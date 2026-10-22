package com.bytedance.apm6.cpu.collect;

import com.bytedance.apm6.cpu.Constants;
import com.bytedance.apm6.cpu.config.CpuConfig;
import com.bytedance.apm6.monitor.Monitor;
import com.bytedance.apm6.perf.base.PerfFilterManager;
import com.bytedance.apm6.service.lifecycle.DummyLifecycleListener;
import com.bytedance.apm6.util.ApmBaseContext;
import com.bytedance.apm6.util.log.Logger;
import g5.c;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
class CpuDataAssembler extends DummyLifecycleListener {
    private c assistStat;
    private CpuConfig mConfig;
    private AtomicBoolean mIsStart;
    private HashMap<String, CpuCacheItem> mTimerInfoBack;
    private HashMap<String, CpuCacheItem> mTimerInfoFore;
    private HashMap<String, CpuCacheItem> mTimerInfoMix;

    /* JADX INFO: renamed from: com.bytedance.apm6.cpu.collect.CpuDataAssembler$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$bytedance$apm6$cpu$collect$CpuCacheItem$CpuDataType = null;

        static {
            int[] r10 = new int[CpuCacheItem.CpuDataType.values().length];
            $SwitchMap$com$bytedance$apm6$cpu$collect$CpuCacheItem$CpuDataType = r10;
            r10[CpuCacheItem.CpuDataType.MIX.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            $SwitchMap$com$bytedance$apm6$cpu$collect$CpuCacheItem$CpuDataType[CpuCacheItem.CpuDataType.BACK.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$com$bytedance$apm6$cpu$collect$CpuCacheItem$CpuDataType[CpuCacheItem.CpuDataType.FRONT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    CpuDataAssembler(c r10) {
        this.mIsStart = new AtomicBoolean(false);
        this.assistStat = r10;
    }

    private void addCacheItem(CpuCacheItem.CpuDataType r10, String r11, CpuCacheItem r12) {
        int r13 = AnonymousClass1.$SwitchMap$com$bytedance$apm6$cpu$collect$CpuCacheItem$CpuDataType[r10.ordinal()];
        if (r13 != 1) goto L5;
        HashMap<String, CpuCacheItem> r14 = this.mTimerInfoMix;
    L12:
        r14.put(r11, r12);
        return;
    L5:
        if (r13 != 2) goto L7;
        r14 = this.mTimerInfoBack;
        goto L12
    L7:
        if (r13 != 3) goto L14;
        r14 = this.mTimerInfoFore;
        goto L12
    }

    private void doAssemble(CpuCacheItem.CpuDataType r17, c.a r18) {
        long r13 = System.currentTimeMillis();
        int r10 = AnonymousClass1.$SwitchMap$com$bytedance$apm6$cpu$collect$CpuCacheItem$CpuDataType[r17.ordinal()];
        if (r10 != 1) goto L5;
        HashMap<String, CpuCacheItem> r11 = this.mTimerInfoMix;
    L13:
        Iterator<Map.Entry<String, CpuCacheItem>> r12 = r11.entrySet().iterator();
    L9:
        Iterator<Map.Entry<String, CpuCacheItem>> r15 = r12;
        if (r15 != null) goto L17;
        return;
    L17:
        if (r15.hasNext() == false) goto L25;
        CpuCacheItem r14 = r15.next().getValue();
        if ((r13 - r14.getFirstTs()) <= this.mConfig.getMonitorInterval()) goto L17;
        r15.remove();
        double r16 = r14.getMetricRate() / ((double) r14.getTimes());
        double r19 = r14.getMetricMaxRate();
        double r20 = r14.getMetricCpuSpeed() / ((double) r14.getTimes());
        double r21 = r14.getMetricMaxCpuSpeed();
        if (ApmBaseContext.isDebugMode() == false) goto L24;
        Logger.d(Constants.TAG, "cpu cache item: " + r14);
        Logger.d(Constants.TAG, "assemble cpu data, type: " + r17 + " rate: " + r16 + " maxRate: " + r19 + " speed: " + r20 + " maxSpeed: " + r21);
    L24:
        doReport(r17, r14.getSceneString(), r16, r19, r20, r21, r18);
        goto L17
    L25:
        return;
    L5:
        if (r10 != 2) goto L7;
        r11 = this.mTimerInfoBack;
        goto L13
    L7:
        if (r10 == 3) goto L10;
        r12 = null;
        goto L9
    L10:
        r11 = this.mTimerInfoFore;
        goto L13
    }

    private void doReport(CpuCacheItem.CpuDataType r14, String r15, double r16, double r18, double r20, double r22, c.a r24) {
        CpuReportEvent r12 = new CpuReportEvent(r14, r15, r16, r18, r20, r22, r24);
        r12.setBatteryCurrent(ub.c.b(ApmBaseContext.getContext()));
        r12.setNormalSampleState(this.assistStat.i());     // Catch: Throwable -> L6
    L4:
        Monitor.record(r12);
    }

    private CpuCacheItem getCacheItem(CpuCacheItem.CpuDataType r10, String r11) {
        int r12 = AnonymousClass1.$SwitchMap$com$bytedance$apm6$cpu$collect$CpuCacheItem$CpuDataType[r10.ordinal()];
        if (r12 != 1) goto L5;
        HashMap<String, CpuCacheItem> r13 = this.mTimerInfoMix;
    L12:
        return r13.get(r11);
    L5:
        if (r12 != 2) goto L7;
        r13 = this.mTimerInfoBack;
        goto L12
    L7:
        if (r12 == 3) goto L10;
        return null;
    L10:
        r13 = this.mTimerInfoFore;
        goto L12
    }

    private static CpuCacheItem refreshCpuCacheItem(CpuCacheItem.CpuDataType r10, CpuCacheItem r11, double r12, double r13) {
        if (r11 != null) goto L5;
        r11 = new CpuCacheItem(r10, System.currentTimeMillis());
        r11.injectScene(PerfFilterManager.getInstance().getSceneString());
    L5:
        if (r12 < 0.0d) goto L7;
    L8:
        r11.addTimes();
    L9:
        r11.addSpeed(r13);
        r11.addRate(r12);
        r11.refreshMaxRate(r12);
        r11.refreshMaxSpeed(r13);
        return r11;
    L7:
        if (r13 < 0.0d) goto L9;
        goto L8
    }

    void addCacheData(double r10, double r12) {
        if (this.mIsStart.get() == true) goto L5;
        return;
    L5:
        String r11 = PerfFilterManager.getInstance().getSceneString();
        if (ApmBaseContext.isDebugMode() == false) goto L9;
        Logger.d(Constants.TAG, r11);
    L9:
        monitor-enter(CpuDataAssembler.class);
    L20:
        th = move-exception;
        throw th;
    L11:
        if (CpuCollectManager.getInstance().isFront() == false) goto L13;
        CpuCacheItem.CpuDataType r13 = CpuCacheItem.CpuDataType.FRONT;     // Catch: Throwable -> L20
    L14:
        CpuCacheItem r14 = refreshCpuCacheItem(r13, getCacheItem(r13, r11), r10, r12);     // Catch: Throwable -> L20
        addCacheItem(r13, r11, r14);     // Catch: Throwable -> L20
        if (ApmBaseContext.isDebugMode() == false) goto L17;
        Logger.d(Constants.TAG, "after add cache data: " + r14);     // Catch: Throwable -> L20
    L17:
        CpuCacheItem.CpuDataType r15 = CpuCacheItem.CpuDataType.MIX;     // Catch: Throwable -> L20
        addCacheItem(r15, r11, refreshCpuCacheItem(r15, getCacheItem(r15, r11), r10, r12));     // Catch: Throwable -> L20
        monitor-exit(CpuDataAssembler.class);     // Catch: Throwable -> L20
        return;
    L13:
        r13 = CpuCacheItem.CpuDataType.BACK;     // Catch: Throwable -> L20
        goto L14
    }

    boolean isStart() {
        return this.mIsStart.get();
    }

    void resume() {
        if (this.mIsStart.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        this.mTimerInfoMix = new HashMap();
        this.mTimerInfoFore = new HashMap();
        this.mTimerInfoBack = new HashMap();
    }

    void start(CpuConfig r10) {
        if (this.mIsStart.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        this.mTimerInfoMix = new HashMap();
        this.mTimerInfoFore = new HashMap();
        this.mTimerInfoBack = new HashMap();
        this.mConfig = r10;
    }

    void stop() {
        if (this.mIsStart.compareAndSet(true, false) == true) goto L6;
        return;
    L6:
        monitor-enter(CpuDataAssembler.class);
        this.mTimerInfoFore.clear();     // Catch: Throwable -> L10
        this.mTimerInfoBack.clear();     // Catch: Throwable -> L10
        this.mTimerInfoMix.clear();     // Catch: Throwable -> L10
        monitor-exit(CpuDataAssembler.class);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public void triggerAssemble(c.a r10) {
        if (this.mIsStart.get() == true) goto L6;
        return;
    L6:
        monitor-enter(CpuDataAssembler.class);
        doAssemble(CpuCacheItem.CpuDataType.FRONT, r10);     // Catch: Throwable -> L10
        doAssemble(CpuCacheItem.CpuDataType.BACK, r10);     // Catch: Throwable -> L10
        doAssemble(CpuCacheItem.CpuDataType.MIX, r10);     // Catch: Throwable -> L10
        monitor-exit(CpuDataAssembler.class);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }
}
