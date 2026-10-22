package com.ss.android.socialbase.downloader.network;

/* JADX INFO: loaded from: classes6.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final double f15593a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f15594b;
    private double c;
    private int d;
    private volatile double e;

    public d(double r3) {
        this.c = -1.0d;
        this.e = 0.0d;
        this.f15593a = r3;
        if (r3 != 0.0d) goto L5;
        int r4 = Integer.MAX_VALUE;
    L6:
        this.f15594b = r4;
        return;
    L5:
        r4 = (int) Math.ceil(1.0d / r3);
        goto L6
    }

    public double a() {
        return this.c;
    }

    public void a(double r8) {
        this.e = r8;
        double r0 = 1.0d - this.f15593a;
        int r4 = this.d;
        if (r4 <= this.f15594b) goto L7;
        double r1 = r0 * Math.log(this.c);
        double r2 = this.f15593a;
    L5:
        r8 = Math.exp(r1 + (r2 * Math.log(r8)));
    L6:
        this.c = r8;
        this.d++;
        return;
    L7:
        if (r4 <= 0) goto L6;
        double r3 = (r0 * ((double) r4)) / (((double) r4) + 1.0d);
        r2 = 1.0d - r3;
        r1 = r3 * Math.log(this.c);
        goto L5
    }

    public double b() {
        return this.e;
    }
}
