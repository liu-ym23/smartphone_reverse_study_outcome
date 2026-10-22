package com.bytedance.crash.npth_repair.monitor;

import android.os.Build;
import androidx.annotation.Keep;
import com.bytedance.crash.npth_repair.NpthRepair;
import com.bytedance.crash.npth_repair.utils.RepairPortrait;
import com.bytedance.crash.npth_repair.utils.RepairState;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes.dex */
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

    private static int[] getSigTypesFromPortrait(RepairPortrait r10) {
        int[] r11 = null;
        if (r10 != null) goto L5;
        return null;
    L5:
        JSONArray r12 = r10.getCustomConfigArray("sigTypes");
        if (r12 != null) goto L8;
    L13:
        return r11;
    L8:
        if (r12.length() <= 0) goto L13;
        r11 = new int[r12.length()];
        int r13 = 0;
    L11:
        if (r13 >= r12.length()) goto L13;
        r11[r13] = r12.optInt(r13);
        r13 = r13 + 1;
        goto L11
    }

    @Keep
    private native int nDumpSignalMonitor(String r10);

    @Keep
    private native int nStartSignalMonitorWithSigType(int[] r10);

    @Keep
    private native void nStopSignalMonitor();

    private boolean shouldMonitor(RepairPortrait r10) {
        if (r10 != null) goto L4;
    L9:
        return true;
    L4:
        if (r10.checkApiLevel(Build.VERSION.SDK_INT) == true) goto L6;
    L8:
        return false;
    L6:
        if (r10.checkBrand(Build.BRAND) == false) goto L8;
        goto L8
    }

    public synchronized int dumpSignalMonitor(String r10) {
        monitor-enter(this);
        int r11 = this.mMonitorState;     // Catch: Throwable -> L16
        if (r11 == 1111) goto L13;
        if (r11 == 1113) goto L13;
        monitor-exit(this);
        return -1;
    L13:
        this.mMonitorState = RepairState.STATE_DUMPED;     // Catch: Throwable -> L16
        int r12 = nDumpSignalMonitor(r10);     // Catch: Throwable -> L16
        monitor-exit(this);
        return r12;
    L16:
        th = move-exception;
        throw th;
    }

    public synchronized int startMonitor(RepairPortrait r10) {
        monitor-enter(this);
        int r11 = this.mMonitorState;     // Catch: Throwable -> L25
        if (r11 == 1110) goto L12;
        if (r11 == 1113) goto L12;
        int r12 = -2;
    L9:
        monitor-exit(this);
        return r12;
    L12:
        if (NpthRepair.isInited() == true) goto L14;
        r12 = -1;
        goto L9
    L14:
        this.mMonitorPortriait = r10;     // Catch: Throwable -> L25
        int r13 = -6;
        if (shouldMonitor(r10) == true) goto L29;
    L19:
        if (r13 == 0) goto L21;
        this.mMonitorState = RepairState.STATE_FAIL;     // Catch: Throwable -> L25
    L23:
        monitor-exit(this);
        return r13;
    L21:
        this.mMonitorState = RepairState.STATE_SUCCESS;     // Catch: Throwable -> L25
        goto L23
    L29:
        r13 = nStartSignalMonitorWithSigType(getSigTypesFromPortrait(r10));     // Catch: Throwable -> L18
    L18:
        r13 = -4;
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
