package com.bytedance.monitor.util.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Map<Class<?>, Class<?>> f2882a = null;

    static {
        HashMap r0 = new HashMap();
        f2882a = r0;
        r0.put(Boolean.class, Boolean.TYPE);
        r0.put(Byte.class, Byte.TYPE);
        r0.put(Character.class, Character.TYPE);
        r0.put(Short.class, Short.TYPE);
        r0.put(Integer.class, Integer.TYPE);
        r0.put(Float.class, Float.TYPE);
        r0.put(Long.class, Long.TYPE);
        r0.put(Double.class, Double.TYPE);
        r0.put(Boolean.TYPE, Boolean.TYPE);
        r0.put(Byte.TYPE, Byte.TYPE);
        r0.put(Character.TYPE, Character.TYPE);
        r0.put(Short.TYPE, Short.TYPE);
        r0.put(Integer.TYPE, Integer.TYPE);
        r0.put(Float.TYPE, Float.TYPE);
        r0.put(Long.TYPE, Long.TYPE);
        r0.put(Double.TYPE, Double.TYPE);
    }

    public static <T> T a(String r2, String r3, Object... r4) {
        return (T) a(ZeusTransformUtils.forName(r2, "com.obric.memorydata.plugin"), r3, a(r4)).invoke(null, r4);
    L5:
        return null;
    }

    private static Method a(Class<?> r1, String r2, Class<?>... r3) {
        Method r0 = a(r1.getDeclaredMethods(), r2, r3);
        if (r0 == null) goto L5;
        r0.setAccessible(true);
        return r0;
    L5:
        if (r1.getSuperclass() == null) goto L9;
        return a(r1.getSuperclass(), r2, r3);
    L9:
        throw new NoSuchMethodException();
    }

    private static Method a(Method[] r4, String r5, Class<?>[] r6) {
        Objects.requireNonNull(r5, "Method name is null.");
        int r0 = r4.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L10;
        Method r2 = r4[r1];
        if (r2.getName().equals(r5) == false) goto L9;
        if (a(r2.getParameterTypes(), r6) == false) goto L9;
        return r2;
    L9:
        r1 = r1 + 1;
        goto L3
    L10:
        return null;
    }

    private static boolean a(Class<?>[] r7, Class<?>[] r8) {
        if (r7 != null) goto L10;
        if (r8 != null) goto L6;
        return true;
    L6:
        if (r8.length != 0) goto L9;
        return true;
    L9:
        return false;
    L10:
        if (r8 != null) goto L17;
        if (r7.length != 0) goto L15;
        return true;
    L15:
        return false;
    L17:
        if (r7.length == r8.length) goto L19;
        return false;
    L19:
        int r2 = 0;
    L21:
        if (r2 >= r7.length) goto L30;
        if (r7[r2].isAssignableFrom(r8[r2]) == true) goto L29;
        Map<Class<?>, Class<?>> r3 = f2882a;
        if (r3.containsKey(r7[r2]) == false) goto L28;
        if (((Class) ZeusTransformUtils.preCheckCast(r3.get(r7[r2]), Class.class, "com.obric.memorydata.plugin")).equals(r3.get(r8[r2])) == true) goto L29;
    L28:
        return false;
    L29:
        r2 = r2 + 1;
        goto L21
    L30:
        return true;
    }

    private static Class<?>[] a(Object... r4) {
        if (r4 != null) goto L5;
        return null;
    L5:
        if (r4.length <= 0) goto L20;
        Class<?>[] r1 = new Class[r4.length];
        int r2 = 0;
    L8:
        if (r2 >= r4.length) goto L15;
        Object r3 = r4[r2];
        if (r3 != null) goto L12;
        Class<?> r5 = null;
    L13:
        r1[r2] = r5;
        r2 = r2 + 1;
        goto L8
    L12:
        r5 = r3.getClass();
        goto L13
    L15:
        return r1;
    L20:
        return null;
    }
}
