package com.bytedance.ai.api;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.net.Uri;
import com.google.gson.JsonObject;
import com.obric.assistant.interaction.impl.AssistantInteractionService;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.i1;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J(\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u000e\u0010\u000f\u001a\u00020\u0007H\u0096@¢\u0006\u0002\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0013H\u0016JA\u0010\u0014\u001a\u00020\u00072\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00170\u00162#\u0010\u0018\u001a\u001f\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0019H\u0016Jh\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u000b2\b\u0010\u001f\u001a\u0004\u0018\u00010\u000b2\b\u0010 \u001a\u0004\u0018\u00010\u000b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010!\u001a\u0004\u0018\u00010\u000b2\b\u0010\"\u001a\u0004\u0018\u00010\u000b2\u0014\u0010#\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0017\u0018\u00010$2\u000e\u0010%\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010&H\u0016J\u0018\u0010'\u001a\u00020\u00072\u0006\u0010(\u001a\u00020\u000b2\u0006\u0010)\u001a\u00020*H\u0016J\n\u0010+\u001a\u0004\u0018\u00010\u000bH\u0016J\u001c\u0010,\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020/0.\u0018\u00010-H\u0016J\u0010\u00100\u001a\u00020\u00072\u0006\u00101\u001a\u000202H\u0016J\b\u00103\u001a\u00020\u0007H\u0016J\u000e\u00104\u001a\b\u0012\u0004\u0012\u00020\u000b05H\u0016J\b\u00106\u001a\u00020\u000bH\u0016¨\u00067"}, d2 = {"Lcom/bytedance/ai/api/NoopAppletService;", "Lcom/bytedance/ai/api/AppletService;", "<init>", "()V", "isInitialized", "", "init", "", "application", "Landroid/app/Application;", "bid", "", "isDebug", "geckoConfigs", "Lcom/ivy/ivykit/base/resource/GeckoConfigs;", "ensureInitialized", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isAppletAppContext", "context", "Landroid/content/Context;", "openPage", "data", "", "", "callback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", com.bytedance.android.ec.core.event.a.KEY_SHOPPING_GUIDE_NAME, "isSuccess", "runApplet", "appletId", "conversationID", "botId", "msgId", "replyFor", "traceInfo", "", "runAppletResult", "Lkotlin/Function0;", "publishEvent", "eventKey", "eventJson", "Lcom/google/gson/JsonObject;", "getCurDeepResearchResourceId", "getEventFlow", "Lkotlinx/coroutines/flow/StateFlow;", "Lkotlin/Pair;", "Lorg/json/JSONObject;", "addAppActionListener", "listener", "Lcom/bytedance/ai/api/IActionListener;", "notifyChatWillReady", "getAlarmListWithKeepStatus", "", "getGeckoEnv", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NoopAppletService implements AppletService {
    public static final NoopAppletService a = null;

    static {
        a = new NoopAppletService();
    }

    private NoopAppletService() {
    }

    public final void a(String r10, JsonObject r11) {
        Intrinsics.checkNotNullParameter(r10, "eventKey");
        Intrinsics.checkNotNullParameter(r11, "eventJson");
    }

    public final void c(String r1, String r10, Context r11, String r12, String r13, Map r14, Function0 r15) {
        Intrinsics.checkNotNullParameter("com.flow.remind", "appletId");
    }

    public final void e() {
    }

    public final boolean g(Context r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
        return false;
    }

    public final i1<Pair<String, JSONObject>> getEventFlow() {
        return null;
    }

    public final void h(Application r1, String r10, boolean r11, pg9.b r12) {
        Intrinsics.checkNotNullParameter(r1, "application");
        Intrinsics.checkNotNullParameter(r10, "bid");
        Intrinsics.checkNotNullParameter(r12, "geckoConfigs");
    }

    public final String i() {
        return "";
    }

    public final boolean isInitialized() {
        return false;
    }

    public final String k() {
        return null;
    }

    public final void l(AssistantInteractionService.startAppletListener.1 r10) {
        Intrinsics.checkNotNullParameter(r10, "listener");
    }

    public final List<String> d() {
        return CollectionsKt.emptyList();
    }

    public final Object j(Continuation<? super Unit> r1) {
        return Unit.INSTANCE;
    }

    public final void f(Map<String, ? extends Object> r10, Function1<? super Boolean, Unit> r11) {
        Intrinsics.checkNotNullParameter(r10, "data");
        r11.invoke(Boolean.FALSE);
    }

    public final boolean b(Activity r1, Uri r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r1, com.bytedance.android.ec.core.event.a.VALUE_ACTIVITY);
        return false;
    }
}
