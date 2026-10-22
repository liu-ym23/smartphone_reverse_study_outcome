package com.google.common.math;

/* JADX INFO: loaded from: classes2.dex */
public final class e extends g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final double f9307a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final double f9308b;

    public e(double r5, double r10) {
        this.f9307a = r5;
        this.f9308b = r10;
    }

    public final String toString() {
        return String.format("y = %g * x + %g", new Object[]{Double.valueOf(this.f9307a), Double.valueOf(this.f9308b)});
    }
}
