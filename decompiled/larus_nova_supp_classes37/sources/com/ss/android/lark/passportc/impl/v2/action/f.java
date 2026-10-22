package com.ss.android.lark.passportc.impl.v2.action;

import com.ss.android.lark.log.Log;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.passportc.entity.UserState;
import com.ss.android.lark.passportc.impl.v2.entity.UpdateUserContext;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class f<Component> implements c {
    public static final /* synthetic */ int b = 0;
    public final m<Component> a;

    public static final class a {
    }

    static {
    }

    public f(m<Component> r2) {
        Intrinsics.checkNotNullParameter(r2, "userComponentDelegate");
        this.a = r2;
    }

    @Override // i0c.b
    public final h0c.b a(UpdateUserContext r3, Object r4, Object r5) {
        UserState r6 = (UserState) r4;
        UserState r7 = (UserState) r5;
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r6, "from");
        Intrinsics.checkNotNullParameter(r7, "to");
        if (r6 == r7) goto L13;
        if (r7 != UserState.ABSENT) goto L13;
        UserSession r8 = r3.j;
        if (r8 == null) goto L9;
        this.a.a(r8);
    L10:
        int r9 = h0c.b.b;
        return new h0c.b.c(com.ss.android.lark.passportc.task.i.a);
    L9:
        Log.e("DeleteUserComponentAction", "delete user component failed, target session is null, user:" + r3.c.userId);
    L13:
        throw new IllegalStateException("delete user component action state error, state: " + r6 + " -> " + r7);
    }
}
