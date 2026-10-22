package com.obric.flow.cardlistpage.data;

import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f11503a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList f11504b;

    public p(ArrayList r5, ArrayList r10) {
        Intrinsics.checkNotNullParameter(r5, "widgets");
        Intrinsics.checkNotNullParameter(r10, "externalCards");
        this.f11503a = r5;
        this.f11504b = r10;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof p) == true) goto L8;
        return false;
    L8:
        p r10 = (p) r5;
        ArrayList r11 = r10.f11503a;
        if (Intrinsics.areEqual(this.f11503a, r11) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f11504b, r10.f11504b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r5 = this.f11503a.hashCode() * 31;
        return this.f11504b.hashCode() + r5;
    }

    public final String toString() {
        return "DefaultTemplates(widgets=" + this.f11503a + ", externalCards=" + this.f11504b + ")";
    }
}
