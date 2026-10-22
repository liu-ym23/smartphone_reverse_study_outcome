package com.obric.oui.material;

import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.obric.oui.color.a[] f13653a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final cs.a f13654b;

    public f(com.obric.oui.color.a[] r5, cs.a r10) {
        Intrinsics.checkNotNullParameter(r5, "defaultConfig");
        Intrinsics.checkNotNullParameter(r10, "stateList");
        this.f13653a = r5;
        this.f13654b = r10;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof f) == true) goto L8;
        return false;
    L8:
        f r10 = (f) r5;
        com.obric.oui.color.a[] r11 = r10.f13653a;
        if (Intrinsics.areEqual(this.f13653a, r11) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f13654b, r10.f13654b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r5 = Arrays.hashCode(this.f13653a) * 31;
        return this.f13654b.hashCode() + r5;
    }

    public final String toString() {
        return "ParsedBlendConfigContainer(defaultConfig=" + Arrays.toString(this.f13653a) + ", stateList=" + this.f13654b + ')';
    }
}
