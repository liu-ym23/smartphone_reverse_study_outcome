package com.larus.bmhome.share.panel;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class n {
    public final Integer a;
    public final String b;
    public final Function0<Unit> c;
    public final Integer d;
    public final CharSequence e;
    public final Integer f;
    public final Float g;
    public final Boolean h;
    public final Boolean i;
    public final Integer j;
    public final Integer k;

    public n() {
        this(null, null, null, null, null, null, null, null, null, null, 2047);
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
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r6.g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.h, r6.h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.i, r6.i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.j, r6.j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.k, r6.k) == true) goto L41;
        return false;
    L41:
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
        Function0<Unit> r7 = this.c;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        Integer r10 = this.d;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        CharSequence r13 = this.e;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        Integer r16 = this.f;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        Float r19 = this.g;
        if (r19 != null) goto L29;
        int r20 = 0;
    L30:
        int r21 = (r18 + r20) * 31;
        Boolean r22 = this.h;
        if (r22 != null) goto L33;
        int r23 = 0;
    L34:
        int r24 = (r21 + r23) * 31;
        Boolean r25 = this.i;
        if (r25 != null) goto L37;
        int r26 = 0;
    L38:
        int r27 = (r24 + r26) * 31;
        Integer r28 = this.j;
        if (r28 != null) goto L41;
        int r29 = 0;
    L42:
        int r30 = (r27 + r29) * 31;
        Integer r31 = this.k;
        if (r31 == null) goto L47;
        r1 = r31.hashCode();
    L47:
        return r30 + r1;
    L41:
        r29 = r28.hashCode();
        goto L42
    L37:
        r26 = r25.hashCode();
        goto L38
    L33:
        r23 = r22.hashCode();
        goto L34
    L29:
        r20 = r19.hashCode();
        goto L30
    L25:
        r17 = r16.hashCode();
        goto L26
    L21:
        r14 = r13.hashCode();
        goto L22
    L17:
        r11 = r10.hashCode();
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
        return "SubTitleConfig(iconRes=" + this.a + ", actionText=" + this.b + ", actionClickListener=" + this.c + ", backgroundRes=" + this.d + ", subTitleText=" + this.e + ", subTitleContainerHorizontalPadding=" + this.f + ", subTitleTextSize=" + this.g + ", subTitleBold=" + this.h + ", actionAutoDismiss=" + this.i + ", subTitleMarginTop=" + this.j + ", subTitleContentVerticalPadding=" + this.k + ')';
    }

    public n(Integer r3, String r4, com.larus.doc.impl.operation.j r5, Integer r6, CharSequence r7, Integer r8, Float r9, Boolean r10, Integer r11, Integer r12, int r13) {
        if ((r13 & 1) == 0) goto L6;
        r3 = null;
    L6:
        if ((r13 & 2) == 0) goto L9;
        r4 = null;
    L9:
        if ((r13 & 4) == 0) goto L12;
        r5 = null;
    L12:
        if ((r13 & 8) == 0) goto L15;
        r6 = null;
    L15:
        if ((r13 & 16) == 0) goto L18;
        r7 = null;
    L18:
        if ((r13 & 32) == 0) goto L21;
        r8 = null;
    L21:
        if ((r13 & 64) == 0) goto L24;
        r9 = null;
    L24:
        if ((r13 & 256) == 0) goto L27;
        r10 = null;
    L27:
        if ((r13 & 512) == 0) goto L30;
        r11 = null;
    L30:
        if ((r13 & 1024) == 0) goto L32;
        r12 = null;
    L32:
        this.a = r3;
        this.b = r4;
        this.c = r5;
        this.d = r6;
        this.e = r7;
        this.f = r8;
        this.g = r9;
        this.h = null;
        this.i = r10;
        this.j = r11;
        this.k = r12;
    }
}
