package com.bytedance.apm6.cpu.collect;

import android.app.Application;
import com.bytedance.apm6.cpu.Constants;
import com.bytedance.apm6.cpu.config.CpuConfig;
import com.bytedance.apm6.foundation.context.ApmContext;
import com.bytedance.apm6.monitor.Monitor;
import com.bytedance.apm6.perf.base.PerfFilterManager;
import com.bytedance.apm6.service.lifecycle.DummyLifecycleListener;
import com.bytedance.apm6.util.log.Logger;
import com.bytedance.watson.assist.a.c;
import com.volcengine.zeus.transform.ZeusTransformUtils;
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
            int[] r0 = new int[CpuCacheItem.CpuDataType.values().length];
            $SwitchMap$com$bytedance$apm6$cpu$collect$CpuCacheItem$CpuDataType = r0;
            r0[CpuCacheItem.CpuDataType.MIX.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            $SwitchMap$com$bytedance$apm6$cpu$collect$CpuCacheItem$CpuDataType[CpuCacheItem.CpuDataType.BACK.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$com$bytedance$apm6$cpu$collect$CpuCacheItem$CpuDataType[CpuCacheItem.CpuDataType.FRONT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    CpuDataAssembler(c r3) {
        c r4 = (c) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.memorydata.plugin");
        this.mIsStart = new AtomicBoolean(false);
        this.assistStat = r4;
    }

    private void addCacheItem(CpuCacheItem.CpuDataType r2, String r3, CpuCacheItem r4) {
        int r5 = AnonymousClass1.$SwitchMap$com$bytedance$apm6$cpu$collect$CpuCacheItem$CpuDataType[r2.ordinal()];
        if (r5 != 1) goto L5;
        HashMap<String, CpuCacheItem> r1 = this.mTimerInfoMix;
    L12:
        r1.put(r3, r4);
        return;
    L5:
        if (r5 != 2) goto L7;
        r1 = this.mTimerInfoBack;
        goto L12
    L7:
        if (r5 != 3) goto L14;
        r1 = this.mTimerInfoFore;
        goto L12
    }

    private void doAssemble(CpuCacheItem.CpuDataType r17, c.a r18) {
        long r13 = System.currentTimeMillis();
        int r0 = AnonymousClass1.$SwitchMap$com$bytedance$apm6$cpu$collect$CpuCacheItem$CpuDataType[r17.ordinal()];
        if (r0 != 1) goto L5;
        HashMap<String, CpuCacheItem> r1 = this.mTimerInfoMix;
    L13:
        Iterator<Map.Entry<String, CpuCacheItem>> r2 = r1.entrySet().iterator();
    L9:
        Iterator<Map.Entry<String, CpuCacheItem>> r15 = r2;
        if (r15 != null) goto L17;
        return;
    L17:
        if (r15.hasNext() == false) goto L25;
        CpuCacheItem r3 = (CpuCacheItem) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r15.next(), Map.Entry.class, "com.obric.memorydata.plugin")).getValue(), CpuCacheItem.class, "com.obric.memorydata.plugin");
        if ((r13 - r3.getFirstTs()) <= this.mConfig.getMonitorInterval()) goto L17;
        r15.remove();
        double r4 = r3.getMetricRate() / ((double) r3.getTimes());
        double r5 = r3.getMetricMaxRate();
        double r7 = r3.getMetricCpuSpeed() / ((double) r3.getTimes());
        double r9 = r3.getMetricMaxCpuSpeed();
        if (ApmContext.isDebugMode() == false) goto L24;
        Logger.d(Constants.TAG, "cpu cache item: " + r3);
        Logger.d(Constants.TAG, "assemble cpu data, type: " + r17 + " rate: " + r4 + " maxRate: " + r5 + " speed: " + r7 + " maxSpeed: " + r9);
    L24:
        doReport(r17, r3.getSceneString(), r4, r5, r7, r9, r18);
        goto L17
    L25:
        return;
    L5:
        if (r0 != 2) goto L7;
        r1 = this.mTimerInfoBack;
        goto L13
    L7:
        if (r0 == 3) goto L10;
        r2 = null;
        goto L9
    L10:
        r1 = this.mTimerInfoFore;
        goto L13
    }

    private void doReport(CpuCacheItem.CpuDataType r14, String r15, double r16, double r18, double r20, double r22, c.a r24) {
        CpuReportEvent r12 = new CpuReportEvent(r14, r15, r16, r18, r20, r22, r24);
        r12.setBatteryCurrent(com.ss.thor.c.b((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(ApmContext.getContext(), "com.obric.memorydata.plugin"), Application.class, "com.obric.memorydata.plugin")));
        r12.setNormalSampleState(this.assistStat.i());     // Catch: Throwable -> L6
    L4:
        Monitor.record(r12);
    }

    private CpuCacheItem getCacheItem(CpuCacheItem.CpuDataType r3, String r4) {
        int r5 = AnonymousClass1.$SwitchMap$com$bytedance$apm6$cpu$collect$CpuCacheItem$CpuDataType[r3.ordinal()];
        if (r5 != 1) goto L5;
        HashMap<String, CpuCacheItem> r2 = this.mTimerInfoMix;
    L12:
        return (CpuCacheItem) ZeusTransformUtils.preCheckCast(r2.get(r4), CpuCacheItem.class, "com.obric.memorydata.plugin");
    L5:
        if (r5 != 2) goto L7;
        r2 = this.mTimerInfoBack;
        goto L12
    L7:
        if (r5 == 3) goto L10;
        return null;
    L10:
        r2 = this.mTimerInfoFore;
        goto L12
    }

    private static CpuCacheItem refreshCpuCacheItem(CpuCacheItem.CpuDataType r2, CpuCacheItem r3, double r4, double r6) {
        if (r3 != null) goto L5;
        r3 = new CpuCacheItem(r2, System.currentTimeMillis());
        r3.injectScene(PerfFilterManager.getInstance().getSceneString());
    L5:
        if (r4 < 0.0d) goto L7;
    L8:
        r3.addTimes();
    L9:
        r3.addSpeed(r6);
        r3.addRate(r4);
        r3.refreshMaxRate(r4);
        r3.refreshMaxSpeed(r6);
        return r3;
    L7:
        if (r6 < 0.0d) goto L9;
        goto L8
    }

    void addCacheData(double r10, double r12) {
        if (this.mIsStart.get() == true) goto L5;
        return;
    L5:
        String r0 = PerfFilterManager.getInstance().getSceneString();
        if (ApmContext.isDebugMode() == false) goto L9;
        Logger.d(Constants.TAG, r0);
    L9:
        monitor-enter(CpuDataAssembler.class);
    L20:
        th = move-exception;
        throw th;
    L11:
        if (CpuCollectManager.getInstance().isFront() == false) goto L13;
        CpuCacheItem.CpuDataType r2 = CpuCacheItem.CpuDataType.FRONT;     // Catch: Throwable -> L20
    L14:
        CpuCacheItem r3 = refreshCpuCacheItem(r2, getCacheItem(r2, r0), r10, r12);     // Catch: Throwable -> L20
        addCacheItem(r2, r0, r3);     // Catch: Throwable -> L20
        if (ApmContext.isDebugMode() == false) goto L17;
        Logger.d(Constants.TAG, "after add cache data: " + r3);     // Catch: Throwable -> L20
    L17:
        addCacheItem(CpuCacheItem.CpuDataType.MIX, r0, refreshCpuCacheItem(CpuCacheItem.CpuDataType.MIX, getCacheItem(CpuCacheItem.CpuDataType.MIX, r0), r10, r12));     // Catch: Throwable -> L20
        monitor-exit(CpuDataAssembler.class);     // Catch: Throwable -> L20
        return;
    L13:
        r2 = CpuCacheItem.CpuDataType.BACK;     // Catch: Throwable -> L20
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

    void start(CpuConfig r4) {
        if (this.mIsStart.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        this.mTimerInfoMix = new HashMap();
        this.mTimerInfoFore = new HashMap();
        this.mTimerInfoBack = new HashMap();
        this.mConfig = r4;
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

    public void triggerAssemble(c.a r3) {
        if (this.mIsStart.get() == true) goto L6;
        return;
    L6:
        monitor-enter(CpuDataAssembler.class);
        doAssemble(CpuCacheItem.CpuDataType.FRONT, r3);     // Catch: Throwable -> L10
        doAssemble(CpuCacheItem.CpuDataType.BACK, r3);     // Catch: Throwable -> L10
        doAssemble(CpuCacheItem.CpuDataType.MIX, r3);     // Catch: Throwable -> L10
        monitor-exit(CpuDataAssembler.class);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }
}
