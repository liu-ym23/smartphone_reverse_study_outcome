package com.google.common.hash;

import sun.misc.Unsafe;

/* JADX INFO: loaded from: classes2.dex */
public final class c0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Unsafe f9279b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final long f9280c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile long f9281a;

    static {
        Unsafe r5 = Striped64.access$000();     // Catch: Exception -> L4
        f9279b = r5;     // Catch: Exception -> L4
        f9280c = r5.objectFieldOffset(c0.class.getDeclaredField("a"));     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        throw new Error(e);
    }

    public c0(long r5) {
        this.f9281a = r5;
    }

    public final boolean a(long r10, long r11) {
        return f9279b.compareAndSwapLong(this, f9280c, r10, r11);
    }
}
