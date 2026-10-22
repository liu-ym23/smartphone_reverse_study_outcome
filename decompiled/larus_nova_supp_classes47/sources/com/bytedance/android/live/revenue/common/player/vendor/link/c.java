package com.bytedance.android.live.revenue.common.player.vendor.link;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c {
    public final boolean a;
    public final boolean b;
    public final boolean c;
    public final int d;
    public final int e;
    public final int f;
    public final int g;
    public final int h;
    public final boolean i;
    public final RevSeiFrame j;
    public final boolean k;
    public final boolean l;
    public final boolean m;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof c) == false) goto L32;
        c r4 = (c) r3;
        if (this.a == r4.a) goto L8;
        return false;
    L8:
        if (this.b == r4.b) goto L10;
        return false;
    L10:
        if (this.c == r4.c) goto L12;
        return false;
    L12:
        if (this.d == r4.d) goto L14;
        return false;
    L14:
        if (this.e == r4.e) goto L16;
        return false;
    L16:
        if (this.f == r4.f) goto L18;
        return false;
    L18:
        if (this.g == r4.g) goto L20;
        return false;
    L20:
        if (this.h == r4.h) goto L22;
        return false;
    L22:
        if (this.i == r4.i) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.j, r4.j) == true) goto L26;
        return false;
    L26:
        if (this.k == r4.k) goto L28;
        return false;
    L28:
        if (this.l == r4.l) goto L30;
        return false;
    L30:
        if (this.m == r4.m) goto L49;
        return false;
    L49:
        return true;
    L32:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v17, types: [int] */
    /* JADX WARN: Type inference failed for: r0v21, types: [int] */
    /* JADX WARN: Type inference failed for: r0v23, types: [int] */
    /* JADX WARN: Type inference failed for: r0v25, types: [int] */
    /* JADX WARN: Type inference failed for: r0v26 */
    /* JADX WARN: Type inference failed for: r0v27 */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v10, types: [int] */
    /* JADX WARN: Type inference failed for: r2v15, types: [int] */
    /* JADX WARN: Type inference failed for: r2v17, types: [int] */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r2v22 */
    /* JADX WARN: Type inference failed for: r2v23 */
    /* JADX WARN: Type inference failed for: r2v24 */
    /* JADX WARN: Type inference failed for: r2v25 */
    /* JADX WARN: Type inference failed for: r2v26 */
    /* JADX WARN: Type inference failed for: r2v27 */
    /* JADX WARN: Type inference failed for: r2v28 */
    /* JADX WARN: Type inference failed for: r2v29 */
    /* JADX WARN: Type inference failed for: r2v3, types: [int] */
    public final int hashCode() {
        boolean r0 = this.a;
        ?? r1 = 1;
        ?? r2 = r0;
        if (r0 == false) goto L5;
        r2 = 1;
    L5:
        int r3 = r2 * 31;
        boolean r4 = this.b;
        ?? r5 = r4;
        if (r4 == false) goto L8;
        r5 = 1;
    L8:
        int r6 = (r3 + r5) * 31;
        boolean r7 = this.c;
        ?? r8 = r7;
        if (r7 == false) goto L11;
        r8 = 1;
    L11:
        int r9 = (((((((((((r6 + r8) * 31) + this.d) * 31) + this.e) * 31) + this.f) * 31) + this.g) * 31) + this.h) * 31;
        boolean r10 = this.i;
        ?? r12 = r10;
        if (r10 == false) goto L14;
        r12 = 1;
    L14:
        int r13 = (r9 + r12) * 31;
        RevSeiFrame r14 = this.j;
        if (r14 == null) goto L17;
        int r15 = r14.hashCode();
    L18:
        int r16 = (r13 + r15) * 31;
        boolean r17 = this.k;
        ?? r18 = r17;
        if (r17 == false) goto L21;
        r18 = 1;
    L21:
        int r19 = (r16 + r18) * 31;
        boolean r20 = this.l;
        ?? r22 = r20;
        if (r20 == false) goto L24;
        r22 = 1;
    L24:
        int r23 = (r19 + r22) * 31;
        boolean r24 = this.m;
        if (r24 == true) goto L29;
        r1 = r24;
    L29:
        return r23 + r1;
    L17:
        r15 = 0;
        goto L18
    }

    public final String toString() {
        return "StrategyReduceContext(isPad=" + this.a + ", isFoldScreenFullType=" + this.b + ", isPortrait=" + this.c + ", containerWidth=" + this.d + ", containerHeight=" + this.e + ", videoWidth=" + this.f + ", videoHeight=" + this.g + ", topOffset=" + this.h + ", hasStatusBar=" + this.i + ", seiFrame=" + this.j + ", isPcVrRoom=" + this.k + ", isLiveTypeAudio=" + this.l + ", isScreenRecord=" + this.m + ")";
    }

    public c(boolean r2, boolean r3, boolean r4, int r5, int r6, int r7, int r8, int r9, RevSeiFrame r10, boolean r12, boolean r13, boolean r14) {
        Intrinsics.checkNotNullParameter(r10, "seiFrame");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
        this.i = true;
        this.j = r10;
        this.k = r12;
        this.l = r13;
        this.m = r14;
    }
}
