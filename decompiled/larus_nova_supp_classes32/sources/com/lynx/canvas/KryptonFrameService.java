package com.lynx.canvas;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public abstract class KryptonFrameService extends KryptonService {

    public interface FrameCallback {
        void doFrame(long r1);
    }

    public abstract void registerBeforeVSyncEndListener(FrameCallback r1);

    public abstract void requestVSync(FrameCallback r1);

    public abstract void setPreferredFramesPerSecond(long r1);

    public KryptonFrameService() {
    }
}
