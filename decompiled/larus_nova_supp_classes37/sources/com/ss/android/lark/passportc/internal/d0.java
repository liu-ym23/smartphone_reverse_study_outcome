package com.ss.android.lark.passportc.internal;

import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class d0 {
    public final WeakReference<com.ss.android.lark.passportc.api.o> a;

    public final boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof d0) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.a, ((d0) r4).a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return "UserConventionData(convention=" + this.a + ')';
    }

    public d0(WeakReference<com.ss.android.lark.passportc.api.o> r2) {
        Intrinsics.checkNotNullParameter(r2, "convention");
        this.a = r2;
    }
}
