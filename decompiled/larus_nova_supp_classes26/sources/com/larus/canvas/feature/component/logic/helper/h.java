package com.larus.canvas.feature.component.logic.helper;

import android.os.SystemClock;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class h {
    public final long a;
    public final long b;
    public final long c;
    public final long d;
    public final long e;
    public final int f;
    public final int g;
    public final int h;
    public volatile long i;
    public volatile long j;
    public final long k;
    public final long l;

    public h(long r8, long r10) {
        this.a = r8;
        this.b = r10;
        this.c = 1577836800000L;
        this.d = 200;
        this.e = 4095;
        this.f = 12;
        this.g = 17;
        this.h = 22;
        this.i = -1;
        this.k = System.currentTimeMillis();
        this.l = SystemClock.elapsedRealtime();
        boolean r0 = true;
        if (0 <= r8) goto L5;
    L7:
        boolean r9 = false;
    L8:
        if (r9 == false) goto L20;
        if (0 <= r10) goto L12;
    L14:
        r0 = false;
    L15:
        if (r0 == false) goto L18;
        return;
    L18:
        throw new IllegalArgumentException("datacenterId out of range 0..31".toString());
    L12:
        if (r10 > 31) goto L14;
    L20:
        throw new IllegalArgumentException("workerId out of range 0..31".toString());
    L5:
        if (r8 > 31) goto L7;
        r9 = true;
        goto L8
    }
}
