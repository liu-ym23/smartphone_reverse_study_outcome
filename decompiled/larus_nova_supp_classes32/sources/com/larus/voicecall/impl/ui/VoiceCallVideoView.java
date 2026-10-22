package com.larus.voicecall.impl.ui;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.platform.api.IVideoController;
import com.larus.platform.api.n0;
import com.larus.platform.service.e2;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.larus.voicecall.impl.util.t0;
import com.lynx.jsbridge.LynxResourceModule;
import com.lynx.serval.svg.SVGRenderEngine;
import com.obric.aivoice.core.data.NameKeys;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.ExecutorsKt;
import kotlinx.coroutines.SupervisorKt;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u001c\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\t*\u0002)9\u0018\u0000 q2\u00020\u0001:\u0003qrsB\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0010\u0010;\u001a\u00020\u00152\b\u0010<\u001a\u0004\u0018\u00010\u0010J(\u0010=\u001a\u00020\u00152\u0006\u0010>\u001a\u00020\n2\u0006\u0010?\u001a\u00020\n2\u0006\u0010@\u001a\u00020\n2\u0006\u0010A\u001a\u00020\nH\u0014J\u0018\u0010B\u001a\u00020\u00152\u0006\u0010C\u001a\u00020\n2\u0006\u0010D\u001a\u00020\nH\u0014J\u000e\u0010E\u001a\u00020\u00152\u0006\u0010F\u001a\u00020\nJ\u0006\u0010G\u001a\u00020\u0015J<\u0010H\u001a\u00020\u00152\u0006\u00102\u001a\u00020\u00172\u0006\u0010I\u001a\u00020\u00172\u0006\u0010J\u001a\u00020\u00172\b\b\u0002\u0010K\u001a\u00020\n2\b\b\u0002\u0010L\u001a\u00020\n2\b\b\u0002\u0010M\u001a\u00020\nJ\b\u0010N\u001a\u000200H\u0002J\b\u0010O\u001a\u00020\u0017H\u0002J\b\u0010P\u001a\u00020\u0017H\u0002J\u000e\u00107\u001a\u00020\u00152\u0006\u0010Q\u001a\u00020\u0017J\u0006\u0010R\u001a\u00020\u0015J\u000e\u0010S\u001a\u00020\u00152\u0006\u0010T\u001a\u00020UJ*\u0010V\u001a\u00020\u00152\b\u0010W\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010X\u001a\u00020\u00172\u000e\b\u0002\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014J\u0010\u0010Y\u001a\u00020\u00152\u0006\u0010W\u001a\u00020\u0012H\u0002J\u0010\u0010Z\u001a\u00020\u00152\b\b\u0001\u0010[\u001a\u00020\nJ\u000e\u0010Z\u001a\u00020\u00152\u0006\u0010\\\u001a\u00020\rJ\u0006\u0010]\u001a\u00020\u0015J\u0018\u0010X\u001a\u00020\u00152\u0006\u0010^\u001a\u00020_2\b\b\u0002\u0010`\u001a\u00020\u0017J\u0010\u0010a\u001a\u00020\u00172\u0006\u0010b\u001a\u00020\rH\u0002J \u0010c\u001a\u00020\u00172\u0006\u0010d\u001a\u00020\n2\u0006\u0010e\u001a\u00020\n2\u0006\u0010f\u001a\u00020\u0017H\u0002J\b\u0010g\u001a\u00020\u0015H\u0014J\b\u0010h\u001a\u00020\u0015H\u0014J\u0010\u0010i\u001a\u00020\u00152\u0006\u0010j\u001a\u00020kH\u0014J(\u0010l\u001a\u00020\u00152\u0006\u0010j\u001a\u00020k2\u0006\u0010m\u001a\u00020\n2\u0006\u0010n\u001a\u00020\n2\u0006\u0010o\u001a\u00020UH\u0002J(\u0010p\u001a\u00020\u00152\u0006\u0010j\u001a\u00020k2\u0006\u0010m\u001a\u00020\n2\u0006\u0010n\u001a\u00020\n2\u0006\u0010o\u001a\u00020UH\u0002R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001d\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001d\u0010!\u001a\u0004\u0018\u00010\"8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b#\u0010$R\u0010\u0010'\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u00020)X\u0082\u0004¢\u0006\u0004\n\u0002\u0010*R\u000e\u0010+\u001a\u00020,X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020.X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u000200X\u0082.¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u000200X\u0082.¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00103\u001a\u0004\u0018\u000104X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u000206X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00108\u001a\u000209X\u0082\u0004¢\u0006\u0004\n\u0002\u0010:¨\u0006t"}, d2 = {"Lcom/larus/voicecall/impl/ui/VoiceCallVideoView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", NameKeys.UnloadStrategy_No_Strategy, "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "wrapLog", NameKeys.UnloadStrategy_No_Strategy, "message", "surfaceReadyCallback", "Lcom/larus/voicecall/impl/ui/VoiceCallVideoView$SurfaceReadyCallback;", "pendingVideo", "Lcom/larus/voicecall/impl/util/RealtimeDiskExt$VoiceVideo;", "pendingOnRenderStart", "Lkotlin/Function0;", NameKeys.UnloadStrategy_No_Strategy, "isCircle", NameKeys.UnloadStrategy_No_Strategy, SVGRenderEngine.PATH, "Landroid/graphics/Path;", "mSurface", "Landroid/view/Surface;", "onRenderStart", "isSurfaceReady", "()Z", "setSurfaceReady", "(Z)V", "mVideoController", "Lcom/larus/platform/api/IVideoController;", "getMVideoController", "()Lcom/larus/platform/api/IVideoController;", "mVideoController$delegate", "Lkotlin/Lazy;", "mVideo", "mVideoView", "com/larus/voicecall/impl/ui/VoiceCallVideoView$mVideoView$1", "Lcom/larus/voicecall/impl/ui/VoiceCallVideoView$mVideoView$1;", "mFrameView", "Lcom/facebook/drawee/view/SimpleDraweeView;", "mCoverView", "Landroid/view/View;", "shadowBlurPaint", "Landroid/graphics/Paint;", "coverBlurPaint", "staticBlur", "blurShader", "Landroid/graphics/BitmapShader;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "autoReleaseVideoController", "mSurfaceTextureListener", "com/larus/voicecall/impl/ui/VoiceCallVideoView$mSurfaceTextureListener$1", "Lcom/larus/voicecall/impl/ui/VoiceCallVideoView$mSurfaceTextureListener$1;", "setSurfaceReadyCallback", "callback", "onSizeChanged", "w", "h", "oldw", "oldh", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "updateBlurCoverColor", "coverColor", "resetVideoState", "enableBlur", "isImmersive", "isDarkMode", "immersiveColor", "darkCoverColor", "lightCoverColor", "createBlurPaint", "isBlurMode", "enableBlurCover", "enable", "releaseVideoController", "setSpeed", "speed", NameKeys.UnloadStrategy_No_Strategy, "play", LynxResourceModule.VIDEO_TYPE, "showCover", "startVideoPlayback", "showFrame", "firstFrame", "firstFrameUrl", "stop", "cover", "Lcom/larus/voicecall/impl/ui/VoiceCallVideoView$Cover;", "withAnim", "fitVideoIfNeed", "from", "applyVideoTransform", "containerWidth", "containerHeight", "centerCrop", "onAttachedToWindow", "onDetachedFromWindow", "dispatchDraw", "canvas", "Landroid/graphics/Canvas;", "renderOnBlur", "width", "height", "radius", "renderOnNormal", "Companion", "SurfaceReadyCallback", "Cover", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class VoiceCallVideoView extends FrameLayout {
    public static final /* synthetic */ int p = 0;
    public c a;
    public t0.b b;
    public Function0<Unit> c;
    public final boolean d;
    public final Path e;
    public Surface f;
    public Function0<Unit> g;
    public boolean h;
    public final Lazy i;
    public t0.b j;
    public final f k;
    public final SimpleDraweeView l;
    public final View m;
    public final CoroutineScope n;
    public final boolean o;

    public static final class a {
    }

    public static final class b {
        public final int a;
        public final float b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (this.a == r6.a) goto L12;
            return false;
        L12:
            if (Float.compare(this.b, r6.b) == 0) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.a * 31) + Float.floatToIntBits(this.b);
        }

        public final String toString() {
            return "Cover(color=" + this.a + ", alpha=" + this.b + ')';
        }

        public b(int r1, float r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public interface c {
        void onSurfaceDestroyed();

        void onSurfaceReady();
    }

    public static final class d implements TextureView.SurfaceTextureListener {
        public final /* synthetic */ VoiceCallVideoView a;

        @Override // android.view.TextureView.SurfaceTextureListener
        public final void onSurfaceTextureSizeChanged(SurfaceTexture r1, int r2, int r3) {
            Intrinsics.checkNotNullParameter(r1, "surface");
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public final void onSurfaceTextureUpdated(SurfaceTexture r2) {
            Intrinsics.checkNotNullParameter(r2, "surface");
        }

        public d(VoiceCallVideoView r1) {
            this.a = r1;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public final boolean onSurfaceTextureDestroyed(SurfaceTexture r6) {
            Intrinsics.checkNotNullParameter(r6, "surface");
            FLogger r0 = FLogger.a;
            VoiceCallVideoView r1 = this.a;
            int r2 = VoiceCallVideoView.p;
            r0.d("VoiceCallVideoView", r1.j("onSurfaceTextureDestroyed"));
            Surface r3 = this.a.f;
            if (r3 != null) goto L5;
        L7:
            boolean r4 = false;
        L8:
            if (r4 == false) goto L16;
            this.a.setSurfaceReady(false);
            c r5 = this.a.a;
            if (r5 == null) goto L12;
            r5.onSurfaceDestroyed();
        L12:
            r6.release();
            Surface r7 = this.a.f;
            if (r7 == null) goto L15;
            r7.release();
        L15:
            VoiceCallVideoView r8 = this.a;
            r8.f = null;
            r0.d("VoiceCallVideoView", r8.j("Surface destroyed and resources cleaned"));
        L16:
            return true;
        L5:
            if (r3.isValid() != true) goto L7;
            r4 = true;
            goto L8
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public final void onSurfaceTextureAvailable(SurfaceTexture r5, int r6, int r7) {
            Intrinsics.checkNotNullParameter(r5, "surface");
            FLogger r0 = FLogger.a;
            VoiceCallVideoView r1 = this.a;
            String r8 = "onSurfaceTextureAvailable: width=" + r6 + ", height=" + r7;
            int r9 = VoiceCallVideoView.p;
            r0.d("VoiceCallVideoView", r1.j(r8));
            Surface r10 = this.a.f;
            if (r10 != null) goto L5;
        L7:
            boolean r11 = false;
        L8:
            if (r11 == true) goto L19;
            this.a.f = new Surface(r5);
            this.a.setSurfaceReady(true);
            VoiceCallVideoView r12 = this.a;
            t0.b r13 = r12.b;
            if (r13 == null) goto L15;
            r0.d("VoiceCallVideoView", r12.j("Playing pending video after surface ready"));
            com.larus.utils.t0.c(new j0(r13, r12));
            Function0<Unit> r14 = r12.c;
            if (r14 == null) goto L14;
            r12.g = r14;
        L14:
            r12.b = null;
            r12.c = null;
        L15:
            c r15 = this.a.a;
            if (r15 == null) goto L20;
            r15.onSurfaceReady();
            return;
        L20:
            return;
        L19:
            return;
        L5:
            if (r10.isValid() != true) goto L7;
            r11 = true;
            goto L8
        }
    }

    public static final class e implements n0 {
        public final /* synthetic */ VoiceCallVideoView a;

        public final void b(Integer r1, Integer r2) {
        }

        public final void c(int r1) {
        }

        public final void d(int r1) {
        }

        public final void onCompletion() {
        }

        public final void onPrepare() {
        }

        public final void onPrepared() {
        }

        public final void onRenderStart() {
            e1.o(this.a.l);
            this.a.getClass();
            FLogger.a.i("VoiceCallVideoView", this.a.j("onRenderStart"));
            Function0<Unit> r0 = this.a.g;
            if (r0 == null) goto L5;
            r0.invoke();
        L5:
            this.a.g = null;
        }

        public e(VoiceCallVideoView r1) {
            this.a = r1;
        }

        public final void onVideoStatusException(int r4) {
            FLogger.a.e("VoiceCallVideoView", "onVideoStatusException status=" + r4);
        }

        public final void a(Integer r4, Integer r5) {
            FLogger.a.e("VoiceCallVideoView", "onError code=" + r4 + " internalCode=" + r5);
        }
    }

    public static final class f extends TextureView {
        public Function0<Unit> a;

        @Override // android.view.View
        public final void invalidate() {
            super.invalidate();
            this.a.invoke();
        }

        public final Function0<Unit> getOnTextureLayerUpdate() {
            return this.a;
        }

        public f(Context r1) {
            super(r1);
            this.a = new l0();
        }

        public final void setOnTextureLayerUpdate(Function0<Unit> r2) {
            Intrinsics.checkNotNullParameter(r2, "<set-?>");
            this.a = r2;
        }
    }

    static {
    }

    private final IVideoController getMVideoController() {
        return (IVideoController) this.i.getValue();
    }

    public final void i() {
        FLogger.a.d("VoiceCallVideoView", j("stop"));
        IVideoController r0 = getMVideoController();
        boolean r1 = false;
        if (r0 != null) goto L5;
    L7:
        if (r1 == false) goto L12;
        IVideoController r2 = getMVideoController();
        if (r2 == null) goto L13;
        r2.stop();
        return;
    L13:
        return;
    L12:
        return;
    L5:
        if (r0.p3() != true) goto L7;
        r1 = true;
        goto L7
    }

    public final void g() {
        IVideoController r0 = getMVideoController();
        if (r0 == null) goto L5;
        r0.stop();
    L5:
        IVideoController r1 = getMVideoController();
        if (r1 == null) goto L8;
        r1.l();
    L8:
        IVideoController r2 = getMVideoController();
        if (r2 == null) goto L11;
        r2.release();
    L11:
        CoroutineScopeKt.cancel$default(this.n, null, 1, null);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        FLogger.a.d("VoiceCallVideoView", j("onAttachedToWindow"));
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        FLogger.a.d("VoiceCallVideoView", j("onDetachedFromWindow"));
        if (this.o == false) goto L6;
        g();
        return;
    }

    public VoiceCallVideoView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    public final void d(String r7) {
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L13
        FLogger r4 = FLogger.a;     // Catch: Throwable -> L13
        r4.i("VoiceCallVideoView", j("fitVideoIfNeed, from:" + r7 + ",video:" + this.j));     // Catch: Throwable -> L13
        t0.b r8 = this.j;     // Catch: Throwable -> L13
        if (r8 == null) goto L8;
        boolean r5 = true;
        if (r8.a() != true) goto L8;
    L9:
        if (r5 == true) goto L11;
        return;
    L11:
        int r2 = getWidth();     // Catch: Throwable -> L13
        int r6 = getHeight();     // Catch: Throwable -> L13
        c(r2, r6, e2.a.isPad());     // Catch: Throwable -> L13
        r4.i("VoiceCallVideoView", j("fitVideoIfNeed, viewWidth:" + r2 + ",viewHeight:" + r6 + ",videoWidth:" + r8.c + ",videoHeight:" + r8.d + ",resultWidth:" + this.k.getWidth() + ",resultHeight:" + this.k.getHeight()));     // Catch: Throwable -> L13
        Object r9 = Result.constructor-impl(Boolean.TRUE);     // Catch: Throwable -> L13
    L15:
        Boolean r0 = Boolean.FALSE;
        if (Result.isFailure-impl(r9) == false) goto L18;
        r9 = r0;
    L18:
        ((Boolean) r9).booleanValue();
        return;
    L8:
        r5 = false;
    L13:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        r9 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L15
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r8) {
        Intrinsics.checkNotNullParameter(r8, "canvas");
        if (this.d == true) goto L15;
        super.dispatchDraw(r8);
        return;
    L15:
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L8
        int r1 = getWidth();     // Catch: Throwable -> L8
        int r2 = getHeight();     // Catch: Throwable -> L8
        float r3 = (float) ((Math.min(r1, r2) / ((double) 2)) - ((double) i5.b()));     // Catch: Throwable -> L8
        this.e.reset();     // Catch: Throwable -> L8
        this.e.addCircle(r1 / 2, r2 / 2, r3, Path.Direction.CW);     // Catch: Throwable -> L8
        r8.save();     // Catch: Throwable -> L8
        r8.clipPath(this.e);     // Catch: Throwable -> L8
        super.dispatchDraw(r8);     // Catch: Throwable -> L8
        r8.restore();     // Catch: Throwable -> L8
        Object r9 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L8
    L10:
        Throwable r10 = Result.exceptionOrNull-impl(r9);
        if (r10 == null) goto L17;
        FLogger.a.e("VoiceCallVideoView", "dispatchDraw failed:" + r10);
        return;
    L17:
        return;
    L8:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r9 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L10
    }

    public final String j(String r3) {
        return hashCode() + " - " + r3;
    }

    public final void setSpeed(final float r2) {
        com.larus.utils.t0.c(new f0(this, r2));
    }

    public final void setSurfaceReady(boolean r1) {
        this.h = r1;
    }

    public final void setSurfaceReadyCallback(c r1) {
        this.a = r1;
    }

    public VoiceCallVideoView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, r3, 0);
    }

    public static void a(t0.b r4, VoiceCallVideoView r5) {
        String r0 = r4.e;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L10:
        if (r1 == true) goto L15;
        IVideoController r2 = r5.getMVideoController();
        if (r2 == null) goto L14;
        r2.setDirectURL(r4.e);
    L14:
        FLogger.a.d("VoiceCallVideoView", r5.j("Setting network URL: " + r4.e));
    L19:
        IVideoController r6 = r5.getMVideoController();
        if (r6 == null) goto L22;
        r6.play();
    L22:
        FLogger.a.d("VoiceCallVideoView", r5.j("Play command sent"));
        return;
    L15:
        IVideoController r3 = r5.getMVideoController();
        if (r3 == null) goto L18;
        r3.setLocalURL(r4.a);
    L18:
        FLogger.a.d("VoiceCallVideoView", r5.j("Setting local URI: " + r4.a));
        goto L19
    L5:
        if (r0.length() == 0) goto L8;
        r1 = false;
        goto L10
    }

    public static void b(VoiceCallVideoView r0, float r1) {
        IVideoController r2 = r0.getMVideoController();
        if (r2 == null) goto L8;
        com.larus.platform.api.n r3 = r2.a();
        if (r3 == null) goto L9;
        r3.a = r1;
        return;
    L9:
        return;
    }

    public static /* synthetic */ void f(VoiceCallVideoView r2, t0.b r3) {
        r2.e(r3, true, new e0());
    }

    public static void h(VoiceCallVideoView r2, b r3) {
        r2.getClass();
        Intrinsics.checkNotNullParameter(r3, "cover");
        r2.m.setBackgroundColor(r3.a);
        r2.m.setAlpha(r3.b);
        e1.x(r2.m);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r4, int r5) {
        if (e2.a.isPad() == true) goto L5;
        c(View.MeasureSpec.getSize(r4), View.MeasureSpec.getSize(r5), false);
    L5:
        super.onMeasure(r4, r5);
    }

    public VoiceCallVideoView(Context r7, AttributeSet r8, int r9) {
        Intrinsics.checkNotNullParameter(r7, "context");
        super(r7, r8, r9);
        this.e = new Path();
        this.g = new g0();
        this.i = LazyKt.lazy(new h0(this));
        f r0 = new f(getContext());
        this.k = r0;
        SimpleDraweeView r10 = new SimpleDraweeView(getContext());
        r10.setScaleType(ImageView.ScaleType.CENTER_CROP);
        e1.o(r10);
        this.l = r10;
        View r1 = new View(getContext());
        e1.o(r1);
        this.m = r1;
        this.n = CoroutineScopeKt.CoroutineScope(ExecutorsKt.from(PThreadExecutorsUtils.newSingleThreadExecutor(new DefaultThreadFactory("VoiceCallVideoView"))).plus(SupervisorKt.SupervisorJob$default(null, 1, null)));
        this.o = true;
        d r2 = new d(this);
        if (r8 == null) goto L5;
        TypedArray r11 = r7.obtainStyledAttributes(r8, new int[]{2130972025});
        this.d = r11.getBoolean(0, false);
        r11.recycle();
    L5:
        setBackgroundColor(ContextCompat.getColor(r7, R.color.transparent));
        r0.setSurfaceTextureListener(r2);
        addView(r0, -1, -1);
        addView(r10, -1, -1);
        addView(r1, -1, -1);
        r0.setOnTextureLayerUpdate(new i0(this));
    }

    public final void c(int r6, int r7, boolean r8) {
        t0.b r0 = this.j;
        if (r6 <= 0) goto L23;
        if (r7 > 0) goto L6;
        return;
    L6:
        if (r0 != null) goto L8;
    L10:
        boolean r2 = false;
    L11:
        if (r2 == false) goto L25;
        float r9 = r6;
        float r3 = r9 / r0.c;
        float r10 = r7;
        float r4 = r10 / r0.d;
        float r5 = Math.max(r3, r4);
        if (r8 == false) goto L16;
        float r1 = r5 / r3;
        float r11 = r5 / r4;
    L17:
        Matrix r12 = new Matrix();
        if (r8 == false) goto L20;
        r12.setScale(r1, r11, r9 / 2.0f, r10 / 2.0f);
    L21:
        this.k.setTransform(r12);
        return;
    L20:
        r12.setScale(r1, r11);
        goto L21
    L16:
        float r13 = (((int) (r0.c * r5)) + 1) / r9;
        r11 = (((int) (r0.d * r5)) + 1) / r10;
        r1 = r13;
        goto L17
    L25:
        return;
    L8:
        if (r0.a() != true) goto L10;
        r2 = true;
        goto L11
    }

    public final void e(t0.b r6, boolean r7, Function0<Unit> r8) {
        Intrinsics.checkNotNullParameter(r8, "onRenderStart");
        FLogger r0 = FLogger.a;
        r0.d("VoiceCallVideoView", j("play, video=" + r6));
        this.j = r6;
        this.g = r8;
        boolean r1 = false;
        if (r6 != null) goto L5;
    L7:
        boolean r4 = false;
    L8:
        if (r4 == false) goto L24;
        if (r7 == false) goto L18;
        String r9 = r6.f;
        if (r9 != null) goto L13;
    L14:
        r1 = true;
    L15:
        if (r1 == true) goto L17;
        String r10 = r6.f;
        Intrinsics.checkNotNullParameter(r10, "firstFrameUrl");
        e1.x(this.l);
        ImageLoaderKt.u(this.l, r10, "realtime_call_bot_avatar");
        goto L18
    L17:
        int r11 = r6.b;
        e1.x(this.l);
        this.l.setImageResource(r11);
        goto L18
    L13:
        if (r9.length() != 0) goto L15;
    L18:
        d("play");
        if (this.h == true) goto L22;
        r0.w("VoiceCallVideoView", j("Surface not ready, caching video for later playback"));
        this.b = r6;
        this.c = r8;
        return;
    L22:
        com.larus.utils.t0.c(new j0(r6, this));
        return;
    L24:
        return;
    L5:
        if (r6.a() != true) goto L7;
        r4 = true;
        goto L8
    }

    @Override // android.view.View
    public final void onSizeChanged(int r1, int r2, int r3, int r4) {
        super.onSizeChanged(r1, r2, r3, r4);
        d("onSizeChanged");
    }
}
