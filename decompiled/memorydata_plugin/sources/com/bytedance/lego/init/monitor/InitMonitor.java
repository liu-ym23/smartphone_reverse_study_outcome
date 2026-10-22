package com.bytedance.lego.init.monitor;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.util.Pair;
import androidx.core.app.NotificationCompat;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.bytedance.crash.entity.EventBody;
import com.bytedance.crash.event.EnsureDeliverer;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.bytedance.lego.init.InitScheduler;
import com.bytedance.lego.init.h;
import com.bytedance.lego.init.l;
import com.bytedance.lego.init.util.d;
import com.bytedance.services.apm.api.IApmAgent;
import com.bytedance.services.apm.api.IEnsure;
import com.bytedance.services.apm.api.ILaunchTrace;
import com.obric.memorydata.memory.ui.list.MemoryListActivity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ThreadPoolExecutor;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u0014H\u0002J\u000e\u0010\"\u001a\u00020\u001f2\u0006\u0010#\u001a\u00020$J\u0016\u0010\"\u001a\u00020\u001f2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u0004J\u0018\u0010&\u001a\u00020\u00042\u0006\u0010'\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\u000fH\u0002J\u0018\u0010)\u001a\u00020\u00042\u0006\u0010'\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\u000fH\u0002J\u0018\u0010*\u001a\u00020\u00042\u0006\u0010'\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\u000fH\u0002J\u0018\u0010+\u001a\u00020\u00042\u0006\u0010,\u001a\u00020-2\u0006\u0010(\u001a\u00020\u000fH\u0002J\u0018\u0010.\u001a\u00020\u00042\u0006\u0010,\u001a\u00020/2\u0006\u0010(\u001a\u00020\u000fH\u0002J\u0018\u00100\u001a\u00020\u00042\u0006\u0010,\u001a\u00020/2\u0006\u0010(\u001a\u00020\u000fH\u0002J\u0018\u00101\u001a\u00020\u00042\u0006\u0010,\u001a\u00020/2\u0006\u0010(\u001a\u00020\u000fH\u0002J\u000e\u00102\u001a\u00020\u001f2\u0006\u0010'\u001a\u00020\u0004J\u001e\u00103\u001a\u00020\u001f2\u0006\u0010,\u001a\u00020/2\u0006\u0010!\u001a\u00020\u00142\u0006\u0010(\u001a\u00020\u000fJ\u001e\u00103\u001a\u00020\u001f2\u0006\u0010,\u001a\u00020-2\u0006\u0010!\u001a\u00020\u00142\u0006\u0010(\u001a\u00020\u000fJ\u001e\u00103\u001a\u00020\u001f2\u0006\u0010'\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u00142\u0006\u0010(\u001a\u00020\u000fJ\u0016\u00104\u001a\u00020\u001f2\u0006\u0010'\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\u000fJ\u001e\u00105\u001a\u00020\u001f2\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u00020\u00042\u0006\u00109\u001a\u00020:J\u0016\u0010;\u001a\u00020\u001f2\u0006\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020:J\u0016\u0010?\u001a\u00020\u001f2\u0006\u0010'\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\u000fJ\u0016\u0010@\u001a\u00020\u001f2\u0006\u0010,\u001a\u00020/2\u0006\u0010(\u001a\u00020\u000fJ\u0016\u0010A\u001a\u00020\u001f2\u0006\u0010,\u001a\u00020/2\u0006\u0010(\u001a\u00020\u000fJ\b\u0010B\u001a\u00020\u000fH\u0002J\u0006\u0010C\u001a\u00020\u001fJ\u000e\u0010D\u001a\u00020\u001f2\u0006\u0010E\u001a\u00020\u000fJ\u000e\u0010F\u001a\u00020\u001f2\u0006\u0010G\u001a\u00020\u0004J\u0010\u0010H\u001a\u00020\u001f2\u0006\u0010I\u001a\u00020\u0014H\u0002J\b\u0010J\u001a\u00020\u001fH\u0002J\u0006\u0010K\u001a\u00020\u001fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R \u0010\u0011\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00140\u00130\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0015\u001a\u0004\u0018\u00010\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0017\u0010\u0018R\u000e\u0010\u001b\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00040\u001dX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006L"}, d2 = {"Lcom/bytedance/lego/init/monitor/InitMonitor;", "", "()V", "ALL_FEED_FIRST_SHOWN", "", "ASYNC", "INIT_SCHEDULER", "MAIN", "MONITOR_INIT", "MONITOR_INIT_EXCEPTION", "TASKDISPATCHER_INIT", "TASK_END_SUFFIX", "TASK_START_SUFFIX", "WAIT_ASYNC_TASK_INIT", "alreadyFeedShown", "", "alreadyUpload", "cosTimeList", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Landroid/util/Pair;", "", "launchTraceService", "Lcom/bytedance/services/apm/api/ILaunchTrace;", "getLaunchTraceService", "()Lcom/bytedance/services/apm/api/ILaunchTrace;", "launchTraceService$delegate", "Lkotlin/Lazy;", "onAttachBaseTime", "timeoutTaskList", "", "addDuration", "", "key", "cosTime", "ensureNotReachHere", "t", "", NotificationCompat.CATEGORY_MESSAGE, "getMonitorEndTag", ActivityLifecycle.NAME, "isMainThread", "getMonitorStartTag", "getMonitorTag", "getPeriodTaskTag", "taskInfo", "Lcom/bytedance/lego/init/model/PeriodTaskInfo;", "getTaskEndTag", "Lcom/bytedance/lego/init/model/InitTaskInfo;", "getTaskStartTag", "getTaskTag", CommonConsts.LOG_REPORT_TYPE_DEFAULT, "monitorCosTime", "monitorEnd", "monitorEvent", EventBody.KEY_CATEGORY, "Lcom/bytedance/lego/init/monitor/Category;", "type", "extraLog", "Lorg/json/JSONObject;", "monitorLog", "logType", "Lcom/bytedance/lego/init/monitor/LogType;", "logExtr", "monitorStart", "monitorTaskEnd", "monitorTaskStart", "monitorTaskTimeout", "onAttachBase", "onFeedFirstShown", "needUploadTask", "onTaskTimeout", "taskId", "sendStartUpTimeAsync", "delay", "sendStartUpTimeAsyncInternal", "sendStartUpTimeImmediately", "initscheduler_release"}, k = 1, mv = {1, 1, 13})
public final class InitMonitor {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    private static final String ALL_FEED_FIRST_SHOWN = "ALLFeedFirstShown";
    public static final String ASYNC = "Async:";
    private static final String INIT_SCHEDULER = "init-scheduler";
    public static final InitMonitor INSTANCE = null;
    public static final String MAIN = "Main:";
    private static final String MONITOR_INIT = "init_task_monitor";
    private static final String MONITOR_INIT_EXCEPTION = "init_task_exception_monitor";
    public static final String TASKDISPATCHER_INIT = "InitTaskDispatcher.init";
    public static final String TASK_END_SUFFIX = "##TASKEND";
    public static final String TASK_START_SUFFIX = "##TASKSTART";
    public static final String WAIT_ASYNC_TASK_INIT = "wait_async_task_init";
    private static volatile boolean alreadyFeedShown;
    private static volatile boolean alreadyUpload;
    private static final CopyOnWriteArrayList<Pair<String, Long>> cosTimeList = null;
    private static final Lazy launchTraceService$delegate = null;
    private static long onAttachBaseTime;
    private static final List<String> timeoutTaskList = null;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 1, 13})
    static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f2787a = null;

        /* JADX INFO: renamed from: com.bytedance.lego.init.monitor.InitMonitor$a$a, reason: collision with other inner class name */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 1, 13})
        static final class RunnableC0142a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final RunnableC0142a f2788a = null;

            static {
                f2788a = new RunnableC0142a();
            }

            RunnableC0142a() {
            }

            /* JADX WARN: Type inference fix 'apply assigned field type' failed
            java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
            	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
            	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
            	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
             */
            @Override // java.lang.Runnable
            public final void run() {
                InitMonitor.access$sendStartUpTimeAsyncInternal(InitMonitor.INSTANCE);     // Catch: Exception -> L4
                return;
            L4:
                e = move-exception;
                InitMonitor r0 = InitMonitor.INSTANCE;
                Category r1 = Category.OTHER_EXCEPTION;
                String r2 = e.getClass().getName();
                Intrinsics.checkExpressionValueIsNotNull(r2, "e.javaClass.name");
                JSONObject r3 = new JSONObject();
                JSONObject r4 = new JSONObject();
                r4.put("exception_detail", Log.getStackTraceString((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin")));
                r3.put("exception_detail", r4);
                r0.monitorEvent(r1, r2, r3);
            }
        }

        static {
            f2787a = new a();
        }

        a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            Runnable r2 = (Runnable) ZeusTransformUtils.preCheckCast(RunnableC0142a.f2788a, Runnable.class, "com.obric.memorydata.plugin");
            ThreadPoolExecutor r0 = InitScheduler.INSTANCE.getExecutorServiceOrNull$initscheduler_release();
            if (r0 != null) goto L5;
        L7:
            InitMonitor r1 = InitMonitor.INSTANCE;
            new Thread(r2).start();
            Unit r3 = Unit.INSTANCE;
            return;
        L5:
            if (r0.submit(r2) == null) goto L7;
        }
    }

    static {
        $$delegatedProperties = new KProperty[]{(KProperty) ZeusTransformUtils.preCheckCast(Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(InitMonitor.class), "launchTraceService", "getLaunchTraceService()Lcom/bytedance/services/apm/api/ILaunchTrace;")), KProperty.class, "com.obric.memorydata.plugin")};
        INSTANCE = new InitMonitor();
        cosTimeList = new CopyOnWriteArrayList();
        timeoutTaskList = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        launchTraceService$delegate = LazyKt.lazy((Function0) ZeusTransformUtils.preCheckCast(InitMonitor$launchTraceService$2.INSTANCE, Function0.class, "com.obric.memorydata.plugin"));
        ALL_FEED_FIRST_SHOWN = "ALLFeedFirstShown";
        INIT_SCHEDULER = "init-scheduler";
    }

    private InitMonitor() {
    }

    public static final /* synthetic */ void access$sendStartUpTimeAsyncInternal(InitMonitor r0) {
        r0.sendStartUpTimeAsyncInternal();
    }

    private final synchronized void addDuration(String r3, long r4) {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (alreadyFeedShown == false) goto L7;
        monitor-exit(this);
        return;
    L7:
        cosTimeList.add(new Pair(r3, Long.valueOf(r4)));     // Catch: Throwable -> L10
        monitor-exit(this);
    }

    private final ILaunchTrace getLaunchTraceService() {
        Lazy r2 = launchTraceService$delegate;
        KProperty r0 = $$delegatedProperties[0];
        return (ILaunchTrace) ZeusTransformUtils.preCheckCast(r2.getValue(), ILaunchTrace.class, "com.obric.memorydata.plugin");
    }

    private final String getMonitorEndTag(String r2, boolean r3) {
        if (r3 == false) goto L7;
        StringBuilder r4 = new StringBuilder();
        String r0 = MAIN;
    L6:
        return r4.append(r0).append(r2).append(TASK_END_SUFFIX).toString();
    L7:
        r4 = new StringBuilder();
        r0 = ASYNC;
        goto L6
    }

    private final String getMonitorStartTag(String r2, boolean r3) {
        if (r3 == false) goto L7;
        StringBuilder r4 = new StringBuilder();
        String r0 = MAIN;
    L6:
        return r4.append(r0).append(r2).append(TASK_START_SUFFIX).toString();
    L7:
        r4 = new StringBuilder();
        r0 = ASYNC;
        goto L6
    }

    private final String getMonitorTag(String r1, boolean r2) {
        if (r2 == false) goto L7;
        StringBuilder r0 = new StringBuilder();
        String r3 = MAIN;
    L6:
        return r0.append(r3).append(r1).toString();
    L7:
        r0 = new StringBuilder();
        r3 = ASYNC;
        goto L6
    }

    private final String getPeriodTaskTag(com.bytedance.lego.init.model.c r1, boolean r2) {
        if (r2 == false) goto L7;
        StringBuilder r0 = new StringBuilder();
        String r3 = MAIN;
    L6:
        return r0.append(r3).append(r1.a()).toString();
    L7:
        r0 = new StringBuilder();
        r3 = ASYNC;
        goto L6
    }

    private final String getTaskEndTag(com.bytedance.lego.init.model.b r2, boolean r3) {
        if (r3 == false) goto L7;
        StringBuilder r4 = new StringBuilder();
        String r0 = MAIN;
    L6:
        return r4.append(r0).append(r2.f2783a).append(TASK_END_SUFFIX).toString();
    L7:
        r4 = new StringBuilder();
        r0 = ASYNC;
        goto L6
    }

    private final String getTaskStartTag(com.bytedance.lego.init.model.b r2, boolean r3) {
        if (r3 == false) goto L7;
        StringBuilder r4 = new StringBuilder();
        String r0 = MAIN;
    L6:
        return r4.append(r0).append(r2.f2783a).append(TASK_START_SUFFIX).toString();
    L7:
        r4 = new StringBuilder();
        r0 = ASYNC;
        goto L6
    }

    private final String getTaskTag(com.bytedance.lego.init.model.b r1, boolean r2) {
        if (r2 == false) goto L7;
        StringBuilder r0 = new StringBuilder();
        String r3 = "Main:Task-";
    L6:
        return r0.append(r3).append(r1.f2783a).toString();
    L7:
        r0 = new StringBuilder();
        r3 = "Async:Task-";
        goto L6
    }

    private final boolean monitorTaskTimeout() {
        List<String> r4 = timeoutTaskList;     // Catch: Exception -> L12
        if (r4.isEmpty() == false) goto L6;
        return false;
    L6:
        Iterator r5 = ((Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Exception -> L12
    L8:
        if (r5.hasNext() == false) goto L10;
        String r6 = (String) ZeusTransformUtils.preCheckCast(r5.next(), String.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L12
        INSTANCE.monitorEvent(Category.TASK_TIMEOUT_EXCEPTION_REAL, InitScheduler.INSTANCE.getConfig$initscheduler_release().getTimeout() + ':' + r6, new JSONObject());     // Catch: Exception -> L12
        d.b(d.f2800a, null, "TaskTimeout: " + r6 + ", " + InitScheduler.INSTANCE.getConfig$initscheduler_release().getTimeout(), 1, null);     // Catch: Exception -> L12
        goto L8
    L10:
        sendStartUpTimeAsyncInternal();     // Catch: Exception -> L12
        return true;
    L12:
        e = move-exception;
        e.printStackTrace();
        d r7 = d.f2800a;
        String r10 = Log.getStackTraceString((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        Intrinsics.checkExpressionValueIsNotNull(r10, "Log.getStackTraceString(e)");
        d.c(r7, null, r10, 1, null);
        return false;
    }

    private final void sendStartUpTimeAsync(long r4) {
        new Handler(Looper.getMainLooper()).postDelayed((Runnable) ZeusTransformUtils.preCheckCast(a.f2787a, Runnable.class, "com.obric.memorydata.plugin"), r4);
    }

    private final synchronized void sendStartUpTimeAsyncInternal() {
        monitor-enter(this);
    L23:
        th = move-exception;
        throw th;
    L4:
        if (alreadyUpload == false) goto L8;
        monitor-exit(this);
        return;
    L8:
        alreadyUpload = true;     // Catch: Throwable -> L23
        IApmAgent r1 = (IApmAgent) ZeusTransformUtils.preCheckCast(l.f2777a.a(IApmAgent.class), IApmAgent.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L23
        if (r1 == null) goto L21;
        alreadyFeedShown = true;     // Catch: Throwable -> L23
        JSONObject r0 = new JSONObject();     // Catch: Throwable -> L23
        Iterator r2 = ((Iterable) ZeusTransformUtils.preCheckCast(cosTimeList, Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Exception -> L16 Throwable -> L23
    L13:
        if (r2.hasNext() == false) goto L18;
        Pair r3 = (Pair) ZeusTransformUtils.preCheckCast(r2.next(), Pair.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L16 Throwable -> L23
        String r4 = (String) ZeusTransformUtils.preCheckCast(r3.first, String.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L16 Throwable -> L23
        Object r5 = r3.second;     // Catch: Exception -> L16 Throwable -> L23
        Intrinsics.checkExpressionValueIsNotNull(r5, "it.second");     // Catch: Exception -> L16 Throwable -> L23
        r0.put(r4, ((Number) ZeusTransformUtils.preCheckCast(r5, Number.class, "com.obric.memorydata.plugin")).longValue());     // Catch: Exception -> L16 Throwable -> L23
    L18:
        d r6 = d.f2800a;     // Catch: Throwable -> L23
        String r7 = r0.toString();     // Catch: Throwable -> L23
        Intrinsics.checkExpressionValueIsNotNull(r7, "metric.toString()");     // Catch: Throwable -> L23
        r6.b("sendStartUpTimeAsync", r7);     // Catch: Throwable -> L23
        h.f2770b.b();     // Catch: Throwable -> L23
        r1.monitorEvent(MONITOR_INIT, new JSONObject(), r0, new JSONObject());     // Catch: Throwable -> L23
        cosTimeList.clear();     // Catch: Throwable -> L23
        monitor-exit(this);
        return;
    L16:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L23
        goto L18
    L21:
        monitor-exit(this);
    }

    public final void ensureNotReachHere(Throwable r3) {
        Intrinsics.checkParameterIsNotNull(r3, "t");
        IEnsure r2 = (IEnsure) ZeusTransformUtils.preCheckCast(l.f2777a.a(IEnsure.class), IEnsure.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L6;
        r2.ensureNotReachHere(r3);
        return;
    }

    public final void ensureNotReachHere(Throwable r4, String r5) {
        Intrinsics.checkParameterIsNotNull(r4, "t");
        Intrinsics.checkParameterIsNotNull(r5, NotificationCompat.CATEGORY_MESSAGE);
        IEnsure r3 = (IEnsure) ZeusTransformUtils.preCheckCast(l.f2777a.a(IEnsure.class), IEnsure.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L5;
        r3.ensureNotReachHere(r4, r5);
    L5:
        IApmAgent r6 = (IApmAgent) ZeusTransformUtils.preCheckCast(l.f2777a.a(IApmAgent.class), IApmAgent.class, "com.obric.memorydata.plugin");
        if (r6 == null) goto L9;
        JSONObject r0 = new JSONObject();
        r0.put(EnsureDeliverer.ENSURE_NOT_REACH_HERE, r5);
        JSONObject r7 = new JSONObject();
        JSONObject r1 = new JSONObject();
        r1.put(MemoryListActivity.JUMP_FROM_DETAIL, Log.getStackTraceString(r4));
        r6.monitorEvent(MONITOR_INIT_EXCEPTION, r0, r7, r1);
        return;
    }

    public final void monitor(String r5) {
        Intrinsics.checkParameterIsNotNull(r5, ActivityLifecycle.NAME);
        addDuration(r5, System.currentTimeMillis() - onAttachBaseTime);
    }

    public final void monitorCosTime(com.bytedance.lego.init.model.b r2, long r3, boolean r5) {
        Intrinsics.checkParameterIsNotNull(r2, "taskInfo");
        addDuration(getTaskTag(r2, r5), r3);
    }

    public final void monitorCosTime(com.bytedance.lego.init.model.c r2, long r3, boolean r5) {
        Intrinsics.checkParameterIsNotNull(r2, "taskInfo");
        addDuration(getPeriodTaskTag(r2, r5), r3);
    }

    public final void monitorCosTime(String r2, long r3, boolean r5) {
        Intrinsics.checkParameterIsNotNull(r2, ActivityLifecycle.NAME);
        addDuration(getMonitorTag(r2, r5), r3);
    }

    public final void monitorEnd(String r5, boolean r6) {
        Intrinsics.checkParameterIsNotNull(r5, ActivityLifecycle.NAME);
        addDuration(getMonitorEndTag(r5, r6), System.currentTimeMillis() - onAttachBaseTime);
        ILaunchTrace r4 = getLaunchTraceService();
        if (r4 == null) goto L6;
        r4.endSpan(INIT_SCHEDULER, r5);
        return;
    }

    public final void monitorEvent(Category r4, String r5, JSONObject r6) {
        Intrinsics.checkParameterIsNotNull(r4, EventBody.KEY_CATEGORY);
        Intrinsics.checkParameterIsNotNull(r5, "type");
        Intrinsics.checkParameterIsNotNull(r6, "extraLog");
        IApmAgent r3 = (IApmAgent) ZeusTransformUtils.preCheckCast(l.f2777a.a(IApmAgent.class), IApmAgent.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L13;
        JSONObject r0 = new JSONObject();
        r0.put(r4.getValue(), r5);     // Catch: Exception -> L7
    L9:
        r6.put("processName", InitScheduler.INSTANCE.getConfig$initscheduler_release().getProcessName());
        r6.put("isUIThread", Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper()));
        r3.monitorEvent(MONITOR_INIT, r0, new JSONObject(), r6);
        d.b(d.f2800a, null, r4.name() + ' ' + r5 + ' ' + r6.toString(), 1, null);
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
        goto L9
    }

    public final void monitorLog(LogType r3, JSONObject r4) {
        Intrinsics.checkParameterIsNotNull(r3, "logType");
        Intrinsics.checkParameterIsNotNull(r4, "logExtr");
        IApmAgent r2 = (IApmAgent) ZeusTransformUtils.preCheckCast(l.f2777a.a(IApmAgent.class), IApmAgent.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L6;
        r2.monitorLog(r3.name(), r4);
        d.b(d.f2800a, null, r3.name() + " " + r4.toString(), 1, null);
        return;
    }

    public final void monitorStart(String r5, boolean r6) {
        Intrinsics.checkParameterIsNotNull(r5, ActivityLifecycle.NAME);
        addDuration(getMonitorStartTag(r5, r6), System.currentTimeMillis() - onAttachBaseTime);
        ILaunchTrace r4 = getLaunchTraceService();
        if (r4 == null) goto L6;
        r4.startSpan(INIT_SCHEDULER, r5);
        return;
    }

    public final void monitorTaskEnd(com.bytedance.lego.init.model.b r5, boolean r6) {
        Intrinsics.checkParameterIsNotNull(r5, "taskInfo");
        addDuration(getTaskEndTag(r5, r6), System.currentTimeMillis() - onAttachBaseTime);
        ILaunchTrace r4 = getLaunchTraceService();
        if (r4 == null) goto L6;
        r4.endSpan(r5.f2784b, r5.f2783a);
        return;
    }

    public final void monitorTaskStart(com.bytedance.lego.init.model.b r5, boolean r6) {
        Intrinsics.checkParameterIsNotNull(r5, "taskInfo");
        addDuration(getTaskStartTag(r5, r6), System.currentTimeMillis() - onAttachBaseTime);
        ILaunchTrace r4 = getLaunchTraceService();
        if (r4 == null) goto L6;
        r4.startSpan(r5.f2784b, r5.f2783a);
        return;
    }

    public final void onAttachBase() {
        onAttachBaseTime = System.currentTimeMillis();
        b.f2791a.a();
        ILaunchTrace r2 = getLaunchTraceService();
        if (r2 == null) goto L6;
        r2.startTrace();
        return;
    }

    public final void onFeedFirstShown(boolean r10) {
        long r1 = System.currentTimeMillis() - onAttachBaseTime;     // Catch: Exception -> L25
        boolean r3 = false;
        if (r1 > LocationInfoConst.HALF_MINUTES) goto L6;
        r3 = monitorTaskTimeout();     // Catch: Exception -> L25
    L6:
        if (r10 == true) goto L12;
        ILaunchTrace r11 = getLaunchTraceService();     // Catch: Exception -> L25
        if (r11 == null) goto L10;
        r11.cancelTrace();     // Catch: Exception -> L25
    L10:
        cosTimeList.clear();     // Catch: Exception -> L25
        return;
    L12:
        ILaunchTrace r12 = getLaunchTraceService();     // Catch: Exception -> L25
        if (r12 == null) goto L21;
        Activity r6 = (Activity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(InitScheduler.getMainActivity$initscheduler_release(), "com.obric.memorydata.plugin"), Activity.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L25
        if (r6 == null) goto L19;
        Class<?> r7 = r6.getClass();     // Catch: Exception -> L25
        if (r7 == null) goto L19;
        String r8 = r7.getName();     // Catch: Exception -> L25
    L20:
        r12.endTrace(2, r8, 20000);     // Catch: Exception -> L25
    L19:
        r8 = null;
    L21:
        addDuration(ALL_FEED_FIRST_SHOWN, r1);     // Catch: Exception -> L25
        d.b(d.f2800a, null, "onFeedFirstShown: cos " + r1 + " ms.", 1, null);     // Catch: Exception -> L25
        if (r3 == true) goto L29;
        sendStartUpTimeAsync(5000);     // Catch: Exception -> L25
        return;
    L29:
        return;
    L25:
        e = move-exception;
        ensureNotReachHere((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"), "ON_FEED_FIRST_SHOW_EXCEPTION");
        Category r2 = Category.OTHER_EXCEPTION;
        String r4 = e.getClass().getName();
        Intrinsics.checkExpressionValueIsNotNull(r4, "e.javaClass.name");
        JSONObject r5 = new JSONObject();
        JSONObject r9 = new JSONObject();
        r9.put("exception_detail", Log.getStackTraceString((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin")));
        r5.put("exception_detail", r9);
        monitorEvent(r2, r4, r5);
    }

    public final void onTaskTimeout(String r3) {
        Intrinsics.checkParameterIsNotNull(r3, "taskId");
        timeoutTaskList.add(r3);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
        d r4 = d.f2800a;
        String r2 = Log.getStackTraceString((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        Intrinsics.checkExpressionValueIsNotNull(r2, "Log.getStackTraceString(e)");
        d.c(r4, null, r2, 1, null);
    }

    public final synchronized void sendStartUpTimeImmediately() {
        monitor-enter(this);
        JSONObject r0 = new JSONObject();     // Catch: Throwable -> L11 Exception -> L13
        r0.put("curTime", System.currentTimeMillis() - onAttachBaseTime);     // Catch: Throwable -> L11 Exception -> L13
        Iterator r1 = ((Iterable) ZeusTransformUtils.preCheckCast(cosTimeList, Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Throwable -> L11 Exception -> L13
    L5:
        if (r1.hasNext() == false) goto L7;
        Pair r2 = (Pair) ZeusTransformUtils.preCheckCast(r1.next(), Pair.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11 Exception -> L13
        String r3 = (String) ZeusTransformUtils.preCheckCast(r2.first, String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11 Exception -> L13
        Object r4 = r2.second;     // Catch: Throwable -> L11 Exception -> L13
        Intrinsics.checkExpressionValueIsNotNull(r4, "it.second");     // Catch: Throwable -> L11 Exception -> L13
        r0.put(r3, ((Number) ZeusTransformUtils.preCheckCast(r4, Number.class, "com.obric.memorydata.plugin")).longValue());     // Catch: Throwable -> L11 Exception -> L13
        goto L5
    L7:
        d r5 = d.f2800a;     // Catch: Throwable -> L11 Exception -> L13
        String r6 = r0.toString();     // Catch: Throwable -> L11 Exception -> L13
        Intrinsics.checkExpressionValueIsNotNull(r6, "metric.toString()");     // Catch: Throwable -> L11 Exception -> L13
        r5.b("sendStartUpTimeImmediately", r6);     // Catch: Throwable -> L11 Exception -> L13
        IApmAgent r7 = (IApmAgent) ZeusTransformUtils.preCheckCast(l.f2777a.a(IApmAgent.class), IApmAgent.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11 Exception -> L13
        if (r7 == null) goto L15;
        r7.monitorEvent(MONITOR_INIT, new JSONObject(), r0, new JSONObject());     // Catch: Throwable -> L11 Exception -> L13
    L15:
        monitor-exit(this);
        return;
    L13:
        e = move-exception;
        d r8 = d.f2800a;     // Catch: Throwable -> L11
        String r9 = Log.getStackTraceString((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L11
        Intrinsics.checkExpressionValueIsNotNull(r9, "Log.getStackTraceString(e)");     // Catch: Throwable -> L11
        d.b(r8, null, r9, 1, null);     // Catch: Throwable -> L11
        Category r10 = Category.OTHER_EXCEPTION;     // Catch: Throwable -> L11
        String r11 = "sendStartUpTimeImmediately" + e.getClass().getName();     // Catch: Throwable -> L11
        JSONObject r12 = new JSONObject();     // Catch: Throwable -> L11
        JSONObject r13 = new JSONObject();     // Catch: Throwable -> L11
        r13.put("exception_detail", Log.getStackTraceString((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin")));     // Catch: Throwable -> L11
        r12.put("exception_detail", r13);     // Catch: Throwable -> L11
        monitorEvent(r10, r11, r12);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }
}
