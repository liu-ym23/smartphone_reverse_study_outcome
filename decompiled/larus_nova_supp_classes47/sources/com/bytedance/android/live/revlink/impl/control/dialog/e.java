package com.bytedance.android.live.revlink.impl.control.dialog;

import com.bytedance.android.livesdk.link.model.IRivalRankRecommendResponse;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class e {
    public final int a;
    public final String b;
    public final IRivalRankRecommendResponse c;
    public final long d;
    public final long e;
    public Map<String, String> f;

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof e) == false) goto L18;
        e r7 = (e) r6;
        if (this.a == r7.a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r7.b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.c, r7.c) == true) goto L12;
        return false;
    L12:
        if (this.d == r7.d) goto L14;
        return false;
    L14:
        if (this.e == r7.e) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f, r7.f) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public final int hashCode() {
        int r0 = this.a * 31;
        String r1 = this.b;
        int r2 = 0;
        if (r1 == null) goto L5;
        int r3 = r1.hashCode();
    L6:
        int r4 = (r0 + r3) * 31;
        IRivalRankRecommendResponse r5 = this.c;
        if (r5 == null) goto L9;
        int r6 = r5.hashCode();
    L10:
        long r7 = this.d;
        int r8 = (((r4 + r6) * 31) + ((int) (r7 ^ (r7 >>> 32)))) * 31;
        long r9 = this.e;
        int r10 = (r8 + ((int) (r9 ^ (r9 >>> 32)))) * 31;
        Map<String, String> r12 = this.f;
        if (r12 == null) goto L14;
        r2 = r12.hashCode();
    L14:
        return r10 + r2;
    L9:
        r6 = 0;
        goto L10
    L5:
        r3 = 0;
        goto L6
    }

    public final String toString() {
        return "RecommendCacheData(loadType=" + this.a + ", activityId=" + this.b + ", resp=" + this.c + ", startLoadingTs=" + this.d + ", loadedTs=" + this.e + ", logMap=" + this.f + ")";
    }

    public /* synthetic */ e(int r10, String r12, IRivalRankRecommendResponse r13, long r14, long r15) {
        this(r10, r12, r13, r14, r15, null);
    }

    public e(int r2, String r3, IRivalRankRecommendResponse r4, long r5, long r7, Map<String, String> r9) {
        Intrinsics.checkNotNullParameter(r3, "activityId");
        Intrinsics.checkNotNullParameter(r4, "resp");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r7;
        this.f = r9;
    }
}
