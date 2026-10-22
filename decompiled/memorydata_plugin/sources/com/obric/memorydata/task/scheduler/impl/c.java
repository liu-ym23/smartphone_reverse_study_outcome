package com.obric.memorydata.task.scheduler.impl;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.os.PowerManager;
import androidx.core.app.NotificationCompat;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.bdinstall.Api;
import com.bytedance.common.wschannel.WsConstants;
import com.obric.capabilitykit.common.Ext;
import com.obric.memorydata.aikernelcore.h;
import com.obric.memorydata.awareness.api.AwarenessManager;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.middleware.api.logging.g;
import com.obric.memorydata.middleware.api.logging.o;
import com.obric.memorydata.task.AbsTaskRequest;
import com.obric.memorydata.task.TaskRegister;
import com.obric.memorydata.task.alarm.AlarmTime;
import com.obric.memorydata.task.alarm.Type;
import com.obric.memorydata.task.condition.e;
import com.obric.memorydata.task.cron.CronJobRunnerTask;
import com.obric.memorydata.task.impl.TaskInfo;
import com.obric.memorydata.task.impl.TaskResult;
import com.obric.memorydata.utils.threadpool.ThreadPoolContainer;
import com.tom_roush.pdfbox.pdmodel.a.d.f;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.i;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 E2\u00020\u0001:\u0001EB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0016\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000fH\u0016J\u0018\u0010\u0010\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J(\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u00152\u0016\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u0018\u0018\u00010\u0017H\u0016J\u0010\u0010\u0019\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u0015H\u0016J\u0010\u0010\u001b\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u0015H\u0016J\u0010\u0010\u001c\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u0015H\u0016J\u0010\u0010\u001d\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u0015H\u0016J\"\u0010\u0019\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020\u001fH\u0002J\u0018\u0010!\u001a\u00020\u001f2\u0006\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\f\u0010\"\u001a\u00020\u001f*\u00020\u000bH\u0002J\f\u0010#\u001a\u00020\u001f*\u00020\u000bH\u0002J\u0010\u0010$\u001a\u00020\r2\u0006\u0010%\u001a\u00020\u0015H\u0016J\u0010\u0010&\u001a\u00020\u001f2\u0006\u0010%\u001a\u00020\u0015H\u0016J\b\u0010'\u001a\u00020\rH\u0016J\b\u0010(\u001a\u00020\rH\u0016J\u0010\u0010)\u001a\u00020\u001f2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010*\u001a\u00020\r2\u0006\u0010+\u001a\u00020\u00152\u0006\u0010,\u001a\u00020-H\u0016J$\u0010.\u001a\u00020\r2\u0006\u0010+\u001a\u00020\u00152\u0012\u0010/\u001a\u000e\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020\r00H\u0016J\u0010\u00101\u001a\u00020\r2\u0006\u0010+\u001a\u00020\u0015H\u0016J\u0016\u00102\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0082@¢\u0006\u0002\u00103J\u0010\u00104\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\f\u00105\u001a\u00020\u001f*\u00020\u000bH\u0002J\u0010\u00106\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0010\u00107\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0015\u00108\u001a\u00020\u001f2\u0006\u0010\n\u001a\u00020\u000bH\u0000¢\u0006\u0002\b9J\u0015\u0010:\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u000bH\u0000¢\u0006\u0002\b;J&\u0010<\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u00152\u0014\b\u0002\u0010=\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u001f00H\u0002J\u0018\u0010>\u001a\u00020\u001f2\u0006\u0010%\u001a\u00020\u00152\u0006\u0010?\u001a\u00020\u001fH\u0002J\u0010\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020\u000bH\u0002J\r\u0010C\u001a\u00020\u0007H\u0000¢\u0006\u0002\bDR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006F"}, d2 = {"Lcom/obric/memorydata/task/scheduler/impl/TaskManager;", "Lcom/obric/memorydata/task/scheduler/ITaskManager;", "<init>", "()V", "memoryTaskExecutor", "Lcom/obric/memorydata/task/scheduler/impl/MemoryTaskExecutor;", "conditionValidator", "Lcom/obric/memorydata/task/condition/ConditionValidator;", "executeAwait", "Lcom/obric/memorydata/task/impl/TaskResult;", Ext.KEY_REQUEST, "Lcom/obric/memorydata/task/AbsTaskRequest;", "enqueue", "", "requests", "", "enqueueWithUniqueTask", "existingTaskPolicy", "Lcom/obric/memorydata/task/scheduler/impl/ExistingTaskPolicy;", "dispatchEvent", "event", "", WsConstants.KEY_EXTRA, "", "", "removeTask", "taskName", "removeTaskIncludingScheduled", "removeScheduledTasks", "cancelTaskIncludingScheduled", "includeScheduledPackageTask", "", "includeActiveTask", "shouldRetainScheduledPackageTask", "isScheduledTaskRequest", "hasFutureSchedule", "removeTaskId", Api.KEY_UUID, "cancelTaskId", "removeAllBackgroundTask", "printAllBackgroundTask", "hasTask", "notifyProgress", "taskId", "payload", "Lorg/json/JSONObject;", "registerProgressCallback", f.c, "Lkotlin/Function1;", "unregisterProgressCallback", "executeAwaitInner", "(Lcom/obric/memorydata/task/AbsTaskRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "innerEnqueue", "isDisabledAutoTriggerRequest", "executeAlarmRequest", "executeDelayRequest", "isSatisfiedCondition", "isSatisfiedCondition$task_obricRelease", "executeImmediately", "executeImmediately$task_obricRelease", "cancelAlarmTask", "retainPredicate", "cancelAlarmTaskId", "markCancelled", "convertTaskRequestToInfoBeforeEnqueue", "Lcom/obric/memorydata/task/impl/TaskInfo;", "taskRequest", "getConditionValidator", "getConditionValidator$task_obricRelease", "Companion", "task_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class c implements com.obric.memorydata.task.scheduler.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f12961a = null;
    private static final ConcurrentHashMap<String, Pair<AbsTaskRequest, PendingIntent>> d = null;
    private static final ConcurrentHashMap<String, Integer> e = null;
    private static final ConcurrentHashMap<String, Function1<JSONObject, Unit>> f = null;
    private static final int g = 0;
    private static final Lazy<c> h = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final b f12962b;
    private final e c;

    @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u001d\u001a\u00020\u001eJ\r\u0010\u001f\u001a\u00020\u0018H\u0000¢\u0006\u0002\b R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R+\u0010\u0006\u001a\u001c\u0012\u0004\u0012\u00020\u0005\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\n0\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001d\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000e0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR&\u0010\u0010\u001a\u001a\u0012\u0004\u0012\u00020\u0005\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\u00110\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\u00020\u000eX\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u001b\u0010\u0017\u001a\u00020\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u0019\u0010\u001a¨\u0006!"}, d2 = {"Lcom/obric/memorydata/task/scheduler/impl/TaskManager$Companion;", "", "<init>", "()V", "TAG", "", "INTERVAL_TASK_REQUEST_MAP", "Ljava/util/concurrent/ConcurrentHashMap;", "Lkotlin/Pair;", "Lcom/obric/memorydata/task/AbsTaskRequest;", "Landroid/app/PendingIntent;", "getINTERVAL_TASK_REQUEST_MAP", "()Ljava/util/concurrent/ConcurrentHashMap;", "INTERVAL_TASK_COUNT_MAP", "", "getINTERVAL_TASK_COUNT_MAP", "PROGRESS_CALLBACK_MAP", "Lkotlin/Function1;", "Lorg/json/JSONObject;", "", "SCHEDULE_ALARM_MAX_COUNT_FOR_ONE_TASK", "getSCHEDULE_ALARM_MAX_COUNT_FOR_ONE_TASK", "()I", "sInstance", "Lcom/obric/memorydata/task/scheduler/impl/TaskManager;", "getSInstance", "()Lcom/obric/memorydata/task/scheduler/impl/TaskManager;", "sInstance$delegate", "Lkotlin/Lazy;", "getInstance", "Lcom/obric/memorydata/task/scheduler/ITaskManager;", "getTaskManagerInstance", "getTaskManagerInstance$task_obricRelease", "task_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        private final c f() {
            return (c) ZeusTransformUtils.preCheckCast(c.e().getValue(), c.class, "com.obric.memorydata.plugin");
        }

        public final ConcurrentHashMap<String, Pair<AbsTaskRequest, PendingIntent>> a() {
            return c.b();
        }

        public final ConcurrentHashMap<String, Integer> b() {
            return c.c();
        }

        public final int c() {
            return c.d();
        }

        public final com.obric.memorydata.task.scheduler.b d() {
            return (com.obric.memorydata.task.scheduler.b) ZeusTransformUtils.preCheckCast(f(), com.obric.memorydata.task.scheduler.b.class, "com.obric.memorydata.plugin");
        }

        public final c e() {
            return f();
        }
    }

    static {
        f12961a = new a(null);
        d = new ConcurrentHashMap();
        e = new ConcurrentHashMap();
        f = new ConcurrentHashMap();
        g = 20;
        h = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, $$Lambda$c$yCvaTlTQXzHvF437QnDUb3BksE.INSTANCE);
    }

    public c() {
        this.f12962b = b.f12958b.a();
        this.c = new e();
    }

    private final Object a(AbsTaskRequest r10, Continuation<? super TaskResult> r11) {
        Continuation r9 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r11, Continuation.class, "com.obric.memorydata.plugin");
        SafeContinuation r12 = new SafeContinuation(IntrinsicsKt.intercepted(r9));
        Continuation r1 = (Continuation) ZeusTransformUtils.preCheckCast(r12, Continuation.class, "com.obric.memorydata.plugin");
        r10.getTaskParameter().setSync(true);
        if (r10.getTaskParameter().getExistingTaskPolicy() != null) goto L17;
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r10.getTaskParameter().getConditions(), Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == true) goto L15;
        com.obric.memorydata.task.scheduler.impl.a r0 = new com.obric.memorydata.task.scheduler.impl.a(r10);
        r0.run();
        TaskResult r13 = r0.d();
        if (r13 != null) goto L9;
        Result.Companion r14 = Result.Companion;
        r13 = new TaskResult(1, null, null, null, 14, null);
    L10:
        r1.resumeWith(Result.m1421constructorimpl(r13));
        Object r15 = r12.getOrThrow();
        if (r15 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L13;
        DebugProbesKt.probeCoroutineSuspended(r9);
    L13:
        return r15;
    L9:
        Result.Companion r2 = Result.Companion;
        goto L10
    L15:
        throw new IllegalStateException("sync task not support setCondition");
    L17:
        throw new IllegalStateException("sync task not support existingTaskPolicy");
    }

    public static final /* synthetic */ Object a(c r2, AbsTaskRequest r3, Continuation r4) {
        return r2.a(r3, (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    private static final void a(AbsTaskRequest r9, long r10) {
        com.obric.memorydata.task.utils.b.a(com.obric.memorydata.task.utils.b.f12969a, (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r9, r10, true, false, 16, null);
    }

    static /* synthetic */ void a(c r1, String r2, Function1 r3, int r4, Object r5) {
        Function1<? super AbsTaskRequest, Boolean> r6 = (Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin");
        if ((r4 & 2) == 0) goto L5;
        r6 = $$Lambda$c$OZlwkYgnfGOpkXXxGlKwcYxpr0.INSTANCE;
    L5:
        r1.b(r2, r6);
    }

    static /* synthetic */ void a(c r0, String r1, boolean r2, boolean r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = false;
    L5:
        r0.a(r1, r2, r3);
    }

    private final void a(String r8, boolean r9, boolean r10) {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "TaskManager", "removeTask " + r8 + " includeScheduledPackageTask=" + r9 + " includeActiveTask=" + r10, false, 4, null);
        final boolean r11 = a(r8, r9);
        Function1<? super AbsTaskRequest, Boolean> r0 = new $$Lambda$c$Myi9QCuT4TWp50u0yR8KREWMPPw(r11, this);
        this.f12962b.a(r8, r0);
        if (r10 == false) goto L5;
        this.f12962b.c(r8);
    L5:
        this.c.a(r8, r0);
        b(r8, r0);
    }

    private final boolean a(String r1, boolean r2) {
        if (r2 == false) goto L4;
    L8:
        return false;
    L4:
        if (TaskRegister.f12863a.a(r1) == false) goto L8;
        if (h.f8481a.a(r1) == false) goto L8;
        return true;
    }

    private static final boolean a(boolean r6, c r7, AbsTaskRequest r8) {
        Intrinsics.checkNotNullParameter(r8, Ext.KEY_REQUEST);
        if (r6 == false) goto L9;
        boolean r9 = r7.f(r8);
        if (r9 == false) goto L7;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "TaskManager", "retain scheduled package task " + r8.getTaskParameter(), false, 4, null);
    L7:
        if (r9 == false) goto L9;
        return true;
    L9:
        return false;
    }

    public static final /* synthetic */ ConcurrentHashMap b() {
        return d;
    }

    private final void b(String r9, Function1<? super AbsTaskRequest, Boolean> r10) {
        Function1 r8 = (Function1) ZeusTransformUtils.wrapperContextForParams(r10, Function1.class, "com.obric.memorydata.plugin");
        Object r11 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getSystemService(NotificationCompat.CATEGORY_ALARM);
        Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type android.app.AlarmManager");
        AlarmManager r12 = (AlarmManager) ZeusTransformUtils.preCheckCast(r11, AlarmManager.class, "com.obric.memorydata.plugin");
        Set<String> r1 = d.keySet();
        Intrinsics.checkNotNullExpressionValue(r1, "<get-keys>(...)");
        Iterable r2 = (Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.memorydata.plugin");
        Collection r3 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r4 = r2.iterator();
    L4:
        if (r4.hasNext() == false) goto L15;
        Object r5 = r4.next();
        String r6 = (String) ZeusTransformUtils.preCheckCast(r5, String.class, "com.obric.memorydata.plugin");
        Pair r7 = (Pair) ZeusTransformUtils.preCheckCast(d.get(r6), Pair.class, "com.obric.memorydata.plugin");
        boolean r13 = false;
        if (r7 != null) goto L9;
    L13:
        if (r13 == false) goto L4;
        r3.add(r5);
        goto L4
    L9:
        if (Intrinsics.areEqual(((AbsTaskRequest) ZeusTransformUtils.preCheckCast(r7.getFirst(), AbsTaskRequest.class, "com.obric.memorydata.plugin")).getTaskParameter().getName(), r9) == false) goto L13;
        if (((Boolean) ZeusTransformUtils.preCheckCast(r8.invoke(r7.getFirst()), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == true) goto L13;
        r13 = true;
        goto L13
    L15:
        Iterator r14 = ((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L17:
        if (r14.hasNext() == false) goto L27;
        String r15 = (String) ZeusTransformUtils.preCheckCast(r14.next(), String.class, "com.obric.memorydata.plugin");
        Pair r16 = (Pair) ZeusTransformUtils.preCheckCast(d.remove(r15), Pair.class, "com.obric.memorydata.plugin");
        if (r16 == null) goto L17;
        PendingIntent r17 = (PendingIntent) ZeusTransformUtils.preCheckCast(r16.getSecond(), PendingIntent.class, "com.obric.memorydata.plugin");
        if (r17 == null) goto L17;
        r12.cancel(r17);     // Catch: RuntimeException -> L24
    L26:
        com.obric.memorydata.task.utils.b.f12969a.a(r15);
    L24:
        e = move-exception;
        e.printStackTrace();
        goto L26
    }

    private final boolean b(String r4, boolean r5) {
        Object r3 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getSystemService(NotificationCompat.CATEGORY_ALARM);
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type android.app.AlarmManager");
        AlarmManager r6 = (AlarmManager) ZeusTransformUtils.preCheckCast(r3, AlarmManager.class, "com.obric.memorydata.plugin");
        Pair r1 = (Pair) ZeusTransformUtils.preCheckCast(d.remove(r4), Pair.class, "com.obric.memorydata.plugin");
        if (r5 == false) goto L8;
        if (r1 == null) goto L8;
        AbsTaskRequest r7 = (AbsTaskRequest) ZeusTransformUtils.preCheckCast(r1.getFirst(), AbsTaskRequest.class, "com.obric.memorydata.plugin");
        if (r7 == null) goto L8;
        r7.setCancelled();
    L8:
        if (r1 == null) goto L16;
        PendingIntent r8 = (PendingIntent) ZeusTransformUtils.preCheckCast(r1.getSecond(), PendingIntent.class, "com.obric.memorydata.plugin");
        if (r8 == null) goto L16;
        r6.cancel(r8);     // Catch: RuntimeException -> L13
    L15:
        com.obric.memorydata.task.utils.b.f12969a.a(r4);
    L13:
        e = move-exception;
        e.printStackTrace();
    L16:
        if (r1 == null) goto L18;
        return true;
    L18:
        return false;
    }

    public static final /* synthetic */ ConcurrentHashMap c() {
        return e;
    }

    public static final /* synthetic */ int d() {
        return g;
    }

    public static final /* synthetic */ Lazy e() {
        return h;
    }

    private static final c f() {
        return new c();
    }

    private final boolean f(AbsTaskRequest r3) {
        String r0 = r3.getTaskParameter().getInputParams().optString("trigger_source");
        if (g(r3) == false) goto L5;
    L10:
        return true;
    L5:
        if (Intrinsics.areEqual(r0, CommonConsts.TIMER_TYPE) == true) goto L10;
        if (Intrinsics.areEqual(r0, CronJobRunnerTask.KEY_TRIGGER_SOURCE_VALUE) == true) goto L10;
        return false;
    }

    private final boolean g(AbsTaskRequest r7) {
        if (r7.getTaskParameter().getDelay().c() <= 0) goto L5;
        return true;
    L5:
        if (r7.getTaskParameter().getInterval().c() <= 0) goto L7;
        return true;
    L7:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r7.getTaskParameter().getAlarmTimeList(), Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == true) goto L13;
        return false;
    L13:
        return true;
    }

    private final void h(AbsTaskRequest r10) {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "TaskManager", "innerEnqueue " + r10, false, 4, null);
        if (i(r10) == false) goto L8;
        o r9 = (o) ZeusTransformUtils.preCheckCast(com.obric.memorydata.middleware.api.logging.b.f11611a, o.class, "com.obric.memorydata.plugin");
        com.obric.memorydata.middleware.api.logging.e r6 = new com.obric.memorydata.middleware.api.logging.e(null, null, null, 7, null);
        if (AppContext.INSTANCE.isDebug() == false) goto L27;
        g r0 = new g();
        r0.a("package_name", r10.getTaskParameter().getName());
        Unit r11 = Unit.INSTANCE;
        r9.a("自动触发任务入队已被 Feature 开关拦截", r6, r0.a());
        return;
    L27:
        return;
    L8:
        r10.getTaskParameter().setTaskEnqueueTime(System.currentTimeMillis());
        com.obric.memorydata.task.scheduler.c r1 = r10.getTaskParameter().getOnTaskInfoCallBack();
        if (r1 == null) goto L12;
        r1.a(l(r10));
    L12:
        if (r10.getTaskParameter().getSync() == false) goto L16;
        this.f12962b.a((Runnable) ZeusTransformUtils.preCheckCast(new com.obric.memorydata.task.scheduler.impl.a(r10), Runnable.class, "com.obric.memorydata.plugin"));
        return;
    L16:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r10.getTaskParameter().getAlarmTimeList(), Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L20;
        j(r10);
        return;
    L20:
        if (r10.getTaskParameter().getDelay().a() != 0) goto L24;
        this.f12962b.a((Runnable) ZeusTransformUtils.preCheckCast(new com.obric.memorydata.task.scheduler.impl.a(r10), Runnable.class, "com.obric.memorydata.plugin"), r10.getTaskParameter().getExecuteImmediately());
        return;
    L24:
        if (r10.getTaskParameter().getDelay().a() == 0) goto L28;
        k(r10);
        return;
    }

    private final boolean i(AbsTaskRequest r6) {
        String r5 = r6.getTaskParameter().getInputParams().optString("trigger_source");
        if (StringsKt.startsWith$default(r6.getTaskParameter().getName(), CronJobRunnerTask.TASK_NAME_PREFIX, false, 2, null) == false) goto L6;
        String r7 = r6.getTaskParameter().getInputParams().optString(CronJobRunnerTask.KEY_TARGET_TASK);
    L12:
        Intrinsics.checkNotNull(r7);
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L15;
        return false;
    L15:
        if (AwarenessManager.INSTANCE.isPackageAutoTriggerEnabled(r7) == false) goto L17;
        return false;
    L17:
        return true;
    L6:
        if (Intrinsics.areEqual(r5, CommonConsts.TIMER_TYPE) == false) goto L8;
    L11:
        r7 = r6.getTaskParameter().getName();
        goto L12
    L8:
        if (Intrinsics.areEqual(r5, CronJobRunnerTask.KEY_TRIGGER_SOURCE_VALUE) == true) goto L11;
        return false;
    }

    private final void j(AbsTaskRequest r13) {
        if (r13.getTaskParameter().getAlarmAutoTrigger() == false) goto L5;
        this.f12962b.a((Runnable) ZeusTransformUtils.preCheckCast(new com.obric.memorydata.task.scheduler.impl.a(r13), Runnable.class, "com.obric.memorydata.plugin"), r13.getTaskParameter().getExecuteImmediately());
    L5:
        long r2 = Long.MAX_VALUE;
        Iterator r0 = ((Iterable) ZeusTransformUtils.preCheckCast(r13.getTaskParameter().getAlarmTimeList(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
        Type r4 = null;
        AlarmTime r6 = null;
    L7:
        if (r0.hasNext() == false) goto L11;
        AlarmTime r7 = (AlarmTime) ZeusTransformUtils.preCheckCast(r0.next(), AlarmTime.class, "com.obric.memorydata.plugin");
        long r8 = com.obric.memorydata.task.alarm.a.f12865a.a(r7);
        if (r2 < r8) goto L7;
        r6 = r7;
        r2 = r8;
        goto L7
    L11:
        if (r6 == null) goto L14;
        r4 = r6.getType();
    L14:
        if (r4 != Type.ONCE) goto L16;
        r13.getTaskParameter().getAlarmTimeList().remove(r6);
    L16:
        r13.getTaskParameter().setAlarmAutoTrigger(true);
        com.obric.memorydata.task.utils.b.a(com.obric.memorydata.task.utils.b.f12969a, (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r13, System.currentTimeMillis() + new com.obric.memorydata.task.impl.f(r2).c(), false, true, 8, null);
    }

    private final void k(final AbsTaskRequest r8) {
        Object r0 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getSystemService("power");
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type android.os.PowerManager");
        boolean r1 = ((PowerManager) ZeusTransformUtils.preCheckCast(r0, PowerManager.class, "com.obric.memorydata.plugin")).isDeviceIdleMode();
        if (r8.getTaskParameter().getDelay().b().toMillis(r8.getTaskParameter().getDelay().a()) >= com.obric.memorydata.task.scheduler.impl.a.f12955a.a().b().toMillis(com.obric.memorydata.task.scheduler.impl.a.f12955a.a().a())) goto L8;
        if (r1 == true) goto L8;
        if (r8.getTaskParameter().getTriggerExactly() == true) goto L8;
        this.f12962b.a((Runnable) ZeusTransformUtils.preCheckCast(new com.obric.memorydata.task.scheduler.impl.a(r8), Runnable.class, "com.obric.memorydata.plugin"), r8.getTaskParameter().getDelay());
        return;
    L8:
        final long r2 = System.currentTimeMillis() + r8.getTaskParameter().getDelay().b().toMillis(r8.getTaskParameter().getDelay().a());
        ThreadPoolContainer.Companion.getInstance().execute(new $$Lambda$c$oc6Ec4FqJ6TL6Kd0mkqG3G0LWVY(r8, r2));
    }

    private final TaskInfo l(AbsTaskRequest r19) {
        TaskInfo r15 = new TaskInfo(r19.getTaskParameter().getUuid(), null, null, null, null, false, 0, 0, 0, 0, 1022, null);
        r15.a(r19.getTaskParameter().getName());
        r15.a(r19.getTaskParameter().getInputParams());
        r15.a(TaskInfo.State.ENQUEUED);
        return r15;
    }

    public static /* synthetic */ boolean lambda$Myi9QCuT4TWp50u0yR8KREWMPPw(boolean r0, c r1, AbsTaskRequest r2) {
        return a(r0, r1, r2);
    }

    /* JADX INFO: renamed from: lambda$OZlwkYgnfGOpkXXxGl-KwcYxpr0, reason: not valid java name */
    public static /* synthetic */ boolean m1198lambda$OZlwkYgnfGOpkXXxGlKwcYxpr0(AbsTaskRequest r0) {
        return m(r0);
    }

    public static /* synthetic */ void lambda$oc6Ec4FqJ6TL6Kd0mkqG3G0LWVY(AbsTaskRequest r0, long r1) {
        a(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$yCvaT-lTQXzHvF437QnDUb3BksE, reason: not valid java name */
    public static /* synthetic */ c m1199lambda$yCvaTlTQXzHvF437QnDUb3BksE() {
        return f();
    }

    private static final boolean m(AbsTaskRequest r1) {
        Intrinsics.checkNotNullParameter(r1, "it");
        return false;
    }

    public final e a() {
        return this.c;
    }

    @Override // com.obric.memorydata.task.scheduler.b
    public TaskResult a(AbsTaskRequest r4) {
        Intrinsics.checkNotNullParameter(r4, Ext.KEY_REQUEST);
        Ref.ObjectRef r0 = new Ref.ObjectRef();
        i.a(null, (Function2) ZeusTransformUtils.preCheckCast(new TaskManager$executeAwait$1(r0, this, r4, null), Function2.class, "com.obric.memorydata.plugin"), 1, null);
        return (TaskResult) ZeusTransformUtils.preCheckCast(r0.element, TaskResult.class, "com.obric.memorydata.plugin");
    }

    public void a(AbsTaskRequest r10, ExistingTaskPolicy r11) {
        Intrinsics.checkNotNullParameter(r10, Ext.KEY_REQUEST);
        Intrinsics.checkNotNullParameter(r11, "existingTaskPolicy");
        if (r11 != ExistingTaskPolicy.KEEP_IN_QUEUE) goto L26;
        if (this.f12962b.b((Runnable) ZeusTransformUtils.preCheckCast(new com.obric.memorydata.task.scheduler.impl.a(r10), Runnable.class, "com.obric.memorydata.plugin")) == false) goto L9;
        IRunLog r0 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r9 = new StringBuilder();
        String r12 = "ExistingTaskPolicy.KEEP has already same task ";
    L7:
        IRunLog.a.a(r0, "TaskManager", r9.append(r12).append(r10).toString(), false, 4, null);
        return;
    L9:
        Map r13 = (Map) ZeusTransformUtils.preCheckCast(d, Map.class, "com.obric.memorydata.plugin");
        boolean r2 = false;
        if (r13.isEmpty() == true) goto L18;
        Iterator r14 = r13.entrySet().iterator();
    L14:
        if (r14.hasNext() == false) goto L18;
        if (Intrinsics.areEqual(((AbsTaskRequest) ZeusTransformUtils.preCheckCast(((Pair) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r14.next(), Map.Entry.class, "com.obric.memorydata.plugin")).getValue(), Pair.class, "com.obric.memorydata.plugin")).getFirst(), AbsTaskRequest.class, "com.obric.memorydata.plugin")).getTaskParameter().getName(), r10.getTaskParameter().getName()) == false) goto L14;
        r2 = true;
    L18:
        if (r2 == false) goto L21;
        r0 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        r9 = new StringBuilder();
        r12 = "alarm manager has same task ";
        goto L7
    L21:
        if (this.c.a(r10.getTaskParameter().getName()) == false) goto L23;
        r0 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        r9 = new StringBuilder();
        r12 = "condition pending list has same task ";
        goto L7
    L23:
        h(r10);
        return;
    L26:
        if (r11 != ExistingTaskPolicy.REPLACE_IN_QUEUE) goto L28;
    L29:
        com.obric.memorydata.task.scheduler.impl.a r1 = new com.obric.memorydata.task.scheduler.impl.a(r10);
        if (this.f12962b.b((Runnable) ZeusTransformUtils.preCheckCast(r1, Runnable.class, "com.obric.memorydata.plugin")) == false) goto L33;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "TaskManager", "ExistingTaskPolicy.REPLACE remove all match tasks current request " + r10, false, 4, null);
        this.f12962b.c((Runnable) ZeusTransformUtils.preCheckCast(r1, Runnable.class, "com.obric.memorydata.plugin"));
    L33:
        if (this.c.a(r10.getTaskParameter().getName()) == false) goto L35;
        e.a(this.c, r10.getTaskParameter().getName(), null, 2, null);
    L35:
        a(this, r10.getTaskParameter().getName(), null, 2, null);
        h(r10);
    L37:
        if (r11 != ExistingTaskPolicy.SINGLE_QUEUE) goto L43;
        h(r10);
        return;
    L43:
        return;
    L28:
        if (r11 != ExistingTaskPolicy.CANCEL_EXISTING) goto L37;
        goto L29
    }

    @Override // com.obric.memorydata.task.scheduler.b
    public void a(String r8) {
        Intrinsics.checkNotNullParameter(r8, "taskName");
        a(this, r8, false, false, 4, null);
    }

    @Override // com.obric.memorydata.task.scheduler.b
    public void a(String r2, Map<String, ? extends Object> r3) {
        Map<String, ? extends Object> r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, "event");
        AwarenessManager.INSTANCE.dispatchTaskEvent(r2, r1);
    }

    @Override // com.obric.memorydata.task.scheduler.b
    public void a(String r3, Function1<? super JSONObject, Unit> r4) {
        Function1 r2 = (Function1) ZeusTransformUtils.wrapperContextForParams(r4, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "taskId");
        Intrinsics.checkNotNullParameter(r2, f.c);
        ((Map) ZeusTransformUtils.preCheckCast(f, Map.class, "com.obric.memorydata.plugin")).put(r3, r2);
    }

    @Override // com.obric.memorydata.task.scheduler.b
    public void a(String r2, JSONObject r3) {
        Intrinsics.checkNotNullParameter(r2, "taskId");
        Intrinsics.checkNotNullParameter(r3, "payload");
        Function1 r1 = (Function1) ZeusTransformUtils.preCheckCast(f.get(r2), Function1.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L6;
        r1.invoke(r3);
        return;
    }

    @Override // com.obric.memorydata.task.scheduler.b
    public void a(List<? extends AbsTaskRequest> r10) {
        List r11 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r11, "requests");
        Iterator r12 = ((Iterable) ZeusTransformUtils.preCheckCast(r11, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r12.hasNext() == false) goto L9;
        AbsTaskRequest r0 = (AbsTaskRequest) ZeusTransformUtils.preCheckCast(r12.next(), AbsTaskRequest.class, "com.obric.memorydata.plugin");
        if (r0.getTaskParameter().getExistingTaskPolicy() != null) goto L7;
        h(r0);
        goto L4
    L7:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "TaskManager", "enqueueWithUniqueTask " + r0.getTaskParameter().getName(), false, 4, null);
        ExistingTaskPolicy r2 = r0.getTaskParameter().getExistingTaskPolicy();
        Intrinsics.checkNotNull(r2);
        a(r0, r2);
        goto L4
    }

    @Override // com.obric.memorydata.task.scheduler.b
    public void b(AbsTaskRequest r2) {
        Intrinsics.checkNotNullParameter(r2, Ext.KEY_REQUEST);
        List<? extends AbsTaskRequest> r3 = Collections.singletonList(r2);
        Intrinsics.checkNotNullExpressionValue(r3, "singletonList(...)");
        a(r3);
    }

    @Override // com.obric.memorydata.task.scheduler.b
    public void b(String r3) {
        Intrinsics.checkNotNullParameter(r3, "taskName");
        a(r3, true, false);
    }

    @Override // com.obric.memorydata.task.scheduler.b
    public void c(String r9) {
        Intrinsics.checkNotNullParameter(r9, "taskName");
        o r0 = (o) ZeusTransformUtils.preCheckCast(com.obric.memorydata.middleware.api.logging.b.f11611a, o.class, "com.obric.memorydata.plugin");
        com.obric.memorydata.middleware.api.logging.e r7 = new com.obric.memorydata.middleware.api.logging.e(null, null, null, 7, null);
        if (AppContext.INSTANCE.isDebug() == false) goto L5;
        g r1 = new g();
        r1.a("package_name", r9);
        Unit r2 = Unit.INSTANCE;
        r0.a("算法包未来自动调度已清理", r7, r1.a());
    L5:
        this.f12962b.b(r9);
    }

    @Override // com.obric.memorydata.task.scheduler.b
    public boolean c(AbsTaskRequest r3) {
        Intrinsics.checkNotNullParameter(r3, Ext.KEY_REQUEST);
        return this.f12962b.b((Runnable) ZeusTransformUtils.preCheckCast(new com.obric.memorydata.task.scheduler.impl.a(r3), Runnable.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.task.scheduler.b
    public void d(String r2) {
        Intrinsics.checkNotNullParameter(r2, "taskName");
        a(r2, true, true);
    }

    public final boolean d(AbsTaskRequest r2) {
        Intrinsics.checkNotNullParameter(r2, Ext.KEY_REQUEST);
        return this.c.a(r2);
    }

    public final void e(AbsTaskRequest r4) {
        Intrinsics.checkNotNullParameter(r4, Ext.KEY_REQUEST);
        this.f12962b.a((Runnable) ZeusTransformUtils.preCheckCast(new com.obric.memorydata.task.scheduler.impl.a(r4), Runnable.class, "com.obric.memorydata.plugin"), r4.getTaskParameter().getExecuteImmediately());
    }

    @Override // com.obric.memorydata.task.scheduler.b
    public void e(String r8) {
        Intrinsics.checkNotNullParameter(r8, Api.KEY_UUID);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "TaskManager", "removeTask " + r8, false, 4, null);
        this.f12962b.e(r8);
        this.c.b(r8);
        b(r8, false);
    }

    @Override // com.obric.memorydata.task.scheduler.b
    public boolean f(String r8) {
        Intrinsics.checkNotNullParameter(r8, Api.KEY_UUID);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "TaskManager", "cancelTaskId " + r8, false, 4, null);
        boolean r0 = com.obric.memorydata.task.e.f12914a.a(r8);
        if (this.f12962b.d(r8) == true) goto L7;
        if (r0 == true) goto L7;
        boolean r1 = false;
    L9:
        if (this.c.b(r8) == true) goto L13;
        if (r1 == true) goto L13;
        boolean r2 = false;
    L15:
        if (b(r8, true) == true) goto L18;
        if (r2 == true) goto L18;
        return false;
    L18:
        return true;
    L13:
        r2 = true;
    L7:
        r1 = true;
        goto L9
    }

    @Override // com.obric.memorydata.task.scheduler.b
    public void g(String r1) {
        Intrinsics.checkNotNullParameter(r1, "taskId");
        f.remove(r1);
    }
}
