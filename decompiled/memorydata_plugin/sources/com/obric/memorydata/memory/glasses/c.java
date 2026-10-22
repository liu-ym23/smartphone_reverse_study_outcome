package com.obric.memorydata.memory.glasses;

import android.security.obric.guard.ObricSecurityGuardStub;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.common.wschannel.WsConstants;
import com.obric.aiproactive.api.DoubaoGlassesConnectionSnapshot;
import com.obric.aiproactive.api.DoubaoGlassesConnectionState;
import com.obric.aiproactive.api.ab;
import com.obric.memorydata.memory.ui.list.PendingPersonalInfoNotificationTask;
import com.obric.memorydata.middleware.api.app.UserSettings;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.logging.g;
import com.obric.memorydata.middleware.api.logging.o;
import com.obric.memorydata.recommend.RecommendApi;
import com.obric.memorydata.task.impl.TaskInfo;
import com.obric.memorydata.task.impl.TaskRequest;
import com.obric.memorydata.task.scheduler.impl.ExistingTaskPolicy;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.al;
import kotlinx.coroutines.am;
import kotlinx.coroutines.ba;
import kotlinx.coroutines.cu;
import kotlinx.coroutines.i;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000}\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000*\u0003\u000f\u0014\u0017\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0019\u001a\u00020\u001aJ \u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001fH\u0002J\u0018\u0010!\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\b\u0010\"\u001a\u00020\u001aH\u0002J(\u0010#\u001a\u00020$2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010%\u001a\u00020\u001fH\u0002J\r\u0010&\u001a\u00020\u001aH\u0000¢\u0006\u0002\b'J\b\u0010(\u001a\u00020\u001aH\u0002J\u0006\u0010)\u001a\u00020\u001aJ\u0015\u0010*\u001a\u00020\u001a2\u0006\u0010+\u001a\u00020,H\u0000¢\u0006\u0002\b-J\r\u0010\n\u001a\u00020\u000bH\u0000¢\u0006\u0002\b.J\u0010\u0010/\u001a\u00020\u001a2\u0006\u00100\u001a\u000201H\u0002J\u0010\u00102\u001a\u00020\u001a2\u0006\u0010+\u001a\u00020,H\u0002J\u0018\u00103\u001a\u0002042\u0006\u00105\u001a\u0002012\u0006\u00106\u001a\u000201H\u0002J\u0018\u00107\u001a\u0002042\u0006\u00108\u001a\u0002092\u0006\u00106\u001a\u000201H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0015R\u0010\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0018¨\u0006:"}, d2 = {"Lcom/obric/memorydata/memory/glasses/GlassesObservationSyncCoordinator;", "", "<init>", "()V", "logger", "Lcom/obric/memorydata/middleware/api/logging/ModuleLogger;", "started", "Ljava/util/concurrent/atomic/AtomicBoolean;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "currentTaskState", "Lcom/obric/memorydata/task/impl/TaskInfo$State;", "lifecycle", "Lcom/obric/memorydata/memory/glasses/GlassesObservationSyncLifecycle;", "taskInfoCallback", "com/obric/memorydata/memory/glasses/GlassesObservationSyncCoordinator$taskInfoCallback$1", "Lcom/obric/memorydata/memory/glasses/GlassesObservationSyncCoordinator$taskInfoCallback$1;", "connectionListener", "Lcom/obric/aiproactive/api/DoubaoGlassesConnectionListener;", "loginStateListener", "com/obric/memorydata/memory/glasses/GlassesObservationSyncCoordinator$loginStateListener$1", "Lcom/obric/memorydata/memory/glasses/GlassesObservationSyncCoordinator$loginStateListener$1;", "privacyListener", "com/obric/memorydata/memory/glasses/GlassesObservationSyncCoordinator$privacyListener$1", "Lcom/obric/memorydata/memory/glasses/GlassesObservationSyncCoordinator$privacyListener$1;", CommonConsts.APM_INNER_EVENT_COST_START, "", "enqueue", PendingPersonalInfoNotificationTask.KEY_GENERATION, "", "wearing", "", "forceHotwordsSync", "scheduleNext", "scheduleDisconnectClear", "buildSyncTask", "Lcom/obric/memorydata/task/impl/TaskRequest$Builder;", "cellularUploadEnabled", "restoreAutomaticScheduleAfterDebugPull", "restoreAutomaticScheduleAfterDebugPull$memory_obricRelease", ObricSecurityGuardStub.SettingsEventConst.EVENT_RESULT_CANCEL, "onEligibilityChanged", "recordTaskInfo", "taskInfo", "Lcom/obric/memorydata/task/impl/TaskInfo;", "recordTaskInfo$memory_obricRelease", "currentTaskState$memory_obricRelease", "traceEligibilityChanged", "trigger", "", "traceTaskState", "taskContext", "Lcom/obric/memorydata/middleware/api/logging/LogContext;", "taskId", "stage", "connectionContext", "snapshot", "Lcom/obric/aiproactive/api/DoubaoGlassesConnectionSnapshot;", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f10140a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final o f10141b = null;
    private static final AtomicBoolean c = null;
    private static final al d = null;
    private static volatile TaskInfo.State e;
    private static final e f = null;
    private static final C0495c g = null;
    private static final ab h = null;
    private static final a i = null;
    private static final b j = null;

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0005H\u0016¨\u0006\b"}, d2 = {"com/obric/memorydata/memory/glasses/GlassesObservationSyncCoordinator$loginStateListener$1", "Lcom/obric/memorydata/middleware/api/app/LoginStateListener;", "onLogin", "", "userId", "", "onLogout", "lastUserId", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a implements com.obric.memorydata.middleware.api.app.d {
        a() {
        }

        @Override // com.obric.memorydata.middleware.api.app.d
        public void a(String r1) {
            Intrinsics.checkNotNullParameter(r1, "userId");
            c.a(c.f10140a, "login");
        }

        @Override // com.obric.memorydata.middleware.api.app.d
        public void b(String r1) {
            Intrinsics.checkNotNullParameter(r1, "lastUserId");
            c.a(c.f10140a, "logout");
        }
    }

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u0005"}, d2 = {"com/obric/memorydata/memory/glasses/GlassesObservationSyncCoordinator$privacyListener$1", "Lcom/obric/memorydata/middleware/api/app/AgreePrivacyListener;", "onAgree", "", "onDisagree", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b implements com.obric.memorydata.middleware.api.app.a {
        b() {
        }

        @Override // com.obric.memorydata.middleware.api.app.a
        public void a() {
            c.a(c.f10140a, "privacy_agreed");
        }

        @Override // com.obric.memorydata.middleware.api.app.a
        public void b() {
            c.a(c.f10140a, "privacy_disagreed");
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.glasses.c$c, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/obric/memorydata/memory/glasses/GlassesObservationSyncCoordinator$taskInfoCallback$1", "Lcom/obric/memorydata/task/scheduler/OnTaskInfoCallBack;", "onChanged", "", "taskInfo", "Lcom/obric/memorydata/task/impl/TaskInfo;", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class C0495c implements com.obric.memorydata.task.scheduler.c {
        C0495c() {
        }

        @Override // com.obric.memorydata.task.scheduler.c
        public void a(TaskInfo r1) {
            Intrinsics.checkNotNullParameter(r1, "taskInfo");
            c r0 = c.f10140a;
            c.a(r1.c());
            c.a(c.f10140a, r1);
        }
    }

    static {
        c r0 = new c();
        f10140a = r0;
        f10141b = com.obric.memorydata.middleware.api.logging.d.f11613a.a("GlassesObservationSync");
        c = new AtomicBoolean(false);
        d = am.a(cu.a(null, 1, null).plus((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin")));
        e = TaskInfo.State.IDLE;
        f = new e((Function0) ZeusTransformUtils.preCheckCast(new GlassesObservationSyncCoordinator$lifecycle$1(com.obric.memorydata.memory.glasses.a.f10137a), Function0.class, "com.obric.memorydata.plugin"), (Function3) ZeusTransformUtils.preCheckCast(new GlassesObservationSyncCoordinator$lifecycle$2(r0), Function3.class, "com.obric.memorydata.plugin"), (Function2) ZeusTransformUtils.preCheckCast(new GlassesObservationSyncCoordinator$lifecycle$3(r0), Function2.class, "com.obric.memorydata.plugin"), (Function0) ZeusTransformUtils.preCheckCast(new GlassesObservationSyncCoordinator$lifecycle$4(r0), Function0.class, "com.obric.memorydata.plugin"), (Function0) ZeusTransformUtils.preCheckCast(new GlassesObservationSyncCoordinator$lifecycle$5(RecommendApi.INSTANCE), Function0.class, "com.obric.memorydata.plugin"), (Function0) ZeusTransformUtils.preCheckCast(new GlassesObservationSyncCoordinator$lifecycle$6(r0), Function0.class, "com.obric.memorydata.plugin"));
        g = new C0495c();
        h = $$Lambda$c$guj236n4fdDhyHLX5yBahGAlFA.INSTANCE;
        i = new a();
        j = new b();
    }

    private c() {
    }

    private final com.obric.memorydata.middleware.api.logging.e a(DoubaoGlassesConnectionSnapshot r7, String r8) {
        return new com.obric.memorydata.middleware.api.logging.e(null, "connection_" + r7.getGeneration(), r8, 1, null);
    }

    public static final /* synthetic */ com.obric.memorydata.middleware.api.logging.e a(c r0, DoubaoGlassesConnectionSnapshot r1, String r2) {
        return r0.a(r1, r2);
    }

    private final com.obric.memorydata.middleware.api.logging.e a(String r7, String r8) {
        return new com.obric.memorydata.middleware.api.logging.e(null, r7, r8, 1, null);
    }

    private final TaskRequest.Builder a(long r3, boolean r5, boolean r6, boolean r7) {
        TaskRequest.Builder r2 = new TaskRequest.Builder("glasses_observation_sync");
        JSONObject r4 = new JSONObject().put("connection_generation", r3).put("force_hotwords_sync", r6).put("record_request_history", AppContext.INSTANCE.isDebug());
        Intrinsics.checkNotNullExpressionValue(r4, "put(...)");
        return (TaskRequest.Builder) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(r2.setInputParam(r4), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).setConditions(d.a(r5, r7)), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).setTaskInfoCallback((com.obric.memorydata.task.scheduler.c) ZeusTransformUtils.preCheckCast(g, com.obric.memorydata.task.scheduler.c.class, "com.obric.memorydata.plugin")), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).setExistingTaskPolicy(ExistingTaskPolicy.REPLACE_IN_QUEUE), TaskRequest.Builder.class, "com.obric.memorydata.plugin");
    }

    private static final Unit a(long r1, boolean r3, boolean r4, g r5) {
        Intrinsics.checkNotNullParameter(r5, "$this$mainTrace");
        r5.a("connection_generation", Long.valueOf(r1));
        r5.a("wearing", Boolean.valueOf(r3));
        r5.a("cellular_upload_enabled", Boolean.valueOf(r4));
        r5.a("delay_minutes", 120L);
        return Unit.INSTANCE;
    }

    private static final Unit a(long r1, boolean r3, boolean r4, boolean r5, g r6) {
        Intrinsics.checkNotNullParameter(r6, "$this$mainTrace");
        r6.a("connection_generation", Long.valueOf(r1));
        r6.a("wearing", Boolean.valueOf(r3));
        r6.a("cellular_upload_enabled", Boolean.valueOf(r4));
        r6.a("force_hotwords_sync", Boolean.valueOf(r5));
        r6.a("schedule_mode", "immediate");
        return Unit.INSTANCE;
    }

    private static final Unit a(DoubaoGlassesConnectionSnapshot r2, com.obric.memorydata.memory.glasses.b r3, g r4) {
        Intrinsics.checkNotNullParameter(r4, "$this$mainTrace");
        r4.a("connection_generation", Long.valueOf(r2.getGeneration()));
        r4.a("delay_minutes", Long.valueOf(r3.d()));
        r4.a("connected", Boolean.valueOf(r2.getConnected()));
        return Unit.INSTANCE;
    }

    private static final Unit a(DoubaoGlassesConnectionSnapshot r2, g r3) {
        Intrinsics.checkNotNullParameter(r3, "$this$mainTrace");
        r3.a("connected", Boolean.valueOf(r2.getConnected()));
        r3.a("wearing", Boolean.valueOf(r2.getWearing()));
        r3.a("environment_memory_enabled", Boolean.valueOf(r2.getEnvironmentMemoryEnabled()));
        r3.a("automatic_sync_allowed", Boolean.valueOf(com.obric.memorydata.memory.glasses.a.f10137a.b()));
        return Unit.INSTANCE;
    }

    private static final Unit a(TaskInfo.State r2, TaskInfo r3, g r4) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        String r0 = r2.name().toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(r0, "toLowerCase(...)");
        r4.a("state", r0);
        r4.a("attempt_count", Integer.valueOf(r3.g()));
        r4.a("time_cost_ms", Long.valueOf(r3.h()));
        if (r2.isFinished() == false) goto L6;
        r4.a("task_code", Integer.valueOf(r3.e().getCode()));
    L6:
        return Unit.INSTANCE;
    }

    private static final Unit a(String r1, DoubaoGlassesConnectionSnapshot r2, g r3) {
        Intrinsics.checkNotNullParameter(r3, "$this$mainTrace");
        r3.a("trigger", r1);
        r3.a("automatic_sync_allowed", Boolean.valueOf(com.obric.memorydata.memory.glasses.a.f10137a.b()));
        r3.a("connected", Boolean.valueOf(r2.getConnected()));
        r3.a("wearing", Boolean.valueOf(r2.getWearing()));
        r3.a("environment_memory_enabled", Boolean.valueOf(r2.getEnvironmentMemoryEnabled()));
        return Unit.INSTANCE;
    }

    private final void a(final long r11, final boolean r13) {
        final boolean r0 = RecommendApi.INSTANCE.getScreenObservationCellularEnabled();
        TaskRequest r1 = (TaskRequest) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(a(r11, r13, false, r0).setDelay((com.obric.memorydata.task.impl.g) ZeusTransformUtils.preCheckCast(new com.obric.memorydata.task.impl.d(120), com.obric.memorydata.task.impl.g.class, "com.obric.memorydata.plugin")), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).build(), TaskRequest.class, "com.obric.memorydata.plugin");
        r1.enqueue();
        o.a(f10141b, "眼镜同步任务已延迟调度", "sync_task_scheduled", a(r1.getId().toString(), "schedule"), new $$Lambda$c$ZMqi9rj5GmUluJHr2Ga0BQ1C0qk(r11, r13, r0), null, 16, null);
    }

    private final void a(final long r11, final boolean r13, final boolean r14) {
        final boolean r0 = RecommendApi.INSTANCE.getScreenObservationCellularEnabled();
        TaskRequest r1 = (TaskRequest) ZeusTransformUtils.preCheckCast(a(r11, r13, r14, r0).build(), TaskRequest.class, "com.obric.memorydata.plugin");
        r1.enqueue();
        o.a(f10141b, "眼镜同步任务已入队", "sync_task_enqueued", a(r1.getId().toString(), "schedule"), new $$Lambda$c$fTO3ci3x3ffDmMxITuwqW7fVCE4(r11, r13, r0, r14), null, 16, null);
    }

    private static final void a(DoubaoGlassesConnectionSnapshot r5) {
        Intrinsics.checkNotNullParameter(r5, "snapshot");
        o r0 = f10141b;
        com.obric.memorydata.middleware.api.logging.e r1 = f10140a.a(r5, WsConstants.KEY_CONNECTION);
        if (AppContext.INSTANCE.isDebug() == false) goto L5;
        g r2 = new g();
        r2.a("connected", Boolean.valueOf(r5.getConnected()));
        r2.a(PendingPersonalInfoNotificationTask.KEY_GENERATION, Long.valueOf(r5.getGeneration()));
        r2.a("wearing", Boolean.valueOf(r5.getWearing()));
        r2.a("environment_memory_enabled", Boolean.valueOf(r5.getEnvironmentMemoryEnabled()));
        Unit r3 = Unit.INSTANCE;
        r0.a("眼镜同步：收到连接快照", r1, r2.a());
    L5:
        f.a(r5);
    }

    public static final /* synthetic */ void a(c r0) {
        r0.e();
    }

    public static final /* synthetic */ void a(c r0, long r1, boolean r3) {
        r0.a(r1, r3);
    }

    public static final /* synthetic */ void a(c r0, long r1, boolean r3, boolean r4) {
        r0.a(r1, r3, r4);
    }

    public static final /* synthetic */ void a(c r0, TaskInfo r1) {
        r0.a(r1);
    }

    public static final /* synthetic */ void a(c r0, String r1) {
        r0.a(r1);
    }

    public static final /* synthetic */ void a(TaskInfo.State r0) {
        e = r0;
    }

    private final void a(final TaskInfo r13) {
        final TaskInfo.State r0 = r13.c();
        String r1 = r13.a().toString();
        Intrinsics.checkNotNullExpressionValue(r1, "toString(...)");
        com.obric.memorydata.middleware.api.logging.e r8 = a(r1, "execute");
        Function1 r9 = new $$Lambda$c$guNVxq_pCnAkDg4yM8Et49neh8(r0, r13);
        if (r0 != TaskInfo.State.FAILED) goto L5;
    L10:
        o r3 = f10141b;
        StringBuilder r12 = new StringBuilder().append("task_");
        String r14 = r0.name().toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(r14, "toLowerCase(...)");
        o.a(r3, "眼镜同步任务执行失败", "sync_task_execution_failed", r12.append(r14).toString(), null, r8, r9, 8, null);
        return;
    L5:
        if (r0 == TaskInfo.State.TIMEOUT) goto L10;
        o r15 = f10141b;
        if (AppContext.INSTANCE.isDebug() == false) goto L12;
        g r16 = new g();
        r9.invoke(r16);
        r15.a("眼镜同步：状态已更新", r8, r16.a());
        return;
    }

    private final void a(final String r10) {
        final DoubaoGlassesConnectionSnapshot r0 = DoubaoGlassesConnectionState.INSTANCE.currentSnapshot();
        o.a(f10141b, "眼镜同步资格状态已变化", "sync_eligibility_changed", a(r0, "eligibility"), new $$Lambda$c$tjkAGdfxcLNu78J04Lj0g_Hn7I(r10, r0), null, 16, null);
        f.a();
    }

    public static final /* synthetic */ o b() {
        return f10141b;
    }

    private static final Unit b(DoubaoGlassesConnectionSnapshot r2, g r3) {
        Intrinsics.checkNotNullParameter(r3, "$this$mainTrace");
        r3.a("connected", Boolean.valueOf(r2.getConnected()));
        r3.a("wearing", Boolean.valueOf(r2.getWearing()));
        r3.a("automatic_sync_allowed", Boolean.valueOf(com.obric.memorydata.memory.glasses.a.f10137a.b()));
        String r4 = e.name().toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(r4, "toLowerCase(...)");
        r3.a("previous_task_state", r4);
        return Unit.INSTANCE;
    }

    public static final /* synthetic */ void b(c r0) {
        r0.d();
    }

    public static final /* synthetic */ e c() {
        return f;
    }

    private final void d() {
        final DoubaoGlassesConnectionSnapshot r0 = DoubaoGlassesConnectionState.INSTANCE.currentSnapshot();
        final com.obric.memorydata.memory.glasses.b r1 = d.a(r0.getGeneration(), AppContext.INSTANCE.isDebug());
        TaskRequest.Builder r2 = new TaskRequest.Builder(r1.a());
        JSONObject r3 = new JSONObject().put("clear_hotwords_after_disconnect", true).put("connection_generation", r1.b());
        Intrinsics.checkNotNullExpressionValue(r3, "put(...)");
        TaskRequest r4 = (TaskRequest) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(r2.setInputParam(r3), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).setConditions(r1.c()), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).setDelay((com.obric.memorydata.task.impl.g) ZeusTransformUtils.preCheckCast(new com.obric.memorydata.task.impl.d(r1.d()), com.obric.memorydata.task.impl.g.class, "com.obric.memorydata.plugin")), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).setTaskInfoCallback((com.obric.memorydata.task.scheduler.c) ZeusTransformUtils.preCheckCast(g, com.obric.memorydata.task.scheduler.c.class, "com.obric.memorydata.plugin")), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).setExistingTaskPolicy(r1.e()), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).build(), TaskRequest.class, "com.obric.memorydata.plugin");
        r4.enqueue();
        o.a(f10141b, "眼镜 HotWords 断连保护任务已调度", "hotwords_clear_scheduled", a(r4.getId().toString(), "schedule"), new $$Lambda$c$JvuoE4KJPIDhIRpbvxwOTJe36ag(r0, r1), null, 16, null);
    }

    private final void e() {
        com.obric.memorydata.task.scheduler.impl.c.f12961a.d().d("glasses_observation_sync");
        final DoubaoGlassesConnectionSnapshot r0 = DoubaoGlassesConnectionState.INSTANCE.currentSnapshot();
        o.a(f10141b, "眼镜同步任务已取消", "sync_tasks_cancelled", a(r0, "schedule"), new $$Lambda$c$lOkxAgzml0sQkjb5ng6B04V2g_0(r0), null, 16, null);
    }

    public static /* synthetic */ Unit lambda$JvuoE4KJPIDhIRpbvxwOTJe36ag(DoubaoGlassesConnectionSnapshot r0, com.obric.memorydata.memory.glasses.b r1, g r2) {
        return a(r0, r1, r2);
    }

    /* JADX INFO: renamed from: lambda$S6DHA1L8HR32GJJETTX5etmT-3I, reason: not valid java name */
    public static /* synthetic */ Unit m697lambda$S6DHA1L8HR32GJJETTX5etmT3I(DoubaoGlassesConnectionSnapshot r0, g r1) {
        return a(r0, r1);
    }

    public static /* synthetic */ Unit lambda$ZMqi9rj5GmUluJHr2Ga0BQ1C0qk(long r0, boolean r2, boolean r3, g r4) {
        return a(r0, r2, r3, r4);
    }

    public static /* synthetic */ Unit lambda$fTO3ci3x3ffDmMxITuwqW7fVCE4(long r0, boolean r2, boolean r3, boolean r4, g r5) {
        return a(r0, r2, r3, r4, r5);
    }

    /* JADX INFO: renamed from: lambda$guNVxq_pCnAkDg4yM8Et49ne-h8, reason: not valid java name */
    public static /* synthetic */ Unit m698lambda$guNVxq_pCnAkDg4yM8Et49neh8(TaskInfo.State r0, TaskInfo r1, g r2) {
        return a(r0, r1, r2);
    }

    /* JADX INFO: renamed from: lambda$guj236n4fdDhyHLX5y-BahGAlFA, reason: not valid java name */
    public static /* synthetic */ void m699lambda$guj236n4fdDhyHLX5yBahGAlFA(DoubaoGlassesConnectionSnapshot r0) {
        a(r0);
    }

    public static /* synthetic */ Unit lambda$lOkxAgzml0sQkjb5ng6B04V2g_0(DoubaoGlassesConnectionSnapshot r0, g r1) {
        return b(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$t-jkAGdfxcLNu78J04Lj0g_Hn7I, reason: not valid java name */
    public static /* synthetic */ Unit m700lambda$tjkAGdfxcLNu78J04Lj0g_Hn7I(String r0, DoubaoGlassesConnectionSnapshot r1, g r2) {
        return a(r0, r1, r2);
    }

    public final void a() {
        if (c.compareAndSet(false, true) == true) goto L8;
        o r12 = f10141b;
        com.obric.memorydata.middleware.api.logging.e r6 = new com.obric.memorydata.middleware.api.logging.e(null, null, null, 7, null);
        if (AppContext.INSTANCE.isDebug() == false) goto L10;
        g r0 = new g();
        Unit r1 = Unit.INSTANCE;
        r12.a("眼镜同步器已启动，跳过重复初始化", r6, r0.a());
        return;
    L10:
        return;
    L8:
        UserSettings.INSTANCE.registerLoginStateListener((com.obric.memorydata.middleware.api.app.d) ZeusTransformUtils.preCheckCast(i, com.obric.memorydata.middleware.api.app.d.class, "com.obric.memorydata.plugin"));
        UserSettings.INSTANCE.registerAgreePrivacyListener((com.obric.memorydata.middleware.api.app.a) ZeusTransformUtils.preCheckCast(j, com.obric.memorydata.middleware.api.app.a.class, "com.obric.memorydata.plugin"));
        DoubaoGlassesConnectionState.registerListener$default(DoubaoGlassesConnectionState.INSTANCE, h, false, 2, null);
        i.a(d, null, null, (Function2) ZeusTransformUtils.preCheckCast(new GlassesObservationSyncCoordinator$start$2(null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        final DoubaoGlassesConnectionSnapshot r2 = DoubaoGlassesConnectionState.INSTANCE.currentSnapshot();
        f.a(r2);
        o.a(f10141b, "眼镜同步器已启动", "sync_coordinator_started", a(r2, "coordinator"), new $$Lambda$c$S6DHA1L8HR32GJJETTX5etmT3I(r2), null, 16, null);
    }
}
