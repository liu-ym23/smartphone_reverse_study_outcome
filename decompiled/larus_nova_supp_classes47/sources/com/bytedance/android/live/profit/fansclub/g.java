package com.bytedance.android.live.profit.fansclub;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class g {
    public final b a;
    public final b b;
    public final b c;
    public final boolean d;

    public g() {
        this(null, null, null, false);
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof g) == false) goto L14;
        g r4 = (g) r3;
        if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r4.b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.c, r4.c) == true) goto L12;
        return false;
    L12:
        if (this.d == r4.d) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v6 */
    public final int hashCode() {
        b r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        b r4 = this.b;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        b r7 = this.c;
        if (r7 == null) goto L13;
        r1 = r7.hashCode();
    L13:
        int r8 = (r6 + r1) * 31;
        boolean r9 = this.d;
        ?? r10 = r9;
        if (r9 == false) goto L17;
        r10 = 1;
    L17:
        return r8 + r10;
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "FansClubProfile(current=" + this.a + ", personal=" + this.b + ", otherRooms=" + this.c + ", isAPIValue=" + this.d + ")";
    }

    public final int b() {
        b r0 = this.a;
        if (r0 == null) goto L10;
        j r1 = r0.c;
        if (r1 == null) goto L10;
        FansClubUserStatus r2 = r1.a;
        if (r2 == null) goto L10;
        return r2.getValue();
    L10:
        return FansClubUserStatus.Unknown.getValue();
    }

    public final boolean c() {
        if (this.a != null) goto L5;
    L7:
        return false;
    L5:
        if (b() == FansClubUserStatus.Unknown.getValue()) goto L7;
        return true;
    }

    public static g a(g r3, b r4) {
        return new g(r4, r3.b, r3.c, true);
    }

    public g(b r1, b r2, b r3, boolean r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
