package com.obric.flow.cardlistpage.ui.component.overlayanimator;

import com.obric.flow.cardlistpage.mvi.MviLogLevel;

/* JADX INFO: loaded from: classes3.dex */
public final class e extends g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f11655a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MviLogLevel f11656b;

    public e(float r5) {
        this.f11655a = r5;
        this.f11656b = MviLogLevel.VERBOSE;
    }

    @Override // com.obric.flow.cardlistpage.ui.component.overlayanimator.g, com.obric.flow.cardlistpage.mvi.e
    public final MviLogLevel b() {
        return this.f11656b;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof e) == true) goto L9;
        return false;
    L9:
        if (Float.compare(this.f11655a, ((e) r5).f11655a) == 0) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return Float.hashCode(this.f11655a);
    }

    public final String toString() {
        return "UpdateOverscroll(deltaX=" + this.f11655a + ")";
    }
}
