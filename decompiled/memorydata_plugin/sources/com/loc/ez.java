package com.loc;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes3.dex */
public final class ez {
    private static Object a(Class<?> r0, String r1, Object[] r2, Class<?>[] r3) {
        Method r4 = r0.getDeclaredMethod(r1, r3);
        if (r4.isAccessible() == true) goto L6;
        r4.setAccessible(true);
    L6:
        return r4.invoke(null, r2);
    }

    public static Object a(Object r5, Class<?> r6, String r7, Object... r8) {
        Class<?>[] r0 = new Class[r8.length];
        int r1 = r8.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L14;
        r0[r2] = r8[r2].getClass();
        if (r0[r2] != Integer.class) goto L8;
        r0[r2] = Integer.TYPE;
    L8:
        if (r0[r2] != Boolean.class) goto L11;
        r0[r2] = Boolean.TYPE;
    L11:
        if (r0[r2] != Double.class) goto L13;
        r0[r2] = Double.TYPE;
    L13:
        r2 = r2 + 1;
        goto L3
    L14:
        Method r9 = r6.getDeclaredMethod(r7, r0);
        if (r9.isAccessible() == true) goto L26;
        r9.setAccessible(true);
    L26:
        return r9.invoke(r5, r8);
    L20:
        th = move-exception;
        if (ZeusTransformUtils.instanceOf(th, InvocationTargetException.class) == false) goto L33;
        ev.a(((InvocationTargetException) ZeusTransformUtils.preCheckCast(th, InvocationTargetException.class, "com.obric.memorydata.plugin")).getTargetException(), "Reflect", "invokeMethod ".concat(String.valueOf(r7)));     // Catch: Throwable -> L25
        return null;
    L33:
        return null;
    L35:
        return null;
    }

    public static Object a(Object r1, String r2, Object... r3) {
        return a(r1, r1.getClass(), r2, r3);
    L4:
        return null;
    }

    public static Object a(String r1, String r2) {
        Class r3 = ZeusTransformUtils.forName(r1, "com.obric.memorydata.plugin");
        Field r4 = r3.getField(r2);
        r4.setAccessible(true);
        return r4.get(r3);
    }

    public static Object a(String r1, String r2, Object[] r3, Class<?>[] r4) {
        return a(ZeusTransformUtils.forName(r1, "com.obric.memorydata.plugin"), r2, r3, r4);
    }

    public static int b(Object r0, String r1, Object... r2) {
        return ((Integer) ZeusTransformUtils.preCheckCast(a(r0, r1, r2), Integer.class, "com.obric.memorydata.plugin")).intValue();
    }

    public static int b(String r1, String r2) {
        return ((Integer) ZeusTransformUtils.preCheckCast(a(r1, r2), Integer.class, "com.obric.memorydata.plugin")).intValue();
    }
}
