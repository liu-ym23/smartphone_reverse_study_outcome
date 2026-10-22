package com.larus.bmhome.share.panel;

import android.text.TextUtils;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class i {
    public final String a;
    public final n b;
    public final Integer c;
    public final Integer d;
    public final Integer e;
    public final Integer f;
    public final TextUtils.TruncateAt g;
    public final Float h;

    public i() {
        this(null, null, null, null, null, null, null, 255);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof i) == true) goto L8;
        return false;
    L8:
        i r6 = (i) r5;
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
        if (this.g == r6.g) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.h, r6.h) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        String r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        n r4 = this.b;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Integer r7 = this.c;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        Integer r10 = this.d;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        Integer r13 = this.e;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        Integer r16 = this.f;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        TextUtils.TruncateAt r19 = this.g;
        if (r19 != null) goto L29;
        int r20 = 0;
    L30:
        int r21 = (r18 + r20) * 31;
        Float r22 = this.h;
        if (r22 == null) goto L35;
        r1 = r22.hashCode();
    L35:
        return r21 + r1;
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
        return "SharePanelHeaderConfig(title=" + this.a + ", subTitle=" + this.b + ", titleMaxEms=" + this.c + ", titleGravity=" + this.d + ", titleStartMargin=" + this.e + ", titleMaxLines=" + this.f + ", titleEllipsize=" + this.g + ", titleTextSize=" + this.h + ')';
    }

    public i(String r3, n r4, Integer r5, Integer r6, Integer r7, Integer r8, TextUtils.TruncateAt r9, int r10) {
        if ((r10 & 1) == 0) goto L6;
        r3 = null;
    L6:
        if ((r10 & 2) == 0) goto L9;
        r4 = null;
    L9:
        if ((r10 & 4) == 0) goto L12;
        r5 = null;
    L12:
        if ((r10 & 8) == 0) goto L15;
        r6 = null;
    L15:
        if ((r10 & 16) == 0) goto L18;
        r7 = null;
    L18:
        if ((r10 & 32) == 0) goto L21;
        r8 = null;
    L21:
        if ((r10 & 64) == 0) goto L23;
        r9 = null;
    L23:
        this.a = r3;
        this.b = r4;
        this.c = r5;
        this.d = r6;
        this.e = r7;
        this.f = r8;
        this.g = r9;
        this.h = null;
    }
}
