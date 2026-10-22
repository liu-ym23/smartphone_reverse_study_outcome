package com.bytedance.android.livesdk.gift.platform.core.giftlist;

import com.bytedance.android.livesdk.gift.model.h1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class p {
    public final h1 a;
    public final int b;
    public final int c;
    public int d;
    public int e;
    public long f;

    public final boolean equals(Object r5) {
        if (this != r5) goto L4;
        return true;
    L4:
        if ((r5 instanceof p) == false) goto L18;
        p r6 = (p) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L8;
        return false;
    L8:
        if (this.b == r6.b) goto L10;
        return false;
    L10:
        if (this.c == r6.c) goto L12;
        return false;
    L12:
        if (this.d == r6.d) goto L14;
        return false;
    L14:
        if (this.e == r6.e) goto L16;
        return false;
    L16:
        if (this.f == r6.f) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public final int hashCode() {
        h1 r0 = this.a;
        if (r0 == null) goto L5;
        int r1 = r0.hashCode();
    L6:
        int r2 = ((((((((r1 * 31) + this.b) * 31) + this.c) * 31) + this.d) * 31) + this.e) * 31;
        long r3 = this.f;
        return r2 + ((int) (r3 ^ (r3 >>> 32)));
    L5:
        r1 = 0;
        goto L6
    }

    public final String toString() {
        return "RemindGiftModel(gift=" + this.a + ", newPosition=" + this.b + ", originPageType=" + this.c + ", posDiff=" + this.d + ", priceDiff=" + this.e + ", originGiftId=" + this.f + ")";
    }

    public p(h1 r2, int r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "gift");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = 1000000;
        this.e = 1000000;
        this.f = -1;
    }
}
