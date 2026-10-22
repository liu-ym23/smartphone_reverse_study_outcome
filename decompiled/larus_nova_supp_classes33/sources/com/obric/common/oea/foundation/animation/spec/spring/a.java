package com.obric.common.oea.foundation.animation.spec.spring;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class a {
    public double a;
    public double b;

    public final boolean equals(Object r5) {
        if (this != r5) goto L4;
        return true;
    L4:
        if ((r5 instanceof a) == false) goto L10;
        a r6 = (a) r5;
        if (Double.compare(this.a, r6.a) == 0) goto L8;
        return false;
    L8:
        if (Double.compare(this.b, r6.b) == 0) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        long r0 = Double.doubleToLongBits(this.a);
        int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
        long r3 = Double.doubleToLongBits(this.b);
        return r1 + ((int) (r3 ^ (r3 >>> 32)));
    }

    public final String toString() {
        return "ComplexDouble(_real=" + this.a + ", _imaginary=" + this.b + ")";
    }

    public a(double r1, double r3) {
        this.a = r1;
        this.b = r3;
    }
}
