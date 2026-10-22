package com.bytedance.apm.util;

import android.text.TextUtils;
import com.bytedance.rpc.internal.RpcUtils;
import com.bytedance.services.apm.api.IHttpService;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class e {
    public static com.bytedance.services.apm.api.c a(String r6, List<File> r7, Map<String, String> r8) {
        List r9 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin");
        Map r10 = (Map) ZeusTransformUtils.wrapperContextForParams(r8, Map.class, "com.obric.memorydata.plugin");
        IHttpService r2 = (IHttpService) ZeusTransformUtils.preCheckCast(com.bytedance.news.common.service.manager.d.a(IHttpService.class), IHttpService.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L30
        if (r2 != null) goto L6;
        r2 = com.bytedance.apm.b.u();     // Catch: Exception -> L30
    L6:
        com.bytedance.services.apm.api.g r11 = r2.buildMultipartUpload(r6, RpcUtils.CHARSET_UTF8, false);     // Catch: Exception -> L30
        if (r9 != null) goto L9;
    L16:
        if (r10 != null) goto L18;
    L23:
        String r12 = new String(r11.a().b());     // Catch: Exception -> L30
        if (TextUtils.isEmpty(r12) == true) goto L29;
        JSONObject r13 = new JSONObject(r12);     // Catch: JSONException -> L27 Exception -> L30
        return new com.bytedance.services.apm.api.c(r13.optInt("error_code", 0), r13.optString("message", "").getBytes());
    L27:
        e = move-exception;
        e.printStackTrace();     // Catch: Exception -> L30
        goto L29
    L18:
        if (r10.isEmpty() == true) goto L23;
        Iterator r14 = r10.entrySet().iterator();     // Catch: Exception -> L30
    L21:
        if (r14.hasNext() == false) goto L23;
        Map.Entry r15 = (Map.Entry) ZeusTransformUtils.preCheckCast(r14.next(), Map.Entry.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L30
        r11.a((String) ZeusTransformUtils.preCheckCast(r15.getKey(), String.class, "com.obric.memorydata.plugin"), (String) ZeusTransformUtils.preCheckCast(r15.getValue(), String.class, "com.obric.memorydata.plugin"));     // Catch: Exception -> L30
        goto L21
    L9:
        if (r9.isEmpty() == true) goto L16;
        Iterator r16 = r9.iterator();     // Catch: Exception -> L30
    L12:
        if (r16.hasNext() == false) goto L16;
        File r3 = (File) ZeusTransformUtils.preCheckCast(r16.next(), File.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L30
        if (r3.exists() == false) goto L12;
        HashMap r4 = new HashMap();     // Catch: Exception -> L30
        r11.a(r3.getName(), r3, null, r4);     // Catch: Exception -> L30
    L29:
        return null;
    }
}
