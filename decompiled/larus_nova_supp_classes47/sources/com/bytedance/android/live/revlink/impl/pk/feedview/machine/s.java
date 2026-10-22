package com.bytedance.android.live.revlink.impl.pk.feedview.machine;

import com.bytedance.android.livesdk.link.model.api.IBaseBattleSetting;
import com.bytedance.android.livesdk.link.model.x2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class s {
    public final long a;
    public final int b;
    public final IBaseBattleSetting c;
    public final x2 d;
    public final int e;

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof s) == false) goto L16;
        s r7 = (s) r6;
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
        if (this.e == r7.e) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public final int hashCode() {
        long r0 = this.a;
        int r1 = ((((int) (r0 ^ (r0 >>> 32))) * 31) + this.b) * 31;
        IBaseBattleSetting r2 = this.c;
        int r3 = 0;
        if (r2 == null) goto L5;
        int r4 = r2.hashCode();
    L6:
        int r5 = (r1 + r4) * 31;
        x2 r6 = this.d;
        if (r6 == null) goto L10;
        r3 = r6.hashCode();
    L10:
        return ((r5 + r3) * 31) + this.e;
    L5:
        r4 = 0;
        goto L6
    }

    public final String toString() {
        return "PenalInfo(startTimeMs=" + this.a + ", duration=" + this.b + ", setting=" + this.c + ", skinConfig=" + this.d + ", skinType=" + this.e + ")";
    }

    public s(long r2, int r4, IBaseBattleSetting r5, x2 r6, int r7) {
        Intrinsics.checkNotNullParameter(r5, "setting");
        this.a = r2;
        this.b = r4;
        this.c = r5;
        this.d = r6;
        this.e = r7;
    }
}
