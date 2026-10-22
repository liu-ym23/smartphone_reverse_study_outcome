package com.bytedance.apm6.memory;

import android.app.ActivityManager;
import android.os.Build;
import android.os.Debug;
import android.os.Process;
import android.text.TextUtils;
import com.bytedance.apm6.memory.config.MemoryConfig;
import com.bytedance.apm6.memory.monitorable.MemoryPerfDataEvent;
import com.bytedance.apm6.service.ServiceManager;
import com.bytedance.apm6.service.lifecycle.ActivityLifecycleService;
import com.bytedance.apm6.util.ApmBaseContext;
import com.bytedance.apm6.util.log.Logger;
import java.math.BigDecimal;

/* JADX INFO: loaded from: classes.dex */
class MemoryStatistics {
    private long lastBlockingGcCount;
    private long lastGcBlockingGcTime;
    private long lastGcCount;
    private long lastGcTime;

    private static class InnerHolder {
        private static final MemoryStatistics instance = null;

        static {
            instance = new MemoryStatistics();
        }

        private InnerHolder() {
        }

        static /* synthetic */ MemoryStatistics access$000() {
            return instance;
        }
    }

    MemoryStatistics() {
    }

    private long getBlockingGcCount() {
        if (Build.VERSION.SDK_INT >= 23) goto L6;
        return -1;
    L6:
        long r10 = Long.parseLong(Debug.getRuntimeStat("art.gc.blocking-gc-count"));
        long r11 = r10 - this.lastBlockingGcCount;
        this.lastBlockingGcCount = r10;
        if (ApmBaseContext.isDebugMode() == false) goto L9;
        Logger.d("APM-Memory", "blockingGcCount:" + this.lastBlockingGcCount);
    L9:
        return r11;
    }

    private long getBlockingGcTime() {
        if (Build.VERSION.SDK_INT >= 23) goto L6;
        return -1;
    L6:
        long r10 = Long.parseLong(Debug.getRuntimeStat("art.gc.blocking-gc-time"));
        long r11 = r10 - this.lastGcBlockingGcTime;
        this.lastGcBlockingGcTime = r10;
        if (ApmBaseContext.isDebugMode() == false) goto L9;
        Logger.d("APM-Memory", "blockingGcTime:" + this.lastGcBlockingGcTime);
    L9:
        return r11;
    }

    private long getDalvikUsedSize(Debug.MemoryInfo r10) {
        return ((long) r10.dalvikPss) * 1024;
    }

    private long getGcCount() {
        if (Build.VERSION.SDK_INT >= 23) goto L6;
        return -1;
    L6:
        long r10 = Long.parseLong(Debug.getRuntimeStat("art.gc.gc-count"));
        long r11 = r10 - this.lastGcCount;
        this.lastGcCount = r10;
        if (ApmBaseContext.isDebugMode() == false) goto L9;
        Logger.d("APM-Memory", "gcCount:" + r10);
    L9:
        return r11;
    }

    private long getGcTime() {
        if (Build.VERSION.SDK_INT >= 23) goto L6;
        return -1;
    L6:
        long r10 = Long.parseLong(Debug.getRuntimeStat("art.gc.gc-time"));
        long r11 = r10 - this.lastGcTime;
        this.lastGcTime = r10;
        if (ApmBaseContext.isDebugMode() == false) goto L9;
        Logger.d("APM-Memory", "gcTime:" + this.lastGcTime);
    L9:
        return r11;
    }

    private long getGraphics(Debug.MemoryInfo r10) {
        if (Build.VERSION.SDK_INT >= 23) goto L5;
        return -1;
    L5:
        String r11 = r10.getMemoryStat("summary.graphics");
        if (TextUtils.isEmpty(r11) == false) goto L13;
    L12:
        return -1;
    L13:
        return ((long) Integer.parseInt(r11)) * 1024;
    L10:
        e = move-exception;
        Logger.e("APM-Memory", "getGraphics", e);
        e.printStackTrace();
        goto L12
    }

    public static MemoryStatistics getInstance() {
        return InnerHolder.access$000();
    }

    private double getJavaUsedMemoryRate(long r10) {
        if (r10 > 0) goto L5;
        return -1.0d;
    L5:
        return new BigDecimal(r10).divide(new BigDecimal(Runtime.getRuntime().maxMemory()), 4, 4).doubleValue();
    }

    public static Debug.MemoryInfo getMemoryInfo() {
        if (ApmBaseContext.getContext() != null) goto L11;
        return null;
    L11:
        ActivityManager r10 = (ActivityManager) ApmBaseContext.getContext().getSystemService("activity");     // Catch: Exception -> L10
        if (r10 != null) goto L8;
        return null;
    L8:
        return r10.getProcessMemoryInfo(new int[]{Process.myPid()})[0];
    L10:
        return null;
    }

    private long getVmSize() {
        long r10 = Tools.getVmSize() * 1024;
        if (r10 <= 0) goto L5;
        return r10;
    L5:
        return -1;
    }

    MemoryPerfDataEvent collectWithConfig(MemoryConfig r33) {
        Debug.MemoryInfo r10 = getMemoryInfo();
        if (r10 != null) goto L5;
        return null;
    L5:
        long r19 = getDalvikUsedSize(r10);
        if (r19 >= 0) goto L8;
        return null;
    L8:
        ActivityLifecycleService r11 = (ActivityLifecycleService) ServiceManager.getService(ActivityLifecycleService.class);
        long r13 = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        double r25 = getJavaUsedMemoryRate(r13);
        long r12 = getGcCount();
        long r14 = getGcTime();
        long r15 = getBlockingGcCount();
        long r16 = getBlockingGcTime();
        boolean r17 = !r11.isForeground();
        long r21 = ((long) r10.nativePss) * 1024;
        long r18 = 1024 * ((long) r10.getTotalPss());
        long r20 = getGraphics(r10);
        long r23 = getVmSize();
        if (r25 <= r33.memoryTopCheckThreshold()) goto L11;
        boolean r27 = true;
    L13:
        return new MemoryPerfDataEvent(r12, r14, r15, r16, r17, r21, r18, r13, r19, r20, r23, r25, r27, r33.isRealTimeMemEnable());
    L11:
        r27 = false;
        goto L13
    }

    void init() {
        getGcCount();
        getGcTime();
        getBlockingGcCount();
        getBlockingGcTime();
    }
}
