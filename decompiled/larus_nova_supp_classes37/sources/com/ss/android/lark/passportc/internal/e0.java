package com.ss.android.lark.passportc.internal;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class e0 {
    public final com.ss.android.lark.passportc.api.o a;

    public final boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof e0) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.a, ((e0) r4).a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return "UserConventionDataStrong(convention=" + this.a + ')';
    }

    public e0(com.ss.android.lark.passportc.api.o r2) {
        Intrinsics.checkNotNullParameter(r2, "convention");
        this.a = r2;
    }
}
