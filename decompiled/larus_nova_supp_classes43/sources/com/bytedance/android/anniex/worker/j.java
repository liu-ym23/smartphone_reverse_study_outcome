package com.bytedance.android.anniex.worker;

import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.DefaultType;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeIntEnum;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeParamField;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeStringEnum;
import com.bytedance.sdk.xbridge.cn.registry.core.exception.IllegalInputParamException;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseModel;
import com.bytedance.vmsdk.jsbridge.utils.JavaOnlyMap;
import com.bytedance.vmsdk.jsbridge.utils.ReadableArray;
import com.bytedance.vmsdk.jsbridge.utils.ReadableMap;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import me7.l;
import me7.o;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class j implements com.bytedance.sdk.xbridge.cn.protocol.g<ReadableMap, ReadableMap> {

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[DefaultType.values().length];
            r0[DefaultType.DOUBLE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[DefaultType.LONG.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[DefaultType.INT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    public static final class b implements InvocationHandler {
        public final /* synthetic */ j a;
        public final /* synthetic */ Class<? extends XBaseModel> b;
        public final /* synthetic */ HashMap<String, Object> c;

        public b(j r1, Class<? extends XBaseModel> r10, HashMap<String, Object> r11) {
            this.a = r1;
            this.b = r10;
            this.c = r11;
        }

        @Override // java.lang.reflect.InvocationHandler
        public final Object invoke(Object r1, Method r10, Object[] r11) {
            if (Intrinsics.areEqual(r10.getName(), "toJSON") == true) goto L5;
            XBridgeParamField r12 = r10.getAnnotation(XBridgeParamField.class);
            Object r13 = this.c.get(r12.keyPath());
            return this.a.e(r13, r12);
        L5:
            return new JSONObject(this.a.g(this.b, this.c));
        }
    }

    public j() {
    }

    public final Map d(Object r10) {
        JavaOnlyMap r11 = (ReadableMap) r10;
        Intrinsics.checkNotNullParameter(r11, "params");
        return h.c(r11);
    }

    public final int f(Object r10) {
        if ((r10 instanceof Number) == true) goto L5;
        if (r10 != null) goto L10;
        throw new IllegalInputParamException("the key is null");
    L10:
        throw new IllegalInputParamException("the key is not a number");
    L5:
        return ((Number) r10).intValue();
    }

    public final /* bridge */ /* synthetic */ Map b(Object r1, Class r10) {
        return k((ReadableMap) r1, r10);
    }

    public final Object e(Object r10, XBridgeParamField r11) {
        boolean r1 = false;
        Class<? extends XBaseModel> r12 = null;
        if ((r10 instanceof Map) == false) goto L10;
        if (r11 == null) goto L6;
        KClass r0 = Reflection.getOrCreateKotlinClass(r11.nestedClassType());
    L8:
        if (Intrinsics.areEqual(r0, Reflection.getOrCreateKotlinClass(XBaseModel.a.class)) == true) goto L10;
        boolean r13 = true;
    L12:
        if (r13 == false) goto L17;
        if (r11 == null) goto L15;
        r12 = r11.nestedClassType();
    L15:
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type com.bytedance.vmsdk.jsbridge.utils.ReadableMap");
        return j(r12, ((ReadableMap) r10).toHashMap());
    L17:
        if ((r10 instanceof List) == false) goto L24;
        if (r11 == null) goto L20;
        KClass r14 = Reflection.getOrCreateKotlinClass(r11.nestedClassType());
    L22:
        if (Intrinsics.areEqual(r14, Reflection.getOrCreateKotlinClass(XBaseModel.a.class)) == true) goto L24;
        r1 = true;
        goto L24
    L20:
        r14 = null;
    L24:
        if (r1 == false) goto L34;
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type kotlin.collections.List<*>");
        List r15 = (List) r10;
        ArrayList r16 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r15, 10));
        Iterator r17 = r15.iterator();
    L27:
        if (r17.hasNext() == false) goto L40;
        Object r18 = r17.next();
        if (r11 == null) goto L31;
        Class<? extends XBaseModel> r19 = r11.nestedClassType();
    L32:
        Intrinsics.checkNotNull(r18, "null cannot be cast to non-null type com.bytedance.vmsdk.jsbridge.utils.ReadableMap");
        r16.add(j(r19, ((ReadableMap) r18).toHashMap()));
        goto L27
    L31:
        r19 = null;
        goto L32
    L40:
        return r16;
    L34:
        h.a.getClass();
        return h.h(r10);
    L6:
        r0 = null;
    L10:
        r13 = false;
        goto L12
    }

    public final HashMap<String, Object> g(Class<? extends XBaseModel> r10, HashMap<String, Object> r11) {
        HashMap<String, Object> r0 = null;
        if (r10 == null) goto L17;
        Method[] r12 = r10.getDeclaredMethods();
        if (r12 == null) goto L17;
        ArrayList r1 = new ArrayList();
        int r13 = r12.length;
        int r14 = 0;
    L7:
        if (r14 >= r13) goto L18;
        Method r15 = r12[r14];
        XBridgeParamField r16 = r15.getAnnotation(XBridgeParamField.class);
        if (r16 == null) goto L13;
        boolean r17 = true;
        if (r16.isGetter() != true) goto L13;
    L14:
        if (r17 == false) goto L16;
        r1.add(r15);
    L16:
        r14 = r14 + 1;
    L13:
        r17 = false;
    L18:
        if (r1 == null) goto L43;
        r0 = new HashMap();
        Iterator r18 = r1.iterator();
    L21:
        if (r18.hasNext() == false) goto L43;
        Method r19 = (Method) r18.next();
        XBridgeParamField r20 = (XBridgeParamField) r19.getAnnotation(XBridgeParamField.class);
        Object r21 = r11.get(r20.keyPath());
        if (r21 == null) goto L25;
    L27:
        String r22 = r20.keyPath();
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(r20.nestedClassType()), Reflection.getOrCreateKotlinClass(XBaseModel.a.class)) == true) goto L33;
        if ((r21 instanceof ReadableMap) == false) goto L33;
        Object r23 = g(r20.nestedClassType(), ((ReadableMap) r21).toHashMap());
    L42:
        r0.put(r22, r23);
    L33:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(r20.nestedClassType()), Reflection.getOrCreateKotlinClass(XBaseModel.a.class)) == false) goto L35;
    L41:
        r23 = r11.get(r20.keyPath());
        goto L42
    L35:
        if ((r21 instanceof ReadableArray) == false) goto L41;
        ArrayList r24 = ((ReadableArray) r21).toArrayList();
        ArrayList r25 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r24, 10));
        Iterator r26 = r24.iterator();
    L38:
        if (r26.hasNext() == false) goto L40;
        Object r27 = r26.next();
        Class<? extends XBaseModel> r28 = r20.nestedClassType();
        Intrinsics.checkNotNull(r27, "null cannot be cast to non-null type com.bytedance.vmsdk.jsbridge.utils.ReadableMap");
        r25.add(g(r28, ((ReadableMap) r27).toHashMap()));
        goto L38
    L40:
        r23 = r25;
        goto L42
    L25:
        if (r20.defaultValue().type() == DefaultType.NONE) goto L27;
        r11.put(r20.keyPath(), h(r19, r20));
    L43:
        return r0;
    L17:
        r1 = null;
        goto L18
    }

    public final Object h(Method r10, XBridgeParamField r11) {
        Class<?> r12 = r10.getReturnType();
        boolean r1 = true;
        if (Intrinsics.areEqual(r12, Number.class) == false) goto L15;
        DefaultType r13 = r11.defaultValue().type();
        int r14 = a.a[r13.ordinal()];
        if (r14 == 1) goto L25;
        if (r14 == 2) goto L24;
        if (r14 == 3) goto L23;
        return Integer.valueOf(r11.defaultValue().intValue());
    L23:
        return Integer.valueOf(r11.defaultValue().intValue());
    L24:
        return Long.valueOf(r11.defaultValue().longValue());
    L25:
        return Double.valueOf(r11.defaultValue().doubleValue());
    L15:
        if (Intrinsics.areEqual(r12, Boolean.TYPE) == true) goto L18;
        r1 = Intrinsics.areEqual(r12, Boolean.class);
    L18:
        if (r1 == false) goto L21;
        return Boolean.valueOf(r11.defaultValue().boolValue());
    L21:
        return r11.defaultValue().stringValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final HashMap<String, Pair<Method, XBridgeParamField>> i(Class<? extends XBaseModel> r12, HashMap<String, Object> r13) {
        if (r12 == null) goto L130;
        Method[] r14 = r12.getDeclaredMethods();
        if (r14 == null) goto L177;
        HashMap<String, Pair<Method, XBridgeParamField>> r0 = new HashMap();
        int r1 = r14.length;
        int r10 = 0;
    L6:
        if (r10 >= r1) goto L11;
        Method r11 = r14[r10];
        XBridgeParamField r15 = r11.getAnnotation(XBridgeParamField.class);
        if (r15 == null) goto L10;
        r0.put(r15.keyPath(), new Pair(r11, r15));
    L10:
        r10 = r10 + 1;
        goto L6
    L11:
        LinkedHashMap r16 = new LinkedHashMap();
        Iterator<Map.Entry<String, Pair<Method, XBridgeParamField>>> r17 = r0.entrySet().iterator();
    L12:
        boolean r18 = true;
        if (r17.hasNext() == false) goto L22;
        Map.Entry<String, Pair<Method, XBridgeParamField>> r19 = r17.next();
        if (r13.get(r19.getKey()) == null) goto L17;
    L19:
        r18 = false;
    L20:
        if (r18 == false) goto L12;
        r16.put(r19.getKey(), r19.getValue());
        goto L12
    L17:
        if (((XBridgeParamField) r19.getValue().getSecond()).defaultValue().type() == DefaultType.NONE) goto L19;
    L22:
        Iterator r110 = r16.entrySet().iterator();
    L24:
        if (r110.hasNext() == false) goto L26;
        Map.Entry r20 = (Map.Entry) r110.next();
        r13.put(r20.getKey(), h((Method) ((Pair) r20.getValue()).getFirst(), (XBridgeParamField) ((Pair) r20.getValue()).getSecond()));
        goto L24
    L26:
        Iterator<Map.Entry<String, Pair<Method, XBridgeParamField>>> r111 = r0.entrySet().iterator();
    L28:
        if (r111.hasNext() == false) goto L129;
        Map.Entry<String, Pair<Method, XBridgeParamField>> r21 = r111.next();
        XBridgeParamField r22 = (XBridgeParamField) r21.getValue().getSecond();
        Method r23 = (Method) r21.getValue().getFirst();
        Object r24 = r13.get(r21.getKey());
        if (r22.required() == false) goto L35;
        if (r24 != null) goto L35;
        throw new IllegalInputParamException(r21.getKey() + " param is missing from input");
    L35:
        Class<?> r25 = r23.getReturnType();
        if (Intrinsics.areEqual(r25, String.class) == false) goto L44;
        if (r24 != null) goto L39;
    L78:
        if (r24 == null) goto L28;
        if (r22.isEnum() == false) goto L28;
        Class<?> r26 = r23.getReturnType();
        if (Intrinsics.areEqual(r26, String.class) == true) goto L83;
        if (Intrinsics.areEqual(r26, Number.class) == true) goto L90;
        if (Intrinsics.areEqual(r26, Map.class) == false) goto L28;
        XBridgeStringEnum r27 = r23.getAnnotation(XBridgeStringEnum.class);
        if (r27 != null) goto L99;
        XBridgeIntEnum r28 = r23.getAnnotation(XBridgeIntEnum.class);
        if (r28 == null) goto L28;
        int[] r29 = r28.option();
        Map r30 = (Map) r24;
        if (r30.isEmpty() == true) goto L124;
        Iterator r31 = r30.entrySet().iterator();
    L120:
        if (r31.hasNext() == false) goto L124;
        if ((!ArraysKt.contains(r29, f(((Map.Entry) r31.next()).getValue()))) == false) goto L120;
        boolean r32 = true;
    L125:
        if (r32 == false) goto L28;
        throw new IllegalInputParamException(r21.getKey() + " has wrong value.should be one of " + ArraysKt.asList(r29) + " but got " + r24);
    L124:
        r32 = false;
        goto L125
    L99:
        String[] r33 = r27.option();
        Map r34 = (Map) r24;
        if (r34.isEmpty() == true) goto L108;
        Iterator r35 = r34.entrySet().iterator();
    L104:
        if (r35.hasNext() == false) goto L108;
        if ((!ArraysKt.contains(r33, ((Map.Entry) r35.next()).getValue())) == false) goto L104;
        boolean r36 = true;
    L109:
        if (r36 == false) goto L28;
        throw new IllegalInputParamException(r21.getKey() + " has wrong type.should be one of " + ArraysKt.asList(r33) + " but got " + r24);
    L108:
        r36 = false;
        goto L109
    L90:
        int[] r37 = r23.getAnnotation(XBridgeIntEnum.class).option();
        if (ArraysKt.contains(r37, f(r24)) == true) goto L28;
        throw new IllegalInputParamException(r21.getKey() + " has wrong value.should be one of " + ArraysKt.asList(r37) + " but got " + r24);
    L83:
        String[] r38 = r23.getAnnotation(XBridgeStringEnum.class).option();
        if (ArraysKt.contains(r38, r24) == true) goto L28;
        throw new IllegalInputParamException(r21.getKey() + " has wrong type.should be one of " + ArraysKt.asList(r38) + " but got " + r24);
    L39:
        if ((r24 instanceof String) == true) goto L78;
        throw new IllegalInputParamException(r21.getKey() + " param has wrong declared type. except string,but " + r24.getClass());
    L44:
        if (Intrinsics.areEqual(r25, Number.class) == false) goto L52;
        if (r24 == null) goto L78;
        if ((r24 instanceof Number) == true) goto L78;
        throw new IllegalInputParamException(r21.getKey() + " param has wrong declared type. except number,but " + r24.getClass());
    L52:
        if (Intrinsics.areEqual(r25, Boolean.class) == false) goto L54;
        boolean r39 = true;
    L55:
        if (r39 == false) goto L63;
        if (r24 == null) goto L78;
        if ((r24 instanceof Boolean) == true) goto L78;
        throw new IllegalInputParamException(r21.getKey() + " param has wrong declared type. except boolean,but " + r24.getClass());
    L63:
        if (Intrinsics.areEqual(r25, List.class) == false) goto L71;
        if (r24 == null) goto L78;
        if ((r24 instanceof List) == true) goto L78;
        throw new IllegalInputParamException(r21.getKey() + " param has wrong declared type. except List ,but " + r24.getClass());
    L71:
        if (Intrinsics.areEqual(r25, Map.class) == false) goto L78;
        if (r24 == null) goto L78;
        if ((r24 instanceof Map) == true) goto L78;
        throw new IllegalInputParamException(r21.getKey() + " param has wrong declared type. except Map ,but " + r24.getClass());
    L54:
        r39 = Intrinsics.areEqual(r25, Boolean.TYPE);
        goto L55
    L129:
        return r0;
    L177:
        return null;
    L130:
        return null;
    }

    public final Object j(Class<? extends XBaseModel> r10, HashMap<String, Object> r11) throws IllegalInputParamException {
        if (r10 != null) goto L6;
        return null;
    L6:
        if (i(r10, r11) != null) goto L9;
        return null;
    L9:
        return Proxy.newProxyInstance(r10.getClassLoader(), new Class[]{r10}, new b(this, r10, r11));
    }

    public final Map<String, Object> k(ReadableMap r10, Class<? extends IDLXBridgeMethod> r11) throws IllegalInputParamException {
        Intrinsics.checkNotNullParameter(r10, "params");
        Intrinsics.checkNotNullParameter(r11, "clazz");
        me7.f r12 = (me7.f) o.a.get(r11);
        if (r12 == null) goto L11;
        int r13 = i.a;
        HashMap r14 = r10.toHashMap();
        Intrinsics.checkNotNullParameter(r14, "params");
        Intrinsics.checkNotNullParameter(r12, "clazz");
        me7.g r15 = i.e(r12.c, r14);
        if (r15 == null) goto L33;
        LinkedHashMap r16 = new LinkedHashMap(MapsKt.mapCapacity(r14.size()));
        Iterator r17 = r14.entrySet().iterator();
    L9:
        if (r17.hasNext() == false) goto L35;
        Map.Entry r0 = (Map.Entry) r17.next();
        r16.put(r0.getKey(), i.a(r0.getValue(), (me7.i) r15.b.get(r0.getKey()), r12));
        goto L9
    L35:
        return r16;
    L33:
        return null;
    L11:
        Class<? extends XBaseModel> r1 = l.a(r11);
        if (r1 != null) goto L16;
        r1 = id7.e.c(r11);
        if (r1 != null) goto L16;
        return null;
    L16:
        HashMap<String, Object> r18 = r10.toHashMap();
        HashMap<String, Pair<Method, XBridgeParamField>> r19 = i(r1, r18);
        if (r19 == null) goto L34;
        LinkedHashMap r20 = new LinkedHashMap(MapsKt.mapCapacity(r18.size()));
        Iterator<T> r21 = r18.entrySet().iterator();
    L21:
        if (r21.hasNext() == false) goto L28;
        Map.Entry r22 = (Map.Entry) r21.next();
        Object r23 = r22.getKey();
        Pair<Method, XBridgeParamField> r24 = r19.get(r22.getKey());
        if (r24 == null) goto L25;
        XBridgeParamField r25 = (XBridgeParamField) r24.getSecond();
    L26:
        r20.put(r23, e(r22.getValue(), r25));
        goto L21
    L25:
        r25 = null;
        goto L26
    L28:
        return r20;
    L34:
        return null;
    }

    public final Object a(Map r1, Class r10, le7.a r11) {
        Intrinsics.checkNotNullParameter(r1, "params");
        Intrinsics.checkNotNullParameter(r10, "clazz");
        Object r12 = r1.get("__jsb2__data__");
        if (r12 == null) goto L6;
        return h.e((JSONObject) r12);
    L6:
        return h.f(r1);
    }

    public final Map c(Object r10, Class r11, String r12) {
        ReadableMap r13 = (ReadableMap) r10;
        Intrinsics.checkNotNullParameter(r13, "params");
        Intrinsics.checkNotNullParameter(r11, "clazz");
        Intrinsics.checkNotNullParameter(r12, "nameSpace");
        return k(r13, r11);
    }
}
