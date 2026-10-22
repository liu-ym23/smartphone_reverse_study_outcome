package com.ss.android.lark.passportc.impl.v2.entity;

import com.ss.android.lark.passport.signinsdk_api.account.User;
import com.ss.android.lark.passportc.entity.UserState;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class d {
    public final User a;
    public final UserState b;
    public final boolean c;

    public final int hashCode() {
        int r0 = ((this.a.userId.hashCode() * 31) + this.b.hashCode()) * 31;
        if (this.c == false) goto L5;
        int r1 = 1231;
    L7:
        return r0 + r1;
    L5:
        r1 = 1237;
        goto L7
    }

    public final String toString() {
        return "(targetUserId=" + this.a.userId + ", targetState=" + this.b + ", forceReset=" + this.c + ')';
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof d) == true) goto L8;
        return false;
    L8:
        d r6 = (d) r5;
        if (Intrinsics.areEqual(this.a.userId, r6.a.userId) == true) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L17;
        return false;
    L17:
        return true;
    }

    public d(User r2, UserState r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "targetUser");
        Intrinsics.checkNotNullParameter(r3, "targetState");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
