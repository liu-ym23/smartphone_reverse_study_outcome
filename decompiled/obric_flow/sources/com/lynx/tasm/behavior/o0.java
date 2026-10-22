package com.lynx.tasm.behavior;

import android.view.PixelCopy;

/* JADX INFO: loaded from: classes2.dex */
public final class o0 implements PixelCopy.OnPixelCopyFinishedListener {
    @Override // android.view.PixelCopy.OnPixelCopyFinishedListener
    public final void onPixelCopyFinished(int r5) {
        Object r10 = LynxUIRenderer.f10158n;
        monitor-enter(r10);
        r10.notify();     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
