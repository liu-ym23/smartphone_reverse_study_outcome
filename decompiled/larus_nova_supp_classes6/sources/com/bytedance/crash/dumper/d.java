package com.bytedance.crash.dumper;

import com.bytedance.crash.monitor.j;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class d {
    public static void a(File r8) {
        com.bytedance.crash.monitor.a r3 = j.a;
        if (r3 != null) goto L5;
        return;
    L5:
        JSONObject r4 = new JSONObject();
        Map r5 = r3.c();
        if (r5 == null) goto L23;
        Iterator r6 = r5.keySet().iterator();     // Catch: Exception -> L27
    L9:
        if (r6.hasNext() == false) goto L14;
        String r7 = (String) r6.next();     // Catch: Exception -> L27
        if (r5.get(r7) == null) goto L9;
        r4.put(r7, r5.get(r7));     // Catch: Exception -> L27
        goto L9
    L14:
        if (r5.containsKey("version_name") == false) goto L17;
        r4.put("crash_version_name", r5.get("version_name"));     // Catch: Exception -> L27
    L17:
        if (r5.containsKey("update_version_code") == false) goto L20;
        r4.put("crash_update_version_code", r5.get("update_version_code"));     // Catch: Exception -> L27
    L20:
        if (r5.containsKey("version_code") == false) goto L23;
        r4.put("crash_version_code", r5.get("version_code"));     // Catch: Exception -> L27
    L23:
        if (r4.length() > 0) goto L29;
        return;
    L29:
        com.bytedance.crash.util.h.h(new PolarisFileWrapper(r8, "common_params.json"), r4.toString(), false);     // Catch: Exception -> L28
        return;
    }
}
