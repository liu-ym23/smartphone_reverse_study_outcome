package com.bytedance.android.live.profit.dress;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class v extends d {
    public final long a;
    public final long b;
    public final int c;
    public final py.k d;
    public final py.k e;
    public final py.k f;
    public final py.k g;
    public final com.bytedance.android.live.base.model.d h;
    public final py.k i;
    public final com.bytedance.android.live.base.model.d j;
    public final py.k k;

    public final int hashCode() {
        long r0 = this.a;
        int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
        long r3 = this.b;
        int r2 = (((r1 + ((int) (r3 ^ (r3 >>> 32)))) * 31) + this.c) * 31;
        py.k r4 = this.d;
        int r5 = 0;
        if (r4 == null) goto L5;
        int r6 = r4.hashCode();
    L6:
        int r7 = (r2 + r6) * 31;
        py.k r8 = this.e;
        if (r8 == null) goto L9;
        int r9 = r8.hashCode();
    L10:
        int r10 = (r7 + r9) * 31;
        py.k r12 = this.f;
        if (r12 == null) goto L13;
        int r13 = r12.hashCode();
    L14:
        int r14 = (r10 + r13) * 31;
        py.k r15 = this.g;
        if (r15 == null) goto L17;
        int r16 = r15.hashCode();
    L18:
        int r17 = (r14 + r16) * 31;
        com.bytedance.android.live.base.model.d r18 = this.h;
        if (r18 == null) goto L21;
        int r19 = r18.hashCode();
    L22:
        int r20 = (r17 + r19) * 31;
        py.k r22 = this.i;
        if (r22 == null) goto L25;
        int r23 = r22.hashCode();
    L26:
        int r24 = (r20 + r23) * 31;
        com.bytedance.android.live.base.model.d r25 = this.j;
        if (r25 == null) goto L29;
        int r26 = r25.hashCode();
    L30:
        int r27 = (r24 + r26) * 31;
        py.k r28 = this.k;
        if (r28 == null) goto L34;
        r5 = r28.hashCode();
    L34:
        return r27 + r5;
    L29:
        r26 = 0;
        goto L30
    L25:
        r23 = 0;
        goto L26
    L21:
        r19 = 0;
        goto L22
    L17:
        r16 = 0;
        goto L18
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
        return "ProfileSkinDress(parallaxAssetId=" + this.a + ", otherAssetId=" + this.b + ", flashCardAssetId=" + this.c + ", panelBgPng=" + this.d + ", panelEnterWebp=" + this.e + ", panelLoopWebp=" + this.f + ", panelRightPng=" + this.g + ", border9Png=" + this.h + ", borderPng=" + this.i + ", mainButton9Png=" + this.j + ", mainButtonWebp=" + this.k + ")";
    }

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof v) == false) goto L28;
        v r7 = (v) r6;
        if (this.a == r7.a) goto L8;
        return false;
    L8:
        if (this.b == r7.b) goto L10;
        return false;
    L10:
        if (this.c == r7.c) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.d, r7.d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.e, r7.e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f, r7.f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.g, r7.g) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.h, r7.h) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.i, r7.i) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.j, r7.j) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.k, r7.k) == true) goto L43;
        return false;
    L43:
        return true;
    L28:
        return false;
    }

    public v(long r1, long r3, int r5, py.k r6, py.k r7, py.k r8, py.k r9, com.bytedance.android.live.base.model.d r10, py.k r12, com.bytedance.android.live.base.model.d r13, py.k r14) {
        this.a = r1;
        this.b = r3;
        this.c = r5;
        this.d = r6;
        this.e = r7;
        this.f = r8;
        this.g = r9;
        this.h = r10;
        this.i = r12;
        this.j = r13;
        this.k = r14;
    }
}
