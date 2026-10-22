package com.larus.bmhome.chat.view;

import android.R;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.TextureView;
import android.widget.FrameLayout;
import androidx.core.content.ContextCompat;
import com.larus.platform.api.IVideoController;
import com.larus.platform.api.l4;
import com.larus.platform.api.n0;
import com.larus.platform.service.q3;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.larus.video.impl.sdk.o;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import po8.q;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u000e*\u0003\u001c!$\u0018\u0000 42\u00020\u0001:\u00014B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ(\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u00072\u0006\u0010)\u001a\u00020\u00072\u0006\u0010*\u001a\u00020\u00072\u0006\u0010+\u001a\u00020\u0007H\u0014J\b\u0010,\u001a\u00020'H\u0014J\b\u0010-\u001a\u00020'H\u0014J\b\u0010.\u001a\u00020\u0018H\u0002J\b\u0010/\u001a\u00020'H\u0002J\u0018\u00100\u001a\u00020'2\u0006\u00101\u001a\u00020\u000b2\b\b\u0002\u0010\u0017\u001a\u00020\u0018J\u000e\u00102\u001a\u00020'2\u0006\u00101\u001a\u00020\u000bJ\u0006\u00103\u001a\u00020'R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001dR\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u00020!X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\"R\u0010\u0010#\u001a\u00020$X\u0082\u0004¢\u0006\u0004\n\u0002\u0010%¨\u00065"}, d2 = {"Lcom/larus/bmhome/chat/view/ImmerseBgVideoView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "tag", "", "mVideoController", "Lcom/larus/platform/api/IVideoController;", "mVideoView", "Landroid/view/TextureView;", "mSurface", "Landroid/view/Surface;", "mVideoWidth", "", "mVideoHeight", "mViewAspectRatio", "mVideoAspectRatio", "needPause", "", "isPauseInFirstFrame", "currentVideoModel", "mSurfaceTextureListener", "com/larus/bmhome/chat/view/ImmerseBgVideoView$mSurfaceTextureListener$1", "Lcom/larus/bmhome/chat/view/ImmerseBgVideoView$mSurfaceTextureListener$1;", "mOnPreDrawListener", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "videoStateCallback", "com/larus/bmhome/chat/view/ImmerseBgVideoView$videoStateCallback$1", "Lcom/larus/bmhome/chat/view/ImmerseBgVideoView$videoStateCallback$1;", "videoModelPreloadCallback", "com/larus/bmhome/chat/view/ImmerseBgVideoView$videoModelPreloadCallback$1", "Lcom/larus/bmhome/chat/view/ImmerseBgVideoView$videoModelPreloadCallback$1;", "onSizeChanged", "", "w", "h", "oldw", "oldh", "onAttachedToWindow", "onDetachedFromWindow", "isSurfaceValid", "fitVideoViewSizeCenterCrop", "parseVideoModelAndPlay", "videoModel", "resumePlay", "stop", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ImmerseBgVideoView extends FrameLayout {
    public static final /* synthetic */ int m = 0;
    public final String a;
    public final IVideoController b;
    public final TextureView c;
    public Surface d;
    public float e;
    public float f;
    public float g;
    public float h;
    public boolean i;
    public boolean j;
    public final q k;
    public final d l;

    public static final class a {
    }

    public static final class b implements TextureView.SurfaceTextureListener {
        public final /* synthetic */ ImmerseBgVideoView a;

        @Override // android.view.TextureView.SurfaceTextureListener
        public final void onSurfaceTextureSizeChanged(SurfaceTexture r1, int r2, int r3) {
            Intrinsics.checkNotNullParameter(r1, "surface");
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public final void onSurfaceTextureUpdated(SurfaceTexture r2) {
            Intrinsics.checkNotNullParameter(r2, "surface");
        }

        public b(ImmerseBgVideoView r1) {
            this.a = r1;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public final boolean onSurfaceTextureDestroyed(SurfaceTexture r3) {
            Intrinsics.checkNotNullParameter(r3, "surface");
            r3.release();
            FLogger.a.d(this.a.a, "onSurfaceTextureDestroyed");
            Surface r4 = this.a.d;
            if (r4 == null) goto L5;
            r4.release();
        L5:
            this.a.d = null;
            return true;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public final void onSurfaceTextureAvailable(SurfaceTexture r1, int r2, int r3) {
            Intrinsics.checkNotNullParameter(r1, "surface");
            Surface r4 = this.a.d;
            if (r4 == null) goto L7;
            boolean r5 = true;
            if (r4.isValid() != true) goto L7;
        L8:
            if (r5 == true) goto L10;
            ImmerseBgVideoView r6 = this.a;
            r6.d = new Surface(r1);
        L10:
            ImmerseBgVideoView r7 = this.a;
            IVideoController r8 = r7.b;
            if (r8 == null) goto L13;
            r8.setSurface(r7.d);
        L13:
            FLogger.a.d(this.a.a, "onSurfaceTextureAvailable");
            return;
        L7:
            r5 = false;
            goto L8
        }
    }

    public static final class c implements l4 {
        public final /* synthetic */ String a;
        public final /* synthetic */ ImmerseBgVideoView b;

        public c(String r1, ImmerseBgVideoView r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void a(String r5, com.larus.video.impl.sdk.a r6) {
            if (Intrinsics.areEqual(this.a, r5) == false) goto L18;
            if (r6 == null) goto L19;
            ImmerseBgVideoView r7 = this.b;
            r7.e = r6.b();
            float r0 = r6.a();
            r7.f = r0;
            float r1 = r7.e / r0;
        L9:
            r7.h = r1;
            FLogger.a.d(r7.a, "mVideoAspectRatio = " + r7.h);
            IVideoController r2 = r7.b;
            if (r2 == null) goto L12;
            r2.j(r6, false);
        L12:
            IVideoController r8 = r7.b;
            if (r8 == null) goto L20;
            r8.play();
            return;
        L20:
            return;
        L8:
            r1 = 0.0f;
            goto L9
        L19:
            return;
        }
    }

    public static final class d implements n0 {
        public final /* synthetic */ ImmerseBgVideoView a;

        public final void b(Integer r1, Integer r2) {
        }

        public final void onCompletion() {
            ImmerseBgVideoView r0 = this.a;
            r0.j = false;
            FLogger.a.d(r0.a, "onCompletion, gone");
        }

        public final void onPrepare() {
            FLogger.a.d(this.a.a, "onPrepare");
        }

        public final void onPrepared() {
            e1.x(this.a);
            FLogger.a.d(this.a.a, "onPrepared");
        }

        public final void onRenderStart() {
            ImmerseBgVideoView r0 = this.a;
            if (r0.i == false) goto L8;
            IVideoController r1 = r0.b;
            if (r1 == null) goto L7;
            r1.b();
        L7:
            ImmerseBgVideoView r2 = this.a;
            r2.j = true;
            FLogger.a.d(r2.a, "onRenderStart, pause video");
        L8:
            FLogger.a.d(this.a.a, "onRenderStart");
        }

        public d(ImmerseBgVideoView r1) {
            this.a = r1;
        }

        public final void c(int r5) {
            FLogger.a.d(this.a.a, "playbackState = " + r5);
        }

        public final void d(int r5) {
            FLogger.a.d(this.a.a, "loadState = " + r5);
        }

        public final void onVideoStatusException(int r5) {
            FLogger.a.d(this.a.a, "status = " + r5);
        }

        public final void a(Integer r5, Integer r6) {
            FLogger.a.e(this.a.a, "code = " + r5 + ", internalCode = " + r6);
        }
    }

    static {
    }

    public ImmerseBgVideoView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public ImmerseBgVideoView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public final void a() {
        boolean r1 = true;
        if (this.g != 0.0f) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return;
    L8:
        if (this.h == 0.0f) goto L11;
        r1 = false;
    L11:
        if (r1 == true) goto L16;
        int r2 = getHeight();
        int r3 = getWidth();
        FLogger r4 = FLogger.a;
        r4.d(this.a, "fitVideoViewSize, displayWidth = " + this.e + ", displayHeight = " + this.f + ", containerWidth = " + r3 + ", containerHeight = " + r2);
        float r5 = (float) r3;
        float r6 = r5 / this.e;
        float r7 = (float) r2;
        float r8 = r7 / this.f;
        float r9 = Math.max(r6, r8);
        float r10 = r9 / r6;
        float r11 = r9 / r8;
        r4.d(this.a, "fitVideoViewSizeV2, scaleX = " + r10 + ", scaleY = " + r11);
        Matrix r12 = new Matrix();
        r12.setScale(r10, r11, r5 / 2.0f, r7 / 2.0f);
        this.c.setTransform(r12);
        r4.d(this.a, "fitVideoViewSize, resultWidth = " + this.c.getWidth() + ", resultHeight = " + this.c.getHeight());
        return;
    L16:
        return;
    L5:
        r0 = false;
        goto L6
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        IVideoController r0 = this.b;
        if (r0 == null) goto L5;
        r0.p(this.l);
    L5:
        getViewTreeObserver().addOnPreDrawListener(this.k);
        FLogger.a.d(this.a, "onAttachedToWindow");
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        FLogger.a.d(this.a, "onDetachedFromWindow, release video controller");
        getViewTreeObserver().removeOnPreDrawListener(this.k);
        IVideoController r0 = this.b;
        if (r0 == null) goto L5;
        r0.stop();
    L5:
        IVideoController r1 = this.b;
        if (r1 == null) goto L8;
        r1.l();
    L8:
        IVideoController r2 = this.b;
        if (r2 == null) goto L12;
        r2.release();
        return;
    }

    public final void b(String r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r5, "videoModel");
        FLogger.a.d(this.a, "parseVideoModelAndPlay, needPause=" + r6);
        IVideoController r0 = this.b;
        if (r0 == null) goto L7;
        boolean r1 = true;
        if (r0.p3() != true) goto L7;
    L8:
        if (r1 == false) goto L10;
        return;
    L10:
        this.i = r6;
        IVideoController r7 = this.b;
        if (r7 == null) goto L14;
        r7.f(r5, new c(r5, this));
        return;
    L14:
        return;
    L7:
        r1 = false;
        goto L8
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [po8.q] */
    public ImmerseBgVideoView(Context r3, AttributeSet r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, r4, r5);
        String r6 = "ImmerseBgVideoView-" + hashCode();
        this.a = r6;
        o r7 = q3.b(r6, null, 6);
        this.b = r7;
        TextureView r8 = new TextureView(r3);
        this.c = r8;
        b r0 = new b(this);
        this.k = new q(this);
        this.l = new d(this);
        setBackgroundColor(ContextCompat.getColor(r3, R.color.transparent));
        addView(r8, -1, -1);
        r8.setSurfaceTextureListener(r0);
        if (r7 == null) goto L6;
        r7.C(true);
        return;
    }

    public /* synthetic */ ImmerseBgVideoView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    @Override // android.view.View
    public final void onSizeChanged(int r1, int r2, int r3, int r4) {
        super.onSizeChanged(r1, r2, r3, r4);
        FLogger.a.d(this.a, "onSizeChanged");
        a();
    }
}
