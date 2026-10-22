package com.lynx.tasm;

import com.lynx.base.log.LynxLog;

/* JADX INFO: loaded from: classes2.dex */
final class LynxWhiteBoard {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f10046a;

    public LynxWhiteBoard() {
        this.f10046a = 0;
        if (LynxEnv.inst().isNativeLibraryLoaded() == false) goto L6;
        this.f10046a = nativeCreate();
        return;
    L6:
        LynxLog.b(4, "LynxWhiteBoard", "LynxWhiteBoard create failed, since LynxEnv init failed.");
    }

    private native long nativeCreate();

    private native void nativeDestroy(long r5);

    public final void a() {
        long r5 = this.f10046a;
        if (r5 == 0) goto L6;
        nativeDestroy(r5);
        this.f10046a = 0;
        return;
    }
}
