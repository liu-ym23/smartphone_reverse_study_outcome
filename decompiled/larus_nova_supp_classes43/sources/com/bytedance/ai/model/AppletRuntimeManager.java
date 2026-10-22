package com.bytedance.ai.model;

import android.view.View;
import com.bytedance.ai.applet.app.base.ApplicationRouter;
import com.bytedance.ai.applet.app.base.RouteOptions;
import com.bytedance.ai.bridge.utils.ConvertUtils;
import com.bytedance.ai.core.base.SessionType;
import com.bytedance.ai.core.manager.WorkerRuntimeManager;
import com.bytedance.ai.model.objects.Applet;
import com.bytedance.ai.model.objects.PageInfo;
import com.bytedance.ai.model.objects.PageType;
import com.bytedance.ai.monitor.timeline.OpenFrom;
import com.bytedance.ai.widget.WidgetManager;
import com.bytedance.android.ec.base.api.ai.AIStateLogRequest;
import com.bytedance.vmsdk.jsbridge.utils.JavaOnlyMap;
import com.google.gson.JsonParser;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import m5.i1;
import m5.y0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000Ø\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001:\u0003vwxB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u0013J\u000e\u0010&\u001a\u00020$2\u0006\u0010%\u001a\u00020\u0013J\u0015\u0010'\u001a\u00020$2\u0006\u0010(\u001a\u00020\u0005H\u0000¢\u0006\u0002\b)Jm\u0010*\u001a\u00020$2\u0006\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010.2S\u0010/\u001aO\u0012\u0013\u0012\u001101¢\u0006\f\b2\u0012\b\b3\u0012\u0004\b\b(4\u0012\u0015\u0012\u0013\u0018\u00010\u0005¢\u0006\f\b2\u0012\b\b3\u0012\u0004\b\b(5\u0012\u0015\u0012\u0013\u0018\u00010\u0005¢\u0006\f\b2\u0012\b\b3\u0012\u0004\b\b(+\u0012\u0004\u0012\u00020\u001f00j\u0002`6J.\u00107\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u0001082\u0006\u00109\u001a\u00020\u00052\u0006\u0010:\u001a\u00020\u00052\u0006\u0010;\u001a\u00020\u0005H\u0016J*\u0010<\u001a\u00020$2\"\u0010=\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u001c0\u001bj\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u001c`\u001dJ&\u0010>\u001a\"\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001bj\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u001c\u0018\u0001`\u001dJ(\u0010?\u001a\u0004\u0018\u00010@2\b\u00109\u001a\u0004\u0018\u00010\u00052\b\u0010:\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u0005J\u0012\u0010A\u001a\u0004\u0018\u00010\u00052\b\u0010:\u001a\u0004\u0018\u00010\u0005J\u001a\u0010B\u001a\u00020$2\u0012\u0010C\u001a\u000e\u0012\u0004\u0012\u00020@\u0012\u0004\u0012\u00020$0DJ`\u0010E\u001a\u0004\u0018\u00010@2\u0006\u0010(\u001a\u00020\u00052\u0006\u0010F\u001a\u00020\u00052\u0006\u0010:\u001a\u00020\u00052\u0006\u0010-\u001a\u00020.2\n\b\u0002\u0010;\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010G\u001a\u0004\u0018\u00010\u00052\u0016\b\u0002\u0010H\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u001c\u0018\u00010IH\u0086@¢\u0006\u0002\u0010JJ\u000e\u0010K\u001a\u00020$2\u0006\u0010(\u001a\u00020\u0005Jh\u0010L\u001a\u00020$2\u0006\u0010(\u001a\u00020\u00052\u0006\u0010F\u001a\u00020\u00052\u0006\u0010:\u001a\u00020\u00052\n\b\u0002\u0010;\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010G\u001a\u0004\u0018\u00010\u00052\u0016\b\u0002\u0010H\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u001c\u0018\u00010I2\u0018\u0010M\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010@\u0012\u0004\u0012\u00020$0Dj\u0002`NJ\b\u0010O\u001a\u0004\u0018\u00010\u000fJ\b\u0010P\u001a\u0004\u0018\u00010\u000fJ\u0010\u0010Q\u001a\u0004\u0018\u00010\u000f2\u0006\u0010R\u001a\u00020\u0005J\u000e\u0010S\u001a\u00020$2\u0006\u0010T\u001a\u00020\u0005J\u000e\u0010U\u001a\u00020$2\u0006\u0010V\u001a\u00020\u000fJ\"\u0010\r\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000f0\u000ej\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000f`\u0010J\u0012\u0010W\u001a\u0004\u0018\u00010X2\b\u0010Y\u001a\u0004\u0018\u00010ZJ\u000e\u0010[\u001a\u00020\u00052\u0006\u0010\\\u001a\u00020\u0005J\u0012\u0010]\u001a\u0004\u0018\u00010^2\b\u0010_\u001a\u0004\u0018\u00010ZJ\u0010\u0010`\u001a\u0004\u0018\u00010^2\u0006\u0010a\u001a\u00020\u0005JA\u0010b\u001a\u00020$2\u0012\u0010+\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u001c082%\b\u0002\u0010c\u001a\u001f\u0012\u0013\u0012\u00110\u001f¢\u0006\f\b2\u0012\b\b3\u0012\u0004\b\b(d\u0012\u0004\u0012\u00020$\u0018\u00010DJ\u0014\u0010e\u001a\u0004\u0018\u00010\u00052\b\u0010f\u001a\u0004\u0018\u00010\u0005H\u0002J \u0010g\u001a\u00020$2\u0006\u0010h\u001a\u00020\u00052\b\u0010i\u001a\u0004\u0018\u00010\u00052\u0006\u0010j\u001a\u00020kJ*\u0010g\u001a\u00020$2\u0006\u0010h\u001a\u00020\u00052\b\u0010i\u001a\u0004\u0018\u00010\u00052\u0006\u0010j\u001a\u00020k2\b\u0010l\u001a\u0004\u0018\u00010\u0005J\u0012\u0010m\u001a\u0004\u0018\u00010n2\u0006\u0010i\u001a\u00020\u0005H\u0002J\u000e\u0010o\u001a\u00020$2\u0006\u0010%\u001a\u00020pJ\u000e\u0010q\u001a\u00020$2\u0006\u0010%\u001a\u00020pJ\u0012\u0010t\u001a\u0004\u0018\u00010\u00052\u0006\u0010:\u001a\u00020\u0005H\u0002J\u000e\u0010u\u001a\u00020$2\u0006\u0010:\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR*\u0010\r\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000f0\u000ej\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000f`\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R.\u0010\u001a\u001a\"\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001bj\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u001c\u0018\u0001`\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001e\u001a\u00020\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010 \"\u0004\b!\u0010\"R\u0014\u0010r\u001a\b\u0012\u0004\u0012\u00020p0sX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006y"}, d2 = {"Lcom/bytedance/ai/model/AppletRuntimeManager;", "Lcom/bytedance/ai/context/IContextProvider;", "<init>", "()V", "TAG", "", "EVENT_IS_BACKGROUND", "workRuntimeManager", "Lcom/bytedance/ai/core/manager/WorkerRuntimeManager;", "getWorkRuntimeManager", "()Lcom/bytedance/ai/core/manager/WorkerRuntimeManager;", "workRuntimeManager$delegate", "Lkotlin/Lazy;", "runningPages", "Ljava/util/LinkedHashMap;", "Lcom/bytedance/ai/model/widgets/AIContainerViewBase;", "Lkotlin/collections/LinkedHashMap;", "runtimeLifecycleListeners", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/bytedance/ai/model/AppletRuntimeManager$RuntimeLifecycleListener;", "aiAbility", "Lcom/bytedance/ai/api/model/ability/IAIAbilities;", "getAiAbility", "()Lcom/bytedance/ai/api/model/ability/IAIAbilities;", "setAiAbility", "(Lcom/bytedance/ai/api/model/ability/IAIAbilities;)V", "eventCommonParams", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "isBackground", "", "()Z", "setBackground", "(Z)V", "registerRuntimeLifecycleListener", "", "listener", "unregisterRuntimeLifecycleListener", "dispatchRuntimeTerminated", "appletId", "dispatchRuntimeTerminated$ai_sdk_release", "llmMsgReceived", "data", "Lcom/bytedance/ai/model/objects/ChatData;", "context", "Landroid/content/Context;", "appActionCallback", "Lkotlin/Function3;", "", "Lkotlin/ParameterName;", com.bytedance.android.ec.core.event.a.KEY_SHOPPING_GUIDE_NAME, "code", com.bytedance.android.ec.core.event.a.KEY_MSG, "Lcom/bytedance/ai/model/AppActionCallback;", "getContext", "", "cvsId", "botId", "msgId", "setEventCommonParams", "params", "getEventCommonParams", "getRunningApplet", "Lcom/bytedance/ai/model/AppletRuntime;", "botIdToSessionId", "forEachAllAppletRuntimes", "invoke", "Lkotlin/Function1;", "awaitRunApplet", "conversationID", "replyFor", "traceInfo", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "terminateRuntime", "runApplet", "runAppletResult", "Lcom/bytedance/ai/model/RunAppletResult;", "currentTopPage", "currentTopNonWidgetPage", "findAppletPage", "pageId", "removeAppletPage", "id", "addAppletPage", AIStateLogRequest.SOURCE_PAGE, "findAIContainerByView", "Lcom/bytedance/ai/api/model/view/IAIContainer;", "view", "Landroid/view/View;", "getBotId", "sessionId", "findWidgetByView", "Lcom/bytedance/ai/widget/contianer/IWidgetContainer;", "renderView", "findWidgetContainerByID", "widgetId", "openPage", "callback", "isSuccess", "sanitizePageData", "pageData", "openPageByDoubaoAppsSchema", "appletName", "pageUrl", "mode", "Lcom/bytedance/ai/applet/app/base/ApplicationRouter$Mode;", "conversationId", "getDoubaoAppsChatCardContext", "Lcom/bytedance/ai/model/AppletRuntimeManager$DoubaoAppsChatCardContext;", "registerRunningPageListener", "Lcom/bytedance/ai/model/AppletRuntimeManager$RunningPageListener;", "unregisterRunningPageListener", "runningPageListeners", "", "getAdditionalContextGlobally", "clearAdditionalContextGlobally", "RuntimeLifecycleListener", "DoubaoAppsChatCardContext", "RunningPageListener", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AppletRuntimeManager implements t4.a {
    public static final AppletRuntimeManager INSTANCE = null;
    public static final Lazy a = null;
    public static final LinkedHashMap<String, com.bytedance.ai.model.widgets.c> b = null;
    public static final CopyOnWriteArrayList<RuntimeLifecycleListener> c = null;
    public static g2.b d;
    public static HashMap<String, Object> e;
    public static boolean f;
    public static final List<? extends b> g = null;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ai/model/AppletRuntimeManager$RuntimeLifecycleListener;", "", "onRuntimeTerminated", "", "appletId", "", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface RuntimeLifecycleListener {
        void onRuntimeTerminated(String r1);
    }

    public static final class a {
        public final String a;
        public final String b;
        public final String c;

        public final boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof a) == true) goto L8;
            return false;
        L8:
            a r11 = (a) r10;
            if (Intrinsics.areEqual(this.a, r11.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r11.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r11.c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r0 = this.a.hashCode() * 31;
            String r1 = this.b;
            int r10 = 0;
            if (r1 != null) goto L5;
            int r11 = 0;
        L6:
            int r12 = (r0 + r11) * 31;
            String r13 = this.c;
            if (r13 == null) goto L11;
            r10 = r13.hashCode();
        L11:
            return r12 + r10;
        L5:
            r11 = r1.hashCode();
            goto L6
        }

        public final String toString() {
            return "DoubaoAppsChatCardContext(messageId=" + this.a + ", conversationId=" + this.b + ", sectionId=" + this.c + ')';
        }

        public a(String r10, String r11, String r12) {
            Intrinsics.checkNotNullParameter(r10, "messageId");
            this.a = r10;
            this.b = r11;
            this.c = r12;
        }
    }

    public interface b {
        void a();

        void b();
    }

    public static final class c implements Function3<k2.j, Boolean, String, Unit> {
        public final /* synthetic */ Function1<Boolean, Unit> a;

        /* JADX WARN: Multi-variable type inference failed */
        public c(Function1<? super Boolean, Unit> r1) {
            this.a = r1;
        }

        public final Object invoke(Object r1, Object r10, Object r11) {
            k2.j r12 = (k2.j) r1;
            boolean r13 = ((Boolean) r10).booleanValue();
            Intrinsics.checkNotNullParameter((String) r11, com.bytedance.android.ec.core.event.a.KEY_MSG);
            Function1<Boolean, Unit> r14 = this.a;
            if (r14 == null) goto L6;
            r14.invoke(Boolean.valueOf(r13));
        L6:
            return Unit.INSTANCE;
        }
    }

    public AppletRuntimeManager() {
    }

    static {
        INSTANCE = new AppletRuntimeManager();
        a = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, new u());
        b = new LinkedHashMap();
        c = new CopyOnWriteArrayList();
        g = CollectionsKt.emptyList();
    }

    public static com.bytedance.ai.model.widgets.c c() {
        LinkedHashMap<String, com.bytedance.ai.model.widgets.c> r0 = b;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L5
        Object r10 = Result.constructor-impl((com.bytedance.ai.model.widgets.c) CollectionsKt.last(r0.values()));     // Catch: Throwable -> L5
    L8:
        if (Result.isFailure-impl(r10) == false) goto L11;
        r10 = null;
    L11:
        return (com.bytedance.ai.model.widgets.c) r10;
    L5:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        r10 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L8
    }

    public static WorkerRuntimeManager j() {
        return (WorkerRuntimeManager) a.getValue();
    }

    public static void b(final String r1) {
        Intrinsics.checkNotNullParameter(r1, "botId");
        g(new y(r1));
    }

    public static k2.i d(final View r10) {
        k2.i r0 = null;
        if (r10 != null) goto L5;
        return null;
    L5:
        Object r1 = r10.getTag(2131363149);
        if ((r1 instanceof WeakReference) == false) goto L8;
        WeakReference r11 = (WeakReference) r1;
    L9:
        if (r11 == null) goto L17;
        Object r12 = r11.get();
        if (r12 == null) goto L17;
        if ((r12 instanceof k2.i) == false) goto L15;
        r0 = (k2.i) r12;
    L15:
        if (r0 == null) goto L17;
        return r0;
    L17:
        com.bytedance.ai.model.widgets.c r13 = (com.bytedance.ai.model.widgets.c) SequencesKt.firstOrNull(SequencesKt.filter(SequencesKt.map(MapsKt.asSequence(b), new a0()), new b0(r10)));
        if (r13 == null) goto L21;
        return r13;
    L21:
        return WidgetManager.h.a(r10);
    L8:
        r11 = null;
        goto L9
    }

    public static com.bytedance.ai.model.widgets.c e(String r1) {
        Intrinsics.checkNotNullParameter(r1, "pageId");
        return b.get(r1);
    }

    public static com.bytedance.ai.widget.contianer.h f(final String r10) {
        Intrinsics.checkNotNullParameter(r10, "widgetId");
        WidgetManager.a r0 = WidgetManager.h;
        monitor-enter(r0);
        Intrinsics.checkNotNullParameter(r10, "widgetId");     // Catch: Throwable -> L16
        Iterator r1 = CollectionsKt.asReversedMutable(WidgetManager.i).iterator();     // Catch: Throwable -> L16
    L5:
        com.bytedance.ai.widget.contianer.h r11 = null;
        if (r1.hasNext() == false) goto L14;
        WidgetManager r12 = (WidgetManager) ((WeakReference) r1.next()).get();     // Catch: Throwable -> L16
        if (r12 == null) goto L11;
        Intrinsics.checkNotNullParameter(r10, "widgetId");     // Catch: Throwable -> L16
        r11 = r12.m(new com.bytedance.ai.widget.h(r10));     // Catch: Throwable -> L16
    L11:
        if (r11 == null) goto L5;
        monitor-exit(r0);
    L15:
        return r11;
    L14:
        monitor-exit(r0);
    L16:
        th = move-exception;
        throw th;
    }

    public static void g(Function1 r10) {
        Intrinsics.checkNotNullParameter(r10, "invoke");
        WorkerRuntimeManager r1 = j();
        r1.getClass();
        Intrinsics.checkNotNullParameter(r10, "invoke");
        Iterator<Map.Entry<String, AppletRuntime>> r0 = r1.a.entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        Map.Entry<String, AppletRuntime> r11 = r0.next();
        if (r11.getValue().H() == true) goto L4;
        r10.invoke(r11.getValue());
        goto L4
    L8:
        Iterator<Map.Entry<String, AppletRuntime>> r12 = r1.b.entrySet().iterator();
    L10:
        if (r12.hasNext() == false) goto L14;
        Map.Entry<String, AppletRuntime> r13 = r12.next();
        if (r13.getValue().H() == true) goto L10;
        r10.invoke(r13.getValue());
        goto L10
    }

    public static String h(String r10) {
        Intrinsics.checkNotNullParameter(r10, "sessionId");
        ConcurrentHashMap<String, String> r0 = x4.a.a;
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Iterator<T> r1 = x4.a.a.entrySet().iterator();
    L3:
        String r11 = null;
        if (r1.hasNext() == false) goto L8;
        Object r12 = r1.next();
        if (Intrinsics.areEqual(((Map.Entry) r12).getValue(), r10) == false) goto L3;
    L9:
        Map.Entry r13 = (Map.Entry) r12;
        if (r13 == null) goto L12;
        String r14 = (String) r13.getKey();
    L13:
        if (r14 != null) goto L24;
        g2.b r15 = d;
        if (r15 == null) goto L17;
        r11 = r15.I(r10);
    L17:
        if (r11 != null) goto L20;
        return "";
    L20:
        return r11;
    L24:
        return r14;
    L12:
        r14 = null;
        goto L13
    L8:
        r12 = null;
        goto L9
    }

    public static void m(String r10) {
        Intrinsics.checkNotNullParameter(r10, "id");
        LinkedHashMap<String, com.bytedance.ai.model.widgets.c> r0 = b;
        com.bytedance.ai.model.widgets.c r1 = r0.get(r10);
        r0.remove(r10);
        Iterator<T> r11 = g.iterator();
    L4:
        if (r11.hasNext() == false) goto L8;
        b r12 = (b) r11.next();
        if (r1 == null) goto L4;
        r12.a();
        goto L4
    }

    public final void registerRuntimeLifecycleListener(RuntimeLifecycleListener r10) {
        Intrinsics.checkNotNullParameter(r10, "listener");
        c.addIfAbsent(r10);
    }

    public final void k(Map<String, ? extends Object> r30, final Function1<? super Boolean, Unit> r31) {
        Intrinsics.checkNotNullParameter(r30, "data");
        Object r0 = r30.get("appletId");
        LinkedHashMap r10 = null;
        if ((r0 instanceof String) == false) goto L5;
        String r11 = (String) r0;
    L6:
        Object r1 = r30.get("pageId");
        if ((r1 instanceof String) == false) goto L9;
        String r12 = (String) r1;
    L10:
        Object r13 = r30.get("pageData");
        if ((r13 instanceof String) == false) goto L13;
        String r14 = (String) r13;
    L14:
        if (r14 != null) goto L22;
        Object r15 = r30.get("originData");
        if ((r15 instanceof Map) == false) goto L18;
        Map r16 = (Map) r15;
    L19:
        if (r16 == null) goto L21;
        r14 = (String) r16.get("pageData");
        goto L22
    L21:
        r14 = null;
        goto L22
    L18:
        r16 = null;
    L22:
        boolean r17 = true;
        if (r14 != null) goto L25;
    L28:
        boolean r18 = true;
    L29:
        if (r18 == false) goto L143;
        String r19 = null;
    L42:
        Object r20 = r30.get("pageType");
        if ((r20 instanceof String) == false) goto L45;
        String r21 = (String) r20;
    L47:
        if (r21 != null) goto L49;
        r21 = com.bytedance.android.ec.core.event.a.VALUE_SHOW_POPUP;
    L49:
        Object r110 = r30.get("pageSettings");
        if ((r110 instanceof Map) == false) goto L52;
        Map r111 = (Map) r110;
    L53:
        if (r111 != null) goto L55;
        r111 = new LinkedHashMap();
    L55:
        Object r112 = r30.get("conversationId");
        if ((r112 instanceof String) == false) goto L58;
        String r113 = (String) r112;
    L60:
        if (r113 != null) goto L62;
        String r25 = "SYSTEM_CVS_ID";
    L63:
        Object r114 = r30.get("context");
        if ((r114 instanceof Map) == false) goto L66;
        Map<String, String> r115 = (Map) r114;
    L67:
        if (r115 != null) goto L69;
        r115 = new LinkedHashMap();
    L69:
        String r116 = r115.get("botId");
        if (r116 != null) goto L77;
        Object r22 = r30.get("botId");
        if ((r22 instanceof String) == false) goto L74;
        String r23 = (String) r22;
    L75:
        if (r23 != null) goto L78;
        r23 = "SYSTEM_CVS_ID";
    L78:
        if (r11 != null) goto L80;
    L83:
        boolean r117 = true;
    L84:
        if (r117 == true) goto L140;
        if (r12 != null) goto L87;
    L90:
        boolean r118 = true;
    L91:
        if (r118 == true) goto L140;
        i1 r119 = y0.a;
        String r120 = y0.a("api", r11, r12);
        if (Intrinsics.areEqual(r21, "full") == true) goto L100;
        if (Intrinsics.areEqual(r21, com.bytedance.android.ec.core.event.a.VALUE_SHOW_POPUP) == true) goto L100;
        r17 = false;
    L100:
        if (r17 == false) goto L102;
        y0.e(r120, r12, r21, OpenFrom.NATIVE.getFrom());
        r10 = new LinkedHashMap();
        r10.put("trace_id", r120);
        r10.put("eventName", "applet_page_timeline_full");
    L102:
        int r121 = r21.hashCode();
        double r122 = 0.5d;
        if (r121 == 3154575) goto L127;
        if (r121 == 106852524) goto L123;
        if (r121 == 2010122246) goto L110;
    L129:
        PageType r24 = PageType.FULL_PAGE;
    L130:
        PageType r123 = r24;
        double r124 = 0.5d;
        boolean r125 = false;
    L132:
        if (r19 != null) goto L134;
        r19 = "";
    L134:
        final boolean r26 = r17;
        final PageInfo r27 = new PageInfo(r12, r19, ConvertUtils.INSTANCE.mapToReadableMap(r115), null, r123, r23, null, JavaOnlyMap.from(r111), null, r124, r125, null, r10, r11, null, null, 51520, null);
        if (r26 == false) goto L137;
        final String r28 = r120;
        y0.m(r28, "applet_page_timeline_full");
    L138:
        o(this, r11, r25, r23, null, null, r10, new z(r26, r28, r27, r31), 24);
        return;
    L137:
        r28 = r120;
        goto L138
    L110:
        if (r21.equals("floating") == false) goto L129;
        String r29 = (String) r111.get("pos");
        if (r29 == null) goto L117;
        Double r32 = StringsKt.toDoubleOrNull(r29);
        if (r32 == null) goto L117;
        r122 = r32.doubleValue();
    L117:
        String r33 = (String) r111.get("align");
        if (r33 == null) goto L120;
        boolean r34 = Intrinsics.areEqual(r33, "left");
    L121:
        r123 = PageType.FLOATING_VIEW;
        r124 = r122;
        r125 = r34;
        goto L132
    L120:
        r34 = false;
        goto L121
    L123:
        if (r21.equals(com.bytedance.android.ec.core.event.a.VALUE_SHOW_POPUP) == false) goto L129;
        r24 = PageType.POPUP_PAGE;
        goto L130
    L127:
        if (r21.equals("full") == false) goto L129;
        r24 = PageType.FULL_PAGE;
        goto L130
    L87:
        if (r12.length() == 0) goto L90;
        r118 = false;
    L140:
        if (r31 == null) goto L145;
        r31.invoke(Boolean.FALSE);
        return;
    L145:
        return;
    L80:
        if (r11.length() == 0) goto L83;
        r117 = false;
        goto L84
    L74:
        r23 = null;
        goto L75
    L77:
        r23 = r116;
        goto L78
    L66:
        r115 = null;
        goto L67
    L62:
        r25 = r113;
        goto L63
    L58:
        r113 = null;
        goto L60
    L52:
        r111 = null;
        goto L53
    L45:
        r21 = null;
        goto L47
    L143:
        Result.Companion r35 = Result.Companion;     // Catch: Throwable -> L33
        new JsonParser().parse(r14);     // Catch: Throwable -> L33
        Object r36 = Result.constructor-impl(r14);     // Catch: Throwable -> L33
    L35:
        Throwable r37 = Result.exceptionOrNull-impl(r36);
        if (r37 == null) goto L39;
        com.bytedance.ai.utils.g.a.e("AppletRuntimeManager", "openPage pageData is not valid json string: " + r14, r37);
    L39:
        if (Result.isFailure-impl(r36) == false) goto L41;
        r36 = null;
    L41:
        r19 = (String) r36;
    L33:
        th = move-exception;
        Result.Companion r38 = Result.Companion;
        r36 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L35
    L25:
        if (r14.length() == 0) goto L28;
        r18 = false;
        goto L29
    L13:
        r14 = null;
        goto L14
    L9:
        r12 = null;
        goto L10
    L5:
        r11 = null;
        goto L6
    }

    public static AppletRuntime i(String r10, String r11, String r12) {
        WorkerRuntimeManager r0 = j();
        if (r10 != null) goto L7;
        if (r11 == null) goto L6;
        String r13 = x4.a.a(r11);
    L8:
        boolean r14 = false;
        if (com.bytedance.ai.utils.f.g(r12) == false) goto L18;
        AppletRuntime r15 = r0.a.get(r12);
        if (r15 != null) goto L13;
    L15:
        if (r14 == false) goto L36;
        if (r12 == null) goto L36;
        r0.d(r12);
    L35:
        r15 = null;
    L36:
        if (r15 == null) goto L46;
        if (r10 == null) goto L40;
        r15.m(r10, r11, SessionType.CHATUI);
    L40:
        return r15;
    L46:
        return null;
    L13:
        if (r15.H() != true) goto L15;
        r14 = true;
        goto L15
    L18:
        if (r13 == null) goto L34;
        Iterator r16 = MapsKt.asSequence(r0.a).iterator();
    L21:
        if (r16.hasNext() == false) goto L30;
        Object r1 = r16.next();
        AppletRuntime r17 = (AppletRuntime) ((Map.Entry) r1).getValue();
        if (r17.H() == false) goto L25;
    L27:
        boolean r18 = false;
    L28:
        if (r18 == false) goto L21;
    L31:
        Map.Entry r19 = (Map.Entry) r1;
        if (r19 == null) goto L35;
        r15 = (AppletRuntime) r19.getValue();
        goto L36
    L25:
        if (r17.s(r13) == null) goto L27;
        r18 = true;
        goto L28
    L30:
        r1 = null;
        goto L31
    L34:
        r0.getClass();
        goto L35
    L6:
        r13 = null;
        goto L8
    L7:
        r13 = r10;
        goto L8
    }

    @Override // t4.a
    public Map<String, String> getContext(String r12, final String r13, String r14) {
        Intrinsics.checkNotNullParameter(r12, "cvsId");
        Intrinsics.checkNotNullParameter(r13, "botId");
        Intrinsics.checkNotNullParameter(r14, "msgId");
        ConcurrentHashMap<String, String> r15 = x4.a.a;
        Intrinsics.checkNotNullParameter(r12, "sessionId");
        if (r13 == null) goto L6;
        x4.a.a.putIfAbsent(r13, r12);
    L6:
        com.bytedance.ai.model.widgets.c r16 = c();
        String r1 = null;
        if (r16 == null) goto L13;
        AppletRuntime r17 = r16.getAppletRuntime();
        if (r17 == null) goto L13;
        Applet r18 = r17.h;
        if (r18 == null) goto L13;
        String r19 = r18.o();
    L14:
        AppletRuntime r110 = i(r12, r13, r19);
        LinkedHashMap<String, com.bytedance.ai.model.widgets.c> r111 = b;
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L28
        Iterator<T> r112 = r111.values().iterator();     // Catch: Throwable -> L28
        Object r11 = null;
        boolean r20 = false;
    L17:
        if (r112.hasNext() == false) goto L24;
        Object r21 = r112.next();     // Catch: Throwable -> L28
        if (((com.bytedance.ai.model.widgets.c) r21).getPageInfo().getPageType() == PageType.WIDGET_PAGE) goto L21;
        boolean r22 = true;
    L22:
        if (r22 == false) goto L17;
        r11 = r21;
        r20 = true;
        goto L17
    L21:
        r22 = false;
        goto L22
    L24:
        if (r20 == false) goto L27;
        Object r113 = Result.constructor-impl((com.bytedance.ai.model.widgets.c) r11);     // Catch: Throwable -> L28
    L31:
        if (Result.isFailure-impl(r113) == false) goto L33;
        r113 = null;
    L33:
        com.bytedance.ai.model.widgets.c r114 = (com.bytedance.ai.model.widgets.c) r113;
        if (r110 == null) goto L36;
        Applet r23 = r110.h;
    L37:
        com.bytedance.ai.utils.g r24 = com.bytedance.ai.utils.g.a;
        StringBuilder r25 = new StringBuilder("getAppletPayload applet=");
        r25.append(r23);
        r25.append(" WidgetManager=");
        WidgetManager.a r26 = WidgetManager.h;
        r25.append(r26.b());
        r25.append(", currentTopPage is ");
        r25.append(r114);
        r24.i("AppletRuntimeManager", r25.toString());
        if (r114 == null) goto L46;
        PageInfo r27 = r114.getPageInfo();
        if (r27 == null) goto L46;
        String r28 = r27.getMessageId();
        if (r28 == null) goto L46;
        Boolean r29 = (Boolean) BuildersKt.runBlocking$default(null, new AppletRuntimeManager$getContext$isContextClearedMsg$1$1(r28, null), 1, null);
        if (r29 == null) goto L46;
        boolean r30 = r29.booleanValue();
    L47:
        LinkedHashMap r31 = new LinkedHashMap();
        r31.put("ui_context", "");
        if (r114 == null) goto L50;
        String r32 = r114.uiContext();
    L52:
        if (com.bytedance.ai.utils.f.g(r32) == false) goto L59;
        if (r30 == true) goto L59;
        StringBuilder r33 = new StringBuilder();
        r33.append((String) r31.get("ui_context"));
        r33.append("\"the context of current page\": ");
        if (r114 == null) goto L57;
        String r115 = r114.uiContext();
    L58:
        r33.append(r115);
        r33.append('\n');
        r31.put("ui_context", r33.toString());
        goto L59
    L57:
        r115 = null;
    L59:
        if (r23 == null) goto L61;
        String r116 = r23.f;
    L63:
        if (com.bytedance.ai.utils.f.g(r116) == false) goto L69;
        StringBuilder r117 = new StringBuilder();
        r117.append((String) r31.get("ui_context"));
        r117.append("\"current applet description\": ");
        if (r23 == null) goto L67;
        String r34 = r23.f;
    L68:
        r117.append(r34);
        r117.append('\n');
        r31.put("ui_context", r117.toString());
        goto L69
    L67:
        r34 = null;
    L69:
        if (r110 != null) goto L74;
        final Ref.ObjectRef r118 = new Ref.ObjectRef();
        final String r119 = x4.a.a(r13);
        if (r119 == null) goto L73;
        AppletRuntimeManager r35 = INSTANCE;
        Function1 r36 = new w(r119, r118);
        r35.getClass();
        g(r36);
    L73:
        r110 = (AppletRuntime) r118.element;
    L74:
        if (r110 == null) goto L80;
        Intrinsics.checkNotNullParameter(r13, "botId");
        String r120 = x4.a.a(r13);
        if (r120 != null) goto L78;
        r120 = x4.a.a(r110.h.N);
    L78:
        if (r120 == null) goto L80;
        String r121 = AppletRuntime.o(r110, r120, r13).c;
    L82:
        if (com.bytedance.ai.utils.f.g(r121) == false) goto L84;
        r31.put("ui_context", ((String) r31.get("ui_context")) + r121 + '\n');
    L87:
        WidgetManager r122 = r26.b();
        if (r122 == null) goto L108;
        WeakReference<com.bytedance.ai.widget.contianer.h> r123 = r122.g;
        if (r123 == null) goto L92;
        com.bytedance.ai.widget.contianer.h r124 = r123.get();
    L93:
        if (r124 == null) goto L108;
        String r0 = r122.c;
        if (r0 == null) goto L104;
        WidgetManager.b r125 = r122.a.get(r124);
        if (r125 == null) goto L100;
        String r126 = r125.a;
    L102:
        if (Intrinsics.areEqual(r0, r126) == false) goto L104;
        boolean r127 = true;
    L105:
        if (r127 == false) goto L108;
        r1 = r124.h(r13);
        com.bytedance.ai.applet.base.log.b r128 = com.bytedance.ai.applet.base.log.a.a;
        com.bytedance.ai.applet.base.log.a.a("WidgetManager", "getLLMContext " + r1);
        goto L108
    L100:
        r126 = null;
    L104:
        r127 = false;
        goto L105
    L92:
        r124 = null;
    L108:
        if (com.bytedance.ai.utils.f.g(r1) == false) goto L110;
        r31.put("ui_context", ((String) r31.get("ui_context")) + r1 + '\n');
    L110:
        Iterator r129 = r31.entrySet().iterator();
    L112:
        if (r129.hasNext() == false) goto L119;
        if (((CharSequence) ((Map.Entry) r129.next()).getValue()).length() != 0) goto L116;
        boolean r130 = true;
    L117:
        if (r130 == false) goto L112;
        r129.remove();
        goto L112
    L116:
        r130 = false;
        goto L117
    L119:
        return r31;
    L84:
        final Ref.ObjectRef r131 = new Ref.ObjectRef();
        g(new v(r13, r131));
        String r132 = (String) r131.element;
        if (com.bytedance.ai.utils.f.g(r132) == false) goto L87;
        r31.put("ui_context", ((String) r31.get("ui_context")) + r132 + '\n');
    L80:
        r121 = null;
        goto L82
    L61:
        r116 = null;
        goto L63
    L50:
        r32 = null;
    L46:
        r30 = false;
        goto L47
    L36:
        r23 = null;
        goto L37
    L27:
        throw new NoSuchElementException("Collection contains no element matching the predicate.");     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        Result.Companion r37 = Result.Companion;
        r113 = Result.constructor-impl(ResultKt.createFailure(th));
    L13:
        r19 = null;
        goto L14
    }

    public static void l(String r12, String r13, ApplicationRouter.Mode r14, String r15) {
        Intrinsics.checkNotNullParameter(r12, "appletName");
        Intrinsics.checkNotNullParameter(r14, "mode");
        RouteOptions r0 = null;
        if (r15 != null) goto L5;
    L10:
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new AppletRuntimeManager$openPageByDoubaoAppsSchema$1(r12, r13, r0, r14, null), 3, null);
        return;
    L5:
        if ((!StringsKt.isBlank(r15)) == true) goto L8;
        r15 = null;
    L8:
        if (r15 == null) goto L10;
        r0 = new RouteOptions(r15, 2);
        goto L10
    }

    public static Object a(AppletRuntimeManager r10, String r11, String r12, String r13, String r14, Map r15, Continuation r16) {
        r10.getClass();
        return BuildersKt.withContext(com.bytedance.ai.infra.thread_pool.b.c, new AppletRuntimeManager$awaitRunApplet$2(r11, r12, r13, r14, "", r15, null), r16);
    }

    public static void n(String r13, String r14, String r15, String r16, String r17, Map r18, Function1 r19) {
        Intrinsics.checkNotNullParameter(r13, "appletId");
        Intrinsics.checkNotNullParameter(r14, "conversationID");
        Intrinsics.checkNotNullParameter(r15, "botId");
        Intrinsics.checkNotNullParameter(r19, "runAppletResult");
        com.bytedance.ai.utils.g.a.i("AIManager", "runApplet called. appletId:" + r13 + ", conversationID:" + r14 + ", botId:" + r15 + ", messageId:" + r16);
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(com.bytedance.ai.infra.thread_pool.b.c), null, null, new AppletRuntimeManager$runApplet$1(r13, r14, r15, r16, r17, r18, r19, null), 3, null);
    }

    public static /* synthetic */ void o(AppletRuntimeManager r10, String r11, String r12, String r13, String r14, String r15, Map r16, Function1 r17, int r18) {
        if ((r18 & 8) == 0) goto L5;
        String r19 = "";
    L7:
        if ((r18 & 16) == 0) goto L9;
        String r20 = "";
    L11:
        if ((r18 & 32) == 0) goto L13;
        Map r21 = null;
    L14:
        r10.getClass();
        n(r11, r12, r13, r19, r20, r21, r17);
        return;
    L13:
        r21 = r16;
        goto L14
    L9:
        r20 = r15;
        goto L11
    L5:
        r19 = r14;
        goto L7
    }
}
