package com.obric.flow.cardlistpage.ui.settings;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class d extends f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f11825a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0 f11826b;

    public d(int r5, Function0 r10) {
        Intrinsics.checkNotNullParameter(r10, "onClick");
        super(r10);
        this.f11825a = r5;
        this.f11826b = r10;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof d) == true) goto L8;
        return false;
    L8:
        d r10 = (d) r5;
        int r11 = r10.f11825a;
        if (this.f11825a == r11) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f11826b, r10.f11826b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r5 = Integer.hashCode(this.f11825a) * 31;
        return this.f11826b.hashCode() + r5;
    }

    public final String toString() {
        return "Action(titleResId=" + this.f11825a + ", onClick=" + this.f11826b + ")";
    }
}
