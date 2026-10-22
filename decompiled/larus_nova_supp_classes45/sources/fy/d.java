package fy;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class d {
    public final long a;
    public final int b;
    public final String c;
    public final int d;
    public final String e;

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof d) == false) goto L16;
        d r7 = (d) r6;
        if (this.a == r7.a) goto L8;
        return false;
    L8:
        if (this.b == r7.b) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.c, r7.c) == true) goto L12;
        return false;
    L12:
        if (this.d == r7.d) goto L14;
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
        int r1 = ((((int) (r0 ^ (r0 >>> 32))) * 31) + this.b) * 31;
        String r2 = this.c;
        int r3 = 0;
        if (r2 == null) goto L5;
        int r4 = r2.hashCode();
    L6:
        int r5 = (((r1 + r4) * 31) + this.d) * 31;
        String r6 = this.e;
        if (r6 == null) goto L10;
        r3 = r6.hashCode();
    L10:
        return r5 + r3;
    L5:
        r4 = 0;
        goto L6
    }

    public final String toString() {
        return "FinishParams(channelId=" + this.a + ", scene=" + this.b + ", reqSrc=" + this.c + ", fromAudience=" + this.d + ", subReqSrc=" + this.e + ")";
    }

    public d(long r2, int r4, String r5) {
        Intrinsics.checkNotNullParameter(r5, "reqSrc");
        this.a = r2;
        this.b = r4;
        this.c = r5;
        this.d = 0;
        this.e = null;
    }
}
