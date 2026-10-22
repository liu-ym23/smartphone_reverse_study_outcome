package com.larus.bmhome.bigimg;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class l {
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public final String g;
    public final Integer h;
    public final String i;
    public final String j;
    public final String k;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof l) == true) goto L8;
        return false;
    L8:
        l r6 = (l) r5;
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
        String r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = ((((((r2 * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31;
        String r4 = this.e;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.f;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.g;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        Integer r13 = this.h;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        String r16 = this.i;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        String r19 = this.j;
        if (r19 != null) goto L29;
        int r20 = 0;
    L30:
        int r21 = (r18 + r20) * 31;
        String r22 = this.k;
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
        return "BigImageInfo(itemId=" + this.a + ", imageUrl=" + this.b + ", imageUri=" + this.c + ", imageThumbUrl=" + this.d + ", shortId=" + this.e + ", sourceName=" + this.f + ", sourceIcon=" + this.g + ", sourceFrom=" + this.h + ", jumpUrl=" + this.i + ", imageCaption=" + this.j + ", docId=" + this.k + ')';
    }

    public /* synthetic */ l(String r16, String r17, String r18, String r19, String r20, String r21, String r22, Integer r23, String r24, String r25, int r26) {
        if ((r26 & 1) == 0) goto L5;
        String r4 = null;
    L7:
        if ((r26 & 16) == 0) goto L9;
        String r8 = null;
    L11:
        if ((r26 & 32) == 0) goto L13;
        String r9 = null;
    L15:
        if ((r26 & 64) == 0) goto L17;
        String r10 = null;
    L19:
        if ((r26 & 128) == 0) goto L21;
        Integer r11 = null;
    L23:
        if ((r26 & 256) == 0) goto L25;
        String r12 = null;
    L27:
        if ((r26 & 512) == 0) goto L29;
        String r13 = null;
    L30:
        this(r4, r17, r18, r19, r8, r9, r10, r11, r12, r13, null);
        return;
    L29:
        r13 = r25;
        goto L30
    L25:
        r12 = r24;
        goto L27
    L21:
        r11 = r23;
        goto L23
    L17:
        r10 = r22;
        goto L19
    L13:
        r9 = r21;
        goto L15
    L9:
        r8 = r20;
        goto L11
    L5:
        r4 = r16;
        goto L7
    }

    public l(String r2, String r3, String r4, String r5, String r6, String r7, String r8, Integer r9, String r10, String r11, String r12) {
        Intrinsics.checkNotNullParameter(r3, "imageUrl");
        Intrinsics.checkNotNullParameter(r4, "imageUri");
        Intrinsics.checkNotNullParameter(r5, "imageThumbUrl");
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
}
