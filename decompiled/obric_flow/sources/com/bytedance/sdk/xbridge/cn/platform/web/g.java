package com.bytedance.sdk.xbridge.cn.platform.web;

import ai.j0;
import cj.l;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.DefaultType;
import com.bytedance.sdk.xbridge.cn.registry.core.exception.IllegalInputParamException;
import com.lynx.jsbridge.LynxResourceModule;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Pair;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class g implements com.bytedance.sdk.xbridge.cn.protocol.g {
    public static final Object d(final g r5, Object r10, final dj.c r11) {
        r5.getClass();
        boolean r12 = r10 instanceof JSONObject;
        if (r12 == false) goto L20;
        if (r11 == null) goto L6;
        KClass r13 = Reflection.getOrCreateKotlinClass(r11.nestedClassType());
    L8:
        if (Intrinsics.areEqual(r13, Reflection.getOrCreateKotlinClass(fj.a.class)) == true) goto L20;
        if (r11 == null) goto L11;
        Class r14 = r11.nestedClassType();
    L12:
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type org.json.JSONObject");
        JSONObject r15 = (JSONObject) r10;
        if (r14 != null) goto L16;
        return null;
    L16:
        if (r5.i(r14, r15) != null) goto L19;
        return null;
    L19:
        return Proxy.newProxyInstance(r14.getClassLoader(), new Class[]{r14}, new com.bytedance.sdk.xbridge.cn.platform.lynx.i(r5, r14, r15, 1));
    L11:
        r14 = null;
        goto L12
    L6:
        r13 = null;
    L20:
        boolean r16 = r10 instanceof JSONArray;
        if (r16 == false) goto L29;
        if (r11 == null) goto L24;
        KClass r17 = Reflection.getOrCreateKotlinClass(r11.nestedClassType());
    L26:
        if (Intrinsics.areEqual(r17, Reflection.getOrCreateKotlinClass(fj.a.class)) == true) goto L29;
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type org.json.JSONArray");
        return com.bytedance.sdk.xbridge.cn.utils.f.b((JSONArray) r10, new WebPlatformDataProcessor$convertValueWithAnnotation$1(r5, r11));
    L24:
        r17 = null;
    L29:
        if (r16 == true) goto L31;
        if (r12 == false) goto L36;
        return com.bytedance.sdk.xbridge.cn.utils.f.c((JSONObject) r10);
    L36:
        if (Intrinsics.areEqual(r10, JSONObject.NULL) == false) goto L38;
        return null;
    L38:
        return r10;
    L31:
        return com.bytedance.sdk.xbridge.cn.utils.f.a((JSONArray) r10);
    }

    public static Object e(Method r5, dj.c r10) {
        Class<?> r11 = r5.getReturnType();
        boolean r12 = true;
        if (Intrinsics.areEqual(r11, Number.class) == false) goto L19;
        DefaultType r13 = r10.defaultValue().type();
        int r14 = f.f7422a[r13.ordinal()];
        if (r14 == 1) goto L17;
        if (r14 == 2) goto L15;
        if (r14 == 3) goto L13;
        return Integer.valueOf(r10.defaultValue().intValue());
    L13:
        return Integer.valueOf(r10.defaultValue().intValue());
    L15:
        return Long.valueOf(r10.defaultValue().longValue());
    L17:
        return Double.valueOf(r10.defaultValue().doubleValue());
    L19:
        if (Intrinsics.areEqual(r11, Boolean.TYPE) == true) goto L22;
        r12 = Intrinsics.areEqual(r11, Boolean.class);
    L22:
        if (r12 == false) goto L26;
        return Boolean.valueOf(r10.defaultValue().boolValue());
    L26:
        return r10.defaultValue().stringValue();
    }

    public static HashMap g(JSONObject r5, Function1 r10) {
        HashMap r11 = new HashMap();
        Iterator<String> r12 = r5.keys();
    L4:
        if (r12.hasNext() == false) goto L6;
        String r13 = r12.next();
        r11.put(r13, r10.invoke(new Pair(r13, r5.opt(r13))));
        goto L4
    L6:
        return r11;
    }

    @Override // com.bytedance.sdk.xbridge.cn.protocol.g
    public final LinkedHashMap a(Object r5) {
        JSONObject r10 = (JSONObject) r5;
        Intrinsics.checkNotNullParameter(r10, LynxResourceModule.PARAMS_KEY);
        return com.bytedance.sdk.xbridge.cn.utils.f.c(r10);
    }

    @Override // com.bytedance.sdk.xbridge.cn.protocol.g
    public final Map b(Class r5, Object r10, String r11) {
        JSONObject r12 = (JSONObject) r10;
        Intrinsics.checkNotNullParameter(r12, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r5, "clazz");
        Intrinsics.checkNotNullParameter(r11, "nameSpace");
        if (Intrinsics.areEqual(r11, "webcast") == false) goto L17;
        Iterator<String> r13 = r12.keys();
        JSONObject r14 = new JSONObject();
    L6:
        if (r13.hasNext() == false) goto L15;
        String r15 = r13.next();
        if (r12.opt(r15) == null) goto L6;
        if (Intrinsics.areEqual(r12.opt(r15).toString(), "null") == true) goto L6;
        Object r16 = r12.opt(r15);
        if (r16 == null) goto L6;
        r14.put(r15, r16);
        goto L6
    L15:
        return f(r5, r14);
    L17:
        return f(r5, r12);
    }

    @Override // com.bytedance.sdk.xbridge.cn.protocol.g
    public final /* bridge */ /* synthetic */ Map c(Class r5, Object r10) {
        return f(r5, (JSONObject) r10);
    }

    public final HashMap f(Class r5, JSONObject r10) {
        Intrinsics.checkNotNullParameter(r10, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r5, "clazz");
        final cj.f r11 = (cj.f) l.f1209a.get(r5);
        if (r11 == null) goto L9;
        Intrinsics.checkNotNullParameter(r10, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r11, "clazz");
        final cj.g r12 = i.a(r11.f1196c, r10);
        if (r12 != null) goto L8;
        return null;
    L8:
        return i.d(r10, new WebProcessorForMap$getJavaOnlyMapParams$1(r12, r11));
    L9:
        Class r13 = f4.a.a(r5);
        if (r13 != null) goto L13;
        ConcurrentHashMap r14 = ki.b.f18649a;
        Intrinsics.checkNotNullParameter(r5, "clazz");
        ki.b.a(r5, dj.d.class);
        return null;
    L13:
        final HashMap r15 = i(r13, r10);
        if (r15 != null) goto L17;
        return null;
    L17:
        return g(r10, new WebPlatformDataProcessor$getJsonObjectParams$1(r15, this));
    }

    public final JSONObject h(Class r10, JSONObject r11) {
        if (r10 == null) goto L14;
        Method[] r12 = r10.getDeclaredMethods();
        if (r12 == null) goto L14;
        ArrayList r5 = new ArrayList();
        int r13 = r12.length;
        int r14 = 0;
    L7:
        if (r14 >= r13) goto L15;
        Method r15 = r12[r14];
        dj.c r16 = (dj.c) r15.getAnnotation(dj.c.class);
        if (r16 == null) goto L13;
        if (r16.isGetter() != true) goto L13;
        r5.add(r15);
    L13:
        r14 = r14 + 1;
    L15:
        if (r5 == null) goto L38;
        JSONObject r17 = new JSONObject();
        Iterator r18 = r5.iterator();
    L18:
        if (r18.hasNext() == false) goto L36;
        Method r19 = (Method) r18.next();
        dj.c r20 = (dj.c) r19.getAnnotation(dj.c.class);
        Object r21 = r11.opt(r20.keyPath());
        if (r21 == null) goto L22;
    L24:
        final KClass r22 = Reflection.getOrCreateKotlinClass(r20.nestedClassType());
        String r23 = r20.keyPath();
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(r20.nestedClassType()), Reflection.getOrCreateKotlinClass(fj.a.class)) == true) goto L30;
        if ((r21 instanceof JSONObject) == false) goto L30;
        Object r24 = h(JvmClassMappingKt.getJavaClass(r22), (JSONObject) r21);
    L35:
        r17.put(r23, r24);
    L30:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(r20.nestedClassType()), Reflection.getOrCreateKotlinClass(fj.a.class)) == false) goto L32;
    L34:
        r24 = r11.opt(r20.keyPath());
        goto L35
    L32:
        if ((r21 instanceof JSONArray) == false) goto L34;
        r24 = com.bytedance.sdk.xbridge.cn.utils.f.b((JSONArray) r21, new WebPlatformDataProcessor$getMapWithDefault$1$1(this, r22));
        goto L35
    L22:
        if (r20.defaultValue().type() == DefaultType.NONE) goto L24;
        Object r25 = e(r19, r20);
        r11.put(r20.keyPath(), r25);
        goto L24
    L36:
        return r17;
    L38:
        return new JSONObject();
    L14:
        r5 = null;
        goto L15
    }

    public final HashMap i(Class r11, JSONObject r12) {
        Method[] r13 = r11.getDeclaredMethods();
        if (r13 == null) goto L116;
        HashMap r5 = new HashMap();
        int r10 = r13.length;
        int r14 = 0;
    L5:
        if (r14 >= r10) goto L10;
        Method r15 = r13[r14];
        dj.c r16 = (dj.c) r15.getAnnotation(dj.c.class);
        if (r16 == null) goto L9;
        r5.put(r16.keyPath(), new Pair(r15, r16));
    L9:
        r14 = r14 + 1;
        goto L5
    L10:
        LinkedHashMap r17 = new LinkedHashMap();
        Iterator r18 = r5.entrySet().iterator();
    L12:
        if (r18.hasNext() == false) goto L18;
        Map.Entry r19 = (Map.Entry) r18.next();
        if (r12.has((String) r19.getKey()) == true) goto L12;
        if (((dj.c) ((Pair) r19.getValue()).getSecond()).defaultValue().type() == DefaultType.NONE) goto L12;
        r17.put(r19.getKey(), r19.getValue());
        goto L12
    L18:
        Iterator r110 = r17.entrySet().iterator();
    L20:
        if (r110.hasNext() == false) goto L22;
        Map.Entry r20 = (Map.Entry) r110.next();
        r12.put((String) r20.getKey(), e((Method) ((Pair) r20.getValue()).getFirst(), (dj.c) ((Pair) r20.getValue()).getSecond()));
        goto L20
    L22:
        Iterator r111 = r5.entrySet().iterator();
    L24:
        if (r111.hasNext() == false) goto L115;
        final Map.Entry r21 = (Map.Entry) r111.next();
        dj.c r22 = (dj.c) ((Pair) r21.getValue()).getSecond();
        Method r23 = (Method) ((Pair) r21.getValue()).getFirst();
        final Object r24 = r12.opt((String) r21.getKey());
        if (r22.required() == false) goto L33;
        if (r24 == null) goto L32;
        if (Intrinsics.areEqual(r24, JSONObject.NULL) == false) goto L33;
    L32:
        throw new IllegalInputParamException(j0.q(new StringBuilder(), (String) r21.getKey(), " param is missing from input"));
    L33:
        Class<?> r25 = r23.getReturnType();
        if (Intrinsics.areEqual(r25, String.class) == false) goto L44;
        if (r24 != null) goto L37;
    L86:
        if (r24 == null) goto L24;
        if (r22.isEnum() == false) goto L24;
        Class<?> r26 = r23.getReturnType();
        if (Intrinsics.areEqual(r26, String.class) == true) goto L91;
        if (Intrinsics.areEqual(r26, Number.class) == true) goto L98;
        if (Intrinsics.areEqual(r26, Map.class) == false) goto L24;
        dj.f r27 = (dj.f) r23.getAnnotation(dj.f.class);
        if (r27 != null) goto L111;
        dj.b r28 = (dj.b) r23.getAnnotation(dj.b.class);
        if (r28 == null) goto L24;
        final int[] r29 = r28.option();
        g((JSONObject) r24, new WebPlatformDataProcessor$checkValue$1$2(r29, this, r21, r24));
        goto L24
    L111:
        final String[] r30 = r27.option();
        g((JSONObject) r24, new WebPlatformDataProcessor$checkValue$1$1(r30, r21, r24));
        goto L24
    L98:
        int[] r31 = ((dj.b) r23.getAnnotation(dj.b.class)).option();
        if ((r24 instanceof Number) == false) goto L106;
        if (ArraysKt.contains(r31, ((Number) r24).intValue()) == true) goto L24;
        throw new IllegalInputParamException(((String) r21.getKey()) + " has wrong value.should be one of " + ArraysKt.asList(r31) + " but got " + r24);
    L106:
        throw new IllegalInputParamException("the key is not a number");
    L91:
        String[] r32 = ((dj.f) r23.getAnnotation(dj.f.class)).option();
        if (ArraysKt.contains(r32, r24) == true) goto L24;
        throw new IllegalInputParamException(((String) r21.getKey()) + " has wrong type.should be one of " + ArraysKt.asList(r32) + " but got " + r24);
    L37:
        if ((r24 instanceof String) == true) goto L86;
        if (Intrinsics.areEqual(r24, JSONObject.NULL) == true) goto L86;
        throw new IllegalInputParamException(androidx.room.jarjarred.org.antlr.runtime.a.u(new StringBuilder(), (String) r21.getKey(), " param has wrong declared type. except string,but ", r24));
    L44:
        if (Intrinsics.areEqual(r25, Number.class) == false) goto L54;
        if (r24 == null) goto L86;
        if ((r24 instanceof Number) == true) goto L86;
        if (Intrinsics.areEqual(r24, JSONObject.NULL) == true) goto L86;
        throw new IllegalInputParamException(androidx.room.jarjarred.org.antlr.runtime.a.u(new StringBuilder(), (String) r21.getKey(), " param has wrong declared type. except number,but ", r24));
    L54:
        if (Intrinsics.areEqual(r25, Boolean.class) == false) goto L56;
        boolean r33 = true;
    L57:
        if (r33 == false) goto L67;
        if (r24 == null) goto L86;
        if ((r24 instanceof Boolean) == true) goto L86;
        if (Intrinsics.areEqual(r24, JSONObject.NULL) == true) goto L86;
        throw new IllegalInputParamException(androidx.room.jarjarred.org.antlr.runtime.a.u(new StringBuilder(), (String) r21.getKey(), " param has wrong declared type. except boolean,but ", r24));
    L67:
        if (Intrinsics.areEqual(r25, List.class) == false) goto L77;
        if (r24 == null) goto L86;
        if (Intrinsics.areEqual(r24, JSONObject.NULL) == true) goto L86;
        if ((r24 instanceof JSONArray) == true) goto L86;
        throw new IllegalInputParamException(androidx.room.jarjarred.org.antlr.runtime.a.u(new StringBuilder(), (String) r21.getKey(), " param has wrong declared type. except List ,but ", r24));
    L77:
        if (Intrinsics.areEqual(r25, Map.class) == false) goto L86;
        if (r24 == null) goto L86;
        if (Intrinsics.areEqual(r24, JSONObject.NULL) == true) goto L86;
        if ((r24 instanceof JSONObject) == true) goto L86;
        throw new IllegalInputParamException(androidx.room.jarjarred.org.antlr.runtime.a.u(new StringBuilder(), (String) r21.getKey(), " param has wrong declared type. except Map ,but ", r24));
    L56:
        r33 = Intrinsics.areEqual(r25, Boolean.TYPE);
        goto L57
    L115:
        return r5;
    L116:
        return null;
    }

    @Override // com.bytedance.sdk.xbridge.cn.protocol.g
    public final Object a(HashMap r5, Class r10, bj.a r11) {
        Intrinsics.checkNotNullParameter(r5, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r10, "clazz");
        Object r12 = r5.get("__jsb2__data__");
        if (r12 == null) goto L7;
        return (JSONObject) r12;
    L7:
        return com.bytedance.sdk.xbridge.cn.utils.f.e(r11.F, r5);
    }
}
