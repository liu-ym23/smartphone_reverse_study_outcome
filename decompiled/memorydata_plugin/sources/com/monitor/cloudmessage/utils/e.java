package com.monitor.cloudmessage.utils;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class e {
    public static String a(HashMap<String, String> r5) {
        JSONObject r0 = new JSONObject();
        if (r5 == null) goto L12;
        Iterator<String> r1 = r5.keySet().iterator();     // Catch: JSONException -> L9
    L6:
        if (r1.hasNext() == false) goto L12;
        String r2 = (String) ZeusTransformUtils.preCheckCast(r1.next(), String.class, "com.obric.memorydata.plugin");     // Catch: JSONException -> L9
        r0.put(r2, r5.get(r2));     // Catch: JSONException -> L9
    L9:
        e = move-exception;
        e.printStackTrace();
    L12:
        return r0.toString();
    }

    public static JSONObject a(Map<String, List<String>> r4) {
        Map r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
        JSONObject r0 = new JSONObject();
        if (r5 != null) goto L16;
    L15:
        return r0;
    L16:
        Iterator r6 = r5.entrySet().iterator();     // Catch: JSONException -> L13
    L5:
        if (r6.hasNext() == false) goto L15;
        Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r6.next(), Map.Entry.class, "com.obric.memorydata.plugin");     // Catch: JSONException -> L13
        if (r2.getKey() != null) goto L11;
        String r3 = "Response";
        Object r7 = r2.getValue();     // Catch: JSONException -> L13
    L10:
        r0.put(r3, r7);     // Catch: JSONException -> L13
        goto L5
    L11:
        r3 = r2.getKey().toString();     // Catch: JSONException -> L13
        r7 = r2.getValue();     // Catch: JSONException -> L13
    L13:
        e = move-exception;
        e.printStackTrace();
        goto L15
    }
}
