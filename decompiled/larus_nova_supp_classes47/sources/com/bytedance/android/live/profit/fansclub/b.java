package com.bytedance.android.live.profit.fansclub;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b {
    public final String a;
    public final int b;
    public final j c;
    public final a d;
    public final m e;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof b) == false) goto L16;
        b r4 = (b) r3;
        if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
        return false;
    L8:
        if (this.b == r4.b) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.c, r4.c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.d, r4.d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.e, r4.e) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public final int hashCode() {
        String r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = ((r2 * 31) + this.b) * 31;
        j r4 = this.c;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        a r7 = this.d;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        m r10 = this.e;
        if (r10 == null) goto L18;
        r1 = r10.hashCode();
    L18:
        return r9 + r1;
    L13:
        r8 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "FansClubData(clubName=" + this.a + ", level=" + this.b + ", fansClubStatus=" + this.c + ", badge=" + this.d + ", guardInfo=" + this.e + ")";
    }

    public final py.k b() {
        a r0 = this.d;
        if (r0 == null) goto L12;
        py.k r1 = r0.b;
        if (r1 == null) goto L12;
        List r2 = r1.getUrls();
        if (r2 == null) goto L12;
        if ((!r2.isEmpty()) != true) goto L12;
        return this.d.b;
    L12:
        return null;
    }

    public static b a(b r6, a r7) {
        String r1 = r6.a;
        int r2 = r6.b;
        j r3 = r6.c;
        m r5 = r6.e;
        Intrinsics.checkNotNullParameter(r1, "clubName");
        Intrinsics.checkNotNullParameter(r3, "fansClubStatus");
        return new b(r1, r2, r3, r7, r5);
    }

    public b(String r2, int r3, j r4, a r5, m r6) {
        Intrinsics.checkNotNullParameter(r2, "clubName");
        Intrinsics.checkNotNullParameter(r4, "fansClubStatus");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
    }
}
