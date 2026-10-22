package com.larus.dora.dorag.res;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class n {
    public final double a;
    public final double b;

    public n() {
        this(0);
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof n) == true) goto L8;
        return false;
    L8:
        n r9 = (n) r8;
        if (Double.compare(this.a, r9.a) == 0) goto L12;
        return false;
    L12:
        if (Double.compare(this.b, r9.b) == 0) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        long r0 = Double.doubleToLongBits(this.a);
        int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
        long r3 = Double.doubleToLongBits(this.b);
        return r1 + ((int) (r3 ^ (r3 >>> 32)));
    }

    public final String toString() {
        return "MmtTargetBitrateSnapshot(avgKbps=" + this.a + ", minKbps=" + this.b + ')';
    }

    public /* synthetic */ n(int r3) {
        this(-1.0d, -1.0d);
    }

    public n(double r1, double r3) {
        this.a = r1;
        this.b = r3;
    }
}
