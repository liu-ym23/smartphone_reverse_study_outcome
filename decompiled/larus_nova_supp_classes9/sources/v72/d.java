package v72;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class d {
    public final long a;
    public final int b;

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof d) == false) goto L10;
        d r7 = (d) r6;
        if (this.a == r7.a) goto L8;
        return false;
    L8:
        if (this.b == r7.b) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        long r0 = this.a;
        return (((int) (r0 ^ (r0 >>> 32))) * 31) + this.b;
    }

    public final String toString() {
        return "FrequencyBarrier(leftBarrierTs=" + this.a + ", sliceCounter=" + this.b + ")";
    }

    public d(long r1, int r3) {
        this.a = r1;
        this.b = r3;
    }
}
