package com.obric.flow.cardlistpage.ui.component.overlayanimator;

/* JADX INFO: loaded from: classes3.dex */
public final class d extends g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f11652a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f11653b;

    public d(boolean r5, boolean r10) {
        this.f11652a = r5;
        this.f11653b = r10;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof d) == true) goto L8;
        return false;
    L8:
        d r10 = (d) r5;
        boolean r11 = r10.f11652a;
        if (this.f11652a == r11) goto L12;
        return false;
    L12:
        if (this.f11653b == r10.f11653b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r5 = Boolean.hashCode(this.f11652a) * 31;
        return Boolean.hashCode(this.f11653b) + r5;
    }

    public final String toString() {
        StringBuilder r5 = new StringBuilder("SetOpen(open=");
        r5.append(this.f11652a);
        r5.append(", animate=");
        return ai.j0.r(r5, this.f11653b, ")");
    }
}
