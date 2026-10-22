package com.bytedance.android.livesdk.interactivity.medialink.contract;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class g implements x32.d {
    public final long a;
    public final com.bytedance.android.livesdk.interactivity.medialink.widget.presenter.b b;

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof g) == false) goto L10;
        g r7 = (g) r6;
        if (this.a == r7.a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r7.b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        long r0 = this.a;
        int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
        com.bytedance.android.livesdk.interactivity.medialink.widget.presenter.b r2 = this.b;
        if (r2 == null) goto L5;
        int r3 = r2.hashCode();
    L7:
        return r1 + r3;
    L5:
        r3 = 0;
        goto L7
    }

    public final String toString() {
        return "MediaMultiLinkAudienceLaunchContext(channelID=" + this.a + ", source=" + this.b + ")";
    }

    public g(long r2, com.bytedance.android.livesdk.interactivity.medialink.widget.presenter.b r4) {
        Intrinsics.checkNotNullParameter(r4, "source");
        this.a = r2;
        this.b = r4;
    }
}
