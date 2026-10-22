package com.bytedance.android.live.profit.vote;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class g {
    public final long a;
    public final long b;
    public final String c;
    public final String d;
    public final py.k e;

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof g) == false) goto L16;
        g r7 = (g) r6;
        if (this.a == r7.a) goto L8;
        return false;
    L8:
        if (this.b == r7.b) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.c, r7.c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.d, r7.d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.e, r7.e) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public final int hashCode() {
        long r0 = this.a;
        int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
        long r3 = this.b;
        int r2 = (r1 + ((int) (r3 ^ (r3 >>> 32)))) * 31;
        String r4 = this.c;
        int r5 = 0;
        if (r4 == null) goto L5;
        int r6 = r4.hashCode();
    L6:
        int r7 = (r2 + r6) * 31;
        String r8 = this.d;
        if (r8 == null) goto L9;
        int r9 = r8.hashCode();
    L10:
        int r10 = (r7 + r9) * 31;
        py.k r12 = this.e;
        if (r12 == null) goto L14;
        r5 = r12.hashCode();
    L14:
        return r10 + r5;
    L9:
        r9 = 0;
        goto L10
    L5:
        r6 = 0;
        goto L6
    }

    public final String toString() {
        return "VoteItem(count=" + this.a + ", giftId=" + this.b + ", giftName=" + this.c + ", text=" + this.d + ", icon=" + this.e + ")";
    }

    public g(long r2, long r4, String r6, String r7, py.k r8) {
        Intrinsics.checkNotNullParameter(r6, "giftName");
        Intrinsics.checkNotNullParameter(r7, "text");
        this.a = r2;
        this.b = r4;
        this.c = r6;
        this.d = r7;
        this.e = r8;
    }
}
