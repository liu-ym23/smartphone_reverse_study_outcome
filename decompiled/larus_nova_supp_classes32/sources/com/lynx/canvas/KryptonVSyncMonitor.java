package com.lynx.canvas;

import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class KryptonVSyncMonitor {
    private WeakReference<KryptonApp> mApp;

    private static native void nativeOnBeforeVSyncEndTrigger(long r0, long r2);

    private static native void nativeOnVSyncTrigger(long r0, long r2);

    public KryptonVSyncMonitor(KryptonApp r2) {
        this.mApp = new WeakReference(r2);
    }

    public void registerBeforeAnimationEnd(final long r3) {
        KryptonApp r0 = this.mApp.get();
        if (r0 != null) goto L5;
        return;
    L5:
        KryptonFrameService r1 = (KryptonFrameService) r0.getService(KryptonFrameService.class);
        if (r1 != null) goto L8;
        return;
    L8:
        r1.registerBeforeVSyncEndListener(new AnonymousClass2(this, r3));
    }

    public void requestVSync(final long r3) {
        KryptonApp r0 = this.mApp.get();
        if (r0 != null) goto L5;
        return;
    L5:
        KryptonFrameService r1 = (KryptonFrameService) r0.getService(KryptonFrameService.class);
        if (r1 != null) goto L8;
        return;
    L8:
        r1.requestVSync(new AnonymousClass1(this, r3));
    }

    public static /* synthetic */ void access$000(long r0, long r2) {
        nativeOnVSyncTrigger(r0, r2);
    }

    public static /* synthetic */ void access$100(long r0, long r2) {
        nativeOnBeforeVSyncEndTrigger(r0, r2);
    }
}
