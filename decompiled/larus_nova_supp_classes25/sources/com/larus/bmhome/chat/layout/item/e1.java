package com.larus.bmhome.chat.layout.item;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class e1 {
    public final int a;
    public final boolean b;
    public final boolean c;
    public final boolean d;
    public final boolean e;
    public final boolean f;
    public final String g;
    public final String h;
    public final boolean i;
    public final String j;
    public final boolean k;

    public e1() {
        this(null, 2047);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof e1) == true) goto L8;
        return false;
    L8:
        e1 r6 = (e1) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L18;
        return false;
    L18:
        if (this.d == r6.d) goto L21;
        return false;
    L21:
        if (this.e == r6.e) goto L24;
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
        if (Intrinsics.areEqual(this.j, r6.j) == true) goto L39;
        return false;
    L39:
        if (this.k == r6.k) goto L41;
        return false;
    L41:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a * 31;
        int r2 = 1231;
        if (this.b == false) goto L5;
        int r1 = 1231;
    L6:
        int r3 = (r0 + r1) * 31;
        if (this.c == false) goto L9;
        int r4 = 1231;
    L10:
        int r5 = (r3 + r4) * 31;
        if (this.d == false) goto L13;
        int r6 = 1231;
    L14:
        int r7 = (r5 + r6) * 31;
        if (this.e == false) goto L17;
        int r8 = 1231;
    L18:
        int r9 = (r7 + r8) * 31;
        if (this.f == false) goto L21;
        int r10 = 1231;
    L22:
        int r11 = (r9 + r10) * 31;
        String r12 = this.g;
        int r13 = 0;
        if (r12 != null) goto L25;
        int r14 = 0;
    L26:
        int r15 = (r11 + r14) * 31;
        String r16 = this.h;
        if (r16 != null) goto L29;
        int r17 = 0;
    L30:
        int r18 = (r15 + r17) * 31;
        if (this.i == false) goto L33;
        int r19 = 1231;
    L34:
        int r20 = (r18 + r19) * 31;
        String r21 = this.j;
        if (r21 == null) goto L38;
        r13 = r21.hashCode();
    L38:
        int r22 = (r20 + r13) * 31;
        if (this.k == true) goto L43;
        r2 = 1237;
    L43:
        return r22 + r2;
    L33:
        r19 = 1237;
        goto L34
    L29:
        r17 = r16.hashCode();
        goto L30
    L25:
        r14 = r12.hashCode();
        goto L26
    L21:
        r10 = 1237;
        goto L22
    L17:
        r8 = 1237;
        goto L18
    L13:
        r6 = 1237;
        goto L14
    L9:
        r4 = 1237;
        goto L10
    L5:
        r1 = 1237;
        goto L6
    }

    public final String toString() {
        return "LynxBoxConfig(maxWidthValue=" + this.a + ", disableBackground=" + this.b + ", disableLoading=" + this.c + ", useRadius=" + this.d + ", useCanvasRadius=" + this.e + ", enableStroke=" + this.f + ", initData=" + this.g + ", cardType=" + this.h + ", isForPicShare=" + this.i + ", appletId=" + this.j + ", enableAppletCache=" + this.k + ')';
    }

    public /* synthetic */ e1(String r13, int r14) {
        if ((r14 & 128) == 0) goto L5;
        r13 = null;
    L5:
        String r8 = r13;
        if ((r14 & 1024) == 0) goto L8;
        boolean r11 = true;
    L9:
        this(0, false, false, false, false, false, null, r8, false, null, r11);
        return;
    L8:
        r11 = false;
        goto L9
    }

    public e1(int r1, boolean r2, boolean r3, boolean r4, boolean r5, boolean r6, String r7, String r8, boolean r9, String r10, boolean r11) {
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
        this.k = r11;
    }
}
