package com.google.common.primitives;

import com.google.common.base.n;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Map<Class<?>, Class<?>> f4767a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Map<Class<?>, Class<?>> f4768b = null;

    static {
        LinkedHashMap r0 = new LinkedHashMap(16);
        LinkedHashMap r2 = new LinkedHashMap(16);
        a(r0, r2, Boolean.TYPE, Boolean.class);
        a(r0, r2, Byte.TYPE, Byte.class);
        a(r0, r2, Character.TYPE, Character.class);
        a(r0, r2, Double.TYPE, Double.class);
        a(r0, r2, Float.TYPE, Float.class);
        a(r0, r2, Integer.TYPE, Integer.class);
        a(r0, r2, Long.TYPE, Long.class);
        a(r0, r2, Short.TYPE, Short.class);
        a(r0, r2, Void.TYPE, Void.class);
        f4767a = Collections.unmodifiableMap(r0);
        f4768b = Collections.unmodifiableMap(r2);
    }

    public static <T> Class<T> a(Class<T> r3) {
        n.a(r3);
        Class<T> r0 = (Class) ZeusTransformUtils.preCheckCast(f4767a.get(r3), Class.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L6;
        return r3;
    L6:
        return r0;
    }

    public static Set<Class<?>> a() {
        return f4768b.keySet();
    }

    private static void a(Map<Class<?>, Class<?>> r2, Map<Class<?>, Class<?>> r3, Class<?> r4, Class<?> r5) {
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin");
        Map r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        r6.put(r4, r5);
        r7.put(r5, r4);
    }

    public static <T> Class<T> b(Class<T> r3) {
        n.a(r3);
        Class<T> r0 = (Class) ZeusTransformUtils.preCheckCast(f4768b.get(r3), Class.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L6;
        return r3;
    L6:
        return r0;
    }
}
