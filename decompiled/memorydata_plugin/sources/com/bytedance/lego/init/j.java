package com.bytedance.lego.init;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.lego.init.model.ExecutionPeriod;
import com.bytedance.lego.init.monitor.InitMonitor;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\n2\b\b\u0002\u0010\u0010\u001a\u00020\u0006H\u0002J\u0006\u0010\u0011\u001a\u00020\u000eJ\b\u0010\u0012\u001a\u00020\u000eH\u0002J\u0015\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u0015H\u0000¢\u0006\u0002\b\u0016J\u0015\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u0015H\u0000¢\u0006\u0002\b\u0018R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R \u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/bytedance/lego/init/PeriodTaskManager;", "", "()V", "TAG", "", "alreadyMainOnResume", "", "alreadySplashOnResume", "periodTaskMap", "", "Lcom/bytedance/lego/init/model/ExecutionPeriod;", "", "Lcom/bytedance/lego/init/model/PeriodTaskInfo;", "dispatchTasks", "", "executionPeriod", "shouldMonitor", CommonConsts.APM_INNER_EVENT_COST_INIT, "printAllPeriodTasks", "registerMain", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "registerMain$initscheduler_release", "registerSplash", "registerSplash$initscheduler_release", "initscheduler_release"}, k = 1, mv = {1, 1, 13})
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j f2775a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Map<ExecutionPeriod, List<com.bytedance.lego.init.model.c>> f2776b = null;
    private static volatile boolean c;
    private static volatile boolean d;

    static {
        f2775a = new j();
        f2776b = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
    }

    private j() {
    }

    public static final /* synthetic */ void a(j r0, ExecutionPeriod r1, boolean r2) {
        r0.a(r1, r2);
    }

    static /* synthetic */ void a(j r0, ExecutionPeriod r1, boolean r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = false;
    L5:
        r0.a(r1, r2);
    }

    public static final /* synthetic */ void a(j r0, boolean r1) {
        c = r1;
    }

    private final void a(ExecutionPeriod r8, boolean r9) {
        List r7 = (List) ZeusTransformUtils.preCheckCast(f2776b.get(r8), List.class, "com.obric.memorydata.plugin");
        if (r7 == null) goto L15;
        Iterator r10 = ((Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L6:
        if (r10.hasNext() == false) goto L26;
        com.bytedance.lego.init.model.c r11 = (com.bytedance.lego.init.model.c) ZeusTransformUtils.preCheckCast(r10.next(), com.bytedance.lego.init.model.c.class, "com.obric.memorydata.plugin");
        if (r11.b().mustRunInMainThread() == true) goto L9;
        InitScheduler.INSTANCE.getExecutorService$initscheduler_release().submit((Runnable) ZeusTransformUtils.preCheckCast(r11.b(), Runnable.class, "com.obric.memorydata.plugin"));
        com.bytedance.lego.init.util.d.f2800a.b("PeriodTaskManager", "ASYNC " + r11.a() + " submit.");
        if (r9 == false) goto L6;
        InitMonitor.INSTANCE.monitor(r11.a() + "-SUBMIT");
        goto L6
    L9:
        long r3 = System.currentTimeMillis();
        com.bytedance.lego.init.util.g r1 = com.bytedance.lego.init.util.g.f2802a;
        String r5 = r11.a();
        Intrinsics.checkExpressionValueIsNotNull(r5, "taskInfo.taskId");
        r1.a(r5);
        r11.b().run();
        com.bytedance.lego.init.util.g.f2802a.b();
        com.bytedance.lego.init.util.d.f2800a.b("PeriodTaskManager", "UIThread " + r11.a() + " done.");
        if (r9 == false) goto L6;
        InitMonitor.INSTANCE.monitorCosTime(r11, System.currentTimeMillis() - r3, true);
        goto L6
    L26:
        return;
    }

    public static final /* synthetic */ boolean a(j r0) {
        return c;
    }

    private final void b() {
        if (InitScheduler.INSTANCE.isDebug$initscheduler_release() == true) goto L5;
        return;
    L5:
        StringBuilder r6 = new StringBuilder("------------------------------ AllPeriodTask --------------------------------\n");
        Iterator<Map.Entry<ExecutionPeriod, List<com.bytedance.lego.init.model.c>>> r0 = f2776b.entrySet().iterator();
    L7:
        if (r0.hasNext() == false) goto L15;
        Map.Entry r1 = (Map.Entry) ZeusTransformUtils.preCheckCast(r0.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r1.getValue(), Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L7;
        r6.append(((ExecutionPeriod) ZeusTransformUtils.preCheckCast(r1.getKey(), ExecutionPeriod.class, "com.obric.memorydata.plugin")).name() + ": ");
        Iterator r2 = ((Iterable) ZeusTransformUtils.preCheckCast(r1.getValue(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L12:
        if (r2.hasNext() == false) goto L14;
        r6.append(((com.bytedance.lego.init.model.c) ZeusTransformUtils.preCheckCast(r2.next(), com.bytedance.lego.init.model.c.class, "com.obric.memorydata.plugin")).a() + ' ');
        goto L12
    L14:
        r6.append("\n");
        goto L7
    L15:
        com.bytedance.lego.init.util.d r3 = com.bytedance.lego.init.util.d.f2800a;
        String r7 = r6.toString();
        Intrinsics.checkExpressionValueIsNotNull(r7, "totalInfo.toString()");
        r3.b("PeriodTaskManager", r7);
    }

    public static final /* synthetic */ void b(j r0, boolean r1) {
        d = r1;
    }

    public static final /* synthetic */ boolean b(j r0) {
        return d;
    }

    public final void a() {
        List<com.bytedance.lego.init.model.c> r0 = m.e();
        Intrinsics.checkExpressionValueIsNotNull(r0, "TaskCollectorManager.getAllPeriodTaskInfo()");
        Iterator r1 = ((Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r1.hasNext() == false) goto L11;
        com.bytedance.lego.init.model.c r2 = (com.bytedance.lego.init.model.c) ZeusTransformUtils.preCheckCast(r1.next(), com.bytedance.lego.init.model.c.class, "com.obric.memorydata.plugin");
        Map<ExecutionPeriod, List<com.bytedance.lego.init.model.c>> r3 = f2776b;
        Intrinsics.checkExpressionValueIsNotNull(r2, "taskInfo");
        List<com.bytedance.lego.init.model.c> r4 = (List) ZeusTransformUtils.preCheckCast(r3.get(r2.c()), List.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L9;
        r4 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        ExecutionPeriod r5 = r2.c();
        Intrinsics.checkExpressionValueIsNotNull(r5, "taskInfo.executionPeriod");
        r3.put(r5, r4);
        Unit r6 = Unit.INSTANCE;
    L9:
        if (r4 == null) goto L4;
        r4.add(r2);
        goto L4
    L11:
        b();
    }

    public final void a(Lifecycle r3) {
        Intrinsics.checkParameterIsNotNull(r3, "lifecycle");
        r3.addObserver((LifecycleObserver) ZeusTransformUtils.preCheckCast(new PeriodTaskManager$registerMain$1(), LifecycleObserver.class, "com.obric.memorydata.plugin"));
    }

    public final void b(Lifecycle r3) {
        Intrinsics.checkParameterIsNotNull(r3, "lifecycle");
        r3.addObserver((LifecycleObserver) ZeusTransformUtils.preCheckCast(new PeriodTaskManager$registerSplash$1(), LifecycleObserver.class, "com.obric.memorydata.plugin"));
    }
}
