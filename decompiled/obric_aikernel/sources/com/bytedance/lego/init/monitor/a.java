package com.bytedance.lego.init.monitor;

import com.bytedance.crash.tracker.ActivityLifecycle;
import com.bytedance.lego.init.j;
import com.bytedance.lego.init.model.DelayTaskInfo;
import com.bytedance.lego.init.util.c;
import com.bytedance.services.apm.api.IApmAgent;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final CopyOnWriteArrayList<Pair<String, Long>> f2110a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static long f2111b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f2112c = null;

    static {
        f2112c = new a();
        f2110a = new CopyOnWriteArrayList();
        f2111b = -1;
    }

    private a() {
    }

    private final void a(String r10, long r11) {
        f2110a.add(new Pair(r10, Long.valueOf(r11)));
    }

    private final String b(String r10, boolean r11) {
        if (r11 == false) goto L7;
        StringBuilder r12 = new StringBuilder();
        String r13 = InitMonitor.MAIN;
    L5:
        r12.append(r13);
        r12.append(r10);
        return r12.toString();
    L7:
        r12 = new StringBuilder();
        r13 = InitMonitor.ASYNC;
        goto L5
    }

    private final String c(DelayTaskInfo r10, boolean r11) {
        if (r11 == false) goto L7;
        StringBuilder r12 = new StringBuilder();
        String r13 = InitMonitor.MAIN;
    L5:
        r12.append(r13);
        r12.append(r10.taskId);
        r12.append("_TASKSTART");
        return r12.toString();
    L7:
        r12 = new StringBuilder();
        r13 = InitMonitor.ASYNC;
        goto L5
    }

    public final void d(String r10, long r11, boolean r12) {
        Intrinsics.checkParameterIsNotNull(r10, ActivityLifecycle.NAME);
        a(b(r10, r12), r11);
    }

    public final void e(DelayTaskInfo r10, boolean r11) {
        Intrinsics.checkParameterIsNotNull(r10, "taskInfo");
        if (f2111b >= 0) goto L5;
        return;
    L5:
        a(c(r10, r11), System.currentTimeMillis() - f2111b);
    }

    public final void f() {
        IApmAgent r10 = (IApmAgent) j.f2093b.a(IApmAgent.class);
        if (r10 == null) goto L14;
        JSONObject r11 = new JSONObject();
        Iterator<T> r12 = f2110a.iterator();     // Catch: Exception -> L10
    L7:
        if (r12.hasNext() == false) goto L12;
        Pair r13 = (Pair) r12.next();     // Catch: Exception -> L10
        r11.put((String) r13.getFirst(), ((Number) r13.getSecond()).longValue());     // Catch: Exception -> L10
    L12:
        c.f2121a.a("DelayTaskMonitor", "sendDelayTaskMonitor " + r11);
        r10.monitorEvent("delay_task_monitor", new JSONObject(), r11, new JSONObject());
        f2110a.clear();
        return;
    L10:
        e = move-exception;
        e.printStackTrace();
        goto L12
    L14:
        c.f2121a.c("DelayTaskMonitor", "ServiceManager.getService(IApmAgent::class.java) is null.");
    }

    public final void g(long r10) {
        f2111b = r10;
    }
}
