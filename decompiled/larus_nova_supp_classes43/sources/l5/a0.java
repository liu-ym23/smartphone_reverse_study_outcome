package l5;

import com.bytedance.ai.applet.render.core.lynx.LynxAIBridgePort;
import com.bytedance.ai.applet.render.core.web.WebViewAIBridgePort;
import com.bytedance.ai.bridge.protocol.WorkerAIBridgePort;
import com.bytedance.ai.monitor.bridge.TraceType;
import java.util.LinkedHashMap;
import java.util.Map;
import m5.b1;
import m5.h1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a0 {
    public static final /* synthetic */ int h = 0;
    public final h1 a;
    public final b1 b;
    public int c;
    public boolean d;
    public final Map<String, Object> e;
    public TraceType f;
    public boolean g;

    public static final class a {
        public static String a(m4.c r1) {
            if ((r1 instanceof WebViewAIBridgePort) == false) goto L5;
        L11:
            return "js";
        L5:
            if ((r1 instanceof WorkerAIBridgePort) == true) goto L11;
            if ((r1 instanceof LynxAIBridgePort) == false) goto L10;
            return "lynx";
        L10:
            return "null";
        }
    }

    static {
    }

    public a0() {
        this.a = new h1();
        this.b = new b1();
        this.e = new LinkedHashMap();
        this.f = TraceType.NONE;
    }
}
