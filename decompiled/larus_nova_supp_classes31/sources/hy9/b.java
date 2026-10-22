package hy9;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class b {
    public final boolean a;
    public final int b;
    public final boolean c;
    public final g d;
    public final Long e;

    public b() {
        this(null, 31);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof b) == true) goto L8;
        return false;
    L8:
        b r6 = (b) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r1 = 1231;
        if (this.a == false) goto L5;
        int r0 = 1231;
    L6:
        int r2 = ((r0 * 31) + this.b) * 31;
        if (this.c == true) goto L10;
        r1 = 1237;
    L10:
        int r3 = (r2 + r1) * 31;
        g r4 = this.d;
        int r5 = 0;
        if (r4 != null) goto L13;
        int r6 = 0;
    L14:
        int r7 = (r3 + r6) * 31;
        Long r8 = this.e;
        if (r8 == null) goto L19;
        r5 = r8.hashCode();
    L19:
        return r7 + r5;
    L13:
        r6 = r4.hashCode();
        goto L14
    L5:
        r0 = 1237;
        goto L6
    }

    public final String toString() {
        return "HostReadState(eligible=" + this.a + ", roundNum=" + this.b + ", isHostRead=" + this.c + ", roundInfo=" + this.d + ", curServerTimeMs=" + this.e + ')';
    }

    public /* synthetic */ b(Long r7, int r8) {
        if ((r8 & 2) == 0) goto L5;
        int r2 = -1;
    L7:
        if ((r8 & 16) == 0) goto L9;
        r7 = null;
    L9:
        this(false, r2, false, null, r7);
        return;
    L5:
        r2 = 0;
        goto L7
    }

    public b(boolean r1, int r2, boolean r3, g r4, Long r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }
}
