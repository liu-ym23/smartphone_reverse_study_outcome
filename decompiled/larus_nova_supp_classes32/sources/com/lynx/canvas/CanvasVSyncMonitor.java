package com.lynx.canvas;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class CanvasVSyncMonitor {
    private KryptonFrameService mFrameService;

    public CanvasVSyncMonitor() {
    }

    private static native void nativeOnVSync(long r0, long r2);

    public void requestVSync(final long r3) {
        KryptonFrameService r0 = this.mFrameService;
        if (r0 == null) goto L6;
        r0.requestVSync(new AnonymousClass1(this, r3));
        return;
    }

    public void setFrameService(KryptonFrameService r1) {
        this.mFrameService = r1;
    }

    public static /* synthetic */ void access$000(long r0, long r2) {
        doFrame(r0, r2);
    }

    private static void doFrame(long r0, long r2) {
        nativeOnVSync(r0, r2);
    }
}
