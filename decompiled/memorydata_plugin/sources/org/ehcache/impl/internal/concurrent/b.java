package org.ehcache.impl.internal.concurrent;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Field;
import java.security.AccessController;
import java.util.concurrent.ThreadLocalRandom;
import sun.misc.Unsafe;

/* JADX INFO: loaded from: classes7.dex */
class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final Unsafe f18089a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final long f18090b = 0;

    static {
        Unsafe r0 = a();
        f18089a = r0;
        f18090b = r0.objectFieldOffset(Thread.class.getDeclaredField("threadLocalRandomProbe"));     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        throw new Error(e);
    }

    static final int a(int r4) {
        int r5 = r4 ^ (r4 << 13);
        int r6 = r5 ^ (r5 >>> 17);
        int r7 = r6 ^ (r6 << 5);
        f18089a.putInt(Thread.currentThread(), f18090b, r7);
        return r7;
    }

    private static String a(Object r0) {
        if (r0 == null) goto L5;
        String r1 = r0.toString();
        if (r1 == null) goto L5;
        return r1;
    L5:
        return "null";
    }

    static String a(Object r4, Object r5) {
        String r6 = a(r4);
        int r0 = r6.length();
        String r7 = a(r5);
        int r1 = r7.length();
        char[] r2 = new char[(r0 + r1) + 1];
        r6.getChars(0, r0, r2, 0);
        r2[r0] = '=';
        r7.getChars(0, r1, r2, r0 + 1);
        return new String(r2);
    }

    static Unsafe a() {
        return Unsafe.getUnsafe();
    L4:
        return (Unsafe) ZeusTransformUtils.preCheckCast(AccessController.doPrivileged($$Lambda$b$y8vMVFAkLZoJfk616zNjolJ3tc.INSTANCE), Unsafe.class, "com.obric.memorydata.plugin");
    L6:
        e = move-exception;
        throw new RuntimeException("Could not initialize intrinsics", e.getCause());
    }

    static final int b() {
        return f18089a.getInt(Thread.currentThread(), f18090b);
    }

    static final void c() {
        ThreadLocalRandom.current();
    }

    private static /* synthetic */ Unsafe d() {
        Field[] r1 = Unsafe.class.getDeclaredFields();
        int r2 = r1.length;
        int r3 = 0;
    L3:
        if (r3 >= r2) goto L10;
        Field r4 = r1[r3];
        r4.setAccessible(true);
        Object r5 = r4.get(null);
        if (ZeusTransformUtils.instanceOf(Unsafe.class, r5) == true) goto L7;
        r3 = r3 + 1;
        goto L3
    L7:
        return (Unsafe) ZeusTransformUtils.preCheckCast(Unsafe.class.cast(r5), Unsafe.class, "com.obric.memorydata.plugin");
    L10:
        throw new NoSuchFieldError("the Unsafe");
    }

    /* JADX INFO: renamed from: lambda$y-8vMVFAkLZoJfk616zNjolJ3tc, reason: not valid java name */
    public static /* synthetic */ Unsafe m3201lambda$y8vMVFAkLZoJfk616zNjolJ3tc() {
        return d();
    }
}
