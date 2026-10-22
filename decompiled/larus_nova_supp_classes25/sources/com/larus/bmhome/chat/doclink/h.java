package com.larus.bmhome.chat.doclink;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class h {
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final Integer f;
    public final Integer g;
    public final Integer h;
    public final Integer i;
    public final String j;
    public final String k;
    public final String l;
    public final String m;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof h) == true) goto L8;
        return false;
    L8:
        h r6 = (h) r5;
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
        if (Intrinsics.areEqual(this.k, r6.k) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.l, r6.l) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.m, r6.m) == true) goto L47;
        return false;
    L47:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31;
        String r1 = this.d;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.e;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        Integer r8 = this.f;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (r7 + r9) * 31;
        Integer r11 = this.g;
        if (r11 != null) goto L17;
        int r12 = 0;
    L18:
        int r13 = (r10 + r12) * 31;
        Integer r14 = this.h;
        if (r14 != null) goto L21;
        int r15 = 0;
    L22:
        int r16 = (r13 + r15) * 31;
        Integer r17 = this.i;
        if (r17 != null) goto L25;
        int r18 = 0;
    L26:
        int r19 = (r16 + r18) * 31;
        String r20 = this.j;
        if (r20 != null) goto L29;
        int r21 = 0;
    L30:
        int r22 = (r19 + r21) * 31;
        String r23 = this.k;
        if (r23 != null) goto L33;
        int r24 = 0;
    L34:
        int r25 = (r22 + r24) * 31;
        String r26 = this.l;
        if (r26 != null) goto L37;
        int r27 = 0;
    L38:
        int r28 = (r25 + r27) * 31;
        String r29 = this.m;
        if (r29 == null) goto L43;
        r2 = r29.hashCode();
    L43:
        return r28 + r2;
    L37:
        r27 = r26.hashCode();
        goto L38
    L33:
        r24 = r23.hashCode();
        goto L34
    L29:
        r21 = r20.hashCode();
        goto L30
    L25:
        r18 = r17.hashCode();
        goto L26
    L21:
        r15 = r14.hashCode();
        goto L22
    L17:
        r12 = r11.hashCode();
        goto L18
    L13:
        r9 = r8.hashCode();
        goto L14
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "MessageDocPreviewEntity(previewId=" + this.a + ", title=" + this.b + ", url=" + this.c + ", iconKey=" + this.d + ", iconColorToken=" + this.e + ", iconColorValue=" + this.f + ", iconColorKeyType=" + this.g + ", iconColorKeyValue=" + this.h + ", iconColorKeyAlpha=" + this.i + ", iconUnicode=" + this.j + ", netIconKey=" + this.k + ", fileType=" + this.l + ", matchedUrl=" + this.m + ')';
    }

    public static h a(h r17, String r18, String r19, String r20, int r21) {
        if ((r21 & 1) == 0) goto L5;
        String r4 = r17.a;
    L7:
        if ((r21 & 2) == 0) goto L9;
        String r5 = r17.b;
    L11:
        if ((r21 & 4) == 0) goto L13;
        String r6 = r17.c;
    L15:
        if ((r21 & 8) == 0) goto L17;
        String r7 = r17.d;
    L19:
        if ((r21 & 16) == 0) goto L21;
        String r8 = r17.e;
    L23:
        if ((r21 & 32) == 0) goto L25;
        Integer r9 = r17.f;
    L27:
        if ((r21 & 64) == 0) goto L29;
        Integer r10 = r17.g;
    L31:
        if ((r21 & 128) == 0) goto L33;
        Integer r11 = r17.h;
    L35:
        if ((r21 & 256) == 0) goto L37;
        Integer r12 = r17.i;
    L39:
        if ((r21 & 512) == 0) goto L41;
        String r13 = r17.j;
    L43:
        if ((r21 & 1024) == 0) goto L45;
        String r14 = r17.k;
    L47:
        if ((r21 & 2048) == 0) goto L49;
        String r15 = r17.l;
    L51:
        if ((r21 & 4096) == 0) goto L53;
        String r16 = r17.m;
    L54:
        Intrinsics.checkNotNullParameter(r4, "previewId");
        Intrinsics.checkNotNullParameter(r5, "title");
        Intrinsics.checkNotNullParameter(r6, "url");
        return new h(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16);
    L53:
        r16 = r20;
        goto L54
    L49:
        r15 = null;
        goto L51
    L45:
        r14 = null;
        goto L47
    L41:
        r13 = null;
        goto L43
    L37:
        r12 = null;
        goto L39
    L33:
        r11 = null;
        goto L35
    L29:
        r10 = null;
        goto L31
    L25:
        r9 = null;
        goto L27
    L21:
        r8 = null;
        goto L23
    L17:
        r7 = null;
        goto L19
    L13:
        r6 = r19;
        goto L15
    L9:
        r5 = null;
        goto L11
    L5:
        r4 = r18;
        goto L7
    }

    public h(String r2, String r3, String r4, String r5, String r6, Integer r7, Integer r8, Integer r9, Integer r10, String r11, String r12, String r13, String r14) {
        Intrinsics.checkNotNullParameter(r2, "previewId");
        Intrinsics.checkNotNullParameter(r3, "title");
        Intrinsics.checkNotNullParameter(r4, "url");
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
        this.l = r13;
        this.m = r14;
    }
}
