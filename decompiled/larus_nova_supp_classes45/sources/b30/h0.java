package b30;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class h0 {
    public final boolean a;

    public final boolean equals(Object r2) {
        if (this != r2) goto L4;
        return true;
    L4:
        if ((r2 instanceof h0) == true) goto L6;
        return false;
    L6:
        if (this.a == ((h0) r2).a) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        boolean r0 = this.a;
        if (r0 == false) goto L6;
        return 1;
    L6:
        return r0 ? 1 : 0;
    }

    public final String toString() {
        return "ZhimaVerifyResultEvent(succeed=" + this.a + ")";
    }

    public h0(boolean r1) {
        this.a = r1;
    }
}
