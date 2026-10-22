package com.obric.aiproactive.ui.widget;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.TextureView;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.bdlocation.monitor.LBSLightLocationTraceLogger;
import com.bytedance.common.wschannel.WsConstants;
import com.ttnet.org.chromium.net.NetError;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002:\u0001;B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u001d\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\fJ\u0016\u0010\u001f\u001a\u00020\u00152\u000e\u0010 \u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014J\u0016\u0010!\u001a\u00020\u00152\u000e\u0010 \u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014J\u001c\u0010\"\u001a\u00020\u00152\u0014\u0010 \u001a\u0010\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0018J\u0006\u0010#\u001a\u00020\u0015J \u0010$\u001a\u00020\u00152\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\b2\u0006\u0010(\u001a\u00020\bH\u0016J \u0010)\u001a\u00020\u00152\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\b2\u0006\u0010(\u001a\u00020\bH\u0016J\u0010\u0010*\u001a\u00020\u00122\u0006\u0010%\u001a\u00020&H\u0016J\u0010\u0010+\u001a\u00020\u00152\u0006\u0010%\u001a\u00020&H\u0016J\b\u0010,\u001a\u00020\u0015H\u0014J\b\u0010-\u001a\u00020\u0015H\u0014J\b\u0010.\u001a\u00020\u0015H\u0002J\u0010\u0010/\u001a\u00020\u00152\u0006\u0010%\u001a\u00020&H\u0002J\u0010\u00100\u001a\u00020\u00152\u0006\u00101\u001a\u00020\u000eH\u0002J \u00102\u001a\u00020\u00152\u0006\u00101\u001a\u00020\u000e2\u0006\u00103\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\fH\u0002J\b\u00104\u001a\u00020\u0015H\u0002J\u001c\u00105\u001a\u00020\u00152\u0006\u00106\u001a\u00020\f2\n\u00107\u001a\u000608j\u0002`9H\u0002J\b\u0010:\u001a\u00020\u0015H\u0002R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u001a\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c¨\u0006<"}, d2 = {"Lcom/obric/aiproactive/ui/widget/AvatarTextureVideoView;", "Landroid/view/TextureView;", "Landroid/view/TextureView$SurfaceTextureListener;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "requestedVideoPath", "", "mediaPlayer", "Landroid/media/MediaPlayer;", "playbackSurface", "Landroid/view/Surface;", "firstFrameReported", "", "onPlaybackPendingListener", "Lkotlin/Function0;", "", "onFirstFrameListener", "onPlaybackErrorListener", "Lkotlin/Function1;", "Lcom/obric/aiproactive/ui/widget/AvatarTextureVideoView$PlaybackError;", "hasVideoSource", "getHasVideoSource", "()Z", "setVideoPath", "path", "setOnFirstFrameListener", "listener", "setOnPlaybackPendingListener", "setOnPlaybackErrorListener", "release", "onSurfaceTextureAvailable", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "width", "height", "onSurfaceTextureSizeChanged", "onSurfaceTextureDestroyed", "onSurfaceTextureUpdated", "onDetachedFromWindow", "onAttachedToWindow", "restartPlaybackIfSurfaceReady", "startPlaybackIfNeeded", "configureMediaPlayerCallbacks", "player", "prepareMediaPlayer", "surface", "reportUnsupportedRendering", "reportPlaybackFailure", "operation", CommonConsts.LOG_REPORT_TYPE_EXCEPTION, "Ljava/lang/Exception;", "Lkotlin/Exception;", "releasePlayback", "PlaybackError", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AvatarTextureVideoView extends TextureView implements TextureView.SurfaceTextureListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f6905a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private MediaPlayer f6906b;
    private Surface c;
    private boolean d;
    private Function0<Unit> e;
    private Function0<Unit> f;
    private Function1<? super a, Unit> g;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u000e\u0010\u0007\u001a\n\u0018\u00010\bj\u0004\u0018\u0001`\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\u0011\u0010\u0016\u001a\n\u0018\u00010\bj\u0004\u0018\u0001`\tHÆ\u0003J9\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\u0010\b\u0002\u0010\u0007\u001a\n\u0018\u00010\bj\u0004\u0018\u0001`\tHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0019\u0010\u0007\u001a\n\u0018\u00010\bj\u0004\u0018\u0001`\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001d"}, d2 = {"Lcom/obric/aiproactive/ui/widget/AvatarTextureVideoView$PlaybackError;", "", "operation", "", "what", "", WsConstants.KEY_EXTRA, "cause", "Ljava/lang/Exception;", "Lkotlin/Exception;", "<init>", "(Ljava/lang/String;IILjava/lang/Exception;)V", "getOperation", "()Ljava/lang/String;", "getWhat", "()I", "getExtra", "getCause", "()Ljava/lang/Exception;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f6907a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f6908b;
        private final int c;
        private final Exception d;

        public a(String r2, int r3, int r4, Exception r5) {
            Intrinsics.checkNotNullParameter(r2, "operation");
            this.f6907a = r2;
            this.f6908b = r3;
            this.c = r4;
            this.d = r5;
        }

        public final String a() {
            return this.f6907a;
        }

        public final int b() {
            return this.f6908b;
        }

        public final int c() {
            return this.c;
        }

        public final Exception d() {
            return this.d;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f6907a, r6.f6907a) == true) goto L12;
            return false;
        L12:
            if (this.f6908b == r6.f6908b) goto L15;
            return false;
        L15:
            if (this.c == r6.c) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public int hashCode() {
            int r0 = ((((this.f6907a.hashCode() * 31) + Integer.hashCode(this.f6908b)) * 31) + Integer.hashCode(this.c)) * 31;
            Exception r2 = this.d;
            if (r2 != null) goto L5;
            int r3 = 0;
        L7:
            return r0 + r3;
        L5:
            r3 = r2.hashCode();
            goto L7
        }

        public String toString() {
            return "PlaybackError(operation=" + this.f6907a + ", what=" + this.f6908b + ", extra=" + this.c + ", cause=" + this.d + ')';
        }
    }

    public AvatarTextureVideoView(Context r7) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "context");
        this(r1, null, 0, 6, null);
    }

    public AvatarTextureVideoView(Context r9, AttributeSet r10) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 0, 4, null);
    }

    public AvatarTextureVideoView(Context r3, AttributeSet r4, int r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "context");
        super(r6, r7, r5);
        setOpaque(false);
        setSurfaceTextureListener((TextureView.SurfaceTextureListener) ZeusTransformUtils.preCheckCast(this, TextureView.SurfaceTextureListener.class, "com.obric.memorydata.plugin"));
    }

    public /* synthetic */ AvatarTextureVideoView(Context r2, AttributeSet r3, int r4, int r5, DefaultConstructorMarker r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.memorydata.plugin");
        if ((r5 & 2) == 0) goto L6;
        r8 = null;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = 0;
    L8:
        this(r7, r8, r4);
    }

    private final void a(SurfaceTexture r4) {
        String r0 = this.f6905a;
        if (r0 != null) goto L6;
        return;
    L6:
        if (this.f6906b == null) goto L9;
        return;
    L9:
        if (isHardwareAccelerated() == true) goto L12;
        c();
        return;
    L12:
        Function0<Unit> r1 = this.e;
        if (r1 == null) goto L15;
        r1.invoke();
    L15:
        Surface r2 = new Surface(r4);
        MediaPlayer r5 = new MediaPlayer();
        this.c = r2;
        this.f6906b = r5;
        this.d = false;
        a(r5);
        a(r5, r2, r0);
    }

    private final void a(MediaPlayer r2) {
        r2.setOnPreparedListener(new $$Lambda$AvatarTextureVideoView$iYcxJsJWAw4aUf4PnDPDrlZpuA(this));
        r2.setOnInfoListener(new $$Lambda$AvatarTextureVideoView$Tv4f3pcQy6EeUKkpZPuCiCv6yLc(this));
        r2.setOnErrorListener(new $$Lambda$AvatarTextureVideoView$d6mdjWaElLD3T8mEXz113rjjLX8(this));
    }

    private final void a(MediaPlayer r2, Surface r3, String r4) {
        r2.setSurface(r3);     // Catch: SecurityException -> L5 IllegalStateException -> L7 IllegalArgumentException -> L9 IOException -> L11
        r2.setDataSource(r4);     // Catch: SecurityException -> L5 IllegalStateException -> L7 IllegalArgumentException -> L9 IOException -> L11
        r2.setLooping(true);     // Catch: SecurityException -> L5 IllegalStateException -> L7 IllegalArgumentException -> L9 IOException -> L11
        r2.setVolume(0.0f, 0.0f);     // Catch: SecurityException -> L5 IllegalStateException -> L7 IllegalArgumentException -> L9 IOException -> L11
        r2.prepareAsync();     // Catch: SecurityException -> L5 IllegalStateException -> L7 IllegalArgumentException -> L9 IOException -> L11
    L17:
        return;
    L11:
        e = move-exception;
        Exception r5 = (Exception) ZeusTransformUtils.preCheckCast(e, Exception.class, "com.obric.memorydata.plugin");
        String r6 = LBSLightLocationTraceLogger.PREPARE;
    L13:
        a(r6, r5);
        return;
    L9:
        e = move-exception;
        r5 = (Exception) ZeusTransformUtils.preCheckCast(e, Exception.class, "com.obric.memorydata.plugin");
        r6 = "data source";
    L7:
        e = move-exception;
        r5 = (Exception) ZeusTransformUtils.preCheckCast(e, Exception.class, "com.obric.memorydata.plugin");
        r6 = "prepare state";
    L5:
        e = move-exception;
        r5 = (Exception) ZeusTransformUtils.preCheckCast(e, Exception.class, "com.obric.memorydata.plugin");
        r6 = "data source access";
        goto L13
    }

    private static final void a(AvatarTextureVideoView r2, MediaPlayer r3) {
        if (r2.f6906b == r3) goto L10;
        return;
    L10:
        r3.start();     // Catch: IllegalStateException -> L7
        return;
    L7:
        e = move-exception;
        r2.a(CommonConsts.APM_INNER_EVENT_COST_START, (Exception) ZeusTransformUtils.preCheckCast(e, Exception.class, "com.obric.memorydata.plugin"));
    }

    private final void a(String r4, Exception r5) {
        d();
        Function1<? super a, Unit> r3 = this.g;
        if (r3 == null) goto L6;
        r3.invoke(new a(r4, 1, 0, r5));
        return;
    }

    private static final boolean a(AvatarTextureVideoView r0, MediaPlayer r1, int r2, int r3) {
        if (r0.f6906b == r1) goto L5;
        return false;
    L5:
        if (r2 == 3) goto L7;
        return false;
    L7:
        if (r0.d == true) goto L16;
        r0.d = true;
        Function0<Unit> r4 = r0.f;
        if (r4 == null) goto L12;
        r4.invoke();
    L12:
        return true;
    L16:
        return false;
    }

    private final void b() {
        d();
        if (isAvailable() == false) goto L8;
        SurfaceTexture r0 = getSurfaceTexture();
        if (r0 == null) goto L9;
        a(r0);
        return;
    L9:
        return;
    }

    private static final boolean b(AvatarTextureVideoView r3, MediaPlayer r4, int r5, int r6) {
        if (r3.f6906b == r4) goto L5;
        return true;
    L5:
        r3.d();
        Function1<? super a, Unit> r7 = r3.g;
        if (r7 == null) goto L8;
        r7.invoke(new a("playback", r5, r6, null));
    L8:
        return true;
    }

    private final void c() {
        Function0<Unit> r0 = this.e;
        if (r0 == null) goto L5;
        r0.invoke();
    L5:
        Function1<? super a, Unit> r5 = this.g;
        if (r5 == null) goto L9;
        r5.invoke(new a("hardware acceleration unavailable", NetError.ERR_BT_STREAM_FIN_RECEIVED, 0, null));
        return;
    }

    private final void d() {
        MediaPlayer r0 = this.f6906b;
        this.f6906b = null;
        if (r0 == null) goto L5;
        r0.setOnPreparedListener(null);
    L5:
        if (r0 == null) goto L7;
        r0.setOnInfoListener(null);
    L7:
        if (r0 == null) goto L9;
        r0.setOnErrorListener(null);
    L9:
        if (r0 == null) goto L11;
        r0.release();
    L11:
        Surface r1 = this.c;
        if (r1 == null) goto L14;
        r1.release();
    L14:
        this.c = null;
        this.d = false;
    }

    public static /* synthetic */ boolean lambda$Tv4f3pcQy6EeUKkpZPuCiCv6yLc(AvatarTextureVideoView r0, MediaPlayer r1, int r2, int r3) {
        return a(r0, r1, r2, r3);
    }

    public static /* synthetic */ boolean lambda$d6mdjWaElLD3T8mEXz113rjjLX8(AvatarTextureVideoView r0, MediaPlayer r1, int r2, int r3) {
        return b(r0, r1, r2, r3);
    }

    /* JADX INFO: renamed from: lambda$iYc-xJsJWAw4aUf4PnDPDrlZpuA, reason: not valid java name */
    public static /* synthetic */ void m358lambda$iYcxJsJWAw4aUf4PnDPDrlZpuA(AvatarTextureVideoView r0, MediaPlayer r1) {
        a(r0, r1);
    }

    public final void a() {
        this.f6905a = null;
        d();
    }

    public final boolean getHasVideoSource() {
        if (this.f6905a == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // android.view.TextureView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (isAvailable() == false) goto L8;
        SurfaceTexture r0 = getSurfaceTexture();
        if (r0 == null) goto L9;
        a(r0);
        return;
    L9:
        return;
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        d();
        super.onDetachedFromWindow();
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture r1, int r2, int r3) {
        Intrinsics.checkNotNullParameter(r1, "surfaceTexture");
        a(r1);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture r2) {
        Intrinsics.checkNotNullParameter(r2, "surfaceTexture");
        d();
        if (this.f6905a == null) goto L9;
        Function0<Unit> r1 = this.e;
        if (r1 == null) goto L10;
        r1.invoke();
        return true;
    L10:
        return true;
    L9:
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture r1, int r2, int r3) {
        Intrinsics.checkNotNullParameter(r1, "surfaceTexture");
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture r1) {
        Intrinsics.checkNotNullParameter(r1, "surfaceTexture");
    }

    public final void setOnFirstFrameListener(Function0<Unit> r3) {
        this.f = (Function0) ZeusTransformUtils.wrapperContextForParams(r3, Function0.class, "com.obric.memorydata.plugin");
    }

    public final void setOnPlaybackErrorListener(Function1<? super a, Unit> r3) {
        this.g = (Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin");
    }

    public final void setOnPlaybackPendingListener(Function0<Unit> r3) {
        this.e = (Function0) ZeusTransformUtils.wrapperContextForParams(r3, Function0.class, "com.obric.memorydata.plugin");
    }

    public final void setVideoPath(String r2) {
        Intrinsics.checkNotNullParameter(r2, "path");
        this.f6905a = r2;
        b();
    }
}
