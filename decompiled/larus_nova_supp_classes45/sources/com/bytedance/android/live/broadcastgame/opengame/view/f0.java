package com.bytedance.android.live.broadcastgame.opengame.view;

import com.bytedance.android.live.broadcastgame.opengame.network.m0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class f0 {
    public final m0 a;
    public final com.bytedance.android.live.broadcastgame.opengame.network.f b;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof f0) == false) goto L10;
        f0 r4 = (f0) r3;
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
        m0 r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        com.bytedance.android.live.broadcastgame.opengame.network.f r4 = this.b;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        return r3 + r1;
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "ZipResponse(totalDiamondResponse=" + this.a + ", diamondRankListResponse=" + this.b + ")";
    }

    public f0(m0 r2, com.bytedance.android.live.broadcastgame.opengame.network.f r3) {
        Intrinsics.checkNotNullParameter(r2, "totalDiamondResponse");
        Intrinsics.checkNotNullParameter(r3, "diamondRankListResponse");
        this.a = r2;
        this.b = r3;
    }
}
