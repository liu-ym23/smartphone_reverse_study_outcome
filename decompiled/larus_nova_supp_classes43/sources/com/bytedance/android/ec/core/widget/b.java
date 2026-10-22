package com.bytedance.android.ec.core.widget;

import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b {
    public final float a;
    public final float b;
    public final int c;
    public final int d;
    public final int e;
    public final boolean f;
    public final float[] g;
    public final float[] h;
    public final float i;
    public final Float j;
    public final boolean k;
    public final boolean l;

    public final boolean equals(Object r10) {
        if (this != r10) goto L4;
        return true;
    L4:
        if ((r10 instanceof b) == false) goto L30;
        b r11 = (b) r10;
        if (Float.compare(this.a, r11.a) == 0) goto L8;
        return false;
    L8:
        if (Float.compare(this.b, r11.b) == 0) goto L10;
        return false;
    L10:
        if (this.c == r11.c) goto L12;
        return false;
    L12:
        if (this.d == r11.d) goto L14;
        return false;
    L14:
        if (this.e == r11.e) goto L16;
        return false;
    L16:
        if (this.f == r11.f) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.g, r11.g) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.h, r11.h) == true) goto L22;
        return false;
    L22:
        if (Float.compare(this.i, r11.i) == 0) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.j, r11.j) == true) goto L26;
        return false;
    L26:
        if (this.k == r11.k) goto L28;
        return false;
    L28:
        if (this.l == r11.l) goto L46;
        return false;
    L46:
        return true;
    L30:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11, types: [int] */
    /* JADX WARN: Type inference failed for: r0v21, types: [int] */
    /* JADX WARN: Type inference failed for: r0v23, types: [int] */
    /* JADX WARN: Type inference failed for: r1v17, types: [int] */
    /* JADX WARN: Type inference failed for: r1v19 */
    /* JADX WARN: Type inference failed for: r1v22 */
    /* JADX WARN: Type inference failed for: r1v23 */
    /* JADX WARN: Type inference failed for: r1v24 */
    /* JADX WARN: Type inference failed for: r1v6, types: [int] */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public final int hashCode() {
        int r0 = ((((((((Float.floatToIntBits(this.a) * 31) + Float.floatToIntBits(this.b)) * 31) + this.c) * 31) + this.d) * 31) + this.e) * 31;
        boolean r1 = this.f;
        ?? r10 = 1;
        ?? r11 = r1;
        if (r1 == false) goto L5;
        r11 = 1;
    L5:
        int r12 = (r0 + r11) * 31;
        float[] r13 = this.g;
        int r14 = 0;
        if (r13 == null) goto L8;
        int r15 = Arrays.hashCode(r13);
    L9:
        int r16 = (r12 + r15) * 31;
        float[] r17 = this.h;
        if (r17 == null) goto L12;
        int r18 = Arrays.hashCode(r17);
    L13:
        int r19 = (((r16 + r18) * 31) + Float.floatToIntBits(this.i)) * 31;
        Float r20 = this.j;
        if (r20 == null) goto L16;
        r14 = r20.hashCode();
    L16:
        int r21 = (r19 + r14) * 31;
        boolean r22 = this.k;
        ?? r23 = r22;
        if (r22 == false) goto L19;
        r23 = 1;
    L19:
        int r24 = (r21 + r23) * 31;
        boolean r25 = this.l;
        if (r25 == true) goto L24;
        r10 = r25;
    L24:
        return r24 + r10;
    L12:
        r18 = 0;
        goto L13
    L8:
        r15 = 0;
        goto L9
    }

    public final String toString() {
        return "ECHotAtmosphereUIConfig(topImageHeight=" + this.a + ", bgHeight=" + this.b + ", xFontSize=" + this.c + ", numFontSize=" + this.d + ", appendFontSize=" + this.e + ", useColors=" + this.f + ", linearColorPosition=" + Arrays.toString(this.g) + ", radius=" + Arrays.toString(this.h) + ", hotIconMarginRightDp=" + this.i + ", paddingRightDp=" + this.j + ", disableBackground=" + this.k + ", disableBorder=" + this.l + ")";
    }

    public b(float r10, int r11, int r12, float[] r13, float r14, Float r15, boolean r16, boolean r17) {
        this.a = 14.0f;
        this.b = r10;
        this.c = r11;
        this.d = r12;
        this.e = 13;
        this.f = false;
        this.g = null;
        this.h = r13;
        this.i = r14;
        this.j = r15;
        this.k = r16;
        this.l = r17;
    }
}
