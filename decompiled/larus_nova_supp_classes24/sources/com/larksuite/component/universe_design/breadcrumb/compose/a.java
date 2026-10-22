package com.larksuite.component.universe_design.breadcrumb.compose;

import androidx.compose.ui.graphics.Color;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class a {
    public final long a;
    public final long b;
    public final long c;
    public final long d;
    public final long e;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof a) == true) goto L8;
        return false;
    L8:
        a r9 = (a) r8;
        if (Color.equals-impl0(this.a, r9.a) == true) goto L12;
        return false;
    L12:
        if (Color.equals-impl0(this.b, r9.b) == true) goto L15;
        return false;
    L15:
        if (Color.equals-impl0(this.c, r9.c) == true) goto L18;
        return false;
    L18:
        if (Color.equals-impl0(this.d, r9.d) == true) goto L21;
        return false;
    L21:
        if (Color.equals-impl0(this.e, r9.e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        return (((((((Color.hashCode-impl(this.a) * 31) + Color.hashCode-impl(this.b)) * 31) + Color.hashCode-impl(this.c)) * 31) + Color.hashCode-impl(this.d)) * 31) + Color.hashCode-impl(this.e);
    }

    public final String toString() {
        return "UDBreadcrumbColors(itemText=" + Color.toString-impl(this.a) + ", currentItemText=" + Color.toString-impl(this.b) + ", separator=" + Color.toString-impl(this.c) + ", itemPressedBackground=" + Color.toString-impl(this.d) + ", itemHoverBackground=" + Color.toString-impl(this.e) + ')';
    }

    public a(long r1, long r3, long r5, long r7, long r9) {
        this.a = r1;
        this.b = r3;
        this.c = r5;
        this.d = r7;
        this.e = r9;
    }
}
