package ka2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a {
    public boolean a;
    public final int b;
    public final int c;
    public final int d;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof a) == false) goto L12;
        a r4 = (a) r3;
        if (this.b == r4.b) goto L8;
        return false;
    L8:
        if (this.c == r4.c) goto L10;
        return false;
    L10:
        if (this.d == r4.d) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        return (((this.b * 31) + this.c) * 31) + this.d;
    }

    public final String toString() {
        return "MessageUpdateInfo(size=" + this.b + ", scrollSize=" + this.c + ", foldSize=" + this.d + ")";
    }

    public a(int r1, int r2, int r3) {
        this.b = r1;
        this.c = r2;
        this.d = r3;
    }
}
