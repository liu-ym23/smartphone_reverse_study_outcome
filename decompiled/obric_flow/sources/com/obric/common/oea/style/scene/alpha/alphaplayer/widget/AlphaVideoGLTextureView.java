package com.obric.common.oea.style.scene.alpha.alphaplayer.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.room.jarjarred.org.antlr.v4.analysis.LeftRecursiveRuleTransformer;
import com.lynx.tasm.behavior.u;
import com.obric.common.oea.style.scene.alpha.AlphaView;
import com.obric.common.oea.style.scene.alpha.alphaplayer.model.ScaleType;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import up.a;
import xp.b;
import xp.c;
import zp.e;
import zp.f;
import zp.k;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0019\u0010\u001aR$\u0010 \u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010\u0010R$\u0010(\u001a\u0004\u0018\u00010!8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'¨\u0006)"}, d2 = {"Lcom/obric/common/oea/style/scene/alpha/alphaplayer/widget/AlphaVideoGLTextureView;", "Lcom/obric/common/oea/style/scene/alpha/alphaplayer/widget/GLTextureView;", "Lzp/k;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "Landroid/view/View;", "getView", "()Landroid/view/View;", "Lup/a;", "playerController", "", "setPlayerController", "(Lup/a;)V", "Lxp/b;", "renderer", "setVideoRenderer", "(Lxp/b;)V", "Lcom/obric/common/oea/style/scene/alpha/alphaplayer/model/ScaleType;", "scaleType", "setScaleType", "(Lcom/obric/common/oea/style/scene/alpha/alphaplayer/model/ScaleType;)V", "getScaleType", "()Lcom/obric/common/oea/style/scene/alpha/alphaplayer/model/ScaleType;", LeftRecursiveRuleTransformer.PRECEDENCE_OPTION_NAME, "Lup/a;", "getMPlayerController", "()Lup/a;", "setMPlayerController", "mPlayerController", "Landroid/view/Surface;", "q", "Landroid/view/Surface;", "getMSurface", "()Landroid/view/Surface;", "setMSurface", "(Landroid/view/Surface;)V", "mSurface", "style_standardRelease"}, k = 1, mv = {1, 4, 3})
public final class AlphaVideoGLTextureView extends GLTextureView implements k {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f11357l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f11358m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public ScaleType f11359n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public b f11360o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public a f11361p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Surface f11362q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final k6.a f11363r;

    @JvmOverloads
    public AlphaVideoGLTextureView(Context r5) {
        this(r5, null);
    }

    @Override // zp.k
    public final void a() {
        b r5 = this.f11360o;
        if (r5 == null) goto L6;
        ((c) r5).e();
        return;
    }

    @Override // zp.k
    public final void b(float r10, float r11) {
        float r5 = 0;
        if (r10 > r5) goto L5;
    L7:
        b r12 = this.f11360o;
        if (r12 == null) goto L17;
        u r13 = new u(r12, getMeasuredWidth(), getMeasuredHeight(), this, 2);
        e r14 = this.f11366b;
        r14.getClass();
        f r15 = GLTextureView.f11364k;
        monitor-enter(r15);
        r14.f23571p.add(r13);     // Catch: Throwable -> L14
        r15.notifyAll();     // Catch: Throwable -> L14
        monitor-exit(r15);     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        throw th;
    L17:
        return;
    L5:
        if (r11 <= r5) goto L7;
        this.f11357l = r10;
        this.f11358m = r11;
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
        b r5 = this.f11360o;
        if (r5 == null) goto L6;
        ((c) r5).d();
        return;
    }

    public final a getMPlayerController() {
        return this.f11361p;
    }

    public final Surface getMSurface() {
        return this.f11362q;
    }

    @Override // zp.k
    public ScaleType getScaleType() {
        return this.f11359n;
    }

    public View getView() {
        return this;
    }

    @Override // android.view.View
    public final void onMeasure(int r5, int r10) {
        super.onMeasure(r5, r10);
        b(this.f11357l, this.f11358m);
    }

    @Override // zp.k
    public final void release() {
        k6.a r5 = this.f11363r;
        Surface r10 = ((AlphaVideoGLTextureView) r5.f18623a).getMSurface();
        if (r10 == null) goto L5;
        r10.release();
    L5:
        AlphaVideoGLTextureView r11 = (AlphaVideoGLTextureView) r5.f18623a;
        r11.setMSurface(null);
        r11.getClass();
    }

    public final void setMPlayerController(a r5) {
        this.f11361p = r5;
    }

    public final void setMSurface(Surface r5) {
        this.f11362q = r5;
    }

    @Override // zp.k
    public void setPlayerController(a r5) {
        Intrinsics.checkNotNullParameter(r5, "playerController");
        this.f11361p = r5;
    }

    public void setScaleType(ScaleType r5) {
        Intrinsics.checkNotNullParameter(r5, "scaleType");
        this.f11359n = r5;
        b r10 = this.f11360o;
        if (r10 == null) goto L6;
        Intrinsics.checkNotNullParameter(r5, "scaleType");
        ((c) r10).f23205p = r5;
        return;
    }

    @Override // zp.k
    public void setVideoRenderer(b r5) {
        Intrinsics.checkNotNullParameter(r5, "renderer");
        this.f11360o = r5;
        setRenderer(r5);
        b r10 = this.f11360o;
        if (r10 == null) goto L5;
        k6.a r11 = this.f11363r;
        Intrinsics.checkNotNullParameter(r11, "surfaceListener");
        ((c) r10).f23204o = r11;
    L5:
        setRenderMode(0);
    }

    @JvmOverloads
    public AlphaVideoGLTextureView(Context r5, AttributeSet r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r10);
        this.f11359n = ScaleType.ScaleAspectFill;
        k6.a r11 = new k6.a(this);
        this.f11363r = r11;
        setEGLContextClientVersion(2);
        setEGLConfigChooser(new zp.a(this, 8, 16));
        b r12 = this.f11360o;
        if (r12 == null) goto L5;
        Intrinsics.checkNotNullParameter(r11, "surfaceListener");
        ((c) r12).f23204o = r11;
    L5:
        setPreserveEGLContextOnPause(true);
        setOpaque(false);
    }
}
