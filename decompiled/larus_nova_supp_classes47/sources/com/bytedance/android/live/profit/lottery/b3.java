package com.bytedance.android.live.profit.lottery;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b3 {
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public final String g;

    public b3() {
        this(null, null, null, null, null, null, 127);
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof b3) == false) goto L20;
        b3 r4 = (b3) r3;
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
        if (Intrinsics.areEqual(this.e, r4.e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f, r4.f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.g, r4.g) == true) goto L31;
        return false;
    L31:
        return true;
    L20:
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
        String r7 = this.c;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.d;
        if (r10 == null) goto L17;
        int r12 = r10.hashCode();
    L18:
        int r13 = (r9 + r12) * 31;
        String r14 = this.e;
        if (r14 == null) goto L21;
        int r15 = r14.hashCode();
    L22:
        int r16 = (r13 + r15) * 31;
        String r17 = this.f;
        if (r17 == null) goto L25;
        int r18 = r17.hashCode();
    L26:
        int r19 = (r16 + r18) * 31;
        String r20 = this.g;
        if (r20 == null) goto L30;
        r1 = r20.hashCode();
    L30:
        return r19 + r1;
    L25:
        r18 = 0;
        goto L26
    L21:
        r15 = 0;
        goto L22
    L17:
        r12 = 0;
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
        return "LotteryUriConfig(anchorLotteryCreateUri=" + this.a + ", anchorLotteryDetailUri=" + this.b + ", anchorLotteryResultlUri=" + this.c + ", audienceLotteryWaitUri=" + this.d + ", audienceLotteryResultUri=" + this.e + ", lotteryAudienceResultWin=" + this.f + ", lotteryAudienceResultFail=" + this.g + ")";
    }

    public b3(String r4, String r5, String r6, String r7, String r8, String r9, int r10) {
        if ((r10 & 1) == 0) goto L5;
        String r0 = "";
    L7:
        if ((r10 & 2) == 0) goto L10;
        r4 = "";
    L10:
        if ((r10 & 4) == 0) goto L13;
        r5 = "";
    L13:
        if ((r10 & 8) == 0) goto L16;
        r6 = "";
    L16:
        if ((r10 & 16) == 0) goto L19;
        r7 = "";
    L19:
        if ((r10 & 32) == 0) goto L22;
        r8 = "";
    L22:
        if ((r10 & 64) == 0) goto L24;
        r9 = "";
    L24:
        Intrinsics.checkNotNullParameter(r0, "anchorLotteryCreateUri");
        Intrinsics.checkNotNullParameter(r4, "anchorLotteryDetailUri");
        Intrinsics.checkNotNullParameter(r5, "anchorLotteryResultlUri");
        Intrinsics.checkNotNullParameter(r6, "audienceLotteryWaitUri");
        Intrinsics.checkNotNullParameter(r7, "audienceLotteryResultUri");
        Intrinsics.checkNotNullParameter(r8, "lotteryAudienceResultWin");
        Intrinsics.checkNotNullParameter(r9, "lotteryAudienceResultFail");
        this.a = r0;
        this.b = r4;
        this.c = r5;
        this.d = r6;
        this.e = r7;
        this.f = r8;
        this.g = r9;
        return;
    L5:
        r0 = null;
        goto L7
    }
}
