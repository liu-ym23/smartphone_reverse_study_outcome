package com.obric.common.oea.style.scene.alpha.alphaplayer.controller;

import ai.g0;
import android.content.Context;
import android.media.MediaMetadataRetriever;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.Surface;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import com.obric.common.oea.style.scene.alpha.alphaplayer.model.AlphaVideoViewType;
import com.obric.common.oea.style.scene.alpha.alphaplayer.player.PlayerState;
import com.obric.common.oea.style.scene.alpha.alphaplayer.widget.AlphaVideoGLSurfaceView;
import com.obric.common.oea.style.scene.alpha.alphaplayer.widget.AlphaVideoGLTextureView;
import com.obric.oui.orecyclerview.widget.f0;
import g8.g;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import mn.i;
import up.a;
import up.b;
import zm.c;
import zp.k;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\b\u0010\u0006J\u000f\u0010\t\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\t\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/obric/common/oea/style/scene/alpha/alphaplayer/controller/PlayerController;", "Lup/a;", "Landroidx/lifecycle/LifecycleObserver;", "Landroid/os/Handler$Callback;", "", "onPause", "()V", "onResume", "onStop", "onDestroy", "style_standardRelease"}, k = 1, mv = {1, 4, 3})
public class PlayerController implements a, LifecycleObserver, Handler.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LifecycleOwner f11343a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public g0 f11344b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f11345c;
    public boolean d;
    public PlayerState e;
    public c f;
    public Handler g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Handler f11346h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final HandlerThread f11347i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final i f11348j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final k6.a f11349k;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v6, types: [android.view.View, zp.k] */
    /* JADX WARN: Type inference failed for: r5v9 */
    public PlayerController(i4.a r5) {
        Intrinsics.checkNotNullParameter(r5, "configuration");
        this.e = PlayerState.NOT_PREPARED;
        this.f11346h = new Handler(Looper.getMainLooper());
        this.f11348j = new i(this);
        this.f11349k = new k6.a(this);
        Context r10 = (Context) r5.f17503c;
        LifecycleOwner r11 = (LifecycleOwner) r5.d;
        this.f11343a = r11;
        AlphaVideoViewType r12 = (AlphaVideoViewType) r5.f17502b;
        this.f11344b = new g0(3);
        r11.getLifecycle().addObserver(this);
        HandlerThread r13 = new HandlerThread("alpha-play-thread", 10);
        this.f11347i = r13;
        Intrinsics.checkNotNull(r13);
        r13.start();
        HandlerThread r14 = this.f11347i;
        Intrinsics.checkNotNull(r14);
        this.g = new Handler(r14.getLooper(), this);
        int r15 = b.f22420a[r12.ordinal()];
        if (r15 != 1) goto L5;
        ?? r16 = new AlphaVideoGLSurfaceView(r10, null);
    L10:
        this.f11345c = r16;
        r16.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        r16.setPlayerController(this);
        r16.setVideoRenderer(new xp.c(r16));
        f(c(1, null));
        return;
    L5:
        if (r15 != 2) goto L8;
        r16 = new AlphaVideoGLTextureView(r10, null);
        goto L10
    L8:
        throw new NoWhenBranchMatchedException();
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [android.view.View, zp.k] */
    public static final /* synthetic */ k a(PlayerController r5) {
        ?? r10 = r5.f11345c;
        if (r10 != 0) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("alphaVideoView");
    L5:
        return r10;
    }

    public static Message c(int r5, Surface r10) {
        Message r11 = Message.obtain();
        r11.what = r5;
        r11.obj = r10;
        return r11;
    }

    public final void b() {
        this.d = false;
        this.f11346h.post(new up.c(this, 0));
    }

    /* JADX WARN: Type inference failed for: r0v10, types: [android.view.View, zp.k] */
    /* JADX WARN: Type inference failed for: r3v1, types: [android.view.View, zp.k] */
    public final void d() {
        g0 r5 = this.f11344b;
        String r10 = (String) r5.g;
        if (r10 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("dataPath");
    L6:
        if (TextUtils.isEmpty(r10) == true) goto L25;
        MediaMetadataRetriever r11 = (MediaMetadataRetriever) r5.f;
        String r12 = (String) r5.g;
        if (r12 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("dataPath");
    L10:
        r11.setDataSource(r12);
        String r13 = r11.extractMetadata(18);
        String r14 = r11.extractMetadata(19);
        if (TextUtils.isEmpty(r13) == true) goto L23;
        if (TextUtils.isEmpty(r14) == true) goto L23;
        String r15 = r11.extractMetadata(18);
        Intrinsics.checkNotNull(r15);
        int r16 = Integer.parseInt(r15);
        String r17 = r11.extractMetadata(19);
        Intrinsics.checkNotNull(r17);
        int r18 = Integer.parseInt(r17);
        f0 r19 = new f0();
        r19.f13809a = r16;
        r19.f13810b = r18;
        ?? r20 = this.f11345c;
        if (r20 != 0) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("alphaVideoView");
    L17:
        r20.b(r16 / 2, r18);
        ?? r21 = this.f11345c;
        if (r21 != 0) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("alphaVideoView");
    L20:
        this.f11346h.post(new com.bytedance.android.anniex.scene.core.i(this, 23, r19, r21.getScaleType()));
        return;
    L23:
        throw new Exception("DefaultSystemPlayer get metadata failure!");
    L25:
        throw new Exception("dataPath is null, please set setDataSource firstly!");
    }

    public final void e() {
        g0 r5 = this.f11344b;
        PlayerState r10 = this.e;
        if (r10 != PlayerState.NOT_PREPARED) goto L5;
    L6:
        r5.getClass();
        i r11 = this.f11348j;
        Intrinsics.checkNotNullParameter(r11, "preparedListener");
        r5.f210b = r11;
        k6.a r12 = this.f11349k;
        Intrinsics.checkNotNullParameter(r12, "errorListener");
        r5.f211c = r12;
        MediaPlayer r13 = (MediaPlayer) r5.e;
        if (r13 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("mediaPlayer");
    L9:
        r13.prepareAsync();
        return;
    L5:
        if (r10 == PlayerState.STOPPED) goto L6;
    }

    public final void f(Message r5) {
        HandlerThread r10 = this.f11347i;
        if (r10 != null) goto L5;
        return;
    L5:
        if (r10.isAlive() == true) goto L7;
        return;
    L7:
        if (r10.isInterrupted() == false) goto L9;
        return;
    L9:
        if (this.g != null) goto L11;
        this.g = new Handler(r10.getLooper(), this);
    L11:
        Handler r11 = this.g;
        Intrinsics.checkNotNull(r11);
        r11.sendMessageDelayed(r5, 0);
    }

    public final void g() {
        PlayerState r5 = this.e;
        int r10 = b.f22421b[r5.ordinal()];
        if (r10 != 1) goto L5;
        MediaPlayer r11 = (MediaPlayer) this.f11344b.e;
        if (r11 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("mediaPlayer");
    L22:
        r11.start();
        this.d = true;
        this.e = PlayerState.STARTED;
        this.f11346h.post(new up.c(this, 1));
        return;
    L5:
        if (r10 != 2) goto L7;
        MediaPlayer r12 = (MediaPlayer) this.f11344b.e;
        if (r12 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("mediaPlayer");
    L18:
        r12.start();
        this.e = PlayerState.STARTED;
        return;
    L7:
        if (r10 != 3) goto L9;
    L24:
        e();     // Catch: Exception -> L13
        return;
    L13:
        e = move-exception;
        e.printStackTrace();
        b();
        return;
    L9:
        if (r10 == 4) goto L24;
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [android.view.View, zp.k] */
    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message r10) {
        int r5 = 12;
        ?? r11 = this.f11345c;
        Intrinsics.checkNotNullParameter(r10, "msg");
        switch(r10.what) {
            case 1: goto L82;
            case 2: goto L65;
            case 3: goto L84;
            case 4: goto L54;
            case 5: goto L51;
            case 6: goto L41;
            case 7: goto L18;
            case 8: goto L9;
            case 9: goto L5;
            default: goto L81;
        };
    L5:
        g0 r12 = this.f11344b;
        MediaPlayer r13 = (MediaPlayer) r12.e;
        if (r13 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mediaPlayer");
    L8:
        r13.reset();
        r12.g = "";
        this.e = PlayerState.NOT_PREPARED;
        this.d = false;
        goto L81
    L9:
        Object r14 = r10.obj;
        if (r14 == null) goto L16;
        Surface r15 = (Surface) r14;
        g0 r16 = this.f11344b;
        r16.getClass();
        Intrinsics.checkNotNullParameter(r15, "surface");
        MediaPlayer r17 = (MediaPlayer) r16.e;
        if (r17 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("mediaPlayer");
    L14:
        r17.setSurface(r15);
        goto L81
    L16:
        throw new NullPointerException("null cannot be cast to non-null type android.view.Surface");
    L41:
        int r18 = b.d[this.e.ordinal()];
        if (r18 != 1) goto L44;
    L46:
        MediaPlayer r19 = (MediaPlayer) this.f11344b.e;
        if (r19 != null) goto L49;
        Intrinsics.throwUninitializedPropertyAccessException("mediaPlayer");
    L49:
        r19.pause();
        this.e = PlayerState.PAUSED;
        goto L81
    L44:
        if (r18 == 2) goto L46;
    L81:
        return true;
    L82:
        this.f11344b.f();     // Catch: Exception -> L72
    L74:
        MediaPlayer r20 = (MediaPlayer) this.f11344b.e;
        if (r20 != null) goto L77;
        Intrinsics.throwUninitializedPropertyAccessException("mediaPlayer");
    L77:
        r20.setScreenOnWhilePlaying(true);
        MediaPlayer r21 = (MediaPlayer) this.f11344b.e;
        if (r21 != null) goto L80;
        Intrinsics.throwUninitializedPropertyAccessException("mediaPlayer");
    L80:
        r21.setLooping(false);
        g0 r22 = this.f11344b;
        g r23 = new g(this, r5);
        r22.getClass();
        Intrinsics.checkNotNullParameter(r23, "firstFrameListener");
        r22.d = r23;
        g0 r24 = this.f11344b;
        jg.k r25 = new jg.k(this, r5);
        r24.getClass();
        Intrinsics.checkNotNullParameter(r25, "completionListener");
        r24.f209a = r25;
    L72:
        e = move-exception;
        g0 r26 = new g0(3);
        this.f11344b = r26;
        r26.f();
        Log.e("PlayerController", "initPlayer failed " + e.getMessage());
        goto L74
    L84:
        d();     // Catch: Exception -> L62
        this.e = PlayerState.PREPARED;     // Catch: Exception -> L62
        g();     // Catch: Exception -> L62
        Unit r27 = Unit.INSTANCE;     // Catch: Exception -> L62
    L62:
        e = move-exception;
        Log.getStackTraceString(e);
        b();
        Unit r28 = Unit.INSTANCE;
        goto L81
    L18:
        if (r11 != 0) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("alphaVideoView");
    L20:
        r11.onPause();
        if (this.e != PlayerState.STARTED) goto L27;
        MediaPlayer r29 = (MediaPlayer) this.f11344b.e;
        if (r29 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("mediaPlayer");
    L25:
        r29.pause();
        this.e = PlayerState.PAUSED;
    L27:
        if (this.e != PlayerState.PAUSED) goto L32;
        MediaPlayer r30 = (MediaPlayer) this.f11344b.e;
        if (r30 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("mediaPlayer");
    L31:
        r30.stop();
        this.e = PlayerState.STOPPED;
    L32:
        g0 r31 = this.f11344b;
        MediaPlayer r32 = (MediaPlayer) r31.e;
        if (r32 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("mediaPlayer");
    L35:
        r32.release();
        r31.g = "";
        if (r11 != 0) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("alphaVideoView");
    L38:
        r11.release();
        this.e = PlayerState.RELEASE;
        HandlerThread r33 = this.f11347i;
        if (r33 == null) goto L81;
        r33.quit();
        r33.interrupt();
        goto L81
    L51:
        if (this.d == false) goto L81;
        g();
        goto L81
    L54:
        if (b.f22422c[this.e.ordinal()] != 1) goto L81;
        MediaPlayer r34 = (MediaPlayer) this.f11344b.e;
        if (r34 != null) goto L59;
        Intrinsics.throwUninitializedPropertyAccessException("mediaPlayer");
    L59:
        r34.pause();
        this.e = PlayerState.PAUSED;
        goto L81
    L65:
        if (r10.obj != null) goto L69;
        throw new NullPointerException("null cannot be cast to non-null type com.obric.common.oea.style.scene.alpha.alphaplayer.model.DataSource");
    L69:
        throw new ClassCastException();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void onDestroy() {
        f(c(7, null));
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public final void onPause() {
        f(c(4, null));
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public final void onResume() {
        f(c(5, null));
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public final void onStop() {
        f(c(6, null));
    }
}
