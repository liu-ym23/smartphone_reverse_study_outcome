package com.obric.flow.cardlistpage.ui.component.floatingbtn;

/* JADX INFO: loaded from: classes3.dex */
public final class e extends h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f11634a;

    public e(float r5) {
        this.f11634a = r5;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof e) == true) goto L9;
        return false;
    L9:
        if (Float.compare(this.f11634a, ((e) r5).f11634a) == 0) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return Float.hashCode(this.f11634a);
    }

    public final String toString() {
        return "AnimateQsbReady(targetTranslationX=" + this.f11634a + ")";
    }
}
