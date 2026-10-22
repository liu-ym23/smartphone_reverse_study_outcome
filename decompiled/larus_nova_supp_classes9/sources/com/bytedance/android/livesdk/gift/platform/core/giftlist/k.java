package com.bytedance.android.livesdk.gift.platform.core.giftlist;

import com.bytedance.android.livesdk.gift.model.c1;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class k {
    public final long a;
    public final List<Long> b;
    public final List<c1> c;
    public long d;
    public List<Long> e;

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof k) == false) goto L16;
        k r7 = (k) r6;
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
        if (Intrinsics.areEqual(this.e, r7.e) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public final int hashCode() {
        long r0 = this.a;
        int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
        List<Long> r2 = this.b;
        int r3 = 0;
        if (r2 == null) goto L5;
        int r4 = r2.hashCode();
    L6:
        int r5 = (r1 + r4) * 31;
        List<c1> r6 = this.c;
        if (r6 == null) goto L9;
        int r7 = r6.hashCode();
    L10:
        long r8 = this.d;
        int r9 = (((r5 + r7) * 31) + ((int) (r8 ^ (r8 >>> 32)))) * 31;
        List<Long> r10 = this.e;
        if (r10 == null) goto L14;
        r3 = r10.hashCode();
    L14:
        return r9 + r3;
    L9:
        r7 = 0;
        goto L10
    L5:
        r4 = 0;
        goto L6
    }

    public final String toString() {
        return "PagingGiftListModel(pagingId=" + this.a + ", giftListIds=" + this.b + ", remainingBaseGifts=" + this.c + ", curRequestLastGiftId=" + this.d + ", curResponseLoadGiftIds=" + this.e + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public k(long r2, List<Long> r4, List<? extends c1> r5, long r6, List<Long> r8) {
        Intrinsics.checkNotNullParameter(r4, "giftListIds");
        Intrinsics.checkNotNullParameter(r5, "remainingBaseGifts");
        Intrinsics.checkNotNullParameter(r8, "curResponseLoadGiftIds");
        this.a = r2;
        this.b = r4;
        this.c = r5;
        this.d = r6;
        this.e = r8;
    }
}
