package com.bytedance.ai.applet.app.view;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class m {
    public final int a;
    public final String b;
    public final Integer c;
    public final String d;
    public final int e;
    public final boolean f;
    public final Integer g;
    public final String h;
    public final String i;
    public final Integer j;

    public final boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof m) == true) goto L8;
        return false;
    L8:
        m r11 = (m) r10;
        if (this.a == r11.a) goto L12;
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
        if (this.e == r11.e) goto L24;
        return false;
    L24:
        if (this.f == r11.f) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r11.g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.h, r11.h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.i, r11.i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.j, r11.j) == true) goto L38;
        return false;
    L38:
        return true;
    }

    public final int hashCode() {
        int r0 = ((this.a * 31) + this.b.hashCode()) * 31;
        Integer r1 = this.c;
        int r10 = 0;
        if (r1 != null) goto L5;
        int r11 = 0;
    L6:
        int r12 = (r0 + r11) * 31;
        String r13 = this.d;
        if (r13 != null) goto L9;
        int r14 = 0;
    L10:
        int r15 = (((r12 + r14) * 31) + this.e) * 31;
        if (this.f == false) goto L13;
        int r16 = 1231;
    L14:
        int r17 = (r15 + r16) * 31;
        Integer r18 = this.g;
        if (r18 != null) goto L17;
        int r19 = 0;
    L18:
        int r20 = (r17 + r19) * 31;
        String r21 = this.h;
        if (r21 != null) goto L21;
        int r22 = 0;
    L22:
        int r23 = (r20 + r22) * 31;
        String r24 = this.i;
        if (r24 != null) goto L25;
        int r25 = 0;
    L26:
        int r26 = (r23 + r25) * 31;
        Integer r27 = this.j;
        if (r27 == null) goto L31;
        r10 = r27.hashCode();
    L31:
        return r26 + r10;
    L25:
        r25 = r24.hashCode();
        goto L26
    L21:
        r22 = r21.hashCode();
        goto L22
    L17:
        r19 = r18.hashCode();
        goto L18
    L13:
        r16 = 1237;
        goto L14
    L9:
        r14 = r13.hashCode();
        goto L10
    L5:
        r11 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "MenuItem(itemId=" + this.a + ", title=" + this.b + ", iconRes=" + this.c + ", iconUrl=" + this.d + ", order=" + this.e + ", enable=" + this.f + ", backgroundRes=" + this.g + ", backgroundUrl=" + this.h + ", trackValue=" + this.i + ", titleColor=" + this.j + ')';
    }

    public static m a(m r15, String r16, Integer r17, boolean r18, int r19) {
        if ((r19 & 1) == 0) goto L5;
        int r10 = r15.a;
    L7:
        if ((r19 & 2) == 0) goto L9;
        String r11 = r15.b;
    L11:
        if ((r19 & 4) == 0) goto L13;
        Integer r12 = r15.c;
    L15:
        if ((r19 & 8) == 0) goto L17;
        String r13 = r15.d;
    L19:
        if ((r19 & 16) == 0) goto L21;
        int r14 = r15.e;
    L23:
        if ((r19 & 32) == 0) goto L25;
        boolean r110 = r15.f;
    L27:
        if ((r19 & 64) == 0) goto L29;
        Integer r111 = r15.g;
    L31:
        if ((r19 & 128) == 0) goto L33;
        String r112 = r15.h;
    L35:
        if ((r19 & 256) == 0) goto L37;
        String r113 = r15.i;
    L39:
        if ((r19 & 512) == 0) goto L41;
        Integer r114 = r15.j;
    L42:
        Intrinsics.checkNotNullParameter(r11, "title");
        return new m(r10, r11, r12, r13, r14, r110, r111, r112, r113, r114);
    L41:
        r114 = null;
        goto L42
    L37:
        r113 = null;
        goto L39
    L33:
        r112 = null;
        goto L35
    L29:
        r111 = null;
        goto L31
    L25:
        r110 = r18;
        goto L27
    L21:
        r14 = 0;
        goto L23
    L17:
        r13 = null;
        goto L19
    L13:
        r12 = r17;
        goto L15
    L9:
        r11 = r16;
        goto L11
    L5:
        r10 = 0;
        goto L7
    }

    public /* synthetic */ m(int r15, String r16, Integer r17, int r18, boolean r19, Integer r20, String r21, Integer r22, int r23) {
        if ((r23 & 4) == 0) goto L5;
        Integer r10 = null;
    L7:
        if ((r23 & 64) == 0) goto L9;
        Integer r11 = null;
    L11:
        if ((r23 & 256) == 0) goto L13;
        String r12 = null;
    L15:
        if ((r23 & 512) == 0) goto L17;
        Integer r13 = null;
    L18:
        this(r15, r16, r10, null, r18, r19, r11, null, r12, r13);
        return;
    L17:
        r13 = r22;
        goto L18
    L13:
        r12 = r21;
        goto L15
    L9:
        r11 = r20;
        goto L11
    L5:
        r10 = r17;
        goto L7
    }

    public m(int r10, String r11, Integer r12, String r13, int r14, boolean r15, Integer r16, String r17, String r18, Integer r19) {
        Intrinsics.checkNotNullParameter(r11, "title");
        this.a = r10;
        this.b = r11;
        this.c = r12;
        this.d = r13;
        this.e = r14;
        this.f = r15;
        this.g = r16;
        this.h = r17;
        this.i = r18;
        this.j = r19;
    }
}
