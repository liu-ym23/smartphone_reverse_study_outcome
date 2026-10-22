package com.bytedance.android.livesdk.gift.platform.core.preview.viewmodel;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a {
    public final List<com.bytedance.android.livesdk.gift.platform.core.preview.b> a;
    public final List<com.bytedance.android.livesdk.gift.platform.core.preview.b> b;
    public final List<Long> c;
    public final List<Long> d;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof a) == false) goto L14;
        a r4 = (a) r3;
        if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r4.b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.c, r4.c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.d, r4.d) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        List<com.bytedance.android.livesdk.gift.platform.core.preview.b> r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        List<com.bytedance.android.livesdk.gift.platform.core.preview.b> r4 = this.b;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        List<Long> r7 = this.c;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        List<Long> r10 = this.d;
        if (r10 == null) goto L18;
        r1 = r10.hashCode();
    L18:
        return r9 + r1;
    L13:
        r8 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "UgcGiftData(saleList=" + this.a + ", poolList=" + this.b + ", topList=" + this.c + ", dislikeList=" + this.d + ")";
    }

    public a(List<com.bytedance.android.livesdk.gift.platform.core.preview.b> r2, List<com.bytedance.android.livesdk.gift.platform.core.preview.b> r3, List<Long> r4, List<Long> r5) {
        Intrinsics.checkNotNullParameter(r2, "saleList");
        Intrinsics.checkNotNullParameter(r3, "poolList");
        Intrinsics.checkNotNullParameter(r4, "topList");
        Intrinsics.checkNotNullParameter(r5, "dislikeList");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
