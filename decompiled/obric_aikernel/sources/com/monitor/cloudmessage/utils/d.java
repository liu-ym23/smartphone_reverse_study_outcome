package com.monitor.cloudmessage.utils;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class d {
    public static JSONObject a(Map<String, List<String>> r10) {
        JSONObject r11 = new JSONObject();
        if (r10 != null) goto L16;
    L15:
        return r11;
    L16:
        Iterator<Map.Entry<String, List<String>>> r12 = r10.entrySet().iterator();     // Catch: JSONException -> L13
    L5:
        if (r12.hasNext() == false) goto L15;
        Map.Entry<String, List<String>> r13 = r12.next();     // Catch: JSONException -> L13
        if (r13.getKey() != null) goto L11;
        String r14 = "Response";
        List<String> r15 = r13.getValue();     // Catch: JSONException -> L13
    L10:
        r11.put(r14, r15);     // Catch: JSONException -> L13
        goto L5
    L11:
        r14 = r13.getKey().toString();     // Catch: JSONException -> L13
        r15 = r13.getValue();     // Catch: JSONException -> L13
    L13:
        e = move-exception;
        e.printStackTrace();
        goto L15
    }

    public static String b(HashMap<String, String> r10) {
        JSONObject r11 = new JSONObject();
        if (r10 == null) goto L12;
        Iterator<String> r12 = r10.keySet().iterator();     // Catch: JSONException -> L9
    L6:
        if (r12.hasNext() == false) goto L12;
        String r13 = r12.next();     // Catch: JSONException -> L9
        r11.put(r13, r10.get(r13));     // Catch: JSONException -> L9
    L9:
        e = move-exception;
        e.printStackTrace();
    L12:
        return r11.toString();
    }
}
