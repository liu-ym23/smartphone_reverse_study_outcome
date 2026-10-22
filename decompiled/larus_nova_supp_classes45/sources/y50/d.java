package y50;

import com.bytedance.android.live.core.monitor.LiveTracingMonitor;
import com.bytedance.android.live.core.utils.NetworkUtils;
import com.bytedance.android.livehostapi.TTMiddlewareLiveSDK;
import com.bytedance.bpea.cert.token.TokenCert;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class d {
    public static final TokenCert a = null;
    public static final Map<String, Object> b = null;

    static {
        a = TokenCert.Companion.with("bpea-broadcastfulllink_get_network_type");
        b = new LinkedHashMap();
    }

    public static JSONObject a(Map r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "$this$asArgs");
        JSONObject r0 = new JSONObject();
        Iterator r5 = r3.entrySet().iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        Map.Entry r1 = (Map.Entry) r5.next();
        r0.putOpt((String) r1.getKey(), String.valueOf(r1.getValue()));
        goto L4
    L6:
        Iterator r6 = ((LinkedHashMap) b).entrySet().iterator();
    L8:
        if (r6.hasNext() == false) goto L11;
        Map.Entry r2 = (Map.Entry) r6.next();
        r0.putOpt((String) r2.getKey(), String.valueOf(r2.getValue()));
        goto L8
    L11:
        if (r4 == Integer.MIN_VALUE) goto L13;
        r0.put("status_code", String.valueOf(r4));
    L13:
        r0.put("network_status", NetworkUtils.a(TTMiddlewareLiveSDK.hostMiddlewareService().appContext().context(), a));
        r0.put("role_type", 2);
        return r0;
    }

    public static void b(LiveTracingMonitor.EventModule r2, JSONObject r3) {
        Intrinsics.checkNotNullParameter(r2, "scene");
        Intrinsics.checkNotNullParameter(r3, "args");
        LiveTracingMonitor.d("ttlive_anchor_server_api_call", r2, LiveTracingMonitor.EventType.SERVER_API_CALL, r3);
    }
}
