package com.byted.cast.sdk.render.video;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public interface VideoJitterBufferCallback {
    void onOutputFrame(long r1);

    void onRenderFrame(long r1);

    void onVideoSize(int r1, int r10);
}
