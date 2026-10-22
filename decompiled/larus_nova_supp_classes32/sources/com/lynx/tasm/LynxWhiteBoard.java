package com.lynx.tasm;

import com.lynx.tasm.base.LLog;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
final class LynxWhiteBoard {
    public long a;

    private native long nativeCreate();

    private native void nativeDestroy(long r1);

    public final void a() {
        long r0 = this.a;
        if (r0 == 0) goto L6;
        nativeDestroy(r0);
        this.a = 0;
        return;
    }

    public LynxWhiteBoard() {
        this.a = 0;
        if (LynxEnv.inst().isNativeLibraryLoaded() == false) goto L5;
        this.a = nativeCreate();
        return;
    L5:
        LLog.e("LynxWhiteBoard", "LynxWhiteBoard create failed, since LynxEnv init failed.");
    }
}
