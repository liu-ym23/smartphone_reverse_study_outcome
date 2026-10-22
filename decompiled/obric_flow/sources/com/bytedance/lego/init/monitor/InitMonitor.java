package com.bytedance.lego.init.monitor;

import ai.j0;
import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.util.Pair;
import androidx.room.jarjarred.org.stringtemplate.v4.STGroup;
import com.bytedance.lego.init.InitScheduler;
import com.bytedance.lego.init.l;
import com.bytedance.services.apm.api.IApmAgent;
import com.bytedance.services.apm.api.IEnsure;
import com.bytedance.services.apm.api.ILaunchTrace;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kf.e;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0003J%\u0010\f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ%\u0010\f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\u000fJ%\u0010\f\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\u0012J\u001d\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u0013\u0010\u0014J\u001d\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u0015\u0010\u0014J\u001d\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u0016\u0010\u0017J\u001d\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u0018\u0010\u0017J\u0015\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0019\u0010\u001aJ\u0015\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\n¢\u0006\u0004\b\u001c\u0010\u001dJ%\u0010#\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u00102\u0006\u0010\"\u001a\u00020!¢\u0006\u0004\b#\u0010$J\u0015\u0010&\u001a\u00020\u00042\u0006\u0010%\u001a\u00020\u0010¢\u0006\u0004\b&\u0010\u001aJ\u001d\u0010*\u001a\u00020\u00042\u0006\u0010(\u001a\u00020'2\u0006\u0010)\u001a\u00020\u0010¢\u0006\u0004\b*\u0010+J\u001d\u0010/\u001a\u00020\u00042\u0006\u0010-\u001a\u00020,2\u0006\u0010.\u001a\u00020!¢\u0006\u0004\b/\u00100J\u0015\u0010*\u001a\u00020\u00042\u0006\u0010(\u001a\u00020'¢\u0006\u0004\b*\u00101J\r\u00102\u001a\u00020\u0004¢\u0006\u0004\b2\u0010\u0003J\u001f\u00104\u001a\u00020\u00042\u0006\u00103\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b4\u00105J\u001f\u00106\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b6\u00107J\u001f\u00108\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b8\u00109J\u001f\u0010:\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b:\u0010;J\u001f\u0010<\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b<\u00107J\u001f\u0010=\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b=\u00107J\u001f\u0010>\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b>\u0010;J\u001f\u0010?\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b?\u0010;J\u000f\u0010@\u001a\u00020\nH\u0002¢\u0006\u0004\b@\u0010AJ\u0017\u0010C\u001a\u00020\u00042\u0006\u0010B\u001a\u00020\bH\u0002¢\u0006\u0004\bC\u0010DJ\u000f\u0010E\u001a\u00020\u0004H\u0002¢\u0006\u0004\bE\u0010\u0003R\u0014\u0010F\u001a\u00020\u00108\u0002X\u0082T¢\u0006\u0006\n\u0004\bF\u0010GR\u0014\u0010H\u001a\u00020\u00108\u0002X\u0082T¢\u0006\u0006\n\u0004\bH\u0010GR\u0016\u0010I\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bI\u0010JR&\u0010M\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\b0L0K8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bM\u0010NR\u001a\u0010P\u001a\b\u0012\u0004\u0012\u00020\u00100O8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bP\u0010QR\u001d\u0010W\u001a\u0004\u0018\u00010R8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bS\u0010T\u001a\u0004\bU\u0010VR\u0016\u0010X\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bX\u0010YR\u0016\u0010Z\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bZ\u0010YR\u0014\u0010[\u001a\u00020\u00108\u0002X\u0082D¢\u0006\u0006\n\u0004\b[\u0010GR\u0014\u0010\\\u001a\u00020\u00108\u0002X\u0082D¢\u0006\u0006\n\u0004\b\\\u0010GR\u0014\u0010]\u001a\u00020\u00108\u0006X\u0086T¢\u0006\u0006\n\u0004\b]\u0010GR\u0014\u0010^\u001a\u00020\u00108\u0006X\u0086T¢\u0006\u0006\n\u0004\b^\u0010GR\u0014\u0010_\u001a\u00020\u00108\u0006X\u0086T¢\u0006\u0006\n\u0004\b_\u0010GR\u0014\u0010`\u001a\u00020\u00108\u0006X\u0086T¢\u0006\u0006\n\u0004\b`\u0010GR\u0014\u0010a\u001a\u00020\u00108\u0006X\u0086T¢\u0006\u0006\n\u0004\ba\u0010GR\u0014\u0010b\u001a\u00020\u00108\u0006X\u0086T¢\u0006\u0006\n\u0004\bb\u0010G¨\u0006c"}, d2 = {"Lcom/bytedance/lego/init/monitor/InitMonitor;", "", "<init>", "()V", "", "onAttachBase", "Lkf/d;", "taskInfo", "", "cosTime", "", "isMainThread", "monitorCosTime", "(Lkf/d;JZ)V", "Lkf/e;", "(Lkf/e;JZ)V", "", "name", "(Ljava/lang/String;JZ)V", "monitorTaskStart", "(Lkf/d;Z)V", "monitorTaskEnd", "monitorStart", "(Ljava/lang/String;Z)V", "monitorEnd", "monitor", "(Ljava/lang/String;)V", "needUploadTask", "onFeedFirstShown", "(Z)V", "Lcom/bytedance/lego/init/monitor/Category;", "category", "type", "Lorg/json/JSONObject;", "extraLog", "monitorEvent", "(Lcom/bytedance/lego/init/monitor/Category;Ljava/lang/String;Lorg/json/JSONObject;)V", "taskId", "onTaskTimeout", "", "t", "msg", "ensureNotReachHere", "(Ljava/lang/Throwable;Ljava/lang/String;)V", "Lcom/bytedance/lego/init/monitor/LogType;", "logType", "logExtr", "monitorLog", "(Lcom/bytedance/lego/init/monitor/LogType;Lorg/json/JSONObject;)V", "(Ljava/lang/Throwable;)V", "sendStartUpTimeImmediately", STGroup.DICT_KEY, "addDuration", "(Ljava/lang/String;J)V", "getTaskTag", "(Lkf/d;Z)Ljava/lang/String;", "getPeriodTaskTag", "(Lkf/e;Z)Ljava/lang/String;", "getMonitorTag", "(Ljava/lang/String;Z)Ljava/lang/String;", "getTaskStartTag", "getTaskEndTag", "getMonitorStartTag", "getMonitorEndTag", "monitorTaskTimeout", "()Z", "delay", "sendStartUpTimeAsync", "(J)V", "sendStartUpTimeAsyncInternal", "MONITOR_INIT", "Ljava/lang/String;", "MONITOR_INIT_EXCEPTION", "onAttachBaseTime", "J", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Landroid/util/Pair;", "cosTimeList", "Ljava/util/concurrent/CopyOnWriteArrayList;", "", "timeoutTaskList", "Ljava/util/List;", "Lcom/bytedance/services/apm/api/ILaunchTrace;", "launchTraceService$delegate", "Lkotlin/Lazy;", "getLaunchTraceService", "()Lcom/bytedance/services/apm/api/ILaunchTrace;", "launchTraceService", "alreadyFeedShown", "Z", "alreadyUpload", "ALL_FEED_FIRST_SHOWN", "INIT_SCHEDULER", "TASKDISPATCHER_INIT", "WAIT_ASYNC_TASK_INIT", "TASK_START_SUFFIX", "TASK_END_SUFFIX", "MAIN", "ASYNC", "initscheduler_release"}, k = 1, mv = {1, 4, 0})
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

    public static final /* synthetic */ void access$sendStartUpTimeAsyncInternal(InitMonitor r5) {
        r5.sendStartUpTimeAsyncInternal();
    }

    private final synchronized void addDuration(String r5, long r10) {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (alreadyFeedShown == false) goto L7;
        monitor-exit(this);
        return;
    L7:
        cosTimeList.add(new Pair(r5, Long.valueOf(r10)));     // Catch: Throwable -> L10
        monitor-exit(this);
    }

    private final ILaunchTrace getLaunchTraceService() {
        Lazy r5 = launchTraceService$delegate;
        KProperty r10 = $$delegatedProperties[0];
        return (ILaunchTrace) r5.getValue();
    }

    private final String getMonitorEndTag(String r5, boolean r10) {
        if (r10 == false) goto L7;
        return j0.k(MAIN, r5, TASK_END_SUFFIX);
    L7:
        return j0.k(ASYNC, r5, TASK_END_SUFFIX);
    }

    private final String getMonitorStartTag(String r5, boolean r10) {
        if (r10 == false) goto L7;
        return j0.k(MAIN, r5, TASK_START_SUFFIX);
    L7:
        return j0.k(ASYNC, r5, TASK_START_SUFFIX);
    }

    private final String getMonitorTag(String r5, boolean r10) {
        if (r10 == false) goto L6;
        return j0.C(MAIN, r5);
    L6:
        return j0.C(ASYNC, r5);
    }

    private final String getPeriodTaskTag(e r5, boolean r10) {
        if (r10 == false) goto L5;
        throw null;
    L5:
        throw null;
    }

    private final String getTaskEndTag(kf.d r5, boolean r10) {
        if (r10 == false) goto L5;
        throw null;
    L5:
        throw null;
    }

    private final String getTaskStartTag(kf.d r5, boolean r10) {
        if (r10 == false) goto L5;
        throw null;
    L5:
        throw null;
    }

    private final String getTaskTag(kf.d r5, boolean r10) {
        if (r10 == false) goto L5;
        throw null;
    L5:
        throw null;
    }

    private final boolean monitorTaskTimeout() {
        List<String> r5 = timeoutTaskList;     // Catch: Exception -> L10
        if (r5.isEmpty() == false) goto L6;
        return false;
    L6:
        Iterator<T> r10 = r5.iterator();     // Catch: Exception -> L10
    L8:
        if (r10.hasNext() == false) goto L12;
        String r11 = (String) r10.next();     // Catch: Exception -> L10
        InitMonitor r12 = INSTANCE;     // Catch: Exception -> L10
        Category r13 = Category.TASK_TIMEOUT_EXCEPTION_REAL;     // Catch: Exception -> L10
        StringBuilder r14 = new StringBuilder();     // Catch: Exception -> L10
        InitScheduler r15 = InitScheduler.INSTANCE;     // Catch: Exception -> L10
        r14.append(r15.getConfig$initscheduler_release().getTimeout());     // Catch: Exception -> L10
        r14.append(':');     // Catch: Exception -> L10
        r14.append(r11);     // Catch: Exception -> L10
        r12.monitorEvent(r13, r14.toString(), new JSONObject());     // Catch: Exception -> L10
        com.bytedance.lego.init.util.b.b("TaskTimeout: " + r11 + ", " + r15.getConfig$initscheduler_release().getTimeout());     // Catch: Exception -> L10
        goto L8
    L12:
        sendStartUpTimeAsyncInternal();     // Catch: Exception -> L10
        return true;
    L10:
        e = move-exception;
        e.printStackTrace();
        Log.e("#inittask#", " " + Log.getStackTraceString(e));
        return false;
    }

    private final void sendStartUpTimeAsync(long r5) {
        new Handler(Looper.getMainLooper()).postDelayed(d.f6765c, r5);
    }

    private final synchronized void sendStartUpTimeAsyncInternal() {
        monitor-enter(this);
    L16:
        th = move-exception;
        throw th;
    L4:
        if (alreadyUpload == false) goto L8;
        monitor-exit(this);
        return;
    L8:
        alreadyUpload = true;     // Catch: Throwable -> L16
        IApmAgent r5 = (IApmAgent) og.a.a(IApmAgent.class);     // Catch: Throwable -> L16
        if (r5 == null) goto L23;
        alreadyFeedShown = true;     // Catch: Throwable -> L16
        JSONObject r10 = new JSONObject();     // Catch: Throwable -> L16
        Iterator<T> r11 = cosTimeList.iterator();     // Catch: Throwable -> L16 Exception -> L18
    L13:
        if (r11.hasNext() == false) goto L20;
        Pair r12 = (Pair) r11.next();     // Catch: Throwable -> L16 Exception -> L18
        r10.put((String) r12.first, ((Number) r12.second).longValue());     // Catch: Throwable -> L16 Exception -> L18
    L20:
        com.bytedance.lego.init.util.b.a("sendStartUpTimeAsync", r10.toString());     // Catch: Throwable -> L16
        l.f6750m.getClass();     // Catch: Throwable -> L16
        l.f6743b.beforeSendMonitor();     // Catch: Throwable -> L16
        r5.monitorEvent(MONITOR_INIT, new JSONObject(), r10, new JSONObject());     // Catch: Throwable -> L16
        cosTimeList.clear();     // Catch: Throwable -> L16
        monitor-exit(this);
        return;
    L18:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L16
        goto L20
    L23:
        monitor-exit(this);
    }

    public final void ensureNotReachHere(Throwable r5) {
        IEnsure r10 = (IEnsure) og.a.a(IEnsure.class);
        if (r10 == null) goto L6;
        r10.ensureNotReachHere(r5);
        return;
    }

    public final void monitor(String r5) {
        addDuration(r5, System.currentTimeMillis() - onAttachBaseTime);
    }

    public final void monitorCosTime(kf.d r5, long r10, boolean r11) {
        addDuration(getTaskTag(r5, r11), r10);
    }

    public final void monitorEnd(String r5, boolean r10) {
        addDuration(getMonitorEndTag(r5, r10), System.currentTimeMillis() - onAttachBaseTime);
        ILaunchTrace r11 = getLaunchTraceService();
        if (r11 == null) goto L6;
        r11.endSpan(INIT_SCHEDULER, r5);
        return;
    }

    public final void monitorEvent(Category r5, String r10, JSONObject r11) {
        IApmAgent r12 = (IApmAgent) og.a.a(IApmAgent.class);
        if (r12 == null) goto L13;
        JSONObject r13 = new JSONObject();
        r13.put(r5.getValue(), r10);     // Catch: Exception -> L7
    L9:
        r11.put("processName", InitScheduler.INSTANCE.getConfig$initscheduler_release().getProcessName());
        r11.put("isUIThread", Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper()));
        r12.monitorEvent(MONITOR_INIT, r13, new JSONObject(), r11);
        com.bytedance.lego.init.util.b.b(r5.name() + ' ' + r10 + ' ' + r11.toString());
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
        goto L9
    }

    public final void monitorLog(LogType r5, JSONObject r10) {
        IApmAgent r11 = (IApmAgent) og.a.a(IApmAgent.class);
        if (r11 == null) goto L6;
        r11.monitorLog(r5.name(), r10);
        com.bytedance.lego.init.util.b.b(r5.name() + " " + r10.toString());
        return;
    }

    public final void monitorStart(String r5, boolean r10) {
        addDuration(getMonitorStartTag(r5, r10), System.currentTimeMillis() - onAttachBaseTime);
        ILaunchTrace r11 = getLaunchTraceService();
        if (r11 == null) goto L6;
        r11.startSpan(INIT_SCHEDULER, r5);
        return;
    }

    public final void monitorTaskEnd(kf.d r5, boolean r10) {
        addDuration(getTaskEndTag(r5, r10), System.currentTimeMillis() - onAttachBaseTime);
        if (getLaunchTraceService() != null) goto L6;
        return;
    L6:
        throw null;
    }

    public final void monitorTaskStart(kf.d r5, boolean r10) {
        addDuration(getTaskStartTag(r5, r10), System.currentTimeMillis() - onAttachBaseTime);
        if (getLaunchTraceService() != null) goto L6;
        return;
    L6:
        throw null;
    }

    public final void onAttachBase() {
        onAttachBaseTime = System.currentTimeMillis();
        CopyOnWriteArrayList r5 = b.f6760b;
        b.f6759a = System.currentTimeMillis();
        ILaunchTrace r10 = getLaunchTraceService();
        if (r10 == null) goto L6;
        r10.startTrace();
        return;
    }

    public final void onFeedFirstShown(boolean r10) {
        long r5 = System.currentTimeMillis() - onAttachBaseTime;     // Catch: Exception -> L6
        if (r5 > 30000) goto L8;
        boolean r11 = monitorTaskTimeout();     // Catch: Exception -> L6
    L9:
        if (r10 == true) goto L15;
        ILaunchTrace r12 = getLaunchTraceService();     // Catch: Exception -> L6
        if (r12 == null) goto L13;
        r12.cancelTrace();     // Catch: Exception -> L6
    L13:
        cosTimeList.clear();     // Catch: Exception -> L6
        return;
    L15:
        ILaunchTrace r13 = getLaunchTraceService();     // Catch: Exception -> L6
        if (r13 == null) goto L22;
        Activity r14 = InitScheduler.getMainActivity$initscheduler_release();     // Catch: Exception -> L6
        if (r14 == null) goto L20;
        String r15 = r14.getClass().getName();     // Catch: Exception -> L6
    L21:
        r13.endTrace(2, r15, 20000);     // Catch: Exception -> L6
        goto L22
    L20:
        r15 = null;
    L22:
        addDuration(ALL_FEED_FIRST_SHOWN, r5);     // Catch: Exception -> L6
        com.bytedance.lego.init.util.b.b("onFeedFirstShown: cos " + r5 + " ms.");     // Catch: Exception -> L6
        if (r11 == true) goto L29;
        sendStartUpTimeAsync(5000);     // Catch: Exception -> L6
        return;
    L29:
        return;
    L8:
        r11 = false;
    L6:
        e = move-exception;
        ensureNotReachHere(e, "ON_FEED_FIRST_SHOW_EXCEPTION");
        Category r16 = Category.OTHER_EXCEPTION;
        String r17 = e.getClass().getName();
        JSONObject r18 = new JSONObject();
        JSONObject r19 = new JSONObject();
        r19.put("exception_detail", Log.getStackTraceString(e));
        r18.put("exception_detail", r19);
        monitorEvent(r16, r17, r18);
    }

    public final void onTaskTimeout(String r5) {
        timeoutTaskList.add(r5);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
        String r10 = Log.getStackTraceString(e);
        if ((true & true) == false) goto L8;
        String r11 = "";
    L9:
        Log.e("#inittask#", r11 + ' ' + r10);
        return;
    L8:
        r11 = null;
        goto L9
    }

    public final synchronized void sendStartUpTimeImmediately() {
        monitor-enter(this);
        JSONObject r5 = new JSONObject();     // Catch: Throwable -> L7 Exception -> L9
        r5.put("curTime", System.currentTimeMillis() - onAttachBaseTime);     // Catch: Throwable -> L7 Exception -> L9
        Iterator<T> r10 = cosTimeList.iterator();     // Catch: Throwable -> L7 Exception -> L9
    L5:
        if (r10.hasNext() == false) goto L11;
        Pair r11 = (Pair) r10.next();     // Catch: Throwable -> L7 Exception -> L9
        r5.put((String) r11.first, ((Number) r11.second).longValue());     // Catch: Throwable -> L7 Exception -> L9
        goto L5
    L11:
        com.bytedance.lego.init.util.b.a("sendStartUpTimeImmediately", r5.toString());     // Catch: Throwable -> L7 Exception -> L9
        IApmAgent r12 = (IApmAgent) og.a.a(IApmAgent.class);     // Catch: Throwable -> L7 Exception -> L9
        if (r12 == null) goto L16;
        r12.monitorEvent(MONITOR_INIT, new JSONObject(), r5, new JSONObject());     // Catch: Throwable -> L7 Exception -> L9
    L16:
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    L9:
        e = move-exception;
        com.bytedance.lego.init.util.b.b(Log.getStackTraceString(e));     // Catch: Throwable -> L7
        Category r13 = Category.OTHER_EXCEPTION;     // Catch: Throwable -> L7
        String r14 = "sendStartUpTimeImmediately" + e.getClass().getName();     // Catch: Throwable -> L7
        JSONObject r15 = new JSONObject();     // Catch: Throwable -> L7
        JSONObject r16 = new JSONObject();     // Catch: Throwable -> L7
        r16.put("exception_detail", Log.getStackTraceString(e));     // Catch: Throwable -> L7
        r15.put("exception_detail", r16);     // Catch: Throwable -> L7
        monitorEvent(r13, r14, r15);     // Catch: Throwable -> L7
        goto L16
    }

    public final void monitorCosTime(e r5, long r10, boolean r11) {
        addDuration(getPeriodTaskTag(r5, r11), r10);
    }

    public final void monitorCosTime(String r5, long r10, boolean r11) {
        addDuration(getMonitorTag(r5, r11), r10);
    }

    public final void ensureNotReachHere(Throwable r5, String r10) {
        IEnsure r11 = (IEnsure) og.a.a(IEnsure.class);
        if (r11 == null) goto L5;
        r11.ensureNotReachHere(r5, r10);
    L5:
        IApmAgent r12 = (IApmAgent) og.a.a(IApmAgent.class);
        if (r12 == null) goto L9;
        JSONObject r13 = new JSONObject();
        r13.put("EnsureNotReachHere", r10);
        JSONObject r14 = new JSONObject();
        JSONObject r15 = new JSONObject();
        r15.put("detail", Log.getStackTraceString(r5));
        r12.monitorEvent(MONITOR_INIT_EXCEPTION, r13, r14, r15);
        return;
    }
}
