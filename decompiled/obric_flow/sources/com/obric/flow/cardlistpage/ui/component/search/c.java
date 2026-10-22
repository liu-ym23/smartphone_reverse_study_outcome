package com.obric.flow.cardlistpage.ui.component.search;

/* JADX INFO: loaded from: classes3.dex */
public final class c extends f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f11754a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f11755b;

    public c(int r5, int r10) {
        this.f11754a = r5;
        this.f11755b = r10;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof c) == true) goto L8;
        return false;
    L8:
        c r10 = (c) r5;
        int r11 = r10.f11754a;
        if (this.f11754a == r11) goto L12;
        return false;
    L12:
        if (this.f11755b == r10.f11755b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r5 = Integer.hashCode(this.f11754a) * 31;
        return Integer.hashCode(this.f11755b) + r5;
    }

    public final String toString() {
        StringBuilder r5 = new StringBuilder("AnimateQsbReady(targetWidth=");
        r5.append(this.f11754a);
        r5.append(", targetHeight=");
        return androidx.constraintlayout.motion.widget.a.s(r5, this.f11755b, ")");
    }
}
