package com.ss.android.lark.passportc.impl.v2.entity;

import com.ss.android.lark.passport.signinsdk_api.account.User;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.passportc.entity.UserState;
import com.ss.android.lark.passportc.impl.v2.state.UserStateModel;
import com.ss.android.lark.passportc.internal.g0;
import io.reactivex.subjects.BehaviorSubject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class UpdateUserContext {
    public final int a;
    public final UserStateModel b;
    public final User c;
    public final BehaviorSubject<c> d;
    public final com.ss.android.lark.passportc.api.d e;
    public final lzb.a f;
    public final com.ss.android.lark.passportc.impl.v2.d g;
    public final h0c.a<UserState, UpdateUserContext, j0c.a> h;
    public g0 i;
    public UserSession j;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof UpdateUserContext) == true) goto L8;
        return false;
    L8:
        UpdateUserContext r6 = (UpdateUserContext) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r6.g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.h, r6.h) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((((((((this.a * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31;
        com.ss.android.lark.passportc.impl.v2.d r1 = this.g;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        h0c.a<UserState, UpdateUserContext, j0c.a> r5 = this.h;
        if (r5 == null) goto L11;
        r2 = r5.hashCode();
    L11:
        return r4 + r2;
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "UpdateUserContext(requestId=" + this.a + ", userStateModel=" + this.b + ", targetUser=" + this.c + ", updateSubject=" + this.d + ", executeMode=" + this.e + ", actionContext=" + this.f + ", updateVisitor=" + this.g + ", actionCallback=" + this.h + ')';
    }

    public UpdateUserContext(int r2, UserStateModel r3, User r4, BehaviorSubject<c> r5, com.ss.android.lark.passportc.api.d r6, lzb.a r7, com.ss.android.lark.passportc.impl.v2.d r8, h0c.a<UserState, UpdateUserContext, j0c.a> r9) {
        Intrinsics.checkNotNullParameter(r3, "userStateModel");
        Intrinsics.checkNotNullParameter(r4, "targetUser");
        Intrinsics.checkNotNullParameter(r5, "updateSubject");
        Intrinsics.checkNotNullParameter(r6, "executeMode");
        Intrinsics.checkNotNullParameter(r7, "actionContext");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
        this.i = (g0) r3.b(new UpdateUserContext$userDelegate$1(this));
        this.j = (UserSession) r3.b(new UpdateUserContext$targetSession$1(this));
    }
}
