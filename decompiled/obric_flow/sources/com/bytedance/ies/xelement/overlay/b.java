package com.bytedance.ies.xelement.overlay;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f6488a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f6489b;

    public b(String r5, a r10) {
        Intrinsics.checkNotNullParameter(r5, "id");
        Intrinsics.checkNotNullParameter(r10, "dialog");
        this.f6488a = r5;
        this.f6489b = r10;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof b) == true) goto L8;
        return false;
    L8:
        b r10 = (b) r5;
        String r11 = r10.f6488a;
        if (Intrinsics.areEqual(this.f6488a, r11) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f6489b, r10.f6489b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r5 = this.f6488a.hashCode() * 31;
        return this.f6489b.hashCode() + r5;
    }

    public final String toString() {
        return "OverlayData(id=" + this.f6488a + ", dialog=" + this.f6489b + ')';
    }
}
