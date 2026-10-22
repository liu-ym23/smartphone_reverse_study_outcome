package com.bytedance.android.live.liveinteract.plantform.model;

import android.graphics.Bitmap;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class s0 {
    public final float a;
    public final float b;
    public final int c;
    public final int d;
    public final Bitmap e;
    public final View f;
    public final float g;
    public final View h;
    public final String i;
    public final String j;
    public final Boolean k;
    public final String l;
    public final Integer m;
    public final String n;
    public final Integer o;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof s0) == false) goto L36;
        s0 r4 = (s0) r3;
        if (Float.compare(this.a, r4.a) == 0) goto L8;
        return false;
    L8:
        if (Float.compare(this.b, r4.b) == 0) goto L10;
        return false;
    L10:
        if (this.c == r4.c) goto L12;
        return false;
    L12:
        if (this.d == r4.d) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.e, r4.e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f, r4.f) == true) goto L18;
        return false;
    L18:
        if (Float.compare(this.g, r4.g) == 0) goto L20;
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
        if (Intrinsics.areEqual(this.l, r4.l) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.m, r4.m) == true) goto L32;
        return false;
    L32:
        if (Intrinsics.areEqual(this.n, r4.n) == true) goto L34;
        return false;
    L34:
        if (Intrinsics.areEqual(this.o, r4.o) == true) goto L55;
        return false;
    L55:
        return true;
    L36:
        return false;
    }

    public final int hashCode() {
        int r0 = ((((((Float.floatToIntBits(this.a) * 31) + Float.floatToIntBits(this.b)) * 31) + this.c) * 31) + this.d) * 31;
        Bitmap r1 = this.e;
        int r2 = 0;
        if (r1 == null) goto L5;
        int r3 = r1.hashCode();
    L6:
        int r4 = (r0 + r3) * 31;
        View r5 = this.f;
        if (r5 == null) goto L9;
        int r6 = r5.hashCode();
    L10:
        int r7 = (((r4 + r6) * 31) + Float.floatToIntBits(this.g)) * 31;
        View r8 = this.h;
        if (r8 == null) goto L13;
        int r9 = r8.hashCode();
    L14:
        int r10 = (r7 + r9) * 31;
        String r11 = this.i;
        if (r11 == null) goto L17;
        int r12 = r11.hashCode();
    L18:
        int r13 = (r10 + r12) * 31;
        String r14 = this.j;
        if (r14 == null) goto L21;
        int r15 = r14.hashCode();
    L22:
        int r16 = (r13 + r15) * 31;
        Boolean r17 = this.k;
        if (r17 == null) goto L25;
        int r18 = r17.hashCode();
    L26:
        int r19 = (r16 + r18) * 31;
        String r20 = this.l;
        if (r20 == null) goto L29;
        int r21 = r20.hashCode();
    L30:
        int r22 = (r19 + r21) * 31;
        Integer r23 = this.m;
        if (r23 == null) goto L33;
        int r24 = r23.hashCode();
    L34:
        int r25 = (r22 + r24) * 31;
        String r26 = this.n;
        if (r26 == null) goto L37;
        int r27 = r26.hashCode();
    L38:
        int r28 = (r25 + r27) * 31;
        Integer r29 = this.o;
        if (r29 == null) goto L42;
        r2 = r29.hashCode();
    L42:
        return r28 + r2;
    L37:
        r27 = 0;
        goto L38
    L33:
        r24 = 0;
        goto L34
    L29:
        r21 = 0;
        goto L30
    L25:
        r18 = 0;
        goto L26
    L21:
        r15 = 0;
        goto L22
    L17:
        r12 = 0;
        goto L18
    L13:
        r9 = 0;
        goto L14
    L9:
        r6 = 0;
        goto L10
    L5:
        r3 = 0;
        goto L6
    }

    public final String toString() {
        StringBuilder r0 = new StringBuilder("{LinkerHeadRenderInfo--uid:");
        r0.append(this.i);
        r0.append(", x:");
        r0.append(this.a);
        r0.append(", y:");
        r0.append(this.b);
        r0.append(", width:");
        r0.append(this.c);
        r0.append(", height:");
        r0.append(this.d);
        r0.append(", bimap:");
        Bitmap r1 = this.e;
        if (r1 == null) goto L5;
        int r2 = r1.hashCode();
    L6:
        r0.append(r2);
        r0.append('}');
        return r0.toString();
    L5:
        r2 = 0;
        goto L6
    }

    public /* synthetic */ s0(float r17, float r18, int r19, int r20, float r21, String r22, Boolean r23, int r24) {
        if ((r24 & 512) == 0) goto L5;
        String r10 = "";
    L7:
        if ((r24 & 1024) == 0) goto L9;
        Boolean r11 = null;
    L11:
        if ((r24 & 2048) == 0) goto L13;
        String r12 = "circle";
    L15:
        if ((r24 & 4096) == 0) goto L17;
        Integer r13 = 0;
    L19:
        if ((r24 & 8192) == 0) goto L21;
        String r14 = "";
    L23:
        if ((r24 & 16384) == 0) goto L25;
        Integer r15 = -1;
    L26:
        this(r17, r18, r19, r20, null, null, r21, null, r22, r10, r11, r12, r13, r14, r15);
        return;
    L25:
        r15 = null;
        goto L26
    L21:
        r14 = null;
        goto L23
    L17:
        r13 = null;
        goto L19
    L13:
        r12 = null;
        goto L15
    L9:
        r11 = r23;
        goto L11
    L5:
        r10 = null;
        goto L7
    }

    public s0(float r5, float r6, int r7, int r8, Bitmap r9, View r10, float r11, View r12, String r13, String r14, Boolean r15, String r16, Integer r17, String r18, Integer r19) {
        Intrinsics.checkNotNullParameter(r14, "url");
        Intrinsics.checkNotNullParameter(r18, "linkType");
        this.a = r5;
        this.b = r6;
        this.c = r7;
        this.d = r8;
        this.e = r9;
        this.f = r10;
        this.g = r11;
        this.h = r12;
        this.i = r13;
        this.j = r14;
        this.k = r15;
        this.l = r16;
        this.m = r17;
        this.n = r18;
        this.o = r19;
    }
}
