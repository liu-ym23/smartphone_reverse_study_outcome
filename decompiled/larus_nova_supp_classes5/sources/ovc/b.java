package ovc;

import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.frameworks.baselib.network.http.NetworkParams;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class b {
    public static long d = 100;
    public static volatile boolean e;
    public final long a;
    public final long b;
    public volatile boolean c;

    public b(Map<String, Object> r12, boolean r13) {
        this.c = true;
        if (NetworkParams.getDestroyDeltaMillis() <= 0) goto L5;
        d = NetworkParams.getDestroyDeltaMillis();
        long r5 = a(r12, "destroy_timeout_millis", 0);
        if (r5 < 1000) goto L11;
        e = true;
        if (r13 == false) goto L20;
        long r6 = r5 - d;
        this.a = r6;
        if (Logger.debug() == false) goto L39;
        Logger.d("CronetFrontierConnection", "Destroy ws timeout: " + r6);
        return;
    L39:
        return;
    L20:
        long r14 = a(r12, "fallback_timeout_mills", 10000);
        if (Logger.debug() == false) goto L24;
        Logger.d("CronetFrontierConnection", "fallback timeout:" + r14 + " destroy timeout:" + r5);
    L24:
        if (r14 < r5) goto L30;
        this.c = false;
        if (Logger.debug() == false) goto L28;
        Logger.d("CronetFrontierConnection", "Disable fallback to websocket, fallback >= destroy timeout");
    L28:
        this.b = r5 - d;
        return;
    L30:
        long r7 = d;
        this.b = r14 - r7;
        long r8 = (r5 - r14) - r7;
        this.a = r8;
        if (r8 < 0) goto L33;
        return;
    L33:
        if (Logger.debug() == false) goto L35;
        Logger.d("CronetFrontierConnection", "Disable fallback to websocket, timeout <= 0:" + r8);
    L35:
        this.c = false;
        return;
    L11:
        if (Logger.debug() == false) goto L38;
        Logger.d("CronetFrontierConnection", "Destroy timeout disable: " + r5);
        return;
    L38:
        return;
    L5:
        if (Logger.debug() == false) goto L37;
        Logger.d("CronetFrontierConnection", "Destroy delta disable: " + NetworkParams.getDestroyDeltaMillis());
        return;
    }

    public static boolean b(String r2, boolean r3) {
        if (e == true) goto L5;
        return false;
    L5:
        if (TextUtils.isEmpty(r2) == false) goto L8;
        return false;
    L8:
        if (r3 == false) goto L16;
        if (r2.contains("\\\"net_error\\\":-7") == true) goto L12;
        return false;
    L12:
        if (r2.contains("WebSocket opening handshake timed out") == false) goto L24;
        return true;
    L24:
        return false;
    L16:
        if (r2.contains("\"error_code\":-193") == false) goto L18;
    L21:
        return true;
    L18:
        if (r2.contains("\"error_code\":-356") == true) goto L20;
        return false;
    L20:
        if (r2.contains("\\\"internal_error\\\":67") == true) goto L21;
        return false;
    }

    public static long a(Map<String, Object> r1, String r2, long r3) {
        Map r4 = (Map) r1.get("custom_headers");
        if (r4 != null) goto L5;
        return r3;
    L5:
        if (r4.isEmpty() == false) goto L8;
        return r3;
    L8:
        if (r4.containsKey(r2) == true) goto L10;
        return r3;
    L10:
        String r5 = (String) r4.get(r2);
        if (TextUtils.isEmpty(r5) == false) goto L18;
        return r3;
    L18:
        int r6 = CastIntegerProtector.valueOf(r5).intValue();     // Catch: Exception -> L17
        if (r6 > 0) goto L16;
        return r3;
    L16:
        return r6;
    L23:
        return r3;
    }
}
