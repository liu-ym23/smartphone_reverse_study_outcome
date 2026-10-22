package com.obric.cae.utils.bridge;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.ToNumberPolicy;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Gson f7365a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Regex f7366b = null;

    static {
        f7365a = new GsonBuilder().setObjectToNumberStrategy(ToNumberPolicy.LONG_OR_DOUBLE).create();
        f7366b = new Regex("[A-Za-z_][A-Za-z0-9_]{0,63}");
    }

    public static Object[] a(Method r14, List r15) {
        List r16 = (List) ZeusTransformUtils.wrapperContextForParams(r15, List.class, "com.obric.memorydata.plugin");
        int r0 = r16.size();
        Object[] r2 = new Object[r0];
        int r4 = 0;
    L3:
        if (r4 >= r0) goto L143;
        Object r5 = r16.get(r4);
        Class<?> r6 = r14.getParameterTypes()[r4];
        Intrinsics.checkNotNullExpressionValue(r6, "method.parameterTypes[index]");
        Type r7 = r14.getGenericParameterTypes()[r4];
        Intrinsics.checkNotNullExpressionValue(r7, "method.genericParameterTypes[index]");
        Object r8 = null;
        if (r5 != null) goto L12;
        if ((!r6.isPrimitive()) == false) goto L10;
    L8:
        r5 = r8;
    L142:
        r2[r4] = r5;
        r4 = r4 + 1;
        goto L3
    L10:
        throw new IllegalArgumentException("null cannot be passed to ".concat(r6.getName()).toString());
    L12:
        if (r6.isPrimitive() == true) goto L15;
    L38:
        Class<?> r9 = r6;
    L40:
        if (Intrinsics.areEqual(r9, Object.class) == true) goto L142;
        if (Intrinsics.areEqual(r9, Object.class) == true) goto L142;
        if (ZeusTransformUtils.instanceOf(r9, r5) == false) goto L52;
        if (ZeusTransformUtils.instanceOf(r5, Collection.class) == true) goto L52;
        if (r9.isArray() == false) goto L142;
    L52:
        if (Intrinsics.areEqual(r9, Byte.class) == false) goto L60;
        if (ZeusTransformUtils.instanceOf(r5, Number.class) == false) goto L56;
        Number r10 = (Number) ZeusTransformUtils.preCheckCast(r5, Number.class, "com.obric.memorydata.plugin");
    L57:
        if (r10 == null) goto L138;
        r8 = Byte.valueOf(r10.byteValue());
    L138:
        if (r8 != null) goto L8;
        throw new IllegalArgumentException("Parameter type " + r5.getClass().getName() + " does not match " + r6.getName());
    L56:
        r10 = null;
        goto L57
    L60:
        if (Intrinsics.areEqual(r9, Short.class) == false) goto L68;
        if (ZeusTransformUtils.instanceOf(r5, Number.class) == false) goto L64;
        Number r11 = (Number) ZeusTransformUtils.preCheckCast(r5, Number.class, "com.obric.memorydata.plugin");
    L65:
        if (r11 == null) goto L138;
        r8 = Short.valueOf(r11.shortValue());
        goto L138
    L64:
        r11 = null;
        goto L65
    L68:
        if (Intrinsics.areEqual(r9, Integer.class) == false) goto L76;
        if (ZeusTransformUtils.instanceOf(r5, Number.class) == false) goto L72;
        Number r12 = (Number) ZeusTransformUtils.preCheckCast(r5, Number.class, "com.obric.memorydata.plugin");
    L73:
        if (r12 == null) goto L138;
        r8 = Integer.valueOf(r12.intValue());
        goto L138
    L72:
        r12 = null;
        goto L73
    L76:
        if (Intrinsics.areEqual(r9, Long.class) == false) goto L84;
        if (ZeusTransformUtils.instanceOf(r5, Number.class) == false) goto L80;
        Number r13 = (Number) ZeusTransformUtils.preCheckCast(r5, Number.class, "com.obric.memorydata.plugin");
    L81:
        if (r13 == null) goto L138;
        r8 = Long.valueOf(r13.longValue());
        goto L138
    L80:
        r13 = null;
        goto L81
    L84:
        if (Intrinsics.areEqual(r9, Float.class) == false) goto L92;
        if (ZeusTransformUtils.instanceOf(r5, Number.class) == false) goto L88;
        Number r17 = (Number) ZeusTransformUtils.preCheckCast(r5, Number.class, "com.obric.memorydata.plugin");
    L89:
        if (r17 == null) goto L138;
        r8 = Float.valueOf(r17.floatValue());
        goto L138
    L88:
        r17 = null;
        goto L89
    L92:
        if (Intrinsics.areEqual(r9, Double.class) == false) goto L100;
        if (ZeusTransformUtils.instanceOf(r5, Number.class) == false) goto L96;
        Number r18 = (Number) ZeusTransformUtils.preCheckCast(r5, Number.class, "com.obric.memorydata.plugin");
    L97:
        if (r18 == null) goto L138;
        r8 = Double.valueOf(r18.doubleValue());
        goto L138
    L96:
        r18 = null;
        goto L97
    L100:
        if (Intrinsics.areEqual(r9, Boolean.class) == false) goto L105;
        if (ZeusTransformUtils.instanceOf(r5, Boolean.class) == false) goto L138;
        r8 = (Boolean) ZeusTransformUtils.preCheckCast(r5, Boolean.class, "com.obric.memorydata.plugin");
        goto L138
    L105:
        if (Intrinsics.areEqual(r9, Character.class) == false) goto L113;
        if (ZeusTransformUtils.instanceOf(r5, String.class) == false) goto L109;
        String r19 = (String) ZeusTransformUtils.preCheckCast(r5, String.class, "com.obric.memorydata.plugin");
    L110:
        if (r19 == null) goto L138;
        r8 = StringsKt.singleOrNull(r19);
        goto L138
    L109:
        r19 = null;
        goto L110
    L113:
        if (Intrinsics.areEqual(r9, String.class) == false) goto L118;
        if (ZeusTransformUtils.instanceOf(r5, String.class) == false) goto L138;
        r8 = (String) ZeusTransformUtils.preCheckCast(r5, String.class, "com.obric.memorydata.plugin");
        goto L138
    L118:
        if (Intrinsics.areEqual(r9, JSONObject.class) == false) goto L121;
        r8 = new JSONObject(f7365a.toJson(r5));
        goto L138
    L121:
        if (Intrinsics.areEqual(r9, JSONArray.class) == false) goto L124;
        r8 = new JSONArray(f7365a.toJson(r5));
        goto L138
    L124:
        if (r9.isEnum() == true) goto L126;
        Gson r20 = f7365a;     // Catch: RuntimeException -> L144
        r8 = r20.fromJson(r20.toJsonTree(r5), r7);     // Catch: RuntimeException -> L144
        goto L138
    L126:
        if (ZeusTransformUtils.instanceOf(r5, String.class) == false) goto L128;
        String r21 = (String) ZeusTransformUtils.preCheckCast(r5, String.class, "com.obric.memorydata.plugin");
    L129:
        if (r21 == null) goto L138;
        Object[] r22 = r9.getEnumConstants();
        Intrinsics.checkNotNullExpressionValue(r22, "targetType.enumConstants");
        int r110 = r22.length;
        int r111 = 0;
    L132:
        if (r111 >= r110) goto L138;
        Object r112 = r22[r111];
        Intrinsics.checkNotNull(r112, "null cannot be cast to non-null type kotlin.Enum<*>");
        if (Intrinsics.areEqual(((Enum) ZeusTransformUtils.preCheckCast(r112, Enum.class, "com.obric.memorydata.plugin")).name(), r21) == true) goto L135;
        r111 = r111 + 1;
        goto L132
    L135:
        r8 = r112;
        goto L138
    L128:
        r21 = null;
        goto L129
    L15:
        if (Intrinsics.areEqual(r6, Byte.TYPE) == false) goto L18;
        r9 = Byte.class;
        goto L40
    L18:
        if (Intrinsics.areEqual(r6, Short.TYPE) == false) goto L21;
        r9 = Short.class;
        goto L40
    L21:
        if (Intrinsics.areEqual(r6, Integer.TYPE) == false) goto L24;
        r9 = Integer.class;
        goto L40
    L24:
        if (Intrinsics.areEqual(r6, Long.TYPE) == false) goto L27;
        r9 = Long.class;
        goto L40
    L27:
        if (Intrinsics.areEqual(r6, Float.TYPE) == false) goto L30;
        r9 = Float.class;
        goto L40
    L30:
        if (Intrinsics.areEqual(r6, Double.TYPE) == false) goto L33;
        r9 = Double.class;
        goto L40
    L33:
        if (Intrinsics.areEqual(r6, Boolean.TYPE) == false) goto L36;
        r9 = Boolean.class;
        goto L40
    L36:
        if (Intrinsics.areEqual(r6, Character.TYPE) == false) goto L38;
        r9 = Character.class;
        goto L40
    L143:
        return r2;
    }
}
