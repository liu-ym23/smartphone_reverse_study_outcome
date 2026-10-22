package com.obric.oui.indicator;

import ai.j0;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f13464a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f13465b;

    public a(int r5, int r10) {
        this.f13464a = r5;
        this.f13465b = r10;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof a) == true) goto L8;
        return false;
    L8:
        a r10 = (a) r5;
        int r11 = r10.f13464a;
        if (this.f13464a == r11) goto L12;
        return false;
    L12:
        if (this.f13465b == r10.f13465b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r5 = Integer.hashCode(this.f13464a) * 31;
        return Integer.hashCode(this.f13465b) + r5;
    }

    public final String toString() {
        StringBuilder r5 = new StringBuilder("DotSpacingSpec(startMargin=");
        r5.append(this.f13464a);
        r5.append(", endMargin=");
        return j0.n(r5, this.f13465b, ')');
    }
}
