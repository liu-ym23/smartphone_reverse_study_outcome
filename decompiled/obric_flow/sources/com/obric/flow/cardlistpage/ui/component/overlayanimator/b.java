package com.obric.flow.cardlistpage.ui.component.overlayanimator;

/* JADX INFO: loaded from: classes3.dex */
public final class b extends g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f11648a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f11649b;

    public b(float r5, boolean r10) {
        this.f11648a = r5;
        this.f11649b = r10;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof b) == true) goto L8;
        return false;
    L8:
        b r10 = (b) r5;
        float r11 = r10.f11648a;
        if (Float.compare(this.f11648a, r11) == 0) goto L12;
        return false;
    L12:
        if (this.f11649b == r10.f11649b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r5 = Float.hashCode(this.f11648a) * 31;
        return Boolean.hashCode(this.f11649b) + r5;
    }

    public final String toString() {
        return "Release(velocityX=" + this.f11648a + ", hasOverscroll=" + this.f11649b + ")";
    }
}
