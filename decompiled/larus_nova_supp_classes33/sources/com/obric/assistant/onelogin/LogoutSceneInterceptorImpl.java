package com.obric.assistant.onelogin;

import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.spi.login.ILogoutSceneInterceptor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\u000b"}, d2 = {"Lcom/obric/assistant/onelogin/LogoutSceneInterceptorImpl;", "Lcom/obric/assistant/spi/login/ILogoutSceneInterceptor;", "<init>", "()V", "shouldIntercept", "", "scene", "", "dispatch", "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LogoutSceneInterceptorImpl implements ILogoutSceneInterceptor {

    public static final class a {
    }

    static {
    }

    public LogoutSceneInterceptorImpl() {
    }

    @Override // com.obric.assistant.spi.login.ILogoutSceneInterceptor
    public final void a(String r5) {
        Intrinsics.checkNotNullParameter(r5, "scene");
        FLogger r0 = FLogger.a;
        r0.i("LogoutSceneInterceptorImpl", "intercept and dispatch logout scene: " + r5 + ", don't jump to login page");
        if (Intrinsics.areEqual(r5, "session_expired") == false) goto L8;
        AppHost.Companion r1 = AppHost.a;
        if (r1.a().isAppBackground() == false) goto L9;
        r0.i("LogoutSceneInterceptorImpl", r5 + " and isAppBackground, finish all activities");
        r1.a().finishAllActivities();
        return;
    L9:
        return;
    }

    @Override // com.obric.assistant.spi.login.ILogoutSceneInterceptor
    public final boolean shouldIntercept(String r2) {
        Intrinsics.checkNotNullParameter(r2, "scene");
        if (Intrinsics.areEqual(r2, "logout_by_o_matrix") == false) goto L5;
    L19:
        return true;
    L5:
        if (Intrinsics.areEqual(r2, "logout_by_account_removed") == true) goto L19;
        if (Intrinsics.areEqual(r2, "logout_by_check_account_on_init") == false) goto L10;
        int r3 = ObricOneLoginImpl.j;
        goto L19
    L10:
        if (Intrinsics.areEqual(r2, "logout_by_check_account_network_available") == false) goto L14;
        if (AppHost.a.a().isAppBackground() == true) goto L19;
    L14:
        if (Intrinsics.areEqual(r2, "session_expired") == true) goto L16;
    L18:
        return false;
    L16:
        if (AppHost.a.a().isAppBackground() == false) goto L18;
        goto L18
    }
}
