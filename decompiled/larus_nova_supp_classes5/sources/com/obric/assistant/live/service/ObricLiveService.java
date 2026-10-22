package com.obric.assistant.live.service;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.larus.bmhome.chat.api.IAuthModelService;
import com.larus.common.apphost.AppHost;
import com.larus.home.api.main.HomeService;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.larus.voicecall.obric.ObricRealtimeCallServiceDelegate;
import com.obric.aiagent.assistant.idl.IAgentDMStateManagerIDL;
import com.obric.assistant.audio.service.IObricLiveService;
import com.obric.assistant.audio.service.ObricLiveServiceDelegate;
import com.obric.assistant.chat.p;
import com.obric.assistant.complex_task.ComplexTaskManager;
import com.obric.assistant.complex_task.MultiComplexTaskManager;
import com.obric.assistant.complex_task.t;
import com.obric.assistant.data.ObricFloatChatPageData;
import com.obric.assistant.data.ObricFloatChatPageState;
import com.obric.assistant.interaction.api.IAssistantChatWindow;
import com.obric.assistant.interaction.api.IAssistantChatWindowKt;
import com.obric.assistant.interaction.api.IKeyguardStateKt;
import com.obric.assistant.interaction.api.service.IInteractionStateService;
import com.obric.assistant.live.api.j;
import com.obric.assistant.live.event.Event;
import com.obric.assistant.live.oenum.ObricActivityVisibleState;
import com.obric.assistant.oauto.IOAutoApi;
import com.obric.assistant.settings.LockedUseAuthSettingItem;
import com.obric.assistant.spi.app.IObricLaunchService;
import com.obric.assistant.spi.audio.IObricRealtimeCallExtService;
import com.obric.assistant.spi.audio.ObricTtsControlDelegate;
import com.obric.assistant.state.api.v2.core.IObricStateDispatcherService;
import com.obric.assistant.state.api.v2.core.bean.ObricInteractionScene;
import com.obric.assistant.state.api.v2.core.bean.ObricIslandPriority;
import com.obric.assistant.state.api.v2.core.bean.ObricIslandStateType;
import com.obric.assistant.state.api.v2.core.bean.ObricState;
import com.obric.assistant.t1;
import com.obric.assistant.task.ObricTaskStatusManager;
import com.obric.assistant.util.m2;
import com.obric.assistant.utils.l;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import gd9.i;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.b1;
import kotlinx.coroutines.flow.j1;
import kotlinx.coroutines.w1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\r*\u00021D\b\u0007\u0018\u0000 \u0081\u00012\u00020\u0001:\u0002\u0081\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0019\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u0015H\u0002J\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u001a\u001a\u00020\u0015H\u0002J\u0018\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u001f\u001a\u00020\u0017H\u0002J\u001c\u0010 \u001a\u00020\u001e2\u0006\u0010\u001a\u001a\u00020\u00152\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0015H\u0002J\u0016\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00170\"2\u0006\u0010\u001a\u001a\u00020\u0015H\u0002J\f\u0010/\u001a\u00020\u0010*\u00020\u0017H\u0002J\u0010\u00106\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020\u0017H\u0002J\u0010\u00107\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020\u0017H\u0002J\u0014\u00108\u001a\u00020\u0010*\u0002092\u0006\u0010:\u001a\u000209H\u0002J\b\u0010;\u001a\u00020\u0010H\u0016J\b\u0010<\u001a\u00020\u001eH\u0016J\u0010\u0010=\u001a\u00020\u00102\u0006\u0010>\u001a\u00020\u0017H\u0002J\u0010\u0010?\u001a\u00020\u00102\u0006\u0010>\u001a\u00020\u0017H\u0002J\u0010\u0010@\u001a\u00020\u001e2\u0006\u0010>\u001a\u00020\u0017H\u0002J\u0010\u0010A\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020\u0017H\u0002J\u0010\u0010B\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020\u0017H\u0002J\u0010\u0010H\u001a\u00020\u001e2\u0006\u0010I\u001a\u00020\u0010H\u0016J\u001a\u0010J\u001a\u00020\u001e2\b\u0010K\u001a\u0004\u0018\u00010\u00172\u0006\u0010L\u001a\u00020\u0017H\u0002J\u0010\u0010M\u001a\u00020\u00102\u0006\u0010L\u001a\u00020\u0017H\u0002J\u0010\u0010N\u001a\u0004\u0018\u00010\u0015*\u0004\u0018\u00010\u0017H\u0002J\u001a\u0010O\u001a\u00020\u001e2\u0006\u0010L\u001a\u00020\u00172\b\u0010K\u001a\u0004\u0018\u00010\u0017H\u0002J\u0010\u0010P\u001a\u00020\u001e2\u0006\u0010L\u001a\u00020\u0017H\u0002J\u001a\u0010Q\u001a\u00020\u001e2\u0006\u0010L\u001a\u00020\u00172\b\u0010K\u001a\u0004\u0018\u00010\u0017H\u0002J\f\u0010R\u001a\u00020\u0010*\u00020\u0015H\u0002J\b\u0010V\u001a\u00020\u001eH\u0016J\b\u0010W\u001a\u00020\u001eH\u0002J\u0018\u0010X\u001a\u00020\u001e2\u0006\u0010Y\u001a\u00020Z2\u0006\u0010\u001f\u001a\u00020\u0017H\u0002J\u0010\u0010[\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020\u0017H\u0002J\u0010\u0010\\\u001a\u00020\u00102\u0006\u0010]\u001a\u00020\u0017H\u0002J\u0010\u0010^\u001a\u00020\u00102\u0006\u0010]\u001a\u00020\u0017H\u0002J\u0010\u0010_\u001a\u00020\u001e2\u0006\u0010]\u001a\u00020\u0017H\u0002J\b\u0010`\u001a\u00020\u001eH\u0002J\u0010\u0010a\u001a\u00020\u001e2\u0006\u0010b\u001a\u00020\u000bH\u0002J\u0010\u0010c\u001a\u00020\u00102\u0006\u0010b\u001a\u00020dH\u0002J\u0010\u0010e\u001a\u00020\u001e2\u0006\u0010>\u001a\u00020\u0017H\u0002J\b\u0010f\u001a\u00020\u001eH\u0016J\u0010\u0010g\u001a\u00020\u001e2\u0006\u0010Y\u001a\u00020hH\u0016J\u0018\u0010i\u001a\u00020\u001e2\u0006\u0010Y\u001a\u00020h2\u0006\u0010c\u001a\u00020\u0010H\u0016J \u0010i\u001a\u00020\u001e2\u0006\u0010Y\u001a\u00020h2\u0006\u0010c\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u0015H\u0016J\"\u0010j\u001a\u00020\u001e2\u0006\u0010Y\u001a\u00020h2\u0006\u0010c\u001a\u00020\u00102\b\u0010\u001b\u001a\u0004\u0018\u00010\u0015H\u0002J\b\u0010k\u001a\u00020\u001eH\u0016J\u0014\u0010l\u001a\u00020\u001e*\u00020\u000b2\u0006\u0010m\u001a\u00020\u0015H\u0002J\b\u0010n\u001a\u00020\u001eH\u0016J\u0010\u0010n\u001a\u00020\u001e2\u0006\u0010\u001b\u001a\u00020\u0015H\u0016J\b\u0010o\u001a\u00020\u001eH\u0016J\b\u0010p\u001a\u00020\u0010H\u0016J\b\u0010r\u001a\u00020\u001eH\u0016J\u0010\u0010s\u001a\u00020\u001e2\u0006\u0010t\u001a\u00020uH\u0016J\b\u0010v\u001a\u00020\u0010H\u0002J\u0018\u0010w\u001a\u00020\u001e2\u0006\u0010t\u001a\u00020u2\u0006\u0010Y\u001a\u00020ZH\u0002J\u0010\u0010x\u001a\u00020\u001e2\u0006\u0010y\u001a\u00020\u0015H\u0002J\u0010\u0010z\u001a\u00020\u001e2\u0006\u0010Y\u001a\u00020ZH\u0002J\b\u0010{\u001a\u00020\u0010H\u0002J\u0010\u0010|\u001a\u00020\u00152\u0006\u0010Y\u001a\u00020ZH\u0002J\b\u0010}\u001a\u00020\u001eH\u0002J\f\u0010~\u001a\u00020\u0010*\u00020uH\u0002J\u0012\u0010\u007f\u001a\u0004\u0018\u00010\u00172\u0006\u0010Y\u001a\u00020\u0015H\u0016J\u001a\u0010\u007f\u001a\u0004\u0018\u00010\u00172\u0006\u0010Y\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u0015H\u0016J\r\u0010\u0080\u0001\u001a\u00020\u0015*\u00020\u0017H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R.\u0010\u0013\u001a\"\u0012\u0004\u0012\u00020\u0015\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0015\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u00160\u00140\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00150\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010#\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00170\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00170\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020'X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010(\u001a\u00020\u00108BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b(\u0010)R\u000e\u0010*\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020.X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u00100\u001a\u0002018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b4\u00105\u001a\u0004\b2\u00103R\u001b\u0010C\u001a\u00020D8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bG\u00105\u001a\u0004\bE\u0010FR\u000e\u0010S\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010T\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0004\n\u0002\u0010UR\u000e\u0010q\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0082\u0001"}, d2 = {"Lcom/obric/assistant/live/service/ObricLiveService;", "Lcom/obric/assistant/audio/service/IObricLiveService;", "<init>", "()V", "context", "Landroid/content/Context;", "channelSendScope", "Lkotlinx/coroutines/CoroutineScope;", "channelReceiveScope", "eventChannel", "Lkotlinx/coroutines/channels/Channel;", "Lcom/obric/assistant/live/event/Event;", "activityVisibility", "Lcom/obric/assistant/live/oenum/ObricActivityVisibleState;", "_isRealtimeCallMuteFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "isRealtimeCallMuteFlow", "Lkotlinx/coroutines/flow/StateFlow;", "sessionStateMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Ljava/util/concurrent/atomic/AtomicReference;", "Lcom/obric/assistant/state/api/v2/core/bean/ObricState;", "latestSessionConversationIdMap", "getSessionStateByConversation", "tag", "conversationId", "getLatestSessionState", "setSessionState", "", "state", "removeSessionState", "getSessionStates", "", "previousSessionState", "deepThinkStartStateMap", "defaultStartStateMap", "isTtsPlaying", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isGenerating", "()Z", "stopTTSByUser", "activityInvisibleWhenGenerated", "generatingClosedByUser", "lifecycleOwnerCount", "Ljava/util/concurrent/atomic/AtomicLong;", "isCalendarTTSMessage", "obricStateListener", "com/obric/assistant/live/service/ObricLiveService$obricStateListener$2$1", "getObricStateListener", "()Lcom/obric/assistant/live/service/ObricLiveService$obricStateListener$2$1;", "obricStateListener$delegate", "Lkotlin/Lazy;", "resolveSimpleTaskDeepThinkState", "checkIslandPriority", "priorityBehind", "Lcom/obric/assistant/state/api/v2/core/bean/ObricIslandPriority;", IInteractionStateService.WAKE_UP_SOURCE_OTHER, "isRealtimeCallMute", "resetRealtimeCallMuteState", "makeSureRealtimeCallState", "obricState", "showDeepThinkEnd", "setupRealtimeCallMuteState", "isDeepThinkEndAfterTtsPlaying", "isDeepThinkTtsPlaying", "appBackGroundListener", "com/obric/assistant/live/service/ObricLiveService$appBackGroundListener$2$1", "getAppBackGroundListener", "()Lcom/obric/assistant/live/service/ObricLiveService$appBackGroundListener$2$1;", "appBackGroundListener$delegate", "updateDialogueActionBtn", "disable", "beginToShowLiveCard", "oldObricState", "newObricState", "shouldDestroyComplexTaskWhenInterrupted", "getComplexTaskId", "updateDirectlyAnswerLiveShow", "updateAigcGenerationLiveShow", "updateSimpleTaskLiveShow", "isMainBotId", "lastMainBotId", "lastIsInMinorMode", "Ljava/lang/Boolean;", "init", "setupEventReceiveChannel", "updateLiveShow", "scene", "Lcom/obric/assistant/state/api/v2/core/bean/ObricInteractionScene;", "shouldSkipDefaultTtsLiveCard", "preProcessComplexTaskLiveShow", "it", "preProcessDefaultOrDeepThinkLiveShow", "updateRealtimeCallShow", "resetActivityVisibility", "processLiveShow", "event", "isFromContinuousIntents", "Lcom/obric/assistant/live/event/Event$Destroy;", "updateLiveCard", "destroyAllLiveCard", "showLiveCardByScene", "", "destroyLiveCardByScene", "destroyLiveCardBySceneInternal", "updateDialogue", "sendEvent", DBDefinition.SEGMENT_INFO, "updateComplexTaskLiveCard", "markAsClosed", "isCollapseNotificationPanelAvailable", "setOnShowWhenLocked", "cancelShowOnLocked", "openChatOrRealtimeCallActivity", "intent", "Landroid/content/Intent;", "shouldSkipOpenChatWindowForAlreadyVisibleHalf", "startOrResumeActivity", "tryScrollPendingComplexTaskReplyForVisibleChatPage", "trigger", "resumeCurrentTask", "isLandscapeMode", "getTargetActivityNameByScene", "changeWindowToHalf", "isToChatActivity", "getSessionState", "sessionStateTag", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricLiveService implements IObricLiveService {
    public static final /* synthetic */ int u = 0;
    public Context a;
    public final CoroutineScope b;
    public final CoroutineScope c;
    public final Channel<Event> d;
    public ObricActivityVisibleState e;
    public final StateFlowImpl f;
    public final StateFlowImpl g;
    public final ConcurrentHashMap<String, ConcurrentHashMap<String, AtomicReference<ObricState>>> h;
    public final ConcurrentHashMap<String, String> i;
    public final AtomicReference<ObricState> j;
    public final ConcurrentHashMap<String, ObricState> k;
    public final ConcurrentHashMap<String, ObricState> l;
    public final AtomicBoolean m;
    public boolean n;
    public boolean o;
    public final Lazy p;
    public final Lazy q;
    public String r;
    public Boolean s;
    public boolean t;

    public static final class c implements f09.a.b {
        public final /* synthetic */ ObricLiveService a;

        public final void onAllActivityDestroyed() {
        }

        public final void onAppBackground() {
            FLogger.a.i("ObricLiveService", "onAppBackground");
            ObricLiveService r0 = this.a;
            r0.e = ObricActivityVisibleState.INVISIBLE;
            ObricState r1 = r0.r("simple_task");
            ObricIslandStateType r2 = null;
            if (r1 == null) goto L5;
            ObricIslandStateType r3 = r1.getCurrentIslandState();
        L6:
            ObricIslandStateType r4 = ObricIslandStateType.TTS_END;
            if (r3 == r4) goto L14;
            ObricState r5 = this.a.r("complex_task");
            if (r5 == null) goto L11;
            r2 = r5.getCurrentIslandState();
        L11:
            if (r2 == r4) goto L14;
            boolean r6 = false;
        L15:
            r0.n = r6;
            j r7 = j.a;
            if (r7.e() == true) goto L18;
            com.obric.assistant.live.api.a.a.a(r7, false, 3);
        L18:
            this.a.m();
            return;
        L14:
            r6 = true;
            goto L15
        L5:
            r3 = null;
            goto L6
        }

        public final void onAppForeground() {
            ObricLiveService r0 = this.a;
            r0.e = ObricActivityVisibleState.VISIBLE;
            List<ObricState> r1 = r0.t("simple_task");
            ObricLiveService r2 = this.a;
            Iterator<T> r3 = r1.iterator();
        L4:
            if (r3.hasNext() == false) goto L8;
            ObricState r4 = (ObricState) r3.next();
            if (r4.getCurrentIslandState() != ObricIslandStateType.DEEP_THINK_END) goto L4;
            r2.x(new Event.a(ObricInteractionScene.DEEP_THINK_SCENE, r4), "destroy deep think live card when app foreground");
            goto L4
        L8:
            List<ObricState> r5 = this.a.t("complex_task");
            ObricLiveService r6 = this.a;
            Iterator<T> r7 = r5.iterator();
        L10:
            if (r7.hasNext() == false) goto L14;
            ObricState r8 = (ObricState) r7.next();
            if (r8.getCurrentIslandState() != ObricIslandStateType.COMPLEX_TASK_COMPLETED) goto L10;
            r6.x(new Event.a(ObricInteractionScene.COMPLEX_TASK_SCENE, r8), "destroy complex task live card when app foreground");
            goto L10
        L14:
            j r9 = j.a;
            if (r9.e() == true) goto L28;
            r9.l(false);
            return;
        }

        public c(ObricLiveService r1) {
            this.a = r1;
        }
    }

    public static final class d implements com.larus.platform.api.b {
        public final /* synthetic */ ObricLiveService a;

        public final void a(com.larus.platform.api.c r2) {
            Intrinsics.checkNotNullParameter(r2, "event");
        }

        public d(ObricLiveService r1) {
            this.a = r1;
        }

        public final void b(com.larus.platform.api.c r3) {
            Intrinsics.checkNotNullParameter(r3, "event");
            FLogger.a.i("ObricLiveService", "onLogout");
            this.a.o();
        }
    }

    public static final class e implements cha.c {
        public final /* synthetic */ ObricLiveService a;

        public e(ObricLiveService r1) {
            this.a = r1;
        }

        public final void c(ObricState r14) {
            Intrinsics.checkNotNullParameter(r14, "state");
            Intrinsics.checkNotNullParameter(r14, "state");
            FLogger r0 = FLogger.a;
            r0.i("ObricLiveService", "onObricStateChanged: " + ObricState.copy$default(r14, null, null, null, null, null, null, MapsKt.minus(r14.getExt(), "origin_query"), 63, null) + " with botId " + r14.getConversationId());
            ObricLiveService r1 = this.a;
            int r3 = ObricLiveService.u;
            r1.getClass();
            r0.i("ObricLiveService", "tts message id: " + r14.getSourceMessageId() + ", scene: " + r14.getScene());
            ObricInteractionScene r2 = r14.getScene();
            ObricInteractionScene r4 = ObricInteractionScene.DEFAULT;
            boolean r5 = false;
            if (r2 == r4) goto L5;
        L7:
            boolean r6 = false;
        L8:
            if (r6 == false) goto L10;
            return;
        L10:
            this.a.getClass();
            if (r14.getScene() != ObricInteractionScene.REALTIME_CALL_SCENE) goto L15;
            if (r14.getCurrentIslandState() != ObricIslandStateType.REALTIME_CALL_INVALID) goto L15;
        L17:
            boolean r7 = false;
        L18:
            if (r7 == true) goto L21;
            r0.i("ObricLiveService", "makeSureRealtimeCallState, scene: " + r14.getScene() + " currentIslandState: " + r14.getCurrentIslandState());
            return;
        L21:
            ObricState r8 = this.a.j.get();
            if (r8 != null) goto L24;
        L29:
            boolean r9 = false;
        L30:
            if (r9 == false) goto L37;
            StringBuilder r10 = new StringBuilder("checkIslandPriority, previousSessionState: ");
            ObricState r11 = this.a.j.get();
            if (r11 == null) goto L34;
            ObricIslandPriority r12 = r11.getPriority();
        L35:
            r10.append(r12);
            r10.append(", currSessionState: ");
            r10.append(r14.getPriority());
            r10.append(' ');
            r0.i("ObricLiveService", r10.toString());
            return;
        L34:
            r12 = null;
            goto L35
        L37:
            ObricInteractionScene r13 = r14.getScene();
            if (r13 != null) goto L40;
            int r15 = -1;
        L41:
            if (r15 != 1) goto L49;
            ObricState r16 = this.a.s("complex_task", r14.getConversationId());
            if (r16 == null) goto L48;
            ObricLiveService r17 = this.a;
            if (dha.a.a(r16, r14) == true) goto L47;
            ObricLiveService.n(r17, r16, r14);
            return;
        L47:
            r0.i("ObricLiveService", "areContentTheSame");
            return;
        L48:
            ObricLiveService.n(this.a, r14, r14);
            return;
        L49:
            ObricLiveService r18 = this.a;
            r18.getClass();
            if (Intrinsics.areEqual(ObricLiveService.y(r14), "simple_task") == false) goto L81;
            ObricInteractionScene r19 = r14.getScene();
            ObricInteractionScene r20 = ObricInteractionScene.DEEP_THINK_SCENE;
            if (r19 != r20) goto L55;
        L57:
            int r21 = b.a[r14.getCurrentIslandState().ordinal()];
            if (r21 != 1) goto L60;
            r18.k.put(r14.getConversationId(), r14);
            goto L81
        L60:
            if (r21 != 2) goto L62;
            r18.k.remove(r14.getConversationId());
            goto L81
        L62:
            if (r21 != 3) goto L64;
            r18.l.put(r14.getConversationId(), r14);
            goto L81
        L64:
            if (r21 != 4) goto L66;
            r18.l.remove(r14.getConversationId());
            goto L81
        L66:
            if (r21 != 5) goto L81;
            if (r14.getScene() != r20) goto L73;
            ObricState r22 = r18.k.get(r14.getConversationId());
            if (r22 == null) goto L81;
            r0.i("ObricLiveService", "restore deep think state after tts end, conversationId: " + r14.getConversationId());
        L76:
            r14 = r22;
            goto L81
        L73:
            r22 = r18.l.get(r14.getConversationId());
            if (r22 == null) goto L81;
            r0.i("ObricLiveService", "restore deep think state after tts end, conversationId: " + r14.getConversationId());
            goto L76
        L55:
            if (r14.getScene() == r4) goto L57;
        L81:
            ObricLiveService r23 = this.a;
            r23.getClass();
            ObricState r24 = r23.s(ObricLiveService.y(r14), r14.getConversationId());
            r0.i("ObricLiveService", "stateMap " + r24);
            if (r14.getScene() == r4) goto L84;
        L97:
            if (r24 == null) goto L135;
            ObricLiveService r25 = this.a;
            if (dha.a.a(r24, r14) == false) goto L105;
            if (r14.getCurrentIslandState() == ObricIslandStateType.MSG_START) goto L103;
            return;
        L103:
            if (Intrinsics.areEqual(r24.getSourceMessageId(), r14.getSourceMessageId()) == false) goto L105;
            return;
        L105:
            if (r14.getScene() == ObricInteractionScene.AIGC_GENERATION_SCENE) goto L128;
            r25.getClass();
            r0.i("ObricLiveService", "showDeepThinkEnd: " + r14 + ", isTtsPlaying " + r25.m.get());
            if (r14.getCurrentIslandState() != ObricIslandStateType.DEEP_THINK_START) goto L110;
            r25.m.set(false);
        L125:
            r5 = true;
        L126:
            if (r5 == true) goto L128;
            return;
        L110:
            if (r14.getScene() == ObricInteractionScene.DEEP_THINK_SCENE) goto L112;
        L114:
            boolean r26 = false;
        L115:
            if (r26 == false) goto L118;
            r25.m.set(true);
            goto L125
        L118:
            if (r14.getCurrentIslandState() == ObricIslandStateType.DEEP_THINK_END) goto L120;
        L122:
            boolean r27 = false;
        L123:
            if (r27 == false) goto L125;
            r25.m.set(false);
            goto L126
        L120:
            if (r25.m.get() == false) goto L122;
            r27 = true;
            goto L123
        L112:
            if (r14.getCurrentIslandState() != ObricIslandStateType.TTS_PLAYING) goto L114;
            r26 = true;
        L128:
            r25.getClass();
            if (r14.getCurrentIslandState() != ObricIslandStateType.REALTIME_CALL_MUTE) goto L132;
            r25.f.setValue(Boolean.TRUE);
        L134:
            ObricLiveService.n(r25, r24, r14);
            return;
        L132:
            if (r14.getCurrentIslandState() != ObricIslandStateType.REALTIME_CALL_UN_MUTE) goto L134;
            r25.f.setValue(Boolean.FALSE);
            goto L134
        L135:
            ObricLiveService.n(this.a, r14, r14);
            return;
        L84:
            if (r14.getCurrentIslandState() != ObricIslandStateType.MSG_END) goto L97;
            if (r24 != null) goto L87;
            return;
        L87:
            if (r24.getScene() == r4) goto L89;
            return;
        L89:
            if (Intrinsics.areEqual(r24.getConversationId(), r14.getConversationId()) == true) goto L91;
            return;
        L91:
            if (r24.getCurrentIslandState() != ObricIslandStateType.TTS_PLAYING) goto L93;
            return;
        L93:
            if (r24.getCurrentIslandState() == ObricIslandStateType.TTS_END) goto L141;
            ObricLiveService r28 = this.a;
            r28.getClass();
            r28.z(ObricLiveService.y(r14), r14);
            this.a.x(new Event.a(r4, r14), "destroy default live card when message ends without TTS");
            return;
        L141:
            return;
        L40:
            r15 = a.a[r13.ordinal()];
            goto L41
        L24:
            if (r8.getPriority().compareTo(r14.getPriority()) <= 0) goto L26;
            boolean r29 = true;
        L27:
            if (r29 == false) goto L29;
            r9 = true;
            goto L30
        L26:
            r29 = false;
        L15:
            if (r14.getCurrentIslandState() == ObricIslandStateType.REALTIME_CALL_UNINITIALIZED) goto L17;
            r7 = true;
            goto L18
        L5:
            if (Intrinsics.areEqual(r14.getSourceMessageId(), "obric_alarm_tts") == false) goto L7;
            r6 = true;
            goto L8
        }
    }

    public static final class f implements Observer, FunctionAdapter {
        public final /* synthetic */ Function1 a;

        public f(com.obric.assistant.live.service.c r2) {
            Intrinsics.checkNotNullParameter(r2, "function");
            this.a = r2;
        }

        public final boolean equals(Object r3) {
            if ((r3 instanceof Observer) == true) goto L5;
            return false;
        L5:
            if ((r3 instanceof FunctionAdapter) == true) goto L7;
            return false;
        L7:
            return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) r3).getFunctionDelegate());
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> getFunctionDelegate() {
            return this.a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        public final /* synthetic */ void onChanged(Object r2) {
            this.a.invoke(r2);
        }
    }

    static {
    }

    public final boolean a() {
        return j.a.a();
    }

    public final void b() {
        j.a.b();
    }

    public final void c() {
        j r0 = j.a;
        if (r0.e() == false) goto L6;
        r0.m(false);
        return;
    }

    public final void e() {
        this.f.setValue(Boolean.FALSE);
    }

    public final boolean f() {
        return ((Boolean) this.g.getValue()).booleanValue();
    }

    public final void i() {
        FLogger.a.i("ObricLiveService", "updateComplexTaskLiveCard");
        ObricState r0 = r("complex_task");
        if (r0 != null) goto L5;
        return;
    L5:
        x(new Event.b(ObricInteractionScene.COMPLEX_TASK_SCENE, r0), "update complex live card after receive clarify");
    }

    /* JADX WARN: Type inference failed for: r1v14, types: [com.obric.assistant.live.service.c] */
    public final void init() {
        FLogger.a.i("ObricLiveService", "init");
        AppHost.Companion r0 = AppHost.a;
        this.a = r0.getApplication().getApplicationContext();
        IObricStateDispatcherService r1 = (IObricStateDispatcherService) ServiceManager.get().getService(IObricStateDispatcherService.class);
        if (r1 == null) goto L5;
        r1.e((e) this.p.getValue());
    L5:
        BuildersKt.launch$default(this.c, null, null, new ObricLiveService$setupEventReceiveChannel$1(this, null), 3, null);
        r0.a().j((c) this.q.getValue());
        AccountService.a.E(new d(this));
        if (z2.a.getAppsFrameworkConfig().c == false) goto L8;
        Map r2 = MultiComplexTaskManager.a;
        MultiComplexTaskManager.c();
    L9:
        j.a.init();
        IAuthModelService r3 = (IAuthModelService) ServiceManager.get().getService(IAuthModelService.class);
        if (r3 == null) goto L15;
        LiveData r4 = r3.y();
        if (r4 == null) goto L16;
        r4.observeForever(new f(new com.obric.assistant.live.service.c(this)));
        return;
    L16:
        return;
    L15:
        return;
    L8:
        t r5 = ComplexTaskManager.a;
        com.obric.aiagent.assistant.idl.f.b(Reflection.getOrCreateKotlinClass(IAgentDMStateManagerIDL.class), new com.obric.assistant.complex_task.j());
        goto L9
    }

    public final void j() {
        ObricState r0 = r("complex_task");
        if (r0 == null) goto L5;
        ObricIslandStateType r1 = r0.getCurrentIslandState();
    L7:
        if (r1 != ObricIslandStateType.DEEP_THINK_START) goto L9;
        boolean r2 = true;
    L10:
        this.o = r2;
        return;
    L9:
        r2 = false;
        goto L10
    L5:
        r1 = null;
        goto L7
    }

    public final void m() {
        FLogger.a.i("ObricLiveService", "cancelShowOnLocked, setOnShowWhenLocked = " + this.t);
        if (this.t == false) goto L12;
        this.t = false;
        Iterator r1 = AppHost.a.a().g().iterator();
    L6:
        if (r1.hasNext() == false) goto L20;
        Activity r3 = (Activity) r1.next();
        if (p.d(r3) == false) goto L6;
        if (Build.VERSION.SDK_INT < 27) goto L6;
        FLogger.a.i("ObricLiveService", "cancelShowOnLocked, setOnShowWhenLocked false, activity = " + r3);
        r3.setShowWhenLocked(false);
        goto L6
    L20:
        return;
    }

    public final void o() {
        FLogger.a.i("ObricLiveService", "destroyAllLiveCard");
        j r0 = j.a;
        Context r1 = this.a;
        if (r1 != null) goto L5;
        r1 = AppHost.a.getApplication().getApplicationContext();
    L5:
        Intrinsics.checkNotNull(r1);
        r0.q(r1);
        this.k.clear();
        this.l.clear();
        Iterator<T> r2 = this.h.values().iterator();
    L7:
        if (r2.hasNext() == false) goto L13;
        ConcurrentHashMap r3 = (ConcurrentHashMap) r2.next();
        Iterator r4 = r3.values().iterator();
    L10:
        if (r4.hasNext() == false) goto L12;
        ((AtomicReference) r4.next()).set(null);
        goto L10
    L12:
        r3.clear();
        goto L7
    L13:
        this.i.clear();
    }

    public ObricLiveService() {
        this.b = CoroutineScopeKt.CoroutineScope(w1.a(1, "obricLiveSendScope").plus(SupervisorKt.SupervisorJob$default(null, 1, null)));
        this.c = CoroutineScopeKt.CoroutineScope(w1.a(1, "obricLiveReceiveScope").plus(SupervisorKt.SupervisorJob$default(null, 1, null)));
        this.d = ChannelKt.Channel$default(0, null, null, 7, null);
        this.e = ObricActivityVisibleState.NA;
        StateFlowImpl r1 = j1.a(Boolean.FALSE);
        this.f = r1;
        this.g = r1;
        ConcurrentHashMap<String, ConcurrentHashMap<String, AtomicReference<ObricState>>> r2 = new ConcurrentHashMap();
        r2.put("simple_task", new ConcurrentHashMap());
        r2.put("aigc_generation", new ConcurrentHashMap());
        r2.put("complex_task", new ConcurrentHashMap());
        r2.put("directly_answer", new ConcurrentHashMap());
        this.h = r2;
        this.i = new ConcurrentHashMap();
        this.j = new AtomicReference(null);
        this.k = new ConcurrentHashMap();
        this.l = new ConcurrentHashMap();
        this.m = new AtomicBoolean(false);
        new AtomicLong(0);
        this.p = LazyKt.lazy(new a(this));
        this.q = LazyKt.lazy(new b(this));
        this.r = "";
    }

    public final ObricState k() {
        Intrinsics.checkNotNullParameter("complex_task", "scene");
        return r("complex_task");
    }

    public static String q(ObricState r1) {
        if (r1 == null) goto L12;
        Map r2 = r1.getExt();
        if (r2 == null) goto L12;
        Object r3 = r2.get("o_omni_task_id");
        if (r3 == null) goto L12;
        String r4 = r3.toString();
        if (r4 == null) goto L12;
        if ((!StringsKt.isBlank(r4)) == false) goto L12;
        return r4;
    L12:
        return null;
    }

    public static boolean u(Intent r2) {
        Bundle r3 = r2.getExtras();
        if (r3 == null) goto L5;
        Integer r4 = Integer.valueOf(r3.getInt("live_state", -1));
    L6:
        if (r4 != null) goto L9;
    L10:
        if (r4 != null) goto L13;
    L15:
        return false;
    L13:
        if (r4.intValue() != (-100)) goto L15;
    L16:
        return true;
    L9:
        if (r4.intValue() == (-106)) goto L16;
    L5:
        r4 = null;
        goto L6
    }

    public static void w(ObricInteractionScene r22) {
        ObricFloatChatPageState r1 = (ObricFloatChatPageState) waa.a.b.getValue();
        FLogger r2 = FLogger.a;
        r2.i("ObricLiveService", "resumeCurrentTask pageState = " + r1);
        AppHost.Companion r3 = AppHost.a;
        if (r3.getApplication().getResources().getConfiguration().orientation != 2) goto L5;
        boolean r5 = true;
    L6:
        if (r5 == true) goto L8;
    L20:
        ObricFloatChatPageData.Companion.getClass();
        if ((r1 instanceof vda.a) == true) goto L23;
    L30:
        r2.i("ObricLiveService", "resumeCurrentTask isChatWindow is false ");
        IObricLaunchService r4 = (IObricLaunchService) ServiceManager.get().getService(IObricLaunchService.class);
        if (r4 != null) goto L33;
    L39:
        boolean r6 = false;
    L40:
        if (r6 == false) goto L42;
        return;
    L42:
        if (r22 == ObricInteractionScene.REALTIME_CALL_SCENE) goto L51;
        IAssistantChatWindow r9 = IAssistantChatWindowKt.getAssistantChatWindow();
        if (r9 == null) goto L46;
        Bundle r13 = new Bundle();
        r13.putBoolean("arg_launch_half_screen", true);
        IAssistantChatWindow.DefaultImpls.openChatWindow$default(r9, null, false, null, r13, false, false, null, null, false, false, 999, null);
    L46:
        sea.e.d(false);
        r2.i("ObricLiveService", "resumeCurrentTask resumeAssistantTask failed, fallback to open half screen");
        return;
    L51:
        return;
    L33:
        if (r22 != ObricInteractionScene.REALTIME_CALL_SCENE) goto L35;
        String r7 = ObricRealtimeCallServiceDelegate.b.u();
    L36:
        r2.i("ObricLiveService", "getTargetActivityNameByScene() scene:" + r22 + ", activityName:" + r7);
        if (r4.resumeAssistantTask(r7, true) != true) goto L39;
        r6 = true;
        goto L40
    L35:
        r7 = HomeService.a.P();
        goto L36
    L23:
        if (r22 == ObricInteractionScene.REALTIME_CALL_SCENE) goto L30;
        int r0 = p.a;
        t1a.b r8 = p.a(r3.a().getCurrentActivity());
        if (r8 == null) goto L29;
        laa.d r10 = r8.o(Reflection.getOrCreateKotlinClass(laa.d.class));
        if (r10 == null) goto L29;
        laa.d.a.d(r10, false, m2.b, null, false, false, null, 61);
    L29:
        sea.e.d(false);
        r2.i("ObricLiveService", "resumeCurrentTask isChatWindow is true ");
        return;
    L8:
        if (r22 == ObricInteractionScene.REALTIME_CALL_SCENE) goto L20;
        IAssistantChatWindow r11 = IAssistantChatWindowKt.getAssistantChatWindow();
        if (r11 != null) goto L12;
    L14:
        boolean r12 = false;
    L15:
        if (r12 == false) goto L20;
        IAssistantChatWindow r14 = IAssistantChatWindowKt.getAssistantChatWindow();
        if (r14 == null) goto L19;
        IAssistantChatWindow.DefaultImpls.pop$default(r14, null, 1, null);
    L19:
        sea.e.d(false);
        r2.i("ObricLiveService", "resumeCurrentTask isLandscapeMode is true, pop window");
        return;
    L12:
        if (r11.isWindowMode() != true) goto L14;
        r12 = true;
        goto L15
    L5:
        r5 = false;
        goto L6
    }

    public static String y(ObricState r2) {
        if (r2.getScene() != ObricInteractionScene.AIGC_GENERATION_SCENE) goto L6;
        return "aigc_generation";
    L6:
        if (com.obric.assistant.live.api.b.a(r2) == false) goto L8;
        return "directly_answer";
    L8:
        return "simple_task";
    }

    public final void g(Intent r31) {
        Intrinsics.checkNotNullParameter(r31, "intent");
        if (r31.getBooleanExtra("is_complex_task_scene", false) == false) goto L6;
        ObricInteractionScene r0 = ObricInteractionScene.COMPLEX_TASK_SCENE;
    L5:
        ObricInteractionScene r5 = r0;
        ObricInteractionScene r1 = ObricInteractionScene.REALTIME_CALL_SCENE;
        if (r5 != r1) goto L20;
        FLogger.a.i("ObricLiveService", "set realtime call show when locked");
        IObricRealtimeCallExtService r7 = (IObricRealtimeCallExtService) ServiceManager.get().getService(IObricRealtimeCallExtService.class);
        if (r7 == null) goto L20;
        r7.setShowWhenLockedForExistingRealtimeCallActivity();
    L20:
        String r8 = r31.getStringExtra("island_conversation_id");
        ObricFloatChatPageState r9 = null;
        if (r8 == null) goto L45;
        IAuthModelService r10 = (IAuthModelService) ServiceManager.get().getService(IAuthModelService.class);
        if (r10 == null) goto L27;
        LiveData r11 = r10.y();
        if (r11 == null) goto L27;
        wc9.e r12 = (wc9.e) r11.getValue();
    L29:
        if (r8.length() <= 0) goto L31;
        boolean r13 = true;
    L32:
        if (r13 == false) goto L39;
        if (r12 == null) goto L35;
        String r14 = r12.a;
    L37:
        if (Intrinsics.areEqual(r8, r14) == false) goto L39;
        boolean r15 = true;
    L40:
        if (r15 == true) goto L45;
        FLogger.a.i("ObricLiveService", "resume assistant task for non-main conversation");
        IObricLaunchService r2 = (IObricLaunchService) ServiceManager.get().getService(IObricLaunchService.class);
        if (r2 == null) goto L44;
        r2.resumeOrLaunchNewTask(true);
    L44:
        sea.e.c(false);
    L196:
        IOAutoApi r3 = (IOAutoApi) ServiceManager.get().getService(IOAutoApi.class);
        if (r3 != null) goto L199;
    L201:
        boolean r4 = false;
    L202:
        if (r4 == false) goto L225;
        FLogger.a.i("ObricLiveService", "exitVirtualDisplay");
        IAssistantChatWindow r6 = (IAssistantChatWindow) ServiceManager.get().getService(IAssistantChatWindow.class);
        if (r6 == null) goto L226;
        r6.exitVirtualDisplay(500);
        return;
    L226:
        return;
    L225:
        return;
    L199:
        if (r3.b() != true) goto L201;
        r4 = true;
        goto L202
    L35:
        r14 = null;
    L39:
        r15 = false;
        goto L40
    L31:
        r13 = false;
    L27:
        r12 = null;
    L45:
        IAssistantChatWindow r16 = IAssistantChatWindowKt.getAssistantChatWindow();
        if (r16 != null) goto L48;
    L50:
        boolean r17 = false;
    L52:
        if (r17 == false) goto L104;
        if (r5 == r1) goto L104;
        if (IKeyguardStateKt.getKeyguardState().isKeyguardLocked() == true) goto L66;
        if (ObricLiveServiceDelegate.b.a() == false) goto L66;
        Result.Companion r18 = Result.Companion;     // Catch: Throwable -> L60
        FLogger.a.i("ObricLiveService", "collapseNotificationPanel");     // Catch: Throwable -> L60
        j.a.collapseNotificationPanel();     // Catch: Throwable -> L60
        Object r19 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L60
    L62:
        Throwable r20 = Result.exceptionOrNull-impl(r19);
        if (r20 == null) goto L66;
        FLogger.a.i("ObricLiveService", "collapseNotificationPanel failed, " + r20);
    L60:
        th = move-exception;
        Result.Companion r21 = Result.Companion;
        r19 = Result.constructor-impl(ResultKt.createFailure(th));
    L66:
        if (IKeyguardStateKt.getKeyguardState().isKeyguardLocked() == true) goto L75;
        IAssistantChatWindow r22 = IAssistantChatWindowKt.getAssistantChatWindow();
        if (r22 != null) goto L70;
    L72:
        boolean r23 = false;
    L73:
        if (r23 == false) goto L75;
        FLogger.a.i("ObricLiveService", "openChatOrRealtimeCallActivity skip openChatWindow, top chat activity matches system top");
        goto L196
    L70:
        if (r22.hasTopChatActivityMatchingSystemTop() != true) goto L72;
        r23 = true;
    L75:
        IAssistantChatWindow r24 = IAssistantChatWindowKt.getAssistantChatWindow();
        if (r24 != null) goto L79;
    L97:
        boolean r25 = false;
    L98:
        if (r25 == false) goto L100;
        FLogger.a.i("ObricLiveService", "openChatOrRealtimeCallActivity skip openChatWindow, window already visible half");
        goto L196
    L100:
        FLogger.a.i("ObricLiveService", "try to open chat window");
        IAssistantChatWindow r110 = IAssistantChatWindowKt.getAssistantChatWindow();
        if (r110 == null) goto L196;
        Bundle r26 = new Bundle();
        r26.putBoolean("arg_launch_half_screen", true);
        IAssistantChatWindow.DefaultImpls.openChatWindow$default(r110, null, false, null, r26, true, false, null, null, false, false, 999, null);
        goto L196
    L79:
        if (r24.isShowing() == false) goto L97;
        if (r24.isWindowAnimationRunning() == true) goto L97;
        t1a.b r27 = r24.provideWindowVContext();
        if (r27 == null) goto L88;
        laa.d r28 = r27.o(Reflection.getOrCreateKotlinClass(laa.d.class));
        if (r28 == null) goto L88;
        r9 = r28.getPageState();
    L88:
        ObricFloatChatPageData.Companion.getClass();
        if ((r9 instanceof vda.e) == false) goto L91;
    L94:
        r25 = true;
    L95:
        if (r25 == false) goto L98;
        FLogger.a.i("ObricLiveService", "already visible half window, pageState=" + r9);
        goto L98
    L91:
        if ((r9 instanceof vda.f) == true) goto L94;
        r25 = false;
    L104:
        if (IKeyguardStateKt.getKeyguardState().isKeyguardLocked() == false) goto L106;
    L114:
        AppHost.Companion r29 = AppHost.a;
        List r30 = r29.a().g();
        boolean r32 = t1.a.i();
        boolean r111 = LockedUseAuthSettingItem.AUTO_GUI.isEnabled();
        b1 r112 = waa.a.b;
        ObricFloatChatPageState r113 = (ObricFloatChatPageState) r112.getValue();
        ObricFloatChatPageData.Companion.getClass();
        boolean r114 = r113 instanceof vda.d;
        ObricInteractionScene r115 = ObricInteractionScene.COMPLEX_TASK_SCENE;
        if (r5 == r115) goto L117;
    L123:
        boolean r33 = false;
    L125:
        if (IKeyguardStateKt.getKeyguardState().isKeyguardLocked() == false) goto L169;
        if (u(r31) == false) goto L169;
        if (r30.isEmpty() == false) goto L131;
    L134:
        FLogger r34 = FLogger.a;
        r34.i("ObricLiveService", "launch chat activity with half screen on keyguard");
        if (r30.isEmpty() == false) goto L140;
        r34.i("ObricLiveService", "activityList is empty");
        IAssistantChatWindow r116 = IAssistantChatWindowKt.getAssistantChatWindow();
        if (r116 == null) goto L178;
        Bundle r35 = new Bundle();
        r35.putBoolean("arg_launch_half_screen", true);
        IAssistantChatWindow.DefaultImpls.openChatWindow$default(r116, null, false, null, r35, false, false, null, null, false, false, 999, null);
    L178:
        if (r33 == false) goto L195;
        String r36 = r113.toString();
        ObricFloatChatPageState r37 = sea.e.b();
        if (r37 == null) goto L195;
        if ((!StringsKt.isBlank(r37)) == false) goto L184;
        r9 = r37;
    L184:
        if (r9 == null) goto L195;
        int r38 = p.a;
        i r39 = com.larus.im.b.a;
        Intrinsics.checkNotNull(r39);
        t1a.b r40 = p.a(r39.a().e());
        if (r40 != null) goto L188;
        FLogger.a.i("ObricLiveService", "tryScrollPendingComplexTaskReplyForVisibleChatPage skipped, trigger=" + r36 + ", reason=current_activity_not_chat");
        goto L195
    L188:
        laa.c r41 = r40.o(Reflection.getOrCreateKotlinClass(laa.c.class));
        if (r41 != null) goto L192;
        FLogger.a.i("ObricLiveService", "tryScrollPendingComplexTaskReplyForVisibleChatPage skipped, trigger=" + r36 + ", reason=no_chat_list_ability");
        goto L195
    L192:
        if (r41.BL(r9) == true) goto L194;
        FLogger.a.i("ObricLiveService", "tryScrollPendingComplexTaskReplyForVisibleChatPage skipped, trigger=" + r36 + ", reason=message_not_in_chat_list, replyMessageId=" + r9);
        goto L195
    L194:
        FLogger.a.i("ObricLiveService", "tryScrollPendingComplexTaskReplyForVisibleChatPage success, trigger=" + r36 + ", replyMessageId=" + r9);
        r41.vC(r9);
        sea.e.e.set(SystemClock.elapsedRealtime());
        sea.e.a(r9);
    L195:
        com.obric.assistant.live.api.a.a.a(j.a, true, 1);
        goto L196
    L140:
        if (j.a.c(r5) == false) goto L142;
    L159:
        r34.i("ObricLiveService", "resume chat activity on keyguard");
        sea.e.d(true);
        Iterator r42 = r30.iterator();
    L161:
        if (r42.hasNext() == false) goto L167;
        Activity r43 = (Activity) r42.next();
        if (p.d(r43) == false) goto L161;
        if (Build.VERSION.SDK_INT < 27) goto L161;
        FLogger.a.i("ObricLiveService", "setShowWhenLocked true, activity = " + r43);
        r43.setShowWhenLocked(true);
        this.t = true;
        goto L161
    L167:
        w(r5);
        goto L178
    L142:
        if (IKeyguardStateKt.getKeyguardState().isDeviceLocked() == false) goto L159;
        if (IKeyguardStateKt.getKeyguardState().isDeviceLocked() == false) goto L178;
        if (r5 != r115) goto L178;
        if (r114 == true) goto L178;
        if (r32 == false) goto L178;
        if (r111 == false) goto L178;
        r34.i("ObricLiveService", "resume complex task scene on keyguard");
        sea.e.d(true);
        Iterator r44 = r30.iterator();
    L152:
        if (r44.hasNext() == false) goto L158;
        Activity r45 = (Activity) r44.next();
        if (p.d(r45) == false) goto L152;
        if (Build.VERSION.SDK_INT < 27) goto L152;
        FLogger.a.i("ObricLiveService", "setShowWhenLocked true, activity = " + r45 + "，scene = complex task");
        r45.setShowWhenLocked(true);
        this.t = true;
        goto L152
    L158:
        w(r5);
        goto L178
    L131:
        if ((((ObricFloatChatPageState) r112.getValue()) instanceof vda.d) == false) goto L134;
        if (IKeyguardStateKt.getKeyguardState().isDeviceLocked() == true) goto L134;
    L169:
        if (r30.isEmpty() == false) goto L174;
        IAssistantChatWindow r117 = IAssistantChatWindowKt.getAssistantChatWindow();
        if (r117 == null) goto L173;
        Bundle r46 = new Bundle();
        r46.putBoolean("arg_launch_half_screen", true);
        IAssistantChatWindow.DefaultImpls.openChatWindow$default(r117, null, false, null, r46, false, false, null, null, false, false, 999, null);
    L173:
        FLogger.a.i("ObricLiveService", "launch main activity");
        goto L178
    L174:
        FLogger.a.i("ObricLiveService", "resume assistant task");
        if (r5 == ObricInteractionScene.REALTIME_CALL_SCENE) goto L177;
        sea.e.d(true);
    L177:
        w(r5);
        goto L178
    L117:
        if (u(r31) == false) goto L123;
        if (r29.a().isAppBackground() == true) goto L123;
        if (ObricFloatChatPageData.a.d(r113) == false) goto L123;
        r33 = true;
        goto L125
    L106:
        if (ObricLiveServiceDelegate.b.a() == false) goto L114;
        Result.Companion r47 = Result.Companion;     // Catch: Throwable -> L109
        FLogger.a.i("ObricLiveService", "collapseNotificationPanel");     // Catch: Throwable -> L109
        j.a.collapseNotificationPanel();     // Catch: Throwable -> L109
        Object r48 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L109
    L111:
        Throwable r49 = Result.exceptionOrNull-impl(r48);
        if (r49 == null) goto L114;
        FLogger.a.i("ObricLiveService", "collapseNotificationPanel failed, " + r49);
    L109:
        th = move-exception;
        Result.Companion r50 = Result.Companion;
        r48 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L111
    L48:
        if (r16.isWindowMode() != true) goto L50;
        r17 = true;
        goto L52
    L6:
        Bundle r51 = r31.getExtras();
        if (r51 != null) goto L9;
    L11:
        boolean r52 = false;
    L12:
        if (r52 == false) goto L14;
        r0 = ObricInteractionScene.REALTIME_CALL_SCENE;
        goto L5
    L14:
        r0 = ObricInteractionScene.DEFAULT;
        goto L5
    L9:
        if (r51.getInt("live_state", -1) != (-101)) goto L11;
        r52 = true;
        goto L12
    }

    public final ObricState r(String r2) {
        String r0 = this.i.get(r2);
        if (r0 != null) goto L7;
        return null;
    L7:
        return s(r2, r0);
    }

    public final List<ObricState> t(String r3) {
        ConcurrentHashMap<String, AtomicReference<ObricState>> r4 = this.h.get(r3);
        if (r4 == null) goto L12;
        Collection<AtomicReference<ObricState>> r5 = r4.values();
        if (r5 == null) goto L12;
        ArrayList r0 = new ArrayList();
        Iterator<T> r6 = r5.iterator();
    L8:
        if (r6.hasNext() == false) goto L13;
        ObricState r1 = (ObricState) ((AtomicReference) r6.next()).get();
        if (r1 == null) goto L8;
        r0.add(r1);
    L13:
        if (r0 == null) goto L15;
        return r0;
    L15:
        return CollectionsKt.emptyList();
    L12:
        r0 = null;
        goto L13
    }

    public final void A(ObricInteractionScene r10, ObricState r11) {
        FLogger r0 = FLogger.a;
        r0.i("ObricLiveService", "update live show, scene: " + r10 + ", state: " + r11);
        if (this.e == ObricActivityVisibleState.NA) goto L5;
    L9:
        boolean r4 = false;
        if (r11.getScene() == ObricInteractionScene.DEFAULT) goto L12;
    L27:
        boolean r1 = false;
    L28:
        if (r1 == false) goto L30;
        r0.i("ObricLiveService", "skip TTS live card because playback stops in background, messageId: " + r11.getSourceMessageId());
    L30:
        if (r1 == false) goto L32;
        return;
    L32:
        int[] r2 = b.b;
        if (r2[r10.ordinal()] != 1) goto L54;
        if (this.n == false) goto L46;
        if (r11.getCurrentIslandState() != ObricIslandStateType.COMPLEX_TASK_COMPLETED) goto L39;
    L44:
        this.n = false;
        goto L46
    L39:
        if (r11.getCurrentIslandState() == ObricIslandStateType.TTS_PLAYING) goto L44;
        if (s("complex_task", r11.getConversationId()) != null) goto L46;
    L51:
        if (r4 == true) goto L102;
        return;
    L102:
        x(new Event.b(r10, r11), "update live card, scene: " + r10);
        return;
    L46:
        if (r11.getCurrentIslandState() == ObricIslandStateType.COMPLEX_TASK_COMPLETED) goto L48;
    L50:
        r4 = true;
        goto L51
    L48:
        if (this.o == false) goto L50;
        this.o = false;
        goto L51
    L54:
        if (r11.getCurrentIslandState() != ObricIslandStateType.CLICK_TALK_END) goto L56;
    L104:
        r0.i("ObricLiveService", "need destroy directly answer live show, state: " + r11);
        x(new Event.a(r10, r11), "update directly answer live show");
        return;
    L56:
        if (r11.getCurrentIslandState() == ObricIslandStateType.CLICK_TALK_ASR_END) goto L104;
        if (r11.getCurrentIslandState() != ObricIslandStateType.REALTIME_CALL_END) goto L63;
        r0.i("ObricLiveService", "need destroy simple task live show, state: " + r11);
        x(new Event.a(r10, r11), "update simple task live show");
        return;
    L63:
        if (com.obric.assistant.live.api.b.a(r11) == false) goto L66;
        r0.i("ObricLiveService", "updateDirectlyAnswerLiveShow, state: " + r11);
        x(new Event.b(r10, r11), "update directly answer live show");
        return;
    L66:
        ObricInteractionScene r3 = r11.getScene();
        if (r3 != null) goto L69;
        int r5 = -1;
    L71:
        if (r5 == 2) goto L102;
        if (r5 != 3) goto L75;
        r0.i("ObricLiveService", "sessionMode: ObricInteractionScene.REALTIME_CALL_SCENE, with state " + r11.getCurrentIslandState().name() + " activityInvisibleWhenGenerated " + this.n + " stopTtsByUser false ");
        this.o = false;
        ObricInteractionScene r6 = ObricInteractionScene.REALTIME_CALL_SCENE;
        x(new Event.b(r6, r11), "update live card, scene: " + r6);
        goto L102
    L75:
        if (r5 != 4) goto L77;
    L80:
        r0.i("ObricLiveService", "state " + r11.getCurrentIslandState().name() + " mode " + r11.getScene() + " activityInvisibleWhenGenerated " + this.n + " stopTtsByUser false ");
        if (this.n == false) goto L94;
        if (r11.getCurrentIslandState() != ObricIslandStateType.DEEP_THINK_START) goto L85;
    L92:
        this.n = false;
        goto L94
    L85:
        if (r11.getCurrentIslandState() == ObricIslandStateType.MSG_START) goto L92;
        if (r11.getCurrentIslandState() == ObricIslandStateType.TTS_PLAYING) goto L92;
        if (s("simple_task", r11.getConversationId()) != null) goto L94;
    L99:
        if (r4 == true) goto L102;
        return;
    L94:
        if (r11.getCurrentIslandState() == ObricIslandStateType.DEEP_THINK_END) goto L96;
    L98:
        r4 = true;
        goto L99
    L96:
        if (this.o == false) goto L98;
        this.o = false;
        goto L99
    L77:
        if (r5 == 5) goto L80;
        r0.e("ObricLiveService", "state(" + r11 + ") not match SimpleTask");
        return;
    L69:
        r5 = r2[r3.ordinal()];
        goto L71
    L12:
        if (r11.getCurrentIslandState() != ObricIslandStateType.TTS_PLAYING) goto L27;
        if (com.obric.assistant.live.api.b.a(r11) == true) goto L27;
        if (IKeyguardStateKt.getKeyguardState().isKeyguardLocked() == true) goto L27;
        if (ObricTtsControlDelegate.b.f() == false) goto L27;
        IAssistantChatWindow r7 = IAssistantChatWindowKt.getAssistantChatWindow();
        if (r7 != null) goto L22;
    L24:
        boolean r8 = false;
    L25:
        if (r8 == true) goto L27;
        r1 = true;
        goto L28
    L22:
        if (r7.isShowing() != true) goto L24;
        r8 = true;
        goto L25
    L5:
        if (AppHost.a.a().isAppBackground() == false) goto L7;
        ObricActivityVisibleState r9 = ObricActivityVisibleState.INVISIBLE;
    L8:
        this.e = r9;
        goto L9
    L7:
        r9 = ObricActivityVisibleState.VISIBLE;
        goto L8
    }

    public final ObricState h(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "scene");
        Intrinsics.checkNotNullParameter(r3, "conversationId");
        return s(r2, r3);
    }

    public final void l(int r2, boolean r3) {
        p(r2, r3, null);
    }

    public final ObricState s(String r2, String r3) {
        ConcurrentHashMap<String, AtomicReference<ObricState>> r4 = this.h.get(r2);
        if (r4 == null) goto L7;
        AtomicReference<ObricState> r5 = r4.get(r3);
        if (r5 == null) goto L7;
        return r5.get();
    L7:
        return null;
    }

    public final void v(String r4, String r5) {
        ConcurrentHashMap<String, AtomicReference<ObricState>> r0 = this.h.get(r4);
        if (r0 != null) goto L5;
        return;
    L5:
        if (r5 != null) goto L9;
        r5 = this.i.get(r4);
        if (r5 != null) goto L9;
        return;
    L9:
        AtomicReference<ObricState> r1 = r0.remove(r5);
        if (r1 == null) goto L13;
        r1.set(null);
    L13:
        if (Intrinsics.areEqual(this.i.get(r4), r5) == false) goto L19;
        String r6 = (String) CollectionsKt.firstOrNull(r0.keySet());
        if (r6 == null) goto L17;
        this.i.put(r4, r6);
        return;
    L17:
        this.i.remove(r4);
        return;
    }

    public final void x(Event r7, String r8) {
        BuildersKt.launch$default(this.b, null, null, new sendEvent.1(r7, r8, this, null), 3, null);
    }

    public final void z(String r4, ObricState r5) {
        ConcurrentHashMap<String, AtomicReference<ObricState>> r0 = this.h.get(r4);
        if (r0 != null) goto L5;
        return;
    L5:
        AtomicReference<ObricState> r1 = new AtomicReference(null);
        AtomicReference<ObricState> r2 = r0.get(r5.getConversationId());
        if (r2 != null) goto L11;
        AtomicReference<ObricState> r3 = r0.putIfAbsent(r5.getConversationId(), r1);
        if (r3 == null) goto L12;
        r1 = r3;
    L12:
        r1.set(r5);
        this.i.put(r4, r5.getConversationId());
        return;
    L11:
        r1 = r2;
        goto L12
    }

    public static final void n(ObricLiveService r8, ObricState r9, ObricState r10) {
        r8.getClass();
        ObricInteractionScene r0 = r10.getScene();
        if (r0 != null) goto L5;
        int r1 = -1;
    L6:
        boolean r2 = true;
        ObricState r4 = null;
        if (r1 != 1) goto L9;
        r8.z("complex_task", r10);
        FLogger r6 = FLogger.a;
        r6.i("ObricLiveService", "beginToShowLiveCard, oldObricState: " + r9 + ", newObricState: " + r10);
        if (r10.getCurrentIslandState() != ObricIslandStateType.COMPLEX_TASK_INTERRUPTED) goto L66;
        String r11 = q(r10);
        if (r11 != null) goto L42;
        r6.i("ObricLiveService", "complex task interrupted without taskId, keep destroy behavior");
    L58:
        if (r2 == false) goto L97;
        ObricInteractionScene r12 = r10.getScene();
        if (r12 == null) goto L92;
        j r3 = j.a;
        if (r3.e() == false) goto L65;
        r3.f(false);
    L65:
        r8.x(new Event.a(r12, r10), "destroy complex task live card when interrupted");
        return;
    L92:
        return;
    L97:
        return;
    L42:
        ObricTaskStatusManager.a.getClass();
        ObricState r5 = l.d(ObricTaskStatusManager.c());
        if ((!StringsKt.isBlank(r5)) == false) goto L46;
        r4 = r5;
    L46:
        if (r4 == null) goto L48;
        r2 = Intrinsics.areEqual(r11, r4);
        r6.i("ObricLiveService", "complex task interrupted, interruptedTaskId: " + r11 + ", runningTaskId: " + r4 + ", shouldDestroy: " + r2);
        goto L58
    L48:
        List<ObricState> r7 = r8.t("complex_task");
        ArrayList r13 = new ArrayList();
        Iterator<T> r14 = r7.iterator();
    L50:
        if (r14.hasNext() == false) goto L54;
        String r15 = q((ObricState) r14.next());
        if (r15 == null) goto L50;
        r13.add(r15);
        goto L50
    L54:
        Set r16 = CollectionsKt.toSet(r13);
        if (r16.isEmpty() == false) goto L57;
        FLogger.a.i("ObricLiveService", "complex task interrupted without current task, keep destroy behavior, interruptedTaskId: ".concat(r11));
        goto L58
    L57:
        r2 = r16.contains(r11);
        FLogger.a.i("ObricLiveService", "complex task interrupted, interruptedTaskId: " + r11 + ", currentTaskIds: " + r16 + ", shouldDestroy: " + r2);
        goto L58
    L66:
        if (r9 == null) goto L69;
        r4 = r9.getCurrentIslandState();
    L69:
        if (r4 != ObricIslandStateType.TTS_PLAYING) goto L74;
        if (r10.getCurrentIslandState() == ObricIslandStateType.TTS_END) goto L74;
        r6.i("ObricLiveService", "beginToShowLiveCard, complex task end tts playing");
        return;
    L74:
        if (r10.getCurrentIslandState() == ObricIslandStateType.COMPLEX_TASK_COMPLETED) goto L76;
    L80:
        r8.A(ObricInteractionScene.COMPLEX_TASK_SCENE, r10);
        return;
    L76:
        if (AppHost.a.a().isAppBackground() == true) goto L80;
        ObricInteractionScene r17 = r10.getScene();
        if (r17 == null) goto L95;
        r8.x(new Event.a(r17, r10), "destroy complex task live card when completed in foreground");
        return;
    L95:
        return;
    L9:
        if (r1 != 2) goto L11;
        FLogger.a.i("ObricLiveService", "updateAigcGenerationLiveShow, newObricState: " + r10);
        r8.z("aigc_generation", r10);
        r8.A(ObricInteractionScene.AIGC_GENERATION_SCENE, r10);
        return;
    L11:
        if (com.obric.assistant.live.api.b.a(r10) == false) goto L16;
        FLogger.a.i("ObricLiveService", "updateDirectlyAnswerLiveShow, oldObricState: " + r9 + ", newObricState: " + r10);
        r8.z("directly_answer", r10);
        ObricInteractionScene r18 = r10.getScene();
        if (r18 != null) goto L15;
        r18 = ObricInteractionScene.DEFAULT;
    L15:
        r8.A(r18, r10);
        return;
    L16:
        FLogger r19 = FLogger.a;
        r19.i("ObricLiveService", "updateSimpleTaskLiveShow, oldObricState: " + r9 + ", newObricState: " + r10);
        if (r10.getCurrentIslandState() != ObricIslandStateType.REALTIME_CALL_MUTE) goto L19;
    L21:
        r4 = r9;
    L23:
        if (r10.getCurrentIslandState() == ObricIslandStateType.DEEP_THINK_END) goto L25;
    L29:
        r19.i("ObricLiveService", "beginToShowLiveCard, oldObricState: " + r9 + ", newObricState: " + r10);
        ObricInteractionScene r20 = r10.getScene();
        if (r20 != null) goto L32;
        r20 = ObricInteractionScene.DEFAULT;
    L32:
        if (r4 == null) goto L35;
        r10 = r4;
    L35:
        r8.A(r20, r10);
        return;
    L25:
        if (AppHost.a.a().isAppBackground() == true) goto L29;
        ObricInteractionScene r21 = r10.getScene();
        if (r21 == null) goto L88;
        r8.x(new Event.a(r21, r10), "destroy simple task live card when deep think ends in foreground");
        return;
    L88:
        return;
    L19:
        if (r10.getCurrentIslandState() == ObricIslandStateType.REALTIME_CALL_UN_MUTE) goto L21;
        r8.z("simple_task", r10);
        goto L23
    L5:
        r1 = b.b[r0.ordinal()];
        goto L6
    }

    public final void d(int r2, boolean r3, String r4) {
        Intrinsics.checkNotNullParameter(r4, "conversationId");
        p(r2, r3, r4);
    }

    public final void p(int r4, boolean r5, String r6) {
        ObricInteractionScene.Companion.getClass();
        ObricInteractionScene r0 = (ObricInteractionScene) ArraysKt.getOrNull(ObricInteractionScene.values(), r4);
        if (r0 != null) goto L5;
        r0 = ObricInteractionScene.DEFAULT;
    L5:
        int r1 = b.b[r0.ordinal()];
        if (r1 != 1) goto L8;
        v("complex_task", r6);
    L22:
        if (r6 != null) goto L30;
        j r7 = j.a;
        Context r2 = this.a;
        if (r2 != null) goto L26;
        r2 = AppHost.a.getApplication().getApplicationContext();
    L26:
        Intrinsics.checkNotNull(r2);
        ObricInteractionScene r8 = (ObricInteractionScene) ArraysKt.getOrNull(ObricInteractionScene.values(), r4);
        if (r8 != null) goto L29;
        r8 = ObricInteractionScene.DEFAULT;
    L29:
        r7.d(r2, r8, r5);
        return;
    L30:
        j r3 = j.a;
        Context r9 = this.a;
        if (r9 != null) goto L33;
        r9 = AppHost.a.getApplication().getApplicationContext();
    L33:
        Intrinsics.checkNotNull(r9);
        ObricInteractionScene r10 = (ObricInteractionScene) ArraysKt.getOrNull(ObricInteractionScene.values(), r4);
        if (r10 != null) goto L36;
        r10 = ObricInteractionScene.DEFAULT;
    L36:
        r3.o(r9, r10, r5, r6);
        return;
    L8:
        if (r1 == 2) goto L20;
        if (r5 == false) goto L11;
        v("directly_answer", r6);
        goto L22
    L11:
        if (r6 != null) goto L14;
        this.k.clear();
        this.l.clear();
    L19:
        v("simple_task", r6);
        goto L22
    L14:
        if (r4 != ObricInteractionScene.DEFAULT.ordinal()) goto L17;
        this.l.remove(r6);
        goto L19
    L17:
        if (r4 != ObricInteractionScene.DEEP_THINK_SCENE.ordinal()) goto L19;
        this.k.remove(r6);
        goto L19
    L20:
        v("aigc_generation", r6);
        goto L22
    }
}
