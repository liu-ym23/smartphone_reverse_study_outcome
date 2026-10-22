package isb;

import android.os.SystemClock;
import com.bytedance.apm.ApmAgent;
import com.bytedance.common.utility.NetworkUtils;
import com.ss.android.lark.appcontext.applifecycle.a0;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.LarkContext;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a {
    public static boolean b() {
        NetworkUtils.NetworkType r0 = NetworkUtils.getNetworkType(LarkContext.getApplication());
        if (r0 != NetworkUtils.NetworkType.MOBILE) goto L5;
    L13:
        return false;
    L5:
        if (r0 == NetworkUtils.NetworkType.MOBILE_2G) goto L13;
        if (r0 == NetworkUtils.NetworkType.MOBILE_3G) goto L13;
        if (r0 == NetworkUtils.NetworkType.MOBILE_4G) goto L13;
        if (r0 == NetworkUtils.NetworkType.MOBILE_5G) goto L13;
        return true;
    }

    public static void a(JSONObject r5, JSONObject r6) {
        if (r6 == null) goto L21;
        Iterator<String> r0 = r6.keys();     // Catch: Exception -> L11
    L6:
        if (r0.hasNext() == false) goto L22;
        String r1 = r0.next();     // Catch: Exception -> L11
        Object r2 = r6.opt(r1);     // Catch: Exception -> L11
        if (r2 == null) goto L6;
        r5.put("extra_" + r1, r2);     // Catch: Exception -> L11
        goto L6
    L22:
        return;
    L11:
        e = move-exception;
        Log.d("MonitorUtils", e);
        return;
    }

    public static void c(String r6, JSONObject r7) {
        JSONObject r0 = new JSONObject();     // Catch: JSONException -> L4
        int r2 = a0.b;     // Catch: JSONException -> L4
        r0.put("since_latest_enter_foreground", SystemClock.elapsedRealtime() - a0.a);     // Catch: JSONException -> L4
        r0.put("since_startup", SystemClock.elapsedRealtime() - 0);     // Catch: JSONException -> L4
        ApmAgent.monitorEvent(r6, null, r7, r0);     // Catch: JSONException -> L4
        return;
    }
}
