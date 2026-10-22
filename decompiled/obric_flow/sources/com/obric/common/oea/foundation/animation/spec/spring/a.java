package com.obric.common.oea.foundation.animation.spec.spring;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public double f11320a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public double f11321b;

    public a(double r5, double r10) {
        this.f11320a = r5;
        this.f11321b = r10;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L4;
        return true;
    L4:
        if ((r5 instanceof a) == false) goto L10;
        a r10 = (a) r5;
        if (Double.compare(this.f11320a, r10.f11320a) == 0) goto L8;
        return false;
    L8:
        if (Double.compare(this.f11321b, r10.f11321b) == 0) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        int r5 = Double.hashCode(this.f11320a) * 31;
        return Double.hashCode(this.f11321b) + r5;
    }

    public final String toString() {
        return "ComplexDouble(_real=" + this.f11320a + ", _imaginary=" + this.f11321b + ")";
    }
}
