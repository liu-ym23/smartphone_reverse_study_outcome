package com.obric.oui.indicator;

import ai.j0;

/* JADX INFO: loaded from: classes3.dex */
public final class r extends s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f13507a;

    public r(int r5) {
        this.f13507a = r5;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof r) == true) goto L9;
        return false;
    L9:
        if (this.f13507a == ((r) r5).f13507a) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return Integer.hashCode(this.f13507a);
    }

    public final String toString() {
        return j0.n(new StringBuilder("Page(pageIndex="), this.f13507a, ')');
    }
}
