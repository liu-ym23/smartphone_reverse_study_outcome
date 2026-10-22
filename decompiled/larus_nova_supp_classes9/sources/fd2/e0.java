package fd2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class e0 {
    public final int a;
    public final double b;

    public final boolean equals(Object r5) {
        if (this != r5) goto L4;
        return true;
    L4:
        if ((r5 instanceof e0) == false) goto L10;
        e0 r6 = (e0) r5;
        if (this.a == r6.a) goto L8;
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
        int r0 = this.a * 31;
        long r1 = Double.doubleToLongBits(this.b);
        return r0 + ((int) (r1 ^ (r1 >>> 32)));
    }

    public final String toString() {
        return "NetWorkStatus(rtt=" + this.a + ", fractionLost=" + this.b + ")";
    }

    public e0(int r1, double r2) {
        this.a = r1;
        this.b = r2;
    }
}
