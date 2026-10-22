package com.ss.android.lark.passportc.impl.v2.action;

import com.ss.android.lark.passportc.api.ExecuteStrategy;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.passportc.entity.UserState;
import com.ss.android.lark.passportc.impl.v2.entity.UpdateUserContext;
import com.ss.android.lark.passportc.impl.v2.state.UserStateModel;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class j implements c {
    public j() {
    }

    @Override // i0c.b
    public final h0c.b a(UpdateUserContext r3, Object r4, Object r5) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter((UserState) r4, "from");
        Intrinsics.checkNotNullParameter((UserState) r5, "to");
        UserStateModel r6 = r3.b;
        com.ss.android.lark.passportc.api.d r7 = r3.e;
        final UserSession r8 = r3.j;
        if (r8 == null) goto L10;
        if (r7.b == ExecuteStrategy.ROLLBACK) goto L7;
        Function1<f0c.d, Boolean> r9 = new UpdateToAbsentStateAction$execute$1(r8);
        UpdateToAbsentStateAction$execute$2 r10 = UpdateToAbsentStateAction$execute$2.INSTANCE;
        r6.getClass();
        Intrinsics.checkNotNullParameter(r9, "find");
        Intrinsics.checkNotNullParameter(r10, "action");
        r6.e(new UserStateModel.b[]{new UserStateModel.b(r9, r10)});
    L7:
        int r11 = h0c.b.b;
        return new h0c.b.c(com.ss.android.lark.passportc.task.i.a);
    L10:
        throw new IllegalArgumentException("Required value was null.".toString());
    }
}
