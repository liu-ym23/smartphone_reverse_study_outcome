package com.ss.android.socialbase.downloader.network;

/* JADX INFO: loaded from: classes3.dex */
public class ExponentialGeometricAverage {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final double f15960a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f15961b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public double f15962c;
    public int d;

    public ExponentialGeometricAverage(double r5) {
        this.f15962c = -1.0d;
        this.f15960a = r5;
        if (r5 != 0.0d) goto L5;
        int r10 = Integer.MAX_VALUE;
    L6:
        this.f15961b = r10;
        return;
    L5:
        r10 = (int) Math.ceil(1.0d / r5);
        goto L6
    }

    public final void a(double r10) {
        double r5 = 1.0d - this.f15960a;
        int r11 = this.d;
        if (r11 <= this.f15961b) goto L5;
        this.f15962c = Math.exp((Math.log(r10) * this.f15960a) + (Math.log(this.f15962c) * r5));
    L8:
        this.d++;
        return;
    L5:
        if (r11 <= 0) goto L7;
        double r12 = r11;
        double r13 = (r5 * r12) / (r12 + 1.0d);
        this.f15962c = Math.exp((Math.log(r10) * (1.0d - r13)) + (Math.log(this.f15962c) * r13));
        goto L8
    L7:
        this.f15962c = r10;
        goto L8
    }
}
