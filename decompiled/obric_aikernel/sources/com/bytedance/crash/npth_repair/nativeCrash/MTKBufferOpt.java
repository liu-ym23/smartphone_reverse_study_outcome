package com.bytedance.crash.npth_repair.nativeCrash;

import androidx.annotation.Keep;
import com.bytedance.crash.npth_repair.NpthRepair;

/* JADX INFO: loaded from: classes.dex */
public class MTKBufferOpt {
    private static final String TAG = "RenderD128Opt";
    protected static boolean doFix;
    protected static int fixErrno;

    public MTKBufferOpt() {
    }

    public static synchronized int doOpt(int r10) {
        monitor-enter(MTKBufferOpt.class);
    L20:
        th = move-exception;
        throw th;
    L5:
        if (NpthRepair.isInited() == true) goto L10;
        int r11 = -1;
    L7:
        monitor-exit(MTKBufferOpt.class);
        return r11;
    L10:
        if (doFix == false) goto L12;
        r11 = -2;
        goto L7
    L12:
        doFix = true;     // Catch: Throwable -> L20
        fixErrno = nOptMTKBuffer(r10);     // Catch: Throwable -> L15
    L17:
        int r12 = fixErrno;     // Catch: Throwable -> L20
        monitor-exit(MTKBufferOpt.class);
        return r12;
    L16:
        fixErrno = -4;     // Catch: Throwable -> L20
        goto L17
    }

    @Keep
    private static native int nOptMTKBuffer(int r10);
}
