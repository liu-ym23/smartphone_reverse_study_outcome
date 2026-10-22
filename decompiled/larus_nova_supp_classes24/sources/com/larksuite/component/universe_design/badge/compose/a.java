package com.larksuite.component.universe_design.badge.compose;

import androidx.compose.ui.unit.Dp;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class a {
    public final float a;
    public final float b;
    public final float c;
    public final float d;
    public final float e;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof a) == true) goto L8;
        return false;
    L8:
        a r6 = (a) r5;
        if (Dp.equals-impl0(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Dp.equals-impl0(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Float.compare(this.c, r6.c) == 0) goto L18;
        return false;
    L18:
        if (Dp.equals-impl0(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (Dp.equals-impl0(this.e, r6.e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        return (((((((Dp.hashCode-impl(this.a) * 31) + Dp.hashCode-impl(this.b)) * 31) + Float.floatToIntBits(this.c)) * 31) + Dp.hashCode-impl(this.d)) * 31) + Dp.hashCode-impl(this.e);
    }

    public final String toString() {
        return "BadgeMetrics(width=" + Dp.toString-impl(this.a) + ", height=" + Dp.toString-impl(this.b) + ", textWidth=" + this.c + ", iconWidth=" + Dp.toString-impl(this.d) + ", iconHeight=" + Dp.toString-impl(this.e) + ')';
    }

    public a(float r1, float r2, float r3, float r4, float r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }
}
