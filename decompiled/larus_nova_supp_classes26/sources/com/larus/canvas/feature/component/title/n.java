package com.larus.canvas.feature.component.title;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class n implements com.larus.canvas.feature.component.base.d {
    public final Integer a;
    public final String b;
    public final Integer c;
    public final boolean d;
    public final String e;
    public final Integer f;
    public final boolean g;
    public final boolean h;

    public n() {
        this(0);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof n) == true) goto L8;
        return false;
    L8:
        n r6 = (n) r5;
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
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L27;
        return false;
    L27:
        if (this.g == r6.g) goto L30;
        return false;
    L30:
        if (this.h == r6.h) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        Integer r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.b;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Integer r7 = this.c;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        int r10 = 1231;
        if (this.d == false) goto L17;
        int r11 = 1231;
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.e;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        Integer r16 = this.f;
        if (r16 == null) goto L26;
        r1 = r16.hashCode();
    L26:
        int r17 = (r15 + r1) * 31;
        if (this.g == false) goto L29;
        int r18 = 1231;
    L30:
        int r19 = (r17 + r18) * 31;
        if (this.h == true) goto L35;
        r10 = 1237;
    L35:
        return r19 + r10;
    L29:
        r18 = 1237;
        goto L30
    L21:
        r14 = r13.hashCode();
        goto L22
    L17:
        r11 = 1237;
        goto L18
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "TitleUIState(leftIconResId=" + this.a + ", centerText=" + this.b + ", centerImgResId=" + this.c + ", isCenterVisible=" + this.d + ", rightText=" + this.e + ", rightTextColor=" + this.f + ", rightLoadingVisible=" + this.g + ", isRightVisible=" + this.h + ')';
    }

    public /* synthetic */ n(int r10) {
        this(null, null, null, false, null, null, false, false);
    }

    public n(Integer r1, String r2, Integer r3, boolean r4, String r5, Integer r6, boolean r7, boolean r8) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
    }

    public static n a(n r9, Integer r10, String r11, Integer r12, boolean r13, String r14, Integer r15, boolean r16, boolean r17, int r18) {
        if ((r18 & 1) == 0) goto L5;
        Integer r2 = r9.a;
    L7:
        if ((r18 & 2) == 0) goto L9;
        String r3 = r9.b;
    L11:
        if ((r18 & 4) == 0) goto L13;
        Integer r4 = r9.c;
    L15:
        if ((r18 & 8) == 0) goto L17;
        boolean r5 = r9.d;
    L19:
        if ((r18 & 16) == 0) goto L21;
        String r6 = r9.e;
    L23:
        if ((r18 & 32) == 0) goto L25;
        Integer r7 = r9.f;
    L27:
        if ((r18 & 64) == 0) goto L29;
        boolean r8 = r9.g;
    L31:
        if ((r18 & 128) == 0) goto L33;
        boolean r1 = r9.h;
    L34:
        r9.getClass();
        return new n(r2, r3, r4, r5, r6, r7, r8, r1);
    L33:
        r1 = r17;
        goto L34
    L29:
        r8 = r16;
        goto L31
    L25:
        r7 = r15;
        goto L27
    L21:
        r6 = r14;
        goto L23
    L17:
        r5 = r13;
        goto L19
    L13:
        r4 = r12;
        goto L15
    L9:
        r3 = r11;
        goto L11
    L5:
        r2 = r10;
        goto L7
    }
}
