package com.larus.common.account.bdauth.repository;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class d {
    public final BDAuthorizeBlockingErrorType a;

    public final boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof d) == true) goto L9;
        return false;
    L9:
        if (this.a == ((d) r4).a) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return "BDAuthorizeBlockingError(type=" + this.a + ')';
    }

    public final BDAuthorizeBlockingErrorType getType() {
        return this.a;
    }

    public d(BDAuthorizeBlockingErrorType r2) {
        Intrinsics.checkNotNullParameter(r2, "type");
        this.a = r2;
    }
}
