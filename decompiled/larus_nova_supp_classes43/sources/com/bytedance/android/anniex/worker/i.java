package com.bytedance.android.anniex.worker;

import com.bytedance.sdk.xbridge.cn.registry.core.annotation.DefaultType;
import com.bytedance.sdk.xbridge.cn.registry.core.exception.IllegalInputParamException;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseModel;
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
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class i {
    public static final /* synthetic */ int a = 0;

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
        public final /* synthetic */ HashMap<String, Object> a;
        public final /* synthetic */ me7.f b;
        public final /* synthetic */ Class<? extends XBaseModel> c;
        public final /* synthetic */ me7.g d;

        public b(HashMap<String, Object> r1, me7.f r10, Class<? extends XBaseModel> r11, me7.g r12) {
            this.a = r1;
            this.b = r10;
            this.c = r11;
            this.d = r12;
        }

        @Override // java.lang.reflect.InvocationHandler
        public final Object invoke(Object r1, Method r10, Object[] r11) {
            if (Intrinsics.areEqual(r10.getName(), "toJSON") == false) goto L6;
            int r12 = i.a;
            return new JSONObject(i.c(this.a, (me7.g) this.b.e.get(this.c), this.b));
        L6:
            me7.i r13 = (me7.i) this.d.a.get(r10);
            HashMap<String, Object> r14 = this.a;
            if (r13 == null) goto L9;
            String r15 = r13.b;
        L10:
            Object r16 = r14.get(r15);
            int r17 = i.a;
            return i.a(r16, r13, this.b);
        L9:
            r15 = null;
            goto L10
        }
    }

    static {
    }

    public static int b(Object r1) {
        if ((r1 instanceof Number) == true) goto L5;
        if (r1 != null) goto L10;
        throw new IllegalInputParamException("the key is null");
    L10:
        throw new IllegalInputParamException("the key is not a number");
    L5:
        return ((Number) r1).intValue();
    }

    public static Object d(Class r10, me7.i r11) {
        boolean r1 = true;
        if (Intrinsics.areEqual(r10, Number.class) == false) goto L15;
        DefaultType r12 = r11.g.getType();
        int r13 = a.a[r12.ordinal()];
        if (r13 == 1) goto L25;
        if (r13 == 2) goto L24;
        if (r13 == 3) goto L23;
        return Integer.valueOf(r11.g.d);
    L23:
        return Integer.valueOf(r11.g.d);
    L24:
        return Long.valueOf(r11.g.f);
    L25:
        return Double.valueOf(r11.g.b);
    L15:
        if (Intrinsics.areEqual(r10, Boolean.TYPE) == true) goto L18;
        r1 = Intrinsics.areEqual(r10, Boolean.class);
    L18:
        if (r1 == false) goto L21;
        return Boolean.valueOf(r11.g.e);
    L21:
        return r11.g.c;
    }

    public static me7.g e(me7.g r11, HashMap r12) {
        if (r11 != null) goto L5;
        return null;
    L5:
        HashMap r0 = r11.b;
        LinkedHashMap r1 = new LinkedHashMap();
        Iterator r10 = r0.entrySet().iterator();
    L6:
        boolean r13 = false;
        if (r10.hasNext() == false) goto L15;
        Map.Entry r14 = (Map.Entry) r10.next();
        if (r12.get(r14.getKey()) == null) goto L11;
    L13:
        if (r13 == false) goto L6;
        r1.put(r14.getKey(), r14.getValue());
        goto L6
    L11:
        if (((me7.i) r14.getValue()).g.getType() == DefaultType.NONE) goto L13;
        r13 = true;
        goto L13
    L15:
        Iterator r15 = r1.entrySet().iterator();
    L17:
        if (r15.hasNext() == false) goto L19;
        Map.Entry r16 = (Map.Entry) r15.next();
        me7.i r17 = (me7.i) r16.getValue();
        r12.put(r16.getKey(), d(r17.h, r17));
        goto L17
    L19:
        Iterator r18 = r11.b.entrySet().iterator();
    L21:
        if (r18.hasNext() == false) goto L122;
        Map.Entry r19 = (Map.Entry) r18.next();
        String r20 = (String) r19.getKey();
        me7.i r21 = (me7.i) r19.getValue();
        Object r22 = r12.get(r20);
        if (r21.a == false) goto L28;
        if (r22 != null) goto L28;
        throw new IllegalInputParamException(((String) r19.getKey()) + " param is missing from input");
    L28:
        Class r23 = r21.h;
        if (Intrinsics.areEqual(r23, String.class) == false) goto L37;
        if (r22 != null) goto L32;
    L71:
        if (r22 == null) goto L21;
        if (r21.e == false) goto L21;
        Class r24 = r21.h;
        if (Intrinsics.areEqual(r24, String.class) == true) goto L76;
        if (Intrinsics.areEqual(r24, Number.class) == true) goto L83;
        if (Intrinsics.areEqual(r24, Map.class) == false) goto L21;
        List r25 = r21.i;
        if ((!r25.isEmpty()) == true) goto L92;
        List r26 = r21.j;
        if ((!r26.isEmpty()) == false) goto L21;
        Map r27 = (Map) r22;
        if (r27.isEmpty() == true) goto L117;
        Iterator r28 = r27.entrySet().iterator();
    L113:
        if (r28.hasNext() == false) goto L117;
        if ((!r26.contains(Integer.valueOf(b(((Map.Entry) r28.next()).getValue())))) == false) goto L113;
        boolean r29 = true;
    L118:
        if (r29 == false) goto L21;
        throw new IllegalInputParamException(((String) r19.getKey()) + " has wrong value.should be one of " + r26 + " but got " + r22);
    L117:
        r29 = false;
        goto L118
    L92:
        Map r30 = (Map) r22;
        if (r30.isEmpty() == true) goto L101;
        Iterator r31 = r30.entrySet().iterator();
    L97:
        if (r31.hasNext() == false) goto L101;
        if ((!CollectionsKt.contains(r25, ((Map.Entry) r31.next()).getValue())) == false) goto L97;
        boolean r32 = true;
    L102:
        if (r32 == false) goto L21;
        throw new IllegalInputParamException(((String) r19.getKey()) + " has wrong type.should be one of " + r25 + " but got " + r22);
    L101:
        r32 = false;
        goto L102
    L83:
        List r33 = r21.j;
        if (r33.contains(Integer.valueOf(b(r22))) == true) goto L21;
        throw new IllegalInputParamException(((String) r19.getKey()) + " has wrong value.should be one of " + r33 + " but got " + r22);
    L76:
        List r34 = r21.i;
        if (CollectionsKt.contains(r34, r22) == true) goto L21;
        throw new IllegalInputParamException(((String) r19.getKey()) + " has wrong type.should be one of " + r34 + " but got " + r22);
    L32:
        if ((r22 instanceof String) == true) goto L71;
        throw new IllegalInputParamException(((String) r19.getKey()) + " param has wrong declared type. except string,but " + r22.getClass());
    L37:
        if (Intrinsics.areEqual(r23, Number.class) == false) goto L45;
        if (r22 == null) goto L71;
        if ((r22 instanceof Number) == true) goto L71;
        throw new IllegalInputParamException(((String) r19.getKey()) + " param has wrong declared type. except number,but " + r22.getClass());
    L45:
        if (Intrinsics.areEqual(r23, Boolean.class) == false) goto L47;
        boolean r35 = true;
    L48:
        if (r35 == false) goto L56;
        if (r22 == null) goto L71;
        if ((r22 instanceof Boolean) == true) goto L71;
        throw new IllegalInputParamException(((String) r19.getKey()) + " param has wrong declared type. except boolean,but " + r22.getClass());
    L56:
        if (Intrinsics.areEqual(r23, List.class) == false) goto L64;
        if (r22 == null) goto L71;
        if ((r22 instanceof List) == true) goto L71;
        throw new IllegalInputParamException(((String) r19.getKey()) + " param has wrong declared type. except List ,but " + r22.getClass());
    L64:
        if (Intrinsics.areEqual(r23, Map.class) == false) goto L71;
        if (r22 == null) goto L71;
        if ((r22 instanceof Map) == true) goto L71;
        throw new IllegalInputParamException(((String) r19.getKey()) + " param has wrong declared type. except Map ,but " + r22.getClass());
    L47:
        r35 = Intrinsics.areEqual(r23, Boolean.TYPE);
        goto L48
    L122:
        return r11;
    }

    public static Object a(Object r10, me7.i r11, me7.f r12) {
        boolean r1 = false;
        Class r13 = null;
        if ((r10 instanceof Map) == false) goto L10;
        if (r11 == null) goto L6;
        KClass r0 = r11.c;
    L8:
        if (Intrinsics.areEqual(r0, Reflection.getOrCreateKotlinClass(XBaseModel.a.class)) == true) goto L10;
        boolean r14 = true;
    L12:
        if (r14 == false) goto L19;
        if (r11 == null) goto L17;
        KClass r15 = r11.c;
        if (r15 == null) goto L17;
        r13 = JvmClassMappingKt.getJavaClass(r15);
    L17:
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type com.bytedance.vmsdk.jsbridge.utils.ReadableMap");
        return f(r13, ((ReadableMap) r10).toHashMap(), r12);
    L19:
        if ((r10 instanceof List) == false) goto L26;
        if (r11 == null) goto L22;
        KClass r16 = r11.c;
    L24:
        if (Intrinsics.areEqual(r16, Reflection.getOrCreateKotlinClass(XBaseModel.a.class)) == true) goto L26;
        r1 = true;
        goto L26
    L22:
        r16 = null;
    L26:
        if (r1 == false) goto L38;
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type kotlin.collections.List<*>");
        List r17 = (List) r10;
        ArrayList r18 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r17, 10));
        Iterator r19 = r17.iterator();
    L29:
        if (r19.hasNext() == false) goto L44;
        Object r20 = r19.next();
        if (r11 == null) goto L35;
        KClass r21 = r11.c;
        if (r21 == null) goto L35;
        Class r22 = JvmClassMappingKt.getJavaClass(r21);
    L36:
        Intrinsics.checkNotNull(r20, "null cannot be cast to non-null type com.bytedance.vmsdk.jsbridge.utils.ReadableMap");
        r18.add(f(r22, ((ReadableMap) r20).toHashMap(), r12));
    L35:
        r22 = null;
        goto L36
    L44:
        return r18;
    L38:
        h.a.getClass();
        return h.h(r10);
    L6:
        r0 = null;
    L10:
        r14 = false;
        goto L12
    }

    public static Map c(HashMap r10, me7.g r11, me7.f r12) {
        if (r11 != null) goto L5;
        return null;
    L5:
        HashMap r13 = r11.b;
        LinkedHashMap r0 = new LinkedHashMap(MapsKt.mapCapacity(r13.size()));
        Iterator r14 = r13.entrySet().iterator();
    L7:
        if (r14.hasNext() == false) goto L29;
        Map.Entry r1 = (Map.Entry) r14.next();
        Object r15 = r1.getKey();
        Object r16 = r10.get(((me7.i) r1.getValue()).b);
        if (r16 != null) goto L14;
        if (((me7.i) r1.getValue()).g.getType() == DefaultType.NONE) goto L14;
        Object r17 = d(((me7.i) r1.getValue()).h, (me7.i) r1.getValue());
        r10.put(((me7.i) r1.getValue()).b, r17);
    L14:
        if (Intrinsics.areEqual(((me7.i) r1.getValue()).c, Reflection.getOrCreateKotlinClass(XBaseModel.a.class)) == true) goto L19;
        if ((r16 instanceof ReadableMap) == false) goto L19;
        HashMap r18 = ((ReadableMap) r16).toHashMap();
        Object r19 = r12.e.get(JvmClassMappingKt.getJavaClass(((me7.i) r1.getValue()).c));
        Intrinsics.checkNotNull(r19);
        Object r20 = c(r18, (me7.g) r19, r12);
    L28:
        r0.put(r15, r20);
    L19:
        if (Intrinsics.areEqual(((me7.i) r1.getValue()).c, Reflection.getOrCreateKotlinClass(XBaseModel.a.class)) == false) goto L21;
    L27:
        r20 = r10.get(((me7.i) r1.getValue()).b);
        goto L28
    L21:
        if ((r16 instanceof ReadableArray) == false) goto L27;
        ArrayList r21 = ((ReadableArray) r16).toArrayList();
        ArrayList r22 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r21, 10));
        Iterator r23 = r21.iterator();
    L24:
        if (r23.hasNext() == false) goto L26;
        Object r24 = r23.next();
        Intrinsics.checkNotNull(r24, "null cannot be cast to non-null type com.bytedance.vmsdk.jsbridge.utils.ReadableMap");
        HashMap r25 = ((ReadableMap) r24).toHashMap();
        Object r26 = r12.e.get(JvmClassMappingKt.getJavaClass(((me7.i) r1.getValue()).c));
        Intrinsics.checkNotNull(r26);
        r22.add(c(r25, (me7.g) r26, r12));
        goto L24
    L26:
        r20 = r22;
        goto L28
    L29:
        return r0;
    }

    public static Object f(Class r10, HashMap r11, me7.f r12) throws IllegalInputParamException {
        if (r10 != null) goto L5;
        return null;
    L5:
        me7.g r1 = e((me7.g) r12.e.get(r10), r11);
        if (r1 != null) goto L9;
        return null;
    L9:
        return Proxy.newProxyInstance(r10.getClassLoader(), new Class[]{r10}, new b(r11, r12, r10, r1));
    }
}
