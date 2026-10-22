package com.ss.android.socialbase.downloader.network.a;

import android.net.TrafficStats;
import com.ss.android.socialbase.downloader.network.d;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes6.dex */
public class a extends b {
    private float e;
    private float f;
    private final float g;
    private float h;
    private float i;
    private long j;
    private long k;
    private final d l;
    private final d m;
    private long n;
    private long o;
    private long p;
    private double q;
    private long r;
    private long s;
    private double t;
    private long u;
    private double v;
    private long w;
    private int x;
    private int y;
    private double z;

    public a(InputStream r4, float r5, float r6) {
        super(r4);
        this.e = 0.1f;
        this.f = 0.7f;
        this.h = 0.1f;
        this.i = 0.1f;
        this.j = 1000;
        this.k = 2000;
        this.l = new d(0.1d);
        this.m = new d(0.1d);
        this.x = 1;
        this.y = 60;
        if (r5 < r6) goto L5;
    L9:
        if (r5 < r6) goto L11;
    L15:
        this.g = (this.e + this.f) / 2.0f;
        return;
    L11:
        if (r6 <= 0.0f) goto L15;
        if (r6 > 1.0f) goto L15;
        this.f = r6;
        goto L15
    L5:
        if (r5 < 0.0f) goto L9;
        if (r5 >= 1.0f) goto L9;
        this.e = r5;
        goto L9
    }

    private int a(double r3, double r5, double r7) {
        double r8 = r7 + this.z;
        this.z = 0.0d;
        int r4 = this.y;
        if (r8 < r4) goto L6;
        return -1;
    L6:
        if (r8 >= (-r4)) goto L8;
        return -1;
    L8:
        this.z = r8;
        if (r8 <= ((-r4) / 2.0f)) goto L12;
        return 1;
    L12:
        return 0;
    }

    private void a() {
        if (this.h <= this.g) goto L5;
        float r0 = (-this.i) * 2.0f;
    L6:
        a(r0);
        return;
    L5:
        r0 = -this.i;
        goto L6
    }

    private void a(float r4) {
        if (r4 <= 0.0f) goto L8;
        if (this.h < this.f) goto L12;
        r4 = -this.i;
    L12:
        float r1 = this.h + r4;
        this.h = r1;
        if (r4 <= 0.0f) goto L15;
        this.x = 1;
        float r5 = Math.min(r1, this.f);
    L16:
        this.h = r5;
        return;
    L15:
        this.x = -1;
        r5 = Math.max(this.e, r1);
        goto L16
    L8:
        if (r4 >= 0.0f) goto L12;
        if (this.h > this.e) goto L12;
        r4 = this.i;
        goto L12
    }

    private void a(long r9) {
        long r0 = this.n;
        if ((r9 - r0) < this.j) goto L12;
        double r2 = r9 - r0;
        if (r0 > 0) goto L7;
    L10:
        this.n = r9;
        this.r = TrafficStats.getTotalRxBytes();
        this.o = this.p;
        return;
    L7:
        if (r2 <= 0.0d) goto L10;
        this.n = r9;
        long r10 = TrafficStats.getTotalRxBytes();
        this.s = r10;
        long r1 = this.p;
        long r4 = r1 - this.o;
        long r6 = r10 - this.r;
        this.o = r1;
        this.r = r10;
        this.l.a(r4 / r2);
        this.m.a(r6 / r2);
        return;
    }

    private void b() {
        if (this.h >= this.g) goto L5;
        float r0 = this.i * 2.0f;
    L6:
        a(r0);
        return;
    L5:
        r0 = this.i;
        goto L6
    }

    private void b(long r14) {
        long r0 = this.u;
        if ((r14 - r0) < this.k) goto L18;
        this.u = r14;
        if (r0 != 0) goto L7;
        return;
    L7:
        double r15 = this.l.a();
        double r1 = this.m.a();
        double r2 = r1 - r15;
        double r7 = r15 - this.q;
        double r9 = r1 - this.t;
        double r11 = r2 - this.v;
        this.q = r15;
        this.t = r1;
        this.v = r2;
        int r16 = a(r7, r9, r11);
        if (r16 <= 0) goto L10;
        b();
        return;
    L10:
        if (r16 >= 0) goto L13;
        a();
        return;
    L13:
        if (this.h >= this.g) goto L15;
        float r17 = this.i;
    L16:
        a(r17);
        return;
    L15:
        r17 = -this.i;
        goto L16
    }

    @Override // com.ss.android.socialbase.downloader.network.a.b, java.io.InputStream
    public int read(byte[] r9, int r10, int r11) {
        if (this.f15580a != (-1)) goto L27;
        long r0 = System.currentTimeMillis();
        if ((r0 - this.d) <= this.c) goto L22;
        this.d = r0;
        a(r0);
        b(r0);
        long r1 = (long) (this.c * ((double) (1.0f - this.h)));
        long r2 = this.w;
        if (r2 < r1) goto L10;
        this.w = r2 - r1;
        goto L22
    L10:
        if (r2 <= 0) goto L13;
        r1 = r1 - r2;
        this.w = 0;
    L13:
        if (r1 <= 0) goto L22;
        long r3 = System.currentTimeMillis();
        Thread.sleep(r1);     // Catch: InterruptedException -> L19
        long r6 = (System.currentTimeMillis() - r3) - r1;
        if (r6 <= 0) goto L22;
        this.w = r6;
    L19:
        e = move-exception;
        throw new IOException(e);
    L22:
        int r12 = a(r9, r10, r11);
        if (r12 == (-1)) goto L25;
        this.p += (long) r12;
    L25:
        return r12;
    L27:
        return super.read(r9, r10, r11);
    }
}
