package com.google.common.util.concurrent;

import java.security.AccessController;
import java.security.PrivilegedActionException;
import sun.misc.Unsafe;

/* JADX INFO: loaded from: classes2.dex */
public final class m extends p0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Unsafe f9418a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final long f9419b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final long f9420c = 0;
    public static final long d = 0;
    public static final long e = 0;
    public static final long f = 0;

    static {
        Unsafe r5 = Unsafe.getUnsafe();     // Catch: SecurityException -> L5
    L14:
        f9420c = r5.objectFieldOffset(o.class.getDeclaredField("c"));     // Catch: Exception -> L8
        f9419b = r5.objectFieldOffset(o.class.getDeclaredField("b"));     // Catch: Exception -> L8
        d = r5.objectFieldOffset(o.class.getDeclaredField("a"));     // Catch: Exception -> L8
        e = r5.objectFieldOffset(n.class.getDeclaredField("a"));     // Catch: Exception -> L8
        f = r5.objectFieldOffset(n.class.getDeclaredField("b"));     // Catch: Exception -> L8
        f9418a = r5;     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        com.google.common.base.f0.a(e);
        throw new RuntimeException(e);
    L5:
        r5 = (Unsafe) AccessController.doPrivileged(new l());     // Catch: PrivilegedActionException -> L11
    L11:
        e = move-exception;
        throw new RuntimeException("Could not initialize intrinsics", e.getCause());
    }

    @Override // com.google.common.util.concurrent.p0
    public final boolean a(o r10, c r11, c r12) {
        return j.a(f9418a, r10, f9419b, r11, r12);
    }

    @Override // com.google.common.util.concurrent.p0
    public final boolean b(o r10, Object r11, Object r12) {
        return k.a(f9418a, r10, d, r11, r12);
    }

    @Override // com.google.common.util.concurrent.p0
    public final boolean c(o r10, n r11, n r12) {
        return i.a(f9418a, r10, f9420c, r11, r12);
    }

    @Override // com.google.common.util.concurrent.p0
    public final c e(o r5) {
        c r10 = c.d;
        return (c) f9418a.getAndSetObject(r5, f9419b, r10);
    }

    @Override // com.google.common.util.concurrent.p0
    public final n f(o r5) {
        n r10 = n.f9421c;
        return (n) f9418a.getAndSetObject(r5, f9420c, r10);
    }

    @Override // com.google.common.util.concurrent.p0
    public final void i(n r5, n r10) {
        f9418a.putObject(r5, f, r10);
    }

    @Override // com.google.common.util.concurrent.p0
    public final void j(n r5, Thread r10) {
        f9418a.putObject(r5, e, r10);
    }
}
