package com.obric.flow.cardlistpage.ui.component.feedlist;

/* JADX INFO: loaded from: classes3.dex */
public final class x extends a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f11624a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f11625b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f11626c;

    public x(int r5, float r10, float r11) {
        this.f11624a = r5;
        this.f11625b = r10;
        this.f11626c = r11;
    }

    @Override // com.obric.flow.cardlistpage.mvi.j
    public final String a() {
        StringBuilder r5 = new StringBuilder("ExternalDragCancel(currentFakePosition=");
        r5.append(this.f11624a);
        r5.append(", x=");
        r5.append(this.f11625b);
        r5.append(", y=");
        return androidx.constraintlayout.motion.widget.a.r(r5, this.f11626c, ")");
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof x) == true) goto L8;
        return false;
    L8:
        x r10 = (x) r5;
        int r11 = r10.f11624a;
        if (this.f11624a == r11) goto L12;
        return false;
    L12:
        if (Float.compare(this.f11625b, r10.f11625b) == 0) goto L15;
        return false;
    L15:
        if (Float.compare(this.f11626c, r10.f11626c) == 0) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r5 = Integer.hashCode(this.f11624a) * 31;
        int r10 = androidx.constraintlayout.motion.widget.a.b(this.f11625b, r5, 31);
        return Float.hashCode(this.f11626c) + r10;
    }

    public final String toString() {
        StringBuilder r5 = new StringBuilder("ExternalDragCancel(currentFakePosition=");
        r5.append(this.f11624a);
        r5.append(", x=");
        r5.append(this.f11625b);
        r5.append(", y=");
        return androidx.constraintlayout.motion.widget.a.r(r5, this.f11626c, ")");
    }
}
