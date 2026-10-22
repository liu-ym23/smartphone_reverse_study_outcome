package com.bytedance.apm6.cpu.collect;

import android.os.Process;
import com.bytedance.apm.d;
import com.bytedance.apm.util.b;
import com.bytedance.apm.util.o;
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
import e0.a;
import g5.c;
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

    CpuDataCollector(CpuDataAssembler r10, c r11) {
        this.isFirstCollect = true;
        this.mIsStart = new AtomicBoolean(false);
        this.mAssembler = r10;
        this.assistStat = r11;
    }

    static /* synthetic */ long access$000(CpuDataCollector r10) {
        return r10.mCollectInterval;
    }

    static /* synthetic */ void access$100(CpuDataCollector r10, boolean r11) {
        r10.refreshConfig(r11);
    }

    static /* synthetic */ boolean access$200(CpuDataCollector r10) {
        return r10.isFirstCollect;
    }

    static /* synthetic */ boolean access$202(CpuDataCollector r10, boolean r11) {
        r10.isFirstCollect = r11;
        return r11;
    }

    static /* synthetic */ void access$300(CpuDataCollector r10) {
        r10.doCollectProcess();
    }

    static /* synthetic */ void access$400(CpuDataCollector r10) {
        r10.doCollectThread();
    }

    private void doCollectProcess() {
        long r10 = System.currentTimeMillis();
        if ((r10 - this.mLastWorkTimestamp) >= this.mCollectInterval) goto L5;
        return;
    L5:
        this.mLastWorkTimestamp = r10;
        int r11 = b.d();
        if (r11 > 0) goto L8;
        return;
    L8:
        long r12 = k.n().c();
        long r13 = k.n().k(r11);
        boolean r14 = false;
        Thread.sleep(360);     // Catch: InterruptedException -> L11
    L12:
        if (r14 == false) goto L14;
        return;
    L14:
        long r15 = k.n().c();
        double r16 = -1.0d;
        long r17 = k.n().k(r11) - r13;
        if (r17 <= 0) goto L17;
        r16 = (r15 - r12) / r17;
        a.b(TAG, "appCpuRate -> " + r16);
    L17:
        double r18 = (r15 - r12) * 1000.0d;
        double r19 = (r18 / (System.currentTimeMillis() - r10)) / b.k(100);
        if (d.D() == false) goto L21;
        Logger.d(Constants.TAG, String.valueOf(r18) + " " + (System.currentTimeMillis() - r10) + " " + b.k(100));
    L21:
        if (d.D() == false) goto L23;
        a.b(TAG, "appCpuSpeed -> " + r19);
        Logger.d(Constants.TAG, "collect cpu data, rate: " + r16 + " speed: " + r19);
    L23:
        c.a r20 = null;
        this.assistStat.h();     // Catch: Throwable -> L32
        r20 = this.assistStat.f();     // Catch: Throwable -> L32
    L26:
        if (this.mAssembler.isStart() == false) goto L28;
        this.mAssembler.addCacheData(r16, r19);
        this.mAssembler.triggerAssemble(r20);
    L28:
        CurrentCpuDataHolder.getInstance().refreshData(r16, r19);
        ApmCpuManager.ICpuDataListener r110 = CpuCollectManager.getInstance().getDataListener();
        if (r110 == null) goto L37;
        r110.onCpuData(r19, r16, PerfFilterManager.getInstance().getSceneString(), r20, NetworkUtils.f(d.g()));
        return;
    L37:
        return;
    L11:
        r14 = true;
        goto L12
    }

    private void doCollectThread() {
        long r10 = System.currentTimeMillis();
        if ((r10 - this.mLastThreadWorkTimestamp) >= this.mCollectThreadInterval) goto L5;
        return;
    L5:
        this.mLastThreadWorkTimestamp = r10;
        HashMap r11 = new HashMap();
        HashMap r12 = new HashMap();
        boolean r13 = false;
        ThreadCpuExceptionUtils.getThreadInfo(Process.myPid(), r11);
        Thread.sleep(100);     // Catch: InterruptedException -> L8
    L10:
        if (r13 == false) goto L12;
        return;
    L12:
        ThreadCpuExceptionUtils.getThreadInfo(Process.myPid(), r12);
        c.a r14 = null;
        r14 = this.assistStat.f();     // Catch: Exception -> L16
    L14:
        doCollectThreadAndReport(0, r11, r12, r14);
        return;
    L8:
        e = move-exception;
        Logger.e(Constants.TAG, "InterruptedException", e);
        r13 = true;
        goto L10
    }

    private void doCollectThreadAndReport(long r17, Map<Integer, ThreadExceptionItem> r19, Map<Integer, ThreadExceptionItem> r20, c.a r21) {
        if (r19.isEmpty() == false) goto L5;
        return;
    L5:
        if (r20.isEmpty() == true) goto L61;
        LinkedList r10 = new LinkedList();
        LinkedList<ICpuDataService.ThreadCpuItem> r11 = new LinkedList();
        Iterator<Map.Entry<Integer, ThreadExceptionItem>> r12 = r19.entrySet().iterator();
    L9:
        if (r12.hasNext() == false) goto L30;
        Map.Entry<Integer, ThreadExceptionItem> r13 = r12.next();
        ThreadExceptionItem r14 = r13.getValue();
        if (r14 == null) goto L9;
        ThreadExceptionItem r15 = r20.get(r13.getKey());
        if (r15 == null) goto L9;
        if (r15.getThreadName().equals(r14.getThreadName()) == false) goto L9;
        long r16 = r15.getThreadCpuTime() - r14.getThreadCpuTime();
        if (r16 == 0) goto L9;
        Logger.d(Constants.TAG, "cpu_thread=" + r15.getThreadName() + " thread_time=" + r16 + " app_time=" + r17);
        if (r17 == 0) goto L24;
        double r18 = r16 / r17;
        if (r18 <= 9.0E-4d) goto L9;
        r10.add(new o(r15.getThreadName(), Double.valueOf(String.format("%.3f", new Object[]{Double.valueOf(r18)}))));
        ICpuDataService.ThreadCpuItem r22 = new ICpuDataService.ThreadCpuItem(r15.getThreadName(), Double.valueOf(String.format("%.3f", new Object[]{Double.valueOf(r18)})).doubleValue(), r15.getThreadId());
    L25:
        r11.add(r22);
        goto L9
    L24:
        double r23 = r16;
        r10.add(new o(r15.getThreadName(), Double.valueOf(r23)));
        r22 = new ICpuDataService.ThreadCpuItem(r15.getThreadName(), r23, r15.getThreadId());
        goto L25
    L30:
        if (r10.isEmpty() == false) goto L32;
        return;
    L32:
        Collections.sort(r11, new AnonymousClass2(this));
        CurrentCpuDataHolder.getInstance().refreshTopThreadData(r11);
        if (this.cpuConfig.isEnableUpload() == true) goto L35;
        return;
    L35:
        if (CpuCollectManager.getInstance().isFront() == false) goto L37;
        CpuCacheItem.CpuDataType r24 = CpuCacheItem.CpuDataType.FRONT;
    L38:
        CpuReportEvent r25 = new CpuReportEvent(r24, PerfFilterManager.getInstance().getSceneString(), r10, r21);
        r25.setBatteryCurrent(ub.c.b(d.g()));
        r25.setNormalSampleState(this.assistStat.i());     // Catch: Throwable -> L42
    L40:
        Monitor.record(r25);
        return;
    L37:
        r24 = CpuCacheItem.CpuDataType.BACK;
        goto L38
    }

    private void initAsyncTask() {
        if (this.mCollectAsyncTask != null) goto L6;
        final long r10 = 30000;
        final long r11 = 30000;
        this.mCollectAsyncTask = new AnonymousClass1(this, r10, r11);
        return;
    }

    private void refreshConfig(boolean r10) {
        CpuConfig r11 = this.cpuConfig;
        if (r10 == false) goto L5;
        long r12 = r11.getFrontCollectInterval();
    L6:
        this.mCollectInterval = r12;
        if (r10 == false) goto L9;
        long r13 = this.cpuConfig.getFrontThreadCollectInterval();
    L10:
        this.mCollectThreadInterval = r13;
        return;
    L9:
        r13 = this.cpuConfig.getBackThreadCollectInterval();
        goto L10
    L5:
        r12 = r11.getBackCollectInterval();
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
        this.assistStat.start();     // Catch: Throwable -> L10
        return;
    }

    void start(CpuConfig r10) {
        if (this.mIsStart.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        this.cpuConfig = r10;
        initAsyncTask();
        if (this.mCollectAsyncTask == null) goto L11;
        AsyncTaskManager.getInstance(AsyncTaskManagerType.CPU).sendTask(this.mCollectAsyncTask);
    L11:
        this.assistStat.start();     // Catch: Throwable -> L10
        return;
    }

    void stop() {
        if (this.mIsStart.compareAndSet(true, false) == true) goto L5;
        return;
    L5:
        if (this.mCollectAsyncTask == null) goto L14;
        AsyncTaskManager.getInstance(AsyncTaskManagerType.CPU).removeTask(this.mCollectAsyncTask);
        this.assistStat.a();     // Catch: Throwable -> L10
        return;
    L15:
        return;
    }
}
