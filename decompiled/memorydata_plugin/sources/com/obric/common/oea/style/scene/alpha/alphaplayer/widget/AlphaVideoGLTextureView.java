package com.obric.common.oea.style.scene.alpha.alphaplayer.widget;

import android.content.Context;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000k\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011*\u0001\u001d\u0018\u00002\u00020\u00012\u00020\u0002B\u001b\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\"\u001a\u00020#H\u0002J\u0010\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020&H\u0016J\b\u0010'\u001a\u00020\u0015H\u0016J\b\u0010(\u001a\u00020)H\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010*\u001a\u00020#2\u0006\u0010+\u001a\u00020 2\u0006\u0010,\u001a\u00020 H\u0016J\b\u0010-\u001a\u00020#H\u0016J\b\u0010.\u001a\u00020#H\u0016J\u0018\u0010/\u001a\u00020#2\u0006\u00100\u001a\u00020\t2\u0006\u00101\u001a\u00020\tH\u0014J\b\u00102\u001a\u00020#H\u0016J\u0010\u00103\u001a\u00020#2\u0006\u0010%\u001a\u00020&H\u0016J\u0010\u00104\u001a\u00020#2\u0006\u00105\u001a\u00020\rH\u0016J\u0010\u00106\u001a\u00020#2\u0006\u00107\u001a\u00020\u0015H\u0016J\u0010\u00108\u001a\u00020#2\u0006\u00109\u001a\u00020\u0013H\u0016R\u000e\u0010\b\u001a\u00020\tX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0010\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001eR\u000e\u0010\u001f\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006:"}, d2 = {"Lcom/obric/common/oea/style/scene/alpha/alphaplayer/widget/AlphaVideoGLTextureView;", "Lcom/obric/common/oea/style/scene/alpha/alphaplayer/widget/GLTextureView;", "Lcom/obric/common/oea/style/scene/alpha/alphaplayer/widget/IAlphaVideoView;", "context", "Landroid/content/Context;", "attr", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "GL_CONTEXT_VERSION", "", "isSurfaceCreated", "", "mPlayerController", "Lcom/obric/common/oea/style/scene/alpha/alphaplayer/controller/IPlayerControllerExt;", "getMPlayerController", "()Lcom/obric/common/oea/style/scene/alpha/alphaplayer/controller/IPlayerControllerExt;", "setMPlayerController", "(Lcom/obric/common/oea/style/scene/alpha/alphaplayer/controller/IPlayerControllerExt;)V", "mRenderer", "Lcom/obric/common/oea/style/scene/alpha/alphaplayer/render/IRender;", "mScaleType", "Lcom/obric/common/oea/style/scene/alpha/alphaplayer/model/ScaleType;", "mSurface", "Landroid/view/Surface;", "getMSurface", "()Landroid/view/Surface;", "setMSurface", "(Landroid/view/Surface;)V", "mSurfaceListener", "com/obric/common/oea/style/scene/alpha/alphaplayer/widget/AlphaVideoGLTextureView$mSurfaceListener$1", "Lcom/obric/common/oea/style/scene/alpha/alphaplayer/widget/AlphaVideoGLTextureView$mSurfaceListener$1;", "mVideoHeight", "", "mVideoWidth", "addOnSurfacePreparedListener", "", "addParentView", "parentView", "Landroid/view/ViewGroup;", "getScaleType", "getView", "Landroid/view/View;", "measureInternal", "videoWidth", "videoHeight", "onCompletion", "onFirstFrame", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "release", "removeParentView", "setPlayerController", "playerController", "setScaleType", "scaleType", "setVideoRenderer", "renderer", "style_standardRelease"}, k = 1, mv = {1, 4, 3})
public final class AlphaVideoGLTextureView extends GLTextureView implements com.obric.common.oea.style.scene.alpha.alphaplayer.widget.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f7806a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile boolean f7807b;
    private float c;
    private float d;
    private ScaleType e;
    private com.obric.common.oea.style.scene.alpha.alphaplayer.a.a f;
    private com.obric.common.oea.style.scene.alpha.alphaplayer.controller.b g;
    private Surface h;
    private final a i;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"com/obric/common/oea/style/scene/alpha/alphaplayer/widget/AlphaVideoGLTextureView$mSurfaceListener$1", "Lcom/obric/common/oea/style/scene/alpha/alphaplayer/render/IRender$SurfaceListener;", "onSurfaceDestroyed", "", "onSurfacePrepared", "surface", "Landroid/view/Surface;", "style_standardRelease"}, k = 1, mv = {1, 4, 3})
    public static final class a implements com.obric.common.oea.style.scene.alpha.alphaplayer.a.a.InterfaceC0378a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AlphaVideoGLTextureView f7808a;

        a(AlphaVideoGLTextureView r1) {
            this.f7808a = r1;
        }

        public void a() {
            Surface r0 = this.f7808a.getMSurface();
            if (r0 == null) goto L5;
            r0.release();
        L5:
            this.f7808a.setMSurface((Surface) ZeusTransformUtils.preCheckCast(null, Surface.class, "com.obric.memorydata.plugin"));
            AlphaVideoGLTextureView.a(this.f7808a, false);
        }

        @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.a.a.InterfaceC0378a
        public void a(Surface r3) {
            Intrinsics.checkNotNullParameter(r3, "surface");
            Surface r0 = this.f7808a.getMSurface();
            if (r0 == null) goto L5;
            r0.release();
        L5:
            this.f7808a.setMSurface(r3);
            AlphaVideoGLTextureView.a(this.f7808a, true);
            com.obric.common.oea.style.scene.alpha.alphaplayer.controller.b r1 = this.f7808a.getMPlayerController();
            if (r1 == null) goto L8;
            r1.surfacePrepared(r3);
        L8:
            com.obric.common.oea.style.scene.alpha.alphaplayer.controller.b r2 = this.f7808a.getMPlayerController();
            if (r2 == null) goto L12;
            r2.resume();
            return;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, d2 = {"<anonymous>", "", "run", "com/obric/common/oea/style/scene/alpha/alphaplayer/widget/AlphaVideoGLTextureView$measureInternal$1$1"}, k = 3, mv = {1, 4, 3})
    static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.obric.common.oea.style.scene.alpha.alphaplayer.a.a f7809a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f7810b;
        final /* synthetic */ int c;
        final /* synthetic */ AlphaVideoGLTextureView d;

        b(com.obric.common.oea.style.scene.alpha.alphaplayer.a.a r3, int r4, int r5, AlphaVideoGLTextureView r6) {
            this.f7809a = (com.obric.common.oea.style.scene.alpha.alphaplayer.a.a) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.common.oea.style.scene.alpha.alphaplayer.a.a.class, "com.obric.memorydata.plugin");
            this.f7810b = r4;
            this.c = r5;
            this.d = r6;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f7809a.a(this.f7810b, this.c, AlphaVideoGLTextureView.a(this.d), AlphaVideoGLTextureView.b(this.d));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AlphaVideoGLTextureView(Context r3) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), null, 2, 0 == true ? 1 : 0);
    }

    public AlphaVideoGLTextureView(Context r8, AttributeSet r9) {
        Context r10 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r11 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r9, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11);
        this.f7806a = 2;
        this.e = ScaleType.ScaleAspectFill;
        this.i = new a(this);
        setEGLContextClientVersion(2);
        a(8, 8, 8, 8, 16, 0);
        f();
        setPreserveEGLContextOnPause(true);
        setOpaque(false);
    }

    public /* synthetic */ AlphaVideoGLTextureView(Context r2, AttributeSet r3, int r4, DefaultConstructorMarker r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.memorydata.plugin");
        if ((r4 & 2) == 0) goto L5;
        r7 = (AttributeSet) ZeusTransformUtils.preCheckCast(null, AttributeSet.class, "com.obric.memorydata.plugin");
    L5:
        this(r6, r7);
    }

    public static final /* synthetic */ float a(AlphaVideoGLTextureView r0) {
        return r0.c;
    }

    public static final /* synthetic */ void a(AlphaVideoGLTextureView r0, boolean r1) {
        r0.f7807b = r1;
    }

    public static final /* synthetic */ float b(AlphaVideoGLTextureView r0) {
        return r0.d;
    }

    private final void f() {
        com.obric.common.oea.style.scene.alpha.alphaplayer.a.a r0 = this.f;
        if (r0 == null) goto L6;
        r0.a((com.obric.common.oea.style.scene.alpha.alphaplayer.a.a.InterfaceC0378a) ZeusTransformUtils.preCheckCast(this.i, com.obric.common.oea.style.scene.alpha.alphaplayer.a.a.InterfaceC0378a.class, "com.obric.memorydata.plugin"));
        return;
    }

    @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.widget.a
    public void a(float r3, float r4) {
        float r0 = 0;
        if (r3 > r0) goto L5;
    L7:
        com.obric.common.oea.style.scene.alpha.alphaplayer.a.a r5 = this.f;
        if (r5 == null) goto L11;
        a((Runnable) ZeusTransformUtils.preCheckCast(new b(r5, getMeasuredWidth(), getMeasuredHeight(), this), Runnable.class, "com.obric.memorydata.plugin"));
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
        return this.f7807b;
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

    public final com.obric.common.oea.style.scene.alpha.alphaplayer.controller.b getMPlayerController() {
        return this.g;
    }

    public final Surface getMSurface() {
        return this.h;
    }

    @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.widget.a
    public ScaleType getScaleType() {
        return this.e;
    }

    @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.widget.a
    public View getView() {
        return (View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin");
    }

    @Override // android.view.View
    public void onMeasure(int r1, int r2) {
        super.onMeasure(r1, r2);
        a(this.c, this.d);
    }

    public final void setMPlayerController(com.obric.common.oea.style.scene.alpha.alphaplayer.controller.b r3) {
        this.g = (com.obric.common.oea.style.scene.alpha.alphaplayer.controller.b) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.common.oea.style.scene.alpha.alphaplayer.controller.b.class, "com.obric.memorydata.plugin");
    }

    public final void setMSurface(Surface r1) {
        this.h = r1;
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
        setRenderer((GLTextureView.m) ZeusTransformUtils.preCheckCast(r4, GLTextureView.m.class, "com.obric.memorydata.plugin"));
        f();
        setRenderMode(0);
    }
}
