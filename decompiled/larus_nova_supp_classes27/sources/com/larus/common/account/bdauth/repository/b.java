package com.larus.common.account.bdauth.repository;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class b {
    public final BDAuthorizeAccountIssueType a;
    public final a b;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof b) == true) goto L8;
        return false;
    L8:
        b r6 = (b) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        a r1 = this.b;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return r0 + r2;
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public final String toString() {
        return "BDAuthorizeAccountIssue(type=" + this.a + ", account=" + this.b + ')';
    }

    public final BDAuthorizeAccountIssueType getType() {
        return this.a;
    }

    public b(BDAuthorizeAccountIssueType r2, a r3) {
        Intrinsics.checkNotNullParameter(r2, "type");
        this.a = r2;
        this.b = r3;
    }
}
