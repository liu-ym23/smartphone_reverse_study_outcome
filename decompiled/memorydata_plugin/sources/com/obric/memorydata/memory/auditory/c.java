package com.obric.memorydata.memory.auditory;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.SystemClock;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.bdlocation.monitor.InfoRequestQPSOptTraceLogger;
import com.bytedance.common.utility.NetworkUtils;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.obric.memorydata.memory.ui.settings.l;
import com.obric.memorydata.middleware.api.app.UserSettings;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.bridge.AuditoryBridgeAPI;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.middleware.api.settings.SettingsChangeListener;
import com.obric.memorydata.middleware.api.settings.SettingsManager;
import com.obric.memorydata.recommend.RecommendApi;
import com.obric.memorydata.task.condition.AbilityConditionManager;
import com.obric.memorydata.task.condition.Condition;
import com.obric.memorydata.task.condition.j;
import com.obric.memorydata.task.condition.m;
import com.obric.memorydata.task.impl.TaskInfo;
import com.obric.memorydata.task.impl.TaskRequest;
import com.obric.memorydata.task.scheduler.impl.ExistingTaskPolicy;
import com.volcengine.zeus.receiver.PluginBroadcastReceiver;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.al;
import kotlinx.coroutines.am;
import kotlinx.coroutines.ba;
import kotlinx.coroutines.cu;
import kotlinx.coroutines.i;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0097\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0013*\u0007'*-0369\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010;\u001a\u00020<J\b\u0010=\u001a\u00020\fH\u0002J\b\u0010>\u001a\u00020<H\u0002J\b\u0010?\u001a\u00020<H\u0002J\b\u0010@\u001a\u00020<H\u0002J\u0010\u0010A\u001a\u00020<2\u0006\u0010B\u001a\u00020\u0011H\u0002J\u0018\u0010C\u001a\u00020<2\u0006\u0010D\u001a\u00020\u00052\u0006\u0010E\u001a\u00020\u0011H\u0002J\b\u0010F\u001a\u00020<H\u0002J(\u0010G\u001a\u00020<2\u0006\u0010H\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010I\u001a\u00020\u00112\u0006\u0010J\u001a\u00020\u0011H\u0002J\b\u0010K\u001a\u00020<H\u0002J\b\u0010L\u001a\u00020<H\u0002J\u0010\u0010M\u001a\u00020<2\u0006\u0010N\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000fR\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u001dR\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u00020'X\u0082\u0004¢\u0006\u0004\n\u0002\u0010(R\u0010\u0010)\u001a\u00020*X\u0082\u0004¢\u0006\u0004\n\u0002\u0010+R\u0010\u0010,\u001a\u00020-X\u0082\u0004¢\u0006\u0004\n\u0002\u0010.R\u0010\u0010/\u001a\u000200X\u0082\u0004¢\u0006\u0004\n\u0002\u00101R\u0010\u00102\u001a\u000203X\u0082\u0004¢\u0006\u0004\n\u0002\u00104R\u0010\u00105\u001a\u000206X\u0082\u0004¢\u0006\u0004\n\u0002\u00107R\u0010\u00108\u001a\u000209X\u0082\u0004¢\u0006\u0004\n\u0002\u0010:¨\u0006O"}, d2 = {"Lcom/obric/memorydata/memory/auditory/AuditoryObservationSyncCoordinator;", "", "<init>", "()V", "TAG", "", "started", "Ljava/util/concurrent/atomic/AtomicBoolean;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "lock", "config", "Lcom/obric/memorydata/memory/auditory/AuditorySyncConfig;", "activeIntervalSeconds", "", "Ljava/lang/Long;", "drainOnly", "", "deviceState", "Lcom/obric/memorydata/memory/auditory/AuditoryDeviceState;", "lastRunElapsedRealtimeMs", "platformSupport", "Lcom/obric/memorydata/memory/auditory/AuditoryPlatformSupport;", "platformProbeStarted", "desiredScheduleState", "Lcom/obric/memorydata/memory/auditory/AuditoryScheduleState;", "networkPolicyState", "Lcom/obric/memorydata/memory/auditory/AuditoryNetworkPolicyState;", "scheduledCellularUploadEnabled", "Ljava/lang/Boolean;", "screenOnCondition", "Lcom/obric/memorydata/task/condition/ScreenOnCondition;", "powerConnectedCondition", "Lcom/obric/memorydata/task/condition/BaseCondition;", "networkAvailableCondition", "Lcom/obric/memorydata/task/condition/NetAvailableCondition;", "wifiConnectedCondition", "Lcom/obric/memorydata/task/condition/WifiConnectedCondition;", "deviceStateListener", "com/obric/memorydata/memory/auditory/AuditoryObservationSyncCoordinator$deviceStateListener$1", "Lcom/obric/memorydata/memory/auditory/AuditoryObservationSyncCoordinator$deviceStateListener$1;", "networkStateListener", "com/obric/memorydata/memory/auditory/AuditoryObservationSyncCoordinator$networkStateListener$1", "Lcom/obric/memorydata/memory/auditory/AuditoryObservationSyncCoordinator$networkStateListener$1;", "settingsListener", "com/obric/memorydata/memory/auditory/AuditoryObservationSyncCoordinator$settingsListener$1", "Lcom/obric/memorydata/memory/auditory/AuditoryObservationSyncCoordinator$settingsListener$1;", "loginListener", "com/obric/memorydata/memory/auditory/AuditoryObservationSyncCoordinator$loginListener$1", "Lcom/obric/memorydata/memory/auditory/AuditoryObservationSyncCoordinator$loginListener$1;", "privacyListener", "com/obric/memorydata/memory/auditory/AuditoryObservationSyncCoordinator$privacyListener$1", "Lcom/obric/memorydata/memory/auditory/AuditoryObservationSyncCoordinator$privacyListener$1;", "timeChangedReceiver", "com/obric/memorydata/memory/auditory/AuditoryObservationSyncCoordinator$timeChangedReceiver$1", "Lcom/obric/memorydata/memory/auditory/AuditoryObservationSyncCoordinator$timeChangedReceiver$1;", "taskInfoCallback", "com/obric/memorydata/memory/auditory/AuditoryObservationSyncCoordinator$taskInfoCallback$1", "Lcom/obric/memorydata/memory/auditory/AuditoryObservationSyncCoordinator$taskInfoCallback$1;", CommonConsts.APM_INNER_EVENT_COST_START, "", "readConfig", "observeDeviceState", "observeNetworkState", "observeSystemTimeChange", "refreshNetworkPolicyState", "refreshCellularSetting", "reconcile", InfoRequestQPSOptTraceLogger.REASON, "drainIfDisabled", "probePlatformSupport", "enqueuePeriodic", "intervalSeconds", "executeImmediately", "cellularUploadEnabled", "removeQueuedAndScheduled", "cancelIncludingActive", "clearAccount", "accountScope", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f10069a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final AtomicBoolean f10070b = null;
    private static final al c = null;
    private static final Object d = null;
    private static volatile com.obric.memorydata.memory.auditory.f e;
    private static volatile Long f;
    private static volatile boolean g;
    private static volatile com.obric.memorydata.memory.auditory.a h;
    private static volatile Long i;
    private static volatile AuditoryPlatformSupport j;
    private static final AtomicBoolean k = null;
    private static volatile com.obric.memorydata.memory.auditory.e l;
    private static volatile com.obric.memorydata.memory.auditory.b m;
    private static volatile Boolean n;
    private static final j o = null;
    private static final com.obric.memorydata.task.condition.b p = null;
    private static final com.obric.memorydata.task.condition.g q = null;
    private static final m r = null;
    private static final a s = null;
    private static final C0492c t = null;
    private static final e u = null;
    private static final b v = null;
    private static final d w = null;
    private static final g x = null;
    private static final f y = null;

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/obric/memorydata/memory/auditory/AuditoryObservationSyncCoordinator$deviceStateListener$1", "Lcom/obric/memorydata/task/condition/ConditionChangeListener;", "onConditionChange", "", "condition", "Lcom/obric/memorydata/task/condition/Condition;", "isSatisfied", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a implements com.obric.memorydata.task.condition.d {

        /* JADX INFO: renamed from: com.obric.memorydata.memory.auditory.c$a$a, reason: collision with other inner class name */
        @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
        public /* synthetic */ class C0491a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f10071a = null;

            static {
                int[] r0 = new int[Condition.values().length];
                r0[Condition.SCREEN_ON.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
            L9:
                r0[Condition.POWER_CONNECTED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
            L5:
                f10071a = r0;
            }
        }

        a() {
        }

        @Override // com.obric.memorydata.task.condition.d
        public void onConditionChange(Condition r8, boolean r9) {
            Intrinsics.checkNotNullParameter(r8, "condition");
            String r7 = "device_state_changed";
            Object r0 = c.b();
            monitor-enter(r0);
            boolean r1 = c.f().a();     // Catch: Throwable -> L21
            c r2 = c.f10069a;     // Catch: Throwable -> L21
            int r3 = C0491a.f10071a[r8.ordinal()];     // Catch: Throwable -> L21
            if (r3 == 1) goto L11;
            if (r3 == 2) goto L10;
            monitor-exit(r0);
            return;
        L10:
            com.obric.memorydata.memory.auditory.a r4 = com.obric.memorydata.memory.auditory.a.a(c.f(), false, r9, 1, null);     // Catch: Throwable -> L21
        L12:
            c.a(r4);     // Catch: Throwable -> L21
            if (r8 != Condition.SCREEN_ON) goto L17;
            if (r1 == true) goto L17;
            if (r9 == false) goto L17;
            r7 = "screen_turned_on";
        L17:
            Unit r10 = Unit.INSTANCE;     // Catch: Throwable -> L21
            monitor-exit(r0);
            c.a(c.f10069a, r7, false);
            return;
        L11:
            r4 = com.obric.memorydata.memory.auditory.a.a(c.f(), r9, false, 2, null);     // Catch: Throwable -> L21
        L21:
            th = move-exception;
            throw th;
        }
    }

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0005H\u0016¨\u0006\b"}, d2 = {"com/obric/memorydata/memory/auditory/AuditoryObservationSyncCoordinator$loginListener$1", "Lcom/obric/memorydata/middleware/api/app/LoginStateListener;", "onLogin", "", "userId", "", "onLogout", "lastUserId", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b implements com.obric.memorydata.middleware.api.app.d {
        b() {
        }

        @Override // com.obric.memorydata.middleware.api.app.d
        public void a(String r2) {
            Intrinsics.checkNotNullParameter(r2, "userId");
            c.a(c.f10069a, "login_changed", false);
        }

        @Override // com.obric.memorydata.middleware.api.app.d
        public void b(String r2) {
            Intrinsics.checkNotNullParameter(r2, "lastUserId");
            c.a(c.f10069a, r2);
            c.a(c.f10069a, "login_changed", false);
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.auditory.c$c, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/obric/memorydata/memory/auditory/AuditoryObservationSyncCoordinator$networkStateListener$1", "Lcom/obric/memorydata/task/condition/ConditionChangeListener;", "onConditionChange", "", "condition", "Lcom/obric/memorydata/task/condition/Condition;", "isSatisfied", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class C0492c implements com.obric.memorydata.task.condition.d {
        C0492c() {
        }

        @Override // com.obric.memorydata.task.condition.d
        public void onConditionChange(Condition r1, boolean r2) {
            Intrinsics.checkNotNullParameter(r1, "condition");
            c.a(c.f10069a, "network_changed", false);
        }
    }

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u0005"}, d2 = {"com/obric/memorydata/memory/auditory/AuditoryObservationSyncCoordinator$privacyListener$1", "Lcom/obric/memorydata/middleware/api/app/AgreePrivacyListener;", "onAgree", "", "onDisagree", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class d implements com.obric.memorydata.middleware.api.app.a {
        d() {
        }

        @Override // com.obric.memorydata.middleware.api.app.a
        public void a() {
            c.a(c.f10069a, "privacy_changed", false);
        }

        @Override // com.obric.memorydata.middleware.api.app.a
        public void b() {
            c.a(c.f10069a, UserSettings.INSTANCE.getUserId());
            c.a(c.f10069a, "privacy_changed", false);
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/obric/memorydata/memory/auditory/AuditoryObservationSyncCoordinator$settingsListener$1", "Lcom/obric/memorydata/middleware/api/settings/SettingsChangeListener;", "onSettingsChanged", "", "key", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class e implements SettingsChangeListener {
        e() {
        }

        @Override // com.obric.memorydata.middleware.api.settings.SettingsChangeListener
        public void onSettingsChanged(String r2) {
            Intrinsics.checkNotNullParameter(r2, "key");
            if (Intrinsics.areEqual(r2, "obric_memd_auditory_memory") == true) goto L5;
            return;
        L5:
            c r1 = c.f10069a;
            c.a(c.a(c.f10069a));
            c.a(c.f10069a, "settings_changed", false);
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/obric/memorydata/memory/auditory/AuditoryObservationSyncCoordinator$taskInfoCallback$1", "Lcom/obric/memorydata/task/scheduler/OnTaskInfoCallBack;", "onChanged", "", "taskInfo", "Lcom/obric/memorydata/task/impl/TaskInfo;", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class f implements com.obric.memorydata.task.scheduler.c {
        f() {
        }

        @Override // com.obric.memorydata.task.scheduler.c
        public void a(TaskInfo r7) {
            Intrinsics.checkNotNullParameter(r7, "taskInfo");
            if (r7.c() != TaskInfo.State.RUNNING) goto L7;
            c r6 = c.f10069a;
            c.a(Long.valueOf(SystemClock.elapsedRealtime()));
            return;
        L7:
            if (r7.c() == TaskInfo.State.SUCCEEDED) goto L9;
            return;
        L9:
            int r8 = r7.e().getOutput().optInt("remaining_tasks", -1);
            Object r9 = c.b();
            monitor-enter(r9);
        L18:
            th = move-exception;
            throw th;
        L12:
            if (com.obric.memorydata.memory.auditory.d.a(r8, c.d()) == true) goto L15;
            monitor-exit(r9);
            return;
        L15:
            c.b(c.f10069a);     // Catch: Throwable -> L18
            c r10 = c.f10069a;     // Catch: Throwable -> L18
            c.a(new com.obric.memorydata.memory.auditory.e(null, false, 3, null));     // Catch: Throwable -> L18
            c r11 = c.f10069a;     // Catch: Throwable -> L18
            c.b(null);     // Catch: Throwable -> L18
            c r12 = c.f10069a;     // Catch: Throwable -> L18
            c.a(false);     // Catch: Throwable -> L18
            c r13 = c.f10069a;     // Catch: Throwable -> L18
            c.a(null);     // Catch: Throwable -> L18
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AuditorySync", "drain completed, periodic task removed", false, 4, null);     // Catch: Throwable -> L18
            Unit r14 = Unit.INSTANCE;     // Catch: Throwable -> L18
            monitor-exit(r9);
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, d2 = {"com/obric/memorydata/memory/auditory/AuditoryObservationSyncCoordinator$timeChangedReceiver$1", "Landroid/content/BroadcastReceiver;", "onReceive", "", "context", "Landroid/content/Context;", MemorySourceLinkType.INTENT, "Landroid/content/Intent;", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class g extends PluginBroadcastReceiver {
        g() {
        }

        public void onReceive(Context r2, Intent r3) {
            Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
            if (r3 == null) goto L5;
            String r4 = r3.getAction();
        L7:
            if (Intrinsics.areEqual(r4, "android.intent.action.TIME_SET") == true) goto L9;
            return;
        L9:
            c.a(c.f10069a, "system_time_changed", false);
            return;
        L5:
            r4 = null;
            goto L7
        }
    }

    static {
        f10069a = new c();
        f10070b = new AtomicBoolean(false);
        c = am.a(cu.a(null, 1, null).plus((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.a(), CoroutineContext.class, "com.obric.memorydata.plugin")));
        d = new Object();
        e = new com.obric.memorydata.memory.auditory.f(false, 0, 0, 0, 15, null);
        h = new com.obric.memorydata.memory.auditory.a(false, false);
        j = AuditoryPlatformSupport.UNKNOWN;
        k = new AtomicBoolean(false);
        l = new com.obric.memorydata.memory.auditory.e(null, false, 3, null);
        m = new com.obric.memorydata.memory.auditory.b(false, false, false);
        o = new j();
        p = AbilityConditionManager.INSTANCE.createPowerConnectedCondition();
        q = new com.obric.memorydata.task.condition.g();
        r = new m();
        s = new a();
        t = new C0492c();
        u = new e();
        v = new b();
        w = new d();
        x = new g();
        y = new f();
    }

    private c() {
    }

    public static final /* synthetic */ com.obric.memorydata.memory.auditory.f a(c r0) {
        return r0.g();
    }

    private final void a(long r2, boolean r4, boolean r5, boolean r6) {
        TaskRequest.Builder r1 = (TaskRequest.Builder) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(new TaskRequest.Builder("auditory_observation_sync").setInputParam(e.a(r4)), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).setConditions(com.obric.memorydata.memory.auditory.d.a(r6)), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).setInterval((com.obric.memorydata.task.impl.g) ZeusTransformUtils.preCheckCast(new com.obric.memorydata.task.impl.f(r2), com.obric.memorydata.task.impl.g.class, "com.obric.memorydata.plugin")), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).setTaskInfoCallback((com.obric.memorydata.task.scheduler.c) ZeusTransformUtils.preCheckCast(y, com.obric.memorydata.task.scheduler.c.class, "com.obric.memorydata.plugin")), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).setExistingTaskPolicy(ExistingTaskPolicy.REPLACE_IN_QUEUE), TaskRequest.Builder.class, "com.obric.memorydata.plugin");
        if (r5 == true) goto L5;
        r1.setDelay((com.obric.memorydata.task.impl.g) ZeusTransformUtils.preCheckCast(new com.obric.memorydata.task.impl.f(r2), com.obric.memorydata.task.impl.g.class, "com.obric.memorydata.plugin"));
    L5:
        ((TaskRequest) ZeusTransformUtils.preCheckCast(r1.build(), TaskRequest.class, "com.obric.memorydata.plugin")).enqueue();
    }

    public static final /* synthetic */ void a(AuditoryPlatformSupport r0) {
        j = r0;
    }

    public static final /* synthetic */ void a(com.obric.memorydata.memory.auditory.a r0) {
        h = r0;
    }

    public static final /* synthetic */ void a(com.obric.memorydata.memory.auditory.b r0) {
        m = r0;
    }

    public static final /* synthetic */ void a(c r0, String r1) {
        r0.a(r1);
    }

    public static final /* synthetic */ void a(c r0, String r1, boolean r2) {
        r0.a(r1, r2);
    }

    public static final /* synthetic */ void a(com.obric.memorydata.memory.auditory.e r0) {
        l = r0;
    }

    public static final /* synthetic */ void a(com.obric.memorydata.memory.auditory.f r0) {
        e = r0;
    }

    public static final /* synthetic */ void a(Boolean r0) {
        n = r0;
    }

    public static final /* synthetic */ void a(Long r0) {
        i = r0;
    }

    private final void a(String r7) {
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L5;
        return;
    L5:
        if (Intrinsics.areEqual(r7, "0") == false) goto L8;
        return;
    L8:
        if (AuditoryBridgeAPI.INSTANCE.clearAccountData(r7) == true) goto L12;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AuditorySync", "clear account data incomplete", null, 4, null);
        return;
    }

    private final void a(String r13, boolean r14) {
        b(Intrinsics.areEqual(r13, "screen_turned_on"));
        Object r12 = d;
        monitor-enter(r12);
        boolean r4 = UserSettings.INSTANCE.hasAgreePrivacyAndLogin();     // Catch: Throwable -> L79
        com.obric.memorydata.memory.auditory.e r0 = l;     // Catch: Throwable -> L79
        com.obric.memorydata.memory.auditory.e r9 = new com.obric.memorydata.memory.auditory.e(f, g);     // Catch: Throwable -> L79
        boolean r5 = ((Boolean) ZeusTransformUtils.preCheckCast(l.f11479a.a().d().c(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();     // Catch: Throwable -> L79
        boolean r10 = true;
        if (r0.a() != null) goto L13;
        if (r4 == false) goto L13;
        if (e.b() == false) goto L13;
        if (r5 == true) goto L13;
        if (AuditoryBridgeAPI.INSTANCE.countTasks(UserSettings.INSTANCE.getUserId()) == 0) goto L13;
        boolean r8 = true;
    L15:
        if (j != AuditoryPlatformSupport.UNKNOWN) goto L22;
        if (r4 == false) goto L22;
        if (e.b() == false) goto L22;
        if (r5 == true) goto L21;
        if (r8 == false) goto L22;
    L21:
        f10069a.k();     // Catch: Throwable -> L79
    L22:
        com.obric.memorydata.memory.auditory.e r15 = com.obric.memorydata.memory.auditory.d.a(r0, e, h, r4, r5, j, r14, r8);     // Catch: Throwable -> L79
        com.obric.memorydata.memory.auditory.e r1 = com.obric.memorydata.memory.auditory.d.a(r15, m);     // Catch: Throwable -> L79
        boolean r2 = com.obric.memorydata.memory.auditory.d.a(r13, r0, r15);     // Catch: Throwable -> L79
        boolean r3 = com.obric.memorydata.memory.auditory.d.a(r13, r1, i, SystemClock.elapsedRealtime());     // Catch: Throwable -> L79
        if (r1.a() != null) goto L25;
    L27:
        boolean r6 = false;
    L28:
        boolean r7 = com.obric.memorydata.memory.auditory.d.a(r13);     // Catch: Throwable -> L79
        if (Intrinsics.areEqual(r1, r9) == true) goto L31;
    L38:
        if (r7 == true) goto L44;
        if (r3 == true) goto L44;
        if (com.obric.memorydata.memory.auditory.d.a(r9, r1) == true) goto L44;
        boolean r11 = false;
    L45:
        if (r2 == false) goto L48;
        f10069a.m();     // Catch: Throwable -> L79
    L55:
        Long r16 = r1.a();     // Catch: Throwable -> L79
        if (r16 == null) goto L58;
        f10069a.a(((Number) ZeusTransformUtils.preCheckCast(r16, Number.class, "com.obric.memorydata.plugin")).longValue(), r1.b(), r11, m.a());     // Catch: Throwable -> L79
    L58:
        l = r15;     // Catch: Throwable -> L79
        f = r1.a();     // Catch: Throwable -> L79
        g = r1.b();     // Catch: Throwable -> L79
        if (r1.a() != null) goto L61;
        Boolean r17 = null;
    L62:
        n = r17;     // Catch: Throwable -> L79
        IRunLog r18 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L79
        StringBuilder r19 = new StringBuilder().append("periodic task changed, reason=").append(r13).append(", active=");     // Catch: Throwable -> L79
        if (r1.a() == null) goto L65;
        boolean r20 = true;
    L66:
        StringBuilder r110 = r19.append(r20).append(", drain=").append(r15.b()).append(", waiting_network=");     // Catch: Throwable -> L79
        if (r15.a() != null) goto L69;
    L71:
        r10 = false;
    L72:
        StringBuilder r111 = r110.append(r10).append(", interval_seconds=");     // Catch: Throwable -> L79
        Long r112 = r15.a();     // Catch: Throwable -> L79
        if (r112 == null) goto L75;
        long r21 = r112.longValue();     // Catch: Throwable -> L79
    L76:
        IRunLog.a.a(r18, "AuditorySync", r111.append(r21).toString(), false, 4, null);     // Catch: Throwable -> L79
        Unit r113 = Unit.INSTANCE;     // Catch: Throwable -> L79
        monitor-exit(r12);
        return;
    L75:
        r21 = 0;
        goto L76
    L69:
        if (r1.a() != null) goto L71;
    L65:
        r20 = false;
        goto L66
    L61:
        r17 = Boolean.valueOf(m.a());     // Catch: Throwable -> L79
        goto L62
    L48:
        if (r9.a() == null) goto L50;
    L54:
        f10069a.l();     // Catch: Throwable -> L79
        goto L55
    L50:
        if (Intrinsics.areEqual(r13, CommonConsts.APM_INNER_EVENT_COST_START) == true) goto L52;
    L53:
        if (r7 == false) goto L55;
    L52:
        if (r1.a() == null) goto L54;
    L44:
        r11 = true;
        goto L45
    L31:
        if (Intrinsics.areEqual(r15, r0) == false) goto L38;
        if (r2 == true) goto L38;
        if (r3 == true) goto L38;
        if (r6 == true) goto L38;
        if (r7 == true) goto L38;
        monitor-exit(r12);
        return;
    L25:
        if (Intrinsics.areEqual(n, Boolean.valueOf(m.a())) == true) goto L27;
        r6 = true;
    L13:
        r8 = false;
    L79:
        th = move-exception;
        throw th;
    }

    public static final /* synthetic */ void a(boolean r0) {
        g = r0;
    }

    public static final /* synthetic */ Object b() {
        return d;
    }

    public static final /* synthetic */ void b(c r0) {
        r0.l();
    }

    public static final /* synthetic */ void b(Long r0) {
        f = r0;
    }

    private final void b(boolean r12) {
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        boolean r1 = UserSettings.INSTANCE.hasAgreePrivacy();
        boolean r2 = true;
        if (r1 == true) goto L5;
    L7:
        boolean r4 = false;
    L8:
        if (r1 == true) goto L10;
    L12:
        r2 = false;
    L13:
        if (r12 == true) goto L34;
        boolean r11 = m.a();
    L26:
        Object r13 = d;
        monitor-enter(r13);
        m = new com.obric.memorydata.memory.auditory.b(r4, r2, r11);     // Catch: Throwable -> L31
        Unit r14 = Unit.INSTANCE;     // Catch: Throwable -> L31
        monitor-exit(r13);
        return;
    L31:
        th = move-exception;
        throw th;
    L34:
        Result.Companion r15 = Result.Companion;     // Catch: Throwable -> L16
        c r16 = (c) ZeusTransformUtils.preCheckCast(this, c.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L16
        Object r17 = Result.m1421constructorimpl(Boolean.valueOf(RecommendApi.INSTANCE.getScreenObservationCellularEnabled()));     // Catch: Throwable -> L16
    L18:
        Throwable r18 = Result.m1424exceptionOrNullimpl(r17);
        if (r18 == null) goto L21;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AuditorySync", "read cellular setting failed, error_type=" + r18.getClass().getSimpleName(), null, 4, null);
    L21:
        Boolean r19 = Boolean.valueOf(m.a());
        if (Result.m1427isFailureimpl(r17) == false) goto L24;
        r17 = r19;
    L24:
        r11 = ((Boolean) ZeusTransformUtils.preCheckCast(r17, Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    L16:
        th = move-exception;
        Result.Companion r110 = Result.Companion;
        r17 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L18
    L10:
        if (NetworkUtils.a(r0) == false) goto L12;
    L5:
        if (NetworkUtils.b(r0) == false) goto L7;
        r4 = true;
        goto L8
    }

    public static final /* synthetic */ com.obric.memorydata.memory.auditory.b c() {
        return m;
    }

    public static final /* synthetic */ com.obric.memorydata.memory.auditory.e d() {
        return l;
    }

    public static final /* synthetic */ AuditoryPlatformSupport e() {
        return j;
    }

    public static final /* synthetic */ com.obric.memorydata.memory.auditory.a f() {
        return h;
    }

    private final com.obric.memorydata.memory.auditory.f g() {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        c r1 = (c) ZeusTransformUtils.preCheckCast(this, c.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L5
        Object r2 = Result.m1421constructorimpl(com.obric.memorydata.memory.auditory.d.a(SettingsManager.INSTANCE.getJson("obric_memd_auditory_memory")));     // Catch: Throwable -> L5
    L7:
        Throwable r3 = Result.m1424exceptionOrNullimpl(r2);
        if (r3 == null) goto L10;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AuditorySync", "read settings failed, error_type=" + r3.getClass().getSimpleName(), null, 4, null);
    L10:
        com.obric.memorydata.memory.auditory.f r4 = new com.obric.memorydata.memory.auditory.f(false, 0, 0, 0, 15, null);
        if (Result.m1427isFailureimpl(r2) == false) goto L14;
        r2 = r4;
    L14:
        return (com.obric.memorydata.memory.auditory.f) ZeusTransformUtils.preCheckCast(r2, com.obric.memorydata.memory.auditory.f.class, "com.obric.memorydata.plugin");
    L5:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        r2 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    private final void h() {
        j r4 = o;
        a r0 = s;
        r4.b((com.obric.memorydata.task.condition.d) ZeusTransformUtils.preCheckCast(r0, com.obric.memorydata.task.condition.d.class, "com.obric.memorydata.plugin"));
        com.obric.memorydata.task.condition.b r1 = p;
        r1.b((com.obric.memorydata.task.condition.d) ZeusTransformUtils.preCheckCast(r0, com.obric.memorydata.task.condition.d.class, "com.obric.memorydata.plugin"));
        r4.b();
        r1.b();
        h = new com.obric.memorydata.memory.auditory.a(r4.c(), r1.c());
    }

    private final void i() {
        com.obric.memorydata.task.condition.g r0 = q;
        C0492c r1 = t;
        r0.b((com.obric.memorydata.task.condition.d) ZeusTransformUtils.preCheckCast(r1, com.obric.memorydata.task.condition.d.class, "com.obric.memorydata.plugin"));
        m r2 = r;
        r2.b((com.obric.memorydata.task.condition.d) ZeusTransformUtils.preCheckCast(r1, com.obric.memorydata.task.condition.d.class, "com.obric.memorydata.plugin"));
        r0.b();
        r2.b();
        b(false);
    }

    private final void j() {
        Context r4 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        IntentFilter r1 = new IntentFilter("android.intent.action.TIME_SET");
        if (Build.VERSION.SDK_INT < 33) goto L5;
        ZeusTransformUtils.registerReceiver(r4, (PluginBroadcastReceiver) ZeusTransformUtils.preCheckCast(x, PluginBroadcastReceiver.class, "com.obric.memorydata.plugin"), r1, 4, "com.obric.memorydata.plugin");
        return;
    L5:
        ZeusTransformUtils.registerReceiver(r4, (PluginBroadcastReceiver) ZeusTransformUtils.preCheckCast(x, PluginBroadcastReceiver.class, "com.obric.memorydata.plugin"), r1, "com.obric.memorydata.plugin");
    }

    private final void k() {
        if (k.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        i.a(c, (CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin"), null, (Function2) ZeusTransformUtils.preCheckCast(new AuditoryObservationSyncCoordinator$probePlatformSupport$1(null), Function2.class, "com.obric.memorydata.plugin"), 2, null);
    }

    private final void l() {
        com.obric.memorydata.task.scheduler.impl.c.f12961a.d().b("auditory_observation_sync");
    }

    private final void m() {
        com.obric.memorydata.task.scheduler.impl.c.f12961a.d().d("auditory_observation_sync");
    }

    public final void a() {
        if (f10070b.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        e = g();
        b(true);
        SettingsManager.INSTANCE.registerChangeListener("obric_memd_auditory_memory", (SettingsChangeListener) ZeusTransformUtils.preCheckCast(u, SettingsChangeListener.class, "com.obric.memorydata.plugin"));
        UserSettings.INSTANCE.registerLoginStateListener((com.obric.memorydata.middleware.api.app.d) ZeusTransformUtils.preCheckCast(v, com.obric.memorydata.middleware.api.app.d.class, "com.obric.memorydata.plugin"));
        UserSettings.INSTANCE.registerAgreePrivacyListener((com.obric.memorydata.middleware.api.app.a) ZeusTransformUtils.preCheckCast(w, com.obric.memorydata.middleware.api.app.a.class, "com.obric.memorydata.plugin"));
        h();
        i();
        j();
        al r0 = c;
        i.a(r0, null, null, (Function2) ZeusTransformUtils.preCheckCast(new AuditoryObservationSyncCoordinator$start$1(null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        i.a(r0, null, null, (Function2) ZeusTransformUtils.preCheckCast(new AuditoryObservationSyncCoordinator$start$2(null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        a(CommonConsts.APM_INNER_EVENT_COST_START, false);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AuditorySync", "started", false, 4, null);
    }
}
