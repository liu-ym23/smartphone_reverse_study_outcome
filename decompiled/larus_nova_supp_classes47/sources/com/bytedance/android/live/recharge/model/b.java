package com.bytedance.android.live.recharge.model;

import com.bytedance.android.livesdk.gift.platform.core.model.v;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b {
    public final String a;
    public final String b;
    public final long c;
    public final long d;
    public final long e;
    public final int f;
    public final a g;
    public final v h;

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof b) == false) goto L22;
        b r7 = (b) r6;
        if (Intrinsics.areEqual(this.a, r7.a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r7.b) == true) goto L10;
        return false;
    L10:
        if (this.c == r7.c) goto L12;
        return false;
    L12:
        if (this.d == r7.d) goto L14;
        return false;
    L14:
        if (this.e == r7.e) goto L16;
        return false;
    L16:
        if (this.f == r7.f) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.g, r7.g) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.h, r7.h) == true) goto L34;
        return false;
    L34:
        return true;
    L22:
        return false;
    }

    public final int hashCode() {
        String r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.b;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        long r7 = this.c;
        int r8 = (r6 + ((int) (r7 ^ (r7 >>> 32)))) * 31;
        long r9 = this.d;
        int r10 = (r8 + ((int) (r9 ^ (r9 >>> 32)))) * 31;
        long r12 = this.e;
        int r13 = (((r10 + ((int) (r12 ^ (r12 >>> 32)))) * 31) + this.f) * 31;
        a r14 = this.g;
        if (r14 == null) goto L13;
        int r15 = r14.hashCode();
    L14:
        int r16 = (r13 + r15) * 31;
        v r17 = this.h;
        if (r17 == null) goto L18;
        r1 = r17.hashCode();
    L18:
        return r16 + r1;
    L13:
        r15 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "GiftRechargeParams(giftRequestId=" + this.a + ", giftSendType=" + this.b + ", giftPayMoney=" + this.c + ", giftPrice=" + this.d + ", giftId=" + this.e + ", giftCount=" + this.f + ", extraGiftParams=" + this.g + ", originGiftParams=" + this.h + ")";
    }

    public /* synthetic */ b(String r14, String r15, long r16, long r18, long r20, int r22, a r23, int r24) {
        if ((r24 & 1) == 0) goto L5;
        String r2 = "";
    L7:
        if ((r24 & 64) == 0) goto L9;
        a r12 = new a(0);
    L10:
        this(r2, r15, r16, r18, r20, r22, r12, null);
        return;
    L9:
        r12 = r23;
        goto L10
    L5:
        r2 = r14;
        goto L7
    }

    public b(String r2, String r3, long r4, long r6, long r8, int r10, a r12, v r13) {
        Intrinsics.checkNotNullParameter(r2, "giftRequestId");
        Intrinsics.checkNotNullParameter(r3, "giftSendType");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r6;
        this.e = r8;
        this.f = r10;
        this.g = r12;
        this.h = r13;
    }
}
