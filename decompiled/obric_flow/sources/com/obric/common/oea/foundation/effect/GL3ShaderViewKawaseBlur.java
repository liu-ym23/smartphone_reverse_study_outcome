package com.obric.common.oea.foundation.effect;

import android.content.Context;
import android.graphics.Bitmap;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import android.view.Choreographer;
import op.b;

/* JADX INFO: loaded from: classes2.dex */
public class GL3ShaderViewKawaseBlur extends GLSurfaceView implements Choreographer.FrameCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f11335a;

    public GL3ShaderViewKawaseBlur(Context r5) {
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
        this.f11335a.R = r5;
    }

    public void setBlurRadius(float r5) {
        b r10 = this.f11335a;
        if (r10.f20848d0 == r5) goto L6;
        r10.f20848d0 = r5;
        r10.f20847c0 = r5 * 10.0f;
        return;
    }

    public GL3ShaderViewKawaseBlur(Context r10, AttributeSet r11) {
        super(r10, r11);
        getHolder().setFormat(1);
        setZOrderOnTop(true);
        setEGLContextClientVersion(3);
        setEGLConfigChooser(8, 8, 8, 0, 0, 0);
        b r12 = new b(this);
        this.f11335a = r12;
        setRenderer(r12);
        setRenderMode(0);
        setPreserveEGLContextOnPause(true);
    }
}
