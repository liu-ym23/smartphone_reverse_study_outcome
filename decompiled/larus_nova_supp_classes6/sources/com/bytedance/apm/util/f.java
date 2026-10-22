package com.bytedance.apm.util;

import android.text.TextUtils;
import com.bytedance.news.common.service.manager.ServiceManager;
import com.bytedance.services.apm.api.IHttpService;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class f {
    public static ff7.b a(String r4, List<File> r5, Map<String, String> r6) {
        IHttpService r1 = (IHttpService) ServiceManager.getService(IHttpService.class);     // Catch: Exception -> L30
        if (r1 != null) goto L6;
        r1 = com.bytedance.apm.d.j;     // Catch: Exception -> L30
    L6:
        ff7.g r7 = r1.buildMultipartUpload(r4, "UTF-8", false);     // Catch: Exception -> L30
        if (r5 != null) goto L9;
    L16:
        if (r6 != null) goto L18;
    L23:
        ff7.b r8 = r7.finish();     // Catch: Exception -> L30
        String r9 = new String(r8.c);     // Catch: Exception -> L30
        if (TextUtils.isEmpty(r9) == true) goto L29;
        JSONObject r10 = new JSONObject(r9);     // Catch: JSONException -> L27 Exception -> L30
        return new ff7.b(r8.a, r10.optString("message", "").getBytes());
    L27:
        e = move-exception;
        e.printStackTrace();     // Catch: Exception -> L30
        goto L29
    L18:
        if (r6.isEmpty() == true) goto L23;
        Iterator<Map.Entry<String, String>> r11 = r6.entrySet().iterator();     // Catch: Exception -> L30
    L21:
        if (r11.hasNext() == false) goto L23;
        Map.Entry<String, String> r12 = r11.next();     // Catch: Exception -> L30
        r7.a(r12.getKey(), r12.getValue());     // Catch: Exception -> L30
        goto L21
    L9:
        if (r5.isEmpty() == true) goto L16;
        Iterator<File> r13 = r5.iterator();     // Catch: Exception -> L30
    L12:
        if (r13.hasNext() == false) goto L16;
        File r2 = r13.next();     // Catch: Exception -> L30
        if (r2.exists() == false) goto L12;
        HashMap r3 = new HashMap();     // Catch: Exception -> L30
        r7.b(r2.getName(), r2, null, r3);     // Catch: Exception -> L30
    L29:
        return null;
    }
}
