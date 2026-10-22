package com.bytedance.apm6.memory;

import android.app.ActivityManager;
import android.app.Application;
import android.os.Build;
import android.os.Debug;
import android.os.Process;
import android.text.TextUtils;
import com.bytedance.apm6.foundation.context.ApmContext;
import com.bytedance.apm6.memory.config.MemoryConfig;
import com.bytedance.apm6.memory.monitorable.MemoryPerfDataEvent;
import com.bytedance.apm6.service.ServiceManager;
import com.bytedance.apm6.service.lifecycle.ActivityLifecycleService;
import com.bytedance.apm6.util.log.Logger;
import com.volcengine.zeus.transform.ZeusTransformUtils;
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
        long r0 = Long.parseLong(Debug.getRuntimeStat("art.gc.blocking-gc-count"));
        long r2 = r0 - this.lastBlockingGcCount;
        this.lastBlockingGcCount = r0;
        if (ApmContext.isDebugMode() == false) goto L9;
        Logger.d("APM-Memory", "blockingGcCount:" + this.lastBlockingGcCount);
    L9:
        return r2;
    }

    private long getBlockingGcTime() {
        if (Build.VERSION.SDK_INT >= 23) goto L6;
        return -1;
    L6:
        long r0 = Long.parseLong(Debug.getRuntimeStat("art.gc.blocking-gc-time"));
        long r2 = r0 - this.lastGcBlockingGcTime;
        this.lastGcBlockingGcTime = r0;
        if (ApmContext.isDebugMode() == false) goto L9;
        Logger.d("APM-Memory", "blockingGcTime:" + this.lastGcBlockingGcTime);
    L9:
        return r2;
    }

    private long getDalvikUsedSize(Debug.MemoryInfo r3) {
        return ((long) r3.dalvikPss) * 1024;
    }

    private long getGcCount() {
        if (Build.VERSION.SDK_INT >= 23) goto L6;
        return -1;
    L6:
        long r0 = Long.parseLong(Debug.getRuntimeStat("art.gc.gc-count"));
        long r2 = r0 - this.lastGcCount;
        this.lastGcCount = r0;
        if (ApmContext.isDebugMode() == false) goto L9;
        Logger.d("APM-Memory", "gcCount:" + r0);
    L9:
        return r2;
    }

    private long getGcTime() {
        if (Build.VERSION.SDK_INT >= 23) goto L6;
        return -1;
    L6:
        long r0 = Long.parseLong(Debug.getRuntimeStat("art.gc.gc-time"));
        long r2 = r0 - this.lastGcTime;
        this.lastGcTime = r0;
        if (ApmContext.isDebugMode() == false) goto L9;
        Logger.d("APM-Memory", "gcTime:" + this.lastGcTime);
    L9:
        return r2;
    }

    private long getGraphics(Debug.MemoryInfo r4) {
        if (Build.VERSION.SDK_INT >= 23) goto L5;
        return -1;
    L5:
        String r3 = r4.getMemoryStat("summary.graphics");
        if (TextUtils.isEmpty(r3) == false) goto L13;
    L12:
        return -1;
    L13:
        return ((long) Integer.parseInt(r3)) * 1024;
    L10:
        e = move-exception;
        Logger.e("APM-Memory", "getGraphics", e);
        e.printStackTrace();
        goto L12
    }

    public static MemoryStatistics getInstance() {
        return InnerHolder.access$000();
    }

    private double getJavaUsedMemoryRate(long r3) {
        if (r3 > 0) goto L5;
        return -1.0d;
    L5:
        return new BigDecimal(r3).divide(new BigDecimal(Runtime.getRuntime().maxMemory()), 4, 4).doubleValue();
    }

    public static Debug.MemoryInfo getMemoryInfo() {
        if (((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(ApmContext.getContext(), "com.obric.memorydata.plugin"), Application.class, "com.obric.memorydata.plugin")) != null) goto L11;
        return null;
    L11:
        ActivityManager r0 = (ActivityManager) ZeusTransformUtils.preCheckCast(((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(ApmContext.getContext(), "com.obric.memorydata.plugin"), Application.class, "com.obric.memorydata.plugin")).getSystemService("activity"), ActivityManager.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L10
        if (r0 != null) goto L8;
        return null;
    L8:
        return r0.getProcessMemoryInfo(new int[]{Process.myPid()})[0];
    L10:
        return null;
    }

    private long getVmSize() {
        long r0 = Tools.getVmSize() * 1024;
        if (r0 <= 0) goto L5;
        return r0;
    L5:
        return -1;
    }

    MemoryPerfDataEvent collectWithConfig(MemoryConfig r33) {
        Debug.MemoryInfo r1 = getMemoryInfo();
        if (r1 != null) goto L5;
        return null;
    L5:
        long r19 = getDalvikUsedSize(r1);
        if (r19 >= 0) goto L8;
        return null;
    L8:
        ActivityLifecycleService r2 = (ActivityLifecycleService) ZeusTransformUtils.preCheckCast(ServiceManager.getService(ActivityLifecycleService.class), ActivityLifecycleService.class, "com.obric.memorydata.plugin");
        long r13 = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        double r25 = getJavaUsedMemoryRate(r13);
        long r4 = getGcCount();
        long r6 = getGcTime();
        long r8 = getBlockingGcCount();
        long r10 = getBlockingGcTime();
        boolean r12 = !r2.isForeground();
        long r21 = ((long) r1.nativePss) * 1024;
        long r17 = 1024 * ((long) r1.getTotalPss());
        long r3 = getGraphics(r1);
        long r23 = getVmSize();
        if (r25 <= r33.memoryTopCheckThreshold()) goto L11;
        boolean r27 = true;
    L13:
        return new MemoryPerfDataEvent(r4, r6, r8, r10, r12, r21, r17, r13, r19, r3, r23, r25, r27, r33.isRealTimeMemEnable());
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
