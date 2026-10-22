package com.obric.assistant;

import com.lynx.jsbridge.LynxResourceModule;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.chatcontext.ClearContextInKeyguardServiceImpl;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.i1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\t\u0010\u0004\u001a\u00020\u0005H\u0096\u0001J\t\u0010\u0006\u001a\u00020\u0007H\u0096\u0001J\t\u0010\b\u001a\u00020\tH\u0096\u0001J\u0015\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\f0\u000bH\u0096\u0001J\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\u000eH\u0096\u0001J\u000f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\t0\u000eH\u0096\u0001J\t\u0010\u0010\u001a\u00020\tH\u0096\u0001J\t\u0010\u0011\u001a\u00020\tH\u0096\u0001J\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\t0\u000eH\u0096\u0001J\u0011\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0015H\u0096\u0001J(\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0096\u0001¢\u0006\u0002\u0010\u001dJ0\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\tH\u0096\u0001¢\u0006\u0002\u0010 J\u0019\u0010!\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001cH\u0096\u0001J(\u0010\"\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0096\u0001¢\u0006\u0002\u0010\u001dJ\t\u0010#\u001a\u00020\u0007H\u0096\u0001J\u0019\u0010$\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u00052\u0006\u0010&\u001a\u00020\tH\u0096\u0001J\u0019\u0010'\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u00052\u0006\u0010&\u001a\u00020\tH\u0096\u0001J\u0019\u0010(\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u00052\u0006\u0010&\u001a\u00020\tH\u0096\u0001J\u0011\u0010)\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0015H\u0096\u0001¨\u0006*"}, d2 = {"Lcom/obric/assistant/SessionAuthenticationServiceDelegate;", "Lcom/obric/assistant/ISessionAuthenticationService;", "<init>", "()V", "getSessionId", NameKeys.UnloadStrategy_No_Strategy, "init", NameKeys.UnloadStrategy_No_Strategy, "isAuthenticationPass", NameKeys.UnloadStrategy_No_Strategy, "isAuthenticationPassV2", "Lkotlin/Pair;", "Lcom/obric/assistant/AuthenticationType;", "isBiometricAuthenticating", "Lkotlinx/coroutines/flow/StateFlow;", "isBiometricPass", "isNeedVoicePrintAuthentication", "isVoicePrintAuthenticationOnLockScreenEnabled", "isVoicePrintPass", "registerSessionAuthenticationStateChangedListener", "listener", "Lcom/obric/assistant/IOnSessionAuthenticationStateChangedListener;", "requestActivityAuthenticationOnLockAsync", LynxResourceModule.PARAMS_KEY, "Lcom/obric/assistant/RequestAuthenticationParams;", "timeoutMillis", NameKeys.UnloadStrategy_No_Strategy, "callback", "Lcom/obric/assistant/RequestAuthenticationCallback;", "(Lcom/obric/assistant/RequestAuthenticationParams;Ljava/lang/Long;Lcom/obric/assistant/RequestAuthenticationCallback;)V", "requestBiometricAuthentication", "playTts", "(Lcom/obric/assistant/RequestAuthenticationParams;Ljava/lang/Long;Lcom/obric/assistant/RequestAuthenticationCallback;Z)V", "requestDeviceCredentialAuthentication", "requestVoicePrintAuthentication", "resetSessionState", "setBiometricState", "sessionId", "isPassed", "setDeviceState", "setVoicePrintState", "unregisterSessionAuthenticationStateChangedListener", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SessionAuthenticationServiceDelegate implements ISessionAuthenticationService {
    public static final SessionAuthenticationServiceDelegate b = null;
    public final /* synthetic */ ISessionAuthenticationService a;

    static {
        b = new SessionAuthenticationServiceDelegate();
    }

    public final void d(String r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "sessionId");
        this.a.d(r2, r3);
    }

    public final void e(o4 r2, n4 r3) {
        Intrinsics.checkNotNullParameter(r2, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r3, "callback");
        this.a.e(r2, r3);
    }

    public final void f(o4 r2, Long r3, n4 r4) {
        Intrinsics.checkNotNullParameter(r2, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r4, "callback");
        this.a.f(r2, r3, r4);
    }

    public final void g(o4 r2, Long r3, n4 r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r2, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r4, "callback");
        this.a.g(r2, r3, r4, r5);
    }

    public final String getSessionId() {
        return this.a.getSessionId();
    }

    public final void h(ClearContextInKeyguardServiceImpl.d r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.a.h(r2);
    }

    public final Pair<Boolean, AuthenticationType> i() {
        return this.a.i();
    }

    public final void init() {
        this.a.init();
    }

    public final boolean isAuthenticationPass() {
        return this.a.isAuthenticationPass();
    }

    public final void j(o4 r2, Long r3, n4 r4) {
        Intrinsics.checkNotNullParameter(r2, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r4, "callback");
        this.a.j(r2, r3, r4);
    }

    public final i1<Boolean> k() {
        return this.a.k();
    }

    public final i1<Boolean> l() {
        return this.a.l();
    }

    public final boolean m() {
        return this.a.m();
    }

    public final boolean n() {
        return this.a.n();
    }

    public final i1<Boolean> o() {
        return this.a.o();
    }

    private SessionAuthenticationServiceDelegate() {
        this.a = (ISessionAuthenticationService) ServiceManager.get().getService(ISessionAuthenticationService.class);
    }
}
