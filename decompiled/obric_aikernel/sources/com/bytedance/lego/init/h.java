package com.bytedance.lego.init;

import androidx.annotation.UiThread;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.lego.init.monitor.Category;
import com.bytedance.lego.init.monitor.InitMonitor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Map<String, m3.g> f2085a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ArrayList<m3.g> f2086b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final PriorityBlockingQueue<m3.g> f2087c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final PriorityBlockingQueue<m3.g> f2088d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Object f2089e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private AtomicInteger f2090f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final String f2091g;

    public h() {
        this.f2085a = new LinkedHashMap();
        this.f2086b = new ArrayList();
        this.f2087c = new PriorityBlockingQueue();
        this.f2088d = new PriorityBlockingQueue();
        this.f2089e = new Object();
        this.f2090f = new AtomicInteger(0);
        this.f2091g = "InitTaskManager";
    }

    private final boolean e() {
        Object r10 = this.f2089e;
        monitor-enter(r10);
    L19:
        th = move-exception;
        throw th;
    L6:
        if ((!this.f2088d.isEmpty()) == false) goto L9;
        monitor-exit(r10);
        return true;
    L9:
        Iterator<T> r11 = this.f2086b.iterator();     // Catch: Throwable -> L19
    L11:
        if (r11.hasNext() == false) goto L17;
        if (((m3.g) r11.next()).f11032j == true) goto L11;
        monitor-exit(r10);
        return true;
    L17:
        monitor-exit(r10);
        return false;
    }

    private final void g() {
        Collection<m3.g> r10 = this.f2085a.values();
        if (r10 == null) goto L12;
        Iterator<T> r11 = r10.iterator();
    L6:
        if (r11.hasNext() == false) goto L19;
        m3.g r12 = (m3.g) r11.next();
        List<String> r13 = r12.f11038p;
        if (r13 == null) goto L11;
        if (r13.isEmpty() == false) goto L6;
    L11:
        h(r12);
        goto L6
    L19:
        return;
    }

    private final void h(m3.g r10) {
        com.bytedance.lego.init.util.c.f2121a.a(this.f2091g, "letTaskReady: " + r10.f11028c);
        if (r10.f11032j == false) goto L5;
        PriorityBlockingQueue<m3.g> r11 = this.f2087c;
    L6:
        r11.add(r10);
        this.f2086b.remove(r10);
        return;
    L5:
        r11 = this.f2088d;
        goto L6
    }

    public static /* synthetic */ m3.g k(h r10, Long r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L6;
        r11 = null;
    L6:
        return r10.j(r11);
    }

    public final void a() {
    L10:
        e = move-exception;
        e.printStackTrace();
        return;
    L3:
        if (this.f2090f.get() == this.f2085a.size()) goto L16;
        JSONObject r10 = new JSONObject();     // Catch: Exception -> L10
        r10.put(CommonConsts.COUNT_TYPE, this.f2090f.get() - this.f2085a.size());     // Catch: Exception -> L10
        r10.put("undispatchCount", this.f2086b.size());     // Catch: Exception -> L10
        Iterator<T> r11 = this.f2086b.iterator();     // Catch: Exception -> L10
    L6:
        if (r11.hasNext() == false) goto L8;
        r10.put(((m3.g) r11.next()).f11028c, "task");     // Catch: Exception -> L10
        goto L6
    L8:
        InitMonitor r12 = InitMonitor.INSTANCE;     // Catch: Exception -> L10
        Category r13 = Category.TASK_COUNT_EXCEPTION;     // Catch: Exception -> L10
        String r14 = String.valueOf(this.f2090f.get() - this.f2085a.size());     // Catch: Exception -> L10
        JSONObject r15 = new JSONObject();     // Catch: Exception -> L10
        r15.put("task_count_exception", r10);     // Catch: Exception -> L10
        r12.monitorEvent(r13, r14, r15);     // Catch: Exception -> L10
        return;
    }

    public final m3.g b(String r10) {
        Intrinsics.checkParameterIsNotNull(r10, "taskId");
        return this.f2085a.get(r10);
    }

    public final float c(String r10) {
        Intrinsics.checkParameterIsNotNull(r10, "taskId");
        m3.g r11 = this.f2085a.get(r10);
        if (r11 != null) goto L7;
        return -1.0f;
    L7:
        return r11.f11035m;
    }

    public final List<String> d(String r10) {
        Intrinsics.checkParameterIsNotNull(r10, "taskId");
        ArrayList r11 = new ArrayList();
        Object r12 = this.f2089e;
        monitor-enter(r12);
        m3.g r13 = this.f2085a.get(r10);     // Catch: Throwable -> L9
        if (r13 == null) goto L7;
        List<String> r14 = r13.f11038p;     // Catch: Throwable -> L9
        Intrinsics.checkExpressionValueIsNotNull(r14, "it.dependencies");     // Catch: Throwable -> L9
        r11.addAll(r14);     // Catch: Throwable -> L9
    L7:
        monitor-exit(r12);
        return r11;
    L9:
        th = move-exception;
        throw th;
    }

    public final void f() {
        long r10 = System.currentTimeMillis();
        Map<String, m3.g> r11 = k.g();
        Intrinsics.checkExpressionValueIsNotNull(r11, "TaskCollectorManager.getInitTaskIndexs()");
        this.f2085a = r11;
        com.bytedance.lego.init.util.c.b(com.bytedance.lego.init.util.c.f2121a, null, "collect cos: " + (System.currentTimeMillis() - r10) + "ms  size: " + this.f2085a.size(), 1, null);
        InitMonitor r12 = InitMonitor.INSTANCE;
        r12.monitorCosTime("InitTaskManager.CollectTasks", System.currentTimeMillis() - r10, false);
        this.f2086b.addAll(this.f2085a.values());
        g();
        InitTaskDispatcher.f2068u.p(this.f2085a.isEmpty());
        r12.monitorCosTime("InitTaskManager.init", System.currentTimeMillis() - r10, false);
    }

    public final void i(m3.g r10) {
        Intrinsics.checkParameterIsNotNull(r10, "task");
        Object r11 = this.f2089e;
        monitor-enter(r11);
    L30:
        th = move-exception;
        throw th;
    L5:
        if (r10.f11041s == false) goto L9;
        monitor-exit(r11);
        return;
    L9:
        r10.f11041s = true;     // Catch: Throwable -> L30
        this.f2090f.getAndIncrement();     // Catch: Throwable -> L30
        List<String> r12 = r10.f11036n;     // Catch: Throwable -> L30
        if (r12 == null) goto L28;
        Iterator<T> r13 = r12.iterator();     // Catch: Throwable -> L30
    L13:
        if (r13.hasNext() == false) goto L27;
        String r14 = (String) r13.next();     // Catch: Throwable -> L30
        m3.g r15 = this.f2085a.get(r14);     // Catch: Throwable -> L30
        if (r15 == null) goto L13;
        if (this.f2086b.contains(r15) == false) goto L13;
        List<String> r16 = r15.f11038p;     // Catch: Throwable -> L30
        if (r16 == null) goto L22;
        r16.remove(r10.f11028c);     // Catch: Throwable -> L30
    L22:
        List<String> r17 = r15.f11038p;     // Catch: Throwable -> L30
        if (r17 == null) goto L26;
        if (r17.isEmpty() == false) goto L13;
    L26:
        h(r15);     // Catch: Throwable -> L30
        goto L13
    L27:
        Unit r18 = Unit.INSTANCE;     // Catch: Throwable -> L30
    L28:
        monitor-exit(r11);
    }

    public final m3.g j(Long r10) {
        if (e() == true) goto L6;
        return null;
    L6:
        PriorityBlockingQueue<m3.g> r11 = this.f2088d;
        if (r10 == null) goto L11;
        m3.g r12 = r11.poll(r10.longValue(), TimeUnit.MILLISECONDS);
    L10:
        return r12;
    L11:
        r12 = r11.take();
        goto L10
    }

    @UiThread
    public final m3.g l(long r10) {
        return this.f2087c.poll(r10, TimeUnit.MILLISECONDS);
    L4:
        e = move-exception;
        e.printStackTrace();
        return null;
    }
}
