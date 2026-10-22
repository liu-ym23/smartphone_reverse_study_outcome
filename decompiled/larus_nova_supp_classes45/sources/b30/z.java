package b30;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class z {
    public final int a;

    public final boolean equals(Object r2) {
        if (this != r2) goto L4;
        return true;
    L4:
        if ((r2 instanceof z) == true) goto L6;
        return false;
    L6:
        if (this.a == ((z) r2).a) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        return this.a;
    }

    public final String toString() {
        return "SetPullDownCloseEvent(pullDownClose=" + this.a + ")";
    }

    public z(int r1) {
        this.a = r1;
    }
}
