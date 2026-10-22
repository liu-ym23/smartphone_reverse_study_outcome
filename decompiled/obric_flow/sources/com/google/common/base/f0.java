package com.google.common.base;

import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public abstract class f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Object f8657a = null;

    static {
        Method r5 = null;
        Object r10 = Class.forName("sun.misc.SharedSecrets", false, null).getMethod("getJavaLangAccess", null).invoke(null, null);     // Catch: ThreadDeath -> L5 Throwable -> L7
    L8:
        f8657a = r10;
        if (r10 != null) goto L34;
    L16:
        if (r10 == null) goto L40;
        r5 = Class.forName("sun.misc.JavaLangAccess", false, null).getMethod("getStackTraceDepth", new Class[]{Throwable.class});     // Catch: ThreadDeath -> L21 Throwable -> L31
    L21:
        e = move-exception;
        throw e;     // Catch: Throwable -> L32 Throwable -> L32 Throwable -> L32
    L23:
        if (r5 == null) goto L41;
        r5.invoke(r10, new Object[]{new Throwable()});     // Catch: Throwable -> L32 Throwable -> L32 Throwable -> L32
        return;
    L41:
        return;
    L42:
        return;
    L40:
        return;
    L34:
        Class.forName("sun.misc.JavaLangAccess", false, null).getMethod("getStackTraceElement", new Class[]{Throwable.class, Integer.TYPE});     // Catch: ThreadDeath -> L14 Throwable -> L30
    L14:
        e = move-exception;
        throw e;
    L5:
        e = move-exception;
        throw e;
    L7:
        r10 = null;
        goto L8
    }

    public static void a(Exception r5) {
        if ((r5 instanceof RuntimeException) == true) goto L6;
        return;
    L6:
        throw ((RuntimeException) r5);
    }
}
