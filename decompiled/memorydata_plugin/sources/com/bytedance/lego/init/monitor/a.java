package com.bytedance.lego.init.monitor;

import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.crash.entity.EventBody;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.bytedance.lego.init.l;
import com.bytedance.lego.init.model.DelayTaskInfo;
import com.bytedance.lego.init.util.d;
import com.bytedance.services.apm.api.IApmAgent;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u000bH\u0002J\u0018\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0018\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0018\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0018\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u001e\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u0018J\u001e\u0010 \u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u0018J\u001e\u0010!\u001a\u00020\u00122\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u00042\u0006\u0010%\u001a\u00020&J\u0016\u0010'\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0017\u001a\u00020\u0018J\u0016\u0010(\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0017\u001a\u00020\u0018J\u0006\u0010)\u001a\u00020\u0012R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R \u0010\b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000b0\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006*"}, d2 = {"Lcom/bytedance/lego/init/monitor/DelayTaskMonitor;", "", "()V", "MONITOR_DELAY", "", "TAG", "TASK_END", "TASK_START", "cosTimeList", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lkotlin/Pair;", "", "onCreateEnd", "getOnCreateEnd", "()J", "setOnCreateEnd", "(J)V", "addDuration", "", "key", "cosTime", "getMonitorTag", ActivityLifecycle.NAME, "isMainThread", "", "getTaskEndTag", "taskInfo", "Lcom/bytedance/lego/init/model/DelayTaskInfo;", "getTaskStartTag", "getTaskTag", CommonConsts.LOG_REPORT_TYPE_DEFAULT, EventBody.KEY_VALUE, "monitorCosTime", "monitorEvent", EventBody.KEY_CATEGORY, "Lcom/bytedance/lego/init/monitor/Category;", "type", "extraLog", "Lorg/json/JSONObject;", "monitorTaskEnd", "monitorTaskStart", "sendDelayTaskMonitor", "initscheduler_release"}, k = 1, mv = {1, 1, 13})
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f2789a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final CopyOnWriteArrayList<Pair<String, Long>> f2790b = null;
    private static long c;

    static {
        f2789a = new a();
        f2790b = new CopyOnWriteArrayList();
        c = -1;
    }

    private a() {
    }

    private final String a(String r1, boolean r2) {
        if (r2 == false) goto L7;
        StringBuilder r0 = new StringBuilder();
        String r3 = InitMonitor.MAIN;
    L6:
        return r0.append(r3).append(r1).toString();
    L7:
        r0 = new StringBuilder();
        r3 = InitMonitor.ASYNC;
        goto L6
    }

    private final void a(String r2, long r3) {
        f2790b.add(new Pair(r2, Long.valueOf(r3)));
    }

    private final String c(DelayTaskInfo r1, boolean r2) {
        if (r2 == false) goto L7;
        StringBuilder r0 = new StringBuilder();
        String r3 = "Main:Task-";
    L6:
        return r0.append(r3).append(r1.taskId).toString();
    L7:
        r0 = new StringBuilder();
        r3 = "Async:Task-";
        goto L6
    }

    private final String d(DelayTaskInfo r2, boolean r3) {
        if (r3 == false) goto L7;
        StringBuilder r4 = new StringBuilder();
        String r0 = InitMonitor.MAIN;
    L6:
        return r4.append(r0).append(r2.taskId).append("_TASKSTART").toString();
    L7:
        r4 = new StringBuilder();
        r0 = InitMonitor.ASYNC;
        goto L6
    }

    private final String e(DelayTaskInfo r2, boolean r3) {
        if (r3 == false) goto L7;
        StringBuilder r4 = new StringBuilder();
        String r0 = InitMonitor.MAIN;
    L6:
        return r4.append(r0).append(r2.taskId).append("_TASKEND").toString();
    L7:
        r4 = new StringBuilder();
        r0 = InitMonitor.ASYNC;
        goto L6
    }

    public final void a() {
        IApmAgent r0 = (IApmAgent) ZeusTransformUtils.preCheckCast(l.f2777a.a(IApmAgent.class), IApmAgent.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L14;
        JSONObject r8 = new JSONObject();
        Iterator r3 = ((Iterable) ZeusTransformUtils.preCheckCast(f2790b, Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Exception -> L10
    L7:
        if (r3.hasNext() == false) goto L12;
        Pair r4 = (Pair) ZeusTransformUtils.preCheckCast(r3.next(), Pair.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L10
        r8.put((String) ZeusTransformUtils.preCheckCast(r4.getFirst(), String.class, "com.obric.memorydata.plugin"), ((Number) ZeusTransformUtils.preCheckCast(r4.getSecond(), Number.class, "com.obric.memorydata.plugin")).longValue());     // Catch: Exception -> L10
    L12:
        d.f2800a.b("DelayTaskMonitor", "sendDelayTaskMonitor " + r8);
        r0.monitorEvent("delay_task_monitor", new JSONObject(), r8, new JSONObject());
        f2790b.clear();
        return;
    L10:
        e = move-exception;
        e.printStackTrace();
        goto L12
    L14:
        a r9 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.memorydata.plugin");
        d.f2800a.c("DelayTaskMonitor", "ServiceManager.getService(IApmAgent::class.java) is null.");
    }

    public final void a(long r1) {
        c = r1;
    }

    public final void a(DelayTaskInfo r2, long r3, boolean r5) {
        Intrinsics.checkParameterIsNotNull(r2, "taskInfo");
        a(c(r2, r5), r3);
    }

    public final void a(DelayTaskInfo r5, boolean r6) {
        Intrinsics.checkParameterIsNotNull(r5, "taskInfo");
        if (c >= 0) goto L5;
        return;
    L5:
        a(d(r5, r6), System.currentTimeMillis() - c);
    }

    public final void a(String r2, long r3, boolean r5) {
        Intrinsics.checkParameterIsNotNull(r2, ActivityLifecycle.NAME);
        a(a(r2, r5), r3);
    }

    public final void b(DelayTaskInfo r5, boolean r6) {
        Intrinsics.checkParameterIsNotNull(r5, "taskInfo");
        if (c >= 0) goto L5;
        return;
    L5:
        a(e(r5, r6), System.currentTimeMillis() - c);
    }
}
