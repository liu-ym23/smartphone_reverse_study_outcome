package com.bytedance.apm6.cpu.collect;

import android.content.Context;
import android.os.Process;
import com.bytedance.apm.e.a;
import com.bytedance.apm.util.b;
import com.bytedance.apm.util.m;
import com.bytedance.apm6.cpu.ApmCpuManager;
import com.bytedance.apm6.cpu.Constants;
import com.bytedance.apm6.cpu.config.CpuConfig;
import com.bytedance.apm6.cpu.exception.ThreadCpuExceptionUtils;
import com.bytedance.apm6.cpu.exception.ThreadExceptionItem;
import com.bytedance.apm6.cpu.service.CurrentCpuDataHolder;
import com.bytedance.apm6.monitor.Monitor;
import com.bytedance.apm6.perf.base.PerfFilterManager;
import com.bytedance.apm6.service.lifecycle.DummyLifecycleListener;
import com.bytedance.apm6.service.perf.ICpuDataService;
import com.bytedance.apm6.util.log.Logger;
import com.bytedance.apm6.util.timetask.AsyncTask;
import com.bytedance.apm6.util.timetask.AsyncTaskManager;
import com.bytedance.apm6.util.timetask.AsyncTaskManagerType;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.monitor.collector.k;
import com.bytedance.watson.assist.a.c;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
class CpuDataCollector extends DummyLifecycleListener {
    private static final long POLL_INTERVAL = 30000;
    private static final String TAG = "MonitorCpu";
    private c assistStat;
    private CpuConfig cpuConfig;
    private boolean isFirstCollect;
    private CpuDataAssembler mAssembler;
    private AsyncTask mCollectAsyncTask;
    private long mCollectInterval;
    private long mCollectThreadInterval;
    private AtomicBoolean mIsStart;
    private long mLastThreadWorkTimestamp;
    private long mLastWorkTimestamp;

    CpuDataCollector(CpuDataAssembler r3, c r4) {
        c r5 = (c) ZeusTransformUtils.wrapperContextForParams(r4, c.class, "com.obric.memorydata.plugin");
        this.isFirstCollect = true;
        this.mIsStart = new AtomicBoolean(false);
        this.mAssembler = r3;
        this.assistStat = r5;
    }

    static /* synthetic */ long access$000(CpuDataCollector r2) {
        return r2.mCollectInterval;
    }

    static /* synthetic */ void access$100(CpuDataCollector r0, boolean r1) {
        r0.refreshConfig(r1);
    }

    static /* synthetic */ boolean access$200(CpuDataCollector r0) {
        return r0.isFirstCollect;
    }

    static /* synthetic */ boolean access$202(CpuDataCollector r0, boolean r1) {
        r0.isFirstCollect = r1;
        return r1;
    }

    static /* synthetic */ void access$300(CpuDataCollector r0) {
        r0.doCollectProcess();
    }

    static /* synthetic */ void access$400(CpuDataCollector r0) {
        r0.doCollectThread();
    }

    private void doCollectProcess() {
        long r1 = System.currentTimeMillis();
        if ((r1 - this.mLastWorkTimestamp) >= this.mCollectInterval) goto L5;
        return;
    L5:
        this.mLastWorkTimestamp = r1;
        int r3 = b.c();
        if (r3 > 0) goto L8;
        return;
    L8:
        long r4 = k.a().m();
        long r6 = k.a().b(r3);
        boolean r8 = false;
        Thread.sleep(360);     // Catch: InterruptedException -> L11
    L12:
        if (r8 == false) goto L14;
        return;
    L14:
        long r9 = k.a().m();
        double r12 = -1.0d;
        long r10 = k.a().b(r3) - r6;
        if (r10 <= 0) goto L17;
        r12 = (r9 - r4) / r10;
        a.c(TAG, "appCpuRate -> " + r12);
    L17:
        double r7 = (r9 - r4) * 1000.0d;
        double r5 = (r7 / (System.currentTimeMillis() - r1)) / b.a(100);
        if (com.bytedance.apm.b.k() == false) goto L21;
        Logger.d(Constants.TAG, String.valueOf(r7) + " " + (System.currentTimeMillis() - r1) + " " + b.a(100));
    L21:
        if (com.bytedance.apm.b.k() == false) goto L23;
        a.c(TAG, "appCpuSpeed -> " + r5);
        Logger.d(Constants.TAG, "collect cpu data, rate: " + r12 + " speed: " + r5);
    L23:
        c.a r2 = null;
        this.assistStat.g();     // Catch: Throwable -> L32
        r2 = this.assistStat.j();     // Catch: Throwable -> L32
    L26:
        if (this.mAssembler.isStart() == false) goto L28;
        this.mAssembler.addCacheData(r12, r5);
        this.mAssembler.triggerAssemble(r2);
    L28:
        CurrentCpuDataHolder.getInstance().refreshData(r12, r5);
        ApmCpuManager.ICpuDataListener r14 = CpuCollectManager.getInstance().getDataListener();
        if (r14 == null) goto L37;
        r14.onCpuData(r5, r12, PerfFilterManager.getInstance().getSceneString(), r2, NetworkUtils.c((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.bytedance.apm.b.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")));
        return;
    L37:
        return;
    L11:
        r8 = true;
        goto L12
    }

    private void doCollectThread() {
        long r0 = System.currentTimeMillis();
        if ((r0 - this.mLastThreadWorkTimestamp) >= this.mCollectThreadInterval) goto L5;
        return;
    L5:
        this.mLastThreadWorkTimestamp = r0;
        HashMap r6 = new HashMap();
        HashMap r7 = new HashMap();
        boolean r1 = false;
        ThreadCpuExceptionUtils.getThreadInfo(Process.myPid(), r6);
        Thread.sleep(100);     // Catch: InterruptedException -> L8
    L10:
        if (r1 == false) goto L12;
        return;
    L12:
        ThreadCpuExceptionUtils.getThreadInfo(Process.myPid(), r7);
        c.a r2 = null;
        r2 = this.assistStat.j();     // Catch: Exception -> L16
    L14:
        doCollectThreadAndReport(0, r6, r7, r2);
        return;
    L8:
        e = move-exception;
        Logger.e(Constants.TAG, "InterruptedException", e);
        r1 = true;
        goto L10
    }

    private void doCollectThreadAndReport(long r18, Map<Integer, ThreadExceptionItem> r20, Map<Integer, ThreadExceptionItem> r21, c.a r22) {
        Map r3 = (Map) ZeusTransformUtils.wrapperContextForParams(r20, Map.class, "com.obric.memorydata.plugin");
        Map r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r21, Map.class, "com.obric.memorydata.plugin");
        if (r3.isEmpty() == false) goto L5;
        return;
    L5:
        if (r5.isEmpty() == true) goto L62;
        LinkedList r6 = new LinkedList();
        LinkedList<ICpuDataService.ThreadCpuItem> r7 = new LinkedList();
        Iterator r4 = r3.entrySet().iterator();
    L9:
        if (r4.hasNext() == false) goto L29;
        Map.Entry r8 = (Map.Entry) ZeusTransformUtils.preCheckCast(r4.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        ThreadExceptionItem r9 = (ThreadExceptionItem) ZeusTransformUtils.preCheckCast(r8.getValue(), ThreadExceptionItem.class, "com.obric.memorydata.plugin");
        if (r9 == null) goto L9;
        ThreadExceptionItem r10 = (ThreadExceptionItem) ZeusTransformUtils.preCheckCast(r5.get(r8.getKey()), ThreadExceptionItem.class, "com.obric.memorydata.plugin");
        if (r10 == null) goto L9;
        if (r10.getThreadName().equals(r9.getThreadName()) == false) goto L9;
        long r11 = r10.getThreadCpuTime() - r9.getThreadCpuTime();
        if (r11 == 0) goto L9;
        Logger.d(Constants.TAG, "cpu_thread=" + r10.getThreadName() + " thread_time=" + r11 + " app_time=" + r18);
        if (r18 == 0) goto L24;
        double r12 = r11 / r18;
        if (r12 <= 9.0E-4d) goto L9;
        r6.add(new m(r10.getThreadName(), Double.valueOf(String.format("%.3f", new Object[]{Double.valueOf(r12)}))));
        r7.add(new ICpuDataService.ThreadCpuItem(r10.getThreadName(), Double.valueOf(String.format("%.3f", new Object[]{Double.valueOf(r12)})).doubleValue(), r10.getThreadId()));
        goto L9
    L24:
        double r13 = r11;
        r6.add(new m(r10.getThreadName(), Double.valueOf(r13)));
        r7.add(new ICpuDataService.ThreadCpuItem(r10.getThreadName(), r13, r10.getThreadId()));
        goto L9
    L29:
        if (r6.isEmpty() == false) goto L31;
        return;
    L31:
        Collections.sort(r7, new AnonymousClass2(this));
        CurrentCpuDataHolder.getInstance().refreshTopThreadData(r7);
        if (this.cpuConfig.isEnableUpload() == true) goto L34;
        return;
    L34:
        if (CpuCollectManager.getInstance().isFront() == false) goto L36;
        CpuCacheItem.CpuDataType r1 = CpuCacheItem.CpuDataType.FRONT;
    L37:
        CpuReportEvent r2 = new CpuReportEvent(r1, PerfFilterManager.getInstance().getSceneString(), r6, r22);
        r2.setBatteryCurrent(com.ss.thor.c.b((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.bytedance.apm.b.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")));
        r2.setNormalSampleState(this.assistStat.i());     // Catch: Throwable -> L41
    L39:
        Monitor.record(r2);
        return;
    L36:
        r1 = CpuCacheItem.CpuDataType.BACK;
        goto L37
    }

    private void initAsyncTask() {
        if (this.mCollectAsyncTask != null) goto L6;
        final long r3 = POLL_INTERVAL;
        final long r5 = POLL_INTERVAL;
        this.mCollectAsyncTask = new AnonymousClass1(this, r3, r5);
        return;
    }

    private void refreshConfig(boolean r3) {
        CpuConfig r0 = this.cpuConfig;
        if (r3 == false) goto L5;
        long r1 = r0.getFrontCollectInterval();
    L6:
        this.mCollectInterval = r1;
        if (r3 == false) goto L9;
        long r2 = this.cpuConfig.getFrontThreadCollectInterval();
    L10:
        this.mCollectThreadInterval = r2;
        return;
    L9:
        r2 = this.cpuConfig.getBackThreadCollectInterval();
        goto L10
    L5:
        r1 = r0.getBackCollectInterval();
        goto L6
    }

    void resume() {
        if (this.mIsStart.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        initAsyncTask();
        if (this.mCollectAsyncTask == null) goto L11;
        AsyncTaskManager.getInstance(AsyncTaskManagerType.CPU).sendTask(this.mCollectAsyncTask);
    L11:
        this.assistStat.b();     // Catch: Throwable -> L10
        return;
    }

    void start(CpuConfig r4) {
        if (this.mIsStart.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        this.cpuConfig = r4;
        initAsyncTask();
        if (this.mCollectAsyncTask == null) goto L11;
        AsyncTaskManager.getInstance(AsyncTaskManagerType.CPU).sendTask(this.mCollectAsyncTask);
    L11:
        this.assistStat.b();     // Catch: Throwable -> L10
        return;
    }

    void stop() {
        if (this.mIsStart.compareAndSet(true, false) == true) goto L5;
        return;
    L5:
        if (this.mCollectAsyncTask == null) goto L14;
        AsyncTaskManager.getInstance(AsyncTaskManagerType.CPU).removeTask(this.mCollectAsyncTask);
        this.assistStat.c();     // Catch: Throwable -> L10
        return;
    L15:
        return;
    }
}
