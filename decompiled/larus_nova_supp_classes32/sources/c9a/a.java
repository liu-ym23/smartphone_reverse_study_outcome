package c9a;

import com.monitor.cloudmessage.utils.c;
import com.obric.aivoice.core.data.NameKeys;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class a {
    public static JSONObject a() {
        JSONObject r1 = new JSONObject();
        r1.put("used_memory", ((Runtime.getRuntime().totalMemory() / 1024) / 1024) + "MB");     // Catch: JSONException -> L8
        r1.put("total_memory", ((Runtime.getRuntime().maxMemory() / 1024) / 1024) + "MB");     // Catch: JSONException -> L8
        r1.put("sd_all_size", c.b()[0] + "MB");     // Catch: JSONException -> L8
        r1.put("sd_avail_size", c.b()[1] + "MB");     // Catch: JSONException -> L8
        String r0 = NameKeys.UnloadStrategy_No_Strategy;
        String[] r2 = c.a();     // Catch: JSONException -> L8
        int r3 = r2.length;     // Catch: JSONException -> L8
        int r4 = 0;
    L4:
        if (r4 >= r3) goto L6;
        r0 = r0 + r2[r4] + "  ";     // Catch: JSONException -> L8
        r4 = r4 + 1;     // Catch: JSONException -> L8
        goto L4
    L6:
        r1.put("cpu_info", r0);     // Catch: JSONException -> L8
        r1.put("kernel_version", c.c()[0]);     // Catch: JSONException -> L8
        r1.put("firmware_version", c.c()[1]);     // Catch: JSONException -> L8
        r1.put("model", c.c()[2]);     // Catch: JSONException -> L8
        r1.put("system_version", c.c()[3]);     // Catch: JSONException -> L8
    L7:
        return r1;
    }
}
