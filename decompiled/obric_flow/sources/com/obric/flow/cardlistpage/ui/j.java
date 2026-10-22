package com.obric.flow.cardlistpage.ui;

/* JADX INFO: loaded from: classes3.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f11779a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f11780b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f11781c;
    public final int d;

    public j(int r5, int r10, int r11, int r12) {
        this.f11779a = r5;
        this.f11780b = r10;
        this.f11781c = r11;
        this.d = r12;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof j) == true) goto L8;
        return false;
    L8:
        j r10 = (j) r5;
        int r11 = r10.f11779a;
        if (this.f11779a == r11) goto L12;
        return false;
    L12:
        if (this.f11780b == r10.f11780b) goto L15;
        return false;
    L15:
        if (this.f11781c == r10.f11781c) goto L18;
        return false;
    L18:
        if (this.d == r10.d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r5 = Integer.hashCode(this.f11779a) * 31;
        int r10 = androidx.room.jarjarred.org.antlr.runtime.a.c(this.f11780b, r5, 31);
        int r11 = androidx.room.jarjarred.org.antlr.runtime.a.c(this.f11781c, r10, 31);
        return Integer.hashCode(this.d) + r11;
    }

    public final String toString() {
        StringBuilder r5 = new StringBuilder("GestureExclusionBounds(left=");
        r5.append(this.f11779a);
        r5.append(", top=");
        r5.append(this.f11780b);
        r5.append(", right=");
        r5.append(this.f11781c);
        r5.append(", bottom=");
        return androidx.constraintlayout.motion.widget.a.s(r5, this.d, ")");
    }
}
