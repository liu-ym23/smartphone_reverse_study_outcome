package com.bytedance.android.livesdk.gift.platform.core.scope.service;

import com.bytedance.bdlocation.BuildConfig;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class l {
    public final com.bytedance.android.live.core.resources.e a;
    public final long b;
    public final String c;
    public final com.bytedance.android.livesdk.gift.platform.business.effect.assets.a d;
    public final String e;
    public final long f;

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof l) == false) goto L18;
        l r7 = (l) r6;
        if (Intrinsics.areEqual(this.a, r7.a) == true) goto L8;
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
        if (Intrinsics.areEqual(this.e, r7.e) == true) goto L16;
        return false;
    L16:
        if (this.f == r7.f) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public final int hashCode() {
        com.bytedance.android.live.core.resources.e r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        long r3 = this.b;
        int r4 = ((r2 * 31) + ((int) (r3 ^ (r3 >>> 32)))) * 31;
        String r5 = this.c;
        if (r5 == null) goto L9;
        int r6 = r5.hashCode();
    L10:
        int r7 = (r4 + r6) * 31;
        com.bytedance.android.livesdk.gift.platform.business.effect.assets.a r8 = this.d;
        if (r8 == null) goto L13;
        int r9 = r8.hashCode();
    L14:
        int r10 = (r7 + r9) * 31;
        String r11 = this.e;
        if (r11 == null) goto L17;
        r1 = r11.hashCode();
    L17:
        int r13 = (r10 + r1) * 31;
        long r14 = this.f;
        return r13 + ((int) (r14 ^ (r14 >>> 32)));
    L13:
        r9 = 0;
        goto L14
    L9:
        r6 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "DeleteAssetData(assetsModel=" + this.a + ", assetId=" + this.b + ", md5=" + this.c + ", assetsMd5Model=" + this.d + ", filePath=" + this.e + ", interval=" + this.f + ")";
    }

    public l(long r5, String r7, com.bytedance.android.livesdk.gift.platform.business.effect.assets.a r8, String r9, long r10, int r13) {
        if ((r13 & 2) == 0) goto L6;
        r5 = 0;
    L6:
        if ((r13 & 8) == 0) goto L9;
        r8 = null;
    L9:
        if ((r13 & 16) == 0) goto L12;
        r9 = BuildConfig.FLAVOR;
    L12:
        if ((r13 & 32) == 0) goto L14;
        r10 = 0;
    L14:
        Intrinsics.checkNotNullParameter(r7, "md5");
        Intrinsics.checkNotNullParameter(r9, "filePath");
        this.a = null;
        this.b = r5;
        this.c = r7;
        this.d = r8;
        this.e = r9;
        this.f = r10;
    }
}
