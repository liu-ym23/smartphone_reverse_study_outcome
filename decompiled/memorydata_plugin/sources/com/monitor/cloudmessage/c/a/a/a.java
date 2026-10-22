package com.monitor.cloudmessage.c.a.a;

import com.monitor.cloudmessage.utils.f;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class a {
    public a() {
    }

    public JSONObject a() {
        JSONObject r0 = new JSONObject();
        r0.put("used_memory", f.a() + "MB");     // Catch: JSONException -> L8
        r0.put("total_memory", f.b() + "MB");     // Catch: JSONException -> L8
        r0.put("sd_all_size", f.c()[0] + "MB");     // Catch: JSONException -> L8
        r0.put("sd_avail_size", f.c()[1] + "MB");     // Catch: JSONException -> L8
        String r8 = "";
        String[] r1 = f.e();     // Catch: JSONException -> L8
        int r2 = r1.length;     // Catch: JSONException -> L8
        int r3 = 0;
    L4:
        if (r3 >= r2) goto L6;
        r8 = r8 + r1[r3] + "  ";     // Catch: JSONException -> L8
        r3 = r3 + 1;     // Catch: JSONException -> L8
        goto L4
    L6:
        r0.put("cpu_info", r8);     // Catch: JSONException -> L8
        r0.put("kernel_version", f.d()[0]);     // Catch: JSONException -> L8
        r0.put("firmware_version", f.d()[1]);     // Catch: JSONException -> L8
        r0.put("model", f.d()[2]);     // Catch: JSONException -> L8
        r0.put("system_version", f.d()[3]);     // Catch: JSONException -> L8
    L7:
        return r0;
    }
}
