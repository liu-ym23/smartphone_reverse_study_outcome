package com.ss.android.lark.passportc.impl.v2.action;

import com.ss.android.lark.passport.signinsdk_api.account.User;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.passportc.entity.UserState;
import com.ss.android.lark.passportc.impl.v2.entity.UpdateUserContext;
import com.ss.android.lark.passportc.internal.PassportStateManagerImpl;
import com.ss.android.lark.passportc.internal.g0;
import com.ss.android.lark.passportc.internal.p;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class e<Component> implements c {
    public static final /* synthetic */ int c = 0;
    public final p a;
    public final m<Component> b;

    public static final class a {
    }

    static {
    }

    public e(p r2, m<Component> r3) {
        Intrinsics.checkNotNullParameter(r2, "userDataSource");
        Intrinsics.checkNotNullParameter(r3, "userComponentDelegate");
        this.a = r2;
        this.b = r3;
    }

    @Override // i0c.b
    public final h0c.b a(UpdateUserContext r3, Object r4, Object r5) {
        UserState r6 = (UserState) r4;
        UserState r7 = (UserState) r5;
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r6, "from");
        Intrinsics.checkNotNullParameter(r7, "to");
        if (r6 == r7) goto L9;
        if (r7 != UserState.OFFLINE) goto L9;
        User r8 = r3.c;
        int r9 = PassportStateManagerImpl.r;
        UserSession r10 = PassportStateManagerImpl.a.a(r8.userId);
        r3.j = r10;
        g0 r0 = new g0(r10, this.a, r8);
        this.b.e(r0);
        r3.i = r0;
        int r11 = h0c.b.b;
        return new h0c.b.c(com.ss.android.lark.passportc.task.i.a);
    L9:
        throw new IllegalStateException("create user component action state error, state: " + r6 + " -> " + r7);
    }
}
