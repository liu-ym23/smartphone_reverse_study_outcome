package com.bytedance.android.live.profit.dress;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class s extends d {
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final boolean f;
    public final String g;
    public final String h;
    public final String i;
    public final py.k j;
    public final List<Integer> k;
    public final com.bytedance.android.live.profit.dress.config.l l;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof s) == false) goto L30;
        s r4 = (s) r3;
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
        if (this.f == r4.f) goto L18;
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
        if (Intrinsics.areEqual(this.l, r4.l) == true) goto L46;
        return false;
    L46:
        return true;
    L30:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v12, types: [int] */
    /* JADX WARN: Type inference failed for: r2v13, types: [int] */
    /* JADX WARN: Type inference failed for: r2v35 */
    /* JADX WARN: Type inference failed for: r2v40 */
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
        boolean r17 = this.f;
        ?? r18 = r17;
        if (r17 == false) goto L25;
        r18 = 1;
    L25:
        int r19 = (r16 + r18) * 31;
        String r20 = this.g;
        if (r20 == null) goto L28;
        int r22 = r20.hashCode();
    L29:
        int r23 = (r19 + r22) * 31;
        String r24 = this.h;
        if (r24 == null) goto L32;
        int r25 = r24.hashCode();
    L33:
        int r26 = (r23 + r25) * 31;
        String r27 = this.i;
        if (r27 == null) goto L36;
        int r28 = r27.hashCode();
    L37:
        int r29 = (r26 + r28) * 31;
        py.k r30 = this.j;
        if (r30 == null) goto L40;
        int r32 = r30.hashCode();
    L41:
        int r33 = (r29 + r32) * 31;
        List<Integer> r34 = this.k;
        if (r34 == null) goto L44;
        int r35 = r34.hashCode();
    L45:
        int r36 = (r33 + r35) * 31;
        com.bytedance.android.live.profit.dress.config.l r37 = this.l;
        if (r37 == null) goto L49;
        r1 = r37.hashCode();
    L49:
        return r36 + r1;
    L44:
        r35 = 0;
        goto L45
    L40:
        r32 = 0;
        goto L41
    L36:
        r28 = 0;
        goto L37
    L32:
        r25 = 0;
        goto L33
    L28:
        r22 = 0;
        goto L29
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
        return "LinkmicDecoration(name=" + this.a + ", playValueIcon=" + this.b + ", linkmicDynamicEffect=" + this.c + ", beautyEffectId=" + this.d + ", linkmicStaticEffect=" + this.e + ", showFlymicEffect=" + this.f + ", valueBgColor=" + this.g + ", valueNumberColor=" + this.h + ", sponsorBgColor=" + this.i + ", honorIcon=" + this.j + ", playMode=" + this.k + ", starWishConfig=" + this.l + ")";
    }

    public s(String r2, String r3, String r4, String r5, String r6, boolean r7, String r8, String r9, String r10, py.k r12, List<Integer> r13, com.bytedance.android.live.profit.dress.config.l r14) {
        Intrinsics.checkNotNullParameter(r13, "playMode");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
        this.i = r10;
        this.j = r12;
        this.k = r13;
        this.l = r14;
    }
}
