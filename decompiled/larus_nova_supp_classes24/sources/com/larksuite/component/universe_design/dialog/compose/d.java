package com.larksuite.component.universe_design.dialog.compose;

import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Dp;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class d {
    public final String a;
    public final Function0<Unit> b;
    public final UDDialogActionRole c;
    public final boolean d;
    public final boolean e;
    public final Color f;
    public final Color g;
    public final Color h;
    public final Dp i;
    public final TextStyle j;
    public final int k;

    public d() {
        throw null;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof d) == true) goto L8;
        return false;
    L8:
        d r6 = (d) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L18;
        return false;
    L18:
        if (this.d == r6.d) goto L21;
        return false;
    L21:
        if (this.e == r6.e) goto L24;
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
        if (TextAlign.equals-impl0(this.k, r6.k) == true) goto L41;
        return false;
    L41:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31;
        int r2 = 1231;
        if (this.d == false) goto L5;
        int r1 = 1231;
    L6:
        int r3 = (r0 + r1) * 31;
        if (this.e == true) goto L10;
        r2 = 1237;
    L10:
        int r4 = (r3 + r2) * 31;
        Color r5 = this.f;
        int r6 = 0;
        if (r5 != null) goto L13;
        int r7 = 0;
    L14:
        int r8 = (r4 + r7) * 31;
        Color r9 = this.g;
        if (r9 != null) goto L17;
        int r10 = 0;
    L18:
        int r11 = (r8 + r10) * 31;
        Color r12 = this.h;
        if (r12 != null) goto L21;
        int r13 = 0;
    L22:
        int r14 = (r11 + r13) * 31;
        Dp r15 = this.i;
        if (r15 != null) goto L25;
        int r16 = 0;
    L26:
        int r17 = (r14 + r16) * 31;
        TextStyle r19 = this.j;
        if (r19 == null) goto L31;
        r6 = r19.hashCode();
    L31:
        return ((r17 + r6) * 31) + TextAlign.hashCode-impl(this.k);
    L25:
        r16 = Dp.hashCode-impl(r15.unbox-impl());
        goto L26
    L21:
        r13 = Color.hashCode-impl(r12.unbox-impl());
        goto L22
    L17:
        r10 = Color.hashCode-impl(r9.unbox-impl());
        goto L18
    L13:
        r7 = Color.hashCode-impl(r5.unbox-impl());
        goto L14
    L5:
        r1 = 1237;
        goto L6
    }

    public final String toString() {
        return "UDDialogListItem(text=" + this.a + ", onClick=" + this.b + ", role=" + this.c + ", enabled=" + this.d + ", autoDismiss=" + this.e + ", textColor=" + this.f + ", backgroundColor=" + this.g + ", pressedBackgroundColor=" + this.h + ", height=" + this.i + ", textStyle=" + this.j + ", textAlign=" + TextAlign.toString-impl(this.k) + ')';
    }

    public d(String r3, Function0 r4, UDDialogActionRole r5, boolean r6, boolean r7, Color r8, Color r9, Dp r10) {
        int r0 = TextAlign.Companion.getCenter-e0LSkKk();
        Intrinsics.checkNotNullParameter(r3, "text");
        Intrinsics.checkNotNullParameter(r4, "onClick");
        Intrinsics.checkNotNullParameter(r5, "role");
        this.a = r3;
        this.b = r4;
        this.c = r5;
        this.d = r6;
        this.e = r7;
        this.f = null;
        this.g = r8;
        this.h = r9;
        this.i = r10;
        this.j = null;
        this.k = r0;
    }
}
