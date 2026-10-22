package com.obric.assistant.login;

import android.app.Application;
import android.content.Intent;
import android.media.AudioManager;
import com.larus.account.base.api.ILoginService;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.voice.IObricVoiceService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import n38.a;
import n38.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u00007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0007\b\u0007\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u0016\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\b\u0010\u000e\u001a\u00020\u0005H\u0002J\u0010\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0010\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0014H\u0002R\u0010\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\b¨\u0006\u0016"}, d2 = {"Lcom/obric/assistant/login/LoginStateImpl;", "Lcom/obric/assistant/login/ILoginState;", "<init>", "()V", "monitorLoginState", "", "accountStatusListener", "com/obric/assistant/login/LoginStateImpl$accountStatusListener$1", "Lcom/obric/assistant/login/LoginStateImpl$accountStatusListener$1;", "updateState", "event", "Lcom/larus/account/base/api/AccountStatusEvent;", "method", "", "broadCastLoginStatus", "resetLoginBannerState", "accountStatus", "Lcom/larus/account/base/model/AccountStatus;", "updateBacktraceState", "isLogin", "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LoginStateImpl implements ILoginState {
    public final c a;

    public static final class c implements j {
        public final /* synthetic */ LoginStateImpl a;

        public c(LoginStateImpl r1) {
            this.a = r1;
        }

        public final void a(a r2) {
            Intrinsics.checkNotNullParameter(r2, "event");
            this.a.getClass();
            LoginStateImpl.c(r2, "onUserDidOffline");
            this.a.getClass();
            LoginStateImpl.b(false);
        }

        public final void b(a r2) {
            Intrinsics.checkNotNullParameter(r2, "event");
            this.a.getClass();
            LoginStateImpl.c(r2, "onUserDidOnline");
            this.a.getClass();
            LoginStateImpl.b(true);
        }
    }

    static {
    }

    public final void a() {
        FLogger.a.i("LoginStateImpl", "monitorLoginState");
        ILoginService.Companion r0 = ILoginService.a;
        r0.f(this.a, Boolean.FALSE);
        if (r0.getAccountInfo().a == false) goto L6;
        b(true);
        return;
    }

    public LoginStateImpl() {
        this.a = new c(this);
    }

    public static void b(boolean r3) {
        Object r0 = AppHost.a.getApplication().getSystemService("audio");
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type android.media.AudioManager");
        AudioManager r1 = (AudioManager) r0;
        if (r3 == false) goto L12;
        IObricVoiceService.a.getClass();
        IObricVoiceService r4 = IObricVoiceService.a.a();
        if (r4 == null) goto L9;
        boolean r2 = true;
        if (r4.a() != true) goto L9;
    L10:
        if (r2 == false) goto L12;
        FLogger.a.i("LoginStateImpl", "updateBacktraceState: enable_backtrace=true");
        r1.setParameters("enable_backtrace=true");
        return;
    L9:
        r2 = false;
    L12:
        FLogger.a.i("LoginStateImpl", "updateBacktraceState: enable_backtrace=false");
        r1.setParameters("enable_backtrace=false");
    }

    public static void c(a r5, String r6) {
        Intrinsics.checkNotNullParameter(r5, "event");
        Intrinsics.checkNotNullParameter(r6, "method");
        FLogger r0 = FLogger.a;
        r0.i("LoginStateImpl", r6 + ": accountStatus = " + r5.a + ", businessScene = " + r5.d);
        boolean r7 = ILoginService.a.getAccountInfo().a;
        StringBuilder r2 = new StringBuilder("broadCastLoginStatus: isLogin = ");
        r2.append(r7);
        r0.i("LoginStateImpl", r2.toString());
        Application r3 = AppHost.a.getApplication();
        Intent r4 = new Intent("com.obric.assistant.login_status_changed");
        r4.putExtra("is_login", r7);
        r3.sendBroadcast(r4, "com.obric.assistant.permission.hybrid_ability");
        int r8 = b.a[r5.a.ordinal()];
        if (r8 != 1) goto L5;
    L7:
        r0.i("LoginStateImpl", "resetLoginBannerState, set OBRIC_LOGIN_BANNERED false");
        xg9.b.a().storeString("obric_login_bannered", "false");
        return;
    L5:
        if (r8 == 2) goto L7;
    }
}
