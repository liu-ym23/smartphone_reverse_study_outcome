package com.obric.flow.cardlistpage.ui.component.feedlist;

import ai.j0;

/* JADX INFO: loaded from: classes3.dex */
public final class i extends o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f11587a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f11588b;

    public i(boolean r5, boolean r10) {
        this.f11587a = r5;
        this.f11588b = r10;
    }

    @Override // com.obric.flow.cardlistpage.mvi.e
    public final String a() {
        StringBuilder r5 = new StringBuilder("RefreshCards(isFirstLoad=");
        r5.append(this.f11587a);
        r5.append(", refreshStepCounter=");
        return j0.r(r5, this.f11588b, ")");
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof i) == true) goto L8;
        return false;
    L8:
        i r10 = (i) r5;
        boolean r11 = r10.f11587a;
        if (this.f11587a == r11) goto L12;
        return false;
    L12:
        if (this.f11588b == r10.f11588b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r5 = Boolean.hashCode(this.f11587a) * 31;
        return Boolean.hashCode(this.f11588b) + r5;
    }

    public final String toString() {
        StringBuilder r5 = new StringBuilder("RefreshCards(isFirstLoad=");
        r5.append(this.f11587a);
        r5.append(", refreshStepCounter=");
        return j0.r(r5, this.f11588b, ")");
    }
}
