package com.ss.android.lark.passportc.impl.v2.action;

import com.ss.android.lark.passportc.api.ExecuteStrategy;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.passportc.entity.UserState;
import com.ss.android.lark.passportc.impl.v2.entity.UpdateUserContext;
import com.ss.android.lark.passportc.impl.v2.state.UserStateModel;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class l implements c {
    public final boolean a;

    public l(boolean r1) {
        this.a = r1;
    }

    @Override // i0c.b
    public final h0c.b a(final UpdateUserContext r6, Object r7, Object r8) {
        UserState r9 = (UserState) r7;
        UserState r10 = (UserState) r8;
        Intrinsics.checkNotNullParameter(r6, "context");
        Intrinsics.checkNotNullParameter(r9, "from");
        Intrinsics.checkNotNullParameter(r10, "to");
        UserStateModel r0 = r6.b;
        final com.ss.android.lark.passportc.api.d r1 = r6.e;
        final UserSession r2 = r6.j;
        if (r2 == null) goto L16;
        com.ss.android.lark.passportc.impl.v2.d r3 = r6.g;
        if (r3 == null) goto L8;
        r3.o(r6, r9, r10, this.a);
    L8:
        if (r1.b == ExecuteStrategy.ROLLBACK) goto L10;
        Function1<f0c.d, Boolean> r4 = new UpdateToOnlineStateAction$execute$1(r2);
        Function1<f0c.d, f0c.d> r5 = new UpdateToOnlineStateAction$execute$2(r1, r6, this);
        r0.getClass();
        Intrinsics.checkNotNullParameter(r4, "find");
        Intrinsics.checkNotNullParameter(r5, "action");
        r0.e(new UserStateModel.b[]{new UserStateModel.b(r4, r5)});
    L10:
        com.ss.android.lark.passportc.impl.v2.d r11 = r6.g;
        if (r11 == null) goto L13;
        r11.n(r6, r9, r10, this.a);
    L13:
        int r12 = h0c.b.b;
        return new h0c.b.c(com.ss.android.lark.passportc.task.i.a);
    L16:
        throw new IllegalArgumentException("Required value was null.".toString());
    }
}
