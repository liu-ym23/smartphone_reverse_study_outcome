package com.bytedance.lego.init;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.lego.init.model.InitPeriod;
import com.bytedance.lego.init.monitor.Category;
import com.bytedance.lego.init.monitor.InitMonitor;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0011\u001a\u00020\u0012J\u0010\u0010\u0013\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0014\u001a\u00020\u0004J\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0014\u001a\u00020\u0004J\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00040\u00182\u0006\u0010\u0014\u001a\u00020\u0004J\b\u0010\u0019\u001a\u00020\u001aH\u0002J\u0006\u0010\u001b\u001a\u00020\u0012J\b\u0010\u001c\u001a\u00020\u0012H\u0002J\u0010\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\tH\u0002J\u000e\u0010\u001f\u001a\u00020\u00122\u0006\u0010 \u001a\u00020\tJ\u0019\u0010!\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010#¢\u0006\u0002\u0010$J\u0010\u0010%\u001a\u0004\u0018\u00010\t2\u0006\u0010&\u001a\u00020'J\u0014\u0010(\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\"\u001a\u00020#H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t0\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\t0\u000fj\b\u0012\u0004\u0012\u00020\t`\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/bytedance/lego/init/InitTaskManager;", "", "()V", "TAG", "", "completedTaskCount", "Ljava/util/concurrent/atomic/AtomicInteger;", "nonUiReadyQueue", "Ljava/util/concurrent/PriorityBlockingQueue;", "Lcom/bytedance/lego/init/model/InitTaskInfo;", "readWriteLock", "taskIndex", "", "uiReadyQueue", "unDispatchTask", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "beforeSendMonitor", "", "getInitTaskInfoById", "taskId", "getPriorityByTaskId", "", "getTaskDependencyById", "", "hasNonUiTask", "", CommonConsts.APM_INNER_EVENT_COST_INIT, "initReadyQueue", "letTaskReady", "taskInfo", "onTaskComplete", "task", "takeNonUiTaskIfExist", LocationMonitorConst.TIMEOUT, "", "(Ljava/lang/Long;)Lcom/bytedance/lego/init/model/InitTaskInfo;", "takeNonUiTaskMainThreadIfExist", TypedValues.CycleType.S_WAVE_PERIOD, "Lcom/bytedance/lego/init/model/InitPeriod;", "takeUiTaskIfExist", "initscheduler_release"}, k = 1, mv = {1, 1, 13})
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Map<String, com.bytedance.lego.init.model.b> f2773a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ArrayList<com.bytedance.lego.init.model.b> f2774b;
    private final PriorityBlockingQueue<com.bytedance.lego.init.model.b> c;
    private final PriorityBlockingQueue<com.bytedance.lego.init.model.b> d;
    private final Object e;
    private AtomicInteger f;
    private final String g;

    public i() {
        this.f2773a = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        this.f2774b = new ArrayList();
        this.c = new PriorityBlockingQueue();
        this.d = new PriorityBlockingQueue();
        this.e = new Object();
        this.f = new AtomicInteger(0);
        this.g = "InitTaskManager";
    }

    public static /* synthetic */ com.bytedance.lego.init.model.b a(i r0, Long r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = (Long) ZeusTransformUtils.preCheckCast(null, Long.class, "com.obric.memorydata.plugin");
    L6:
        return r0.a(r1);
    }

    private final void b(com.bytedance.lego.init.model.b r5) {
        com.bytedance.lego.init.util.d.f2800a.b(this.g, "letTaskReady: " + r5.f2783a);
        if (r5.e == false) goto L5;
        PriorityBlockingQueue<com.bytedance.lego.init.model.b> r0 = this.c;
    L6:
        r0.add(r5);
        this.f2774b.remove(r5);
        return;
    L5:
        r0 = this.d;
        goto L6
    }

    private final boolean c() {
        Object r0 = this.e;
        monitor-enter(r0);
    L19:
        th = move-exception;
        throw th;
    L6:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(this.d, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L9;
        monitor-exit(r0);
        return true;
    L9:
        Iterator r5 = ((Iterable) ZeusTransformUtils.preCheckCast(this.f2774b, Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Throwable -> L19
    L11:
        if (r5.hasNext() == false) goto L17;
        if (((com.bytedance.lego.init.model.b) ZeusTransformUtils.preCheckCast(r5.next(), com.bytedance.lego.init.model.b.class, "com.obric.memorydata.plugin")).e == true) goto L11;
        monitor-exit(r0);
        return true;
    L17:
        monitor-exit(r0);
        return false;
    }

    private final void d() {
        Collection<com.bytedance.lego.init.model.b> r0 = this.f2773a.values();
        if (r0 == null) goto L12;
        Iterator r1 = ((Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L6:
        if (r1.hasNext() == false) goto L19;
        com.bytedance.lego.init.model.b r2 = (com.bytedance.lego.init.model.b) ZeusTransformUtils.preCheckCast(r1.next(), com.bytedance.lego.init.model.b.class, "com.obric.memorydata.plugin");
        if (r2.j == null) goto L11;
        if (r2.j.isEmpty() == false) goto L6;
    L11:
        b(r2);
        goto L6
    L19:
        return;
    }

    public final com.bytedance.lego.init.model.b a(long r2) {
        return (com.bytedance.lego.init.model.b) ZeusTransformUtils.preCheckCast(this.c.poll(r2, TimeUnit.MILLISECONDS), com.bytedance.lego.init.model.b.class, "com.obric.memorydata.plugin");
    L4:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public final com.bytedance.lego.init.model.b a(InitPeriod r5) {
        Intrinsics.checkParameterIsNotNull(r5, TypedValues.CycleType.S_WAVE_PERIOD);
        if (c() == true) goto L5;
        return null;
    L5:
        Iterator<com.bytedance.lego.init.model.b> r4 = this.d.iterator();
        Intrinsics.checkExpressionValueIsNotNull(r4, "nonUiReadyQueue.iterator()");
    L7:
        if (r4.hasNext() == false) goto L12;
        com.bytedance.lego.init.model.b r0 = (com.bytedance.lego.init.model.b) ZeusTransformUtils.preCheckCast(r4.next(), com.bytedance.lego.init.model.b.class, "com.obric.memorydata.plugin");
        InitPeriod r2 = r0.k;
        Intrinsics.checkExpressionValueIsNotNull(r2, "next.endPeriod");
        if (r2.getValue() > r5.getValue()) goto L7;
        r4.remove();
        return r0;
    L12:
        return null;
    }

    public final com.bytedance.lego.init.model.b a(Long r4) {
        if (c() == true) goto L6;
        return null;
    L6:
        PriorityBlockingQueue<com.bytedance.lego.init.model.b> r3 = this.d;
        if (r4 == null) goto L11;
        com.bytedance.lego.init.model.b r5 = r3.poll(r4.longValue(), TimeUnit.MILLISECONDS);
    L10:
        return (com.bytedance.lego.init.model.b) ZeusTransformUtils.preCheckCast(r5, com.bytedance.lego.init.model.b.class, "com.obric.memorydata.plugin");
    L11:
        r5 = r3.take();
        goto L10
    }

    public final com.bytedance.lego.init.model.b a(String r2) {
        Intrinsics.checkParameterIsNotNull(r2, "taskId");
        return (com.bytedance.lego.init.model.b) ZeusTransformUtils.preCheckCast(this.f2773a.get(r2), com.bytedance.lego.init.model.b.class, "com.obric.memorydata.plugin");
    }

    public final void a() {
        long r0 = System.currentTimeMillis();
        Map<String, com.bytedance.lego.init.model.b> r2 = m.f();
        Intrinsics.checkExpressionValueIsNotNull(r2, "TaskCollectorManager.getInitTaskIndexs()");
        this.f2773a = r2;
        com.bytedance.lego.init.util.d.b(com.bytedance.lego.init.util.d.f2800a, null, "collect cos: " + (System.currentTimeMillis() - r0) + "ms  size: " + this.f2773a.size(), 1, null);
        InitMonitor.INSTANCE.monitorCosTime("InitTaskManager.CollectTasks", System.currentTimeMillis() - r0, false);
        this.f2774b.addAll(this.f2773a.values());
        d();
        h.f2770b.a(this.f2773a.isEmpty());
        InitMonitor.INSTANCE.monitorCosTime("InitTaskManager.init", System.currentTimeMillis() - r0, false);
    }

    public final void a(com.bytedance.lego.init.model.b r6) {
        Intrinsics.checkParameterIsNotNull(r6, "task");
        Object r0 = this.e;
        monitor-enter(r0);
    L30:
        th = move-exception;
        throw th;
    L5:
        if (r6.n == false) goto L9;
        monitor-exit(r0);
        return;
    L9:
        r6.n = true;     // Catch: Throwable -> L30
        this.f.getAndIncrement();     // Catch: Throwable -> L30
        List<String> r1 = r6.h;     // Catch: Throwable -> L30
        if (r1 == null) goto L28;
        Iterator r2 = ((Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Throwable -> L30
    L13:
        if (r2.hasNext() == false) goto L27;
        String r3 = (String) ZeusTransformUtils.preCheckCast(r2.next(), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L30
        com.bytedance.lego.init.model.b r4 = (com.bytedance.lego.init.model.b) ZeusTransformUtils.preCheckCast(this.f2773a.get(r3), com.bytedance.lego.init.model.b.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L30
        if (r4 == null) goto L13;
        if (this.f2774b.contains(r4) == false) goto L13;
        List<String> r5 = r4.j;     // Catch: Throwable -> L30
        if (r5 == null) goto L23;
        r5.remove(r6.f2783a);     // Catch: Throwable -> L30
    L23:
        if (r4.j == null) goto L26;
        if (r4.j.isEmpty() == false) goto L13;
    L26:
        b(r4);     // Catch: Throwable -> L30
        goto L13
    L27:
        Unit r7 = Unit.INSTANCE;     // Catch: Throwable -> L30
    L28:
        monitor-exit(r0);
    }

    public final List<String> b(String r4) {
        Intrinsics.checkParameterIsNotNull(r4, "taskId");
        List<String> r0 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        Object r1 = this.e;
        monitor-enter(r1);
        com.bytedance.lego.init.model.b r3 = (com.bytedance.lego.init.model.b) ZeusTransformUtils.preCheckCast(this.f2773a.get(r4), com.bytedance.lego.init.model.b.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L9
        if (r3 == null) goto L7;
        List<String> r5 = r3.j;     // Catch: Throwable -> L9
        Intrinsics.checkExpressionValueIsNotNull(r5, "it.dependencies");     // Catch: Throwable -> L9
        Boolean.valueOf(r0.addAll((Collection) ZeusTransformUtils.preCheckCast(r5, Collection.class, "com.obric.memorydata.plugin")));     // Catch: Throwable -> L9
    L7:
        monitor-exit(r1);
        return r0;
    L9:
        th = move-exception;
        throw th;
    }

    public final void b() {
    L11:
        e = move-exception;
        e.printStackTrace();
        return;
    L4:
        if (this.f.get() == this.f2773a.size()) goto L17;
        JSONObject r1 = new JSONObject();     // Catch: Exception -> L11
        r1.put(CommonConsts.COUNT_TYPE, this.f.get() - this.f2773a.size());     // Catch: Exception -> L11
        r1.put("undispatchCount", this.f2774b.size());     // Catch: Exception -> L11
        Iterator r2 = ((Iterable) ZeusTransformUtils.preCheckCast(this.f2774b, Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Exception -> L11
    L7:
        if (r2.hasNext() == false) goto L9;
        r1.put(((com.bytedance.lego.init.model.b) ZeusTransformUtils.preCheckCast(r2.next(), com.bytedance.lego.init.model.b.class, "com.obric.memorydata.plugin")).f2783a, "task");     // Catch: Exception -> L11
        goto L7
    L9:
        InitMonitor r0 = InitMonitor.INSTANCE;     // Catch: Exception -> L11
        Category r3 = Category.TASK_COUNT_EXCEPTION;     // Catch: Exception -> L11
        String r5 = String.valueOf(this.f.get() - this.f2773a.size());     // Catch: Exception -> L11
        JSONObject r4 = new JSONObject();     // Catch: Exception -> L11
        r4.put("task_count_exception", r1);     // Catch: Exception -> L11
        r0.monitorEvent(r3, r5, r4);     // Catch: Exception -> L11
        return;
    }

    public final float c(String r2) {
        Intrinsics.checkParameterIsNotNull(r2, "taskId");
        com.bytedance.lego.init.model.b r1 = (com.bytedance.lego.init.model.b) ZeusTransformUtils.preCheckCast(this.f2773a.get(r2), com.bytedance.lego.init.model.b.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L7;
        return -1.0f;
    L7:
        return r1.g;
    }
}
