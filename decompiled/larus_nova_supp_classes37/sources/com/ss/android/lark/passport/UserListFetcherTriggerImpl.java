package com.ss.android.lark.passport;

import com.ss.android.lark.log.Log;
import com.ss.android.lark.passportc.api.j;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.passportc.internal.v;
import e0c.k;
import f0c.g;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class UserListFetcherTriggerImpl extends c0c.b implements d {
    public static final Function0<Unit> d = null;
    public final v b;
    public Function0<Unit> c;

    public static final class a {
    }

    static {
        d = UserListFetcherTriggerImpl$Companion$emptyDestroy$1.INSTANCE;
    }

    @Inject
    public UserListFetcherTriggerImpl(j r2, v r3) {
        Intrinsics.checkNotNullParameter(r2, "passport");
        Intrinsics.checkNotNullParameter(r3, "accessor");
        super(r2);
        this.b = r3;
        this.c = d;
    }

    @Override // c0c.b
    public final void pf(g r3, f0c.b r4) {
        Intrinsics.checkNotNullParameter(r4, "toState");
        Log.i("UserListFetcherTrigger", "preparing fromUser=" + r3 + ", toState=" + r4);
        this.c.invoke();
        g r5 = r4.a();
        if (r5 == null) goto L9;
        UserSession r6 = r5.b;
        if (r6 == null) goto L9;
        this.c = ((b) k.b(this.b.c(r6), b.class)).register();
        return;
    L9:
        Log.w("UserListFetcherTrigger", "onUserChanged toUserSession is invalid.");
    }
}
