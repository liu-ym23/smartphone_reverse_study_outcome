package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper;

import com.bytedance.bdlocation.BuildConfig;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class i {
    public String a;
    public long b;
    public int c;

    public i() {
        this(0);
    }

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof i) == false) goto L12;
        i r7 = (i) r6;
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
        return (((r1 * 31) + ((int) (r2 ^ (r2 >>> 32)))) * 31) + this.c;
    L5:
        r1 = 0;
        goto L6
    }

    public final String toString() {
        return "GiftExposureAnimFreqData(frequencyKey=" + this.a + ", lastDate=" + this.b + ", openTimes=" + this.c + ")";
    }

    public i(int r3) {
        Intrinsics.checkNotNullParameter(BuildConfig.FLAVOR, "frequencyKey");
        this.a = BuildConfig.FLAVOR;
        this.b = 0;
        this.c = 0;
    }
}
