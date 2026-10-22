package xs8;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class l {
    public final long a;
    public final long b;
    public final boolean c;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof l) == true) goto L8;
        return false;
    L8:
        l r9 = (l) r8;
        if (this.a == r9.a) goto L12;
        return false;
    L12:
        if (this.b == r9.b) goto L15;
        return false;
    L15:
        if (this.c == r9.c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        long r0 = this.a;
        int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
        long r3 = this.b;
        int r2 = (r1 + ((int) (r3 ^ (r3 >>> 32)))) * 31;
        if (this.c == false) goto L5;
        int r4 = 1231;
    L7:
        return r2 + r4;
    L5:
        r4 = 1237;
        goto L7
    }

    public final String toString() {
        return "SubscribedModelFallback(selectedId=" + this.a + ", fallbackId=" + this.b + ", syncVideoModel=" + this.c + ')';
    }

    public l(long r1, long r3, boolean r5) {
        this.a = r1;
        this.b = r3;
        this.c = r5;
    }
}
