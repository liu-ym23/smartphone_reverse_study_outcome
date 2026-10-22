package com.bytedance.apm6.cpu.collect;

import com.bytedance.apm.util.b;
import com.bytedance.apm6.monitor.Monitor;
import com.bytedance.apm6.util.timetask.AsyncTaskManager;
import com.bytedance.apm6.util.timetask.AsyncTaskManagerType;
import com.bytedance.monitor.collector.k;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class InitiativeCpuCollectManager {
    private static volatile boolean isConfigReady;
    private static Map<String, CacheDataItem> sCacheCollectData;
    private static List<CpuReportEvent> sCacheReportData;

    private static class CacheDataItem {
        public long appCpuTime;
        public long startTime;
        public long totalCpuTime;

        private CacheDataItem() {
        }

        /* synthetic */ CacheDataItem(AnonymousClass1 r1) {
            this();
        }
    }

    static {
        sCacheCollectData = new HashMap();
        sCacheReportData = new LinkedList();
        isConfigReady = false;
    }

    public InitiativeCpuCollectManager() {
    }

    static /* synthetic */ boolean access$100() {
        return isConfigReady;
    }

    static /* synthetic */ List access$200() {
        return sCacheReportData;
    }

    public static synchronized void onConfigReady() {
        monitor-enter(InitiativeCpuCollectManager.class);
        isConfigReady = true;     // Catch: Throwable -> L14
        if (sCacheReportData.isEmpty() == true) goto L12;
        Iterator<CpuReportEvent> r1 = sCacheReportData.iterator();     // Catch: Throwable -> L14
    L9:
        if (r1.hasNext() == false) goto L11;
        Monitor.record((CpuReportEvent) ZeusTransformUtils.preCheckCast(r1.next(), CpuReportEvent.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L14
        goto L9
    L11:
        sCacheReportData.clear();     // Catch: Throwable -> L14
    L12:
        monitor-exit(InitiativeCpuCollectManager.class);
        return;
    L14:
        th = move-exception;
        throw th;
    }

    private static void sendData(final String r9, final double r10, final double r12, final boolean r14) {
        AsyncTaskManager.getInstance(AsyncTaskManagerType.CPU).sendTask(new AnonymousClass1(r14, r9, r10, r12));
    }

    public static synchronized void startCollect(String r4) {
        monitor-enter(InitiativeCpuCollectManager.class);
        CacheDataItem r1 = new CacheDataItem(null);     // Catch: Throwable -> L7
        r1.startTime = System.currentTimeMillis();     // Catch: Throwable -> L7
        r1.appCpuTime = k.a().m();     // Catch: Throwable -> L7
        r1.totalCpuTime = k.a().b(b.c());     // Catch: Throwable -> L7
        sCacheCollectData.put(r4, r1);     // Catch: Throwable -> L7
        monitor-exit(InitiativeCpuCollectManager.class);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static synchronized void stopCollect(String r12, boolean r13) {
        monitor-enter(InitiativeCpuCollectManager.class);
        CacheDataItem r1 = (CacheDataItem) ZeusTransformUtils.preCheckCast(sCacheCollectData.get(r12), CacheDataItem.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L21
        if (r1 != null) goto L9;
        monitor-exit(InitiativeCpuCollectManager.class);
        return;
    L9:
        if (r1.appCpuTime < 0) goto L12;
    L15:
        long r2 = k.a().m();     // Catch: Throwable -> L21
        long r6 = k.a().b(b.c());     // Catch: Throwable -> L21
        double r8 = -1.0d;
        if ((r6 - r1.totalCpuTime) <= 0) goto L18;
        r8 = (r2 - r1.appCpuTime) / (r6 - r1.totalCpuTime);     // Catch: Throwable -> L21
    L18:
        double r4 = (((r2 - r1.appCpuTime) * 1000.0d) / (System.currentTimeMillis() - r1.startTime)) / b.a(100);     // Catch: Throwable -> L21
        sCacheCollectData.remove(r12);     // Catch: Throwable -> L21
        sendData(r12, r8, r4, r13);     // Catch: Throwable -> L21
        monitor-exit(InitiativeCpuCollectManager.class);
        return;
    L12:
        if (r1.totalCpuTime >= 0) goto L15;
        monitor-exit(InitiativeCpuCollectManager.class);
        return;
    L21:
        th = move-exception;
        throw th;
    }
}
