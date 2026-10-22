package com.ss.android.lark.monitor.memory;

import android.app.ActivityManager;
import android.os.Debug;
import com.ss.android.lark.utils.LarkContext;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class MemoryInfoUtil {
    private static String TAG = "MemoryInfoUtil";

    public MemoryInfoUtil() {
    }

    public static float getJavaHeapUsedRate() {
        return getUsedJavaHeapMB() / (Runtime.getRuntime().maxMemory() / 1048576);
    }

    public static int getNativeHeapMB() {
        return (int) (Debug.getNativeHeapSize() / 1048576);
    }

    public static float getRemainTotalMemoryRate() {
        ActivityManager r0 = (ActivityManager) LarkContext.getApplication().getSystemService("activity");
        ActivityManager.MemoryInfo r1 = new ActivityManager.MemoryInfo();
        r0.getMemoryInfo(r1);
        return r1.availMem / r1.totalMem;
    }

    public static int getUsedJavaHeapMB() {
        return (int) ((Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 1048576);
    }
}
