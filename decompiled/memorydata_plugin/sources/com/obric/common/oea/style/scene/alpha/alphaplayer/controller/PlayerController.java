package com.obric.common.oea.style.scene.alpha.alphaplayer.controller;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.Surface;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.app.NotificationCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.common.wschannel.WsConstants;
import com.obric.common.oea.style.scene.alpha.alphaplayer.model.AlphaVideoViewType;
import com.obric.common.oea.style.scene.alpha.alphaplayer.model.ScaleType;
import com.obric.common.oea.style.scene.alpha.alphaplayer.player.PlayerState;
import com.obric.common.oea.style.scene.alpha.alphaplayer.widget.AlphaVideoGLSurfaceView;
import com.obric.common.oea.style.scene.alpha.alphaplayer.widget.AlphaVideoGLTextureView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000ª\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0002\u0015\u001c\b\u0016\u0018\u0000 \\2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\\B\u001b\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bB'\b\u0016\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u000fJ\u0010\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0016J\u0010\u0010+\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0016J\b\u0010,\u001a\u00020(H\u0002J\u001a\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u0002002\b\u00101\u001a\u0004\u0018\u000102H\u0002J\b\u00103\u001a\u000204H\u0016J\u0006\u00105\u001a\u00020#J\b\u00106\u001a\u000207H\u0016J\u0010\u00108\u001a\u00020\u00132\u0006\u00109\u001a\u00020.H\u0016J\b\u0010:\u001a\u00020(H\u0003J\b\u0010;\u001a\u00020(H\u0002J\u0010\u0010;\u001a\u00020(2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\b\u0010<\u001a\u00020(H\u0002J\b\u0010=\u001a\u00020(H\u0002J\b\u0010>\u001a\u00020(H\u0003J,\u0010?\u001a\u00020(2\u0006\u0010@\u001a\u00020\u00132\b\b\u0002\u0010/\u001a\u0002002\b\b\u0002\u0010A\u001a\u0002002\u0006\u0010B\u001a\u000204H\u0002J\b\u0010C\u001a\u00020(H\u0007J\b\u0010D\u001a\u00020(H\u0007J\b\u0010E\u001a\u00020(H\u0007J\b\u0010F\u001a\u00020(H\u0007J\b\u0010G\u001a\u00020(H\u0003J\b\u0010H\u001a\u00020(H\u0016J\b\u0010I\u001a\u00020(H\u0003J\b\u0010J\u001a\u00020(H\u0016J\b\u0010K\u001a\u00020(H\u0016J\b\u0010L\u001a\u00020(H\u0016J\u0010\u0010M\u001a\u00020(2\u0006\u00109\u001a\u00020.H\u0002J\u0010\u0010N\u001a\u00020(2\u0006\u0010O\u001a\u00020%H\u0003J\u0010\u0010P\u001a\u00020(2\u0006\u0010?\u001a\u00020\u0018H\u0016J\u0010\u0010Q\u001a\u00020(2\u0006\u0010R\u001a\u00020\u001aH\u0016J\u0010\u0010S\u001a\u00020(2\u0006\u0010O\u001a\u00020%H\u0003J\u0010\u0010T\u001a\u00020(2\u0006\u0010U\u001a\u000200H\u0016J\u0010\u0010V\u001a\u00020(2\u0006\u0010O\u001a\u00020%H\u0016J\b\u0010W\u001a\u00020(H\u0003J\b\u0010X\u001a\u00020(H\u0016J\u0010\u0010Y\u001a\u00020(2\u0006\u0010Z\u001a\u00020[H\u0016R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0016R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001dR\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006]"}, d2 = {"Lcom/obric/common/oea/style/scene/alpha/alphaplayer/controller/PlayerController;", "Lcom/obric/common/oea/style/scene/alpha/alphaplayer/controller/IPlayerControllerExt;", "Landroidx/lifecycle/LifecycleObserver;", "Landroid/os/Handler$Callback;", "configuration", "Lcom/obric/common/oea/style/scene/alpha/alphaplayer/model/Configuration;", "mediaPlayer", "Lcom/obric/common/oea/style/scene/alpha/alphaplayer/player/IMediaPlayer;", "(Lcom/obric/common/oea/style/scene/alpha/alphaplayer/model/Configuration;Lcom/obric/common/oea/style/scene/alpha/alphaplayer/player/IMediaPlayer;)V", "context", "Landroid/content/Context;", "owner", "Landroidx/lifecycle/LifecycleOwner;", "alphaVideoViewType", "Lcom/obric/common/oea/style/scene/alpha/alphaplayer/model/AlphaVideoViewType;", "(Landroid/content/Context;Landroidx/lifecycle/LifecycleOwner;Lcom/obric/common/oea/style/scene/alpha/alphaplayer/model/AlphaVideoViewType;Lcom/obric/common/oea/style/scene/alpha/alphaplayer/player/IMediaPlayer;)V", "alphaVideoView", "Lcom/obric/common/oea/style/scene/alpha/alphaplayer/widget/IAlphaVideoView;", "isPlaying", "", "mErrorListener", "com/obric/common/oea/style/scene/alpha/alphaplayer/controller/PlayerController$mErrorListener$1", "Lcom/obric/common/oea/style/scene/alpha/alphaplayer/controller/PlayerController$mErrorListener$1;", "mMonitor", "Lcom/obric/common/oea/style/scene/alpha/alphaplayer/IMonitor;", "mPlayerAction", "Lcom/obric/common/oea/style/scene/alpha/alphaplayer/IPlayerAction;", "mPreparedListener", "com/obric/common/oea/style/scene/alpha/alphaplayer/controller/PlayerController$mPreparedListener$1", "Lcom/obric/common/oea/style/scene/alpha/alphaplayer/controller/PlayerController$mPreparedListener$1;", "mainHandler", "Landroid/os/Handler;", "playThread", "Landroid/os/HandlerThread;", "playerState", "Lcom/obric/common/oea/style/scene/alpha/alphaplayer/player/PlayerState;", "suspendDataSource", "Lcom/obric/common/oea/style/scene/alpha/alphaplayer/model/DataSource;", "workHandler", "attachAlphaView", "", "parentView", "Landroid/view/ViewGroup;", "detachAlphaView", "emitEndSignal", "getMessage", "Landroid/os/Message;", "what", "", "obj", "", "getPlayerType", "", "getStatus", "getView", "Landroid/view/View;", "handleMessage", NotificationCompat.CATEGORY_MESSAGE, "handleSuspendedEvent", CommonConsts.APM_INNER_EVENT_COST_INIT, "initAlphaView", "initMediaPlayer", "initPlayer", CommonConsts.LOG_REPORT_TYPE_DEFAULT, "state", WsConstants.KEY_EXTRA, "errorInfo", "onDestroy", "onPause", "onResume", "onStop", "parseVideoSize", "pause", "prepareAsync", "release", "reset", "resume", "sendMessage", "setDataSource", "dataSource", "setMonitor", "setPlayerAction", "playerAction", "setVideoFromFile", "setVisibility", "visibility", CommonConsts.APM_INNER_EVENT_COST_START, "startPlay", "stop", "surfacePrepared", "surface", "Landroid/view/Surface;", "Companion", "style_standardRelease"}, k = 1, mv = {1, 4, 3})
public class PlayerController implements Handler.Callback, LifecycleObserver, com.obric.common.oea.style.scene.alpha.alphaplayer.controller.b {
    public static final a Companion = null;
    public static final int DESTROY = 7;
    public static final int INIT_MEDIA_PLAYER = 1;
    public static final int PAUSE = 4;
    public static final int RESET = 9;
    public static final int RESUME = 5;
    public static final int SET_DATA_SOURCE = 2;
    public static final int START = 3;
    public static final int STOP = 6;
    public static final int SURFACE_PREPARED = 8;
    public static final String TAG = "PlayerController";
    private com.obric.common.oea.style.scene.alpha.alphaplayer.widget.a alphaVideoView;
    private AlphaVideoViewType alphaVideoViewType;
    private Context context;
    private boolean isPlaying;
    private final e mErrorListener;
    private com.obric.common.oea.style.scene.alpha.alphaplayer.a mMonitor;
    private com.obric.common.oea.style.scene.alpha.alphaplayer.b mPlayerAction;
    private final f mPreparedListener;
    private final Handler mainHandler;
    private com.obric.common.oea.style.scene.alpha.alphaplayer.player.c mediaPlayer;
    private LifecycleOwner owner;
    private HandlerThread playThread;
    private PlayerState playerState;
    private com.obric.common.oea.style.scene.alpha.alphaplayer.model.b suspendDataSource;
    private Handler workHandler;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/obric/common/oea/style/scene/alpha/alphaplayer/controller/PlayerController$Companion;", "", "()V", "DESTROY", "", "INIT_MEDIA_PLAYER", "PAUSE", "RESET", "RESUME", "SET_DATA_SOURCE", "START", "STOP", "SURFACE_PREPARED", "TAG", "", "style_standardRelease"}, k = 1, mv = {1, 4, 3})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 4, 3})
    static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ PlayerController f7777a;

        b(PlayerController r1) {
            this.f7777a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.obric.common.oea.style.scene.alpha.alphaplayer.b r0 = PlayerController.access$getMPlayerAction$p(this.f7777a);
            if (r0 == null) goto L6;
            r0.b();
            return;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/obric/common/oea/style/scene/alpha/alphaplayer/controller/PlayerController$initPlayer$1", "Lcom/obric/common/oea/style/scene/alpha/alphaplayer/player/IMediaPlayer$OnFirstFrameListener;", "onFirstFrame", "", "style_standardRelease"}, k = 1, mv = {1, 4, 3})
    public static final class c implements com.obric.common.oea.style.scene.alpha.alphaplayer.player.c.InterfaceC0380c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ PlayerController f7778a;

        c(PlayerController r1) {
            this.f7778a = r1;
        }

        @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.player.c.InterfaceC0380c
        public void a() {
            PlayerController.access$getAlphaVideoView$p(this.f7778a).c();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/obric/common/oea/style/scene/alpha/alphaplayer/controller/PlayerController$initPlayer$2", "Lcom/obric/common/oea/style/scene/alpha/alphaplayer/player/IMediaPlayer$OnCompletionListener;", "onCompletion", "", "style_standardRelease"}, k = 1, mv = {1, 4, 3})
    public static final class d implements com.obric.common.oea.style.scene.alpha.alphaplayer.player.c.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ PlayerController f7779a;

        d(PlayerController r1) {
            this.f7779a = r1;
        }

        @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.player.c.a
        public void a() {
            PlayerController.access$getAlphaVideoView$p(this.f7779a).d();
            PlayerController.access$setPlayerState$p(this.f7779a, PlayerState.PAUSED);
            PlayerController.monitor$default(this.f7779a, true, 0, 0, "", 6, null);
            PlayerController.access$emitEndSignal(this.f7779a);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"com/obric/common/oea/style/scene/alpha/alphaplayer/controller/PlayerController$mErrorListener$1", "Lcom/obric/common/oea/style/scene/alpha/alphaplayer/player/IMediaPlayer$OnErrorListener;", "onError", "", "what", "", WsConstants.KEY_EXTRA, "desc", "", "style_standardRelease"}, k = 1, mv = {1, 4, 3})
    public static final class e implements com.obric.common.oea.style.scene.alpha.alphaplayer.player.c.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ PlayerController f7780a;

        e(PlayerController r1) {
            this.f7780a = r1;
        }

        @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.player.c.b
        public void a(int r4, int r5, String r6) {
            Intrinsics.checkNotNullParameter(r6, "desc");
            PlayerController.access$monitor(this.f7780a, false, r4, r5, "mediaPlayer error, info: " + r6);
            PlayerController.access$emitEndSignal(this.f7780a);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/obric/common/oea/style/scene/alpha/alphaplayer/controller/PlayerController$mPreparedListener$1", "Lcom/obric/common/oea/style/scene/alpha/alphaplayer/player/IMediaPlayer$OnPreparedListener;", "onPrepared", "", "style_standardRelease"}, k = 1, mv = {1, 4, 3})
    public static final class f implements com.obric.common.oea.style.scene.alpha.alphaplayer.player.c.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ PlayerController f7781a;

        f(PlayerController r1) {
            this.f7781a = r1;
        }

        @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.player.c.d
        public void a() {
            PlayerController r2 = this.f7781a;
            PlayerController.access$sendMessage(r2, PlayerController.access$getMessage(r2, 3, null));
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 4, 3})
    static final class g implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ PlayerController f7782a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.obric.common.oea.style.scene.alpha.alphaplayer.model.c f7783b;
        final /* synthetic */ ScaleType c;

        g(PlayerController r1, com.obric.common.oea.style.scene.alpha.alphaplayer.model.c r2, ScaleType r3) {
            this.f7782a = r1;
            this.f7783b = r2;
            this.c = r3;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.obric.common.oea.style.scene.alpha.alphaplayer.b r0 = PlayerController.access$getMPlayerAction$p(this.f7782a);
            if (r0 == null) goto L6;
            r0.a(this.f7783b.a() / 2, this.f7783b.b(), this.c);
            return;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 4, 3})
    static final class h implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ PlayerController f7784a;

        h(PlayerController r1) {
            this.f7784a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.obric.common.oea.style.scene.alpha.alphaplayer.b r0 = PlayerController.access$getMPlayerAction$p(this.f7784a);
            if (r0 == null) goto L6;
            r0.a();
            return;
        }
    }

    static {
        Companion = new a(null);
    }

    public PlayerController(Context r4, LifecycleOwner r5, AlphaVideoViewType r6, com.obric.common.oea.style.scene.alpha.alphaplayer.player.c r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        LifecycleOwner r9 = (LifecycleOwner) ZeusTransformUtils.wrapperContextForParams(r5, LifecycleOwner.class, "com.obric.memorydata.plugin");
        com.obric.common.oea.style.scene.alpha.alphaplayer.player.c r10 = (com.obric.common.oea.style.scene.alpha.alphaplayer.player.c) ZeusTransformUtils.wrapperContextForParams(r7, com.obric.common.oea.style.scene.alpha.alphaplayer.player.c.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r8, "context");
        Intrinsics.checkNotNullParameter(r9, "owner");
        Intrinsics.checkNotNullParameter(r6, "alphaVideoViewType");
        Intrinsics.checkNotNullParameter(r10, "mediaPlayer");
        this.playerState = PlayerState.NOT_PREPARED;
        this.mainHandler = new Handler(Looper.getMainLooper());
        this.mPreparedListener = new f(this);
        this.mErrorListener = new e(this);
        this.context = ZeusTransformUtils.wrapperContext(r8, "com.obric.memorydata.plugin");
        this.owner = r9;
        this.alphaVideoViewType = r6;
        this.mediaPlayer = r10;
        init();
    }

    public PlayerController(com.obric.common.oea.style.scene.alpha.alphaplayer.model.a r4, com.obric.common.oea.style.scene.alpha.alphaplayer.player.c r5) {
        com.obric.common.oea.style.scene.alpha.alphaplayer.player.c r6 = (com.obric.common.oea.style.scene.alpha.alphaplayer.player.c) ZeusTransformUtils.wrapperContextForParams(r5, com.obric.common.oea.style.scene.alpha.alphaplayer.player.c.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "configuration");
        this.playerState = PlayerState.NOT_PREPARED;
        this.mainHandler = new Handler(Looper.getMainLooper());
        this.mPreparedListener = new f(this);
        this.mErrorListener = new e(this);
        this.context = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
        this.owner = r4.b();
        this.alphaVideoViewType = r4.a();
        if (r6 != null) goto L6;
        r6 = (com.obric.common.oea.style.scene.alpha.alphaplayer.player.c) ZeusTransformUtils.preCheckCast(new com.obric.common.oea.style.scene.alpha.alphaplayer.player.b(), com.obric.common.oea.style.scene.alpha.alphaplayer.player.c.class, "com.obric.memorydata.plugin");
    L6:
        this.mediaPlayer = r6;
        init();
    }

    public /* synthetic */ PlayerController(com.obric.common.oea.style.scene.alpha.alphaplayer.model.a r2, com.obric.common.oea.style.scene.alpha.alphaplayer.player.c r3, int r4, DefaultConstructorMarker r5) {
        com.obric.common.oea.style.scene.alpha.alphaplayer.player.c r6 = (com.obric.common.oea.style.scene.alpha.alphaplayer.player.c) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.common.oea.style.scene.alpha.alphaplayer.player.c.class, "com.obric.memorydata.plugin");
        if ((r4 & 2) == 0) goto L5;
        r6 = (com.obric.common.oea.style.scene.alpha.alphaplayer.player.c) ZeusTransformUtils.preCheckCast(null, com.obric.common.oea.style.scene.alpha.alphaplayer.player.c.class, "com.obric.memorydata.plugin");
    L5:
        this(r2, r6);
    }

    public static final /* synthetic */ void access$emitEndSignal(PlayerController r0) {
        r0.emitEndSignal();
    }

    public static final /* synthetic */ com.obric.common.oea.style.scene.alpha.alphaplayer.widget.a access$getAlphaVideoView$p(PlayerController r1) {
        com.obric.common.oea.style.scene.alpha.alphaplayer.widget.a r2 = r1.alphaVideoView;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("alphaVideoView");
    L5:
        return r2;
    }

    public static final /* synthetic */ com.obric.common.oea.style.scene.alpha.alphaplayer.b access$getMPlayerAction$p(PlayerController r0) {
        return r0.mPlayerAction;
    }

    public static final /* synthetic */ Message access$getMessage(PlayerController r0, int r1, Object r2) {
        return r0.getMessage(r1, r2);
    }

    public static final /* synthetic */ PlayerState access$getPlayerState$p(PlayerController r0) {
        return r0.playerState;
    }

    public static final /* synthetic */ void access$monitor(PlayerController r0, boolean r1, int r2, int r3, String r4) {
        r0.monitor(r1, r2, r3, r4);
    }

    public static final /* synthetic */ void access$sendMessage(PlayerController r0, Message r1) {
        r0.sendMessage(r1);
    }

    public static final /* synthetic */ void access$setAlphaVideoView$p(PlayerController r2, com.obric.common.oea.style.scene.alpha.alphaplayer.widget.a r3) {
        r2.alphaVideoView = (com.obric.common.oea.style.scene.alpha.alphaplayer.widget.a) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.common.oea.style.scene.alpha.alphaplayer.widget.a.class, "com.obric.memorydata.plugin");
    }

    public static final /* synthetic */ void access$setMPlayerAction$p(PlayerController r2, com.obric.common.oea.style.scene.alpha.alphaplayer.b r3) {
        r2.mPlayerAction = (com.obric.common.oea.style.scene.alpha.alphaplayer.b) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.common.oea.style.scene.alpha.alphaplayer.b.class, "com.obric.memorydata.plugin");
    }

    public static final /* synthetic */ void access$setPlayerState$p(PlayerController r0, PlayerState r1) {
        r0.playerState = r1;
    }

    private final void emitEndSignal() {
        this.isPlaying = false;
        this.mainHandler.post((Runnable) ZeusTransformUtils.preCheckCast(new b(this), Runnable.class, "com.obric.memorydata.plugin"));
    }

    private final Message getMessage(int r1, Object r2) {
        Message r0 = Message.obtain();
        r0.what = r1;
        r0.obj = r2;
        Intrinsics.checkNotNullExpressionValue(r0, "message");
        return r0;
    }

    private final void handleSuspendedEvent() {
        com.obric.common.oea.style.scene.alpha.alphaplayer.model.b r0 = this.suspendDataSource;
        if (r0 == null) goto L5;
        setVideoFromFile(r0);
    L5:
        this.suspendDataSource = (com.obric.common.oea.style.scene.alpha.alphaplayer.model.b) ZeusTransformUtils.preCheckCast(null, com.obric.common.oea.style.scene.alpha.alphaplayer.model.b.class, "com.obric.memorydata.plugin");
    }

    private final void init() {
        init(this.owner);
        initAlphaView();
        initMediaPlayer();
    }

    private final void init(LifecycleOwner r4) {
        ((LifecycleOwner) ZeusTransformUtils.wrapperContextForParams(r4, LifecycleOwner.class, "com.obric.memorydata.plugin")).getLifecycle().addObserver((LifecycleObserver) ZeusTransformUtils.preCheckCast(this, LifecycleObserver.class, "com.obric.memorydata.plugin"));
        HandlerThread r5 = new HandlerThread("alpha-play-thread", 10);
        this.playThread = r5;
        Intrinsics.checkNotNull(r5);
        r5.start();
        HandlerThread r0 = this.playThread;
        Intrinsics.checkNotNull(r0);
        this.workHandler = new Handler(r0.getLooper(), (Handler.Callback) ZeusTransformUtils.preCheckCast(this, Handler.Callback.class, "com.obric.memorydata.plugin"));
    }

    private final void initAlphaView() {
        AlphaVideoViewType r0 = this.alphaVideoViewType;
        int r1 = com.obric.common.oea.style.scene.alpha.alphaplayer.controller.c.f7785a[r0.ordinal()];
        if (r1 != 1) goto L5;
        Object r2 = new AlphaVideoGLSurfaceView(this.context, null);
    L10:
        com.obric.common.oea.style.scene.alpha.alphaplayer.widget.a r3 = (com.obric.common.oea.style.scene.alpha.alphaplayer.widget.a) ZeusTransformUtils.preCheckCast(r2, com.obric.common.oea.style.scene.alpha.alphaplayer.widget.a.class, "com.obric.memorydata.plugin");
        this.alphaVideoView = r3;
        if (r3 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("alphaVideoView");
    L13:
        r3.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        r3.setPlayerController((com.obric.common.oea.style.scene.alpha.alphaplayer.controller.b) ZeusTransformUtils.preCheckCast(this, com.obric.common.oea.style.scene.alpha.alphaplayer.controller.b.class, "com.obric.memorydata.plugin"));
        r3.setVideoRenderer((com.obric.common.oea.style.scene.alpha.alphaplayer.a.a) ZeusTransformUtils.preCheckCast(new com.obric.common.oea.style.scene.alpha.alphaplayer.a.b(r3), com.obric.common.oea.style.scene.alpha.alphaplayer.a.a.class, "com.obric.memorydata.plugin"));
        return;
    L5:
        if (r1 != 2) goto L8;
        r2 = new AlphaVideoGLTextureView(this.context, null);
        goto L10
    L8:
        throw new NoWhenBranchMatchedException();
    }

    private final void initMediaPlayer() {
        sendMessage(getMessage(1, null));
    }

    private final void initPlayer() {
        this.mediaPlayer.e();     // Catch: Exception -> L5
    L7:
        this.mediaPlayer.b(true);
        this.mediaPlayer.a(false);
        this.mediaPlayer.a((com.obric.common.oea.style.scene.alpha.alphaplayer.player.c.InterfaceC0380c) ZeusTransformUtils.preCheckCast(new c(this), com.obric.common.oea.style.scene.alpha.alphaplayer.player.c.InterfaceC0380c.class, "com.obric.memorydata.plugin"));
        this.mediaPlayer.a((com.obric.common.oea.style.scene.alpha.alphaplayer.player.c.a) ZeusTransformUtils.preCheckCast(new d(this), com.obric.common.oea.style.scene.alpha.alphaplayer.player.c.a.class, "com.obric.memorydata.plugin"));
        return;
    L5:
        e = move-exception;
        com.obric.common.oea.style.scene.alpha.alphaplayer.player.c r2 = (com.obric.common.oea.style.scene.alpha.alphaplayer.player.c) ZeusTransformUtils.preCheckCast(new com.obric.common.oea.style.scene.alpha.alphaplayer.player.b(), com.obric.common.oea.style.scene.alpha.alphaplayer.player.c.class, "com.obric.memorydata.plugin");
        this.mediaPlayer = r2;
        r2.e();
        Log.e(TAG, "initPlayer failed " + e.getMessage());
        goto L7
    }

    private final void monitor(boolean r7, int r8, int r9, String r10) {
        com.obric.common.oea.style.scene.alpha.alphaplayer.a r0 = this.mMonitor;
        if (r0 == null) goto L6;
        r0.a(r7, getPlayerType(), r8, r9, r10);
        return;
    }

    static /* synthetic */ void monitor$default(PlayerController r1, boolean r2, int r3, int r4, String r5, int r6, Object r7) {
        if (r7 != null) goto L12;
        if ((r6 & 2) == 0) goto L7;
        r3 = 0;
    L7:
        if ((r6 & 4) == 0) goto L9;
        r4 = 0;
    L9:
        r1.monitor(r2, r3, r4, r5);
        return;
    L12:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: monitor");
    }

    private final void parseVideoSize() {
        com.obric.common.oea.style.scene.alpha.alphaplayer.model.c r0 = this.mediaPlayer.l();
        com.obric.common.oea.style.scene.alpha.alphaplayer.widget.a r1 = this.alphaVideoView;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("alphaVideoView");
    L5:
        r1.a(r0.a() / 2, r0.b());
        com.obric.common.oea.style.scene.alpha.alphaplayer.widget.a r2 = this.alphaVideoView;
        if (r2 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("alphaVideoView");
    L8:
        this.mainHandler.post((Runnable) ZeusTransformUtils.preCheckCast(new g(this, r0, r2.getScaleType()), Runnable.class, "com.obric.memorydata.plugin"));
    }

    private final void prepareAsync() {
        com.obric.common.oea.style.scene.alpha.alphaplayer.player.c r0 = this.mediaPlayer;
        if (this.playerState != PlayerState.NOT_PREPARED) goto L5;
    L6:
        r0.a((com.obric.common.oea.style.scene.alpha.alphaplayer.player.c.d) ZeusTransformUtils.preCheckCast(this.mPreparedListener, com.obric.common.oea.style.scene.alpha.alphaplayer.player.c.d.class, "com.obric.memorydata.plugin"));
        r0.a((com.obric.common.oea.style.scene.alpha.alphaplayer.player.c.b) ZeusTransformUtils.preCheckCast(this.mErrorListener, com.obric.common.oea.style.scene.alpha.alphaplayer.player.c.b.class, "com.obric.memorydata.plugin"));
        r0.f();
        return;
    L5:
        if (this.playerState == PlayerState.STOPPED) goto L6;
    }

    private final void sendMessage(Message r5) {
        HandlerThread r0 = this.playThread;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isAlive() == true) goto L7;
        return;
    L7:
        if (r0.isInterrupted() == false) goto L9;
        return;
    L9:
        if (this.workHandler != null) goto L11;
        this.workHandler = new Handler(r0.getLooper(), (Handler.Callback) ZeusTransformUtils.preCheckCast(this, Handler.Callback.class, "com.obric.memorydata.plugin"));
    L11:
        Handler r4 = this.workHandler;
        Intrinsics.checkNotNull(r4);
        r4.sendMessageDelayed(r5, 0);
    }

    private final void setDataSource(com.obric.common.oea.style.scene.alpha.alphaplayer.model.b r8) {
        setVideoFromFile(r8);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
        monitor$default(this, false, 0, 0, "alphaVideoView set dataSource failure: " + Log.getStackTraceString((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin")), 6, null);
        emitEndSignal();
    }

    private final void setVideoFromFile(com.obric.common.oea.style.scene.alpha.alphaplayer.model.b r9) {
        this.mediaPlayer.j();
        this.playerState = PlayerState.NOT_PREPARED;
        Resources r0 = ZeusTransformUtils.getResources(this.context, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r0, "context.resources");
        int r1 = r0.getConfiguration().orientation;
        String r2 = r9.a(r1);
        ScaleType r3 = r9.b(r1);
        if (TextUtils.isEmpty((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L5;
    L21:
        monitor$default(this, false, 0, 0, "dataPath is empty or File is not exists. path = " + r2, 6, null);
        emitEndSignal();
        return;
    L5:
        if (new File(r2).exists() == false) goto L21;
        if (r3 == null) goto L13;
        com.obric.common.oea.style.scene.alpha.alphaplayer.widget.a r4 = this.alphaVideoView;
        if (r4 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("alphaVideoView");
    L12:
        r4.setScaleType(r3);
    L13:
        this.mediaPlayer.a(r9.a());
        this.mediaPlayer.a(r2);
        com.obric.common.oea.style.scene.alpha.alphaplayer.widget.a r5 = this.alphaVideoView;
        if (r5 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("alphaVideoView");
    L17:
        if (r5.a() == false) goto L19;
        prepareAsync();
        return;
    L19:
        this.suspendDataSource = r9;
    }

    private final void startPlay() {
        PlayerState r0 = this.playerState;
        int r1 = com.obric.common.oea.style.scene.alpha.alphaplayer.controller.c.f7786b[r0.ordinal()];
        if (r1 != 1) goto L5;
        this.mediaPlayer.g();
        this.isPlaying = true;
        this.playerState = PlayerState.STARTED;
        this.mainHandler.post((Runnable) ZeusTransformUtils.preCheckCast(new h(this), Runnable.class, "com.obric.memorydata.plugin"));
        return;
    L5:
        if (r1 != 2) goto L7;
        this.mediaPlayer.g();
        this.playerState = PlayerState.STARTED;
        return;
    L7:
        if (r1 != 3) goto L9;
    L18:
        prepareAsync();     // Catch: Exception -> L13
        return;
    L13:
        e = move-exception;
        e.printStackTrace();
        monitor$default(this, false, 0, 0, "prepare and start MediaPlayer failure!", 6, null);
        emitEndSignal();
        return;
    L9:
        if (r1 == 4) goto L18;
    }

    public void attachAlphaView(ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r2, "parentView");
        com.obric.common.oea.style.scene.alpha.alphaplayer.widget.a r1 = this.alphaVideoView;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("alphaVideoView");
    L5:
        r1.a(r2);
    }

    public void detachAlphaView(ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r2, "parentView");
        com.obric.common.oea.style.scene.alpha.alphaplayer.widget.a r1 = this.alphaVideoView;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("alphaVideoView");
    L5:
        r1.b(r2);
    }

    public String getPlayerType() {
        return this.mediaPlayer.m();
    }

    public final PlayerState getStatus() {
        return this.playerState;
    }

    public View getView() {
        com.obric.common.oea.style.scene.alpha.alphaplayer.widget.a r1 = this.alphaVideoView;
        if (r1 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("alphaVideoView");
    L6:
        return r1.getView();
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message r11) {
        Intrinsics.checkNotNullParameter(r11, NotificationCompat.CATEGORY_MESSAGE);
        switch(r11.what) {
            case 1: goto L39;
            case 2: goto L38;
            case 3: goto L41;
            case 4: goto L31;
            case 5: goto L28;
            case 6: goto L22;
            case 7: goto L7;
            case 8: goto L6;
            case 9: goto L5;
            default: goto L40;
        };
    L5:
        this.mediaPlayer.j();
        this.playerState = PlayerState.NOT_PREPARED;
        this.isPlaying = false;
        goto L40
    L6:
        Object r12 = r11.obj;
        Objects.requireNonNull(r12, "null cannot be cast to non-null type android.view.Surface");
        this.mediaPlayer.a((Surface) ZeusTransformUtils.preCheckCast(r12, Surface.class, "com.obric.memorydata.plugin"));
        handleSuspendedEvent();
        goto L40
    L7:
        com.obric.common.oea.style.scene.alpha.alphaplayer.widget.a r13 = this.alphaVideoView;
        if (r13 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("alphaVideoView");
    L10:
        r13.onPause();
        if (this.playerState != PlayerState.STARTED) goto L14;
        this.mediaPlayer.h();
        this.playerState = PlayerState.PAUSED;
    L14:
        if (this.playerState != PlayerState.PAUSED) goto L16;
        this.mediaPlayer.i();
        this.playerState = PlayerState.STOPPED;
    L16:
        this.mediaPlayer.k();
        com.obric.common.oea.style.scene.alpha.alphaplayer.widget.a r14 = this.alphaVideoView;
        if (r14 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("alphaVideoView");
    L19:
        r14.e();
        this.playerState = PlayerState.RELEASE;
        HandlerThread r10 = this.playThread;
        if (r10 == null) goto L40;
        r10.quit();
        r10.interrupt();
        goto L40
    L22:
        int r15 = com.obric.common.oea.style.scene.alpha.alphaplayer.controller.c.d[this.playerState.ordinal()];
        if (r15 != 1) goto L25;
    L33:
        this.mediaPlayer.h();
        this.playerState = PlayerState.PAUSED;
        goto L40
    L25:
        if (r15 == 2) goto L33;
    L38:
        Object r16 = r11.obj;
        Objects.requireNonNull(r16, "null cannot be cast to non-null type com.obric.common.oea.style.scene.alpha.alphaplayer.model.DataSource");
        setDataSource((com.obric.common.oea.style.scene.alpha.alphaplayer.model.b) ZeusTransformUtils.preCheckCast(r16, com.obric.common.oea.style.scene.alpha.alphaplayer.model.b.class, "com.obric.memorydata.plugin"));
        goto L40
    L39:
        initPlayer();
    L40:
        return true;
    L41:
        parseVideoSize();     // Catch: Exception -> L36
        this.playerState = PlayerState.PREPARED;     // Catch: Exception -> L36
        startPlay();     // Catch: Exception -> L36
        Unit r17 = Unit.INSTANCE;     // Catch: Exception -> L36
    L36:
        e = move-exception;
        monitor$default(this, false, 0, 0, "start video failure: " + Log.getStackTraceString((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin")), 6, null);
        emitEndSignal();
        Unit r18 = Unit.INSTANCE;
        goto L40
    L28:
        if (this.isPlaying == false) goto L40;
        startPlay();
        goto L40
    L31:
        if (com.obric.common.oea.style.scene.alpha.alphaplayer.controller.c.c[this.playerState.ordinal()] == 1) goto L33;
        goto L33
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void onDestroy() {
        release();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public final void onPause() {
        pause();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public final void onResume() {
        resume();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public final void onStop() {
        stop();
    }

    public void pause() {
        sendMessage(getMessage(4, null));
    }

    public void release() {
        sendMessage(getMessage(7, null));
    }

    public void reset() {
        sendMessage(getMessage(9, null));
    }

    @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.controller.a
    public void resume() {
        sendMessage(getMessage(5, null));
    }

    public void setMonitor(com.obric.common.oea.style.scene.alpha.alphaplayer.a r3) {
        com.obric.common.oea.style.scene.alpha.alphaplayer.a r4 = (com.obric.common.oea.style.scene.alpha.alphaplayer.a) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.common.oea.style.scene.alpha.alphaplayer.a.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, CommonConsts.LOG_REPORT_TYPE_DEFAULT);
        this.mMonitor = r4;
    }

    public void setPlayerAction(com.obric.common.oea.style.scene.alpha.alphaplayer.b r3) {
        com.obric.common.oea.style.scene.alpha.alphaplayer.b r4 = (com.obric.common.oea.style.scene.alpha.alphaplayer.b) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.common.oea.style.scene.alpha.alphaplayer.b.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "playerAction");
        this.mPlayerAction = r4;
    }

    public void setVisibility(int r3) {
        com.obric.common.oea.style.scene.alpha.alphaplayer.widget.a r0 = this.alphaVideoView;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("alphaVideoView");
    L5:
        r0.setVisibility(r3);
        if (r3 != 0) goto L12;
        com.obric.common.oea.style.scene.alpha.alphaplayer.widget.a r2 = this.alphaVideoView;
        if (r2 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("alphaVideoView");
    L10:
        r2.bringToFront();
        return;
    }

    public void start(com.obric.common.oea.style.scene.alpha.alphaplayer.model.b r8) {
        Intrinsics.checkNotNullParameter(r8, "dataSource");
        if (r8.b() == false) goto L5;
        setVisibility(0);
        sendMessage(getMessage(2, r8));
        return;
    L5:
        emitEndSignal();
        monitor$default(this, false, 0, 0, "dataSource is invalid!", 6, null);
    }

    public void stop() {
        sendMessage(getMessage(6, null));
    }

    @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.controller.b
    public void surfacePrepared(Surface r2) {
        Intrinsics.checkNotNullParameter(r2, "surface");
        sendMessage(getMessage(8, r2));
    }
}
