package com.bytedance.crash.dumper;

import com.bytedance.crash.CrashInfoCallback;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.monitor.AppMonitor;
import com.bytedance.crash.monitor.MonitorManager;
import com.bytedance.crash.util.FileUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public class CustomFile {
    private static final int SIZE_LIMIT = 1048576;
    private static int cacheFileSize = 1048576;
    private static volatile boolean isEnable = true;

    static {
    }

    public CustomFile() {
    }

    public static void dump(File r12, CrashType r13) {
        AppMonitor r0 = MonitorManager.getAppMonitor();
        if (r0 != null) goto L5;
        return;
    L5:
        if (isEnable == false) goto L37;
        Iterator<CrashInfoCallback> r1 = r0.getUserDataCenter().getCrashInfoCallback(r13).iterator();     // Catch: Throwable -> L24
        int r2 = 0;
    L9:
        if (r1.hasNext() == false) goto L39;
        File[] r3 = ((CrashInfoCallback) ZeusTransformUtils.preCheckCast(r1.next(), CrashInfoCallback.class, "com.obric.memorydata.plugin")).crashFileList(r13);     // Catch: Throwable -> L24
        if (r3 == null) goto L9;
        int r4 = r3.length;     // Catch: Throwable -> L24
        int r5 = 0;
    L14:
        if (r5 >= r4) goto L9;
        File r6 = r3[r5];     // Catch: Throwable -> L24
        File r7 = new File(r12, r6.getName());     // Catch: Throwable -> L24
        if (r7.exists() == true) goto L22;
        r2 = (int) (((long) r2) + r6.length());     // Catch: Throwable -> L24
        if (r2 > cacheFileSize) goto L9;
        FileUtils.copy(r6, r7);     // Catch: Throwable -> L24
    L22:
        r5 = r5 + 1;
        goto L14
    L39:
        return;
    L38:
        return;
    }

    public static void updateConfig(boolean r0, int r1) {
        isEnable = r0;
        if (r1 <= 0) goto L6;
        cacheFileSize = r1;
        return;
    }
}
