package org.apache.logging.log4j.util;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes6.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final int f17936a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Method f17937b = null;
    private static final o c = null;
    private static final Class<?> d = null;

    static {
        int r0 = -1;
        Method r1 = null;
        Class<?> r2 = g.a("sun.reflect.Reflection");     // Catch: Throwable -> L12
        Method r3 = r2.getDeclaredMethod("getCallerClass", new Class[]{Integer.TYPE});     // Catch: Throwable -> L12
        Object r5 = r3.invoke(null, new Object[]{0});     // Catch: Throwable -> L12
        r3.invoke(null, new Object[]{0});     // Catch: Throwable -> L12
        if (r5 == null) goto L13;
        if (r5 != r2) goto L13;
        if (r3.invoke(null, new Object[]{1}) != r2) goto L11;
        System.out.println("WARNING: Unexpected result from sun.reflect.Reflection.getCallerClass(int), adjusting offset for future calls.");     // Catch: Throwable -> L12
        r1 = r3;
        r0 = 1;
        goto L13
    L11:
        r1 = r3;
        r0 = 0;
    L13:
        f17937b = r1;
        f17936a = r0;
        c = new o();
        return;
    L12:
        System.out.println("WARNING: sun.reflect.Reflection.getCallerClass is not supported. This will impact performance.");
        goto L13
    }

    private o() {
    }

    public static o a() {
        return c;
    }

    public Class<?> a(int r5) {
        if (r5 < 0) goto L13;
        Method r4 = f17937b;
        if (r4 != null) goto L14;
        return d;
    L14:
        return (Class) ZeusTransformUtils.preCheckCast(r4.invoke(null, new Object[]{Integer.valueOf((r5 + 1) + f17936a)}), Class.class, "com.obric.memorydata.plugin");
    L11:
        return d;
    L13:
        throw new IndexOutOfBoundsException(Integer.toString(r5));
    }

    public StackTraceElement a(String r6) {
        if (r6 != null) goto L5;
        return null;
    L5:
        StackTraceElement[] r0 = new Throwable().getStackTrace();
        int r1 = 0;
        boolean r2 = false;
    L7:
        if (r1 >= r0.length) goto L17;
        String r3 = r0[r1].getClassName();
        if (r6.equals(r3) == false) goto L11;
        r2 = true;
    L16:
        r1 = r1 + 1;
        goto L7
    L11:
        if (r2 == false) goto L16;
        if (r6.equals(r3) == true) goto L16;
        return r0[r1];
    L17:
        return null;
    }
}
