package com.obric.assistant.onelogin;

import b48.k;
import com.bytedance.sdk.account.impl.i0;
import com.larus.account.saas.coreapi.IAccountEventsInterceptor;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.login.d0;
import com.obric.assistant.login.f0;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\u000b"}, d2 = {"Lcom/obric/assistant/onelogin/AccountEventsInterceptorImpl;", "Lcom/larus/account/saas/coreapi/IAccountEventsInterceptor;", "<init>", "()V", "shouldIntercept", "", "event", "Lcom/larus/account/saas/model/SaaSAccountEvent;", "dispatch", "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AccountEventsInterceptorImpl implements IAccountEventsInterceptor {

    public static final class a {
    }

    static {
    }

    public AccountEventsInterceptorImpl() {
    }

    public final boolean a(k r4) {
        Intrinsics.checkNotNullParameter(r4, "event");
        Object r0 = r4.b;
        if ((r0 instanceof ta7.b) == false) goto L5;
        ta7.b r1 = (ta7.b) r0;
    L7:
        if (Intrinsics.areEqual(r4.getType(), "session_expired") == true) goto L9;
        return false;
    L9:
        if (r1 == null) goto L15;
        i0 r2 = r1.c;
        if (r2 == null) goto L15;
        if (r2.b != 701) goto L15;
        boolean r3 = true;
    L16:
        if (r3 == false) goto L20;
        return true;
    L20:
        return false;
    L15:
        r3 = false;
        goto L16
    L5:
        r1 = null;
        goto L7
    }

    public final void b(k r3) {
        Intrinsics.checkNotNullParameter(r3, "event");
        f0.a.getClass();
        FLogger.a.i("ObricLoginStrategyCenter", "onOAccountPasswordChanged, logout assistant and start O system one login");
        c0.b(true, "logout_by_o_matrix", new d0());
    }
}
