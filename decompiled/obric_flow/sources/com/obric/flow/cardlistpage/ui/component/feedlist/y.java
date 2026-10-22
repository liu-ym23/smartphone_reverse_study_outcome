package com.obric.flow.cardlistpage.ui.component.feedlist;

/* JADX INFO: loaded from: classes3.dex */
public final class y extends a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f11627a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f11628b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f11629c;
    public final int d;
    public final int e;
    public final float f;
    public final float g;

    public y(int r5, int r10, int r11, int r12, int r13, float r14, float r15) {
        this.f11627a = r5;
        this.f11628b = r10;
        this.f11629c = r11;
        this.d = r12;
        this.e = r13;
        this.f = r14;
        this.g = r15;
    }

    @Override // com.obric.flow.cardlistpage.mvi.j
    public final String a() {
        StringBuilder r5 = new StringBuilder("ExternalDragStart(position=");
        r5.append(this.f11627a);
        r5.append(", spanX=");
        r5.append(this.f11628b);
        r5.append(", spanY=");
        r5.append(this.f11629c);
        r5.append(", x=");
        r5.append(this.f);
        r5.append(", y=");
        return androidx.constraintlayout.motion.widget.a.r(r5, this.g, ")");
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof y) == true) goto L8;
        return false;
    L8:
        y r10 = (y) r5;
        int r11 = r10.f11627a;
        if (this.f11627a == r11) goto L12;
        return false;
    L12:
        if (this.f11628b == r10.f11628b) goto L15;
        return false;
    L15:
        if (this.f11629c == r10.f11629c) goto L18;
        return false;
    L18:
        if (this.d == r10.d) goto L21;
        return false;
    L21:
        if (this.e == r10.e) goto L24;
        return false;
    L24:
        if (Float.compare(this.f, r10.f) == 0) goto L27;
        return false;
    L27:
        if (Float.compare(this.g, r10.g) == 0) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r5 = Integer.hashCode(this.f11627a) * 31;
        int r10 = androidx.room.jarjarred.org.antlr.runtime.a.c(this.f11628b, r5, 31);
        int r11 = androidx.room.jarjarred.org.antlr.runtime.a.c(this.f11629c, r10, 31);
        int r12 = androidx.room.jarjarred.org.antlr.runtime.a.c(this.d, r11, 31);
        int r13 = androidx.room.jarjarred.org.antlr.runtime.a.c(this.e, r12, 31);
        int r14 = androidx.constraintlayout.motion.widget.a.b(this.f, r13, 31);
        return Float.hashCode(this.g) + r14;
    }

    public final String toString() {
        StringBuilder r5 = new StringBuilder("ExternalDragStart(position=");
        r5.append(this.f11627a);
        r5.append(", spanX=");
        r5.append(this.f11628b);
        r5.append(", spanY=");
        r5.append(this.f11629c);
        r5.append(", minWidth=");
        r5.append(this.d);
        r5.append(", minHeight=");
        r5.append(this.e);
        r5.append(", x=");
        r5.append(this.f);
        r5.append(", y=");
        return androidx.constraintlayout.motion.widget.a.r(r5, this.g, ")");
    }
}
