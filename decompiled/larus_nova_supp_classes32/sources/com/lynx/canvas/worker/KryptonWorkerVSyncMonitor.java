package com.lynx.canvas.worker;

import android.view.Choreographer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class KryptonWorkerVSyncMonitor {
    public KryptonWorkerVSyncMonitor() {
    }

    private static native void nativeOnWorkerVSync(long r0, long r2);

    private static void requestWorkerVSync(final long r2) {
        Choreographer.getInstance().postFrameCallback(new AnonymousClass1(r2));
    }

    public static /* synthetic */ void access$000(long r0, long r2) {
        nativeOnWorkerVSync(r0, r2);
    }
}
