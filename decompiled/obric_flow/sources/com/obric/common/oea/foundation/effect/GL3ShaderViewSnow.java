package com.obric.common.oea.foundation.effect;

import android.content.Context;
import android.graphics.Bitmap;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import android.view.Choreographer;
import op.e;

/* JADX INFO: loaded from: classes2.dex */
public class GL3ShaderViewSnow extends GLSurfaceView implements Choreographer.FrameCallback {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f11339b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f11340a;

    public GL3ShaderViewSnow(Context r5) {
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
        this.f11340a.f20940z = r5;
    }

    public void setFrostImage(Bitmap r5) {
        this.f11340a.A = r5;
    }

    public void setShaderAlpha(float r5) {
        this.f11340a.f20935u.f18208a = r5;
    }

    public void setShaderIntensity(float r5) {
        this.f11340a.f20936v.f18208a = r5;
    }

    public void setShaderSpeed(float r5) {
        this.f11340a.f20937w.f18208a = r5;
    }

    public GL3ShaderViewSnow(Context r10, AttributeSet r11) {
        super(r10, r11);
        getHolder().setFormat(1);
        setZOrderOnTop(true);
        setEGLContextClientVersion(3);
        setEGLConfigChooser(8, 8, 8, 0, 0, 0);
        e r12 = new e(getContext());
        this.f11340a = r12;
        setRenderer(r12);
        setRenderMode(0);
        setPreserveEGLContextOnPause(true);
    }
}
