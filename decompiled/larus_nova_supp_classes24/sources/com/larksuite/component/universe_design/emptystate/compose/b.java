package com.larksuite.component.universe_design.emptystate.compose;

import androidx.compose.ui.graphics.Color;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class b {
    public final long a;
    public final long b;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof b) == true) goto L8;
        return false;
    L8:
        b r9 = (b) r8;
        if (Color.equals-impl0(this.a, r9.a) == true) goto L12;
        return false;
    L12:
        if (Color.equals-impl0(this.b, r9.b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (Color.hashCode-impl(this.a) * 31) + Color.hashCode-impl(this.b);
    }

    public final String toString() {
        return "UDEmptyStateColors(titleColor=" + Color.toString-impl(this.a) + ", descriptionColor=" + Color.toString-impl(this.b) + ')';
    }

    public b(long r1, long r3) {
        this.a = r1;
        this.b = r3;
    }
}
