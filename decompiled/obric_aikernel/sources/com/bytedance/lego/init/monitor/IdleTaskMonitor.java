package com.bytedance.lego.init.monitor;

import android.annotation.SuppressLint;
import android.util.Pair;
import com.bytedance.crash.entity.EventBody;
import com.bytedance.lego.init.InitScheduler;
import com.bytedance.lego.init.util.c;
import com.bytedance.services.apm.api.IApmAgent;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"CI_ByteDanceKotlinRules_Static_Names"})
public final class IdleTaskMonitor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final /* synthetic */ KProperty[] f2103a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final CopyOnWriteArrayList<Pair<String, Long>> f2104b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Lazy f2105c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static long f2106d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final IdleTaskMonitor f2107e = null;

    static {
        f2103a = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(IdleTaskMonitor.class), "iApmAgent", "getIApmAgent()Lcom/bytedance/services/apm/api/IApmAgent;"))};
        f2107e = new IdleTaskMonitor();
        f2104b = new CopyOnWriteArrayList();
        f2105c = LazyKt.lazy(IdleTaskMonitor$iApmAgent$2.INSTANCE);
        f2106d = -1;
    }

    private IdleTaskMonitor() {
    }

    private final void a(String r10, long r11) {
        f2104b.add(new Pair(r10, Long.valueOf(r11)));
    }

    private final boolean b() {
        if (f2106d <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    private final IApmAgent c() {
        Lazy r10 = f2105c;
        KProperty r11 = f2103a[0];
        return (IApmAgent) r10.getValue();
    }

    private final String d(String r10, boolean r11) {
        return j(r11) + r10 + InitMonitor.TASK_END_SUFFIX;
    }

    private final String e(String r10, boolean r11) {
        return j(r11) + r10 + InitMonitor.TASK_START_SUFFIX;
    }

    private final String f(String r10, boolean r11) {
        return j(r11) + "Task-" + r10;
    }

    private final String j(boolean r10) {
        if (r10 == false) goto L4;
        return InitMonitor.MAIN;
    L4:
        return InitMonitor.ASYNC;
    }

    public final void g(String r10, long r11, boolean r12) {
        Intrinsics.checkParameterIsNotNull(r10, "taskId");
        a(f(r10, r12), r11);
    }

    public final void h(String r10, boolean r11) {
        Intrinsics.checkParameterIsNotNull(r10, "taskId");
        if (b() == true) goto L5;
        return;
    L5:
        a(d(r10, r11), System.currentTimeMillis() - f2106d);
    }

    public final void i(String r10, boolean r11) {
        Intrinsics.checkParameterIsNotNull(r10, "taskId");
        if (b() == true) goto L5;
        return;
    L5:
        a(e(r10, r11), System.currentTimeMillis() - f2106d);
    }

    public final void k() {
        if (c() == null) goto L15;
        JSONObject r10 = new JSONObject();
        Iterator<T> r11 = f2104b.iterator();     // Catch: Throwable -> L17
    L7:
        if (r11.hasNext() == false) goto L10;
        Pair r12 = (Pair) r11.next();     // Catch: Throwable -> L17
        String r13 = (String) r12.first;     // Catch: Throwable -> L17
        Object r14 = r12.second;     // Catch: Throwable -> L17
        Intrinsics.checkExpressionValueIsNotNull(r14, "it.second");     // Catch: Throwable -> L17
        r10.put(r13, ((Number) r14).longValue());     // Catch: Throwable -> L17
    L10:
        c.f2121a.a("IdleTaskMonitor", "sendIdleTaskMonitor " + r10);
        JSONObject r15 = new JSONObject();
        r15.put(EventBody.KEY_CATEGORY, InitScheduler.INSTANCE.getINIT_SCHEDULER_CATEGORY$initscheduler_release());
        IApmAgent r16 = c();
        if (r16 == null) goto L13;
        r16.monitorEvent("idle_task_monitor", r15, r10, new JSONObject());
    L13:
        f2104b.clear();
        return;
    L15:
        c.f2121a.c("IdleTaskMonitor", "ServiceManager.getService(IApmAgent::class.java) is null.");
    }

    public final void l(long r10) {
        f2106d = r10;
    }
}
