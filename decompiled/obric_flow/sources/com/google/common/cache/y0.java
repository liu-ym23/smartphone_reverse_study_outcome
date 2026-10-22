package com.google.common.cache;

import sun.misc.Unsafe;

/* JADX INFO: loaded from: classes2.dex */
public final class y0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Unsafe f8780b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final long f8781c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile long f8782a;

    static {
        Unsafe r5 = Striped64.access$000();     // Catch: Exception -> L4
        f8780b = r5;     // Catch: Exception -> L4
        f8781c = r5.objectFieldOffset(y0.class.getDeclaredField("a"));     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        throw new Error(e);
    }

    public y0(long r5) {
        this.f8782a = r5;
    }

    public final boolean a(long r10, long r11) {
        return f8780b.compareAndSwapLong(this, f8781c, r10, r11);
    }
}
