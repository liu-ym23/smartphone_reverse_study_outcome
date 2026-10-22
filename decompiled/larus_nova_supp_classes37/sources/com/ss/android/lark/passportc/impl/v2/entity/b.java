package com.ss.android.lark.passportc.impl.v2.entity;

import com.ss.android.lark.passport.signinsdk_api.account.User;
import com.ss.android.lark.passportc.api.Scene;
import com.ss.android.lark.passportc.entity.UserState;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class b {
    public final User a;
    public final boolean b;
    public final UserState c;
    public final UserState d;
    public final Scene e;

    public final int hashCode() {
        int r0 = this.a.userId.hashCode() * 31;
        if (this.b == false) goto L5;
        int r1 = 1231;
    L6:
        int r2 = (((((r0 + r1) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31;
        Scene r3 = this.e;
        if (r3 == null) goto L9;
        int r4 = r3.hashCode();
    L11:
        return r2 + r4;
    L9:
        r4 = 0;
        goto L11
    L5:
        r1 = 1237;
        goto L6
    }

    public final String toString() {
        return "{uid:" + this.a.userId + ", foreground:" + this.b + ", " + this.c + " -> " + this.d + ", scene:" + this.e + '}';
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof b) == true) goto L8;
        return false;
    L8:
        b r6 = (b) r5;
        if (Intrinsics.areEqual(this.a.userId, r6.a.userId) == true) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L18;
        return false;
    L18:
        if (this.d == r6.d) goto L21;
        return false;
    L21:
        if (this.e == r6.e) goto L23;
        return false;
    L23:
        return true;
    }

    public /* synthetic */ b(User r7, boolean r8, UserState r9, UserState r10) {
        this(r7, r8, r9, r10, null);
    }

    public b(User r2, boolean r3, UserState r4, UserState r5, Scene r6) {
        Intrinsics.checkNotNullParameter(r2, "user");
        Intrinsics.checkNotNullParameter(r4, "from");
        Intrinsics.checkNotNullParameter(r5, "to");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
    }
}
