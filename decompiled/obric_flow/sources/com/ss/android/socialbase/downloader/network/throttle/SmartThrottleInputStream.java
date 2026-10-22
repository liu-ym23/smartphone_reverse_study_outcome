package com.ss.android.socialbase.downloader.network.throttle;

import android.net.TrafficStats;
import com.ss.android.socialbase.downloader.network.ExponentialGeometricAverage;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes3.dex */
public class SmartThrottleInputStream extends ThrottleInputStream {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final float f15972i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final float f15973j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final float f15974k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f15975l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final float f15976m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final long f15977n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final long f15978o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final ExponentialGeometricAverage f15979p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final ExponentialGeometricAverage f15980q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public long f15981r;
    public long s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public long f15982t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public long f15983u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public long f15984v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public double f15985w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public long f15986x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final int f15987y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public double f15988z;

    public SmartThrottleInputStream(InputStream r5, float r10, float r11) {
        super(r5);
        this.f15972i = 0.1f;
        this.f15973j = 0.7f;
        this.f15975l = 0.1f;
        this.f15976m = 0.1f;
        this.f15977n = 1000;
        this.f15978o = 2000;
        this.f15979p = new ExponentialGeometricAverage(0.1d);
        this.f15980q = new ExponentialGeometricAverage(0.1d);
        this.f15987y = 60;
        if (r10 < r11) goto L5;
    L9:
        if (r10 < r11) goto L11;
    L15:
        this.f15974k = (this.f15972i + this.f15973j) / 2.0f;
        return;
    L11:
        if (r11 <= 0.0f) goto L15;
        if (r11 > 1.0f) goto L15;
        this.f15973j = r11;
        goto L15
    L5:
        if (r10 < 0.0f) goto L9;
        if (r10 >= 1.0f) goto L9;
        this.f15972i = r10;
        goto L9
    }

    public final void a(float r5) {
        if (r5 <= 0.0f) goto L8;
        if (this.f15975l < this.f15973j) goto L12;
        r5 = -this.f15976m;
    L12:
        float r10 = this.f15975l + r5;
        this.f15975l = r10;
        if (r5 <= 0.0f) goto L15;
        float r11 = Math.min(r10, this.f15973j);
    L16:
        this.f15975l = r11;
        return;
    L15:
        r11 = Math.max(this.f15972i, r10);
        goto L16
    L8:
        if (r5 >= 0.0f) goto L12;
        if (this.f15975l > this.f15972i) goto L12;
        r5 = this.f15976m;
        goto L12
    }

    @Override // com.ss.android.socialbase.downloader.network.throttle.ThrottleInputStream, java.io.InputStream
    public final int read(byte[] r16, int r17, int r18) {
        if (this.f15990b != (-1)) goto L67;
        long r5 = System.currentTimeMillis();
        if ((r5 - this.g) <= this.d) goto L62;
        this.g = r5;
        long r10 = this.f15981r;
        long r11 = r5 - r10;
        if (r11 < this.f15977n) goto L15;
        double r12 = r11;
        if (r10 > 0) goto L11;
    L14:
        this.f15981r = r5;
        this.f15983u = TrafficStats.getTotalRxBytes();
        this.s = this.f15982t;
        goto L15
    L11:
        if (r12 <= 0.0d) goto L14;
        this.f15981r = r5;
        long r13 = TrafficStats.getTotalRxBytes();
        long r14 = this.f15982t;
        long r15 = r14 - this.s;
        long r19 = r13 - this.f15983u;
        this.s = r14;
        this.f15983u = r13;
        this.f15979p.a(r15 / r12);
        this.f15980q.a(r19 / r12);
    L15:
        long r20 = this.f15984v;
        if ((r5 - r20) >= this.f15978o) goto L18;
    L46:
        long r21 = (long) (this.d * ((double) (1.0f - this.f15975l)));
        long r22 = this.f15986x;
        if (r22 < r21) goto L50;
        this.f15986x = r22 - r21;
        goto L62
    L50:
        if (r22 <= 0) goto L53;
        r21 = r21 - r22;
        this.f15986x = 0;
    L53:
        if (r21 <= 0) goto L62;
        long r23 = System.currentTimeMillis();
        Thread.sleep(r21);     // Catch: InterruptedException -> L59
        long r24 = (System.currentTimeMillis() - r23) - r21;
        if (r24 <= 0) goto L62;
        this.f15986x = r24;
    L59:
        e = move-exception;
        throw new IOException(e);
    L18:
        if (r20 != 0) goto L20;
        this.f15984v = r5;
        goto L46
    L20:
        this.f15984v = r5;
        double r25 = this.f15980q.f15962c - this.f15979p.f15962c;
        double r26 = r25 - this.f15985w;
        this.f15985w = r25;
        double r27 = r26 + this.f15988z;
        this.f15988z = 0.0d;
        int r28 = this.f15987y;
        if (r27 >= r28) goto L25;
        int r29 = -r28;
        if (r27 < r29) goto L25;
        this.f15988z = r27;
        if (r27 <= (r29 / 2.0f)) goto L29;
        byte r30 = 1;
    L30:
        if (r30 > 0) goto L32;
        if (r30 >= 0) goto L43;
        if (this.f15975l <= this.f15974k) goto L40;
        float r31 = (-this.f15976m) * 2.0f;
    L41:
        a(r31);
        goto L46
    L40:
        r31 = -this.f15976m;
        goto L41
    L43:
        if (this.f15975l >= this.f15974k) goto L45;
        a(this.f15976m);
        goto L46
    L45:
        a(-this.f15976m);
        goto L46
    L32:
        if (this.f15975l >= this.f15974k) goto L34;
        float r32 = this.f15976m * 2.0f;
    L35:
        a(r32);
        goto L46
    L34:
        r32 = this.f15976m;
        goto L35
    L29:
        r30 = 0;
    L25:
        r30 = -1;
    L62:
        int r33 = a(r16, r17, r18);
        if (r33 == (-1)) goto L65;
        this.f15982t += (long) r33;
    L65:
        return r33;
    L67:
        return super.read(r16, r17, r18);
    }
}
