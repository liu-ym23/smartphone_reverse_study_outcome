package com.obric.flow.cardlistpage.ui.component.overlayanimator;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class v extends c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f11710a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f11711b;

    public v(boolean r5, String r10) {
        Intrinsics.checkNotNullParameter(r10, "desc");
        this.f11710a = r5;
        this.f11711b = r10;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof v) == true) goto L8;
        return false;
    L8:
        v r10 = (v) r5;
        boolean r11 = r10.f11710a;
        if (this.f11710a == r11) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f11711b, r10.f11711b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r5 = Boolean.hashCode(this.f11710a) * 31;
        return this.f11711b.hashCode() + r5;
    }

    public final String toString() {
        return "AnimateTo(open=" + this.f11710a + ", desc=" + this.f11711b + ")";
    }
}
