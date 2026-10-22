package com.obric.aiproactive.impl.livecard;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import androidx.core.app.NotificationCompat;
import com.bytedance.bdlocation.monitor.InfoRequestQPSOptTraceLogger;
import com.bytedance.common.wschannel.WsConstants;
import com.obric.aiproactive.api.AiProactiveCardStatus;
import com.obric.aiproactive.api.IProactiveService;
import com.obric.aiproactive.api.ProactiveRecommendationDto;
import com.obric.aiproactive.api.x;
import com.obric.aiproactive.api.z;
import com.obric.aiproactive.impl.ProactiveService;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.obric.livecard.api.entity.IslandSession;
import com.obric.memorydata.database.entity.ChatMessage;
import com.obric.memorydata.middleware.api.app.UserSettings;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.middleware.api.store.IStore;
import com.obric.memorydata.middleware.api.store.IStoreManager;
import com.obric.memorydata.middleware.api.store.StoreManager;
import com.obric.memorydata.utils.y;
import com.volcengine.zeus.receiver.PluginBroadcastReceiver;
import com.volcengine.zeus.transform.ZeusProviderTransform;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.al;
import kotlinx.coroutines.am;
import kotlinx.coroutines.ba;
import kotlinx.coroutines.cu;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000Ç\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0012*\u0001+\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u000200J\u001d\u00101\u001a\u00020.2\u0006\u0010/\u001a\u0002002\u0006\u00102\u001a\u00020\u0005H\u0000¢\u0006\u0002\b3J\u0018\u00104\u001a\u00020.2\u0006\u0010/\u001a\u0002002\u0006\u00102\u001a\u00020\u0005H\u0002J\u0018\u00105\u001a\u0004\u0018\u00010\u00182\u0006\u00106\u001a\u00020\u0005H\u0082@¢\u0006\u0002\u00107J\u0018\u00108\u001a\u0004\u0018\u00010\u00182\u0006\u00106\u001a\u00020\u0005H\u0082@¢\u0006\u0002\u00107J,\u00109\u001a\u0004\u0018\u00010\u00182\u0006\u00106\u001a\u00020\u00052\u0006\u0010:\u001a\u00020;2\n\b\u0002\u0010<\u001a\u0004\u0018\u00010\u0018H\u0082@¢\u0006\u0002\u0010=J\u0016\u0010>\u001a\u00020.2\u0006\u00106\u001a\u00020\u0005H\u0082@¢\u0006\u0002\u00107J\u001a\u0010?\u001a\u00020.2\u0006\u00106\u001a\u00020\u00052\n\b\u0002\u0010@\u001a\u0004\u0018\u00010\u0005J\u0018\u0010A\u001a\u00020.2\u0006\u00106\u001a\u00020\u00052\b\u0010@\u001a\u0004\u0018\u00010\u0005J\u0016\u0010B\u001a\u00020.2\u0006\u0010C\u001a\u00020\u00052\u0006\u0010D\u001a\u00020\u0005J\u0010\u0010E\u001a\u00020.2\u0006\u0010/\u001a\u000200H\u0002J\u0018\u0010F\u001a\u00020.2\u0006\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020\u0005H\u0002J*\u0010J\u001a\u00020.2\u0006\u0010G\u001a\u00020H2\u0006\u0010K\u001a\u00020(2\u0006\u0010I\u001a\u00020\u00052\b\b\u0002\u0010L\u001a\u00020MH\u0002J.\u0010N\u001a\u00020.2\u0006\u0010G\u001a\u00020H2\u0006\u0010K\u001a\u00020(2\u0006\u0010I\u001a\u00020\u00052\u0006\u0010L\u001a\u00020MH\u0082@¢\u0006\u0002\u0010OJ\u0018\u0010P\u001a\u00020.2\u0006\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020\u0005H\u0002J\u0016\u0010Q\u001a\u00020.2\u0006\u00106\u001a\u00020\u00052\u0006\u00102\u001a\u00020\u0005J\u0016\u0010R\u001a\u00020.2\u0006\u00106\u001a\u00020\u00052\u0006\u00102\u001a\u00020\u0005JW\u0010S\u001a\u00020.2\f\u0010T\u001a\b\u0012\u0004\u0012\u00020H0U2\u000e\b\u0002\u0010V\u001a\b\u0012\u0004\u0012\u00020H0U2\u0014\b\u0002\u0010W\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020Y0X2\n\b\u0002\u0010Z\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010[\u001a\u0004\u0018\u00010\"¢\u0006\u0002\u0010\\J\u0016\u0010]\u001a\u00020.2\f\u0010T\u001a\b\u0012\u0004\u0012\u00020H0UH\u0002JJ\u0010^\u001a\b\u0012\u0004\u0012\u00020_0U2\u0006\u0010/\u001a\u0002002\u0006\u0010G\u001a\u00020H2\u0006\u0010`\u001a\u00020\u00052\f\u0010a\u001a\b\u0012\u0004\u0012\u00020b0U2\u0006\u0010c\u001a\u00020&2\f\u0010d\u001a\b\u0012\u0004\u0012\u00020\u00180eH\u0002J4\u0010f\u001a\u00020.2\u0006\u0010G\u001a\u00020H2\u0006\u0010g\u001a\u00020b2\u0006\u0010h\u001a\u00020\u00182\n\b\u0002\u0010i\u001a\u0004\u0018\u00010jH\u0080@¢\u0006\u0004\bk\u0010lJ\u001e\u0010m\u001a\u00020&2\u0006\u00106\u001a\u00020\u00052\u0006\u0010h\u001a\u00020\u0018H\u0082@¢\u0006\u0002\u0010nJ\u001e\u0010o\u001a\u00020.2\u0006\u00106\u001a\u00020\u00052\u0006\u0010h\u001a\u00020\u0018H\u0082@¢\u0006\u0002\u0010nJ \u0010p\u001a\u00020.2\u0006\u0010/\u001a\u0002002\u0006\u0010G\u001a\u00020H2\u0006\u0010q\u001a\u00020\u0005H\u0002J\n\u0010r\u001a\u0004\u0018\u00010\u0005H\u0002J\u000f\u0010s\u001a\u0004\u0018\u00010\"H\u0002¢\u0006\u0002\u0010tJ\u0010\u0010u\u001a\u00020.2\u0006\u0010v\u001a\u00020\u0005H\u0002J\u0018\u0010w\u001a\u00020.2\u0006\u00106\u001a\u00020\u00052\u0006\u00102\u001a\u00020\u0005H\u0002J\u001e\u0010x\u001a\u00020.2\u0006\u00106\u001a\u00020\u00052\u0006\u0010I\u001a\u00020\u0005H\u0082@¢\u0006\u0002\u0010yJ\u0018\u0010z\u001a\u00020.2\u0006\u0010{\u001a\u00020\"2\u0006\u00102\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u0011\u001a\u00020\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00180\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00050\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00050\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u001e\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u001f0\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010!\u001a\u0004\u0018\u00010\"X\u0082\u000e¢\u0006\u0004\n\u0002\u0010#R\u0010\u0010$\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010'\u001a\u0004\u0018\u00010(X\u0082\u000e¢\u0006\u0004\n\u0002\u0010)R\u0010\u0010*\u001a\u00020+X\u0082\u0004¢\u0006\u0004\n\u0002\u0010,¨\u0006|"}, d2 = {"Lcom/obric/aiproactive/impl/livecard/ProactiveLiveCardManager;", "", "<init>", "()V", "TAG", "", "LIVE_CARD_STORE_REPO", "scope", "Lkotlinx/coroutines/CoroutineScope;", "mutex", "Lkotlinx/coroutines/sync/Mutex;", "store", "Lcom/obric/memorydata/middleware/api/store/IStore;", "getStore", "()Lcom/obric/memorydata/middleware/api/store/IStore;", "store$delegate", "Lkotlin/Lazy;", "aiDbRepository", "Lcom/obric/aiproactive/impl/aidb/AiProactiveDbRepository;", "getAiDbRepository", "()Lcom/obric/aiproactive/impl/aidb/AiProactiveDbRepository;", "aiDbRepository$delegate", "activeSessions", "", "Lcom/obric/livecard/api/entity/IslandSession;", "processedIds", "", "retainedDismissTimerState", "Lcom/obric/aiproactive/impl/livecard/RetainedDismissTimerState;", "trackedDismissTimerIds", "continueSessionsInFlight", "", "activeCandidateSetKey", "activeTopRowId", "", "Ljava/lang/Long;", "activeRecommendId", "themeChangeReceiverRegistered", "", "lastUiNightMode", "", "Ljava/lang/Integer;", "themeChangeReceiver", "com/obric/aiproactive/impl/livecard/ProactiveLiveCardManager$themeChangeReceiver$1", "Lcom/obric/aiproactive/impl/livecard/ProactiveLiveCardManager$themeChangeReceiver$1;", "startThemeChangeMonitor", "", "context", "Landroid/content/Context;", "refreshActiveSessionThemeIfNeeded", InfoRequestQPSOptTraceLogger.REASON, "refreshActiveSessionThemeIfNeeded$ai_proactive_impl_obricRelease", "refreshActiveSessionTheme", "detachSessionAndMarkProcessed", "recommendId", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "detachSessionForDetailOpen", "detachSession", "policy", "Lcom/obric/aiproactive/impl/livecard/LockScreenDetachPolicy;", "expectedSession", "(Ljava/lang/String;Lcom/obric/aiproactive/impl/livecard/LockScreenDetachPolicy;Lcom/obric/livecard/api/entity/IslandSession;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "removeActiveSession", "markAsProcessed", "feedbackAction", "syncProcessedStateFromApp", "destroyAllForAccountChange", "oldUserId", "newUserId", "collapseStatusBar", "syncAdoptedStateToUiAndDb", NotificationCompat.CATEGORY_RECOMMENDATION, "Lcom/obric/aiproactive/api/ProactiveRecommendationDto;", "actionLabel", "syncSpecificActionExecutedStateToUiAndDb", "actionIndex", "cardStatus", "Lcom/obric/aiproactive/api/AiProactiveCardStatus;", "persistSpecificActionStateAndNotify", "(Lcom/obric/aiproactive/api/ProactiveRecommendationDto;ILjava/lang/String;Lcom/obric/aiproactive/api/AiProactiveCardStatus;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendAdoptedStateToUi", "syncDismissStateToUi", "syncDismissStateToUiAndDb", "syncToLockScreen", "recommendations", "", "dismissRecommendations", "displayTextByRecommendId", "", "Lcom/obric/aiproactive/impl/livecard/AiProactiveLockScreenDisplayText;", "candidateSetKey", "topRowId", "(Ljava/util/List;Ljava/util/List;Ljava/util/Map;Ljava/lang/String;Ljava/lang/Long;)V", "syncDismissTimersLocked", "buildLiveCardActionButtons", "Lcom/obric/aiproactive/impl/livecard/ProactiveLiveCardDisplayTool$CardActionButton;", "recommendContent", "lockScreenActions", "Lcom/obric/aiproactive/impl/livecard/AiSuggestionLockScreenAction;", "hasLegacyExecuteInstruction", "sessionHolder", "Lcom/obric/aiproactive/impl/livecard/LockScreenActionSessionHolder;", "submitContinueFromLockScreen", "action", "session", "service", "Lcom/obric/aiproactive/api/IProactiveService;", "submitContinueFromLockScreen$ai_proactive_impl_obricRelease", "(Lcom/obric/aiproactive/api/ProactiveRecommendationDto;Lcom/obric/aiproactive/impl/livecard/AiSuggestionLockScreenAction;Lcom/obric/livecard/api/entity/IslandSession;Lcom/obric/aiproactive/api/IProactiveService;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "acquireContinueSubmissionGate", "(Ljava/lang/String;Lcom/obric/livecard/api/entity/IslandSession;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "releaseContinueSubmissionGate", "launchAssistantFromLockScreen", ChatMessage.TYPE_QUERY, "readConsumedCandidateSetKey", "readConsumedTopRowId", "()Ljava/lang/Long;", "consumeActiveCandidateSetLocked", "processedRecommendId", "sendDismissStateToUi", "syncAiProactiveDbState", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "notifyAiProactiveUiStateChanged", "recommendationId", "ai_proactive_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final n f6478a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final al f6479b = null;
    private static final kotlinx.coroutines.sync.a c = null;
    private static final Lazy d = null;
    private static final Lazy e = null;
    private static final Map<String, IslandSession> f = null;
    private static final Set<String> g = null;
    private static final t h = null;
    private static final Set<String> i = null;
    private static final Map<String, List<IslandSession>> j = null;
    private static String k;
    private static Long l;
    private static String m;
    private static boolean n;
    private static Integer o;
    private static final a p = null;

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, d2 = {"com/obric/aiproactive/impl/livecard/ProactiveLiveCardManager$themeChangeReceiver$1", "Landroid/content/BroadcastReceiver;", "onReceive", "", "context", "Landroid/content/Context;", MemorySourceLinkType.INTENT, "Landroid/content/Intent;", "ai_proactive_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a extends PluginBroadcastReceiver {
        a() {
        }

        public void onReceive(Context r2, Intent r3) {
            Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r1, "context");
            if (r3 == null) goto L5;
            String r4 = r3.getAction();
        L7:
            if (Intrinsics.areEqual(r4, "android.intent.action.CONFIGURATION_CHANGED") == true) goto L9;
            return;
        L9:
            n.f6478a.a(r1, "configuration_changed");
            return;
        L5:
            r4 = null;
            goto L7
        }
    }

    static {
        f6478a = new n();
        f6479b = am.a(cu.a(null, 1, null).plus((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin")));
        c = kotlinx.coroutines.sync.c.a(false, 1, null);
        d = LazyKt.lazy($$Lambda$n$S2FX36VDvZwZCBx3qTB2kmldac.INSTANCE);
        e = LazyKt.lazy($$Lambda$n$5laEdPwRkMfZTRMCeEhsc8bXtw.INSTANCE);
        f = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        g = (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.memorydata.plugin");
        h = new t();
        i = (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.memorydata.plugin");
        j = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        p = new a();
    }

    private n() {
    }

    private static final z a(IProactiveService r2, x r3) {
        return ((IProactiveService) ZeusTransformUtils.wrapperContextForParams(r2, IProactiveService.class, "com.obric.memorydata.plugin")).submitAiProactiveUserRequirement(r3);
    }

    private final Object a(ProactiveRecommendationDto r18, int r19, String r20, AiProactiveCardStatus r21, Continuation<? super Unit> r22) {
        n r0 = this;
        Continuation r2 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r22, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r2, ProactiveLiveCardManager$persistSpecificActionStateAndNotify$1.class) == false) goto L7;
        ProactiveLiveCardManager$persistSpecificActionStateAndNotify$1 r4 = (ProactiveLiveCardManager$persistSpecificActionStateAndNotify$1) ZeusTransformUtils.preCheckCast(r2, ProactiveLiveCardManager$persistSpecificActionStateAndNotify$1.class, "com.obric.memorydata.plugin");
        if ((r4.label & Integer.MIN_VALUE) == 0) goto L7;
        r4.label -= Integer.MIN_VALUE;
    L8:
        ProactiveLiveCardManager$persistSpecificActionStateAndNotify$1 r12 = r4;
        Object r3 = r12.result;
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r6 = r12.label;
        if (r6 == 0) goto L18;
        if (r6 != 1) goto L17;
        int r1 = r12.I$0;
        Long r7 = (Long) ZeusTransformUtils.preCheckCast(r12.L$2, Long.class, "com.obric.memorydata.plugin");
        String r8 = (String) ZeusTransformUtils.preCheckCast(r12.L$1, String.class, "com.obric.memorydata.plugin");
        n r9 = (n) ZeusTransformUtils.preCheckCast(r12.L$0, n.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r3);     // Catch: Throwable -> L14
        Long r10 = r7;
        r0 = r9;
    L35:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ProactiveLiveCardManager", "Synced specific lock-screen action to ai_proactive DB recommendId=" + r10 + " actionIndex=" + r1, false, 4, null);     // Catch: Throwable -> L14
        r0.a(r10.longValue(), r8);     // Catch: Throwable -> L14
    L41:
        return Unit.INSTANCE;
    L14:
        th = th;
    L39:
        RunLog.INSTANCE.error("ProactiveLiveCardManager", "Failed to sync ai_proactive DB status on lock screen action=" + r8 + " actionIndex=" + r1, th);
        goto L41
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r3);
        r0.b(r18, r20);
        Long r11 = StringsKt.toLongOrNull(r18.getRecommendId());     // Catch: Throwable -> L37
        if (r11 != null) goto L22;
    L27:
        Long r14 = null;
    L28:
        if (r14 != null) goto L31;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ProactiveLiveCardManager", "Skip ai_proactive action DB sync because recommendId is invalid recommendId=" + r18.getRecommendId(), null, 4, null);     // Catch: Throwable -> L37
        return Unit.INSTANCE;
    L31:
        com.obric.aiproactive.impl.aidb.d r13 = g();     // Catch: Throwable -> L37
        long r15 = r14.longValue();     // Catch: Throwable -> L37
        r12.L$0 = r0;     // Catch: Throwable -> L37
        r12.L$1 = r20;     // Catch: Throwable -> L37
        r12.L$2 = r14;     // Catch: Throwable -> L37
        r12.I$0 = r19;     // Catch: Throwable -> L37
        r12.label = 1;     // Catch: Throwable -> L37
        Long r16 = r14;
        if (com.obric.aiproactive.impl.aidb.d.a(r13, r15, r19, r21, 0, r12, 8, null) != r5) goto L34;
        return r5;
    L34:
        r8 = r20;
        r10 = r16;
        r1 = r19;
        goto L35
    L22:
        if (((Number) ZeusTransformUtils.preCheckCast(r11, Number.class, "com.obric.memorydata.plugin")).longValue() <= 0) goto L24;
        boolean r17 = true;
    L25:
        if (r17 == false) goto L27;
        r14 = r11;
        goto L28
    L24:
        r17 = false;
    L37:
        th = th;
        r8 = r20;
        r1 = r19;
    L7:
        r4 = new ProactiveLiveCardManager$persistSpecificActionStateAndNotify$1(r0, r2);
        goto L8
    }

    public static final /* synthetic */ Object a(n r6, ProactiveRecommendationDto r7, int r8, String r9, AiProactiveCardStatus r10, Continuation r11) {
        return r6.a(r7, r8, r9, r10, (Continuation) ZeusTransformUtils.wrapperContextForParams(r11, Continuation.class, "com.obric.memorydata.plugin"));
    }

    public static /* synthetic */ Object a(n r7, ProactiveRecommendationDto r8, h r9, IslandSession r10, IProactiveService r11, Continuation r12, int r13, Object r14) {
        IProactiveService r15 = (IProactiveService) ZeusTransformUtils.wrapperContextForParams(r11, IProactiveService.class, "com.obric.memorydata.plugin");
        Continuation<? super Unit> r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r12, Continuation.class, "com.obric.memorydata.plugin");
        if ((r13 & 8) == 0) goto L6;
        r15 = (IProactiveService) ZeusTransformUtils.preCheckCast(ProactiveService.Companion.a(), IProactiveService.class, "com.obric.memorydata.plugin");
    L6:
        return r7.a(r8, r9, r10, r15, r6);
    }

    public static final /* synthetic */ Object a(n r2, String r3, j r4, IslandSession r5, Continuation r6) {
        return r2.a(r3, r4, r5, (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin"));
    }

    static /* synthetic */ Object a(n r1, String r2, j r3, IslandSession r4, Continuation r5, int r6, Object r7) {
        Continuation<? super IslandSession> r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        if ((r6 & 4) == 0) goto L6;
        r4 = null;
    L6:
        return r1.a(r2, r3, r4, r8);
    }

    public static final /* synthetic */ Object a(n r2, String r3, IslandSession r4, Continuation r5) {
        return r2.a(r3, r4, (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin"));
    }

    public static final /* synthetic */ Object a(n r2, String r3, String r4, Continuation r5) {
        return r2.a(r3, r4, (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin"));
    }

    public static final /* synthetic */ Object a(n r2, String r3, Continuation r4) {
        return r2.a(r3, (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    private final Object a(String r6, j r7, IslandSession r8, Continuation<? super IslandSession> r9) {
        Continuation r10 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r9, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r10, ProactiveLiveCardManager$detachSession$1.class) == false) goto L7;
        ProactiveLiveCardManager$detachSession$1 r0 = (ProactiveLiveCardManager$detachSession$1) ZeusTransformUtils.preCheckCast(r10, ProactiveLiveCardManager$detachSession$1.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r5 = r0.result;
        Object r11 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        if (r2 == 0) goto L14;
        if (r2 != 1) goto L13;
        kotlinx.coroutines.sync.a r12 = (kotlinx.coroutines.sync.a) ZeusTransformUtils.preCheckCast(r0.L$3, kotlinx.coroutines.sync.a.class, "com.obric.memorydata.plugin");
        r8 = (IslandSession) ZeusTransformUtils.preCheckCast(r0.L$2, IslandSession.class, "com.obric.memorydata.plugin");
        r7 = (j) ZeusTransformUtils.preCheckCast(r0.L$1, j.class, "com.obric.memorydata.plugin");
        String r13 = (String) ZeusTransformUtils.preCheckCast(r0.L$0, String.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r5);
        kotlinx.coroutines.sync.a r14 = r12;
        r6 = r13;
    L39:
        Map<String, IslandSession> r15 = f;     // Catch: Throwable -> L36
        IslandSession r1 = (IslandSession) ZeusTransformUtils.preCheckCast(r15.get(r6), IslandSession.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L36
        if (r1 != null) goto L20;
    L19:
        IslandSession r16 = null;
    L34:
        r14.b(null);
        return r16;
    L20:
        if (r8 == null) goto L24;
        if (r1 != r8) goto L19;
    L24:
        if (r7.a() == false) goto L27;
        g.add(r6);     // Catch: Throwable -> L36
    L27:
        if (r7.b() == false) goto L30;
        f6478a.c(r6);     // Catch: Throwable -> L36
    L30:
        if (r7.c() == false) goto L32;
        l.f6475a.a(r6);     // Catch: Throwable -> L36
    L33:
        r16 = (IslandSession) ZeusTransformUtils.preCheckCast(r15.remove(r6), IslandSession.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L36
        goto L34
    L32:
        h.a(r6);     // Catch: Throwable -> L36
    L36:
        th = move-exception;
        r14.b(null);
        throw th;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r5);
        r14 = c;
        r0.L$0 = r6;
        r0.L$1 = r7;
        r0.L$2 = r8;
        r0.L$3 = r14;
        r0.label = 1;
        if (r14.a(null, r0) != r11) goto L39;
        return r11;
    L7:
        r0 = new ProactiveLiveCardManager$detachSession$1(this, r10);
        goto L8
    }

    private final Object a(String r7, IslandSession r8, Continuation<? super Boolean> r9) {
        Continuation r10 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r9, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r10, ProactiveLiveCardManager$acquireContinueSubmissionGate$1.class) == false) goto L7;
        ProactiveLiveCardManager$acquireContinueSubmissionGate$1 r0 = (ProactiveLiveCardManager$acquireContinueSubmissionGate$1) ZeusTransformUtils.preCheckCast(r10, ProactiveLiveCardManager$acquireContinueSubmissionGate$1.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r6 = r0.result;
        Object r11 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        boolean r4 = true;
        if (r2 == 0) goto L14;
        if (r2 != 1) goto L13;
        kotlinx.coroutines.sync.a r12 = (kotlinx.coroutines.sync.a) ZeusTransformUtils.preCheckCast(r0.L$2, kotlinx.coroutines.sync.a.class, "com.obric.memorydata.plugin");
        r8 = (IslandSession) ZeusTransformUtils.preCheckCast(r0.L$1, IslandSession.class, "com.obric.memorydata.plugin");
        String r13 = (String) ZeusTransformUtils.preCheckCast(r0.L$0, String.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r6);
        kotlinx.coroutines.sync.a r14 = r12;
        r7 = r13;
    L47:
    L44:
        th = move-exception;
        r14.b(null);
        throw th;
    L18:
        if (f.get(r7) == r8) goto L20;
    L19:
        r4 = false;
    L41:
        Boolean r15 = Boxing.boxBoolean(r4);     // Catch: Throwable -> L44
        r14.b(null);
        return r15;
    L20:
        Map<String, List<IslandSession>> r16 = j;     // Catch: Throwable -> L44
        List<IslandSession> r3 = r16.get(r7);     // Catch: Throwable -> L44
        if (r3 != null) goto L23;
        r3 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L44
        r16.put(r7, r3);     // Catch: Throwable -> L44
    L23:
        List r17 = (List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L44
        Iterable r18 = (Iterable) ZeusTransformUtils.preCheckCast(r17, Iterable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L44
        if (ZeusTransformUtils.instanceOf(r18, Collection.class) == true) goto L26;
    L28:
        Iterator r19 = r18.iterator();     // Catch: Throwable -> L44
    L30:
        if (r19.hasNext() == false) goto L37;
        if (((IslandSession) ZeusTransformUtils.preCheckCast(r19.next(), IslandSession.class, "com.obric.memorydata.plugin")) != r8) goto L34;
        boolean r5 = true;
    L35:
        if (r5 == false) goto L30;
        boolean r20 = true;
    L38:
        if (r20 == true) goto L19;
        r17.add(r8);     // Catch: Throwable -> L44
        goto L41
    L34:
        r5 = false;
    L37:
        r20 = false;
        goto L38
    L26:
        if (((Collection) ZeusTransformUtils.preCheckCast(r18, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L28;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r6);
        r14 = c;
        r0.L$0 = r7;
        r0.L$1 = r8;
        r0.L$2 = r14;
        r0.label = 1;
        if (r14.a(null, r0) != r11) goto L47;
        return r11;
    L7:
        r0 = new ProactiveLiveCardManager$acquireContinueSubmissionGate$1(this, r10);
        goto L8
    }

    private final Object a(String r21, String r22, Continuation<? super Unit> r23) {
        n r0 = this;
        String r1 = r22;
        Continuation r3 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r23, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r3, ProactiveLiveCardManager$syncAiProactiveDbState$1.class) == false) goto L7;
        ProactiveLiveCardManager$syncAiProactiveDbState$1 r5 = (ProactiveLiveCardManager$syncAiProactiveDbState$1) ZeusTransformUtils.preCheckCast(r3, ProactiveLiveCardManager$syncAiProactiveDbState$1.class, "com.obric.memorydata.plugin");
        if ((r5.label & Integer.MIN_VALUE) == 0) goto L7;
        r5.label -= Integer.MIN_VALUE;
    L8:
        Object r4 = r5.result;
        Object r15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r6 = r5.label;
        if (r6 == 0) goto L20;
        if (r6 == 1) goto L19;
        if (r6 == 2) goto L18;
        if (r6 == 3) goto L17;
        if (r6 != 4) goto L16;
        c r2 = (c) ZeusTransformUtils.preCheckCast(r5.L$2, c.class, "com.obric.memorydata.plugin");
        r1 = (String) ZeusTransformUtils.preCheckCast(r5.L$1, String.class, "com.obric.memorydata.plugin");
        n r7 = (n) ZeusTransformUtils.preCheckCast(r5.L$0, n.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r4);
        c r8 = r2;
        r0 = r7;
    L51:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ProactiveLiveCardManager", "Synced status to ai_proactive DB recommendId=" + ((c.b) ZeusTransformUtils.preCheckCast(r8, c.b.class, "com.obric.memorydata.plugin")).a() + " cardStatus=" + ((c.b) ZeusTransformUtils.preCheckCast(r8, c.b.class, "com.obric.memorydata.plugin")).b(), false, 4, null);
        long r9 = ((c.b) ZeusTransformUtils.preCheckCast(r8, c.b.class, "com.obric.memorydata.plugin")).a();
    L52:
        r0.a(r9, r1);
    L54:
        return Unit.INSTANCE;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        c r10 = (c) ZeusTransformUtils.preCheckCast(r5.L$2, c.class, "com.obric.memorydata.plugin");
        r1 = (String) ZeusTransformUtils.preCheckCast(r5.L$1, String.class, "com.obric.memorydata.plugin");
        n r11 = (n) ZeusTransformUtils.preCheckCast(r5.L$0, n.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r4);
        r8 = r10;
        r0 = r11;
    L47:
        Unit r12 = Unit.INSTANCE;
        goto L51
    L18:
        c r13 = (c) ZeusTransformUtils.preCheckCast(r5.L$2, c.class, "com.obric.memorydata.plugin");
        r1 = (String) ZeusTransformUtils.preCheckCast(r5.L$1, String.class, "com.obric.memorydata.plugin");
        n r14 = (n) ZeusTransformUtils.preCheckCast(r5.L$0, n.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r4);
    L38:
        n r19 = r14;
        r8 = r13;
        r0 = r19;
    L39:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ProactiveLiveCardManager", "Synced execute action to ai_proactive DB recommendId=" + ((c.a) ZeusTransformUtils.preCheckCast(r8, c.a.class, "com.obric.memorydata.plugin")).a(), false, 4, null);
        r9 = ((c.a) ZeusTransformUtils.preCheckCast(r8, c.a.class, "com.obric.memorydata.plugin")).a();
        goto L52
    L19:
        c r16 = (c) ZeusTransformUtils.preCheckCast(r5.L$2, c.class, "com.obric.memorydata.plugin");
        r1 = (String) ZeusTransformUtils.preCheckCast(r5.L$1, String.class, "com.obric.memorydata.plugin");
        n r17 = (n) ZeusTransformUtils.preCheckCast(r5.L$0, n.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r4);
        r8 = r16;
        r0 = r17;
    L28:
        com.obric.aiproactive.api.t r18 = (com.obric.aiproactive.api.t) ZeusTransformUtils.preCheckCast(r4, com.obric.aiproactive.api.t.class, "com.obric.memorydata.plugin");
        if (r18 == null) goto L31;
        AiProactiveCardStatus r20 = r18.l();
    L33:
        if (r20 == AiProactiveCardStatus.EXECUTED) goto L39;
        com.obric.aiproactive.impl.aidb.d r24 = r0.g();
        long r25 = ((c.a) ZeusTransformUtils.preCheckCast(r8, c.a.class, "com.obric.memorydata.plugin")).a();
        AiProactiveCardStatus r26 = AiProactiveCardStatus.EXECUTED;
        r5.L$0 = r0;
        r5.L$1 = r1;
        r5.L$2 = r8;
        r5.label = 2;
        if (com.obric.aiproactive.impl.aidb.d.a(r24, r25, r26, 0, r5, 4, null) != r15) goto L37;
        return r15;
    L37:
        c r110 = r8;
        r14 = r0;
        r13 = r110;
        goto L38
    L31:
        r20 = null;
        goto L33
    L20:
        ResultKt.throwOnFailure(r4);
        r8 = o.c(r21, r22);
        if (r8 != null) goto L24;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ProactiveLiveCardManager", "Skip ai_proactive DB sync because mutation is unresolved recommendId=" + r21 + " action=" + r1, null, 4, null);
        goto L54
    L24:
        if (ZeusTransformUtils.instanceOf(r8, c.a.class) == false) goto L41;
        com.obric.aiproactive.impl.aidb.d r27 = g();
        long r28 = ((c.a) ZeusTransformUtils.preCheckCast(r8, c.a.class, "com.obric.memorydata.plugin")).a();
        r5.L$0 = r0;
        r5.L$1 = r1;
        r5.L$2 = r8;
        r5.label = 1;
        r4 = com.obric.aiproactive.impl.aidb.d.a(r27, r28, 0, r5, 2, null);
        if (r4 != r15) goto L28;
        return r15;
    L41:
        if (ZeusTransformUtils.instanceOf(r8, c.b.class) == false) goto L56;
        if (Intrinsics.areEqual(r1, "auto_dismiss") == false) goto L48;
        com.obric.aiproactive.impl.aidb.d r29 = g();
        long r30 = ((c.b) ZeusTransformUtils.preCheckCast(r8, c.b.class, "com.obric.memorydata.plugin")).a();
        AiProactiveCardStatus r31 = ((c.b) ZeusTransformUtils.preCheckCast(r8, c.b.class, "com.obric.memorydata.plugin")).b();
        r5.L$0 = r0;
        r5.L$1 = r1;
        r5.L$2 = r8;
        r5.label = 3;
        if (com.obric.aiproactive.impl.aidb.d.a(r29, r30, r31, "auto_dismiss", null, null, 0, r5, 56, null) != r15) goto L47;
        return r15;
    L48:
        com.obric.aiproactive.impl.aidb.d r32 = g();
        long r33 = ((c.b) ZeusTransformUtils.preCheckCast(r8, c.b.class, "com.obric.memorydata.plugin")).a();
        AiProactiveCardStatus r111 = ((c.b) ZeusTransformUtils.preCheckCast(r8, c.b.class, "com.obric.memorydata.plugin")).b();
        r5.L$0 = r0;
        r5.L$1 = r1;
        r5.L$2 = r8;
        r5.label = 4;
        if (com.obric.aiproactive.impl.aidb.d.a(r32, r33, r111, 0, r5, 4, null) != r15) goto L51;
        return r15;
    L56:
        throw new NoWhenBranchMatchedException();
    L7:
        r5 = new ProactiveLiveCardManager$syncAiProactiveDbState$1(r0, r3);
        goto L8
    }

    private final Object a(String r8, Continuation<? super IslandSession> r9) {
        Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r9, Continuation.class, "com.obric.memorydata.plugin");
        return a(this, r8, o.a(LockScreenDetachReason.PROCESSED), null, r4, 4, null);
    }

    public static final /* synthetic */ String a(n r0) {
        return r0.h();
    }

    private final List<ProactiveLiveCardDisplayTool.CardActionButton> a(Context r18, final ProactiveRecommendationDto r19, String r20, List<h> r21, final boolean r22, final i<IslandSession> r23) {
        final Context r0 = (Context) ZeusTransformUtils.wrapperContextForParams(r18, Context.class, "com.obric.memorydata.plugin");
        List r2 = (List) ZeusTransformUtils.wrapperContextForParams(r21, List.class, "com.obric.memorydata.plugin");
        if (r2.isEmpty() == true) goto L5;
        Iterable r3 = (Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.memorydata.plugin");
        Collection r8 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r3, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r9 = r3.iterator();
    L8:
        if (r9.hasNext() == false) goto L11;
        final h r4 = (h) ZeusTransformUtils.preCheckCast(r9.next(), h.class, "com.obric.memorydata.plugin");
        r8.add(new ProactiveLiveCardDisplayTool.CardActionButton("action_" + r4.a(), r4.b(), r4.d(), "left", new $$Lambda$n$mDEGfhGhRnq5Xq2xq8wKlHL1B9M(r4, r19, r23, r0, r22)));
        goto L8
    L11:
        return (List) ZeusTransformUtils.preCheckCast(r8, List.class, "com.obric.memorydata.plugin");
    L5:
        return CollectionsKt.emptyList();
    }

    public static final /* synthetic */ List a(n r9, Context r10, ProactiveRecommendationDto r11, String r12, List r13, boolean r14, i r15) {
        return r9.a((Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.memorydata.plugin"), r11, r12, (List) ZeusTransformUtils.wrapperContextForParams(r13, List.class, "com.obric.memorydata.plugin"), r14, r15);
    }

    private static final Unit a(h r14, ProactiveRecommendationDto r15, i r16, Context r17, boolean r18) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r17, Context.class, "com.obric.memorydata.plugin");
        if (r14.d() == false) goto L5;
        String r0 = "execute_now";
    L6:
        String r6 = r0;
        r.f6485a.a(r15, r6);
        if (r14.e() == false) goto L12;
        IslandSession r1 = (IslandSession) ZeusTransformUtils.preCheckCast(r16.a(), IslandSession.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L11;
    L13:
        IslandSession r5 = r1;
        kotlinx.coroutines.i.a(f6479b, null, null, (Function2) ZeusTransformUtils.preCheckCast(new ProactiveLiveCardManager$buildLiveCardActionButtons$1$1$1(r14, r15, r5, r6, r7, r18, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        return Unit.INSTANCE;
    L11:
        return Unit.INSTANCE;
    L12:
        r1 = null;
        goto L13
    L5:
        r0 = "get";
        goto L6
    }

    public static final /* synthetic */ kotlinx.coroutines.sync.a a() {
        return c;
    }

    private final void a(long r7, String r9) {
        ProactiveService r6 = ProactiveService.Companion.a();
        if (r6 != null) goto L6;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ProactiveLiveCardManager", "Skip direct ai_proactive UI notify because service is null recommendId=" + r7 + " reason=" + r9, null, 4, null);
        return;
    L6:
        r6.notifyAiProactiveRecommendationChangedFromLockScreen$ai_proactive_impl_obricRelease(r7, r9);
    }

    private final void a(Context r9, ProactiveRecommendationDto r10, String r11) {
        Context r12 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L5;
        return;
    L5:
        b(r12);
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L11
        n r8 = (n) ZeusTransformUtils.preCheckCast(this, n.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        Uri r3 = Uri.parse("content://com.obric.assistantaiagent.AgentOpenApiProvider");     // Catch: Throwable -> L11
        JSONObject r13 = new JSONObject();     // Catch: Throwable -> L11
        String r2 = r10.getActionContext();     // Catch: Throwable -> L11
        if (r2 != null) goto L9;
        r2 = "";
    L9:
        r13.put("o_pc_recommend_reason", r2);     // Catch: Throwable -> L11
        Bundle r6 = new Bundle();     // Catch: Throwable -> L11
        r6.putString(ChatMessage.TYPE_QUERY, r11);     // Catch: Throwable -> L11
        r6.putString("o_omni_instruction_type", "manual_normal");     // Catch: Throwable -> L11
        r6.putString("o_instruction_entry", "app_query");     // Catch: Throwable -> L11
        r6.putString("expand_state", "half");     // Catch: Throwable -> L11
        r6.putString(WsConstants.KEY_EXTRA, r13.toString());     // Catch: Throwable -> L11
        ZeusProviderTransform.call(r12.getContentResolver(), r3, "try_send_omni_query", null, r6, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ProactiveLiveCardManager", "Executed lock-screen action via Assistant AI Agent for recommendId: " + r10.getRecommendId(), false, 4, null);     // Catch: Throwable -> L11
        Object r14 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L11
    L13:
        Throwable r15 = Result.m1424exceptionOrNullimpl(r14);
        if (r15 == null) goto L19;
        RunLog.INSTANCE.warn("ProactiveLiveCardManager", "Failed to execute lock-screen action via Assistant AI Agent for recommendId: " + r10.getRecommendId(), r15);
        return;
    L19:
        return;
    L11:
        th = move-exception;
        Result.Companion r16 = Result.Companion;
        r14 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L13
    }

    private final void a(ProactiveRecommendationDto r8, int r9, String r10, AiProactiveCardStatus r11) {
        kotlinx.coroutines.i.a(f6479b, null, null, (Function2) ZeusTransformUtils.preCheckCast(new ProactiveLiveCardManager$syncSpecificActionExecutedStateToUiAndDb$1(r8, r9, r10, r11, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    }

    private final void a(ProactiveRecommendationDto r7, String r8) {
        kotlinx.coroutines.i.a(f6479b, null, null, (Function2) ZeusTransformUtils.preCheckCast(new ProactiveLiveCardManager$syncAdoptedStateToUiAndDb$1(r8, r7, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    }

    public static final /* synthetic */ void a(n r2, Context r3) {
        r2.b((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"));
    }

    public static final /* synthetic */ void a(n r2, Context r3, ProactiveRecommendationDto r4, String r5) {
        r2.a((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), r4, r5);
    }

    static /* synthetic */ void a(n r0, ProactiveRecommendationDto r1, int r2, String r3, AiProactiveCardStatus r4, int r5, Object r6) {
        if ((r5 & 8) == 0) goto L5;
        r4 = AiProactiveCardStatus.EXECUTED;
    L5:
        r0.a(r1, r2, r3, r4);
    }

    public static final /* synthetic */ void a(n r0, ProactiveRecommendationDto r1, String r2) {
        r0.a(r1, r2);
    }

    public static final /* synthetic */ void a(n r0, String r1) {
        r0.c(r1);
    }

    public static final /* synthetic */ void a(n r0, String r1, String r2) {
        r0.d(r1, r2);
    }

    public static final /* synthetic */ void a(n r2, List r3) {
        r2.a((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    public static final /* synthetic */ void a(Long r0) {
        l = r0;
    }

    public static final /* synthetic */ void a(String r0) {
        k = r0;
    }

    private final void a(List<ProactiveRecommendationDto> r11) {
        List r10 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.memorydata.plugin");
        Iterable r12 = (Iterable) ZeusTransformUtils.preCheckCast(r10, Iterable.class, "com.obric.memorydata.plugin");
        Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r12, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r13 = r12.iterator();
    L4:
        if (r13.hasNext() == false) goto L6;
        r1.add(((ProactiveRecommendationDto) ZeusTransformUtils.preCheckCast(r13.next(), ProactiveRecommendationDto.class, "com.obric.memorydata.plugin")).getRecommendId());
        goto L4
    L6:
        Set r14 = CollectionsKt.toSet((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"));
        Iterator r2 = ((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.subtract((Iterable) ZeusTransformUtils.preCheckCast(i, Iterable.class, "com.obric.memorydata.plugin"), (Iterable) ZeusTransformUtils.preCheckCast(r14, Iterable.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L8:
        if (r2.hasNext() == false) goto L10;
        l.f6475a.a((String) ZeusTransformUtils.preCheckCast(r2.next(), String.class, "com.obric.memorydata.plugin"));
        goto L8
    L10:
        Set<String> r3 = i;
        r3.clear();
        r3.addAll((Collection) ZeusTransformUtils.preCheckCast(r14, Collection.class, "com.obric.memorydata.plugin"));
        Iterator r15 = ((Iterable) ZeusTransformUtils.preCheckCast(r10, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L12:
        if (r15.hasNext() == false) goto L20;
        ProactiveRecommendationDto r16 = (ProactiveRecommendationDto) ZeusTransformUtils.preCheckCast(r15.next(), ProactiveRecommendationDto.class, "com.obric.memorydata.plugin");
        Long r4 = r16.getExpireAtMs();
        if (r4 != null) goto L15;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ProactiveLiveCardManager", "[LiveCardAlarm-SCHEDULE] expireAtMs is null, skipping schedule. recommendId=" + r16.getRecommendId(), null, 4, null);
        goto L12
    L15:
        long r5 = ((Number) ZeusTransformUtils.preCheckCast(r4, Number.class, "com.obric.memorydata.plugin")).longValue();
        if (r5 > System.currentTimeMillis()) goto L17;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ProactiveLiveCardManager", "[LiveCardAlarm-SCHEDULE] expireAtMs already passed, skipping schedule. recommendId=" + r16.getRecommendId() + " expireAtMs=" + r5 + " now=" + System.currentTimeMillis(), null, 4, null);
        goto L12
    L17:
        l.f6475a.a(r16.getRecommendId(), r5);
        goto L12
    }

    private static final boolean a(IProactiveService r2) {
        return ((IProactiveService) ZeusTransformUtils.wrapperContextForParams(r2, IProactiveService.class, "com.obric.memorydata.plugin")).ensureAgreePrivacyAndLogin();
    }

    private static final boolean a(IslandSession r1, IslandSession r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        if (r2 != r1) goto L5;
        return true;
    L5:
        return false;
    }

    public static final /* synthetic */ Long b(n r0) {
        return r0.i();
    }

    public static final /* synthetic */ Object b(n r2, String r3, IslandSession r4, Continuation r5) {
        return r2.b(r3, r4, (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin"));
    }

    public static final /* synthetic */ Object b(n r2, String r3, Continuation r4) {
        return r2.b(r3, (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    private final Object b(String r6, final IslandSession r7, Continuation<? super Unit> r8) {
        Continuation r9 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r8, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r9, ProactiveLiveCardManager$releaseContinueSubmissionGate$1.class) == false) goto L7;
        ProactiveLiveCardManager$releaseContinueSubmissionGate$1 r0 = (ProactiveLiveCardManager$releaseContinueSubmissionGate$1) ZeusTransformUtils.preCheckCast(r9, ProactiveLiveCardManager$releaseContinueSubmissionGate$1.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r5 = r0.result;
        Object r10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        if (r2 == 0) goto L14;
        if (r2 != 1) goto L13;
        kotlinx.coroutines.sync.a r11 = (kotlinx.coroutines.sync.a) ZeusTransformUtils.preCheckCast(r0.L$2, kotlinx.coroutines.sync.a.class, "com.obric.memorydata.plugin");
        r7 = (IslandSession) ZeusTransformUtils.preCheckCast(r0.L$1, IslandSession.class, "com.obric.memorydata.plugin");
        String r12 = (String) ZeusTransformUtils.preCheckCast(r0.L$0, String.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r5);
        kotlinx.coroutines.sync.a r13 = r11;
        r6 = r12;
    L28:
        Map<String, List<IslandSession>> r14 = j;     // Catch: Throwable -> L25
        List r1 = (List) ZeusTransformUtils.preCheckCast(r14.get(r6), List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L25
        if (r1 == null) goto L23;
        CollectionsKt.removeAll(r1, new $$Lambda$n$VoFpmrF_O0MhwvV1_U3V_JGrWsg(r7));     // Catch: Throwable -> L25
        if (r1.isEmpty() == false) goto L22;
        r14.remove(r6);     // Catch: Throwable -> L25
    L22:
        Unit r15 = Unit.INSTANCE;     // Catch: Throwable -> L25
    L23:
        r13.b(null);
        return Unit.INSTANCE;
    L25:
        th = move-exception;
        r13.b(null);
        throw th;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r5);
        r13 = c;
        r0.L$0 = r6;
        r0.L$1 = r7;
        r0.L$2 = r13;
        r0.label = 1;
        if (r13.a(null, r0) != r10) goto L28;
        return r10;
    L7:
        r0 = new ProactiveLiveCardManager$releaseContinueSubmissionGate$1(this, r9);
        goto L8
    }

    private final Object b(String r8, Continuation<? super IslandSession> r9) {
        Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r9, Continuation.class, "com.obric.memorydata.plugin");
        return a(this, r8, o.a(LockScreenDetachReason.DETAIL_OPEN), null, r4, 4, null);
    }

    public static final /* synthetic */ Map b() {
        return f;
    }

    private final void b(Context r8) {
        Object r7 = ((Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.memorydata.plugin")).getSystemService("statusbar");     // Catch: Exception -> L5
        Method r9 = ZeusTransformUtils.forName("android.app.StatusBarManager", "com.obric.memorydata.plugin").getMethod("collapsePanels", new Class[0]);     // Catch: Exception -> L5
        r9.setAccessible(true);     // Catch: Exception -> L5
        r9.invoke(r7, new Object[0]);     // Catch: Exception -> L5
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ProactiveLiveCardManager", "Successfully collapsed status bar", false, 4, null);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ProactiveLiveCardManager", "Failed to collapse status bar: " + e.getMessage(), null, 4, null);
    }

    private final void b(Context r8, String r9) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.memorydata.plugin");
        kotlinx.coroutines.i.a(f6479b, null, null, (Function2) ZeusTransformUtils.preCheckCast(new ProactiveLiveCardManager$refreshActiveSessionTheme$1(r9, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    }

    private final void b(ProactiveRecommendationDto r9, String r10) {
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L5
        Intent r1 = new Intent("com.obric.proactive.action.RECOMMENDATION_ADOPTED");     // Catch: Exception -> L5
        r1.setClassName(r0.getPackageName(), "com.obric.aiproactive.ui.ipc.ProactiveUiSyncReceiver");     // Catch: Exception -> L5
        r1.putExtra("recommendId", r9.getRecommendId());     // Catch: Exception -> L5
        r1.putExtra("feedbackAction", r10);     // Catch: Exception -> L5
        r0.sendBroadcast(r1);     // Catch: Exception -> L5
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ProactiveLiveCardManager", "Broadcast sent for action=" + r10 + " recommendId=" + r9.getRecommendId() + " target=" + r0.getPackageName() + "/com.obric.aiproactive.ui.ipc.ProactiveUiSyncReceiver", false, 4, null);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        RunLog.INSTANCE.error("ProactiveLiveCardManager", "Failed to send broadcast for action=" + r10, (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
    }

    public static final /* synthetic */ void b(String r0) {
        m = r0;
    }

    public static final /* synthetic */ Object c(n r2, String r3, Continuation r4) {
        return r2.c(r3, (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    private final Object c(String r12, Continuation<? super Unit> r13) {
        Continuation r14 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r13, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r14, ProactiveLiveCardManager$removeActiveSession$1.class) == false) goto L7;
        ProactiveLiveCardManager$removeActiveSession$1 r0 = (ProactiveLiveCardManager$removeActiveSession$1) ZeusTransformUtils.preCheckCast(r14, ProactiveLiveCardManager$removeActiveSession$1.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r11 = r0.result;
        Object r15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        if (r2 == 0) goto L14;
        if (r2 != 1) goto L13;
        kotlinx.coroutines.sync.a r16 = (kotlinx.coroutines.sync.a) ZeusTransformUtils.preCheckCast(r0.L$1, kotlinx.coroutines.sync.a.class, "com.obric.memorydata.plugin");
        String r17 = (String) ZeusTransformUtils.preCheckCast(r0.L$0, String.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r11);
        kotlinx.coroutines.sync.a r18 = r16;
        r12 = r17;
    L30:
    L27:
        th = move-exception;
        r18.b(null);
        throw th;
    L18:
        if (h.b(r12) == false) goto L20;
        l.f6475a.a(r12);     // Catch: Throwable -> L27
    L21:
        f.remove(r12);     // Catch: Throwable -> L27
        if (Intrinsics.areEqual(m, r12) == false) goto L24;
        l = null;     // Catch: Throwable -> L27
        m = null;     // Catch: Throwable -> L27
    L24:
        Unit r19 = Unit.INSTANCE;     // Catch: Throwable -> L27
        r18.b(null);
        return Unit.INSTANCE;
    L20:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ProactiveLiveCardManager", "Skip cancel dismiss timer on session destroy for recommendId=" + r12 + " because detail flow retained it", false, 4, null);     // Catch: Throwable -> L27
        goto L21
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r11);
        r18 = c;
        r0.L$0 = r12;
        r0.L$1 = r18;
        r0.label = 1;
        if (r18.a(null, r0) != r15) goto L30;
        return r15;
    L7:
        r0 = new ProactiveLiveCardManager$removeActiveSession$1(this, r14);
        goto L8
    }

    public static final /* synthetic */ Set c() {
        return g;
    }

    private final void c(String r13) {
        String r0 = o.a(k, m, r13);
        Long r1 = o.a(l, m, r13);
        if (r0 != null) goto L6;
        if (r1 != null) goto L6;
        return;
    L6:
        String r2 = AppContext.INSTANCE.getUserId();
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L10;
        r2 = null;
    L10:
        if (r0 == null) goto L12;
        f().save(o.a(r2), r0);
    L12:
        if (r1 == null) goto L14;
        f().save(o.b(r2), r1.longValue());
    L14:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ProactiveLiveCardManager", "consumeActiveCandidateSetLocked recommendId=" + r13 + " candidateSetKey=" + r0 + " topRowId=" + r1, false, 4, null);
        k = null;
        l = null;
        m = null;
    }

    public static final /* synthetic */ Set d() {
        return i;
    }

    private final void d(String r9, String r10) {
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L5
        Intent r1 = new Intent("com.obric.proactive.action.RECOMMENDATION_DISMISSED");     // Catch: Exception -> L5
        r1.setClassName(r0.getPackageName(), "com.obric.aiproactive.ui.ipc.ProactiveUiSyncReceiver");     // Catch: Exception -> L5
        r1.putExtra("recommendId", r9);     // Catch: Exception -> L5
        r1.putExtra(InfoRequestQPSOptTraceLogger.REASON, r10);     // Catch: Exception -> L5
        r0.sendBroadcast(r1);     // Catch: Exception -> L5
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ProactiveLiveCardManager", "[LiveCardDismiss-SYNC] Broadcast sent recommendId=" + r9 + " reason=" + r10 + " target=" + r0.getPackageName() + "/com.obric.aiproactive.ui.ipc.ProactiveUiSyncReceiver", false, 4, null);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        RunLog.INSTANCE.error("ProactiveLiveCardManager", "Failed to send dismiss sync broadcast reason=" + r10 + " recommendId=" + r9, (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
    }

    public static final /* synthetic */ al e() {
        return f6479b;
    }

    private final IStore f() {
        return (IStore) ZeusTransformUtils.preCheckCast(d.getValue(), IStore.class, "com.obric.memorydata.plugin");
    }

    private final com.obric.aiproactive.impl.aidb.d g() {
        return (com.obric.aiproactive.impl.aidb.d) ZeusTransformUtils.preCheckCast(e.getValue(), com.obric.aiproactive.impl.aidb.d.class, "com.obric.memorydata.plugin");
    }

    private final String h() {
        String r0 = AppContext.INSTANCE.getUserId();
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L6;
        r0 = null;
    L6:
        String r4 = f().getString(o.a(r0), null);
        if (r4 != null) goto L9;
        return null;
    L9:
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L11;
        return null;
    L11:
        return r4;
    }

    private final Long i() {
        String r0 = AppContext.INSTANCE.getUserId();
        boolean r3 = true;
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L6;
        r0 = null;
    L6:
        Long r7 = Long.valueOf(f().getLong(o.b(r0), Long.MIN_VALUE));
        if (((Number) ZeusTransformUtils.preCheckCast(r7, Number.class, "com.obric.memorydata.plugin")).longValue() != Long.MIN_VALUE) goto L10;
        r3 = false;
    L10:
        if (r3 == true) goto L12;
        return null;
    L12:
        return r7;
    }

    private static final IStore j() {
        return IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null);
    }

    private static final com.obric.aiproactive.impl.aidb.d k() {
        return new com.obric.aiproactive.impl.aidb.d(null, null, null, null, null, 31, null);
    }

    /* JADX INFO: renamed from: lambda$-ERiqGcKmastTah_xElGiHXBk48, reason: not valid java name */
    public static /* synthetic */ boolean m235lambda$ERiqGcKmastTah_xElGiHXBk48(IProactiveService r0) {
        return a(r0);
    }

    /* JADX INFO: renamed from: lambda$5laEdPwRkMfZTRMC-eEhsc8bXtw, reason: not valid java name */
    public static /* synthetic */ com.obric.aiproactive.impl.aidb.d m236lambda$5laEdPwRkMfZTRMCeEhsc8bXtw() {
        return k();
    }

    public static /* synthetic */ z lambda$RQSd5na0orkX127Fm6CdPSgaHkQ(IProactiveService r0, x r1) {
        return a(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$S2FX36VD-vZwZCBx3qTB2kmldac, reason: not valid java name */
    public static /* synthetic */ IStore m237lambda$S2FX36VDvZwZCBx3qTB2kmldac() {
        return j();
    }

    public static /* synthetic */ boolean lambda$VoFpmrF_O0MhwvV1_U3V_JGrWsg(IslandSession r0, IslandSession r1) {
        return a(r0, r1);
    }

    public static /* synthetic */ Unit lambda$mDEGfhGhRnq5Xq2xq8wKlHL1B9M(h r0, ProactiveRecommendationDto r1, i r2, Context r3, boolean r4) {
        return a(r0, r1, r2, r3, r4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r16v1 */
    /* JADX WARN: Type inference failed for: r18v0, types: [com.obric.aiproactive.impl.livecard.n, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r18v1, types: [com.obric.aiproactive.impl.livecard.n] */
    /* JADX WARN: Type inference failed for: r1v0, types: [com.obric.livecard.api.entity.IslandSession, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v18, types: [java.lang.Object, java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v25, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v29, types: [java.lang.Object, java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v33, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v37 */
    /* JADX WARN: Type inference failed for: r1v38 */
    /* JADX WARN: Type inference failed for: r1v39 */
    /* JADX WARN: Type inference failed for: r1v4, types: [com.obric.livecard.api.entity.IslandSession, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v40 */
    /* JADX WARN: Type inference failed for: r1v41 */
    /* JADX WARN: Type inference failed for: r1v42 */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.Class, java.lang.Class<com.obric.aiproactive.impl.livecard.n>] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v11, types: [com.obric.aiproactive.impl.livecard.n] */
    /* JADX WARN: Type inference failed for: r2v12, types: [com.obric.aiproactive.impl.livecard.n, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v15, types: [com.obric.aiproactive.impl.livecard.n] */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v2, types: [com.obric.aiproactive.impl.livecard.n] */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r2v21 */
    /* JADX WARN: Type inference failed for: r2v22 */
    /* JADX WARN: Type inference failed for: r2v23 */
    /* JADX WARN: Type inference failed for: r2v24 */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6, types: [com.obric.aiproactive.impl.livecard.n, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v9, types: [com.obric.aiproactive.impl.livecard.n, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v16, types: [com.obric.livecard.api.entity.IslandSession, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v2, types: [com.obric.aiproactive.api.IProactiveService, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v21 */
    /* JADX WARN: Type inference failed for: r3v22 */
    /* JADX WARN: Type inference failed for: r3v23, types: [com.obric.livecard.api.entity.IslandSession, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v27, types: [com.obric.livecard.api.entity.IslandSession] */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v31 */
    /* JADX WARN: Type inference failed for: r3v32 */
    /* JADX WARN: Type inference failed for: r3v33 */
    /* JADX WARN: Type inference failed for: r3v34 */
    /* JADX WARN: Type inference failed for: r3v35 */
    /* JADX WARN: Type inference failed for: r3v36 */
    /* JADX WARN: Type inference failed for: r3v4, types: [com.obric.livecard.api.entity.IslandSession] */
    /* JADX WARN: Type inference failed for: r3v5, types: [com.obric.aiproactive.api.IProactiveService, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v9 */
    /* JADX WARN: Type inference failed for: r5v15 */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r5v9, types: [com.obric.aiproactive.api.IProactiveService] */
    /* JADX WARN: Type inference failed for: r8v24, types: [java.lang.StringBuilder] */
    public final Object a(ProactiveRecommendationDto r19, h r20, IslandSession r21, IProactiveService r22, Continuation<? super Unit> r23) {
        ?? r1 = r21;
        ?? r2 = n.class;
        ?? r3 = (IProactiveService) ZeusTransformUtils.wrapperContextForParams(r22, IProactiveService.class, "com.obric.memorydata.plugin");
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r23, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r5, ProactiveLiveCardManager$submitContinueFromLockScreen$1.class) == false) goto L7;
        ProactiveLiveCardManager$submitContinueFromLockScreen$1 r6 = (ProactiveLiveCardManager$submitContinueFromLockScreen$1) ZeusTransformUtils.preCheckCast(r5, ProactiveLiveCardManager$submitContinueFromLockScreen$1.class, "com.obric.memorydata.plugin");
        if ((r6.label & Integer.MIN_VALUE) == 0) goto L7;
        r6.label -= Integer.MIN_VALUE;
    L8:
        Object r7 = r6.result;
        Object r8 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch(r6.label) {
            case 0: goto L34;
            case 1: goto L33;
            case 2: goto L32;
            case 3: goto L31;
            case 4: goto L30;
            case 5: goto L25;
            case 6: goto L24;
            case 7: goto L23;
            case 8: goto L22;
            case 9: goto L17;
            case 10: goto L14;
            case 11: goto L13;
            case 12: goto L12;
            default: goto L11;
        };
    L12:
        Throwable r0 = (Throwable) ZeusTransformUtils.preCheckCast(r6.L$0, Throwable.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r7);
        throw r0;
    L13:
        ResultKt.throwOnFailure(r7);
    L98:
        return Unit.INSTANCE;
    L14:
        String r4 = (String) ZeusTransformUtils.preCheckCast(r6.L$2, String.class, "com.obric.memorydata.plugin");
        IslandSession r9 = (IslandSession) ZeusTransformUtils.preCheckCast(r6.L$1, IslandSession.class, "com.obric.memorydata.plugin");
        n r10 = (n) ZeusTransformUtils.preCheckCast(r6.L$0, r2, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r7);     // Catch: Throwable -> L20
        ?? r11 = r4;
        ?? r12 = r10;
        ?? r13 = r9;
    L91:
        IslandSession r14 = (IslandSession) ZeusTransformUtils.preCheckCast(r7, IslandSession.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L20
        if (r14 == null) goto L94;
        ProactiveLiveCardDisplayTool.INSTANCE.destroySession(r14);     // Catch: Throwable -> L20
    L94:
        r6.L$0 = null;
        r6.L$1 = null;
        r6.L$2 = null;
        r6.label = 11;
        if (r12.b(r11, r13, r6) != r8) goto L98;
        return r8;
    L17:
        String r15 = (String) ZeusTransformUtils.preCheckCast(r6.L$2, String.class, "com.obric.memorydata.plugin");
        IslandSession r16 = (IslandSession) ZeusTransformUtils.preCheckCast(r6.L$1, IslandSession.class, "com.obric.memorydata.plugin");
        n r17 = (n) ZeusTransformUtils.preCheckCast(r6.L$0, r2, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r7);     // Catch: Throwable -> L20
        ?? r18 = r15;
        ?? r24 = r17;
        ?? r25 = r16;
    L88:
        j r26 = o.a(LockScreenDetachReason.PROCESSED);     // Catch: Throwable -> L20
        r6.L$0 = r24;     // Catch: Throwable -> L20
        r6.L$1 = r25;     // Catch: Throwable -> L20
        r6.L$2 = r18;     // Catch: Throwable -> L20
        r6.label = 10;     // Catch: Throwable -> L20
        r7 = r24.a(r18, r26, r25, r6);     // Catch: Throwable -> L20
        r11 = r18;
        r12 = r24;
        r13 = r25;
        if (r7 != r8) goto L91;
        return r8;
    L22:
        Unit r27 = (Unit) ZeusTransformUtils.preCheckCast(r6.L$0, Unit.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r7);
        return r27;
    L23:
        Unit r28 = (Unit) ZeusTransformUtils.preCheckCast(r6.L$0, Unit.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r7);
        return r28;
    L24:
        Unit r29 = (Unit) ZeusTransformUtils.preCheckCast(r6.L$0, Unit.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r7);
        return r29;
    L25:
        kotlinx.coroutines.sync.a r30 = (kotlinx.coroutines.sync.a) ZeusTransformUtils.preCheckCast(r6.L$7, kotlinx.coroutines.sync.a.class, "com.obric.memorydata.plugin");
        r1 = (String) ZeusTransformUtils.preCheckCast(r6.L$6, String.class, "com.obric.memorydata.plugin");
        x r31 = (x) ZeusTransformUtils.preCheckCast(r6.L$5, x.class, "com.obric.memorydata.plugin");
        IProactiveService r32 = (IProactiveService) ZeusTransformUtils.preCheckCast(r6.L$4, IProactiveService.class, "com.obric.memorydata.plugin");
        IslandSession r110 = (IslandSession) ZeusTransformUtils.preCheckCast(r6.L$3, IslandSession.class, "com.obric.memorydata.plugin");
        h r111 = (h) ZeusTransformUtils.preCheckCast(r6.L$2, h.class, "com.obric.memorydata.plugin");
        ProactiveRecommendationDto r112 = (ProactiveRecommendationDto) ZeusTransformUtils.preCheckCast(r6.L$1, ProactiveRecommendationDto.class, "com.obric.memorydata.plugin");
        r2 = (n) ZeusTransformUtils.preCheckCast(r6.L$0, r2, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r7);     // Catch: Throwable -> L28
        final ?? r33 = r32;
        kotlinx.coroutines.sync.a r34 = r30;
        final x r35 = r31;
        r3 = r110;
        h r113 = r111;
        ProactiveRecommendationDto r114 = r112;
        r1 = r1;
        r2 = r2;
    L122:
        if (f.get(r1) != r3) goto L69;
        boolean r115 = true;
    L70:
        r34.b(null);     // Catch: Throwable -> L20
        if (r115 == true) goto L120;
        Unit r36 = Unit.INSTANCE;     // Catch: Throwable -> L20
        r6.L$0 = r36;
        r6.L$1 = null;
        r6.L$2 = null;
        r6.L$3 = null;
        r6.L$4 = null;
        r6.L$5 = null;
        r6.L$6 = null;
        r6.L$7 = null;
        r6.label = 6;
        if (r2.b(r1, r3, r6) != r8) goto L130;
        return r8;
    L130:
        return r36;
    L120:
    L79:
        if (o.a((z) ZeusTransformUtils.preCheckCast(y.a(null, new $$Lambda$n$RQSd5na0orkX127Fm6CdPSgaHkQ(r33, r35), 1, null), z.class, "com.obric.memorydata.plugin"), r35.b()) == true) goto L85;
        Unit r37 = Unit.INSTANCE;     // Catch: Throwable -> L20
        r6.L$0 = r37;
        r6.L$1 = null;
        r6.L$2 = null;
        r6.L$3 = null;
        r6.L$4 = null;
        r6.L$5 = null;
        r6.L$6 = null;
        r6.L$7 = null;
        r6.label = 8;
        if (r2.b(r1, r3, r6) != r8) goto L131;
        return r8;
    L131:
        return r37;
    L85:
        int r38 = r113.a();     // Catch: Throwable -> L20
        AiProactiveCardStatus r39 = AiProactiveCardStatus.ACKNOWLEDGED;     // Catch: Throwable -> L20
        r6.L$0 = r2;     // Catch: Throwable -> L20
        r6.L$1 = r3;     // Catch: Throwable -> L20
        r6.L$2 = r1;     // Catch: Throwable -> L20
        r6.L$3 = null;     // Catch: Throwable -> L20
        r6.L$4 = null;     // Catch: Throwable -> L20
        r6.L$5 = null;     // Catch: Throwable -> L20
        r6.L$6 = null;     // Catch: Throwable -> L20
        r6.L$7 = null;     // Catch: Throwable -> L20
        r6.label = 9;     // Catch: Throwable -> L20
        Object r40 = r2.a(r114, r38, "get", r39, r6);     // Catch: Throwable -> L20
        r18 = r1;
        r24 = r2;
        r25 = r3;
        if (r40 != r8) goto L88;
        return r8;
    L99:
        e = move-exception;
        RunLog.INSTANCE.warn("ProactiveLiveCardManager", "Continue submit failed recommendId=" + r1 + " actionIndex=" + r113.a(), (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L20
        Unit r41 = Unit.INSTANCE;     // Catch: Throwable -> L20
        r6.L$0 = r41;
        r6.L$1 = null;
        r6.L$2 = null;
        r6.L$3 = null;
        r6.L$4 = null;
        r6.L$5 = null;
        r6.L$6 = null;
        r6.L$7 = null;
        r6.label = 7;
        if (r2.b(r1, r3, r6) != r8) goto L132;
        return r8;
    L132:
        return r41;
    L69:
        r115 = false;
        goto L70
    L105:
        th = move-exception;
        r34.b(null);     // Catch: Throwable -> L20
        throw th;     // Catch: Throwable -> L20
    L28:
        th = th;
        r3 = r110;
    L114:
        r6.L$0 = th;
        r6.L$1 = null;
        r6.L$2 = null;
        r6.L$3 = null;
        r6.L$4 = null;
        r6.L$5 = null;
        r6.L$6 = null;
        r6.L$7 = null;
        r6.label = 12;
        if (r2.b(r1, r3, r6) != r8) goto L134;
        return r8;
    L134:
        throw th;
    L30:
        Unit r42 = (Unit) ZeusTransformUtils.preCheckCast(r6.L$0, Unit.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r7);
        return r42;
    L31:
        Unit r43 = (Unit) ZeusTransformUtils.preCheckCast(r6.L$0, Unit.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r7);
        return r43;
    L32:
        Unit r44 = (Unit) ZeusTransformUtils.preCheckCast(r6.L$0, Unit.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r7);
        return r44;
    L33:
        String r45 = (String) ZeusTransformUtils.preCheckCast(r6.L$6, String.class, "com.obric.memorydata.plugin");
        x r46 = (x) ZeusTransformUtils.preCheckCast(r6.L$5, x.class, "com.obric.memorydata.plugin");
        IProactiveService r47 = (IProactiveService) ZeusTransformUtils.preCheckCast(r6.L$4, IProactiveService.class, "com.obric.memorydata.plugin");
        IslandSession r48 = (IslandSession) ZeusTransformUtils.preCheckCast(r6.L$3, IslandSession.class, "com.obric.memorydata.plugin");
        r113 = (h) ZeusTransformUtils.preCheckCast(r6.L$2, h.class, "com.obric.memorydata.plugin");
        r114 = (ProactiveRecommendationDto) ZeusTransformUtils.preCheckCast(r6.L$1, ProactiveRecommendationDto.class, "com.obric.memorydata.plugin");
        n r49 = (n) ZeusTransformUtils.preCheckCast(r6.L$0, r2, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r7);
        String r50 = r45;
        r35 = r46;
        ?? r51 = r48;
        Object r52 = r7;
        r2 = r49;
        final ?? r53 = r47;
    L43:
        if (((Boolean) ZeusTransformUtils.preCheckCast(r52, Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L45;
        if (r53 != 0) goto L118;
        Unit r54 = Unit.INSTANCE;     // Catch: Throwable -> L52
        r6.L$0 = r54;
        r6.L$1 = null;
        r6.L$2 = null;
        r6.L$3 = null;
        r6.L$4 = null;
        r6.L$5 = null;
        r6.L$6 = null;
        r6.label = 2;
        if (r2.b(r50, r51, r6) != r8) goto L128;
        return r8;
    L128:
        return r54;
    L118:
    L56:
        if (Intrinsics.areEqual((Boolean) ZeusTransformUtils.preCheckCast(y.a(null, new $$Lambda$n$ERiqGcKmastTah_xElGiHXBk48(r53), 1, null), Boolean.class, "com.obric.memorydata.plugin"), Boxing.boxBoolean(true)) == true) goto L62;
        Unit r55 = Unit.INSTANCE;     // Catch: Throwable -> L52
        r6.L$0 = r55;
        r6.L$1 = null;
        r6.L$2 = null;
        r6.L$3 = null;
        r6.L$4 = null;
        r6.L$5 = null;
        r6.L$6 = null;
        r6.label = 4;
        if (r2.b(r50, r51, r6) != r8) goto L129;
        return r8;
    L129:
        return r55;
    L62:
        r34 = c;     // Catch: Throwable -> L52
        r6.L$0 = r2;     // Catch: Throwable -> L52
        r6.L$1 = r114;     // Catch: Throwable -> L52
        r6.L$2 = r113;     // Catch: Throwable -> L52
        r6.L$3 = r51;     // Catch: Throwable -> L52
        r6.L$4 = r53;     // Catch: Throwable -> L52
        r6.L$5 = r35;     // Catch: Throwable -> L52
        r6.L$6 = r50;     // Catch: Throwable -> L52
        r6.L$7 = r34;     // Catch: Throwable -> L52
        r6.label = 5;     // Catch: Throwable -> L52
        if (r34.a(null, r6) != r8) goto L65;
        return r8;
    L65:
        ?? r116 = r53;
        r3 = r51;
        r1 = r50;
        r33 = r116;
        r2 = r2;
    L108:
        e = move-exception;
        RunLog.INSTANCE.warn("ProactiveLiveCardManager", "Continue privacy/login gate failed recommendId=" + r50, (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L52
        Unit r56 = Unit.INSTANCE;     // Catch: Throwable -> L52
        r6.L$0 = r56;
        r6.L$1 = null;
        r6.L$2 = null;
        r6.L$3 = null;
        r6.L$4 = null;
        r6.L$5 = null;
        r6.L$6 = null;
        r6.label = 3;
        if (r2.b(r50, r51, r6) != r8) goto L133;
        return r8;
    L133:
        return r56;
    L52:
        th = th;
        r3 = r51;
        r1 = r50;
        goto L114
    L45:
        return Unit.INSTANCE;
    L34:
        ResultKt.throwOnFailure(r7);
        x r57 = com.obric.aiproactive.api.y.a(r20.f(), com.obric.aiproactive.api.y.a(), System.currentTimeMillis());
        if (r57 == null) goto L37;
        r50 = r19.getRecommendId();
        r6.L$0 = this;
        r6.L$1 = r19;
        r113 = r20;
        r6.L$2 = r113;
        r6.L$3 = r1;
        r6.L$4 = r3;
        r6.L$5 = r57;
        r6.L$6 = r50;
        r6.label = 1;
        Object r117 = a(r50, r1, r6);
        if (r117 != r8) goto L41;
        return r8;
    L41:
        r2 = this;
        r35 = r57;
        r114 = r19;
        r52 = r117;
        r51 = r1;
        r53 = r3;
        goto L43
    L37:
        return Unit.INSTANCE;
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L20:
        th = th;
    L7:
        r6 = new ProactiveLiveCardManager$submitContinueFromLockScreen$1(this, r5);
        goto L8
    }

    public final void a(Context r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r8, "context");
        monitor-enter(this);
    L15:
        th = move-exception;
        throw th;
    L5:
        if (n == false) goto L8;
        monitor-exit(this);
        return;
    L8:
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r8.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L15
        if (r0 == null) goto L12;
        r8 = r0;
    L12:
        o = ProactiveLiveCardDisplayTool.INSTANCE.resolveHostUiNightMode$ai_proactive_impl_obricRelease();     // Catch: Throwable -> L15
        ZeusTransformUtils.registerReceiver(r8, (PluginBroadcastReceiver) ZeusTransformUtils.preCheckCast(p, PluginBroadcastReceiver.class, "com.obric.memorydata.plugin"), new IntentFilter("android.intent.action.CONFIGURATION_CHANGED"), "com.obric.memorydata.plugin");     // Catch: Throwable -> L15
        n = true;     // Catch: Throwable -> L15
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ProactiveLiveCardManager", "Registered lock-screen theme change monitor nightMode=" + o, false, 4, null);     // Catch: Throwable -> L15
        Unit r9 = Unit.INSTANCE;     // Catch: Throwable -> L15
        monitor-exit(this);
    }

    public final void a(Context r5, String r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "context");
        Intrinsics.checkNotNullParameter(r6, InfoRequestQPSOptTraceLogger.REASON);
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r7.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L6;
        r7 = r0;
    L6:
        Integer r1 = ProactiveLiveCardDisplayTool.INSTANCE.resolveHostUiNightMode$ai_proactive_impl_obricRelease();
        monitor-enter(this);
        boolean r2 = o.a(o, r1);     // Catch: Throwable -> L19
        if (r1 == null) goto L11;
        o = r1;     // Catch: Throwable -> L19
    L11:
        if (r2 == true) goto L15;
        RunLog.INSTANCE.debug("ProactiveLiveCardManager", "Skip lock-screen theme refresh because night mode unchanged reason=" + r6 + " mode=" + r1);     // Catch: Throwable -> L19
        monitor-exit(this);
        return;
    L15:
        Unit r3 = Unit.INSTANCE;     // Catch: Throwable -> L19
        monitor-exit(this);
        b(r7, r6);
        return;
    L19:
        th = move-exception;
        throw th;
    }

    public final void a(String r7, String r8) {
        Intrinsics.checkNotNullParameter(r7, "recommendId");
        kotlinx.coroutines.i.a(f6479b, null, null, (Function2) ZeusTransformUtils.preCheckCast(new ProactiveLiveCardManager$markAsProcessed$1(r7, r8, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    }

    public final void a(List<ProactiveRecommendationDto> r11, List<ProactiveRecommendationDto> r12, Map<String, d> r13, String r14, Long r15) {
        List r3 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.memorydata.plugin");
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r12, List.class, "com.obric.memorydata.plugin");
        Map r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r13, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "recommendations");
        Intrinsics.checkNotNullParameter(r4, "dismissRecommendations");
        Intrinsics.checkNotNullParameter(r7, "displayTextByRecommendId");
        kotlinx.coroutines.i.a(f6479b, null, null, (Function2) ZeusTransformUtils.preCheckCast(new ProactiveLiveCardManager$syncToLockScreen$1(r3, r4, r14, r15, r7, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    }

    public final void b(String r7, String r8) {
        Intrinsics.checkNotNullParameter(r7, "recommendId");
        kotlinx.coroutines.i.a(f6479b, null, null, (Function2) ZeusTransformUtils.preCheckCast(new ProactiveLiveCardManager$syncProcessedStateFromApp$1(r7, r8, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    }

    public final void c(String r8, String r9) {
        Intrinsics.checkNotNullParameter(r8, "recommendId");
        Intrinsics.checkNotNullParameter(r9, InfoRequestQPSOptTraceLogger.REASON);
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L5;
        return;
    L5:
        kotlinx.coroutines.i.a(f6479b, null, null, (Function2) ZeusTransformUtils.preCheckCast(new ProactiveLiveCardManager$syncDismissStateToUiAndDb$1(r8, r9, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    }
}
