package com.larus.doc.impl.video.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.TextureView;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.common.utility.UIUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.common_ui.view.ActivityIndicatorView;
import com.larus.doc.sdk.impl.BuildConfig;
import com.larus.media.MediaLevel;
import com.larus.media.MediaOccupyStrategy;
import com.larus.media.MediaResourceManager;
import com.larus.media.MixPriority;
import com.larus.platform.api.IVideoController;
import com.larus.platform.api.n0;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000Å\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001e*\u00013\u0018\u0000 \u0084\u00012\u00020\u0001:\f\u0084\u0001\u0085\u0001\u0086\u0001\u0087\u0001\u0088\u0001\u0089\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ(\u0010I\u001a\u00020\u00112\u0006\u0010J\u001a\u00020\u00072\u0006\u0010K\u001a\u00020\u00072\u0006\u0010L\u001a\u00020\u00072\u0006\u0010M\u001a\u00020\u0007H\u0014J\b\u0010N\u001a\u00020\u0011H\u0014J\b\u0010O\u001a\u00020\u0011H\u0014J\u001a\u0010P\u001a\u00020\u00112\b\u0010Q\u001a\u0004\u0018\u00010&2\b\u0010R\u001a\u0004\u0018\u00010\u000bJ\u0006\u0010S\u001a\u00020\u0011J\b\u0010T\u001a\u00020\u0011H\u0002J\b\u0010U\u001a\u00020\u0011H\u0002J\b\u0010V\u001a\u00020\u0011H\u0002J\u0006\u0010W\u001a\u00020\u0011J\u0006\u0010X\u001a\u00020YJ\u0006\u0010Z\u001a\u00020YJ\u0006\u0010[\u001a\u00020\u0011J\u0006\u0010\\\u001a\u00020\u0011J\u0010\u0010b\u001a\u00020\u00112\b\b\u0002\u0010c\u001a\u00020!J\u0010\u0010d\u001a\u00020\u00112\b\b\u0002\u0010c\u001a\u00020!J\u0010\u0010e\u001a\u00020!2\u0006\u0010f\u001a\u00020gH\u0016J\u0010\u0010h\u001a\u00020!2\u0006\u0010f\u001a\u00020gH\u0016J\u0018\u0010i\u001a\u00020\u00112\u0006\u0010j\u001a\u00020\u00072\b\u0010k\u001a\u0004\u0018\u00010lJ\u0006\u0010m\u001a\u00020\u0011J\u0006\u0010n\u001a\u00020\u0011J\u0006\u0010o\u001a\u00020\u0011J\u000e\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0007J)\u0010p\u001a\u00020\u00112!\u0010q\u001a\u001d\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00110\rJ)\u0010r\u001a\u00020\u00112!\u0010q\u001a\u001d\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00110\rJ+\u0010\u0013\u001a\u00020\u00112#\u0010s\u001a\u001f\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u0011\u0018\u00010\rJ\u0006\u0010t\u001a\u00020!J\u0006\u0010u\u001a\u00020!J\u0006\u0010v\u001a\u00020\u0011J\b\u0010w\u001a\u00020\u0011H\u0002J\b\u0010x\u001a\u00020\u0011H\u0002J\b\u0010y\u001a\u00020\u0011H\u0002J\u000e\u0010z\u001a\u00020\u00112\u0006\u0010{\u001a\u00020\u0007J\b\u0010|\u001a\u00020\u0011H\u0002J\b\u0010}\u001a\u00020\u0011H\u0002J\u0010\u0010~\u001a\u00020\u00112\u0006\u0010\u007f\u001a\u00020.H\u0002J\t\u0010\u0080\u0001\u001a\u00020!H\u0002J\u0011\u0010\u0081\u0001\u001a\u00020\u00112\u0006\u0010\u007f\u001a\u00020.H\u0002J\t\u0010\u0082\u0001\u001a\u00020\u0011H\u0002J\t\u0010\u0083\u0001\u001a\u00020\u0011H\u0002R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R+\u0010\f\u001a\u001f\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u0011\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R+\u0010\u0012\u001a\u001f\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u0011\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R+\u0010\u0013\u001a\u001f\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u0011\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020*X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010,\u001a\u0016\u0012\u0004\u0012\u00020.\u0018\u00010-j\n\u0012\u0004\u0012\u00020.\u0018\u0001`/X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\u001eX\u0082D¢\u0006\u0002\n\u0000R\u0010\u00102\u001a\u000203X\u0082\u0004¢\u0006\u0004\n\u0002\u00104R\u0010\u00105\u001a\u0004\u0018\u000106X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020.X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020:X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010;\u001a\u0004\u0018\u00010<X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\"\u0010A\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010BX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\u000e\u0010G\u001a\u00020HX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010]\u001a\u00020!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b^\u0010_\"\u0004\b`\u0010a¨\u0006\u008a\u0001"}, d2 = {"Lcom/larus/doc/impl/video/widget/VideoPlayView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mUrl", "", "mOnBufferingUpdate", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "percent", "", "mOnPlayingProgressUpdate", "onPlayStatusChanged", "status", "mVideoView", "Landroid/view/TextureView;", "mPlayButton", "Landroid/widget/ImageView;", "mLoadingView", "Lcom/larus/common_ui/view/ActivityIndicatorView;", "mSurface", "Landroid/view/Surface;", "mViewAspectRatio", "", "mVideoAspectRatio", "banInnerDismiss", "", "startX", "startY", "mVideoId", "mVideoController", "Lcom/larus/platform/api/IVideoController;", "parentSlideDirection", "mShouldBePlaying", "mMainHandler", "Landroid/os/Handler;", "mExecutingActions", "mPendingActions", "Ljava/util/ArrayList;", "Ljava/lang/Runnable;", "Lkotlin/collections/ArrayList;", "touchSlop", "dismissOffset", "mSurfaceTextureListener", "com/larus/doc/impl/video/widget/VideoPlayView$mSurfaceTextureListener$1", "Lcom/larus/doc/impl/video/widget/VideoPlayView$mSurfaceTextureListener$1;", "mProgressUpdateTask", "Lcom/larus/doc/impl/video/widget/VideoPlayView$ProgressUpdateTask;", "ignoreClick", "showLoadingRunable", "mOnPreDrawListener", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "afterClickCallBack", "Lcom/larus/doc/impl/video/widget/VideoPlayView$AfterClickCallBack;", "getAfterClickCallBack", "()Lcom/larus/doc/impl/video/widget/VideoPlayView$AfterClickCallBack;", "setAfterClickCallBack", "(Lcom/larus/doc/impl/video/widget/VideoPlayView$AfterClickCallBack;)V", "dismissCallback", "Lkotlin/Function0;", "getDismissCallback", "()Lkotlin/jvm/functions/Function0;", "setDismissCallback", "(Lkotlin/jvm/functions/Function0;)V", "mediaApplicant", "Lcom/larus/media/model/MediaRequestApplicant;", "onSizeChanged", "w", "h", "oldw", "oldh", "onAttachedToWindow", "onDetachedFromWindow", "setUrl", "videoController", "url", "start", "realStart", "playByVideoUrl", "resetSurfaceAndPlay", "retryStart", "getCurrentPlaybackTime", "", "getDuration", "stop", BuildConfig.BUILD_TYPE, "mResumeOrPauseByUser", "getMResumeOrPauseByUser", "()Z", "setMResumeOrPauseByUser", "(Z)V", "resume", "byUser", "pause", "onInterceptTouchEvent", "ev", "Landroid/view/MotionEvent;", "onTouchEvent", "seekTo", "msec", "listener", "Lcom/larus/platform/api/IFlowSeekCompletionListener;", "showLoadingWithDelay", "showLoading", "hideLoading", "onBufferingUpdate", "block", "onPlayingProgressUpdate", "callback", "isPlaying", "isPaused", "onSingleTap", "updateProgress", "resetViewVisible", "fitVideoSize", "setPlayButtonVisible", "visible", "fitVideoViewSize", "abandonAudioFocus", "execAction", "action", "isSurfaceValid", "enqueueAction", "execPendingActions", "clearPendingActions", "Companion", "PlayType", "EngineListener", "ProgressUpdateTask", "GestureDetectorListener", "AfterClickCallBack", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class VideoPlayView extends FrameLayout {
    public static final /* synthetic */ int z = 0;
    public String a;
    public Function1<? super Integer, Unit> b;
    public Function1<? super Integer, Unit> c;
    public final TextureView d;
    public final ImageView e;
    public final ActivityIndicatorView f;
    public Surface g;
    public float h;
    public float i;
    public float j;
    public String k;
    public IVideoController l;
    public boolean m;
    public final Handler n;
    public boolean o;
    public ArrayList<Runnable> p;
    public final int q;
    public final float r;
    public c s;
    public boolean t;
    public final p u;
    public final q v;
    public Function0<Unit> w;
    public final com.larus.media.model.a x;
    public boolean y;

    public static final class Companion {

        @Target({ElementType.PARAMETER, ElementType.TYPE_USE})
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/larus/doc/impl/video/widget/VideoPlayView$Companion$PlayStatus;", "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
        @kotlin.annotation.Target(allowedTargets = {AnnotationTarget.VALUE_PARAMETER, AnnotationTarget.TYPE})
        @Retention(RetentionPolicy.SOURCE)
        @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
        public @interface PlayStatus {
            public static final a Companion = null;
            public static final int PLAY_COMPLETE = 2;
            public static final int PLAY_FAIL = 1;
            public static final int PLAY_PAUSE = 3;
            public static final int PLAY_SUCCESS = 0;

            public static final class a {
                public static final /* synthetic */ a a = null;

                static {
                    a = new a();
                }

                public a() {
                }
            }

            static {
                Companion = a.a;
            }
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0083\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/larus/doc/impl/video/widget/VideoPlayView$PlayType;", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface PlayType {
    }

    public interface a {
    }

    public static final class b implements n0 {
        public final VideoPlayView a;

        public final void b(Integer r1, Integer r2) {
        }

        public final void onPrepare() {
        }

        public final void onPrepared() {
        }

        public final void onCompletion() {
            Function1<? super Integer, Unit> r0 = this.a.c;
            if (r0 == null) goto L6;
            r0.invoke(2);
            return;
        }

        public final void onRenderStart() {
            VideoPlayView.a(this.a);
            this.a.c();
            Function1<? super Integer, Unit> r0 = this.a.c;
            if (r0 == null) goto L6;
            r0.invoke(0);
            return;
        }

        public b(VideoPlayView r2) {
            Intrinsics.checkNotNullParameter(r2, "view");
            this.a = r2;
        }

        public final void c(int r4) {
            FLogger.a.i("VideoPlayView", "onPlaybackStateChanged: " + r4);
            if (r4 != 0) goto L5;
        L18:
            VideoPlayView r5 = this.a;
            int r0 = VideoPlayView.z;
            r5.getClass();
            Lazy r1 = MediaResourceManager.a;
            MediaResourceManager.a(r5.x);
            return;
        L5:
            if (r4 != 1) goto L7;
            this.a.e.setVisibility(8);
            this.a.c();
            Function1<? super Integer, Unit> r6 = this.a.c;
            if (r6 == null) goto L17;
            r6.invoke(0);
        L17:
            this.a.getCurrentPlaybackTime();
            return;
        L7:
            if (r4 == 2) goto L18;
            if (r4 != 3) goto L23;
            this.a.c();
            Function1<? super Integer, Unit> r7 = this.a.c;
            if (r7 == null) goto L20;
            r7.invoke(1);
            return;
        L20:
            return;
        }

        public final void d(int r4) {
            FLogger.a.i("VideoPlayView", "onLoadStateChanged: " + r4);
            if (r4 != 1) goto L5;
            this.a.c();
            Function1<? super Integer, Unit> r5 = this.a.c;
            if (r5 == null) goto L23;
            r5.invoke(0);
            return;
        L23:
            return;
        L5:
            if (r4 != 2) goto L7;
            VideoPlayView r6 = this.a;
            r6.n.removeCallbacks(r6.u);
            r6.n.postDelayed(r6.u, 500);
            if (NetworkUtils.isNetworkAvailable(this.a.getContext()) == true) goto L21;
            t19.s r7 = t19.s.a;
            Context r0 = this.a.getContext();
            String r1 = this.a.getContext().getResources().getString(2131906741);
            r7.getClass();
            t19.s.c(r0, r1);
            return;
        L21:
            return;
        L7:
            if (r4 != 3) goto L24;
            Function1<? super Integer, Unit> r8 = this.a.c;
            if (r8 == null) goto L12;
            r8.invoke(1);
        L12:
            this.a.c();
            return;
        }

        public final void onVideoStatusException(int r4) {
            FLogger.a.e("VideoPlayView", "onVideoStatusException: " + r4);
            this.a.post(new u(this));
        }

        public final void a(Integer r3, Integer r4) {
            FLogger.a.e("VideoPlayView", "onError: " + r3);
            Function1<? super Integer, Unit> r5 = this.a.c;
            if (r5 == null) goto L5;
            r5.invoke(1);
        L5:
            this.a.c();
        }
    }

    public static final class c implements Runnable {
        public final VideoPlayView a;

        @Override // java.lang.Runnable
        public final void run() {
            VideoPlayView.a(this.a);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public c(VideoPlayView r2) {
            Intrinsics.checkNotNullParameter(r2, "view");
            this.a = r2;
        }
    }

    public static final class d implements TextureView.SurfaceTextureListener {
        public final /* synthetic */ VideoPlayView a;

        @Override // android.view.TextureView.SurfaceTextureListener
        public final void onSurfaceTextureSizeChanged(SurfaceTexture r1, int r2, int r3) {
            Intrinsics.checkNotNullParameter(r1, "surface");
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public final void onSurfaceTextureUpdated(SurfaceTexture r2) {
            Intrinsics.checkNotNullParameter(r2, "surface");
        }

        public d(VideoPlayView r1) {
            this.a = r1;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public final boolean onSurfaceTextureDestroyed(SurfaceTexture r2) {
            Intrinsics.checkNotNullParameter(r2, "surface");
            r2.release();
            Surface r3 = this.a.g;
            if (r3 == null) goto L5;
            r3.release();
        L5:
            this.a.g = null;
            return true;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public final void onSurfaceTextureAvailable(SurfaceTexture r3, int r4, int r5) {
            Intrinsics.checkNotNullParameter(r3, "surface");
            VideoPlayView r6 = this.a;
            int r7 = VideoPlayView.z;
            Surface r8 = r6.g;
            if (r8 != null) goto L5;
        L7:
            boolean r9 = false;
        L8:
            if (r9 == true) goto L10;
            VideoPlayView r10 = this.a;
            r10.g = new Surface(r3);
        L10:
            VideoPlayView r11 = this.a;
            IVideoController r12 = r11.l;
            if (r12 != null) goto L13;
        L15:
            VideoPlayView r13 = this.a;
            if (r13.o == true) goto L30;
            ArrayList<Runnable> r14 = r13.p;
            if (r14 == null) goto L27;
            r13.o = true;
            Iterator r15 = new ArrayList(r14).iterator();
        L22:
            if (r15.hasNext() == false) goto L24;
            ((Runnable) r15.next()).run();
            goto L22
        L24:
            ArrayList<Runnable> r16 = r13.p;
            if (r16 == null) goto L27;
            r16.clear();
        L27:
            r13.o = false;
            return;
        L30:
            return;
        L13:
            if (r11.m == false) goto L15;
            r12.setSurface(r11.g);
            goto L15
        L5:
            if (r8.isValid() != true) goto L7;
            r9 = true;
            goto L8
        }
    }

    public static final class e implements com.larus.media.v {
        public ValueAnimator a;
        public final /* synthetic */ VideoPlayView b;

        public e(VideoPlayView r1) {
            this.b = r1;
        }

        public final boolean b(lk9.g r2) {
            Intrinsics.checkNotNullParameter(r2, "applicant");
            if (Intrinsics.areEqual(r2.getScene(), "TTS_SAMPLE") == false) goto L6;
            return true;
        L6:
            return false;
        }

        public final void e(lk9.g r1) {
            com.larus.media.v.a.d(r1);
        }

        public final void f(MediaResourceManager.a r2) {
            Intrinsics.checkNotNullParameter(r2, "event");
        }

        public final void a(lk9.g r4, float r5) {
            Intrinsics.checkNotNullParameter(r4, "applicant");
            final VideoPlayView r0 = this.b;
            r0.n.post(new w(r0, this));
            com.larus.media.v.a.f(r4, r5);
        }

        public final void d(lk9.g r2, lk9.g r3) {
            Intrinsics.checkNotNullParameter(r2, "current");
            Intrinsics.checkNotNullParameter(r3, "applicant");
            com.larus.media.v.a.c(r2, r3);
            final VideoPlayView r4 = this.b;
            r4.n.post(new v(r4, this));
        }

        public final void g(lk9.g r1, float r2) {
            com.larus.media.v.a.g(r1, r2);
        }

        public final void i(lk9.g r1, lk9.g r2) {
            com.larus.media.v.a.e(r1, r2);
        }

        public final MediaOccupyStrategy c(lk9.g r1, lk9.g r2, int r3) {
            return com.larus.media.v.a.a(this, r1, r2, r3);
        }

        public final MediaOccupyStrategy h(lk9.g r1, lk9.g r2, int r3) {
            Intrinsics.checkNotNullParameter(r1, "current");
            Intrinsics.checkNotNullParameter(r2, "applicant");
            return MediaOccupyStrategy.PAUSE;
        }
    }

    static {
    }

    public VideoPlayView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public VideoPlayView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public final a getAfterClickCallBack() {
        return null;
    }

    public final void setAfterClickCallBack(a r1) {
    }

    public final void c() {
        this.n.removeCallbacks(this.u);
        this.f.setVisibility(8);
    }

    public final void d() {
        FLogger.a.i("VideoPlayView", "[onSingleTap]");
        if (this.t == false) goto L5;
        return;
    L5:
        IVideoController r0 = this.l;
        IVideoController.PlayType r1 = null;
        if (r0 == null) goto L8;
        IVideoController.PlayType r2 = r0.d();
    L9:
        boolean r3 = false;
        if (r2 != IVideoController.PlayType.PLAY) goto L12;
        boolean r4 = true;
    L13:
        if (r4 == false) goto L15;
        e(true);
        return;
    L15:
        IVideoController r5 = this.l;
        if (r5 == null) goto L19;
        r1 = r5.d();
    L19:
        if (r1 != IVideoController.PlayType.PAUSE) goto L21;
        r3 = true;
    L21:
        if (r3 == false) goto L23;
        f(true);
        return;
    L23:
        g();
        return;
    L12:
        r4 = false;
        goto L13
    L8:
        r2 = null;
        goto L9
    }

    public final void g() {
        Lazy r0 = MediaResourceManager.a;
        MediaResourceManager.m(this.x, new n(this), new o(this), 0, 8);
    }

    public final long getCurrentPlaybackTime() {
        IVideoController r0 = this.l;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.getCurrentPlaybackTime();
    }

    public final long getDuration() {
        IVideoController r0 = this.l;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.n();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        getViewTreeObserver().addOnPreDrawListener(this.v);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getViewTreeObserver().removeOnPreDrawListener(this.v);
        Lazy r0 = MediaResourceManager.a;
        MediaResourceManager.a(this.x);
    }

    public final Function0<Unit> getDismissCallback() {
        return this.w;
    }

    public final boolean getMResumeOrPauseByUser() {
        return this.y;
    }

    public static final void a(VideoPlayView r8) {
        c r0 = r8.s;
        if (r0 == null) goto L9;
        long r1 = r8.getCurrentPlaybackTime();
        long r3 = r8.getDuration();
        Function1<? super Integer, Unit> r5 = r8.b;
        if (r5 == null) goto L7;
        r5.invoke(Integer.valueOf((int) ((r1 * ((long) 100)) / r3)));
    L7:
        r8.postDelayed(r0, 30);
        return;
    }

    public final void b(Runnable r3) {
        Surface r0 = this.g;
        if (r0 == null) goto L7;
        boolean r1 = true;
        if (r0.isValid() != true) goto L7;
    L8:
        if (r1 == false) goto L11;
        r3.run();
        return;
    L11:
        if (this.p != null) goto L13;
        this.p = new ArrayList();
    L13:
        ArrayList<Runnable> r2 = this.p;
        if (r2 == null) goto L18;
        r2.add(r3);
        return;
    L18:
        return;
    L7:
        r1 = false;
        goto L8
    }

    public final void e(final boolean r4) {
        FLogger.a.i("VideoPlayView", "[pause] byUser:" + r4);
        IVideoController r0 = this.l;
        if (r0 == null) goto L5;
        IVideoController.PlayType r1 = r0.d();
    L7:
        if (r1 != IVideoController.PlayType.PLAY) goto L11;
        Function1<? super Integer, Unit> r2 = this.c;
        if (r2 == null) goto L11;
        r2.invoke(3);
    L11:
        b(new m(this, r4));
        return;
    L5:
        r1 = null;
        goto L7
    }

    public final void f(final boolean r4) {
        FLogger.a.i("VideoPlayView", "[resume] byUser:" + r4);
        b(new l(this, r4));
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r8) {
        Intrinsics.checkNotNullParameter(r8, "ev");
        int r0 = r8.getActionMasked();
        if (r0 != 0) goto L5;
        this.i = r8.getX();
        this.j = r8.getY();
        getParent().requestDisallowInterceptTouchEvent(true);
    L27:
        return super.onInterceptTouchEvent(r8);
    L5:
        if (r0 != 1) goto L7;
    L24:
        getParent().requestDisallowInterceptTouchEvent(false);
        goto L27
    L7:
        if (r0 != 2) goto L9;
        float r1 = r8.getX() - this.i;
        float r3 = r8.getY() - this.j;
        if (Math.abs(r3) > this.q) goto L14;
    L16:
        boolean r4 = false;
    L18:
        if (Math.abs(r1) <= this.q) goto L20;
        int r2 = (Math.abs(r1) > Math.abs(r3) ? 1 : (Math.abs(r1) == Math.abs(r3) ? 0 : -1));
    L20:
        if (r4 == true) goto L22;
        getParent().requestDisallowInterceptTouchEvent(false);
        goto L27
    L22:
        getParent().requestDisallowInterceptTouchEvent(true);
        return true;
    L14:
        if (Math.abs(r3) <= Math.abs(r1)) goto L16;
        r4 = true;
        goto L18
    L9:
        if (r0 == 3) goto L24;
        goto L24
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r8) {
        Intrinsics.checkNotNullParameter(r8, "ev");
        if (r8.getActionMasked() != 2) goto L27;
        float r0 = r8.getX() - this.i;
        float r1 = r8.getY() - this.j;
        boolean r4 = false;
        if (Math.abs(r1) > this.q) goto L7;
    L9:
        boolean r2 = false;
    L11:
        if (Math.abs(r0) <= this.q) goto L13;
        int r3 = (Math.abs(r0) > Math.abs(r1) ? 1 : (Math.abs(r0) == Math.abs(r1) ? 0 : -1));
    L13:
        if (r2 == true) goto L15;
        getParent().requestDisallowInterceptTouchEvent(false);
        goto L27
    L15:
        getParent().requestDisallowInterceptTouchEvent(true);
        float r9 = this.r;
        if (r1 <= r9) goto L18;
        r4 = true;
    L18:
        int r10 = (r0 > r9 ? 1 : (r0 == r9 ? 0 : -1));
        if (r4 == false) goto L25;
        Function0<Unit> r11 = this.w;
        if (r11 == null) goto L24;
        r11.invoke();
    L24:
        this.t = true;
    L25:
        return true;
    L7:
        if (Math.abs(r1) <= Math.abs(r0)) goto L9;
        r2 = true;
    L27:
        return super.onTouchEvent(r8);
    }

    public final void setDismissCallback(Function0<Unit> r1) {
        this.w = r1;
    }

    public final void setMResumeOrPauseByUser(boolean r1) {
        this.y = r1;
    }

    public final void setPlayButtonVisible(int r2) {
        this.e.setVisibility(r2);
    }

    /* JADX WARN: Type inference failed for: r6v1, types: [com.larus.doc.impl.video.widget.p] */
    /* JADX WARN: Type inference failed for: r6v2, types: [com.larus.doc.impl.video.widget.q] */
    public VideoPlayView(Context r23, AttributeSet r24, int r25) {
        Intrinsics.checkNotNullParameter(r23, "context");
        super(r23, r24, r25);
        TextureView r2 = new TextureView(r23);
        this.d = r2;
        ImageView r3 = new ImageView(r23);
        this.e = r3;
        ActivityIndicatorView r4 = new ActivityIndicatorView(r23, null);
        this.f = r4;
        this.n = new Handler(Looper.getMainLooper());
        this.q = ViewConfiguration.get(r23).getScaledTouchSlop();
        this.r = 150.0f;
        d r5 = new d(this);
        this.u = new p(this);
        this.v = new q(this);
        this.x = new com.larus.media.model.a(null, "VIDEO", false, 0, 2, false, MixPriority.DEFAULT.getValue(), false, false, MediaLevel.PLAY_HIGH.getValue(), false, new e(this), 1453);
        setBackgroundColor(v19.c.a(2130972310, r23, 2131103292));
        addView(r2, -1, -1);
        int r6 = (int) UIUtils.dip2Px(r23, 56.0f);
        int r7 = (int) UIUtils.dip2Px(r23, 32.0f);
        FrameLayout.LayoutParams r8 = new FrameLayout.LayoutParams(r6, r6);
        r8.gravity = 17;
        addView(r3, r8);
        r3.setImageResource(2131243486);
        e1.d(r3, new r(this));
        FrameLayout.LayoutParams r9 = new FrameLayout.LayoutParams(r7, r7);
        r9.gravity = 17;
        r4.d = true;
        r4.setColor(v19.c.a(2130972081, r23, 2131103143));
        r4.setStrokeWidth(i5.Y());
        r4.setVisibility(8);
        addView(r4, r9);
        r2.setSurfaceTextureListener(r5);
        e1.d(this, new s(this));
    }

    public /* synthetic */ VideoPlayView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    @Override // android.view.View
    public final void onSizeChanged(int r1, int r2, int r3, int r4) {
        super.onSizeChanged(r1, r2, r3, r4);
    }
}
