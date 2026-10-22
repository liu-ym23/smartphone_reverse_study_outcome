package com.ss.android.lark.passport.flow.mfa;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class q {
    public final String a;

    public final boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof q) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.a, ((q) r4).a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return "FlowMfaStartResult(mfaToken=" + this.a + ')';
    }

    public q(String r2) {
        Intrinsics.checkNotNullParameter(r2, "mfaToken");
        this.a = r2;
    }
}
