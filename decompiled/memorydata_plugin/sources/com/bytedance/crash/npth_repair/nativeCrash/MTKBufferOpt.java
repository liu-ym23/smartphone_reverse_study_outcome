package com.bytedance.crash.npth_repair.nativeCrash;

import com.bytedance.crash.npth_repair.NpthRepair;

/* JADX INFO: loaded from: classes2.dex */
public class MTKBufferOpt {
    private static final String TAG = "RenderD128Opt";
    protected static boolean doFix;
    protected static int fixErrno;

    public MTKBufferOpt() {
    }

    public static synchronized int doOpt(int r2) {
        monitor-enter(MTKBufferOpt.class);
    L20:
        th = move-exception;
        throw th;
    L5:
        if (NpthRepair.isInited() == true) goto L10;
        int r3 = -1;
    L7:
        monitor-exit(MTKBufferOpt.class);
        return r3;
    L10:
        if (doFix == false) goto L12;
        r3 = -2;
        goto L7
    L12:
        doFix = true;     // Catch: Throwable -> L20
        fixErrno = nOptMTKBuffer(r2);     // Catch: Throwable -> L15
    L17:
        int r4 = fixErrno;     // Catch: Throwable -> L20
        monitor-exit(MTKBufferOpt.class);
        return r4;
    L16:
        fixErrno = -4;     // Catch: Throwable -> L20
        goto L17
    }

    private static native int nOptMTKBuffer(int r0);
}
