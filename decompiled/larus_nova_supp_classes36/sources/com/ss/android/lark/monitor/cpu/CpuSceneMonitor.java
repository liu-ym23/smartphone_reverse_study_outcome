package com.ss.android.lark.monitor.cpu;

import com.bytedance.apm.ApmAgent;
import com.larksuite.framework.thread.CoreThreadPool;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.appcontext.applifecycle.AppLifecycle;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.monitor.MonitorModule;
import com.ss.android.lark.monitor.callback.CpuCallbackManager;
import com.ss.android.lark.monitor.e;
import com.ss.android.lark.monitor.i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class CpuSceneMonitor extends e {
    private static String TAG = "CpuSceneMonitor";
    public int cpuCoreNum;
    private int detectCount;
    private ScheduledFuture<?> mCpuDetectTask;
    private CopyOnWriteArrayList<b> mCpuPerfCallbacks;
    private float mLastCpuTime;
    private float mLastLastCpuTime;
    private long mLastLastTime;
    private long mLastTime;
    private ConcurrentHashMap<String, CpuThreadMetrics> sceneCpuMetrics;

    public class a implements Runnable {
        public final /* synthetic */ CpuSceneMonitor a;

        public final void a() {
            float r0 = CpuSceneMonitor.getCpuTimesN() / CpuSceneMonitor.getCpuTickN();
            long r2 = System.currentTimeMillis();
            int r8 = 1;
            if (CpuSceneMonitor.access$000(this.a) != 0.0f) goto L5;
        L30:
            CpuSceneMonitor r4 = this.a;
            if (r4.cpuCoreNum > 0) goto L33;
        L45:
            CpuSceneMonitor.access$212(this.a, 1);
            CpuSceneMonitor r5 = this.a;
            CpuSceneMonitor.access$302(r5, CpuSceneMonitor.access$000(r5));
            CpuSceneMonitor r6 = this.a;
            CpuSceneMonitor.access$402(r6, CpuSceneMonitor.access$100(r6));
            CpuSceneMonitor.access$102(this.a, r2);
            CpuSceneMonitor.access$002(this.a, r0);
            if (CpuSceneMonitor.access$700(this.a) == false) goto L48;
            this.a.addOneCpuDetectTask();
            return;
        L48:
            Log.i(CpuSceneMonitor.access$600(), "current is background and doze, so stop cpu detect!");
            if (CpuSceneMonitor.access$800(this.a) == null) goto L59;
            CpuSceneMonitor.access$800(this.a).cancel(true);
            CpuSceneMonitor.access$802(this.a, null);
            CpuSceneMonitor.access$102(this.a, 0);
            CpuSceneMonitor.access$002(this.a, 0.0f);
            CpuSceneMonitor.access$302(this.a, 0.0f);
            CpuSceneMonitor.access$402(this.a, 0);
            CpuSceneMonitor.access$202(this.a, 0);
            return;
        L59:
            return;
        L33:
            if ((CpuSceneMonitor.access$200(r4) % 2) != 0) goto L45;
            if (CpuSceneMonitor.access$100(this.a) == 0) goto L45;
            float r7 = ((r0 - CpuSceneMonitor.access$300(this.a)) / (((r2 - CpuSceneMonitor.access$400(this.a)) / 1000.0f) * this.a.cpuCoreNum)) * 100.0f;
            if (r7 > 0.0f) goto L39;
        L44:
            Log.w(CpuSceneMonitor.access$600(), "found CpuUsage abnormal, CpuUsage is: " + r7);
            goto L45
        L39:
            if (r7 >= 100.0f) goto L44;
            Log.i("ScenePerfMonitor", "During Scene:" + MonitorModule.e().d() + ",10s interval CpuUsage:" + r7);
            Iterator r9 = CpuSceneMonitor.access$500(this.a).iterator();
        L42:
            if (r9.hasNext() == false) goto L45;
            ((b) r9.next()).a((int) r7);
            goto L42
        L5:
            if (CpuSceneMonitor.access$100(this.a) == 0) goto L30;
            float r10 = ((r0 - CpuSceneMonitor.access$000(this.a)) / ((r2 - CpuSceneMonitor.access$100(this.a)) / 1000.0f)) * 100.0f;
            CpuCallbackManager r12 = CpuCallbackManager.a();
            r12.c = r10;
            Iterator r13 = ((CopyOnWriteArrayList) r12.a).iterator();
        L8:
            if (r13.hasNext() == false) goto L11;
            ((CpuCallbackManager.a) r13.next()).b(r10);
            goto L8
        L11:
            if (r12.c >= r12.d) goto L29;
            List<CpuCallbackManager.b> r14 = r12.b;
            monitor-enter(r14);
            Iterator r15 = ((ArrayList) r12.b).iterator();     // Catch: Throwable -> L26
            int r16 = 0;
        L16:
            if (r15.hasNext() == false) goto L24;
            r16 = r16 + r8;     // Catch: Throwable -> L26
            final CpuCallbackManager.c r11 = ((CpuCallbackManager.b) r15.next()).a;     // Catch: Throwable -> L26
            CoreThreadPool.getDefault().getFixedThreadPool().execute(new bsb.b(r11));     // Catch: Throwable -> L26
            if ((r11 instanceof CpuCallbackManager.d) == false) goto L21;
            r15.remove();     // Catch: Throwable -> L26
        L21:
            if (r16 >= r12.e) goto L24;
            r8 = 1;
        L24:
            monitor-exit(r14);     // Catch: Throwable -> L26
        L26:
            th = move-exception;
            throw th;
        L29:
            Log.i("ScenePerfMonitor", "During Scene:" + MonitorModule.e().d() + ",5s interval CpuSpeed:" + r10);
            goto L30
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

        public a(CpuSceneMonitor r1) {
            this.a = r1;
        }
    }

    public interface b {
        void a(int r1);
    }

    public static /* synthetic */ void access$001(String r0) {
        System.loadLibrary(r0);
    }

    public static native int getCpuTickN();

    public static native float getCpuTimesN();

    private void startCpuDetect() {
        monitor-enter(this);
        ScheduledFuture<?> r0 = this.mCpuDetectTask;     // Catch: Throwable -> L9
        if (r0 == null) goto L6;
        r0.cancel(true);     // Catch: Throwable -> L9
        this.mCpuDetectTask = null;     // Catch: Throwable -> L9
    L6:
        addOneCpuDetectTask();     // Catch: Throwable -> L9
        monitor-exit(this);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    private void initCpuUsageDetect() {
        INVOKESTATIC_com_ss_android_lark_monitor_cpu_CpuSceneMonitor_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary("appmonitor");
        this.isAppFront = AppLifecycle.a.a.h();
        this.cpuCoreNum = com.bytedance.apm.util.b.b();
    }

    private boolean testCanAddNextTask() {
        AppLifecycle r0 = AppLifecycle.a.a;
        if (r0.h() == true) goto L13;
        i r1 = this.mMetricsConfig;
        if (r1 != null) goto L8;
    L14:
        return false;
    L8:
        if (r1.b == null) goto L14;
        if (r0.h() == true) goto L14;
        if (this.mMetricsConfig.b.a() == true) goto L14;
    L13:
        return true;
    }

    public void addOneCpuDetectTask() {
        this.mCpuDetectTask = CoreThreadPool.getDefault().getScheduleThreadPool().schedule(new a(this), 5000, TimeUnit.MILLISECONDS);
    }

    public static /* synthetic */ String access$600() {
        return TAG;
    }

    public CpuSceneMonitor(i r4) {
        super(r4);
        this.mLastCpuTime = 0.0f;
        this.mLastTime = 0;
        this.detectCount = 0;
        this.mLastLastCpuTime = 0.0f;
        this.mLastLastTime = 0;
        this.cpuCoreNum = 0;
        this.sceneCpuMetrics = new ConcurrentHashMap();
        this.mCpuPerfCallbacks = new CopyOnWriteArrayList();
        initCpuUsageDetect();
        startCpuDetect();
    }

    @JvmStatic
    public static void INVOKESTATIC_com_ss_android_lark_monitor_cpu_CpuSceneMonitor_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary(String r4) {
        Intrinsics.checkNotNullParameter(r4, "libName");
        FLogger r0 = FLogger.a;
        r0.i("Librarian_loadLib", "loadLibrary start libName -> " + r4);
        com.bytedance.librarian.a.c(r4);
        r0.i("Librarian_loadLib", "loadLibrary success by librarian -> " + r4);
    }

    public static /* synthetic */ float access$000(CpuSceneMonitor r0) {
        return r0.mLastCpuTime;
    }

    public static /* synthetic */ long access$100(CpuSceneMonitor r2) {
        return r2.mLastTime;
    }

    public static /* synthetic */ int access$200(CpuSceneMonitor r0) {
        return r0.detectCount;
    }

    public static /* synthetic */ float access$300(CpuSceneMonitor r0) {
        return r0.mLastLastCpuTime;
    }

    public static /* synthetic */ long access$400(CpuSceneMonitor r2) {
        return r2.mLastLastTime;
    }

    public static /* synthetic */ CopyOnWriteArrayList access$500(CpuSceneMonitor r0) {
        return r0.mCpuPerfCallbacks;
    }

    public static /* synthetic */ boolean access$700(CpuSceneMonitor r0) {
        return r0.testCanAddNextTask();
    }

    public static /* synthetic */ ScheduledFuture access$800(CpuSceneMonitor r0) {
        return r0.mCpuDetectTask;
    }

    public void addCpuPerfCallback(b r2) {
        this.mCpuPerfCallbacks.add(r2);
    }

    @Override // com.ss.android.lark.monitor.d
    public void onAppFrontStateChanged(boolean r1) {
        if (r1 == false) goto L4;
        startCpuDetect();
    L4:
        this.isAppFront = r1;
    }

    @Override // com.ss.android.lark.monitor.e
    public void pauseScene(String r6) {
        String r0 = r6.split("#hash")[0];
        st3.a.b().d(r0);
        ApmAgent.stopCpuMonitor(r0);
        CpuThreadMetrics r7 = this.sceneCpuMetrics.get(r6);
        if (r7 != null) goto L5;
        return;
    L5:
        float r1 = (System.currentTimeMillis() - r7.createTime) / 1000.0f;
        float r2 = getCpuTimesN() - r7.cpuTimes;
        r7.mSceneAccumulateTime += r1;
        r7.mSceneAccumulateCpuTime += r2;
        Log.i("ScenePerfMonitor", "Pause Scene:" + r0 + " CpuSpeed:" + (r2 / r1) + " Span:" + r1);
    }

    @Override // com.ss.android.lark.monitor.e
    public void startScene(String r5) {
        String r0 = r5.split("#hash")[0];
        CpuThreadMetrics r1 = this.sceneCpuMetrics.get(r5);
        if (r1 != null) goto L5;
        r1 = new CpuThreadMetrics();
        this.sceneCpuMetrics.put(r5, r1);
    L5:
        st3.a.b().c(r0);
        ApmAgent.startCpuMonitor(r0);
        r1.cpuTimes = getCpuTimesN();
        r1.createTime = System.currentTimeMillis();
    }

    public static /* synthetic */ float access$002(CpuSceneMonitor r0, float r1) {
        r0.mLastCpuTime = r1;
        return r1;
    }

    public static /* synthetic */ long access$102(CpuSceneMonitor r0, long r1) {
        r0.mLastTime = r1;
        return r1;
    }

    public static /* synthetic */ int access$202(CpuSceneMonitor r0, int r1) {
        r0.detectCount = r1;
        return r1;
    }

    public static /* synthetic */ int access$212(CpuSceneMonitor r1, int r2) {
        int r0 = r1.detectCount + r2;
        r1.detectCount = r0;
        return r0;
    }

    public static /* synthetic */ float access$302(CpuSceneMonitor r0, float r1) {
        r0.mLastLastCpuTime = r1;
        return r1;
    }

    public static /* synthetic */ long access$402(CpuSceneMonitor r0, long r1) {
        r0.mLastLastTime = r1;
        return r1;
    }

    public static /* synthetic */ ScheduledFuture access$802(CpuSceneMonitor r0, ScheduledFuture r1) {
        r0.mCpuDetectTask = r1;
        return r1;
    }

    @Override // com.ss.android.lark.monitor.e
    public void stopScene(String r6, JSONObject r7) {
        String r0 = r6.split("#hash")[0];
        CpuThreadMetrics r8 = this.sceneCpuMetrics.remove(r6);
        if (r8 != null) goto L6;
        return;
    L6:
        if (r8.mSceneAccumulateTime != 0.0f) goto L8;
        st3.a.b().d(r0);
        ApmAgent.stopCpuMonitor(r0);
        float r1 = (System.currentTimeMillis() - r8.createTime) / 1000.0f;
        float r2 = getCpuTimesN() - r8.cpuTimes;
        r8.mSceneAccumulateTime = r1;
        r8.mSceneAccumulateCpuTime = r2;
    L8:
        float r3 = r8.mSceneAccumulateCpuTime / (r8.mSceneAccumulateTime * getCpuTickN());
        Log.i("ScenePerfMonitor", "End Scene:" + r0 + " CpuSpeed:" + r3 + " Span(s):" + r8.mSceneAccumulateTime);
        if (r8.mSceneAccumulateTime >= 5.0f) goto L16;
        return;
    L16:
        JSONObject r4 = new JSONObject();     // Catch: JSONException -> L13
        r4.put("scene", r0);     // Catch: JSONException -> L13
        r4.put("cupSpeed", r3);     // Catch: JSONException -> L13
        r4.put("span", r8.mSceneAccumulateTime);     // Catch: JSONException -> L13
        isb.a.a(r4, r7);     // Catch: JSONException -> L13
        isb.a.c("scene_cpu_info", r4);     // Catch: JSONException -> L13
        return;
    L13:
        e = move-exception;
        e.printStackTrace();
    }
}
