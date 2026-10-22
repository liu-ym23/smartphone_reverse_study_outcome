package com.obric.oui.material;

import android.content.res.ColorStateList;
import android.os.Parcel;
import com.obric.oui.color.i0;
import com.obric.oui.color.j0;
import java.util.ArrayList;
import java.util.Arrays;
import kma.a;
import kma.b;
import kma.d;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class c {
    public ColorStateList a;
    public a b;
    public com.obric.oui.color.a[] c;
    public kma.c d;
    public i0 e;
    public a f;
    public com.obric.oui.blur.a g;
    public Float h;
    public com.obric.oui.shadow.a[] i;
    public com.obric.oui.fluid.a j;

    public c() {
        this(null, null, null, null, null, null, null, null, 1023);
    }

    public final String toString() {
        return "MaterialConfig(fallbackBgColor=" + this.a + ", blendConfigStateList=" + this.b + ", blendConfig=" + Arrays.toString(this.c) + ", strokeStateList=" + this.d + ", stroke=" + this.e + ", overlayBlendConfigStateList=" + this.f + ", blurConfig=" + this.g + ", blurRadius=" + this.h + ", shadow=" + Arrays.toString(this.i) + ", fluid=" + this.j + ')';
    }

    public final c a() {
        ColorStateList r0 = this.a;
        a r2 = this.b;
        if (r2 != null) goto L5;
        b r3 = null;
    L6:
        com.obric.oui.color.a[] r4 = this.c;
        if (r4 != null) goto L9;
        com.obric.oui.color.b[] r5 = null;
    L10:
        kma.c r6 = this.d;
        if (r6 != null) goto L13;
        d r7 = null;
    L14:
        i0 r8 = this.e;
        if (r8 != null) goto L17;
        j0 r9 = null;
    L18:
        a r10 = this.f;
        if (r10 != null) goto L21;
        b r11 = null;
    L22:
        com.obric.oui.blur.a r12 = this.g;
        if (r12 != null) goto L25;
        com.obric.oui.blur.b r15 = null;
    L26:
        Float r13 = this.h;
        com.obric.oui.shadow.a[] r14 = this.i;
        String r16 = "<this>";
        if (r14 != null) goto L29;
        com.obric.oui.shadow.b[] r17 = null;
    L35:
        com.obric.oui.fluid.a r18 = this.j;
        if (r18 != null) goto L38;
        com.obric.oui.fluid.b r19 = null;
    L40:
        if (r0 == null) goto L42;
        ColorStateList r110 = r0;
    L43:
        if (r3 == null) goto L45;
        b r111 = r3.b();
    L46:
        com.obric.oui.color.b r1 = com.obric.oui.color.b.c;
        if (r5 != null) goto L49;
        com.obric.oui.color.b[] r112 = null;
    L58:
        if (r7 == null) goto L76;
        int[][] r20 = new int[r7.a.length][];
        int r21 = 0;
    L60:
        int[][] r22 = r7.a;
        if (r21 >= r22.length) goto L63;
        int[] r23 = r22[r21];
        r20[r21] = Arrays.copyOf(r23, r23.length);
        r21 = r21 + 1;
        goto L60
    L63:
        j0[] r24 = new j0[r7.b.length];
        int r25 = 0;
    L64:
        j0[] r113 = r7.b;
        if (r25 >= r113.length) goto L71;
        j0 r114 = r113[r25];
        if (r114 != null) goto L69;
        j0 r115 = null;
    L70:
        r24[r25] = r115;
        r25 = r25 + 1;
        r16 = r16;
        goto L64
    L69:
        r115 = new j0(r114.a, r114.b, r114.c);
        goto L70
    L71:
        String r27 = r16;
        j0 r26 = r7.c;
        if (r26 != null) goto L74;
        j0 r116 = null;
    L75:
        d r28 = new d(r20, r24, r116);
    L77:
        if (r9 == null) goto L79;
        j0 r29 = new j0(r9.a, r9.b, r9.c);
    L80:
        if (r11 == null) goto L82;
        b r210 = r11.b();
    L83:
        if (r15 == null) goto L85;
        com.obric.oui.blur.b r211 = new com.obric.oui.blur.b(r15.a, r15.b, r15.c, r15.d, r15.e);
    L86:
        if (r17 != null) goto L88;
        com.obric.oui.shadow.b[] r212 = null;
    L97:
        if (r19 == null) goto L103;
        float[] r30 = r19.a;
        if (r30 == null) goto L101;
        float[] r31 = (float[]) r30.clone();
    L102:
        com.obric.oui.fluid.b r213 = new com.obric.oui.fluid.b(r31);
    L104:
        c r32 = f.a(new e(r110, r111, r112, r28, r29, r210, r211, r13, r212, r213));
        ColorStateList r33 = this.a;
        if (r33 != null) goto L107;
        ColorStateList r34 = null;
    L110:
        r32.a = r34;
        return r32;
    L107:
        Intrinsics.checkNotNullParameter(r33, r27);
        Parcel r35 = Parcel.obtain();
        r33.writeToParcel(r35, 0);     // Catch: Throwable -> L112
        r35.setDataPosition(0);     // Catch: Throwable -> L112
        ColorStateList r36 = (ColorStateList) ColorStateList.CREATOR.createFromParcel(r35);     // Catch: Throwable -> L112
        r35.recycle();
        r34 = r36;
    L112:
        th = move-exception;
        r35.recycle();
        throw th;
    L101:
        r31 = null;
        goto L102
    L103:
        r213 = null;
        goto L104
    L88:
        com.obric.oui.shadow.b[] r37 = new com.obric.oui.shadow.b[r17.length];
        int r38 = 0;
    L90:
        if (r38 >= r17.length) goto L96;
        com.obric.oui.shadow.b r39 = r17[r38];
        if (r39 != null) goto L94;
        com.obric.oui.shadow.b r40 = null;
    L95:
        r37[r38] = r40;
        r38 = r38 + 1;
        goto L90
    L94:
        r40 = new com.obric.oui.shadow.b(r39.a, r39.b, r39.c, r39.d, r39.e, r39.f);
        goto L95
    L96:
        r212 = r37;
        goto L97
    L85:
        r211 = null;
        goto L86
    L82:
        r210 = null;
        goto L83
    L79:
        r29 = null;
        goto L80
    L74:
        r116 = new j0(r26.a, r26.b, r26.c);
        goto L75
    L76:
        r27 = "<this>";
        r28 = null;
        goto L77
    L49:
        com.obric.oui.color.b[] r41 = new com.obric.oui.color.b[r5.length];
        int r42 = 0;
    L51:
        if (r42 >= r5.length) goto L57;
        com.obric.oui.color.b r117 = r5[r42];
        if (r117 != null) goto L55;
        com.obric.oui.color.b r118 = null;
    L56:
        r41[r42] = r118;
        r42 = r42 + 1;
        goto L51
    L55:
        r118 = new com.obric.oui.color.b(r117.a, r117.b);
        goto L56
    L57:
        r112 = r41;
        goto L58
    L45:
        r111 = null;
        goto L46
    L42:
        r110 = null;
        goto L43
    L38:
        r19 = new com.obric.oui.fluid.b(r18.a);
        goto L40
    L29:
        Intrinsics.checkNotNullParameter(r14, "<this>");
        ArrayList r119 = new ArrayList(r14.length);
        int r120 = r14.length;
        int r121 = 0;
    L30:
        if (r121 >= r120) goto L32;
        r119.add(r14[r121].b());
        r121 = r121 + 1;
        goto L30
    L32:
        Object[] r43 = r119.toArray(new com.obric.oui.shadow.b[0]);
        if (r43 == null) goto L116;
        r17 = (com.obric.oui.shadow.b[]) r43;
        goto L35
    L116:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    L25:
        r15 = new com.obric.oui.blur.b(r12.a, r12.b, r12.c, r12.d, r12.e);
        goto L26
    L21:
        r11 = r10.a;
        goto L22
    L17:
        r9 = r8.a();
        goto L18
    L13:
        r7 = r6.a;
        goto L14
    L9:
        r5 = com.obric.oui.color.c.b(r4);
        goto L10
    L5:
        r3 = r2.a;
        goto L6
    }

    public final int hashCode() {
        Float r0 = this.h;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        ColorStateList r4 = this.a;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        a r7 = this.b;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        com.obric.oui.color.a[] r10 = this.c;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        kma.c r13 = this.d;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        i0 r16 = this.e;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        a r19 = this.f;
        if (r19 != null) goto L29;
        int r20 = 0;
    L30:
        int r21 = (r18 + r20) * 31;
        com.obric.oui.blur.a r22 = this.g;
        if (r22 != null) goto L33;
        int r23 = 0;
    L34:
        int r24 = (r21 + r23) * 31;
        com.obric.oui.shadow.a[] r25 = this.i;
        if (r25 != null) goto L37;
        int r26 = 0;
    L38:
        int r27 = (r24 + r26) * 31;
        com.obric.oui.fluid.a r28 = this.j;
        if (r28 == null) goto L43;
        r1 = r28.hashCode();
    L43:
        return r27 + r1;
    L37:
        r26 = Arrays.hashCode(r25);
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
        r11 = Arrays.hashCode(r10);
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

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L8;
        Class<?> r2 = null;
    L10:
        if (Intrinsics.areEqual(c.class, r2) == true) goto L12;
        return false;
    L12:
        if (r5 == null) goto L45;
        c r6 = (c) r5;
        if (Intrinsics.areEqual(this.h, r6.h) == true) goto L17;
        return false;
    L17:
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L23;
        return false;
    L23:
        if (Arrays.equals(this.c, r6.c) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L29;
        return false;
    L29:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L32;
        return false;
    L32:
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L35;
        return false;
    L35:
        if (Intrinsics.areEqual(this.g, r6.g) == true) goto L38;
        return false;
    L38:
        if (Arrays.equals(this.i, r6.i) == true) goto L41;
        return false;
    L41:
        if (Intrinsics.areEqual(this.j, r6.j) == true) goto L43;
        return false;
    L43:
        return true;
    L45:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.material.MaterialConfig");
    L8:
        r2 = r5.getClass();
        goto L10
    }

    public /* synthetic */ c(ColorStateList r15, a r16, com.obric.oui.color.a[] r17, i0 r18, com.obric.oui.blur.a r19, Float r20, com.obric.oui.shadow.a[] r21, com.obric.oui.fluid.a r22, int r23) {
        if ((r23 & 1) == 0) goto L5;
        ColorStateList r4 = null;
    L7:
        if ((r23 & 2) == 0) goto L9;
        a r5 = null;
    L11:
        if ((r23 & 4) == 0) goto L13;
        com.obric.oui.color.a[] r6 = null;
    L15:
        if ((r23 & 16) == 0) goto L17;
        i0 r8 = null;
    L19:
        if ((r23 & 64) == 0) goto L21;
        com.obric.oui.blur.a r10 = null;
    L23:
        if ((r23 & 128) == 0) goto L25;
        Float r11 = null;
    L27:
        if ((r23 & 256) == 0) goto L29;
        com.obric.oui.shadow.a[] r12 = null;
    L31:
        if ((r23 & 512) == 0) goto L33;
        com.obric.oui.fluid.a r13 = null;
    L34:
        this(r4, r5, r6, null, r8, null, r10, r11, r12, r13);
        return;
    L33:
        r13 = r22;
        goto L34
    L29:
        r12 = r21;
        goto L31
    L25:
        r11 = r20;
        goto L27
    L21:
        r10 = r19;
        goto L23
    L17:
        r8 = r18;
        goto L19
    L13:
        r6 = r17;
        goto L15
    L9:
        r5 = r16;
        goto L11
    L5:
        r4 = r15;
        goto L7
    }

    public c(ColorStateList r1, a r2, com.obric.oui.color.a[] r3, kma.c r4, i0 r5, a r6, com.obric.oui.blur.a r7, Float r8, com.obric.oui.shadow.a[] r9, com.obric.oui.fluid.a r10) {
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
    }
}
