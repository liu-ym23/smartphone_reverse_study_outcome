package com.byted.cast.sdk.render.audio;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public interface AudioJitterBufferCallback {
    void onAudioReadyToPlay();

    void onAudioSmoothOutput(byte[] r1);
}
