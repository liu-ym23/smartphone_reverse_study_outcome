package esb;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Debug;
import android.os.Process;
import com.bytedance.apm.internal.ApmDelegate;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.larksuite.framework.thread.CoreThreadPool;
import com.larksuite.framework.utils.DevEnvUtil;
import com.larksuite.framework.utils.h;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.monitor.MonitorModule;
import com.ss.android.lark.monitor.callback.MemoryCallbackManager;
import com.ss.android.lark.monitor.i;
import com.ss.android.lark.monitor.memory.MemoryInfoUtil;
import com.ss.android.lark.monitor.memory.MemoryMetrics;
import com.ss.android.lark.utils.LarkContext;
import com.suite.lark.platform.component.deviceperf.DevicePerfUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b extends com.ss.android.lark.monitor.e {
    public static boolean i;
    public final ConcurrentHashMap<String, MemoryMetrics> a;
    public final ArrayList<c> b;
    public final int c;
    public ScheduledFuture<?> d;
    public ScheduledFuture<?> e;
    public long f;
    public final int g;
    public int h;

    public class a implements Runnable {
        public final /* synthetic */ b a;

        @Override // java.lang.Runnable
        public final void run() {
            b.a(this.a);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(b r1) {
            this.a = r1;
        }
    }

    /* JADX INFO: renamed from: esb.b$b, reason: collision with other inner class name */
    public class RunnableC0259b implements Runnable {
        public final /* synthetic */ b a;

        @Override // java.lang.Runnable
        public final void run() {
            b.b(this.a);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public RunnableC0259b(b r1) {
            this.a = r1;
        }
    }

    public interface c {
        void a(int r1);
    }

    public final void f() {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (this.d == null) goto L8;
        Log.i("MemoryPerfMonitor", "java mem reach top task has already started");     // Catch: Throwable -> L11
        monitor-exit(this);     // Catch: Throwable -> L11
        return;
    L8:
        this.d = CoreThreadPool.getDefault().getScheduleThreadPool().scheduleWithFixedDelay(new RunnableC0259b(this), 60, 60, TimeUnit.SECONDS);     // Catch: Throwable -> L11
        monitor-exit(this);     // Catch: Throwable -> L11
    }

    public final void g() {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (this.e == null) goto L8;
        Log.i("MemoryPerfMonitor", "memory monitor period task has already started");     // Catch: Throwable -> L11
        monitor-exit(this);     // Catch: Throwable -> L11
        return;
    L8:
        this.e = CoreThreadPool.getDefault().getScheduleThreadPool().scheduleWithFixedDelay(new a(this), 1, 8, TimeUnit.SECONDS);     // Catch: Throwable -> L11
        monitor-exit(this);     // Catch: Throwable -> L11
    }

    public final void h() {
        monitor-enter(this);
        ScheduledFuture<?> r0 = this.d;     // Catch: Throwable -> L11
        if (r0 != null) goto L8;
        Log.i("MemoryPerfMonitor", "java mem reach top task has already stoped");     // Catch: Throwable -> L11
        monitor-exit(this);     // Catch: Throwable -> L11
        return;
    L8:
        r0.cancel(true);     // Catch: Throwable -> L11
        this.d = null;     // Catch: Throwable -> L11
        monitor-exit(this);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.android.lark.monitor.e
    public final void pauseScene(String r1) {
    }

    public final boolean e() {
        if (this.h != (-1)) goto L17;
        if (DevEnvUtil.isDebugMode(LarkContext.getApplication()) == false) goto L7;
    L15:
        this.h = 0;
        goto L17
    L7:
        if (ApmDelegate.g.a.f == true) goto L9;
    L12:
        boolean r0 = true;
    L13:
        if (r0 == false) goto L15;
        this.h = 1;
        goto L17
    L9:
        if (zs3.c.a.getServiceSwitch("scene_memory_info") == true) goto L12;
        r0 = false;
    L17:
        if (this.h != 1) goto L20;
        return true;
    L20:
        return false;
    }

    public b(i r5) {
        super(r5);
        this.a = new ConcurrentHashMap();
        this.b = new ArrayList();
        this.c = (int) (Runtime.getRuntime().maxMemory() / 1048576);
        this.f = 0;
        this.g = Process.myPid();
        this.h = -1;
        f();
        g();
        r5.a.registerComponentCallbacks(new e(this, r5));
        if (iu3.a.a == null) goto L5;
    L14:
        iu3.a r6 = iu3.a.a;
        lu3.a r0 = new esb.a();
        r6.getClass();
        int r7 = iu3.d.h;
        ((CopyOnWriteArrayList) iu3.d.a.a.g).add(r0);
        return;
    L5:
        monitor-enter(iu3.a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (iu3.a.a != null) goto L9;
        iu3.a.a = new iu3.a();     // Catch: Throwable -> L11
    L9:
        monitor-exit(iu3.a.class);     // Catch: Throwable -> L11
        goto L14
    }

    public static void a(b r4) {
        Object r0 = r4.mMetricsConfig.a.getSystemService("activity");
        if (r0 != null) goto L5;
        Log.w("MemoryPerfMonitor", "context is null");
        return;
    L5:
        List<ActivityManager.RunningAppProcessInfo> r1 = ((ActivityManager) r0).getRunningAppProcesses();
        if (r1 != null) goto L8;
        Log.w("MemoryPerfMonitor", "runningAppProcesses is null");
        r4.d(r4.g, r4.mMetricsConfig.e);
        return;
    L8:
        Iterator<ActivityManager.RunningAppProcessInfo> r2 = r1.iterator();
    L10:
        if (r2.hasNext() == false) goto L21;
        ActivityManager.RunningAppProcessInfo r3 = r2.next();
        if (r3.processName.startsWith(r4.mMetricsConfig.a.getPackageName()) == false) goto L10;
        r4.d(r3.pid, r3.processName);
        goto L10
    }

    public static void b(b r7) {
        monitor-enter(r7);
        long r0 = System.currentTimeMillis();     // Catch: Throwable -> L31
        if ((r0 - r7.f) >= 5000) goto L8;
        Log.w("MemoryPerfMonitor", "Less than 5 seconds since last check!");     // Catch: Throwable -> L31
        monitor-exit(r7);     // Catch: Throwable -> L31
        return;
    L8:
        r7.f = r0;     // Catch: Throwable -> L31
        int r1 = MemoryInfoUtil.getUsedJavaHeapMB();     // Catch: Throwable -> L31
        Iterator<c> r2 = r7.b.iterator();     // Catch: Throwable -> L31
    L10:
        if (r2.hasNext() == false) goto L13;
        r2.next().a(r1);     // Catch: Throwable -> L31
        goto L10
    L13:
        float r3 = r1 / r7.c;
        MemoryCallbackManager.getInstance().notifyJavaMemoryUsedRate(r3);     // Catch: Throwable -> L16
    L18:
        double r4 = r3;
        if (r4 < 0.65d) goto L24;
        if (i == true) goto L24;
        i = true;     // Catch: Throwable -> L31
        Intent r5 = new Intent();     // Catch: Throwable -> L31
        r5.setAction("com.ss.android.lark.DUMP_HPROF");     // Catch: Throwable -> L31
        r5.setPackage(r7.mMetricsConfig.a.getPackageName());     // Catch: Throwable -> L31
        r5.putExtra("auto_upload", true);     // Catch: Throwable -> L31
        r7.mMetricsConfig.a.sendBroadcast(r5);     // Catch: Throwable -> L31
        Log.i("MemoryPerfMonitor", "usedJavaMemoryRate:" + r3 + ", auto dump hprof");     // Catch: Throwable -> L31
    L24:
        if (r4 < 0.8d) goto L29;
        MemoryMetrics r6 = r7.a.get(MonitorModule.e().d());     // Catch: Throwable -> L31
        if (r6 == null) goto L28;
        r6.reachTopCount++;     // Catch: Throwable -> L31
    L28:
        CoreThreadPool.getDefault().getCachedThreadPool().execute(new g(r7));     // Catch: Throwable -> L31
    L29:
        monitor-exit(r7);     // Catch: Throwable -> L31
        return;
    L16:
        th = move-exception;
        Log.e("MemoryPerfMonitor", "notifyJavaMemoryUsedRate error", th);     // Catch: Throwable -> L31
    L31:
        th = move-exception;
        throw th;
    }

    public static void c(MemoryMetrics r4) {
        r4.javaHeapMB = (int) ((Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 1048576);
        r4.nativeHeapMB = (int) (Debug.getNativeHeapSize() / 1048576);
        r4.maxMemMB = (int) (Runtime.getRuntime().maxMemory() / 1048576);
        r4.totalMemMB = r4.javaHeapMB + r4.nativeHeapMB;
        if (Build.VERSION.SDK_INT < 23) goto L6;
        r4.gcCount = CastIntegerProtector.parseInt(Debug.getRuntimeStat("art.gc.gc-count"));
        return;
    }

    @Override // com.ss.android.lark.monitor.d
    public final void onAppFrontStateChanged(boolean r2) {
        if (r2 == false) goto L4;
        f();
        g();
        return;
    L4:
        monitor-enter(this);
        ScheduledFuture<?> r3 = this.e;     // Catch: Throwable -> L14
        if (r3 != null) goto L10;
        Log.i("MemoryPerfMonitor", "memory monitor period task has already stoped");     // Catch: Throwable -> L14
        monitor-exit(this);     // Catch: Throwable -> L14
    L12:
        h();
        return;
    L10:
        r3.cancel(true);     // Catch: Throwable -> L14
        this.e = null;     // Catch: Throwable -> L14
        monitor-exit(this);     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.android.lark.monitor.e
    public final void startScene(String r3) {
        if (this.a.containsKey(r3) == false) goto L5;
        return;
    L5:
        MemoryMetrics r0 = new MemoryMetrics();
        c(r0);
        this.a.put(r3, r0);
    }

    public final void d(int r5, String r6) {
        Context r0 = this.mMetricsConfig.a;
        if (r0 != null) goto L6;
        Log.w("MemoryPerfMonitor", "context is null");
        return;
    L6:
        Debug.MemoryInfo[] r7 = ((ActivityManager) r0.getSystemService("activity")).getProcessMemoryInfo(new int[]{r5});
        if (r7 != null) goto L9;
    L17:
        Log.w("MemoryPerfMonitor", "processMemoryInfo is illegal");
        return;
    L9:
        if (r7.length == 0) goto L17;
        Debug.MemoryInfo r8 = r7[0];
        if (r8 != null) goto L15;
        Log.w("MemoryPerfMonitor", "memoryInfo is null");
        return;
    L15:
        Log.i("ScenePerfMonitor", "process: " + r6 + ",TotalPss:" + (r8.getTotalPss() / 1024) + "(M),NativeMem:" + (r8.nativePss / 1024) + ",JavaMem:" + (r8.dalvikPss / 1024));
    }

    @Override // com.ss.android.lark.monitor.e
    public final void stopScene(String r8, JSONObject r9) {
        String r0 = r8.split("#hash")[0];
        MemoryMetrics r10 = this.a.remove(r8);
        if (r10 != null) goto L5;
        return;
    L5:
        long r2 = System.currentTimeMillis() - r10.createTime;
        if (r2 >= 500) goto L10;
        Log.d("MemoryPerfMonitor", "scene time less than 50ms:" + r0);
        return;
    L10:
        if (DevicePerfUtils.f() == true) goto L12;
        boolean r4 = FeatureGatingModule.getFeatureGatingService().isEnable("lark.android.crash.disable_oppo_android15_explicit_gc_guard");
        int r5 = h.a;
        Intrinsics.checkNotNullParameter("monitor_stop_scene", "reason");
        h.b("monitor_stop_scene", r4, false);
    L12:
        MemoryMetrics r1 = new MemoryMetrics();
        c(r1);
        MemoryMetrics r3 = (MemoryMetrics) r1.diff(r10);
        r3.reachTopCount = r10.reachTopCount;
        Log.i("ScenePerfMonitor", "End Scene:" + r0 + ",start Meminfo:" + r10 + ", diff Meminfo: " + r3 + ", spanTime(ms): " + r2);
        if (r3.javaHeapMB >= 20) goto L15;
        return;
    L15:
        if (r3.reachTopCount >= 1) goto L17;
        return;
    L17:
        if (e() == false) goto L31;
        JSONObject r6 = new JSONObject();     // Catch: JSONException -> L24
        r6.put("scene", r0);     // Catch: JSONException -> L24
        r6.put("startJavaMem", r10.javaHeapMB);     // Catch: JSONException -> L24
        r6.put("javaMem", r3.javaHeapMB);     // Catch: JSONException -> L24
        r6.put("startNativeMem", r10.nativeHeapMB);     // Catch: JSONException -> L24
        r6.put("nativeMem", r3.nativeHeapMB);     // Catch: JSONException -> L24
        r6.put("spanTime", r2);     // Catch: JSONException -> L24
        r6.put("reachTopCount", r3.reachTopCount);     // Catch: JSONException -> L24
        if (r2 <= 1000) goto L22;
        r6.put("gcRate", r3.gcCount / (r2 / 1000.0f));     // Catch: JSONException -> L24
    L22:
        r6.put("gcCount", r3.gcCount);     // Catch: JSONException -> L24
        isb.a.a(r6, r9);     // Catch: JSONException -> L24
        isb.a.c("scene_memory_info", r6);     // Catch: JSONException -> L24
        return;
    L24:
        e = move-exception;
        e.printStackTrace();
        return;
    }
}
