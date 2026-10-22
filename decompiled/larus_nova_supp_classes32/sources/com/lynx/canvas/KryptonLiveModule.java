package com.lynx.canvas;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public abstract class KryptonLiveModule extends KryptonModule {

    public interface IAudioSampleListener {
        void onAudioSample(ByteBuffer r1, int r2);
    }

    public interface IVideoFrameListener {
        void onVideoFrame(ByteBuffer r1, int r2, int r3);
    }

    public static String moduleName() {
        return "live";
    }

    public abstract void flushCapture(IVideoFrameListener r1, IAudioSampleListener r2);

    public abstract void setBackgroundVolume(float r1);

    public abstract void setEnableCaptureMicrophone(boolean r1);

    public abstract void setMicrophoneVolume(float r1);

    public abstract boolean startCapture(int r1, int r2, int r3, String r4, int r5, boolean r6);

    public abstract void stopCapture();

    public KryptonLiveModule() {
    }
}
