package com.bytedance.android.live.profit.fansclub;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class j {
    public final FansClubUserStatus a;
    public final GuardStatus b;

    public j() {
        this(0);
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof j) == false) goto L10;
        j r4 = (j) r3;
        if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r4.b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        FansClubUserStatus r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        GuardStatus r4 = this.b;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        return r3 + r1;
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "FansClubStatus(fansClubUserStatus=" + this.a + ", guardStatus=" + this.b + ")";
    }

    public /* synthetic */ j(int r2) {
        this(FansClubUserStatus.Unknown, GuardStatus.NoGuard);
    }

    public j(FansClubUserStatus r2, GuardStatus r3) {
        Intrinsics.checkNotNullParameter(r2, "fansClubUserStatus");
        Intrinsics.checkNotNullParameter(r3, "guardStatus");
        this.a = r2;
        this.b = r3;
    }
}
