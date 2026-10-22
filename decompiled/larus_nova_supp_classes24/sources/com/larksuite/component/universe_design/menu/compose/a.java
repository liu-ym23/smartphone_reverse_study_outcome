package com.larksuite.component.universe_design.menu.compose;

import androidx.compose.ui.graphics.Color;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class a {
    public final long a;
    public final long b;
    public final long c;
    public final long d;
    public final long e;
    public final long f;
    public final long g;
    public final long h;
    public final long i;
    public final long j;
    public final long k;

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
        if (Color.equals-impl0(this.e, r9.e) == true) goto L24;
        return false;
    L24:
        if (Color.equals-impl0(this.f, r9.f) == true) goto L27;
        return false;
    L27:
        if (Color.equals-impl0(this.g, r9.g) == true) goto L30;
        return false;
    L30:
        if (Color.equals-impl0(this.h, r9.h) == true) goto L33;
        return false;
    L33:
        if (Color.equals-impl0(this.i, r9.i) == true) goto L36;
        return false;
    L36:
        if (Color.equals-impl0(this.j, r9.j) == true) goto L39;
        return false;
    L39:
        if (Color.equals-impl0(this.k, r9.k) == true) goto L41;
        return false;
    L41:
        return true;
    }

    public final int hashCode() {
        return (((((((((((((((((((Color.hashCode-impl(this.a) * 31) + Color.hashCode-impl(this.b)) * 31) + Color.hashCode-impl(this.c)) * 31) + Color.hashCode-impl(this.d)) * 31) + Color.hashCode-impl(this.e)) * 31) + Color.hashCode-impl(this.f)) * 31) + Color.hashCode-impl(this.g)) * 31) + Color.hashCode-impl(this.h)) * 31) + Color.hashCode-impl(this.i)) * 31) + Color.hashCode-impl(this.j)) * 31) + Color.hashCode-impl(this.k);
    }

    public final String toString() {
        return "UDMenuColors(container=" + Color.toString-impl(this.a) + ", border=" + Color.toString-impl(this.b) + ", itemPressed=" + Color.toString-impl(this.c) + ", itemHover=" + Color.toString-impl(this.d) + ", text=" + Color.toString-impl(this.e) + ", description=" + Color.toString-impl(this.f) + ", icon=" + Color.toString-impl(this.g) + ", disabledText=" + Color.toString-impl(this.h) + ", disabledIcon=" + Color.toString-impl(this.i) + ", divider=" + Color.toString-impl(this.j) + ", loading=" + Color.toString-impl(this.k) + ')';
    }

    public a(long r4, long r6, long r8, long r10, long r12, long r14, long r16, long r19, long r20, long r22, long r24) {
        this.a = r4;
        this.b = r6;
        this.c = r8;
        this.d = r10;
        this.e = r12;
        this.f = r14;
        this.g = r16;
        this.h = r19;
        this.i = r20;
        this.j = r22;
        this.k = r24;
    }
}
