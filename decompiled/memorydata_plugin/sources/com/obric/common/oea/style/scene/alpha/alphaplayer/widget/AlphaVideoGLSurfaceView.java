package com.obric.common.oea.style.scene.alpha.alphaplayer.widget;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.obric.common.oea.style.scene.alpha.alphaplayer.model.ScaleType;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000q\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011*\u0001'\u0018\u00002\u00020\u00012\u00020\u0002B\u001b\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0006\u00102\u001a\u000203J\u0010\u00104\u001a\u0002032\u0006\u00105\u001a\u000206H\u0016J\b\u00107\u001a\u00020\u001bH\u0016J\b\u00108\u001a\u000209H\u0016J\b\u0010\f\u001a\u00020\rH\u0016J\u0018\u0010:\u001a\u0002032\u0006\u0010;\u001a\u00020*2\u0006\u0010<\u001a\u00020*H\u0016J\b\u0010=\u001a\u000203H\u0016J\b\u0010>\u001a\u000203H\u0016J\u0018\u0010?\u001a\u0002032\u0006\u0010@\u001a\u00020\t2\u0006\u0010A\u001a\u00020\tH\u0014J\b\u0010B\u001a\u000203H\u0016J\u0010\u0010C\u001a\u0002032\u0006\u00105\u001a\u000206H\u0016J\u0010\u0010D\u001a\u0002032\u0006\u0010E\u001a\u00020\u000fH\u0016J\u0010\u0010F\u001a\u0002032\u0006\u0010G\u001a\u00020\u001bH\u0016J\u0010\u0010H\u001a\u0002032\u0006\u0010I\u001a\u00020\u0015H\u0016R\u0014\u0010\b\u001a\u00020\tX\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001c\u0010 \u001a\u0004\u0018\u00010!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u0010\u0010&\u001a\u00020'X\u0082\u0004¢\u0006\u0004\n\u0002\u0010(R\u001a\u0010)\u001a\u00020*X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001a\u0010/\u001a\u00020*X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010,\"\u0004\b1\u0010.¨\u0006J"}, d2 = {"Lcom/obric/common/oea/style/scene/alpha/alphaplayer/widget/AlphaVideoGLSurfaceView;", "Landroid/opengl/GLSurfaceView;", "Lcom/obric/common/oea/style/scene/alpha/alphaplayer/widget/IAlphaVideoView;", "context", "Landroid/content/Context;", "attr", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "GL_CONTEXT_VERSION", "", "getGL_CONTEXT_VERSION", "()I", "isSurfaceCreated", "", "mPlayerController", "Lcom/obric/common/oea/style/scene/alpha/alphaplayer/controller/IPlayerControllerExt;", "getMPlayerController", "()Lcom/obric/common/oea/style/scene/alpha/alphaplayer/controller/IPlayerControllerExt;", "setMPlayerController", "(Lcom/obric/common/oea/style/scene/alpha/alphaplayer/controller/IPlayerControllerExt;)V", "mRenderer", "Lcom/obric/common/oea/style/scene/alpha/alphaplayer/render/IRender;", "getMRenderer", "()Lcom/obric/common/oea/style/scene/alpha/alphaplayer/render/IRender;", "setMRenderer", "(Lcom/obric/common/oea/style/scene/alpha/alphaplayer/render/IRender;)V", "mScaleType", "Lcom/obric/common/oea/style/scene/alpha/alphaplayer/model/ScaleType;", "getMScaleType", "()Lcom/obric/common/oea/style/scene/alpha/alphaplayer/model/ScaleType;", "setMScaleType", "(Lcom/obric/common/oea/style/scene/alpha/alphaplayer/model/ScaleType;)V", "mSurface", "Landroid/view/Surface;", "getMSurface", "()Landroid/view/Surface;", "setMSurface", "(Landroid/view/Surface;)V", "mSurfaceListener", "com/obric/common/oea/style/scene/alpha/alphaplayer/widget/AlphaVideoGLSurfaceView$mSurfaceListener$1", "Lcom/obric/common/oea/style/scene/alpha/alphaplayer/widget/AlphaVideoGLSurfaceView$mSurfaceListener$1;", "mVideoHeight", "", "getMVideoHeight", "()F", "setMVideoHeight", "(F)V", "mVideoWidth", "getMVideoWidth", "setMVideoWidth", "addOnSurfacePreparedListener", "", "addParentView", "parentView", "Landroid/view/ViewGroup;", "getScaleType", "getView", "Landroid/view/View;", "measureInternal", "videoWidth", "videoHeight", "onCompletion", "onFirstFrame", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "release", "removeParentView", "setPlayerController", "playerController", "setScaleType", "scaleType", "setVideoRenderer", "renderer", "style_standardRelease"}, k = 1, mv = {1, 4, 3})
public final class AlphaVideoGLSurfaceView extends GLSurfaceView implements com.obric.common.oea.style.scene.alpha.alphaplayer.widget.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f7801a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile boolean f7802b;
    private float c;
    private float d;
    private ScaleType e;
    private com.obric.common.oea.style.scene.alpha.alphaplayer.a.a f;
    private com.obric.common.oea.style.scene.alpha.alphaplayer.controller.b g;
    private Surface h;
    private final a i;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"com/obric/common/oea/style/scene/alpha/alphaplayer/widget/AlphaVideoGLSurfaceView$mSurfaceListener$1", "Lcom/obric/common/oea/style/scene/alpha/alphaplayer/render/IRender$SurfaceListener;", "onSurfaceDestroyed", "", "onSurfacePrepared", "surface", "Landroid/view/Surface;", "style_standardRelease"}, k = 1, mv = {1, 4, 3})
    public static final class a implements com.obric.common.oea.style.scene.alpha.alphaplayer.a.a.InterfaceC0378a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AlphaVideoGLSurfaceView f7803a;

        a(AlphaVideoGLSurfaceView r1) {
            this.f7803a = r1;
        }

        public void a() {
            Surface r0 = this.f7803a.getMSurface();
            if (r0 == null) goto L5;
            r0.release();
        L5:
            this.f7803a.setMSurface((Surface) ZeusTransformUtils.preCheckCast(null, Surface.class, "com.obric.memorydata.plugin"));
            AlphaVideoGLSurfaceView.a(this.f7803a, false);
        }

        @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.a.a.InterfaceC0378a
        public void a(Surface r3) {
            Intrinsics.checkNotNullParameter(r3, "surface");
            Surface r0 = this.f7803a.getMSurface();
            if (r0 == null) goto L5;
            r0.release();
        L5:
            this.f7803a.setMSurface(r3);
            AlphaVideoGLSurfaceView.a(this.f7803a, true);
            com.obric.common.oea.style.scene.alpha.alphaplayer.controller.b r1 = this.f7803a.getMPlayerController();
            if (r1 == null) goto L8;
            r1.surfacePrepared(r3);
        L8:
            com.obric.common.oea.style.scene.alpha.alphaplayer.controller.b r2 = this.f7803a.getMPlayerController();
            if (r2 == null) goto L12;
            r2.resume();
            return;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, d2 = {"<anonymous>", "", "run", "com/obric/common/oea/style/scene/alpha/alphaplayer/widget/AlphaVideoGLSurfaceView$measureInternal$1$1"}, k = 3, mv = {1, 4, 3})
    static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.obric.common.oea.style.scene.alpha.alphaplayer.a.a f7804a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f7805b;
        final /* synthetic */ int c;
        final /* synthetic */ AlphaVideoGLSurfaceView d;

        b(com.obric.common.oea.style.scene.alpha.alphaplayer.a.a r3, int r4, int r5, AlphaVideoGLSurfaceView r6) {
            this.f7804a = (com.obric.common.oea.style.scene.alpha.alphaplayer.a.a) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.common.oea.style.scene.alpha.alphaplayer.a.a.class, "com.obric.memorydata.plugin");
            this.f7805b = r4;
            this.c = r5;
            this.d = r6;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f7804a.a(this.f7805b, this.c, this.d.getMVideoWidth(), this.d.getMVideoHeight());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AlphaVideoGLSurfaceView(Context r3) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), null, 2, 0 == true ? 1 : 0);
    }

    public AlphaVideoGLSurfaceView(Context r8, AttributeSet r9) {
        Context r10 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r11 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r9, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11);
        this.f7801a = 2;
        this.e = ScaleType.ScaleAspectFill;
        this.i = new a(this);
        setEGLContextClientVersion(2);
        setEGLConfigChooser(8, 8, 8, 8, 16, 0);
        getHolder().setFormat(-3);
        b();
        setZOrderOnTop(true);
        setPreserveEGLContextOnPause(true);
    }

    public /* synthetic */ AlphaVideoGLSurfaceView(Context r2, AttributeSet r3, int r4, DefaultConstructorMarker r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.memorydata.plugin");
        if ((r4 & 2) == 0) goto L5;
        r7 = (AttributeSet) ZeusTransformUtils.preCheckCast(null, AttributeSet.class, "com.obric.memorydata.plugin");
    L5:
        this(r6, r7);
    }

    public static final /* synthetic */ void a(AlphaVideoGLSurfaceView r0, boolean r1) {
        r0.f7802b = r1;
    }

    @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.widget.a
    public void a(float r3, float r4) {
        float r0 = 0;
        if (r3 > r0) goto L5;
    L7:
        com.obric.common.oea.style.scene.alpha.alphaplayer.a.a r5 = this.f;
        if (r5 == null) goto L11;
        queueEvent((Runnable) ZeusTransformUtils.preCheckCast(new b(r5, getMeasuredWidth(), getMeasuredHeight(), this), Runnable.class, "com.obric.memorydata.plugin"));
        return;
    L11:
        return;
    L5:
        if (r4 <= r0) goto L7;
        this.c = r3;
        this.d = r4;
        goto L7
    }

    @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.widget.a
    public void a(ViewGroup r4) {
        Intrinsics.checkNotNullParameter(r4, "parentView");
        if (r4.indexOfChild((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin")) != (-1)) goto L9;
        ViewParent r0 = getParent();
        if (r0 == null) goto L7;
        Objects.requireNonNull(r0, "null cannot be cast to non-null type android.view.ViewGroup");
        ((ViewGroup) ZeusTransformUtils.preCheckCast(r0, ViewGroup.class, "com.obric.memorydata.plugin")).removeView((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"));
    L7:
        r4.addView((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"));
        return;
    }

    @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.widget.a
    public boolean a() {
        return this.f7802b;
    }

    public final void b() {
        com.obric.common.oea.style.scene.alpha.alphaplayer.a.a r0 = this.f;
        if (r0 == null) goto L6;
        r0.a((com.obric.common.oea.style.scene.alpha.alphaplayer.a.a.InterfaceC0378a) ZeusTransformUtils.preCheckCast(this.i, com.obric.common.oea.style.scene.alpha.alphaplayer.a.a.InterfaceC0378a.class, "com.obric.memorydata.plugin"));
        return;
    }

    @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.widget.a
    public void b(ViewGroup r3) {
        Intrinsics.checkNotNullParameter(r3, "parentView");
        r3.removeView((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.widget.a
    public void c() {
        com.obric.common.oea.style.scene.alpha.alphaplayer.a.a r0 = this.f;
        if (r0 == null) goto L6;
        r0.a();
        return;
    }

    @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.widget.a
    public void d() {
        com.obric.common.oea.style.scene.alpha.alphaplayer.a.a r0 = this.f;
        if (r0 == null) goto L6;
        r0.b();
        return;
    }

    @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.widget.a
    public void e() {
        this.i.a();
    }

    public final int getGL_CONTEXT_VERSION() {
        return this.f7801a;
    }

    public final com.obric.common.oea.style.scene.alpha.alphaplayer.controller.b getMPlayerController() {
        return this.g;
    }

    public final com.obric.common.oea.style.scene.alpha.alphaplayer.a.a getMRenderer() {
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

    @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.widget.a
    public ScaleType getScaleType() {
        return this.e;
    }

    @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.widget.a
    public View getView() {
        return (View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin");
    }

    @Override // android.view.SurfaceView, android.view.View
    public void onMeasure(int r1, int r2) {
        super.onMeasure(r1, r2);
        a(this.c, this.d);
    }

    public final void setMPlayerController(com.obric.common.oea.style.scene.alpha.alphaplayer.controller.b r3) {
        this.g = (com.obric.common.oea.style.scene.alpha.alphaplayer.controller.b) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.common.oea.style.scene.alpha.alphaplayer.controller.b.class, "com.obric.memorydata.plugin");
    }

    public final void setMRenderer(com.obric.common.oea.style.scene.alpha.alphaplayer.a.a r3) {
        this.f = (com.obric.common.oea.style.scene.alpha.alphaplayer.a.a) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.common.oea.style.scene.alpha.alphaplayer.a.a.class, "com.obric.memorydata.plugin");
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

    @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.widget.a
    public void setPlayerController(com.obric.common.oea.style.scene.alpha.alphaplayer.controller.b r3) {
        com.obric.common.oea.style.scene.alpha.alphaplayer.controller.b r4 = (com.obric.common.oea.style.scene.alpha.alphaplayer.controller.b) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.common.oea.style.scene.alpha.alphaplayer.controller.b.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "playerController");
        this.g = r4;
    }

    @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.widget.a
    public void setScaleType(ScaleType r2) {
        Intrinsics.checkNotNullParameter(r2, "scaleType");
        this.e = r2;
        com.obric.common.oea.style.scene.alpha.alphaplayer.a.a r1 = this.f;
        if (r1 == null) goto L6;
        r1.a(r2);
        return;
    }

    @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.widget.a
    public void setVideoRenderer(com.obric.common.oea.style.scene.alpha.alphaplayer.a.a r3) {
        com.obric.common.oea.style.scene.alpha.alphaplayer.a.a r4 = (com.obric.common.oea.style.scene.alpha.alphaplayer.a.a) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.common.oea.style.scene.alpha.alphaplayer.a.a.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "renderer");
        this.f = r4;
        setRenderer((GLSurfaceView.Renderer) ZeusTransformUtils.preCheckCast(r4, GLSurfaceView.Renderer.class, "com.obric.memorydata.plugin"));
        b();
        setRenderMode(0);
    }
}
