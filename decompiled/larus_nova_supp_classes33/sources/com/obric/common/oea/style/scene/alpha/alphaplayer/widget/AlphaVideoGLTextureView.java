package com.obric.common.oea.style.scene.alpha.alphaplayer.widget;

import android.content.Context;
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
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\b\u0007\u0012\u0006\u0010 \u001a\u00020\u001f\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010!¢\u0006\u0004\b#\u0010$J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016J\u0010\u0010\u000e\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u000f\u001a\u00020\fH\u0016R$\u0010\u0016\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R$\u0010\u001e\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006%"}, d2 = {"Lcom/obric/common/oea/style/scene/alpha/alphaplayer/widget/AlphaVideoGLTextureView;", "Lcom/obric/common/oea/style/scene/alpha/alphaplayer/widget/GLTextureView;", "Ltja/a;", "Landroid/view/View;", "getView", "Loja/b;", "playerController", "", "setPlayerController", "Lrja/a;", "renderer", "setVideoRenderer", "Lcom/obric/common/oea/style/scene/alpha/alphaplayer/model/ScaleType;", "scaleType", "setScaleType", "getScaleType", "q", "Loja/b;", "getMPlayerController", "()Loja/b;", "setMPlayerController", "(Loja/b;)V", "mPlayerController", "Landroid/view/Surface;", "r", "Landroid/view/Surface;", "getMSurface", "()Landroid/view/Surface;", "setMSurface", "(Landroid/view/Surface;)V", "mSurface", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "style_standardRelease"}, k = 1, mv = {1, 4, 3})
public final class AlphaVideoGLTextureView extends GLTextureView implements tja.a {
    public volatile boolean l;
    public float m;
    public float n;
    public ScaleType o;
    public rja.a p;
    public oja.b q;
    public Surface r;
    public final a s;

    public static final class a implements rja.a.InterfaceC0070a {
        public final /* synthetic */ AlphaVideoGLTextureView a;

        public a(AlphaVideoGLTextureView r1) {
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
            this.a.l = true;
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
        public final /* synthetic */ AlphaVideoGLTextureView d;

        public b(rja.a r1, int r2, int r3, AlphaVideoGLTextureView r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        @Override // java.lang.Runnable
        public final void run() {
            rja.a r0 = this.a;     // Catch: Throwable -> L4
            float r1 = this.b;     // Catch: Throwable -> L4
            float r2 = this.c;     // Catch: Throwable -> L4
            AlphaVideoGLTextureView r3 = this.d;     // Catch: Throwable -> L4
            r0.h(r1, r2, r3.m, r3.n);     // Catch: Throwable -> L4
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
        rja.a r0 = this.p;
        if (r0 == null) goto L6;
        r0.onCompletion();
        return;
    }

    @Override // tja.a
    public final void onFirstFrame() {
        rja.a r0 = this.p;
        if (r0 == null) goto L6;
        r0.onFirstFrame();
        return;
    }

    @Override // tja.a
    public final void release() {
        a r0 = this.s;
        Surface r1 = r0.a.getMSurface();
        if (r1 == null) goto L5;
        r1.release();
    L5:
        r0.a.setMSurface(null);
        r0.a.l = false;
    }

    @Override // tja.a
    public final boolean a() {
        return this.l;
    }

    public final oja.b getMPlayerController() {
        return this.q;
    }

    public final Surface getMSurface() {
        return this.r;
    }

    @Override // tja.a
    public ScaleType getScaleType() {
        return this.o;
    }

    public AlphaVideoGLTextureView(Context r2) {
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
        this.q = r1;
    }

    public final void setMSurface(Surface r1) {
        this.r = r1;
    }

    @Override // tja.a
    public void setPlayerController(oja.b r2) {
        Intrinsics.checkNotNullParameter(r2, "playerController");
        this.q = r2;
    }

    public void setScaleType(ScaleType r2) {
        Intrinsics.checkNotNullParameter(r2, "scaleType");
        this.o = r2;
        rja.a r0 = this.p;
        if (r0 == null) goto L6;
        r0.m(r2);
        return;
    }

    @Override // tja.a
    public void setVideoRenderer(rja.a r2) {
        Intrinsics.checkNotNullParameter(r2, "renderer");
        this.p = r2;
        setRenderer(r2);
        rja.a r3 = this.p;
        if (r3 == null) goto L5;
        r3.f(this.s);
    L5:
        setRenderMode(0);
    }

    public AlphaVideoGLTextureView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, r4);
        this.o = ScaleType.ScaleAspectFill;
        a r5 = new a(this);
        this.s = r5;
        setEGLContextClientVersion(2);
        setEGLConfigChooser(new GLTextureView.b(this, 8, 16));
        rja.a r6 = this.p;
        if (r6 == null) goto L5;
        r6.f(r5);
    L5:
        setPreserveEGLContextOnPause(true);
        setOpaque(false);
    }

    @Override // tja.a
    public final void c(float r3, float r4) {
        float r0 = 0;
        if (r3 > r0) goto L5;
    L7:
        rja.a r5 = this.p;
        if (r5 == null) goto L17;
        b r1 = new b(r5, getMeasuredWidth(), getMeasuredHeight(), this);
        GLTextureView.i r6 = this.b;
        r6.getClass();
        GLTextureView.j r7 = GLTextureView.k;
        monitor-enter(r7);
        r6.K.add(r1);     // Catch: Throwable -> L14
        r7.notifyAll();     // Catch: Throwable -> L14
        monitor-exit(r7);     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        throw th;
    L17:
        return;
    L5:
        if (r4 <= r0) goto L7;
        this.m = r3;
        this.n = r4;
        goto L7
    }

    @Override // android.view.View
    public final void onMeasure(int r1, int r2) {
        super.onMeasure(r1, r2);
        c(this.m, this.n);
    }
}
