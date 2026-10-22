package com.bytedance.crash.dumper;

import com.bytedance.crash.CrashInfoCallback;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.monitor.AppMonitor;
import com.bytedance.crash.monitor.MonitorManager;
import com.bytedance.crash.util.FileUtils;
import java.io.File;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class CustomFile {
    private static final int SIZE_LIMIT = 1048576;
    private static int cacheFileSize = 1048576;
    private static volatile boolean isEnable = true;

    static {
    }

    public CustomFile() {
    }

    public static void dump(File r12, CrashType r13) {
        AppMonitor r10 = MonitorManager.getAppMonitor();
        if (r10 != null) goto L5;
        return;
    L5:
        if (isEnable == false) goto L37;
        Iterator<CrashInfoCallback> r11 = r10.getUserDataCenter().getCrashInfoCallback(r13).iterator();     // Catch: Throwable -> L24
        int r14 = 0;
    L9:
        if (r11.hasNext() == false) goto L39;
        File[] r15 = r11.next().crashFileList(r13);     // Catch: Throwable -> L24
        if (r15 == null) goto L9;
        int r16 = r15.length;     // Catch: Throwable -> L24
        int r17 = 0;
    L14:
        if (r17 >= r16) goto L9;
        File r18 = r15[r17];     // Catch: Throwable -> L24
        File r19 = new File(r12, r18.getName());     // Catch: Throwable -> L24
        if (r19.exists() == true) goto L22;
        r14 = (int) (((long) r14) + r18.length());     // Catch: Throwable -> L24
        if (r14 > cacheFileSize) goto L9;
        FileUtils.copy(r18, r19);     // Catch: Throwable -> L24
    L22:
        r17 = r17 + 1;
        goto L14
    L39:
        return;
    L38:
        return;
    }

    public static void updateConfig(boolean r10, int r11) {
        isEnable = r10;
        if (r11 <= 0) goto L6;
        cacheFileSize = r11;
        return;
    }
}
