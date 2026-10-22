package com.larus.common.account.bdauth.repository;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class e {
    public final za7.c a;
    public final c b;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof e) == true) goto L8;
        return false;
    L8:
        e r6 = (e) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.a.hashCode() * 31) + this.b.hashCode();
    }

    public final String toString() {
        return "BDAuthorizePrepareData(authInfoResponse=" + this.a + ", accountSnapshot=" + this.b + ')';
    }

    public e(za7.c r2, c r3) {
        Intrinsics.checkNotNullParameter(r2, "authInfoResponse");
        Intrinsics.checkNotNullParameter(r3, "accountSnapshot");
        this.a = r2;
        this.b = r3;
    }
}
