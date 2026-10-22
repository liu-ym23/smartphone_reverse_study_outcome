package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class p0 {
    public final com.bytedance.android.livesdk.gift.model.n a;
    public final vz1.i b;
    public final long c;

    public final boolean equals(Object r5) {
        if (this != r5) goto L4;
        return true;
    L4:
        if ((r5 instanceof p0) == false) goto L12;
        p0 r6 = (p0) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L10;
        return false;
    L10:
        if (this.c == r6.c) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        com.bytedance.android.livesdk.gift.model.n r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        vz1.i r4 = this.b;
        if (r4 == null) goto L9;
        r1 = r4.hashCode();
    L9:
        int r5 = (r3 + r1) * 31;
        long r6 = this.c;
        return r5 + ((int) (r6 ^ (r6 >>> 32)));
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "VMDIYInfo(diyInfo=" + this.a + ", showImageInfo=" + this.b + ", originId=" + this.c + ")";
    }

    public final com.bytedance.android.livesdk.gift.model.n a() {
        return this.a;
    }

    public final long b() {
        return this.c;
    }

    public final vz1.i c() {
        return this.b;
    }

    public p0(com.bytedance.android.livesdk.gift.model.n r2, vz1.i r3, long r4) {
        Intrinsics.checkNotNullParameter(r2, "diyInfo");
        Intrinsics.checkNotNullParameter(r3, "showImageInfo");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
