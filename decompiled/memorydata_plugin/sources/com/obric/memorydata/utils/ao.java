package com.obric.memorydata.utils;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public class ao {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Map<Class<?>, Class<?>> f13172a = null;

    static {
        HashMap r0 = new HashMap();
        f13172a = r0;
        r0.put(Byte.TYPE, Byte.class);
        r0.put(Short.TYPE, Short.class);
        r0.put(Integer.TYPE, Integer.class);
        r0.put(Long.TYPE, Long.class);
        r0.put(Float.TYPE, Float.class);
        r0.put(Double.TYPE, Double.class);
        r0.put(Character.TYPE, Character.class);
        r0.put(Boolean.TYPE, Boolean.class);
    }

    public static Object a(Class<?> r0, String r1) {
        Field r2 = r0.getDeclaredField(r1);
        r2.setAccessible(true);
        return r2.get(null);
    }

    public static <T> T a(Class<T> r4, Object... r5) {
        return r4.cast(a(r4, a(r5)).newInstance(r5));
    L4:
        e = move-exception;
        throw new RuntimeException(String.format("Cannot invoke constructor of \"%s\" with parameters %s.", new Object[]{r4.getCanonicalName(), Arrays.toString(r5)}), e);
    }

    public static Object a(Object r1, String r2) {
        Field r3 = r1.getClass().getDeclaredField(r2);
        r3.setAccessible(true);
        return r3.get(r1);
    }

    private static Constructor<?> a(Class<?> r8, Class<?>[] r9) {
        return r8.getConstructor(r9);
    L4:
        e = move-exception;
        Constructor<?>[] r1 = r8.getConstructors();
        int r2 = r1.length;
        int r4 = 0;
    L6:
        if (r4 >= r2) goto L14;
        Constructor<?> r5 = r1[r4];
        if (r5.getParameterCount() != r9.length) goto L12;
        if (a(r5.getParameterTypes(), r9) == false) goto L12;
        return r5;
    L12:
        r4 = r4 + 1;
        goto L6
    L14:
        throw new RuntimeException(String.format("Cannot find constructor of \"%s\" with parameter types %s.", new Object[]{r8.getCanonicalName(), Arrays.toString(r9)}), e);
    }

    public static Method a(Class<?> r8, String r9, Class<?>[] r10) {
        return r8.getMethod(r9, r10);
    L4:
        e = move-exception;
        Method[] r1 = r8.getMethods();
        int r2 = r1.length;
        int r4 = 0;
    L6:
        if (r4 >= r2) goto L16;
        Method r5 = r1[r4];
        if (r5.getName().equals(r9) == false) goto L14;
        if (r5.getParameterCount() != r10.length) goto L14;
        if (a(r5.getParameterTypes(), r10) == false) goto L14;
        return r5;
    L14:
        r4 = r4 + 1;
        goto L6
    L16:
        throw new RuntimeException(String.format("Cannot find method \"%s\" of \"%s\" with parameter types %s.", new Object[]{r9, r8.getCanonicalName(), Arrays.toString(r10)}), e);
    }

    public static boolean a(Class<?> r1) {
        return f13172a.containsKey(r1);
    }

    private static boolean a(Class<?> r0, Class<?> r1) {
        return b(r0).isAssignableFrom(b(r1));
    }

    private static boolean a(Class<?>[] r4, Class<?>[] r5) {
        if (r4.length != r5.length) goto L13;
        int r0 = 0;
    L6:
        if (r0 >= r4.length) goto L11;
        if (a(r4[r0], r5[r0]) == false) goto L9;
        r0 = r0 + 1;
        goto L6
    L9:
        return false;
    L11:
        return true;
    L13:
        return false;
    }

    private static /* synthetic */ Class[] a(int r0) {
        return new Class[r0];
    }

    private static Class<?>[] a(Object... r2) {
        return (Class[]) ZeusTransformUtils.preCheckCast(Arrays.stream(r2).map($$Lambda$ao$rHUyTXF3WwDhksPJwq4lmTN5I.INSTANCE).toArray($$Lambda$ao$B2kMMsfmWlT0cIqnB_BDXUdcM9I.INSTANCE), Class[].class, "com.obric.memorydata.plugin");
    }

    public static Class<?> b(Class<?> r2) {
        if (a(r2) == true) goto L6;
        return r2;
    L6:
        return (Class) ZeusTransformUtils.preCheckCast(f13172a.get(r2), Class.class, "com.obric.memorydata.plugin");
    }

    public static <T> T call(Class<?> r5, String r6, Object... r7) {
        Method r1 = a(r5, r6, a(r7));     // Catch: Exception -> L5
        r1.setAccessible(true);     // Catch: Exception -> L5
        return (T) r1.invoke(null, r7);
    L5:
        e = move-exception;
        throw new RuntimeException(String.format("Cannot invoke static method \"%s\" of \"%s\" with parameters %s.", new Object[]{r6, r5.getCanonicalName(), Arrays.toString(r7)}), e);
    }

    public static <T> T call(Object r5, String r6, Object... r7) {
        Method r1 = a(r5.getClass(), r6, a(r7));     // Catch: Exception -> L5
        r1.setAccessible(true);     // Catch: Exception -> L5
        return (T) r1.invoke(r5, r7);
    L5:
        e = move-exception;
        throw new RuntimeException(String.format("Cannot invoke method \"%s\" of \"%s\" with parameters %s.", new Object[]{r6, r5.getClass().getCanonicalName(), Arrays.toString(r7)}), e);
    }

    public static /* synthetic */ Class[] lambda$B2kMMsfmWlT0cIqnB_BDXUdcM9I(int r0) {
        return a(r0);
    }

    /* JADX INFO: renamed from: lambda$rHUyT--XF3WwDhksPJwq4lmTN5I, reason: not valid java name */
    public static /* synthetic */ Class m1242lambda$rHUyTXF3WwDhksPJwq4lmTN5I(Object r0) {
        return r0.getClass();
    }
}
