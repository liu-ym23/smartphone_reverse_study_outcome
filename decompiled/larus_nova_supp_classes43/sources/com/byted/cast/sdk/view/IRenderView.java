package com.byted.cast.sdk.view;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public interface IRenderView {
    public static final int AR_16_9_FIT_PARENT = 4;
    public static final int AR_4_3_FIT_PARENT = 5;
    public static final int AR_ASPECT_FILL_PARENT = 1;
    public static final int AR_ASPECT_FIT_PARENT = 0;
    public static final int AR_ASPECT_WRAP_CONTENT = 2;
    public static final int AR_MATCH_PARENT = 3;

    public interface IRenderCallback {
        void onSurfaceChanged(ISurfaceHolder r1, int r10, int r11, int r12);

        void onSurfaceCreated(ISurfaceHolder r1, int r10, int r11);

        void onSurfaceDestroyed(ISurfaceHolder r1);

        void onSurfaceTextureCreated(IRenderView r1, Surface r10);
    }

    public interface ISurfaceHolder {
        IRenderView getRenderView();

        SurfaceHolder getSurfaceHolder();

        SurfaceTexture getSurfaceTexture();

        Surface openSurface();
    }

    void addRenderCallback(IRenderCallback r1);

    View getView();

    void removeRenderCallback(IRenderCallback r1);

    void setAspectRatio(int r1);

    void setVideoRotation(int r1);

    void setVideoSampleAspectRatio(int r1, int r10);

    void setVideoSize(int r1, int r10);
}
