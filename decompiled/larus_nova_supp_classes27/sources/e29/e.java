package e29;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class e {
    public final boolean a;
    public final int b;

    public e() {
        this(false, 0);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof e) == true) goto L8;
        return false;
    L8:
        e r6 = (e) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        if (this.a == false) goto L5;
        int r0 = 1231;
    L7:
        return (r0 * 31) + this.b;
    L5:
        r0 = 1237;
        goto L7
    }

    public final String toString() {
        return "CommunityHostUiPolicy(useHostChrome=" + this.a + ", tabListEndMargin=" + this.b + ')';
    }

    public final boolean a(boolean r1) {
        if (r1 == true) goto L4;
    L6:
        return false;
    L4:
        if (this.a == true) goto L6;
        return true;
    }

    public e(boolean r1, int r2) {
        this.a = r1;
        this.b = r2;
    }
}
