package q6;

import com.monitor.cloudmessage.utils.e;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class a {
    public a() {
    }

    public JSONObject a() {
        JSONObject r10 = new JSONObject();
        r10.put("used_memory", e.d() + "MB");     // Catch: JSONException -> L8
        r10.put("total_memory", e.c() + "MB");     // Catch: JSONException -> L8
        r10.put("sd_all_size", e.b()[0] + "MB");     // Catch: JSONException -> L8
        r10.put("sd_avail_size", e.b()[1] + "MB");     // Catch: JSONException -> L8
        String r11 = "";
        String[] r12 = e.a();     // Catch: JSONException -> L8
        int r13 = r12.length;     // Catch: JSONException -> L8
        int r14 = 0;
    L4:
        if (r14 >= r13) goto L6;
        r11 = r11 + r12[r14] + "  ";     // Catch: JSONException -> L8
        r14 = r14 + 1;     // Catch: JSONException -> L8
        goto L4
    L6:
        r10.put("cpu_info", r11);     // Catch: JSONException -> L8
        r10.put("kernel_version", e.e()[0]);     // Catch: JSONException -> L8
        r10.put("firmware_version", e.e()[1]);     // Catch: JSONException -> L8
        r10.put("model", e.e()[2]);     // Catch: JSONException -> L8
        r10.put("system_version", e.e()[3]);     // Catch: JSONException -> L8
    L7:
        return r10;
    }
}
