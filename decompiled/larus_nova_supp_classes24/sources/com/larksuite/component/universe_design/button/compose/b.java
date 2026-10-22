package com.larksuite.component.universe_design.button.compose;

import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Dp;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class b {
    public final float a;
    public final float b;
    public final float c;
    public final boolean d;
    public final TextStyle e;
    public final boolean f;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof b) == true) goto L8;
        return false;
    L8:
        b r6 = (b) r5;
        if (Dp.equals-impl0(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Dp.equals-impl0(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Dp.equals-impl0(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (this.d == r6.d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
        return false;
    L24:
        if (this.f == r6.f) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((Dp.hashCode-impl(this.a) * 31) + Dp.hashCode-impl(this.b)) * 31) + Dp.hashCode-impl(this.c)) * 31;
        int r2 = 1231;
        if (this.d == false) goto L5;
        int r1 = 1231;
    L6:
        int r3 = (((r0 + r1) * 31) + this.e.hashCode()) * 31;
        if (this.f == true) goto L11;
        r2 = 1237;
    L11:
        return r3 + r2;
    L5:
        r1 = 1237;
        goto L6
    }

    public final String toString() {
        return "UDButtonSizeSpec(height=" + Dp.toString-impl(this.a) + ", minWidth=" + Dp.toString-impl(this.b) + ", horizontalPadding=" + Dp.toString-impl(this.c) + ", fillMaxWidth=" + this.d + ", textStyle=" + this.e + ", custom=" + this.f + ')';
    }

    public /* synthetic */ b(float r8, float r9, float r10, boolean r11, TextStyle r12) {
        this(r8, r9, r10, r11, r12, false);
    }

    public b(float r2, float r3, float r4, boolean r5, TextStyle r6, boolean r7) {
        Intrinsics.checkNotNullParameter(r6, "textStyle");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
    }
}
