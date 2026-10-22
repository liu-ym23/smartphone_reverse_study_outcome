package com.bytedance.crash.util;

import com.bytedance.crash.Global;
import com.bytedance.crash.event.EventConfig;
import com.bytedance.crash.runtime.DefaultWorkThread;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public class NpthDiskMonitor {
    public static String SERVICE_NAME = "npth_disk_event";
    private static NpthDiskMonitor sInstance;

    static {
        sInstance = new NpthDiskMonitor();
    }

    private NpthDiskMonitor() {
    }

    public static long getDirSize(File r10) {
        long r11 = 0;
        if (r10.exists() == true) goto L5;
        return 0;
    L5:
        if (r10.isDirectory() == false) goto L11;
        File[] r12 = r10.listFiles();
        int r13 = r12.length;
        int r14 = 0;
    L7:
        if (r14 >= r13) goto L9;
        r11 = r11 + getDirSize(r12[r14]);
        r14 = r14 + 1;
        goto L7
    L9:
        return r11;
    L11:
        return r10.length() / 1024;
    }

    public static NpthDiskMonitor getInstance() {
        return sInstance;
    }

    public void cleanOldDir() {
        File r10 = Global.getRootDirectory();     // Catch: Throwable -> L8
        if (new File(r10, "crash.deleted").exists() == false) goto L6;
        return;
    L6:
        FileUtils.deleteFile(new File(r10, "RuntimeContext"));     // Catch: Throwable -> L8
        FileUtils.deleteFile(new File(r10, "ProcessTrack"));     // Catch: Throwable -> L8
        FileUtils.deleteFile(new File(r10, "TrackInfo"));     // Catch: Throwable -> L8
        FileUtils.deleteFile(new File(r10, "CrashCommonLog"));     // Catch: Throwable -> L8
        FileUtils.deleteFile(new File(r10, "CrashLogJava"));     // Catch: Throwable -> L8
        FileUtils.deleteFile(new File(r10, "CrashLogNative"));     // Catch: Throwable -> L8
        FileUtils.deleteFile(new File(r10, "procanr"));     // Catch: Throwable -> L8
        FileUtils.deleteFile(new File(r10, "configCrash"));     // Catch: Throwable -> L8
        new File(r10, "crash.deleted").createNewFile();     // Catch: Throwable -> L8
        return;
    }

    public void init() {
        DefaultWorkThread.post(new AnonymousClass2(this));
    }

    public void setConfig(EventConfig r10) {
        if (r10 != null) goto L5;
        return;
    L5:
        if (r10.isSampled(SERVICE_NAME) == true) goto L7;
        return;
    L7:
        DefaultWorkThread.post(new AnonymousClass1(this));
    }
}
