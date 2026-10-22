package com.larksuite.component.universe_design.badge.compose;

import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.unit.Dp;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class c {
    public final boolean equals(Object r6) {
        if (this != r6) goto L6;
        return true;
    L6:
        if ((r6 instanceof c) == true) goto L8;
        return false;
    L8:
        ((c) r6).getClass();
        if (Dp.equals-impl0(0.0f, 0.0f) == true) goto L12;
        return false;
    L12:
        if (Color.equals-impl0(0, 0) == true) goto L15;
        return false;
    L15:
        if (Dp.equals-impl0(0.0f, 0.0f) == true) goto L18;
        return false;
    L18:
        if (Color.equals-impl0(0, 0) == true) goto L21;
        return false;
    L21:
        if (Dp.equals-impl0(0.0f, 0.0f) == true) goto L24;
        return false;
    L24:
        if (Color.equals-impl0(0, 0) == true) goto L27;
        return false;
    L27:
        if (Color.equals-impl0(0, 0) == true) goto L30;
        return false;
    L30:
        if (Dp.equals-impl0(0.0f, 0.0f) == true) goto L33;
        return false;
    L33:
        if (Dp.equals-impl0(0.0f, 0.0f) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(null, null) == true) goto L39;
        return false;
    L39:
        if (Color.equals-impl0(0, 0) == true) goto L41;
        return false;
    L41:
        return true;
    }

    public final UDBadgeType getType() {
        return null;
    }

    public final int hashCode() {
        throw null;
    }

    public final String toString() {
        return "UDBadgeStyle(type=null, badgeSize=" + Dp.toString-impl(0.0f) + ", badgeColor=" + Color.toString-impl(0) + ", outerBorderWidth=" + Dp.toString-impl(0.0f) + ", outerBorderColor=" + Color.toString-impl(0) + ", innerBorderWidth=" + Dp.toString-impl(0.0f) + ", innerBorderColor=" + Color.toString-impl(0) + ", textColor=" + Color.toString-impl(0) + ", textSize=" + Dp.toString-impl(0.0f) + ", textWidthPadding=" + Dp.toString-impl(0.0f) + ", textMaxLength=0, iconPadding=null, iconTint=" + Color.toString-impl(0) + ')';
    }
}
