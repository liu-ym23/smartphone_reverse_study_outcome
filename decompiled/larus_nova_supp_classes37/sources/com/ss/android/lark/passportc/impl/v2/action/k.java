package com.ss.android.lark.passportc.impl.v2.action;

import com.ss.android.lark.passportc.api.ExecuteStrategy;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.passportc.entity.UserState;
import com.ss.android.lark.passportc.impl.v2.entity.UpdateUserContext;
import com.ss.android.lark.passportc.impl.v2.state.UserStateModel;
import com.ss.android.lark.passportc.internal.g0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class k implements c {
    public final boolean a;

    public k(boolean r1) {
        this.a = r1;
    }

    @Override // i0c.b
    public final h0c.b a(final UpdateUserContext r12, Object r13, Object r14) {
        UserState r15 = (UserState) r13;
        UserState r16 = (UserState) r14;
        Intrinsics.checkNotNullParameter(r12, "context");
        Intrinsics.checkNotNullParameter(r15, "from");
        Intrinsics.checkNotNullParameter(r16, "to");
        b.a(r15, r16, UserState.OFFLINE);
        UserStateModel r0 = r12.b;
        final com.ss.android.lark.passportc.api.d r2 = r12.e;
        final UserSession r5 = r12.j;
        if (r5 == null) goto L20;
        final g0 r6 = r12.i;
        if (r6 == null) goto L18;
        com.ss.android.lark.passportc.impl.v2.d r1 = r12.g;
        if (r1 == null) goto L10;
        r1.b(r12, r15, r16, this.a);
    L10:
        if (r2.b == ExecuteStrategy.ROLLBACK) goto L12;
        r0.e(new UserStateModel.b[]{new UserStateModel.b(new UpdateToOfflineStateAction$execute$1(this, r5), UpdateToOfflineStateAction$execute$2.INSTANCE), new UserStateModel.b(new UpdateToOfflineStateAction$execute$3(r5), new UpdateToOfflineStateAction$execute$4(r2, r12, this, r5, r6))});
    L12:
        com.ss.android.lark.passportc.impl.v2.d r3 = r12.g;
        if (r3 == null) goto L15;
        r3.a(r12, r15, r16, this.a);
    L15:
        int r17 = h0c.b.b;
        return new h0c.b.c(com.ss.android.lark.passportc.task.i.a);
    L18:
        throw new IllegalArgumentException("Required value was null.".toString());
    L20:
        throw new IllegalArgumentException("Required value was null.".toString());
    }
}
