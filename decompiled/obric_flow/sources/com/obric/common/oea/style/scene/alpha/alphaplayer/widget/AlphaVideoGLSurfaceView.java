package com.obric.common.oea.style.scene.alpha.alphaplayer.widget;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.lynx.tasm.behavior.u;
import com.obric.common.oea.style.scene.alpha.AlphaView;
import com.obric.common.oea.style.scene.alpha.alphaplayer.model.ScaleType;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import up.a;
import xp.b;
import xp.c;
import zp.k;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0019\u0010\u001aR\u001a\u0010 \u001a\u00020\u001b8\u0006X\u0086D¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\"\u0010(\u001a\u00020!8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\"\u0010,\u001a\u00020!8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b)\u0010#\u001a\u0004\b*\u0010%\"\u0004\b+\u0010'R\"\u00101\u001a\u00020\u00158\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b/\u0010\u001a\"\u0004\b0\u0010\u0018R$\u00107\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b2\u00103\u001a\u0004\b4\u00105\"\u0004\b6\u0010\u0014R$\u0010=\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b8\u00109\u001a\u0004\b:\u0010;\"\u0004\b<\u0010\u0010R$\u0010E\u001a\u0004\u0018\u00010>8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b?\u0010@\u001a\u0004\bA\u0010B\"\u0004\bC\u0010D¨\u0006F"}, d2 = {"Lcom/obric/common/oea/style/scene/alpha/alphaplayer/widget/AlphaVideoGLSurfaceView;", "Landroid/opengl/GLSurfaceView;", "Lzp/k;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "Landroid/view/View;", "getView", "()Landroid/view/View;", "Lup/a;", "playerController", "", "setPlayerController", "(Lup/a;)V", "Lxp/b;", "renderer", "setVideoRenderer", "(Lxp/b;)V", "Lcom/obric/common/oea/style/scene/alpha/alphaplayer/model/ScaleType;", "scaleType", "setScaleType", "(Lcom/obric/common/oea/style/scene/alpha/alphaplayer/model/ScaleType;)V", "getScaleType", "()Lcom/obric/common/oea/style/scene/alpha/alphaplayer/model/ScaleType;", "", "a", "I", "getGL_CONTEXT_VERSION", "()I", "GL_CONTEXT_VERSION", "", "b", "F", "getMVideoWidth", "()F", "setMVideoWidth", "(F)V", "mVideoWidth", "c", "getMVideoHeight", "setMVideoHeight", "mVideoHeight", "d", "Lcom/obric/common/oea/style/scene/alpha/alphaplayer/model/ScaleType;", "getMScaleType", "setMScaleType", "mScaleType", "e", "Lxp/b;", "getMRenderer", "()Lxp/b;", "setMRenderer", "mRenderer", "f", "Lup/a;", "getMPlayerController", "()Lup/a;", "setMPlayerController", "mPlayerController", "Landroid/view/Surface;", "g", "Landroid/view/Surface;", "getMSurface", "()Landroid/view/Surface;", "setMSurface", "(Landroid/view/Surface;)V", "mSurface", "style_standardRelease"}, k = 1, mv = {1, 4, 3})
public final class AlphaVideoGLSurfaceView extends GLSurfaceView implements k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f11353a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f11354b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f11355c;
    public ScaleType d;
    public b e;
    public a f;
    public Surface g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final jg.k f11356h;

    @JvmOverloads
    public AlphaVideoGLSurfaceView(Context r5) {
        this(r5, null);
    }

    @Override // zp.k
    public final void a() {
        b r5 = this.e;
        if (r5 == null) goto L6;
        ((c) r5).e();
        return;
    }

    @Override // zp.k
    public final void b(float r10, float r11) {
        float r5 = 0;
        if (r10 > r5) goto L5;
    L7:
        b r12 = this.e;
        if (r12 == null) goto L11;
        queueEvent(new u(r12, getMeasuredWidth(), getMeasuredHeight(), this, 1));
        return;
    L11:
        return;
    L5:
        if (r11 <= r5) goto L7;
        this.f11354b = r10;
        this.f11355c = r11;
        goto L7
    }

    @Override // zp.k
    public final void c(AlphaView r5) {
        Intrinsics.checkNotNullParameter(r5, "parentView");
        if (r5.indexOfChild(this) != (-1)) goto L9;
        ViewParent r10 = getParent();
        if (r10 == null) goto L7;
        ((ViewGroup) r10).removeView(this);
    L7:
        r5.addView(this);
        return;
    }

    @Override // zp.k
    public final void d(AlphaView r5) {
        Intrinsics.checkNotNullParameter(r5, "parentView");
        r5.removeView(this);
    }

    @Override // zp.k
    public final void e() {
        b r5 = this.e;
        if (r5 == null) goto L6;
        ((c) r5).d();
        return;
    }

    public final int getGL_CONTEXT_VERSION() {
        return this.f11353a;
    }

    public final a getMPlayerController() {
        return this.f;
    }

    public final b getMRenderer() {
        return this.e;
    }

    public final ScaleType getMScaleType() {
        return this.d;
    }

    public final Surface getMSurface() {
        return this.g;
    }

    public final float getMVideoHeight() {
        return this.f11355c;
    }

    public final float getMVideoWidth() {
        return this.f11354b;
    }

    @Override // zp.k
    public ScaleType getScaleType() {
        return this.d;
    }

    public View getView() {
        return this;
    }

    @Override // android.view.SurfaceView, android.view.View
    public final void onMeasure(int r5, int r10) {
        super.onMeasure(r5, r10);
        b(this.f11354b, this.f11355c);
    }

    @Override // zp.k
    public final void release() {
        jg.k r5 = this.f11356h;
        Surface r10 = ((AlphaVideoGLSurfaceView) r5.f18339b).getMSurface();
        if (r10 == null) goto L5;
        r10.release();
    L5:
        AlphaVideoGLSurfaceView r11 = (AlphaVideoGLSurfaceView) r5.f18339b;
        r11.setMSurface(null);
        r11.getClass();
    }

    public final void setMPlayerController(a r5) {
        this.f = r5;
    }

    public final void setMRenderer(b r5) {
        this.e = r5;
    }

    public final void setMScaleType(ScaleType r5) {
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        this.d = r5;
    }

    public final void setMSurface(Surface r5) {
        this.g = r5;
    }

    public final void setMVideoHeight(float r5) {
        this.f11355c = r5;
    }

    public final void setMVideoWidth(float r5) {
        this.f11354b = r5;
    }

    @Override // zp.k
    public void setPlayerController(a r5) {
        Intrinsics.checkNotNullParameter(r5, "playerController");
        this.f = r5;
    }

    public void setScaleType(ScaleType r5) {
        Intrinsics.checkNotNullParameter(r5, "scaleType");
        this.d = r5;
        b r10 = this.e;
        if (r10 == null) goto L6;
        Intrinsics.checkNotNullParameter(r5, "scaleType");
        ((c) r10).f23205p = r5;
        return;
    }

    @Override // zp.k
    public void setVideoRenderer(b r5) {
        Intrinsics.checkNotNullParameter(r5, "renderer");
        this.e = r5;
        setRenderer(r5);
        b r10 = this.e;
        if (r10 == null) goto L5;
        jg.k r11 = this.f11356h;
        Intrinsics.checkNotNullParameter(r11, "surfaceListener");
        ((c) r10).f23204o = r11;
    L5:
        setRenderMode(0);
    }

    @JvmOverloads
    public AlphaVideoGLSurfaceView(Context r10, AttributeSet r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11);
        this.f11353a = 2;
        this.d = ScaleType.ScaleAspectFill;
        jg.k r12 = new jg.k(this, 13);
        this.f11356h = r12;
        setEGLContextClientVersion(2);
        setEGLConfigChooser(8, 8, 8, 8, 16, 0);
        getHolder().setFormat(-3);
        b r13 = this.e;
        if (r13 == null) goto L5;
        Intrinsics.checkNotNullParameter(r12, "surfaceListener");
        ((c) r13).f23204o = r12;
    L5:
        setZOrderOnTop(true);
        setPreserveEGLContextOnPause(true);
    }
}
