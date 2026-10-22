package com.bytedance.applog.util;

import com.bytedance.applog.log.q;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class i {
    public static JSONObject a(JSONObject r4, JSONObject r5) {
        if (r4 != null) goto L4;
        return r5;
    L4:
        Iterator<String> r0 = r4.keys();
    L12:
    L9:
        e = move-exception;
        q.a().a(Collections.singletonList("JsonUtils"), "Merge json interrupted.", e, new Object[0]);
    L11:
        return r5;
    L6:
        if (r0.hasNext() == false) goto L11;
        String r1 = (String) ZeusTransformUtils.preCheckCast(r0.next(), String.class, "com.obric.memorydata.plugin");     // Catch: JSONException -> L9
        r5.put(r1, r4.opt(r1));     // Catch: JSONException -> L9
        goto L12
    }

    public static boolean a(String r2) {
        if (o.b(r2) == false) goto L6;
        return false;
    L6:
        if (r2.startsWith("{") == false) goto L10;
        if (r2.startsWith("}") == false) goto L10;
    L13:
        return true;
    L10:
        if (r2.startsWith("[") == true) goto L12;
        return false;
    L12:
        if (r2.endsWith("]") == true) goto L13;
        return false;
    }

    public static boolean a(JSONArray r0) {
        if (r0 != null) goto L4;
    L7:
        return true;
    L4:
        if (r0.length() == 0) goto L7;
        return false;
    }

    public static boolean a(JSONObject r3, Set<String> r4) {
        Iterator r5 = ((Set) ZeusTransformUtils.wrapperContextForParams(r4, Set.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r5.hasNext() == false) goto L9;
        if (r3.has((String) ZeusTransformUtils.preCheckCast(r5.next(), String.class, "com.obric.memorydata.plugin")) == true) goto L4;
        return false;
    L9:
        return true;
    }
}
