package com.larus.community.impl.detail.video;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.viewbinding.ViewBindings;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.video.VideoPlayView;
import com.larus.common_ui.video.progress.PlayerProgressView;
import com.larus.community.impl.databinding.LarusCommunityCreationDetailVideoLayoutBinding;
import com.larus.platform.api.IVideoController;
import com.larus.platform.api.creation.AuthorInfo;
import com.larus.platform.api.creation.UserCreation;
import com.larus.platform.api.creation.UserCreationContent;
import com.larus.platform.api.creation.UserCreationTrackParams;
import com.larus.platform.api.creation.VideoContentFromChat;
import com.larus.platform.api.creation.VideoUserContent;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.q3;
import com.larus.platform.service.z2;
import com.larus.uaigc.nowatermark.CreationNoWatermarkManager;
import com.larus.utils.logger.FLogger;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import tx9.a4;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\u008d\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001H\u0018\u0000 a2\u00020\u0001:\u0001aB\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u00103\u001a\u00020\n2\u0006\u00104\u001a\u0002052\b\b\u0002\u00106\u001a\u00020\u0018H\u0002J\u000e\u00107\u001a\u00020\n2\u0006\u00108\u001a\u00020\u001eJ\f\u00109\u001a\u00020\u001c*\u00020\u001cH\u0002J\u001a\u0010:\u001a\u00020\n2\b\u0010;\u001a\u0004\u0018\u00010\"2\b\u0010\u001f\u001a\u0004\u0018\u00010 J\b\u0010<\u001a\u00020\nH\u0002J\b\u0010=\u001a\u00020\nH\u0002J\u000e\u0010B\u001a\u00020\n2\u0006\u0010C\u001a\u00020\u0018J6\u0010D\u001a\u00020\n2\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tJ\u0012\u0010E\u001a\u00020\u00182\b\u00104\u001a\u0004\u0018\u00010FH\u0016J\u0006\u0010L\u001a\u00020\nJ\u0006\u0010M\u001a\u00020\nJ\u0006\u0010N\u001a\u00020\nJ\u0006\u0010O\u001a\u00020\nJ\u0006\u0010P\u001a\u00020\nJ\u0010\u0010L\u001a\u00020\n2\b\b\u0002\u0010Q\u001a\u00020\u0018J\b\u0010R\u001a\u00020\nH\u0014J\b\u0010S\u001a\u00020\nH\u0014J\u0016\u0010T\u001a\u00020\n2\u0006\u0010U\u001a\u00020A2\u0006\u0010V\u001a\u00020\u0018J\u001f\u0010W\u001a\u00020\n2\u0017\u0010X\u001a\u0013\u0012\u0004\u0012\u00020Z\u0012\u0004\u0012\u00020\n0Y¢\u0006\u0002\b[J\b\u0010\\\u001a\u00020\nH\u0002J\u0006\u0010]\u001a\u00020\u0018J\n\u0010^\u001a\u0004\u0018\u00010\u001aH\u0002J\n\u0010_\u001a\u0004\u0018\u00010\u001aH\u0002J\b\u0010`\u001a\u00020\nH\u0002R\"\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\"\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000eR\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020%X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020(X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020(X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020(X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010.\u001a\u00020\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b1\u00102\u001a\u0004\b/\u00100R\u000e\u0010>\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020%X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u00020AX\u0082D¢\u0006\u0002\n\u0000R\u001b\u0010G\u001a\u00020H8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bK\u00102\u001a\u0004\bI\u0010J¨\u0006b"}, d2 = {"Lcom/larus/community/impl/detail/video/CreationDetailVideoView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "onImageLongPressListener", "Lkotlin/Function0;", "", "getOnImageLongPressListener", "()Lkotlin/jvm/functions/Function0;", "setOnImageLongPressListener", "(Lkotlin/jvm/functions/Function0;)V", "onImageScaleListener", "getOnImageScaleListener", "setOnImageScaleListener", "onImageDoubleTapListener", "getOnImageDoubleTapListener", "setOnImageDoubleTapListener", "binding", "Lcom/larus/community/impl/databinding/LarusCommunityCreationDetailVideoLayoutBinding;", "videoEngineLeakFixEnabled", "", "videoPlayerEngine", "Lcom/larus/platform/api/IVideoController;", "currentVideoPlayData", "Lcom/larus/platform/model/video/VideoPlayData;", "currentUserCreation", "Lcom/larus/platform/api/creation/UserCreation;", "trackParams", "Lcom/larus/platform/api/creation/CreationFeedTrackParams;", "reportHelper", "Lcom/larus/community/impl/tracker/CreationFeedVideoReportHelper;", "playSessionActive", "segmentStartTs", "", "accumulatedDuration", "playCompleteCount", "", "hasReportedThisSession", "savedPlaybackTimeMs", "wasPlayingBeforeDetach", "lastKnownPlaybackTimeMs", "lastKnownPlaying", "videoFocusFixEnabled", "getVideoFocusFixEnabled", "()Z", "videoFocusFixEnabled$delegate", "Lkotlin/Lazy;", "logPlayback", "event", "", "debugOnly", "bindVideoData", "userCreation", "withVideoModelCoverSize", "setVideoReportParams", "helper", "reportAiVideoPlay", "reportPlayTimeIfNeeded", "draging", "latestDragSeekTime", "maxRatio", "", "adjustContainerSize", "hasExtraList", "bindAction", "dispatchTouchEvent", "Landroid/view/MotionEvent;", "gestureDetector", "com/larus/community/impl/detail/video/CreationDetailVideoView$gestureDetector$2$1", "getGestureDetector", "()Lcom/larus/community/impl/detail/video/CreationDetailVideoView$gestureDetector$2$1;", "gestureDetector$delegate", "onPause", "onResume", "onResumeAfterPause", "onDestroy", "releaseVideoPlayerForReuse", "byUser", "onAttachedToWindow", "onDetachedFromWindow", "updateProgress", "percent", "smooth", "configProgressView", "config", "Lkotlin/Function1;", "Lcom/larus/common_ui/video/progress/PlayerProgressView;", "Lkotlin/ExtensionFunctionType;", "initSeekbar", "isValid", "createVideoPlayerEngine", "getOrCreateVideoPlayerEngine", "releaseVideoPlayer", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CreationDetailVideoView extends ConstraintLayout {
    public static final /* synthetic */ int y = 0;
    public Function0<Unit> a;
    public Function0<Unit> b;
    public Function0<Unit> c;
    public final LarusCommunityCreationDetailVideoLayoutBinding d;
    public final boolean e;
    public IVideoController f;
    public nr9.g g;
    public UserCreation h;
    public zp9.g i;
    public p29.b j;
    public boolean k;
    public long l;
    public long m;
    public int n;
    public boolean o;
    public int p;
    public boolean q;
    public int r;
    public boolean s;
    public final Lazy t;
    public boolean u;
    public long v;
    public final float w;
    public final Lazy x;

    public static final class a {
    }

    public static final class b extends GestureDetector {
        public b(Context r1, c r2) {
            super(r1, r2);
        }
    }

    public static final class c extends GestureDetector.SimpleOnGestureListener {
        public final /* synthetic */ CreationDetailVideoView a;

        public c(CreationDetailVideoView r1) {
            this.a = r1;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public final boolean onDoubleTap(MotionEvent r2) {
            Intrinsics.checkNotNullParameter(r2, "e");
            Function0<Unit> r3 = this.a.getOnImageDoubleTapListener();
            if (r3 == null) goto L7;
            r3.invoke();
            return true;
        L7:
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final void onLongPress(MotionEvent r2) {
            Intrinsics.checkNotNullParameter(r2, "e");
            super.onLongPress(r2);
            Function0<Unit> r3 = this.a.getOnImageLongPressListener();
            if (r3 == null) goto L6;
            r3.invoke();
            return;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public final boolean onSingleTapConfirmed(MotionEvent r3) {
            Intrinsics.checkNotNullParameter(r3, "e");
            CreationDetailVideoView r0 = this.a;
            int r1 = CreationDetailVideoView.y;
            r0.b6();
            this.a.d.d.x();
            return super.onSingleTapConfirmed(r3);
        }
    }

    static {
    }

    public static IVideoController U5() {
        com.larus.video.impl.sdk.o r0 = q3.b("ugc_video", null, 6);
        if (r0 == null) goto L6;
        com.larus.video.impl.sdk.o r1 = r0;
        r1.setSubTag("immersive_preview");
        r1.I(true);
        r1.y(z2.a.j1(), "CreationDetailVideoView");
        return r0;
    L6:
        return null;
    }

    private final b getGestureDetector() {
        return (b) this.x.getValue();
    }

    private final IVideoController getOrCreateVideoPlayerEngine() {
        IVideoController r0 = this.f;
        if (r0 != null) goto L5;
    L10:
        IVideoController r1 = U5();
        this.f = r1;
        return r1;
    L5:
        if (r0.isReleased() == false) goto L8;
        r0 = null;
    L8:
        if (r0 == null) goto L10;
        return r0;
    }

    private final boolean getVideoFocusFixEnabled() {
        return ((Boolean) this.t.getValue()).booleanValue();
    }

    public final void Z5() {
        IVideoController r0 = this.f;
        if (r0 != null) goto L5;
        return;
    L5:
        this.f = null;
        this.d.d.D();     // Catch: Throwable -> L11
        if (r0.isReleased() == true) goto L18;
        r0.release();
        return;
    L18:
        return;
    L11:
        th = move-exception;
        if (r0.isReleased() == true) goto L15;
        r0.release();
    L15:
        throw th;
    }

    public final void b6() {
        if (this.k == true) goto L5;
        return;
    L5:
        if (this.o == true) goto L70;
        long r1 = this.m + (SystemClock.elapsedRealtime() - this.l);
        this.m = r1;
        UserCreation r3 = this.h;
        if (r3 != null) goto L10;
        return;
    L10:
        nr9.g r4 = this.g;
        zp9.g r5 = this.i;
        p29.b r6 = this.j;
        if (r6 == null) goto L66;
        if (r4 == null) goto L14;
        String r8 = r4.a;
    L15:
        if (r5 == null) goto L18;
        String r9 = r5.c;
        if (r9 == null) goto L18;
    L22:
        Boolean r10 = Boolean.TRUE;
        if (r5 == null) goto L25;
        String r11 = r5.h;
    L26:
        Long r2 = Long.valueOf(r1);
        if (this.n <= 0) goto L29;
        boolean r7 = true;
    L30:
        Boolean r12 = Boolean.valueOf(r7);
        if (r5 == null) goto L33;
        String r13 = r5.a;
    L34:
        UserCreationContent r14 = r3.e;
        if (r14 == null) goto L39;
        VideoContentFromChat r15 = r14.f;
        if (r15 == null) goto L39;
        String r16 = r15.a;
    L40:
        if (r4 == null) goto L42;
        String r17 = r4.b;
    L43:
        Boolean r18 = Boolean.valueOf(a4.a(r17));
        Boolean r110 = Boolean.valueOf(a4.b(AppHost.a.getApplication(), Boolean.valueOf(this.d.d.s)));
        UserCreationTrackParams r20 = r3.n;
        if (r20 == null) goto L46;
        String r111 = r20.d;
    L47:
        if (r20 == null) goto L49;
        String r21 = r20.e;
    L50:
        if (r5 == null) goto L52;
        String r22 = r5.i;
    L53:
        if (r5 == null) goto L58;
        String r23 = r5.j;
        if (r23 == null) goto L58;
        String r24 = r23;
    L61:
        String r25 = zp9.d.b(r3);
        String r26 = zp9.d.c(r3);
        String r27 = zp9.d.d(r3);
        String r112 = r3.a;
        String r28 = r3.i;
        UserCreationTrackParams r30 = r3.n;
        if (r30 == null) goto L64;
        String r210 = r30.a;
    L65:
        String r113 = r16;
        boolean r31 = true;
        p29.b.b(r6, r8, r9, r10, r11, r2, r12, r13, r113, r18, r110, r111, r21, r22, r24, r25, r26, r27, r112, r28, r210);
    L67:
        this.o = r31;
        this.k = false;
        return;
    L64:
        r210 = null;
    L58:
        if (r5 == null) goto L60;
        r24 = r5.b;
        goto L61
    L60:
        r24 = null;
        goto L61
    L52:
        r22 = null;
        goto L53
    L49:
        r21 = null;
        goto L50
    L46:
        r111 = null;
        goto L47
    L42:
        r17 = null;
    L39:
        r16 = null;
        goto L40
    L33:
        r13 = null;
        goto L34
    L29:
        r7 = false;
        goto L30
    L25:
        r11 = null;
    L18:
        UserCreationTrackParams r32 = r3.n;
        if (r32 == null) goto L21;
        r9 = r32.g;
        goto L22
    L21:
        r9 = null;
        goto L22
    L14:
        r8 = null;
        goto L15
    L66:
        r31 = true;
        goto L67
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDetachedFromWindow() {
        V5("detach", true);
        if (getVideoFocusFixEnabled() == true) goto L7;
        super/*android.view.ViewGroup*/.onDetachedFromWindow();
        return;
    L7:
        if (this.g == null) goto L23;
        int r0 = (int) this.d.d.getCurrentPlaybackTime();
        boolean r2 = this.d.d.r();
        if (r0 <= 0) goto L11;
        int r3 = r0;
    L12:
        if (r2 == false) goto L14;
    L17:
        boolean r4 = true;
    L19:
        if (r4 == false) goto L22;
        if (r3 <= 0) goto L22;
        this.q = true;
        this.p = r3;
        FLogger.a.i("CreationDetailVideoView", "[onDetachedFromWindow] save state, playing=true, pos=" + r3 + "ms (livePos=" + r0 + ", cachedPos=" + this.r + ", livePlaying=" + r2 + ", cachedPlaying=" + this.s + ')');
    L22:
        FLogger.a.i("CreationDetailVideoView", "[onDetachedFromWindow] no save, playing=" + r4 + ", pos=" + r3 + "ms");
        goto L23
    L14:
        if (this.s == true) goto L17;
        r4 = false;
        goto L19
    L11:
        r3 = this.r;
    L23:
        super/*android.view.ViewGroup*/.onDetachedFromWindow();
    }

    public final void onPause() {
        V5("page_pause", false);
        b6();
        if (getVideoFocusFixEnabled() == false) goto L5;
        this.s = false;
    L5:
        VideoPlayView.z(this.d.d, 0, 3);
    }

    public final void onResume() {
        V5("page_resume", false);
        if (getVideoFocusFixEnabled() == true) goto L6;
        this.d.d.M();
        return;
    L6:
        int r0 = this.p;
        if (this.q == false) goto L10;
        if (r0 <= 0) goto L10;
        boolean r2 = true;
    L12:
        if (r2 == false) goto L22;
        FLogger.a.i("CreationDetailVideoView", "[onResume] resume from saved position " + r0 + "ms");
        IVideoController r3 = this.f;
        if (r3 == null) goto L16;
        r3.setStartTime(r0);
    L16:
        nr9.g r1 = this.g;
        if (r1 == null) goto L19;
        VideoPlayView.e(this.d.d, this.f, r1.b, r1.h, null, null, null, 56);
    L19:
        this.q = false;
        this.p = 0;
        this.d.d.M();
        return;
    L22:
        if (this.d.d.r() == false) goto L25;
        FLogger.a.i("CreationDetailVideoView", "[onResume] already playing, skip start()");
        return;
    L25:
        this.d.d.M();
        return;
    L10:
        r2 = false;
        goto L12
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onAttachedToWindow() {
        super/*android.view.ViewGroup*/.onAttachedToWindow();
        V5("attach", true);
        if (getVideoFocusFixEnabled() == true) goto L6;
        return;
    L6:
        if (this.q == true) goto L8;
        return;
    L8:
        if (this.g == null) goto L12;
        FLogger.a.i("CreationDetailVideoView", "[onAttachedToWindow] trigger resume, saved=" + this.p + "ms");
        onResume();
        return;
    }

    public final Function0<Unit> getOnImageDoubleTapListener() {
        return this.c;
    }

    public final Function0<Unit> getOnImageLongPressListener() {
        return this.a;
    }

    public final Function0<Unit> getOnImageScaleListener() {
        return this.b;
    }

    public CreationDetailVideoView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    /* JADX WARN: Type inference failed for: r1v3, types: [com.larus.community.impl.detail.video.n, java.lang.Object] */
    public final void T5(UserCreation r110) {
        UserCreation r1 = r110;
        Intrinsics.checkNotNullParameter(r1, "userCreation");
        AuthorInfo r2 = r1.g;
        Bitmap r3 = null;
        if (r2 == null) goto L5;
        String r4 = r2.b;
    L7:
        if (Intrinsics.areEqual(r4, AccountService.a.getUserId()) == true) goto L9;
    L11:
        boolean r5 = false;
    L12:
        if (r5 == false) goto L17;
        UserCreation r6 = CreationNoWatermarkManager.a.f0(r1, false);
        if (r6 == null) goto L17;
        r1 = r6;
    L17:
        this.h = r1;
        switch(r1.b) {
            case 6: goto L20;
            case 7: goto L20;
            case 8: goto L20;
            case 9: goto L20;
            case 10: goto L20;
            case 11: goto L20;
            case 12: goto L20;
            default: goto L39;
        };
    L20:
        UserCreationContent r7 = r1.e;
        if (r7 == null) goto L23;
        VideoUserContent r8 = r7.e;
    L24:
        if (r5 == false) goto L27;
        if (r8 == null) goto L30;
        nr9.g r9 = os8.c.c(r8);
    L29:
        nr9.g r10 = r9;
    L31:
        if (r10 == null) goto L39;
        CreationNoWatermarkManager r11 = CreationNoWatermarkManager.a;
        String r12 = r10.b;
        r11.getClass();
        CreationNoWatermarkManager.h r13 = CreationNoWatermarkManager.J(r12);
        if (r13 == null) goto L40;
        nr9.f r14 = r10.g;
        if (r14 == null) goto L40;
        r10 = nr9.g.a(r10, null, null, null, null, null, null, nr9.f.a(r14, null, null, Integer.valueOf(r13.b), Integer.valueOf(r13.a), null, 39), 959);
    L40:
        this.g = r10;
        V5("bind", false);
        ?? r15 = new n(this);
        Intrinsics.checkNotNullParameter(r15, "config");
        r15.invoke(this.d.c);
        nr9.g r16 = this.g;
        if (r16 != null) goto L43;
        return;
    L43:
        if (this.e == false) goto L45;
        IVideoController r17 = getOrCreateVideoPlayerEngine();
    L46:
        VideoPlayView.e(this.d.d, r17, r16.b, r16.h, null, null, null, 56);
        VideoPlayView r18 = this.d.d;
        nr9.f r20 = r16.g;
        if (r20 == null) goto L49;
        String r21 = r20.a;
    L50:
        if (r20 == null) goto L52;
        String r22 = r20.b;
    L53:
        if (r20 == null) goto L55;
        String r23 = r20.c;
    L56:
        if (r20 == null) goto L58;
        Integer r24 = r20.d;
    L59:
        if (r20 == null) goto L61;
        Integer r25 = r20.e;
    L62:
        if (r20 == null) goto L64;
        r3 = r20.f;
    L64:
        VideoPlayView.p(r18, r21, r22, r23, r24, r25, r3, null, null, 192);
        final VideoPlayView r26 = this.d.d;
        r26.w(new l(this, r26));
        r26.d = new m(this);
        return;
    L61:
        r25 = null;
        goto L62
    L58:
        r24 = null;
        goto L59
    L55:
        r23 = null;
        goto L56
    L52:
        r22 = null;
        goto L53
    L49:
        r21 = null;
        goto L50
    L45:
        r17 = this.f;
    L30:
        r10 = null;
        goto L31
    L27:
        if (r8 == null) goto L30;
        r9 = os8.c.d(r8);
        goto L29
    L23:
        r8 = null;
    L39:
        r10 = null;
        goto L40
    L9:
        if (CreationNoWatermarkManager.a.D() == false) goto L11;
        r5 = true;
        goto L12
    L5:
        r4 = null;
        goto L7
    }

    public final void Y5(boolean r3) {
        V5("pause byUser=false", false);
        b6();
        if (getVideoFocusFixEnabled() == false) goto L5;
        this.s = false;
    L5:
        VideoPlayView.z(this.d.d, 0, 2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean dispatchTouchEvent(MotionEvent r3) {
        if (r3 != null) goto L5;
        return false;
    L5:
        r3.getAction();
        r3.getActionMasked();
        boolean r0 = super/*android.view.ViewGroup*/.dispatchTouchEvent(r3);
        getGestureDetector().onTouchEvent(r3);
        return r0;
    }

    public final void setOnImageDoubleTapListener(Function0<Unit> r1) {
        this.c = r1;
    }

    public final void setOnImageLongPressListener(Function0<Unit> r1) {
        this.a = r1;
    }

    public final void setOnImageScaleListener(Function0<Unit> r1) {
        this.b = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CreationDetailVideoView(final Context r4, AttributeSet r5) {
        Intrinsics.checkNotNullParameter(r4, "context");
        super(r4, r5);
        LayoutInflater.from(r4).inflate(2131561935, this);
        int r6 = 2131367728;
        ConstraintLayout r0 = ViewBindings.findChildViewById(this, 2131367728);
        if (r0 == null) goto L15;
        r6 = 2131382471;
        PlayerProgressView r1 = (PlayerProgressView) ViewBindings.findChildViewById(this, 2131382471);
        if (r1 == null) goto L15;
        r6 = 2131392404;
        VideoPlayView r2 = (VideoPlayView) ViewBindings.findChildViewById(this, 2131392404);
        if (r2 == null) goto L15;
        this.d = new LarusCommunityCreationDetailVideoLayoutBinding(this, r0, r1, r2);
        boolean r7 = z2.a.creationDetailVideoEngineLeakFix();
        this.e = r7;
        if (r7 == false) goto L11;
        IVideoController r8 = null;
    L12:
        this.f = r8;
        this.t = LazyKt.lazy(new j());
        r2.setParentSlideDirection(1);
        r2.setBackgroundColor(ContextCompat.getColor(r4, 2131102529));
        r2.setEnabled(false);
        r2.setBanInnerDismiss(true);
        r1.setSupportTouch(false);
        setClickable(true);
        this.w = 0.74f;
        this.x = LazyKt.lazy(new k(this, r4));
        return;
    L11:
        r8 = U5();
    L15:
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(r6)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static String R5(String r2, CreationDetailVideoView r3) {
        StringBuilder r0 = new StringBuilder("[playback] ");
        r0.append(r2);
        r0.append(" owner=");
        r0.append(r3.hashCode());
        r0.append(" view=");
        r0.append(r3.d.d.hashCode());
        r0.append(" controller=");
        IVideoController r4 = r3.f;
        String r1 = null;
        if (r4 == null) goto L5;
        Integer r5 = Integer.valueOf(r4.hashCode());
    L6:
        r0.append(r5);
        r0.append(" creation=");
        UserCreation r6 = r3.h;
        if (r6 == null) goto L9;
        String r7 = r6.a;
    L10:
        r0.append(r7);
        r0.append(" vid=");
        nr9.g r8 = r3.g;
        if (r8 == null) goto L13;
        r1 = r8.a;
    L13:
        r0.append(r1);
        r0.append(" attached=");
        r0.append(r3.isAttachedToWindow());
        r0.append(" playing=");
        r0.append(r3.d.d.r());
        r0.append(" focusFix=");
        r0.append(r3.getVideoFocusFixEnabled());
        r0.append(" engineFix=");
        r0.append(r3.e);
        return r0.toString();
    L9:
        r7 = null;
        goto L10
    L5:
        r5 = null;
        goto L6
    }

    public final void V5(final String r2, boolean r3) {
        Function0 r0 = new i(r2, this);
        if (r3 == false) goto L5;
        FLogger.a.g("CreationDetailVideoView", r0);
        return;
    L5:
        FLogger.a.i("CreationDetailVideoView", r0);
    }

    public static Unit S5(CreationDetailVideoView r8, VideoPlayView r9, int r10) {
        if (r8.getVideoFocusFixEnabled() == false) goto L18;
        int r0 = (int) r9.getCurrentPlaybackTime();
        if (r0 <= 0) goto L7;
        r8.r = r0;
    L16:
        r8.s = r9.r();
        goto L18
    L7:
        int r1 = (int) r9.getDuration();
        if (r1 <= 0) goto L16;
        if (r10 >= 0) goto L11;
    L13:
        boolean r2 = false;
    L14:
        if (r2 == false) goto L16;
        r8.r = (r1 * r10) / 100;
        goto L16
    L11:
        if (r10 >= 101) goto L13;
        r2 = true;
    L18:
        if (r8.u == false) goto L21;
        return Unit.INSTANCE;
    L21:
        if (r8.v > (System.currentTimeMillis() - ((long) 500))) goto L26;
        r8.d.c.J1(r10, false);
        return Unit.INSTANCE;
    L26:
        return Unit.INSTANCE;
    }
}
