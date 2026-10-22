package com.bytedance.android.live.revlink.impl.multianchor.vm;

import com.bytedance.android.livesdk.link.model.IRivalRankRecommendResponse;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class h {
    public final IRivalRankRecommendResponse a;
    public final int b;
    public final long c;
    public final long d;

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof h) == false) goto L14;
        h r7 = (h) r6;
        if (Intrinsics.areEqual(this.a, r7.a) == true) goto L8;
        return false;
    L8:
        if (this.b == r7.b) goto L10;
        return false;
    L10:
        if (this.c == r7.c) goto L12;
        return false;
    L12:
        if (this.d == r7.d) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        IRivalRankRecommendResponse r0 = this.a;
        if (r0 == null) goto L5;
        int r1 = r0.hashCode();
    L6:
        int r2 = ((r1 * 31) + this.b) * 31;
        long r3 = this.c;
        int r4 = (r2 + ((int) (r3 ^ (r3 >>> 32)))) * 31;
        long r5 = this.d;
        return r4 + ((int) (r5 ^ (r5 >>> 32)));
    L5:
        r1 = 0;
        goto L6
    }

    public final String toString() {
        return "RecommendPreloadData(resp=" + this.a + ", tabType=" + this.b + ", startLoadingTs=" + this.c + ", loadedTs=" + this.d + ")";
    }

    public h(IRivalRankRecommendResponse r2, int r3, long r4, long r6) {
        Intrinsics.checkNotNullParameter(r2, "resp");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r6;
    }
}
