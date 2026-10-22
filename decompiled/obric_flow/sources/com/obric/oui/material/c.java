package com.obric.oui.material;

import android.content.res.ColorStateList;
import android.os.Parcel;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ColorStateList f13609a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public cs.a f13610b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public com.obric.oui.color.a[] f13611c;
    public cs.c d;
    public com.obric.oui.color.d e;
    public cs.a f;
    public xq.a g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Float f13612h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public es.a[] f13613i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public com.obric.oui.fluid.a f13614j;

    public c(ColorStateList r5, cs.a r10, com.obric.oui.color.a[] r11, cs.c r12, com.obric.oui.color.d r13, cs.a r14, xq.a r15, Float r16, es.a[] r17, com.obric.oui.fluid.a r18) {
        this.f13609a = r5;
        this.f13610b = r10;
        this.f13611c = r11;
        this.d = r12;
        this.e = r13;
        this.f = r14;
        this.g = r15;
        this.f13612h = r16;
        this.f13613i = r17;
        this.f13614j = r18;
    }

    public final c a() {
        ColorStateList r5 = this.f13609a;
        int r10 = 0;
        if (r5 == null) goto L10;
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Parcel r11 = Parcel.obtain();
        r5.writeToParcel(r11, 0);     // Catch: Throwable -> L7
        r11.setDataPosition(0);     // Catch: Throwable -> L7
        ColorStateList r12 = (ColorStateList) ColorStateList.CREATOR.createFromParcel(r11);     // Catch: Throwable -> L7
        r11.recycle();
    L11:
        cs.a r13 = this.f13610b;
        if (r13 == null) goto L14;
        cs.a r14 = r13.a();
    L15:
        com.obric.oui.color.a[] r15 = this.f13611c;
        if (r15 != null) goto L18;
        com.obric.oui.color.a[] r16 = null;
    L26:
        cs.c r17 = this.d;
        if (r17 == null) goto L51;
        int[][] r18 = r17.f16504a;
        ArrayList r19 = new ArrayList(r18.length);
        int r20 = r18.length;
        int r110 = 0;
    L29:
        if (r110 >= r20) goto L31;
        int[] r111 = r18[r110];
        r19.add(Arrays.copyOf(r111, r111.length));
        r110 = r110 + 1;
        goto L29
    L31:
        Object[] r21 = r19.toArray(new int[0][]);
        if (r21 == null) goto L50;
        int[][] r22 = (int[][]) r21;
        com.obric.oui.color.d[] r112 = r17.f16505b;
        ArrayList r23 = new ArrayList(r112.length);
        int r113 = r112.length;
        int r114 = 0;
    L34:
        if (r114 >= r113) goto L40;
        com.obric.oui.color.d r115 = r112[r114];
        if (r115 != null) goto L38;
        com.obric.oui.color.d r116 = null;
    L39:
        r23.add(r116);
        r114 = r114 + 1;
        goto L34
    L38:
        r116 = r115.a();
        goto L39
    L40:
        Object[] r24 = r23.toArray(new com.obric.oui.color.d[0]);
        if (r24 == null) goto L48;
        com.obric.oui.color.d[] r25 = (com.obric.oui.color.d[]) r24;
        com.obric.oui.color.d r26 = r17.f16506c;
        if (r26 != null) goto L45;
        com.obric.oui.color.d r27 = null;
    L46:
        cs.c r28 = new cs.c(r22, r25, r27);
    L52:
        com.obric.oui.color.d r29 = this.e;
        if (r29 == null) goto L55;
        com.obric.oui.color.d r30 = r29.a();
    L56:
        cs.a r31 = this.f;
        if (r31 == null) goto L59;
        cs.a r32 = r31.a();
    L60:
        xq.a r33 = this.g;
        if (r33 == null) goto L63;
        float r117 = r33.f23207a;
        int r118 = r33.f23208b;
        xq.a r119 = new xq.a(r117, r33.f23209c, r33.e, r118, r33.d);
    L64:
        es.a[] r34 = this.f13613i;
        if (r34 != null) goto L67;
        cs.a r210 = r32;
        es.a[] r35 = null;
    L76:
        com.obric.oui.fluid.a r36 = this.f13614j;
        if (r36 == null) goto L83;
        float[] r37 = r36.f13225a;
        if (r37 == null) goto L81;
        float[] r38 = (float[]) r37.clone();
    L82:
        com.obric.oui.fluid.a r120 = new com.obric.oui.fluid.a(r38);
    L85:
        return new c(r12, r14, r16, r28, r30, r210, r119, this.f13612h, r35, r120);
    L81:
        r38 = null;
        goto L82
    L83:
        r120 = null;
        goto L85
    L67:
        es.a[] r121 = new es.a[r34.length];
    L69:
        if (r10 >= r34.length) goto L75;
        es.a r122 = r34[r10];
        if (r122 == null) goto L73;
        es.b r123 = r122.a();
        int r124 = r123.f;
        float r125 = r123.f16862b;
        float r39 = r123.e;
        es.a r40 = es.c.a(new es.b(r123.d, r124, r123.f16861a, r125, r123.f16863c, r39));
    L74:
        r121[r10] = r40;
        r10 = r10 + 1;
        r34 = r34;
        r32 = r32;
        goto L69
    L73:
        r40 = null;
        goto L74
    L75:
        r210 = r32;
        r35 = r121;
        goto L76
    L63:
        r119 = null;
        goto L64
    L59:
        r32 = null;
        goto L60
    L55:
        r30 = null;
        goto L56
    L45:
        r27 = r26.a();
        goto L46
    L48:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    L50:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    L51:
        r28 = null;
        goto L52
    L18:
        r16 = new com.obric.oui.color.a[r15.length];
        int r41 = 0;
    L20:
        if (r41 >= r15.length) goto L26;
        com.obric.oui.color.a r42 = r15[r41];
        if (r42 == null) goto L24;
        com.obric.oui.color.a r126 = new com.obric.oui.color.a(r42.f12398a, r42.f12399b);
    L25:
        r16[r41] = r126;
        r41 = r41 + 1;
        goto L20
    L24:
        r126 = null;
        goto L25
    L14:
        r14 = null;
    L7:
        th = move-exception;
        r11.recycle();
        throw th;
    L10:
        r12 = null;
        goto L11
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L5;
        return true;
    L5:
        if (r5 != null) goto L7;
        Class<?> r10 = null;
    L9:
        if (Intrinsics.areEqual(c.class, r10) == true) goto L11;
        return false;
    L11:
        if (r5 == null) goto L44;
        c r11 = (c) r5;
        if (Intrinsics.areEqual(this.f13612h, r11.f13612h) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f13609a, r11.f13609a) == true) goto L19;
        return false;
    L19:
        if (Intrinsics.areEqual(this.f13610b, r11.f13610b) == true) goto L22;
        return false;
    L22:
        if (Arrays.equals(this.f13611c, r11.f13611c) == true) goto L25;
        return false;
    L25:
        if (Intrinsics.areEqual(this.d, r11.d) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.e, r11.e) == true) goto L31;
        return false;
    L31:
        if (Intrinsics.areEqual(this.f, r11.f) == true) goto L34;
        return false;
    L34:
        if (Intrinsics.areEqual(this.g, r11.g) == true) goto L37;
        return false;
    L37:
        if (Arrays.equals(this.f13613i, r11.f13613i) == true) goto L40;
        return false;
    L40:
        if (Intrinsics.areEqual(this.f13614j, r11.f13614j) == true) goto L42;
        return false;
    L42:
        return true;
    L44:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.material.MaterialConfig");
    L7:
        r10 = r5.getClass();
        goto L9
    }

    public final int hashCode() {
        int r5 = 0;
        Float r10 = this.f13612h;
        if (r10 != null) goto L5;
        int r11 = 0;
    L6:
        int r12 = r11 * 31;
        ColorStateList r13 = this.f13609a;
        if (r13 != null) goto L9;
        int r14 = 0;
    L10:
        int r15 = (r12 + r14) * 31;
        cs.a r16 = this.f13610b;
        if (r16 != null) goto L13;
        int r17 = 0;
    L14:
        int r18 = (r15 + r17) * 31;
        com.obric.oui.color.a[] r19 = this.f13611c;
        if (r19 != null) goto L17;
        int r20 = 0;
    L18:
        int r21 = (r18 + r20) * 31;
        cs.c r22 = this.d;
        if (r22 != null) goto L21;
        int r23 = 0;
    L22:
        int r24 = (r21 + r23) * 31;
        com.obric.oui.color.d r25 = this.e;
        if (r25 != null) goto L25;
        int r26 = 0;
    L26:
        int r27 = (r24 + r26) * 31;
        cs.a r28 = this.f;
        if (r28 != null) goto L29;
        int r29 = 0;
    L30:
        int r30 = (r27 + r29) * 31;
        xq.a r31 = this.g;
        if (r31 != null) goto L33;
        int r32 = 0;
    L34:
        int r33 = (r30 + r32) * 31;
        es.a[] r34 = this.f13613i;
        if (r34 != null) goto L37;
        int r35 = 0;
    L38:
        int r36 = (r33 + r35) * 31;
        com.obric.oui.fluid.a r37 = this.f13614j;
        if (r37 == null) goto L43;
        r5 = r37.hashCode();
    L43:
        return r36 + r5;
    L37:
        r35 = Arrays.hashCode(r34);
        goto L38
    L33:
        r32 = r31.hashCode();
        goto L34
    L29:
        r29 = r28.hashCode();
        goto L30
    L25:
        r26 = r25.hashCode();
        goto L26
    L21:
        r23 = r22.hashCode();
        goto L22
    L17:
        r20 = Arrays.hashCode(r19);
        goto L18
    L13:
        r17 = r16.hashCode();
        goto L14
    L9:
        r14 = r13.hashCode();
        goto L10
    L5:
        r11 = r10.hashCode();
        goto L6
    }

    public final String toString() {
        return "MaterialConfig(fallbackBgColor=" + this.f13609a + ", blendConfigStateList=" + this.f13610b + ", blendConfig=" + Arrays.toString(this.f13611c) + ", strokeStateList=" + this.d + ", stroke=" + this.e + ", overlayBlendConfigStateList=" + this.f + ", blurConfig=" + this.g + ", blurRadius=" + this.f13612h + ", shadow=" + Arrays.toString(this.f13613i) + ", fluid=" + this.f13614j + ')';
    }

    public /* synthetic */ c(ColorStateList r15, cs.a r16, com.obric.oui.color.a[] r17, xq.a r18, Float r19, com.obric.oui.fluid.a r20, int r21) {
        if ((r21 & 1) == 0) goto L5;
        ColorStateList r5 = null;
    L7:
        if ((r21 & 2) == 0) goto L9;
        cs.a r10 = null;
    L11:
        if ((r21 & 4) == 0) goto L13;
        com.obric.oui.color.a[] r11 = null;
    L15:
        if ((r21 & 64) == 0) goto L17;
        xq.a r12 = null;
    L19:
        if ((r21 & 128) == 0) goto L21;
        Float r13 = null;
    L23:
        if ((r21 & 512) == 0) goto L25;
        com.obric.oui.fluid.a r14 = null;
    L26:
        this(r5, r10, r11, null, null, null, r12, r13, null, r14);
        return;
    L25:
        r14 = r20;
        goto L26
    L21:
        r13 = r19;
        goto L23
    L17:
        r12 = r18;
        goto L19
    L13:
        r11 = r17;
        goto L15
    L9:
        r10 = r16;
        goto L11
    L5:
        r5 = r15;
        goto L7
    }
}
