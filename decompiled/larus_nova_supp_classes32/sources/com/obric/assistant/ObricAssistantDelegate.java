package com.obric.assistant;

import com.lynx.jsbridge.LynxResourceModule;
import com.obric.aivoice.core.data.NameKeys;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0096\u0001J\u000b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096\u0001J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0005H\u0096\u0001J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0005H\u0096\u0001J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0005H\u0096\u0001J\t\u0010\n\u001a\u00020\u000bH\u0096\u0001J\t\u0010\f\u001a\u00020\u000bH\u0096\u0001J\t\u0010\r\u001a\u00020\u000bH\u0096\u0001J\t\u0010\u000e\u001a\u00020\u000bH\u0096\u0001J\u001b\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0096\u0001J\u0011\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0010H\u0096\u0001J\u0011\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u0013H\u0096\u0001J\u0011\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u0013H\u0096\u0001J \u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u00132\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0096\u0001¢\u0006\u0002\u0010\u0019¨\u0006\u001a"}, d2 = {"Lcom/obric/assistant/ObricAssistantDelegate;", "Lcom/obric/assistant/IObricAssistant;", "<init>", "()V", "createObricChatPageRouterInterceptor", "Lcom/bytedance/router/interceptor/IInterceptor;", "createObricLockScreenRouterInterceptor", "createObricMultiTabChatPageRouterInterceptor", "createObricRealTimeCallRouterInterceptor", "createObricSecurityRouterInterceptor", "finishChatPage", NameKeys.UnloadStrategy_No_Strategy, "initCapabilitySdk", "initEventTaskSdk", "registerLifecycle", "routeToCameraCapture", NameKeys.UnloadStrategy_No_Strategy, "isTopRtcVideo", "startupAttemptId", NameKeys.UnloadStrategy_No_Strategy, "routeToCameraResult", LynxResourceModule.URI_KEY, "routeToCreationCanvas", "displayId", NameKeys.UnloadStrategy_No_Strategy, "(Ljava/lang/String;Ljava/lang/Integer;)V", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricAssistantDelegate implements IObricAssistant {
    public static final ObricAssistantDelegate b = null;
    public final /* synthetic */ IObricAssistant a;

    static {
        b = new ObricAssistantDelegate();
    }

    public final void a(String r2, Integer r3) {
        Intrinsics.checkNotNullParameter(r2, LynxResourceModule.URI_KEY);
        this.a.a(r2, r3);
    }

    public final q97.a b() {
        return this.a.b();
    }

    public final q97.a c() {
        return this.a.c();
    }

    public final void d(String r2) {
        Intrinsics.checkNotNullParameter(r2, LynxResourceModule.URI_KEY);
        this.a.d(r2);
    }

    public final boolean e(boolean r2, String r3) {
        return this.a.e(r2, r3);
    }

    public final void f() {
        this.a.f();
    }

    public final void finishChatPage() {
        this.a.finishChatPage();
    }

    public final void g() {
        this.a.g();
    }

    public final q97.a h() {
        return this.a.h();
    }

    public final void i() {
        this.a.i();
    }

    public final void j(boolean r2) {
        this.a.j(r2);
    }

    public final q97.a k() {
        return this.a.k();
    }

    private ObricAssistantDelegate() {
        this.a = (IObricAssistant) ServiceManager.get().getService(IObricAssistant.class);
    }
}
