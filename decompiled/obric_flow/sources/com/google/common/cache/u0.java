package com.google.common.cache;

/* JADX INFO: loaded from: classes2.dex */
public abstract class u0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final com.google.common.base.e0 f8770a = null;

    static {
        new LongAdder();     // Catch: Throwable -> L4
        com.google.common.base.e0 r5 = new s0();     // Catch: Throwable -> L4
    L5:
        f8770a = r5;
        return;
    L4:
        r5 = new t0();
        goto L5
    }

    public static r0 a() {
        return (r0) f8770a.get();
    }
}
