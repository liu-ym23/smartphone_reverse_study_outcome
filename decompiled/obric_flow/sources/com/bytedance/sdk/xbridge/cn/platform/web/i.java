package com.bytedance.sdk.xbridge.cn.platform.web;

import ai.j0;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.DefaultType;
import com.bytedance.sdk.xbridge.cn.registry.core.exception.IllegalInputParamException;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class i {
    public static cj.g a(cj.g r10, JSONObject r11) {
        if (r10 != null) goto L5;
        return null;
    L5:
        HashMap r5 = r10.f1198b;
        LinkedHashMap r12 = new LinkedHashMap();
        Iterator r13 = r5.entrySet().iterator();
    L7:
        if (r13.hasNext() == false) goto L13;
        Map.Entry r14 = (Map.Entry) r13.next();
        if (r11.opt((String) r14.getKey()) != null) goto L7;
        if (((cj.i) r14.getValue()).g.f1199a == DefaultType.NONE) goto L7;
        r12.put(r14.getKey(), r14.getValue());
        goto L7
    L13:
        Iterator r15 = r12.entrySet().iterator();
    L15:
        if (r15.hasNext() == false) goto L17;
        Map.Entry r16 = (Map.Entry) r15.next();
        cj.i r17 = (cj.i) r16.getValue();
        r11.put((String) r16.getKey(), b(r17.f1205h, r17));
        goto L15
    L17:
        Iterator r18 = r5.entrySet().iterator();
    L19:
        if (r18.hasNext() == false) goto L110;
        final Map.Entry r19 = (Map.Entry) r18.next();
        String r20 = (String) r19.getKey();
        cj.i r21 = (cj.i) r19.getValue();
        final Object r22 = r11.opt(r20);
        if (r21.f1202a == false) goto L28;
        if (r22 == null) goto L27;
        if (Intrinsics.areEqual(r22, JSONObject.NULL) == false) goto L28;
    L27:
        throw new IllegalInputParamException(j0.q(new StringBuilder(), (String) r19.getKey(), " param is missing from input"));
    L28:
        Class r23 = r21.f1205h;
        if (Intrinsics.areEqual(r23, String.class) == false) goto L39;
        if (r22 != null) goto L32;
    L81:
        if (r22 == null) goto L19;
        if (r21.e == false) goto L19;
        boolean r24 = Intrinsics.areEqual(r23, String.class);
        final List r25 = r21.f1206i;
        if (r24 == true) goto L87;
        boolean r26 = Intrinsics.areEqual(r23, Number.class);
        final List r27 = r21.f1207j;
        if (r26 == true) goto L94;
        if (Intrinsics.areEqual(r23, Map.class) == false) goto L19;
        if (r25.isEmpty() == false) goto L106;
        if (r27.isEmpty() == true) goto L19;
        d((JSONObject) r22, new WebProcessorForMap$checkValue$1$2(r27, r19, r22));
        goto L19
    L106:
        d((JSONObject) r22, new WebProcessorForMap$checkValue$1$1(r25, r19, r22));
        goto L19
    L94:
        if ((r22 instanceof Number) == false) goto L101;
        if (r27.contains(Integer.valueOf(((Number) r22).intValue())) == true) goto L19;
        throw new IllegalInputParamException(((String) r19.getKey()) + " has wrong value.should be one of " + r27 + " but got " + r22);
    L101:
        throw new IllegalInputParamException("the key is not a number");
    L87:
        if (CollectionsKt.contains(r25, r22) == true) goto L19;
        throw new IllegalInputParamException(((String) r19.getKey()) + " has wrong type.should be one of " + r25 + " but got " + r22);
    L32:
        if ((r22 instanceof String) == true) goto L81;
        if (Intrinsics.areEqual(r22, JSONObject.NULL) == true) goto L81;
        throw new IllegalInputParamException(androidx.room.jarjarred.org.antlr.runtime.a.u(new StringBuilder(), (String) r19.getKey(), " param has wrong declared type. except string,but ", r22));
    L39:
        if (Intrinsics.areEqual(r23, Number.class) == false) goto L49;
        if (r22 == null) goto L81;
        if ((r22 instanceof Number) == true) goto L81;
        if (Intrinsics.areEqual(r22, JSONObject.NULL) == true) goto L81;
        throw new IllegalInputParamException(androidx.room.jarjarred.org.antlr.runtime.a.u(new StringBuilder(), (String) r19.getKey(), " param has wrong declared type. except number,but ", r22));
    L49:
        if (Intrinsics.areEqual(r23, Boolean.class) == false) goto L51;
        boolean r28 = true;
    L52:
        if (r28 == false) goto L62;
        if (r22 == null) goto L81;
        if ((r22 instanceof Boolean) == true) goto L81;
        if (Intrinsics.areEqual(r22, JSONObject.NULL) == true) goto L81;
        throw new IllegalInputParamException(androidx.room.jarjarred.org.antlr.runtime.a.u(new StringBuilder(), (String) r19.getKey(), " param has wrong declared type. except boolean,but ", r22));
    L62:
        if (Intrinsics.areEqual(r23, List.class) == false) goto L72;
        if (r22 == null) goto L81;
        if (Intrinsics.areEqual(r22, JSONObject.NULL) == true) goto L81;
        if ((r22 instanceof JSONArray) == true) goto L81;
        throw new IllegalInputParamException(androidx.room.jarjarred.org.antlr.runtime.a.u(new StringBuilder(), (String) r19.getKey(), " param has wrong declared type. except List ,but ", r22));
    L72:
        if (Intrinsics.areEqual(r23, Map.class) == false) goto L81;
        if (r22 == null) goto L81;
        if (Intrinsics.areEqual(r22, JSONObject.NULL) == true) goto L81;
        if ((r22 instanceof JSONObject) == true) goto L81;
        throw new IllegalInputParamException(androidx.room.jarjarred.org.antlr.runtime.a.u(new StringBuilder(), (String) r19.getKey(), " param has wrong declared type. except Map ,but ", r22));
    L51:
        r28 = Intrinsics.areEqual(r23, Boolean.TYPE);
        goto L52
    L110:
        return r10;
    }

    public static Object b(Class r5, cj.i r10) {
        boolean r11 = true;
        if (Intrinsics.areEqual(r5, Number.class) == false) goto L19;
        DefaultType r12 = r10.g.f1199a;
        int r13 = h.f7423a[r12.ordinal()];
        cj.h r14 = r10.g;
        if (r13 == 1) goto L17;
        if (r13 == 2) goto L15;
        if (r13 == 3) goto L13;
        return Integer.valueOf(r14.d);
    L13:
        return Integer.valueOf(r14.d);
    L15:
        return Long.valueOf(r14.f);
    L17:
        return Double.valueOf(r14.f1200b);
    L19:
        if (Intrinsics.areEqual(r5, Boolean.TYPE) == true) goto L22;
        r11 = Intrinsics.areEqual(r5, Boolean.class);
    L22:
        if (r11 == false) goto L26;
        return Boolean.valueOf(r10.g.e);
    L26:
        return r10.g.f1201c;
    }

    public static final Object c(Object r10, final cj.i r11, final cj.f r12) {
        boolean r5 = r10 instanceof JSONObject;
        if (r5 == false) goto L22;
        if (r11 == null) goto L6;
        KClass r13 = r11.f1204c;
    L8:
        if (Intrinsics.areEqual(r13, Reflection.getOrCreateKotlinClass(fj.a.class)) == true) goto L22;
        if (r11 == null) goto L13;
        KClass r14 = r11.f1204c;
        if (r14 == null) goto L13;
        Class r15 = JvmClassMappingKt.getJavaClass(r14);
    L14:
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type org.json.JSONObject");
        JSONObject r16 = (JSONObject) r10;
        if (r15 != null) goto L17;
        return null;
    L17:
        cj.g r17 = a((cj.g) r12.e.get(r15), r16);
        if (r17 != null) goto L21;
        return null;
    L21:
        return Proxy.newProxyInstance(r15.getClassLoader(), new Class[]{r15}, new com.bytedance.sdk.xbridge.cn.platform.lynx.f(r16, r12, r15, r17, 1));
    L13:
        r15 = null;
        goto L14
    L6:
        r13 = null;
    L22:
        boolean r18 = r10 instanceof JSONArray;
        if (r18 == false) goto L31;
        if (r11 == null) goto L26;
        KClass r19 = r11.f1204c;
    L28:
        if (Intrinsics.areEqual(r19, Reflection.getOrCreateKotlinClass(fj.a.class)) == true) goto L31;
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type org.json.JSONArray");
        return com.bytedance.sdk.xbridge.cn.utils.f.b((JSONArray) r10, new WebProcessorForMap$convertValueWithAnnotation$result$1(r11, r12));
    L26:
        r19 = null;
    L31:
        if (r18 == true) goto L33;
        if (r5 == false) goto L38;
        return com.bytedance.sdk.xbridge.cn.utils.f.c((JSONObject) r10);
    L38:
        if (Intrinsics.areEqual(r10, JSONObject.NULL) == false) goto L40;
        return null;
    L40:
        return r10;
    L33:
        return com.bytedance.sdk.xbridge.cn.utils.f.a((JSONArray) r10);
    }

    public static HashMap d(JSONObject r5, Function1 r10) {
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

    public static JSONObject e(JSONObject r10, cj.g r11, final cj.f r12) {
        if (r11 != null) goto L5;
        return null;
    L5:
        HashMap r13 = r11.f1198b;
        LinkedHashMap r5 = new LinkedHashMap(MapsKt.mapCapacity(r13.size()));
        Iterator r14 = r13.entrySet().iterator();
    L7:
        if (r14.hasNext() == false) goto L26;
        final Map.Entry r15 = (Map.Entry) r14.next();
        Object r16 = r15.getKey();
        Object r17 = r10.opt(((cj.i) r15.getValue()).f1203b);
        if (r17 != null) goto L14;
        if (((cj.i) r15.getValue()).g.f1199a == DefaultType.NONE) goto L14;
        Object r18 = b(((cj.i) r15.getValue()).f1205h, (cj.i) r15.getValue());
        r10.put(((cj.i) r15.getValue()).f1203b, r18);
    L14:
        if (Intrinsics.areEqual(((cj.i) r15.getValue()).f1204c, Reflection.getOrCreateKotlinClass(fj.a.class)) == true) goto L19;
        if ((r17 instanceof JSONObject) == false) goto L19;
        Object r19 = r12.e.get(JvmClassMappingKt.getJavaClass(((cj.i) r15.getValue()).f1204c));
        Intrinsics.checkNotNull(r19);
        Object r20 = e((JSONObject) r17, (cj.g) r19, r12);
    L24:
        r5.put(r16, r20);
    L19:
        if (Intrinsics.areEqual(((cj.i) r15.getValue()).f1204c, Reflection.getOrCreateKotlinClass(fj.a.class)) == false) goto L21;
    L23:
        r20 = r10.opt(((cj.i) r15.getValue()).f1203b);
        goto L24
    L21:
        if ((r17 instanceof JSONArray) == false) goto L23;
        r20 = com.bytedance.sdk.xbridge.cn.utils.f.b((JSONArray) r17, new WebProcessorForMap$getMapWithDefault$1$1(r12, r15));
        goto L24
    L26:
        return new JSONObject(r5);
    }
}
