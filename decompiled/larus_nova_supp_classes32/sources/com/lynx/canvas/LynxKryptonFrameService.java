package com.lynx.canvas;

import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class LynxKryptonFrameService extends KryptonFrameService {
    private ArrayList<KryptonFrameService.FrameCallback> mBeforeVsyncEndCallbacks;
    private ArrayList<KryptonFrameService.FrameCallback> mCallbacks;
    private long mNativeFrameService;

    private native long nativeCreateFrameService(long r1);

    private native void nativeDestroyFrameService(long r1);

    private native void nativeDoRegisterBeforeVSyncEndListener(long r1);

    private native void nativeDoRequestVSync(long r1);

    @Override // com.lynx.canvas.KryptonFrameService
    public void setPreferredFramesPerSecond(long r1) {
    }

    @Override // com.lynx.canvas.KryptonService
    public void onDestroy() {
        long r0 = this.mNativeFrameService;
        if (r0 == 0) goto L6;
        nativeDestroyFrameService(r0);
        this.mNativeFrameService = 0;
        return;
    }

    public LynxKryptonFrameService(long r2) {
        this.mCallbacks = new ArrayList();
        this.mBeforeVsyncEndCallbacks = new ArrayList();
        this.mNativeFrameService = nativeCreateFrameService(r2);
    }

    public void OnBeforeVSyncEnd(long r3) {
        Iterator<KryptonFrameService.FrameCallback> r0 = this.mBeforeVsyncEndCallbacks.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().doFrame(r3);
        goto L4
    }

    public void OnVSync(long r3) {
        ArrayList r0 = new ArrayList(this.mCallbacks);
        this.mCallbacks.clear();
        Iterator r1 = r0.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        ((KryptonFrameService.FrameCallback) r1.next()).doFrame(r3);
        goto L4
    }

    @Override // com.lynx.canvas.KryptonFrameService
    public void registerBeforeVSyncEndListener(KryptonFrameService.FrameCallback r3) {
        this.mBeforeVsyncEndCallbacks.add(r3);
        nativeDoRegisterBeforeVSyncEndListener(this.mNativeFrameService);
    }

    @Override // com.lynx.canvas.KryptonFrameService
    public void requestVSync(KryptonFrameService.FrameCallback r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        this.mCallbacks.add(r3);
        nativeDoRequestVSync(this.mNativeFrameService);
    }
}
