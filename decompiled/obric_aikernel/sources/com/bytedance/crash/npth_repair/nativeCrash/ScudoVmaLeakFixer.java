package com.bytedance.crash.npth_repair.nativeCrash;

import androidx.annotation.Keep;
import com.bytedance.crash.npth_repair.NpthRepair;
import com.bytedance.crash.npth_repair.utils.RepairLog;

/* JADX INFO: loaded from: classes.dex */
public class ScudoVmaLeakFixer {
    private static final String TAG = "ScudoVmaLeakFixer";
    private static boolean doFix;
    private static int fixErrno;

    public ScudoVmaLeakFixer() {
    }

    public static synchronized int doFixCrash() {
        monitor-enter(ScudoVmaLeakFixer.class);
    L21:
        th = move-exception;
        throw th;
    L5:
        if (NpthRepair.isInited() == true) goto L11;
        RepairLog.d(TAG, "not init yet, please make sure invoke NpthRepair.init first");     // Catch: Throwable -> L21
        int r10 = -1;
    L8:
        monitor-exit(ScudoVmaLeakFixer.class);
        return r10;
    L11:
        if (doFix == false) goto L13;
        RepairLog.d(TAG, "has fixed");     // Catch: Throwable -> L21
        r10 = -2;
        goto L8
    L13:
        doFix = true;     // Catch: Throwable -> L21
        fixErrno = nFixScudoVmaLeak();     // Catch: Throwable -> L16
    L18:
        int r11 = fixErrno;     // Catch: Throwable -> L21
        monitor-exit(ScudoVmaLeakFixer.class);
        return r11;
    L17:
        fixErrno = -4;     // Catch: Throwable -> L21
        goto L18
    }

    @Keep
    private static native int nFixScudoVmaLeak();

    public static synchronized void unFixCrash() {
        monitor-enter(ScudoVmaLeakFixer.class);
        monitor-exit(ScudoVmaLeakFixer.class);
    }
}
