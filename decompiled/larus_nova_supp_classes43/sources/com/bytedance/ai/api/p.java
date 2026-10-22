package com.bytedance.ai.api;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class p {
    public final Integer a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public final String g;
    public final String h;

    public final boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof p) == true) goto L8;
        return false;
    L8:
        p r11 = (p) r10;
        if (Intrinsics.areEqual(this.a, r11.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r11.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r11.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r11.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r11.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r11.f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r11.g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.h, r11.h) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        Integer r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r10 = 0;
    L6:
        int r11 = r10 * 31;
        String r12 = this.b;
        if (r12 != null) goto L9;
        int r13 = 0;
    L10:
        int r14 = (((((((((((r11 + r13) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31) + this.g.hashCode()) * 31;
        String r15 = this.h;
        if (r15 == null) goto L15;
        r1 = r15.hashCode();
    L15:
        return r14 + r1;
    L9:
        r13 = r12.hashCode();
        goto L10
    L5:
        r10 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "MiniApplicationDialogConfig(iconRes=" + this.a + ", iconResUrl=" + this.b + ", applicationName=" + this.c + ", mainTitle=" + this.d + ", subtitle=" + this.e + ", confirmText=" + this.f + ", cancelText=" + this.g + ", confirmSubText=" + this.h + ')';
    }

    public p(Integer r10, String r11, String r12, String r13, String r14, String r15, String r16, String r17) {
        Intrinsics.checkNotNullParameter(r12, "applicationName");
        Intrinsics.checkNotNullParameter(r13, "mainTitle");
        Intrinsics.checkNotNullParameter(r14, "subtitle");
        Intrinsics.checkNotNullParameter(r15, "confirmText");
        Intrinsics.checkNotNullParameter(r16, "cancelText");
        this.a = r10;
        this.b = r11;
        this.c = r12;
        this.d = r13;
        this.e = r14;
        this.f = r15;
        this.g = r16;
        this.h = r17;
    }
}
