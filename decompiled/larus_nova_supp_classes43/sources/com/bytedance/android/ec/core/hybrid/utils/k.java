package com.bytedance.android.ec.core.hybrid.utils;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class k {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static JSONArray a(List r10) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_LIST);
        JSONArray r0 = new JSONArray();
        Iterator r11 = r10.iterator();
    L4:
        if (r11.hasNext() == false) goto L43;
        Object r1 = r11.next();
        if ((r1 instanceof Float) == true) goto L7;
        if ((r1 instanceof Long) == true) goto L10;
        if ((r1 instanceof Integer) == true) goto L13;
        if ((r1 instanceof Double) == true) goto L16;
        if ((r1 instanceof String) == true) goto L19;
        if ((r1 instanceof Boolean) == true) goto L22;
        if ((r1 instanceof Map) == true) goto L25;
        if ((r1 instanceof List) == false) goto L4;
        if (r1 == null) goto L38;
        r0.put(a((List) r1));     // Catch: ClassCastException -> L39 JSONException -> L41
    L39:
        e = move-exception;
        e.getMessage();
    L41:
        e = move-exception;
        e.getMessage();
        goto L4
    L38:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");     // Catch: ClassCastException -> L39 JSONException -> L41
    L25:
        if (r1 == null) goto L28;
        r0.put(b((Map) r1));     // Catch: ClassCastException -> L29 JSONException -> L31
    L29:
        e = move-exception;
        e.getMessage();
    L31:
        e = move-exception;
        e.getMessage();
        goto L4
    L28:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.Any?>");     // Catch: ClassCastException -> L29 JSONException -> L31
    L22:
        r0.put(((Boolean) r1).booleanValue());
        goto L4
    L19:
        r0.put(r1);
        goto L4
    L16:
        r0.put(((Number) r1).doubleValue());
        goto L4
    L13:
        r0.put(((Number) r1).intValue());
        goto L4
    L10:
        r0.put(((Number) r1).longValue());
        goto L4
    L7:
        r0.put(((Number) r1).floatValue());
        goto L4
    L43:
        return r0;
    }

    public static JSONObject b(Map r10) {
        JSONObject r0 = new JSONObject();
        if (r10 != null) goto L5;
        return r0;
    L5:
        Iterator r11 = r10.entrySet().iterator();
    L7:
        if (r11.hasNext() == false) goto L42;
        Map.Entry r1 = (Map.Entry) r11.next();
        String r12 = (String) r1.getKey();
        Object r13 = r1.getValue();
        if ((r13 instanceof Long) == true) goto L10;
        if ((r13 instanceof Float) == true) goto L13;
        if ((r13 instanceof Integer) == true) goto L16;
        if ((r13 instanceof Double) == true) goto L19;
        if ((r13 instanceof String) == true) goto L22;
        if ((r13 instanceof Boolean) == true) goto L25;
        if ((r13 instanceof Map) == false) goto L35;
        r0.put(r12, b((Map) r13));     // Catch: ClassCastException -> L30 JSONException -> L32
    L30:
        e = move-exception;
        e.getMessage();
    L32:
        e = move-exception;
        e.getMessage();
        goto L7
    L35:
        if ((r13 instanceof List) == false) goto L7;
        r0.put(r12, a((List) r13));     // Catch: ClassCastException -> L38 JSONException -> L40
    L38:
        e = move-exception;
        e.getMessage();
    L40:
        e = move-exception;
        e.getMessage();
        goto L7
    L25:
        r0.put(r12, ((Boolean) r13).booleanValue());
        goto L7
    L22:
        r0.put(r12, r13);
        goto L7
    L19:
        r0.put(r12, ((Number) r13).doubleValue());
        goto L7
    L16:
        r0.put(r12, ((Number) r13).intValue());
        goto L7
    L13:
        r0.put(r12, ((Number) r13).floatValue());
        goto L7
    L10:
        r0.put(r12, ((Number) r13).longValue());
        goto L7
    L42:
        return r0;
    }
}
