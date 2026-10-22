package xs1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b {
    public final int a;
    public final long b;

    public final boolean equals(Object r5) {
        if (this != r5) goto L4;
        return true;
    L4:
        if ((r5 instanceof b) == false) goto L10;
        b r6 = (b) r5;
        if (this.a == r6.a) goto L8;
        return false;
    L8:
        if (this.b == r6.b) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        int r0 = this.a * 31;
        long r1 = this.b;
        return r0 + ((int) (r1 ^ (r1 >>> 32)));
    }

    public final String toString() {
        return "AnchorProbePopupConfig(popupTimes=" + this.a + ", popupTimestamp=" + this.b + ")";
    }

    public b() {
        this.a = 0;
        this.b = 0;
    }
}
