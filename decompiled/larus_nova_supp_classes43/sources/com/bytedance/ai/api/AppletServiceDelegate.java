package com.bytedance.ai.api;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.net.Uri;
import com.google.gson.JsonObject;
import com.obric.assistant.interaction.impl.AssistantInteractionService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.i1;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0011\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0096\u0001J#\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\tH\u0096\u0001J\u000e\u0010\u000f\u001a\u00020\u0005H\u0096A¢\u0006\u0002\u0010\u0010J\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0096\u0001J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0096\u0001J\u001d\u0010\u0015\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00180\u0017\u0018\u00010\u0016H\u0096\u0001J\t\u0010\u0019\u001a\u00020\u0013H\u0096\u0001J)\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u001e\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020 H\u0096\u0001J\u0011\u0010!\u001a\u00020\t2\u0006\u0010\"\u001a\u00020#H\u0096\u0001J\t\u0010$\u001a\u00020\tH\u0096\u0001J\t\u0010%\u001a\u00020\u0005H\u0096\u0001JB\u0010&\u001a\u00020\u00052\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020)0(2#\u0010*\u001a\u001f\u0012\u0013\u0012\u00110\t¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(.\u0012\u0004\u0012\u00020\u0005\u0018\u00010+H\u0096\u0001J\u0019\u0010/\u001a\u00020\u00052\u0006\u00100\u001a\u00020\u00132\u0006\u00101\u001a\u000202H\u0096\u0001Ji\u00103\u001a\u00020\u00052\u0006\u00104\u001a\u00020\u00132\b\u00105\u001a\u0004\u0018\u00010\u00132\b\u00106\u001a\u0004\u0018\u00010\u00132\b\u0010\"\u001a\u0004\u0018\u00010#2\b\u00107\u001a\u0004\u0018\u00010\u00132\b\u00108\u001a\u0004\u0018\u00010\u00132\u0014\u00109\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020)\u0018\u00010:2\u000e\u0010;\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010<H\u0096\u0001¨\u0006="}, d2 = {"Lcom/bytedance/ai/api/AppletServiceDelegate;", "Lcom/bytedance/ai/api/AppletService;", "<init>", "()V", "addAppActionListener", "", "listener", "Lcom/bytedance/ai/api/IActionListener;", "consumeBusinessDeepLink", "", com.bytedance.android.ec.core.event.a.VALUE_ACTIVITY, "Landroid/app/Activity;", "uri", "Landroid/net/Uri;", "finishAfterConsume", "ensureInitialized", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAlarmListWithKeepStatus", "", "", "getCurDeepResearchResourceId", "getEventFlow", "Lkotlinx/coroutines/flow/StateFlow;", "Lkotlin/Pair;", "Lorg/json/JSONObject;", "getGeckoEnv", "init", "application", "Landroid/app/Application;", "bid", "isDebug", "geckoConfigs", "Lcom/ivy/ivykit/base/resource/GeckoConfigs;", "isAppletAppContext", "context", "Landroid/content/Context;", "isInitialized", "notifyChatWillReady", "openPage", "data", "", "", "callback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", com.bytedance.android.ec.core.event.a.KEY_SHOPPING_GUIDE_NAME, "isSuccess", "publishEvent", "eventKey", "eventJson", "Lcom/google/gson/JsonObject;", "runApplet", "appletId", "conversationID", "botId", "msgId", "replyFor", "traceInfo", "", "runAppletResult", "Lkotlin/Function0;", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AppletServiceDelegate implements AppletService {
    public static final AppletServiceDelegate b = null;
    public final /* synthetic */ AppletService a;

    static {
        b = new AppletServiceDelegate();
    }

    public final void a(String r10, JsonObject r11) {
        Intrinsics.checkNotNullParameter(r10, "eventKey");
        Intrinsics.checkNotNullParameter(r11, "eventJson");
        this.a.a(r10, r11);
    }

    public final boolean b(Activity r10, Uri r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.VALUE_ACTIVITY);
        return this.a.b(r10, r11, r12);
    }

    public final void c(String r10, String r11, Context r12, String r13, String r14, Map r15, Function0 r16) {
        Intrinsics.checkNotNullParameter("com.flow.remind", "appletId");
        this.a.c(r10, r11, r12, r13, r14, r15, r16);
    }

    public final List<String> d() {
        return this.a.d();
    }

    public final void e() {
        this.a.e();
    }

    public final void f(Map<String, ? extends Object> r10, Function1<? super Boolean, Unit> r11) {
        Intrinsics.checkNotNullParameter(r10, "data");
        this.a.f(r10, r11);
    }

    public final boolean g(Context r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
        return this.a.g(r10);
    }

    public final i1<Pair<String, JSONObject>> getEventFlow() {
        return this.a.getEventFlow();
    }

    public final void h(Application r10, String r11, boolean r12, pg9.b r13) {
        Intrinsics.checkNotNullParameter(r10, "application");
        Intrinsics.checkNotNullParameter(r11, "bid");
        Intrinsics.checkNotNullParameter(r13, "geckoConfigs");
        this.a.h(r10, r11, r12, r13);
    }

    public final String i() {
        return this.a.i();
    }

    public final boolean isInitialized() {
        return this.a.isInitialized();
    }

    public final Object j(Continuation<? super Unit> r10) {
        return this.a.j(r10);
    }

    public final String k() {
        return this.a.k();
    }

    public final void l(AssistantInteractionService.startAppletListener.1 r10) {
        Intrinsics.checkNotNullParameter(r10, "listener");
        this.a.l(r10);
    }

    private AppletServiceDelegate() {
        AppletService r0 = (AppletService) ServiceManager.get().getService(AppletService.class);
        if (r0 != null) goto L5;
        r0 = NoopAppletService.a;
    L5:
        this.a = r0;
    }
}
