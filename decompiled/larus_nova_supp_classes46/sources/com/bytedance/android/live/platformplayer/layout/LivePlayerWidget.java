package com.bytedance.android.live.platformplayer.layout;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.os.Build;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.base.model.message.z3;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.commonui.LiveSettingKeys;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.LiveSlardarMonitor;
import com.bytedance.android.live.core.setting.LiveInfraSettingKeys;
import com.bytedance.android.live.core.setting.c2;
import com.bytedance.android.live.core.setting.i5;
import com.bytedance.android.live.core.setting.m5;
import com.bytedance.android.live.core.setting.m6;
import com.bytedance.android.live.core.setting.n6;
import com.bytedance.android.live.core.setting.o3;
import com.bytedance.android.live.core.setting.t4;
import com.bytedance.android.live.core.setting.u6;
import com.bytedance.android.live.core.setting.v5;
import com.bytedance.android.live.core.setting.v6;
import com.bytedance.android.live.core.setting.w6;
import com.bytedance.android.live.core.setting.y6;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.core.tetris.widgets.LiveWidget;
import com.bytedance.android.live.core.utils.DigHoleScreenUtil;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.StatusBarUtil;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.m2;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.utils.screen.FoldScreenUtils;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.api.utils.LiveSeiUtil;
import com.bytedance.android.live.matchroom.MatchRoomLandScapeAnimUtil;
import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.live.platformplayer.LivePlatformPlayerManager;
import com.bytedance.android.live.platformplayer.api.ILandSlideService;
import com.bytedance.android.live.platformplayer.effect.VrEffectDownloader;
import com.bytedance.android.live.platformplayer.subcamera.SubCameraStateHandler;
import com.bytedance.android.live.plugin_api.LivePluginSPIManager;
import com.bytedance.android.live.room.api.IVisibilityControlBrickService;
import com.bytedance.android.live.room.api.IVisibilityControlService;
import com.bytedance.android.live.room.api.visibilitycontrol.LiveVisibilityControlContext;
import com.bytedance.android.live.strategy.api.IStrategyService;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livehostapi.TTMiddlewareLiveSDK;
import com.bytedance.android.livehostapi.business.multitask.LiveIndependentConfig;
import com.bytedance.android.livehostapi.platform.IMiddlewareHostAction;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.model.PadOrientation;
import com.bytedance.android.livesdk.chatroom.multitask.LiveInnerIndependentHelper;
import com.bytedance.android.livesdk.chatroom.multitask.LiveInnerIndependentManager;
import com.bytedance.android.livesdk.chatroom.progress.context.PlayerProgressServiceContext;
import com.bytedance.android.livesdk.chatroom.progress.service.IPlayerProgressService;
import com.bytedance.android.livesdk.chatroom.room.RoomSession;
import com.bytedance.android.livesdk.chatroom.ui.CameraTransitionViewHolder;
import com.bytedance.android.livesdk.chatroom.ui.InteractPlayViewManager;
import com.bytedance.android.livesdk.chatroom.ui.LiveResolutionChangeAnimHolder;
import com.bytedance.android.livesdk.chatroom.ui.VideoViewParams;
import com.bytedance.android.livesdk.chatroom.ui.d8;
import com.bytedance.android.livesdk.chatroom.ui.l6;
import com.bytedance.android.livesdk.chatroom.ui.q6;
import com.bytedance.android.livesdk.chatroom.ui.v9;
import com.bytedance.android.livesdk.chatroom.utils.VSMediaUIConfigHelper;
import com.bytedance.android.livesdk.chatroom.utils.VrUtils;
import com.bytedance.android.livesdk.chatroom.utils.a2;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.utils.LiveBgPlayUtil;
import com.bytedance.android.livesdk.chatroom.vsplayer.api.IVSPlayerService;
import com.bytedance.android.livesdk.config.LiveInitSettingKeys;
import com.bytedance.android.livesdk.config.PerformanceTestSettings;
import com.bytedance.android.livesdk.config.ag;
import com.bytedance.android.livesdk.config.ai0;
import com.bytedance.android.livesdk.config.bg1;
import com.bytedance.android.livesdk.config.bi0;
import com.bytedance.android.livesdk.config.ci0;
import com.bytedance.android.livesdk.config.cu;
import com.bytedance.android.livesdk.config.cu0;
import com.bytedance.android.livesdk.config.cx0;
import com.bytedance.android.livesdk.config.ei0;
import com.bytedance.android.livesdk.config.en;
import com.bytedance.android.livesdk.config.ez0;
import com.bytedance.android.livesdk.config.ff;
import com.bytedance.android.livesdk.config.fn;
import com.bytedance.android.livesdk.config.g50;
import com.bytedance.android.livesdk.config.g60;
import com.bytedance.android.livesdk.config.ht;
import com.bytedance.android.livesdk.config.id1;
import com.bytedance.android.livesdk.config.jf;
import com.bytedance.android.livesdk.config.jv0;
import com.bytedance.android.livesdk.config.kx0;
import com.bytedance.android.livesdk.config.lx0;
import com.bytedance.android.livesdk.config.m40;
import com.bytedance.android.livesdk.config.ng;
import com.bytedance.android.livesdk.config.qf0;
import com.bytedance.android.livesdk.config.r3;
import com.bytedance.android.livesdk.config.s11;
import com.bytedance.android.livesdk.config.tl0;
import com.bytedance.android.livesdk.config.wj0;
import com.bytedance.android.livesdk.config.ws0;
import com.bytedance.android.livesdk.config.xg0;
import com.bytedance.android.livesdk.config.xj0;
import com.bytedance.android.livesdk.config.yh0;
import com.bytedance.android.livesdk.config.yt0;
import com.bytedance.android.livesdk.config.zh0;
import com.bytedance.android.livesdk.config.zt0;
import com.bytedance.android.livesdk.h3;
import com.bytedance.android.livesdk.h8;
import com.bytedance.android.livesdk.k8;
import com.bytedance.android.livesdk.link.model.z5;
import com.bytedance.android.livesdk.message.model.VrTransferMessage;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdk.performance.LiveHazyFrameHelper;
import com.bytedance.android.livesdk.player.LivePlayerClient;
import com.bytedance.android.livesdk.player.LivePlayerContext;
import com.bytedance.android.livesdk.player.LivePlayerSpmLogger;
import com.bytedance.android.livesdk.player.State;
import com.bytedance.android.livesdk.player.layout.LivePlayerLayoutContextObserver;
import com.bytedance.android.livesdk.player.model.LiveStreamData;
import com.bytedance.android.livesdk.r9;
import com.bytedance.android.livesdk.room.data.EndReason;
import com.bytedance.android.livesdk.utils.e5;
import com.bytedance.android.livesdk.utils.e6;
import com.bytedance.android.livesdk.utils.r2;
import com.bytedance.android.livesdk.vscore_api.paid.PaidSceneEnum;
import com.bytedance.android.livesdkapi.ILiveParentLoadingView;
import com.bytedance.android.livesdkapi.TTLiveServiceMiddleware;
import com.bytedance.android.livesdkapi.depend.live.LiveRoomState;
import com.bytedance.android.livesdkapi.depend.model.live.AdaptionInfo;
import com.bytedance.android.livesdkapi.depend.model.live.IBaseStreamUrl;
import com.bytedance.android.livesdkapi.depend.model.live.ILiveCoreSDKData;
import com.bytedance.android.livesdkapi.depend.model.live.IPullData;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomAppearance;
import com.bytedance.android.livesdkapi.depend.model.live.IStreamUrlExtra;
import com.bytedance.android.livesdkapi.depend.model.live.LiveCoreSDKData;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.RoomKt;
import com.bytedance.android.livesdkapi.depend.model.live.RoomOthersData;
import com.bytedance.android.livesdkapi.depend.model.live.StreamUrl;
import com.bytedance.android.livesdkapi.depend.model.live.episode.EpisodeExtraInfo;
import com.bytedance.android.livesdkapi.depend.model.live.episode.IPaidLiveData;
import com.bytedance.android.livesdkapi.depend.model.live.episode.VSCameraInfo;
import com.bytedance.android.livesdkapi.depend.model.live.vr.VrInfo;
import com.bytedance.android.livesdkapi.depend.model.live.vr.VrSixdofTransferInfo;
import com.bytedance.android.livesdkapi.depend.model.live.vr.VrSixdofTransferInfoExtKt;
import com.bytedance.android.livesdkapi.depend.model.live.vs.MultiTab;
import com.bytedance.android.livesdkapi.depend.prefs.Property;
import com.bytedance.android.livesdkapi.eventbus.ChangeCameraStreamEvent;
import com.bytedance.android.livesdkapi.eventbus.HorizontalPlayEvent;
import com.bytedance.android.livesdkapi.model.CropSeiData;
import com.bytedance.android.livesdkapi.model.DisplayMode;
import com.bytedance.android.livesdkapi.model.DisplayRatio;
import com.bytedance.android.livesdkapi.model.ListenLiveStatus;
import com.bytedance.android.livesdkapi.model.LiveHazyFrameConfig;
import com.bytedance.android.livesdkapi.model.LivePreviewStreamSurfaceViewConfig;
import com.bytedance.android.livesdkapi.model.PlayerFirstFrameInfo;
import com.bytedance.android.livesdkapi.model.PlayerInnerDrawerConfig;
import com.bytedance.android.livesdkapi.model.PlayerMainApplyConfig;
import com.bytedance.android.livesdkapi.model.PlayerMainRenderLayoutConfig;
import com.bytedance.android.livesdkapi.model.PlayerMixedAudioConfig;
import com.bytedance.android.livesdkapi.model.PlayerOptimizeConfig;
import com.bytedance.android.livesdkapi.model.RenderViewInfo;
import com.bytedance.android.livesdkapi.model.SmoothEnterLeaveDoubleRenderConfig;
import com.bytedance.android.livesdkapi.model.VSFoldFixConfig;
import com.bytedance.android.livesdkapi.model.VideoHeadSurfaceControlConfig;
import com.bytedance.android.livesdkapi.model.WormholeConfig;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.live.config.setting.LiveVr6DofEffectConfig;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.GameDisplayRatioConfig;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.LiveMemLeakConfig;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.LiveModuleCrashFixConfig;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.MultiRoomConfig;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.setting.SmoothAnimConfig;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.rxbus.RxBusAbility;
import com.bytedance.android.livesdkapi.room.handler.toolbar.NewToolbarButtonConstants;
import com.bytedance.android.livesdkapi.roomplayer.AbsLivePlayerView;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerExtraRenderController;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerScene;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerSharedDataManager;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerSpmLogger;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerStatusController;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerVRController;
import com.bytedance.android.livesdkapi.roomplayer.IPlayerLogger;
import com.bytedance.android.livesdkapi.roomplayer.IRoomEventHub;
import com.bytedance.android.livesdkapi.roomplayer.LivePlayerClientContext;
import com.bytedance.android.livesdkapi.roomplayer.LivePlayerConfig;
import com.bytedance.android.livesdkapi.roomplayer.LivePlayerScene;
import com.bytedance.android.livesdkapi.roomplayer.LivePlayerView;
import com.bytedance.android.livesdkapi.roomplayer.LiveRequest;
import com.bytedance.android.livesdkapi.roomplayer.VideoEffectInitConfigBuilder;
import com.bytedance.android.livesdkapi.service.IFloatWindowService;
import com.bytedance.android.livesdkapi.service.ILandscapePicTypeService;
import com.bytedance.android.livesdkapi.service.IMiddlewareLiveService;
import com.bytedance.android.livesdkapi.service.IUhdLoginService;
import com.bytedance.android.livesdkapi.service.IVrContextService;
import com.bytedance.android.livesdkapi.util.LiveBlurProcessorV2;
import com.bytedance.android.livesdkapi.view.IRenderView;
import com.bytedance.android.livesdkapi.view.IVideoViewCropper;
import com.bytedance.android.livesdkapi.view.SurfaceRenderView;
import com.bytedance.android.livesdkapi.view.TextureRenderView;
import com.bytedance.android.livesdkapi.vr.LiveVrEffectInfo;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.videoarch.liveplayer.model.LiveStreamInfo;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import zg1.k3;
import zg1.u1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\b\u0012\u0004\u0012\u00020\u00050\u00042\u00020\u00062\u00020\u0007:\u0003\b\t\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/platformplayer/layout/LivePlayerWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "Lvlc/l;", "Lcom/bytedance/android/livesdk/chatroom/ui/d8$a;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "Lis2/g;", "Lgs0/c;", "a", "b", "c", "platform-player-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LivePlayerWidget extends LiveRecyclableWidget implements vlc.l, d8.a, Observer<KVData>, is2.g, gs0.c {
    public static final /* synthetic */ int V2 = 0;
    public final Lazy A;
    public final Lazy B;
    public final Lazy C;
    public ImageView D;
    public ImageView E;
    public boolean E2;
    public Bitmap F;
    public final l1 F2;
    public Bitmap G;
    public boolean G1;
    public vlc.d G2;
    public final com.bytedance.android.live.platformplayer.layout.s H;
    public LiveResolutionChangeAnimHolder H0;
    public boolean H1;
    public final j1 H2;
    public CameraTransitionViewHolder I;
    public boolean I2;
    public final Lazy J;
    public final c0 J2;
    public boolean K;
    public final com.bytedance.android.live.platformplayer.layout.h K2;
    public String L;
    public com.bytedance.android.livesdk.player.layout.e L0;
    public final boolean L1;
    public final k1 L2;
    public final com.bytedance.android.livesdk.chatroom.utils.i1 M;
    public boolean M1;
    public final i1 M2;
    public final Lazy N;
    public boolean N2;
    public long O;
    public final Lazy O2;
    public com.bytedance.android.live.platformplayer.layout.c P;
    public com.bytedance.android.livesdk.player.layout.n P0;
    public Pair<Integer, Integer> P1;
    public final a1 P2;
    public ValueAnimator Q;
    public Pair<Integer, Integer> Q1;
    public final b1 Q2;
    public py.k R;
    public g1 R2;
    public final Lazy S;
    public boolean S1;
    public final com.bytedance.android.live.platformplayer.layout.i S2;
    public boolean T;
    public final Lazy T1;
    public final com.bytedance.android.live.platformplayer.layout.m T2;
    public boolean U;
    public final ds0.d U2;
    public final Lazy V;
    public cy0.a V0;
    public final Lazy V1;
    public int W;
    public final Lazy X;
    public final Lazy Y;
    public final Lazy Z;
    public gs0.d a;
    public gs0.b b;
    public final b b1;
    public final Lazy b2;
    public AbsLivePlayerView c;
    public HSImageView d;
    public View e;
    public ViewGroup f;
    public View g;
    public final com.bytedance.android.live.platformplayer.layout.r g1;
    public boolean g2;
    public Function0<? extends is2.d> h;
    public int h1;
    public boolean h2;
    public Function0<? extends com.bytedance.android.live.platformplayer.b> i;
    public boolean j;
    public String k;
    public final b0 k0;
    public boolean k1;
    public boolean l;
    public final Lazy m;
    public v9 n;
    public final Boolean o;
    public ILiveParentLoadingView p;
    public com.bytedance.android.livesdk.chatroom.ui.background.a p0;
    public boolean p1;
    public final Lazy p2;
    public final Boolean q;
    public final com.bytedance.android.live.platformplayer.utils.g r;
    public final d8 s;
    public InteractPlayViewManager t;
    public final l6 u;
    public boolean v;
    public boolean v1;
    public boolean v2;
    public boolean w;
    public boolean x;
    public boolean x1;
    public boolean x2;
    public final String y;
    public boolean y1;
    public gs0.a y2;
    public Configuration z;

    public static final class a {
    }

    public static final class b implements Function0<Pair<? extends Integer, ? extends String>> {
        public final WeakReference<LivePlayerWidget> a;

        public final Object invoke() {
            LivePlayerWidget r0 = this.a.get();
            int r1 = 0;
            if (r0 == null) goto L45;
            AbsLivePlayerView r2 = r0.R8();
            ILivePlayerScene r4 = null;
            if ((r2 instanceof LivePlayerView) == true) goto L7;
            r2 = null;
        L7:
            LivePlayerView r3 = (LivePlayerView) r2;
            if (r3 == null) goto L12;
            LivePlayerConfig r5 = r3.getConfig();
            if (r5 == null) goto L12;
            ILivePlayerScene r6 = r5.getScene();
        L13:
            ILivePlayerClient r7 = r0.dr();
            if (r7 == null) goto L18;
            LivePlayerClientContext r8 = r7.context();
            if (r8 == null) goto L18;
            r4 = r8.getUseScene();
        L18:
            boolean r9 = Intrinsics.areEqual(r6, r4);
            ILivePlayerClient r10 = r0.dr();
            if (r10 != null) goto L21;
        L23:
            boolean r11 = false;
        L24:
            ILivePlayerClient r12 = r0.dr();
            if (r12 != null) goto L27;
        L29:
            boolean r13 = false;
        L31:
            if (((com.bytedance.android.live.platformplayer.b) r0.ar().invoke()).b() == true) goto L33;
        L35:
            boolean r14 = false;
        L36:
            if (r9 == false) goto L46;
            if (r13 == false) goto L46;
            if (r11 == false) goto L46;
            if (r14 == false) goto L46;
            if (r0.v1 == true) goto L46;
            Logger.e("LivePlayer", "内流业务侧禁音异常");
            r1 = 1;
        L46:
            return new Pair(Integer.valueOf(r1), "sameScene:" + r9 + ",isPlaying:" + r13 + ",isMute:" + r11 + ",isWidgetValid:" + r14);
        L33:
            if (((com.bytedance.android.live.platformplayer.b) r0.ar().invoke()).isUserVisible() == false) goto L35;
            r14 = true;
            goto L36
        L27:
            if (r12.isPlaying() != true) goto L29;
            r13 = true;
            goto L31
        L21:
            if (r10.isMute() != true) goto L23;
            r11 = true;
        L12:
            r6 = null;
            goto L13
        L45:
            return new Pair(0, "");
        }

        public b(WeakReference<LivePlayerWidget> r2) {
            Intrinsics.checkNotNullParameter(r2, "widget");
            this.a = r2;
        }
    }

    public static final class c implements ViewTreeObserver.OnGlobalLayoutListener {
        public final WeakReference<LivePlayerWidget> a;

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            LivePlayerWidget r0 = this.a.get();
            if (r0 == null) goto L24;
            ALogger.d("LivePlayer", "WeakOnGlobalLayoutListener.onGlobalLayout");
            DataCenter r2 = ((Widget) r0).dataCenter;
            if (r2 == null) goto L7;
            Boolean r3 = (Boolean) r2.get("DATA_PICTURE_MODE", Boolean.FALSE);
        L9:
            if (Intrinsics.areEqual(r3, Boolean.TRUE) == false) goto L11;
            return;
        L11:
            r0.R8().getRenderView().getSelfView().getViewTreeObserver().removeGlobalOnLayoutListener(this);
            ALogger.d("LivePlayer", "WeakOnGlobalLayoutListener removed " + r0.R8().getRenderView().getSelfView().getViewTreeObserver().hashCode());
            if (VrUtils.d(((Widget) r0).dataCenter) == false) goto L14;
            int r1 = LivePlayerWidget.fr();
        L16:
            if (VrUtils.d(((Widget) r0).dataCenter) == false) goto L18;
            int r4 = 0;
        L19:
            DataCenter r5 = ((Widget) r0).dataCenter;
            if (r5 == null) goto L22;
            r5.put("data_video_size", TuplesKt.to(Integer.valueOf(r1), Integer.valueOf(r4)));
        L22:
            boolean r6 = com.bytedance.android.live.revenue.core.util.h.a;
            com.bytedance.android.live.revenue.core.util.h.d(kc0.j.class).updateVideoHeight(r0.V0, r1, r4);
            return;
        L18:
            r4 = (int) r0.R8().getRenderView().getSelfView().getY();
            goto L19
        L14:
            r1 = r0.R8().getHeight();
            goto L16
        L7:
            r3 = null;
            goto L9
        }

        public c(WeakReference<LivePlayerWidget> r2) {
            Intrinsics.checkNotNullParameter(r2, "playerWidget");
            this.a = r2;
        }
    }

    public static final class d implements Runnable {
        public final /* synthetic */ LivePlayerWidget a;
        public final /* synthetic */ int b;
        public final /* synthetic */ int c;
        public final /* synthetic */ boolean d;
        public final /* synthetic */ ILivePlayerExtraRenderController e;

        public d(LivePlayerWidget r1, int r2, int r3, boolean r4, ILivePlayerExtraRenderController r5) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
        }

        public final void a() {
            AbsLivePlayerView r1 = this.a.R8();
            Pair r2 = TuplesKt.to(Integer.valueOf(r1.getHeight()), Integer.valueOf(r1.getWidth()));
            int r5 = ((Number) r2.component1()).intValue();
            int r4 = ((Number) r2.component2()).intValue();
            ViewGroup.LayoutParams r3 = this.a.R8().getRenderView().getLayoutParams();
            if ((r3 instanceof FrameLayout.LayoutParams) == true) goto L5;
            r3 = null;
        L5:
            FrameLayout.LayoutParams r6 = (FrameLayout.LayoutParams) r3;
            if (r5 <= 0) goto L45;
            if (r4 <= 0) goto L46;
            if (r6 == null) goto L48;
            float r9 = this.b / this.c;
            boolean r8 = this.d;
            if (r8 == false) goto L13;
            int r7 = r6.topMargin;
        L14:
            PlayerMainRenderLayoutConfig r14 = new PlayerMainRenderLayoutConfig(r4, r5, r7, 0, r8, r9, 0, 0, false, false, null, 1984, null);
            this.a.R8().setScaleType(0);
            PlayerMainApplyConfig r10 = this.e.calculateMainRenderSize(r14);
            if (r10 == null) goto L47;
            r6.width = r10.getContainerVideoWidth();
            r6.height = -1;
            r6.leftMargin = r10.getContainerLeftMargin();
            r6.gravity = r10.getContainerGravity();
            if (r10.getBgNeedUpdate() == false) goto L43;
            LivePlayerWidget r11 = this.a;
            boolean r12 = this.d;
            ILivePlayerExtraRenderController r13 = this.e;
            Context r15 = ((Widget) r11).context;
            if (r15 == null) goto L43;
            HSImageView r16 = new HSImageView(r15);
            if (r12 == true) goto L40;
            if (PadConfigUtils.c() == true) goto L40;
            Room r17 = r11.U2.w();
            if (r17 == null) goto L43;
            py.k r18 = r17.getCover();
            if (r18 != null) goto L33;
            User r19 = r17.getOwner();
            if (r19 == null) goto L32;
            r18 = r19._avatarLarge;
            goto L33
        L32:
            r18 = null;
        L33:
            if (r18 == null) goto L43;
            if (Build.VERSION.SDK_INT < 23) goto L38;
            r16.setForeground(ContextCompat.getDrawable(r15, 2131108056));
        L38:
            ImageLoader.bindImage(r16, r18, new LiveBlurProcessorV2(5));
        L42:
            r13.updateExtraRenderBackground(r16);
        L40:
            if (Build.VERSION.SDK_INT < 23) goto L42;
            r16.setForeground(ContextCompat.getDrawable(r15, 2131108057));
        L43:
            ILivePlayerExtraRenderController.DefaultImpls.updateExtraRenderLayoutConfig$default(this.e, PlayerMainRenderLayoutConfig.copy$default(r14, 0, 0, 0, r10.getContainerLeftMargin(), false, 0.0f, r10.getContainerVideoWidth(), r10.getContainerVideoHeight(), r10.getEnableLandStyle(), false, null, 1591, null), null, 2, null);
            return;
        L47:
            return;
        L13:
            r7 = 0;
            goto L14
        L48:
            return;
        L46:
            return;
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

    public static final class e implements Runnable {
        public final /* synthetic */ LivePlayerWidget a;

        public e(LivePlayerWidget r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            LivePlayerWidget r0 = this.a;     // Catch: Throwable -> L4
            int r1 = LivePlayerWidget.V2;     // Catch: Throwable -> L4
            r0.Qq();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class f implements Runnable {
        public final /* synthetic */ LivePlayerWidget a;

        public f(LivePlayerWidget r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            LivePlayerWidget r0 = this.a;     // Catch: Throwable -> L4
            int r1 = LivePlayerWidget.V2;     // Catch: Throwable -> L4
            r0.Qq();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class g<T> implements Observer {
        public final /* synthetic */ LivePlayerWidget a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ boolean c;

        public g(LivePlayerWidget r1, boolean r2, boolean r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void onChanged(Object r3) {
            if ((!Intrinsics.areEqual((Boolean) r3, Boolean.TRUE)) == false) goto L6;
            return;
        L6:
            if (wt2.h.f() == false) goto L8;
        L9:
            LivePlayerWidget r4 = this.a;
            int r0 = LivePlayerWidget.V2;
            r4.Zr();
            LivePlayerWidget r5 = this.a;
            gs0.a r1 = r5.y2;
            if (r1 == null) goto L12;
            boolean r2 = r1.a;
        L13:
            if (r2 == true) goto L17;
            if (r5.U2.isLiveHeadEnterSmooth() == true) goto L17;
            return;
        L17:
            if (this.c == true) goto L22;
            this.a.Kr(0);
            return;
        L22:
            return;
        L12:
            r2 = false;
            goto L13
        L8:
            if (this.b == true) goto L9;
        }
    }

    public static final class h<T> implements Observer {
        public final /* synthetic */ LivePlayerWidget a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ boolean c;

        public h(LivePlayerWidget r1, boolean r2, boolean r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void onChanged(Object r3) {
            if ((!Intrinsics.areEqual((Boolean) r3, Boolean.TRUE)) == false) goto L6;
            return;
        L6:
            if (wt2.h.f() == false) goto L8;
        L9:
            LivePlayerWidget r4 = this.a;
            gs0.a r0 = r4.y2;
            if (r0 == null) goto L12;
            boolean r1 = r0.a;
        L13:
            if (r1 == true) goto L15;
            return;
        L15:
            if (this.c == false) goto L20;
            r4.Kr(0);
            return;
        L20:
            return;
        L12:
            r1 = false;
            goto L13
        L8:
            if (this.b == true) goto L9;
        }
    }

    public static final class i<T> implements androidx.lifecycle.Observer {
        public final /* synthetic */ LivePlayerWidget a;

        public i(LivePlayerWidget r1) {
            this.a = r1;
        }

        public final void onChanged(Object r4) {
            Integer r5 = (Integer) r4;
            if (r5 == null) goto L11;
            if (r5.intValue() != 3) goto L11;
            LivePlayerWidget r6 = this.a;
            int r1 = LivePlayerWidget.V2;
            ILivePlayerClient r7 = r6.dr();
            if (r7 == null) goto L27;
            r7.toggleVr(false);
            return;
        L27:
            return;
        L11:
            if (r5 != null) goto L14;
        L16:
            if (r5 != null) goto L19;
            return;
        L19:
            if (r5.intValue() != 2) goto L29;
        L20:
            LivePlayerWidget r8 = this.a;
            int r2 = LivePlayerWidget.V2;
            ILivePlayerClient r9 = r8.dr();
            if (r9 == null) goto L23;
            ILivePlayerVRController.DefaultImpls.recenter$default(r9, false, 1, null);
        L23:
            ILivePlayerClient r10 = this.a.dr();
            if (r10 == null) goto L30;
            r10.gyroEnable(false);
            return;
        L30:
            return;
        L29:
            return;
        L14:
            if (r5.intValue() != 1) goto L16;
            goto L16
        }
    }

    public static final class j implements Runnable {
        public final /* synthetic */ LivePlayerWidget a;

        public j(LivePlayerWidget r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            LivePlayerWidget r0 = this.a;     // Catch: Throwable -> L14
            if (r0.U2.getEnterSmooth() == true) goto L5;
            return;
        L5:
            if (wt2.h.f() == false) goto L8;
            wt2.h.a++;     // Catch: Throwable -> L14
        L8:
            if (r0.U2.isSmoothEnterDoubleRender() == true) goto L21;
            ImageView r1 = r0.D;     // Catch: Throwable -> L14
            if (r1 == null) goto L22;
            r1.post(new c1(r0));     // Catch: Throwable -> L14
            return;
        L22:
            return;
        L21:
            return;
        L14:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L23;
            throw th;
        }
    }

    public static final class k implements Runnable {
        public final /* synthetic */ LivePlayerWidget a;

        public k(LivePlayerWidget r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            LivePlayerWidget r0 = this.a;     // Catch: Throwable -> L4
            int r1 = LivePlayerWidget.V2;     // Catch: Throwable -> L4
            r0.Zr();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class l<T> implements Consumer {
        public final /* synthetic */ LivePlayerWidget a;

        public l(LivePlayerWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r5) {
            Pair r6 = (Pair) r5;
            if (((PaidSceneEnum) r6.getFirst()) == PaidSceneEnum.PAID_ROOM) goto L7;
            if (((PaidSceneEnum) r6.getFirst()) == PaidSceneEnum.SUBSCRIBE_ROOM) goto L7;
        L9:
            if (((PaidSceneEnum) r6.getFirst()) == PaidSceneEnum.PAID_CAMERA) goto L11;
            return;
        L11:
            if (com.bytedance.android.livesdk.vscore_api.paidlive.scope.g.d(((Widget) this.a).dataCenter).J0().s(((Widget) this.a).dataCenter) == false) goto L48;
        L12:
            LivePlayerWidget r0 = this.a;
            com.bytedance.android.livesdk.vscore_api.paidlive.l r7 = (com.bytedance.android.livesdk.vscore_api.paidlive.l) r6.getSecond();
            int r1 = LivePlayerWidget.V2;
            r0.getClass();
            if (r7 != null) goto L15;
        L16:
            if (r7 != null) goto L18;
        L40:
            if (r7 != null) goto L42;
            return;
        L42:
            if ((r7 instanceof com.bytedance.android.livesdk.vscore_api.paidlive.l.a) == true) goto L44;
            return;
        L44:
            if (r0.tr() == false) goto L53;
            r0.Xk("remove paid float view for audio live");
            r0.es();
            return;
        L53:
            return;
        L18:
            if ((r7 instanceof com.bytedance.android.livesdk.vscore_api.paidlive.l.g) != true) goto L40;
        L20:
            if (r0.tr() == false) goto L37;
            r0.G1 = false;
            Fragment r8 = (Fragment) r0.U2.getGetFragment().invoke();
            View r2 = null;
            if (r8 == null) goto L26;
            View r9 = r8.getView();
            if (r9 == null) goto L26;
            View r10 = r9.findViewById(2131383590);
        L27:
            Fragment r3 = (Fragment) r0.U2.getGetFragment().invoke();
            if (r3 == null) goto L33;
            View r4 = r3.getView();
            if (r4 == null) goto L33;
            r2 = r4.findViewById(2131383591);
        L33:
            if (r10 == null) goto L35;
            r10.setVisibility(8);
        L35:
            if (r2 == null) goto L37;
            r2.setVisibility(8);
        L26:
            r10 = null;
        L37:
            r0.Wu("paid temp watch end", false);
            r0.hs();
            ViewGroup r11 = r0.f;
            if (r11 == null) goto L49;
            UtilityKotlinExtentionsKt.t(r11);
            return;
        L49:
            return;
        L15:
            if ((r7 instanceof com.bytedance.android.livesdk.vscore_api.paidlive.l.e) == true) goto L20;
        L48:
            return;
        L7:
            if (com.bytedance.android.livesdk.vscore_api.paidlive.scope.g.d(((Widget) this.a).dataCenter).J0().s(((Widget) this.a).dataCenter) == false) goto L12;
            goto L12
        }
    }

    public static final class m implements ViewTreeObserver.OnGlobalLayoutListener {
        public final /* synthetic */ LivePlayerWidget a;

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            DataCenter r0 = ((Widget) this.a).dataCenter;
            if (r0 == null) goto L5;
            Boolean r1 = (Boolean) r0.get("DATA_PICTURE_MODE", Boolean.FALSE);
        L7:
            if (Intrinsics.areEqual(r1, Boolean.TRUE) == false) goto L9;
            return;
        L9:
            this.a.R8().getRenderView().getSelfView().getViewTreeObserver().removeGlobalOnLayoutListener(this);
            if (VrUtils.d(((Widget) this.a).dataCenter) == false) goto L12;
            this.a.getClass();
            int r2 = LivePlayerWidget.fr();
        L14:
            if (VrUtils.d(((Widget) this.a).dataCenter) == false) goto L16;
            int r3 = 0;
        L17:
            DataCenter r4 = ((Widget) this.a).dataCenter;
            if (r4 == null) goto L20;
            r4.put("data_video_size", TuplesKt.to(Integer.valueOf(r2), Integer.valueOf(r3)));
        L20:
            boolean r5 = com.bytedance.android.live.revenue.core.util.h.a;
            com.bytedance.android.live.revenue.core.util.h.d(kc0.j.class).updateVideoHeight(this.a.V0, r2, r3);
            return;
        L16:
            r3 = (int) this.a.R8().getRenderView().getSelfView().getY();
            goto L17
        L12:
            r2 = this.a.R8().getHeight();
            goto L14
        L5:
            r1 = null;
            goto L7
        }

        public m(LivePlayerWidget r1) {
            this.a = r1;
        }
    }

    public static final class n implements IVideoViewCropper.CropCallback {
        public final /* synthetic */ LivePlayerWidget a;

        public final boolean supportCrop() {
            LivePlayerWidget r0 = this.a;
            int r1 = LivePlayerWidget.V2;
            if (r0.Ir(r0.Rq(null)) == false) goto L6;
            return false;
        L6:
            LivePlayerWidget r2 = this.a;
            return !r2.Hr(r2.Rq(null));
        }

        public n(LivePlayerWidget r1) {
            this.a = r1;
        }

        public final void onCropStateChanged(boolean r3) {
            LivePlayerWidget r0 = this.a;
            int r1 = LivePlayerWidget.V2;
            ILivePlayerClient r2 = r0.dr();
            if (r2 == null) goto L10;
            IRoomEventHub r4 = r2.getEventHub();
            if (r4 == null) goto L11;
            MutableLiveData r5 = r4.isSeiCropping();
            if (r5 == null) goto L12;
            r5.setValue(Boolean.valueOf(r3));
            return;
        L12:
            return;
        L11:
            return;
        }

        public final void resizeViewByCropper(boolean r2, int r3, int r4) {
            LivePlayerWidget r5 = this.a;
            r5.getClass();
            if (((Boolean) c2.a.getValue()).booleanValue() == false) goto L25;
            if (r2 == true) goto L25;
            v9 r6 = r5.n;
            Integer r7 = null;
            if (r6 == null) goto L8;
            Integer r8 = (Integer) r6.getOriginVideoInfo().getFirst();
        L9:
            if (r8 != null) goto L12;
        L13:
            v9 r9 = r5.n;
            if (r9 == null) goto L16;
            r7 = (Integer) r9.getOriginVideoInfo().getSecond();
        L16:
            if (r7 != null) goto L19;
        L20:
            v9 r10 = r5.n;
            if (r10 == null) goto L25;
            Pair<Integer, Integer> r11 = r10.getOriginVideoInfo();
            ILivePlayerClient r12 = r5.dr();
            if (r12 == null) goto L25;
            r12.setVideoSize(r11);
            goto L25
        L19:
            if (r7.intValue() == 0) goto L25;
        L12:
            if (r8.intValue() == 0) goto L25;
        L8:
            r8 = null;
        L25:
            r5.M30(s1.y(), "cropBySEI");
            if (r5.a == null) goto L31;
            DataCenter r13 = ((Widget) r5).dataCenter;
            if (r13 == null) goto L32;
            r13.put("cmd_video_orientation_changed", new k3(r5.U2.isVideoHorizontal(), r5.U2.getPortraitVideoViewBottom()));
            return;
        L32:
            return;
        }
    }

    public static final class o implements Runnable {
        public static final o a = null;

        static {
            a = new o();
        }

        public o() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            xs2.b.a().post(new zg1.h1(34));     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.platformplayer.layout.LivePlayerWidget$onLoad$1, reason: invalid class name */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 3})
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function0<Unit> {
        public AnonymousClass1(LivePlayerWidget r8) {
            super(0, r8, LivePlayerWidget.class, "notifyVideoOrientationEventIfDiff", "notifyVideoOrientationEventIfDiff()V", 0);
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final void m831invoke() {
            LivePlayerWidget r0 = (LivePlayerWidget) ((CallableReference) this).receiver;
            int r1 = LivePlayerWidget.V2;
            r0.Lr();
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            m831invoke();
            return Unit.INSTANCE;
        }
    }

    public static final class p implements Runnable {
        public final /* synthetic */ LivePlayerWidget a;
        public final /* synthetic */ ILivePlayerClient b;

        public p(LivePlayerWidget r1, ILivePlayerClient r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            LivePlayerWidget r0 = this.a;     // Catch: Throwable -> L4
            int r1 = LivePlayerWidget.V2;     // Catch: Throwable -> L4
            r0.Kr(1);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class q implements Runnable {
        public final /* synthetic */ LivePlayerWidget a;
        public final /* synthetic */ ILivePlayerClient b;

        public q(LivePlayerWidget r1, ILivePlayerClient r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            LivePlayerWidget r0 = this.a;     // Catch: Throwable -> L4
            int r1 = LivePlayerWidget.V2;     // Catch: Throwable -> L4
            r0.Kr(1);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class r implements Runnable {
        public final /* synthetic */ LivePlayerWidget a;
        public final /* synthetic */ ILivePlayerClient b;

        public r(LivePlayerWidget r1, ILivePlayerClient r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            LivePlayerWidget.yq(this.a, 1);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class s implements Runnable {
        public final /* synthetic */ LivePlayerWidget a;

        public s(LivePlayerWidget r1) {
            this.a = r1;
        }

        public final void a() {
            LivePlayerWidget r0 = this.a;
            if (r0.D == null) goto L5;
            r0.Qq();
        L5:
            ImageView r1 = this.a.D;
            if (r1 == null) goto L8;
            ViewParent r2 = r1.getParent();
        L10:
            if ((r2 instanceof ViewGroup) == true) goto L12;
            r2 = null;
        L12:
            ViewGroup r3 = (ViewGroup) r2;
            if (r3 == null) goto L15;
            r3.removeView(this.a.D);
        L15:
            ImageView r4 = this.a.D;
            if (r4 == null) goto L18;
            r4.setImageBitmap(null);
        L18:
            LivePlayerWidget r5 = this.a;
            r5.D = null;
            Bitmap r6 = r5.F;
            if (r6 == null) goto L21;
            r6.recycle();
        L21:
            this.a.F = null;
            return;
        L8:
            r2 = null;
            goto L10
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

    public static final class t implements Runnable {
        public final /* synthetic */ LivePlayerWidget a;

        public t(LivePlayerWidget r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            LivePlayerWidget r0 = this.a;     // Catch: Throwable -> L4
            int r1 = LivePlayerWidget.V2;     // Catch: Throwable -> L4
            r0.Qq();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class u implements Runnable {
        public final /* synthetic */ LivePlayerWidget a;
        public final /* synthetic */ int b;

        public static final class a implements Runnable {
            public final /* synthetic */ u a;

            public a(u r1) {
                this.a = r1;
            }

            public final void a() {
                LivePlayerWidget r0 = this.a.a;
                ImageView r1 = r0.E;
                if (r1 == null) goto L5;
                r1.post(new z0(r0));
            L5:
                ImageView r2 = r0.E;
                if (r2 == null) goto L18;
                ViewParent r3 = r2.getParent();
                if ((r3 instanceof ViewGroup) == true) goto L10;
                r3 = null;
            L10:
                ViewGroup r4 = (ViewGroup) r3;
                if (r4 == null) goto L13;
                r4.removeView(r2);
            L13:
                r2.setImageBitmap(null);
                r0.E = null;
                Bitmap r5 = r0.G;
                if (r5 == null) goto L16;
                r5.recycle();
            L16:
                r0.G = null;
                return;
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

        public u(LivePlayerWidget r1, int r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void a() {
            ALogger.i("SmoothDoubleRender", "newSurfaceRendered() >>> initBackground");
            LivePlayerWidget r0 = this.a;
            if (r0.v2 == false) goto L5;
        L7:
            ALogger.i("SmoothDoubleRender", "newSurfaceRendered() >>> convertActivityFromTranslucent");
            this.a.Qq();
            ALogger.i("SmoothDoubleRender", "newSurfaceRendered() >>> resetSmoothDoubleRenderSurface");
            ILivePlayerClient r1 = this.a.dr();
            if (r1 == null) goto L10;
            r1.resetSmoothDoubleRenderSurface();
        L10:
            gs0.a r2 = this.a.y2;
            if (r2 == null) goto L13;
            r2.a(false);
        L13:
            gs0.a r3 = this.a.y2;
            if (r3 == null) goto L17;
            r3.b(false);
        L17:
            if (this.a.U2.isLiveHeadEnterSmooth() == true) goto L19;
            return;
        L19:
            if (this.b != 1) goto L23;
            this.a.R8().attachSurfaceView();
            ImageView r4 = this.a.E;
            if (r4 == null) goto L23;
            r4.post(new a(this));
        L23:
            ILivePlayerClient r5 = this.a.dr();
            if (r5 == null) goto L28;
            r5.setSetSurfaceInterceptor(null);
            return;
        L28:
            return;
        L5:
            if (((Widget) r0).containerView == null) goto L7;
            r0.rr(r0.U2.getStreamType(), this.a.U2.h());
            goto L7
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

    static {
    }

    public final GameDisplayRatioConfig Yq() {
        return (GameDisplayRatioConfig) this.Z.getValue();
    }

    public final rc0.e br() {
        return (rc0.e) this.V1.getValue();
    }

    public final String businessTypeV2() {
        return "LivePlayerWidget";
    }

    public final rc0.f cr() {
        return (rc0.f) this.T1.getValue();
    }

    public final PlayerInnerDrawerConfig er() {
        return (PlayerInnerDrawerConfig) this.J.getValue();
    }

    public final void es() {
        boolean r0 = true;
        this.G1 = true;
        Map r1 = com.bytedance.android.live.core.utils.a0.n(((Widget) this).dataCenter).getLinkMap();
        if (r1 != null) goto L5;
    L7:
        r0 = false;
    L9:
        if (this.U2.getEnterSmooth() == true) goto L29;
        if (r0 == false) goto L12;
        return;
    L12:
        if (this.H1 == true) goto L31;
        Fragment r2 = (Fragment) this.U2.getGetFragment().invoke();
        View r3 = null;
        if (r2 == null) goto L18;
        View r4 = r2.getView();
        if (r4 == null) goto L18;
        View r5 = r4.findViewById(2131383590);
    L19:
        Fragment r6 = (Fragment) this.U2.getGetFragment().invoke();
        if (r6 == null) goto L24;
        View r7 = r6.getView();
        if (r7 == null) goto L24;
        r3 = r7.findViewById(2131383591);
    L24:
        if (r5 == null) goto L26;
        r5.setVisibility(0);
    L26:
        if (r3 == null) goto L32;
        r3.setVisibility(0);
        return;
    L32:
        return;
    L18:
        r5 = null;
        goto L19
    L31:
        return;
    L29:
        return;
    L5:
        if (r1.containsKey(String.valueOf(1)) != true) goto L7;
        goto L7
    }

    public final Map<String, Object> getEnvData() {
        return null;
    }

    public final String getSpm() {
        return "a100.a212.a100";
    }

    public final boolean isIgnored() {
        return false;
    }

    public final void onInit(Object[] r1) {
    }

    public final void onOrientationChangeV2(int r1) {
    }

    public final void onRoomPrepareV2(boolean r1) {
    }

    public final String or() {
        boolean r0 = false;
        int r1 = mr(false);
        long r2 = System.currentTimeMillis();
        String r4 = "";
        if (r1 < 3) goto L5;
    L10:
        IStrategyService r6 = jc1.k.f(IStrategyService.class);
        if (r6 != null) goto L13;
        return "";
    L13:
        LiveData r7 = r6.getFactor("vr_stream_downgrade_toast", "", false, false);
        if (r7 == null) goto L19;
        String r8 = (String) r7.getValue();
        if (r8 == null) goto L19;
        r4 = r8;
    L19:
        if (r1 < 3) goto L21;
    L27:
        return r4;
    L21:
        if (r4.length() <= 0) goto L23;
        r0 = true;
    L23:
        if (r0 == false) goto L27;
        if ((!Intrinsics.areEqual(r4, "null")) == false) goto L27;
        ((Property) this.B.getValue()).setValue(Long.valueOf(r2));
        Property r3 = (Property) this.A.getValue();
        r3.setValue(Integer.valueOf(((Integer) r3.getValue()).intValue() + 1));
        goto L27
    L5:
        if (((Number) ((Property) this.A.getValue()).getValue()).intValue() < 10) goto L8;
        return "";
    L8:
        if ((r2 - ((Number) ((Property) this.B.getValue()).getValue()).longValue()) > 86400000) goto L10;
        return "";
    }

    @Override // gs0.c
    public final void A70() {
        com.bytedance.android.live.platformplayer.utils.g r0 = this.r;
        com.bytedance.android.live.platformplayer.utils.d r1 = r0.a;
        if (r1 == null) goto L5;
        r1.cancel();
    L5:
        com.bytedance.android.live.platformplayer.utils.e r2 = r0.b;
        if (r2 == null) goto L8;
        r2.cancel();
    L8:
        com.bytedance.android.live.platformplayer.utils.f r3 = r0.c;
        if (r3 == null) goto L12;
        r3.cancel();
        return;
    }

    public final boolean Cr() {
        return LivePlatformPlayerManager.c(this.U2.x(), this.U2.isPseudo()).x(this.U2.getStreamType(), ((Boolean) wj0.a.getValue()).booleanValue(), wt2.h.f(), wt2.h.a(), this.j);
    }

    public final void Fq() {
        if (((Boolean) ht.a.getValue()).booleanValue() == true) goto L5;
        return;
    L5:
        Er("adjustPlayViewForTalkRoom");
        int r0 = Math.min(UIUtils.getScreenWidth(s1.getContext()), UIUtils.getScreenHeight(s1.getContext()));
        int r1 = (int) (s1.G(s1.w() - s1.j(2131169232)) / 6);
        int r2 = r0 - UtilityKotlinExtentionsKt.i(r1 + 3);
        int r3 = (r1 * 6) + 15;
        int r4 = s1.f(r3);
        int r5 = ((Widget) this).containerView.getHeight() - UtilityKotlinExtentionsKt.i(r3 + 48);
        ViewGroup.LayoutParams r6 = R8().getLayoutParams();
        if (r6 == null) goto L10;
        FrameLayout.LayoutParams r7 = (FrameLayout.LayoutParams) r6;
        r7.width = r2;
        r7.height = r4;
        r7.gravity = 3;
        r7.leftMargin = 0;
        r7.topMargin = r5;
        R8().setLayoutParams(r7);
        return;
    L10:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
    }

    public final void Iq() {
        if (this.U2.getStreamType() == LiveMode.AUDIO) goto L5;
        return;
    L5:
        if (((com.bytedance.android.livesdk.config.j0) ff.a.getValue()).mEnable == true) goto L7;
        return;
    L7:
        if (this.k1 == false) goto L9;
    L15:
        boolean r0 = false;
    L16:
        Er("audioBlackFrameOpt disableRender=" + r0 + " old=" + this.M1);
        if (this.M1 == r0) goto L24;
        this.M1 = r0;
        ILivePlayerClient r1 = dr();
        if (r1 == null) goto L25;
        r1.disableVideoRender(this.M1);
        return;
    L25:
        return;
    L24:
        return;
    L9:
        if (this.x1 == true) goto L15;
        if (Nq() == true) goto L15;
        if (this.H1 == true) goto L15;
        r0 = true;
        goto L16
    }

    public final boolean Jr() {
        if ((!this.U2.q().isEmpty()) == true) goto L5;
    L11:
        return false;
    L5:
        if (this.U2.t() == true) goto L13;
        Room r0 = this.U2.w();
        if (r0 == null) goto L11;
        if (r0.isGameRoom() != 1) goto L11;
        return true;
    L13:
        return true;
    }

    @Override // gs0.c
    public final void Jy() {
        if (this.H0 != null) goto L9;
        ViewGroup r0 = ((Widget) this).containerView;
        if (r0 == null) goto L7;
        FrameLayout r1 = (FrameLayout) r0.findViewById(2131382474);
    L8:
        this.H0 = new LiveResolutionChangeAnimHolder(r1, ((Widget) this).dataCenter);
        goto L9
    L7:
        r1 = null;
    L9:
        LiveResolutionChangeAnimHolder r2 = this.H0;
        if (r2 == null) goto L13;
        r2.b();
        return;
    }

    public final void Lr() {
        DataCenter r0 = ((Widget) this).dataCenter;
        if (r0 != null) goto L5;
        return;
    L5:
        k3 r2 = (k3) r0.get("cmd_video_orientation_changed");
        if (r2 != null) goto L8;
    L12:
        r0.put("cmd_video_orientation_changed", new k3(this.U2.isVideoHorizontal(), this.U2.getPortraitVideoViewBottom()));
        return;
    L8:
        if (r2.a != this.U2.isVideoHorizontal()) goto L12;
        if (r2.b != this.U2.getPortraitVideoViewBottom()) goto L12;
    }

    public final boolean Nq() {
        if (this.U2.isCustomizeAudioRoom() == false) goto L5;
    L8:
        return true;
    L5:
        if (this.y1 == true) goto L8;
        return false;
    }

    public final void Nr() {
        pu2.c r0 = com.bytedance.android.livesdk.vscore_api.paidlive.scope.g.d(((Widget) this).dataCenter).V1();
        if (r0 == null) goto L12;
        Observable r1 = r0.qh();
        if (r1 == null) goto L13;
        Observable r2 = r1.observeOn(AndroidSchedulers.mainThread());
        if (r2 == null) goto L14;
        ObservableSubscribeProxy r3 = (ObservableSubscribeProxy) r2.as(AutoDispose.bind(this));
        if (r3 == null) goto L15;
        r3.subscribe(new l(this));
        return;
    L15:
        return;
    L14:
        return;
    L13:
        return;
    }

    @Override // gs0.c
    public final void On() {
        d8 r0 = this.s;
        r0.k = false;
        r0.l = false;
        r0.h();
    }

    public final void Pr() {
        if (this.c != null) goto L5;
        return;
    L5:
        AbsLivePlayerView r0 = R8();
        if (r0 != null) goto L8;
        return;
    L8:
        Pair r1 = cr().h();
        if (r1 != null) goto L11;
        r1 = TuplesKt.to(0, 0);
    L11:
        int r2 = ((Number) r1.component1()).intValue();
        int r3 = ((Number) r1.component2()).intValue();
        IMiddlewareLiveService r4 = TTLiveServiceMiddleware.getLiveService();
        if (r4 != null) goto L14;
    L15:
        cr().a(r0);
        r0.getRenderView().setScaleType(2);
        r0.getRenderView().setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        if (r2 <= 0) goto L23;
        if (r3 <= 0) goto L24;
        ILivePlayerClient r5 = dr();
        if (r5 == null) goto L25;
        r5.setVideoSize(TuplesKt.to(Integer.valueOf(r2), Integer.valueOf(r3)));
        return;
    L25:
        return;
    L24:
        return;
    L23:
        return;
    L14:
        if (r4.shouldUseNewLivePlayerLayout() != true) goto L15;
    }

    public final void Qq() {
        Context r0 = ((Widget) this).context;
        if ((r0 instanceof Activity) == true) goto L5;
        r0 = null;
    L5:
        Activity r1 = (Activity) r0;
        if (r1 == null) goto L20;
        fn r2 = fn.a;     // Catch: Throwable -> L15
        if (((Boolean) r2.getValue()).booleanValue() == true) goto L10;
    L13:
        Method r3 = Activity.class.getDeclaredMethod("convertFromTranslucent", new Class[0]);     // Catch: Throwable -> L15
        r3.setAccessible(true);     // Catch: Throwable -> L15
        r3.invoke(r1, new Object[0]);     // Catch: Throwable -> L15
        r1.getWindow().setBackgroundDrawableResource(2131103394);     // Catch: Throwable -> L15
        return;
    L10:
        if (((Boolean) r2.getValue()).booleanValue() == true) goto L12;
        return;
    L12:
        if (this.j == false) goto L13;
        return;
    L15:
        th = move-exception;
        th.printStackTrace();
        return;
    }

    public final void Qr() {
        Er("LivePlayerWidget onPlaying, widget " + hashCode());
        M30(s1.y(), "onPlayDisplayed");
        ILivePlayerClient r0 = dr();
        boolean r1 = false;
        if (r0 == null) goto L6;
        Pair<Integer, Integer> r2 = r0.getVideoSize();
        if (r2 == null) goto L6;
    L7:
        int r3 = ((Number) r2.component1()).intValue();
        int r4 = ((Number) r2.component2()).intValue();
        if (r3 == 0) goto L15;
        if (r4 == 0) goto L15;
        if (this.a == null) goto L15;
        DataCenter r5 = ((Widget) this).dataCenter;
        if (r5 == null) goto L15;
        r5.put("cmd_video_orientation_changed", new k3(this.U2.isVideoHorizontal(), this.U2.getPortraitVideoViewBottom()));
    L15:
        this.U2.e().getHideLoading().setValue(Boolean.TRUE);
        A70();
        if (this.U2.getLiveIllegal() == false) goto L18;
        cs(true, "first frame but in illegal status");
        ILivePlayerClient r6 = dr();
        if (r6 == null) goto L27;
        r6.mute("LivePlayerWidget.onPlaying");
    L27:
        if (this.U2.getStreamType() == LiveMode.AUDIO) goto L29;
    L45:
        gs();
        com.bytedance.android.livesdk.chatroom.ui.background.a r7 = this.p0;
        if (r7 == null) goto L48;
        r7.c = dr();
    L48:
        com.bytedance.android.livesdk.chatroom.ui.background.a r8 = this.p0;
        if (r8 == null) goto L55;
        ds0.d r9 = this.U2;
        if (r9 == null) goto L53;
        LiveMode r10 = r9.getStreamType();
    L54:
        r8.b(r10);
        goto L55
    L53:
        r10 = null;
    L55:
        IUhdLoginService r11 = Sq();
        if (r11 == null) goto L59;
        r11.startTimer(hashCode());
    L59:
        if (Nq() == false) goto L64;
        ILivePlayerClient r12 = dr();
        if (r12 == null) goto L65;
        int r13 = is0.b.a;
        r12.registerPlayerFeature(is0.b.a.b("pc_customize_audio_room"));
        return;
    L65:
        return;
    L64:
        return;
    L29:
        if (((com.bytedance.android.livesdk.config.j0) ff.a.getValue()).mEnable == false) goto L45;
        if (this.U2.getInPkMode() == false) goto L33;
    L41:
        this.M1 = r1;
        ILivePlayerClient r14 = dr();
        if (r14 == null) goto L44;
        r14.disableVideoRender(this.M1);
    L44:
        Er("onPlaying disableRender=" + this.M1);
        goto L45
    L33:
        if (this.x1 == true) goto L41;
        if (this.U2.f == true) goto L41;
        if (Nq() == true) goto L41;
        if (this.H1 == true) goto L41;
        r1 = true;
        goto L41
    L18:
        if (tr() == true) goto L20;
        Wu("first frame", false);
        com.bytedance.android.live.core.utils.rxutils.j.a r15 = com.bytedance.android.live.core.utils.rxutils.j.a;
        ((ObservableSubscribeProxy) com.bytedance.android.live.core.utils.rxutils.j.c(1000, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).as(AutoDispose.bind(this))).subscribe(new h1(this));
        goto L27
    L20:
        Er("hide parent background, widget " + hashCode());
        ILiveParentLoadingView r16 = this.p;
        if (r16 == null) goto L27;
        r16.hideBackground();
    L6:
        r2 = new Pair(0, 0);
        goto L7
    }

    @Override // gs0.c
    public final AbsLivePlayerView R8() {
        AbsLivePlayerView r0 = this.c;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("playerView");
    L5:
        return r0;
    }

    public final void Wr() {
        ILivePlayerClient r0 = LivePlatformPlayerManager.a(this.U2.x(), this.U2.isPseudo());
        if (r0 != null) goto L5;
        return;
    L5:
        IRenderView r1 = r0.getRenderView();
        if (r1 == null) goto L46;
        boolean r2 = r0.context().isPreviewSurfaceView();
        int r3 = r1.getWidth();
        int r4 = r1.getHeight();
        if (Cr() == true) goto L11;
        if (r2 == true) goto L11;
        Cq(r1);
    L11:
        ViewGroup r5 = this.f;
        if (r5 == null) goto L14;
        r5.setVisibility(8);
    L14:
        Er("loadSharedPlayer() player render view width : " + R8().getRenderView().getWidth() + " , height : " + R8().getRenderView().getHeight());
        boolean r8 = false;
        if (this.U2.getStreamType() != LiveMode.THIRD_PARTY) goto L17;
        R8().setScaleType(0);
    L20:
        boolean r6 = LivePlatformPlayerManager.c(this.U2.x(), this.U2.isPseudo()).m();
        if (this.U2.getEnterSmooth() == false) goto L23;
        if (r6 == false) goto L23;
    L24:
        r0.setShouldDestroy(r8);
        ILivePlayerClient r7 = dr();
        if (r7 == null) goto L31;
        IRoomEventHub r9 = r7.getEventHub();
        if (r9 == null) goto L31;
        MutableLiveData r10 = r9.getPlaying();
        if (r10 == null) goto L31;
        r10.setValue(Boolean.TRUE);
    L31:
        Qr();
        if (Cr() == true) goto L36;
        if (r2 == true) goto L36;
        Zr();
    L36:
        if (tr() == true) goto L38;
    L40:
        Dr();
        if (this.U2.isSmoothEnterDoubleRender() == true) goto L43;
        return;
    L43:
        if (wt2.g.d() <= 0) goto L48;
        R8().postDelayed(new p(this, r0), wt2.g.d());
        return;
    L48:
        return;
    L38:
        if (this.H1 == true) goto L40;
        r1.setVisibility(8);
    L23:
        r8 = true;
        goto L24
    L17:
        if (r3 >= r4) goto L19;
        R8().setScaleType(2);
        goto L20
    L19:
        R8().setScaleType(0);
        goto L20
    }

    public final void Xr() {
        ILivePlayerClient r0 = LivePlatformPlayerManager.a(this.U2.x(), this.U2.isPseudo());
        if (r0 != null) goto L5;
        return;
    L5:
        IRenderView r1 = r0.getRenderView();
        if (r1 == null) goto L54;
        boolean r2 = r0.context().isPreviewSurfaceView();
        if (Cr() == true) goto L11;
        if (r2 == true) goto L11;
        Cq(r1);
    L11:
        ViewGroup r3 = this.f;
        if (r3 == null) goto L14;
        r3.setVisibility(8);
    L14:
        Er("loadSharedPlayer() player render view width : " + R8().getRenderView().getWidth() + " , height : " + R8().getRenderView().getHeight());
        boolean r4 = LivePlatformPlayerManager.c(this.U2.x(), this.U2.isPseudo()).m();
        if (this.U2.getEnterSmooth() == false) goto L19;
        if (r4 == false) goto L19;
        boolean r5 = false;
    L20:
        r0.setShouldDestroy(r5);
        ILivePlayerClient r6 = dr();
        if (r6 == null) goto L27;
        IRoomEventHub r7 = r6.getEventHub();
        if (r7 == null) goto L27;
        MutableLiveData r8 = r7.getPlaying();
        if (r8 == null) goto L27;
        r8.setValue(Boolean.TRUE);
    L27:
        Qr();
        if (Cr() == true) goto L32;
        if (r2 == true) goto L32;
        Zr();
    L32:
        if (tr() == true) goto L34;
    L36:
        Dr();
        if (this.U2.isSmoothEnterDoubleRender() == false) goto L42;
        if (wt2.g.d() <= 0) goto L42;
        R8().postDelayed(new q(this, r0), wt2.g.d());
    L42:
        if (this.U2.q == true) goto L44;
    L52:
        ms(this, "realLoadShareViewNew", 0, 0, null, null, 30);
        return;
    L44:
        if ((r1 instanceof SurfaceRenderView) == true) goto L46;
        r1 = null;
    L46:
        SurfaceRenderView r9 = (SurfaceRenderView) r1;
        if (r9 == null) goto L50;
        r9.addSurfaceControlRenderListener(this.H2);
    L50:
        if (wt2.g.d() <= 0) goto L52;
        R8().postDelayed(new r(this, r0), wt2.g.d());
        goto L52
    L34:
        if (this.H1 == true) goto L36;
        r1.setVisibility(8);
    L19:
        r5 = true;
        goto L20
    }

    public final void Zr() {
        if (this.U2.getEnterSmooth() == false) goto L5;
    L6:
        boolean r1 = true;
        if (wt2.h.f() == false) goto L10;
        wt2.h.a++;
    L10:
        if (this.U2.isSmoothEnterDoubleRender() == false) goto L13;
        return;
    L13:
        if (Cr() == false) goto L17;
        if (((Boolean) i5.a.getValue()).booleanValue() == false) goto L17;
    L26:
        if (r1 == false) goto L30;
        ImageView r0 = this.D;
        if (r0 == null) goto L47;
        r0.post(new s(this));
        return;
    L47:
        return;
    L30:
        ImageView r2 = this.D;
        if (r2 == null) goto L33;
        r2.post(new t(this));
    L33:
        ImageView r3 = this.D;
        if (r3 == null) goto L49;
        ViewParent r4 = r3.getParent();
        if ((r4 instanceof ViewGroup) == true) goto L38;
        r4 = null;
    L38:
        ViewGroup r5 = (ViewGroup) r4;
        if (r5 == null) goto L41;
        r5.removeView(r3);
    L41:
        r3.setImageBitmap(null);
        this.D = null;
        Bitmap r6 = this.F;
        if (r6 == null) goto L44;
        r6.recycle();
    L44:
        this.F = null;
        return;
    L49:
        return;
    L17:
        if (Cr() == true) goto L25;
        ILivePlayerClient r7 = dr();
        if (r7 == null) goto L25;
        LivePlayerClientContext r8 = r7.context();
        if (r8 == null) goto L25;
        if (r8.isPreviewSurfaceView() == true) goto L26;
    L25:
        r1 = false;
        goto L26
    L5:
        if (this.U2.isLiveHeadEnterSmooth() == true) goto L6;
    }

    public final Function0<com.bytedance.android.live.platformplayer.b> ar() {
        Function0 r0 = this.i;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("getFragment");
    L5:
        return r0;
    }

    public final Room bs() {
        Room r0 = this.U2.w();
        if (r0 != null) goto L9;
        DataCenter r1 = ((Widget) this).dataCenter;
        if (r1 == null) goto L8;
        return (Room) r1.get("data_room", null);
    L8:
        return null;
    L9:
        return r0;
    }

    public final void ds() {
        if (((VSFoldFixConfig) LiveSettingKeys.LIVE_VS_FOLD_FIX_CONFIG.getValue()).getEnable() == true) goto L5;
    L7:
        boolean r0 = false;
    L9:
        if (r0 == true) goto L35;
        if (e5.f(this.U2.getScreenOrientation()) == false) goto L35;
        DataCenter r1 = ((Widget) this).dataCenter;
        IRoom r4 = null;
        if (r1 == null) goto L15;
        r4 = (IRoom) r1.get("data_room", null);
    L15:
        if (r4 != null) goto L17;
    L19:
        ViewGroup r2 = ((Widget) this).containerView;
        if (r2 == null) goto L24;
        View r3 = r2.findViewById(2131392252);
        if (r3 == null) goto L24;
        r3.setVisibility(8);
    L24:
        ALogger.d(this.y, "set video background gone, roomId = " + this.U2.x());
        if (this.U2.isSmoothLeaveDoubleRender() == false) goto L27;
    L29:
        ViewGroup r5 = ((Widget) this).containerView;
        if (r5 == null) goto L45;
        View r6 = r5.findViewById(2131379689);
        if (r6 == null) goto L46;
        UtilityKotlinExtentionsKt.z(r6, false);
        return;
    L46:
        return;
    L45:
        return;
    L27:
        if (this.U2.isSmoothEnterDoubleRender() == true) goto L29;
        qs(true);
        goto L29
    L17:
        if (r4.isD3Room() != true) goto L19;
        return;
    L35:
        if (this.U2.isSmoothLeaveDoubleRender() == false) goto L37;
    L39:
        qs(false);
        ViewGroup r7 = ((Widget) this).containerView;
        if (r7 == null) goto L48;
        View r8 = r7.findViewById(2131379689);
        if (r8 == null) goto L49;
        UtilityKotlinExtentionsKt.t(r8);
        return;
    L49:
        return;
    L48:
        return;
    L37:
        if (this.U2.isSmoothEnterDoubleRender() == true) goto L39;
        fs();
        goto L39
    L5:
        if (FoldScreenUtils.e() == false) goto L7;
        r0 = true;
        goto L9
    }

    public final void fs() {
        ViewGroup r0 = ((Widget) this).containerView;
        if (r0 == null) goto L7;
        View r1 = r0.findViewById(2131392252);
        if (r1 == null) goto L7;
        r1.setVisibility(0);
    L7:
        ALogger.d(this.y, "set video background visible, roomId = " + this.U2.x());
    }

    public final Function0<is2.d> gr() {
        Function0<? extends is2.d> r0 = this.h;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("roomEngine");
    L5:
        return r0;
    }

    public final void gs() {
        com.bytedance.android.livesdk.vscore_api.paidlive.scope.g.c(this.U2.w()).d1(this.k0, this.U2.w());
    }

    public final void hs() {
        CameraTransitionViewHolder r0 = this.I;
        if (r0 == null) goto L5;
        r0.b();
    L5:
        IRoomContextService r1 = jc1.k.f(IRoomContextService.class);
        if (r1 == null) goto L13;
        com.bytedance.android.livesdk.chatroom.o r2 = IRoomContextService.a.a(r1, null, 0, 3);
        if (r2 == null) goto L14;
        com.bytedance.live.datacontext.m r3 = r2.c2();
        if (r3 == null) goto L15;
        r3.setValue(Boolean.FALSE);
        return;
    L15:
        return;
    L14:
        return;
    }

    public final void ks() {
        IService r0 = jr(ILandSlideService.class);
        Intrinsics.checkNotNull(r0);
        if (((ILandSlideService) r0).isSlideAble() == false) goto L9;
        IService r1 = jr(ILandSlideService.class);
        Intrinsics.checkNotNull(r1);
        if (((ILandSlideService) r1).getSelectedRoomId() == this.U2.x()) goto L9;
        ALogger.i("LivePlayer", "switchScreenToPortrait fail , view pager is scrolling");
        return;
    L9:
        if (((WormholeConfig) ez0.a.getValue()).mEnable == false) goto L14;
        IService r2 = jr(ILandSlideService.class);
        Intrinsics.checkNotNull(r2);
        if (((ILandSlideService) r2).getSelectedRoomId() == this.U2.x()) goto L14;
        ALogger.i("LivePlayer", "switchScreenToPortrait fail , current live isInwormhole");
        return;
    L14:
        Boolean r3 = null;
        if (this.a == null) goto L18;
        com.bytedance.android.livesdk.log.b0 r4 = com.bytedance.android.livesdk.log.b0.o();
        String r5 = "onVideoSizeChanged cause to hide interaction; id" + this.U2.x();
        r4.getClass();
        com.bytedance.android.live.core.log.g.a("ttlive_room_exit", r5);
        xs2.b.a().post(new HorizontalPlayEvent(1));
    L38:
        if (this.h2 == false) goto L40;
        return;
    L40:
        if (this.U2.isVideoHorizontal() == true) goto L52;
        DataCenter r6 = ((Widget) this).dataCenter;
        if (r6 == null) goto L45;
        r3 = (Boolean) r6.get("data_longer_video_within_live_type", Boolean.FALSE);
    L45:
        if (Intrinsics.areEqual(r3, Boolean.TRUE) == true) goto L54;
        this.h2 = true;
        ILandSlideService r7 = (ILandSlideService) jr(ILandSlideService.class);
        if (r7 == null) goto L53;
        r7.showToast(this.U2);
        return;
    L53:
        return;
    L54:
        return;
    L52:
        return;
    L18:
        if (com.bytedance.android.livesdk.utils.landscape.f.a() == true) goto L25;
        DataCenter r8 = ((Widget) this).dataCenter;
        if (r8 == null) goto L22;
        Boolean r9 = (Boolean) r8.get("data_longer_video_within_live_type", Boolean.FALSE);
    L24:
        if (Intrinsics.areEqual(r9, Boolean.TRUE) == true) goto L25;
    L26:
        Context r10 = ((Widget) this).context;
        if ((r10 instanceof Activity) == true) goto L29;
        r10 = null;
    L29:
        Activity r11 = (Activity) r10;
        if (r11 == null) goto L32;
        r11.setRequestedOrientation(e5.c(1, false));
    L32:
        this.U2.setScreenOrientation(e5.c(1, false));
        LiveRequest r12 = this.U2.getLiveRequest();
        if (r12 == null) goto L38;
        MutableLiveData r13 = r12.isPortrait();
        if (r13 == null) goto L38;
        r13.setValue(Boolean.TRUE);
        goto L38
    L22:
        r9 = null;
    L25:
        this.U2.g = true;
        goto L26
    }

    public final void onDestroy() {
        Er("onDestroy");
        if (((LiveMemLeakConfig) com.bytedance.android.livesdk.j1.a.getValue()).getOpenFixPlayerV1() == true) goto L5;
    L10:
        com.bytedance.android.livesdk.chatroom.room.p0 r0 = this.U2.e();
        r0.getStartPull().removeObserver(this.M2);
        r0.getSwitchStreamDataEvent().removeObserver(this.L2);
        this.U2.z();
        R8().removeCallbacks(this.H);
        ILivePlayerClient r1 = R8().getClient();
        if (r1 == null) goto L17;
        IRoomEventHub r2 = r1.getEventHub();
        if (r2 == null) goto L17;
        MutableLiveData r3 = r2.getBackgroundStopIn4G();
        if (r3 == null) goto L17;
        r3.removeObserver(this.K2);
    L17:
        ILivePlayerClient r4 = R8().getClient();
        if (r4 == null) goto L24;
        IRoomEventHub r5 = r4.getEventHub();
        if (r5 == null) goto L24;
        MutableLiveData r6 = r5.getReset();
        if (r6 == null) goto L24;
        r6.removeObserver(this.J2);
    L24:
        ILivePlayerClient r7 = R8().getClient();
        if (r7 == null) goto L38;
        ILivePlayerExtraRenderController r8 = r7.extraRenderController();
        if (r8 == null) goto L38;
        if (r8.isGameRoom() == true) goto L32;
        r8 = null;
    L32:
        if (r8 == null) goto L38;
        ILivePlayerExtraRenderController.EventHub r9 = r8.eventHub();
        if (r9 == null) goto L38;
        MutableLiveData r10 = r9.getExtraRenderIsShow();
        if (r10 == null) goto L38;
        r10.removeObserver((Observer) this.p2.getValue());
    L38:
        ILivePlayerClient r11 = dr();
        if (r11 == null) goto L45;
        IRoomEventHub r12 = r11.getEventHub();
        if (r12 == null) goto L45;
        MutableLiveData r13 = r12.getBackgroundHandlerRunning();
        if (r13 == null) goto L45;
        r13.removeObserver(this.S2);
    L45:
        ILivePlayerClient r14 = dr();
        if (r14 == null) goto L52;
        IRoomEventHub r15 = r14.getEventHub();
        if (r15 == null) goto L52;
        MutableLiveData r16 = r15.getPlayingHandlerRunning();
        if (r16 == null) goto L52;
        r16.removeObserver(this.T2);
    L52:
        qQ();
        com.bytedance.android.livesdk.chatroom.ui.background.a r17 = this.p0;
        if (r17 == null) goto L58;
        r17.a = false;
        r17.b = false;
        r17.c = null;
        Disposable r18 = r17.d;
        if (r18 == null) goto L57;
        r18.dispose();
    L57:
        r17.d = null;
    L58:
        this.p0 = null;
        this.T = true;
        super.onDestroy();
        return;
    L5:
        if (((Boolean) yh0.a.getValue()).booleanValue() == false) goto L10;
        com.bytedance.android.livesdk.player.layout.n r19 = this.P0;
        if (r19 == null) goto L9;
        r19.reset();
    L9:
        ConcurrentHashMap<String, as0.a> r20 = LivePlatformPlayerManager.a;
        LivePlatformPlayerManager.b.remove(Long.valueOf(this.U2.x()));
        goto L10
    }

    public final void onUnload() {
        Er("player widget @" + hashCode() + " onUnload()");
        this.U = false;
        if (((PlayerMixedAudioConfig) is0.c.c().getConfig(PlayerMixedAudioConfig.class)).getFixPreviewResumeMixedAudio() == false) goto L10;
        AbsLivePlayerView r1 = R8();
        if ((r1 instanceof LivePlayerView) == true) goto L7;
        r1 = null;
    L7:
        LivePlayerView r2 = (LivePlayerView) r1;
        if (r2 == null) goto L10;
        r2.release();
    L10:
        yh0 r3 = yh0.a;
        if (((Boolean) r3.getValue()).booleanValue() == true) goto L36;
        cr().d();
        if (cr().c() == false) goto L24;
        ILivePlayerClient r4 = dr();
        if (r4 == null) goto L19;
        LivePlayerClientContext r5 = r4.context();
        if (r5 == null) goto L19;
        ILivePlayerScene r6 = r5.getUseScene();
    L21:
        if (Intrinsics.areEqual(r6, LivePlayerScene.INSTANCE.getINNER_DRAW()) == false) goto L23;
        Pr();
        goto L24
    L23:
        cr().b(R8());
    L19:
        r6 = null;
    L24:
        br().d();
        if (br().c() == false) goto L36;
        ILivePlayerClient r7 = dr();
        if (r7 == null) goto L31;
        LivePlayerClientContext r8 = r7.context();
        if (r8 == null) goto L31;
        ILivePlayerScene r9 = r8.getUseScene();
    L33:
        if (Intrinsics.areEqual(r9, LivePlayerScene.INSTANCE.getINNER_DRAW()) == false) goto L35;
        Or();
        goto L36
    L35:
        br().b(R8());
    L31:
        r9 = null;
    L36:
        rc0.h r10 = (rc0.h) this.b2.getValue();
        if (r10 == null) goto L39;
        r10.detach();
    L39:
        com.bytedance.android.live.platformplayer.utils.g r11 = this.r;
        com.bytedance.android.live.platformplayer.utils.d r12 = r11.a;
        if (r12 == null) goto L42;
        r12.cancel();
    L42:
        com.bytedance.android.live.platformplayer.utils.e r13 = r11.b;
        if (r13 == null) goto L45;
        r13.cancel();
    L45:
        com.bytedance.android.live.platformplayer.utils.f r14 = r11.c;
        if (r14 == null) goto L48;
        r14.cancel();
    L48:
        r11.a = null;
        r11.b = null;
        r11.c = null;
        LiveResolutionChangeAnimHolder r15 = this.H0;
        if (r15 == null) goto L51;
        r15.a();
    L51:
        this.F2.removeCallbacksAndMessages(null);
        vlc.d r16 = this.G2;
        if (r16 == null) goto L55;
        r16.removeMessageListener(this);
    L55:
        if (((Boolean) r3.getValue()).booleanValue() == false) goto L60;
        com.bytedance.android.livesdk.player.layout.n r17 = this.P0;
        if (r17 == null) goto L59;
        r17.reset();
    L59:
        ConcurrentHashMap<String, as0.a> r18 = LivePlatformPlayerManager.a;
        LivePlatformPlayerManager.b.remove(Long.valueOf(this.U2.x()));
    L60:
        ILivePlayerClient r19 = dr();
        if (r19 == null) goto L63;
        r19.unRegisterMuteAudioCheck(this.b1);
    L63:
        R8().getRenderView().removeRenderViewMeasureListener(this.Q2);
        if ((R8().getRenderView() instanceof SurfaceRenderView) == false) goto L75;
        SurfaceRenderView r20 = R8().getRenderView();
        if (r20 == null) goto L73;
        r20.removeRenderViewLayoutListener(this.P2);
        SurfaceRenderView r21 = R8().getRenderView();
        if (r21 == null) goto L71;
        r21.removeSurfaceControlRenderListener(this.H2);
        goto L75
    L71:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdkapi.view.SurfaceRenderView");
    L73:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdkapi.view.SurfaceRenderView");
    L75:
        if ((R8().getRenderView() instanceof TextureRenderView) == false) goto L81;
        TextureRenderView r22 = R8().getRenderView();
        if (r22 == null) goto L80;
        r22.removeRenderViewLayoutListener(this.P2);
        goto L81
    L80:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdkapi.view.TextureRenderView");
    L81:
        InteractPlayViewManager r23 = this.t;
        if (r23 == null) goto L100;
        CompositeDisposable r24 = r23.d;
        if (r24 == null) goto L87;
        r24.clear();
    L87:
        if (r23.w == false) goto L100;
        if (r23.j == null) goto L100;
        StringBuilder r25 = new StringBuilder();
        IRoom r26 = r23.j;
        if (r26 == null) goto L94;
        Object r27 = r26.getIdStr();
        if (r27 == null) goto L94;
    L95:
        r25.append(r27);
        r25.append('_');
        if (r23.z != null) goto L98;
        String r28 = PbRequest.SwitchType.FEED;
    L99:
        r25.append(r28);
        String r29 = r25.toString();
        ALogger.d("InteractPlayViewManager", "onDestroy, clear RxBus, uniqueId = " + r29);
        RxBusAbility.INSTANCE.clearRxBus(r29);
        goto L100
    L98:
        r28 = PbRequest.SwitchType.ROOM;
    L94:
        r27 = 0;
    L100:
        this.L = null;
        com.bytedance.android.livesdk.chatroom.ui.background.a r30 = this.p0;
        if (r30 == null) goto L106;
        r30.a = false;
        r30.b = false;
        r30.c = null;
        Disposable r31 = r30.d;
        if (r31 == null) goto L105;
        r31.dispose();
    L105:
        r30.d = null;
    L106:
        this.p0 = null;
        this.y2 = null;
        this.v2 = false;
        this.x2 = false;
        ValueAnimator r0 = this.Q;
        if (r0 == null) goto L109;
        r0.cancel();
    L109:
        this.Q = null;
    }

    @Override // gs0.c
    public final void qQ() {
        if (((Boolean) m6.a.getValue()).booleanValue() == true) goto L5;
        return;
    L5:
        this.l = true;
    }

    public final void sr() {
        DataCenter r0 = ((Widget) this).dataCenter;
        vlc.d r1 = null;
        if (r0 == null) goto L5;
        r1 = (vlc.d) r0.get("data_message_manager", null);
    L5:
        this.G2 = r1;
        if (r1 == null) goto L8;
        r1.addMessageListener("WebcastRoomBackgroundMessage", this);
    L8:
        vlc.d r2 = this.G2;
        if (r2 == null) goto L11;
        r2.addMessageListener("WebcastGameBackgroundImageMessage", this);
    L11:
        vlc.d r3 = this.G2;
        if (r3 == null) goto L15;
        r3.addMessageListener("WebcastVrTransferMessage", this);
        return;
    }

    @Override // gs0.c
    public final void uu() {
        boolean r0 = com.bytedance.android.live.revenue.core.util.h.a;
        com.bytedance.android.live.revenue.core.util.h.d(kc0.j.class).markAddPkBackground(this.V0, false);
    }

    public final boolean vr() {
        if (this.U2.t() == true) goto L11;
        Room r0 = this.U2.w();
        if (r0 != null) goto L7;
    L9:
        return false;
    L7:
        if (r0.isGameRoom() != 1) goto L9;
        return true;
    L11:
        return true;
    }

    public final boolean xr() {
        ILandSlideService r0 = (ILandSlideService) jr(ILandSlideService.class);
        if (r0 == null) goto L5;
        boolean r1 = r0.enableLand2Land();
    L7:
        if (VrUtils.d(((Widget) this).dataCenter) == false) goto L10;
    L14:
        boolean r2 = false;
    L15:
        if (r1 == true) goto L17;
        return r2;
    L17:
        IService r3 = jr(ILandSlideService.class);
        Intrinsics.checkNotNull(r3);
        if (((ILandSlideService) r3).checkIsNotSupportLandFromDrawer(this.U2) == true) goto L20;
        if (r2 == true) goto L20;
        return false;
    L20:
        return true;
    L10:
        if (this.U2.isVideoHorizontal() == true) goto L14;
        if (e5.f(this.U2.getScreenOrientation()) == false) goto L14;
        r2 = true;
        goto L15
    L5:
        r1 = false;
        goto L7
    }

    public final boolean zr() {
        if (this.U2.getStreamType() != LiveMode.THIRD_PARTY) goto L5;
        return true;
    L5:
        return false;
    }

    public static IUhdLoginService Sq() {
        if (LiveModuleCrashFixConfig.getLiveFixServiceExceptionAnr() == false) goto L7;
        return null;
    L7:
        return jr(IUhdLoginService.class);
    }

    public static int fr() {
        Resources r0 = Resources.getSystem();
        return WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics()).heightPixels;
    }

    public final void Dr() {
        if (er().getForceRemoveStaticFrame() == true) goto L5;
        return;
    L5:
        if (er().getForceRemoveStaticFrameV2() == false) goto L9;
        ImageView r0 = this.D;
        if (r0 == null) goto L14;
        r0.postDelayed(new j(this), er().getForceRemoveStaticFrameDelayTime());
        return;
    L14:
        return;
    L9:
        ImageView r1 = this.D;
        if (r1 == null) goto L16;
        r1.postDelayed(new k(this), er().getForceRemoveStaticFrameDelayTime());
        return;
    }

    public final void Jq() {
        AbsLivePlayerView r0 = R8();
        ILivePlayerClient r1 = dr();
        ViewParent r2 = null;
        if (r1 == null) goto L7;
        IRenderView r3 = r1.getRenderView();
        if (r3 == null) goto L7;
        ViewParent r4 = r3.getParent();
    L8:
        boolean r5 = false;
        if ((!Intrinsics.areEqual(r0, r4)) == true) goto L11;
    L13:
        boolean r6 = false;
    L14:
        if (r6 == true) goto L20;
        ILivePlayerClient r7 = dr();
        if (r7 == null) goto L18;
        IRenderView r8 = r7.getRenderView();
    L19:
        if (r8 == null) goto L20;
        return;
    L18:
        r8 = null;
    L20:
        ILivePlayerClient r9 = dr();
        if (r9 == null) goto L25;
        IPlayerLogger r10 = r9.logger();
        if (r10 == null) goto L25;
        ILivePlayerSpmLogger.DefaultImpls.logLifeCycle$default(r10, "bind render view on player prepared", null, false, 6, null);
    L25:
        ILivePlayerClient r11 = dr();
        if (r11 == null) goto L28;
        r11.bindRenderView(R8().getRenderView());
    L28:
        ILivePlayerClient r12 = dr();
        if (r12 == null) goto L36;
        AbsLivePlayerView r13 = R8();
        if ((r13 instanceof LivePlayerView) == true) goto L33;
        r13 = null;
    L33:
        LivePlayerView r14 = (LivePlayerView) r13;
        if (r14 == null) goto L36;
        r14.setClient(r12);
    L36:
        PlayerMixedAudioConfig r15 = (PlayerMixedAudioConfig) is0.c.c().getConfig(PlayerMixedAudioConfig.class);
        if (r15 != null) goto L39;
        return;
    L39:
        if (r15.getEnableMixedAudioCheck() != true) goto L98;
        ILivePlayerClient r16 = dr();
        if (r16 == null) goto L99;
        IRenderView r17 = r16.getRenderView();
        if (r17 == null) goto L100;
        View r18 = r17.getSelfView();
        if (r18 == null) goto L101;
        IInteractService r19 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r19 != null) goto L49;
    L50:
        IInteractService r20 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r20 != null) goto L53;
    L54:
        Room r21 = bs();
        if (r21 == null) goto L60;
        Map r22 = r21.getLinkMap();
        if (r22 == null) goto L60;
        if (r22.containsKey(String.valueOf(9)) != true) goto L60;
    L83:
        r5 = true;
    L84:
        if (r5 == false) goto L86;
        return;
    L86:
        if ((true ^ Intrinsics.areEqual(r18.getParent(), R8())) == false) goto L103;
        ViewParent r23 = r18.getParent();
        if ((r23 instanceof ViewGroup) == false) goto L91;
        r2 = r23;
    L91:
        ViewGroup r24 = (ViewGroup) r2;
        if (r24 == null) goto L94;
        r24.removeView(r18);
    L94:
        R8().addView(r18);
        return;
    L103:
        return;
    L60:
        Room r25 = bs();
        if (r25 == null) goto L66;
        Map r26 = r25.getLinkMap();
        if (r26 == null) goto L66;
        if (r26.containsKey(String.valueOf(5)) == true) goto L83;
    L66:
        Room r27 = bs();
        if (r27 == null) goto L71;
        Map r28 = r27.getLinkMap();
        if (r28 == null) goto L71;
        int r29 = r28.size();
    L72:
        if (r29 == 0) goto L79;
        Room r30 = bs();
        if (r30 == null) goto L84;
        Map r31 = r30.getLinkMap();
        if (r31 == null) goto L84;
        if (r31.containsKey(String.valueOf(0)) != true) goto L84;
    L79:
        Room r32 = bs();
        if (r32 == null) goto L84;
        if (r32.isLiveTypeAudio() != true) goto L84;
    L71:
        r29 = -1;
        goto L72
    L53:
        if (r20.getCurrentScene() == 5) goto L83;
    L49:
        if (r19.getCurrentScene() == 9) goto L83;
    L101:
        return;
    L100:
        return;
    L99:
        return;
    L98:
        return;
    L11:
        if (yr() == false) goto L13;
        r6 = true;
    L7:
        r4 = null;
        goto L8
    }

    public final void Mq() {
        ILivePlayerClient r0 = dr();
        LivePlayerWidget r1 = null;
        if (r0 == null) goto L7;
        IRoomEventHub r2 = r0.getEventHub();
        if (r2 == null) goto L7;
        MutableLiveData r3 = r2.getSurfaceReadyFirstFrameRender();
    L8:
        ILivePlayerClient r4 = dr();
        if (r4 == null) goto L13;
        IRoomEventHub r5 = r4.getEventHub();
        if (r5 == null) goto L13;
        MutableLiveData r6 = r5.getAllSurfaceReadyFirstFrameRender();
    L14:
        ILivePlayerClient r7 = dr();
        boolean r8 = true;
        boolean r9 = false;
        if (r7 == null) goto L21;
        LivePlayerClientContext r10 = r7.context();
        if (r10 == null) goto L21;
        if (r10.isPreviewSurfaceView() != true) goto L21;
        boolean r11 = true;
    L22:
        if (r3 == null) goto L24;
        Boolean r12 = (Boolean) r3.getValue();
    L26:
        if (Intrinsics.areEqual(r12, Boolean.TRUE) == false) goto L68;
        if (wt2.h.f() == false) goto L49;
        ILivePlayerClient r13 = dr();
        if (r13 == null) goto L34;
        IRenderView r14 = r13.getRenderView();
        if (r14 == null) goto L34;
        View r15 = r14.getSelfView();
    L36:
        if ((r15 instanceof SurfaceView) == true) goto L38;
        r15 = null;
    L38:
        SurfaceView r16 = (SurfaceView) r15;
        if (r16 == null) goto L47;
        SurfaceHolder r17 = r16.getHolder();
        if (r17 == null) goto L47;
        Surface r18 = r17.getSurface();
        if (r18 == null) goto L47;
        if (r18.isValid() != true) goto L47;
        boolean r19 = true;
    L48:
        if (r19 == false) goto L49;
    L66:
        Zr();
        Kr(0);
    L47:
        r19 = false;
    L34:
        r15 = null;
    L49:
        ILivePlayerClient r20 = dr();
        if (r20 == null) goto L54;
        IRenderView r21 = r20.getRenderView();
        if (r21 == null) goto L54;
        View r22 = r21.getSelfView();
    L56:
        if ((r22 instanceof TextureView) == true) goto L58;
        r22 = null;
    L58:
        TextureView r23 = (TextureView) r22;
        if (r23 != null) goto L61;
    L63:
        boolean r24 = false;
    L64:
        if (r24 == false) goto L68;
        if (r11 == false) goto L68;
    L61:
        if (r23.isAvailable() != true) goto L63;
        r24 = true;
    L54:
        r22 = null;
    L68:
        if (Zq() == false) goto L70;
        r1 = this;
    L73:
        ILivePlayerClient r25 = dr();
        if (r25 != null) goto L76;
    L84:
        if (r1 == null) goto L90;
        if (r3 == null) goto L87;
        r3.observe(r1, new g(this, r11, r9));
    L87:
        if (r6 == null) goto L90;
        r6.observe(r1, new h(this, r11, r9));
    L90:
        if (LivePlatformPlayerManager.g().getEnableV1() == true) goto L96;
        ILivePlayerClient r26 = dr();
        if (r26 == null) goto L94;
        r26.changeRenderView(R8().getRenderView());
    L94:
        M30(s1.y(), "changeSurfaceView");
        return;
    L96:
        return;
    L76:
        if (r25.gameExtraRenderController().isEnable() == false) goto L78;
    L83:
        r9 = r8;
        goto L84
    L78:
        if (r25.extraRenderController().isGameRenderEnable() == true) goto L83;
        if (r25.multiRenderController().isEnable() == true) goto L83;
        r8 = false;
        goto L83
    L70:
        ILivePlayerClient r27 = dr();
        if (r27 == null) goto L73;
        r1 = r27.getLifecycleOwner();
        goto L73
    L24:
        r12 = null;
    L21:
        r11 = false;
    L13:
        r6 = null;
    L7:
        r3 = null;
        goto L8
    }

    public final void Or() {
        IMiddlewareLiveService r0 = TTLiveServiceMiddleware.getLiveService();
        if (r0 != null) goto L5;
    L6:
        br().a(R8());
        R8().getRenderView().setScaleType(2);
        R8().getRenderView().setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        return;
    L5:
        if (r0.shouldUseNewLivePlayerLayout() != true) goto L6;
    }

    public final void Pq() {
        View r4 = null;
        View r5 = null;
        Drawable r6 = null;
        if (Jr() == false) goto L17;
        ALogger.d(this.y, "configAfterSmooth set video background foreground gone, roomId = " + this.U2.x());
        ViewGroup r0 = ((Widget) this).containerView;
        if (r0 == null) goto L7;
        View r1 = r0.findViewById(2131392252);
    L9:
        if (Build.VERSION.SDK_INT < 23) goto L12;
        if (r1 == null) goto L35;
        r1.setForeground(null);
        return;
    L35:
        return;
    L12:
        ViewGroup r2 = ((Widget) this).containerView;
        if (r2 == null) goto L15;
        r5 = r2.findViewById(2131392253);
    L15:
        UIUtils.setViewVisibility(r5, 8);
        return;
    L7:
        r1 = null;
        goto L9
    L17:
        ALogger.d(this.y, "configAfterSmooth set video background foreground visible, roomId = " + this.U2.x());
        ViewGroup r3 = ((Widget) this).containerView;
        if (r3 == null) goto L20;
        View r7 = r3.findViewById(2131392252);
    L22:
        if (Build.VERSION.SDK_INT < 23) goto L28;
        if (r7 == null) goto L37;
        Context r8 = r7.getContext();
        if (r8 == null) goto L27;
        r6 = r8.getDrawable(2131108058);
    L27:
        r7.setForeground(r6);
        return;
    L37:
        return;
    L28:
        ViewGroup r9 = ((Widget) this).containerView;
        if (r9 == null) goto L31;
        r4 = r9.findViewById(2131392253);
    L31:
        UIUtils.setViewVisibility(r4, 0);
        if (r4 == null) goto L39;
        r4.setBackgroundResource(2131108058);
        return;
    L39:
        return;
    L20:
        r7 = null;
        goto L22
    }

    public final boolean Zq() {
        ILivePlayerClient r0 = dr();
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.enableEventHubLeakFix() != true) goto L7;
        return true;
    }

    public final ILivePlayerClient dr() {
        if (LivePlatformPlayerManager.g().getEnableV1() == false) goto L6;
        return LivePlatformPlayerManager.a(this.U2.x(), this.U2.isPseudo());
    L6:
        return R8().getClient();
    }

    public final void e9() {
        ILivePlayerClient r0 = R8().getClient();
        if (r0 == null) goto L6;
        Pair<Integer, Integer> r1 = r0.getVideoSize();
        if (r1 == null) goto L6;
    L7:
        int r2 = ((Number) r1.component1()).intValue();
        int r3 = ((Number) r1.component2()).intValue();
        if (r2 == 0) goto L12;
        if (r3 == 0) goto L13;
        M30(UIUtils.getScreenWidth(getContext()), "onPkStateChanged");
        return;
    L13:
        return;
    L12:
        return;
    L6:
        r1 = TuplesKt.to(0, 0);
        goto L7
    }

    public final Map<String, Object> getPropertyParams() {
        Map<String, Object> r0 = super/*com.bytedance.android.live.core.tetris.widgets.LiveWidget*/.getPropertyParams();
        if (r0 != null) goto L6;
        r0 = new HashMap();
    L6:
        if ((r0 instanceof HashMap) == false) goto L10;
        ds0.d r1 = this.U2;
        if (r1 == null) goto L10;
        r0.put("room_id", Long.valueOf(r1.x()));
    L10:
        return r0;
    }

    public final Pair<Integer, Integer> lr() {
        boolean r1 = false;
        CropSeiData r4 = null;
        if (wr() == false) goto L52;
        ILivePlayerClient r0 = dr();
        if (r0 == null) goto L8;
        Pair<Integer, Integer> r2 = r0.getVideoSize();
        if (r2 == null) goto L8;
    L9:
        int r6 = ((Number) r2.component1()).intValue();
        int r3 = ((Number) r2.component2()).intValue();
        if (r6 <= 0) goto L12;
        if (r3 <= 0) goto L12;
    L23:
        v9 r5 = this.n;
        if (r5 == null) goto L36;
        CropSeiData r7 = r5.f;
        if (r7 == null) goto L36;
        if (zr() == true) goto L30;
    L32:
        if (r1 == false) goto L34;
        r4 = r7;
    L34:
        if (r4 == null) goto L36;
        r6 = r4.cropW;
        r3 = r4.cropH;
        goto L36
    L30:
        if (r7.isLegalCropSei() == false) goto L32;
        r1 = true;
    L36:
        DataCenter r8 = ((Widget) this).dataCenter;
        if (r8 == null) goto L93;
        r8.put("data_video_size_pair", TuplesKt.to(Integer.valueOf(r6), Integer.valueOf(r3)));
    L93:
        return TuplesKt.to(Integer.valueOf(r6), Integer.valueOf(r3));
    L12:
        DataCenter r9 = ((Widget) this).dataCenter;
        if (r9 == null) goto L20;
        Object r10 = r9.get("data_video_size_pair");
        if (r10 != null) goto L17;
        r10 = TuplesKt.to(0, 0);
    L17:
        Pair r11 = (Pair) r10;
        if (r11 == null) goto L20;
        r6 = ((Number) r11.getFirst()).intValue();
        r3 = ((Number) r11.getSecond()).intValue();
    L20:
        if (r6 <= 0) goto L40;
        if (r3 > 0) goto L23;
    L40:
        ILivePlayerClient r12 = dr();
        if (r12 == null) goto L44;
        Pair<Integer, Integer> r13 = r12.getVideoSizeOnCreateRenderView();
        if (r13 == null) goto L44;
    L46:
        if (((Number) r13.getFirst()).intValue() == 0) goto L51;
        if (((Number) r13.getSecond()).intValue() == 0) goto L51;
        return r13;
    L51:
        return TuplesKt.to(0, 0);
    L44:
        r13 = TuplesKt.to(0, 0);
    L8:
        r2 = TuplesKt.to(0, 0);
        goto L9
    L52:
        ILivePlayerClient r14 = dr();
        if (r14 == null) goto L92;
        Pair<Integer, Integer> r15 = r14.getVideoSize();
        if (r15 == null) goto L92;
        int r16 = ((Number) r15.component1()).intValue();
        int r17 = ((Number) r15.component2()).intValue();
        if (r16 <= 0) goto L60;
        if (r17 <= 0) goto L60;
    L71:
        v9 r18 = this.n;
        if (r18 == null) goto L84;
        CropSeiData r19 = r18.f;
        if (r19 == null) goto L84;
        if (zr() == true) goto L78;
    L80:
        if (r1 == false) goto L82;
        r4 = r19;
    L82:
        if (r4 == null) goto L84;
        r16 = r4.cropW;
        r17 = r4.cropH;
        goto L84
    L78:
        if (r19.isLegalCropSei() == false) goto L80;
        r1 = true;
    L84:
        DataCenter r20 = ((Widget) this).dataCenter;
        if (r20 == null) goto L88;
        r20.put("data_video_size_pair", TuplesKt.to(Integer.valueOf(r16), Integer.valueOf(r17)));
    L88:
        return TuplesKt.to(Integer.valueOf(r16), Integer.valueOf(r17));
    L60:
        DataCenter r21 = ((Widget) this).dataCenter;
        if (r21 == null) goto L68;
        Object r22 = r21.get("data_video_size_pair");
        if (r22 != null) goto L65;
        r22 = TuplesKt.to(0, 0);
    L65:
        Pair r23 = (Pair) r22;
        if (r23 == null) goto L68;
        r16 = ((Number) r23.getFirst()).intValue();
        r17 = ((Number) r23.getSecond()).intValue();
    L68:
        if (r16 <= 0) goto L90;
        if (r17 > 0) goto L71;
    L90:
        return TuplesKt.to(0, 0);
    L92:
        return TuplesKt.to(0, 0);
    }

    public final LiveVrEffectInfo nr() {
        ILivePlayerClient r0 = dr();
        if (r0 == null) goto L7;
        LiveVrEffectInfo r1 = r0.getVrEffectManagerVrEffectInfoCopy();
        if (r1 == null) goto L7;
        return r1;
    L7:
        return new LiveVrEffectInfo(0, null, 0, null, null, null, null, false, false, null, null, 2047, null);
    }

    public final void onPause() {
        super/*com.bytedance.android.live.core.tetris.widgets.LiveWidget*/.onPause();
        Er("onPause");
        e6.a("LivePlayerWidget: onPause");
        ILivePlayerClient r0 = dr();
        if (r0 == null) goto L6;
        String r1 = r0.getCurrentResolution();
        if (r1 == null) goto L6;
    L7:
        this.k = r1;
        IRoomEventHub r2 = this.U2.n();
        if (r2 == null) goto L12;
        MutableLiveData r3 = r2.getStopped();
        if (r3 == null) goto L12;
        Boolean r4 = (Boolean) r3.getValue();
    L13:
        Boolean r5 = Boolean.TRUE;
        boolean r6 = true;
        if (Intrinsics.areEqual(r4, r5) == false) goto L24;
        IRoomContextService r7 = jc1.k.f(IRoomContextService.class);
        if (r7 == null) goto L22;
        com.bytedance.android.livesdk.chatroom.o r8 = IRoomContextService.a.a(r7, null, 0, 3);
        if (r8 == null) goto L22;
        if (r8.isVSFirstShow() != true) goto L22;
    L23:
        boolean r9 = true;
    L25:
        this.S1 = r9;
        if ((!Intrinsics.areEqual((Boolean) this.U2.e().getEndRoom().getValue(), r5)) == false) goto L97;
        LiveMode r10 = this.U2.getStreamType();
        int r11 = com.bytedance.android.live.platformplayer.utils.a.a;
        Intrinsics.checkNotNullParameter(r10, "liveMode");
        ag r12 = ag.a;
        if (((com.bytedance.android.livesdk.model.m) r12.getValue()).c() == true) goto L30;
    L34:
        boolean r13 = false;
    L36:
        if (((com.bytedance.android.livesdk.model.m) r12.getValue()).a() == false) goto L46;
        if (r13 == false) goto L44;
        IMiddlewareHostAction r14 = jc1.k.f(IMiddlewareHostAction.class);
        if (r14 == null) goto L41;
        boolean r15 = r14.isInTimingClosed();
    L42:
        if (r15 == true) goto L44;
        r13 = true;
        goto L46
    L41:
        r15 = false;
    L44:
        r13 = false;
    L46:
        if (r13 == false) goto L63;
        IFloatWindowService r16 = jr(IFloatWindowService.class);
        Intrinsics.checkNotNull(r16);
        if (r16.isFloatWindowOpen(s1.getContext()) == true) goto L55;
        IFloatWindowService r17 = jc1.k.f(IFloatWindowService.class);
        if (r17 != null) goto L52;
    L54:
        boolean r18 = false;
    L56:
        if (r18 == true) goto L63;
        Integer r19 = (Integer) ((ge1.a) hd0.c.f()).b;
        if (r19 != null) goto L61;
    L62:
        this.F2.sendMessageDelayed(this.F2.obtainMessage(38), ((com.bytedance.android.livesdk.model.m) r12.getValue()).b() * 60000);
        com.bytedance.android.live.platformplayer.utils.a.a("pause sendMessage BACKGROUND_TIMEOUT " + (((com.bytedance.android.livesdk.model.m) r12.getValue()).b() * 60000));
        goto L63
    L61:
        if (r19.intValue() == 2) goto L63;
    L52:
        if (r17.isPipModeOpen() != true) goto L54;
    L55:
        r18 = true;
    L63:
        ILivePlayerClient r20 = dr();
        if (r20 == null) goto L94;
        LiveMode r21 = this.U2.getStreamType();
        Intrinsics.checkNotNullParameter(r21, "liveMode");
        if (LiveBgPlayUtil.a().a() == true) goto L68;
    L70:
        boolean r22 = false;
    L71:
        if (r22 == false) goto L76;
        if (r21 != LiveMode.AUDIO) goto L83;
    L84:
        boolean r23 = false;
    L85:
        if (r23 == false) goto L92;
        Integer r24 = (Integer) ((ge1.a) hd0.c.f()).b;
        if (r24 != null) goto L90;
    L93:
        r20.setEnableBackgroundStop(r6);
        goto L94
    L90:
        if (r24.intValue() != 2) goto L93;
    L92:
        r6 = false;
    L83:
        r23 = true;
        goto L85
    L76:
        if (((com.bytedance.android.livesdk.model.m) r12.getValue()).c() == false) goto L84;
        if (r21 == LiveMode.AUDIO) goto L84;
        Context r25 = s1.getContext();
        int r26 = ita.i.a;
        if (NetworkUtils.isWifi(r25) == true) goto L84;
        if (TTMiddlewareLiveSDK.hostMiddlewareService().config().appConfig().isFreeFlow() == true) goto L84;
    L68:
        if (LiveBgPlayUtil.b == true) goto L70;
        r22 = true;
    L94:
        ILivePlayerClient r27 = dr();
        if (r27 == null) goto L97;
        r27.onBackground();
        goto L97
    L30:
        if (((com.bytedance.android.livesdk.model.m) r12.getValue()).b() <= 0) goto L34;
        if (r10 == LiveMode.AUDIO) goto L34;
        r13 = true;
    L97:
        ILivePlayerClient r28 = dr();
        if (r28 == null) goto L101;
        r28.unRegisterMuteAudioCheck(this.b1);
        return;
    L101:
        return;
    L22:
        if (((Boolean) id1.a.getValue()).booleanValue() == true) goto L23;
    L24:
        r9 = false;
    L12:
        r4 = null;
    L6:
        r1 = "origin";
        goto L7
    }

    public final void onResume() {
        super/*com.bytedance.android.live.core.tetris.widgets.LiveWidget*/.onResume();
        if (((com.bytedance.android.live.platformplayer.b) ar().invoke()).isUserVisible() == true) goto L5;
        return;
    L5:
        ILivePlayerClient r0 = dr();
        if (r0 != null) goto L8;
    L24:
        ILivePlayerClient r1 = R8().getClient();
        if (r1 == null) goto L29;
        LivePlayerClientContext r2 = r1.context();
        if (r2 == null) goto L29;
        Boolean r3 = Boolean.valueOf(r2.isSharedClient());
    L30:
        this.F2.removeMessages(38);
        com.bytedance.android.live.platformplayer.utils.a.a("resume remove MSG_WHAT_BACKGROUND_STATUE_TIMER");
        Er("onResume, is sharePlayer: " + r3);
        e6.a("LivePlayerWidget: onResume");
        IFloatWindowService r4 = jr(IFloatWindowService.class);
        Intrinsics.checkNotNull(r4);
        r4.hideFloatWindow();
        Boolean r5 = (Boolean) this.U2.e().getShowLiveEnd().getValue();
        Boolean r6 = Boolean.TRUE;
        if (Intrinsics.areEqual(r5, r6) == false) goto L35;
        ALogger.d("ttlive_room", "Room is end when resume roomId=" + this.U2.x() + ", userId=" + this.U2.getUserId() + ", mAutoStartWhenResume=" + this.U2.getAutoStartWhenResume());
        return;
    L35:
        if (Intrinsics.areEqual(r3, r6) == false) goto L39;
        ILivePlayerClient r7 = dr();
        if (r7 == null) goto L39;
        r7.updateDisplayMode(DisplayMode.INNER);
    L39:
        IFloatWindowService r8 = jr(IFloatWindowService.class);
        if (r8 == null) goto L42;
        boolean r9 = r8.isInnerFloatPlay();
    L43:
        if (r9 == true) goto L51;
        AbsLivePlayerView r10 = R8();
        if ((r10 instanceof LivePlayerView) == true) goto L47;
        r10 = null;
    L47:
        LivePlayerView r11 = (LivePlayerView) r10;
        if (r11 == null) goto L51;
        LivePlayerView.resumePlay$default(r11, null, 1, null);
    L51:
        if (this.U2.getLiveIllegal() == true) goto L67;
        IRoomContextService r12 = jc1.k.f(IRoomContextService.class);
        if (r12 == null) goto L57;
        com.bytedance.android.livesdk.chatroom.o r13 = IRoomContextService.a.a(r12, null, 0, 3);
        if (r13 == null) goto L57;
        Boolean r14 = r13.P2();
    L59:
        if ((!Intrinsics.areEqual(r14, Boolean.FALSE)) == false) goto L67;
        ILivePlayerClient r15 = dr();
        if (r15 == null) goto L63;
        r15.unmute("LivePlayerWidget.onResume");
    L63:
        ILivePlayerClient r16 = dr();
        if (r16 == null) goto L67;
        r16.onForeground();
    L57:
        r14 = null;
    L67:
        if (er().getLivePlayerWidgetResumeFix() == false) goto L73;
        ILivePlayerClient r17 = dr();
        if (r17 == null) goto L73;
        if (r17.isPlaying() == true) goto L73;
        this.U2.e().getStartPull().setValue(Boolean.FALSE);
    L73:
        StringBuilder r18 = new StringBuilder("onResume startPull：");
        r18.append((Boolean) this.U2.e().getStartPull().getValue());
        r18.append("，isPlaying：");
        ILivePlayerClient r19 = dr();
        if (r19 == null) goto L76;
        Boolean r110 = Boolean.valueOf(r19.isPlaying());
    L77:
        r18.append(r110);
        r18.append("，isPausedBeforeBackground：");
        r18.append(this.S1);
        r18.append("isInnerFloatPlay：");
        r18.append(r9);
        ALogger.i("LivePlayer", r18.toString());
        Boolean r20 = (Boolean) this.U2.e().getStartPull().getValue();
        Boolean r111 = Boolean.FALSE;
        if (Intrinsics.areEqual(r20, r111) == false) goto L87;
        ILivePlayerClient r21 = dr();
        if (r21 == null) goto L87;
        if (r21.isPlaying() == true) goto L87;
        if (this.S1 == true) goto L87;
        if (r9 == true) goto L87;
        Rz(false);
    L87:
        IMiddlewareLiveService r22 = TTLiveServiceMiddleware.getLiveService();
        if (r22 == null) goto L118;
        LiveInnerIndependentManager r23 = r22.getLiveInnerIndependentManage();
        if (r23 == null) goto L118;
        if (r23.a() != true) goto L118;
        if (this.U == false) goto L104;
        IMiddlewareLiveService r24 = TTLiveServiceMiddleware.getLiveService();
        if (r24 == null) goto L100;
        LiveInnerIndependentManager r25 = r24.getLiveInnerIndependentManage();
        if (r25 == null) goto L100;
        r25.d("LivePlayer", "postResumeStream isPauseFromIndependent start message");
    L100:
        vlc.d r26 = this.G2;
        if (r26 == null) goto L103;
        r26.startMessage();
    L103:
        this.U = false;
    L104:
        l1 r27 = this.F2;
        d0 r112 = new d0(this, r9);
        IMiddlewareLiveService r28 = TTLiveServiceMiddleware.getLiveService();
        if (r28 != null) goto L107;
    L109:
        LiveIndependentConfig r29 = null;
    L111:
        if ((r29 instanceof LiveIndependentConfig) == true) goto L113;
        r29 = null;
    L113:
        if (r29 == null) goto L115;
        long r113 = r29.getDelayTime();
    L116:
        r27.postDelayed(r112, r113);
        goto L118
    L115:
        r113 = 0;
        goto L116
    L107:
        if (r28.getLiveInnerDependentTaskHelper() == null) goto L109;
        r29 = (LiveIndependentConfig) LiveInnerIndependentHelper.a.getValue();
    L118:
        if (this.U2.getAutoStartWhenResume() == false) goto L138;
        IRoomContextService r30 = jc1.k.f(IRoomContextService.class);
        if (r30 == null) goto L126;
        com.bytedance.android.livesdk.chatroom.o r31 = IRoomContextService.a.a(r30, null, 0, 3);
        if (r31 == null) goto L126;
        if (r31.isVSFirstShow() != true) goto L126;
    L128:
        if (this.S1 == true) goto L138;
    L129:
        vlc.d r32 = this.G2;
        if (r32 == null) goto L132;
        r32.startMessage();
    L132:
        this.U2.e().getEndRoom().setValue(r111);
        this.U2.setAutoStartWhenResume(false);
        if (this.U2.getCurState() != LiveRoomState.PREPARED) goto L138;
        Er("onResume autoStartWhenResume startPullStream()");
        is2.d r33 = (is2.d) gr().invoke();
        if (r33 == null) goto L138;
        r33.startPullStreamV2("on_resume", false);
    L126:
        if (((Boolean) id1.a.getValue()).booleanValue() == false) goto L129;
    L138:
        if (Intrinsics.areEqual(r3, r6) == true) goto L140;
    L166:
        ILivePlayerClient r34 = dr();
        if (r34 == null) goto L170;
        r34.registerMuteAudioCheck(this.b1);
        return;
    L170:
        return;
    L140:
        if ((!Intrinsics.areEqual(this.k, "")) == false) goto L166;
        String r35 = this.k;
        int r36 = ((PlayerInnerDrawerConfig) y6.a.getValue()).getOptShareOuterFloatWindowResolutionStrategy();
        ILivePlayerClient r37 = R8().getClient();
        if (r37 == null) goto L144;
        String r38 = r37.getCurrentResolution();
    L146:
        if ((!Intrinsics.areEqual(r38, r35)) == false) goto L165;
        ILivePlayerClient r39 = R8().getClient();
        if (r39 == null) goto L150;
        State r40 = r39.getCurrentState();
    L152:
        if ((r40 instanceof State.Playing) == false) goto L165;
        if (r36 == 0) goto L160;
        if (r36 != 1) goto L166;
        Er("[onResume]resolution is not same, need change to " + r35 + ", strategy: smooth");
        ILivePlayerClient r41 = R8().getClient();
        if (r41 == null) goto L166;
        r41.smoothSwitchResolution(r35, 2, true);
        goto L166
    L160:
        Er("[onResume]resolution is not same, need change to " + r35 + ", strategy: normal");
        AbsLivePlayerView r42 = R8();
        if (r42 == null) goto L166;
        ILivePlayerClient r43 = r42.getClient();
        if (r43 == null) goto L166;
        r43.switchResolution(r35, "share_player_resume", null);
        goto L166
    L150:
        r40 = null;
    L165:
        Er("[onResume]need not change resolution");
        goto L166
    L144:
        r38 = null;
        goto L146
    L76:
        r110 = null;
        goto L77
    L42:
        r9 = false;
    L29:
        r3 = null;
        goto L30
    L8:
        if ((!Intrinsics.areEqual(r0, R8().getClient())) == false) goto L24;
        ILivePlayerClient r44 = R8().getClient();
        if (r44 == null) goto L12;
        State r45 = r44.getCurrentState();
    L14:
        if (Intrinsics.areEqual(r45, State.Released.INSTANCE) == false) goto L24;
        if (((PlayerInnerDrawerConfig) y6.a.getValue()).getFixPlayerViewClientAbnormal() == false) goto L24;
        AbsLivePlayerView r46 = R8();
        if ((r46 instanceof LivePlayerView) == true) goto L20;
        r46 = null;
    L20:
        LivePlayerView r47 = (LivePlayerView) r46;
        if (r47 == null) goto L23;
        r47.updateClient(r0);
    L23:
        Er("fix playerView PlayerClient abnormal");
        goto L24
    L12:
        r45 = null;
        goto L14
    }

    public final void onRoomBackgroundV2() {
        ILivePlayerClient r0 = dr();
        if (r0 == null) goto L6;
        r0.onRoomBackgroundV2();
        return;
    }

    public final boolean tr() {
        Room r0 = bs();
        if (r0 == null) goto L7;
        if (r0.isLiveTypeAudio() != true) goto L7;
    L9:
        if (Nq() == false) goto L13;
    L11:
        return false;
    L13:
        return true;
    L7:
        if (this.U2.getStreamType() != LiveMode.AUDIO) goto L11;
        goto L11
    }

    public final boolean ur() {
        if (FoldScreenUtils.f() == true) goto L5;
    L7:
        return false;
    L5:
        if (FoldScreenUtils.b(((Widget) this).context, this.z) != 0) goto L7;
        return true;
    }

    public final boolean wr() {
        ILivePlayerClient r0 = dr();
        if (r0 == null) goto L7;
        LivePlayerClientContext r1 = r0.context();
        if (r1 == null) goto L7;
        ILivePlayerScene r2 = r1.getUseScene();
    L9:
        if (Intrinsics.areEqual(r2, LivePlayerScene.INSTANCE.getLIVE_DETAIL_ROOM()) == false) goto L12;
        return true;
    L12:
        return false;
    L7:
        r2 = null;
        goto L9
    }

    public final boolean yr() {
        AbsLivePlayerView r0 = R8();
        ILivePlayerScene r2 = null;
        if ((r0 instanceof LivePlayerView) == true) goto L5;
        r0 = null;
    L5:
        LivePlayerView r1 = (LivePlayerView) r0;
        if (r1 == null) goto L10;
        LivePlayerConfig r3 = r1.getConfig();
        if (r3 == null) goto L10;
        ILivePlayerScene r4 = r3.getScene();
    L11:
        ILivePlayerClient r5 = dr();
        if (r5 == null) goto L17;
        LivePlayerClientContext r6 = r5.context();
        if (r6 == null) goto L17;
        r2 = r6.getUseScene();
    L17:
        return Intrinsics.areEqual(r4, r2);
    L10:
        r4 = null;
        goto L11
    }

    @Override // gs0.c
    public final boolean BE() {
        return this.H1;
    }

    @Override // gs0.c
    public final boolean cn() {
        return this.k1;
    }

    @Override // gs0.c
    public final boolean isInteracting() {
        return this.K;
    }

    @Override // gs0.c
    public final com.bytedance.android.live.platformplayer.layout.c ly() {
        return this.L0;
    }

    public LivePlayerWidget(RoomSession r3) {
        Intrinsics.checkNotNullParameter(r3, "session");
        this.U2 = r3;
        this.k = "";
        this.l = true;
        this.m = LazyKt.lazy(LivePlayerWidget$notWaitingForRoom$2.INSTANCE);
        this.o = (Boolean) o3.a.getValue();
        this.q = (Boolean) jv0.a.getValue();
        this.r = new com.bytedance.android.live.platformplayer.utils.g();
        this.s = new d8(this);
        this.u = new l6(new LivePlayerWidget$gameUIHelper$1(this));
        this.v = true;
        this.w = true;
        this.y = "live_background[" + hashCode() + ']';
        this.A = LazyKt.lazy(LivePlayerWidget$vrDegradeToastTotalNum$2.INSTANCE);
        this.B = LazyKt.lazy(LivePlayerWidget$vrDegradeToastLastTimestamp$2.INSTANCE);
        this.C = LazyKt.lazy(LivePlayerWidget$vrEffectPkToastLastTimestamp$2.INSTANCE);
        this.H = new com.bytedance.android.live.platformplayer.layout.s(this);
        System.currentTimeMillis();
        this.J = LazyKt.lazy(LivePlayerWidget$playerInnerDrawConfig$2.INSTANCE);
        this.M = new com.bytedance.android.livesdk.chatroom.utils.i1();
        this.N = LazyKt.lazy(LivePlayerWidget$seiPlayerJsonOptimizeEnable$2.INSTANCE);
        this.S = LazyKt.lazy(LivePlayerWidget$vsResetVideoBottom$2.INSTANCE);
        this.T = true;
        this.V = LazyKt.lazy(LivePlayerWidget$enableCancelMonitor$2.INSTANCE);
        this.X = LazyKt.lazy(LivePlayerWidget$seiFirstFixAcc$2.INSTANCE);
        this.Y = LazyKt.lazy(new LivePlayerWidget$subCameraStateHandler$2(this));
        this.Z = LazyKt.lazy(LivePlayerWidget$displayRatioConfig$2.INSTANCE);
        this.k0 = new b0(this);
        this.b1 = new b(new WeakReference(this));
        this.g1 = new com.bytedance.android.live.platformplayer.layout.r(this);
        this.h1 = -1;
        this.L1 = bg1.b();
        this.T1 = LazyKt.lazy(LivePlayerWidget$pkHandler$2.INSTANCE);
        this.V1 = LazyKt.lazy(new LivePlayerWidget$multiHandler$2(this));
        this.b2 = LazyKt.lazy(new LivePlayerWidget$revStreamLayoutBiz$2(this));
        this.p2 = LazyKt.lazy(new LivePlayerWidget$extraViewShowObserver$2(this));
        this.F2 = new l1(this, Looper.getMainLooper());
        this.H2 = new j1(this);
        this.J2 = new c0(this);
        this.K2 = com.bytedance.android.live.platformplayer.layout.h.a;
        this.L2 = new k1(this);
        this.M2 = new i1(this);
        this.O2 = LazyKt.lazy(new LivePlayerWidget$customLifecycleOwner$2(this));
        this.P2 = new a1(this);
        this.Q2 = new b1(this);
        this.S2 = new com.bytedance.android.live.platformplayer.layout.i(this);
        this.T2 = new com.bytedance.android.live.platformplayer.layout.m(this);
    }

    public static IService jr(Class r2) {
        if (Intrinsics.areEqual((Boolean) LiveInfraSettingKeys.LIVE_FIX_USE_GET_SERVICE.getValue(), Boolean.TRUE) == false) goto L6;
        return jc1.k.f(r2);
    L6:
        return jc1.k.g(r2, true);
    }

    public static final /* synthetic */ boolean wq(LivePlayerWidget r0) {
        return ((LiveWidget) r0).isAppBackground;
    }

    @Override // gs0.c
    public final void Ap(String r8) {
        Intrinsics.checkNotNullParameter(r8, "source");
        Er("pauseStream, source:" + r8);
        DataCenter r1 = ((Widget) this).dataCenter;
        if (r1 == null) goto L9;
        ListenLiveStatus r2 = (ListenLiveStatus) r1.get("cmd_change_listen_live_status", null);
        if (r2 == null) goto L9;
        if (r2.isOpen() != true) goto L9;
        boolean r3 = true;
    L10:
        IFloatWindowService r5 = jr(IFloatWindowService.class);
        if (r5 != null) goto L13;
    L21:
        ILivePlayerClient r4 = dr();
        if (r4 == null) goto L24;
        r4.stop();
    L24:
        this.F2.post(o.a);
        IMiddlewareLiveService r6 = TTLiveServiceMiddleware.getLiveService();
        if (r6 == null) goto L44;
        LiveInnerIndependentManager r7 = r6.getLiveInnerIndependentManage();
        if (r7 == null) goto L45;
        LiveInnerIndependentManager r9 = r7;
        Intrinsics.checkNotNullParameter(r8, "source");
        if (r9.a() == true) goto L31;
        boolean r0 = false;
    L32:
        if (r0 != true) goto L46;
        DataCenter r10 = this.U2.getDataCenter();
        if (r10 == null) goto L47;
        vlc.d r11 = (vlc.d) r10.get("data_message_manager", null);
        if (r11 == null) goto L48;
        r11.r(false);
        IMiddlewareLiveService r12 = TTLiveServiceMiddleware.getLiveService();
        if (r12 == null) goto L42;
        LiveInnerIndependentManager r13 = r12.getLiveInnerIndependentManage();
        if (r13 == null) goto L42;
        r13.d("LivePlayer", "pauseStream source: ".concat(r8));
    L42:
        this.U = true;
        return;
    L48:
        return;
    L47:
        return;
    L46:
        return;
    L31:
        r0 = StringsKt.startsWith$default(r8, "IndependentTask", false, 2, null);
        r9.d("LiveInnerIndependentTaskManager", "isFromIndependentPause isIndependentTask:" + r0);
        goto L32
    L45:
        return;
    L44:
        return;
    L13:
        if (r5.useSharePlayer() != true) goto L21;
        if (r3 == true) goto L21;
        AbsLivePlayerView r14 = R8();
        if ((r14 instanceof LivePlayerView) == true) goto L18;
        r14 = null;
    L18:
        LivePlayerView r15 = (LivePlayerView) r14;
        if (r15 == null) goto L24;
        r15.stop();
    L9:
        r3 = false;
        goto L10
    }

    public final void Cq(IRenderView r4) {
        if (LivePlatformPlayerManager.g().getEnableV1() == true) goto L19;
        Er("addRenderViewToCurPlayerView " + r4);
        ViewParent r0 = r4.getParent();
        if ((r0 instanceof ViewGroup) == true) goto L8;
        r0 = null;
    L8:
        ViewGroup r1 = (ViewGroup) r0;
        if (r1 == null) goto L11;
        r1.removeView(r4.getSelfView());
    L11:
        r4.setLayoutParams(R8().getRenderView().getLayoutParams());
        R8().removeView(R8().getRenderView().getSelfView());
        R8().addView(r4.getSelfView());
        R8().setRenderView(r4);
        ILivePlayerStatusController r2 = R8().getLiveStatusController();
        if (r2 == null) goto L17;
        View r3 = r2.getCurrentStatusView();
        if (r3 == null) goto L18;
        ViewGroup.LayoutParams r5 = r3.getLayoutParams();
        r5.width = r4.getLayoutParams().width;
        r5.height = r4.getLayoutParams().height;
        r3.setLayoutParams(r5);
        return;
    L18:
        return;
    L17:
        return;
    }

    @Override // gs0.c
    public final void E(cy0.a r2) {
        Intrinsics.checkNotNullParameter(r2, "scope");
        if ((r2 instanceof cy0.a) == false) goto L6;
        this.V0 = r2;
        return;
    }

    public final void Er(String r4) {
        ILivePlayerClient r0 = dr();
        if (r0 == null) goto L8;
        IPlayerLogger r1 = r0.logger();
        if (r1 == null) goto L9;
        ILivePlayerSpmLogger.DefaultImpls.logPlayerWidget$default(r1, r4, null, 2, null);
        return;
    L9:
        return;
    }

    @Override // gs0.c
    public final void HI(boolean r1) {
        this.v1 = r1;
    }

    public final boolean Hr(boolean r6) {
        String r0 = this.L;
        if (r0 != null) goto L6;
        return false;
    L6:
        if (StringsKt.contains$default(r0, "\\\"ver\\\":6", false, 2, null) == true) goto L10;
        if (StringsKt.contains$default(r0, "\\\"ver\\\":19", false, 2, null) == true) goto L10;
        return false;
    L10:
        if (br().g(this.U2.getStreamType(), r6) == false) goto L14;
        return true;
    L14:
        return false;
    }

    public final boolean Ir(boolean r17) {
        Context r2 = ((Widget) this).context;
        if (r2 != null) goto L5;
        return false;
    L5:
        String r3 = this.L;
        if (r3 != null) goto L8;
        return false;
    L8:
        int r11 = StringsKt.indexOf$default(r3, "app_data", 0, false, 6, null);
        if (r11 >= 0) goto L11;
        return false;
    L11:
        int r1 = StringsKt.indexOf$default(r3, "ver", r11, false, 4, null);
        if (r1 >= 0) goto L14;
        return false;
    L14:
        int r4 = r3.length();
        long r5 = 0;
        if (r1 < 0) goto L25;
    L17:
        if (r1 >= r4) goto L21;
        if (Character.isDigit(r3.charAt(r1)) == true) goto L21;
        r1 = r1 + 1;
    L21:
        if (r1 >= r4) goto L25;
        if (Character.isDigit(r3.charAt(r1)) == false) goto L25;
        r5 = (r5 * ((long) 10)) + ((long) (r3.charAt(r1) - '0'));
        r1 = r1 + 1;
    L25:
        Pair<Integer, Integer> r6 = lr();
        int r7 = ((Number) r6.component1()).intValue();
        int r8 = ((Number) r6.component2()).intValue();
        if (r17 == true) goto L29;
        r7 = r8;
        r8 = r7;
    L29:
        if (r5 == 2) goto L31;
        return false;
    L31:
        if (cr().f(r2, r3, this.U2.getStreamType(), r17, com.bytedance.android.live.core.utils.a0.o(((Widget) this).dataCenter), TuplesKt.to(Integer.valueOf(r7), Integer.valueOf(r8))) == false) goto L40;
        return true;
    L40:
        return false;
    }

    public final void Kr(final int r6) {
        if (this.x2 == false) goto L5;
        return;
    L5:
        if (this.U2.isSmoothEnterDoubleRender() == true) goto L9;
        if (this.U2.isLiveHeadEnterSmooth() == true) goto L9;
        return;
    L9:
        if (r6 == 1) goto L11;
    L23:
        is(r6);
        return;
    L11:
        if (this.U2.isLiveHeadEnterSmooth() == false) goto L23;
        ILivePlayerClient r1 = dr();
        if (r1 != null) goto L15;
    L19:
        ALogger.i("SmoothDoubleRender", "live head force rendered no first frame");
        ILivePlayerClient r0 = dr();
        if (r0 == null) goto L22;
        r0.setSurfaceControl(null);
    L22:
        is(r6);
        return;
    L15:
        if (r1.getHasFirstFrame() != true) goto L19;
        final long r2 = System.currentTimeMillis();
        ILivePlayerClient r3 = dr();
        if (r3 == null) goto L27;
        r3.saveFrameV2(true, new LivePlayerWidget$newSurfaceRendered$1(this, r2, r6));
        return;
    }

    @Override // gs0.c
    public final void Mu(AbsLivePlayerView r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.c = r2;
    }

    @Override // gs0.c
    public final void Rl(com.bytedance.android.live.room.h r1) {
        this.a = r1;
    }

    public final boolean Rq(Integer r3) {
        if (r3 != null) goto L8;
        if (e5.m(this.U2.getScreenOrientation()) == false) goto L12;
    L10:
        return false;
    L12:
        return true;
    L8:
        if (e5.o(r3.intValue()) == true) goto L10;
        return true;
    }

    @Override // gs0.c
    public final void Rz(boolean r7) {
        Er("resumeStream  isBackground : " + r7);
        boolean r1 = false;
        if (this.K == false) goto L5;
        LiveSlardarMonitor.monitorStatus("ttlive_interact_event_api_all", 0, MapsKt.mapOf(TuplesKt.to("event", "resumeWhenInteract")));
        ALogger.w("ttlive_link", "room player resume", new IllegalStateException());
    L5:
        ILivePlayerClient r0 = dr();
        if (r0 == null) goto L12;
        IRoomEventHub r2 = r0.getEventHub();
        if (r2 == null) goto L12;
        MutableLiveData r3 = r2.getAfterCdnDisasterToleranceStreamDataString();
        if (r3 == null) goto L12;
        String r4 = (String) r3.getValue();
    L14:
        if (TextUtils.isEmpty(r4) == true) goto L25;
        ds0.d r5 = this.U2;
        ILivePlayerClient r6 = dr();
        if (r6 == null) goto L22;
        IRoomEventHub r8 = r6.getEventHub();
        if (r8 == null) goto L22;
        MutableLiveData r9 = r8.getAfterCdnDisasterToleranceStreamDataString();
        if (r9 == null) goto L22;
        String r10 = (String) r9.getValue();
    L23:
        r5.setDefaultMultiPullStreamData(r10);
    L22:
        r10 = null;
    L25:
        if (com.bytedance.android.live.core.utils.a0.k(((Widget) this).dataCenter) == false) goto L37;
        IVSPlayerService r11 = jc1.k.f(IVSPlayerService.class);
        if (r11 == null) goto L37;
        IPlayerProgressService r12 = r11.provideVSProgressService(((Widget) this).dataCenter);
        if (r12 == null) goto L37;
        PlayerProgressServiceContext r13 = r12.provideContext(((Widget) this).dataCenter);
        if (r13 == null) goto L37;
        com.bytedance.live.datacontext.m r14 = r13.getVsRoomEnableSeek();
        if (r14 == null) goto L37;
        if (((Boolean) r14.getValue()).booleanValue() != true) goto L37;
        boolean r15 = true;
    L38:
        IVisibilityControlBrickService r16 = jc1.k.f(IVisibilityControlBrickService.class);
        if (r16 == null) goto L46;
        IVisibilityControlService r17 = r16.provideVisibilityControlService(((Widget) this).dataCenter);
        if (r17 == null) goto L46;
        LiveVisibilityControlContext r18 = r17.provideContext();
        if (r18 == null) goto L46;
        if (r18.enablePlayBackAbility() != true) goto L46;
    L47:
        rk1.a r19 = jc1.k.f(rk1.a.class);
        if (r19 == null) goto L54;
        IPlayerProgressService r20 = r19.M4(((Widget) this).dataCenter);
        if (r20 == null) goto L54;
        if (r20.isAtLatest() == true) goto L54;
        r20.setAtLatest(true);
    L54:
        is2.d r21 = (is2.d) gr().invoke();
        if (r21 == null) goto L57;
        r21.startPullStreamV2("resume_stream", r7);
    L57:
        ListenLiveStatus r22 = (ListenLiveStatus) ((Widget) this).dataCenter.get("cmd_change_listen_live_status", null);
        if (r22 != null) goto L60;
    L62:
        if (r1 == true) goto L70;
        AbsLivePlayerView r23 = R8();
        if ((r23 instanceof LivePlayerView) == true) goto L66;
        r23 = null;
    L66:
        LivePlayerView r24 = (LivePlayerView) r23;
        if (r24 == null) goto L71;
        LivePlayerView.resumePlay$default(r24, null, 1, null);
        return;
    L71:
        return;
    L70:
        return;
    L60:
        if (r22.isOpen() != true) goto L62;
        r1 = true;
    L46:
        if (r15 == false) goto L54;
    L37:
        r15 = false;
    L12:
        r4 = null;
        goto L14
    }

    public final void Sr(boolean r5) {
        if (r5 == false) goto L4;
    L12:
        ((Widget) this).dataCenter.put("cmd_vr_stream_enable", Boolean.valueOf(r5));
        IRoomContextService r6 = jc1.k.f(IRoomContextService.class);
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.m r0 = null;
        if (r6 == null) goto L19;
        com.bytedance.android.livesdk.chatroom.o r7 = IRoomContextService.a.a(r6, null, 0, 3);
        if (r7 == null) goto L19;
        com.bytedance.live.datacontext.j r8 = r7.getCompactTbLoader();
        if (r8 == null) goto L19;
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.m r9 = (com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.m) r8.getValue();
    L21:
        if ((r9 instanceof com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.m) == false) goto L24;
        r0 = r9;
    L24:
        if (r0 == null) goto L27;
        r0.refreshExistComponent(NewToolbarButtonConstants.ToolbarVR.INSTANCE.getId());
        return;
    L27:
        return;
    L19:
        r9 = null;
        goto L21
    L4:
        if (VrUtils.t(((Widget) this).dataCenter, false) == false) goto L9;
        IVrContextService r1 = jr(IVrContextService.class);
        if (r1 == null) goto L8;
        r1.dismissLandscapeControlDialog();
    L8:
        xs2.b.a().post(new HorizontalPlayEvent(1, 0));
    L9:
        IVrContextService r2 = jr(IVrContextService.class);
        if (r2 == null) goto L12;
        r2.exitVrMode();
        goto L12
    }

    @Override // gs0.c
    public final void Tk(cs0.a r4) {
        Intrinsics.checkNotNullParameter(r4, "event");
        if (this.U2.getCurState() == LiveRoomState.LIVE_STARTED) goto L5;
        return;
    L5:
        HashMap r0 = new HashMap();
        if (this.U2.w() == null) goto L8;
        com.bytedance.android.livesdk.log.j0.l().c(IRoom.class).u(r0, this.U2.w());
    L9:
        com.bytedance.android.livesdk.log.j0.l().c(am2.x.class).a(r0);
        ILivePlayerClient r1 = dr();
        if (r1 == null) goto L13;
        r1.switchResolution(r4.a, r4.b, r0);
        return;
    L13:
        return;
    L8:
        com.bytedance.android.livesdk.log.j0.l().c(IRoom.class).a(r0);
        goto L9
    }

    @Override // gs0.c
    public final void Xk(String r5) {
        Intrinsics.checkNotNullParameter(r5, "reason");
        if (this.U2.isMediaRoomEnding() == false) goto L5;
        return;
    L5:
        Room r0 = bs();
        if (r0 == null) goto L10;
        if (r0.isLiveTypeAudio() != true) goto L10;
    L11:
        boolean r1 = true;
    L13:
        if (r1 == false) goto L18;
        if (this.U2.r == false) goto L18;
        return;
    L18:
        if (Nq() == false) goto L23;
        if (this.U2.s == false) goto L23;
        return;
    L23:
        if (this.H1 == false) goto L26;
        return;
    L26:
        if (((Boolean) yt0.a.getValue()).booleanValue() == false) goto L33;
        ILivePlayerClient r2 = dr();
        if (r2 == null) goto L33;
        if (r2.getHasFirstFrameCacheForSurfaceView() != true) goto L33;
        return;
    L33:
        if (this.U2.isLiveHeadEnterSmooth() == false) goto L35;
        return;
    L35:
        LivePlayerSpmLogger.Companion.getClass();
        if (LivePlayerSpmLogger.access$getPlayerLoggerSimplifyV2$cp() == false) goto L42;
        HSImageView r3 = this.d;
        if (r3 != null) goto L40;
    L41:
        Er("show background, " + r5);
    L43:
        HSImageView r4 = this.d;
        if (r4 != null) goto L46;
    L47:
        HSImageView r6 = this.d;
        if (r6 == null) goto L51;
        r6.setVisibility(0);
    L51:
        if (LiveHazyFrameHelper.a.getDisableDimBackgroundCover() == true) goto L53;
    L59:
        boolean r7 = false;
    L60:
        if (r7 == true) goto L64;
        View r8 = this.e;
        if (r8 == null) goto L64;
        r8.setVisibility(0);
    L64:
        cs(true, r5);
        return;
    L53:
        if ((!this.U2.q().isEmpty()) == false) goto L59;
        if (this.U2.p() == 72) goto L59;
        if (LiveHazyFrameHelper.b() == false) goto L59;
        r7 = true;
        goto L60
    L46:
        if (r4.getVisibility() == 0) goto L64;
    L40:
        if (r3.getVisibility() == 0) goto L43;
    L42:
        Er("show background, " + r5);
    L10:
        if (this.U2.getStreamType() == LiveMode.AUDIO) goto L11;
        r1 = false;
        goto L13
    }

    @Override // gs0.c
    public final void Z70(boolean r1) {
        this.p1 = r1;
    }

    @Override // gs0.c
    public final void ZW(ChangeCameraStreamEvent r10) {
        Intrinsics.checkNotNullParameter(r10, "event");
        AbsLivePlayerView r1 = R8();
        LivePlayerView r3 = null;
        if ((r1 instanceof LivePlayerView) == true) goto L5;
        r1 = null;
    L5:
        LivePlayerView r2 = (LivePlayerView) r1;
        if (r2 == null) goto L8;
        r2.disableDelayStopOrRelease();
    L8:
        ILivePlayerClient r4 = dr();
        if (r4 == null) goto L11;
        r4.stop();
    L11:
        boolean r5 = true;
        if (r10.getCameraType() != 0) goto L14;
        boolean r6 = true;
    L15:
        ALogger.i("LivePlayer", "changeStreamInternal(), change to sub camera: " + r6);
        ILivePlayerClient r7 = dr();
        if (r7 == null) goto L24;
        IRoomEventHub r8 = r7.getEventHub();
        if (r8 == null) goto L24;
        MutableLiveData r9 = r8.getPlayComplete();
        if (r9 == null) goto L24;
        if (r6 == false) goto L23;
        r9.observe(this, this.U2.r());
        goto L24
    L23:
        r9.removeObserver(this.U2.r());
    L24:
        DataCenter r11 = ((Widget) this).dataCenter;
        if (r11 == null) goto L129;
        Room r12 = com.bytedance.android.live.core.utils.z.o(r11);
        if (r12 == null) goto L130;
        StreamUrl r13 = r12.getStreamUrl();
        if (r13 == null) goto L131;
        if (r6 == true) goto L39;
        LiveCoreSDKData r14 = r13.getLiveCoreSDKData();
        if (r14 == null) goto L38;
        LiveCoreSDKData.PullData r15 = r14.pullData;
        if (r15 == null) goto L128;
        this.U2.a(qr(r15.getStreamData(), r10));
    L54:
        Integer r16 = (Integer) zt0.a.getValue();
        if (r10.getCameraScene() != 1) goto L57;
    L58:
        IVrContextService r17 = jr(IVrContextService.class);
        if (r17 == null) goto L61;
        r17.openVrSensor(true);
    L61:
        VrUtils.e.getClass();
        VrUtils.d = 0;
        this.W = 1;
        if (r16 != null) goto L65;
    L75:
        String r18 = or();
        if (r18.length() <= 0) goto L78;
        boolean r19 = true;
    L79:
        if (r19 == true) goto L81;
    L83:
        if (r16 != null) goto L86;
    L94:
        ILivePlayerClient r20 = dr();
        if (r20 == null) goto L98;
        int r21 = is0.b.a;
        r20.registerPlayerFeature(is0.b.a.b("multi_camera_switch"));
    L98:
        if (r10.getCameraType() != 0) goto L100;
        boolean r22 = true;
    L101:
        this.U2.setSwitchingSubCamera(r22);
        ds0.d r23 = this.U2;
        if (r22 == false) goto L104;
        String r24 = String.valueOf(r10.getCameraId());
    L105:
        r23.setCurrentSubSteamKey(r24);
        is2.d r25 = (is2.d) gr().invoke();
        if (r25 == null) goto L108;
        r25.startPullStreamV2("change_camera_stream", false);
    L108:
        ILivePlayerClient r26 = dr();
        if (r26 == null) goto L115;
        IRoomEventHub r27 = r26.getEventHub();
        if (r27 == null) goto L115;
        MutableLiveData r28 = r27.getBackgroundHandlerRunning();
        if (r28 == null) goto L115;
        r28.observeForever(this.S2);
    L115:
        ILivePlayerClient r29 = dr();
        if (r29 == null) goto L122;
        IRoomEventHub r30 = r29.getEventHub();
        if (r30 == null) goto L122;
        MutableLiveData r31 = r30.getPlayingHandlerRunning();
        if (r31 == null) goto L122;
        r31.observeForever(this.T2);
    L122:
        SubCameraStateHandler r32 = (SubCameraStateHandler) this.Y.getValue();
        r32.getClass();
        Intrinsics.checkNotNullParameter(r10, "event");
        r32.b = r10.getStreamId();
        if (r10.getCameraType() == 0) goto L126;
        r5 = false;
    L126:
        r32.c = r5;
        r32.a(new es0.a.b(r32.b, r5));
        return;
    L104:
        r24 = "";
        goto L105
    L100:
        r22 = false;
        goto L101
    L86:
        if (r16.intValue() != 2) goto L94;
        LivePlayerView r33 = R8();
        if ((r33 instanceof LivePlayerView) == false) goto L91;
        r3 = r33;
    L91:
        LivePlayerView r34 = r3;
        if (r34 == null) goto L94;
        r34.recreateRenderView(r6, r6);
        goto L94
    L81:
        if ((!Intrinsics.areEqual(r18, "null")) == false) goto L83;
        f2.c(r18, 0);
        goto L83
    L78:
        r19 = false;
        goto L79
    L65:
        if (r16.intValue() != 1) goto L75;
        AbsLivePlayerView r35 = R8();
        if ((r35 instanceof LivePlayerView) == true) goto L69;
        r35 = null;
    L69:
        LivePlayerView r36 = (LivePlayerView) r35;
        if (r36 == null) goto L73;
        r36.recreateRenderView(r6, r6);
    L73:
        if (((Boolean) k8.a.getValue()).booleanValue() == false) goto L75;
        we(R8(), "vrlandscape");
        goto L75
    L57:
        if (this.W != 1) goto L83;
    L128:
        return;
    L38:
        return;
    L39:
        Map r37 = r13.getPullDatas();
        if (r37 == null) goto L54;
        if (r37.containsKey(String.valueOf(r10.getStreamId())) != true) goto L54;
        Map r38 = r13.getPullDatas();
        if (r38 == null) goto L46;
        IPullData r39 = (IPullData) r38.get(String.valueOf(r10.getStreamId()));
    L48:
        if ((r39 instanceof LiveCoreSDKData.PullData) == true) goto L50;
        r39 = null;
    L50:
        LiveCoreSDKData.PullData r40 = (LiveCoreSDKData.PullData) r39;
        if (r40 != null) goto L53;
        return;
    L53:
        this.U2.a(qr(r40.getStreamData(), r10));
        goto L54
    L46:
        r39 = null;
        goto L48
    L131:
        return;
    L130:
        return;
    L129:
        return;
    L14:
        r6 = false;
        goto L15
    }

    @Override // gs0.c
    public final void dG(Function0<? extends com.bytedance.android.live.platformplayer.b> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.i = r2;
    }

    @Override // gs0.c
    public final void ep(boolean r2) {
        this.U2.e().isScrolling().setValue(Boolean.valueOf(r2));
    }

    @Override // gs0.c
    public final void gV(boolean r3) {
        if (r3 != this.H1) goto L5;
        return;
    L5:
        this.H1 = r3;
        Iq();
        if (r3 == false) goto L44;
        ILivePlayerClient r4 = LivePlatformPlayerManager.f();
        View r0 = null;
        if (r4 == null) goto L14;
        IRenderView r5 = r4.getRenderView();
        if (r5 == null) goto L14;
        View r6 = r5.getSelfView();
        if (r6 == null) goto L14;
        Integer r7 = Integer.valueOf(r6.getVisibility());
    L16:
        if (r7 != null) goto L19;
    L20:
        ILivePlayerClient r8 = LivePlatformPlayerManager.f();
        if (r8 == null) goto L27;
        IRenderView r9 = r8.getRenderView();
        if (r9 == null) goto L27;
        View r10 = r9.getSelfView();
        if (r10 == null) goto L27;
        r10.setVisibility(0);
    L27:
        Wu("show_player_in_audio_room", false);
        Fragment r11 = (Fragment) this.U2.getGetFragment().invoke();
        if (r11 == null) goto L32;
        View r12 = r11.getView();
        if (r12 == null) goto L32;
        View r13 = r12.findViewById(2131383590);
    L33:
        Fragment r1 = (Fragment) this.U2.getGetFragment().invoke();
        if (r1 == null) goto L39;
        View r2 = r1.getView();
        if (r2 == null) goto L39;
        r0 = r2.findViewById(2131383591);
    L39:
        if (r13 == null) goto L41;
        r13.setVisibility(8);
    L41:
        if (r0 == null) goto L47;
        r0.setVisibility(8);
        return;
    L47:
        return;
    L32:
        r13 = null;
        goto L33
    L19:
        if (r7.intValue() == 0) goto L27;
    L14:
        r7 = null;
        goto L16
    L44:
        if (this.G1 == false) goto L49;
        es();
        return;
    }

    @Override // gs0.c
    public final void hG(boolean r1) {
        this.k1 = r1;
        Iq();
    }

    @Override // gs0.c
    public final void hI(boolean r1) {
        this.K = r1;
    }

    public final void is(int r10) {
        ALogger.i("SmoothDoubleRender", "newSurfaceRendered() >>> attachSurfaceView");
        if (r10 == 1) goto L5;
        R8().attachSurfaceView();
    L8:
        Context r2 = ((Widget) this).context;
        long r3 = 0;
        if (r2 == null) goto L14;
        Map<Integer, gs0.e.b> r5 = gs0.e.a;
        Intrinsics.checkNotNullParameter(r2, "context");
        Map<Integer, gs0.e.b> r6 = gs0.e.a;
        LinkedHashMap r7 = (LinkedHashMap) r6;
        if (r7.get(Integer.valueOf(r2.hashCode())) != null) goto L13;
        r6.put(Integer.valueOf(r2.hashCode()), new gs0.e.b());
    L13:
        Object r4 = r7.get(Integer.valueOf(r2.hashCode()));
        Intrinsics.checkNotNull(r4);
        gs0.e.b r8 = (gs0.e.b) r4;
        r8.getClass();
        long r9 = Math.max(SmoothAnimConfig.INSTANCE.getDuration() - (SystemClock.uptimeMillis() - r8.a), 0);
    L15:
        Long r11 = Long.valueOf(r9);
        if (r11.longValue() <= 0) goto L18;
        boolean r12 = true;
    L19:
        if (r12 == true) goto L22;
        r11 = null;
    L22:
        if (r11 == null) goto L24;
        long r13 = r11.longValue();
    L29:
        R8().postDelayed(new u(this, r10), r13);
        ALogger.i("LivePlayer", "newSurfaceRendered roomId = " + this.U2.x() + ",forceRendered = " + r10);
        ILivePlayerClient r14 = dr();
        if (r14 == null) goto L32;
        int r15 = is0.b.a;
        r14.registerPlayerFeature(is0.b.a.a("smooth_enter_force_render", 1, r10));
    L32:
        this.x2 = true;
        ALogger.i("SmoothDoubleRender", "newSurfaceRendered() >>> set isNewSurfaceRendered > TRUE");
        return;
    L24:
        List r16 = wt2.g.a;
        long r17 = ((SmoothEnterLeaveDoubleRenderConfig) ws0.a.getValue()).getNewSurfaceRenderedDelay();
        if (r17 < 0) goto L28;
        r3 = r17;
    L28:
        r13 = r3;
        goto L29
    L18:
        r12 = false;
        goto L19
    L14:
        r9 = 0;
        goto L15
    L5:
        if (this.U2.isLiveHeadEnterSmooth() == true) goto L8;
        R8().attachSurfaceView();
        goto L8
    }

    @Override // gs0.c
    public final void ji(gs0.a r3) {
        if (this.U2.isSmoothEnterDoubleRender() == false) goto L6;
        R8().detachSurfaceViewNotCheck();
        this.y2 = r3;
        ALogger.d("LivePlayer", "detachSurfaceViewNotCheck roomId = " + this.U2.x());
    L6:
        if (this.U2.isLiveHeadEnterSmooth() == false) goto L9;
        R8().detachSurfaceViewNotCheck();
        return;
    }

    @Override // gs0.c
    public final void l60(boolean r1) {
        this.x1 = r1;
        Iq();
    }

    @Override // gs0.c
    public final void mj(String r8) {
        Intrinsics.checkNotNullParameter(r8, "sei");
        m6 r0 = m6.a;
        if (((Boolean) r0.getValue()).booleanValue() == true) goto L6;
        return;
    L6:
        if (((Boolean) v6.a.getValue()).booleanValue() == false) goto L17;
        ILivePlayerClient r1 = dr();
        if (r1 == null) goto L13;
        LivePlayerClientContext r2 = r1.context();
        if (r2 == null) goto L13;
        String r3 = r2.getLastLayoutSei();
    L15:
        if (r2.a(r3) == false) goto L17;
        r8 = r3;
    L13:
        r3 = null;
    L17:
        this.M.getClass();
        if (((Boolean) r0.getValue()).booleanValue() == false) goto L44;
        if (r8 == null) goto L44;
        boolean r4 = true;
        if (r8.length() != 0) goto L25;
        boolean r5 = true;
    L26:
        if (r5 == true) goto L44;
        LiveSeiUtil.i.getClass();     // Catch: JSONException -> L43
        JSONObject r6 = LiveSeiUtil.c(r8);     // Catch: JSONException -> L43
        if (r6.has("app_data") == false) goto L44;
        String r7 = JSONObjectProtectorUtils.getString(r6, "app_data");     // Catch: JSONException -> L43
        JSONObject r9 = new JSONObject(new Regex("\\\\").replace(r7, ""));     // Catch: JSONException -> L43
        if (r9.has("ver") == false) goto L44;
        int r10 = r9.optInt("ver");     // Catch: JSONException -> L43
        Integer[] r11 = (Integer[]) n6.a.getValue();     // Catch: JSONException -> L43
        int r12 = r11.length;     // Catch: JSONException -> L43
        int r13 = 0;
    L35:
        if (r13 >= r12) goto L44;
        if (r11[r13].intValue() != r10) goto L39;
        boolean r14 = true;
    L40:
        if (r14 == true) goto L45;
        r13 = r13 + 1;
    L45:
        if (r4 == true) goto L48;
        return;
    L48:
        if (((Boolean) this.X.getValue()).booleanValue() == false) goto L64;
        com.bytedance.android.livesdk.chatroom.utils.i1 r15 = this.M;
        String r16 = this.L;
        r15.getClass();
        if (com.bytedance.android.livesdk.chatroom.utils.i1.a(r8) == true) goto L53;
        r8 = r16;
    L53:
        this.L = r8;
        if (this.l == false) goto L65;
        DataCenter r17 = ((Widget) this).dataCenter;
        if (r17 == null) goto L58;
        r17.put("data_first_frame_sei", r8);
    L58:
        boolean r18 = com.bytedance.android.live.revenue.core.util.h.a;
        com.bytedance.android.live.revenue.core.util.h.d(kc0.j.class).updateFirstFrameSei(this.L);
        this.l = false;
        return;
    L65:
        return;
    L64:
        return;
    L39:
        r14 = false;
        goto L40
    L25:
        r5 = false;
    L44:
        r4 = false;
        goto L45
    }

    public final int mr(boolean r6) {
        IStrategyService r0 = jc1.k.f(IStrategyService.class);
        if (r0 != null) goto L5;
        return 0;
    L5:
        LiveData r1 = r0.getFactor("vr_stream_downgrade_level", 0, false, true);
        if (r6 == true) goto L8;
    L11:
        if (r1 == null) goto L16;
        Integer r7 = (Integer) r1.getValue();
        if (r7 != null) goto L15;
        return 0;
    L15:
        return r7.intValue();
    L16:
        return 0;
    L8:
        if (((Boolean) lx0.a.getValue()).booleanValue() == false) goto L11;
        if (r1 == null) goto L11;
        r1.observe(this, new i(this));
        goto L11
    }

    public final void onChanged(Object r9) {
        KVData r10 = (KVData) r9;
        Intrinsics.checkNotNullParameter(r10, "kvData");
        String r0 = r10.getKey();
        boolean r3 = false;
        Object r4 = null;
        switch(r0.hashCode()) {
            case -1979299958: goto L56;
            case -1540323875: goto L41;
            case -1180299966: goto L30;
            case -1091008631: goto L9;
            case 698171775: goto L6;
            default: goto L156;
        };
    L156:
        return;
    L6:
        if (r0.equals("cmd_pc_landscape_close_dynamic_1v6") == false) goto L131;
        M30(s1.y(), "pcLandscapeCloseLinkmic");
        return;
    L131:
        return;
    L9:
        if (r0.equals("cmd_multi_state_change") == false) goto L133;
        Object r11 = r10.getData();
        if ((r11 instanceof u1) == false) goto L14;
        r4 = r11;
    L14:
        u1 r5 = (u1) r4;
        if (r5 != null) goto L17;
        return;
    L17:
        if (r5.f != 1) goto L135;
        ILivePlayerClient r12 = dr();
        if (r12 == null) goto L24;
        IRenderView r13 = r12.getRenderView();
        if (r13 == null) goto L24;
        if (r13.getVisibility() != 0) goto L24;
        return;
    L24:
        ILivePlayerClient r14 = dr();
        if (r14 == null) goto L137;
        IRenderView r15 = r14.getRenderView();
        if (r15 == null) goto L138;
        r15.setVisibility(0);
        return;
    L138:
        return;
    L137:
        return;
    L135:
        return;
    L133:
        return;
    L30:
        if (r0.equals("cmd_interact_state_change") == false) goto L140;
        Object r16 = r10.getData();
        if ((r16 instanceof zg1.a1) == false) goto L35;
        r4 = r16;
    L35:
        zg1.a1 r6 = (zg1.a1) r4;
        if (r6 != null) goto L38;
        return;
    L38:
        if (r6.a != 4) goto L142;
        Gq(nr(), true);
        return;
    L142:
        return;
    L140:
        return;
    L41:
        if (r0.equals("cmd_pk_state_change") == false) goto L144;
        Object r17 = r10.getData();
        if ((r17 instanceof zg1.z0) == false) goto L46;
        r4 = r17;
    L46:
        zg1.z0 r7 = (zg1.z0) r4;
        if (r7 != null) goto L49;
        return;
    L49:
        if (r7.a != 0) goto L146;
        AbsLivePlayerView r18 = R8();
        if (r18 == null) goto L147;
        IRenderView r19 = r18.getRenderView();
        if (r19 == null) goto L148;
        r19.setVisibility(0);
        return;
    L148:
        return;
    L147:
        return;
    L146:
        return;
    L144:
        return;
    L56:
        if (r0.equals("data_pull_stream_change") == false) goto L150;
        Object r20 = r10.getData();
        if ((r20 instanceof IRoom) == true) goto L60;
        r20 = null;
    L60:
        IRoom r21 = (IRoom) r20;
        if (r21 != null) goto L63;
        return;
    L63:
        if (r21.getRoomId() != this.U2.x()) goto L65;
        r3 = true;
    L65:
        if (r3 == true) goto L68;
        r21 = null;
    L68:
        if (r21 == null) goto L152;
        Intrinsics.checkNotNullParameter(r21, PbRequest.SwitchType.ROOM);
        IBaseStreamUrl r1 = r21.getStreamUrl();
        if (r1 == null) goto L157;
        StreamUrl r2 = r21.getStreamUrl();
        if (r2 == null) goto L108;
        DataCenter r8 = ((Widget) this).dataCenter;
        if (r8 == null) goto L78;
        IRoom r22 = com.bytedance.android.live.core.utils.a0.n(r8);
    L80:
        if ((r22 instanceof Room) == true) goto L82;
        r22 = null;
    L82:
        Room r23 = (Room) r22;
        if (r23 == null) goto L85;
        r23.setStreamUrl(r2);
    L85:
        IRoomContextService r24 = jc1.k.f(IRoomContextService.class);
        if (r24 == null) goto L92;
        com.bytedance.android.livesdk.chatroom.o r25 = IRoomContextService.a.a(r24, null, 0, 3);
        if (r25 == null) goto L92;
        com.bytedance.live.datacontext.m r26 = r25.getRoom();
        if (r26 == null) goto L92;
        IRoom r27 = (IRoom) r26.getValue();
    L94:
        if ((r27 instanceof Room) == true) goto L96;
        r27 = null;
    L96:
        Room r28 = (Room) r27;
        if (r28 != null) goto L99;
    L103:
        Room r29 = this.U2.w();
        if (r29 == null) goto L106;
        r29.setStreamUrl(r2);
    L106:
        this.U2.b(r2);
        goto L108
    L99:
        if ((r2 instanceof StreamUrl) == true) goto L101;
        StreamUrl r30 = null;
    L102:
        r28.setStreamUrl(r30);
        goto L103
    L101:
        r30 = r2;
    L92:
        r27 = null;
        goto L94
    L78:
        r22 = null;
    L108:
        if (((com.bytedance.android.live.platformplayer.b) ar().invoke()).b() == false) goto L153;
        ILivePlayerClient r31 = dr();
        if (r31 == null) goto L117;
        IRoomEventHub r32 = r31.getEventHub();
        if (r32 == null) goto L117;
        MutableLiveData r33 = r32.getStopped();
        if (r33 == null) goto L117;
        r4 = (Boolean) r33.getValue();
    L117:
        if (Intrinsics.areEqual(r4, Boolean.TRUE) == true) goto L158;
        ILivePlayerClient r34 = dr();
        if (r34 != null) goto L122;
    L129:
        Lq(r1, "refresh_common_stream");
        return;
    L122:
        if (r34.isPlaying() != true) goto L129;
        String r35 = r21.getCompoundStreamData();
        if (r35 == null) goto L159;
        ILivePlayerClient r36 = dr();
        if (r36 == null) goto L154;
        r36.switchStreamData(r35);
        return;
    L154:
        return;
    L159:
        return;
    L158:
        return;
    L153:
        return;
    L157:
        return;
    L152:
        return;
    }

    public final void onConfigurationChanged(Configuration r15) {
        Intrinsics.checkNotNullParameter(r15, "newConfig");
        Er("onConfigurationChanged");
        DataCenter r1 = ((Widget) this).dataCenter;
        if (r1 == null) goto L5;
        Boolean r2 = (Boolean) r1.get("DATA_PICTURE_MODE", Boolean.FALSE);
    L6:
        Boolean r3 = Boolean.TRUE;
        if (Intrinsics.areEqual(r2, r3) == false) goto L10;
        return;
    L10:
        if (Intrinsics.areEqual(g60.a.getValue(), r3) == false) goto L44;
        com.bytedance.android.live.platformplayer.b r4 = (com.bytedance.android.live.platformplayer.b) ar().invoke();
        if (r4 == null) goto L44;
        if (r4.isUserVisible() == true) goto L44;
        ILivePlayerClient r5 = dr();
        if (r5 == null) goto L22;
        IRoomEventHub r6 = r5.getEventHub();
        if (r6 == null) goto L22;
        MutableLiveData r7 = r6.getPlaying();
        if (r7 == null) goto L22;
        Boolean r8 = (Boolean) r7.getValue();
    L24:
        if (Intrinsics.areEqual(r8, Boolean.FALSE) == false) goto L44;
        ILivePlayerClient r9 = dr();
        if (r9 == null) goto L33;
        LivePlayerClientContext r10 = r9.context();
        if (r10 == null) goto L33;
        String r11 = r10.getLastLayoutSei();
        if (r11 == null) goto L33;
        if (StringsKt.contains$default(r11, "\\\"ver\\\":6", false, 2, null) != true) goto L33;
    L42:
        if (FoldScreenUtils.e() == true) goto L44;
        boolean r12 = true;
    L45:
        if (r12 == false) goto L47;
        return;
    L47:
        this.z = r15;
        hs();
        this.U2.w();
        Context r13 = ((Widget) this).context;
        if ((r13 instanceof Activity) == true) goto L50;
        r13 = null;
    L50:
        Activity r14 = (Activity) r13;
        if (r14 == null) goto L291;
        int r16 = r14.getRequestedOrientation();
        if (m2.a(Integer.valueOf(r16), new Object[]{6, 0, 8, 1}) == true) goto L55;
    L57:
        boolean r17 = false;
    L58:
        if (r17 == false) goto L63;
        ds0.d r18 = this.U2;
        if (r18.g == false) goto L63;
        r18.setScreenOrientation(r16);
    L63:
        if (this.U2.getEnterSmooth() == false) goto L105;
        if (r17 == false) goto L105;
        if (r15.orientation != 2) goto L105;
        Activity r19 = ((com.bytedance.android.live.platformplayer.b) ar().invoke()).getActivity();
        if (r19 == null) goto L105;
        View r110 = new View(r19);
        this.g = r110;
        if (r110.getParent() != null) goto L105;
        ViewGroup.LayoutParams r111 = new ViewGroup.LayoutParams(-1, -1);
        View r112 = this.g;
        if (r112 == null) goto L74;
        r112.setLayoutParams(r111);
    L74:
        View r113 = this.g;
        if (r113 == null) goto L78;
        r113.setBackgroundColor(-16777216);
    L78:
        if (er().getSystemFloatWindowBlackFix() == false) goto L91;
        com.bytedance.android.live.platformplayer.b r20 = (com.bytedance.android.live.platformplayer.b) ar().invoke();
        if (r20 == null) goto L84;
        View r21 = r20.getView();
        if (r21 == null) goto L84;
        View r22 = r21.findViewById(2131378433);
    L86:
        if ((r22 instanceof ViewGroup) == true) goto L88;
        r22 = null;
    L88:
        ViewGroup r23 = (ViewGroup) r22;
        if (r23 == null) goto L105;
        r23.addView(this.g, 0);
    L84:
        r22 = null;
        goto L86
    L91:
        Window r24 = r19.getWindow();
        if (r24 == null) goto L98;
        View r25 = r24.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L100;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r114 = ThreadMethodProxy.currentThread();
        if (r114 == com.larus.home.impl.utils.c.a) goto L100;
        com.larus.home.impl.utils.c.a(r114, "getDecorView");
    L100:
        if ((r25 instanceof ViewGroup) == true) goto L102;
        r25 = null;
    L102:
        ViewGroup r26 = (ViewGroup) r25;
        if (r26 == null) goto L105;
        r26.addView(this.g, 0);
        goto L105
    L98:
        r25 = null;
    L105:
        LiveRequest r27 = this.U2.getLiveRequest();
        if (r27 == null) goto L113;
        MutableLiveData r28 = r27.isPortrait();
        if (r28 == null) goto L113;
        if (r16 != 1) goto L111;
        boolean r115 = true;
    L112:
        r28.setValue(Boolean.valueOf(r115));
        goto L113
    L111:
        r115 = false;
    L113:
        v9 r29 = this.n;
        if (r29 == null) goto L126;
        if (r16 == 1) goto L117;
        boolean r116 = true;
    L118:
        int r117 = e5.a;
        if (PadConfigUtils.c() == true) goto L121;
    L124:
        r29.onOrientationChanged(!r116);
        goto L126
    L121:
        if (PadConfigUtils.e(s1.getContext()) == false) goto L123;
        r116 = false;
        goto L124
    L123:
        r116 = e5.m(r16);
        goto L124
    L117:
        r116 = false;
    L126:
        if (PadConfigUtils.c() == false) goto L134;
        ViewGroup r30 = ((Widget) this).containerView;
        if (r30 == null) goto L134;
        View r31 = r30.findViewById(2131392252);
        if (r31 == null) goto L134;
        ViewGroup.LayoutParams r32 = r31.getLayoutParams();
        if (r32 == null) goto L134;
        r32.width = -1;
        r32.height = -1;
    L134:
        this.s.j = false;
        if (Hr(Rq(Integer.valueOf(r15.orientation))) == true) goto L141;
        IMiddlewareLiveService r33 = TTLiveServiceMiddleware.getLiveService();
        if (r33 != null) goto L139;
    L140:
        this.s.b();
        goto L141
    L139:
        if (r33.shouldUseNewLivePlayerLayout() != true) goto L140;
    L141:
        int r34 = UtilityKotlinExtentionsKt.i(r15.screenWidthDp);
        int r118 = UtilityKotlinExtentionsKt.i(r15.screenHeightDp);
        if (LiveInitSettingKeys.get_LIVE_PLAYER_LAYOUT_V1_ENABLE() == true) goto L144;
    L166:
        Pair r35 = TuplesKt.to(Integer.valueOf(r34), Integer.valueOf(r118));
        int r119 = ((Number) r35.component1()).intValue();
        int r36 = ((Number) r35.component2()).intValue();
        Integer r120 = Integer.valueOf(r15.orientation);
        Intrinsics.checkNotNullParameter("onConfigurationChanged", "reason");
        if (r120 == null) goto L169;
        int r121 = r120.intValue();
    L170:
        this.h1 = r121;
        as(r119, r36, "onConfigurationChanged", r120);
        if (((Boolean) yh0.a.getValue()).booleanValue() == false) goto L179;
        ViewGroup.LayoutParams r37 = R8().getLayoutParams();
        if ((r37 instanceof ViewGroup.MarginLayoutParams) == true) goto L175;
        r37 = null;
    L175:
        ViewGroup.MarginLayoutParams r38 = (ViewGroup.MarginLayoutParams) r37;
        if (r38 == null) goto L178;
        r38.rightMargin = 0;
    L178:
        R8().setLayoutParams(r38);
    L179:
        Integer r39 = Integer.valueOf(this.h1);
        ALogger.d("SandwichBorderInfo", "LivePlayerWidget autoAdapterSandwichLayout orientation:" + r39 + " reason:onConfigurationChanged has hasRequestedChangeOrientation:" + this.U2.g);
        if (Intrinsics.areEqual("onConfigurationChanged", "onConfigurationChanged") == false) goto L196;
        if (r39 == null) goto L196;
        if (r39.intValue() != 2) goto L196;
        if (this.U2.g == false) goto L196;
        ILandscapePicTypeService r0 = jr(ILandscapePicTypeService.class);
        if (r0 == null) goto L196;
        if (r0.isSandwich() != true) goto L196;
        ILandscapePicTypeService r40 = jr(ILandscapePicTypeService.class);
        if (r40 == null) goto L194;
        Boolean r41 = Boolean.valueOf(r40.autoAdapterSandwichLayout(this.U2.getRoomId()));
    L195:
        ALogger.d("SandwichBorderInfo", "LivePlayerWidget autoAdapterSandwichLayout " + this.U2.getRoomId() + ' ' + r41);
        goto L196
    L194:
        r41 = null;
    L196:
        DataCenter r42 = ((Widget) this).dataCenter;
        if (r42 == null) goto L199;
        r42.put("cmd_video_orientation_changed", new k3(this.U2.isVideoHorizontal(), this.U2.getPortraitVideoViewBottom(), 0));
    L199:
        com.bytedance.android.livesdk.log.b0 r43 = com.bytedance.android.livesdk.log.b0.o();
        String r44 = "onConfigurationChanged cause show interaction; id" + this.U2.x();
        r43.getClass();
        com.bytedance.android.live.core.log.g.a("ttlive_room_exit", r44);
        List r45 = (List) com.bytedance.android.live.core.setting.n1.a.getValue();
        if (r45 == null) goto L204;
        if (r45.contains(Build.MODEL) != true) goto L204;
    L207:
        ViewGroup r46 = ((Widget) this).containerView;
        if (r46 == null) goto L214;
        View r47 = r46.findViewById(2131392252);
        if (r47 == null) goto L214;
        ViewGroup.LayoutParams r48 = r47.getLayoutParams();
        if (r48 == null) goto L214;
        r48.width = -1;
        r48.height = -1;
    L214:
        ALogger.i("LivePlayer", "fold invoke reset size: " + Build.MODEL);
    L215:
        StreamUrl r49 = this.U2.getStreamUrl();
        if (r49 == null) goto L233;
        if (r49.isCompoundScene() != true) goto L233;
        ILivePlayerClient r50 = dr();
        if (r50 == null) goto L222;
        ILivePlayerExtraRenderController r51 = r50.extraRenderController();
    L224:
        if (r15.orientation != 2) goto L226;
        boolean r52 = true;
    L227:
        if (r52 == false) goto L230;
        if (r51 == null) goto L233;
        ILivePlayerExtraRenderController.DefaultImpls.onScreenLandscape$default(r51, false, 1, null);
        goto L233
    L230:
        if (r51 == null) goto L233;
        r51.onScreenPortrait();
        goto L233
    L226:
        r52 = false;
        goto L227
    L222:
        r51 = null;
    L233:
        if (r15.orientation != 2) goto L240;
        com.bytedance.android.livesdk.chatroom.ui.background.a r53 = this.p0;
        if (r53 == null) goto L260;
        Disposable r54 = r53.d;
        if (r54 == null) goto L239;
        r54.dispose();
        r53.b = true;
    L239:
        r53.a = false;
        r53.c = null;
        r53.d = null;
    L260:
        ds0.d r55 = this.U2;
        if (r55.g == true) goto L263;
        return;
    L263:
        if (r17 == false) goto L286;
        r55.g = false;
        Room r56 = r55.w();
        if (r56 == null) goto L268;
        com.bytedance.android.livesdk.log.b0 r57 = com.bytedance.android.livesdk.log.b0.o();
        String r58 = "onConfigurationChanged real cause show interaction; id$" + r56.id;
        r57.getClass();
        com.bytedance.android.live.core.log.g.a("ttlive_room_exit", r58);
        this.U2.e().getShowInteraction().setValue(r56);
    L268:
        if (r15.orientation != 2) goto L286;
        if (((Boolean) com.bytedance.android.livesdk.q0.a.getValue()).booleanValue() == false) goto L286;
        ViewParent r59 = R8().getParent();
        if ((r59 instanceof ViewGroup) == true) goto L275;
        r59 = null;
    L275:
        ViewGroup r60 = (ViewGroup) r59;
        if (r60 == null) goto L286;
        ViewGroup.LayoutParams r61 = r60.getLayoutParams();
        if ((r61 instanceof ViewGroup.MarginLayoutParams) == true) goto L281;
        r61 = null;
    L281:
        ViewGroup.MarginLayoutParams r62 = (ViewGroup.MarginLayoutParams) r61;
        if (r62 == null) goto L286;
        if (r62.topMargin == 0) goto L286;
        r62.topMargin = 0;
        r60.setLayoutParams(r62);
    L286:
        super/*com.bytedance.ies.sdk.widgets.Widget*/.onConfigurationChanged(r15);
        ValueAnimator r122 = this.Q;
        if (r122 == null) goto L289;
        r122.cancel();
    L289:
        this.Q = null;
        return;
    L240:
        ILivePlayerClient r63 = dr();
        if (r63 == null) goto L247;
        IRoomEventHub r65 = r63.getEventHub();
        if (r65 == null) goto L247;
        MutableLiveData r66 = r65.getPlaying();
        if (r66 == null) goto L247;
        Boolean r67 = (Boolean) r66.getValue();
    L249:
        if (Intrinsics.areEqual(r67, r3) == false) goto L260;
        com.bytedance.android.livesdk.chatroom.ui.background.a r68 = this.p0;
        if (r68 == null) goto L253;
        r68.c = dr();
    L253:
        com.bytedance.android.livesdk.chatroom.ui.background.a r69 = this.p0;
        if (r69 == null) goto L260;
        ds0.d r70 = this.U2;
        if (r70 == null) goto L258;
        LiveMode r71 = r70.getStreamType();
    L259:
        r69.b(r71);
        goto L260
    L258:
        r71 = null;
    L247:
        r67 = null;
    L204:
        if (((Boolean) com.bytedance.android.live.core.setting.l1.a.getValue()).booleanValue() == false) goto L215;
        if (FoldScreenUtils.f() == false) goto L215;
    L169:
        r121 = -1;
        goto L170
    L144:
        if (FoldScreenUtils.e() == false) goto L146;
        this.E2 = true;
        goto L166
    L146:
        if (StatusBarUtil.STATUS_BAR_ADAPT_ENABLE == true) goto L148;
    L152:
        boolean r123 = false;
    L154:
        if (r15.orientation != 2) goto L156;
        boolean r124 = true;
    L157:
        int r125 = StatusBarUtil.getStatusBarHeight(((Widget) this).context);
        if (r123 == false) goto L161;
        if (r124 == true) goto L161;
        r118 = r118 + r125;
    L161:
        if (r124 == false) goto L166;
        if (DigHoleScreenUtil.isDigHole(((Widget) this).context) == false) goto L166;
        r34 = r34 + r125;
        r118 = R8().getWidth();
        goto L166
    L156:
        r124 = false;
        goto L157
    L148:
        if (StatusBarUtil.JUMP_FROM_LIVE_PLAY_ACTIVITY == false) goto L152;
        if (StatusBarUtil.isStatusBarTransparent() == false) goto L152;
        r123 = true;
        goto L154
    L55:
        if (r16 == this.U2.getScreenOrientation()) goto L57;
        r17 = true;
        goto L58
    L291:
        return;
    L33:
        ILivePlayerClient r72 = dr();
        if (r72 == null) goto L44;
        LivePlayerClientContext r73 = r72.context();
        if (r73 == null) goto L44;
        String r74 = r73.getLastLayoutSei();
        if (r74 == null) goto L44;
        if (StringsKt.contains$default(r74, "\\\"ver\\\":2", false, 2, null) != true) goto L44;
    L22:
        r8 = null;
    L44:
        r12 = false;
        goto L45
    L5:
        r2 = null;
        goto L6
    }

    public final void onLoad(Object[] r24) {
        if (((Boolean) PerformanceTestSettings.TEST_DISABLE_LIVE_PLAYER.getValue()).booleanValue() == false) goto L6;
        Er("player widget @" + hashCode() + " onLoad() cancel");
        return;
    L6:
        Er("player widget @" + hashCode() + " onLoad()");
        boolean r1 = com.bytedance.android.live.revenue.core.util.h.a;
        com.bytedance.android.live.revenue.core.util.h.d(kc0.j.class).updateFeedParams(this.V0, ((Number) ((Widget) this).dataCenter.get("data_current_inner_feed_length", 0)).intValue(), ((Number) ((Widget) this).dataCenter.get("data_inner_feed_room_rev_link_scene", 0)).intValue(), ((Number) ((Widget) this).dataCenter.get("data_inner_feed_room_rev_link_pk_state", 0)).intValue(), ((Number) ((Widget) this).dataCenter.get("data_inner_feed_room_build_args_timestamp", 0L)).longValue());
        com.bytedance.android.live.revenue.core.util.h.d(kc0.j.class).updateEnterParams(this.V0, ((Number) ((Widget) this).dataCenter.get("data_live_play_fragment_start_room_ts", 0L)).longValue());
        com.bytedance.android.live.revenue.core.util.h.d(kc0.j.class).updateInteractMarginTop(this.V0, ((Number) ((Widget) this).dataCenter.get("interaction_layer_margin_top", 0)).intValue());
        this.s.w = this.V0;
        cr().E(this.V0);
        br().E(this.V0);
        rc0.h r2 = (rc0.h) this.b2.getValue();
        if (r2 == null) goto L9;
        r2.E(this.V0);
    L9:
        InteractPlayViewManager r3 = this.t;
        if (r3 == null) goto L12;
        r3.m = this.V0;
    L12:
        yh0 r4 = yh0.a;
        if (((Boolean) r4.getValue()).booleanValue() == true) goto L15;
        cr().e();
        br().e();
    L15:
        this.R = null;
        this.U = false;
        rc0.h r5 = (rc0.h) this.b2.getValue();
        if (r5 == null) goto L18;
        r5.a(new AnonymousClass1(this));
    L18:
        ds0.d r6 = this.U2;
        ILivePlayerClient r7 = dr();
        WeakReference r8 = a2.a;
        Intrinsics.checkNotNullParameter(r6, "session");
        if (r6.l() == true) goto L28;
        if (r7 == null) goto L24;
        ILivePlayerSharedDataManager r9 = r7.sharedDataManager();
        if (r9 == null) goto L24;
        r9.putSharedData("live_multi_video_scene_render_view_params", new Object());
    L24:
        if (r7 == null) goto L28;
        ILivePlayerSharedDataManager r10 = r7.sharedDataManager();
        if (r10 == null) goto L28;
        r10.putSharedData("is_hot_soon", Boolean.FALSE);
    L28:
        ViewGroup r11 = ((Widget) this).containerView;
        if (r11 == null) goto L48;
        this.d = r11.findViewById(2131378235);
        if (LiveHazyFrameHelper.a.getDisableDefaultBackground() == true) goto L33;
    L39:
        boolean r12 = false;
    L40:
        if (r12 == false) goto L44;
        HSImageView r13 = this.d;
        if (r13 == null) goto L47;
        r13.setBackgroundResource(0);
    L47:
        this.e = r11.findViewById(2131378234);
        this.f = (ViewGroup) r11.findViewById(2131378405);
        goto L48
    L44:
        HSImageView r14 = this.d;
        if (r14 == null) goto L47;
        r14.setBackgroundResource(2131251156);
        goto L47
    L33:
        if ((!this.U2.q().isEmpty()) == false) goto L39;
        if (this.U2.p() == 72) goto L39;
        if (LiveHazyFrameHelper.b() == false) goto L39;
        r12 = true;
    L48:
        ViewGroup r15 = ((Widget) this).containerView;
        if (r15 == null) goto L51;
        Context r16 = r15.getContext();
    L52:
        this.p0 = new com.bytedance.android.livesdk.chatroom.ui.background.a(r16, ((Widget) this).containerView.findViewById(2131392252));
        hs();
        DataCenter r17 = ((Widget) this).dataCenter;
        String r18 = "";
        if (r17 == null) goto L55;
        String r19 = (String) r17.get("feed_live_enter_room_sei", "");
    L56:
        com.bytedance.android.livesdk.chatroom.utils.i1 r20 = this.M;
        String r21 = this.L;
        r20.getClass();
        if (com.bytedance.android.livesdk.chatroom.utils.i1.a(r19) == true) goto L60;
        r19 = r21;
    L60:
        this.L = r19;
        if (r19 != null) goto L63;
        r19 = "";
    L63:
        mj(r19);
        com.bytedance.android.livesdk.chatroom.room.p0 r22 = this.U2.e();
        r22.getTraceApmEvent().setValue("LPW.observeRoomEvent");
        ILivePlayerClient r23 = dr();
        if (r23 == null) goto L70;
        IRoomEventHub r25 = r23.getEventHub();
        if (r25 == null) goto L70;
        MutableLiveData r26 = r25.getPlaying();
        if (r26 == null) goto L70;
        Boolean r27 = (Boolean) r26.getValue();
    L71:
        Boolean r28 = Boolean.TRUE;
        if (Intrinsics.areEqual(r27, r28) == false) goto L75;
        Er("player widget @" + hashCode() + " onPlaying() before observe");
        Qr();
    L75:
        if (MultiRoomConfig.INSTANCE.enableRoomPreload() == false) goto L77;
        r22.isRoomVisible().observe(this, new com.bytedance.android.live.platformplayer.layout.t(this));
    L78:
        r22.getLiveIllegal().observe(this, new v(this));
        if (((Boolean) t4.a.getValue()).booleanValue() == false) goto L110;
        ILivePlayerClient r29 = dr();
        if (r29 == null) goto L87;
        IRoomEventHub r30 = r29.getEventHub();
        if (r30 == null) goto L87;
        MutableLiveData r31 = r30.getPlaying();
        if (r31 == null) goto L87;
        Boolean r32 = (Boolean) r31.getValue();
    L89:
        if ((!Intrinsics.areEqual(r32, r28)) == false) goto L109;
        NextLiveData r33 = r22.getStartPull();
        if (r33 == null) goto L93;
        Boolean r34 = (Boolean) r33.getValue();
    L95:
        if (Intrinsics.areEqual(r34, r28) == false) goto L109;
        ds0.d r35 = this.U2;
        if (r35 == null) goto L103;
        com.bytedance.android.livesdk.chatroom.room.p0 r36 = r35.e();
        if (r36 == null) goto L103;
        MutableLiveData r37 = r36.getTraceApmEvent();
        if (r37 == null) goto L103;
        r37.setValue("LPW.fixBS3");
    L103:
        i1 r38 = this.M2;
        if (r38 == null) goto L106;
        r38.onChanged(r28);
    L106:
        Er("LIVE_ROOM_BLACK_SCREEN_BG_FIX called");
        if (((PlayerOptimizeConfig) is0.c.c().getConfig(PlayerOptimizeConfig.class)).getStartPullObserveFix() == false) goto L111;
        r22.getStartPull().observeForever(this.M2, true);
    L111:
        r22.getSwitchStreamDataEvent().observeForever(this.L2, true);
        r22.getUpdateInteraction().observe(this, new w(this));
        r22.getMediaGeneratingViewShowing().observe(this, new x(this));
        r22.getMediaStartRender().observe(this, new y(this));
        r22.getShowMediaVideoBackground().observe(this, new z(this));
        this.U2.e().getUpdateRoom().observe(this, new a0(this));
        if (((Boolean) r4.getValue()).booleanValue() == false) goto L118;
        ILivePlayerClient r39 = dr();
        if (r39 == null) goto L116;
        int r40 = is0.b.a;
        Intrinsics.checkNotNullParameter("use_new_layout", "feature");
        r39.registerPlayerFeature(new is0.d("use_new_layout", 0, r28));
    L116:
        this.L0 = new com.bytedance.android.livesdk.player.layout.e(R8().getRenderView());
        com.bytedance.android.livesdk.player.layout.n r41 = new com.bytedance.android.livesdk.player.layout.n(com.bytedance.android.livesdk.player.layout.d.a());
        this.P0 = r41;
        com.bytedance.android.livesdk.player.layout.e r42 = this.L0;
        Intrinsics.checkNotNull(r42);
        r41.b(r42);
        ConcurrentHashMap<String, as0.a> r43 = LivePlatformPlayerManager.a;
        long r110 = this.U2.x();
        com.bytedance.android.live.platformplayer.layout.c r44 = this.L0;
        Intrinsics.checkNotNull(r44);
        Intrinsics.checkNotNullParameter(r44, "livePlayerPosition");
        LivePlatformPlayerManager.b.put(Long.valueOf(r110), r44);
    L118:
        if (((Boolean) r4.getValue()).booleanValue() == false) goto L277;
        Ur(com.bytedance.android.live.core.utils.a0.l(((Widget) this).dataCenter, true), null);
        if (this.U2.l() == false) goto L269;
        Er("loadSharedPlayer() use shared player ");
        ILivePlayerClient r45 = LivePlatformPlayerManager.a(this.U2.x(), this.U2.isPseudo());
        if (r45 == null) goto L439;
        IRenderView r111 = r45.getRenderView();
        if (r111 == null) goto L269;
        r45.unmute("LivePlayerWidget.loadSharedPlayerNew");
        if (this.U2.getEnterSmooth() == true) goto L129;
    L267:
        Xr();
        goto L269
    L129:
        if (this.U2.getStreamType() == LiveMode.AUDIO) goto L267;
        if (((Boolean) wj0.a.getValue()).booleanValue() == false) goto L267;
        if (this.U2.isSmoothEnterDoubleRender() == true) goto L258;
        if (this.U2.q == true) goto L258;
        View r112 = r111.getSelfView();
        if ((r112 instanceof TextureView) == true) goto L140;
        r112 = null;
    L140:
        TextureView r113 = (TextureView) r112;
        if (r113 == null) goto L202;
        Context r114 = getContext();
        if (r114 == null) goto L147;
        String r115 = r114.toString();
        if (r115 == null) goto L147;
        boolean r46 = StringsKt.contains$default(r115, "DetailActivity", false, 2, null);
    L148:
        if (r46 == true) goto L202;
        int r47 = r113.getWidth();
        int r116 = r113.getHeight();
        AbsLivePlayerView r117 = R8();
        if ((r117 instanceof LivePlayerView) == true) goto L152;
        r117 = null;
    L152:
        LivePlayerView r118 = (LivePlayerView) r117;
        if (r118 == null) goto L164;
        Bitmap r48 = r118.getPreSceneRenderBitmap();
        if (r48 == null) goto L164;
        if (Build.VERSION.SDK_INT >= 24) goto L159;
        boolean r49 = false;
    L160:
        if (r49 == false) goto L164;
        if (r47 == 0) goto L163;
        if (r116 != 0) goto L164;
    L163:
        r47 = r48.getWidth();
        r116 = r48.getHeight();
        goto L164
    L159:
        r49 = ((LivePreviewStreamSurfaceViewConfig) xj0.a.getValue()).getPreviewSurfaceRender();
    L164:
        if (r47 <= 0) goto L185;
        if (r116 <= 0) goto L185;
        if (LivePlatformPlayerManager.g().getEnableV1() == false) goto L175;
        AbsLivePlayerView r50 = R8();
        if ((r50 instanceof LivePlayerView) == true) goto L171;
        r50 = null;
    L171:
        LivePlayerView r51 = (LivePlayerView) r50;
        if (r51 == null) goto L183;
        Bitmap r52 = r51.getPreSceneRenderBitmap();
    L184:
        this.F = r52;
    L183:
        r52 = null;
        goto L184
    L175:
        if (r113.isAvailable() == false) goto L183;
        Context r53 = ((Widget) this).context;
        if (r53 == null) goto L179;
        Resources r54 = r53.getResources();
        Bitmap r55 = Bitmap.createBitmap(WindowDisplayMetricsOverride.apply(r54, r54.getDisplayMetrics()), r47, r116, Bitmap.Config.RGB_565);
    L180:
        this.F = r55;
        if (r55 == null) goto L183;
        r52 = r113.getBitmap(r55);
        goto L184
    L179:
        r55 = Bitmap.createBitmap(r47, r116, Bitmap.Config.RGB_565);
    L185:
        Bq(r47, r116);
        if (this.D != null) goto L188;
    L201:
        Xr();
        goto L202
    L188:
        if (this.U2.getEnterSmooth() == false) goto L201;
        if (Cr() == true) goto L197;
        ILivePlayerClient r56 = dr();
        if (r56 == null) goto L198;
        LivePlayerClientContext r57 = r56.context();
        if (r57 == null) goto L198;
        if (r57.isPreviewSurfaceView() == true) goto L197;
    L198:
        ImageView r58 = this.D;
        if (r58 == null) goto L202;
        r58.post(new com.bytedance.android.live.platformplayer.layout.p(this, r45));
    L197:
        Mq();
    L147:
        r46 = false;
    L202:
        View r59 = r111.getSelfView();
        if ((r59 instanceof SurfaceRenderView) == true) goto L206;
        r59 = null;
    L206:
        if (((SurfaceRenderView) r59) == null) goto L269;
        AbsLivePlayerView r60 = R8();
        if ((r60 instanceof LivePlayerView) == true) goto L210;
        r60 = null;
    L210:
        LivePlayerView r61 = (LivePlayerView) r60;
        if (r61 == null) goto L250;
        Bitmap r62 = r61.getPreSceneRenderBitmap();
        if (r62 == null) goto L250;
        if (r62.getWidth() <= 0) goto L439;
        if (r62.getHeight() <= 0) goto L439;
        if (((Boolean) fn.a.getValue()).booleanValue() == true) goto L222;
    L248:
        this.F = r62;
        Bq(r62.getWidth(), r62.getHeight());
        goto L250
    L222:
        if (this.j == false) goto L248;
        if (((Boolean) en.a.getValue()).booleanValue() == true) goto L226;
    L228:
        boolean r63 = false;
    L229:
        if (r63 == true) goto L248;
        if (r62.getWidth() >= r62.getHeight()) goto L243;
        Context r65 = ((Widget) this).context;
        if (r65 == null) goto L242;
        Intent r66 = ((Activity) r65).getIntent();
        if (r66 == null) goto L237;
        int r67 = r66.getIntExtra("vertical_view_pager_height", 0);
    L238:
        if (r67 <= 0) goto L439;
        float r68 = r67 / r62.getHeight();
        int r69 = (int) (r62.getWidth() * r68);
    L247:
        Matrix r70 = new Matrix();
        r70.preScale(r68, r68);
        this.F = Bitmap.createBitmap(r62, 0, 0, r62.getWidth(), r62.getHeight(), r70, true);
        Bq(r69, r67);
        goto L250
    L237:
        r67 = 0;
        goto L238
    L242:
        throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");
    L243:
        r69 = s1.y();
        if (r69 <= 0) goto L439;
        r68 = r69 / r62.getWidth();
        r67 = (int) (r62.getHeight() * r68);
        goto L247
    L226:
        if (wr() == false) goto L228;
        r63 = true;
    L250:
        if (this.D != null) goto L252;
    L256:
        Xr();
        goto L269
    L252:
        if (this.U2.getEnterSmooth() == false) goto L256;
        Mq();
        ImageView r71 = this.D;
        if (r71 == null) goto L269;
        r71.post(new com.bytedance.android.live.platformplayer.layout.q(this, r45));
    L258:
        if (Cr() == true) goto L265;
        ILivePlayerClient r72 = dr();
        if (r72 == null) goto L266;
        LivePlayerClientContext r73 = r72.context();
        if (r73 == null) goto L266;
        if (r73.isPreviewSurfaceView() == true) goto L265;
    L266:
        Xr();
    L265:
        Mq();
    L439:
        if (((Boolean) u6.a.getValue()).booleanValue() == true) goto L441;
    L465:
        ILiveParentLoadingView r74 = null;
    L467:
        if (((Boolean) ci0.a.getValue()).booleanValue() == false) goto L469;
        ALogger.d("LivePlayer", "WeakOnGlobalLayoutListener.addOnGlobalLayout " + R8().getRenderView().getSelfView().getViewTreeObserver().hashCode());
        R8().getRenderView().getSelfView().getViewTreeObserver().addOnGlobalLayoutListener(new c(new WeakReference(this)));
    L470:
        this.n = new v9(new n(this), R8().getRenderView());
        ILiveParentLoadingView r75 = ((Widget) this).context;
        if ((r75 instanceof ILiveParentLoadingView) == true) goto L473;
        r75 = r74;
    L473:
        this.p = r75;
        if (dr() != null) goto L476;
    L494:
        this.z = s1.getResources().getConfiguration();
        sr();
        d8 r76 = this.s;
        DataCenter r77 = ((Widget) this).dataCenter;
        if (r76.b == false) goto L497;
        com.bytedance.android.live.revenue.core.util.h.d(kc0.j.class).markAddPkBackground(r76.w, true);
    L497:
        r76.a = r77;
        InteractPlayViewManager r78 = new InteractPlayViewManager(((Widget) this).dataCenter, ((Widget) this).context);
        this.t = r78;
        r78.updateRoom(bs());
        DataCenter r79 = ((Widget) this).dataCenter;
        if (r79 == null) goto L500;
        r79.observeForever("cmd_pk_state_change", this);
    L500:
        DataCenter r80 = ((Widget) this).dataCenter;
        if (r80 == null) goto L503;
        r80.observeForever("cmd_multi_state_change", this);
    L503:
        DataCenter r81 = ((Widget) this).dataCenter;
        if (r81 == null) goto L506;
        r81.observeForever("cmd_pc_landscape_close_dynamic_1v6", this);
    L506:
        DataCenter r82 = ((Widget) this).dataCenter;
        if (r82 == null) goto L509;
        r82.observeForever("data_adjust_widget_to_pk_mode", this);
    L509:
        DataCenter r83 = ((Widget) this).dataCenter;
        if (r83 == null) goto L512;
        r83.observeForever("data_pull_stream_change", this);
    L512:
        ILivePlayerClient r84 = dr();
        if (r84 == null) goto L515;
        r84.addMixedAudioHandler(this.g1);
    L515:
        ILivePlayerClient r85 = dr();
        if (r85 == null) goto L518;
        r85.registerMuteAudioCheck(this.b1);
    L518:
        Er("load playerWidget@" + hashCode() + ", playerView@" + R8().hashCode() + ", hasSharePlayer : " + this.U2.l());
        if (this.U2.u() == true) goto L521;
        return;
    L521:
        if (((Boolean) m40.a.getValue()).booleanValue() == false) goto L525;
        R8().shouldCheckRenderViewParent(false);
        return;
    L525:
        return;
    L476:
        if (this.U2.isSmoothEnterDoubleRender() == true) goto L483;
        if (this.U2.isLiveHeadEnterSmooth() == true) goto L483;
        ds0.d r86 = this.U2;
        if (r86.q == true) goto L483;
        rr(r86.getStreamType(), this.U2.h());
    L483:
        if (this.U2.getEnterSmooth() == true) goto L494;
        ILivePlayerClient r87 = dr();
        if (r87 == null) goto L492;
        IRoomEventHub r88 = r87.getEventHub();
        if (r88 == null) goto L492;
        MutableLiveData r89 = r88.getPlaying();
        if (r89 == null) goto L492;
        r74 = (Boolean) r89.getValue();
    L492:
        if ((!Intrinsics.areEqual(r74, r28)) == false) goto L494;
        Xk("init");
        goto L494
    L469:
        R8().getRenderView().getSelfView().getViewTreeObserver().addOnGlobalLayoutListener(new m(this));
        goto L470
    L441:
        if (TextUtils.isEmpty(this.L) == true) goto L447;
        d8 r90 = this.s;
        String r91 = this.L;
        if (r91 == null) goto L446;
        r18 = r91;
    L446:
        r90.a(r18, R8(), this.U2, this.z);
        goto L465
    L447:
        r74 = null;
        com.bytedance.android.livesdk.chatroom.o r92 = IRoomContextService.a.a(jc1.k.n(IRoomContextService.class), null, 0, 3);
        if (r92 == null) goto L467;
        Room r93 = r92.getCurrentRoom();
        if (r93 == null) goto L467;
        ILivePlayerClient r94 = LivePlatformPlayerManager.c(r93.getId(), false).player();
        if (r94 == null) goto L456;
        LivePlayerClientContext r95 = r94.context();
        if (r95 == null) goto L456;
        PlayerFirstFrameInfo r96 = r95.getFirstFrameInfo();
    L457:
        if (r96 == null) goto L467;
        if ((System.currentTimeMillis() - r96.getTs()) >= 3000) goto L467;
        d8 r97 = this.s;
        String r98 = r96.getSei();
        if (r98 == null) goto L464;
        r18 = r98;
    L464:
        r97.a(r18, R8(), this.U2, this.z);
    L456:
        r96 = null;
    L269:
        if (this.U2.isLiveHeadEnterSmooth() == false) goto L276;
        ILivePlayerClient r99 = LivePlatformPlayerManager.a(this.U2.x(), this.U2.isPseudo());
        if (r99 == null) goto L439;
        if (r99.getRenderView() == null) goto L276;
        r99.unmute();
        Mq();
        R8().postDelayed(this.H, ((VideoHeadSurfaceControlConfig) r9.a.getValue()).getForceResetDelay());
    L276:
        M30(s1.y(), "UpdateShareRenderView");
        goto L439
    L277:
        Ur(com.bytedance.android.live.core.utils.a0.l(((Widget) this).dataCenter, true), null);
        if (this.U2.l() == false) goto L431;
        Er("loadSharedPlayer() use shared player ");
        if (TextUtils.isEmpty(this.U2.getEnterRoomInfo().getLinkerMap()) == true) goto L282;
        Fq();
    L282:
        ILivePlayerClient r100 = LivePlatformPlayerManager.a(this.U2.x(), this.U2.isPseudo());
        if (r100 == null) goto L439;
        IRenderView r101 = r100.getRenderView();
        if (r101 == null) goto L429;
        r100.unmute("LivePlayerWidget.loadSharedPlayer");
        if (this.U2.getEnterSmooth() == true) goto L290;
    L427:
        Wr();
    L428:
        M30(s1.y(), "UpdateShareRenderView");
        goto L439
    L290:
        if (tr() == false) goto L294;
        if (this.H1 == false) goto L427;
    L294:
        if (((Boolean) wj0.a.getValue()).booleanValue() == false) goto L427;
        if (this.U2.isSmoothEnterDoubleRender() == true) goto L298;
        View r119 = r101.getSelfView();
        if ((r119 instanceof TextureView) == true) goto L310;
        r119 = null;
    L310:
        TextureView r120 = (TextureView) r119;
        if (r120 == null) goto L372;
        Context r121 = getContext();
        if (r121 == null) goto L317;
        String r122 = r121.toString();
        if (r122 == null) goto L317;
        boolean r102 = StringsKt.contains$default(r122, "DetailActivity", false, 2, null);
    L318:
        if (r102 == true) goto L372;
        int r103 = r120.getWidth();
        int r123 = r120.getHeight();
        AbsLivePlayerView r124 = R8();
        if ((r124 instanceof LivePlayerView) == true) goto L322;
        r124 = null;
    L322:
        LivePlayerView r125 = (LivePlayerView) r124;
        if (r125 == null) goto L334;
        Bitmap r126 = r125.getPreSceneRenderBitmap();
        if (r126 == null) goto L334;
        if (Build.VERSION.SDK_INT >= 24) goto L329;
        boolean r104 = false;
    L330:
        if (r104 == false) goto L334;
        if (r103 == 0) goto L333;
        if (r123 != 0) goto L334;
    L333:
        r103 = r126.getWidth();
        r123 = r126.getHeight();
        goto L334
    L329:
        r104 = ((LivePreviewStreamSurfaceViewConfig) xj0.a.getValue()).getPreviewSurfaceRender();
    L334:
        if (r103 <= 0) goto L355;
        if (r123 <= 0) goto L355;
        if (LivePlatformPlayerManager.g().getEnableV1() == false) goto L345;
        AbsLivePlayerView r105 = R8();
        if ((r105 instanceof LivePlayerView) == true) goto L341;
        r105 = null;
    L341:
        LivePlayerView r106 = (LivePlayerView) r105;
        if (r106 == null) goto L353;
        Bitmap r107 = r106.getPreSceneRenderBitmap();
    L354:
        this.F = r107;
    L353:
        r107 = null;
        goto L354
    L345:
        if (r120.isAvailable() == false) goto L353;
        Context r108 = ((Widget) this).context;
        if (r108 == null) goto L349;
        Resources r109 = r108.getResources();
        Bitmap r127 = Bitmap.createBitmap(WindowDisplayMetricsOverride.apply(r109, r109.getDisplayMetrics()), r103, r123, Bitmap.Config.RGB_565);
    L350:
        this.F = r127;
        if (r127 == null) goto L353;
        r107 = r120.getBitmap(r127);
        goto L354
    L349:
        r127 = Bitmap.createBitmap(r103, r123, Bitmap.Config.RGB_565);
    L355:
        Aq(r103, r123);
        if (this.D != null) goto L358;
    L371:
        Wr();
        goto L372
    L358:
        if (this.U2.getEnterSmooth() == false) goto L371;
        if (Cr() == true) goto L367;
        ILivePlayerClient r128 = dr();
        if (r128 == null) goto L368;
        LivePlayerClientContext r129 = r128.context();
        if (r129 == null) goto L368;
        if (r129.isPreviewSurfaceView() == true) goto L367;
    L368:
        ImageView r130 = this.D;
        if (r130 == null) goto L372;
        r130.post(new com.bytedance.android.live.platformplayer.layout.n(this, r100));
    L367:
        Mq();
    L317:
        r102 = false;
    L372:
        View r131 = r101.getSelfView();
        if ((r131 instanceof SurfaceRenderView) == true) goto L376;
        r131 = null;
    L376:
        if (((SurfaceRenderView) r131) == null) goto L428;
        AbsLivePlayerView r132 = R8();
        if ((r132 instanceof LivePlayerView) == true) goto L380;
        r132 = null;
    L380:
        LivePlayerView r133 = (LivePlayerView) r132;
        if (r133 == null) goto L420;
        Bitmap r134 = r133.getPreSceneRenderBitmap();
        if (r134 == null) goto L420;
        if (r134.getWidth() <= 0) goto L439;
        if (r134.getHeight() <= 0) goto L439;
        if (((Boolean) fn.a.getValue()).booleanValue() == true) goto L392;
    L418:
        this.F = r134;
        Aq(r134.getWidth(), r134.getHeight());
        goto L420
    L392:
        if (this.j == false) goto L418;
        if (((Boolean) en.a.getValue()).booleanValue() == true) goto L396;
    L398:
        boolean r135 = false;
    L399:
        if (r135 == true) goto L418;
        if (r134.getWidth() >= r134.getHeight()) goto L413;
        Context r136 = ((Widget) this).context;
        if (r136 == null) goto L412;
        Intent r137 = ((Activity) r136).getIntent();
        if (r137 == null) goto L407;
        int r138 = r137.getIntExtra("vertical_view_pager_height", 0);
    L408:
        if (r138 <= 0) goto L439;
        float r139 = r138 / r134.getHeight();
        int r140 = (int) (r134.getWidth() * r139);
    L417:
        Matrix r141 = new Matrix();
        r141.preScale(r139, r139);
        this.F = Bitmap.createBitmap(r134, 0, 0, r134.getWidth(), r134.getHeight(), r141, true);
        Aq(r140, r138);
        goto L420
    L407:
        r138 = 0;
        goto L408
    L412:
        throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");
    L413:
        r140 = s1.y();
        if (r140 <= 0) goto L439;
        r139 = r140 / r134.getWidth();
        r138 = (int) (r134.getHeight() * r139);
        goto L417
    L396:
        if (wr() == false) goto L398;
        r135 = true;
    L420:
        if (this.D != null) goto L422;
    L426:
        Wr();
        goto L428
    L422:
        if (this.U2.getEnterSmooth() == false) goto L426;
        Mq();
        ImageView r142 = this.D;
        if (r142 == null) goto L428;
        r142.post(new com.bytedance.android.live.platformplayer.layout.o(this, r100));
        goto L428
    L298:
        if (Cr() == true) goto L305;
        ILivePlayerClient r143 = dr();
        if (r143 == null) goto L306;
        LivePlayerClientContext r144 = r143.context();
        if (r144 == null) goto L306;
        if (r144.isPreviewSurfaceView() == true) goto L305;
    L306:
        Wr();
    L305:
        Mq();
        goto L306
    L429:
        R8().setScaleType(2);
        goto L439
    L431:
        if (((PlayerOptimizeConfig) is0.c.c().getConfig(PlayerOptimizeConfig.class)).getOptimizeStartStreamSize() == false) goto L437;
        ILivePlayerClient r145 = R8().getClient();
        if (r145 == null) goto L439;
        if (r145.isVideoHorizontal() != true) goto L439;
        R8().setScaleType(0);
        goto L439
    L437:
        R8().setScaleType(2);
        goto L439
    L93:
        r34 = null;
    L109:
        r22.getStartPull().observeForever(this.M2, true);
    L87:
        r32 = null;
        goto L89
    L110:
        r22.getStartPull().observeForever(this.M2, true);
        goto L111
    L77:
        r22.getInitRoom().observe(this, new com.bytedance.android.live.platformplayer.layout.u(this));
    L70:
        r27 = null;
        goto L71
    L55:
        r19 = null;
        goto L56
    L51:
        r16 = null;
        goto L52
    }

    public final void onMessage(tlc.d r19) {
        Room r9 = null;
        if ((r19 instanceof z3) == true) goto L5;
        tlc.d r0 = null;
    L6:
        z3 r1 = (z3) r0;
        if (r1 == null) goto L32;
        if (Intrinsics.areEqual(r19.getMessageMethod(), "WebcastRoomBackgroundMessage") == true) goto L12;
        r1 = null;
    L12:
        if (r1 == null) goto L32;
        py.k r2 = ((z3) r19).getRoomBackground();
        Room r3 = this.U2.w();
        if (r3 == null) goto L16;
        LiveMode r4 = r3.getStreamType();
    L18:
        if (r4 != LiveMode.SCREEN_RECORD) goto L32;
        Room r5 = this.U2.w();
        if (r5 == null) goto L22;
        LiveMode r6 = r5.getStreamType();
    L24:
        if (r6 != LiveMode.THIRD_PARTY) goto L32;
        HSImageView r7 = ((Widget) this).containerView.findViewById(2131392252);
        if (Build.VERSION.SDK_INT < 23) goto L29;
        r7.setForeground(r7.getContext().getDrawable(2131108058));
    L30:
        ImageLoader.bindImage(r7, r2, false);
        Er("update background");
        goto L32
    L29:
        View r8 = ((Widget) this).containerView.findViewById(2131392253);
        UIUtils.setViewVisibility(r8, 0);
        r8.setBackgroundResource(2131108058);
        goto L30
    L22:
        r6 = null;
        goto L24
    L16:
        r4 = null;
    L32:
        if ((r19 instanceof com.bytedance.android.live.base.model.message.y0) == true) goto L34;
        tlc.d r10 = null;
    L35:
        com.bytedance.android.live.base.model.message.y0 r11 = (com.bytedance.android.live.base.model.message.y0) r10;
        if (r11 == null) goto L73;
        if (Intrinsics.areEqual(r19.getMessageMethod(), "WebcastGameBackgroundImageMessage") == false) goto L40;
        com.bytedance.android.live.base.model.message.y0 r12 = r11;
    L41:
        if (r12 == null) goto L73;
        StringBuilder r13 = new StringBuilder("changeBackground room id ");
        r13.append(this.U2.x());
        r13.append(" check msg valid ");
        py.k r14 = r12.getImage();
        if (r14 == null) goto L45;
        Boolean r15 = Boolean.valueOf(r14.isValid());
    L46:
        r13.append(r15);
        ALogger.i("ServerBlur", r13.toString());
        py.k r16 = r12.getImage();
        if (r16 != null) goto L49;
    L71:
        ALogger.i("ServerBlur", "changeBackground error room id " + this.U2.x());
        goto L73
    L49:
        if (r16.isValid() != true) goto L71;
        if (this.Q != null) goto L71;
        if (com.bytedance.android.livesdk.performance.i0.b.booleanValue() == false) goto L71;
        if (vr() == false) goto L71;
        if (this.R == null) goto L71;
        ViewGroup r17 = ((Widget) this).containerView;
        if (r17 == null) goto L71;
        HSImageView r18 = r17.findViewById(2131392252);
        HSImageView r110 = ((Widget) this).containerView.findViewById(2131387947);
        if (r18 == null) goto L70;
        if (r110 == null) goto L70;
        ALogger.i("ServerBlur", "changeBackground room id " + this.U2.x() + "， changeMs:" + r12.v());
        ViewGroup.LayoutParams r20 = r110.getLayoutParams();
        r20.width = r18.getWidth();
        r20.height = r18.getHeight();
        Long r21 = r12.v();
        if (r21 == null) goto L68;
        long r22 = r21.longValue();
    L69:
        r110.setVisibility(8);
        ImageLoader.bindImage(r110, this.R, new com.bytedance.android.live.platformplayer.layout.l(this, r110, r18, r12, (long) (r22 * 0.5f)));
        goto L73
    L68:
        r22 = 0;
    L70:
        ALogger.i("ServerBlur", "changeBackground error room id " + this.U2.x());
        goto L73
    L45:
        r15 = null;
        goto L46
    L40:
        r12 = null;
    L73:
        if ((r19 instanceof VrTransferMessage) == true) goto L75;
        tlc.d r23 = null;
    L76:
        VrTransferMessage r24 = (VrTransferMessage) r23;
        if (r24 != null) goto L79;
        return;
    L79:
        if (Intrinsics.areEqual(((VrTransferMessage) r19).getMessageMethod(), "WebcastVrTransferMessage") == true) goto L82;
        r24 = null;
    L82:
        if (r24 == null) goto L113;
        ILivePlayerClient r25 = dr();
        if (r25 == null) goto L90;
        com.bytedance.android.live.platformplayer.service.a r26 = (com.bytedance.android.live.platformplayer.service.a) jc1.k.f(com.bytedance.android.live.platformplayer.service.a.class);
        if (r26 == null) goto L90;
        VrEffectDownloader r27 = r26.T0();
        if (r27 == null) goto L90;
        r27.d(r25, String.valueOf(r24.materailId));
    L90:
        LiveVrEffectInfo r28 = nr();
        r28.setMaterialId(r24.materailId);
        String r29 = r24.materialUrl;
        if (r29 == null) goto L93;
        r28.setMaterialUrl(r29);
    L93:
        List r30 = r24.getLayerStatusList();
        if (r30 == null) goto L96;
        r28.setLayerStatusList(r30);
    L96:
        Long r31 = r24.vrTransferType;
        if (r31 == null) goto L99;
        r28.setVrTransferType(r31.longValue());
    L99:
        com.bytedance.android.live.player.utils.b.c("LiveVrEffect", "LivePlayerWidget handleVrTransferMessage message:" + r24 + " vrEffectManagerVrEffectInfoOrNew:" + r28);
        RoomContext r32 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r32 == null) goto L104;
        com.bytedance.live.datacontext.m r33 = r32.getRoom();
        if (r33 == null) goto L104;
        r9 = (Room) r33.getValue();
    L104:
        if (r9 != null) goto L106;
    L108:
        boolean r111 = false;
    L109:
        if (r111 == true) goto L114;
        Gq(r28, false);
        return;
    L114:
        return;
    L106:
        if (Tr(r9, r28, false) == false) goto L108;
        r111 = true;
        goto L109
    L113:
        return;
    L75:
        r23 = r19;
        goto L76
    L34:
        r10 = r19;
        goto L35
    L5:
        r0 = r19;
        goto L6
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.bytedance.android.live.platformplayer.layout.LivePlayerWidget$updateRoomData$1] */
    public final void os(final IRoom r8) {
        ?? r0 = new LivePlayerWidget$updateRoomData$1(r8);
        IRoomContextService r1 = jc1.k.f(IRoomContextService.class);
        if (r1 == null) goto L5;
        com.bytedance.android.livesdk.chatroom.o r2 = IRoomContextService.a.a(r1, null, 0, 3);
    L6:
        DataCenter r6 = ((Widget) this).dataCenter;
        if (r6 == null) goto L11;
        IRoom r7 = com.bytedance.android.live.core.utils.a0.n(r6);
        if (r7 == null) goto L11;
        r0.invoke(r7);
    L11:
        if (r2 == null) goto L15;
        Room r9 = r2.S1();
        if (r9 == null) goto L15;
        r0.invoke(r9);
    L15:
        if (r2 == null) goto L21;
        com.bytedance.live.datacontext.m r3 = r2.getRoom();
        if (r3 == null) goto L21;
        IRoom r4 = (IRoom) r3.getValue();
        if (r4 == null) goto L21;
        r0.invoke(r4);
    L21:
        Room r5 = this.U2.w();
        if (r5 == null) goto L24;
        r0.invoke(r5);
    L24:
        IBaseStreamUrl r10 = r8.getStreamUrl();
        if (r10 == null) goto L27;
        this.U2.b(r10);
    L27:
        IRoomContextService r11 = jc1.k.f(IRoomContextService.class);
        if (r11 == null) goto L34;
        com.bytedance.android.livesdk.chatroom.o r12 = IRoomContextService.a.a(r11, null, 0, 3);
        if (r12 == null) goto L34;
        com.bytedance.live.datacontext.j r13 = r12.getMultiCameraContext();
        if (r13 == null) goto L34;
        ViewModel r14 = (ViewModel) r13.getValue();
    L36:
        if ((r14 instanceof ou2.a) == true) goto L38;
        r14 = null;
    L38:
        ou2.a r15 = (ou2.a) r14;
        if (r15 == null) goto L43;
        com.bytedance.live.datacontext.k r16 = r15.getDataChanged();
        if (r16 == null) goto L43;
        r16.post(2);
    L43:
        dq1.a r17 = pm1.f.a();
        if (r17 == null) goto L47;
        r17.z4(null);
        return;
    L47:
        return;
    L34:
        r14 = null;
        goto L36
    L5:
        r2 = null;
        goto L6
    }

    public final void pr(Room r7) {
        if (LiveVr6DofEffectConfig.INSTANCE.getDisable() == false) goto L6;
        return;
    L6:
        if (r7.isVrRoom() == false) goto L8;
        LivePluginSPIManager.e.getClass();
        LivePluginSPIManager.a().requireByUser("LivePlayer");
    L8:
        StringBuilder r0 = new StringBuilder("handleRoomForVr room.others?.vrInfo=");
        RoomOthersData r1 = r7.others;
        VideoEffectInitConfigBuilder r2 = null;
        if (r1 == null) goto L11;
        VrInfo r3 = r1.getVrInfo();
    L12:
        r0.append(r3);
        com.bytedance.android.live.player.utils.b.c("LiveVrEffect", r0.toString());
        RoomOthersData r4 = r7.others;
        if (r4 == null) goto L58;
        VrInfo r5 = r4.getVrInfo();
        if (r5 == null) goto L60;
        DataCenter r6 = ((Widget) this).dataCenter;
        if (r6 == null) goto L20;
        r6.observe("cmd_interact_state_change", this);
    L20:
        LiveVrEffectInfo r8 = nr();
        r8.setVrTransferType(r5.getVrTransferType());
        r8.setStreamMapping(r5.getStreamMapping());
        VrSixdofTransferInfo r9 = r5.getVrSixdofTransferInfo();
        if (r9 == null) goto L23;
        long r10 = r9.getMaterialId();
    L24:
        r8.setMaterialId(r10);
        VrSixdofTransferInfo r11 = r5.getVrSixdofTransferInfo();
        if (r11 == null) goto L28;
        String r12 = r11.getMaterialUrl();
        if (r12 == null) goto L28;
    L29:
        r8.setMaterialUrl(r12);
        VrSixdofTransferInfo r13 = r5.getVrSixdofTransferInfo();
        if (r13 == null) goto L32;
        List r14 = VrSixdofTransferInfoExtKt.getLayerStatusList(r13);
    L33:
        r8.setLayerStatusList(r14);
        r8.setRoomId(String.valueOf(r7.id));
        Room r15 = bs();
        if (r15 == null) goto L44;
        Map r16 = r15.getLinkMap();
        if (r16 == null) goto L44;
        if (r16.containsKey(String.valueOf(1)) == false) goto L42;
    L45:
        boolean r17 = true;
    L46:
        r8.setRoomIsInInteraction(Boolean.valueOf(r17));
        ILivePlayerClient r18 = dr();
        if (r18 == null) goto L55;
        com.bytedance.android.live.platformplayer.service.a r19 = (com.bytedance.android.live.platformplayer.service.a) jc1.k.f(com.bytedance.android.live.platformplayer.service.a.class);
        if (r19 == null) goto L53;
        VrEffectDownloader r20 = r19.T0();
        if (r20 == null) goto L53;
        r2 = r20.f(r18);
    L53:
        r8.setConfigBuilder(r2);
    L55:
        if (Tr(r7, r8, true) == true) goto L59;
        Gq(r8, false);
        return;
    L59:
        return;
    L42:
        if (r16.containsKey(String.valueOf(7)) == true) goto L45;
    L44:
        r17 = false;
        goto L46
    L32:
        r14 = null;
    L28:
        r12 = "";
        goto L29
    L23:
        r10 = 0;
        goto L24
    L60:
        return;
    L58:
        return;
    L11:
        r3 = null;
        goto L12
    }

    public final void qs(boolean r6) {
        IRoomContextService r0 = jc1.k.f(IRoomContextService.class);
        Boolean r1 = null;
        if (r0 == null) goto L8;
        com.bytedance.android.livesdk.chatroom.o r2 = IRoomContextService.a.a(r0, null, 0, 3);
        if (r2 == null) goto L8;
        r1 = r2.isVSRoom();
    L8:
        if (Intrinsics.areEqual(r1, Boolean.TRUE) == false) goto L10;
        return;
    L10:
        if (((Boolean) g50.a.getValue()).booleanValue() == false) goto L23;
        ViewGroup r3 = ((Widget) this).containerView;
        if (r3 == null) goto L16;
        View r4 = r3.findViewById(2131392323);
        if (r4 == null) goto L16;
        UtilityKotlinExtentionsKt.z(r4, r6);
    L16:
        String r5 = this.y;
        StringBuilder r7 = new StringBuilder("set video landscape background ");
        if (r6 == false) goto L19;
        String r8 = "visible";
    L20:
        r7.append(r8);
        r7.append(", roomId = ");
        r7.append(this.U2.x());
        ALogger.d(r5, r7.toString());
        return;
    L19:
        r8 = "gone";
        goto L20
    }

    @Override // gs0.c
    public final void rz(xj1.a r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.h = r2;
    }

    @Override // gs0.c
    public final void setNestedOutside(boolean r1) {
        this.j = r1;
    }

    @Override // gs0.c
    public final void setUserVisibleHint(boolean r2) {
        if (r2 == true) goto L4;
        return;
    L4:
        if (((com.bytedance.android.live.platformplayer.b) ar().invoke()).b() == false) goto L10;
        ILivePlayerClient r3 = dr();
        if (r3 == null) goto L11;
        r3.updateDisplayMode(DisplayMode.INNER);
        return;
    L11:
        return;
    }

    @Override // gs0.c
    public final void stopRoomWithoutReleasePlayer(boolean r4) {
        Er("stopRoomWithoutReleasePlayer()");
        this.F2.removeCallbacksAndMessages(null);
        A70();
        is2.d r0 = (is2.d) gr().invoke();
        if (r0 == null) goto L5;
        r0.endRoomV2(EndReason.STOP_WITHOUT_RELEASE_PLAYER.INSTANCE, r4);
    L5:
        DataCenter r5 = ((Widget) this).dataCenter;
        if (r5 == null) goto L10;
        se1.c r6 = (se1.c) r5.get("data_audience_backtrace_service");
        if (r6 == null) goto L10;
        r6.release();
    L10:
        com.bytedance.android.livesdk.chatroom.ui.background.a r7 = this.p0;
        if (r7 == null) goto L17;
        Disposable r1 = r7.d;
        if (r1 == null) goto L15;
        r1.dispose();
        r7.b = true;
    L15:
        r7.a = false;
        r7.c = null;
        r7.d = null;
        return;
    }

    @Override // gs0.c
    public final void tX(n1 r2) {
        Intrinsics.checkNotNullParameter(r2, "position");
        this.P = r2;
    }

    @Override // gs0.c
    public final void tp(q6 r1) {
        this.b = r1;
    }

    @Override // gs0.c
    public final void uZ(cs0.c r7) {
        Intrinsics.checkNotNullParameter(r7, "event");
        Er("switchQuality event.quality : " + r7.d);
        this.v = r7.h;
        if (r7.d == null) goto L26;
        if (this.U2.getCurState() == LiveRoomState.LIVE_STARTED) goto L7;
        return;
    L7:
        ds0.d r0 = this.U2;
        String r5 = r7.d.getName();
        r0.getClass();
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        this.U2.n = true;
        DataCenter r1 = ((Widget) this).dataCenter;
        if (r1 == null) goto L11;
        r1.put("action_switch_live_resolution", Boolean.TRUE);
    L11:
        if (((Boolean) cu0.a.getValue()).booleanValue() == false) goto L15;
        DataCenter r2 = ((Widget) this).dataCenter;
        if (r2 == null) goto L15;
        r2.put("action_switch_live_resolution_flag", Boolean.TRUE);
    L15:
        HashMap r3 = new HashMap();
        if (this.U2.w() == null) goto L18;
        com.bytedance.android.livesdk.log.j0.l().c(IRoom.class).u(r3, this.U2.w());
    L19:
        com.bytedance.android.livesdk.log.filter.o r4 = com.bytedance.android.livesdk.log.j0.l().c(am2.x.class);
        if (r4 == null) goto L22;
        r4.a(r3);
    L22:
        ILivePlayerClient r6 = dr();
        if (r6 == null) goto L53;
        r6.switchResolution(r7.d.getSdkKey(), r7.e, r3);
        return;
    L53:
        return;
    L18:
        com.bytedance.android.livesdk.log.j0.l().c(IRoom.class).a(r3);
        goto L19
    L26:
        if (TextUtils.isEmpty(r7.b) == false) goto L28;
        return;
    L28:
        ds0.d r8 = this.U2;
        String r9 = r7.a;
        r8.getClass();
        Intrinsics.checkNotNullParameter(r9, "<set-?>");
        this.U2.n = true;
        DataCenter r10 = ((Widget) this).dataCenter;
        if (r10 == null) goto L32;
        r10.put("action_switch_live_resolution", Boolean.TRUE);
    L32:
        if (((Boolean) cu0.a.getValue()).booleanValue() == false) goto L36;
        DataCenter r11 = ((Widget) this).dataCenter;
        if (r11 == null) goto L36;
        r11.put("action_switch_live_resolution_flag", Boolean.TRUE);
    L36:
        AbsLivePlayerView r12 = R8();
        if ((r12 instanceof LivePlayerView) == true) goto L39;
        r12 = null;
    L39:
        LivePlayerView r13 = (LivePlayerView) r12;
        if (r13 == null) goto L42;
        r13.disableDelayStopOrRelease();
    L42:
        ILivePlayerClient r14 = dr();
        if (r14 == null) goto L46;
        r14.stop();
    L46:
        if (r7.f == false) goto L48;
        this.U2.setDefaultMultiPullStreamData(r7.b);
        this.U2.setDefaultResolution(r7.g);
    L49:
        is2.d r15 = (is2.d) gr().invoke();
        if (r15 == null) goto L55;
        r15.startPullStreamV2("switch_quality", false);
        return;
    L55:
        return;
    L48:
        this.U2.setDefaultPullStreamUrl(r7.b);
        this.U2.setSdkParams(r7.c);
        goto L49
    }

    @Override // gs0.c
    public final void vR(boolean r3) {
        this.y1 = r3;
        if (((Boolean) cu.a.getValue()).booleanValue() == true) goto L5;
        Iq();
    L5:
        if (r3 == false) goto L35;
        ILivePlayerClient r4 = LivePlatformPlayerManager.f();
        if (r4 == null) goto L13;
        IRenderView r5 = r4.getRenderView();
        if (r5 == null) goto L13;
        View r6 = r5.getSelfView();
        if (r6 == null) goto L13;
        Integer r7 = Integer.valueOf(r6.getVisibility());
    L15:
        if (r7 != null) goto L18;
    L19:
        ILivePlayerClient r8 = LivePlatformPlayerManager.f();
        if (r8 == null) goto L26;
        IRenderView r9 = r8.getRenderView();
        if (r9 == null) goto L26;
        View r10 = r9.getSelfView();
        if (r10 == null) goto L26;
        r10.setVisibility(0);
    L26:
        AbsLivePlayerView r11 = R8();
        if (r11 != null) goto L29;
    L30:
        AbsLivePlayerView r12 = R8();
        if (r12 == null) goto L33;
        r12.setScaleType(2);
    L33:
        Wu("pc_customize_audio_room", false);
        return;
    L29:
        if (r11.getScaleType() == 2) goto L33;
    L18:
        if (r7.intValue() == 0) goto L26;
    L13:
        r7 = null;
        goto L15
    }

    @Override // gs0.c
    public final void zS(cs0.b r4) {
        Intrinsics.checkNotNullParameter(r4, "event");
        if (this.U2.getCurState() == LiveRoomState.LIVE_STARTED) goto L5;
        return;
    L5:
        HashMap r0 = new HashMap();
        if (this.U2.w() == null) goto L8;
        com.bytedance.android.livesdk.log.j0.l().c(IRoom.class).u(r0, this.U2.w());
    L9:
        com.bytedance.android.livesdk.log.j0.l().c(am2.x.class).a(r0);
        ILivePlayerClient r1 = dr();
        if (r1 == null) goto L13;
        r1.switchResolution(r4.a, r4.b, r0);
        return;
    L13:
        return;
    L8:
        com.bytedance.android.livesdk.log.j0.l().c(IRoom.class).a(r0);
        goto L9
    }

    public static String kr(StreamUrl r5, String r6) {
        if (r6 != null) goto L5;
    L8:
        boolean r1 = true;
    L10:
        if (r1 == false) goto L12;
        return null;
    L12:
        LiveCoreSDKData r2 = r5.getLiveCoreSDKData();
        if (r2 == null) goto L18;
        LiveCoreSDKData.PullData r3 = r2.pullData;
        if (r3 == null) goto L18;
        String r4 = r3.getStreamData();
        if (r4 == null) goto L18;
    L19:
        com.bytedance.android.live.player.utils.b.c("LivePlayer", "getStreamDataFromAllPullDatas, liveCoreSDKDataPullDataStreamData:" + r4 + ", pullDatas:" + r5.getPullDatas());
        if (StringsKt.contains$default(r4, r6, false, 2, null) == false) goto L23;
        return r4;
    L23:
        return r5.getMultiStreamDataFromPullDatas(r6);
    L18:
        r4 = "";
        goto L19
    L5:
        if (r6.length() == 0) goto L8;
        r1 = false;
        goto L10
    }

    public static String qr(String r6, ChangeCameraStreamEvent r7) {
        if (r7.getCameraType() == 0) goto L5;
        return r6;
    L5:
        if (r7.getCameraScene() == 1) goto L7;
        return r6;
    L7:
        if (((Boolean) kx0.a.getValue()).booleanValue() == true) goto L9;
        return r6;
    L9:
        if (StringsKt.contains$default(r6, "\\\"vr2d\\\":\\\"1\\\"", false, 2, null) == true) goto L11;
        return r6;
    L11:
        return StringsKt.replace$default(r6, "\\\"ContentType\\\":1", "\\\"ContentType\\\":0", false, 4, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void xq(LivePlayerWidget r7, LifecycleOwner r8) {
        r7.getClass();
        r7.Er("registerPlayerEvent " + r8);
        ds0.d r0 = r7.U2;
        if (r0 == null) goto L10;
        com.bytedance.android.livesdk.chatroom.room.p0 r1 = r0.e();
        if (r1 == null) goto L10;
        MutableLiveData r2 = r1.getTraceApmEvent();
        if (r2 == null) goto L10;
        r2.setValue("LPW.startPullObserved");
    L10:
        if (r7.Zq() == true) goto L12;
        LifecycleOwner r3 = r8;
    L16:
        ILivePlayerClient r4 = r7.dr();
        ILivePlayerExtraRenderController r5 = null;
        if (r4 == null) goto L19;
        IRoomEventHub r6 = r4.getEventHub();
    L21:
        if ((r6 instanceof IRoomEventHub) == true) goto L23;
        r6 = null;
    L23:
        if (r6 == null) goto L72;
        Boolean r9 = (Boolean) r6.getPlayPrepared().getValue();
        Boolean r10 = Boolean.TRUE;
        if (Intrinsics.areEqual(r9, r10) == false) goto L28;
        r7.Jq();
    L28:
        r6.getPlayPrepared().observe(r3, new k0(r7));
        r6.getFirstFrame().observe(r3, new q0(r7));
        r6.getSwitchResolutionResult().observe(r3, new r0(r7));
        if (Intrinsics.areEqual((Boolean) r6.getPlaying().getValue(), r10) == false) goto L35;
        r7.Qr();
        if (r7.N2 == true) goto L35;
        r7.N2 = true;
        if (Intrinsics.areEqual(m5.a.getValue(), r10) == false) goto L35;
        y50.g.b("playing is true");
    L35:
        r6.getPlaying().observe(r3, new s0(r7));
        r6.getStopped().observe(r3, new t0(r7));
        r6.getSeiUpdate().observe(r3, new u0(r7, r6));
        r6.getBinarySeiUpdate().observe(r3, new v0(r7));
        r6.getVideoSizeChanged().observe(r3, new w0(r7));
        r6.getPlayerMediaError().observe(r3, new x0(r7));
        r6.getPlayComplete().observe(r3, new e0(r7));
        r6.getPlayResume().observe(r3, new f0(r7));
        Ref.LongRef r11 = new Ref.LongRef();
        r11.element = 0;
        ArrayList r12 = new ArrayList();
        r6.getStallStart().observe(r3, new g0(r7, r11));
        r6.getStallEnd().observe(r3, new h0(r7, r11, r12));
        r6.getVideoRenderStall().observe(r3, new LivePlayerWidget$registerPlayerEvent$14());
        r6.getAudioRenderStall().observe(r3, new LivePlayerWidget$registerPlayerEvent$15());
        Result.Companion r13 = Result.Companion;     // Catch: Throwable -> L38
        r6.getVideoRenderStallNew().observe(r3, i0.a);     // Catch: Throwable -> L38
        Object r14 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L38
    L40:
        Throwable r15 = Result.exceptionOrNull-impl(r14);
        if (r15 == null) goto L70;
        r7.Er("Exception occurred when observe videoRenderStallNew: " + r15.getMessage());
    L70:
        r6.getAudioRenderStallNew().observe(r3, j0.a);     // Catch: Throwable -> L45
        Object r16 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L45
    L47:
        Throwable r17 = Result.exceptionOrNull-impl(r16);
        if (r17 == null) goto L50;
        r7.Er("Exception occurred when observe audioRenderStallNew: " + r17.getMessage());
    L50:
        r6.isSeiCropping().observe(r7, new l0(r7));
        r6.getReset().observeForever(r7.J2);
        r6.getBackgroundStopIn4G().observeForever(r7.K2);
        ILivePlayerClient r18 = r7.dr();
        if (r18 == null) goto L63;
        ILivePlayerExtraRenderController r19 = r18.extraRenderController();
        if (r19 == null) goto L63;
        if (r19.isGameRoom() == false) goto L57;
        r5 = r19;
    L57:
        if (r5 == null) goto L63;
        ILivePlayerExtraRenderController.EventHub r20 = r5.eventHub();
        if (r20 == null) goto L63;
        MutableLiveData r21 = r20.getExtraRenderIsShow();
        if (r21 == null) goto L63;
        r21.observe(r3, (Observer) r7.p2.getValue());
    L63:
        r6.getLayoutEvent().observe(r7, new n0(r7));
        LifecycleOwner r22 = r8;
        if (((LiveMemLeakConfig) com.bytedance.android.livesdk.j1.a.getValue()).getFixPlayerData() == false) goto L66;
        r22 = r3;
    L66:
        r6.getVrEffectEvent().observe(r22, new o0(r7));
        r6.getPlayPrepared().observe(r22, new p0(r7));
        return;
    L45:
        th = move-exception;
        Result.Companion r23 = Result.Companion;
        r16 = Result.constructor-impl(ResultKt.createFailure(th));
    L38:
        th = move-exception;
        Result.Companion r24 = Result.Companion;
        r14 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L40
    L72:
        return;
    L19:
        r6 = null;
        goto L21
    L12:
        if (LiveBgPlayUtil.a().e() == false) goto L14;
        r7.Er("使用自定义lifecycleOwner");
        r3 = (LifecycleOwner) r7.O2.getValue();
        goto L16
    L14:
        r3 = r7;
        goto L16
    }

    public static final void yq(LivePlayerWidget r3, int r4) {
        ds0.d r0 = r3.U2;
        if (r0.q == true) goto L5;
        return;
    L5:
        if (r3.I2 != true) goto L7;
        return;
    L7:
        if (r3.v2 == false) goto L9;
    L11:
        r3.Qq();
        r3.Er("surfaceControlRendered(" + r4 + ')');
        r3.I2 = true;
        return;
    L9:
        if (((Widget) r3).containerView == null) goto L11;
        r3.rr(r0.getStreamType(), r3.U2.h());
        goto L11
    }

    public final void Aq(int r9, int r10) {
        if (Hr(Rq(null)) == true) goto L5;
        this.D = new ImageView(((Widget) this).context);
        FrameLayout.LayoutParams r2 = new FrameLayout.LayoutParams(r9, r10);
        int r0 = 0;
        if (r9 <= r10) goto L18;
        DataCenter r11 = ((Widget) this).dataCenter;
        if (r11 == null) goto L17;
        Integer r12 = (Integer) r11.get("interaction_layer_margin_top", 0);
        if (r12 == null) goto L17;
        r0 = r12.intValue();
    L17:
        r2.gravity = 48;
        r2.topMargin = UtilityKotlinExtentionsKt.i(((Integer) cx0.a.getValue()).intValue()) + r0;
    L43:
        ImageView r13 = this.D;
        if (r13 == null) goto L46;
        r13.setLayoutParams(r2);
    L46:
        ImageView r14 = this.D;
        if (r14 == null) goto L49;
        r14.setScaleType(ImageView.ScaleType.CENTER_CROP);
    L49:
        ImageView r15 = this.D;
        if (r15 == null) goto L52;
        r15.setImageBitmap(this.F);
    L52:
        R8().addView(this.D);
        return;
    L18:
        r2.topMargin = 0;
        boolean r16 = a2.l(this.U2, ((Widget) this).dataCenter);
        if (this.s.b == true) goto L35;
        if (a2.k(this.U2, ((Widget) this).dataCenter) == true) goto L23;
        if (r16 == false) goto L35;
    L23:
        if (r16 == false) goto L28;
        InteractPlayViewManager r17 = this.t;
        if (r17 == null) goto L43;
        r17.updateRenderViewLPGravityIfNeed(R8().getRenderView(), 85, "addFrameView");
        goto L43
    L28:
        if ((R8() instanceof LivePlayerView) == false) goto L43;
        LivePlayerView r18 = R8();
        if (r18 == null) goto L33;
        r2 = a2.b(r2, r18, dr(), ((Widget) this).context, this.U2, ((Widget) this).dataCenter);
        goto L43
    L33:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdkapi.roomplayer.LivePlayerView");
    L35:
        if (this.U2.getStreamType() != LiveMode.SCREEN_RECORD) goto L40;
        if (((Boolean) ei0.a.getValue()).booleanValue() == false) goto L40;
        r2.gravity = 17;
    L40:
        if (wt2.h.f() == false) goto L42;
        r2.gravity = 1;
        goto L43
    L42:
        r2.gravity = 17;
        goto L43
    L5:
        if (this.q.booleanValue() == false) goto L54;
        AbsLivePlayerView r19 = R8();
        if (r19 == null) goto L55;
        r19.post(new e(this));
        return;
    L55:
        return;
    }

    public final void Bq(int r8, int r9) {
        if (Hr(Rq(null)) == true) goto L5;
        ms(this, "addFrameViewNew", 0, 0, null, null, 30);
        this.D = new ImageView(((Widget) this).context);
        com.bytedance.android.livesdk.player.layout.e r0 = this.L0;
        if (r0 == null) goto L62;
        boolean r3 = false;
        if (r0.m != 6) goto L29;
        if (Yq() != null) goto L17;
    L21:
        boolean r1 = false;
    L22:
        if (r1 == false) goto L29;
        DisplayRatio r2 = r0.n;
        if (r2 == null) goto L29;
        RenderViewInfo r4 = DisplayRatio.Companion.calculateRenderViewInfo(r2, r8, r9);
        if (r4 == null) goto L29;
        r8 = r4.getViewWidth();
        r9 = r4.getViewHeight();
        goto L29
    L17:
        if (Yq().getEnable() == false) goto L21;
        if (Yq().getEnterRoomOptEnable() == false) goto L21;
        r1 = true;
    L29:
        if (this.j == false) goto L45;
        ILivePlayerClient r5 = dr();
        if (r5 == null) goto L45;
        ILivePlayerSharedDataManager r6 = r5.sharedDataManager();
        if (r6 == null) goto L45;
        Object r7 = r6.getSharedData("disable_frame_view");
        if (r7 == null) goto L45;
        if ((r7 instanceof Boolean) == false) goto L45;
        ILivePlayerClient r10 = dr();
        if (r10 == null) goto L44;
        ILivePlayerSharedDataManager r11 = r10.sharedDataManager();
        if (r11 == null) goto L44;
        r11.removeSharedData("disable_frame_view");
    L44:
        r3 = ((Boolean) r7).booleanValue();
    L45:
        if (r3 == false) goto L49;
        ImageView r12 = this.D;
        if (r12 == null) goto L49;
        r12.setVisibility(4);
    L49:
        FrameLayout.LayoutParams r13 = new FrameLayout.LayoutParams(r8, r9);
        r13.gravity = r0.l;
        r13.rightMargin = r0.g;
        r13.bottomMargin = r0.f;
        r13.leftMargin = r0.e;
        r13.topMargin = r0.d;
        ImageView r14 = this.D;
        if (r14 == null) goto L52;
        r14.setLayoutParams(r13);
    L52:
        ImageView r15 = this.D;
        if (r15 == null) goto L55;
        r15.setScaleType(ImageView.ScaleType.CENTER_CROP);
    L55:
        ImageView r16 = this.D;
        if (r16 == null) goto L58;
        r16.setImageBitmap(this.F);
    L58:
        R8().addView(this.D);
        return;
    L62:
        return;
    L5:
        if (this.q.booleanValue() == false) goto L60;
        AbsLivePlayerView r17 = R8();
        if (r17 == null) goto L61;
        r17.post(new f(this));
        return;
    L61:
        return;
    }

    public final void Gq(LiveVrEffectInfo r6, boolean r7) {
        com.bytedance.android.live.player.utils.b.c("LiveVrEffect", "LivePlayerWidget applyVrEffectInfo info:" + r6 + ", disableConfigCover:" + r7);
        if (r6.getVrTransferType() > 0) goto L5;
        return;
    L5:
        ILivePlayerClient r0 = dr();
        if (r0 == null) goto L14;
        com.bytedance.android.live.platformplayer.service.a r1 = (com.bytedance.android.live.platformplayer.service.a) jc1.k.f(com.bytedance.android.live.platformplayer.service.a.class);
        if (r1 == null) goto L12;
        VrEffectDownloader r2 = r1.T0();
        if (r2 == null) goto L12;
        r2.c(r0, r6);
    L12:
        r0.applyVrEffect(r6, r7);
        return;
    }

    public final void Kq(VSCameraInfo r4, boolean r5) {
        AbsLivePlayerView r0 = R8();
        if ((r0 instanceof LivePlayerView) == true) goto L5;
        r0 = null;
    L5:
        LivePlayerView r1 = (LivePlayerView) r0;
        if (r1 == null) goto L8;
        r1.disableDelayStopOrRelease();
    L8:
        ILivePlayerClient r2 = dr();
        if (r2 == null) goto L11;
        r2.stop();
    L11:
        ALogger.i("LivePlayer", "changeStreamInternal(), change to sub camera: " + r5);
        ILivePlayerClient r3 = dr();
        if (r3 == null) goto L20;
        IRoomEventHub r6 = r3.getEventHub();
        if (r6 == null) goto L20;
        MutableLiveData r7 = r6.getPlayComplete();
        if (r7 == null) goto L20;
        if (r5 == false) goto L19;
        ds0.d r8 = this.U2;
        r8.m = r4;
        r7.observe(this, r8.r());
        goto L20
    L19:
        ds0.d r9 = this.U2;
        r9.m = null;
        r7.removeObserver(r9.r());
    L20:
        this.U2.c(r4);
        ILivePlayerClient r10 = dr();
        if (r10 == null) goto L23;
        int r11 = is0.b.a;
        r10.registerPlayerFeature(is0.b.a.b("multi_camera_switch"));
    L23:
        is2.d r12 = (is2.d) gr().invoke();
        if (r12 == null) goto L26;
        r12.startPullStreamV2("change_camera_stream", false);
    L26:
        com.bytedance.android.livesdk.vscore_api.paidlive.c r13 = com.bytedance.android.livesdk.vscore_api.paidlive.scope.g.c(this.U2.w());
        if (r4 == null) goto L29;
        long r14 = r4.cameraId;
    L30:
        r13.v0(r14);
        gs();
        return;
    L29:
        r14 = 0;
        goto L30
    }

    public final void Lq(IBaseStreamUrl r10, String r11) {
        if (r10 != null) goto L4;
        return;
    L4:
        AbsLivePlayerView r0 = R8();
        if ((r0 instanceof LivePlayerView) == true) goto L7;
        r0 = null;
    L7:
        LivePlayerView r1 = (LivePlayerView) r0;
        if (r1 == null) goto L10;
        r1.disableDelayStopOrRelease();
    L10:
        ILivePlayerClient r2 = dr();
        if (r2 == null) goto L13;
        r2.stop();
    L13:
        this.U2.b(r10);
        ILivePlayerClient r12 = dr();
        if (r12 == null) goto L16;
        int r3 = is0.b.a;
        r12.registerPlayerFeature(is0.b.a.b(r11));
    L16:
        is2.d r13 = (is2.d) gr().invoke();
        if (r13 == null) goto L20;
        r13.startPullStreamV2(r11, false);
    L20:
        if (Intrinsics.areEqual(r11, "refresh_paid_stream") == false) goto L37;
        com.bytedance.android.livesdk.log.j0 r14 = com.bytedance.android.livesdk.log.j0.l();
        Pair[] r15 = new Pair[7];
        String r4 = "0";
        r15[0] = TuplesKt.to("is_preview", "0");
        r15[1] = TuplesKt.to("reason", "buy_ticket");
        r15[2] = TuplesKt.to("refresh_action", "start_pull");
        IPaidLiveData r5 = com.bytedance.android.live.core.utils.a0.n(((Widget) this).dataCenter).getPaidLiveData();
        long r6 = 0;
        if (r5 == null) goto L26;
        Long r7 = r5.getAsyncAuthAB();
        if (r7 == null) goto L26;
        long r8 = r7.longValue();
    L27:
        r15[3] = TuplesKt.to("async_auth_ab", String.valueOf(r8));
        IPaidLiveData r9 = com.bytedance.android.live.core.utils.a0.n(((Widget) this).dataCenter).getPaidLiveData();
        if (r9 == null) goto L32;
        Long r16 = r9.needRefreshStream();
        if (r16 == null) goto L32;
        r6 = r16.longValue();
    L32:
        r15[4] = TuplesKt.to("async_auth_operate", String.valueOf(r6));
        if (com.bytedance.android.livesdk.vscore_api.paidlive.scope.g.d(((Widget) this).dataCenter).e1(PaidSceneEnum.PAID_ROOM) == false) goto L35;
        r4 = "1";
    L35:
        r15[5] = TuplesKt.to("view_right", r4);
        r15[6] = TuplesKt.to("current_camera_id", String.valueOf(com.bytedance.android.livesdk.vscore_api.paidlive.scope.g.d(((Widget) this).dataCenter).J0().w(((Widget) this).dataCenter)));
        r14.sendLog("livesdk_paidlive_switch_stream_data", MapsKt.mutableMapOf(r15), new Object[]{am2.x.class, IRoom.class});
        return;
    L26:
        r8 = 0;
        goto L27
    }

    @Override // gs0.c
    public final void M30(int r3, String r4) {
        Intrinsics.checkNotNullParameter(r4, "reason");
        if (this.c != null) goto L7;
        ALogger.w("LivePlayer", "resizeVideoView skip by uninitialized playerView, reason=".concat(r4));
        return;
    L7:
        if (((Boolean) com.bytedance.android.livesdk.a2.a.getValue()).booleanValue() == false) goto L9;
        as(R8().getWidth(), R8().getHeight(), r4, null);
        return;
    L9:
        as(r3, -1, r4, null);
    }

    public final void Ur(boolean r5, String r6) {
        ILivePlayerClient r0 = LivePlatformPlayerManager.f();
        if (r0 == null) goto L51;
        AbsLivePlayerView r1 = R8();
        LivePlayerView r3 = null;
        if ((r1 instanceof LivePlayerView) == true) goto L7;
        r1 = null;
    L7:
        LivePlayerView r2 = (LivePlayerView) r1;
        if (r2 == null) goto L13;
        IRenderView r4 = r2.getRenderView();
        if (r4 == null) goto L13;
        r4.setVrStyle(10000);
    L13:
        if ((!Intrinsics.areEqual(R8().getRenderView(), r0.getRenderView())) == false) goto L15;
        return;
    L15:
        if (r0.isVrLive() == false) goto L57;
        if (r6 == null) goto L28;
        if (r6.length() <= 0) goto L21;
        boolean r7 = true;
    L22:
        if (r7 == true) goto L25;
        r6 = null;
    L25:
        if (r6 == null) goto L28;
        R8().getRenderView().setVrMode(r0.checkSeiRawForVrMode(r6));
        goto L28
    L21:
        r7 = false;
    L28:
        if (VrUtils.e() == false) goto L41;
        LivePlayerView r8 = R8();
        if ((r8 instanceof LivePlayerView) == false) goto L33;
        r3 = r8;
    L33:
        LivePlayerView r9 = r3;
        if (r9 == null) goto L38;
        IRenderView r10 = r9.getRenderView();
        if (r10 == null) goto L38;
        r10.setVrStyle(10002);
    L38:
        IRenderView r11 = r0.getRenderView();
        if (r11 == null) goto L53;
        r11.setCurrentLandscape(!r5);
        return;
    L53:
        return;
    L41:
        LivePlayerView r12 = R8();
        if ((r12 instanceof LivePlayerView) == false) goto L45;
        r3 = r12;
    L45:
        LivePlayerView r13 = r3;
        if (r13 == null) goto L55;
        IRenderView r14 = r13.getRenderView();
        if (r14 == null) goto L56;
        r14.setVrStyle(10001);
        return;
    L56:
        return;
    L55:
        return;
    L57:
        return;
    }

    @Override // gs0.c
    public final void Wu(String r12, boolean r13) {
        Intrinsics.checkNotNullParameter(r12, "reason");
        LivePlayerSpmLogger.Companion.getClass();
        if (LivePlayerSpmLogger.access$getPlayerLoggerSimplifyV2$cp() == false) goto L9;
        HSImageView r1 = this.d;
        if (r1 != null) goto L7;
    L8:
        Er("hide background, widget " + hashCode());
    L10:
        ds0.d r2 = this.U2;
        if (r2 == null) goto L17;
        com.bytedance.android.livesdk.chatroom.room.p0 r3 = r2.e();
        if (r3 == null) goto L17;
        MutableLiveData r4 = r3.getTraceApmEvent();
        if (r4 == null) goto L17;
        r4.setValue("LPW.hideBackground: ".concat(r12));
    L17:
        boolean r5 = true;
        if (r13 == false) goto L51;
        HSImageView r14 = this.d;
        if (r14 != null) goto L22;
    L24:
        boolean r15 = false;
    L25:
        com.bytedance.android.live.platformplayer.b r6 = (com.bytedance.android.live.platformplayer.b) ar().invoke();
        if (r6.isUserVisible() == false) goto L28;
    L31:
        boolean r7 = true;
    L32:
        if (r7 == false) goto L51;
        Pair[] r8 = new Pair[3];
        r8[0] = TuplesKt.to("event_name", "liveplay_background_status_check");
        r8[1] = TuplesKt.to("view_bg_reason", r12);
        if (r15 == false) goto L36;
        String r9 = "show";
    L37:
        r8[2] = TuplesKt.to("view_bg_status", r9);
        com.bytedance.android.livesdk.log.b0.o().b("ttlive_room", MapsKt.mapOf(r8));
        if (r15 == false) goto L51;
        com.bytedance.android.livesdk.log.filter.u r16 = com.bytedance.android.livesdk.log.j0.l().c(IRoom.class);
        String r10 = "";
        if ((r16 instanceof com.bytedance.android.livesdk.log.filter.u) == false) goto L49;
        com.bytedance.android.livesdk.log.filter.u r17 = r16;
        if (r17.getMap().containsKey("room_id") == false) goto L44;
        String r11 = (String) r17.getMap().get("room_id");
    L46:
        if (r17.getMap().containsKey("anchor_id") == false) goto L48;
        r10 = (String) r17.getMap().get("anchor_id");
    L48:
        String r18 = r11;
        String r19 = r17.n();
        String r110 = r10;
        r10 = r18;
    L50:
        HashMap r20 = new HashMap();
        r20.put("reason", r12);
        r20.put("bg_view_status", "show");
        r20.put("room_id", r10);
        r20.put("anchor_id", r110);
        r20.put("user_id", r19);
        LiveSlardarMonitor.monitorStatus("ttlive_room_bg_view_status_check", 1, r20);
        goto L51
    L44:
        r11 = "";
        goto L46
    L49:
        r110 = "";
        r19 = r110;
        goto L50
    L36:
        r9 = "hide";
        goto L37
    L28:
        if (r6.c() == false) goto L31;
        r7 = false;
        goto L32
    L22:
        if (r14.getVisibility() != 0) goto L24;
        r15 = true;
    L51:
        ImageView r111 = this.d;
        if (r111 != null) goto L54;
    L57:
        if (r5 == true) goto L60;
        r111 = null;
    L60:
        if (r111 == null) goto L64;
        r111.setVisibility(8);
        View r112 = this.e;
        if (r112 == null) goto L64;
        r112.setVisibility(8);
    L64:
        HSImageView r113 = this.d;
        if (r113 != null) goto L67;
    L68:
        HSImageView r114 = this.d;
        if (r114 == null) goto L71;
        r114.setVisibility(8);
    L71:
        View r115 = this.e;
        if (r115 == null) goto L74;
        r115.setVisibility(8);
    L74:
        cs(false, r12);
        ILiveParentLoadingView r116 = this.p;
        if (r116 == null) goto L78;
        r116.hideBackground();
        return;
    L78:
        return;
    L67:
        if (r113.getVisibility() == 8) goto L74;
    L54:
        if (r111.getVisibility() != 8) goto L57;
        r5 = false;
        goto L57
    L7:
        if (r1.getVisibility() == 8) goto L10;
    L9:
        Er("hide background, widget " + hashCode());
        goto L10
    }

    public final void cs(boolean r10, String r11) {
        if (((Boolean) this.V.getValue()).booleanValue() == false) goto L5;
        return;
    L5:
        com.bytedance.android.live.platformplayer.b r0 = (com.bytedance.android.live.platformplayer.b) ar().invoke();
        if (r0.isUserVisible() == false) goto L8;
    L11:
        boolean r1 = true;
    L12:
        String r2 = "show";
        if (r1 == false) goto L19;
        Pair[] r3 = new Pair[3];
        r3[0] = TuplesKt.to("event_name", "liveplay_background_status");
        r3[1] = TuplesKt.to("view_bg_reason", r11);
        if (r10 == false) goto L17;
        Object r7 = "show";
    L18:
        r3[2] = TuplesKt.to("view_status", r7);
        Map r4 = MapsKt.mapOf(r3);
        com.bytedance.android.livesdk.log.b0.o().b("ttlive_room", r4);
        goto L19
    L17:
        r7 = "hide";
    L19:
        Pair[] r5 = new Pair[3];
        if (r10 == true) goto L23;
        r2 = "hide";
    L23:
        r5[0] = TuplesKt.to("bg_status", r2);
        r5[1] = TuplesKt.to("bg_reason", r11);
        r5[2] = TuplesKt.to("bg_illegal", String.valueOf(this.U2.getLiveIllegal()));
        Map r12 = MapsKt.mapOf(r5);
        com.bytedance.android.livesdk.log.j0.l().sendLog("liveplay_background_monitor", r12, new Object[0]);
        return;
    L8:
        if (r0.c() == false) goto L11;
        r1 = false;
        goto L12
    }

    public final Pair<DisplayRatio, RenderViewInfo> hr(int r8, int r9) {
        StreamUrl r0 = this.U2.getStreamUrl();
        if (r0 == null) goto L58;
        LiveCoreSDKData r1 = r0.getLiveCoreSDKData();
        if (r1 == null) goto L58;
        LiveCoreSDKData.PullData r2 = r1.pullData;
        if (r2 == null) goto L58;
        ILiveCoreSDKData.IDisplay r3 = r2.getDisplay();
        if (r3 == null) goto L58;
        boolean r4 = true;
        boolean r5 = false;
        if (Yq() == null) goto L46;
        if (Yq().getEnable() == false) goto L46;
        if (Yq().getSwitch() == true) goto L18;
        return null;
    L18:
        LiveMode r6 = this.U2.getStreamType();
        int r7 = com.bytedance.android.live.platformplayer.layout.g.b[r6.ordinal()];
        if (r7 != 1) goto L21;
        List r10 = Yq().getSupportRoomScene();
        if (r10 == null) goto L29;
        r5 = r10.contains(Integer.valueOf(GameDisplayRatioConfig.DisplayRoomScene.SCENE_ROOM_SCREEN_RECORD.getValue()));
    L29:
        if (r5 == true) goto L31;
        return null;
    L31:
        GameDisplayRatioConfig r11 = Yq();
        if (r11 == null) goto L44;
        List r12 = r11.getSupportRatio();
        if (r12 == null) goto L44;
        Iterator r13 = r12.iterator();
    L37:
        if (r13.hasNext() == false) goto L44;
        GameDisplayRatioConfig.SupportRatio r14 = (GameDisplayRatioConfig.SupportRatio) r13.next();
        if (r14.getRatioWidth() != r3.getScaleWidth()) goto L37;
        if (r14.getRatioHeight() != r3.getScaleHeight()) goto L37;
        return DisplayRatio.Companion.getScaleCropConfig(Integer.valueOf(r3.getScaleWidth()), Integer.valueOf(r3.getScaleHeight()), r8, r9);
    L44:
        return null;
    L21:
        if (r7 != 2) goto L29;
        List r15 = Yq().getSupportRoomScene();
        if (r15 == null) goto L29;
        r5 = r15.contains(Integer.valueOf(GameDisplayRatioConfig.DisplayRoomScene.SCENE_ROOM_THIRD.getValue()));
    L46:
        if (this.U2.getStreamType() != LiveMode.SCREEN_RECORD) goto L48;
        boolean r16 = true;
    L50:
        if (this.U2.getStreamType() == LiveMode.THIRD_PARTY) goto L53;
        r4 = false;
    L53:
        if (r4 == true) goto L57;
        if (r16 == true) goto L57;
        return null;
    L57:
        return DisplayRatio.Companion.getScaleCropConfig(Integer.valueOf(r3.getScaleWidth()), Integer.valueOf(r3.getScaleHeight()), r8, r9);
    L48:
        r16 = false;
    L58:
        return null;
    }

    public final void ls(HSImageView r8, int r9) {
        View r3 = null;
        View r4 = null;
        r4 = null;
        Drawable r5 = null;
        r3 = null;
        if (Jr() == false) goto L15;
        ALogger.d(this.y, "updateForeground set foreground gone, roomId = " + this.U2.x());
        if (Build.VERSION.SDK_INT < 23) goto L8;
        if (r8 == null) goto L31;
        r8.setForeground(null);
        return;
    L31:
        return;
    L8:
        Fragment r10 = (Fragment) this.U2.getGetFragment().invoke();
        if (r10 == null) goto L13;
        View r11 = r10.getView();
        if (r11 == null) goto L13;
        r4 = r11.findViewById(2131392253);
    L13:
        UIUtils.setViewVisibility(r4, 8);
        return;
    L15:
        ALogger.d(this.y, "updateForeground set foreground visible, roomId = " + this.U2.x());
        if (Build.VERSION.SDK_INT < 23) goto L22;
        if (r8 == null) goto L33;
        Context r0 = r8.getContext();
        if (r0 == null) goto L21;
        r5 = r0.getDrawable(r9);
    L21:
        r8.setForeground(r5);
        return;
    L33:
        return;
    L22:
        Fragment r12 = (Fragment) this.U2.getGetFragment().invoke();
        if (r12 == null) goto L27;
        View r13 = r12.getView();
        if (r13 == null) goto L27;
        r3 = r13.findViewById(2131392253);
    L27:
        UIUtils.setViewVisibility(r3, 0);
        if (r3 == null) goto L35;
        r3.setBackgroundResource(2131108056);
        return;
    }

    public final void onRoomEnterV2(Room r17, ls2.a r18) {
        Intrinsics.checkNotNullParameter(r17, PbRequest.SwitchType.ROOM);
        Intrinsics.checkNotNullParameter(r18, "enterExtra");
        this.g2 = true;
        if (((Boolean) w6.a.getValue()).booleanValue() == true) goto L5;
    L12:
        IRoomContextService r0 = jc1.k.f(IRoomContextService.class);
        List<String> r1 = null;
        if (r0 == null) goto L17;
        com.bytedance.android.livesdk.chatroom.o r2 = IRoomContextService.a.a(r0, null, 0, 3);
        if (r2 == null) goto L17;
        Boolean r3 = r2.isVSRoom();
    L18:
        Boolean r4 = Boolean.TRUE;
        boolean r5 = Intrinsics.areEqual(r3, r4);
        ALogger.d(this.y, "onRoomEnter enterSmooth = " + this.U2.getEnterSmooth() + ", room type = " + this.U2.getStreamType() + ", roomId = " + this.U2.x() + ", isVs = " + r5);
        Fragment r6 = (Fragment) this.U2.getGetFragment().invoke();
        if (r6 == null) goto L23;
        View r7 = r6.getView();
        if (r7 == null) goto L23;
        HSImageView r8 = (HSImageView) r7.findViewById(2131392252);
    L24:
        StringBuilder r9 = new StringBuilder("registerVrStreamEvent owner:");
        ILivePlayerClient r11 = dr();
        if (r11 == null) goto L27;
        LifecycleOwner r12 = r11.getLifecycleOwner();
    L28:
        r9.append(r12);
        r9.append(",  ");
        if (this.U2.w() != null) goto L31;
        String r13 = "room is null";
    L32:
        r9.append(r13);
        Er(r9.toString());
        if (Zq() == false) goto L35;
        LivePlayerWidget r10 = this;
    L39:
        if (r10 != null) goto L42;
    L65:
        com.bytedance.android.livesdk.player.layout.e r14 = this.L0;
        if (r14 == null) goto L68;
        this.R2 = new g1(r14);
        boolean r15 = MatchRoomLandScapeAnimUtil.a;
        g1 r16 = this.R2;
        Intrinsics.checkNotNull(r16);
        Intrinsics.checkNotNullParameter(r16, "position");
        ALogger.i("MatchRoomAnimUtil", "setPlayerPosition : " + r16.hashCode());
        MatchRoomLandScapeAnimUtil.l = new WeakReference(r16);
    L68:
        pr(r17);
        if (this.U2.getEnterSmooth() == true) goto L71;
    L75:
        EpisodeExtraInfo r19 = r17.getEpisodeComponentData();
        if (r19 == null) goto L79;
        py.k r20 = r19.getBackground();
        if (r20 == null) goto L79;
    L80:
        EpisodeExtraInfo r21 = r17.getEpisodeComponentData();
        if (r21 != null) goto L83;
    L87:
        boolean r22 = false;
    L89:
        if (r5 == true) goto L91;
        if (r22 == true) goto L91;
    L107:
        if (r5 == true) goto L109;
    L138:
        Logger.d("bg-view", "UpdateRoomTask process, session.enterSmooth=" + this.U2.getEnterSmooth() + ", session.bgInitSucceed = " + this.U2.p);
        String r23 = this.y;
        StringBuilder r110 = new StringBuilder("onRoomEnter session.enterSmooth=");
        r110.append(this.U2.getEnterSmooth());
        r110.append(", session.bgInitSucceed = ");
        r110.append(this.U2.p);
        r110.append(", roomId = ");
        py.k r111 = r20;
        r110.append(this.U2.x());
        ALogger.d(r23, r110.toString());
        if (this.U2.getStreamType() != LiveMode.OFFICIAL_ACTIVITY) goto L164;
        Logger.d("bg-view", "官方直播间，直接展示背景图片, room.background=" + r17.getBackground());
        if (r17.getBackground() == null) goto L266;
        Fragment r24 = (Fragment) this.U2.getGetFragment().invoke();
        if (r24 == null) goto L147;
        View r25 = r24.getView();
        if (r25 == null) goto L147;
        HSImageView r26 = (HSImageView) r25.findViewById(2131392252);
    L149:
        if (Build.VERSION.SDK_INT < 23) goto L152;
        if (r26 == null) goto L152;
        r26.setForeground(null);
    L152:
        com.bytedance.android.livesdk.chatroom.ui.background.a r27 = this.p0;
        if (r27 == null) goto L155;
        r27.d();
    L155:
        ImageLoader.bindImage(r26, r17.getBackground());
        ds0.d r28 = this.U2;
        py.k r29 = r17.getBackground();
        if (r29 == null) goto L158;
        List<String> r30 = r29.getUrls();
    L159:
        r28.o = r30;
        String r31 = this.y;
        StringBuilder r32 = new StringBuilder("onRoomEnter, load official video background without blur and forground, url=");
        py.k r33 = r17.getBackground();
        if (r33 == null) goto L162;
        List r34 = r33.getUrls();
    L163:
        r32.append(r34);
        r32.append(", roomId = ");
        r32.append(this.U2.x());
        ALogger.d(r31, r32.toString());
        goto L266
    L162:
        r34 = null;
        goto L163
    L158:
        r30 = null;
    L147:
        r26 = null;
    L266:
        ng r35 = ng.a;
        if (((s11) r35.getValue()).enable == true) goto L269;
    L273:
        boolean r36 = false;
    L275:
        if (this.U2.u() == true) goto L277;
    L279:
        boolean r37 = false;
    L280:
        boolean r38 = !this.o.booleanValue();
        if (this.o.booleanValue() == false) goto L287;
        String r39 = jc1.k.n(IMiddlewareUserService.class).user().n();
        Room r40 = this.U2.w();
        if (r40 == null) goto L285;
        String r41 = r40.getAnchorId();
    L286:
        r38 = !Intrinsics.areEqual(r39, r41);
        goto L287
    L285:
        r41 = null;
    L287:
        z5 r42 = r17.getLinkerDetail();
        if (r42 == null) goto L294;
        List r43 = r42.getFeatureList();
        if (r43 == null) goto L294;
        if (r43.contains(1L) != true) goto L294;
        boolean r44 = true;
    L296:
        if (tr() == true) goto L298;
    L347:
        if (r17.isVrRoom() == false) goto L349;
    L350:
        String r45 = or();
        if (r45.length() <= 0) goto L353;
        boolean r46 = true;
    L354:
        if (r46 == true) goto L356;
    L358:
        Nr();
        return;
    L356:
        if ((!Intrinsics.areEqual(r45, "null")) == false) goto L358;
        f2.c(r45, 0);
        goto L358
    L353:
        r46 = false;
        goto L354
    L349:
        if (VrUtils.q() == false) goto L358;
    L298:
        if (this.H1 == true) goto L347;
        if (r38 == false) goto L347;
        if (r36 == false) goto L302;
        if (r37 == false) goto L347;
    L302:
        if (r44 == true) goto L347;
        Fragment r47 = (Fragment) this.U2.getGetFragment().invoke();
        if (r47 == null) goto L308;
        View r48 = r47.getView();
        if (r48 == null) goto L308;
        HSImageView r49 = (HSImageView) r48.findViewById(2131383590);
    L309:
        Fragment r50 = (Fragment) this.U2.getGetFragment().invoke();
        if (r50 == null) goto L314;
        View r51 = r50.getView();
        if (r51 == null) goto L314;
        View r52 = r51.findViewById(2131383591);
    L316:
        if (r49 == null) goto L318;
        r49.setVisibility(0);
    L318:
        if (r52 == null) goto L320;
        r52.setVisibility(0);
    L320:
        float r53 = UIUtils.getScreenWidth(this.U2.d()) / UIUtils.getScreenHeight(this.U2.d());
        User r54 = r17.getOwner();
        if (r54 == null) goto L323;
        py.k r55 = r54._avatarLarge;
    L324:
        ImageLoader.bindImage(r49, r55, new LiveBlurProcessorV2(5, r53, null));
        ds0.d r56 = this.U2;
        User r57 = r17.getOwner();
        if (r57 == null) goto L329;
        py.k r58 = r57._avatarLarge;
        if (r58 == null) goto L329;
        List<String> r59 = r58.getUrls();
    L330:
        r56.o = r59;
        Map r60 = r17.getLinkMap();
        if (r60 != null) goto L333;
    L335:
        boolean r61 = false;
    L337:
        if (this.U2.getEnterSmooth() == true) goto L342;
        if (r61 == true) goto L342;
        if (this.H1 == false) goto L347;
    L342:
        if (r49 == null) goto L344;
        r49.setVisibility(8);
    L344:
        if (r52 == null) goto L347;
        r52.setVisibility(8);
        goto L347
    L333:
        if (r60.containsKey(String.valueOf(1)) != true) goto L335;
        r61 = true;
    L329:
        r59 = null;
        goto L330
    L323:
        r55 = null;
    L314:
        r52 = null;
    L308:
        r49 = null;
    L294:
        r44 = false;
        goto L296
    L277:
        if (this.U2.s() == false) goto L279;
        r37 = true;
        goto L280
    L269:
        if (((s11) r35.getValue()).ktv == false) goto L271;
    L272:
        r36 = true;
        goto L275
    L271:
        if (((s11) r35.getValue()).audio == false) goto L273;
    L164:
        Fragment r62 = (Fragment) this.U2.getGetFragment().invoke();
        if (r62 == null) goto L167;
        View r63 = r62.getView();
    L168:
        if (r63 == null) goto L266;
        if (r5 == false) goto L182;
        if (r111 == null) goto L180;
        EpisodeExtraInfo r65 = r17.getEpisodeExtra();
        if (r65 == null) goto L179;
        MultiTab r66 = r65.getMultiTab();
        if (r66 == null) goto L179;
        if (r66.getDisableBackground() != 1) goto L179;
        ls(r8, 2131107008);
    L185:
        float r67 = UIUtils.getScreenWidth(this.U2.d()) / UIUtils.getScreenHeight(this.U2.d());
        if (r17.getBackground() == null) goto L195;
        Logger.d("bg-view", "设置了背景图片则加载之，不要高斯模糊, room.background=" + r17.getBackground());
        Logger.d("bg-view", "session.bgInitSucceed = " + this.U2.p);
        ALogger.d(this.y, "onRoomEnter 设置了背景图片则加载之，不要高斯模糊, room.background=" + r17.getBackground() + ", roomId = " + this.U2.x());
        ALogger.d(this.y, "onRoomEnter session.bgInitSucceed = " + this.U2.p + ", roomId = " + this.U2.x());
        com.bytedance.android.livesdk.chatroom.ui.background.a r68 = this.p0;
        if (r68 == null) goto L190;
        r68.d();
    L190:
        ImageLoader.bindImage(r8, r17.getBackground(), false);
        ds0.d r69 = this.U2;
        py.k r70 = r17.getBackground();
        if (r70 == null) goto L193;
        List<String> r71 = r70.getUrls();
    L194:
        r69.o = r71;
        goto L266
    L193:
        r71 = null;
        goto L194
    L195:
        ng r72 = ng.a;
        if (((s11) r72.getValue()).enable == false) goto L220;
        if ((!this.U2.g().isEmpty()) == false) goto L220;
        if (this.U2.u() == false) goto L207;
        if (this.U2.s() == true) goto L207;
        if (((s11) r72.getValue()).ktv == false) goto L207;
        ALogger.d(this.y, "onRoomEnter KTV背景处理, audioBgUrls = " + this.U2.g() + ", roomId = " + this.U2.x());
        py.k r73 = vh7.f.c(py.k.class);
        r73.setUri(null);
        r73.setUrls(this.U2.g());
        Unit r74 = Unit.INSTANCE;
        ImageLoader.bindImage(r8, r73, new LiveBlurProcessorV2(5, r67, null));
    L211:
        com.bytedance.android.livesdk.chatroom.ui.background.a r75 = this.p0;
        if (r75 == null) goto L214;
        r75.d();
    L214:
        ds0.d r76 = this.U2;
        User r77 = r17.getOwner();
        Intrinsics.checkNotNull(r77);
        ImageModel r78 = r77.getAvatarThumb();
        if (r78 == null) goto L217;
        List<String> r79 = r78.getUrls();
    L218:
        r76.o = r79;
        goto L266
    L217:
        r79 = null;
    L207:
        if (this.U2.u() == true) goto L211;
        if (((s11) r72.getValue()).audio == false) goto L211;
        ALogger.d(this.y, "onRoomEnter 语音直播间背景处理, audioBgUrls = " + this.U2.g() + ", roomId = " + this.U2.x());
        py.k r80 = vh7.f.c(py.k.class);
        r80.setUri(null);
        r80.setUrls(this.U2.g());
        Unit r81 = Unit.INSTANCE;
        ImageLoader.bindImage(r8, r80);
    L220:
        if (this.U2.p == true) goto L266;
        User r82 = r17.getOwner();
        if (r82 == null) goto L224;
        ImageModel r83 = r82.getAvatarThumb();
    L225:
        if (r83 == null) goto L266;
        if (this.U2.isLiveHeadEnterSmooth() == false) goto L229;
        return;
    L229:
        Logger.d("bg-view", "session.bgInitSucceed = " + this.U2.p);
        ALogger.d(this.y, "onRoomEnter session.bgInitSucceed = " + this.U2.p + ", roomId = " + this.U2.x());
        if (this.U2.q().isEmpty() == false) goto L239;
        ds0.d r84 = this.U2;
        IRoomAppearance r85 = r17.getAppearanceFlex();
        if (r85 == null) goto L237;
        py.k r86 = r85.getBlurImage();
        if (r86 == null) goto L237;
        List<String> r87 = r86.getUrls();
        if (r87 == null) goto L237;
    L238:
        r84.y(r87);
        ALogger.d(this.y, "onRoomEnter session serverBgUrls is empty use room appearance");
    L237:
        r87 = CollectionsKt.emptyList();
    L239:
        ls(r8, 2131108056);
        boolean r88 = LiveHazyFrameHelper.a.getImageDecodeOpt();
        if (com.bytedance.android.livesdk.performance.i0.a.inner == true) goto L246;
        if (com.bytedance.android.livesdk.performance.i0.b.booleanValue() == false) goto L249;
        if (vr() == true) goto L246;
    L249:
        if ((!this.U2.q().isEmpty()) == true) goto L251;
    L255:
        StringBuilder r89 = new StringBuilder("没有设置背景图片，就拿头像做高斯模糊背景，再盖上一个黑色蒙层, room.owner.avatarThumb=");
        User r90 = r17.getOwner();
        Intrinsics.checkNotNull(r90);
        r89.append(r90.getAvatarThumb());
        Logger.d("bg-view", r89.toString());
        String r91 = this.y;
        StringBuilder r92 = new StringBuilder("onRoomEnter 没有设置背景图片，就拿头像做高斯模糊背景，再盖上一个黑色蒙层, room.owner.avatarThumb=");
        User r93 = r17.getOwner();
        Intrinsics.checkNotNull(r93);
        r92.append(r93.getAvatarThumb());
        r92.append(", roomId = ");
        r92.append(this.U2.x());
        ALogger.d(r91, r92.toString());
        User r94 = r17.getOwner();
        Intrinsics.checkNotNull(r94);
        ImageLoader.bindImage(r8, r94.getAvatarThumb(), new LiveBlurProcessorV2(2, r67, null));
    L256:
        ds0.d r95 = this.U2;
        User r96 = r17.getOwner();
        Intrinsics.checkNotNull(r96);
        ImageModel r97 = r96.getAvatarThumb();
        if (r97 == null) goto L259;
        List<String> r98 = r97.getUrls();
    L260:
        r95.o = r98;
        com.bytedance.android.livesdk.chatroom.ui.background.a r99 = this.p0;
        if (r99 == null) goto L263;
        r99.c = dr();
    L263:
        com.bytedance.android.livesdk.chatroom.ui.background.a r100 = this.p0;
        if (r100 == null) goto L266;
        r100.c();
        goto L266
    L259:
        r98 = null;
        goto L260
    L251:
        if (this.U2.p() == 72) goto L255;
        if (LiveHazyFrameHelper.b() == false) goto L255;
        ALogger.i("ServerBlur", "[others] inner server blur image onRoomEnter roomId = " + this.U2.x() + ", serverBgUrls = " + this.U2.q());
        ALogger.d(this.y, "onRoomEnter inner server blur image onRoomEnter roomId = " + this.U2.x() + ", serverBgUrls = " + this.U2.q());
        py.k r101 = vh7.f.c(py.k.class);
        r101.setUri(null);
        r101.setUrls(this.U2.q());
        com.bytedance.android.livesdk.chatroom.utils.a1.q(r8, r101, r88);
        this.R = r101;
    L246:
        if ((!this.U2.q().isEmpty()) == false) goto L249;
        ALogger.i("ServerBlur", "[game] inner server blur image onRoomEnter roomId = " + this.U2.x() + ", serverBgUrls = " + this.U2.q());
        ALogger.d(this.y, "onRoomEnter inner server blur image onRoomEnter roomId = " + this.U2.x() + ", serverBgUrls = " + this.U2.q());
        py.k r102 = vh7.f.c(py.k.class);
        r102.setUri(null);
        r102.setUrls(this.U2.q());
        com.bytedance.android.livesdk.chatroom.utils.a1.q(r8, r102, r88);
        this.R = r102;
        goto L256
    L224:
        r83 = null;
    L179:
        ls(r8, 2131108058);
        goto L185
    L180:
        ls(r8, 2131108056);
        goto L185
    L182:
        if (this.U2.isLiveHeadEnterSmooth() == false) goto L184;
        return;
    L184:
        ls(r8, 2131108058);
        goto L185
    L167:
        r63 = null;
        goto L168
    L109:
        if (this.U2.p == true) goto L138;
        User r112 = r17.getOwner();
        if (r112 == null) goto L113;
        ImageModel r113 = r112.getAvatarThumb();
    L114:
        if (r113 == null) goto L138;
        if (tr() == true) goto L118;
    L119:
        String r103 = this.y;
        StringBuilder r104 = new StringBuilder("onRoomEnter 没有设置背景图片，就拿头像做高斯模糊背景，再盖上一个黑色蒙层, room.owner.avatarThumb=");
        User r105 = r17.getOwner();
        if (r105 == null) goto L122;
        ImageModel r106 = r105.getAvatarThumb();
    L123:
        r104.append(r106);
        r104.append(", roomId = ");
        r104.append(this.U2.x());
        ALogger.d(r103, r104.toString());
        ALogger.d(this.y, "onRoomEnter session.bgInitSucceed = " + this.U2.p + ", roomId = " + this.U2.x());
        ls(r8, 2131108056);
        float r107 = ((float) UIUtils.getScreenWidth(this.U2.d())) / ((float) UIUtils.getScreenHeight(this.U2.d()));
        User r108 = r17.getOwner();
        if (r108 == null) goto L126;
        ImageModel r109 = r108.getAvatarThumb();
    L127:
        ImageLoader.bindImage(r8, r109, new LiveBlurProcessorV2(2, r107, null));
        ds0.d r114 = this.U2;
        User r115 = r17.getOwner();
        if (r115 == null) goto L132;
        ImageModel r116 = r115.getAvatarThumb();
        if (r116 == null) goto L132;
        r1 = r116.getUrls();
    L132:
        r114.o = r1;
        com.bytedance.android.livesdk.chatroom.ui.background.a r117 = this.p0;
        if (r117 == null) goto L135;
        r117.c = dr();
    L135:
        com.bytedance.android.livesdk.chatroom.ui.background.a r118 = this.p0;
        if (r118 == null) goto L347;
        r118.c();
        goto L347
    L126:
        r109 = null;
        goto L127
    L122:
        r106 = null;
        goto L123
    L118:
        if (((Boolean) tl0.a.getValue()).booleanValue() == true) goto L138;
    L113:
        r113 = null;
    L91:
        if (r20 == null) goto L107;
        if (r20.isValid() == false) goto L107;
        EpisodeExtraInfo r119 = r17.getEpisodeComponentData();
        if (r119 == null) goto L101;
        MultiTab r120 = r119.getMultiTab();
        if (r120 == null) goto L101;
        if (r120.getDisableBackground() != 1) goto L101;
        ls(r8, 2131107008);
    L102:
        com.bytedance.android.livesdk.chatroom.ui.background.a r121 = this.p0;
        if (r121 == null) goto L105;
        r121.d();
    L105:
        ImageLoader.bindImage(r8, r20, false);
        ALogger.d(this.y, "onRoomEnter, load vs video background without blur, url=" + r20.getUrls() + ", roomId = " + this.U2.x());
    L101:
        ls(r8, 2131108058);
        goto L102
    L83:
        if (r21.getShareType() != 1) goto L87;
        if (((Boolean) j40.s0.a.getValue()).booleanValue() == false) goto L87;
        r22 = true;
    L79:
        r20 = r17.getBackground();
        goto L80
    L71:
        if ((!this.U2.h().isEmpty()) == false) goto L75;
        if (this.U2.k() == false) goto L75;
        return;
    L42:
        if (VrUtils.x(this.U2.w()) == true) goto L48;
        ILivePlayerClient r122 = dr();
        if (r122 == null) goto L48;
        if (r122.isVrLive() == false) goto L65;
    L48:
        ILivePlayerClient r123 = dr();
        if (r123 == null) goto L58;
        IRoomEventHub r124 = r123.getEventHub();
        if (r124 == null) goto L58;
        MutableLiveData r125 = r124.getVrStreamEnable();
        if (r125 == null) goto L58;
        Boolean r126 = (Boolean) r125.getValue();
        if (r126 == null) goto L58;
        r4 = r126;
    L58:
        Sr(r4.booleanValue());
        ILivePlayerClient r127 = dr();
        if (r127 == null) goto L65;
        IRoomEventHub r128 = r127.getEventHub();
        if (r128 == null) goto L65;
        MutableLiveData r129 = r128.getVrStreamEnable();
        if (r129 == null) goto L65;
        r129.observe(r10, new y0(this));
        goto L65
    L35:
        ILivePlayerClient r130 = dr();
        if (r130 == null) goto L38;
        r10 = r130.getLifecycleOwner();
        goto L39
    L38:
        r10 = null;
        goto L39
    L31:
        r13 = "";
        goto L32
    L27:
        r12 = null;
    L23:
        r8 = null;
    L17:
        r3 = null;
        goto L18
    L5:
        if (LiveInitSettingKeys.get_LIVE_PLAYER_LAYOUT_V1_ENABLE() == false) goto L12;
        LiveSeiUtil r131 = LiveSeiUtil.i;
        String r132 = this.L;
        r131.getClass();
        if (LiveSeiUtil.f(r132, false) == false) goto L12;
        if (((Boolean) this.X.getValue()).booleanValue() == false) goto L12;
        ms(this, "seiUpdate", 0, 0, this.L, null, 22);
        goto L12
    }

    public final void onRoomPreloadV2(Room r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, PbRequest.SwitchType.ROOM);
        if (MultiRoomConfig.INSTANCE.enableRoomPreload() == false) goto L9;
        ds0.d r4 = this.U2;
        if (r4 == null) goto L9;
        if (r4.getHasRoomPreloaded() != true) goto L9;
        return;
    L9:
        pr(r2);
    }

    public final void rr(LiveMode r26, List<String> r27) {
        ALogger.d(this.y, "initBackground streamType=" + r26 + ", bgUrls = " + r27 + ", enterSmooth " + this.U2.getEnterSmooth() + ", roomId = " + this.U2.x() + ", audioBgUrls = " + this.U2.g() + ", isktv = " + this.U2.u());
        StringBuilder r3 = new StringBuilder("initBackground streamType=");
        r3.append(r26);
        r3.append(", bgUrls = ");
        r3.append(r27);
        Er(r3.toString());
        fs();
        ViewGroup r1 = ((Widget) this).containerView;
        if (r1 == null) goto L5;
        View r2 = r1.findViewById(2131392252);
    L6:
        boolean r6 = false;
        if (Build.VERSION.SDK_INT >= 23) goto L9;
        ViewGroup r4 = ((Widget) this).containerView;
        if (r4 == null) goto L26;
        View r5 = r4.findViewById(2131392253);
    L28:
        if (this.U2.getEnterSmooth() == false) goto L30;
    L36:
        UIUtils.setViewVisibility(r5, 8);
        ALogger.d(this.y, "configuerVideoBackground set video background foreground gone, roomId = " + this.U2.x());
    L37:
        ViewGroup r7 = ((Widget) this).containerView;
        if (r7 == null) goto L40;
        HSImageView r8 = (HSImageView) r7.findViewById(2131392252);
    L41:
        float r9 = s1.y() / s1.w();
        if (tr() == false) goto L90;
        if (this.o.booleanValue() == false) goto L61;
        if (this.U2.u() == false) goto L61;
        IMiddlewareUserService r10 = jc1.k.f(IMiddlewareUserService.class);
        if (r10 == null) goto L52;
        com.bytedance.android.livesdk.user.e r11 = r10.user();
        if (r11 == null) goto L52;
        String r12 = r11.n();
    L53:
        Room r13 = this.U2.w();
        if (r13 == null) goto L56;
        String r14 = r13.getAnchorId();
    L58:
        if (Intrinsics.areEqual(r12, r14) == false) goto L61;
        return;
    L56:
        r14 = null;
    L52:
        r12 = null;
    L61:
        if (this.H1 == false) goto L64;
        return;
    L64:
        if (this.U2.getEnterSmooth() == false) goto L66;
    L86:
        com.bytedance.android.livesdk.chatroom.ui.background.a r15 = this.p0;
        if (r15 == null) goto L193;
        r15.d();
    L193:
        this.v2 = true;
        return;
    L66:
        if (this.U2.r == true) goto L86;
        ng r16 = ng.a;
        if (((s11) r16.getValue()).enable == true) goto L70;
        ALogger.d(this.y, "initBackground 语音直播间直接使用奇偶默认背景");
        com.bytedance.android.livesdk.chatroom.utils.a1.r(this.d, com.bytedance.android.livesdk.model.k.b((com.bytedance.android.livesdk.model.k) jf.a.getValue(), this.U2.getUserId()), 2131248875);
        goto L86
    L70:
        if (this.U2.u() == false) goto L79;
        if (this.U2.s() == true) goto L79;
        if ((!this.U2.g().isEmpty()) == false) goto L79;
        if (((s11) r16.getValue()).ktv == false) goto L79;
        ALogger.d(this.y, "initBackground KTV背景处理");
        HSImageView r17 = this.d;
        py.k r18 = vh7.f.c(py.k.class);
        r18.setUri(null);
        r18.setUrls(this.U2.g());
        Unit r19 = Unit.INSTANCE;
        ImageLoader.bindImage(r17, r18, new LiveBlurProcessorV2(5, r9, null));
    L79:
        if (this.U2.u() == true) goto L86;
        if ((!this.U2.g().isEmpty()) == false) goto L86;
        if (((s11) r16.getValue()).audio == false) goto L86;
        ALogger.d(this.y, "initBackground 语音直播间直接使用audioBgUrls");
        HSImageView r20 = this.d;
        py.k r21 = vh7.f.c(py.k.class);
        r21.setUri(null);
        r21.setUrls(this.U2.g());
        Unit r22 = Unit.INSTANCE;
        ImageLoader.bindImage(r20, r21);
        goto L86
    L90:
        if ((!r27.isEmpty()) == true) goto L92;
        String r23 = "res://" + ((Widget) this).context.getPackageName() + "/2131251156";
        ALogger.d(this.y, "initBackground set video background with blur, local url = " + r23 + ", roomId = " + this.U2.x());
        boolean r24 = LiveHazyFrameHelper.a.getImageDecodeOpt();
        com.bytedance.android.livesdk.chatroom.utils.a1.p(this.d, r23, new LiveBlurProcessorV2(5, r9, null), r24);
        com.bytedance.android.livesdk.chatroom.utils.a1.p(r8, r23, new LiveBlurProcessorV2(5, r9, null), r24);
        goto L193
    L92:
        if (this.U2.getEnterSmooth() == false) goto L168;
        Logger.d("bg-view", "setSmoothBackground");
        ALogger.d(this.y, "setSmoothBackground, enterSmoothWithBg " + this.U2.k() + ", roomId = " + this.U2.x());
        Er("setSmoothBackground");
        HSImageView r110 = ((Widget) this).containerView.findViewById(2131392252);
        if (this.U2.i() > 0) goto L96;
    L100:
        List<String> r25 = this.U2.h();
        if (this.U2.k() == false) goto L106;
        ALogger.d(this.y, "load background without foreground and blur, url = " + r25 + ", roomId = " + this.U2.x());
        com.bytedance.android.livesdk.chatroom.ui.background.a r28 = this.p0;
        if (r28 == null) goto L105;
        r28.d();
    L105:
        py.k r29 = vh7.f.c(py.k.class);
        r29.setUri(null);
        r29.setUrls(r25);
        Unit r30 = Unit.INSTANCE;
        ImageLoader.bindImage(r110, r29, false);
        py.k r31 = vh7.f.c(py.k.class);
        r31.setUri(null);
        r31.setUrls(r25);
        this.R = r31;
    L191:
        ds0.d r32 = this.U2;
        r32.p = true;
        r32.o = r27;
        goto L193
    L106:
        String r33 = this.U2.getEnterRoomInfo().getLinkerMap();
        if (r33 != null) goto L109;
    L110:
        String r34 = this.U2.getEnterRoomInfo().getLinkerMap();
        if (r34 != null) goto L113;
    L118:
        ILivePlayerClient r35 = dr();
        if (r35 == null) goto L123;
        ILivePlayerSharedDataManager r36 = r35.sharedDataManager();
        if (r36 == null) goto L123;
        Object r37 = r36.getSharedData("smooth_enter_blur_background");
    L125:
        if ((r37 instanceof TransitionDrawable) == true) goto L127;
        r37 = null;
    L127:
        TransitionDrawable r38 = (TransitionDrawable) r37;
        if (r38 == null) goto L139;
        Pq();
        if (r110 == null) goto L132;
        r110.setScaleType(ImageView.ScaleType.CENTER_CROP);
    L132:
        r110.setImageDrawable(r38);
        com.bytedance.android.livesdk.chatroom.ui.background.a r39 = this.p0;
        if (r39 == null) goto L135;
        r39.c = dr();
    L135:
        com.bytedance.android.livesdk.chatroom.ui.background.a r40 = this.p0;
        if (r40 == null) goto L191;
        r40.c();
        goto L191
    L139:
        if (com.bytedance.android.livesdk.performance.i0.a.smoothEnter == true) goto L145;
        if (com.bytedance.android.livesdk.performance.i0.b.booleanValue() == false) goto L151;
        if (vr() == true) goto L145;
    L151:
        if ((!this.U2.q().isEmpty()) == true) goto L153;
    L164:
        float r41 = this.U2.j() / this.U2.i();
        ALogger.d(this.y, "load background with foreground and blur, url = " + r25 + ", roomId = " + this.U2.x());
        com.bytedance.android.livesdk.chatroom.ui.background.a r42 = this.p0;
        if (r42 == null) goto L167;
        r42.d();
    L167:
        py.k r43 = vh7.f.c(py.k.class);
        r43.setUri(null);
        r43.setUrls(r25);
        ImageLoader.d r44 = ImageLoader.load(r43);
        r44.d = new LiveBlurProcessorV2(5, r41, null);
        int r45 = this.U2.j();
        int r46 = this.U2.i();
        r44.b = r45;
        r44.c = r46;
        r44.e = new f1(r25, this, r110);
        r44.a(r110);
        goto L191
    L153:
        if (this.U2.p() == 72) goto L164;
        LiveHazyFrameConfig r47 = LiveHazyFrameHelper.a;
        if (r47.getEnableSmoothEnter() == true) goto L157;
    L159:
        if (r6 == false) goto L164;
        ALogger.d("ServerBlur", "[others] server smoothEnter load background with foreground and blur, url = " + this.U2.q() + ", roomId = " + this.U2.x());
        com.bytedance.android.livesdk.chatroom.ui.background.a r48 = this.p0;
        if (r48 == null) goto L163;
        r48.d();
    L163:
        py.k r49 = vh7.f.c(py.k.class);
        r49.setUri(null);
        r49.setUrls(this.U2.q());
        Unit r50 = Unit.INSTANCE;
        this.R = r49;
        boolean r210 = r47.getImageDecodeOpt();
        py.k r111 = vh7.f.c(py.k.class);
        r111.setUri(null);
        r111.setUrls(this.U2.q());
        ImageLoader.bindImage(r110, r111, null, 300, this.U2.j(), this.U2.i(), null, new e1(this, r110), false, r210, true);
        goto L191
    L157:
        if (LiveHazyFrameHelper.a() == true) goto L159;
        r6 = true;
    L145:
        if ((!this.U2.q().isEmpty()) == false) goto L151;
        ALogger.d("ServerBlur", "[game] server smoothEnter load background with foreground and blur, url = " + this.U2.q() + ", roomId = " + this.U2.x());
        com.bytedance.android.livesdk.chatroom.ui.background.a r51 = this.p0;
        if (r51 == null) goto L149;
        r51.d();
    L149:
        py.k r52 = vh7.f.c(py.k.class);
        r52.setUri(null);
        r52.setUrls(this.U2.q());
        Unit r53 = Unit.INSTANCE;
        this.R = r52;
        boolean r211 = LiveHazyFrameHelper.a.getImageDecodeOpt();
        py.k r112 = vh7.f.c(py.k.class);
        r112.setUri(null);
        r112.setUrls(this.U2.q());
        ImageLoader.bindImage(r110, r112, null, 300, this.U2.j(), this.U2.i(), null, new d1(this, r110), false, r211, true);
    L123:
        r37 = null;
        goto L125
    L113:
        if (r34.equals("video_talk_room") != true) goto L118;
    L114:
        com.bytedance.android.livesdk.chatroom.ui.background.a r54 = this.p0;
        if (r54 == null) goto L117;
        r54.d();
    L117:
        r110.setBackgroundResource(2131248875);
        goto L191
    L109:
        if (r33.equals("video_ktv") == true) goto L114;
    L96:
        if (this.U2.j() <= 0) goto L100;
        ViewGroup.LayoutParams r55 = r110.getLayoutParams();
        if (r55 == null) goto L100;
        r55.width = this.U2.j();
        r55.height = this.U2.i();
        goto L100
    L168:
        ALogger.d(this.y, "initBackground set video background with blur, bgUrls = " + r27 + ", roomId = " + this.U2.x());
        boolean r56 = LiveHazyFrameHelper.a.getImageDecodeOpt();
        if (com.bytedance.android.livesdk.performance.i0.a.inner == true) goto L175;
        if (com.bytedance.android.livesdk.performance.i0.b.booleanValue() == false) goto L178;
        if (vr() == true) goto L175;
    L178:
        if ((!this.U2.q().isEmpty()) == true) goto L180;
    L184:
        ALogger.d(this.y, "initBackground set video background with blur, bgUrls = " + r27 + ", roomId = " + this.U2.x());
        HSImageView r57 = this.d;
        py.k r58 = vh7.f.c(py.k.class);
        r58.setUri(null);
        r58.setUrls(r27);
        Unit r59 = Unit.INSTANCE;
        ImageLoader.bindImage(r57, r58, new LiveBlurProcessorV2(2, r9, null));
        py.k r60 = vh7.f.c(py.k.class);
        r60.setUri(null);
        r60.setUrls(r27);
        ImageLoader.bindImage(r8, r60, new LiveBlurProcessorV2(2, r9, null));
    L185:
        com.bytedance.android.livesdk.chatroom.ui.background.a r61 = this.p0;
        if (r61 == null) goto L188;
        r61.c = dr();
    L188:
        com.bytedance.android.livesdk.chatroom.ui.background.a r62 = this.p0;
        if (r62 == null) goto L191;
        r62.c();
        goto L191
    L180:
        if (this.U2.p() == 72) goto L184;
        if (LiveHazyFrameHelper.b() == false) goto L184;
        ALogger.i("ServerBlur", "[others] inner server blur image initBackground roomId = " + this.U2.x() + "，serverBgUrls = " + this.U2.q());
        py.k r63 = vh7.f.c(py.k.class);
        r63.setUri(null);
        r63.setUrls(this.U2.q());
        com.bytedance.android.livesdk.chatroom.utils.a1.q(this.d, r63, r56);
        com.bytedance.android.livesdk.chatroom.utils.a1.q(r8, r63, r56);
        this.R = r63;
    L175:
        if ((!this.U2.q().isEmpty()) == false) goto L178;
        ALogger.i("ServerBlur", "[game] inner server blur image initBackground roomId = " + this.U2.x() + "，serverBgUrls = " + this.U2.q());
        py.k r65 = vh7.f.c(py.k.class);
        r65.setUri(null);
        r65.setUrls(this.U2.q());
        com.bytedance.android.livesdk.chatroom.utils.a1.q(this.d, r65, r56);
        com.bytedance.android.livesdk.chatroom.utils.a1.q(r8, r65, r56);
        this.R = r65;
        goto L185
    L40:
        r8 = null;
        goto L41
    L30:
        if (Jr() == true) goto L36;
        UIUtils.setViewVisibility(r5, 0);
        if (r5 == null) goto L35;
        r5.setBackgroundResource(2131108058);
    L35:
        ALogger.d(this.y, "configuerVideoBackground set video background foreground visible, roomId = " + this.U2.x());
        goto L37
    L26:
        r5 = null;
        goto L28
    L9:
        if (this.U2.getEnterSmooth() == false) goto L11;
    L20:
        if (r2 == null) goto L22;
        r2.setForeground(null);
    L22:
        ALogger.d(this.y, "configuerVideoBackground set video background foreground null, roomId = " + this.U2.x());
        goto L37
    L11:
        if (Jr() == true) goto L20;
        if (r2 == null) goto L19;
        Context r66 = r2.getContext();
        if (r66 == null) goto L17;
        Drawable r67 = r66.getDrawable(2131108058);
    L18:
        r2.setForeground(r67);
        goto L19
    L17:
        r67 = null;
    L19:
        ALogger.d(this.y, "configuerVideoBackground set video background foreground drawable, roomId = " + this.U2.x());
        goto L37
    L5:
        r2 = null;
        goto L6
    }

    @Override // gs0.c
    public final void we(AbsLivePlayerView r9, String r10) {
        Intrinsics.checkNotNullParameter(r9, "playerView");
        Intrinsics.checkNotNullParameter(r10, "from");
        Intrinsics.checkNotNullParameter(r9, "<set-?>");
        this.c = r9;
        com.bytedance.android.livesdk.player.layout.n r0 = this.P0;
        if (r0 == null) goto L6;
        this.L0 = new com.bytedance.android.livesdk.player.layout.e(r9.getRenderView());
        r0.reset();
        com.bytedance.android.livesdk.player.layout.e r11 = this.L0;
        Intrinsics.checkNotNull(r11);
        r0.b(r11);
        ms(this, r10, 0, 0, null, null, 30);
        return;
    }

    @Override // gs0.c
    public final void x6(VSCameraInfo r1, boolean r2) {
        Kq(r1, r2);
    }

    public final void Eq(FrameLayout.LayoutParams r18, int r19, int r20) {
        ViewGroup r2 = ((Widget) this).containerView;
        AbsLivePlayerView r3 = R8();
        if (r2 != null) goto L5;
    L11:
        int r4 = 3;
    L12:
        r3.setScaleType(r4);
        if (this.U2.getStreamType() != LiveMode.THIRD_PARTY) goto L15;
        R8().setScaleType(2);
    L15:
        d8 r13 = this.s;
        int r14 = this.h1;
        if (r13.f == null) goto L86;
        JSONObject r5 = r13.e;     // Catch: JSONException -> L83
        if (r5 != null) goto L20;
        return;
    L20:
        if (r5.has("app_data") == false) goto L81;
        JSONObject r10 = new JSONObject(new Regex("\\\\").replace(JSONObjectProtectorUtils.getString(r5, "app_data"), ""));     // Catch: JSONException -> L83
        JSONArray r9 = new JSONArray(r10.optString("grids"));     // Catch: JSONException -> L83
        if (r9.length() <= 0) goto L88;
        int r0 = 0;
        if (r9.opt(0) == null) goto L89;
        Object r11 = r9.opt(0);     // Catch: JSONException -> L83
        if (r11 == null) goto L80;
        JSONObject r12 = (JSONObject) r11;     // Catch: JSONException -> L83
        JSONObject r6 = r10.optJSONObject("canvas");     // Catch: JSONException -> L83
        double r7 = r12.optDouble("y");     // Catch: JSONException -> L83
        float r8 = (float) r12.optDouble("h");     // Catch: JSONException -> L83
        int r15 = r6.optInt("height");     // Catch: JSONException -> L83
        int r16 = r6.optInt("width");     // Catch: JSONException -> L83
        if (r5.has("live_crop") == false) goto L38;
        CropSeiData r17 = CropSeiData.parseCropSei(JSONObjectProtectorUtils.getJSONObject(r5, "live_crop"));     // Catch: JSONException -> L83
        if (r17 == null) goto L38;
        if (r13.c(r17) == true) goto L38;
        if (r17.isLegalCropSei() == false) goto L38;
        double r21 = r17.cropY;     // Catch: JSONException -> L83
        int r22 = r17.strideH;     // Catch: JSONException -> L83
        r7 = r21 / ((double) r22);     // Catch: JSONException -> L83
        r8 = r17.cropH / r22;     // Catch: JSONException -> L83
        r16 = r17.strideW;     // Catch: JSONException -> L83
        r15 = r22;
    L38:
        if (r14 != (-1)) goto L44;
        ds0.d r23 = r13.c;     // Catch: JSONException -> L83
        if (r23 != null) goto L42;
        Intrinsics.throwUninitializedPropertyAccessException("session");     // Catch: JSONException -> L83
    L42:
        boolean r24 = !e5.m(r23.getScreenOrientation());     // Catch: JSONException -> L83
    L48:
        if (PadConfigUtils.c() == false) goto L63;
        if (r24 == false) goto L51;
        r0 = s1.f(r13.n);     // Catch: JSONException -> L83
    L51:
        if (r24 == true) goto L53;
    L59:
        if (r24 == false) goto L61;
        float r25 = s1.t();     // Catch: JSONException -> L83
        float r26 = ((r15 * 1.0f) * r25) / r16;     // Catch: JSONException -> L83
    L78:
        r18.width = (int) r25;     // Catch: JSONException -> L83
        r18.height = (int) r26;     // Catch: JSONException -> L83
        r18.gravity = 1;     // Catch: JSONException -> L83
        r18.topMargin = (int) (((double) r0) - (((double) r26) * r7));     // Catch: JSONException -> L83
        int r1 = (s1.y() - ((int) r25)) / 2;     // Catch: JSONException -> L83
        boolean r27 = com.bytedance.android.live.revenue.core.util.h.a;     // Catch: JSONException -> L83
        com.bytedance.android.live.revenue.core.util.h.d(kc0.j.class).updatePkLeftMargin(r13.w, r1);     // Catch: JSONException -> L83
        goto L81
    L61:
        float r28 = s1.r();     // Catch: JSONException -> L83
    L77:
        float r29 = r28 / r8;     // Catch: JSONException -> L83
        float r30 = (r16 * r29) / r15;     // Catch: JSONException -> L83
        r26 = r29;
        r25 = r30;
        goto L78
    L53:
        if (StatusBarUtil.STATUS_BAR_ADAPT_ENABLE == false) goto L59;
        if (StatusBarUtil.JUMP_FROM_LIVE_PLAY_ACTIVITY == false) goto L59;
        if (StatusBarUtil.isStatusBarTransparent() == false) goto L59;
        r0 = r0 + s1.A();     // Catch: JSONException -> L83
        goto L59
    L63:
        if (PadConfigUtils.c() == false) goto L90;
        if (r24 == false) goto L66;
        float r31 = r13.n;     // Catch: JSONException -> L83
    L67:
        r0 = s1.f(r31);     // Catch: JSONException -> L83
        if (r24 == false) goto L70;
        float r32 = r13.o;     // Catch: JSONException -> L83
    L71:
        int r110 = (s1.w() - r0) - s1.f(r32);     // Catch: JSONException -> L83
        if (r24 == true) goto L74;
    L76:
        r28 = r110;
        goto L77
    L74:
        if (r110 >= s1.f(r13.r)) goto L76;
        r110 = r110 + s1.f(r13.q);     // Catch: JSONException -> L83
        goto L76
    L70:
        r32 = r13.p;     // Catch: JSONException -> L83
        goto L71
    L66:
        r31 = r13.m;     // Catch: JSONException -> L83
        goto L67
    L90:
        return;
    L44:
        if (e5.o(r14) == true) goto L46;
        r24 = true;
        goto L48
    L46:
        r24 = false;
        goto L48
    L80:
        throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");     // Catch: JSONException -> L83
    L89:
        return;
    L88:
        return;
    L81:
        Unit r33 = Unit.INSTANCE;     // Catch: JSONException -> L83
        return;
    L83:
        Unit r34 = Unit.INSTANCE;
        return;
    L86:
        return;
    L5:
        if (r2.getWidth() <= 0) goto L11;
        if (r2.getHeight() <= 0) goto L11;
        if (((r2.getHeight() * r19) / r2.getWidth()) >= r20) goto L11;
        r4 = 2;
        goto L12
    }

    public final void Fr(String r4, int r5, int r6) {
        Map r0 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("event_name", "liveplay_resizeVideoView"), TuplesKt.to("reason", r4), TuplesKt.to("orientation", Integer.valueOf(this.U2.getScreenOrientation())), TuplesKt.to("videoWidth", Integer.valueOf(r5)), TuplesKt.to("videoHeight", Integer.valueOf(r6))});
        r0.put("scaleType", Integer.valueOf(R8().getScaleType()));
        com.bytedance.android.livesdk.log.b0.o().b("ttlive_room", r0);
        Er("update layout params! playerView scaleType : " + R8().getScaleType() + ", orientation : " + this.U2.getScreenOrientation() + ",  videoWidth : " + r5 + ", videoHeight : " + r6 + ", reason : " + r4);
    }

    public final boolean Tr(Room r18, LiveVrEffectInfo r19, boolean r20) {
        StringBuilder r2 = new StringBuilder("LivePlayerWidget onVrTransferTypeChangeSwitchStream onRoomEnter:");
        r2.append(r20);
        r2.append(", LIVE_VR_6DOF_ON_ROOM_ENTER_ENABLE_SWITCH_STREAM:");
        h8 r4 = h8.a;
        r2.append((Boolean) r4.getValue());
        com.bytedance.android.live.player.utils.b.c("LiveVrEffect", r2.toString());
        if (r20 == true) goto L5;
    L7:
        long r6 = r19.getVrTransferType();
        String r5 = String.valueOf(r19.getDefault2dStreamId());
        String r8 = String.valueOf(r19.getTransferSixDofStreamId());
        ILivePlayerClient r9 = dr();
        String r11 = null;
        if ((r9 instanceof LivePlayerClient) == true) goto L10;
        r9 = null;
    L10:
        LivePlayerClient r10 = (LivePlayerClient) r9;
        if (r10 == null) goto L13;
        LivePlayerContext r12 = r10.getPlayerContext();
    L14:
        if (r12 == null) goto L20;
        LiveStreamData r13 = r12.a();
        if (r13 == null) goto L20;
        LiveStreamInfo r14 = r13.a;
        if (r14 == null) goto L20;
        String r15 = r14.getStreamId();
    L21:
        if (r12 == null) goto L25;
        LiveRequest r16 = r12.a;
        if (r16 == null) goto L25;
        r16.getStreamData();
    L25:
        ILivePlayerClient r17 = dr();
        if (r17 == null) goto L28;
        LiveVrEffectInfo r21 = r17.getVrEffectManagerVrEffectInfoCopy();
    L30:
        if (r6 != 2) goto L32;
        boolean r110 = true;
    L34:
        if (r6 != 1) goto L36;
        boolean r7 = true;
    L37:
        StreamUrl r22 = r18.getStreamUrl();
        if (r22 == null) goto L40;
        String r23 = kr(r22, r5);
    L41:
        StreamUrl r111 = r18.getStreamUrl();
        if (r111 == null) goto L44;
        String r112 = kr(r111, r8);
    L45:
        if (r110 == false) goto L47;
        String r113 = r8;
    L50:
        if (r110 == false) goto L52;
        r11 = r112;
    L55:
        if (r2.a(r15) == true) goto L57;
    L61:
        boolean r24 = false;
    L62:
        if (r20 == false) goto L65;
        if (r24 == false) goto L65;
        boolean r114 = true;
    L66:
        if (r20 == true) goto L70;
        if (r110 == false) goto L70;
        if (r24 == false) goto L70;
        boolean r25 = true;
    L71:
        if (r114 == true) goto L75;
        if (r25 == true) goto L75;
        boolean r26 = false;
    L76:
        com.bytedance.android.live.player.utils.b.c("LiveVrEffect", "LivePlayerWidget onVrTransferTypeChangeSwitchStream onRoomEnter:" + r20 + ", effectInfo:" + r19 + ", curVrEffectManagerVrEffectInfo:" + r21 + ", curStreamId:" + r15 + ", default2dStreamId:" + r5 + ", transferSixDofStreamId:" + r8 + ", switchTransferSixDofStream:" + r110 + ", switchDefault2dStream:" + r7 + ", needSwitchStream:" + r26 + ", targetStreamId:" + r113);
        if (r11 != null) goto L79;
    L82:
        boolean r1 = true;
    L83:
        if (r1 == true) goto L91;
        if (r26 == false) goto L91;
        final ILivePlayerClient r3 = dr();
        if (r3 == null) goto L88;
        com.bytedance.android.live.player.utils.b.c("LiveVrEffect", "LivePlayerWidget switchStreamData");
        r3.switchStreamData(r11, new LivePlayerWidget$onVrTransferTypeChangeSwitchStream$1$1(r3));
    L88:
        Gq(r19, false);
        return true;
    L91:
        return false;
    L79:
        if (r11.length() == 0) goto L82;
        r1 = false;
    L75:
        r26 = true;
    L70:
        r25 = false;
    L65:
        r114 = false;
        goto L66
    L57:
        if (r2.a(r113) == false) goto L61;
        if ((!Intrinsics.areEqual(r15, r113)) == false) goto L61;
        r24 = true;
        goto L62
    L52:
        if (r7 == false) goto L55;
        r11 = r23;
        goto L55
    L47:
        if (r7 == false) goto L49;
        r113 = r5;
        goto L50
    L49:
        r113 = null;
        goto L50
    L44:
        r112 = null;
        goto L45
    L40:
        r23 = null;
        goto L41
    L36:
        r7 = false;
        goto L37
    L32:
        r110 = false;
        goto L34
    L28:
        r21 = null;
    L20:
        r15 = null;
        goto L21
    L13:
        r12 = null;
        goto L14
    L5:
        if (((Boolean) r4.getValue()).booleanValue() == true) goto L7;
        return false;
    }

    @Override // gs0.c
    public final void a4(final VSCameraInfo r12, boolean r13, boolean r14, final boolean r15) {
        if (this.I != null) goto L7;
        View r2 = ((ViewStub) ((Widget) this).containerView.findViewById(2131389333)).inflate();
        this.I = new CameraTransitionViewHolder(r2, ((Widget) this).dataCenter);
        if (MatchRoomLandScapeAnimUtil.a == false) goto L7;
        MatchRoomLandScapeAnimUtil.c("match_camera", r2, false, false, false, 28);
    L7:
        CameraTransitionViewHolder r0 = this.I;
        if (r0 != null) goto L10;
        return;
    L10:
        boolean r3 = false;
        if (r13 == r14) goto L13;
        boolean r4 = true;
    L15:
        if (r4 == true) goto L40;
        ViewGroup.LayoutParams r6 = null;
        if (PadConfigUtils.c() == false) goto L31;
        IRoomContextService r5 = jc1.k.f(IRoomContextService.class);
        if (r5 == null) goto L25;
        com.bytedance.android.livesdk.chatroom.o r7 = IRoomContextService.a.a(r5, null, 0, 3);
        if (r7 == null) goto L25;
        com.bytedance.live.datacontext.n r8 = r7.getPadOrientation();
        if (r8 == null) goto L25;
        PadOrientation r9 = (PadOrientation) r8.getValue();
    L27:
        if (r9 == PadOrientation.LANDSCAPE) goto L40;
        if (e5.n() == false) goto L31;
    L25:
        r9 = null;
    L31:
        int r10 = R8().getRenderView().getWidth();
        int r11 = R8().getRenderView().getHeight();
        ViewGroup.LayoutParams r16 = R8().getRenderView().getLayoutParams();
        if ((r16 instanceof FrameLayout.LayoutParams) == false) goto L35;
        r6 = r16;
    L35:
        FrameLayout.LayoutParams r17 = (FrameLayout.LayoutParams) r6;
        if (r17 == null) goto L38;
        int r18 = r17.topMargin;
    L39:
        VideoViewParams r19 = new VideoViewParams(r10, r11, r18, 0.0f);
    L41:
        if (r13 == true) goto L44;
        if (r14 == true) goto L44;
        r3 = true;
    L44:
        r0.a(r19, r3, !r4, new LivePlayerWidget$changeCameraStreamWithAnim$1(this, r12, r15));
        return;
    L38:
        r18 = 0;
    L40:
        r19 = new VideoViewParams(-1, -1, 0, 0.0f);
        goto L41
    L13:
        r4 = false;
        goto L15
    }

    public final void as(int r38, int r39, String r40, Integer r41) {
        if (((Boolean) yh0.a.getValue()).booleanValue() == false) goto L165;
        Pair<Integer, Integer> r1 = lr();
        int r10 = ((Number) r1.component1()).intValue();
        int r2 = ((Number) r1.component2()).intValue();
        if (r10 == 0) goto L577;
        if (r2 != 0) goto L9;
        return;
    L9:
        if (((Boolean) ai0.a.getValue()).booleanValue() == true) goto L11;
    L28:
        boolean r6 = Rq(r41);
        Ur(r6, this.L);
        boolean r3 = Ir(r6);
        boolean r19 = Hr(r6);
        if (r10 != 16) goto L32;
        if (r2 != 16) goto L32;
        boolean r11 = true;
    L34:
        if ((((double) r10) / ((double) r2)) <= 0.75d) goto L36;
        boolean r5 = true;
    L37:
        if (r19 == true) goto L65;
        if (r3 == true) goto L65;
        Room r4 = this.U2.w();
        if (r4 != null) goto L42;
    L48:
        boolean r7 = false;
    L49:
        if (r7 == true) goto L56;
        if (r5 == false) goto L56;
        if (Rq(null) == false) goto L56;
        if (r11 == true) goto L56;
        if (this.x1 == true) goto L56;
    L59:
        Gr(this, new ViewGroup.MarginLayoutParams(-1, -1), r2, r10, r38);
    L56:
        if (r7 == true) goto L58;
    L60:
        this.U2.setPortraitVideoViewMarginTop(0);
        this.w = true;
        if (VSMediaUIConfigHelper.b(((Widget) this).dataCenter) == false) goto L65;
        if (((Boolean) this.S.getValue()).booleanValue() == false) goto L65;
        this.U2.setPortraitVideoViewBottom(0);
        Lr();
        goto L65
    L58:
        if (Intrinsics.areEqual(v5.a.getValue(), Boolean.TRUE) == false) goto L60;
    L42:
        if (r4.isThirdParty() != true) goto L48;
        Room r8 = this.U2.w();
        if (r8 == null) goto L48;
        if (r8.isVrRoom() != true) goto L48;
        r7 = true;
    L65:
        ds();
        if (VrUtils.d(((Widget) this).dataCenter) == false) goto L68;
        int r9 = fr();
    L70:
        if (VrUtils.d(((Widget) this).dataCenter) == false) goto L72;
        int r12 = 0;
    L73:
        Pair r13 = TuplesKt.to(Integer.valueOf(r9), Integer.valueOf(r12));
        DataCenter r14 = ((Widget) this).dataCenter;
        if (r14 == null) goto L76;
        r14.put("data_video_size", r13);
    L76:
        boolean r15 = com.bytedance.android.live.revenue.core.util.h.a;
        com.bytedance.android.live.revenue.core.util.h.d(kc0.j.class).updateVideoHeight(this.V0, r9, r12);
        if (PadConfigUtils.c() == true) goto L103;
        String r16 = jc1.k.n(IMiddlewareUserService.class).user().n();
        Room r17 = this.U2.w();
        if (r17 == null) goto L82;
        String r18 = r17.getAnchorId();
    L84:
        if (com.bytedance.android.livesdk.utils.landscape.e.b(Intrinsics.areEqual(r16, r18), this.U2.w()) == false) goto L103;
        Er("adaptSplitScreen screenOrientation : " + this.U2.getScreenOrientation());
        if (Rq(null) == false) goto L89;
        R8().setPadding(0, 0, 0, 0);
        goto L103
    L89:
        boolean r20 = com.bytedance.android.livesdk.utils.landscape.e.a(this.U2.w());
        int r21 = UIUtils.getStatusBarHeight(((Widget) this).context);
        if (r20 == false) goto L97;
        if (((Boolean) l42.a.g.getValue()).booleanValue() == true) goto L97;
        int r22 = (int) UtilityKotlinExtentionsKt.h(200.0f);
        if (DigHoleScreenUtil.isDigHole(((Widget) this).context) == false) goto L100;
        r21 = r22;
        int r23 = r21;
    L101:
        R8().setPadding(r23, 0, r21, 0);
    L100:
        r21 = r22;
        r23 = 0;
    L97:
        if (DigHoleScreenUtil.isDigHole(((Widget) this).context) == false) goto L99;
        r23 = r21;
        goto L101
    L99:
        r22 = 0;
        goto L100
    L82:
        r18 = null;
    L103:
        if (this.P0 == null) goto L109;
        if (((Boolean) bi0.a.getValue()).booleanValue() == false) goto L107;
        ms(this, r40, 0, 0, null, r41, 14);
        goto L109
    L107:
        ms(this, r40, (r38 - R8().getPaddingLeft()) - R8().getPaddingRight(), r39, null, r41, 8);
    L109:
        ILivePlayerClient r0 = dr();
        if (r0 == null) goto L112;
        r0.setVideoSize(TuplesKt.to(Integer.valueOf(r10), Integer.valueOf(r2)));
    L112:
        R8().getRenderView().addRenderViewMeasureListener(this.Q2);
        if ((R8().getRenderView() instanceof SurfaceRenderView) == false) goto L120;
        SurfaceRenderView r24 = R8().getRenderView();
        if (r24 == null) goto L118;
        r24.addRenderViewLayoutListener(this.P2);
        goto L120
    L118:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdkapi.view.SurfaceRenderView");
    L120:
        if ((R8().getRenderView() instanceof TextureRenderView) == false) goto L126;
        TextureRenderView r25 = R8().getRenderView();
        if (r25 == null) goto L125;
        r25.addRenderViewLayoutListener(this.P2);
        goto L126
    L125:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdkapi.view.TextureRenderView");
    L126:
        Fr(r40, r10, r2);
        if (this.Q1 != null) goto L132;
        if (m1.b(this) == false) goto L136;
        m1.c(this, new Pair(Integer.valueOf(s1.y()), Integer.valueOf(s1.w())), r41);
    L136:
        ILivePlayerClient r26 = LivePlatformPlayerManager.f();
        if (r26 != null) goto L139;
        return;
    L139:
        if (Intrinsics.areEqual(R8().getRenderView(), r26.getRenderView()) == true) goto L141;
        return;
    L141:
        if (r26.isVrLive() == false) goto L581;
        ILivePlayerClient r27 = LivePlatformPlayerManager.f();
        if (r27 != null) goto L145;
    L158:
        LivePlayerView r28 = R8();
        if ((r28 instanceof LivePlayerView) == true) goto L161;
        LivePlayerView r110 = null;
    L162:
        LivePlayerView r111 = r110;
        if (r111 == null) goto L584;
        r111.setScaleType(5);
        return;
    L584:
        return;
    L161:
        r110 = r28;
        goto L162
    L145:
        if (r27.isVrLive() != true) goto L158;
        if (VrUtils.e() == false) goto L158;
        LivePlayerView r29 = R8();
        if ((r29 instanceof LivePlayerView) == true) goto L151;
        LivePlayerView r112 = null;
    L152:
        LivePlayerView r113 = r112;
        if (r113 == null) goto L155;
        r113.setScaleType(10002);
    L155:
        IRenderView r30 = r26.getRenderView();
        if (r30 == null) goto L582;
        r30.setCurrentLandscape(true ^ r6);
        return;
    L582:
        return;
    L151:
        r112 = r29;
        goto L152
    L581:
        return;
    L132:
        if (Intrinsics.areEqual(r40, "onConfigurationChanged") == false) goto L136;
        if (m1.b(this) == false) goto L136;
        m1.c(this, new Pair(Integer.valueOf(s1.y()), Integer.valueOf(s1.w())), r41);
        goto L136
    L72:
        r12 = (int) R8().getRenderView().getSelfView().getY();
        goto L73
    L68:
        r9 = R8().getHeight();
        goto L70
    L36:
        r5 = false;
    L32:
        r11 = false;
        goto L34
    L11:
        if (yr() == true) goto L28;
        StringBuilder r31 = new StringBuilder("skip resize by configScene[");
        AbsLivePlayerView r32 = R8();
        if ((r32 instanceof LivePlayerView) == true) goto L15;
        r32 = null;
    L15:
        LivePlayerView r33 = (LivePlayerView) r32;
        if (r33 == null) goto L20;
        LivePlayerConfig r34 = r33.getConfig();
        if (r34 == null) goto L20;
        ILivePlayerScene r35 = r34.getScene();
    L21:
        r31.append(r35);
        r31.append("] not match useScene[");
        ILivePlayerClient r36 = dr();
        if (r36 == null) goto L26;
        LivePlayerClientContext r37 = r36.context();
        if (r37 == null) goto L26;
        ILivePlayerScene r114 = r37.getUseScene();
    L27:
        r31.append(r114);
        r31.append("] from: ");
        r31.append(r40);
        Er(r31.toString());
        return;
    L26:
        r114 = null;
    L20:
        r35 = null;
        goto L21
    L577:
        return;
    L165:
        Pair<Integer, Integer> r42 = lr();
        int r43 = ((Number) r42.component1()).intValue();
        int r115 = ((Number) r42.component2()).intValue();
        if (r43 == 0) goto L586;
        if (r115 == 0) goto L594;
        float r44 = r115;
        float r45 = r43;
        float r116 = r44 / r45;
        boolean r46 = Rq(r41);
        String r117 = this.L;
        Ur(r46, r117);
        boolean r210 = Ir(r46);
        if (r210 == false) goto L172;
    L174:
        boolean r211 = Hr(r46);
        if (r211 == false) goto L177;
    L179:
        ViewGroup.LayoutParams r212 = R8().getRenderView().getLayoutParams();
        if (r212 == null) goto L576;
        ViewGroup.MarginLayoutParams r47 = (ViewGroup.MarginLayoutParams) r212;
        if (r43 != 16) goto L185;
        if (r115 != 16) goto L185;
        boolean r48 = true;
    L187:
        if ((((double) r43) / ((double) r115)) <= 0.75d) goto L189;
        boolean r49 = true;
    L190:
        String r118 = this.U2.getEnterRoomInfo().getLinkerMap();
        if (r118 != null) goto L193;
        r118 = "";
    L193:
        DataCenter r119 = ((Widget) this).dataCenter;
        if (r119 == null) goto L198;
        String r120 = "adaptSplitScreen screenOrientation : ";
        Integer r50 = (Integer) r119.get("data_pk_moved_margin_top", -1);
        if (r50 == null) goto L199;
        int r51 = r50.intValue();
    L200:
        DataCenter r121 = ((Widget) this).dataCenter;
        if (r121 == null) goto L205;
        String r122 = "null cannot be cast to non-null type com.bytedance.android.livesdkapi.view.SurfaceRenderView";
        Boolean r123 = (Boolean) r121.get("ktv_mv_style_flag", Boolean.FALSE);
        if (r123 == null) goto L206;
        boolean r124 = r123.booleanValue();
    L208:
        if (r211 == true) goto L244;
        if (r210 == true) goto L244;
        Room r125 = this.U2.w();
        if (r125 == null) goto L219;
        boolean r213 = r124;
        if (r125.isThirdParty() != true) goto L220;
        Room r126 = this.U2.w();
        if (r126 == null) goto L220;
        if (r126.isVrRoom() != true) goto L220;
        boolean r127 = true;
    L221:
        if (r127 == true) goto L228;
        if (r49 == false) goto L228;
        if (Rq(null) == false) goto L228;
        if (r48 == true) goto L228;
        if (this.x1 == true) goto L228;
    L231:
        Gr(this, r47, r115, r43, r38);
    L245:
        R8().getRenderView().setLayoutParams(r47);
        ds();
        if (VrUtils.d(((Widget) this).dataCenter) == false) goto L248;
        int r52 = fr();
    L250:
        if (VrUtils.d(((Widget) this).dataCenter) == false) goto L252;
        int r53 = 0;
    L253:
        Pair r128 = TuplesKt.to(Integer.valueOf(r52), Integer.valueOf(r53));
        DataCenter r129 = ((Widget) this).dataCenter;
        if (r129 == null) goto L256;
        r129.put("data_video_size", r128);
    L256:
        boolean r54 = com.bytedance.android.live.revenue.core.util.h.a;
        com.bytedance.android.live.revenue.core.util.h.d(kc0.j.class).updateVideoHeight(this.V0, r52, r53);
        ViewGroup.LayoutParams r55 = R8().getRenderView().getLayoutParams();
        if ((r55 instanceof FrameLayout.LayoutParams) == true) goto L259;
        r55 = null;
    L259:
        FrameLayout.LayoutParams r130 = (FrameLayout.LayoutParams) r55;
        if (r130 != null) goto L263;
        return;
    L263:
        if ((!Intrinsics.areEqual("video_talk_room", r118)) == false) goto L265;
        boolean r56 = false;
        r130.gravity = 0;
    L267:
        if (r117 == null) goto L270;
        if (r210 == false) goto L270;
        Wq(this, r46, r117, r56, r40);
        boolean r131 = r46;
        ViewGroup.MarginLayoutParams r310 = r47;
        String r132 = r120;
        float r133 = r45;
        String r311 = "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams";
        float r134 = r44;
    L412:
        if (PadConfigUtils.c() == true) goto L442;
        String r57 = jc1.k.n(IMiddlewareUserService.class).user().n();
        Room r58 = this.U2.w();
        if (r58 == null) goto L417;
        String r59 = r58.getAnchorId();
    L419:
        if (com.bytedance.android.livesdk.utils.landscape.e.b(Intrinsics.areEqual(r57, r59), this.U2.w()) == false) goto L442;
        Er(r132 + this.U2.getScreenOrientation());
        if (Rq(null) == false) goto L429;
        ViewGroup.LayoutParams r60 = R8().getLayoutParams();
        if ((r60 instanceof ViewGroup.MarginLayoutParams) == true) goto L426;
        r60 = null;
    L426:
        ViewGroup.MarginLayoutParams r61 = (ViewGroup.MarginLayoutParams) r60;
        if (r61 == null) goto L442;
        r61.rightMargin = 0;
        r61.leftMargin = 0;
        R8().setLayoutParams(r61);
        goto L442
    L429:
        boolean r62 = com.bytedance.android.livesdk.utils.landscape.e.a(this.U2.w());
        int r63 = UIUtils.getStatusBarHeight(((Widget) this).context);
        ViewGroup.LayoutParams r65 = R8().getLayoutParams();
        if (r65 == null) goto L574;
        ViewGroup.MarginLayoutParams r66 = (ViewGroup.MarginLayoutParams) r65;
        if (r62 == false) goto L439;
        if (((Boolean) l42.a.g.getValue()).booleanValue() == true) goto L439;
        r66.rightMargin = (int) UtilityKotlinExtentionsKt.h(200.0f);
        if (DigHoleScreenUtil.isDigHole(((Widget) this).context) == false) goto L441;
        r66.leftMargin = r63;
    L441:
        R8().setLayoutParams(r66);
    L439:
        if (DigHoleScreenUtil.isDigHole(((Widget) this).context) == false) goto L441;
        r66.leftMargin = r63;
        r66.rightMargin = r63;
        goto L441
    L574:
        throw new NullPointerException(r311);
    L417:
        r59 = null;
    L442:
        ILivePlayerClient r67 = dr();
        if (r67 == null) goto L446;
        r67.setVideoSize(TuplesKt.to(Integer.valueOf(r43), Integer.valueOf(r115)));
    L446:
        if (Hr(r131) == true) goto L512;
        if (Ir(r131) == true) goto L512;
        String r68 = jc1.k.n(IMiddlewareUserService.class).user().n();
        Room r69 = this.U2.w();
        if (r69 == null) goto L452;
        String r70 = r69.getAnchorId();
    L453:
        boolean r71 = Intrinsics.areEqual(r68, r70);
        if (Rq(null) == false) goto L471;
        if (r43 > r115) goto L461;
        if (this.U2.getInPkMode() == true) goto L461;
        if (this.U2.f == false) goto L471;
    L461:
        if (er().getFixPlayerWidgetDatacenterCrash() == false) goto L469;
        DataCenter r72 = ((Widget) this).dataCenter;
        if (r72 == null) goto L467;
        Boolean r73 = (Boolean) r72.get("status_bar_is_visible", Boolean.TRUE);
        if (r73 == null) goto L467;
        boolean r74 = r73.booleanValue();
    L468:
        Boolean r75 = Boolean.valueOf(r74);
    L470:
        boolean r76 = r75.booleanValue();
    L472:
        Er("adaptStatusBar " + r76 + ", " + r43 + ", " + r115);
        if (StatusBarUtil.STATUS_BAR_ADAPT_ENABLE == false) goto L489;
        if (StatusBarUtil.JUMP_FROM_LIVE_PLAY_ACTIVITY == false) goto L489;
        if (StatusBarUtil.isStatusBarTransparent() == false) goto L489;
        if (r71 == true) goto L489;
        if (r43 <= r115) goto L489;
        if (r76 == false) goto L510;
        DataCenter r77 = ((Widget) this).dataCenter;
        if (r77 == null) goto L486;
        Integer r78 = (Integer) r77.get("interaction_layer_margin_top", 0);
        if (r78 == null) goto L486;
        int r79 = r78.intValue();
    L487:
        r130.topMargin += r79;
    L486:
        r79 = 0;
    L510:
        Er("adaptStatusBar " + r130.topMargin);
    L489:
        if (StatusBarUtil.STATUS_BAR_ADAPT_ENABLE == true) goto L491;
    L500:
        if (r76 == false) goto L510;
        if (this.w == false) goto L510;
        this.w = false;
        DataCenter r80 = ((Widget) this).dataCenter;
        if (r80 == null) goto L508;
        Integer r81 = (Integer) r80.get("interaction_layer_margin_top", 0);
        if (r81 == null) goto L508;
        int r82 = r81.intValue();
    L509:
        r130.topMargin += r82;
    L508:
        r82 = 0;
        goto L509
    L491:
        if (StatusBarUtil.JUMP_FROM_LIVE_PLAY_ACTIVITY == false) goto L500;
        if (StatusBarUtil.isStatusBarTransparent() == false) goto L500;
        if (r71 == true) goto L500;
        if (this.U2.getInPkMode() == true) goto L512;
        if (this.U2.f == false) goto L500;
    L467:
        r74 = true;
        goto L468
    L469:
        r75 = (Boolean) ((Widget) this).dataCenter.get("status_bar_is_visible", Boolean.TRUE);
    L471:
        r76 = false;
        goto L472
    L452:
        r70 = null;
    L512:
        if (VrUtils.e() == false) goto L514;
        int r83 = 0;
        r130.topMargin = 0;
    L515:
        ILivePlayerClient r84 = dr();
        if (r84 != null) goto L518;
    L522:
        R8().getRenderView().setLayoutParams(r130);
        R8().getRenderView().addRenderViewMeasureListener(this.Q2);
        if ((R8().getRenderView() instanceof SurfaceRenderView) == false) goto L530;
        SurfaceRenderView r85 = R8().getRenderView();
        if (r85 == null) goto L528;
        r85.addRenderViewLayoutListener(this.P2);
        goto L530
    L528:
        throw new NullPointerException(r122);
    L530:
        if ((R8().getRenderView() instanceof TextureRenderView) == false) goto L536;
        TextureRenderView r86 = R8().getRenderView();
        if (r86 == null) goto L535;
        r86.addRenderViewLayoutListener(this.P2);
        goto L536
    L535:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdkapi.view.TextureRenderView");
    L536:
        if (r43 <= r115) goto L542;
        FrameLayout.LayoutParams r87 = new FrameLayout.LayoutParams(r310);
        Integer r88 = r41;
        if (Rq(r88) == false) goto L540;
        int r89 = s1.y();
        r87.width = r89;
        r87.height = (int) (r89 * r116);
    L541:
        R8().getLiveStatusController().changeLayoutParams(r87);
    L543:
        Fr(r40, r43, r115);
        if (this.Q1 != null) goto L549;
        if (m1.b(this) == false) goto L554;
        m1.c(this, new Pair(Integer.valueOf(s1.y()), Integer.valueOf(s1.w())), r88);
    L554:
        if (((Boolean) r3.a.getValue()).booleanValue() == true) goto L556;
        return;
    L556:
        if (Intrinsics.areEqual(this.U2.getEnterRoomInfo().getEnterMerge(), "general_search") == false) goto L588;
        ViewParent r90 = R8().getRenderView().getParent();
        if (r90 == null) goto L589;
        ViewParent r91 = r90.getParent();
        if (r91 != null) goto L562;
        return;
    L562:
        if ((r91 instanceof FrameLayout) == false) goto L591;
        FrameLayout r92 = (FrameLayout) r91;
        ViewGroup.LayoutParams r93 = r92.getLayoutParams();
        if ((r93 instanceof FrameLayout.LayoutParams) == false) goto L572;
        FrameLayout.LayoutParams r94 = (FrameLayout.LayoutParams) r93;
        if (r94.topMargin == 0) goto L568;
        int r95 = 0;
        r94.topMargin = 0;
    L570:
        if (r94.bottomMargin == 0) goto L572;
        r94.bottomMargin = r95;
        goto L572
    L568:
        r95 = 0;
    L572:
        r92.setLayoutParams(r93);
        return;
    L591:
        return;
    L589:
        return;
    L588:
        return;
    L549:
        if (Intrinsics.areEqual(r40, "onConfigurationChanged") == false) goto L554;
        if (m1.b(this) == false) goto L554;
        m1.c(this, new Pair(Integer.valueOf(s1.y()), Integer.valueOf(s1.w())), r88);
        goto L554
    L540:
        int r96 = s1.w();
        r87.height = r96;
        r87.width = (int) (r96 * (r133 / r134));
        r87.gravity = 17;
        goto L541
    L542:
        r88 = r41;
        goto L543
    L518:
        if (r84.isVrLive() != true) goto L522;
        if (ur() == false) goto L522;
        r130.topMargin = r83;
        goto L522
    L514:
        r83 = 0;
    L270:
        if (r117 == null) goto L273;
        if (r211 == false) goto L273;
        r131 = r46;
        r133 = r45;
        r132 = r120;
        r134 = r44;
        r310 = r47;
        r311 = "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams";
        Tq(r46, r117, false, r40, null);
    L273:
        r131 = r46;
        r310 = r47;
        r132 = r120;
        r133 = r45;
        r311 = "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams";
        r134 = r44;
        if (r131 == false) goto L399;
        if (r49 == true) goto L278;
        l6 r97 = this.u;
        if (r97.a == false) goto L297;
        R8().setScaleType(0);
        r130.gravity = 17;
    L396:
        if (r213 == false) goto L412;
        R8().setScaleType(2);
        goto L412
    L297:
        if (r97.b == false) goto L300;
        R8().setScaleType(0);
        r130.gravity = 17;
        goto L396
    L300:
        if (this.U2.getStreamType() == LiveMode.THIRD_PARTY) goto L302;
    L314:
        boolean r98 = false;
    L315:
        if (r98 == false) goto L336;
        if (this.s.b == true) goto L336;
        r130.gravity = 17;
        AbsLivePlayerView r99 = R8();
        FrameLayout r100 = R8();
        if (r100.getWidth() <= 0) goto L321;
        boolean r101 = true;
    L322:
        if (r101 == true) goto L325;
        r100 = null;
    L325:
        if (r100 == null) goto L327;
        float r102 = r100.getHeight() / r100.getWidth();
    L329:
        if (r102 >= 1.5f) goto L331;
    L333:
        int r103 = 0;
    L334:
        r99.setScaleType(r103);
        goto L396
    L331:
        if (r102 > r116) goto L333;
        r103 = 2;
        goto L334
    L327:
        r102 = 0.0f;
        goto L329
    L321:
        r101 = false;
    L336:
        if (ur() == false) goto L345;
        R8().setScaleType(0);
        if (r51 <= 0) goto L340;
    L343:
        r130.gravity = 49;
        goto L396
    L340:
        if (this.U2.l == true) goto L343;
        r130.gravity = 17;
        goto L396
    L345:
        if (PadConfigUtils.c() == true) goto L347;
    L349:
        boolean r104 = a2.l(this.U2, ((Widget) this).dataCenter);
        if (this.U2.getStreamType() != LiveMode.SCREEN_RECORD) goto L359;
        AbsLivePlayerView r105 = R8();
        if (PadConfigUtils.c() == true) goto L356;
        AbsLivePlayerView r106 = R8();
        if (r116 <= (r106.getHeight() / r106.getWidth())) goto L356;
        int r107 = 2;
    L357:
        r105.setScaleType(r107);
        r130.gravity = 17;
    L356:
        r107 = 0;
        goto L357
    L359:
        if (this.s.b == false) goto L361;
    L374:
        d8 r108 = this.s;
        if (r108.k == true) goto L379;
        if (r108.l == true) goto L379;
    L392:
        R8().setScaleType(2);
        if (r51 <= 0) goto L395;
        r130.topMargin = r51;
        r130.gravity = 49;
        goto L396
    L395:
        r130.gravity = 17;
    L379:
        if (this.p1 == true) goto L392;
        R8().setScaleType(3);
        if (r51 <= 0) goto L383;
        r130.topMargin = r51;
    L383:
        r130.gravity = 49;
        ViewGroup.LayoutParams r109 = R8().getLayoutParams();
        if (r109 == null) goto L391;
        ((FrameLayout.LayoutParams) r109).width = -1;
        ViewGroup.LayoutParams r135 = R8().getLayoutParams();
        if (r135 == null) goto L389;
        ((FrameLayout.LayoutParams) r135).height = -1;
        r130.width = -1;
        r130.height = -1;
        goto L396
    L389:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
    L391:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
    L361:
        if (a2.k(this.U2, ((Widget) this).dataCenter) == true) goto L363;
        if (r104 == false) goto L374;
    L363:
        if (r104 == false) goto L368;
        InteractPlayViewManager r136 = this.t;
        if (r136 == null) goto L396;
        r136.updateRenderViewLPGravityIfNeed(R8().getRenderView(), 85, "resizeVideoView");
        goto L396
    L368:
        if ((R8() instanceof LivePlayerView) == false) goto L396;
        LivePlayerView r137 = R8();
        if (r137 == null) goto L373;
        r130 = a2.b(r130, r137, dr(), ((Widget) this).context, this.U2, ((Widget) this).dataCenter);
        goto L396
    L373:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdkapi.roomplayer.LivePlayerView");
    L347:
        if (this.s.b == false) goto L349;
        Eq(r130, r43, r115);
        goto L396
    L302:
        if (r116 < 1.77f) goto L314;
        if (r116 > 1.78f) goto L314;
        StreamUrl r138 = this.U2.getStreamUrl();
        if (r138 == null) goto L314;
        IStreamUrlExtra r139 = r138.getExtra();
        if (r139 == null) goto L314;
        AdaptionInfo r140 = r139.getAdaptionInfo();
        if (r140 == null) goto L314;
        if (r140.getVerticalResizeMode() != 1) goto L314;
        r98 = true;
        goto L315
    L278:
        if (PadConfigUtils.c() == true) goto L280;
    L282:
        ILivePlayerClient r141 = dr();
        if (r141 == null) goto L289;
        ILivePlayerExtraRenderController r142 = r141.extraRenderController();
        if (r142 == null) goto L289;
        int r143 = 1;
        if (r142.isGameRoom() != true) goto L290;
        zq(true, r130, r43, r115);
    L290:
        R8().setScaleType(0);
        r130.gravity = r143;
        Pair<DisplayRatio, RenderViewInfo> r144 = hr(r43, r115);
        if (r144 == null) goto L396;
        R8().setScaleType(6);
        R8().getRenderView().setDisplayRatio((DisplayRatio) r144.getFirst());
        ((ii1.b) this.U2.o().e).k.g = DisplayRatio.Companion.getRatioType((DisplayRatio) r144.getFirst());
    L289:
        r143 = 1;
        goto L290
    L280:
        if (this.s.b == false) goto L282;
        Eq(r130, r43, r115);
        goto L396
    L399:
        if (PadConfigUtils.c() == true) goto L401;
    L403:
        ILivePlayerClient r145 = dr();
        if (r145 == null) goto L410;
        ILivePlayerExtraRenderController r146 = r145.extraRenderController();
        if (r146 == null) goto L410;
        if (r146.isGameRoom() != true) goto L410;
        zq(false, r130, r43, r115);
    L410:
        R8().setScaleType(0);
        r130.gravity = 17;
        goto L412
    L401:
        if (this.s.b == false) goto L403;
        Eq(r130, r43, r115);
        goto L412
    L265:
        r56 = false;
        goto L267
    L252:
        r53 = (int) R8().getRenderView().getSelfView().getY();
        goto L253
    L248:
        r52 = R8().getHeight();
    L228:
        if (r127 == false) goto L233;
        if (Intrinsics.areEqual(v5.a.getValue(), Boolean.TRUE) == true) goto L231;
    L233:
        if ((!Intrinsics.areEqual("video_talk_room", r118)) == false) goto L239;
        if (r51 < 0) goto L236;
        int r147 = r51;
    L237:
        r47.topMargin = r147;
        goto L239
    L236:
        r147 = 0;
    L239:
        if ("video_talk_room".equals(r118) == false) goto L242;
        if (r46 == true) goto L242;
        int r148 = 0;
        r47.topMargin = 0;
    L243:
        this.U2.setPortraitVideoViewMarginTop(r148);
        this.w = true;
    L242:
        r148 = 0;
    L220:
        r127 = false;
        goto L221
    L219:
        r213 = r124;
    L244:
        r213 = r124;
    L206:
        r124 = false;
        goto L208
    L205:
        r122 = "null cannot be cast to non-null type com.bytedance.android.livesdkapi.view.SurfaceRenderView";
    L199:
        r51 = -1;
        goto L200
    L198:
        r120 = "adaptSplitScreen screenOrientation : ";
        goto L199
    L189:
        r49 = false;
    L185:
        r48 = false;
        goto L187
    L576:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L177:
        if (br().c() == false) goto L179;
        Or();
        goto L179
    L172:
        if (cr().c() == false) goto L174;
        Pr();
        goto L174
    L594:
        return;
    }

    public final void zq(boolean r10, FrameLayout.LayoutParams r11, int r12, int r13) {
        ILivePlayerClient r0 = dr();
        if (r0 == null) goto L25;
        ILivePlayerExtraRenderController r1 = r0.extraRenderController();
        if (r1 != null) goto L7;
        return;
    L7:
        if (r1.isGameRoom() == false) goto L9;
        ILivePlayerExtraRenderController r8 = r1;
    L10:
        if (r8 != null) goto L13;
        return;
    L13:
        if (Intrinsics.areEqual((Boolean) r8.eventHub().getExtraRenderIsShow().getValue(), Boolean.FALSE) == false) goto L19;
        R8().setScaleType(0);
        r11.leftMargin = 0;
        r11.width = -1;
        r11.height = -1;
        if (r10 == false) goto L17;
        r11.gravity = 1;
        return;
    L17:
        r11.gravity = 17;
        return;
    L19:
        if (r10 == false) goto L21;
        r8.onScreenPortrait();
    L22:
        R8().post(new d(this, r13, r12, r10, r8));
        return;
    L21:
        ILivePlayerExtraRenderController.DefaultImpls.onScreenLandscape$default(r8, false, 1, null);
        goto L22
    L9:
        r8 = null;
        goto L10
    }

    public static void Gr(LivePlayerWidget r6, ViewGroup.MarginLayoutParams r7, int r8, int r9, int r10) {
        boolean r1 = true;
        if (Build.VERSION.SDK_INT < 24) goto L12;
        Context r0 = ((Widget) r6).context;
        if ((r0 instanceof Activity) == true) goto L7;
        r0 = null;
    L7:
        Activity r2 = (Activity) r0;
        if (r2 == null) goto L12;
        if (r2.isInPictureInPictureMode() != true) goto L12;
        return;
    L12:
        v9 r3 = r6.n;
        int r4 = 0;
        if (r3 != null) goto L15;
    L23:
        boolean r5 = false;
    L24:
        if (r5 == false) goto L26;
        int r11 = (int) (s1.w() * ((Float) qf0.a.getValue()).floatValue());
    L55:
        r7.topMargin = r11;
        r6.U2.setPortraitVideoViewMarginTop(r11);
        if (r9 == 0) goto L59;
        r6.U2.setPortraitVideoViewBottom(((r8 * r10) / r9) + r7.topMargin);
    L59:
        if (r6.Rq(null) == false) goto L63;
        Pair<DisplayRatio, RenderViewInfo> r12 = r6.hr(r9, r8);
        if (r12 == null) goto L63;
        r6.U2.setPortraitVideoViewBottom(((((DisplayRatio) r12.getFirst()).getScaleHeight() * r10) / ((DisplayRatio) r12.getFirst()).getScaleWidth()) + r7.topMargin);
    L63:
        DataCenter r13 = ((Widget) r6).dataCenter;
        if (r13 == null) goto L66;
        r13.put("data_stream_to_avoid_bottom_position", Integer.valueOf(r6.U2.getPortraitVideoViewBottom()));
    L66:
        DataCenter r14 = ((Widget) r6).dataCenter;
        if (r14 == null) goto L69;
        r14.put("data_stream_to_avoid_top_position", Integer.valueOf(r6.U2.getPortraitVideoViewMarginTop()));
    L69:
        r6.Er("player view topMargin : " + r11 + ",  bottom : " + r6.U2.getPortraitVideoViewBottom());
        r6.Lr();
        return;
    L26:
        Object r15 = h3.a.getValue();
        Boolean r16 = Boolean.TRUE;
        if (Intrinsics.areEqual(r15, r16) == true) goto L29;
        DataCenter r17 = ((Widget) r6).dataCenter;
        if (r17 == null) goto L46;
        Boolean r18 = (Boolean) r17.get("status_bar_is_visible", r16);
        if (r18 == null) goto L46;
        r1 = r18.booleanValue();
    L46:
        DataCenter r19 = ((Widget) r6).dataCenter;
        if (r19 == null) goto L51;
        Integer r20 = (Integer) r19.get("interaction_layer_margin_top", 0);
        if (r20 == null) goto L51;
        r4 = r20.intValue();
    L51:
        r11 = UtilityKotlinExtentionsKt.i(((Integer) cx0.a.getValue()).intValue());
        if (r1 == true) goto L55;
        r11 = r11 - r4;
        goto L55
    L29:
        if (PadConfigUtils.c() == false) goto L31;
        r11 = s1.f(122.0f);
    L33:
        if (LiveInitSettingKeys.get_LIVE_PLAYER_LAYOUT_FIX_STATUSBAR() == false) goto L38;
        if (TTMiddlewareLiveSDK.sHostService.appContext().getTopSpaceHeight() != 0) goto L55;
        int r21 = StatusBarUtil.getStatusBarHeight(s1.getContext());
    L40:
        r11 = r11 + r21;
        goto L55
    L38:
        if (StatusBarUtil.isStatusBarTransparent() == false) goto L55;
        r21 = StatusBarUtil.getStatusBarHeight(s1.getContext());
        goto L40
    L31:
        r11 = UtilityKotlinExtentionsKt.i(((Integer) cx0.a.getValue()).intValue());
        goto L33
    L15:
        if (r6.zr() == false) goto L23;
        CropSeiData r22 = r3.f;
        if (r22 == null) goto L23;
        if (r22.isLegalCropSei() != true) goto L23;
        if (r3.isInteract() == false) goto L23;
        r5 = true;
        goto L24
    }

    public static void Wq(LivePlayerWidget r18, boolean r19, String r20, boolean r21, String r22) {
        if (r18.c == null) goto L23;
        Context r13 = ((Widget) r18).context;
        if (r13 == null) goto L24;
        ILivePlayerClient r1 = r18.dr();
        if (r1 == null) goto L13;
        LivePlayerClientContext r2 = r1.context();
        if (r2 == null) goto L13;
        ILivePlayerScene r3 = r2.getUseScene();
    L15:
        if ((!Intrinsics.areEqual(r3, LivePlayerScene.INSTANCE.getINNER_DRAW())) == true) goto L25;
        Pair<Integer, Integer> r4 = r18.lr();
        int r5 = ((Number) r4.component1()).intValue();
        int r6 = ((Number) r4.component2()).intValue();
        if (r19 == true) goto L20;
        int r14 = r6;
        int r15 = r5;
    L21:
        rc0.f r12 = r18.cr();
        AbsLivePlayerView r7 = r18.R8();
        LiveMode r8 = r18.U2.getStreamType();
        ds0.d r9 = r18.U2;
        r12.g(new rc0.j(r19, r7, r8, r20, null, r9.h, r9.i, r9.j, r9.k, r21, r22, r13), com.bytedance.android.live.core.utils.a0.o(((Widget) r18).dataCenter), TuplesKt.to(Integer.valueOf(r14), Integer.valueOf(r15)));
        return;
    L20:
        r15 = r6;
        r14 = r5;
        goto L21
    L25:
        return;
    L13:
        r3 = null;
        goto L15
    L24:
        return;
    }

    public final void Tq(boolean r17, String r18, boolean r19, String r20, rc0.q r21) {
        if (this.c != null) goto L5;
        return;
    L5:
        Context r14 = ((Widget) this).context;
        if (r14 != null) goto L8;
        return;
    L8:
        ILivePlayerClient r1 = dr();
        if (r1 == null) goto L13;
        LivePlayerClientContext r2 = r1.context();
        if (r2 == null) goto L13;
        ILivePlayerScene r3 = r2.getUseScene();
    L15:
        if ((!Intrinsics.areEqual(r3, LivePlayerScene.INSTANCE.getINNER_DRAW())) == false) goto L17;
        return;
    L17:
        rc0.e r4 = br();
        AbsLivePlayerView r5 = R8();
        LiveMode r6 = this.U2.getStreamType();
        ds0.d r7 = this.U2;
        r4.h(new rc0.j(r17, r5, r6, r18, r21, r7.h, r7.i, r7.j, r7.k, r19, r20, r14));
        if (r17 == false) goto L31;
        rc0.m r8 = br().f();
        ds0.d r9 = this.U2;
        int r10 = 0;
        if (r8 == null) goto L22;
        int r11 = r8.c;
    L23:
        r9.setPortraitVideoViewMarginTop(r11);
        ds0.d r12 = this.U2;
        if (r8 == null) goto L26;
        r10 = r8.c + r8.b;
    L26:
        r12.setPortraitVideoViewBottom(r10);
        DataCenter r13 = ((Widget) this).dataCenter;
        if (r13 == null) goto L29;
        r13.put("data_stream_to_avoid_bottom_position", Integer.valueOf(this.U2.getPortraitVideoViewBottom()));
    L29:
        Lr();
        return;
    L22:
        r11 = 0;
        goto L23
    L31:
        return;
    L13:
        r3 = null;
        goto L15
    }

    public static void ms(LivePlayerWidget r1, String r2, int r3, int r4, String r5, Integer r6, int r7) {
        if ((r7 & 2) == 0) goto L6;
        r3 = r1.R8().getWidth();
    L6:
        if ((r7 & 4) == 0) goto L9;
        r4 = r1.R8().getHeight();
    L9:
        if ((r7 & 8) == 0) goto L17;
        ILivePlayerClient r8 = r1.dr();
        if (r8 == null) goto L16;
        LivePlayerClientContext r9 = r8.context();
        if (r9 == null) goto L16;
        r5 = r9.getLastLayoutSei();
        if (r5 != null) goto L17;
    L16:
        r5 = "";
    L17:
        Integer r0 = null;
        if ((r7 & 16) == 0) goto L20;
        r6 = null;
    L20:
        r1.getClass();
        if (((Boolean) zh0.a.getValue()).booleanValue() == false) goto L23;
        r0 = r6;
    L23:
        com.bytedance.android.livesdk.player.layout.n r10 = r1.P0;
        if (r10 != null) goto L26;
        return;
    L26:
        if (((Boolean) j40.r0.a.getValue()).booleanValue() == false) goto L35;
        if (r5 != null) goto L29;
    L32:
        boolean r11 = true;
    L33:
        if (r11 == false) goto L35;
        r5 = r1.L;
        goto L35
    L29:
        if (StringsKt.isBlank(r5) == true) goto L32;
        r11 = false;
    L35:
        boolean r12 = LivePlayerLayoutContextObserver.a;
        r10.a(r5, LivePlayerLayoutContextObserver.a(new LivePlayerWidget$updatePlayerLayout$1(r1, r0, r4, r3)), r2);
    }

    public final void onRoomExitV2(long r1, String r3, boolean r4, Room r5, ls2.e r6, boolean r7, EndReason r8) {
        Intrinsics.checkNotNullParameter(r3, "userId");
        Intrinsics.checkNotNullParameter(r6, "error");
        Intrinsics.checkNotNullParameter(r8, "reason");
        this.g2 = false;
        if (((Boolean) xg0.a.getValue()).booleanValue() == false) goto L9;
        this.p1 = false;
        d8 r2 = this.s;
        if (r2 == null) goto L7;
        r2.k = false;
    L7:
        if (r2 == null) goto L9;
        r2.l = false;
    L9:
        ViewGroup r9 = ((Widget) this).containerView;
        if (r9 == null) goto L14;
        FrameLayout r10 = (FrameLayout) r9.findViewById(2131381829);
        if (r10 == null) goto L14;
        UtilityKotlinExtentionsKt.t(r10);
    L14:
        LivePlayerView r11 = null;
        if (r5 != null) goto L17;
    L32:
        DataCenter r12 = ((Widget) this).dataCenter;
        if (r12 == null) goto L35;
        es0.a.c r13 = (es0.a.c) r12.get("cmd_current_sub_camera_state", es0.a.c.c);
    L36:
        if (r13 == null) goto L38;
        boolean r14 = r13.b;
    L39:
        if (r14 == false) goto L41;
    L42:
        DataCenter r15 = ((Widget) this).dataCenter;
        if (r15 == null) goto L47;
        Room r16 = com.bytedance.android.live.core.utils.z.o(r15);
        if (r16 == null) goto L47;
        StreamUrl r17 = r16.getStreamUrl();
    L48:
        if (r17 == null) goto L80;
        LiveCoreSDKData r18 = r17.getLiveCoreSDKData();
        if (r18 == null) goto L79;
        LiveCoreSDKData.PullData r19 = r18.pullData;
        if (r19 == null) goto L82;
        this.U2.a(r19.getStreamData());
        Integer r20 = (Integer) zt0.a.getValue();
        if (r20 != null) goto L58;
    L68:
        if (r20 == null) goto L80;
        if (r20.intValue() != 2) goto L80;
        LivePlayerView r21 = R8();
        if ((r21 instanceof LivePlayerView) == false) goto L76;
        r11 = r21;
    L76:
        LivePlayerView r22 = r11;
        if (r22 == null) goto L80;
        r22.resetRenderView();
        goto L80
    L58:
        if (r20.intValue() != 1) goto L68;
        if (this.W != 1) goto L68;
        LivePlayerView r23 = R8();
        if ((r23 instanceof LivePlayerView) == false) goto L65;
        r11 = r23;
    L65:
        LivePlayerView r24 = r11;
        if (r24 == null) goto L80;
        r24.resetRenderView();
        goto L80
    L82:
        return;
    L79:
        return;
    L80:
        this.U2.setSwitchingSubCamera(false);
        this.U2.setCurrentSubSteamKey("");
        return;
    L47:
        r17 = null;
        goto L48
    L41:
        if (this.U2.isSwitchingSubCamera() == true) goto L42;
        return;
    L38:
        r14 = false;
        goto L39
    L35:
        r13 = null;
        goto L36
    L17:
        if (r5.isMergeVSRoom() != true) goto L32;
        if (RoomKt.hasMultiCamera(r5) == false) goto L32;
        this.U2.m = null;
        ILivePlayerClient r25 = dr();
        if (r25 == null) goto L27;
        IRoomEventHub r26 = r25.getEventHub();
        if (r26 == null) goto L27;
        MutableLiveData r27 = r26.getPlayComplete();
        if (r27 == null) goto L27;
        r27.removeObserver(this.U2.r());
    L27:
        ds0.d r28 = this.U2;
        nm1.m r29 = pm1.f.l();
        if (r29 == null) goto L30;
        VSCameraInfo r30 = r29.o(r5);
    L31:
        r28.c(r30);
        goto L32
    L30:
        r30 = null;
        goto L31
    }
}
