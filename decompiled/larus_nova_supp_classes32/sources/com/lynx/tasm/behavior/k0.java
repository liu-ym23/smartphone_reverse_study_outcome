package com.lynx.tasm.behavior;

import android.view.PixelCopy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class k0 implements PixelCopy.OnPixelCopyFinishedListener {
    public k0() {
    }

    @Override // android.view.PixelCopy.OnPixelCopyFinishedListener
    public final void onPixelCopyFinished(int r2) {
        Object r3 = LynxUIRenderer.p;
        monitor-enter(r3);
        r3.notify();     // Catch: Throwable -> L7
        monitor-exit(r3);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
