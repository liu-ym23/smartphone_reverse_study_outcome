package com.larus.community.impl.applet;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class t {
    public final boolean a;
    public final boolean b;
    public final int c;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof t) == true) goto L8;
        return false;
    L8:
        t r6 = (t) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r1 = 1231;
        if (this.a == false) goto L5;
        int r0 = 1231;
    L6:
        int r2 = r0 * 31;
        if (this.b == true) goto L11;
        r1 = 1237;
    L11:
        return ((r2 + r1) * 31) + this.c;
    L5:
        r0 = 1237;
        goto L6
    }

    public final String toString() {
        return "CreationDetailHostUiPolicy(enabled=" + this.a + ", isRootPage=" + this.b + ", trailingActionReservedWidth=" + this.c + ')';
    }

    public t(boolean r1, boolean r2, int r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
