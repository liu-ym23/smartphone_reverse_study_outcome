package com.bytedance.android.livesdk.interactivity.service.monitor;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a {
    public final String a;
    public long b;
    public long c;

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof a) == false) goto L12;
        a r7 = (a) r6;
        if (Intrinsics.areEqual(this.a, r7.a) == true) goto L8;
        return false;
    L8:
        if (this.b == r7.b) goto L10;
        return false;
    L10:
        if (this.c == r7.c) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        String r0 = this.a;
        if (r0 == null) goto L5;
        int r1 = r0.hashCode();
    L6:
        long r2 = this.b;
        int r3 = ((r1 * 31) + ((int) (r2 ^ (r2 >>> 32)))) * 31;
        long r4 = this.c;
        return r3 + ((int) (r4 ^ (r4 >>> 32)));
    L5:
        r1 = 0;
        goto L6
    }

    public final String toString() {
        return "AvgIndicator(indicatorName=" + this.a + ", numerator=" + this.b + ", denominator=" + this.c + ")";
    }

    public a(String r2, long r3) {
        Intrinsics.checkNotNullParameter(r2, "indicatorName");
        this.a = r2;
        this.b = r3;
        this.c = 1;
    }
}
