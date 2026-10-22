package com.bytedance.crash.util;

import com.bytedance.crash.Global;
import com.bytedance.crash.event.EventConfig;
import com.bytedance.crash.runtime.DefaultWorkThread;
import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
public class NpthDiskMonitor {
    public static String SERVICE_NAME = "npth_disk_event";
    private static NpthDiskMonitor sInstance;

    static {
        sInstance = new NpthDiskMonitor();
    }

    private NpthDiskMonitor() {
    }

    public static long getDirSize(File r6) {
        long r1 = 0;
        if (r6.exists() == true) goto L5;
        return 0;
    L5:
        if (r6.isDirectory() == false) goto L11;
        File[] r7 = r6.listFiles();
        int r0 = r7.length;
        int r3 = 0;
    L7:
        if (r3 >= r0) goto L9;
        r1 = r1 + getDirSize(r7[r3]);
        r3 = r3 + 1;
        goto L7
    L9:
        return r1;
    L11:
        return r6.length() / 1024;
    }

    public static NpthDiskMonitor getInstance() {
        return sInstance;
    }

    public void cleanOldDir() {
        File r0 = Global.getRootDirectory();     // Catch: Throwable -> L8
        if (new File(r0, "crash.deleted").exists() == false) goto L6;
        return;
    L6:
        FileUtils.deleteFile(new File(r0, "RuntimeContext"));     // Catch: Throwable -> L8
        FileUtils.deleteFile(new File(r0, "ProcessTrack"));     // Catch: Throwable -> L8
        FileUtils.deleteFile(new File(r0, "TrackInfo"));     // Catch: Throwable -> L8
        FileUtils.deleteFile(new File(r0, "CrashCommonLog"));     // Catch: Throwable -> L8
        FileUtils.deleteFile(new File(r0, "CrashLogJava"));     // Catch: Throwable -> L8
        FileUtils.deleteFile(new File(r0, "CrashLogNative"));     // Catch: Throwable -> L8
        FileUtils.deleteFile(new File(r0, "procanr"));     // Catch: Throwable -> L8
        FileUtils.deleteFile(new File(r0, "configCrash"));     // Catch: Throwable -> L8
        new File(r0, "crash.deleted").createNewFile();     // Catch: Throwable -> L8
        return;
    }

    public void init() {
        DefaultWorkThread.post(new AnonymousClass2(this));
    }

    public void setConfig(EventConfig r2) {
        if (r2 != null) goto L5;
        return;
    L5:
        if (r2.isSampled(SERVICE_NAME) == true) goto L7;
        return;
    L7:
        DefaultWorkThread.post(new AnonymousClass1(this));
    }
}
