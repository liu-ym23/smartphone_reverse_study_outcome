package com.bytedance.android.live.revlink.impl.control.launchcontext;

import com.bytedance.android.livesdk.link.model.a6;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b implements sc0.b {
    public final long a;
    public final com.bytedance.android.live.revlink.impl.audience.c b;
    public final String c;
    public final a6 d;

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof b) == false) goto L14;
        b r7 = (b) r6;
        if (this.a == r7.a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r7.b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.c, r7.c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.d, r7.d) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        long r0 = this.a;
        int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
        com.bytedance.android.live.revlink.impl.audience.c r2 = this.b;
        int r3 = 0;
        if (r2 == null) goto L5;
        int r4 = r2.hashCode();
    L6:
        int r5 = (r1 + r4) * 31;
        String r6 = this.c;
        if (r6 == null) goto L9;
        int r7 = r6.hashCode();
    L10:
        int r8 = (r5 + r7) * 31;
        a6 r9 = this.d;
        if (r9 == null) goto L14;
        r3 = r9.hashCode();
    L14:
        return r8 + r3;
    L9:
        r7 = 0;
        goto L10
    L5:
        r4 = 0;
        goto L6
    }

    public final String toString() {
        return "MultiLinkAudienceLaunchContext(channelID=" + this.a + ", source=" + this.b + ", rawSei=" + this.c + ", enterContent=" + this.d + ")";
    }

    public b(long r2, com.bytedance.android.live.revlink.impl.audience.c r4, String r5, a6 r6) {
        Intrinsics.checkNotNullParameter(r4, "source");
        this.a = r2;
        this.b = r4;
        this.c = r5;
        this.d = r6;
    }
}
