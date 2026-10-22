package b30;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a0 {
    public final int a;

    public final boolean equals(Object r2) {
        if (this != r2) goto L4;
        return true;
    L4:
        if ((r2 instanceof a0) == true) goto L6;
        return false;
    L6:
        if (this.a == ((a0) r2).a) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        return this.a;
    }

    public final String toString() {
        return "SetPullDownHeightEvent(pullDownHeight=" + this.a + ")";
    }

    public a0(int r1) {
        this.a = r1;
    }
}
