package com.lynx.animax.player;

import com.lynx.animax.base.CalledByNative;

/* JADX INFO: loaded from: classes2.dex */
public interface IVideoPlayer {
    @CalledByNative
    void attachAsset(VideoAsset r5);

    @CalledByNative
    void destroy();

    @CalledByNative
    float[] getTransformMatrix();

    @CalledByNative
    void setSurface(int r5);

    @CalledByNative
    boolean updateSurface(int r5);
}
