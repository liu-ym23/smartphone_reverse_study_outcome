package com.bytedance.crash.npth_repair.monitor;

import android.os.Build;
import com.bytedance.crash.npth_repair.NpthRepair;
import com.bytedance.crash.npth_repair.utils.RepairPortrait;
import com.bytedance.crash.npth_repair.utils.RepairState;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes2.dex */
public class SignalMonitor {
    private static final String TAG = "SignalMonitor: ";
    private static SignalMonitor sInstance;
    private RepairPortrait mMonitorPortriait;
    private int mMonitorState;

    private SignalMonitor() {
        this.mMonitorState = RepairState.STATE_RAW;
    }

    public static SignalMonitor getInstance() {
        if (sInstance != null) goto L15;
        monitor-enter(SignalMonitor.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new SignalMonitor();     // Catch: Throwable -> L11
    L9:
        monitor-exit(SignalMonitor.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    private static int[] getSigTypesFromPortrait(RepairPortrait r3) {
        int[] r0 = null;
        if (r3 != null) goto L5;
        return null;
    L5:
        JSONArray r4 = r3.getCustomConfigArray("sigTypes");
        if (r4 != null) goto L8;
    L13:
        return r0;
    L8:
        if (r4.length() <= 0) goto L13;
        r0 = new int[r4.length()];
        int r1 = 0;
    L11:
        if (r1 >= r4.length()) goto L13;
        r0[r1] = r4.optInt(r1);
        r1 = r1 + 1;
        goto L11
    }

    private native int nDumpSignalMonitor(String r1);

    private native int nStartSignalMonitorWithSigType(int[] r1);

    private native void nStopSignalMonitor();

    private boolean shouldMonitor(RepairPortrait r1) {
        if (r1 != null) goto L4;
    L9:
        return true;
    L4:
        if (r1.checkApiLevel(Build.VERSION.SDK_INT) == true) goto L6;
    L8:
        return false;
    L6:
        if (r1.checkBrand(Build.BRAND) == false) goto L8;
        goto L8
    }

    public synchronized int dumpSignalMonitor(String r3) {
        monitor-enter(this);
        int r0 = this.mMonitorState;     // Catch: Throwable -> L16
        if (r0 == 1111) goto L13;
        if (r0 == 1113) goto L13;
        monitor-exit(this);
        return -1;
    L13:
        this.mMonitorState = RepairState.STATE_DUMPED;     // Catch: Throwable -> L16
        int r4 = nDumpSignalMonitor(r3);     // Catch: Throwable -> L16
        monitor-exit(this);
        return r4;
    L16:
        th = move-exception;
        throw th;
    }

    public synchronized int startMonitor(RepairPortrait r3) {
        monitor-enter(this);
        int r0 = this.mMonitorState;     // Catch: Throwable -> L25
        if (r0 == 1110) goto L12;
        if (r0 == 1113) goto L12;
        int r4 = -2;
    L9:
        monitor-exit(this);
        return r4;
    L12:
        if (NpthRepair.isInited() == true) goto L14;
        r4 = -1;
        goto L9
    L14:
        this.mMonitorPortriait = r3;     // Catch: Throwable -> L25
        int r1 = -6;
        if (shouldMonitor(r3) == true) goto L29;
    L19:
        if (r1 == 0) goto L21;
        this.mMonitorState = RepairState.STATE_FAIL;     // Catch: Throwable -> L25
    L23:
        monitor-exit(this);
        return r1;
    L21:
        this.mMonitorState = RepairState.STATE_SUCCESS;     // Catch: Throwable -> L25
        goto L23
    L29:
        r1 = nStartSignalMonitorWithSigType(getSigTypesFromPortrait(r3));     // Catch: Throwable -> L18
    L18:
        r1 = -4;
    L25:
        th = move-exception;
        throw th;
    }

    public synchronized void stopMonitor() {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (this.mMonitorState != 1111) goto L6;
        this.mMonitorState = RepairState.STATE_STOPPED;     // Catch: Throwable -> L8
        nStopSignalMonitor();     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
    }
}
