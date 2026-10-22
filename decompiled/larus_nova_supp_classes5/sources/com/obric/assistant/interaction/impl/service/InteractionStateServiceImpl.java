package com.obric.assistant.interaction.impl.service;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.util.SparseArray;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.ai.api.AppletExtService;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.audio.ttsV2.TtsClientDelegate;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.audio.service.ObricRealtimeCallStateServiceDelegate;
import com.obric.assistant.chat.ObricChatContextServiceDelegate;
import com.obric.assistant.interaction.api.service.IInteractionStateService;
import com.obric.assistant.interaction.base.interact.CustomBarAction;
import com.obric.assistant.interaction.base.interact.IObserveToken;
import com.obric.assistant.interaction.base.interact.IStatable;
import com.obric.assistant.interaction.base.interact.KeyguardLockedState;
import com.obric.assistant.interaction.base.mode.MicMuteState;
import com.obric.assistant.interaction.base.model.AssistantActivityExpandState;
import com.obric.assistant.interaction.base.model.AssistantActivityVisibleState;
import com.obric.assistant.interaction.base.model.SessionLifecycleState;
import com.obric.assistant.interaction.impl.KtUtils;
import com.obric.assistant.interaction.impl.model.IFlowSDKControl;
import com.obric.assistant.oauto.IOAutoApi;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.KotlinNothingValueException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.j1;
import kotlinx.coroutines.flow.z0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000Ö\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u001e\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\"\u0010H\u001a\u00020)\"\n\b\u0000\u0010I\u0018\u0001*\u00020J2\u0006\u0010K\u001a\u0002HIH\u0086\b¢\u0006\u0002\u0010LJ\b\u0010M\u001a\u00020\u0012H\u0016J$\u0010N\u001a\u00020)2\u0006\u0010O\u001a\u00020'2\u0012\u0010P\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020)0(H\u0016J\u0010\u0010Q\u001a\u00020)2\u0006\u0010O\u001a\u00020'H\u0016J\b\u0010R\u001a\u00020\u001fH\u0016J$\u0010S\u001a\u00020)2\u0006\u0010O\u001a\u00020'2\u0012\u0010P\u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020)0(H\u0016J\u0010\u0010T\u001a\u00020)2\u0006\u0010O\u001a\u00020'H\u0016J\b\u0010U\u001a\u00020\u001cH\u0016J$\u0010V\u001a\u00020)2\u0006\u0010O\u001a\u00020'2\u0012\u0010P\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020)0(H\u0016J\u0010\u0010W\u001a\u00020)2\u0006\u0010O\u001a\u00020'H\u0016J\b\u0010X\u001a\u00020\u0019H\u0016J$\u0010Y\u001a\u00020)2\u0006\u0010O\u001a\u00020'2\u0012\u0010P\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020)0(H\u0016J\u0010\u0010Z\u001a\u00020)2\u0006\u0010O\u001a\u00020'H\u0016J\u0010\u0010[\u001a\u00020)2\u0006\u0010\\\u001a\u000201H\u0016J\b\u0010]\u001a\u00020)H\u0002J\u0018\u0010^\u001a\u0012\u0012\u0004\u0012\u00020103j\b\u0012\u0004\u0012\u000201`4H\u0016J\u0010\u0010_\u001a\u00020)2\u0006\u0010`\u001a\u00020#H\u0016J\u0016\u0010a\u001a\u00020)2\f\u0010b\u001a\b\u0012\u0004\u0012\u00020\u00060cH\u0016J4\u0010d\u001a\u00020)2\u0006\u0010O\u001a\u00020'2\"\u0010P\u001a\u001e\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020103j\b\u0012\u0004\u0012\u000201`4\u0012\u0004\u0012\u00020)0(H\u0016J\u0010\u0010e\u001a\u00020)2\u0006\u0010O\u001a\u00020'H\u0016J$\u0010f\u001a\u00020)2\u0006\u0010O\u001a\u00020'2\u0012\u0010g\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020)0(H\u0016J\u0010\u0010h\u001a\u00020)2\u0006\u0010O\u001a\u00020'H\u0016J$\u0010i\u001a\u00020)2\u0006\u0010O\u001a\u00020'2\u0012\u0010P\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020)0(H\u0016J\u0010\u0010j\u001a\u00020)2\u0006\u0010O\u001a\u00020'H\u0016J\u0018\u0010k\u001a\u00020)2\u0006\u0010l\u001a\u00020\u00062\u0006\u0010m\u001a\u00020\u0006H\u0016J\u0010\u0010n\u001a\u00020#2\u0006\u0010l\u001a\u00020\u0006H\u0002J\n\u0010o\u001a\u0004\u0018\u00010\u0006H\u0016J\u0010\u0010p\u001a\u00020)2\u0006\u0010q\u001a\u00020\u0006H\u0016J\b\u0010r\u001a\u00020\u0006H\u0016J%\u0010s\u001a\u00020)\"\u0004\b\u0000\u0010I2\u0006\u0010t\u001a\u00020u2\b\u0010v\u001a\u0004\u0018\u0001HIH\u0016¢\u0006\u0002\u0010wJ\u001d\u0010x\u001a\u0004\u0018\u0001HI\"\u0004\b\u0000\u0010I2\u0006\u0010t\u001a\u00020uH\u0016¢\u0006\u0002\u0010yJ\b\u0010z\u001a\u00020)H\u0016J\b\u0010{\u001a\u00020)H\u0016J\b\u0010|\u001a\u00020#H\u0016J\u0010\u0010}\u001a\u00020)2\u0006\u0010~\u001a\u00020#H\u0016J\u0013\u0010\u0081\u0001\u001a\u00020)2\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J.\u0010\u0082\u0001\u001a\u00020)\"\u0004\b\u0000\u0010I*\b\u0012\u0004\u0012\u0002HI0\u00112\u0013\u0010\u0083\u0001\u001a\u000e\u0012\u0004\u0012\u0002HI\u0012\u0004\u0012\u00020)0(H\u0002J\t\u0010\u0084\u0001\u001a\u00020)H\u0016J\t\u0010\u0085\u0001\u001a\u00020)H\u0016J\t\u0010\u0086\u0001\u001a\u00020)H\u0016J\t\u0010\u0087\u0001\u001a\u00020)H\u0016J\t\u0010\u0088\u0001\u001a\u00020)H\u0016J\t\u0010\u0089\u0001\u001a\u00020#H\u0016J\t\u0010\u008a\u0001\u001a\u00020)H\u0016J\t\u0010\u008b\u0001\u001a\u00020)H\u0016J\t\u0010\u008c\u0001\u001a\u00020)H\u0016J\t\u0010\u008d\u0001\u001a\u00020)H\u0016J\r\u0010\u008e\u0001\u001a\u00030\u008f\u0001*\u00030\u008f\u0001R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R\u0017\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0014R\u0017\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0014R\u0017\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\u0011¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0014R#\u0010!\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\u00060\"0\u0011¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0014R(\u0010%\u001a\u001c\u0012\u0004\u0012\u00020'\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020)\u0018\u00010(0&X\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010*\u001a\u001c\u0012\u0004\u0012\u00020'\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020)\u0018\u00010(0&X\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010+\u001a\u001c\u0012\u0004\u0012\u00020'\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020)\u0018\u00010(0&X\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010,\u001a\u001c\u0012\u0004\u0012\u00020'\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020)\u0018\u00010(0&X\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010-\u001a\u001c\u0012\u0004\u0012\u00020'\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020)\u0018\u00010(0&X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020/X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u00100\u001a\b\u0012\u0004\u0012\u0002010\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R6\u00102\u001a*\u0012\u0004\u0012\u00020'\u0012 \u0012\u001e\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020103j\b\u0012\u0004\u0012\u000201`4\u0012\u0004\u0012\u00020)0(0&X\u0082\u0004¢\u0006\u0002\n\u0000R(\u00105\u001a\u001c\u0012\u0004\u0012\u00020'\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020)\u0018\u00010(06X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u00107\u001a\u0010\u0012\f\u0012\n 9*\u0004\u0018\u00010\u00060\u000608X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010:\u001a\u0010\u0012\f\u0012\n 9*\u0004\u0018\u00010\u00060\u000608X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010;\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010=0<X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010>\u001a\u0004\u0018\u00010?8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bB\u0010C\u001a\u0004\b@\u0010AR!\u0010D\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030E\u0012\u0004\u0012\u00020\n06¢\u0006\b\n\u0000\u001a\u0004\bF\u0010GR'\u0010\u007f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\u00060\"0\u00118VX\u0096\u0004¢\u0006\u0007\u001a\u0005\b\u0080\u0001\u0010\u0014¨\u0006\u0090\u0001"}, d2 = {"Lcom/obric/assistant/interaction/impl/service/InteractionStateServiceImpl;", "Lcom/obric/assistant/interaction/api/service/IInteractionStateService;", "Lcom/obric/assistant/interaction/impl/model/IFlowSDKControl;", "<init>", "()V", "TAG", "", "context", "Landroid/content/Context;", "mainScope", "Lkotlinx/coroutines/CoroutineScope;", "getMainScope", "()Lkotlinx/coroutines/CoroutineScope;", "jobs", "", "Lkotlinx/coroutines/Job;", "sessionLifecycleState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/obric/assistant/interaction/base/model/SessionLifecycleState;", "getSessionLifecycleState", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "micMuteState", "Lcom/obric/assistant/interaction/base/mode/MicMuteState;", "getMicMuteState", "keyguardLockedState", "Lcom/obric/assistant/interaction/base/interact/KeyguardLockedState;", "getKeyguardLockedState", "activityExpandState", "Lcom/obric/assistant/interaction/base/model/AssistantActivityExpandState;", "getActivityExpandState", "activityVisibleState", "Lcom/obric/assistant/interaction/base/model/AssistantActivityVisibleState;", "getActivityVisibleState", "_soundEffectState", "Lkotlin/Pair;", "", "get_soundEffectState", "sessionLifecycleStateObservers", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/obric/assistant/interaction/base/interact/IObserveToken;", "Lkotlin/Function1;", "", "activityExpandStateObservers", "activityVisibleStateObservers", "keyguardLockedStateObservers", "micMuteStateObservers", "obricRealtimeCallStateService", "Lcom/obric/assistant/audio/service/ObricRealtimeCallStateServiceDelegate;", "actionsList", "Lcom/obric/assistant/interaction/base/interact/CustomBarAction;", "customBarActionStateObservers", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "autoIncreaseWindowObservers", "", "wakeupPkg", "Ljava/util/concurrent/atomic/AtomicReference;", "kotlin.jvm.PlatformType", "wakeupSource", "wakeupData", "Landroid/util/SparseArray;", "", "appletExtService", "Lcom/bytedance/ai/api/AppletExtService;", "getAppletExtService", "()Lcom/bytedance/ai/api/AppletExtService;", "appletExtService$delegate", "Lkotlin/Lazy;", "scopeMaps", "Lkotlin/reflect/KClass;", "getScopeMaps", "()Ljava/util/Map;", "updateInteractionState", "T", "Lcom/obric/assistant/interaction/base/interact/IStatable;", "state", "(Lcom/obric/assistant/interaction/base/interact/IStatable;)V", "getInteractionSessionLifecycleState", "observeInteractionSessionLifecycleState", "token", "callback", "unObserveInteractionSessionLifecycleState", "getInteractionActivityVisibleState", "observeInteractionActivityVisibleState", "unObserveInteractionActivityVisibleState", "getInteractionActivityExpandState", "observeInteractionActivityExpandState", "unObserveInteractionActivityExpandState", "getInteractionKeyguardLockedState", "observeInteractionKeyguardLockedState", "unObserveInteractionKeyguardLockedState", "addCustomBarAction", "action", "notifyCustomActionBar", "getCustomBarActions", "clearCustomBarActions", "showOnLauncher", "removeCustomBarActions", "keys", "", "observeCustomBarActionsState", "unObserveCustomBarActionsState", "setAutoIncreaseWindowObserver", "observer", "removeAutoIncreaseWindowObserver", "observeMicMuteState", "unObserveMicMuteState", "setWakeUpAppPkg", "pkg", "reason", "handleWakeupSourceOnAssistantPage", "getWakeUpAppPkg", "setWakeUpSource", "source", "getWakeUpSource", "setWakeUpData", "key", "", "data", "(ILjava/lang/Object;)V", "getWakeUpData", "(I)Ljava/lang/Object;", "resetWakeupData", "resetWakeupSource", "isDefiniteWakeUpSource", "setAutoIncreaseWindow", "increase", "preSoundEffectState", "getPreSoundEffectState", "init", "observe", "block", "start", "stop", "release", "stopTtsPlay", "startTtsPlay", "isTtsStopped", "restartTtsPlay", "muteMic", "unMuteMic", "endCall", "findPreviousIfChatWindow", "Landroid/app/Activity;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class InteractionStateServiceImpl implements IInteractionStateService, IFlowSDKControl {
    public static final InteractionStateServiceImpl INSTANCE = null;
    public static final String TAG = "InteractionStateServiceImpl";
    private static final z0<Pair<Boolean, String>> _soundEffectState = null;
    private static final List<CustomBarAction> actionsList = null;
    private static final z0<AssistantActivityExpandState> activityExpandState = null;
    private static final ConcurrentHashMap<IObserveToken, Function1<AssistantActivityExpandState, Unit>> activityExpandStateObservers = null;
    private static final z0<AssistantActivityVisibleState> activityVisibleState = null;
    private static final ConcurrentHashMap<IObserveToken, Function1<AssistantActivityVisibleState, Unit>> activityVisibleStateObservers = null;
    private static final Lazy appletExtService$delegate = null;
    private static final Map<IObserveToken, Function1<Boolean, Unit>> autoIncreaseWindowObservers = null;
    private static Context context;
    private static final ConcurrentHashMap<IObserveToken, Function1<ArrayList<CustomBarAction>, Unit>> customBarActionStateObservers = null;
    private static final List<Job> jobs = null;
    private static final z0<KeyguardLockedState> keyguardLockedState = null;
    private static final ConcurrentHashMap<IObserveToken, Function1<KeyguardLockedState, Unit>> keyguardLockedStateObservers = null;
    private static final CoroutineScope mainScope = null;
    private static final z0<MicMuteState> micMuteState = null;
    private static final ConcurrentHashMap<IObserveToken, Function1<MicMuteState, Unit>> micMuteStateObservers = null;
    private static final ObricRealtimeCallStateServiceDelegate obricRealtimeCallStateService = null;
    private static final Map<KClass<?>, CoroutineScope> scopeMaps = null;
    private static final z0<SessionLifecycleState> sessionLifecycleState = null;
    private static final ConcurrentHashMap<IObserveToken, Function1<SessionLifecycleState, Unit>> sessionLifecycleStateObservers = null;
    private static final SparseArray<Object> wakeupData = null;
    private static AtomicReference<String> wakeupPkg;
    private static AtomicReference<String> wakeupSource;

    /* JADX INFO: renamed from: com.obric.assistant.interaction.impl.service.InteractionStateServiceImpl$observe$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.assistant.interaction.impl.service.InteractionStateServiceImpl$observe$1", f = "InteractionStateServiceImpl.kt", i = {}, l = {435}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<T, Unit> $block;
        final /* synthetic */ z0<T> $this_observe;
        int label;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(z0<T> r1, Function1<? super T, Unit> r2, Continuation<? super AnonymousClass1> r3) {
            this.$this_observe = r1;
            this.$block = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass1(this.$this_observe, this.$block, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r5) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L6;
            ResultKt.throwOnFailure(r5);
        L12:
            throw new KotlinNothingValueException();
        L6:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            final z0<T> r6 = this.$this_observe;
            final Function1<T, Unit> r3 = this.$block;
            FlowCollector r2 = new C00021(r6, r3);
            this.label = 1;
            if (r6.collect(r2, this) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.assistant.interaction.impl.service.InteractionStateServiceImpl$updateInteractionState$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 176)
    @DebugMetadata(c = "com.obric.assistant.interaction.impl.service.InteractionStateServiceImpl$updateInteractionState$1", f = "InteractionStateServiceImpl.kt", i = {}, l = {112, 116, 120, 124, 128}, m = "invokeSuspend", n = {}, s = {})
    public static final class C00371 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: Incorrect field signature: TT; */
        final /* synthetic */ IStatable $state;
        int label;

        /* JADX WARN: Incorrect types in method signature: (TT;Lkotlin/coroutines/Continuation<-Lcom/obric/assistant/interaction/impl/service/InteractionStateServiceImpl$updateInteractionState$1;>;)V */
        public C00371(IStatable r1, Continuation r2) {
            this.$state = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C00371(this.$state, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r10) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L13;
            if (r1 == 1) goto L12;
            if (r1 == 2) goto L12;
            if (r1 == 3) goto L12;
            if (r1 == 4) goto L12;
            if (r1 == 5) goto L12;
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L12:
            ResultKt.throwOnFailure(r10);
        L40:
            return Unit.INSTANCE;
        L13:
            ResultKt.throwOnFailure(r10);
            FLogger r11 = FLogger.a;
            r11.d(InteractionStateServiceImpl.TAG, "updateInteractionState: " + this.$state);
            IStatable r2 = this.$state;
            if ((r2 instanceof SessionLifecycleState) == false) goto L19;
            z0<SessionLifecycleState> r12 = InteractionStateServiceImpl.INSTANCE.getSessionLifecycleState();
            IStatable r3 = this.$state;
            this.label = 1;
            if (r12.emit(r3, this) != r0) goto L40;
            return r0;
        L19:
            if ((r2 instanceof AssistantActivityExpandState) == false) goto L24;
            z0<AssistantActivityExpandState> r13 = InteractionStateServiceImpl.INSTANCE.getActivityExpandState();
            IStatable r4 = this.$state;
            this.label = 2;
            if (r13.emit(r4, this) != r0) goto L40;
            return r0;
        L24:
            if ((r2 instanceof KeyguardLockedState) == false) goto L29;
            z0<KeyguardLockedState> r14 = InteractionStateServiceImpl.INSTANCE.getKeyguardLockedState();
            IStatable r5 = this.$state;
            this.label = 3;
            if (r14.emit(r5, this) != r0) goto L40;
            return r0;
        L29:
            if ((r2 instanceof AssistantActivityVisibleState) == false) goto L34;
            z0<AssistantActivityVisibleState> r15 = InteractionStateServiceImpl.INSTANCE.getActivityVisibleState();
            IStatable r6 = this.$state;
            this.label = 4;
            if (r15.emit(r6, this) != r0) goto L40;
            return r0;
        L34:
            if ((r2 instanceof MicMuteState) == false) goto L38;
            z0<MicMuteState> r16 = InteractionStateServiceImpl.INSTANCE.getMicMuteState();
            IStatable r7 = this.$state;
            this.label = 5;
            if (r16.emit(r7, this) != r0) goto L40;
            return r0;
        L38:
            r11.e(InteractionStateServiceImpl.TAG, "updateInteractionState: unknown state: " + this.$state + " or is not IStatable");
            goto L40
        }
    }

    private InteractionStateServiceImpl() {
    }

    public static /* synthetic */ void a(Function2 r0, Object r1, Object r2) {
        start$lambda$23$lambda$22(r0, r1, r2);
    }

    public static /* synthetic */ Unit b(MicMuteState r0) {
        return start$lambda$23(r0);
    }

    public static /* synthetic */ Unit c(AssistantActivityVisibleState r0, IObserveToken r1, Function1 r2) {
        return start$lambda$11$lambda$9(r0, r1, r2);
    }

    public static /* synthetic */ AppletExtService d() {
        return appletExtService_delegate$lambda$0();
    }

    public static /* synthetic */ void e(Function2 r0, Object r1, Object r2) {
        start$lambda$14$lambda$13(r0, r1, r2);
    }

    public static /* synthetic */ void f(Function2 r0, Object r1, Object r2) {
        start$lambda$17$lambda$16(r0, r1, r2);
    }

    public static /* synthetic */ boolean g(CustomBarAction r0, CustomBarAction r1) {
        return addCustomBarAction$lambda$3$lambda$2(r0, r1);
    }

    public static /* synthetic */ Unit h(KeyguardLockedState r0, IObserveToken r1, Function1 r2) {
        return start$lambda$20$lambda$18(r0, r1, r2);
    }

    public static /* synthetic */ Unit i(KeyguardLockedState r0) {
        return start$lambda$20(r0);
    }

    public static /* synthetic */ Unit j(AssistantActivityVisibleState r0) {
        return start$lambda$11(r0);
    }

    public static /* synthetic */ Unit k(SessionLifecycleState r0) {
        return start$lambda$17(r0);
    }

    public static /* synthetic */ boolean l(Collection r0, CustomBarAction r1) {
        return removeCustomBarActions$lambda$5(r0, r1);
    }

    public static /* synthetic */ Unit m(MicMuteState r0, IObserveToken r1, Function1 r2) {
        return start$lambda$23$lambda$21(r0, r1, r2);
    }

    public static /* synthetic */ Unit n(SessionLifecycleState r0, IObserveToken r1, Function1 r2) {
        return start$lambda$17$lambda$15(r0, r1, r2);
    }

    public static /* synthetic */ void o(Function2 r0, Object r1, Object r2) {
        start$lambda$20$lambda$19(r0, r1, r2);
    }

    public static /* synthetic */ Unit p(AssistantActivityExpandState r0, IObserveToken r1, Function1 r2) {
        return start$lambda$14$lambda$12(r0, r1, r2);
    }

    public static /* synthetic */ void q(Function2 r0, Object r1, Object r2) {
        start$lambda$11$lambda$10(r0, r1, r2);
    }

    public static /* synthetic */ Unit r(AssistantActivityExpandState r0) {
        return start$lambda$14(r0);
    }

    public void release() {
        context = null;
    }

    static {
        INSTANCE = new InteractionStateServiceImpl();
        mainScope = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain());
        jobs = new ArrayList();
        sessionLifecycleState = j1.a(SessionLifecycleState.NA);
        micMuteState = j1.a(MicMuteState.NA);
        keyguardLockedState = j1.a(KeyguardLockedState.UNLOCKED);
        activityExpandState = j1.a(AssistantActivityExpandState.NA);
        activityVisibleState = j1.a(AssistantActivityVisibleState.NA);
        _soundEffectState = j1.a(TuplesKt.to(Boolean.FALSE, ""));
        sessionLifecycleStateObservers = new ConcurrentHashMap();
        activityExpandStateObservers = new ConcurrentHashMap();
        activityVisibleStateObservers = new ConcurrentHashMap();
        keyguardLockedStateObservers = new ConcurrentHashMap();
        micMuteStateObservers = new ConcurrentHashMap();
        obricRealtimeCallStateService = ObricRealtimeCallStateServiceDelegate.b;
        actionsList = new ArrayList();
        customBarActionStateObservers = new ConcurrentHashMap();
        autoIncreaseWindowObservers = new LinkedHashMap();
        wakeupPkg = new AtomicReference(IInteractionStateService.WAKE_UP_SOURCE_OTHER);
        wakeupSource = new AtomicReference(IInteractionStateService.WAKE_UP_SOURCE_OTHER);
        wakeupData = new SparseArray();
        appletExtService$delegate = LazyKt.lazy(new k());
        LinkedHashMap r0 = new LinkedHashMap();
        KtUtils r1 = KtUtils.INSTANCE;
        r1.setScope(Reflection.getOrCreateKotlinClass(SessionLifecycleState.class), r0);
        r1.setScope(Reflection.getOrCreateKotlinClass(AssistantActivityExpandState.class), r0);
        r1.setScope(Reflection.getOrCreateKotlinClass(KeyguardLockedState.class), r0);
        r1.setScope(Reflection.getOrCreateKotlinClass(AssistantActivityVisibleState.class), r0);
        r1.setScope(Reflection.getOrCreateKotlinClass(MicMuteState.class), r0);
        scopeMaps = r0;
    }

    private static final AppletExtService appletExtService_delegate$lambda$0() {
        return (AppletExtService) ServiceManager.get().getService(AppletExtService.class);
    }

    private final AppletExtService getAppletExtService() {
        return (AppletExtService) appletExtService$delegate.getValue();
    }

    @Override // com.obric.assistant.interaction.api.service.IInteractionStateService
    public void endCall() {
        CoroutineScope r1 = scopeMaps.get(Reflection.getOrCreateKotlinClass(MicMuteState.class));
        if (r1 == null) goto L6;
        BuildersKt.launch$default(r1, null, null, new endCall.1(null), 3, null);
        return;
    }

    @Override // com.obric.assistant.interaction.api.service.IInteractionStateService
    public ArrayList<CustomBarAction> getCustomBarActions() {
        return new ArrayList(actionsList);
    }

    @Override // com.obric.assistant.interaction.api.service.IInteractionStateService
    public AssistantActivityExpandState getInteractionActivityExpandState() {
        return (AssistantActivityExpandState) activityExpandState.getValue();
    }

    @Override // com.obric.assistant.interaction.api.service.IInteractionStateService
    public AssistantActivityVisibleState getInteractionActivityVisibleState() {
        return (AssistantActivityVisibleState) activityVisibleState.getValue();
    }

    @Override // com.obric.assistant.interaction.api.service.IInteractionStateService
    public KeyguardLockedState getInteractionKeyguardLockedState() {
        return (KeyguardLockedState) keyguardLockedState.getValue();
    }

    @Override // com.obric.assistant.interaction.api.service.IInteractionStateService
    public SessionLifecycleState getInteractionSessionLifecycleState() {
        return (SessionLifecycleState) sessionLifecycleState.getValue();
    }

    @Override // com.obric.assistant.interaction.api.service.IInteractionStateService
    public String getWakeUpAppPkg() {
        return wakeupPkg.get();
    }

    @Override // com.obric.assistant.interaction.api.service.IInteractionStateService
    public String getWakeUpSource() {
        return wakeupSource.get();
    }

    @Override // com.obric.assistant.interaction.api.service.IInteractionStateService
    public boolean isDefiniteWakeUpSource() {
        String r0 = wakeupSource.get();
        if (r0 != null) goto L5;
    L8:
        boolean r3 = true;
    L9:
        if (r3 == false) goto L11;
        return false;
    L11:
        if (Intrinsics.areEqual(r0, IInteractionStateService.WAKE_UP_SOURCE_OTHER) == false) goto L13;
        return false;
    L13:
        if (Intrinsics.areEqual(r0, IInteractionStateService.WAKE_UP_SOURCE_UNKNOWN) == true) goto L18;
        return true;
    L18:
        return false;
    L5:
        if (r0.length() == 0) goto L8;
        r3 = false;
        goto L9
    }

    public boolean isTtsStopped() {
        return TtsClientDelegate.b.isTtsStopped();
    }

    @Override // com.obric.assistant.interaction.api.service.IInteractionStateService
    public void muteMic() {
        CoroutineScope r1 = scopeMaps.get(Reflection.getOrCreateKotlinClass(MicMuteState.class));
        if (r1 == null) goto L6;
        BuildersKt.launch$default(r1, null, null, new muteMic.1(null), 3, null);
        return;
    }

    @Override // com.obric.assistant.interaction.api.service.IInteractionStateService
    public void resetWakeupData() {
        SparseArray<Object> r0 = wakeupData;
        if (r0.size() <= 0) goto L6;
        r0.clear();
        return;
    }

    @Override // com.obric.assistant.interaction.api.service.IInteractionStateService
    public void resetWakeupSource() {
        wakeupSource.set(IInteractionStateService.WAKE_UP_SOURCE_OTHER);
    }

    public void start() {
        if (Build.VERSION.SDK_INT < 24) goto L6;
        observe(activityVisibleState, new n());
        observe(activityExpandState, new o());
        observe(sessionLifecycleState, new p());
        observe(keyguardLockedState, new q());
        observe(micMuteState, new r());
        return;
    }

    public void startTtsPlay() {
        CoroutineScope r1 = scopeMaps.get(Reflection.getOrCreateKotlinClass(MicMuteState.class));
        if (r1 == null) goto L6;
        BuildersKt.launch$default(r1, null, null, new startTtsPlay.1(null), 3, null);
        return;
    }

    public void stop() {
        Iterator<T> r0 = jobs.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        Job.DefaultImpls.cancel$default((Job) r0.next(), null, 1, null);
        goto L4
    L6:
        jobs.clear();
    }

    @Override // com.obric.assistant.interaction.api.service.IInteractionStateService
    public void stopTtsPlay() {
        TtsClientDelegate.b.cancel("InteractionStateService.stopTtsPlay", false);
    }

    @Override // com.obric.assistant.interaction.api.service.IInteractionStateService
    public void unMuteMic() {
        CoroutineScope r1 = scopeMaps.get(Reflection.getOrCreateKotlinClass(MicMuteState.class));
        if (r1 == null) goto L6;
        BuildersKt.launch$default(r1, null, null, new unMuteMic.1(null), 3, null);
        return;
    }

    private final void notifyCustomActionBar() {
        ArrayList<CustomBarAction> r0 = getCustomBarActions();
        List r1 = CollectionsKt.toList(customBarActionStateObservers.values());
        BuildersKt.launch$default(mainScope, null, null, new notifyCustomActionBar.1(r1, r0, null), 3, null);
    }

    public void restartTtsPlay() {
        stopTtsPlay();
        startTtsPlay();
    }

    public static final /* synthetic */ Map access$getAutoIncreaseWindowObservers$p() {
        return autoIncreaseWindowObservers;
    }

    public static final /* synthetic */ ObricRealtimeCallStateServiceDelegate access$getObricRealtimeCallStateService$p() {
        return obricRealtimeCallStateService;
    }

    public static final /* synthetic */ AtomicReference access$getWakeupPkg$p() {
        return wakeupPkg;
    }

    public final z0<AssistantActivityExpandState> getActivityExpandState() {
        return activityExpandState;
    }

    public final z0<AssistantActivityVisibleState> getActivityVisibleState() {
        return activityVisibleState;
    }

    public final z0<KeyguardLockedState> getKeyguardLockedState() {
        return keyguardLockedState;
    }

    public final CoroutineScope getMainScope() {
        return mainScope;
    }

    public final z0<MicMuteState> getMicMuteState() {
        return micMuteState;
    }

    @Override // com.obric.assistant.interaction.api.service.IInteractionStateService
    public z0<Pair<Boolean, String>> getPreSoundEffectState() {
        return _soundEffectState;
    }

    public final Map<KClass<?>, CoroutineScope> getScopeMaps() {
        return scopeMaps;
    }

    public final z0<SessionLifecycleState> getSessionLifecycleState() {
        return sessionLifecycleState;
    }

    public final z0<Pair<Boolean, String>> get_soundEffectState() {
        return _soundEffectState;
    }

    public static boolean INVOKEVIRTUAL_com_obric_assistant_interaction_impl_service_InteractionStateServiceImpl_com_larus_home_impl_utils_DecorViewLancet_hasWindowFocus(Activity r3) {
        boolean r4 = r3.hasWindowFocus();
        if (com.larus.home.impl.utils.c.e == false) goto L7;
        FLogger.a.i("DecorViewLancet", "hasWindowFocus");
        Thread r0 = ThreadMethodProxy.currentThread();
        if (r0 == com.larus.home.impl.utils.c.a) goto L7;
        com.larus.home.impl.utils.c.a(r0, "hasWindowFocus");
    L7:
        return r4;
    }

    private final boolean handleWakeupSourceOnAssistantPage(String r6) {
        AppHost.Companion r0 = AppHost.a;
        if (Intrinsics.areEqual(r6, r0.getApplication().getPackageName()) == false) goto L21;
        Activity r7 = r0.a().getCurrentActivity();
        String r1 = null;
        if (r7 == null) goto L7;
        Activity r8 = findPreviousIfChatWindow(r7);
    L8:
        if (r8 == null) goto L21;
        InteractionStateServiceImpl r2 = INSTANCE;
        AppletExtService r3 = r2.getAppletExtService();
        if (r3 != null) goto L12;
    L14:
        boolean r4 = false;
    L15:
        if (r4 == false) goto L21;
        AppletExtService r5 = r2.getAppletExtService();
        if (r5 == null) goto L19;
        r1 = r5.g(r8);
    L19:
        FLogger.a.d(TAG, "handleWakeupSourceOnAssistantPage by MiniApp " + r8.getClass().getSimpleName() + " appletId " + r1 + ' ');
        wakeupPkg.set(r1);
        return true;
    L12:
        if (r3.o(r8) != true) goto L14;
        r4 = true;
        goto L15
    L7:
        r8 = null;
    L21:
        return false;
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [com.obric.assistant.interaction.impl.service.c] */
    private static final Unit start$lambda$11(final AssistantActivityVisibleState r3) {
        Intrinsics.checkNotNullParameter(r3, "it");
        FLogger.a.d(TAG, "activityVisibleState changed: " + r3);
        activityVisibleStateObservers.forEach(new l(new c(r3)));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [com.obric.assistant.interaction.impl.service.f] */
    private static final Unit start$lambda$14(final AssistantActivityExpandState r3) {
        Intrinsics.checkNotNullParameter(r3, "it");
        FLogger.a.d(TAG, "activityExpandState changed: " + r3);
        activityExpandStateObservers.forEach(new g(new f(r3)));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [com.obric.assistant.interaction.impl.service.d] */
    private static final Unit start$lambda$17(final SessionLifecycleState r3) {
        Intrinsics.checkNotNullParameter(r3, "it");
        FLogger.a.d(TAG, "sessionLifecycleState changed: " + r3);
        sessionLifecycleStateObservers.forEach(new e(new d(r3)));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [com.obric.assistant.interaction.impl.service.i] */
    private static final Unit start$lambda$20(final KeyguardLockedState r3) {
        Intrinsics.checkNotNullParameter(r3, "it");
        FLogger.a.d(TAG, "keyguardLockedState changed: " + r3);
        keyguardLockedStateObservers.forEach(new j(new i(r3)));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [com.obric.assistant.interaction.impl.service.s] */
    private static final Unit start$lambda$23(final MicMuteState r3) {
        Intrinsics.checkNotNullParameter(r3, "it");
        FLogger.a.d(TAG, "micMuteState changed: " + r3);
        micMuteStateObservers.forEach(new t(new s(r3)));
        return Unit.INSTANCE;
    }

    @Override // com.obric.assistant.interaction.api.service.IInteractionStateService
    public void addCustomBarAction(CustomBarAction r8) {
        Intrinsics.checkNotNullParameter(r8, "action");
        List<CustomBarAction> r1 = actionsList;
        ArrayList r0 = new ArrayList(r1);
        CollectionsKt.removeAll(r1, new h(r8));
        if (r1.isEmpty() == false) goto L5;
        r1.add(r8);
    L26:
        FLogger.a.i(TAG, "addCustomBarAction: " + r8 + " list: " + r1);
        if (Intrinsics.areEqual(r0, r1) == true) goto L30;
        notifyCustomActionBar();
        return;
    L30:
        return;
    L5:
        String r4 = null;
        if (Intrinsics.areEqual(r8.getKey(), "obric_screen_qa") == false) goto L17;
        if (r1.size() != 1) goto L17;
        CustomBarAction r2 = (CustomBarAction) CollectionsKt.firstOrNull(r1);
        if (r2 == null) goto L12;
        String r3 = r2.getKey();
    L14:
        if (Intrinsics.areEqual(r3, "obric_video_perception") == false) goto L17;
        ListProtector.add(r1, 0, r8);
        goto L26
    L12:
        r3 = null;
    L17:
        if (Intrinsics.areEqual(r8.getKey(), "obric_video_perception") == false) goto L26;
        if (r1.size() != 1) goto L26;
        CustomBarAction r5 = (CustomBarAction) CollectionsKt.firstOrNull(r1);
        if (r5 == null) goto L24;
        r4 = r5.getKey();
    L24:
        if (Intrinsics.areEqual(r4, "obric_screen_qa") == false) goto L26;
        r1.add(r8);
        goto L26
    }

    @Override // com.obric.assistant.interaction.api.service.IInteractionStateService
    public void clearCustomBarActions(boolean r9) {
        List<CustomBarAction> r1 = actionsList;
        ArrayList r0 = new ArrayList(r1);
        FLogger r2 = FLogger.a;
        r2.d(TAG, "clearCustomBarActions: " + r1);
        r1.clear();
        if (r9 == false) goto L5;
        r2.d(TAG, "clear tempList");
        r0.clear();
    L5:
        AppHost.Companion r10 = AppHost.a;
        if (r10.a().isAppBackground() == false) goto L9;
        r2.d(TAG, "interruptMovingBackground: app is in background, no need to interrupt");
        return;
    L9:
        LifecycleOwner r11 = r10.a().getCurrentActivity();
        if (r11 != null) goto L14;
        r2.d(TAG, "interruptMovingBackground: no current activity");
        return;
    L14:
        if ((r11 instanceof LifecycleOwner) == true) goto L16;
    L19:
        IOAutoApi r3 = com.obric.assistant.oauto.b.a();
        boolean r5 = true;
        if (r3 != null) goto L22;
    L24:
        boolean r4 = false;
    L25:
        if (r4 == false) goto L29;
        r2.d(TAG, "interruptMovingBackground: assistant is in oauto, no need to interrupt");
        return;
    L29:
        if (INVOKEVIRTUAL_com_obric_assistant_interaction_impl_service_InteractionStateServiceImpl_com_larus_home_impl_utils_DecorViewLancet_hasWindowFocus(r11) == false) goto L31;
        r2.d(TAG, "interruptMovingBackground: has window focus, no need to interrupt");
    L31:
        AppletExtService r6 = (AppletExtService) ServiceManager.get().getService(AppletExtService.class);
        if (r6 != null) goto L34;
    L36:
        r5 = false;
    L37:
        if (r5 == false) goto L40;
        r2.d(TAG, "interruptMovingBackground: current activity is mini app");
        return;
    L40:
        r2.d(TAG, "interruptMovingBackground: revert clear action bar list");
        r1.addAll(r0);
        return;
    L34:
        if (r6.o(r11) != true) goto L36;
    L22:
        if (r3.b() != true) goto L24;
        r4 = true;
        goto L25
    L16:
        if (r11.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.RESUMED) == true) goto L19;
        r2.d(TAG, "interruptMovingBackground: current activity is not resumed, no need to interrupt");
    }

    public final Activity findPreviousIfChatWindow(Activity r3) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        t1a.b r0 = ObricChatContextServiceDelegate.b.b(r3);
        if (r0 == null) goto L9;
        laa.d r1 = r0.getAbility(laa.d.class);
        if (r1 == null) goto L9;
        boolean r2 = true;
        if (r1.JY() != true) goto L9;
    L10:
        if (r2 == false) goto L16;
        Activity r4 = AppHost.a.a().a(r3, null);
        if (r4 != null) goto L15;
        return r3;
    L15:
        return r4;
    L16:
        return r3;
    L9:
        r2 = false;
        goto L10
    }

    @Override // com.obric.assistant.interaction.api.service.IInteractionStateService
    public <T> T getWakeUpData(int r2) {
        T r3 = (T) wakeupData.get(r2);
        if (r3 != null) goto L6;
        return null;
    L6:
        return r3;
    }

    public void init(Context r1) {
        context = r1;
    }

    @Override // com.obric.assistant.interaction.api.service.IInteractionStateService
    public void removeAutoIncreaseWindowObserver(IObserveToken r8) {
        Intrinsics.checkNotNullParameter(r8, "token");
        BuildersKt.launch$default(mainScope, null, null, new removeAutoIncreaseWindowObserver.1(r8, null), 3, null);
    }

    @Override // com.obric.assistant.interaction.api.service.IInteractionStateService
    public void removeCustomBarActions(Collection<String> r5) {
        Intrinsics.checkNotNullParameter(r5, "keys");
        FLogger r0 = FLogger.a;
        StringBuilder r1 = new StringBuilder("removeCustomBarActions: keys=");
        r1.append(r5);
        r1.append(", before=");
        List<CustomBarAction> r2 = actionsList;
        r1.append(r2);
        r0.d(TAG, r1.toString());
        if (r5.isEmpty() == false) goto L5;
        return;
    L5:
        CollectionsKt.removeAll(r2, new m(r5));
        r0.d(TAG, "removeCustomBarActions: after=" + r2);
    }

    @Override // com.obric.assistant.interaction.api.service.IInteractionStateService
    public void setAutoIncreaseWindow(boolean r7) {
        BuildersKt.launch$default(mainScope, null, null, new setAutoIncreaseWindow.1(r7, null), 3, null);
    }

    @Override // com.obric.assistant.interaction.api.service.IInteractionStateService
    public void setWakeUpSource(String r2) {
        Intrinsics.checkNotNullParameter(r2, "source");
        wakeupSource.set(r2);
    }

    @Override // com.obric.assistant.interaction.api.service.IInteractionStateService
    public void unObserveCustomBarActionsState(IObserveToken r6) {
        Intrinsics.checkNotNullParameter(r6, "token");
        ConcurrentHashMap<IObserveToken, Function1<ArrayList<CustomBarAction>, Unit>> r0 = customBarActionStateObservers;
        Function1<ArrayList<CustomBarAction>, Unit> r1 = r0.get(r6);
        FLogger.a.d(TAG, "unObserveCustomBarActionsState: " + r6 + ", " + r1);
        r0.remove(r6);
    }

    @Override // com.obric.assistant.interaction.api.service.IInteractionStateService
    public void unObserveInteractionActivityExpandState(IObserveToken r6) {
        Intrinsics.checkNotNullParameter(r6, "token");
        ConcurrentHashMap<IObserveToken, Function1<AssistantActivityExpandState, Unit>> r0 = activityExpandStateObservers;
        Function1<AssistantActivityExpandState, Unit> r1 = r0.get(r6);
        FLogger.a.d(TAG, "unObserveInteractionActivityExpandState: " + r6 + ", " + r1);
        if (r1 == null) goto L6;
        r0.remove(r6);
        return;
    }

    @Override // com.obric.assistant.interaction.api.service.IInteractionStateService
    public void unObserveInteractionActivityVisibleState(IObserveToken r6) {
        Intrinsics.checkNotNullParameter(r6, "token");
        ConcurrentHashMap<IObserveToken, Function1<AssistantActivityVisibleState, Unit>> r0 = activityVisibleStateObservers;
        Function1<AssistantActivityVisibleState, Unit> r1 = r0.get(r6);
        FLogger.a.d(TAG, "unObserveInteractionActivityVisibleState: " + r6 + ", " + r1);
        if (r1 == null) goto L6;
        r0.remove(r6);
        return;
    }

    @Override // com.obric.assistant.interaction.api.service.IInteractionStateService
    public void unObserveInteractionKeyguardLockedState(IObserveToken r6) {
        Intrinsics.checkNotNullParameter(r6, "token");
        ConcurrentHashMap<IObserveToken, Function1<KeyguardLockedState, Unit>> r0 = keyguardLockedStateObservers;
        Function1<KeyguardLockedState, Unit> r1 = r0.get(r6);
        FLogger.a.d(TAG, "unObserveInteractionKeyGuardLockedState: " + r6 + ", " + r1);
        if (r1 == null) goto L6;
        r0.remove(r6);
        return;
    }

    @Override // com.obric.assistant.interaction.api.service.IInteractionStateService
    public void unObserveInteractionSessionLifecycleState(IObserveToken r6) {
        Intrinsics.checkNotNullParameter(r6, "token");
        ConcurrentHashMap<IObserveToken, Function1<SessionLifecycleState, Unit>> r0 = sessionLifecycleStateObservers;
        Function1<SessionLifecycleState, Unit> r1 = r0.get(r6);
        FLogger.a.d(TAG, "unObserveInteractionState: " + r6 + ", " + r1);
        if (r1 == null) goto L6;
        r0.remove(r6);
        return;
    }

    @Override // com.obric.assistant.interaction.api.service.IInteractionStateService
    public void unObserveMicMuteState(IObserveToken r6) {
        Intrinsics.checkNotNullParameter(r6, "token");
        ConcurrentHashMap<IObserveToken, Function1<MicMuteState, Unit>> r0 = micMuteStateObservers;
        Function1<MicMuteState, Unit> r1 = r0.get(r6);
        FLogger.a.d(TAG, "unObserveMicMuteState: " + r6 + ", " + r1);
        r0.remove(r6);
    }

    public final /* synthetic */ <T extends IStatable> void updateInteractionState(T r10) {
        Intrinsics.checkNotNullParameter(r10, "state");
        KtUtils r0 = KtUtils.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "T");
        BuildersKt.launch$default(r0.getScope(Reflection.getOrCreateKotlinClass(IStatable.class), getScopeMaps()), null, null, new C00371(r10, null), 3, null);
    }

    public static final /* synthetic */ boolean access$handleWakeupSourceOnAssistantPage(InteractionStateServiceImpl r0, String r1) {
        return r0.handleWakeupSourceOnAssistantPage(r1);
    }

    private static final boolean addCustomBarAction$lambda$3$lambda$2(CustomBarAction r3, CustomBarAction r4) {
        Intrinsics.checkNotNullParameter(r4, "it");
        String r0 = r3.getKey();
        if (Intrinsics.areEqual(r0, "obric_screen_qa") == false) goto L6;
        return Intrinsics.areEqual(r4.getKey(), "obric_screen_qa");
    L6:
        if (Intrinsics.areEqual(r0, "obric_video_perception") == false) goto L9;
        return Intrinsics.areEqual(r4.getKey(), "obric_video_perception");
    L9:
        if (Intrinsics.areEqual(r4.getKey(), r3.getKey()) == false) goto L11;
    L16:
        return true;
    L11:
        if (Intrinsics.areEqual(r4.getKey(), "obric_screen_qa") == true) goto L16;
        if (Intrinsics.areEqual(r4.getKey(), "obric_video_perception") == true) goto L16;
        return false;
    }

    private final <T> void observe(z0<T> r8, Function1<? super T, Unit> r9) {
        Job r10 = BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new AnonymousClass1(r8, r9, null), 3, null);
        jobs.add(r10);
    }

    private static final boolean removeCustomBarActions$lambda$5(Collection r1, CustomBarAction r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        return r1.contains(r2.getKey());
    }

    @Override // com.obric.assistant.interaction.api.service.IInteractionStateService
    public void observeCustomBarActionsState(IObserveToken r6, Function1<? super ArrayList<CustomBarAction>, Unit> r7) {
        Intrinsics.checkNotNullParameter(r6, "token");
        Intrinsics.checkNotNullParameter(r7, "callback");
        ConcurrentHashMap<IObserveToken, Function1<ArrayList<CustomBarAction>, Unit>> r0 = customBarActionStateObservers;
        Function1<ArrayList<CustomBarAction>, Unit> r1 = r0.get(r6);
        FLogger.a.d(TAG, "observeCustomBarActionsState: " + r6 + ", " + r1);
        r0.put(r6, r7);
    }

    @Override // com.obric.assistant.interaction.api.service.IInteractionStateService
    public void observeInteractionActivityExpandState(IObserveToken r6, Function1<? super AssistantActivityExpandState, Unit> r7) {
        Intrinsics.checkNotNullParameter(r6, "token");
        Intrinsics.checkNotNullParameter(r7, "callback");
        ConcurrentHashMap<IObserveToken, Function1<AssistantActivityExpandState, Unit>> r0 = activityExpandStateObservers;
        Function1<AssistantActivityExpandState, Unit> r1 = r0.get(r6);
        FLogger.a.d(TAG, "observeInteractionActivityExpandState: " + r6 + ", " + r1);
        r0.put(r6, r7);
    }

    @Override // com.obric.assistant.interaction.api.service.IInteractionStateService
    public void observeInteractionActivityVisibleState(IObserveToken r6, Function1<? super AssistantActivityVisibleState, Unit> r7) {
        Intrinsics.checkNotNullParameter(r6, "token");
        Intrinsics.checkNotNullParameter(r7, "callback");
        ConcurrentHashMap<IObserveToken, Function1<AssistantActivityVisibleState, Unit>> r0 = activityVisibleStateObservers;
        Function1<AssistantActivityVisibleState, Unit> r1 = r0.get(r6);
        FLogger.a.d(TAG, "observeInteractionActivityVisibleState: " + r6 + ", " + r1);
        r0.put(r6, r7);
    }

    @Override // com.obric.assistant.interaction.api.service.IInteractionStateService
    public void observeInteractionKeyguardLockedState(IObserveToken r6, Function1<? super KeyguardLockedState, Unit> r7) {
        Intrinsics.checkNotNullParameter(r6, "token");
        Intrinsics.checkNotNullParameter(r7, "callback");
        ConcurrentHashMap<IObserveToken, Function1<KeyguardLockedState, Unit>> r0 = keyguardLockedStateObservers;
        Function1<KeyguardLockedState, Unit> r1 = r0.get(r6);
        FLogger.a.d(TAG, "observeInteractionKeyGuardLockedState: " + r6 + ", " + r1);
        r0.put(r6, r7);
    }

    @Override // com.obric.assistant.interaction.api.service.IInteractionStateService
    public void observeInteractionSessionLifecycleState(IObserveToken r6, Function1<? super SessionLifecycleState, Unit> r7) {
        Intrinsics.checkNotNullParameter(r6, "token");
        Intrinsics.checkNotNullParameter(r7, "callback");
        ConcurrentHashMap<IObserveToken, Function1<SessionLifecycleState, Unit>> r0 = sessionLifecycleStateObservers;
        Function1<SessionLifecycleState, Unit> r1 = r0.get(r6);
        FLogger.a.d(TAG, "observeInteractionSessionLifecycleState: " + r6 + ", " + r1);
        r0.put(r6, r7);
    }

    @Override // com.obric.assistant.interaction.api.service.IInteractionStateService
    public void observeMicMuteState(IObserveToken r6, Function1<? super MicMuteState, Unit> r7) {
        Intrinsics.checkNotNullParameter(r6, "token");
        Intrinsics.checkNotNullParameter(r7, "callback");
        ConcurrentHashMap<IObserveToken, Function1<MicMuteState, Unit>> r0 = micMuteStateObservers;
        Function1<MicMuteState, Unit> r1 = r0.get(r6);
        FLogger.a.d(TAG, "observeMicMuteState: " + r6 + ", " + r1);
        r0.put(r6, r7);
    }

    @Override // com.obric.assistant.interaction.api.service.IInteractionStateService
    public void setAutoIncreaseWindowObserver(IObserveToken r8, Function1<? super Boolean, Unit> r9) {
        Intrinsics.checkNotNullParameter(r8, "token");
        Intrinsics.checkNotNullParameter(r9, "observer");
        BuildersKt.launch$default(mainScope, null, null, new setAutoIncreaseWindowObserver.1(r8, r9, null), 3, null);
    }

    @Override // com.obric.assistant.interaction.api.service.IInteractionStateService
    public void setWakeUpAppPkg(String r8, String r9) {
        Intrinsics.checkNotNullParameter(r8, "pkg");
        Intrinsics.checkNotNullParameter(r9, "reason");
        BuildersKt.launch$default(mainScope, null, null, new setWakeUpAppPkg.1(r8, r9, null), 3, null);
    }

    @Override // com.obric.assistant.interaction.api.service.IInteractionStateService
    public <T> void setWakeUpData(int r2, T r3) {
        wakeupData.put(r2, r3);
    }

    private static final void start$lambda$11$lambda$10(Function2 r0, Object r1, Object r2) {
        r0.invoke(r1, r2);
    }

    private static final Unit start$lambda$11$lambda$9(AssistantActivityVisibleState r1, IObserveToken r2, Function1 r3) {
        Intrinsics.checkNotNullParameter(r2, "<unused var>");
        if (r3 == null) goto L6;
        r3.invoke(r1);
    L6:
        return Unit.INSTANCE;
    }

    private static final Unit start$lambda$14$lambda$12(AssistantActivityExpandState r1, IObserveToken r2, Function1 r3) {
        Intrinsics.checkNotNullParameter(r2, "<unused var>");
        if (r3 == null) goto L6;
        r3.invoke(r1);
    L6:
        return Unit.INSTANCE;
    }

    private static final void start$lambda$14$lambda$13(Function2 r0, Object r1, Object r2) {
        r0.invoke(r1, r2);
    }

    private static final Unit start$lambda$17$lambda$15(SessionLifecycleState r1, IObserveToken r2, Function1 r3) {
        Intrinsics.checkNotNullParameter(r2, "<unused var>");
        if (r3 == null) goto L6;
        r3.invoke(r1);
    L6:
        return Unit.INSTANCE;
    }

    private static final void start$lambda$17$lambda$16(Function2 r0, Object r1, Object r2) {
        r0.invoke(r1, r2);
    }

    private static final Unit start$lambda$20$lambda$18(KeyguardLockedState r1, IObserveToken r2, Function1 r3) {
        Intrinsics.checkNotNullParameter(r2, "<unused var>");
        if (r3 == null) goto L6;
        r3.invoke(r1);
    L6:
        return Unit.INSTANCE;
    }

    private static final void start$lambda$20$lambda$19(Function2 r0, Object r1, Object r2) {
        r0.invoke(r1, r2);
    }

    private static final Unit start$lambda$23$lambda$21(MicMuteState r1, IObserveToken r2, Function1 r3) {
        Intrinsics.checkNotNullParameter(r2, "<unused var>");
        if (r3 == null) goto L6;
        r3.invoke(r1);
    L6:
        return Unit.INSTANCE;
    }

    private static final void start$lambda$23$lambda$22(Function2 r0, Object r1, Object r2) {
        r0.invoke(r1, r2);
    }
}
