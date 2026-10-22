package com.obric.common.oea.foundation.effect;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import android.view.Choreographer;
import op.c;

/* JADX INFO: loaded from: classes2.dex */
public class GL3ShaderViewProgressBlur extends GLSurfaceView implements Choreographer.FrameCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f11336a;

    public GL3ShaderViewProgressBlur(Context r5) {
        super(r5, null);
    }

    @Override // android.view.Choreographer.FrameCallback
    public final void doFrame(long r5) {
        requestRender();
        Choreographer.getInstance().postFrameCallback(this);
    }

    @Override // android.opengl.GLSurfaceView
    public final void onPause() {
        Choreographer.getInstance().removeFrameCallback(this);
        super.onPause();
    }

    @Override // android.opengl.GLSurfaceView
    public final void onResume() {
        super.onResume();
        Choreographer.getInstance().postFrameCallback(this);
    }

    public void setBackgroundImage(Bitmap r5) {
        this.f11336a.V = r5;
    }

    public void setBlurRadius(float r5) {
        float r10 = r5 * 20.0f;
        this.f11336a.i0 = r10;
    }

    public void setClipRect(Rect r5) {
        this.f11336a.f20883k0.set(r5);
    }

    public void setDirection(int r5) {
        this.f11336a.f20881j0 = r5;
    }

    public GL3ShaderViewProgressBlur(Context r10, AttributeSet r11) {
        super(r10, r11);
        getHolder().setFormat(1);
        setZOrderOnTop(true);
        setEGLContextClientVersion(3);
        setEGLConfigChooser(8, 8, 8, 0, 0, 0);
        c r12 = new c(this);
        this.f11336a = r12;
        setRenderer(r12);
        setRenderMode(0);
        setPreserveEGLContextOnPause(true);
    }
}
