package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class e0 implements mb.b {
    public volatile int a;
    public volatile long b;
    public volatile int c;
    public volatile long d;
    public volatile boolean e;
    public volatile int f;
    public volatile long g;
    public volatile int h;
    public volatile long i;
    public volatile long j;
    public volatile long k;

    public e0() {
    }

    public final void a(long r5) {
        this.c++;
        this.d += System.currentTimeMillis() - r5;
        if (this.e == false) goto L6;
        this.h++;
        this.i += System.currentTimeMillis() - r5;
        this.k += (System.currentTimeMillis() - this.j) - this.i;
        return;
    }

    public final void b(long r5) {
        this.a++;
        this.b += System.currentTimeMillis() - r5;
        if (this.e == false) goto L6;
        this.f++;
        this.g += System.currentTimeMillis() - r5;
        this.j = System.currentTimeMillis();
        return;
    }
}
