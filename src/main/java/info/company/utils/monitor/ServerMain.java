package info.company.utils.monitor;

import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.AbstractHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class ServerMain extends AbstractHandler {


    public void handle(String target,
                       Request baseRequest,
                       HttpServletRequest request,
                       HttpServletResponse response)
        throws IOException, ServletException
    {
        response.setContentType("text/html;charset=utf-8");
        response.setStatus(HttpServletResponse.SC_OK);
        baseRequest.setHandled(true);
        response.getWriter().println(getContent());
    }

    public static void main(String[] args) throws Exception
    {
        Server server = new Server(5000);
        server.setHandler(new ServerMain());


//        ResourceHandler resource_handler = new ResourceHandler();
//        resource_handler.setDirectoriesListed(true);
//        resource_handler.setWelcomeFiles(new String[]{ "index.html" });
//
//        resource_handler.setResourceBase(".");
//
//        HandlerList handlers = new HandlerList();
//        handlers.setHandlers(new Handler[] { resource_handler, new DefaultHandler() });
//        server.setHandler(handlers);

        server.start();
        server.join();
    }


    // While the Jenkins Job succeeds, its promotion Job may have failed. If so, we show the deployment as Green where it should be Red

    private String getContent() {
        String styleGreen= "style=\"color:green\"";
        String styleRed= "style=\"color:red\"";
        String styleBlue= "style=\"color:blue\"";

        StringBuilder sb = new StringBuilder();
        sb.append("<html>\n");
        sb.append("<head>\n");
        sb.append("<meta http-equiv=\"refresh\" content=\"30\"/>\n");
        sb.append("</head>\n");
        sb.append("<body>\n");
        sb.append("ja hoor! het werkt! we zijn erg blij als ie het doet met application.jar");
        sb.append("</body>\n");
        sb.append("</html>\n");
        return sb.toString();
    }
}
