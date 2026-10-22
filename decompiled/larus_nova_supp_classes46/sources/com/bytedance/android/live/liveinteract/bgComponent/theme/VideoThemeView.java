package com.bytedance.android.live.liveinteract.bgComponent.theme;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Movie;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.media.MediaMetadataRetriever;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.FileUtils;
import com.bytedance.android.live.ui.t;
import com.bytedance.android.livesdkapi.depend.model.live.audio.IThemeShowArea;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.ttvideoengine.TTVideoEngine;
import com.ss.ttvideoengine.VideoEngineSimpleCallback;
import com.ss.ttvideoengine.VideoInfoListener;
import com.ss.ttvideoengine.model.VideoModel;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u0019B'\b\u0007\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u000b¢\u0006\u0004\b\u0017\u0010\u0018J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0012\u0010\n\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\r\u001a\u00020\u000bH\u0016J\b\u0010\u000e\u001a\u00020\u000bH\u0016J\u0010\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/live/liveinteract/bgComponent/theme/VideoThemeView;", "Landroid/widget/FrameLayout;", "Landroid/view/SurfaceHolder$Callback;", "Lcom/bytedance/android/live/ui/o;", "Lcom/bytedance/android/live/ui/t;", "rect", "", "setDisplayWindowRect", "Lcom/bytedance/android/livesdkapi/depend/model/live/audio/IThemeShowArea;", "showArea", "setShowArea", "", "getShowWidth", "getShowHeight", "getShowDirection", "", "alpha", "setThemeViewAlpha", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "c", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class VideoThemeView extends FrameLayout implements SurfaceHolder.Callback, com.bytedance.android.live.ui.o {
    public final b A;
    public final f B;
    public TTVideoEngine a;
    public String b;
    public IThemeShowArea c;
    public Rect d;
    public boolean e;
    public int f;
    public int g;
    public int h;
    public int i;
    public int j;
    public int k;
    public int l;
    public boolean m;
    public boolean n;
    public Movie o;
    public String p;
    public com.bytedance.android.live.ui.n q;
    public final Handler r;
    public final a s;
    public long t;
    public final Paint u;
    public int v;
    public SurfaceHolder w;
    public final SurfaceView x;
    public final e y;
    public final d z;

    public static final class a implements Runnable {
        public final /* synthetic */ VideoThemeView a;

        public a(VideoThemeView r1) {
            this.a = r1;
        }

        public final void a() {
            Movie r0 = this.a.o;
            if (r0 != null) goto L5;
            return;
        L5:
            Intrinsics.checkNotNull(r0);
            int r1 = r0.width();
            Movie r2 = this.a.o;
            Intrinsics.checkNotNull(r2);
            Bitmap r3 = Bitmap.createBitmap(r1, r2.height(), Bitmap.Config.ARGB_8888);
            Canvas r4 = new Canvas(r3);
            Movie r5 = this.a.o;
            Intrinsics.checkNotNull(r5);
            r5.draw(r4, 0.0f, 0.0f);
            Movie r6 = this.a.o;
            Intrinsics.checkNotNull(r6);
            if (r6.duration() == 0) goto L8;
            Movie r7 = this.a.o;
            Intrinsics.checkNotNull(r7);
            VideoThemeView r8 = this.a;
            long r9 = r8.t;
            Movie r10 = r8.o;
            Intrinsics.checkNotNull(r10);
            r7.setTime((int) (r9 % ((long) r10.duration())));
        L9:
            r4.save();
            int r11 = r3.getWidth();
            int r12 = r3.getHeight();
            float r13 = this.a.getWidth() / r11;
            float r14 = this.a.getHeight() / r12;
            SurfaceView r15 = this.a.x;
            Intrinsics.checkNotNull(r15);
            int r16 = (r15.getWidth() - this.a.getWidth()) / 2;
            SurfaceView r17 = this.a.x;
            Intrinsics.checkNotNull(r17);
            int r18 = (r17.getHeight() - this.a.getHeight()) / 2;
            Rect r19 = new Rect(r16, r18, this.a.getWidth() + r16, this.a.getHeight() + r18);
            Matrix r20 = new Matrix();
            r20.postScale(r13, r14);
            Bitmap r21 = Bitmap.createBitmap(r3, 0, 0, r11, r12, r20, true);
            SurfaceHolder r22 = this.a.w;
            if (r22 == null) goto L12;
            Canvas r23 = r22.lockCanvas(r19);
        L13:
            if (r23 != null) goto L15;
            return;
        L15:
            r23.drawColor(0, PorterDuff.Mode.CLEAR);
            Paint r24 = this.a.u;
            Intrinsics.checkNotNull(r24);
            r23.drawBitmap(r21, null, r19, r24);
            SurfaceHolder r25 = this.a.w;
            if (r25 == null) goto L18;
            r25.unlockCanvasAndPost(r23);
        L18:
            VideoThemeView r26 = this.a;
            r26.t += 35;
            a r27 = r26.s;
            if (r27 == null) goto L22;
            r26.r.postDelayed(r27, 35);
            return;
        L22:
            return;
        L12:
            r23 = null;
            goto L13
        L8:
            Movie r28 = this.a.o;
            Intrinsics.checkNotNull(r28);
            r28.setTime(0);
            goto L9
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class b implements ViewTreeObserver.OnGlobalLayoutListener {
        public final /* synthetic */ VideoThemeView a;

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            VideoThemeView.a(this.a);
            this.a.getViewTreeObserver().removeOnGlobalLayoutListener(this.a.A);
        }

        public b(VideoThemeView r1) {
            this.a = r1;
        }
    }

    public static final class c {
    }

    public static final class d extends VideoEngineSimpleCallback {
        public final /* synthetic */ VideoThemeView a;

        public d(VideoThemeView r1) {
            this.a = r1;
        }

        public final void onPrepared(TTVideoEngine r1) {
            super.onPrepared(r1);
            if (r1 == null) goto L6;
            r1.start();
            return;
        }

        public final void onPlaybackStateChanged(TTVideoEngine r3, int r4) {
            super.onPlaybackStateChanged(r3, r4);
            ALogger.d("VideoThemeView" + hashCode(), "onPlaybackStateChanged: 视频播放状态 - 状态=" + r4);
            if (r4 != 1) goto L8;
            com.bytedance.android.live.ui.n r5 = this.a.q;
            if (r5 == null) goto L9;
            r5.b();
            return;
        L9:
            return;
        }

        public final void onVideoSizeChanged(TTVideoEngine r3, int r4, int r5) {
            super.onVideoSizeChanged(r3, r4, r5);
            ALogger.i("VideoThemeView" + hashCode(), "onVideoSizeChanged: 视频播放大小 - 宽度=" + r4 + ", 高度=" + r5);
            VideoThemeView r6 = this.a;
            r6.f = r4;
            r6.g = r5;
        }
    }

    public static final class e implements com.bytedance.android.live.liveinteract.bgComponent.theme.audioScene.b {
        public final /* synthetic */ VideoThemeView a;

        public static final class a implements Runnable {
            public final /* synthetic */ e a;
            public final /* synthetic */ String b;

            public a(e r1, String r2) {
                this.a = r1;
                this.b = r2;
            }

            public final void a() {
                ALogger.d("VideoThemeView" + this.a.hashCode(), "onDownloadCompleted: 下载完成，开始播放");
                VideoThemeView r0 = this.a.a;
                r0.d(this.b, r0.p, r0.q);
            }

            @Override // java.lang.Runnable
            public final void run() {
                a();     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        @Override // com.bytedance.android.live.liveinteract.bgComponent.theme.audioScene.b
        public final void b() {
        }

        public e(VideoThemeView r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.live.liveinteract.bgComponent.theme.audioScene.b
        public final void a(String r3) {
            Intrinsics.checkNotNullParameter(r3, "path");
            this.a.post(new a(this, r3));
        }
    }

    public static final class f implements VideoInfoListener {
        public final /* synthetic */ VideoThemeView a;

        public f(VideoThemeView r1) {
            this.a = r1;
        }

        public final boolean onFetchedVideoInfo(VideoModel r1) {
            VideoThemeView.a(this.a);
            return false;
        }
    }

    static {
    }

    public VideoThemeView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public VideoThemeView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r1) {
        return false;
    }

    public final void show() {
        setVisibility(0);
    }

    public final void b() {
        if (this.n == false) goto L8;
        TTVideoEngine r0 = this.a;
        if (r0 == null) goto L9;
        r0.pause();
        return;
    L9:
        return;
    }

    public final void c() {
        ALogger.d("VideoThemeView" + hashCode(), "tryStopPlay: 停止播放，isVideoPlaying " + this.n + ", isGifPlaying " + this.m);
        if (this.n == false) goto L8;
        TTVideoEngine r0 = this.a;
        if (r0 == null) goto L8;
        r0.stop();
    L8:
        if (this.m == false) goto L13;
        a r1 = this.s;
        if (r1 == null) goto L14;
        this.r.removeCallbacks(r1);
        return;
    L14:
        return;
    }

    public final void hide() {
        setVisibility(8);
    }

    public final boolean isPlaying() {
        TTVideoEngine r0 = this.a;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.getPlaybackState() != 1) goto L7;
        return true;
    }

    public final void tryResumePlay() {
        if (this.n == false) goto L12;
        TTVideoEngine r0 = this.a;
        if (r0 != null) goto L7;
        return;
    L7:
        if (r0.isPrepared() != true) goto L14;
        TTVideoEngine r1 = this.a;
        if (r1 == null) goto L15;
        r1.play();
        return;
    L15:
        return;
    L14:
        return;
    }

    public final boolean isVisible() {
        if (getVisibility() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ALogger.d("VideoThemeView" + hashCode(), "onDetachedFromWindow mPlayer?.release()");
        TTVideoEngine r0 = this.a;
        if (r0 == null) goto L5;
        r0.release();
    L5:
        this.a = null;
        a r1 = this.s;
        if (r1 == null) goto L9;
        this.r.removeCallbacks(r1);
        return;
    }

    public int getShowDirection() {
        return this.v;
    }

    public int getShowHeight() {
        return this.i;
    }

    public int getShowWidth() {
        return this.j;
    }

    public static final void a(VideoThemeView r7) {
        if (r7.e == true) goto L5;
        return;
    L5:
        if (r7.b == null) goto L29;
        Rect r0 = r7.d;
        if (r0 == null) goto L30;
        Intrinsics.checkNotNull(r0);
        int r1 = r0.width();
        int r2 = r0.height();
        ALogger.d("VideoThemeView" + r7.hashCode(), "notifyShowAreaChanged: 显示区域 - 宽=" + r1 + ", 高=" + r2 + ", 区域=" + r0);
        if (r7.n == true) goto L12;
    L18:
        r7.j = r1;
        r7.i = r2;
        if (r7.f <= r7.g) goto L23;
        if ((r7.h % 180) != 0) goto L23;
    L24:
        int r3 = 0;
    L26:
        r7.v = r3;
        ALogger.d("VideoThemeView" + r7.hashCode(), "notifyShowAreaChanged: 更新显示宽高 - showWidth=" + r7.j + ", showHeight=" + r7.i);
        r7.e = false;
        return;
    L23:
        if (r7.k > r7.l) goto L24;
        r3 = 1;
        goto L26
    L12:
        if (r7.f <= 0) goto L18;
        if (r7.g <= 0) goto L18;
        TTVideoEngine r4 = r7.a;
        if (r4 == null) goto L18;
        r4.setIntOption(4, 2);
        goto L18
    L30:
        return;
    }

    public final void f(String r3) {
        MediaMetadataRetriever r0 = new MediaMetadataRetriever();
        r0.setDataSource(new PolarisFileInputStreamWrapper(r3).getFD());
        String r4 = e(r0, 18);
        int r1 = 0;
        if (r4 == null) goto L5;
        int r5 = CastIntegerProtector.parseInt(r4);
    L6:
        this.f = r5;
        String r6 = e(r0, 19);
        if (r6 == null) goto L9;
        int r7 = CastIntegerProtector.parseInt(r6);
    L10:
        this.g = r7;
        String r8 = e(r0, 24);
        if (r8 == null) goto L13;
        r1 = CastIntegerProtector.parseInt(r8);
    L13:
        this.h = r1;
        return;
    L9:
        r7 = 0;
        goto L10
    L5:
        r5 = 0;
        goto L6
    }

    public void setDisplayWindowRect(t r4) {
        if (r4 == null) goto L19;
        Rect r0 = new Rect();
        Float r1 = r4.a;
        int r2 = 0;
        if (r1 == null) goto L6;
        int r3 = (int) r1.floatValue();
    L7:
        r0.left = r3;
        Float r5 = r4.b;
        if (r5 == null) goto L10;
        int r6 = (int) r5.floatValue();
    L11:
        r0.top = r6;
        Float r7 = r4.c;
        if (r7 == null) goto L14;
        int r8 = (int) r7.floatValue();
    L15:
        r0.right = r8;
        Float r9 = r4.d;
        if (r9 == null) goto L18;
        r2 = (int) r9.floatValue();
    L18:
        r0.bottom = r2;
    L20:
        this.d = r0;
        if (r4 == null) goto L36;
        SurfaceView r10 = this.x;
        if (r10 == null) goto L25;
        ViewGroup.LayoutParams r11 = r10.getLayoutParams();
    L26:
        if (r11 == null) goto L35;
        FrameLayout.LayoutParams r12 = (FrameLayout.LayoutParams) r11;
        r12.leftMargin = r0.left;
        r12.topMargin = r0.top;
        r12.width = r0.width();
        r12.height = r0.height();
        r12.gravity = 51;
        SurfaceView r13 = this.x;
        if (r13 == null) goto L30;
        r13.setLayoutParams(r12);
    L30:
        SurfaceView r14 = this.x;
        if (r14 == null) goto L33;
        r14.requestLayout();
    L33:
        this.e = true;
        return;
    L35:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
    L25:
        r11 = null;
        goto L26
    L36:
        return;
    L14:
        r8 = 0;
        goto L15
    L10:
        r6 = 0;
        goto L11
    L6:
        r3 = 0;
        goto L7
    L19:
        r0 = new Rect();
        goto L20
    }

    public void setShowArea(IThemeShowArea r1) {
        this.c = r1;
    }

    public void setThemeViewAlpha(float r1) {
        setAlpha(r1);
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceCreated(SurfaceHolder r3) {
        Intrinsics.checkNotNullParameter(r3, "holder");
        ALogger.d("VideoThemeView" + hashCode(), "surfaceCreated: 开始播放");
        ALogger.d("VideoThemeView" + hashCode(), "mVideoUrl: " + this.b);
        d(this.b, this.p, null);
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceDestroyed(SurfaceHolder r2) {
        Intrinsics.checkNotNullParameter(r2, "holder");
        ALogger.d("VideoThemeView" + hashCode(), "surfaceDestroyed");
    }

    public static String e(MediaMetadataRetriever r18, int r19) {
        ArrayList r0 = new ArrayList();
        Object[] r1 = {Integer.valueOf(r19)};
        f06.b r11 = new f06.b();
        g06.a r2 = (g06.a) ApiHookConfig.b.get(100023);
        if (r2 == null) goto L5;
        f06.a[] r3 = r2.i;
    L6:
        f06.a[] r15 = r3;
        int r9 = r15.length;
        int r8 = 0;
    L8:
        if (r8 >= r9) goto L15;
        f06.a r7 = r15[r8];
        int r16 = r8;
        int r17 = r9;
        f06.d r4 = r7.preInvoke(100023, "android/media/MediaMetadataRetriever", "extractMetadata", r18, r1, "java.lang.String", r11);     // Catch: Exception -> L22
        if (r4.a == true) goto L17;
        r0.add(r7);     // Catch: Exception -> L22
    L17:
        if (r4.a == false) goto L21;
        return (String) r4.b;
    L21:
        return r18.extractMetadata(r19);
    L14:
        r8 = r16 + 1;
        r9 = r17;
        goto L8
    L15:
        r4 = new f06.d(false, null);
        goto L17
    L5:
        r3 = ApiHookConfig.d;
        goto L6
    }

    public VideoThemeView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.p = "";
        this.r = new Handler();
        this.v = 1;
        this.y = new e(this);
        this.z = new d(this);
        this.B = new f(this);
        LayoutInflater.from(r2).inflate(2131565184, this, true);
        SurfaceView r5 = (SurfaceView) findViewById(2131392379);
        this.x = r5;
        if (r5 == null) goto L5;
        SurfaceHolder r6 = r5.getHolder();
    L6:
        this.w = r6;
        if (r6 == null) goto L9;
        r6.addCallback(this);
    L9:
        Paint r7 = new Paint();
        this.u = r7;
        Intrinsics.checkNotNull(r7);
        r7.setAntiAlias(true);
        this.s = new a(this);
        this.A = new b(this);
        return;
    L5:
        r6 = null;
        goto L6
    }

    public final void d(String r12, String r13, com.bytedance.android.live.ui.n r14) {
        if (r12 != null) goto L5;
    L8:
        boolean r3 = true;
    L9:
        if (r3 == false) goto L12;
        return;
    L12:
        if (this.w != null) goto L18;
        SurfaceView r4 = this.x;
        if (r4 == null) goto L16;
        SurfaceHolder r5 = r4.getHolder();
    L17:
        this.w = r5;
        goto L18
    L16:
        r5 = null;
    L18:
        PolarisFileWrapper r6 = new PolarisFileWrapper(r12);
        boolean r7 = r6.exists();
        boolean r8 = FileUtils.isGIF(r6);
        ALogger.d("VideoThemeView" + hashCode(), "startPlay: file=" + r6.getAbsolutePath() + ", islocal=" + r7 + ", isGIf=" + r8);
        if (r14 != null) goto L21;
        com.bytedance.android.live.ui.n r9 = this.q;
    L22:
        this.q = r9;
        this.o = null;
        if (r7 == false) goto L28;
        if (r8 == false) goto L26;
        this.m = true;
        this.n = false;
        this.o = Movie.decodeFile(r12);
    L27:
        this.b = r12;
    L40:
        this.e = true;
        String r15 = this.b;
        if (r15 != null) goto L43;
    L46:
        boolean r16 = true;
    L47:
        if (r16 == false) goto L49;
    L53:
        Movie r17 = this.o;
        if (r17 != null) goto L56;
    L58:
        getViewTreeObserver().addOnGlobalLayoutListener(this.A);
        a r18 = this.s;
        if (r18 == null) goto L61;
        this.r.removeCallbacks(r18);
    L61:
        ALogger.d("VideoThemeView" + hashCode(), "isVideoPlaying=" + this.n + ", isGifPlaying=" + this.m);
        if (this.n == false) goto L93;
        a r19 = this.s;
        if (r19 == null) goto L67;
        this.r.removeCallbacks(r19);
    L67:
        if (this.a != null) goto L69;
        TTVideoEngine r110 = new TTVideoEngine(getContext().getApplicationContext(), 0);
        r110.setVideoEngineCallback(this.z);
        r110.setVideoInfoListener(this.B);
        Unit r111 = Unit.INSTANCE;
        this.a = r110;
    L69:
        TTVideoEngine r112 = this.a;
        if (r112 == null) goto L72;
        r112.setSurfaceHolder(this.w);
    L72:
        TTVideoEngine r113 = this.a;
        if (r113 == null) goto L75;
        r113.setLocalURL(this.b);
    L75:
        TTVideoEngine r114 = this.a;
        if (r114 == null) goto L78;
        r114.setIntOption(4, 1);
    L78:
        TTVideoEngine r115 = this.a;
        if (r115 == null) goto L81;
        r115.prepare();
    L81:
        TTVideoEngine r116 = this.a;
        if (r116 == null) goto L84;
        r116.setIsMute(true);
    L84:
        TTVideoEngine r117 = this.a;
        if (r117 == null) goto L87;
        r117.setLooping(true);
    L87:
        TTVideoEngine r118 = this.a;
        if (r118 == null) goto L90;
        r118.start();
    L90:
        if (r14 == null) goto L93;
        r14.a();
    L93:
        if (this.m == false) goto L110;
        TTVideoEngine r119 = this.a;
        if (r119 == null) goto L97;
        r119.release();
    L97:
        Movie r120 = this.o;
        Intrinsics.checkNotNull(r120);
        this.o = r120;
        this.t = 0;
        a r121 = this.s;
        if (r121 == null) goto L100;
        this.r.post(r121);
    L100:
        ALogger.d("VideoThemeView" + hashCode(), "startGif: 启动GIF播放，isGifPlaying设为true");
        return;
    L110:
        return;
    L56:
        if (this.m == false) goto L58;
        this.e = true;
        Intrinsics.checkNotNull(r17);
        this.l = r17.height();
        Movie r122 = this.o;
        Intrinsics.checkNotNull(r122);
        this.k = r122.width();
        ALogger.d("VideoThemeView" + hashCode(), "startPlay: GIF参数 - 宽=" + this.k + ", 高=" + this.l + ", needScale=" + this.e);
        goto L58
    L49:
        if (this.n == false) goto L53;
        ALogger.d("VideoThemeView" + hashCode(), "startPlay: 视频参数 - 视频地址=" + this.b);     // Catch: Throwable -> L52
        f(this.b);     // Catch: Throwable -> L52
        goto L58
    L43:
        if (StringsKt.isBlank(r15) == true) goto L46;
        r16 = false;
        goto L47
    L26:
        this.n = true;
        this.m = false;
        goto L27
    L28:
        this.n = true;
        this.m = false;
        if (r13 != null) goto L31;
    L34:
        boolean r10 = true;
    L35:
        if (r10 == false) goto L37;
        return;
    L37:
        this.p = r13;
        if (VideoThemeDownloadManager.e(r13) == false) goto L102;
        this.b = VideoThemeDownloadManager.d(r13);
        goto L40
    L102:
        Intrinsics.checkNotNullParameter(r13, "id");
        if (VideoThemeDownloadManager.b.containsKey(r13) == false) goto L106;
        VideoThemeDownloadManager.f(r13, this.y);
        return;
    L106:
        VideoThemeDownloadManager.b(r12, r13, this.y);
        return;
    L31:
        if (r13.length() == 0) goto L34;
        r10 = false;
        goto L35
    L21:
        r9 = r14;
        goto L22
    L5:
        if (r12.length() == 0) goto L8;
        r3 = false;
        goto L9
    }

    public /* synthetic */ VideoThemeView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceChanged(SurfaceHolder r2, int r3, int r4, int r5) {
        Intrinsics.checkNotNullParameter(r2, "holder");
        ALogger.d("VideoThemeView" + hashCode(), "surfaceChanged width ; " + r4 + " height : " + r5);
    }
}
