package com.bytedance.android.live.profit.lottery;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class h1 {
    public final long a;
    public final long b;
    public final String c;
    public final String d;
    public final String e;
    public final boolean f;
    public final String g;
    public final ParticipateStatus h;

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof h1) == false) goto L22;
        h1 r7 = (h1) r6;
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
        if (Intrinsics.areEqual(this.e, r7.e) == true) goto L16;
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

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v13, types: [int] */
    /* JADX WARN: Type inference failed for: r0v19 */
    /* JADX WARN: Type inference failed for: r0v23 */
    /* JADX WARN: Type inference failed for: r1v10, types: [int] */
    public final int hashCode() {
        long r0 = this.a;
        int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
        long r3 = this.b;
        int r2 = (r1 + ((int) (r3 ^ (r3 >>> 32)))) * 31;
        String r4 = this.c;
        int r5 = 0;
        if (r4 == null) goto L5;
        int r6 = r4.hashCode();
    L6:
        int r7 = (r2 + r6) * 31;
        String r8 = this.d;
        if (r8 == null) goto L9;
        int r9 = r8.hashCode();
    L10:
        int r10 = (r7 + r9) * 31;
        String r12 = this.e;
        if (r12 == null) goto L13;
        int r13 = r12.hashCode();
    L14:
        int r14 = (r10 + r13) * 31;
        boolean r15 = this.f;
        ?? r16 = r15;
        if (r15 == false) goto L17;
        r16 = 1;
    L17:
        int r17 = (r14 + r16) * 31;
        String r18 = this.g;
        if (r18 == null) goto L20;
        int r19 = r18.hashCode();
    L21:
        int r20 = (r17 + r19) * 31;
        ParticipateStatus r22 = this.h;
        if (r22 == null) goto L25;
        r5 = r22.hashCode();
    L25:
        return r20 + r5;
    L20:
        r19 = 0;
        goto L21
    L13:
        r13 = 0;
        goto L14
    L9:
        r9 = 0;
        goto L10
    L5:
        r6 = 0;
        goto L6
    }

    public final String toString() {
        return "LotteryRefreshInfo(lotteryId=" + this.a + ", lotteryType=" + this.b + ", icon=" + this.c + ", title=" + this.d + ", schema=" + this.e + ", isAnchor=" + this.f + ", toast=" + this.g + ", chooseLotteryStatus=" + this.h + ")";
    }

    public h1(long r1, long r3, String r5, String r6, String r7, boolean r8, String r9, ParticipateStatus r10) {
        this.a = r1;
        this.b = r3;
        this.c = r5;
        this.d = r6;
        this.e = r7;
        this.f = r8;
        this.g = r9;
        this.h = r10;
    }
}
