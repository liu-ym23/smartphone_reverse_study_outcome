package com.bytedance.android.ec.core.utils;

import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class z1 {
    public static final JSONObject a(Object r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$AnyToJSONObject");
        int r1 = t0.a;     // Catch: Exception -> L5
        return new JSONObject(t0.a.a.toJson(r10));
    L6:
        return new JSONObject();
    }

    public static final JSONArray e(String r1) {
    L6:
        e = move-exception;
        ECExceptionMonitor.f(e, "jsonArray_format_error");
        return null;
    L3:
        if (cg4.a.a(r1) == false) goto L12;
        return new JSONArray(r1);
    L12:
        return null;
    }

    public static final JSONObject f(String r1) {
    L6:
        e = move-exception;
        ECExceptionMonitor.f(e, "json_format_error");
    L9:
        return new JSONObject();
    L3:
        if (cg4.a.a(r1) == false) goto L9;
        return new JSONObject(r1);
    }

    public static final JSONObject g(String r1) {
    L6:
        e = move-exception;
        ECExceptionMonitor.f(e, "json_format_error");
        return null;
    L3:
        if (cg4.a.a(r1) == false) goto L12;
        return new JSONObject(r1);
    L12:
        return null;
    }

    public static final List<Object> h(JSONArray r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$toList");
        ArrayList r0 = new ArrayList();
        int r1 = r10.length();
        int r11 = 0;
    L3:
        if (r11 >= r1) goto L11;
        Object r12 = r10.get(r11);
        if ((r12 instanceof JSONArray) == false) goto L8;
        r12 = cd.a.d((JSONArray) r12);
    L10:
        r0.add(r12);
        r11 = r11 + 1;
        goto L3
    L8:
        if ((r12 instanceof JSONObject) == false) goto L10;
        r12 = cd.a.e((JSONObject) r12);
        goto L10
    L11:
        return r0;
    }

    public static final List<Object> i(JSONArray r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$toListNullCompat");
        ArrayList r0 = new ArrayList();
        int r1 = r10.length();
        int r11 = 0;
    L3:
        if (r11 >= r1) goto L12;
        Object r12 = r10.get(r11);     // Catch: Exception -> L13
        if ((r12 instanceof JSONArray) == false) goto L8;
        r12 = i((JSONArray) r12);     // Catch: Exception -> L13
    L10:
        r0.add(r12);     // Catch: Exception -> L13
        goto L11
    L8:
        if ((r12 instanceof JSONObject) == false) goto L10;
        r12 = l((JSONObject) r12);     // Catch: Exception -> L13
    L11:
        r11 = r11 + 1;
        goto L3
    L12:
        return r0;
    }

    public static final Map<String, String> j(JSONObject r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$toMap");
        LinkedHashMap r0 = new LinkedHashMap();
        Iterator<String> r1 = r10.keys();     // Catch: Exception -> L8
    L5:
        if (r1.hasNext() == false) goto L10;
        String r11 = r1.next();     // Catch: Exception -> L8
        r0.put(r11, r10.optString(r11));     // Catch: Exception -> L8
    L10:
        return r0;
    L8:
        e = move-exception;
        ECExceptionMonitor.c(e.toString());
        goto L10
    }

    public static final Map<String, Object> k(JSONObject r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$toObjectMap");
        HashMap r0 = new HashMap();
        Iterator<String> r1 = r10.keys();
    L4:
        if (r1.hasNext() == false) goto L15;
        String r11 = r1.next();     // Catch: Exception -> L13
        Object r12 = r10.get(r11);     // Catch: Exception -> L13
        if ((r12 instanceof JSONArray) == false) goto L9;
        r12 = cd.a.d((JSONArray) r12);     // Catch: Exception -> L13
    L11:
        r0.put(r11, r12);     // Catch: Exception -> L13
        goto L4
    L9:
        if ((r12 instanceof JSONObject) == false) goto L11;
        r12 = k((JSONObject) r12);     // Catch: Exception -> L13
    L13:
        e = move-exception;
        ECExceptionMonitor.c(e.toString());
        goto L4
    L15:
        return r0;
    }

    public static final Map<String, Object> l(JSONObject r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$toObjectMapNullCompat");
        HashMap r0 = new HashMap();
        Iterator<String> r1 = r10.keys();
    L4:
        if (r1.hasNext() == false) goto L18;
        String r11 = r1.next();     // Catch: Exception -> L16
        Object r12 = r10.get(r11);     // Catch: Exception -> L16
        if (r10.isNull(r11) == false) goto L9;
        r12 = null;
    L14:
        r0.put(r11, r12);     // Catch: Exception -> L16
        goto L4
    L9:
        if ((r12 instanceof JSONArray) == false) goto L12;
        r12 = i((JSONArray) r12);     // Catch: Exception -> L16
        goto L14
    L12:
        if ((r12 instanceof JSONObject) == false) goto L14;
        r12 = l((JSONObject) r12);     // Catch: Exception -> L16
    L16:
        e = move-exception;
        ECExceptionMonitor.c(e.toString());
        goto L4
    L18:
        return r0;
    }

    public static final void b(JSONObject r10, JSONObject r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$putAll");
        Intrinsics.checkNotNullParameter(r11, "json");
        Iterator<String> r0 = r11.keys();
    L4:
        if (r0.hasNext() == false) goto L6;
        String r1 = r0.next();
        r10.put(r1, r11.opt(r1));
        goto L4
    }

    public static final void c(JSONObject r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$putJSONString");
        if (r11 == null) goto L20;
        boolean r1 = true;
        if ((!StringsKt.isBlank(r11)) == true) goto L7;
    L9:
        r1 = false;
    L10:
        if (r1 == true) goto L13;
        r11 = null;
    L13:
        if (r11 == null) goto L22;
        JSONObject r12 = g(r11);
        if (r12 == null) goto L23;
        Iterator<String> r0 = r12.keys();
    L18:
        if (r0.hasNext() == false) goto L24;
        String r13 = r0.next();
        r10.put(r13, r12.opt(r13));
        goto L18
    L24:
        return;
    L23:
        return;
    L22:
        return;
    L7:
        if (StringsKt.equals(r11, "null", true) == true) goto L9;
    }

    public static final String d(String r10, Map<String, String> r11) {
        Intrinsics.checkNotNullParameter(r11, "map");
        if (r10 == null) goto L6;
        JSONObject r12 = g(r10);
        if (r12 == null) goto L6;
    L7:
        Iterator<T> r13 = r11.entrySet().iterator();
    L9:
        if (r13.hasNext() == false) goto L12;
        Map.Entry r0 = (Map.Entry) r13.next();
        r12.put((String) r0.getKey(), r0.getValue());
        goto L9
    L12:
        return r12.toString();
    L6:
        r12 = new JSONObject();
        goto L7
    }
}
