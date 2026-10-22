package com.bytedance.apm6.cpu;

import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.Nullable;
import com.bytedance.apm.d;
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
import g5.c;
import j0.a;
import java.util.LinkedList;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: classes.dex */
public class ApmCpuManager {
    private static volatile ApmCpuManager singleton;
    private CopyOnWriteArraySet<String> mSceneSet;

    public interface ICpuDataListener {
        void onCpuData(double r10, double r11, String r12, @Nullable c.a r13, NetworkUtils.NetworkType r14);
    }

    public interface ICpuExceptionFilter {
        boolean needFilter();
    }

    public interface ICpuExceptionListener {
        void onException(double r10);
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
        String r10 = ListUtils.arrayToString(this.mSceneSet.toArray(), "#");
        if (TextUtils.isEmpty(r10) == true) goto L5;
        return r10;
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
        a r10 = new a();
        int r11 = b.d();     // Catch: Exception -> L12
        if (r11 > 0) goto L6;
        return r10;
    L6:
        System.currentTimeMillis();     // Catch: Exception -> L12
        k.n().c();     // Catch: Exception -> L12
        k.n().k(r11);     // Catch: Exception -> L12
        Thread.sleep(360);     // Catch: InterruptedException -> L11 Exception -> L12
    L9:
        k.n().c();     // Catch: Exception -> L12
        k.n().k(r11);     // Catch: Exception -> L12
        System.currentTimeMillis();     // Catch: Exception -> L12
        b.k(100);     // Catch: Exception -> L12
    L10:
        return r10;
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

    public void setCpuDataListener(ICpuDataListener r10) {
        CpuCollectManager.getInstance().setDataListener(r10);
    }

    public void setCpuExceptionFilter(ICpuExceptionFilter r10) {
        CpuExceptionManager.getInstance().setCpuFilterListener(r10);
    }

    public void setExceptionListener(ICpuExceptionListener r10) {
        CpuExceptionManager.getInstance().setExceptionListener(r10);
    }

    public void startExceptionDetectNoStack() {
        if (d.F() == false) goto L6;
        CpuExceptionManager.getInstance().forceOpenNoStack();
        return;
    }

    public void startScene(String r10) {
        this.mSceneSet.add(r10);
        PerfFilterManager.getInstance().startScene(r10);
    }

    public void startUsageDetect(String r10) {
        InitiativeCpuCollectManager.startCollect(r10);
    }

    public void stopExceptionDetectNoStack() {
        if (d.F() == false) goto L6;
        CpuExceptionManager.getInstance().stopForceOpenNoStack();
        return;
    }

    public void stopScene(String r10) {
        this.mSceneSet.remove(r10);
        PerfFilterManager.getInstance().stopScene(r10);
    }

    public void stopUsageDetect(String r10, boolean r11) {
        InitiativeCpuCollectManager.stopCollect(r10, r11);
    }

    @Deprecated
    public void tmpStartExceptionDetect() {
        CpuExceptionManager.getInstance().forceOpen();
    }
}
