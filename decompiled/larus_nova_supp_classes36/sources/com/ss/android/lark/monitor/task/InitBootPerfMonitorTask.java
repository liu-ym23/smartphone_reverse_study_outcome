package com.ss.android.lark.monitor.task;

import android.content.Context;
import android.os.Looper;
import android.os.SystemClock;
import com.bytedance.apm6.util.timetask.AsyncTaskManagerType;
import com.larksuite.framework.launch.task.AsyncLaunchTask;
import com.larksuite.framework.thread.CoreThreadPool;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.abtest.api.IABTestService;
import com.ss.android.lark.appcontext.applifecycle.AppLifecycle;
import com.ss.android.lark.appcontext.applifecycle.a0;
import com.ss.android.lark.appcontext.applifecycle.y;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.keyboard.plugin.tool.voice.audio2.AudioViewModel;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.monitor.abtest.PerfMonitorExperiment;
import com.ss.android.lark.monitor.callback.CpuCallbackManager;
import com.ss.android.lark.statistics.Statistics;
import com.ss.android.lark.utils.ApiUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import tt3.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\t\u0018\u0000 %2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0002%&B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u0018\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u000eH\u0003J\u0010\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u001bH\u0003J\u0010\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\b\u0010\u001f\u001a\u00020\u0012H\u0002J(\u0010 \u001a\u00020\u00122\u0006\u0010!\u001a\u00020\n2\u0006\u0010\"\u001a\u00020\u001e2\u0006\u0010#\u001a\u00020\u001e2\u0006\u0010$\u001a\u00020\u001eH\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/ss/android/lark/monitor/task/InitBootPerfMonitorTask;", "Lcom/larksuite/framework/launch/task/AsyncLaunchTask;", "", "Lcom/ss/android/lark/monitor/callback/CpuCallbackManager$CpuCallback;", "<init>", "()V", "mIsAppFront", "Ljava/util/concurrent/atomic/AtomicBoolean;", "mHasStartMonitor", "mLastStartTime", "", "mCpuIdleCount", "", "mMonitorConfig", "Lcom/ss/android/lark/monitor/abtest/PerfMonitorExperiment$PerfMonitorConfig;", "mIdleCpuData", "Lcom/ss/android/lark/monitor/task/InitBootPerfMonitorTask$CpuData;", "execute", "", "context", "Landroid/content/Context;", "scheduleMonitor", "scene", "", "monitorConfig", "triggerCpuDataCollect", "start", "", "onAppCpuChange", "newAppCpu", "", "removeCpuDetector", "sendCpuIdleEvent", "idleCost", "idleCpu", "cpuUsage", "cpuSpeed", "Companion", "CpuData", "monitor_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class InitBootPerfMonitorTask extends AsyncLaunchTask<Object> implements CpuCallbackManager.a {
    public static final /* synthetic */ int i = 0;
    public final AtomicBoolean c;
    public final AtomicBoolean d;
    public long e;
    public int f;
    public PerfMonitorExperiment.PerfMonitorConfig g;
    public final b h;

    public static final class a {
    }

    public static final class b {
        public long a;
        public long b;
        public long c;
        public float d;
        public float e;

        public b() {
            this(0);
        }

        public final boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof b) == true) goto L8;
            return false;
        L8:
            b r9 = (b) r8;
            if (this.a == r9.a) goto L12;
            return false;
        L12:
            if (this.b == r9.b) goto L15;
            return false;
        L15:
            if (this.c == r9.c) goto L18;
            return false;
        L18:
            if (Float.compare(this.d, r9.d) == 0) goto L21;
            return false;
        L21:
            if (Float.compare(this.e, r9.e) == 0) goto L23;
            return false;
        L23:
            return true;
        }

        public final int hashCode() {
            long r0 = this.a;
            int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
            long r3 = this.b;
            int r2 = (r1 + ((int) (r3 ^ (r3 >>> 32)))) * 31;
            long r4 = this.c;
            return ((((r2 + ((int) (r4 ^ (r4 >>> 32)))) * 31) + Float.floatToIntBits(this.d)) * 31) + Float.floatToIntBits(this.e);
        }

        public final String toString() {
            return "CpuData(startTime=" + this.a + ", appCpuTime=" + this.b + ", totalCpuTime=" + this.c + ", cpuUsage=" + this.d + ", cpuSpeed=" + this.e + ')';
        }

        public b(int r3) {
            this.a = 0;
            this.b = 0;
            this.c = 0;
            this.d = 0.0f;
            this.e = 0.0f;
        }
    }

    public static final class c implements y {
        public final /* synthetic */ InitBootPerfMonitorTask a;
        public final /* synthetic */ PerfMonitorExperiment.PerfMonitorConfig b;

        public static final class a implements Runnable {
            public final /* synthetic */ InitBootPerfMonitorTask a;
            public final /* synthetic */ PerfMonitorExperiment.PerfMonitorConfig b;

            public a(InitBootPerfMonitorTask r1, PerfMonitorExperiment.PerfMonitorConfig r2) {
                this.a = r1;
                this.b = r2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                InitBootPerfMonitorTask r0 = this.a;     // Catch: Throwable -> L4
                PerfMonitorExperiment.PerfMonitorConfig r1 = this.b;     // Catch: Throwable -> L4
                int r2 = InitBootPerfMonitorTask.i;     // Catch: Throwable -> L4
                r0.j("main_front_30_sec", r1);     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        public c(InitBootPerfMonitorTask r1, PerfMonitorExperiment.PerfMonitorConfig r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void f(y.a r3, y.a r4) {
            Intrinsics.checkNotNullParameter(r3, "oldState");
            Intrinsics.checkNotNullParameter(r4, "newState");
            boolean r0 = r4.c;
            if (r0 == r3.c) goto L14;
            this.a.c.set(r0);
            if (r4.c == false) goto L8;
            CoreThreadPool.getDefault().getScheduleThreadPool().execute(new a(this.a, this.b));
            return;
        L8:
            if (FeatureGatingModule.getFeatureGatingService().isEnable("lark.android.core.boot_cpu_monitor_enabled") == false) goto L16;
            InitBootPerfMonitorTask r5 = this.a;
            r5.getClass();
            CpuCallbackManager r6 = CpuCallbackManager.a();
            if (((CopyOnWriteArrayList) r6.a).contains(r5) == false) goto L12;
            ((CopyOnWriteArrayList) r6.a).remove(r5);
        L12:
            Log.i("InitBootPerfMonitorTask", " remove CPU detector when app switch to background after startup");
            return;
        L16:
            return;
        }
    }

    public static final class d implements Runnable {
        public final /* synthetic */ String a;
        public final /* synthetic */ InitBootPerfMonitorTask b;
        public final /* synthetic */ long c;

        public d(String r1, InitBootPerfMonitorTask r2, long r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void a() {
            st3.a r0 = st3.a.b();
            String r3 = this.a;
            boolean r2 = this.b.c.get();
            r0.getClass();
            Map r1 = f.a;
            monitor-enter(f.class);
            Map r4 = f.a;     // Catch: Throwable -> L23
            f.a r5 = (f.a) ((HashMap) r4).get(r3);     // Catch: Throwable -> L23
            if (r5 != null) goto L9;
            monitor-exit(f.class);
        L21:
            Log.i("InitBootPerfMonitorTask", "scheduleMonitor end monitor, scene = " + this.a + ", cost = " + (SystemClock.elapsedRealtime() - this.c));
            this.b.d.set(false);
            return;
        L9:
            if (r5.b < 0) goto L12;
        L15:
            long r6 = com.bytedance.monitor.collector.c.e().a();     // Catch: Throwable -> L23
            long r9 = com.bytedance.monitor.collector.c.e().d(com.bytedance.apm.util.b.b()) - r5.c;     // Catch: Throwable -> L23
            if (r9 <= 0) goto L18;
            double r7 = (r6 - r5.b) / r9;     // Catch: Throwable -> L23
        L19:
            double r10 = (((r6 - r5.b) * 1000.0d) / (System.currentTimeMillis() - r5.a)) / com.bytedance.apm.util.b.f();     // Catch: Throwable -> L23
            ((HashMap) r4).remove(r3);     // Catch: Throwable -> L23
            cv3.b.a(AsyncTaskManagerType.CPU).c(new com.bytedance.apm6.cpu.collect.d(r2, r3, r7, r10));     // Catch: Throwable -> L23
            monitor-exit(f.class);
            goto L21
        L18:
            r7 = -1.0d;
            goto L19
        L12:
            if (r5.c >= 0) goto L15;
            monitor-exit(f.class);
        L23:
            th = move-exception;
            throw th;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class e implements Runnable {
        public final /* synthetic */ String a;

        public e(String r1) {
            this.a = r1;
        }

        public final void a() {
            st3.a r0 = st3.a.b();
            String r1 = this.a;
            r0.getClass();
            Map r2 = f.a;
            monitor-enter(f.class);
            f.a r3 = new f.a();     // Catch: Throwable -> L7
            r3.a = System.currentTimeMillis();     // Catch: Throwable -> L7
            r3.b = com.bytedance.monitor.collector.c.e().a();     // Catch: Throwable -> L7
            r3.c = com.bytedance.monitor.collector.c.e().d(com.bytedance.apm.util.b.b());     // Catch: Throwable -> L7
            ((HashMap) f.a).put(r1, r3);     // Catch: Throwable -> L7
            monitor-exit(f.class);
            return;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    public InitBootPerfMonitorTask() {
        this.c = new AtomicBoolean(false);
        this.d = new AtomicBoolean(false);
        this.g = new PerfMonitorExperiment.PerfMonitorConfig(0.0d, 0, 0, 7, null);
        this.h = new b(0);
    }

    public final void a(Context r5) {
        List<iua.a<?>> r6 = com.ss.android.lark.monitor.abtest.a.a;
        PerfMonitorExperiment.PerfMonitorConfig r7 = (PerfMonitorExperiment.PerfMonitorConfig) ((IABTestService) ApiUtils.getApi(IABTestService.class)).getAbTestValue(PerfMonitorExperiment.class, true);
        if (r7 != null) goto L5;
        return;
    L5:
        Log.i("InitBootPerfMonitorTask", "InitBootPerfMonitorTask start, config = " + r7.getCpuIdleTimesThreshold() + ", " + r7.getCpuIdleFrequencyThreshold() + " ," + r7.getBootMonitorIntervalInMills());
        this.g = r7;
        j("main_start_30_sec", r7);
        k(true);
        AppLifecycle.a.a.c(new c(this, r7));
        CpuCallbackManager r8 = CpuCallbackManager.a();
        if (((CopyOnWriteArrayList) r8.a).contains(this) == true) goto L9;
        ((CopyOnWriteArrayList) r8.a).add(this);
        return;
    }

    @Override // com.ss.android.lark.monitor.callback.CpuCallbackManager.a
    public final void b(float r8) {
        Log.d("InitBootPerfMonitorTask", "onAppCpuChange newAppCpu=" + r8);
        if (r8 >= this.g.getCpuIdleFrequencyThreshold()) goto L5;
        this.f++;
    L7:
        if (this.f < this.g.getCpuIdleTimesThreshold()) goto L13;
        long r2 = SystemClock.uptimeMillis();
        int r4 = a0.b;
        long r3 = r2 - 0;
        Log.d("InitBootPerfMonitorTask", "onAppCpuChange idle, newAppCpu = " + r8 + ", cost = " + r3);
        b r1 = k(false);
        float r5 = r1.d;
        float r6 = r1.e;
        JSONObject r7 = new JSONObject();
        r7.put("cpu_idle_cost", r3);
        r7.put("idle_cpu_usage", Float.valueOf(r8));
        r7.put("average_cpu_usage", Float.valueOf(r5));
        r7.put("average_cpu_speed", Float.valueOf(r6));
        Statistics.sendEvent("perf_boot_cpu_idle_stage_dev", r7);
        CpuCallbackManager r9 = CpuCallbackManager.a();
        if (((CopyOnWriteArrayList) r9.a).contains(this) == false) goto L11;
        ((CopyOnWriteArrayList) r9.a).remove(this);
    L11:
        this.f = 0;
        return;
    L13:
        return;
    L5:
        this.f = 0;
        goto L7
    }

    public final b k(boolean r13) {
        long r0 = SystemClock.elapsedRealtime();
        long r2 = com.bytedance.apm.util.b.a();
        long r4 = com.bytedance.apm.util.b.j();
        if (r13 == false) goto L5;
        b r6 = this.h;
        r6.a = r0;
        r6.b = r2;
        r6.c = r4;
    L8:
        StringBuilder r1 = new StringBuilder("triggerCpuDataCollect ");
        if (r13 == false) goto L11;
        String r14 = "start";
    L12:
        r1.append(r14);
        r1.append(", cpuUsage=");
        r1.append(this.h.d);
        r1.append(", cpuSpeed=");
        r1.append(this.h.e);
        r1.append(", appCpuTime=");
        r1.append(r2);
        r1.append(", totalCpuTime=");
        r1.append(r4);
        Log.i("InitBootPerfMonitorTask", r1.toString());
        return this.h;
    L11:
        r14 = "end";
        goto L12
    L5:
        b r7 = this.h;
        long r8 = r4 - r7.c;
        if (r8 <= 0) goto L8;
        long r9 = r2 - r7.b;
        r7.d = r9 / r8;
        r7.e = ((r9 * ((long) AudioViewModel.ASR_SESSION_IDLE)) / (r0 - r7.a)) / com.bytedance.apm.util.b.f();
        goto L8
    }

    public final void j(String r7, PerfMonitorExperiment.PerfMonitorConfig r8) {
        if (this.d.get() == false) goto L5;
    L13:
        Log.w("InitBootPerfMonitorTask", "scheduleMonitor monitor too frequently, scene = " + r7 + ", hasStart=" + this.d.get());
        return;
    L5:
        if ((SystemClock.elapsedRealtime() - this.e) < 10000) goto L13;
        this.d.set(true);
        long r2 = SystemClock.elapsedRealtime();
        Log.i("InitBootPerfMonitorTask", "scheduleMonitor start monitor, scene = " + r7 + ", thread=" + ThreadMethodProxy.currentThread().getName());
        e r0 = new e(r7);
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L10;
        CoreThreadPool.getDefault().getScheduleThreadPool().execute(r0);
    L11:
        CoreThreadPool.getDefault().getScheduleThreadPool().schedule(new d(r7, this, r2), r8.getBootMonitorIntervalInMills(), TimeUnit.MILLISECONDS);
        this.e = r2;
        return;
    L10:
        r0.run();
        goto L11
    }
}
