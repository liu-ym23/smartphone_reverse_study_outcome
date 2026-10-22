package com.bytedance.apm6.cpu.collect;

import com.bytedance.apm.util.b;
import com.bytedance.apm6.monitor.Monitor;
import com.bytedance.apm6.util.timetask.AsyncTaskManager;
import com.bytedance.apm6.util.timetask.AsyncTaskManagerType;
import com.bytedance.monitor.collector.k;
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

        /* synthetic */ CacheDataItem(AnonymousClass1 r10) {
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
        Iterator<CpuReportEvent> r10 = sCacheReportData.iterator();     // Catch: Throwable -> L14
    L9:
        if (r10.hasNext() == false) goto L11;
        Monitor.record(r10.next());     // Catch: Throwable -> L14
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

    private static void sendData(final String r10, final double r11, final double r12, final boolean r14) {
        AsyncTaskManager.getInstance(AsyncTaskManagerType.CPU).sendTask(new AnonymousClass1(r14, r10, r11, r12));
    }

    public static synchronized void startCollect(String r10) {
        monitor-enter(InitiativeCpuCollectManager.class);
        CacheDataItem r11 = new CacheDataItem(null);     // Catch: Throwable -> L7
        r11.startTime = System.currentTimeMillis();     // Catch: Throwable -> L7
        r11.appCpuTime = k.n().c();     // Catch: Throwable -> L7
        r11.totalCpuTime = k.n().k(b.d());     // Catch: Throwable -> L7
        sCacheCollectData.put(r10, r11);     // Catch: Throwable -> L7
        monitor-exit(InitiativeCpuCollectManager.class);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static synchronized void stopCollect(String r14, boolean r15) {
        monitor-enter(InitiativeCpuCollectManager.class);
        CacheDataItem r10 = sCacheCollectData.get(r14);     // Catch: Throwable -> L21
        if (r10 != null) goto L9;
        monitor-exit(InitiativeCpuCollectManager.class);
        return;
    L9:
        if (r10.appCpuTime < 0) goto L12;
    L15:
        long r11 = k.n().c();     // Catch: Throwable -> L21
        long r12 = k.n().k(b.d());     // Catch: Throwable -> L21
        double r13 = -1.0d;
        long r16 = r10.totalCpuTime;     // Catch: Throwable -> L21
        if ((r12 - r16) <= 0) goto L18;
        r13 = (r11 - r10.appCpuTime) / (r12 - r16);     // Catch: Throwable -> L21
    L18:
        double r17 = (((r11 - r10.appCpuTime) * 1000.0d) / (System.currentTimeMillis() - r10.startTime)) / b.k(100);     // Catch: Throwable -> L21
        sCacheCollectData.remove(r14);     // Catch: Throwable -> L21
        sendData(r14, r13, r17, r15);     // Catch: Throwable -> L21
        monitor-exit(InitiativeCpuCollectManager.class);
        return;
    L12:
        if (r10.totalCpuTime >= 0) goto L15;
        monitor-exit(InitiativeCpuCollectManager.class);
        return;
    L21:
        th = move-exception;
        throw th;
    }
}
