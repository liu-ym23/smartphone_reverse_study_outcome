package com.bytedance.common.wschannel.c;

/* JADX INFO: loaded from: classes.dex */
public abstract class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f2016a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f2017b;
    private long c;

    public e() {
        this(0);
    }

    public e(long r3) {
        this(r3, 0);
    }

    public e(long r1, long r3) {
        this.f2016a = r1;
        this.c = r3;
        if (r3 <= 0) goto L6;
        this.f2017b = true;
        return;
    }

    public final long a() {
        return this.f2016a;
    }

    public final boolean b() {
        return this.f2017b;
    }

    public final long c() {
        return this.c;
    }
}
