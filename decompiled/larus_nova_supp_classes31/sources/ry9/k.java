package ry9;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class k {
    public final String a;
    public final j b;
    public final long c;
    public final boolean d;
    public final boolean e;
    public final boolean f;

    public k() {
        this(null, null, 0, false, false, false, 63);
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof k) == true) goto L8;
        return false;
    L8:
        k r9 = (k) r8;
        if (Intrinsics.areEqual(this.a, r9.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r9.b) == true) goto L15;
        return false;
    L15:
        if (this.c == r9.c) goto L18;
        return false;
    L18:
        if (this.d == r9.d) goto L21;
        return false;
    L21:
        if (this.e == r9.e) goto L24;
        return false;
    L24:
        if (this.f == r9.f) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r0 = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
        long r1 = this.c;
        int r2 = (r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31;
        int r3 = 1231;
        if (this.d == false) goto L5;
        int r4 = 1231;
    L6:
        int r5 = (r2 + r4) * 31;
        if (this.e == false) goto L9;
        int r6 = 1231;
    L10:
        int r7 = (r5 + r6) * 31;
        if (this.f == true) goto L15;
        r3 = 1237;
    L15:
        return r7 + r3;
    L9:
        r6 = 1237;
        goto L10
    L5:
        r4 = 1237;
        goto L6
    }

    public final String toString() {
        return "MultiMediaSelectorStatus(resourceKey=" + this.a + ", status=" + this.b + ", progress=" + this.c + ", isPrivate=" + this.d + ", isAvatar=" + this.e + ", hideLoading=" + this.f + ')';
    }

    public k(String r3, j r4, long r5, boolean r7, boolean r8, boolean r9, int r10) {
        if ((r10 & 1) == 0) goto L6;
        r3 = "";
    L6:
        if ((r10 & 2) == 0) goto L9;
        r4 = j.b.b;
    L9:
        if ((r10 & 4) == 0) goto L12;
        r5 = 0;
    L12:
        if ((r10 & 8) == 0) goto L15;
        r7 = false;
    L15:
        if ((r10 & 16) == 0) goto L18;
        r8 = false;
    L18:
        if ((r10 & 32) == 0) goto L20;
        r9 = false;
    L20:
        Intrinsics.checkNotNullParameter(r3, "resourceKey");
        Intrinsics.checkNotNullParameter(r4, "status");
        this.a = r3;
        this.b = r4;
        this.c = r5;
        this.d = r7;
        this.e = r8;
        this.f = r9;
    }
}
