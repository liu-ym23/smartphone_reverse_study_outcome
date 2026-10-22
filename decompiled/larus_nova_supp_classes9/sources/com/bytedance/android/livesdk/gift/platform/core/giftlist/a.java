package com.bytedance.android.livesdk.gift.platform.core.giftlist;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a {
    public py.k a;
    public com.bytedance.android.livesdk.gift.platform.core.model.g b;
    public List<com.bytedance.android.livesdk.gift.platform.core.model.e> c;
    public com.bytedance.android.livesdk.gift.platform.core.model.m d;
    public com.bytedance.android.livesdk.gift.platform.core.model.d e;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof a) == false) goto L16;
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
        if (Intrinsics.areEqual(this.d, r4.d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.e, r4.e) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public final int hashCode() {
        py.k r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        com.bytedance.android.livesdk.gift.platform.core.model.g r4 = this.b;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        List<com.bytedance.android.livesdk.gift.platform.core.model.e> r7 = this.c;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        com.bytedance.android.livesdk.gift.platform.core.model.m r10 = this.d;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r13 = (r9 + r11) * 31;
        com.bytedance.android.livesdk.gift.platform.core.model.d r14 = this.e;
        if (r14 == null) goto L22;
        r1 = r14.hashCode();
    L22:
        return r13 + r1;
    L17:
        r11 = 0;
        goto L18
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
        return "GiftInfoCacheModel(giftEntranceIcon=" + this.a + ", mExtraParam=" + this.b + ", giftComboInfoList=" + this.c + ", giftSearchConfig=" + this.d + ", giftAgentConfig=" + this.e + ")";
    }

    public a(List r2) {
        Intrinsics.checkNotNullParameter(r2, "giftComboInfoList");
        this.a = null;
        this.b = null;
        this.c = r2;
        this.d = null;
        this.e = null;
    }
}
