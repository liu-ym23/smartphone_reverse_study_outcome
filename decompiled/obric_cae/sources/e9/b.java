package e9;

import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.ttnet.TTNetInit;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static a f7206a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile boolean f7207b = true;

    public interface a {
    }

    public static void a(String r8, int r10, JSONObject r11) {
        a r12 = f7206a;
        if (r12 == null) goto L12;
        TTNetInit.c r13 = (TTNetInit.c) r12;
        JSONObject r14 = new JSONObject();     // Catch: Throwable -> L7
        r14.put(WsConstants.KEY_CONNECTION_URL, r8);     // Catch: Throwable -> L7
        r14.put("value", r10);     // Catch: Throwable -> L7
        r14.put("ext_value", 0);     // Catch: Throwable -> L7
        r14.put("extraObject", r11);     // Catch: Throwable -> L7
        TTNetInit.getTTNetDepend().mobOnEvent(r13.f4070a, "set_cookie", "set_cookie", r14);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        th.printStackTrace();
        return;
    }
}
