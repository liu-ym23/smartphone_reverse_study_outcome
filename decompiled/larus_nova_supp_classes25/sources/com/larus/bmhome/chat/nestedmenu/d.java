package com.larus.bmhome.chat.nestedmenu;

import di8.b0;
import di8.d0;
import di8.f0;
import di8.g0;
import di8.n0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class d implements d0 {
    public final g0 a;
    public final b0 b;
    public final NestedMenuRightModel c;
    public final boolean d;
    public final Float e;
    public final boolean f;
    public final n0 g;
    public final f0 h;
    public final boolean i;
    public final boolean j;
    public final boolean k;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof d) == true) goto L8;
        return false;
    L8:
        d r6 = (d) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (this.d == r6.d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
        return false;
    L24:
        if (this.f == r6.f) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r6.g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.h, r6.h) == true) goto L33;
        return false;
    L33:
        if (this.i == r6.i) goto L36;
        return false;
    L36:
        if (this.j == r6.j) goto L39;
        return false;
    L39:
        if (this.k == r6.k) goto L41;
        return false;
    L41:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31;
        int r2 = 1231;
        if (this.d == false) goto L5;
        int r1 = 1231;
    L6:
        int r3 = (r0 + r1) * 31;
        Float r4 = this.e;
        int r5 = 0;
        if (r4 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r3 + r6) * 31;
        if (this.f == false) goto L13;
        int r8 = 1231;
    L14:
        int r9 = (r7 + r8) * 31;
        n0 r10 = this.g;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        f0 r13 = this.h;
        if (r13 == null) goto L22;
        r5 = r13.hashCode();
    L22:
        int r14 = (r12 + r5) * 31;
        if (this.i == false) goto L25;
        int r15 = 1231;
    L26:
        int r16 = (r14 + r15) * 31;
        if (this.j == false) goto L29;
        int r17 = 1231;
    L30:
        int r18 = (r16 + r17) * 31;
        if (this.k == true) goto L35;
        r2 = 1237;
    L35:
        return r18 + r2;
    L29:
        r17 = 1237;
        goto L30
    L25:
        r15 = 1237;
        goto L26
    L17:
        r11 = r10.hashCode();
        goto L18
    L13:
        r8 = 1237;
        goto L14
    L9:
        r6 = r4.hashCode();
        goto L10
    L5:
        r1 = 1237;
        goto L6
    }

    public final String toString() {
        return "NestedMenuCommonItemModel(left=" + this.a + ", center=" + this.b + ", right=" + this.c + ", enabled=" + this.d + ", alpha=" + this.e + ", canRespondWhenDisabled=" + this.f + ", subMenu=" + this.g + ", sourcePayload=" + this.h + ", dismissMenuAfterClicked=" + this.i + ", removeAroundDivider=" + this.j + ", isHeader=" + this.k + ')';
    }

    @Override // di8.d0
    public final boolean a() {
        return this.j;
    }

    @Override // di8.d0
    public final boolean b() {
        return this.f;
    }

    @Override // di8.d0
    public final f0 c() {
        return this.h;
    }

    @Override // di8.d0
    public final boolean d() {
        return this.i;
    }

    @Override // di8.d0
    public final Float getAlpha() {
        return this.e;
    }

    @Override // di8.d0
    public final b0 getCenter() {
        return this.b;
    }

    @Override // di8.d0
    public final boolean getEnabled() {
        return this.d;
    }

    @Override // di8.d0
    public final g0 getLeft() {
        return this.a;
    }

    @Override // di8.d0
    public final NestedMenuRightModel getRight() {
        return this.c;
    }

    @Override // di8.d0
    public final n0 getSubMenu() {
        return this.g;
    }

    @Override // di8.d0
    public final boolean isHeader() {
        return this.k;
    }

    public static d e(d r12, f0 r13) {
        g0 r1 = r12.a;
        b0 r2 = r12.b;
        NestedMenuRightModel r3 = r12.c;
        boolean r4 = r12.d;
        Float r5 = r12.e;
        boolean r6 = r12.f;
        n0 r7 = r12.g;
        boolean r9 = r12.i;
        boolean r10 = r12.j;
        boolean r11 = r12.k;
        Intrinsics.checkNotNullParameter(r1, "left");
        Intrinsics.checkNotNullParameter(r2, "center");
        Intrinsics.checkNotNullParameter(r3, "right");
        return new d(r1, r2, r3, r4, r5, r6, r7, r13, r9, r10, r11);
    }

    public d(g0 r2, b0 r3, NestedMenuRightModel r4, boolean r5, Float r6, boolean r7, n0 r8, f0 r9, boolean r10, boolean r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r2, "left");
        Intrinsics.checkNotNullParameter(r3, "center");
        Intrinsics.checkNotNullParameter(r4, "right");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
        this.i = r10;
        this.j = r11;
        this.k = r12;
    }

    public /* synthetic */ d(g0 r22, b0 r23, NestedMenuRightModel r24, boolean r25, Float r26, boolean r27, n0 r28, f0 r29, boolean r30, boolean r31, boolean r32, int r33) {
        if ((r33 & 1) == 0) goto L5;
        g0 r10 = new g0(null, null, null, false, null, 63);
    L7:
        if ((r33 & 4) == 0) goto L9;
        NestedMenuRightModel r12 = new NestedMenuRightModel(null, null, null, null, 1023);
    L11:
        if ((r33 & 8) == 0) goto L13;
        boolean r13 = true;
    L15:
        if ((r33 & 16) == 0) goto L17;
        Float r14 = null;
    L19:
        if ((r33 & 32) == 0) goto L21;
        boolean r15 = false;
    L23:
        if ((r33 & 64) == 0) goto L25;
        n0 r16 = null;
    L27:
        if ((r33 & 128) == 0) goto L29;
        f0 r17 = null;
    L31:
        if ((r33 & 256) == 0) goto L33;
        boolean r18 = true;
    L35:
        if ((r33 & 512) == 0) goto L37;
        boolean r19 = false;
    L39:
        if ((r33 & 1024) == 0) goto L41;
        boolean r20 = false;
    L42:
        this(r10, r23, r12, r13, r14, r15, r16, r17, r18, r19, r20);
        return;
    L41:
        r20 = r32;
        goto L42
    L37:
        r19 = r31;
        goto L39
    L33:
        r18 = r30;
        goto L35
    L29:
        r17 = r29;
        goto L31
    L25:
        r16 = r28;
        goto L27
    L21:
        r15 = r27;
        goto L23
    L17:
        r14 = r26;
        goto L19
    L13:
        r13 = r25;
        goto L15
    L9:
        r12 = r24;
        goto L11
    L5:
        r10 = r22;
        goto L7
    }
}
