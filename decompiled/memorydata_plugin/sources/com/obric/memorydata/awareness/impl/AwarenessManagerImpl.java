package com.obric.memorydata.awareness.impl;

import com.bytedance.bdlocation.monitor.InfoRequestQPSOptTraceLogger;
import com.bytedance.common.wschannel.WsConstants;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.aikernel.runtime.AIInferRuntime;
import com.obric.memorydata.aikernelcore.MemoryScriptEngineEnv;
import com.obric.memorydata.awareness.api.FeatureManager;
import com.obric.memorydata.awareness.api.IAwarenessManager;
import com.obric.memorydata.awareness.impl.data.AwarenessEventTriggerConfig;
import com.obric.memorydata.awareness.impl.data.CronConfig;
import com.obric.memorydata.awareness.impl.data.FeatureDurationTriggeredConfig;
import com.obric.memorydata.awareness.impl.data.PapayaConfig;
import com.obric.memorydata.awareness.impl.data.TaskConfig;
import com.obric.memorydata.awareness.impl.data.TimerConfig;
import com.obric.memorydata.awareness.location.LocationProcessor;
import com.obric.memorydata.memory.api.MemoryService;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.middleware.api.logging.o;
import com.obric.memorydata.middleware.api.store.IStoreManager;
import com.obric.memorydata.middleware.api.store.StoreManager;
import com.obric.memorydata.task.condition.Condition;
import com.obric.memorydata.task.cron.CronJobRunnerTask;
import com.obric.memorydata.task.impl.TaskRequest;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.al;
import kotlinx.coroutines.am;
import kotlinx.coroutines.ba;
import kotlinx.coroutines.cu;
import kotlinx.coroutines.flow.ae;
import kotlinx.coroutines.flow.ar;
import kotlinx.coroutines.flow.at;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010%\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010)\u001a\u00020\u0000H\u0007J\u0010\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020&H\u0016J\u0016\u0010-\u001a\u00020+2\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00050\u0018H\u0002J@\u0010/\u001a\u00020+2\f\u00100\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\u000e\b\u0002\u00101\u001a\b\u0012\u0004\u0012\u00020\u00050\u00182\u0010\b\u0002\u0010.\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00182\u0006\u00102\u001a\u00020&H\u0002J\u0016\u00103\u001a\u00020+2\f\u00100\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0002J\u0010\u00104\u001a\u00020+2\u0006\u0010,\u001a\u00020&H\u0002J\u0010\u00105\u001a\u00020&2\u0006\u00106\u001a\u00020\u0005H\u0016J<\u00107\u001a\u00020+2\f\u00108\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\f\u00109\u001a\b\u0012\u0004\u0012\u00020\u00050\u00182\u000e\u0010.\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00182\u0006\u00102\u001a\u00020&H\u0002J8\u0010:\u001a\b\u0012\u0004\u0012\u00020\u00050\u00182\u0018\u0010;\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020<0\u00140\u00132\u000e\u0010.\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0018H\u0002J\u0016\u0010=\u001a\u00020+2\f\u0010>\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0002J\u0018\u0010?\u001a\u00020+2\u0006\u0010@\u001a\u00020\u00052\u0006\u0010A\u001a\u00020\u0011H\u0016J\u0010\u0010B\u001a\u00020+2\u0006\u0010@\u001a\u00020\u0005H\u0002J\u0018\u0010C\u001a\u00020+2\u0006\u0010@\u001a\u00020\u00052\u0006\u0010A\u001a\u00020\u0011H\u0016J<\u0010D\u001a\u00020+2\u0006\u00106\u001a\u00020\u00052\b\u0010E\u001a\u0004\u0018\u00010F2\b\u0010G\u001a\u0004\u0018\u00010F2\u0016\u0010H\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010F\u0018\u00010\u0013H\u0016J<\u0010I\u001a\u00020+2\u0006\u00106\u001a\u00020\u00052\b\u0010E\u001a\u0004\u0018\u00010F2\b\u0010G\u001a\u0004\u0018\u00010F2\u0016\u0010H\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010F\u0018\u00010\u0013H\u0016J(\u0010J\u001a\u00020+2\u0006\u0010K\u001a\u00020\u00052\u0016\u0010H\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010F\u0018\u00010\u0013H\u0016J(\u0010L\u001a\u00020+2\u0006\u0010K\u001a\u00020\u00052\u0016\u0010H\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010F\u0018\u00010\u0013H\u0016J\u0010\u0010M\u001a\u00020&2\u0006\u0010N\u001a\u00020\u0005H\u0016J\u0016\u0010O\u001a\b\u0012\u0004\u0012\u00020&0P2\u0006\u0010@\u001a\u00020\u0005H\u0016J\u0010\u0010Q\u001a\u00020R2\u0006\u0010@\u001a\u00020\u0005H\u0002J\u001a\u0010S\u001a\u0004\u0018\u00010\u00052\u0006\u0010T\u001a\u00020U2\u0006\u0010V\u001a\u00020UH\u0016J\u001a\u0010W\u001a\u0004\u0018\u00010\u00052\u0006\u0010T\u001a\u00020U2\u0006\u0010V\u001a\u00020UH\u0016J\u0010\u0010X\u001a\n\u0012\u0004\u0012\u00020U\u0018\u00010\u0014H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R \u0010\u000e\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0012\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u00140\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00150\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00050\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00050\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R \u0010#\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020&0%0$X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020(X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006Y"}, d2 = {"Lcom/obric/memorydata/awareness/impl/AwarenessManagerImpl;", "Lcom/obric/memorydata/awareness/api/IAwarenessManager;", "<init>", "()V", "TAG", "", "LOCATION_CONTEXT_STORE_REPO", "KEY_ACTION_TYPE", "ACTION_SUBSCRIBE", "ACTION_QUERY", "KEY_TRIGGER_EVENTS", "KEY_AWARENESS_FEATURE", "FEATURE_DURATION_TRIGGERED", "KEY_TIMER", "awarenessEventListenerMap", "", "", "Lcom/obric/memorydata/awareness/api/EventListener;", "taskEventListenerMap", "", "", "Lcom/obric/aikernel/res/metadata/config/PackageConfig;", "awareEventPkgMap", "lastFeatureDurationPackageSources", "", "lastFeatureDurationFeatures", "awarenessPackageScheduler", "Lcom/obric/memorydata/awareness/impl/AwarenessPackageScheduler;", "locationContextStoreCleared", "Ljava/util/concurrent/atomic/AtomicBoolean;", "packageUpdateScope", "Lkotlinx/coroutines/CoroutineScope;", "autoTriggerFeatureSwitchGate", "Lcom/obric/memorydata/awareness/impl/gate/AutoTriggerFeatureSwitchGate;", "lastPackagesInfo", "hasListenerStateMap", "Ljava/util/concurrent/ConcurrentHashMap;", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "updatePackageInfoMutex", "Lkotlinx/coroutines/sync/Mutex;", "getInst", "updatePackageInfo", "", "firstLaunch", "onAutoTriggerFeatureSwitchChanged", "affectedPackages", "reconcileAutoTriggerResources", "packages", "removedPackages", "runSimpleAwarenessInitialization", "syncPackageCronJobs", "clearLocationContextStoreOnProcessStart", "makeAwarenessFeature", "feature", "parsePackageRegisterInfo", "packagesInfoList", "enabledPackageNames", "replacePackageAwarenessListeners", "newListeners", "Lcom/obric/memorydata/awareness/impl/AwarenessPackageEventListener;", "rescheduleLostTask", "papayaList", "registerAwarenessEvent", "event", "listener", "updateState", "unregisterAwarenessEvent", "onFeatureChanged", "oldValue", "", "newValue", WsConstants.KEY_EXTRA, "onFeatureEvent", "dispatchAwarenessEvent", "eventName", "dispatchTaskEvent", "isPackageAutoTriggerEnabled", ObricMemoryConstants.KEY_PACKAGE_NAME, "observeAnyListener", "Lkotlinx/coroutines/flow/StateFlow;", "countObservableListeners", "", "getAddressByGps", "longitude", "", "latitude", "getCachedAddressByGps", "resolveAtHomeEventLocation", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AwarenessManagerImpl implements IAwarenessManager {
    private static final String ACTION_QUERY = "query";
    public static final String ACTION_SUBSCRIBE = "subscribe";
    private static final String FEATURE_DURATION_TRIGGERED = "feature_duration_triggered";
    public static final AwarenessManagerImpl INSTANCE = null;
    public static final String KEY_ACTION_TYPE = "action_type";
    private static final String KEY_AWARENESS_FEATURE = "awareness_feature";
    private static final String KEY_TIMER = "timer";
    private static final String KEY_TRIGGER_EVENTS = "trigger_events";
    private static final String LOCATION_CONTEXT_STORE_REPO = "location_context_controller";
    private static final String TAG = "AwarenessManager";
    private static final com.obric.memorydata.awareness.impl.gate.a autoTriggerFeatureSwitchGate = null;
    private static volatile Map<String, com.obric.aikernel.res.metadata.config.i> awareEventPkgMap;
    private static final Map<String, List<com.obric.memorydata.awareness.api.a>> awarenessEventListenerMap = null;
    private static final f awarenessPackageScheduler = null;
    private static final ConcurrentHashMap<String, ae<Boolean>> hasListenerStateMap = null;
    private static Set<String> lastFeatureDurationFeatures;
    private static Set<String> lastFeatureDurationPackageSources;
    private static volatile List<com.obric.aikernel.res.metadata.config.i> lastPackagesInfo;
    private static final AtomicBoolean locationContextStoreCleared = null;
    private static final al packageUpdateScope = null;
    private static volatile Map<String, ? extends List<com.obric.aikernel.res.metadata.config.i>> taskEventListenerMap;
    private static final kotlinx.coroutines.sync.a updatePackageInfoMutex = null;

    /* JADX INFO: renamed from: com.obric.memorydata.awareness.impl.AwarenessManagerImpl$onAutoTriggerFeatureSwitchChanged$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.awareness.impl.AwarenessManagerImpl$onAutoTriggerFeatureSwitchChanged$1", f = "AwarenessManagerImpl.kt", i = {0}, l = {719}, m = "invokeSuspend", n = {"$this$withLock_u24default$iv"}, s = {"L$0"})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        final /* synthetic */ Set<String> $affectedPackages;
        Object L$0;
        Object L$1;
        int label;

        AnonymousClass1(Set<String> r3, Continuation<? super AnonymousClass1> r4) {
            Set<String> r5 = (Set) ZeusTransformUtils.wrapperContextForParams(r3, Set.class, "com.obric.memorydata.plugin");
            Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.$affectedPackages = r5;
            super(2, r6);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.$affectedPackages, r4), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super Unit> r4) {
            return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r17) {
            Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r2 = this.label;
            boolean r4 = true;
            if (r2 == 0) goto L8;
            if (r2 != 1) goto L7;
            Set<String> r3 = (Set) ZeusTransformUtils.preCheckCast(this.L$1, Set.class, "com.obric.memorydata.plugin");
            kotlinx.coroutines.sync.a r0 = (kotlinx.coroutines.sync.a) ZeusTransformUtils.preCheckCast(this.L$0, kotlinx.coroutines.sync.a.class, "com.obric.memorydata.plugin");
            ResultKt.throwOnFailure(r17);
            kotlinx.coroutines.sync.a r5 = r0;
            Set<String> r9 = r3;
        L35:
            Iterable r6 = (Iterable) ZeusTransformUtils.preCheckCast(AwarenessManagerImpl.access$getLastPackagesInfo$p(), Iterable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L32
            if (ZeusTransformUtils.instanceOf(r6, Collection.class) == true) goto L15;
        L17:
            Iterator r7 = r6.iterator();     // Catch: Throwable -> L32
        L19:
            if (r7.hasNext() == false) goto L23;
            if (r9.contains(((com.obric.aikernel.res.metadata.config.i) ZeusTransformUtils.preCheckCast(r7.next(), com.obric.aikernel.res.metadata.config.i.class, "com.obric.memorydata.plugin")).a()) == false) goto L19;
            r4 = false;
        L23:
            if (r4 == true) goto L29;
            o r8 = (o) ZeusTransformUtils.preCheckCast(com.obric.memorydata.middleware.api.logging.b.f11611a, o.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L32
            com.obric.memorydata.middleware.api.logging.e r10 = new com.obric.memorydata.middleware.api.logging.e(null, null, null, 7, null);     // Catch: Throwable -> L32
            if (AppContext.INSTANCE.isDebug() == false) goto L28;
            com.obric.memorydata.middleware.api.logging.g r11 = new com.obric.memorydata.middleware.api.logging.g();     // Catch: Throwable -> L32
            r11.a("package_count", Boxing.boxInt(r9.size()));     // Catch: Throwable -> L32
            Unit r12 = Unit.INSTANCE;     // Catch: Throwable -> L32
            r8.a("Feature 开关变化，重建算法包自动触发资源", r10, r11.a());     // Catch: Throwable -> L32
        L28:
            AwarenessManagerImpl.reconcileAutoTriggerResources$default(AwarenessManagerImpl.INSTANCE, AwarenessManagerImpl.access$getLastPackagesInfo$p(), null, r9, false, 2, null);     // Catch: Throwable -> L32
        L29:
            Unit r13 = Unit.INSTANCE;     // Catch: Throwable -> L32
            r5.b(null);
            return Unit.INSTANCE;
        L15:
            if (((Collection) ZeusTransformUtils.preCheckCast(r6, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L17;
        L32:
            th = move-exception;
            r5.b(null);
            throw th;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r17);
            r5 = AwarenessManagerImpl.access$getUpdatePackageInfoMutex$p();
            Set<String> r14 = this.$affectedPackages;
            Continuation<? super Unit> r15 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.L$0 = r5;
            this.L$1 = r14;
            this.label = 1;
            if (r5.a(null, r15) != r1) goto L11;
            return r1;
        L11:
            r9 = r14;
            goto L35
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.awareness.impl.AwarenessManagerImpl$updatePackageInfo$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.awareness.impl.AwarenessManagerImpl$updatePackageInfo$1", f = "AwarenessManagerImpl.kt", i = {0, 1}, l = {719, 109}, m = "invokeSuspend", n = {"$this$withLock_u24default$iv", "$this$withLock_u24default$iv"}, s = {"L$0", "L$0"})
    static final class C11011 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $firstLaunch;
        Object L$0;
        boolean Z$0;
        int label;

        C11011(boolean r3, Continuation<? super C11011> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.$firstLaunch = r3;
            super(2, r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new C11011(this.$firstLaunch, r4), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super Unit> r4) {
            return ((C11011) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C11011.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r18) {
            Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r2 = this.label;
            if (r2 == 0) goto L14;
            if (r2 == 1) goto L13;
            if (r2 != 2) goto L12;
            boolean r3 = this.Z$0;
            kotlinx.coroutines.sync.a r4 = (kotlinx.coroutines.sync.a) ZeusTransformUtils.preCheckCast(this.L$0, kotlinx.coroutines.sync.a.class, "com.obric.memorydata.plugin");
            ResultKt.throwOnFailure(r18);     // Catch: Throwable -> L9
            Object r0 = r18;
        L22:
            List r5 = (List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L9
            RunLog.INSTANCE.debug(AwarenessManagerImpl.TAG, "get all package info -----");     // Catch: Throwable -> L9
            Iterator r7 = ((Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Throwable -> L9
        L24:
            if (r7.hasNext() == false) goto L26;
            com.obric.aikernel.res.metadata.config.i r8 = (com.obric.aikernel.res.metadata.config.i) ZeusTransformUtils.preCheckCast(r7.next(), com.obric.aikernel.res.metadata.config.i.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L9
            r8.b();     // Catch: Throwable -> L9
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), AwarenessManagerImpl.TAG, "package name: " + r8.a() + ", version: " + r8.c() + ", deploy version: " + r8.l() + ", extras: " + AIInferRuntime.f6160a.a(r8), false, 4, null);     // Catch: Throwable -> L9
            goto L24
        L26:
            Iterator r9 = ((Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Throwable -> L9
        L28:
            if (r9.hasNext() == false) goto L30;
            com.obric.aikernel.res.metadata.config.i r10 = (com.obric.aikernel.res.metadata.config.i) ZeusTransformUtils.preCheckCast(r9.next(), com.obric.aikernel.res.metadata.config.i.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L9
            com.obric.memorydata.aikernelcore.h.f8481a.a(r10.a(), (JsonElement) ZeusTransformUtils.preCheckCast(AIInferRuntime.f6160a.a(r10), JsonElement.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L9
            goto L28
        L30:
            Iterable r6 = (Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L9
            Collection r11 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L9
            Iterator r12 = r6.iterator();     // Catch: Throwable -> L9
        L32:
            if (r12.hasNext() == false) goto L39;
            Object r13 = r12.next();     // Catch: Throwable -> L9
            if (AIInferRuntime.f6160a.a((com.obric.aikernel.res.metadata.config.i) ZeusTransformUtils.preCheckCast(r13, com.obric.aikernel.res.metadata.config.i.class, "com.obric.memorydata.plugin")) == null) goto L36;
            boolean r14 = true;
        L37:
            if (r14 == false) goto L32;
            r11.add(r13);     // Catch: Throwable -> L9
            goto L32
        L36:
            r14 = false;
            goto L37
        L39:
            List r15 = (List) ZeusTransformUtils.preCheckCast(r11, List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L9
            Iterable r16 = (Iterable) ZeusTransformUtils.preCheckCast(AwarenessManagerImpl.access$getLastPackagesInfo$p(), Iterable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L9
            Collection r17 = (Collection) ZeusTransformUtils.preCheckCast((Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.memorydata.plugin"), Collection.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L9
            Iterator r19 = r16.iterator();     // Catch: Throwable -> L9
        L41:
            if (r19.hasNext() == false) goto L43;
            r17.add(((com.obric.aikernel.res.metadata.config.i) ZeusTransformUtils.preCheckCast(r19.next(), com.obric.aikernel.res.metadata.config.i.class, "com.obric.memorydata.plugin")).a());     // Catch: Throwable -> L9
            goto L41
        L43:
            Iterable r20 = (Iterable) ZeusTransformUtils.preCheckCast(r17, Iterable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L9
            Iterable r21 = (Iterable) ZeusTransformUtils.preCheckCast(r15, Iterable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L9
            Collection r22 = (Collection) ZeusTransformUtils.preCheckCast((Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.memorydata.plugin"), Collection.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L9
            Iterator r23 = r21.iterator();     // Catch: Throwable -> L9
        L45:
            if (r23.hasNext() == false) goto L47;
            r22.add(((com.obric.aikernel.res.metadata.config.i) ZeusTransformUtils.preCheckCast(r23.next(), com.obric.aikernel.res.metadata.config.i.class, "com.obric.memorydata.plugin")).a());     // Catch: Throwable -> L9
            goto L45
        L47:
            Set r24 = CollectionsKt.subtract(r20, (Iterable) ZeusTransformUtils.preCheckCast(r22, Iterable.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L9
            AwarenessManagerImpl r25 = AwarenessManagerImpl.INSTANCE;     // Catch: Throwable -> L9
            AwarenessManagerImpl.access$setLastPackagesInfo$p(r15);     // Catch: Throwable -> L9
            com.obric.memorydata.awareness.impl.gate.a r26 = AwarenessManagerImpl.access$getAutoTriggerFeatureSwitchGate$p();     // Catch: Throwable -> L9
            Iterable r27 = (Iterable) ZeusTransformUtils.preCheckCast(r15, Iterable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L9
            Map r28 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r27, 10)), 16)), Map.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L9
            Iterator r29 = r27.iterator();     // Catch: Throwable -> L9
        L49:
            if (r29.hasNext() == false) goto L58;
            com.obric.aikernel.res.metadata.config.i r110 = (com.obric.aikernel.res.metadata.config.i) ZeusTransformUtils.preCheckCast(r29.next(), com.obric.aikernel.res.metadata.config.i.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L9
            PapayaConfig r111 = com.obric.memorydata.awareness.impl.data.a.a(r110);     // Catch: Throwable -> L9
            String r112 = r110.a();     // Catch: Throwable -> L9
            if (r111 == null) goto L53;
            JsonElement r113 = r111.getAutoTriggerFeatureSwitches();     // Catch: Throwable -> L9
        L54:
            if (r111 == null) goto L56;
            List<AwarenessEventTriggerConfig> r114 = r111.getAwarenessEventTriggers();     // Catch: Throwable -> L9
        L57:
            Pair r115 = TuplesKt.to(r112, new com.obric.memorydata.awareness.impl.gate.b(r113, r114));     // Catch: Throwable -> L9
            r28.put(r115.getFirst(), r115.getSecond());     // Catch: Throwable -> L9
            goto L49
        L56:
            r114 = null;
            goto L57
        L53:
            r113 = null;
            goto L54
        L58:
            r26.a(r28);     // Catch: Throwable -> L9
            AwarenessManagerImpl.reconcileAutoTriggerResources$default(AwarenessManagerImpl.INSTANCE, r15, r24, null, true, 4, null);     // Catch: Throwable -> L9
            if (r3 == false) goto L61;
            AwarenessManagerImpl.access$rescheduleLostTask(AwarenessManagerImpl.INSTANCE, r15);     // Catch: Throwable -> L9
            com.obric.memorydata.task.scheduler.b.a.a(com.obric.memorydata.task.scheduler.impl.c.f12961a.d(), "event_app_launch", null, 2, null);     // Catch: Throwable -> L9
        L62:
            MemoryService.INSTANCE.requestInAppRuleSync();     // Catch: Throwable -> L9
            Unit r30 = Unit.INSTANCE;     // Catch: Throwable -> L9
            r4.b(null);
            return Unit.INSTANCE;
        L61:
            ((TaskRequest) ZeusTransformUtils.preCheckCast(new TaskRequest.Builder("memory_settings").build(), TaskRequest.class, "com.obric.memorydata.plugin")).enqueue();     // Catch: Throwable -> L9
        L9:
            th = th;
        L67:
            r4.b(null);
            throw th;
        L12:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L13:
            boolean r31 = this.Z$0;
            kotlinx.coroutines.sync.a r32 = (kotlinx.coroutines.sync.a) ZeusTransformUtils.preCheckCast(this.L$0, kotlinx.coroutines.sync.a.class, "com.obric.memorydata.plugin");
            ResultKt.throwOnFailure(r18);
        L71:
            MemoryScriptEngineEnv r33 = MemoryScriptEngineEnv.INSTANCE;     // Catch: Throwable -> L65
            this.L$0 = r32;     // Catch: Throwable -> L65
            this.Z$0 = r31;     // Catch: Throwable -> L65
            this.label = 2;     // Catch: Throwable -> L65
            r0 = r33.getAllPackageConfigs(this);     // Catch: Throwable -> L65
            if (r0 != r1) goto L21;
            return r1;
        L21:
            r3 = r31;
            r4 = r32;
        L65:
            th = th;
            r4 = r32;
            goto L67
        L14:
            ResultKt.throwOnFailure(r18);
            kotlinx.coroutines.sync.a r34 = AwarenessManagerImpl.access$getUpdatePackageInfoMutex$p();
            boolean r35 = this.$firstLaunch;
            Continuation<? super Unit> r36 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.L$0 = r34;
            this.Z$0 = r35;
            this.label = 1;
            if (r34.a(null, r36) != r1) goto L17;
            return r1;
        L17:
            r32 = r34;
            r31 = r35;
            goto L71
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        AwarenessManagerImpl r0 = new AwarenessManagerImpl();
        INSTANCE = r0;
        awarenessEventListenerMap = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        taskEventListenerMap = MapsKt.emptyMap();
        awareEventPkgMap = MapsKt.emptyMap();
        lastFeatureDurationPackageSources = SetsKt.emptySet();
        lastFeatureDurationFeatures = SetsKt.emptySet();
        awarenessPackageScheduler = new f();
        locationContextStoreCleared = new AtomicBoolean(false);
        packageUpdateScope = am.a(cu.a(null, 1, null).plus((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin")));
        Object[] r1 = 0 == true ? 1 : 0;
        autoTriggerFeatureSwitchGate = new com.obric.memorydata.awareness.impl.gate.a((com.obric.memorydata.awareness.impl.gate.d) ZeusTransformUtils.preCheckCast(new com.obric.memorydata.awareness.impl.gate.e((com.obric.memorydata.awareness.impl.gate.d) ZeusTransformUtils.preCheckCast(new com.obric.memorydata.awareness.impl.gate.f(null, r1, 3, 0 == true ? 1 : 0), com.obric.memorydata.awareness.impl.gate.d.class, "com.obric.memorydata.plugin"), (com.obric.memorydata.awareness.impl.gate.d) ZeusTransformUtils.preCheckCast(new com.obric.memorydata.awareness.impl.gate.g(null, null, null, 7, null), com.obric.memorydata.awareness.impl.gate.d.class, "com.obric.memorydata.plugin")), com.obric.memorydata.awareness.impl.gate.d.class, "com.obric.memorydata.plugin"), (Function1) ZeusTransformUtils.preCheckCast(new AwarenessManagerImpl$autoTriggerFeatureSwitchGate$1(r0), Function1.class, "com.obric.memorydata.plugin"));
        lastPackagesInfo = CollectionsKt.emptyList();
        hasListenerStateMap = new ConcurrentHashMap();
        updatePackageInfoMutex = kotlinx.coroutines.sync.c.a(false, 1, null);
    }

    private AwarenessManagerImpl() {
    }

    public static final /* synthetic */ com.obric.memorydata.awareness.impl.gate.a access$getAutoTriggerFeatureSwitchGate$p() {
        return autoTriggerFeatureSwitchGate;
    }

    public static final /* synthetic */ List access$getLastPackagesInfo$p() {
        return lastPackagesInfo;
    }

    public static final /* synthetic */ kotlinx.coroutines.sync.a access$getUpdatePackageInfoMutex$p() {
        return updatePackageInfoMutex;
    }

    public static final /* synthetic */ void access$onAutoTriggerFeatureSwitchChanged(AwarenessManagerImpl r2, Set r3) {
        r2.onAutoTriggerFeatureSwitchChanged((Set) ZeusTransformUtils.wrapperContextForParams(r3, Set.class, "com.obric.memorydata.plugin"));
    }

    public static final /* synthetic */ void access$rescheduleLostTask(AwarenessManagerImpl r2, List r3) {
        r2.rescheduleLostTask((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    public static final /* synthetic */ void access$setLastPackagesInfo$p(List r2) {
        lastPackagesInfo = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
    }

    private final void clearLocationContextStoreOnProcessStart(boolean r7) {
        if (r7 == true) goto L4;
        return;
    L4:
        if (locationContextStoreCleared.compareAndSet(false, true) == false) goto L9;
        IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), LOCATION_CONTEXT_STORE_REPO, 0, 2, null).clearAll();
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "App 进程启动，已清空位置中控运行态", false, 4, null);
        return;
    }

    private final int countObservableListeners(String r4) {
        Map<String, List<com.obric.memorydata.awareness.api.a>> r3 = awarenessEventListenerMap;
        monitor-enter(r3);
        List r5 = (List) ZeusTransformUtils.preCheckCast(r3.get(r4), List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L25
        if (r5 == null) goto L7;
        List r6 = CollectionsKt.toList((Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L25
    L8:
        if (r6 != null) goto L10;
        r6 = CollectionsKt.emptyList();     // Catch: Throwable -> L25
    L10:
        monitor-exit(r3);
        Iterable r7 = (Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.memorydata.plugin");
        int r0 = 0;
        if (ZeusTransformUtils.instanceOf(r7, Collection.class) == true) goto L14;
    L16:
        Iterator r8 = r7.iterator();
    L18:
        if (r8.hasNext() == false) goto L24;
        if (((com.obric.memorydata.awareness.api.a) ZeusTransformUtils.preCheckCast(r8.next(), com.obric.memorydata.awareness.api.a.class, "com.obric.memorydata.plugin")).a() == false) goto L18;
        r0 = r0 + 1;
        if (r0 >= 0) goto L18;
        CollectionsKt.throwCountOverflow();
    L24:
        return r0;
    L14:
        if (((Collection) ZeusTransformUtils.preCheckCast(r7, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L16;
    L7:
        r6 = null;
    L25:
        th = move-exception;
        throw th;
    }

    private static final boolean dispatchTaskEvent$lambda$52$lambda$51(com.obric.aikernel.res.metadata.config.i r1) {
        return autoTriggerFeatureSwitchGate.a(r1.a());
    }

    @JvmStatic
    public static final AwarenessManagerImpl getInst() {
        return INSTANCE;
    }

    /* JADX INFO: renamed from: lambda$8Jo2nFXm-1aaf_n-2GuKwEmKCdQ, reason: not valid java name */
    public static /* synthetic */ boolean m504lambda$8Jo2nFXm1aaf_n2GuKwEmKCdQ(com.obric.aikernel.res.metadata.config.i r0) {
        return parsePackageRegisterInfo$lambda$28$lambda$26$lambda$25$lambda$24(r0);
    }

    /* JADX INFO: renamed from: lambda$FmvIIyhihjcISCnYb-fFkKoxjVk, reason: not valid java name */
    public static /* synthetic */ boolean m505lambda$FmvIIyhihjcISCnYbfFkKoxjVk(com.obric.aikernel.res.metadata.config.i r0, AwarenessEventTriggerType r1, String r2) {
        return parsePackageRegisterInfo$lambda$28$lambda$17$lambda$15(r0, r1, r2);
    }

    public static /* synthetic */ boolean lambda$MVYGPe9BB1110wQTxw7eN6Qb0L8(com.obric.aikernel.res.metadata.config.i r0, c r1) {
        return parsePackageRegisterInfo$lambda$28$lambda$11(r0, r1);
    }

    public static /* synthetic */ ae lambda$Q5rwizTtfVP7VhfmreP2L98lfik(Function1 r0, Object r1) {
        return observeAnyListener$lambda$54(r0, r1);
    }

    public static /* synthetic */ Unit lambda$RYfTcE11saFjRXC9jN8XnhpEXU8(com.obric.aikernel.res.metadata.config.i r0, k.c r1) {
        return parsePackageRegisterInfo$lambda$28$lambda$26$lambda$25(r0, r1);
    }

    public static /* synthetic */ boolean lambda$U8254PvzAg5Zy6yLz599x83DK3Y(com.obric.aikernel.res.metadata.config.i r0) {
        return parsePackageRegisterInfo$lambda$28$lambda$19$lambda$18(r0);
    }

    /* JADX INFO: renamed from: lambda$W4YQLfrVsPVct-lND-FsbQq6Img, reason: not valid java name */
    public static /* synthetic */ ae m506lambda$W4YQLfrVsPVctlNDFsbQq6Img(boolean r0, String r1) {
        return observeAnyListener$lambda$53(r0, r1);
    }

    public static /* synthetic */ boolean lambda$WdpiOE2f12SW8qPhvobs9apl1z4(com.obric.aikernel.res.metadata.config.i r0) {
        return parsePackageRegisterInfo$lambda$32$lambda$31(r0);
    }

    public static /* synthetic */ boolean lambda$fESWsupqbWTyahwvaA7OhpgQ3k0(com.obric.aikernel.res.metadata.config.i r0) {
        return dispatchTaskEvent$lambda$52$lambda$51(r0);
    }

    private static final ae observeAnyListener$lambda$53(boolean r1, String r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        return at.a(Boolean.valueOf(r1));
    }

    private static final ae observeAnyListener$lambda$54(Function1 r2, Object r3) {
        return (ae) ZeusTransformUtils.preCheckCast(((Function1) ZeusTransformUtils.wrapperContextForParams(r2, Function1.class, "com.obric.memorydata.plugin")).invoke(r3), ae.class, "com.obric.memorydata.plugin");
    }

    private final void onAutoTriggerFeatureSwitchChanged(Set<String> r8) {
        Set r7 = (Set) ZeusTransformUtils.wrapperContextForParams(r8, Set.class, "com.obric.memorydata.plugin");
        kotlinx.coroutines.i.a(packageUpdateScope, null, null, (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r7, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void parsePackageRegisterInfo(List<com.obric.aikernel.res.metadata.config.i> r30, Set<String> r31, Set<String> r32, boolean r33) {
        List r0 = (List) ZeusTransformUtils.wrapperContextForParams(r30, List.class, "com.obric.memorydata.plugin");
        Set r2 = (Set) ZeusTransformUtils.wrapperContextForParams(r31, Set.class, "com.obric.memorydata.plugin");
        Set<String> r3 = (Set) ZeusTransformUtils.wrapperContextForParams(r32, Set.class, "com.obric.memorydata.plugin");
        Set r4 = (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.memorydata.plugin");
        Map<String, ? extends List<e>> r5 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        Set<String> r6 = (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.memorydata.plugin");
        Set<String> r7 = (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.memorydata.plugin");
        List r8 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        Map r9 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        Map r10 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        Iterator r11 = ((Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r11.hasNext() == false) goto L151;
        final com.obric.aikernel.res.metadata.config.i r12 = (com.obric.aikernel.res.metadata.config.i) ZeusTransformUtils.preCheckCast(r11.next(), com.obric.aikernel.res.metadata.config.i.class, "com.obric.memorydata.plugin");
        PapayaConfig r14 = com.obric.memorydata.awareness.impl.data.a.a(r12);
        if (r2.contains(r12.a()) == true) goto L8;
        List r20 = r0;
        Set r16 = r2;
        Set<String> r21 = r3;
        Map r19 = r9;
        Iterator r17 = r11;
    L150:
        r2 = r16;
        r11 = r17;
        r9 = r19;
        r0 = r20;
        r3 = r21;
        goto L4
    L8:
        if (r14 == null) goto L10;
        List<AwarenessEventTriggerConfig> r13 = r14.getAwarenessEventTriggers();
    L11:
        if (r13 != null) goto L13;
        r13 = CollectionsKt.emptyList();
    L13:
        Iterator r15 = ((Iterable) ZeusTransformUtils.preCheckCast(r13, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L15:
        if (r15.hasNext() == false) goto L32;
        Set r18 = r2;
        AwarenessEventTriggerConfig r22 = (AwarenessEventTriggerConfig) ZeusTransformUtils.preCheckCast(r15.next(), AwarenessEventTriggerConfig.class, "com.obric.memorydata.plugin");
        Iterator r110 = r11;
        AwarenessEventTriggerType r111 = AwarenessEventTriggerType.Companion.a(r22.getType());
        if (r111 != null) goto L20;
        String r23 = "invalid_trigger_type";
    L23:
        if (r23 == null) goto L31;
        o r112 = (o) ZeusTransformUtils.preCheckCast(com.obric.memorydata.middleware.api.logging.b.f11611a, o.class, "com.obric.memorydata.plugin");
        com.obric.memorydata.middleware.api.logging.e r113 = new com.obric.memorydata.middleware.api.logging.e(null, null, null, 7, null);
        com.obric.memorydata.middleware.api.logging.g r24 = new com.obric.memorydata.middleware.api.logging.g();
        r24.a("package_name", r12.a());
        r24.a("scope", "awareness_event");
        if (r111 == null) goto L28;
        String r1 = r111.getValue();
        if (r1 == null) goto L28;
    L29:
        r24.a("trigger_type", r1);
        r24.a(InfoRequestQPSOptTraceLogger.REASON, r23);
        r112.a("awareness_event_trigger_config_invalid", "感知事件触发配置非法，已忽略对应事件", r113, r24.a());
    L28:
        r1 = "unknown";
    L31:
        r2 = r18;
        r11 = r110;
        r15 = r15;
        r9 = r9;
        r0 = r0;
        r3 = r3;
        goto L15
    L20:
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r22.getName(), CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L22;
        r23 = "blank_trigger_name";
        goto L23
    L22:
        r23 = null;
        goto L23
    L32:
        r20 = r0;
        r16 = r2;
        r21 = r3;
        r19 = r9;
        r17 = r11;
        Iterable r25 = (Iterable) ZeusTransformUtils.preCheckCast(d.f8663a.a(r14, (Function1) ZeusTransformUtils.preCheckCast(new AwarenessManagerImpl$parsePackageRegisterInfo$1$2(FeatureManager.INSTANCE), Function1.class, "com.obric.memorydata.plugin"), new $$Lambda$AwarenessManagerImpl$MVYGPe9BB1110wQTxw7eN6Qb0L8(r12)), Iterable.class, "com.obric.memorydata.plugin");
        Map r26 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        Iterator r27 = r25.iterator();
    L34:
        if (r27.hasNext() == false) goto L39;
        Object r28 = r27.next();
        String r29 = ((c) ZeusTransformUtils.preCheckCast(r28, c.class, "com.obric.memorydata.plugin")).a();
        Object r114 = r26.get(r29);
        if (r114 != null) goto L38;
        r114 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        r26.put(r29, r114);
    L38:
        ((List) ZeusTransformUtils.preCheckCast(r114, List.class, "com.obric.memorydata.plugin")).add(r28);
        goto L34
    L39:
        Iterator r34 = r26.entrySet().iterator();
    L41:
        if (r34.hasNext() == false) goto L62;
        Map.Entry r35 = (Map.Entry) ZeusTransformUtils.preCheckCast(r34.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        String r36 = (String) ZeusTransformUtils.preCheckCast(r35.getKey(), String.class, "com.obric.memorydata.plugin");
        Iterable r37 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r35.getValue(), List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");
        Collection r38 = (Collection) ZeusTransformUtils.preCheckCast((Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.memorydata.plugin"), Collection.class, "com.obric.memorydata.plugin");
        Iterator r39 = r37.iterator();
    L44:
        if (r39.hasNext() == false) goto L46;
        r38.add(((c) ZeusTransformUtils.preCheckCast(r39.next(), c.class, "com.obric.memorydata.plugin")).getType());
        goto L44
    L46:
        Set r40 = (Set) ZeusTransformUtils.preCheckCast(r38, Set.class, "com.obric.memorydata.plugin");
        List<e> r41 = r5.get(r36);
        if (r41 != null) goto L49;
        r41 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        r5.put(r36, r41);
    L49:
        ((List) ZeusTransformUtils.preCheckCast(r41, List.class, "com.obric.memorydata.plugin")).add(new e(r12, r36, r40, new $$Lambda$AwarenessManagerImpl$FmvIIyhihjcISCnYbfFkKoxjVk(r12)));
        Iterable r42 = (Iterable) ZeusTransformUtils.preCheckCast(r40, Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r42, Collection.class) == true) goto L52;
    L54:
        Iterator r43 = r42.iterator();
    L56:
        if (r43.hasNext() == false) goto L53;
        if (((AwarenessEventTriggerType) ZeusTransformUtils.preCheckCast(r43.next(), AwarenessEventTriggerType.class, "com.obric.memorydata.plugin")).isFeatureTrigger() == false) goto L56;
        boolean r44 = true;
    L60:
        if (r44 == false) goto L41;
        r4.add(r36);
    L53:
        r44 = false;
        goto L60
    L52:
        if (((Collection) ZeusTransformUtils.preCheckCast(r42, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L54;
    L62:
        if (r14 == null) goto L64;
        List<String> r45 = r14.getFeatureEventPolicies();
    L65:
        if (r45 != null) goto L67;
        r45 = CollectionsKt.emptyList();
    L67:
        Iterator r46 = ((Iterable) ZeusTransformUtils.preCheckCast(r45, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L69:
        if (r46.hasNext() == false) goto L77;
        String r47 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(r46.next(), String.class, "com.obric.memorydata.plugin"), CharSequence.class, "com.obric.memorydata.plugin")).toString();
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r47, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L73;
        boolean r48 = true;
    L74:
        if (r48 == true) goto L75;
        r4.add(r47);
        Boolean.valueOf(r8.add(new com.obric.memorydata.awareness.impl.a.f(r47, r12.a(), (com.obric.memorydata.awareness.impl.a.b) ZeusTransformUtils.preCheckCast(new com.obric.memorydata.awareness.impl.a.a(r12, new $$Lambda$AwarenessManagerImpl$U8254PvzAg5Zy6yLz599x83DK3Y(r12)), com.obric.memorydata.awareness.impl.a.b.class, "com.obric.memorydata.plugin"))));
        goto L69
    L75:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "ignore blank feature event policy, package=" + r12.a(), null, 4, null);
        Unit r49 = Unit.INSTANCE;
        goto L69
    L73:
        r48 = false;
        goto L74
    L77:
        if (r14 == null) goto L79;
        List<String> r50 = r14.getTaskDispatchEvents();
    L80:
        if (r50 == null) goto L89;
        Iterator r51 = ((Iterable) ZeusTransformUtils.preCheckCast(r50, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L83:
        if (r51.hasNext() == false) goto L88;
        String r52 = (String) ZeusTransformUtils.preCheckCast(r51.next(), String.class, "com.obric.memorydata.plugin");
        Object r53 = r10.get(r52);
        if (r53 != null) goto L87;
        r53 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        r10.put(r52, r53);
    L87:
        ((List) ZeusTransformUtils.preCheckCast(r53, List.class, "com.obric.memorydata.plugin")).add(r12);
        goto L83
    L88:
        Unit r54 = Unit.INSTANCE;
    L89:
        String r55 = "papaya:" + r12.a();
        if (r14 == null) goto L108;
        List<FeatureDurationTriggeredConfig> r56 = r14.getFeatureDurationTriggeredList();
        if (r56 == null) goto L108;
        Iterable r57 = (Iterable) ZeusTransformUtils.preCheckCast(r56, Iterable.class, "com.obric.memorydata.plugin");
        Collection r58 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r59 = r57.iterator();
    L95:
        if (r59.hasNext() == false) goto L107;
        FeatureDurationTriggeredConfig r60 = (FeatureDurationTriggeredConfig) ZeusTransformUtils.preCheckCast(r59.next(), FeatureDurationTriggeredConfig.class, "com.obric.memorydata.plugin");
        String r115 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r60.getFeatureName(), CharSequence.class, "com.obric.memorydata.plugin")).toString();
        String r116 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r60.getTargetFeatureValue(), CharSequence.class, "com.obric.memorydata.plugin")).toString();
        long r210 = r60.getDurationSeconds();
        boolean r211 = r60.getOneShot();
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r115, CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L99;
    L104:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "ignore invalid featureDuration config, package=" + r12.a() + ", config=" + r60, null, 4, null);
        k.b r61 = null;
    L105:
        if (r61 == null) goto L95;
        r58.add(r61);
        goto L95
    L99:
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r116, CharSequence.class, "com.obric.memorydata.plugin")) == true) goto L104;
        if (r210 <= 0) goto L104;
        r7.add(r115);
        r4.add(r115);
        r61 = new k.b(r115, r116, r210, r211, new $$Lambda$AwarenessManagerImpl$RYfTcE11saFjRXC9jN8XnhpEXU8(r12));
        goto L105
    L107:
        List<k.b> r62 = (List) ZeusTransformUtils.preCheckCast(r58, List.class, "com.obric.memorydata.plugin");
    L109:
        if (r62 != null) goto L112;
        r62 = CollectionsKt.emptyList();
    L112:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r62, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L114;
        r6.add(r55);
        k.f8704a.a(r55, r62);
    L114:
        if (r14 == null) goto L120;
        List<CronConfig> r63 = r14.getCronList();
        if (r63 == null) goto L120;
        boolean r64 = true;
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r63, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) != true) goto L121;
        boolean r65 = true;
    L122:
        if (r14 != null) goto L124;
    L126:
        boolean r117 = false;
    L127:
        if (r65 == false) goto L134;
        f r66 = awarenessPackageScheduler;
        if (r66.b(r12) == false) goto L133;
        if (r117 == false) goto L132;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "ignore timers because cron_list exists, package=" + r12.a(), false, 4, null);
    L132:
        com.obric.memorydata.task.scheduler.impl.c.f12961a.d().c(r12.a());
    L133:
        r66.a(r12);
        goto L150
    L134:
        if (r14 == null) goto L136;
        TimerConfig r67 = r14.getTimerConfig();
    L137:
        f r68 = awarenessPackageScheduler;
        if (r68.b(r12) == false) goto L150;
        com.obric.memorydata.task.scheduler.impl.c.f12961a.d().c(r12.a());
        if (r67 == null) goto L142;
        r68.a(r12, r67);
    L142:
        if (r14 == null) goto L150;
        List<TimerConfig> r69 = r14.getTimerConfigs();
        if (r69 == null) goto L150;
        Iterator r70 = ((Iterable) ZeusTransformUtils.preCheckCast(r69, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L147:
        if (r70.hasNext() == false) goto L149;
        awarenessPackageScheduler.a(r12, (TimerConfig) ZeusTransformUtils.preCheckCast(r70.next(), TimerConfig.class, "com.obric.memorydata.plugin"));
        goto L147
    L149:
        Unit r71 = Unit.INSTANCE;
        goto L150
    L136:
        r67 = null;
        goto L137
    L124:
        if (r14.hasValidTimer() != r64) goto L126;
        r117 = true;
    L121:
        r65 = false;
    L120:
        r64 = true;
    L108:
        r62 = null;
        goto L109
    L79:
        r50 = null;
        goto L80
    L64:
        r45 = null;
        goto L65
    L10:
        r13 = null;
        goto L11
    L151:
        List r212 = r0;
        Map r118 = r9;
        Set<String> r72 = replacePackageAwarenessListeners(r5, r3);
        com.obric.memorydata.awareness.impl.a.g r73 = com.obric.memorydata.awareness.impl.a.d.f8622a.a((Collection) ZeusTransformUtils.preCheckCast(r8, Collection.class, "com.obric.memorydata.plugin"));
        Iterator r74 = ((Iterable) ZeusTransformUtils.preCheckCast(r73.b(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L153:
        if (r74.hasNext() == false) goto L155;
        com.obric.memorydata.awareness.impl.a.e r75 = (com.obric.memorydata.awareness.impl.a.e) ZeusTransformUtils.preCheckCast(r74.next(), com.obric.memorydata.awareness.impl.a.e.class, "com.obric.memorydata.plugin");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "duplicate feature event policy, feature=" + r75.a() + ", selected=" + r75.b() + ", ignored=" + r75.c(), null, 4, null);
        goto L153
    L155:
        Set<String> r76 = lastFeatureDurationFeatures;
        Iterator r77 = ((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.subtract((Iterable) ZeusTransformUtils.preCheckCast(lastFeatureDurationPackageSources, Iterable.class, "com.obric.memorydata.plugin"), (Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L157:
        if (r77.hasNext() == false) goto L159;
        k.f8704a.a((String) ZeusTransformUtils.preCheckCast(r77.next(), String.class, "com.obric.memorydata.plugin"));
        goto L157
    L159:
        lastFeatureDurationPackageSources = r6;
        Iterator r78 = ((Iterable) ZeusTransformUtils.preCheckCast(r212, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L161:
        if (r78.hasNext() == false) goto L202;
        final com.obric.aikernel.res.metadata.config.i r79 = (com.obric.aikernel.res.metadata.config.i) ZeusTransformUtils.preCheckCast(r78.next(), com.obric.aikernel.res.metadata.config.i.class, "com.obric.memorydata.plugin");
        PapayaConfig r80 = com.obric.memorydata.awareness.impl.data.a.a(r79);
        JsonObject r119 = AIInferRuntime.f6160a.a(r79);
        if (r119 == null) goto L167;
        JsonElement r120 = r119.get(KEY_TRIGGER_EVENTS);
        if (r120 == null) goto L167;
        JsonArray r121 = r120.getAsJsonArray();
    L168:
        JsonObject r122 = AIInferRuntime.f6160a.a(r79);
        if (r122 == null) goto L173;
        JsonElement r123 = r122.get(KEY_AWARENESS_FEATURE);
        if (r123 == null) goto L173;
        String r124 = r123.getAsString();
    L174:
        CharSequence r125 = (CharSequence) ZeusTransformUtils.preCheckCast(r124, CharSequence.class, "com.obric.memorydata.plugin");
        if (r125 != null) goto L177;
    L180:
        boolean r126 = true;
    L181:
        if (r126 == true) goto L200;
        Map r127 = r118;
        r127.put(r124, r79);
        if (r121 != null) goto L190;
        if (r80 == null) goto L186;
        List<AwarenessEventTriggerConfig> r81 = r80.getAwarenessEventTriggers();
    L187:
        if (r81 != null) goto L190;
        boolean r82 = false;
    L191:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "awarenessFeature " + r124, false, 4, null);
        if (b.f8632a.b() == false) goto L201;
        if (r4.contains(r124) == false) goto L201;
        if (r82 == true) goto L201;
        if (r33 == false) goto L201;
        if (autoTriggerFeatureSwitchGate.a(r79.a()) == false) goto L201;
        RunLog.INSTANCE.debug(TAG, "run awareness package " + r79.a());
        JSONObject r83 = new JSONObject();
        r83.put(KEY_ACTION_TYPE, ACTION_SUBSCRIBE);
        com.obric.memorydata.awareness.task.b.f8794a.a(r79, r83, new $$Lambda$AwarenessManagerImpl$WdpiOE2f12SW8qPhvobs9apl1z4(r79));
    L201:
        r118 = r127;
        goto L161
    L186:
        r81 = null;
    L190:
        r82 = true;
        goto L191
    L200:
        r127 = r118;
        goto L201
    L177:
        if (StringsKt.isBlank(r125) == true) goto L180;
        r126 = false;
    L173:
        r124 = null;
    L167:
        r121 = null;
        goto L168
    L202:
        awareEventPkgMap = MapsKt.toMap(r118);
        Map<String, ? extends List<com.obric.aikernel.res.metadata.config.i>> r84 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(MapsKt.mapCapacity(r10.size())), Map.class, "com.obric.memorydata.plugin");
        Iterator r85 = ((Iterable) ZeusTransformUtils.preCheckCast(r10.entrySet(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L204:
        if (r85.hasNext() == false) goto L206;
        Object r86 = r85.next();
        r84.put(((Map.Entry) ZeusTransformUtils.preCheckCast(r86, Map.Entry.class, "com.obric.memorydata.plugin")).getKey(), CollectionsKt.toList((Iterable) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r86, Map.Entry.class, "com.obric.memorydata.plugin")).getValue(), Iterable.class, "com.obric.memorydata.plugin")));
        goto L204
    L206:
        taskEventListenerMap = r84;
        FeatureManager.INSTANCE.collectFeatures(CollectionsKt.toList((Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.memorydata.plugin")), true);
        Set r87 = CollectionsKt.subtract((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.union((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.union((Iterable) ZeusTransformUtils.preCheckCast(r72, Iterable.class, "com.obric.memorydata.plugin"), (Iterable) ZeusTransformUtils.preCheckCast(r76, Iterable.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin"), (Iterable) ZeusTransformUtils.preCheckCast(r73.a(), Iterable.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin"), (Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.memorydata.plugin"));
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r87, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L209;
        RunLog.INSTANCE.debug(TAG, "unsubscribeFeatures = " + r87);
        FeatureManager.INSTANCE.collectFeatures(CollectionsKt.toList((Iterable) ZeusTransformUtils.preCheckCast(r87, Iterable.class, "com.obric.memorydata.plugin")), false);
    L209:
        lastFeatureDurationFeatures = r7;
    }

    private static final boolean parsePackageRegisterInfo$lambda$28$lambda$11(com.obric.aikernel.res.metadata.config.i r2, c r3) {
        Intrinsics.checkNotNullParameter(r3, "subscription");
        return autoTriggerFeatureSwitchGate.a(r2.a(), r3.getType(), r3.a());
    }

    private static final boolean parsePackageRegisterInfo$lambda$28$lambda$17$lambda$15(com.obric.aikernel.res.metadata.config.i r1, AwarenessEventTriggerType r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "type");
        Intrinsics.checkNotNullParameter(r3, "triggerName");
        return autoTriggerFeatureSwitchGate.a(r1.a(), r2, r3);
    }

    private static final boolean parsePackageRegisterInfo$lambda$28$lambda$19$lambda$18(com.obric.aikernel.res.metadata.config.i r1) {
        return autoTriggerFeatureSwitchGate.a(r1.a());
    }

    private static final Unit parsePackageRegisterInfo$lambda$28$lambda$26$lambda$25(final com.obric.aikernel.res.metadata.config.i r8, k.c r9) {
        Intrinsics.checkNotNullParameter(r9, "triggerInfo");
        JSONObject r0 = new JSONObject();
        r0.put(KEY_ACTION_TYPE, ACTION_SUBSCRIBE);
        r0.put("event", FEATURE_DURATION_TRIGGERED);
        JSONObject r1 = new JSONObject();
        r1.put("feature", r9.a());
        r1.put("current_feature_value", r9.d());
        r1.put("target_feature_value", r9.b());
        r1.put("duration_seconds", r9.c());
        Unit r2 = Unit.INSTANCE;
        r0.put(WsConstants.KEY_EXTRA, r1);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "trigger papaya duration package=" + r8.a() + ", feature=" + r9.a() + ", target=" + r9.b() + ", duration=" + r9.c(), false, 4, null);
        com.obric.memorydata.awareness.task.b.f8794a.a(r8, r0, new $$Lambda$AwarenessManagerImpl$8Jo2nFXm1aaf_n2GuKwEmKCdQ(r8));
        return Unit.INSTANCE;
    }

    private static final boolean parsePackageRegisterInfo$lambda$28$lambda$26$lambda$25$lambda$24(com.obric.aikernel.res.metadata.config.i r1) {
        return autoTriggerFeatureSwitchGate.a(r1.a());
    }

    private static final boolean parsePackageRegisterInfo$lambda$32$lambda$31(com.obric.aikernel.res.metadata.config.i r1) {
        return autoTriggerFeatureSwitchGate.a(r1.a());
    }

    private final void reconcileAutoTriggerResources(List<com.obric.aikernel.res.metadata.config.i> r7, Set<String> r8, Set<String> r9, boolean r10) {
        List<com.obric.aikernel.res.metadata.config.i> r11 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin");
        Set r12 = (Set) ZeusTransformUtils.wrapperContextForParams(r8, Set.class, "com.obric.memorydata.plugin");
        Set<String> r13 = (Set) ZeusTransformUtils.wrapperContextForParams(r9, Set.class, "com.obric.memorydata.plugin");
        Iterable r0 = (Iterable) ZeusTransformUtils.preCheckCast(r11, Iterable.class, "com.obric.memorydata.plugin");
        Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r1 = r0.iterator();
    L4:
        if (r1.hasNext() == false) goto L8;
        Object r3 = r1.next();
        com.obric.aikernel.res.metadata.config.i r4 = (com.obric.aikernel.res.metadata.config.i) ZeusTransformUtils.preCheckCast(r3, com.obric.aikernel.res.metadata.config.i.class, "com.obric.memorydata.plugin");
        if (autoTriggerFeatureSwitchGate.a(r4.a()) == false) goto L4;
        r2.add(r3);
        goto L4
    L8:
        Iterable r5 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");
        Collection r6 = (Collection) ZeusTransformUtils.preCheckCast((Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.memorydata.plugin"), Collection.class, "com.obric.memorydata.plugin");
        Iterator r14 = r5.iterator();
    L10:
        if (r14.hasNext() == false) goto L12;
        r6.add(((com.obric.aikernel.res.metadata.config.i) ZeusTransformUtils.preCheckCast(r14.next(), com.obric.aikernel.res.metadata.config.i.class, "com.obric.memorydata.plugin")).a());
        goto L10
    L12:
        Set<String> r15 = (Set) ZeusTransformUtils.preCheckCast(r6, Set.class, "com.obric.memorydata.plugin");
        Iterable r16 = (Iterable) ZeusTransformUtils.preCheckCast(r11, Iterable.class, "com.obric.memorydata.plugin");
        Collection r17 = (Collection) ZeusTransformUtils.preCheckCast((Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.memorydata.plugin"), Collection.class, "com.obric.memorydata.plugin");
        Iterator r18 = r16.iterator();
    L14:
        if (r18.hasNext() == false) goto L16;
        r17.add(((com.obric.aikernel.res.metadata.config.i) ZeusTransformUtils.preCheckCast(r18.next(), com.obric.aikernel.res.metadata.config.i.class, "com.obric.memorydata.plugin")).a());
        goto L14
    L16:
        Iterator r19 = ((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.union((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.subtract((Iterable) ZeusTransformUtils.preCheckCast(r17, Iterable.class, "com.obric.memorydata.plugin"), (Iterable) ZeusTransformUtils.preCheckCast(r15, Iterable.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin"), (Iterable) ZeusTransformUtils.preCheckCast(r12, Iterable.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L18:
        if (r19.hasNext() == false) goto L20;
        String r20 = (String) ZeusTransformUtils.preCheckCast(r19.next(), String.class, "com.obric.memorydata.plugin");
        com.obric.memorydata.task.scheduler.impl.c.f12961a.d().c(r20);
        awarenessPackageScheduler.a(r20);
        goto L18
    L20:
        parsePackageRegisterInfo(r11, r15, r13, r10);
        Iterable r21 = (Iterable) ZeusTransformUtils.preCheckCast(r11, Iterable.class, "com.obric.memorydata.plugin");
        Collection r22 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r23 = r21.iterator();
    L22:
        if (r23.hasNext() == false) goto L26;
        Object r24 = r23.next();
        if (r15.contains(((com.obric.aikernel.res.metadata.config.i) ZeusTransformUtils.preCheckCast(r24, com.obric.aikernel.res.metadata.config.i.class, "com.obric.memorydata.plugin")).a()) == false) goto L22;
        r22.add(r24);
        goto L22
    L26:
        syncPackageCronJobs((List) ZeusTransformUtils.preCheckCast(r22, List.class, "com.obric.memorydata.plugin"));
    }

    static /* synthetic */ void reconcileAutoTriggerResources$default(AwarenessManagerImpl r1, List r2, Set r3, Set r4, boolean r5, int r6, Object r7) {
        List<com.obric.aikernel.res.metadata.config.i> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
        Set<String> r9 = (Set) ZeusTransformUtils.wrapperContextForParams(r3, Set.class, "com.obric.memorydata.plugin");
        Set<String> r10 = (Set) ZeusTransformUtils.wrapperContextForParams(r4, Set.class, "com.obric.memorydata.plugin");
        if ((r6 & 2) == 0) goto L6;
        r9 = SetsKt.emptySet();
    L6:
        if ((r6 & 4) == 0) goto L8;
        r10 = null;
    L8:
        r1.reconcileAutoTriggerResources(r8, r9, r10, r5);
    }

    private final Set<String> replacePackageAwarenessListeners(Map<String, ? extends List<e>> r11, Set<String> r12) {
        Map r13 = (Map) ZeusTransformUtils.wrapperContextForParams(r11, Map.class, "com.obric.memorydata.plugin");
        Set r14 = (Set) ZeusTransformUtils.wrapperContextForParams(r12, Set.class, "com.obric.memorydata.plugin");
        Set<String> r0 = (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.memorydata.plugin");
        Set r1 = (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.memorydata.plugin");
        Map<String, List<com.obric.memorydata.awareness.api.a>> r2 = awarenessEventListenerMap;
        monitor-enter(r2);
        Iterator<Map.Entry<String, List<com.obric.memorydata.awareness.api.a>>> r3 = r2.entrySet().iterator();     // Catch: Throwable -> L54
    L6:
        if (r3.hasNext() == false) goto L22;
        Map.Entry r4 = (Map.Entry) ZeusTransformUtils.preCheckCast(r3.next(), Map.Entry.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L54
        String r5 = (String) ZeusTransformUtils.preCheckCast(r4.getKey(), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L54
        List r6 = (List) ZeusTransformUtils.preCheckCast(r4.getValue(), List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L54
        Iterator r7 = r6.iterator();     // Catch: Throwable -> L54
    L9:
        if (r7.hasNext() == false) goto L20;
        com.obric.memorydata.awareness.api.a r8 = (com.obric.memorydata.awareness.api.a) ZeusTransformUtils.preCheckCast(r7.next(), com.obric.memorydata.awareness.api.a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L54
        if (ZeusTransformUtils.instanceOf(r8, e.class) == false) goto L9;
        if (r14 == null) goto L15;
        if (r14.contains(((e) ZeusTransformUtils.preCheckCast(r8, e.class, "com.obric.memorydata.plugin")).b()) == false) goto L9;
    L15:
        ((e) ZeusTransformUtils.preCheckCast(r8, e.class, "com.obric.memorydata.plugin")).d();     // Catch: Throwable -> L54
        if (((e) ZeusTransformUtils.preCheckCast(r8, e.class, "com.obric.memorydata.plugin")).c() == false) goto L18;
        r0.add(r5);     // Catch: Throwable -> L54
    L18:
        r7.remove();     // Catch: Throwable -> L54
        r1.add(r5);     // Catch: Throwable -> L54
        goto L9
    L20:
        if (r6.isEmpty() == false) goto L6;
        r3.remove();     // Catch: Throwable -> L54
        goto L6
    L22:
        Iterator r15 = r13.entrySet().iterator();     // Catch: Throwable -> L54
    L24:
        if (r15.hasNext() == false) goto L47;
        Map.Entry r9 = (Map.Entry) ZeusTransformUtils.preCheckCast(r15.next(), Map.Entry.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L54
        String r10 = (String) ZeusTransformUtils.preCheckCast(r9.getKey(), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L54
        List r16 = (List) ZeusTransformUtils.preCheckCast(r9.getValue(), List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L54
        Map<String, List<com.obric.memorydata.awareness.api.a>> r17 = awarenessEventListenerMap;     // Catch: Throwable -> L54
        List<com.obric.memorydata.awareness.api.a> r18 = r17.get(r10);     // Catch: Throwable -> L54
        if (r18 != null) goto L28;
        r18 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L54
        r17.put(r10, r18);     // Catch: Throwable -> L54
    L28:
        List r19 = (List) ZeusTransformUtils.preCheckCast(r18, List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L54
        Iterable r20 = (Iterable) ZeusTransformUtils.preCheckCast(r16, Iterable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L54
        Collection r21 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L54
        Iterator r22 = r20.iterator();     // Catch: Throwable -> L54
    L30:
        if (r22.hasNext() == false) goto L40;
        Object r23 = r22.next();     // Catch: Throwable -> L54
        e r24 = (e) ZeusTransformUtils.preCheckCast(r23, e.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L54
        if (r14 != null) goto L34;
    L37:
        boolean r25 = true;
    L38:
        if (r25 == false) goto L30;
        r21.add(r23);     // Catch: Throwable -> L54
        goto L30
    L34:
        if (r14.contains(r24.b()) == true) goto L37;
        r25 = false;
        goto L38
    L40:
        Iterator r26 = ((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r21, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Throwable -> L54
    L42:
        if (r26.hasNext() == false) goto L46;
        e r27 = (e) ZeusTransformUtils.preCheckCast(r26.next(), e.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L54
        if (r19.contains(r27) == true) goto L42;
        r19.add(r27);     // Catch: Throwable -> L54
        goto L42
    L46:
        r1.add(r10);     // Catch: Throwable -> L54
        goto L24
    L47:
        Unit r110 = Unit.INSTANCE;     // Catch: Throwable -> L54
        monitor-exit(r2);
        Iterator r111 = ((Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L51:
        if (r111.hasNext() == false) goto L53;
        updateState((String) ZeusTransformUtils.preCheckCast(r111.next(), String.class, "com.obric.memorydata.plugin"));
        goto L51
    L53:
        return r0;
    L54:
        th = move-exception;
        throw th;
    }

    private final void rescheduleLostTask(List<com.obric.aikernel.res.metadata.config.i> r9) {
        Iterator r8 = ((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r8.hasNext() == false) goto L53;
        com.obric.aikernel.res.metadata.config.i r10 = (com.obric.aikernel.res.metadata.config.i) ZeusTransformUtils.preCheckCast(r8.next(), com.obric.aikernel.res.metadata.config.i.class, "com.obric.memorydata.plugin");
        if (autoTriggerFeatureSwitchGate.a(r10.a()) == false) goto L4;
        PapayaConfig r1 = com.obric.memorydata.awareness.impl.data.a.a(r10);
        boolean r6 = false;
        long r2 = IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), "papaya_last_runtime", 0, 2, null).getLong(r10.a(), 0);
        if (r2 == 0) goto L4;
        if (r1 == null) goto L18;
        List<CronConfig> r5 = r1.getCronList();
        if (r5 == null) goto L18;
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r5, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) != true) goto L18;
        boolean r7 = true;
    L19:
        if (r7 == true) goto L20;
        if (r1 == null) goto L33;
        TimerConfig r11 = r1.getTimerConfig();
        if (r11 == null) goto L33;
        if (r11.validTimer() != true) goto L33;
        r6 = true;
    L33:
        if (r6 == false) goto L4;
        TimerConfig r4 = r1.getTimerConfig();
        if (r4 == null) goto L4;
        Long r12 = r4.getIntervalSec();
        if (r12 == null) goto L4;
        if ((r12.longValue() * ((long) 1000)) >= Math.abs(System.currentTimeMillis() - r2)) goto L4;
        RunLog.INSTANCE.debug(TAG, "schedule lost task " + r10.a());
        JSONObject r3 = new JSONObject();
        r3.put("trigger_source", "timer");
        TaskRequest.Builder r13 = (TaskRequest.Builder) ZeusTransformUtils.preCheckCast(new TaskRequest.Builder(r10.a()).setInputParam(r3), TaskRequest.Builder.class, "com.obric.memorydata.plugin");
        new TaskRequest.Builder(r10.a());
        TaskConfig r14 = r1.getTaskConfig();
        if (r14 == null) goto L52;
        List<String> r15 = r14.getConditions();
        if (r15 == null) goto L52;
        Iterable r16 = (Iterable) ZeusTransformUtils.preCheckCast(r15, Iterable.class, "com.obric.memorydata.plugin");
        Collection r17 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r18 = r16.iterator();
    L47:
        if (r18.hasNext() == false) goto L51;
        Condition r19 = Condition.Companion.a((String) ZeusTransformUtils.preCheckCast(r18.next(), String.class, "com.obric.memorydata.plugin"));
        if (r19 == null) goto L47;
        r17.add(r19);
        goto L47
    L51:
        TaskRequest.Builder r20 = (TaskRequest.Builder) ZeusTransformUtils.preCheckCast(r13.setConditions((List) ZeusTransformUtils.preCheckCast(r17, List.class, "com.obric.memorydata.plugin")), TaskRequest.Builder.class, "com.obric.memorydata.plugin");
    L52:
        ((TaskRequest) ZeusTransformUtils.preCheckCast(r13.build(), TaskRequest.class, "com.obric.memorydata.plugin")).enqueue();
        goto L4
    L20:
        TimerConfig r21 = r1.getTimerConfig();
        if (r21 != null) goto L23;
    L25:
        if (r6 == false) goto L4;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "ignore timers because cron_list exists, package=" + r10.a(), false, 4, null);
        goto L4
    L23:
        if (r21.validTimer() != true) goto L25;
        r6 = true;
    L18:
        r7 = false;
        goto L19
    }

    private final void syncPackageCronJobs(List<com.obric.aikernel.res.metadata.config.i> r24) {
        Iterable r0 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.wrapperContextForParams(r24, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");
        Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r1 = r0.iterator();
    L4:
        if (r1.hasNext() == false) goto L40;
        com.obric.aikernel.res.metadata.config.i r3 = (com.obric.aikernel.res.metadata.config.i) ZeusTransformUtils.preCheckCast(r1.next(), com.obric.aikernel.res.metadata.config.i.class, "com.obric.memorydata.plugin");
        PapayaConfig r4 = com.obric.memorydata.awareness.impl.data.a.a(r3);
        if (r4 == null) goto L36;
        List<CronConfig> r6 = r4.getCronList();
        if (r6 == null) goto L36;
        Iterable r7 = (Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.memorydata.plugin");
        Collection r8 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        int r9 = 0;
        Iterator r10 = r7.iterator();
    L11:
        if (r10.hasNext() == false) goto L35;
        Object r11 = r10.next();
        int r12 = r9 + 1;
        if (r9 >= 0) goto L15;
        CollectionsKt.throwIndexOverflow();
    L15:
        CronConfig r13 = (CronConfig) ZeusTransformUtils.preCheckCast(r11, CronConfig.class, "com.obric.memorydata.plugin");
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r13.getCron(), CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L18;
        com.obric.memorydata.awareness.impl.cron.b.a r5 = null;
    L32:
        if (r5 == null) goto L34;
        r8.add(r5);
    L34:
        r9 = r12;
        goto L11
    L18:
        String r14 = r3.a() + '#' + r9 + '#' + r13.getCron();
        String r15 = r13.getCron();
        boolean r16 = r13.getTriggerExactly();
        String r17 = r3.a();
        JSONObject r18 = new JSONObject();
        r18.put("trigger_source", CronJobRunnerTask.KEY_TRIGGER_SOURCE_VALUE);
        r18.put("cron_expr", r13.getCron());
        Unit r19 = Unit.INSTANCE;
        if (r4 == null) goto L24;
        TaskConfig r20 = r4.getTaskConfig();
        if (r20 == null) goto L24;
        List<String> r21 = r20.getConditions();
        if (r21 == null) goto L24;
    L25:
        List<String> r110 = r21;
        if (r4 == null) goto L30;
        TaskConfig r22 = r4.getTaskConfig();
        if (r22 == null) goto L30;
        String r111 = r22.getExistingTaskPolicy();
    L31:
        r5 = new com.obric.memorydata.awareness.impl.cron.b.a(r14, r15, r16, r17, r18, r110, r111, false, null, 256, null);
    L30:
        r111 = null;
    L24:
        r21 = CollectionsKt.emptyList();
        goto L25
    L35:
        List r23 = (List) ZeusTransformUtils.preCheckCast(r8, List.class, "com.obric.memorydata.plugin");
    L37:
        if (r23 != null) goto L39;
        r23 = CollectionsKt.emptyList();
    L39:
        CollectionsKt.addAll(r2, (Iterable) ZeusTransformUtils.preCheckCast(r23, Iterable.class, "com.obric.memorydata.plugin"));
    L36:
        r23 = null;
        goto L37
    L40:
        com.obric.memorydata.awareness.impl.cron.b.f8651a.a("papaya_package", (List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.memorydata.plugin"));
    }

    private final void updateState(String r4) {
        int r3 = countObservableListeners(r4);
        RunLog.INSTANCE.debug(TAG, "updateState " + r4 + ", listenerCount = " + r3);
        ae r5 = (ae) ZeusTransformUtils.preCheckCast(hasListenerStateMap.get(r4), ae.class, "com.obric.memorydata.plugin");
        if (r5 == null) goto L9;
        if (r3 <= 0) goto L6;
        boolean r6 = true;
    L7:
        r5.b(Boolean.valueOf(r6));
        return;
    L6:
        r6 = false;
        goto L7
    }

    @Override // com.obric.memorydata.awareness.api.IAwarenessManager
    public void dispatchAwarenessEvent(String r8, Map<String, ? extends Object> r9) {
        Map<String, ? extends Object> r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r9, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r8, "eventName");
        com.obric.memorydata.awareness.a.a.f8504a.a(r8, r7);
        Map<String, List<com.obric.memorydata.awareness.api.a>> r10 = awarenessEventListenerMap;
        monitor-enter(r10);
        List r0 = (List) ZeusTransformUtils.preCheckCast(r10.get(r8), List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L20
        if (r0 == null) goto L7;
        List r1 = CollectionsKt.toList((Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L20
    L8:
        if (r1 != null) goto L10;
        r1 = CollectionsKt.emptyList();     // Catch: Throwable -> L20
    L10:
        monitor-exit(r10);
        if (AppContext.INSTANCE.isDebug() == false) goto L14;
        RunLog.INSTANCE.debug(TAG, "onEvent " + r8 + ", extra = " + r7);
    L15:
        com.obric.memorydata.awareness.impl.b.a.f8634a.a(r8);
        Iterator r11 = ((Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L17:
        if (r11.hasNext() == false) goto L19;
        ((com.obric.memorydata.awareness.api.a) ZeusTransformUtils.preCheckCast(r11.next(), com.obric.memorydata.awareness.api.a.class, "com.obric.memorydata.plugin")).a(r8, r7);
        goto L17
    L19:
        return;
    L14:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "onEvent " + r8, false, 4, null);
        goto L15
    L7:
        r1 = null;
    L20:
        th = move-exception;
        throw th;
    }

    @Override // com.obric.memorydata.awareness.api.IAwarenessManager
    public void dispatchTaskEvent(String r8, Map<String, ? extends Object> r9) {
        Map r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r9, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r8, "eventName");
        List r10 = (List) ZeusTransformUtils.preCheckCast(taskEventListenerMap.get(r8), List.class, "com.obric.memorydata.plugin");
        if (r10 == null) goto L14;
        Iterator r11 = ((Iterable) ZeusTransformUtils.preCheckCast(r10, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L6:
        if (r11.hasNext() == false) goto L18;
        final com.obric.aikernel.res.metadata.config.i r1 = (com.obric.aikernel.res.metadata.config.i) ZeusTransformUtils.preCheckCast(r11.next(), com.obric.aikernel.res.metadata.config.i.class, "com.obric.memorydata.plugin");
        JSONObject r2 = new JSONObject();
        r2.put("dispatch_event", r8);
        if (r7 == null) goto L13;
        Iterator r3 = r7.entrySet().iterator();
    L11:
        if (r3.hasNext() == false) goto L13;
        Map.Entry r4 = (Map.Entry) ZeusTransformUtils.preCheckCast(r3.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        r2.put((String) ZeusTransformUtils.preCheckCast(r4.getKey(), String.class, "com.obric.memorydata.plugin"), r4.getValue());
    L13:
        com.obric.memorydata.awareness.task.b.f8794a.a(r1, r2, new $$Lambda$AwarenessManagerImpl$fESWsupqbWTyahwvaA7OhpgQ3k0(r1));
        goto L6
    L18:
        return;
    }

    @Override // com.obric.memorydata.awareness.api.IAwarenessManager
    public String getAddressByGps(double r1, double r3) {
        return LocationProcessor.INSTANCE.getAddressByGps(r1, r3);
    }

    @Override // com.obric.memorydata.awareness.api.IAwarenessManager
    public String getCachedAddressByGps(double r1, double r3) {
        return LocationProcessor.INSTANCE.getCachedAddressByGps(r1, r3);
    }

    @Override // com.obric.memorydata.awareness.api.IAwarenessManager
    public boolean isPackageAutoTriggerEnabled(String r1) {
        Intrinsics.checkNotNullParameter(r1, ObricMemoryConstants.KEY_PACKAGE_NAME);
        return autoTriggerFeatureSwitchGate.a(r1);
    }

    @Override // com.obric.memorydata.awareness.api.IAwarenessManager
    public boolean makeAwarenessFeature(String r5) {
        Intrinsics.checkNotNullParameter(r5, "feature");
        com.obric.aikernel.res.metadata.config.i r4 = (com.obric.aikernel.res.metadata.config.i) ZeusTransformUtils.preCheckCast(awareEventPkgMap.get(r5), com.obric.aikernel.res.metadata.config.i.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L5;
        return false;
    L5:
        JSONObject r1 = new JSONObject();
        r1.put(KEY_ACTION_TYPE, "query");
        if (((TaskRequest) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(new TaskRequest.Builder(r4.a()).setInputParam(r1), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).build(), TaskRequest.class, "com.obric.memorydata.plugin")).execute().getCode() != 0) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // com.obric.memorydata.awareness.api.IAwarenessManager
    public ar<Boolean> observeAnyListener(String r3) {
        Intrinsics.checkNotNullParameter(r3, "event");
        if (countObservableListeners(r3) <= 0) goto L5;
        final boolean r2 = true;
    L6:
        ConcurrentHashMap<String, ae<Boolean>> r0 = hasListenerStateMap;
        final Function1 r1 = new $$Lambda$AwarenessManagerImpl$W4YQLfrVsPVctlNDFsbQq6Img(r2);
        ae<Boolean> r4 = r0.computeIfAbsent(r3, new $$Lambda$AwarenessManagerImpl$Q5rwizTtfVP7VhfmreP2L98lfik(r1));
        Intrinsics.checkNotNullExpressionValue(r4, "computeIfAbsent(...)");
        return (ar) ZeusTransformUtils.preCheckCast(r4, ar.class, "com.obric.memorydata.plugin");
    L5:
        r2 = false;
        goto L6
    }

    @Override // com.obric.memorydata.awareness.api.IAwarenessManager
    public void onFeatureChanged(String r8, Object r9, Object r10, Map<String, ? extends Object> r11) {
        Map<String, ? extends Object> r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r11, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r8, "feature");
        com.obric.memorydata.awareness.a.a.f8504a.a(r8, r9, r10, r7);
        Map<String, List<com.obric.memorydata.awareness.api.a>> r12 = awarenessEventListenerMap;
        monitor-enter(r12);
        List r0 = (List) ZeusTransformUtils.preCheckCast(r12.get(r8), List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L20
        if (r0 == null) goto L7;
        List r1 = CollectionsKt.toList((Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L20
    L8:
        if (r1 != null) goto L10;
        r1 = CollectionsKt.emptyList();     // Catch: Throwable -> L20
    L10:
        monitor-exit(r12);
        if (b.f8632a.a().contains(r8) == false) goto L14;
        IRunLog r2 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        String r3 = TAG;
        StringBuilder r13 = new StringBuilder().append("onFeatureChanged ").append(r8);
    L15:
        IRunLog.a.a(r2, r3, r13.toString(), false, 4, null);
        Iterator r14 = ((Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L17:
        if (r14.hasNext() == false) goto L19;
        ((com.obric.memorydata.awareness.api.a) ZeusTransformUtils.preCheckCast(r14.next(), com.obric.memorydata.awareness.api.a.class, "com.obric.memorydata.plugin")).a(r8, r9, r10, r7);
        goto L17
    L19:
        return;
    L14:
        r2 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        r3 = TAG;
        r13 = new StringBuilder().append("onFeatureChanged ").append(r8).append(", value ").append(r10).append(" extra = ").append(r7);
        goto L15
    L7:
        r1 = null;
    L20:
        th = move-exception;
        throw th;
    }

    @Override // com.obric.memorydata.awareness.api.IAwarenessManager
    public void onFeatureEvent(String r8, Object r9, Object r10, Map<String, ? extends Object> r11) {
        Map<String, ? extends Object> r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r11, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r8, "feature");
        Map<String, List<com.obric.memorydata.awareness.api.a>> r12 = awarenessEventListenerMap;
        monitor-enter(r12);
        List r0 = (List) ZeusTransformUtils.preCheckCast(r12.get(r8), List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L20
        if (r0 == null) goto L7;
        List r1 = CollectionsKt.toList((Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L20
    L8:
        if (r1 != null) goto L10;
        r1 = CollectionsKt.emptyList();     // Catch: Throwable -> L20
    L10:
        monitor-exit(r12);
        if (b.f8632a.a().contains(r8) == false) goto L14;
        IRunLog r2 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        String r3 = TAG;
        StringBuilder r13 = new StringBuilder().append("onFeatureEvent ").append(r8);
    L15:
        IRunLog.a.a(r2, r3, r13.toString(), false, 4, null);
        Iterator r14 = ((Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L17:
        if (r14.hasNext() == false) goto L19;
        ((com.obric.memorydata.awareness.api.a) ZeusTransformUtils.preCheckCast(r14.next(), com.obric.memorydata.awareness.api.a.class, "com.obric.memorydata.plugin")).b(r8, r9, r10, r7);
        goto L17
    L19:
        return;
    L14:
        r2 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        r3 = TAG;
        r13 = new StringBuilder().append("onFeatureEvent ").append(r8).append(", value ").append(r10).append(" extra = ").append(r7);
        goto L15
    L7:
        r1 = null;
    L20:
        th = move-exception;
        throw th;
    }

    @Override // com.obric.memorydata.awareness.api.IAwarenessManager
    public void registerAwarenessEvent(String r8, com.obric.memorydata.awareness.api.a r9) {
        com.obric.memorydata.awareness.api.a r10 = (com.obric.memorydata.awareness.api.a) ZeusTransformUtils.wrapperContextForParams(r9, com.obric.memorydata.awareness.api.a.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r8, "event");
        Intrinsics.checkNotNullParameter(r10, "listener");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "registerAwarenessEvent " + r8, false, 4, null);
        Map<String, List<com.obric.memorydata.awareness.api.a>> r0 = awarenessEventListenerMap;
        monitor-enter(r0);
    L22:
        th = move-exception;
        throw th;
    L5:
        if (r0.containsKey(r8) == true) goto L7;
        r0.put(r8, (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L22
    L7:
        List r1 = (List) ZeusTransformUtils.preCheckCast(r0.get(r8), List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L22
        boolean r2 = true;
        if (r1 != null) goto L10;
    L12:
        r2 = false;
    L13:
        if (r2 == false) goto L16;
        monitor-exit(r0);
        return;
    L16:
        List r3 = (List) ZeusTransformUtils.preCheckCast(r0.get(r8), List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L22
        if (r3 == null) goto L19;
        Boolean.valueOf(r3.add(r10));     // Catch: Throwable -> L22
    L19:
        monitor-exit(r0);
        updateState(r8);
        return;
    L10:
        if (r1.contains(r10) != true) goto L12;
        goto L12
    }

    @Override // com.obric.memorydata.awareness.api.IAwarenessManager
    public List<Double> resolveAtHomeEventLocation() {
        Pair<Double, Double> r3 = com.obric.memorydata.awareness.cae.f.f8574a.a().e();
        if (r3 != null) goto L7;
        return null;
    L7:
        return CollectionsKt.listOf(new Double[]{r3.getFirst(), r3.getSecond()});
    }

    @Override // com.obric.memorydata.awareness.api.IAwarenessManager
    public void unregisterAwarenessEvent(String r8, com.obric.memorydata.awareness.api.a r9) {
        com.obric.memorydata.awareness.api.a r10 = (com.obric.memorydata.awareness.api.a) ZeusTransformUtils.wrapperContextForParams(r9, com.obric.memorydata.awareness.api.a.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r8, "event");
        Intrinsics.checkNotNullParameter(r10, "listener");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "unregisterAwarenessEvent " + r8, false, 4, null);
        Map<String, List<com.obric.memorydata.awareness.api.a>> r0 = awarenessEventListenerMap;
        monitor-enter(r0);
        List r1 = (List) ZeusTransformUtils.preCheckCast(r0.get(r8), List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L14
        if (r1 != null) goto L7;
        boolean r11 = false;
    L10:
        monitor-exit(r0);
        if (r11 == false) goto L19;
        updateState(r8);
        return;
    L19:
        return;
    L7:
        r11 = r1.remove(r10);     // Catch: Throwable -> L14
        if (r1.isEmpty() == false) goto L10;
        r0.remove(r8);     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        throw th;
    }

    @Override // com.obric.memorydata.awareness.api.IAwarenessManager
    public void updatePackageInfo(boolean r7) {
        clearLocationContextStoreOnProcessStart(r7);
        kotlinx.coroutines.i.a(packageUpdateScope, null, null, (Function2) ZeusTransformUtils.preCheckCast(new C11011(r7, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    }
}
