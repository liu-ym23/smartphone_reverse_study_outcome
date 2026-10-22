package com.larus.contextwindow.impl.membership;

import com.larus.contextwindow.impl.membership.model.MembershipQuotaSummaryDto;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class h {
    public final MembershipQuotaSummaryDto a;
    public final boolean b;

    public h() {
        MembershipQuotaSummaryDto r1 = null;
        this(r1, 3);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof h) == true) goto L8;
        return false;
    L8:
        h r6 = (h) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        MembershipQuotaSummaryDto r0 = this.a;
        if (r0 != null) goto L5;
        int r1 = 0;
    L6:
        int r2 = r1 * 31;
        if (this.b == false) goto L9;
        int r3 = 1231;
    L11:
        return r2 + r3;
    L9:
        r3 = 1237;
        goto L11
    L5:
        r1 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "MembershipQuotaRepositoryState(successfulSummary=" + this.a + ", refreshing=" + this.b + ')';
    }

    public /* synthetic */ h(MembershipQuotaSummaryDto r1, int r2) {
        if ((r2 & 1) == 0) goto L5;
        r1 = null;
    L5:
        this(r1, false);
    }

    public h(MembershipQuotaSummaryDto r1, boolean r2) {
        this.a = r1;
        this.b = r2;
    }
}
