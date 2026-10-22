package com.bytedance.crash.npth_repair.nativeCrash;

import android.util.Log;
import androidx.annotation.Keep;
import com.bytedance.crash.npth_repair.NpthRepair;

/* JADX INFO: loaded from: classes.dex */
public class DvmSuspendTimeOpt {
    private static final String TAG = "DvmSuspendTimeOpt";
    protected static boolean doFix;
    protected static int fixErrno;

    public DvmSuspendTimeOpt() {
    }

    public static synchronized int doFixCrash() {
        monitor-enter(DvmSuspendTimeOpt.class);
    L21:
        th = move-exception;
        throw th;
    L5:
        if (NpthRepair.isInited() == true) goto L11;
        Log.d(TAG, "not init yet, please make sure invoke NpthRepair.init first");     // Catch: Throwable -> L21
        int r10 = -1;
    L8:
        monitor-exit(DvmSuspendTimeOpt.class);
        return r10;
    L11:
        if (doFix == false) goto L13;
        Log.d(TAG, "has fixed");     // Catch: Throwable -> L21
        r10 = -2;
        goto L8
    L13:
        doFix = true;     // Catch: Throwable -> L21
        fixErrno = nSuspendTimeOpt();     // Catch: Throwable -> L16
    L18:
        int r11 = fixErrno;     // Catch: Throwable -> L21
        monitor-exit(DvmSuspendTimeOpt.class);
        return r11;
    L16:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L21
        fixErrno = -4;     // Catch: Throwable -> L21
        goto L18
    }

    @Keep
    private static native int nSuspendTimeOpt();

    public static synchronized void unFixCrash() {
        monitor-enter(DvmSuspendTimeOpt.class);
        monitor-exit(DvmSuspendTimeOpt.class);
    }
}
