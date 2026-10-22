package b30;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class y {
    public final int a;

    public final boolean equals(Object r2) {
        if (this != r2) goto L4;
        return true;
    L4:
        if ((r2 instanceof y) == true) goto L6;
        return false;
    L6:
        if (this.a == ((y) r2).a) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        return this.a;
    }

    public final String toString() {
        return "RefreshActivityBannerNumberEvent(bannerNumber=" + this.a + ")";
    }

    public y(int r1) {
        this.a = r1;
    }
}
