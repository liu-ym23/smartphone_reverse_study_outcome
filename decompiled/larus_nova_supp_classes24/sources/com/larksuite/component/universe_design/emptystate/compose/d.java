package com.larksuite.component.universe_design.emptystate.compose;

import androidx.compose.ui.unit.Dp;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class d {
    public final float a;
    public final float b;
    public final float c;
    public final float d;
    public final float e;
    public final float f;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof d) == true) goto L8;
        return false;
    L8:
        d r6 = (d) r5;
        if (Dp.equals-impl0(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Dp.equals-impl0(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Dp.equals-impl0(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Dp.equals-impl0(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (Dp.equals-impl0(this.e, r6.e) == true) goto L24;
        return false;
    L24:
        if (Dp.equals-impl0(this.f, r6.f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        return (((((((((Dp.hashCode-impl(this.a) * 31) + Dp.hashCode-impl(this.b)) * 31) + Dp.hashCode-impl(this.c)) * 31) + Dp.hashCode-impl(this.d)) * 31) + Dp.hashCode-impl(this.e)) * 31) + Dp.hashCode-impl(this.f);
    }

    public final String toString() {
        return "UDEmptyStateDimensions(horizontalPadding=" + Dp.toString-impl(this.a) + ", imageBottomMargin=" + Dp.toString-impl(this.b) + ", titleBottomMargin=" + Dp.toString-impl(this.c) + ", primaryActionTopMargin=" + Dp.toString-impl(this.d) + ", secondaryActionTopMargin=" + Dp.toString-impl(this.e) + ", linkActionTopMargin=" + Dp.toString-impl(this.f) + ')';
    }

    public d(float r1, float r2, float r3, float r4, float r5, float r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }
}
