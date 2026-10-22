package com.bytedance.lego.init.monitor;

import android.util.Pair;
import com.bytedance.crash.entity.EventBody;
import com.bytedance.lego.init.InitScheduler;
import com.bytedance.lego.init.util.d;
import com.bytedance.services.apm.api.IApmAgent;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000e\bÁ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u000bH\u0002J\b\u0010\u0019\u001a\u00020\u001aH\u0002J\u0018\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u001aH\u0002J\u0018\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u001aH\u0002J\u0018\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u001aH\u0002J\u001e\u0010 \u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020\u001aJ\u0016\u0010#\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u001aJ\u0016\u0010$\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u001aJ\u0010\u0010%\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u001aH\u0002J\u0006\u0010&\u001a\u00020\u0016J\u000e\u0010'\u001a\u00020\u00162\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\f\u001a\u0004\u0018\u00010\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR \u0010\u0012\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000b0\u00140\u0013X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/bytedance/lego/init/monitor/IdleTaskMonitor;", "", "()V", "ASYNC", "", "MAIN", "MONITOR_DELAY", "TAG", "TASK_END_SUFFIX", "TASK_START_SUFFIX", "applicationStartTime", "", "iApmAgent", "Lcom/bytedance/services/apm/api/IApmAgent;", "getIApmAgent", "()Lcom/bytedance/services/apm/api/IApmAgent;", "iApmAgent$delegate", "Lkotlin/Lazy;", "idleTaskCostTimeList", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Landroid/util/Pair;", "addDuration", "", "key", "cosTime", "checkCreateEndTimeValid", "", "getTaskEndTag", "taskId", "isMainThread", "getTaskStartTag", "getTaskTag", "monitorCostTime", "costTime", "uiThread", "monitorTaskEnd", "monitorTaskStart", "preTag", "sendIdleTaskTaskMonitor", "setApplicationStartTime", "initscheduler_release"}, k = 1, mv = {1, 1, 13})
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final /* synthetic */ KProperty[] f2793a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final c f2794b = null;
    private static final CopyOnWriteArrayList<Pair<String, Long>> c = null;
    private static final Lazy d = null;
    private static long e;

    static {
        f2793a = new KProperty[]{(KProperty) ZeusTransformUtils.preCheckCast(Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(c.class), "iApmAgent", "getIApmAgent()Lcom/bytedance/services/apm/api/IApmAgent;")), KProperty.class, "com.obric.memorydata.plugin")};
        f2794b = new c();
        c = new CopyOnWriteArrayList();
        d = LazyKt.lazy((Function0) ZeusTransformUtils.preCheckCast(IdleTaskMonitor$iApmAgent$2.INSTANCE, Function0.class, "com.obric.memorydata.plugin"));
        e = -1;
    }

    private c() {
    }

    private final String a(boolean r1) {
        if (r1 == false) goto L4;
        return InitMonitor.MAIN;
    L4:
        return InitMonitor.ASYNC;
    }

    private final void a(String r2, long r3) {
        c.add(new Pair(r2, Long.valueOf(r3)));
    }

    private final IApmAgent b() {
        Lazy r2 = d;
        KProperty r0 = f2793a[0];
        return (IApmAgent) ZeusTransformUtils.preCheckCast(r2.getValue(), IApmAgent.class, "com.obric.memorydata.plugin");
    }

    private final String c(String r2, boolean r3) {
        return a(r3) + r2 + InitMonitor.TASK_START_SUFFIX;
    }

    private final boolean c() {
        if (e <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    private final String d(String r2, boolean r3) {
        return a(r3) + r2 + InitMonitor.TASK_END_SUFFIX;
    }

    private final String e(String r2, boolean r3) {
        return a(r3) + "Task-" + r2;
    }

    public final void a() {
        if (b() == null) goto L15;
        JSONObject r0 = new JSONObject();
        Iterator r3 = ((Iterable) ZeusTransformUtils.preCheckCast(c, Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Throwable -> L17
    L7:
        if (r3.hasNext() == false) goto L10;
        Pair r4 = (Pair) ZeusTransformUtils.preCheckCast(r3.next(), Pair.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L17
        String r5 = (String) ZeusTransformUtils.preCheckCast(r4.first, String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L17
        Object r6 = r4.second;     // Catch: Throwable -> L17
        Intrinsics.checkExpressionValueIsNotNull(r6, "it.second");     // Catch: Throwable -> L17
        r0.put(r5, ((Number) ZeusTransformUtils.preCheckCast(r6, Number.class, "com.obric.memorydata.plugin")).longValue());     // Catch: Throwable -> L17
    L10:
        d.f2800a.b("IdleTaskMonitor", "sendIdleTaskMonitor " + r0);
        JSONObject r1 = new JSONObject();
        r1.put(EventBody.KEY_CATEGORY, InitScheduler.INSTANCE.getINIT_SCHEDULER_CATEGORY$initscheduler_release());
        IApmAgent r8 = b();
        if (r8 == null) goto L13;
        r8.monitorEvent("idle_task_monitor", r1, r0, new JSONObject());
    L13:
        c.clear();
        return;
    L15:
        c r9 = (c) ZeusTransformUtils.preCheckCast(this, c.class, "com.obric.memorydata.plugin");
        d.f2800a.c("IdleTaskMonitor", "ServiceManager.getService(IApmAgent::class.java) is null.");
    }

    public final void a(long r1) {
        e = r1;
    }

    public final void a(String r2, long r3, boolean r5) {
        Intrinsics.checkParameterIsNotNull(r2, "taskId");
        a(e(r2, r5), r3);
    }

    public final void a(String r5, boolean r6) {
        Intrinsics.checkParameterIsNotNull(r5, "taskId");
        if (c() == true) goto L5;
        return;
    L5:
        a(c(r5, r6), System.currentTimeMillis() - e);
    }

    public final void b(String r5, boolean r6) {
        Intrinsics.checkParameterIsNotNull(r5, "taskId");
        if (c() == true) goto L5;
        return;
    L5:
        a(d(r5, r6), System.currentTimeMillis() - e);
    }
}
