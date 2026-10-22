package com.larksuite.component.universe_design.notice.compose;

import androidx.compose.ui.graphics.Color;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class b {
    public final long a;
    public final long b;
    public final long c;
    public final long d;
    public final long e;
    public final long f;

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
        if (Color.equals-impl0(this.f, r9.f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        return (((((((((Color.hashCode-impl(this.a) * 31) + Color.hashCode-impl(this.b)) * 31) + Color.hashCode-impl(this.c)) * 31) + Color.hashCode-impl(this.d)) * 31) + Color.hashCode-impl(this.e)) * 31) + Color.hashCode-impl(this.f);
    }

    public final String toString() {
        return "UDNoticeColors(background=" + Color.toString-impl(this.a) + ", text=" + Color.toString-impl(this.b) + ", icon=" + Color.toString-impl(this.c) + ", iconButton=" + Color.toString-impl(this.d) + ", textButton=" + Color.toString-impl(this.e) + ", textAction=" + Color.toString-impl(this.f) + ')';
    }

    public b(long r1, long r3, long r5, long r7, long r9, long r11) {
        this.a = r1;
        this.b = r3;
        this.c = r5;
        this.d = r7;
        this.e = r9;
        this.f = r11;
    }
}
