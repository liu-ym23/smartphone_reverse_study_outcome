package com.bytedance.android.anniex.worker;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.vmsdk.jsbridge.utils.JavaOnlyArray;
import com.bytedance.vmsdk.jsbridge.utils.JavaOnlyMap;
import com.bytedance.vmsdk.jsbridge.utils.ReadableArray;
import com.bytedance.vmsdk.jsbridge.utils.ReadableMap;
import com.bytedance.vmsdk.jsbridge.utils.ReadableMapKeySetIterator;
import com.bytedance.vmsdk.jsbridge.utils.ReadableType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class h {
    public static final h a = null;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ReadableType.values().length];
            r0[ReadableType.String.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L19:
            r0[ReadableType.Number.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L27:
            r0[ReadableType.Boolean.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
        L21:
            r0[ReadableType.Map.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
        L23:
            r0[ReadableType.Array.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
        L17:
            r0[ReadableType.Null.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
        L9:
            a = r0;
        }
    }

    static {
        a = new h();
    }

    public h() {
    }

    @JvmStatic
    public static final JavaOnlyArray a(List<? extends Object> r10) {
        Intrinsics.checkNotNullParameter(r10, "sourceArray");
        JavaOnlyArray r0 = new JavaOnlyArray();
        int r1 = r10.size();
        int r11 = 0;
    L3:
        if (r11 >= r1) goto L32;
        Object r12 = ListProtector.get(r10, r11);
        if ((r12 instanceof Map) == false) goto L9;
        r0.pushMap(f((Map) r12));     // Catch: Exception -> L33
    L31:
        r11 = r11 + 1;
        goto L3
    L9:
        if ((r12 instanceof List) == false) goto L13;
        r0.pushArray(a((List) r12));     // Catch: Exception -> L33
        goto L31
    L13:
        if ((r12 instanceof Boolean) == false) goto L16;
        r0.pushBoolean(((Boolean) r12).booleanValue());
        goto L31
    L16:
        if ((r12 instanceof Integer) == false) goto L19;
        r0.pushInt(((Number) r12).intValue());
        goto L31
    L19:
        if ((r12 instanceof Long) == false) goto L22;
        r0.pushDouble(((Number) r12).longValue());
        goto L31
    L22:
        if ((r12 instanceof Float) == false) goto L25;
        r0.pushDouble(((Number) r12).floatValue());
        goto L31
    L25:
        if ((r12 instanceof Double) == false) goto L28;
        r0.pushDouble(((Number) r12).doubleValue());
        goto L31
    L28:
        if ((r12 instanceof String) == false) goto L30;
        r0.pushString((String) r12);
        goto L31
    L30:
        r0.pushString(r12.toString());
        goto L31
    L32:
        return r0;
    }

    @JvmStatic
    public static final List<Object> b(JavaOnlyArray r10) {
        ArrayList r0 = new ArrayList();
        int r1 = r10.size();
        int r11 = 0;
    L3:
        if (r11 >= r1) goto L23;
        Object r12 = r10.get(r11);
        ReadableType r13 = r10.getType(r11);     // Catch: Throwable -> L20
        if (r13 != null) goto L8;
        int r14 = -1;
    L10:
        if (r14 != 2) goto L12;
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type kotlin.Number");     // Catch: Throwable -> L20
        a.getClass();     // Catch: Throwable -> L20
        r0.add(g((Number) r12));     // Catch: Throwable -> L20
    L22:
        r11 = r11 + 1;
        goto L3
    L12:
        if (r14 != 4) goto L14;
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type com.bytedance.vmsdk.jsbridge.utils.JavaOnlyMap");     // Catch: Throwable -> L20
        r0.add(c((JavaOnlyMap) r12));     // Catch: Throwable -> L20
        goto L22
    L14:
        if (r14 == 5) goto L16;
        r0.add(r12);     // Catch: Throwable -> L20
        goto L22
    L16:
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type com.bytedance.vmsdk.jsbridge.utils.JavaOnlyArray");     // Catch: Throwable -> L20
        r0.add(b((JavaOnlyArray) r12));     // Catch: Throwable -> L20
        goto L22
    L8:
        r14 = a.a[r13.ordinal()];     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        id7.c.a("convertJavaOnlyArrayToList " + th);
        goto L22
    L23:
        return r0;
    }

    @JvmStatic
    public static final Map<String, Object> c(JavaOnlyMap r10) {
        Intrinsics.checkNotNullParameter(r10, "map");
        LinkedHashMap r0 = new LinkedHashMap();
        if (r10.isEmpty() == false) goto L5;
        return r0;
    L5:
        ReadableMapKeySetIterator r1 = r10.keySetIterator();
    L7:
        if (r1.hasNextKey() == false) goto L26;
        String r11 = r1.nextKey();
        Object r12 = r10.get(r11);
        ReadableType r13 = r10.getType(r11);     // Catch: Throwable -> L24
        if (r13 != null) goto L12;
        int r14 = -1;
    L14:
        if (r14 != 2) goto L16;
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type kotlin.Number");     // Catch: Throwable -> L24
        a.getClass();     // Catch: Throwable -> L24
        r0.put(r11, g((Number) r12));     // Catch: Throwable -> L24
        goto L7
    L16:
        if (r14 != 4) goto L18;
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type com.bytedance.vmsdk.jsbridge.utils.JavaOnlyMap");     // Catch: Throwable -> L24
        r0.put(r11, c((JavaOnlyMap) r12));     // Catch: Throwable -> L24
        goto L7
    L18:
        if (r14 != 5) goto L19;
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type com.bytedance.vmsdk.jsbridge.utils.JavaOnlyArray");     // Catch: Throwable -> L24
        r0.put(r11, b((JavaOnlyArray) r12));     // Catch: Throwable -> L24
        goto L7
    L19:
        r0.put(r11, r12);     // Catch: Throwable -> L24
        goto L7
    L12:
        r14 = a.a[r13.ordinal()];     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        id7.c.a("convertJavaOnlyMapToMap " + th);
        goto L7
    L26:
        return r0;
    }

    @JvmStatic
    public static final JavaOnlyArray d(JSONArray r10) {
        Intrinsics.checkNotNullParameter(r10, "jsonArray");
        JavaOnlyArray r0 = new JavaOnlyArray();
        int r1 = r10.length();
        int r11 = 0;
    L3:
        if (r11 >= r1) goto L30;
        Object r12 = r10.get(r11);
        if ((r12 instanceof JSONObject) == false) goto L8;
        r0.pushMap(e((JSONObject) r12));
    L29:
        r11 = r11 + 1;
        goto L3
    L8:
        if ((r12 instanceof JSONArray) == false) goto L11;
        r0.pushArray(d((JSONArray) r12));
        goto L29
    L11:
        if ((r12 instanceof Boolean) == false) goto L14;
        r0.pushBoolean(((Boolean) r12).booleanValue());
        goto L29
    L14:
        if ((r12 instanceof Integer) == false) goto L17;
        r0.pushInt(((Number) r12).intValue());
        goto L29
    L17:
        if ((r12 instanceof Long) == false) goto L20;
        r0.pushDouble(((Number) r12).longValue());
        goto L29
    L20:
        if ((r12 instanceof Float) == false) goto L23;
        r0.pushDouble(((Number) r12).floatValue());
        goto L29
    L23:
        if ((r12 instanceof Double) == false) goto L26;
        r0.pushDouble(((Number) r12).doubleValue());
        goto L29
    L26:
        if ((r12 instanceof String) == false) goto L28;
        r0.pushString((String) r12);
        goto L29
    L28:
        r0.pushString(r12.toString());
        goto L29
    L30:
        return r0;
    }

    @JvmStatic
    public static final JavaOnlyMap e(JSONObject r10) {
        Intrinsics.checkNotNullParameter(r10, "jsonObject");
        JavaOnlyMap r0 = new JavaOnlyMap();
        Iterator<String> r1 = r10.keys();
    L4:
        if (r1.hasNext() == false) goto L33;
        String r11 = r1.next();
        Object r12 = r10.get(r11);
        if ((r12 instanceof JSONObject) == true) goto L7;
        if (Intrinsics.areEqual(r12, JSONObject.NULL) == true) goto L10;
        if ((r12 instanceof JSONArray) == true) goto L13;
        if ((r12 instanceof Boolean) == true) goto L16;
        if ((r12 instanceof Integer) == true) goto L19;
        if ((r12 instanceof Long) == true) goto L22;
        if ((r12 instanceof Float) == true) goto L25;
        if ((r12 instanceof Double) == true) goto L28;
        if ((r12 instanceof String) == true) goto L31;
        r0.putString(r11, r12.toString());
        goto L4
    L31:
        r0.putString(r11, (String) r12);
        goto L4
    L28:
        r0.putDouble(r11, ((Number) r12).doubleValue());
        goto L4
    L25:
        r0.putDouble(r11, ((Number) r12).floatValue());
        goto L4
    L22:
        r0.putDouble(r11, ((Number) r12).longValue());
        goto L4
    L19:
        r0.putInt(r11, ((Number) r12).intValue());
        goto L4
    L16:
        r0.putBoolean(r11, ((Boolean) r12).booleanValue());
        goto L4
    L13:
        r0.putArray(r11, d((JSONArray) r12));
        goto L4
    L10:
        r0.putMap(r11, null);
        goto L4
    L7:
        r0.putMap(r11, e((JSONObject) r12));
        goto L4
    L33:
        return r0;
    }

    @JvmStatic
    public static final JavaOnlyMap f(Map<String, ? extends Object> r10) {
        Intrinsics.checkNotNullParameter(r10, "source");
        JavaOnlyMap r0 = new JavaOnlyMap();
        Iterator<Map.Entry<String, ? extends Object>> r11 = r10.entrySet().iterator();
    L4:
        if (r11.hasNext() == false) goto L44;
        Map.Entry<String, ? extends Object> r1 = r11.next();
        String r12 = r1.getKey();
        Object r13 = r1.getValue();
        if ((r13 instanceof Map) == false) goto L11;
        r0.putMap(r12, f((Map) r13));     // Catch: Exception -> L9
        goto L4
    L11:
        if ((r13 instanceof List) == true) goto L12;
        if ((r13 instanceof Boolean) == true) goto L16;
        if ((r13 instanceof Integer) == true) goto L19;
        if ((r13 instanceof Long) == true) goto L22;
        if ((r13 instanceof Float) == true) goto L25;
        if ((r13 instanceof Double) == true) goto L28;
        if ((r13 instanceof String) == true) goto L31;
        if ((r13 instanceof JSONObject) == true) goto L34;
        if ((r13 instanceof JSONArray) == true) goto L37;
        if (r13 == null) goto L43;
        if (Intrinsics.areEqual(r13, JSONObject.NULL) == true) goto L43;
        r0.putString(r12, r13.toString());
    L43:
        r0.putNull(r12);
        goto L4
    L37:
        r0.putArray(r12, d((JSONArray) r13));
        goto L4
    L34:
        r0.putMap(r12, e((JSONObject) r13));
        goto L4
    L31:
        r0.putString(r12, (String) r13);
        goto L4
    L28:
        r0.putDouble(r12, ((Number) r13).doubleValue());
        goto L4
    L25:
        r0.putDouble(r12, ((Number) r13).floatValue());
        goto L4
    L22:
        r0.putDouble(r12, ((Number) r13).longValue());
        goto L4
    L19:
        r0.putInt(r12, ((Number) r13).intValue());
        goto L4
    L16:
        r0.putBoolean(r12, ((Boolean) r13).booleanValue());
        goto L4
    L12:
        r0.putArray(r12, a((List) r13));     // Catch: Exception -> L9
        goto L4
    L44:
        return r0;
    }

    public static Number g(Number r10) {
        Intrinsics.checkNotNullParameter(r10, "rawNumber");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        Object r1 = Result.constructor-impl(Integer.valueOf(r10.intValue()));     // Catch: Throwable -> L5
    L7:
        Object r11 = null;
        if (Result.isFailure-impl(r1) == false) goto L10;
        r1 = null;
    L10:
        Integer r12 = (Integer) r1;
        if (r12 == null) goto L13;
        int r13 = r12.intValue();
    L38:
        Object r14 = Result.constructor-impl(Double.valueOf(r10.doubleValue()));     // Catch: Throwable -> L16
    L19:
        if (Result.isFailure-impl(r14) == true) goto L22;
        r11 = r14;
    L22:
        Double r15 = (Double) r11;
        if (r15 == null) goto L25;
        double r16 = r15.doubleValue();
    L27:
        if (Double.compare(r13, r16) == 0) goto L29;
        long r17 = (long) r16;
        if (Double.compare(r16, r17) != 0) goto L35;
        return Long.valueOf(r17);
    L35:
        return Double.valueOf(r16);
    L29:
        return Integer.valueOf(r13);
    L25:
        r16 = 0.0d;
    L16:
        th = move-exception;
        Result.Companion r18 = Result.Companion;
        r14 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L19
    L13:
        r13 = 0;
    L5:
        th = move-exception;
        Result.Companion r19 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.util.HashMap] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r4v4, types: [java.lang.Object] */
    public static Object h(Object r10) {
        if ((r10 instanceof ReadableArray) == false) goto L9;
        ReadableArray r11 = (ReadableArray) r10;
        int r0 = r11.size();
        ?? r1 = new ArrayList();
        int r12 = 0;
    L5:
        if (r12 >= r0) goto L20;
        r1.add(h(i(r11.getDynamic(r12))));
        r12 = r12 + 1;
    L20:
        return r1;
    L9:
        if ((r10 instanceof ReadableMap) == false) goto L15;
        ReadableMap r13 = (ReadableMap) r10;
        Intrinsics.checkNotNullParameter(r13, com.bytedance.android.ec.core.event.a.KEY_LUBAN_VALUE);
        ReadableMapKeySetIterator r14 = r13.keySetIterator();
        r1 = new HashMap();
    L12:
        if (r14.hasNextKey() == false) goto L20;
        String r15 = r14.nextKey();
        r1.put(r15, h(i(r13.getDynamic(r15))));
        goto L12
    L15:
        if ((r10 instanceof Number) == true) goto L17;
        return r10;
    L17:
        return g((Number) r10);
    }

    public static Object i(sp7.a r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        ReadableType r0 = r10.getType();
        if (r0 != null) goto L5;
        int r1 = -1;
    L7:
        if (r1 == 1) goto L23;
        if (r1 == 2) goto L21;
        if (r1 == 3) goto L27;
        if (r1 == 4) goto L26;
        if (r1 == 5) goto L25;
        return null;
    L25:
        return r10.asArray();
    L26:
        return r10.asMap();
    L27:
        return Boolean.valueOf(r10.asBoolean());
    L21:
        return g(Double.valueOf(r10.asDouble()));
    L23:
        return r10.asString();
    L5:
        r1 = a.a[r0.ordinal()];
        goto L7
    }
}
