package df;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class i {
    public final long a;

    public final boolean equals(Object r10) {
        if (this != r10) goto L4;
        return true;
    L4:
        if ((r10 instanceof i) == true) goto L6;
        return false;
    L6:
        if (this.a == ((i) r10).a) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        long r0 = this.a;
        return (int) (r0 ^ (r0 >>> 32));
    }

    public final String toString() {
        return "EnterCartOptional(promotionSource=" + this.a + ")";
    }

    public i() {
        this(0);
    }

    public i(long r1) {
        this.a = r1;
    }
}
