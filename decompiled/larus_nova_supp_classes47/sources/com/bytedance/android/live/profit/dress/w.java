package com.bytedance.android.live.profit.dress;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class w extends d {
    public final String a;
    public final py.k b;
    public final py.k c;
    public final py.k d;
    public final py.k e;
    public final py.k f;
    public final py.k g;
    public final py.k h;
    public final py.k i;
    public final py.k j;
    public final py.k k;
    public final py.k l;
    public final String m;
    public final Map<Long, com.bytedance.android.live.profit.dress.config.v> n;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof w) == false) goto L34;
        w r4 = (w) r3;
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
        if (Intrinsics.areEqual(this.g, r4.g) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.h, r4.h) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.i, r4.i) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.j, r4.j) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.k, r4.k) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.l, r4.l) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.m, r4.m) == true) goto L32;
        return false;
    L32:
        if (Intrinsics.areEqual(this.n, r4.n) == true) goto L52;
        return false;
    L52:
        return true;
    L34:
        return false;
    }

    public final int hashCode() {
        String r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        py.k r4 = this.b;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        py.k r7 = this.c;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        py.k r10 = this.d;
        if (r10 == null) goto L17;
        int r12 = r10.hashCode();
    L18:
        int r13 = (r9 + r12) * 31;
        py.k r14 = this.e;
        if (r14 == null) goto L21;
        int r15 = r14.hashCode();
    L22:
        int r16 = (r13 + r15) * 31;
        py.k r17 = this.f;
        if (r17 == null) goto L25;
        int r18 = r17.hashCode();
    L26:
        int r19 = (r16 + r18) * 31;
        py.k r20 = this.g;
        if (r20 == null) goto L29;
        int r22 = r20.hashCode();
    L30:
        int r23 = (r19 + r22) * 31;
        py.k r24 = this.h;
        if (r24 == null) goto L33;
        int r25 = r24.hashCode();
    L34:
        int r26 = (r23 + r25) * 31;
        py.k r27 = this.i;
        if (r27 == null) goto L37;
        int r28 = r27.hashCode();
    L38:
        int r29 = (r26 + r28) * 31;
        py.k r30 = this.j;
        if (r30 == null) goto L41;
        int r32 = r30.hashCode();
    L42:
        int r33 = (r29 + r32) * 31;
        py.k r34 = this.k;
        if (r34 == null) goto L45;
        int r35 = r34.hashCode();
    L46:
        int r36 = (r33 + r35) * 31;
        py.k r37 = this.l;
        if (r37 == null) goto L49;
        int r38 = r37.hashCode();
    L50:
        int r39 = (r36 + r38) * 31;
        String r40 = this.m;
        if (r40 == null) goto L53;
        int r42 = r40.hashCode();
    L54:
        int r43 = (r39 + r42) * 31;
        Map<Long, com.bytedance.android.live.profit.dress.config.v> r44 = this.n;
        if (r44 == null) goto L58;
        r1 = r44.hashCode();
    L58:
        return r43 + r1;
    L53:
        r42 = 0;
        goto L54
    L49:
        r38 = 0;
        goto L50
    L45:
        r35 = 0;
        goto L46
    L41:
        r32 = 0;
        goto L42
    L37:
        r28 = 0;
        goto L38
    L33:
        r25 = 0;
        goto L34
    L29:
        r22 = 0;
        goto L30
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
        return "RedPacketSkinDress(name=" + this.a + ", shortTouchWaitingPng=" + this.b + ", shortTouchEmptyHideWebp=" + this.c + ", shortTouchEmptyMoreWebp=" + this.d + ", shortTouchEntryPng=" + this.e + ", topCover=" + this.f + ", bottomCover=" + this.g + ", background=" + this.h + ", border=" + this.i + ", resultCard=" + this.j + ", countDownBackground=" + this.k + ", blessIcon=" + this.l + ", blessWord=" + this.m + ", surpriseGift=" + this.n + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public w(String r1, py.k r2, py.k r3, py.k r4, py.k r5, py.k r6, py.k r7, py.k r8, py.k r9, py.k r10, py.k r12, py.k r13, String r14, Map<Long, ? extends com.bytedance.android.live.profit.dress.config.v> r15) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
        this.i = r9;
        this.j = r10;
        this.k = r12;
        this.l = r13;
        this.m = r14;
        this.n = r15;
    }
}
