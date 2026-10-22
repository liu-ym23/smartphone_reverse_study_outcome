package com.bytedance.android.live.profit.lottery;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class e1 {
    public final long a;
    public final List<String> b;
    public final String c;

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof e1) == false) goto L12;
        e1 r7 = (e1) r6;
        if (this.a == r7.a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r7.b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.c, r7.c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        long r0 = this.a;
        int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
        List<String> r2 = this.b;
        int r3 = 0;
        if (r2 == null) goto L5;
        int r4 = r2.hashCode();
    L6:
        int r5 = (r1 + r4) * 31;
        String r6 = this.c;
        if (r6 == null) goto L10;
        r3 = r6.hashCode();
    L10:
        return r5 + r3;
    L5:
        r4 = 0;
        goto L6
    }

    public final String toString() {
        return "LotteryNewDrawResult(lotteryId=" + this.a + ", luckyUserIds=" + this.b + ", extra=" + this.c + ")";
    }

    public e1(long r2, List<String> r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, "luckyUserIds");
        Intrinsics.checkNotNullParameter(r5, "extra");
        this.a = r2;
        this.b = r4;
        this.c = r5;
    }
}
