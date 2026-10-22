package com.lynx.animax.player;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public interface IVideoPlayer {
    void attachAsset(VideoAsset r1);

    void destroy();

    float[] getTransformMatrix();

    void setSurface(int r1);

    boolean updateSurface(int r1);
}
