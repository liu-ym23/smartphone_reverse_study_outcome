package com.obric.common.oea.foundation.animation.spec.spring;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private double f5621a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private double f5622b;

    public a(double r10, double r11) {
        this.f5621a = r10;
        this.f5622b = r11;
    }

    public static final /* synthetic */ double a(a r10) {
        return r10.f5622b;
    }

    public static final /* synthetic */ double b(a r10) {
        return r10.f5621a;
    }

    public static final /* synthetic */ void c(a r10, double r11) {
        r10.f5622b = r11;
    }

    public static final /* synthetic */ void d(a r10, double r11) {
        r10.f5621a = r11;
    }

    public final double e() {
        return this.f5622b;
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L4;
        return true;
    L4:
        if ((r10 instanceof a) == false) goto L10;
        a r11 = (a) r10;
        if (Double.compare(this.f5621a, r11.f5621a) == 0) goto L8;
        return false;
    L8:
        if (Double.compare(this.f5622b, r11.f5622b) == 0) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final double f() {
        return this.f5621a;
    }

    public int hashCode() {
        return (Double.hashCode(this.f5621a) * 31) + Double.hashCode(this.f5622b);
    }

    public String toString() {
        return "ComplexDouble(_real=" + this.f5621a + ", _imaginary=" + this.f5622b + ")";
    }
}
