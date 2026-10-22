package com.larus.dora.dorag.res;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class p {
    public final double a;
    public final long b;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof p) == true) goto L8;
        return false;
    L8:
        p r9 = (p) r8;
        if (Double.compare(this.a, r9.a) == 0) goto L12;
        return false;
    L12:
        if (this.b == r9.b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        long r0 = Double.doubleToLongBits(this.a);
        int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
        long r3 = this.b;
        return r1 + ((int) (r3 ^ (r3 >>> 32)));
    }

    public final String toString() {
        return "RtcAverageBitrateSample(kbps=" + this.a + ", receivedAtMs=" + this.b + ')';
    }

    public p(double r1, long r3) {
        this.a = r1;
        this.b = r3;
    }
}
