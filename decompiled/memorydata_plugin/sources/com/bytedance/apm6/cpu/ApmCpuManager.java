package com.bytedance.apm6.cpu;

import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.apm.h.a.a;
import com.bytedance.apm.util.b;
import com.bytedance.apm6.cpu.collect.CpuCollectManager;
import com.bytedance.apm6.cpu.collect.InitiativeCpuCollectManager;
import com.bytedance.apm6.cpu.exception.CpuExceptionManager;
import com.bytedance.apm6.cpu.service.CurrentCpuDataHolder;
import com.bytedance.apm6.perf.base.PerfFilterManager;
import com.bytedance.apm6.service.perf.ICpuDataService;
import com.bytedance.apm6.util.ListUtils;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.monitor.collector.k;
import com.bytedance.watson.assist.a.c;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.LinkedList;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: classes.dex */
public class ApmCpuManager {
    private static volatile ApmCpuManager singleton;
    private CopyOnWriteArraySet<String> mSceneSet;

    public interface ICpuDataListener {
        void onCpuData(double r1, double r3, String r5, c.a r6, NetworkUtils.NetworkType r7);
    }

    public interface ICpuExceptionFilter {
        boolean needFilter();
    }

    public interface ICpuExceptionListener {
        void onException(double r1);
    }

    private ApmCpuManager() {
        this.mSceneSet = new CopyOnWriteArraySet();
    }

    public static ApmCpuManager getInstance() {
        if (singleton != null) goto L15;
        monitor-enter(ApmCpuManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (singleton != null) goto L9;
        singleton = new ApmCpuManager();     // Catch: Throwable -> L11
    L9:
        monitor-exit(ApmCpuManager.class);     // Catch: Throwable -> L11
    L15:
        return singleton;
    }

    public double getCpuRate() {
        return CurrentCpuDataHolder.getInstance().getCpuRate();
    }

    public CopyOnWriteArraySet<String> getCpuSceneSet() {
        return this.mSceneSet;
    }

    public String getCpuSceneString() {
        String r1 = ListUtils.arrayToString(this.mSceneSet.toArray(), "#");
        if (TextUtils.isEmpty(r1) == true) goto L5;
        return r1;
    L5:
        return "";
    }

    public double getCpuSpeed() {
        return CurrentCpuDataHolder.getInstance().getCpuSpeed();
    }

    public a getCurrentCpuRate() {
        return getCurrentCpuRateNew();
    }

    public a getCurrentCpuRateNew() {
        a r13 = new a();
        int r0 = b.c();     // Catch: Exception -> L15
        if (r0 > 0) goto L6;
        return r13;
    L6:
        long r1 = System.currentTimeMillis();     // Catch: Exception -> L15
        long r3 = k.a().m();     // Catch: Exception -> L15
        long r5 = k.a().b(r0);     // Catch: Exception -> L15
        double r7 = -1.0d;
        Thread.sleep(360);     // Catch: InterruptedException -> L14 Exception -> L15
    L9:
        long r9 = k.a().m();     // Catch: Exception -> L15
        long r11 = k.a().b(r0) - r5;     // Catch: Exception -> L15
        if (r11 <= 0) goto L12;
        r7 = (r9 - r3) / r11;     // Catch: Exception -> L15
    L12:
        double r6 = (((r9 - r3) * 1000.0d) / (System.currentTimeMillis() - r1)) / b.a(100);     // Catch: Exception -> L15
        r13.f1326a = r7;     // Catch: Exception -> L15
        r13.f1327b = r6;     // Catch: Exception -> L15
    L13:
        return r13;
    }

    public Pair<Long, LinkedList<ICpuDataService.ThreadCpuItem>> getExceptionThreadList() {
        return CurrentCpuDataHolder.getInstance().getExceptionThreadList();
    }

    public long getLastCpuExceptionTimestamp() {
        return CpuExceptionManager.getInstance().getLastExceptionTimestamp();
    }

    public Pair<Long, LinkedList<ICpuDataService.ThreadCpuItem>> getThreadList() {
        return CurrentCpuDataHolder.getInstance().getThreadList();
    }

    public void setCpuDataListener(ICpuDataListener r2) {
        ICpuDataListener r1 = (ICpuDataListener) ZeusTransformUtils.wrapperContextForParams(r2, ICpuDataListener.class, "com.obric.memorydata.plugin");
        CpuCollectManager.getInstance().setDataListener(r1);
    }

    public void setCpuExceptionFilter(ICpuExceptionFilter r2) {
        ICpuExceptionFilter r1 = (ICpuExceptionFilter) ZeusTransformUtils.wrapperContextForParams(r2, ICpuExceptionFilter.class, "com.obric.memorydata.plugin");
        CpuExceptionManager.getInstance().setCpuFilterListener(r1);
    }

    public void setExceptionListener(ICpuExceptionListener r2) {
        ICpuExceptionListener r1 = (ICpuExceptionListener) ZeusTransformUtils.wrapperContextForParams(r2, ICpuExceptionListener.class, "com.obric.memorydata.plugin");
        CpuExceptionManager.getInstance().setExceptionListener(r1);
    }

    public void startExceptionDetectNoStack() {
        if (com.bytedance.apm.b.a() == false) goto L6;
        CpuExceptionManager.getInstance().forceOpenNoStack();
        return;
    }

    public void startScene(String r1) {
        this.mSceneSet.add(r1);
        PerfFilterManager.getInstance().startScene(r1);
    }

    public void startUsageDetect(String r1) {
        InitiativeCpuCollectManager.startCollect(r1);
    }

    public void stopExceptionDetectNoStack() {
        if (com.bytedance.apm.b.a() == false) goto L6;
        CpuExceptionManager.getInstance().stopForceOpenNoStack();
        return;
    }

    public void stopScene(String r1) {
        this.mSceneSet.remove(r1);
        PerfFilterManager.getInstance().stopScene(r1);
    }

    public void stopUsageDetect(String r1, boolean r2) {
        InitiativeCpuCollectManager.stopCollect(r1, r2);
    }

    @Deprecated
    public void tmpStartExceptionDetect() {
        CpuExceptionManager.getInstance().forceOpen();
    }
}
