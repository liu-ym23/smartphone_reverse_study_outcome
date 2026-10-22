package com.ss.android.lark.passportc.internal;

import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class g {
    public final WeakReference<com.ss.android.lark.passportc.api.n> a;

    public final boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof g) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.a, ((g) r4).a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return "ConventionData(convention=" + this.a + ')';
    }

    public g(WeakReference<com.ss.android.lark.passportc.api.n> r2) {
        Intrinsics.checkNotNullParameter(r2, "convention");
        this.a = r2;
    }
}
