package com.bytedance.apm.util;

import android.text.TextUtils;
import com.bytedance.services.apm.api.IHttpService;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class e {
    public static t4.c a(String r10, List<File> r11, Map<String, String> r12) {
        IHttpService r13 = (IHttpService) c4.d.a(IHttpService.class);     // Catch: Exception -> L30
        if (r13 != null) goto L6;
        r13 = com.bytedance.apm.d.l();     // Catch: Exception -> L30
    L6:
        t4.g r14 = r13.buildMultipartUpload(r10, "UTF-8", false);     // Catch: Exception -> L30
        if (r11 != null) goto L9;
    L16:
        if (r12 != null) goto L18;
    L23:
        t4.c r15 = r14.finish();     // Catch: Exception -> L30
        String r16 = new String(r15.b());     // Catch: Exception -> L30
        if (TextUtils.isEmpty(r16) == true) goto L29;
        JSONObject r17 = new JSONObject(r16);     // Catch: JSONException -> L27 Exception -> L30
        return new t4.c(r15.c(), r17.optString("message", "").getBytes());
    L27:
        e = move-exception;
        e.printStackTrace();     // Catch: Exception -> L30
        goto L29
    L18:
        if (r12.isEmpty() == true) goto L23;
        Iterator<Map.Entry<String, String>> r18 = r12.entrySet().iterator();     // Catch: Exception -> L30
    L21:
        if (r18.hasNext() == false) goto L23;
        Map.Entry<String, String> r19 = r18.next();     // Catch: Exception -> L30
        r14.addFormField(r19.getKey(), r19.getValue());     // Catch: Exception -> L30
        goto L21
    L9:
        if (r11.isEmpty() == true) goto L16;
        Iterator<File> r20 = r11.iterator();     // Catch: Exception -> L30
    L12:
        if (r20.hasNext() == false) goto L16;
        File r21 = r20.next();     // Catch: Exception -> L30
        if (r21.exists() == false) goto L12;
        HashMap r22 = new HashMap();     // Catch: Exception -> L30
        r14.a(r21.getName(), r21, null, r22);     // Catch: Exception -> L30
    L29:
        return null;
    }
}
