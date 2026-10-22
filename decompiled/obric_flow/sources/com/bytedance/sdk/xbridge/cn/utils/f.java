package com.bytedance.sdk.xbridge.cn.utils;

import com.ss.android.agilelogger.ALog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static a f7505a;

    static {
        f7505a = new r9.c(7);
    }

    public static ArrayList a(JSONArray r5) {
        Intrinsics.checkNotNullParameter(r5, "json");
        ArrayList r10 = new ArrayList();
        int r11 = r5.length();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L27;
        Object r13 = r5.opt(r12);
        if ((r13 instanceof Long) == false) goto L8;
        r10.add(Long.valueOf(r5.optLong(r12)));
    L26:
        r12 = r12 + 1;
        goto L3
    L8:
        if ((r13 instanceof Double) == false) goto L11;
        r10.add(Double.valueOf(r5.optDouble(r12)));
        goto L26
    L11:
        if ((r13 instanceof Integer) == false) goto L14;
        r10.add(Integer.valueOf(r5.getInt(r12)));
        goto L26
    L14:
        if ((r13 instanceof String) == false) goto L17;
        r10.add(r5.optString(r12));
        goto L26
    L17:
        if ((r13 instanceof JSONObject) == false) goto L20;
        r10.add(c(r5.optJSONObject(r12)));
        goto L26
    L20:
        if ((r13 instanceof JSONArray) == false) goto L23;
        r10.add(a(r5.optJSONArray(r12)));
        goto L26
    L23:
        if ((r13 instanceof Boolean) == false) goto L25;
        r10.add(Boolean.valueOf(r5.optBoolean(r12)));
        goto L26
    L25:
        r10.add(null);
        goto L26
    L27:
        return r10;
    }

    public static final ArrayList b(JSONArray r5, Function1 r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "cb");
        ArrayList r11 = new ArrayList();
        int r12 = r5.length();
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L5;
        r11.add(r10.invoke(r5.opt(r13)));
        r13 = r13 + 1;
        goto L3
    L5:
        return r11;
    }

    public static LinkedHashMap c(JSONObject r5) {
        Intrinsics.checkNotNullParameter(r5, "json");
        LinkedHashMap r10 = new LinkedHashMap();
        Iterator<String> r11 = r5.keys();
    L4:
        if (r11.hasNext() == false) goto L27;
        String r12 = r11.next();
        Object r13 = r5.opt(r12);
        if ((r13 instanceof Long) == true) goto L7;
        if ((r13 instanceof Double) == true) goto L10;
        if ((r13 instanceof Integer) == true) goto L13;
        if ((r13 instanceof String) == true) goto L16;
        if ((r13 instanceof JSONObject) == true) goto L19;
        if ((r13 instanceof JSONArray) == true) goto L22;
        if ((r13 instanceof Boolean) == true) goto L25;
        r10.put(r12, null);
        goto L4
    L25:
        r10.put(r12, Boolean.valueOf(r5.optBoolean(r12)));
        goto L4
    L22:
        r10.put(r12, a(r5.optJSONArray(r12)));
        goto L4
    L19:
        r10.put(r12, c(r5.optJSONObject(r12)));
        goto L4
    L16:
        r10.put(r12, r5.optString(r12));
        goto L4
    L13:
        r10.put(r12, Integer.valueOf(r5.optInt(r12)));
        goto L4
    L10:
        r10.put(r12, Double.valueOf(r5.optDouble(r12)));
        goto L4
    L7:
        r10.put(r12, Long.valueOf(r5.optLong(r12)));
        goto L4
    L27:
        return r10;
    }

    public static JSONArray d(List r5, int r10) {
        Intrinsics.checkNotNullParameter(r5, "list");
        JSONArray r11 = new JSONArray();
        Iterator r12 = r5.iterator();
    L4:
        if (r12.hasNext() == false) goto L42;
        Object r13 = r12.next();
        if ((r13 instanceof Float) == true) goto L7;
        if ((r13 instanceof Long) == true) goto L10;
        if ((r13 instanceof Integer) == true) goto L22;
        if ((r13 instanceof Double) == true) goto L25;
        if ((r13 instanceof String) == true) goto L28;
        if ((r13 instanceof Boolean) == true) goto L31;
        if ((r13 instanceof Map) == false) goto L37;
        Intrinsics.checkNotNull(r13, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.Any>");     // Catch: Exception -> L43
        r11.put(e(r10, (Map) r13));     // Catch: Exception -> L43
        goto L4
    L37:
        if ((r13 instanceof List) == true) goto L38;
        if (r13 != null) goto L4;
        r11.put(JSONObject.NULL);
        goto L4
    L38:
        Intrinsics.checkNotNull(r13, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any>");     // Catch: Exception -> L43
        r11.put(d((List) r13, r10));     // Catch: Exception -> L43
        goto L4
    L31:
        r11.put(((Boolean) r13).booleanValue());
        goto L4
    L28:
        r11.put(r13);
        goto L4
    L25:
        r11.put(((Number) r13).doubleValue());
        goto L4
    L22:
        r11.put(((Number) r13).intValue());
        goto L4
    L10:
        long r14 = ((Number) r13).longValue();
        if (r10 != 0) goto L13;
        r11.put(r14);
        goto L4
    L13:
        if (r10 != 1) goto L15;
        r11.put(String.valueOf(r14));
        goto L4
    L15:
        if (r10 != 2) goto L4;
        r11.put(r14);
        goto L4
    L7:
        r11.put(((Number) r13).floatValue());
        goto L4
    L42:
        return r11;
    }

    public static JSONObject e(int r5, Map r10) {
        Intrinsics.checkNotNullParameter(r10, "map");
        JSONObject r11 = new JSONObject();
        Iterator r12 = r10.entrySet().iterator();
    L4:
        if (r12.hasNext() == false) goto L48;
        Map.Entry r13 = (Map.Entry) r12.next();
        String r14 = (String) r13.getKey();
        Object r15 = r13.getValue();
        if ((r15 instanceof Long) == true) goto L7;
        if ((r15 instanceof Float) == true) goto L19;
        if ((r15 instanceof Integer) == true) goto L22;
        if ((r15 instanceof Double) == true) goto L25;
        if ((r15 instanceof String) == true) goto L28;
        if ((r15 instanceof Boolean) == true) goto L31;
        if ((r15 instanceof JSONObject) == true) goto L34;
        if ((r15 instanceof JSONArray) == true) goto L37;
        if ((r15 instanceof Map) == false) goto L43;
        r11.put(r14, e(r5, (Map) r15));     // Catch: Exception -> L49
        goto L4
    L43:
        if ((r15 instanceof List) == true) goto L44;
        if (r15 != null) goto L4;
        r11.put(r14, JSONObject.NULL);
        goto L4
    L44:
        r11.put(r14, d((List) r15, r5));     // Catch: Exception -> L49
        goto L4
    L37:
        r11.put(r14, r15);
        goto L4
    L34:
        r11.put(r14, r15);
        goto L4
    L31:
        r11.put(r14, ((Boolean) r15).booleanValue());
        goto L4
    L28:
        r11.put(r14, r15);
        goto L4
    L25:
        r11.put(r14, ((Number) r15).doubleValue());
        goto L4
    L22:
        r11.put(r14, ((Number) r15).intValue());
        goto L4
    L19:
        r11.put(r14, ((Number) r15).floatValue());
        goto L4
    L7:
        long r16 = ((Number) r15).longValue();
        if (r5 != 0) goto L10;
        r11.put(r14, r16);
        goto L4
    L10:
        if (r5 != 1) goto L12;
        r11.put(r14, String.valueOf(r16));
        goto L4
    L12:
        if (r5 != 2) goto L4;
        r11.put(r14, r16);
        goto L4
    L48:
        return r11;
    }

    public static final void f(String r5, String r10, String r11) {
        Intrinsics.checkNotNullParameter(r5, "methodName");
        Intrinsics.checkNotNullParameter(r10, "msg");
        Intrinsics.checkNotNullParameter("BridgeProcessing", "bridgeStatus");
        Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L5
        String r13 = h(r5, r10, r11);     // Catch: Throwable -> L5
        f7505a.a(r13);     // Catch: Throwable -> L5
        Result.m124constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        Result.m124constructorimpl(ResultKt.createFailure(th));
    }

    public static void g() {
        ALog.getALogSimpleWriteFuncAddr();
    }

    public static String h(String r5, String r10, String r11) {
        StringBuilder r12 = new StringBuilder();
        if (r11.length() != 0) goto L5;
        r12.append("[bulletSession-unknown]");
    L6:
        r12.append("[bullet-bridge][" + r5 + ']');
        r12.append("[BridgeProcessing]");
        r12.append(r10);
        return r12.toString();
    L5:
        r12.append("[bulletSession-" + r11 + ']');
        goto L6
    }

    public static void i(String r5, String r10) {
        Intrinsics.checkNotNullParameter(r5, "tag");
        Intrinsics.checkNotNullParameter(r10, "msg");
        ALog.i(r5, r10);
    }
}
