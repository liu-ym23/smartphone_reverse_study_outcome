package com.obric.memorydata.awareness.impl.location;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.location.LocationManager;
import android.security.obric.guard.ObricSecurityGuardStub;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.bdlocation.monitor.InfoRequestQPSOptTraceLogger;
import com.bytedance.crash.entity.EventBody;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.obric.memorydata.awareness.LocationSnapshot;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.utils.handler.GlobalHandlerUtil;
import com.obric.memorydata.utils.threadpool.ThreadPoolContainer;
import com.volcengine.zeus.receiver.PluginBroadcastReceiver;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.flow.ae;
import kotlinx.coroutines.flow.ar;
import kotlinx.coroutines.flow.at;
import kotlinx.coroutines.flow.k;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0018\b\u0000\u0018\u0000 F2\u00020\u0001:\nFGHIJKLMNOB_\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\u0006\u0010)\u001a\u00020\tJ\u000e\u0010*\u001a\u00020\t2\u0006\u0010+\u001a\u00020,J\u000e\u0010-\u001a\u00020\t2\u0006\u0010+\u001a\u00020,J\u0018\u0010.\u001a\u00020\t2\u0006\u0010+\u001a\u00020,2\b\b\u0002\u0010/\u001a\u00020$J\u0006\u00100\u001a\u00020\tJ\u0006\u00101\u001a\u00020\u0013J\u0006\u00102\u001a\u00020\u0013J\r\u00103\u001a\u00020\u001fH\u0000¢\u0006\u0002\b4J\u0018\u00105\u001a\u00020\t2\u0006\u00106\u001a\u00020\u00162\u0006\u0010+\u001a\u00020,H\u0002J\u0010\u00107\u001a\u0002082\u0006\u00106\u001a\u00020\u0016H\u0002JH\u00109\u001a\u00020\t2\u0006\u0010:\u001a\u00020\u00132\u0006\u0010;\u001a\u00020\u00132\u0006\u0010<\u001a\u00020\u00132\u0006\u0010=\u001a\u00020\u00132\u0006\u0010>\u001a\u00020\u00132\u0006\u0010?\u001a\u00020\u001f2\u0006\u0010@\u001a\u00020\u001f2\u0006\u0010+\u001a\u00020,H\u0002J\b\u0010A\u001a\u00020\tH\u0002J\b\u0010B\u001a\u00020\tH\u0002J\b\u0010C\u001a\u00020\tH\u0002J\u0010\u0010D\u001a\u00020\t2\u0006\u0010E\u001a\u00020\u0013H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00130\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00130\u001b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u001e\u0010 \u001a\u00020\u001f2\u0006\u0010\u001e\u001a\u00020\u001f@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\b!\u0010\"R\u000e\u0010#\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006P"}, d2 = {"Lcom/obric/memorydata/awareness/impl/location/GeofenceRuntimeAvailabilityManager;", "", "environmentMonitor", "Lcom/obric/memorydata/awareness/impl/location/GeofenceRuntimeAvailabilityManager$EnvironmentMonitor;", "scheduler", "Lcom/obric/memorydata/awareness/impl/location/GeofenceRuntimeAvailabilityManager$DelayScheduler;", "locationExpiryScheduler", "onReconciliationDue", "Lkotlin/Function0;", "", "onReconciliationCancelled", "onLocationExpired", "onLocationRefreshRequested", "logger", "Lcom/obric/memorydata/awareness/impl/location/GeofenceRuntimeAvailabilityManager$Logger;", "<init>", "(Lcom/obric/memorydata/awareness/impl/location/GeofenceRuntimeAvailabilityManager$EnvironmentMonitor;Lcom/obric/memorydata/awareness/impl/location/GeofenceRuntimeAvailabilityManager$DelayScheduler;Lcom/obric/memorydata/awareness/impl/location/GeofenceRuntimeAvailabilityManager$DelayScheduler;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lcom/obric/memorydata/awareness/impl/location/GeofenceRuntimeAvailabilityManager$Logger;)V", "lock", "started", "", "environmentInitialized", "environmentState", "Lcom/obric/memorydata/awareness/impl/location/GeofenceRuntimeAvailabilityManager$EnvironmentState;", "snapshotSourceReady", "_realtimeEventsAvailable", "Lkotlinx/coroutines/flow/MutableStateFlow;", "realtimeEventsAvailable", "Lkotlinx/coroutines/flow/StateFlow;", "getRealtimeEventsAvailable", "()Lkotlinx/coroutines/flow/StateFlow;", EventBody.KEY_VALUE, "Lcom/obric/memorydata/awareness/impl/location/GeofenceRuntimeAvailabilityManager$State;", "state", "setState", "(Lcom/obric/memorydata/awareness/impl/location/GeofenceRuntimeAvailabilityManager$State;)V", "pendingDelayMs", "", "scheduledDelayMs", "reconciliationScheduled", "snapshotCollectionInProgress", "locationExpiryScheduled", CommonConsts.APM_INNER_EVENT_COST_START, "onSnapshotSourceReady", InfoRequestQPSOptTraceLogger.REASON, "", "onSnapshotSourceUnavailable", "requestReconciliation", "settlingDelayMs", "completeReconciliation", "shouldAcceptRealtimeEvents", "canCollectSnapshot", "currentState", "currentState$awareness_obricRelease", "onEnvironmentChanged", "next", "updateEnvironmentState", "Lcom/obric/memorydata/awareness/impl/location/GeofenceRuntimeAvailabilityManager$EnvironmentTransition;", "applyEnvironmentTransitionEffects", "shouldCancelReconciliation", "shouldScheduleLocationExpiry", "shouldCancelLocationExpiry", "shouldRequestLocationRefresh", "locationEnabled", "previousState", "nextState", "onLocationExpiryTimer", "scheduleReconciliationIfNeeded", "onReconciliationTimer", "cancelPendingReconciliation", "clearPendingDelay", "Companion", "State", "EnvironmentState", "EnvironmentTransition", "EnvironmentMonitor", "DelayScheduler", "Logger", "HandlerDelayScheduler", "RunLogger", "AndroidEnvironmentMonitor", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class GeofenceRuntimeAvailabilityManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f8718a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final d f8719b;
    private final c c;
    private final c d;
    private final Function0<Unit> e;
    private final Function0<Unit> f;
    private final Function0<Unit> g;
    private final Function0<Unit> h;
    private final h i;
    private final Object j;
    private boolean k;
    private boolean l;
    private e m;
    private boolean n;
    private final ae<Boolean> o;
    private final ar<Boolean> p;
    private State q;
    private long r;
    private long s;
    private boolean t;
    private boolean u;
    private boolean v;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/memorydata/awareness/impl/location/GeofenceRuntimeAvailabilityManager$State;", "", "<init>", "(Ljava/lang/String;I)V", "AVAILABLE", "UNAVAILABLE", "RECONCILING", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final enum State extends Enum<State> {
        private static final /* synthetic */ EnumEntries $ENTRIES = null;
        private static final /* synthetic */ State[] $VALUES = null;
        public static final State AVAILABLE = null;
        public static final State RECONCILING = null;
        public static final State UNAVAILABLE = null;

        private static final /* synthetic */ State[] $values() {
            return new State[]{AVAILABLE, UNAVAILABLE, RECONCILING};
        }

        static {
            AVAILABLE = new State("AVAILABLE", 0);
            UNAVAILABLE = new State("UNAVAILABLE", 1);
            RECONCILING = new State("RECONCILING", 2);
            State[] r0 = $values();
            $VALUES = r0;
            $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
        }

        private State(String r1, int r2) {
            super(r1, r2);
        }

        public static EnumEntries<State> getEntries() {
            return $ENTRIES;
        }

        public static State valueOf(String r2) {
            return (State) ZeusTransformUtils.preCheckCast(Enum.valueOf(State.class, r2), State.class, "com.obric.memorydata.plugin");
        }

        public static State[] values() {
            return (State[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), State[].class, "com.obric.memorydata.plugin");
        }
    }

    @Metadata(d1 = {"\u0000?\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\b\u0007*\u0001\u0013\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\"\u0010\u0015\u001a\u00020\u00102\u0018\u0010\f\u001a\u0014\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\rH\u0016J\u0010\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u000fH\u0002J\b\u0010\u0018\u001a\u00020\u000eH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\f\u001a\u0016\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0014¨\u0006\u0019"}, d2 = {"Lcom/obric/memorydata/awareness/impl/location/GeofenceRuntimeAvailabilityManager$AndroidEnvironmentMonitor;", "Lcom/obric/memorydata/awareness/impl/location/GeofenceRuntimeAvailabilityManager$EnvironmentMonitor;", "context", "Landroid/content/Context;", "logger", "Lcom/obric/memorydata/awareness/impl/location/GeofenceRuntimeAvailabilityManager$Logger;", "<init>", "(Landroid/content/Context;Lcom/obric/memorydata/awareness/impl/location/GeofenceRuntimeAvailabilityManager$Logger;)V", "lock", "", "started", "", "listener", "Lkotlin/Function2;", "Lcom/obric/memorydata/awareness/impl/location/GeofenceRuntimeAvailabilityManager$EnvironmentState;", "", "", "lastState", "locationReceiver", "com/obric/memorydata/awareness/impl/location/GeofenceRuntimeAvailabilityManager$AndroidEnvironmentMonitor$locationReceiver$1", "Lcom/obric/memorydata/awareness/impl/location/GeofenceRuntimeAvailabilityManager$AndroidEnvironmentMonitor$locationReceiver$1;", CommonConsts.APM_INNER_EVENT_COST_START, "refresh", InfoRequestQPSOptTraceLogger.REASON, "readCurrentState", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class a implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Context f8720a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final h f8721b;
        private final Object c;
        private boolean d;
        private Function2<? super e, ? super String, Unit> e;
        private e f;
        private final C0444a g;

        /* JADX INFO: renamed from: com.obric.memorydata.awareness.impl.location.GeofenceRuntimeAvailabilityManager$a$a, reason: collision with other inner class name */
        @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, d2 = {"com/obric/memorydata/awareness/impl/location/GeofenceRuntimeAvailabilityManager$AndroidEnvironmentMonitor$locationReceiver$1", "Landroid/content/BroadcastReceiver;", "onReceive", "", "context", "Landroid/content/Context;", MemorySourceLinkType.INTENT, "Landroid/content/Intent;", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class C0444a extends PluginBroadcastReceiver {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ a f8722a;

            C0444a(a r1) {
                this.f8722a = r1;
            }

            public void onReceive(Context r3, Intent r4) {
                Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
                a r2 = this.f8722a;
                StringBuilder r6 = new StringBuilder().append("定位服务状态变化：");
                if (r4 == null) goto L5;
                String r7 = r4.getAction();
            L6:
                a.a(r2, r6.append(r7).toString());
                return;
            L5:
                r7 = null;
                goto L6
            }
        }

        public a(Context r3, h r4) {
            Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
            h r6 = (h) ZeusTransformUtils.wrapperContextForParams(r4, h.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "context");
            Intrinsics.checkNotNullParameter(r6, "logger");
            this.f8720a = ZeusTransformUtils.wrapperContext(r5, "com.obric.memorydata.plugin");
            this.f8721b = r6;
            this.c = new Object();
            this.g = new C0444a(this);
        }

        private final e a() {
            Object r2 = this.f8720a.getSystemService("location");
            Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type android.location.LocationManager");
            return new e(((LocationManager) ZeusTransformUtils.preCheckCast(r2, LocationManager.class, "com.obric.memorydata.plugin")).isLocationEnabled());
        }

        public static final /* synthetic */ void a(a r0, String r1) {
            r0.a(r1);
        }

        private final void a(String r6) {
            e r0 = a();
            Object r1 = this.c;
            monitor-enter(r1);
            e r2 = this.f;     // Catch: Throwable -> L16
            if (Intrinsics.areEqual(r0, r2) == false) goto L7;
            boolean r3 = false;
            Function2<? super e, ? super String, Unit> r4 = null;
        L9:
            monitor-exit(r1);
            if (r3 == true) goto L12;
            return;
        L12:
            this.f8721b.a("检测到围栏运行环境变化，reason=" + r6 + "，previous=" + r2 + "，current=" + r0);
            if (r4 == null) goto L21;
            r4.invoke(r0, r6);
            return;
        L21:
            return;
        L7:
            this.f = r0;     // Catch: Throwable -> L16
            r4 = this.e;     // Catch: Throwable -> L16
            r3 = true;
        L16:
            th = move-exception;
            throw th;
        }

        @Override // com.obric.memorydata.awareness.impl.location.GeofenceRuntimeAvailabilityManager.d
        public void a(Function2<? super e, ? super String, Unit> r5) {
            Function2<? super e, ? super String, Unit> r6 = (Function2) ZeusTransformUtils.wrapperContextForParams(r5, Function2.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r6, "listener");
            Object r0 = this.c;
            monitor-enter(r0);
            this.e = r6;     // Catch: Throwable -> L13
            boolean r1 = true;
            if (this.d == false) goto L7;
            r1 = false;
        L8:
            monitor-exit(r0);
            if (r1 == true) goto L11;
            return;
        L11:
            Context r7 = this.f8720a;
            PluginBroadcastReceiver r2 = (PluginBroadcastReceiver) ZeusTransformUtils.preCheckCast(this.g, PluginBroadcastReceiver.class, "com.obric.memorydata.plugin");
            IntentFilter r3 = new IntentFilter();
            r3.addAction("android.location.MODE_CHANGED");
            r3.addAction("android.location.PROVIDERS_CHANGED");
            Unit r4 = Unit.INSTANCE;
            ZeusTransformUtils.registerReceiver(r7, r2, r3, 2, "com.obric.memorydata.plugin");
            a("围栏运行环境初始化");
            return;
        L7:
            this.d = true;     // Catch: Throwable -> L13
        L13:
            th = move-exception;
            throw th;
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J8\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/obric/memorydata/awareness/impl/location/GeofenceRuntimeAvailabilityManager$Companion;", "", "<init>", "()V", "TAG", "", "STARTUP_SETTLING_DELAY_MS", "", "LOCATION_RECOVERY_DELAY_MS", "LOCATION_EXPIRY_DELAY_MS", "create", "Lcom/obric/memorydata/awareness/impl/location/GeofenceRuntimeAvailabilityManager;", "context", "Landroid/content/Context;", "onReconciliationDue", "Lkotlin/Function0;", "", "onReconciliationCancelled", "onLocationExpired", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker r1) {
            this();
        }

        private static final void a() {
            LocationSnapshot.INSTANCE.getLocation(0);
        }

        private static final Unit b() {
            ThreadPoolContainer.Companion.getInstance().execute($$Lambda$GeofenceRuntimeAvailabilityManager$b$oQsbEyxDrB2_PBmwpAtfvf_ik58.INSTANCE);
            return Unit.INSTANCE;
        }

        public static /* synthetic */ Unit lambda$V2jnAQUj8yHJXE7HtrW2N_nZw6Q() {
            return b();
        }

        public static /* synthetic */ void lambda$oQsbEyxDrB2_PBmwpAtfvf_ik58() {
            a();
        }

        public final GeofenceRuntimeAvailabilityManager a(Context r11, Function0<Unit> r12, Function0<Unit> r13, Function0<Unit> r14) {
            Context r10 = (Context) ZeusTransformUtils.wrapperContextForParams(r11, Context.class, "com.obric.memorydata.plugin");
            Function0 r5 = (Function0) ZeusTransformUtils.wrapperContextForParams(r12, Function0.class, "com.obric.memorydata.plugin");
            Function0 r6 = (Function0) ZeusTransformUtils.wrapperContextForParams(r13, Function0.class, "com.obric.memorydata.plugin");
            Function0 r7 = (Function0) ZeusTransformUtils.wrapperContextForParams(r14, Function0.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r10, "context");
            Intrinsics.checkNotNullParameter(r5, "onReconciliationDue");
            Intrinsics.checkNotNullParameter(r6, "onReconciliationCancelled");
            Intrinsics.checkNotNullParameter(r7, "onLocationExpired");
            i r15 = i.f8728a;
            Context r16 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r10.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullExpressionValue(r16, "getApplicationContext(...)");
            return new GeofenceRuntimeAvailabilityManager((d) ZeusTransformUtils.preCheckCast(new a(r16, (h) ZeusTransformUtils.preCheckCast(r15, h.class, "com.obric.memorydata.plugin")), d.class, "com.obric.memorydata.plugin"), (c) ZeusTransformUtils.preCheckCast(new g(), c.class, "com.obric.memorydata.plugin"), (c) ZeusTransformUtils.preCheckCast(new g(), c.class, "com.obric.memorydata.plugin"), r5, r6, r7, $$Lambda$GeofenceRuntimeAvailabilityManager$b$V2jnAQUj8yHJXE7HtrW2N_nZw6Q.INSTANCE, (h) ZeusTransformUtils.preCheckCast(r15, h.class, "com.obric.memorydata.plugin"));
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007H&J\b\u0010\b\u001a\u00020\u0003H&¨\u0006\t"}, d2 = {"Lcom/obric/memorydata/awareness/impl/location/GeofenceRuntimeAvailabilityManager$DelayScheduler;", "", "schedule", "", "delayMs", "", "action", "Lkotlin/Function0;", ObricSecurityGuardStub.SettingsEventConst.EVENT_RESULT_CANCEL, "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface c {
        void a();

        void a(long r1, Function0<Unit> r3);
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\b`\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\u0018\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00030\u0005H&¨\u0006\b"}, d2 = {"Lcom/obric/memorydata/awareness/impl/location/GeofenceRuntimeAvailabilityManager$EnvironmentMonitor;", "", CommonConsts.APM_INNER_EVENT_COST_START, "", "listener", "Lkotlin/Function2;", "Lcom/obric/memorydata/awareness/impl/location/GeofenceRuntimeAvailabilityManager$EnvironmentState;", "", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface d {
        void a(Function2<? super e, ? super String, Unit> r1);
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\t\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/obric/memorydata/awareness/impl/location/GeofenceRuntimeAvailabilityManager$EnvironmentState;", "", "locationEnabled", "", "<init>", "(Z)V", "getLocationEnabled", "()Z", "available", "getAvailable", "component1", "copy", "equals", "other", "hashCode", "", "toString", "", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f8723a;

        public e(boolean r1) {
            this.f8723a = r1;
        }

        public final boolean a() {
            return this.f8723a;
        }

        public final boolean b() {
            return this.f8723a;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, e.class) == true) goto L8;
            return false;
        L8:
            e r6 = (e) ZeusTransformUtils.preCheckCast(r5, e.class, "com.obric.memorydata.plugin");
            if (this.f8723a == r6.f8723a) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return Boolean.hashCode(this.f8723a);
        }

        public String toString() {
            return "EnvironmentState(locationEnabled=" + this.f8723a + ')';
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\tHÆ\u0003J\t\u0010\u001c\u001a\u00020\tHÆ\u0003JO\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\tHÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u00032\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\t\u0010\"\u001a\u00020#HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\n\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014¨\u0006$"}, d2 = {"Lcom/obric/memorydata/awareness/impl/location/GeofenceRuntimeAvailabilityManager$EnvironmentTransition;", "", "cancelReconciliation", "", "scheduleReconciliation", "scheduleLocationExpiry", "cancelLocationExpiry", "requestLocationRefresh", "previousState", "Lcom/obric/memorydata/awareness/impl/location/GeofenceRuntimeAvailabilityManager$State;", "nextState", "<init>", "(ZZZZZLcom/obric/memorydata/awareness/impl/location/GeofenceRuntimeAvailabilityManager$State;Lcom/obric/memorydata/awareness/impl/location/GeofenceRuntimeAvailabilityManager$State;)V", "getCancelReconciliation", "()Z", "getScheduleReconciliation", "getScheduleLocationExpiry", "getCancelLocationExpiry", "getRequestLocationRefresh", "getPreviousState", "()Lcom/obric/memorydata/awareness/impl/location/GeofenceRuntimeAvailabilityManager$State;", "getNextState", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "", "toString", "", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f8724a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f8725b;
        private final boolean c;
        private final boolean d;
        private final boolean e;
        private final State f;
        private final State g;

        public f(boolean r2, boolean r3, boolean r4, boolean r5, boolean r6, State r7, State r8) {
            Intrinsics.checkNotNullParameter(r7, "previousState");
            Intrinsics.checkNotNullParameter(r8, "nextState");
            this.f8724a = r2;
            this.f8725b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
            this.f = r7;
            this.g = r8;
        }

        public final boolean a() {
            return this.f8724a;
        }

        public final boolean b() {
            return this.f8725b;
        }

        public final boolean c() {
            return this.c;
        }

        public final boolean d() {
            return this.d;
        }

        public final boolean e() {
            return this.e;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, f.class) == true) goto L8;
            return false;
        L8:
            f r6 = (f) ZeusTransformUtils.preCheckCast(r5, f.class, "com.obric.memorydata.plugin");
            if (this.f8724a == r6.f8724a) goto L12;
            return false;
        L12:
            if (this.f8725b == r6.f8725b) goto L15;
            return false;
        L15:
            if (this.c == r6.c) goto L18;
            return false;
        L18:
            if (this.d == r6.d) goto L21;
            return false;
        L21:
            if (this.e == r6.e) goto L24;
            return false;
        L24:
            if (this.f == r6.f) goto L27;
            return false;
        L27:
            if (this.g == r6.g) goto L29;
            return false;
        L29:
            return true;
        }

        public final State f() {
            return this.f;
        }

        public final State g() {
            return this.g;
        }

        public int hashCode() {
            return (((((((((((Boolean.hashCode(this.f8724a) * 31) + Boolean.hashCode(this.f8725b)) * 31) + Boolean.hashCode(this.c)) * 31) + Boolean.hashCode(this.d)) * 31) + Boolean.hashCode(this.e)) * 31) + this.f.hashCode()) * 31) + this.g.hashCode();
        }

        public String toString() {
            return "EnvironmentTransition(cancelReconciliation=" + this.f8724a + ", scheduleReconciliation=" + this.f8725b + ", scheduleLocationExpiry=" + this.c + ", cancelLocationExpiry=" + this.d + ", requestLocationRefresh=" + this.e + ", previousState=" + this.f + ", nextState=" + this.g + ')';
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\rH\u0016J\b\u0010\u000e\u001a\u00020\tH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/obric/memorydata/awareness/impl/location/GeofenceRuntimeAvailabilityManager$HandlerDelayScheduler;", "Lcom/obric/memorydata/awareness/impl/location/GeofenceRuntimeAvailabilityManager$DelayScheduler;", "<init>", "()V", "lock", "", "pendingRunnable", "Ljava/lang/Runnable;", "schedule", "", "delayMs", "", "action", "Lkotlin/Function0;", ObricSecurityGuardStub.SettingsEventConst.EVENT_RESULT_CANCEL, "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class g implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Object f8726a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Runnable f8727b;

        public g() {
            this.f8726a = new Object();
        }

        private static final void a(g r2, Function0 r3) {
            Function0 r4 = (Function0) ZeusTransformUtils.wrapperContextForParams(r3, Function0.class, "com.obric.memorydata.plugin");
            Object r0 = r2.f8726a;
            monitor-enter(r0);
            r2.f8727b = null;     // Catch: Throwable -> L9
            Unit r5 = Unit.INSTANCE;     // Catch: Throwable -> L9
            monitor-exit(r0);
            r4.invoke();
            return;
        L9:
            th = move-exception;
            throw th;
        }

        public static /* synthetic */ void lambda$w0QLfeUUfZYchIFC3b8bNR6AyfA(g r0, Function0 r1) {
            a(r0, r1);
        }

        @Override // com.obric.memorydata.awareness.impl.location.GeofenceRuntimeAvailabilityManager.c
        public void a() {
            Object r0 = this.f8726a;
            monitor-enter(r0);
            Runnable r1 = this.f8727b;     // Catch: Throwable -> L9
            this.f8727b = null;     // Catch: Throwable -> L9
            monitor-exit(r0);
            if (r1 == null) goto L14;
            GlobalHandlerUtil.Companion.getInstance().removeCallbacks(r1);
            return;
        L14:
            return;
        L9:
            th = move-exception;
            throw th;
        }

        @Override // com.obric.memorydata.awareness.impl.location.GeofenceRuntimeAvailabilityManager.c
        public void a(long r3, Function0<Unit> r5) {
            final Function0 r6 = (Function0) ZeusTransformUtils.wrapperContextForParams(r5, Function0.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r6, "action");
            Runnable r0 = new $$Lambda$GeofenceRuntimeAvailabilityManager$g$w0QLfeUUfZYchIFC3b8bNR6AyfA(this, r6);
            Object r7 = this.f8726a;
            monitor-enter(r7);
            this.f8727b = r0;     // Catch: Throwable -> L8
            Unit r2 = Unit.INSTANCE;     // Catch: Throwable -> L8
            monitor-exit(r7);
            GlobalHandlerUtil.Companion.getInstance().postDelay(r3, r0);
            return;
        L8:
            th = move-exception;
            throw th;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/obric/memorydata/awareness/impl/location/GeofenceRuntimeAvailabilityManager$Logger;", "", "info", "", "message", "", "debug", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface h {
        void a(String r1);

        void b(String r1);
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\t"}, d2 = {"Lcom/obric/memorydata/awareness/impl/location/GeofenceRuntimeAvailabilityManager$RunLogger;", "Lcom/obric/memorydata/awareness/impl/location/GeofenceRuntimeAvailabilityManager$Logger;", "<init>", "()V", "info", "", "message", "", "debug", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class i implements h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final i f8728a = null;

        static {
            f8728a = new i();
        }

        private i() {
        }

        @Override // com.obric.memorydata.awareness.impl.location.GeofenceRuntimeAvailabilityManager.h
        public void a(String r7) {
            Intrinsics.checkNotNullParameter(r7, "message");
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "GeofenceRuntime", r7, false, 4, null);
        }

        @Override // com.obric.memorydata.awareness.impl.location.GeofenceRuntimeAvailabilityManager.h
        public void b(String r2) {
            Intrinsics.checkNotNullParameter(r2, "message");
            RunLog.INSTANCE.debug("GeofenceRuntime", r2);
        }
    }

    static {
        f8718a = new b(null);
    }

    public GeofenceRuntimeAvailabilityManager(d r3, c r4, c r5, Function0<Unit> r6, Function0<Unit> r7, Function0<Unit> r8, Function0<Unit> r9, h r10) {
        d r11 = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.memorydata.plugin");
        c r12 = (c) ZeusTransformUtils.wrapperContextForParams(r4, c.class, "com.obric.memorydata.plugin");
        c r13 = (c) ZeusTransformUtils.wrapperContextForParams(r5, c.class, "com.obric.memorydata.plugin");
        Function0<Unit> r14 = (Function0) ZeusTransformUtils.wrapperContextForParams(r6, Function0.class, "com.obric.memorydata.plugin");
        Function0<Unit> r15 = (Function0) ZeusTransformUtils.wrapperContextForParams(r7, Function0.class, "com.obric.memorydata.plugin");
        Function0<Unit> r16 = (Function0) ZeusTransformUtils.wrapperContextForParams(r8, Function0.class, "com.obric.memorydata.plugin");
        Function0<Unit> r17 = (Function0) ZeusTransformUtils.wrapperContextForParams(r9, Function0.class, "com.obric.memorydata.plugin");
        h r18 = (h) ZeusTransformUtils.wrapperContextForParams(r10, h.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r11, "environmentMonitor");
        Intrinsics.checkNotNullParameter(r12, "scheduler");
        Intrinsics.checkNotNullParameter(r13, "locationExpiryScheduler");
        Intrinsics.checkNotNullParameter(r14, "onReconciliationDue");
        Intrinsics.checkNotNullParameter(r15, "onReconciliationCancelled");
        Intrinsics.checkNotNullParameter(r16, "onLocationExpired");
        Intrinsics.checkNotNullParameter(r17, "onLocationRefreshRequested");
        Intrinsics.checkNotNullParameter(r18, "logger");
        this.f8719b = r11;
        this.c = r12;
        this.d = r13;
        this.e = r14;
        this.f = r15;
        this.g = r16;
        this.h = r17;
        this.i = r18;
        this.j = new Object();
        this.m = new e(false);
        ae<Boolean> r19 = at.a(false);
        this.o = r19;
        this.p = k.a(r19);
        this.q = State.UNAVAILABLE;
    }

    private final f a(e r13) {
        Object r0 = this.j;
        monitor-enter(r0);
        boolean r1 = this.l;     // Catch: Throwable -> L37
        boolean r2 = this.m.b();     // Catch: Throwable -> L37
        this.l = true;     // Catch: Throwable -> L37
        this.m = r13;     // Catch: Throwable -> L37
        State r10 = this.q;     // Catch: Throwable -> L37
        boolean r6 = false;
        if (r13.b() == false) goto L7;
        if (r1 == true) goto L23;
        boolean r14 = this.v;     // Catch: Throwable -> L37
        this.v = false;     // Catch: Throwable -> L37
        a(State.RECONCILING);     // Catch: Throwable -> L37
        if (this.n == false) goto L22;
        this.r = 5000;     // Catch: Throwable -> L37
        boolean r8 = r14;
        boolean r5 = false;
        boolean r7 = false;
        boolean r9 = false;
        r6 = true;
    L34:
        f r15 = new f(r5, r6, r7, r8, r9, r10, this.q);     // Catch: Throwable -> L37
        monitor-exit(r0);
        return r15;
    L22:
        r8 = r14;
        r5 = false;
        r7 = false;
        r9 = false;
        goto L34
    L23:
        if (r2 == true) goto L32;
        boolean r16 = this.v;     // Catch: Throwable -> L37
        this.v = false;     // Catch: Throwable -> L37
        if (this.t == false) goto L27;
    L30:
        boolean r3 = true;
    L31:
        a(State.RECONCILING);     // Catch: Throwable -> L37
        this.t = false;     // Catch: Throwable -> L37
        this.s = 0;     // Catch: Throwable -> L37
        this.u = false;     // Catch: Throwable -> L37
        this.r = 60000;     // Catch: Throwable -> L37
        r8 = r16;
        r5 = r3;
        r9 = true;
        r7 = false;
        r6 = this.n;     // Catch: Throwable -> L37
        goto L34
    L27:
        if (this.u == true) goto L30;
        r3 = false;
        goto L31
    L32:
        r5 = false;
        r7 = false;
        r8 = false;
    L33:
        r9 = r8;
        goto L34
    L7:
        if (this.t == false) goto L9;
    L12:
        boolean r17 = true;
    L14:
        if (this.v == true) goto L16;
        boolean r4 = true;
    L17:
        this.v = true;     // Catch: Throwable -> L37
        a(State.UNAVAILABLE);     // Catch: Throwable -> L37
        this.t = false;     // Catch: Throwable -> L37
        this.s = 0;     // Catch: Throwable -> L37
        this.u = false;     // Catch: Throwable -> L37
        this.r = 0;     // Catch: Throwable -> L37
        r5 = r17;
        r7 = r4;
        r8 = false;
        goto L33
    L16:
        r4 = false;
        goto L17
    L9:
        if (this.u == true) goto L12;
        r17 = false;
    L37:
        th = move-exception;
        throw th;
    }

    private final void a(State r2) {
        this.q = r2;
        ae<Boolean> r1 = this.o;
        if (r2 != State.AVAILABLE) goto L5;
        boolean r3 = true;
    L6:
        r1.b(Boolean.valueOf(r3));
        return;
    L5:
        r3 = false;
        goto L6
    }

    private final void a(e r11, String r12) {
        f r0 = a(r11);
        a(r0.a(), r0.c(), r0.d(), r0.e(), r11.a(), r0.f(), r0.g(), r12);
        if (r0.b() == false) goto L6;
        h();
        return;
    }

    public static final /* synthetic */ void a(GeofenceRuntimeAvailabilityManager r0) {
        r0.g();
    }

    public static final /* synthetic */ void a(GeofenceRuntimeAvailabilityManager r0, e r1, String r2) {
        r0.a(r1, r2);
    }

    public static /* synthetic */ void a(GeofenceRuntimeAvailabilityManager r0, String r1, long r2, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L5;
        r2 = 5000;
    L5:
        r0.a(r1, r2);
    }

    private final void a(boolean r5) {
        Object r0 = this.j;
        monitor-enter(r0);
        this.t = false;     // Catch: Throwable -> L12
        this.s = 0;     // Catch: Throwable -> L12
        this.u = false;     // Catch: Throwable -> L12
        if (r5 == false) goto L8;
        this.r = 0;     // Catch: Throwable -> L12
    L8:
        Unit r6 = Unit.INSTANCE;     // Catch: Throwable -> L12
        monitor-exit(r0);
        this.c.a();
        this.f.invoke();
        return;
    L12:
        th = move-exception;
        throw th;
    }

    private final void a(boolean r3, boolean r4, boolean r5, boolean r6, boolean r7, State r8, State r9, String r10) {
        if (r3 == false) goto L4;
        this.c.a();
        this.f.invoke();
    L4:
        if (r5 == false) goto L6;
        this.d.a();
        this.i.a("GPS 已恢复，取消当前位置失效任务");
    L6:
        if (r6 == false) goto L8;
        this.i.a("检测到 GPS 恢复，主动请求一次定位");
        this.h.invoke();
    L8:
        if (r4 == false) goto L10;
        this.d.a(300000, (Function0) ZeusTransformUtils.preCheckCast(new GeofenceRuntimeAvailabilityManager$applyEnvironmentTransitionEffects$1(this), Function0.class, "com.obric.memorydata.plugin"));
        this.i.a("GPS 持续不可用时将清空当前位置，delayMs=300000");
    L10:
        this.i.a("围栏运行环境变化，locationEnabled=" + r7 + "，state=" + r8 + "->" + r9 + "，reason=" + r10);
    }

    public static final /* synthetic */ void b(GeofenceRuntimeAvailabilityManager r0) {
        r0.i();
    }

    private final void g() {
        Object r0 = this.j;
        monitor-enter(r0);
        boolean r2 = false;
        if (this.v == true) goto L7;
    L11:
        monitor-exit(r0);
        if (r2 == true) goto L14;
        return;
    L14:
        this.i.a("GPS 已持续不可用五分钟，当前位置状态失效");
        this.g.invoke();
        return;
    L7:
        if (this.m.b() == true) goto L11;
        this.v = false;     // Catch: Throwable -> L16
        r2 = true;
    L16:
        th = move-exception;
        throw th;
    }

    private final void h() {
        Object r0 = this.j;
        monitor-enter(r0);
    L25:
        th = move-exception;
        throw th;
    L5:
        if (this.q == State.RECONCILING) goto L7;
    L23:
        monitor-exit(r0);
        return;
    L7:
        if (this.m.b() == false) goto L23;
        if (this.n == false) goto L23;
        long r1 = RangesKt.coerceAtLeast(this.r, 5000);     // Catch: Throwable -> L25
        if (this.t == false) goto L19;
        if (this.s < r1) goto L19;
        monitor-exit(r0);
        return;
    L19:
        this.t = true;     // Catch: Throwable -> L25
        this.s = r1;     // Catch: Throwable -> L25
        monitor-exit(r0);
        this.c.a();
        this.c.a(r1, (Function0) ZeusTransformUtils.preCheckCast(new GeofenceRuntimeAvailabilityManager$scheduleReconciliationIfNeeded$1(this), Function0.class, "com.obric.memorydata.plugin"));
        this.i.a("位置恢复对账已排期，delayMs=" + r1);
    }

    private final void i() {
        Object r0 = this.j;
        monitor-enter(r0);
        boolean r1 = false;
        this.t = false;     // Catch: Throwable -> L18
        this.s = 0;     // Catch: Throwable -> L18
        if (this.q == State.RECONCILING) goto L8;
    L14:
        monitor-exit(r0);
        if (r1 == false) goto L23;
        this.i.a("位置环境稳定窗口结束，开始读取 CAE 围栏和 AOI 快照");
        this.e.invoke();
        return;
    L23:
        return;
    L8:
        if (this.m.b() == false) goto L14;
        if (this.n == false) goto L14;
        this.r = 0;     // Catch: Throwable -> L18
        this.u = true;     // Catch: Throwable -> L18
        r1 = true;
    L18:
        th = move-exception;
        throw th;
    }

    public final ar<Boolean> a() {
        return this.p;
    }

    public final void a(String r8) {
        Intrinsics.checkNotNullParameter(r8, InfoRequestQPSOptTraceLogger.REASON);
        Object r0 = this.j;
        monitor-enter(r0);
    L25:
        th = move-exception;
        throw th;
    L5:
        if (this.n == false) goto L8;
        monitor-exit(r0);
        return;
    L8:
        boolean r1 = true;
        this.n = true;     // Catch: Throwable -> L25
        if (this.m.b() == true) goto L14;
        monitor-exit(r0);
        return;
    L14:
        if (this.q != State.AVAILABLE) goto L16;
    L19:
        a(State.RECONCILING);     // Catch: Throwable -> L25
        this.u = false;     // Catch: Throwable -> L25
        this.r = Math.max(this.r, 5000);     // Catch: Throwable -> L25
        Unit r2 = Unit.INSTANCE;     // Catch: Throwable -> L25
        monitor-exit(r0);
        if (r1 == false) goto L23;
        a(false);
    L23:
        this.i.a("位置快照通道已就绪，进入恢复对账，reason=" + r8);
        h();
        return;
    L16:
        if (this.u == true) goto L19;
        r1 = false;
        goto L19
    }

    public final void a(String r6, long r7) {
        Intrinsics.checkNotNullParameter(r6, InfoRequestQPSOptTraceLogger.REASON);
        Object r0 = this.j;
        monitor-enter(r0);
    L23:
        th = move-exception;
        throw th;
    L5:
        if (this.m.b() == true) goto L9;
        monitor-exit(r0);
        return;
    L9:
        if (this.t == false) goto L11;
    L14:
        boolean r1 = true;
    L15:
        a(State.RECONCILING);     // Catch: Throwable -> L23
        this.u = false;     // Catch: Throwable -> L23
        this.r = Math.max(this.r, r7);     // Catch: Throwable -> L23
        boolean r3 = this.n;     // Catch: Throwable -> L23
        monitor-exit(r0);
        if (r1 == false) goto L19;
        a(false);
    L19:
        this.i.a("请求位置恢复对账，reason=" + r6 + "，settlingDelayMs=" + r7);
        if (r3 == false) goto L28;
        h();
        return;
    L28:
        return;
    L11:
        if (this.u == true) goto L14;
        r1 = false;
        goto L15
    }

    public final void b() {
        Object r0 = this.j;
        monitor-enter(r0);
        boolean r2 = true;
        if (this.k == false) goto L7;
        r2 = false;
    L8:
        monitor-exit(r0);
        if (r2 == true) goto L11;
        return;
    L11:
        this.f8719b.a((Function2) ZeusTransformUtils.preCheckCast(new GeofenceRuntimeAvailabilityManager$start$1(this), Function2.class, "com.obric.memorydata.plugin"));
        return;
    L7:
        this.k = true;     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;
    }

    public final void b(String r8) {
        Intrinsics.checkNotNullParameter(r8, InfoRequestQPSOptTraceLogger.REASON);
        Object r0 = this.j;
        monitor-enter(r0);
    L24:
        th = move-exception;
        throw th;
    L5:
        if (this.n == true) goto L9;
        monitor-exit(r0);
        return;
    L9:
        this.n = false;     // Catch: Throwable -> L24
        if (this.t == false) goto L12;
    L15:
        boolean r2 = true;
    L16:
        this.t = false;     // Catch: Throwable -> L24
        this.s = 0;     // Catch: Throwable -> L24
        this.u = false;     // Catch: Throwable -> L24
        if (this.m.b() == false) goto L19;
        a(State.RECONCILING);     // Catch: Throwable -> L24
        this.r = Math.max(this.r, 5000);     // Catch: Throwable -> L24
    L19:
        monitor-exit(r0);
        if (r2 == false) goto L22;
        this.c.a();
        this.f.invoke();
    L22:
        this.i.a("位置快照通道不可用，等待通道恢复，reason=" + r8);
        return;
    L12:
        if (this.u == true) goto L15;
        r2 = false;
        goto L16
    }

    public final void c() {
        Object r0 = this.j;
        monitor-enter(r0);
        boolean r3 = false;
        if (this.q == State.RECONCILING) goto L7;
    L15:
        monitor-exit(r0);
        if (r3 == false) goto L18;
        this.i.a("位置恢复对账完成，实时围栏和 AOI 回调恢复处理");
        return;
    L18:
        this.i.b("忽略已失效的位置恢复完成回调，state=" + f());
        return;
    L7:
        if (this.u == false) goto L15;
        if (this.m.b() == false) goto L15;
        if (this.n == false) goto L15;
        a(State.AVAILABLE);     // Catch: Throwable -> L20
        this.u = false;     // Catch: Throwable -> L20
        this.r = 0;     // Catch: Throwable -> L20
        r3 = true;
    L20:
        th = move-exception;
        throw th;
    }

    public final boolean d() {
        Object r0 = this.j;
        monitor-enter(r0);
        if (this.q != State.AVAILABLE) goto L7;
        boolean r2 = true;
    L8:
        monitor-exit(r0);
        return r2;
    L7:
        r2 = false;
    L10:
        th = move-exception;
        throw th;
    }

    public final boolean e() {
        Object r0 = this.j;
        monitor-enter(r0);
    L16:
        th = move-exception;
        throw th;
    L5:
        if (this.q == State.RECONCILING) goto L7;
    L13:
        boolean r3 = false;
    L14:
        monitor-exit(r0);
        return r3;
    L7:
        if (this.u == false) goto L13;
        if (this.m.b() == false) goto L13;
        if (this.n == false) goto L13;
        r3 = true;
        goto L14
    }

    public final State f() {
        Object r0 = this.j;
        monitor-enter(r0);
        State r1 = this.q;     // Catch: Throwable -> L7
        monitor-exit(r0);
        return r1;
    L7:
        th = move-exception;
        throw th;
    }
}
