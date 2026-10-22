package com.bytedance.crash.dumper;

import com.bytedance.crash.repair.RepairAdapter;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public class RepairInfo {
    private static final String SIGNAL_FILE_NAME = "signal_monitor.txt";

    public RepairInfo() {
    }

    public static void dumpSignalMonitorInfo(File r10) {
        RepairAdapter.dumpRepairInfo(2, new File(r10, SIGNAL_FILE_NAME).getAbsolutePath());     // Catch: Throwable -> L4
        return;
    }
}
