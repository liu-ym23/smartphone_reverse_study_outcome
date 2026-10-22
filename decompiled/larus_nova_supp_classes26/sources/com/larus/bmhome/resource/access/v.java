package com.larus.bmhome.resource.access;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class v {
    public final boolean a;
    public final boolean b;
    public final boolean c;
    public final boolean d;
    public final boolean e;

    public v() {
        this(false, false, false, 31);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof v) == true) goto L8;
        return false;
    L8:
        v r6 = (v) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L18;
        return false;
    L18:
        if (this.d == r6.d) goto L21;
        return false;
    L21:
        if (this.e == r6.e) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r1 = 1231;
        if (this.a == false) goto L5;
        int r0 = 1231;
    L6:
        int r2 = r0 * 31;
        if (this.b == false) goto L9;
        int r3 = 1231;
    L10:
        int r4 = (r2 + r3) * 31;
        if (this.c == false) goto L13;
        int r5 = 1231;
    L14:
        int r6 = (r4 + r5) * 31;
        if (this.d == false) goto L17;
        int r7 = 1231;
    L18:
        int r8 = (r6 + r7) * 31;
        if (this.e == true) goto L23;
        r1 = 1237;
    L23:
        return r8 + r1;
    L17:
        r7 = 1237;
        goto L18
    L13:
        r5 = 1237;
        goto L14
    L9:
        r3 = 1237;
        goto L10
    L5:
        r0 = 1237;
        goto L6
    }

    public final String toString() {
        return "ResourceAccessOptions(enablePreprocess=" + this.a + ", enableLocalDetect=" + this.b + ", enableReview=" + this.c + ", allowRemoteResolve=" + this.d + ", allowRemoteFallback=" + this.e + ')';
    }

    public v(boolean r4, boolean r5, boolean r6, int r7) {
        boolean r1 = false;
        if ((r7 & 1) == 0) goto L6;
        r4 = false;
    L6:
        if ((r7 & 2) == 0) goto L9;
        r5 = false;
    L9:
        if ((r7 & 4) == 0) goto L12;
        r6 = false;
    L12:
        if ((r7 & 8) == 0) goto L14;
        boolean r0 = true;
    L16:
        if ((r7 & 16) == 0) goto L18;
        r1 = true;
    L18:
        this.a = r4;
        this.b = r5;
        this.c = r6;
        this.d = r0;
        this.e = r1;
        return;
    L14:
        r0 = false;
        goto L16
    }
}
