package com.byted.cast.render.jitterbuffer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public interface JitterBufferListener {
    void onAVSmoothOutput(byte[] r1, long r10);

    void onAudioReadyToPlay();
}
