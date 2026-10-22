package u22;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class h {
    public final long a;
    public final long b;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof h) == false) goto L10;
        h r7 = (h) r6;
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
        int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
        long r3 = this.b;
        return r1 + ((int) (r3 ^ (r3 >>> 32)));
    }

    public final String toString() {
        return "PSMessageClickEvent(opType=" + this.a + ", messageId=" + this.b + ")";
    }

    public h(long r1, long r3) {
        this.a = r1;
        this.b = r3;
    }
}
