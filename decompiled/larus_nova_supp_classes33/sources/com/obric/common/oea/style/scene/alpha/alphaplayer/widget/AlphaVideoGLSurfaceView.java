package com.obric.common.oea.style.scene.alpha.alphaplayer.widget;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.common.oea.style.scene.alpha.alphaplayer.model.ScaleType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\b\u0007\u0012\u0006\u0010@\u001a\u00020?\u0012\n\b\u0002\u0010B\u001a\u0004\u0018\u00010A¢\u0006\u0004\bC\u0010DJ\b\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016J\u0010\u0010\u000e\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u000f\u001a\u00020\fH\u0016R\u001a\u0010\u0015\u001a\u00020\u00108\u0006X\u0086D¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\"\u0010\u001d\u001a\u00020\u00168\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\"\u0010!\u001a\u00020\u00168\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u0018\u001a\u0004\b\u001f\u0010\u001a\"\u0004\b \u0010\u001cR\"\u0010(\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R$\u0010/\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R$\u00106\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105R$\u0010>\u001a\u0004\u0018\u0001078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b8\u00109\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=¨\u0006E"}, d2 = {"Lcom/obric/common/oea/style/scene/alpha/alphaplayer/widget/AlphaVideoGLSurfaceView;", "Landroid/opengl/GLSurfaceView;", "Ltja/a;", "Landroid/view/View;", "getView", "Loja/b;", "playerController", "", "setPlayerController", "Lrja/a;", "renderer", "setVideoRenderer", "Lcom/obric/common/oea/style/scene/alpha/alphaplayer/model/ScaleType;", "scaleType", "setScaleType", "getScaleType", "", "a", "I", "getGL_CONTEXT_VERSION", "()I", "GL_CONTEXT_VERSION", "", "c", "F", "getMVideoWidth", "()F", "setMVideoWidth", "(F)V", "mVideoWidth", "d", "getMVideoHeight", "setMVideoHeight", "mVideoHeight", "e", "Lcom/obric/common/oea/style/scene/alpha/alphaplayer/model/ScaleType;", "getMScaleType", "()Lcom/obric/common/oea/style/scene/alpha/alphaplayer/model/ScaleType;", "setMScaleType", "(Lcom/obric/common/oea/style/scene/alpha/alphaplayer/model/ScaleType;)V", "mScaleType", "f", "Lrja/a;", "getMRenderer", "()Lrja/a;", "setMRenderer", "(Lrja/a;)V", "mRenderer", "g", "Loja/b;", "getMPlayerController", "()Loja/b;", "setMPlayerController", "(Loja/b;)V", "mPlayerController", "Landroid/view/Surface;", "h", "Landroid/view/Surface;", "getMSurface", "()Landroid/view/Surface;", "setMSurface", "(Landroid/view/Surface;)V", "mSurface", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "style_standardRelease"}, k = 1, mv = {1, 4, 3})
public final class AlphaVideoGLSurfaceView extends GLSurfaceView implements tja.a {
    public final int a;
    public volatile boolean b;
    public float c;
    public float d;
    public ScaleType e;
    public rja.a f;
    public oja.b g;
    public Surface h;
    public final a i;

    public static final class a implements rja.a.InterfaceC0070a {
        public final /* synthetic */ AlphaVideoGLSurfaceView a;

        public a(AlphaVideoGLSurfaceView r1) {
            this.a = r1;
        }

        @Override // rja.a.InterfaceC0070a
        public final void a(Surface r3) {
            Intrinsics.checkNotNullParameter(r3, "surface");
            Surface r0 = this.a.getMSurface();
            if (r0 == null) goto L5;
            r0.release();
        L5:
            this.a.setMSurface(r3);
            this.a.b = true;
            oja.b r1 = this.a.getMPlayerController();
            if (r1 == null) goto L8;
            r1.a(r3);
        L8:
            oja.b r4 = this.a.getMPlayerController();
            if (r4 == null) goto L12;
            r4.resume();
            return;
        }
    }

    public static final class b implements Runnable {
        public final /* synthetic */ rja.a a;
        public final /* synthetic */ int b;
        public final /* synthetic */ int c;
        public final /* synthetic */ AlphaVideoGLSurfaceView d;

        public b(rja.a r1, int r2, int r3, AlphaVideoGLSurfaceView r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.h(this.b, this.c, this.d.getMVideoWidth(), this.d.getMVideoHeight());     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public View getView() {
        return this;
    }

    @Override // tja.a
    public final void onCompletion() {
        rja.a r0 = this.f;
        if (r0 == null) goto L6;
        r0.onCompletion();
        return;
    }

    @Override // tja.a
    public final void onFirstFrame() {
        rja.a r0 = this.f;
        if (r0 == null) goto L6;
        r0.onFirstFrame();
        return;
    }

    @Override // tja.a
    public final void release() {
        a r0 = this.i;
        Surface r1 = r0.a.getMSurface();
        if (r1 == null) goto L5;
        r1.release();
    L5:
        r0.a.setMSurface(null);
        r0.a.b = false;
    }

    @Override // tja.a
    public final boolean a() {
        return this.b;
    }

    public final int getGL_CONTEXT_VERSION() {
        return this.a;
    }

    public final oja.b getMPlayerController() {
        return this.g;
    }

    public final rja.a getMRenderer() {
        return this.f;
    }

    public final ScaleType getMScaleType() {
        return this.e;
    }

    public final Surface getMSurface() {
        return this.h;
    }

    public final float getMVideoHeight() {
        return this.d;
    }

    public final float getMVideoWidth() {
        return this.c;
    }

    @Override // tja.a
    public ScaleType getScaleType() {
        return this.e;
    }

    public AlphaVideoGLSurfaceView(Context r2) {
        this(r2, null);
    }

    @Override // tja.a
    public final void b(ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r2, "parentView");
        r2.removeView(this);
    }

    @Override // tja.a
    public final void d(ViewGroup r3) {
        Intrinsics.checkNotNullParameter(r3, "parentView");
        if (r3.indexOfChild(this) != (-1)) goto L9;
        ViewParent r0 = getParent();
        if (r0 == null) goto L7;
        ((ViewGroup) r0).removeView(this);
    L7:
        r3.addView(this);
        return;
    }

    public final void setMPlayerController(oja.b r1) {
        this.g = r1;
    }

    public final void setMRenderer(rja.a r1) {
        this.f = r1;
    }

    public final void setMScaleType(ScaleType r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.e = r2;
    }

    public final void setMSurface(Surface r1) {
        this.h = r1;
    }

    public final void setMVideoHeight(float r1) {
        this.d = r1;
    }

    public final void setMVideoWidth(float r1) {
        this.c = r1;
    }

    @Override // tja.a
    public void setPlayerController(oja.b r2) {
        Intrinsics.checkNotNullParameter(r2, "playerController");
        this.g = r2;
    }

    public void setScaleType(ScaleType r2) {
        Intrinsics.checkNotNullParameter(r2, "scaleType");
        this.e = r2;
        rja.a r0 = this.f;
        if (r0 == null) goto L6;
        r0.m(r2);
        return;
    }

    @Override // tja.a
    public void setVideoRenderer(rja.a r2) {
        Intrinsics.checkNotNullParameter(r2, "renderer");
        this.f = r2;
        setRenderer(r2);
        rja.a r3 = this.f;
        if (r3 == null) goto L5;
        r3.f(this.i);
    L5:
        setRenderMode(0);
    }

    public AlphaVideoGLSurfaceView(Context r8, AttributeSet r9) {
        Intrinsics.checkNotNullParameter(r8, "context");
        super(r8, r9);
        this.a = 2;
        this.e = ScaleType.ScaleAspectFill;
        a r10 = new a(this);
        this.i = r10;
        setEGLContextClientVersion(2);
        setEGLConfigChooser(8, 8, 8, 8, 16, 0);
        getHolder().setFormat(-3);
        rja.a r11 = this.f;
        if (r11 == null) goto L5;
        r11.f(r10);
    L5:
        setZOrderOnTop(true);
        setPreserveEGLContextOnPause(true);
    }

    @Override // tja.a
    public final void c(float r3, float r4) {
        float r0 = 0;
        if (r3 > r0) goto L5;
    L7:
        rja.a r5 = this.f;
        if (r5 == null) goto L11;
        queueEvent(new b(r5, getMeasuredWidth(), getMeasuredHeight(), this));
        return;
    L11:
        return;
    L5:
        if (r4 <= r0) goto L7;
        this.c = r3;
        this.d = r4;
        goto L7
    }

    @Override // android.view.SurfaceView, android.view.View
    public final void onMeasure(int r1, int r2) {
        super.onMeasure(r1, r2);
        c(this.c, this.d);
    }
}
