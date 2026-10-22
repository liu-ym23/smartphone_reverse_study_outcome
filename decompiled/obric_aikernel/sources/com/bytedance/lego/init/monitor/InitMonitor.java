package com.bytedance.lego.init.monitor;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.util.Pair;
import androidx.core.app.NotificationCompat;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.crash.entity.EventBody;
import com.bytedance.crash.event.EnsureDeliverer;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.bytedance.lego.init.InitScheduler;
import com.bytedance.lego.init.InitTaskDispatcher;
import com.bytedance.lego.init.j;
import com.bytedance.lego.init.util.c;
import com.bytedance.services.apm.api.IApmAgent;
import com.bytedance.services.apm.api.IEnsure;
import com.bytedance.services.apm.api.ILaunchTrace;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ThreadPoolExecutor;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import m3.g;
import m3.h;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\bP\u0010QJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\f\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0018\u0010\u000e\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0018\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0018\u0010\u0011\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0018\u0010\u0012\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0018\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0018\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\u0015\u001a\u00020\nH\u0002J\u0010\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0004H\u0002J\b\u0010\u0018\u001a\u00020\u0006H\u0002J\u0006\u0010\u0019\u001a\u00020\u0006J\u001e\u0010\u001a\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nJ\u001e\u0010\u001a\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nJ\u001e\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nJ\u0016\u0010\u001b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nJ\u0016\u0010\u001c\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nJ\u0016\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nJ\u0016\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nJ\u000e\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0002J\u000e\u0010!\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\nJ\u001e\u0010'\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020\u00022\u0006\u0010&\u001a\u00020%J\u000e\u0010)\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\u0002J\u0016\u0010-\u001a\u00020\u00062\u0006\u0010+\u001a\u00020*2\u0006\u0010,\u001a\u00020\u0002J\u0016\u00101\u001a\u00020\u00062\u0006\u0010/\u001a\u00020.2\u0006\u00100\u001a\u00020%J\u000e\u0010-\u001a\u00020\u00062\u0006\u0010+\u001a\u00020*J\u0006\u00102\u001a\u00020\u0006R\u0016\u00103\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b3\u00104R\u0016\u00105\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b5\u00104R\u0016\u00106\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b6\u00104R\u0016\u00107\u001a\u00020\u00028\u0002@\u0002X\u0082D¢\u0006\u0006\n\u0004\b7\u00104R\u001f\u0010=\u001a\u0004\u0018\u0001088B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<R\u0016\u0010>\u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b>\u00104R\u001c\u0010@\u001a\b\u0012\u0004\u0012\u00020\u00020?8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b@\u0010AR\u0016\u0010B\u001a\u00020\u00028\u0002@\u0002X\u0082D¢\u0006\u0006\n\u0004\bB\u00104R\u0016\u0010C\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\bC\u00104R\u0016\u0010D\u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\bD\u00104R\u0016\u0010E\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\bE\u00104R\u0016\u0010F\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bF\u0010GR\u0016\u0010H\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bH\u0010GR\u0016\u0010I\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bI\u0010JR(\u0010M\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040L0K8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bM\u0010NR\u0016\u0010O\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\bO\u00104¨\u0006R"}, d2 = {"Lcom/bytedance/lego/init/monitor/InitMonitor;", "", "", "key", "", "cosTime", "", "addDuration", "Lm3/g;", "taskInfo", "", "isMainThread", "getTaskTag", "Lm3/h;", "getPeriodTaskTag", ActivityLifecycle.NAME, "getMonitorTag", "getTaskStartTag", "getTaskEndTag", "getMonitorStartTag", "getMonitorEndTag", "monitorTaskTimeout", "delay", "sendStartUpTimeAsync", "sendStartUpTimeAsyncInternal", "onAttachBase", "monitorCosTime", "monitorTaskStart", "monitorTaskEnd", "monitorStart", "monitorEnd", CommonConsts.LOG_REPORT_TYPE_DEFAULT, "needUploadTask", "onFeedFirstShown", "Lcom/bytedance/lego/init/monitor/Category;", EventBody.KEY_CATEGORY, WsConstants.KEY_CONNECTION_TYPE, "Lorg/json/JSONObject;", "extraLog", "monitorEvent", "taskId", "onTaskTimeout", "", "t", NotificationCompat.CATEGORY_MESSAGE, "ensureNotReachHere", "Lcom/bytedance/lego/init/monitor/LogType;", "logType", "logExtr", "monitorLog", "sendStartUpTimeImmediately", "WAIT_ASYNC_TASK_INIT", "Ljava/lang/String;", "TASK_START_SUFFIX", "TASK_END_SUFFIX", "ALL_FEED_FIRST_SHOWN", "Lcom/bytedance/services/apm/api/ILaunchTrace;", "launchTraceService$delegate", "Lkotlin/Lazy;", "getLaunchTraceService", "()Lcom/bytedance/services/apm/api/ILaunchTrace;", "launchTraceService", "MONITOR_INIT_EXCEPTION", "", "timeoutTaskList", "Ljava/util/List;", "INIT_SCHEDULER", "MAIN", "MONITOR_INIT", "ASYNC", "alreadyUpload", "Z", "alreadyFeedShown", "onAttachBaseTime", "J", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Landroid/util/Pair;", "cosTimeList", "Ljava/util/concurrent/CopyOnWriteArrayList;", "TASKDISPATCHER_INIT", "<init>", "()V", "initscheduler_release"}, k = 1, mv = {1, 4, 0})
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

    static final class a implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final a f2108c = null;

        /* JADX INFO: renamed from: com.bytedance.lego.init.monitor.InitMonitor$a$a, reason: collision with other inner class name */
        static final class RunnableC0062a implements Runnable {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public static final RunnableC0062a f2109c = null;

            static {
                f2109c = new RunnableC0062a();
            }

            RunnableC0062a() {
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
                InitMonitor r10 = InitMonitor.INSTANCE;
                Category r11 = Category.OTHER_EXCEPTION;
                String r12 = e.getClass().getName();
                Intrinsics.checkExpressionValueIsNotNull(r12, "e.javaClass.name");
                JSONObject r13 = new JSONObject();
                JSONObject r14 = new JSONObject();
                r14.put("exception_detail", Log.getStackTraceString(e));
                r13.put("exception_detail", r14);
                r10.monitorEvent(r11, r12, r13);
            }
        }

        static {
            f2108c = new a();
        }

        a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            RunnableC0062a r10 = RunnableC0062a.f2109c;
            ThreadPoolExecutor r11 = InitScheduler.INSTANCE.getExecutorServiceOrNull$initscheduler_release();
            if (r11 != null) goto L5;
        L7:
            InitMonitor r12 = InitMonitor.INSTANCE;
            new Thread(r10).start();
            Unit r13 = Unit.INSTANCE;
            return;
        L5:
            if (r11.submit(r10) == null) goto L7;
        }
    }

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(InitMonitor.class), "launchTraceService", "getLaunchTraceService()Lcom/bytedance/services/apm/api/ILaunchTrace;"))};
        INSTANCE = new InitMonitor();
        cosTimeList = new CopyOnWriteArrayList();
        timeoutTaskList = new ArrayList();
        launchTraceService$delegate = LazyKt.lazy(InitMonitor$launchTraceService$2.INSTANCE);
        ALL_FEED_FIRST_SHOWN = "ALLFeedFirstShown";
        INIT_SCHEDULER = "init-scheduler";
    }

    private InitMonitor() {
    }

    public static final /* synthetic */ void access$sendStartUpTimeAsyncInternal(InitMonitor r10) {
        r10.sendStartUpTimeAsyncInternal();
    }

    private final synchronized void addDuration(String r10, long r11) {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (alreadyFeedShown == false) goto L7;
        monitor-exit(this);
        return;
    L7:
        cosTimeList.add(new Pair(r10, Long.valueOf(r11)));     // Catch: Throwable -> L10
        monitor-exit(this);
    }

    private final ILaunchTrace getLaunchTraceService() {
        Lazy r10 = launchTraceService$delegate;
        KProperty r11 = $$delegatedProperties[0];
        return (ILaunchTrace) r10.getValue();
    }

    private final String getMonitorEndTag(String r10, boolean r11) {
        if (r11 == false) goto L7;
        StringBuilder r12 = new StringBuilder();
        String r13 = MAIN;
    L5:
        r12.append(r13);
        r12.append(r10);
        r12.append(TASK_END_SUFFIX);
        return r12.toString();
    L7:
        r12 = new StringBuilder();
        r13 = ASYNC;
        goto L5
    }

    private final String getMonitorStartTag(String r10, boolean r11) {
        if (r11 == false) goto L7;
        StringBuilder r12 = new StringBuilder();
        String r13 = MAIN;
    L5:
        r12.append(r13);
        r12.append(r10);
        r12.append(TASK_START_SUFFIX);
        return r12.toString();
    L7:
        r12 = new StringBuilder();
        r13 = ASYNC;
        goto L5
    }

    private final String getMonitorTag(String r10, boolean r11) {
        if (r11 == false) goto L7;
        StringBuilder r12 = new StringBuilder();
        String r13 = MAIN;
    L5:
        r12.append(r13);
        r12.append(r10);
        return r12.toString();
    L7:
        r12 = new StringBuilder();
        r13 = ASYNC;
        goto L5
    }

    private final String getPeriodTaskTag(h r10, boolean r11) {
        if (r11 == false) goto L7;
        StringBuilder r12 = new StringBuilder();
        String r13 = MAIN;
    L5:
        r12.append(r13);
        r12.append(r10.c());
        return r12.toString();
    L7:
        r12 = new StringBuilder();
        r13 = ASYNC;
        goto L5
    }

    private final String getTaskEndTag(g r10, boolean r11) {
        if (r11 == false) goto L7;
        StringBuilder r12 = new StringBuilder();
        String r13 = MAIN;
    L5:
        r12.append(r13);
        r12.append(r10.f11028c);
        r12.append(TASK_END_SUFFIX);
        return r12.toString();
    L7:
        r12 = new StringBuilder();
        r13 = ASYNC;
        goto L5
    }

    private final String getTaskStartTag(g r10, boolean r11) {
        if (r11 == false) goto L7;
        StringBuilder r12 = new StringBuilder();
        String r13 = MAIN;
    L5:
        r12.append(r13);
        r12.append(r10.f11028c);
        r12.append(TASK_START_SUFFIX);
        return r12.toString();
    L7:
        r12 = new StringBuilder();
        r13 = ASYNC;
        goto L5
    }

    private final String getTaskTag(g r10, boolean r11) {
        if (r11 == false) goto L7;
        StringBuilder r12 = new StringBuilder();
        String r13 = "Main:Task-";
    L5:
        r12.append(r13);
        r12.append(r10.f11028c);
        return r12.toString();
    L7:
        r12 = new StringBuilder();
        r13 = "Async:Task-";
        goto L5
    }

    private final boolean monitorTaskTimeout() {
        List<String> r10 = timeoutTaskList;     // Catch: Exception -> L12
        if (r10.isEmpty() == false) goto L6;
        return false;
    L6:
        Iterator<T> r11 = r10.iterator();     // Catch: Exception -> L12
    L8:
        if (r11.hasNext() == false) goto L10;
        String r12 = (String) r11.next();     // Catch: Exception -> L12
        InitMonitor r13 = INSTANCE;     // Catch: Exception -> L12
        Category r14 = Category.TASK_TIMEOUT_EXCEPTION_REAL;     // Catch: Exception -> L12
        StringBuilder r15 = new StringBuilder();     // Catch: Exception -> L12
        InitScheduler r16 = InitScheduler.INSTANCE;     // Catch: Exception -> L12
        r15.append(r16.getConfig$initscheduler_release().getTimeout());     // Catch: Exception -> L12
        r15.append(':');     // Catch: Exception -> L12
        r15.append(r12);     // Catch: Exception -> L12
        r13.monitorEvent(r14, r15.toString(), new JSONObject());     // Catch: Exception -> L12
        c.b(c.f2121a, null, "TaskTimeout: " + r12 + ", " + r16.getConfig$initscheduler_release().getTimeout(), 1, null);     // Catch: Exception -> L12
        goto L8
    L10:
        sendStartUpTimeAsyncInternal();     // Catch: Exception -> L12
        return true;
    L12:
        e = move-exception;
        e.printStackTrace();
        c r17 = c.f2121a;
        String r18 = Log.getStackTraceString(e);
        Intrinsics.checkExpressionValueIsNotNull(r18, "Log.getStackTraceString(e)");
        c.d(r17, null, r18, 1, null);
        return false;
    }

    private final void sendStartUpTimeAsync(long r10) {
        new Handler(Looper.getMainLooper()).postDelayed(a.f2108c, r10);
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
        IApmAgent r10 = (IApmAgent) j.f2093b.a(IApmAgent.class);     // Catch: Throwable -> L23
        if (r10 == null) goto L21;
        alreadyFeedShown = true;     // Catch: Throwable -> L23
        JSONObject r11 = new JSONObject();     // Catch: Throwable -> L23
        Iterator<T> r12 = cosTimeList.iterator();     // Catch: Exception -> L16 Throwable -> L23
    L13:
        if (r12.hasNext() == false) goto L18;
        Pair r13 = (Pair) r12.next();     // Catch: Exception -> L16 Throwable -> L23
        String r14 = (String) r13.first;     // Catch: Exception -> L16 Throwable -> L23
        Object r15 = r13.second;     // Catch: Exception -> L16 Throwable -> L23
        Intrinsics.checkExpressionValueIsNotNull(r15, "it.second");     // Catch: Exception -> L16 Throwable -> L23
        r11.put(r14, ((Number) r15).longValue());     // Catch: Exception -> L16 Throwable -> L23
    L18:
        c r16 = c.f2121a;     // Catch: Throwable -> L23
        String r17 = r11.toString();     // Catch: Throwable -> L23
        Intrinsics.checkExpressionValueIsNotNull(r17, "metric.toString()");     // Catch: Throwable -> L23
        r16.a("sendStartUpTimeAsync", r17);     // Catch: Throwable -> L23
        InitTaskDispatcher.f2068u.g();     // Catch: Throwable -> L23
        r10.monitorEvent(MONITOR_INIT, new JSONObject(), r11, new JSONObject());     // Catch: Throwable -> L23
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

    public final void ensureNotReachHere(Throwable r10) {
        Intrinsics.checkParameterIsNotNull(r10, "t");
        IEnsure r11 = (IEnsure) j.f2093b.a(IEnsure.class);
        if (r11 == null) goto L6;
        r11.ensureNotReachHere(r10);
        return;
    }

    public final void ensureNotReachHere(Throwable r10, String r11) {
        Intrinsics.checkParameterIsNotNull(r10, "t");
        Intrinsics.checkParameterIsNotNull(r11, NotificationCompat.CATEGORY_MESSAGE);
        j r12 = j.f2093b;
        IEnsure r13 = (IEnsure) r12.a(IEnsure.class);
        if (r13 == null) goto L5;
        r13.ensureNotReachHere(r10, r11);
    L5:
        IApmAgent r14 = (IApmAgent) r12.a(IApmAgent.class);
        if (r14 == null) goto L9;
        JSONObject r15 = new JSONObject();
        r15.put(EnsureDeliverer.ENSURE_NOT_REACH_HERE, r11);
        JSONObject r16 = new JSONObject();
        JSONObject r17 = new JSONObject();
        r17.put("detail", Log.getStackTraceString(r10));
        r14.monitorEvent(MONITOR_INIT_EXCEPTION, r15, r16, r17);
        return;
    }

    public final void monitor(String r10) {
        Intrinsics.checkParameterIsNotNull(r10, ActivityLifecycle.NAME);
        addDuration(r10, System.currentTimeMillis() - onAttachBaseTime);
    }

    public final void monitorCosTime(String r10, long r11, boolean r12) {
        Intrinsics.checkParameterIsNotNull(r10, ActivityLifecycle.NAME);
        addDuration(getMonitorTag(r10, r12), r11);
    }

    public final void monitorCosTime(g r10, long r11, boolean r12) {
        Intrinsics.checkParameterIsNotNull(r10, "taskInfo");
        addDuration(getTaskTag(r10, r12), r11);
    }

    public final void monitorCosTime(h r10, long r11, boolean r12) {
        Intrinsics.checkParameterIsNotNull(r10, "taskInfo");
        addDuration(getPeriodTaskTag(r10, r12), r11);
    }

    public final void monitorEnd(String r10, boolean r11) {
        Intrinsics.checkParameterIsNotNull(r10, ActivityLifecycle.NAME);
        addDuration(getMonitorEndTag(r10, r11), System.currentTimeMillis() - onAttachBaseTime);
        ILaunchTrace r12 = getLaunchTraceService();
        if (r12 == null) goto L6;
        r12.endSpan(INIT_SCHEDULER, r10);
        return;
    }

    public final void monitorEvent(Category r10, String r11, JSONObject r12) {
        Intrinsics.checkParameterIsNotNull(r10, EventBody.KEY_CATEGORY);
        Intrinsics.checkParameterIsNotNull(r11, WsConstants.KEY_CONNECTION_TYPE);
        Intrinsics.checkParameterIsNotNull(r12, "extraLog");
        IApmAgent r13 = (IApmAgent) j.f2093b.a(IApmAgent.class);
        if (r13 == null) goto L13;
        JSONObject r14 = new JSONObject();
        r14.put(r10.getValue(), r11);     // Catch: Exception -> L7
    L9:
        r12.put("processName", InitScheduler.INSTANCE.getConfig$initscheduler_release().getProcessName());
        r12.put("isUIThread", Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper()));
        r13.monitorEvent(MONITOR_INIT, r14, new JSONObject(), r12);
        c.b(c.f2121a, null, r10.name() + ' ' + r11 + ' ' + r12.toString(), 1, null);
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
        goto L9
    }

    public final void monitorLog(LogType r10, JSONObject r11) {
        Intrinsics.checkParameterIsNotNull(r10, "logType");
        Intrinsics.checkParameterIsNotNull(r11, "logExtr");
        IApmAgent r12 = (IApmAgent) j.f2093b.a(IApmAgent.class);
        if (r12 == null) goto L6;
        r12.monitorLog(r10.name(), r11);
        c.b(c.f2121a, null, r10.name() + " " + r11.toString(), 1, null);
        return;
    }

    public final void monitorStart(String r10, boolean r11) {
        Intrinsics.checkParameterIsNotNull(r10, ActivityLifecycle.NAME);
        addDuration(getMonitorStartTag(r10, r11), System.currentTimeMillis() - onAttachBaseTime);
        ILaunchTrace r12 = getLaunchTraceService();
        if (r12 == null) goto L6;
        r12.startSpan(INIT_SCHEDULER, r10);
        return;
    }

    public final void monitorTaskEnd(g r10, boolean r11) {
        Intrinsics.checkParameterIsNotNull(r10, "taskInfo");
        addDuration(getTaskEndTag(r10, r11), System.currentTimeMillis() - onAttachBaseTime);
        ILaunchTrace r12 = getLaunchTraceService();
        if (r12 == null) goto L6;
        r12.endSpan(r10.f11029g, r10.f11028c);
        return;
    }

    public final void monitorTaskStart(g r10, boolean r11) {
        Intrinsics.checkParameterIsNotNull(r10, "taskInfo");
        addDuration(getTaskStartTag(r10, r11), System.currentTimeMillis() - onAttachBaseTime);
        ILaunchTrace r12 = getLaunchTraceService();
        if (r12 == null) goto L6;
        r12.startSpan(r10.f11029g, r10.f11028c);
        return;
    }

    public final void onAttachBase() {
        onAttachBaseTime = System.currentTimeMillis();
        b.f2115c.d();
        ILaunchTrace r10 = getLaunchTraceService();
        if (r10 == null) goto L6;
        r10.startTrace();
        return;
    }

    public final void onFeedFirstShown(boolean r10) {
        long r11 = System.currentTimeMillis() - onAttachBaseTime;     // Catch: Exception -> L22
        boolean r12 = false;
        if (r11 > 30000) goto L5;
        r12 = monitorTaskTimeout();     // Catch: Exception -> L22
    L5:
        if (r10 == true) goto L11;
        ILaunchTrace r13 = getLaunchTraceService();     // Catch: Exception -> L22
        if (r13 == null) goto L9;
        r13.cancelTrace();     // Catch: Exception -> L22
    L9:
        cosTimeList.clear();     // Catch: Exception -> L22
        return;
    L11:
        ILaunchTrace r14 = getLaunchTraceService();     // Catch: Exception -> L22
        if (r14 == null) goto L18;
        Activity r15 = InitScheduler.getMainActivity$initscheduler_release();     // Catch: Exception -> L22
        if (r15 == null) goto L16;
        String r16 = r15.getClass().getName();     // Catch: Exception -> L22
    L17:
        r14.endTrace(2, r16, 20000);     // Catch: Exception -> L22
        goto L18
    L16:
        r16 = null;
    L18:
        addDuration(ALL_FEED_FIRST_SHOWN, r11);     // Catch: Exception -> L22
        c.b(c.f2121a, null, "onFeedFirstShown: cos " + r11 + " ms.", 1, null);     // Catch: Exception -> L22
        if (r12 == true) goto L26;
        sendStartUpTimeAsync(5000);     // Catch: Exception -> L22
        return;
    L26:
        return;
    L22:
        e = move-exception;
        ensureNotReachHere(e, "ON_FEED_FIRST_SHOW_EXCEPTION");
        Category r17 = Category.OTHER_EXCEPTION;
        String r18 = e.getClass().getName();
        Intrinsics.checkExpressionValueIsNotNull(r18, "e.javaClass.name");
        JSONObject r19 = new JSONObject();
        JSONObject r20 = new JSONObject();
        r20.put("exception_detail", Log.getStackTraceString(e));
        r19.put("exception_detail", r20);
        monitorEvent(r17, r18, r19);
    }

    public final void onTaskTimeout(String r10) {
        Intrinsics.checkParameterIsNotNull(r10, "taskId");
        timeoutTaskList.add(r10);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
        c r11 = c.f2121a;
        String r12 = Log.getStackTraceString(e);
        Intrinsics.checkExpressionValueIsNotNull(r12, "Log.getStackTraceString(e)");
        c.d(r11, null, r12, 1, null);
    }

    public final synchronized void sendStartUpTimeImmediately() {
        monitor-enter(this);
        JSONObject r10 = new JSONObject();     // Catch: Throwable -> L11 Exception -> L13
        r10.put("curTime", System.currentTimeMillis() - onAttachBaseTime);     // Catch: Throwable -> L11 Exception -> L13
        Iterator<T> r11 = cosTimeList.iterator();     // Catch: Throwable -> L11 Exception -> L13
    L5:
        if (r11.hasNext() == false) goto L7;
        Pair r12 = (Pair) r11.next();     // Catch: Throwable -> L11 Exception -> L13
        String r13 = (String) r12.first;     // Catch: Throwable -> L11 Exception -> L13
        Object r14 = r12.second;     // Catch: Throwable -> L11 Exception -> L13
        Intrinsics.checkExpressionValueIsNotNull(r14, "it.second");     // Catch: Throwable -> L11 Exception -> L13
        r10.put(r13, ((Number) r14).longValue());     // Catch: Throwable -> L11 Exception -> L13
        goto L5
    L7:
        c r15 = c.f2121a;     // Catch: Throwable -> L11 Exception -> L13
        String r16 = r10.toString();     // Catch: Throwable -> L11 Exception -> L13
        Intrinsics.checkExpressionValueIsNotNull(r16, "metric.toString()");     // Catch: Throwable -> L11 Exception -> L13
        r15.a("sendStartUpTimeImmediately", r16);     // Catch: Throwable -> L11 Exception -> L13
        IApmAgent r17 = (IApmAgent) j.f2093b.a(IApmAgent.class);     // Catch: Throwable -> L11 Exception -> L13
        if (r17 == null) goto L15;
        r17.monitorEvent(MONITOR_INIT, new JSONObject(), r10, new JSONObject());     // Catch: Throwable -> L11 Exception -> L13
    L15:
        monitor-exit(this);
        return;
    L11:
        th = move-exception;
        throw th;
    L13:
        e = move-exception;
        c r18 = c.f2121a;     // Catch: Throwable -> L11
        String r19 = Log.getStackTraceString(e);     // Catch: Throwable -> L11
        Intrinsics.checkExpressionValueIsNotNull(r19, "Log.getStackTraceString(e)");     // Catch: Throwable -> L11
        c.b(r18, null, r19, 1, null);     // Catch: Throwable -> L11
        Category r20 = Category.OTHER_EXCEPTION;     // Catch: Throwable -> L11
        String r21 = "sendStartUpTimeImmediately" + e.getClass().getName();     // Catch: Throwable -> L11
        JSONObject r22 = new JSONObject();     // Catch: Throwable -> L11
        JSONObject r23 = new JSONObject();     // Catch: Throwable -> L11
        r23.put("exception_detail", Log.getStackTraceString(e));     // Catch: Throwable -> L11
        r22.put("exception_detail", r23);     // Catch: Throwable -> L11
        monitorEvent(r20, r21, r22);     // Catch: Throwable -> L11
        goto L15
    }
}
