package com.bytedance.android.live.liveinteract.videotalk;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.opengl.GLSurfaceView;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.base.model.message.ILinkmicEnlargeGuestMessage;
import com.bytedance.android.live.base.model.message.e6;
import com.bytedance.android.live.base.model.message.f6;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.broadcast.api.AnchorInteractionData;
import com.bytedance.android.live.broadcast.api.IMiddlewareBroadcastService;
import com.bytedance.android.live.broadcastgame.api.interactgame.IGameDataService;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.b6;
import com.bytedance.android.live.core.tetris.layer.core.event.LayerEventDispatcher;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.live.core.utils.ExceptionUtils;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.utils.screen.FoldScreenUtils;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.effect.event.ReleaseStatus;
import com.bytedance.android.live.link.IMultiLinkServiceExternal;
import com.bytedance.android.live.liveinteract.animation.InteractAnimationContext;
import com.bytedance.android.live.liveinteract.animation.InteractAnimationController;
import com.bytedance.android.live.liveinteract.animation.universalwidget.MultiLinkUniversalAnimWidget;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.api.chatroom.model.OpenPanelType;
import com.bytedance.android.live.liveinteract.api.fulllink.InteractLinkFullLinkMonitor;
import com.bytedance.android.live.liveinteract.api.fulllink.LinkMonitorData;
import com.bytedance.android.live.liveinteract.api.fulllink.TalkRoomBusinessFullLinkMonitor;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.model.CPositionInviteType;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.model.CPositionReplyType;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.model.CPositionToEnlargePosition;
import com.bytedance.android.live.liveinteract.component.MultiComponentManager;
import com.bytedance.android.live.liveinteract.component.api.linkpanel.ILinkPanelService;
import com.bytedance.android.live.liveinteract.digitavatar.DigitAvatarContext;
import com.bytedance.android.live.liveinteract.digitavatar.videoavatar.VideoDigitAvatarWidget;
import com.bytedance.android.live.liveinteract.interactivesong.impl.InteractiveSongContext;
import com.bytedance.android.live.liveinteract.interactivesong.impl.InteractiveSongWidget;
import com.bytedance.android.live.liveinteract.linkbase.api.MediaOperation;
import com.bytedance.android.live.liveinteract.linkcast.LinkCastAnchorWidget;
import com.bytedance.android.live.liveinteract.linkpanel.vm.AdminInviteAndApplyViewModel;
import com.bytedance.android.live.liveinteract.model.LinkScreenCastType;
import com.bytedance.android.live.liveinteract.plantform.api.LinkApi;
import com.bytedance.android.live.liveinteract.plantform.api.LinkAudienceApi;
import com.bytedance.android.live.liveinteract.plantform.camera.SwitchCameraManager;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.BaseLinkSeatWindowView;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.CommonLinkSeatWindowView;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.BaseMultiLinkWindowManager;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.CommonMultiLinkWindowManager;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.DynamicEqualMultiLinkWindowManager;
import com.bytedance.android.live.liveinteract.plantform.linksecurity.rts.RTSVideoWidget;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.plantform.model.r0;
import com.bytedance.android.live.liveinteract.plantform.permission.model.OperateType;
import com.bytedance.android.live.liveinteract.plantform.spatial.SpatialAudioStrategyManager;
import com.bytedance.android.live.liveinteract.plantform.utils.PublicStreamClientMixStrategy;
import com.bytedance.android.live.liveinteract.plantform.utils.PublicStreamPlayState;
import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomLogUtils;
import com.bytedance.android.live.liveinteract.plantform.utils.u0;
import com.bytedance.android.live.liveinteract.plantform.widgt.videolink.MultiLinkVideoBaseAnchorLinkWidget;
import com.bytedance.android.live.liveinteract.playmode.SceneType;
import com.bytedance.android.live.liveinteract.revenue.guestlink.GuestLinkContext;
import com.bytedance.android.live.liveinteract.revenue.linkroomfight.core.LinkRoomFightContext;
import com.bytedance.android.live.liveinteract.revenue.linkroomfight.ui.MultiLinkLinkRoomFightWindowManager;
import com.bytedance.android.live.liveinteract.revenuebase.MultiRevenueDataContext;
import com.bytedance.android.live.liveinteract.spatial.SpatialAudioContext;
import com.bytedance.android.live.liveinteract.utils.MultiLinkLoadWidgetUtils;
import com.bytedance.android.live.liveinteract.utils.s0;
import com.bytedance.android.live.liveinteract.utils.w0;
import com.bytedance.android.live.liveinteract.videolink.VideoTalkAnchorContext;
import com.bytedance.android.live.liveinteract.videotalk.cposition.CPositionContext;
import com.bytedance.android.live.liveinteract.videotalk.cposition.CPositionWidget;
import com.bytedance.android.live.liveinteract.videotalk.dialog.CPositionBeInvitedDialog;
import com.bytedance.android.live.liveinteract.videotalk.dialog.VideoTalkIntegrationGuidDialog;
import com.bytedance.android.live.liveinteract.videotalk.perf.VideoEffectPerfHelper;
import com.bytedance.android.live.liveinteract.videotalk.quickinteract.QuickInteractWidget;
import com.bytedance.android.live.liveinteract.voicechat.emoji.VideoTalkInteractEmojiPanel;
import com.bytedance.android.live.liveinteract.voicechat.match.widget.ChatMatchWidget;
import com.bytedance.android.live.liveinteract.voicechat.toolbar.ToolbarRoomBattleBehavior;
import com.bytedance.android.live.liveinteract.wrds.LinkWRDSHelper;
import com.bytedance.android.live.multilink.external.api.core.type.AckFromSource;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.live.pushstream.model.LiveRequestSourceRole;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livehostapi.business.depend.livead.IMiddlewareLiveMiniAppService;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.android.livesdk.chatroom.model.LinkFinishResult;
import com.bytedance.android.livesdk.chatroom.model.interact.EnlargeGuestInfo;
import com.bytedance.android.livesdk.chatroom.model.interact.e1;
import com.bytedance.android.livesdk.chatroom.model.interact.v1;
import com.bytedance.android.livesdk.chatroom.viewmodel.LivePlayModeLogContext;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.g3;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3;
import com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget;
import com.bytedance.android.livesdk.chatroom.widget.j1;
import com.bytedance.android.livesdk.config.mk;
import com.bytedance.android.livesdk.config.t61;
import com.bytedance.android.livesdk.config.u61;
import com.bytedance.android.livesdk.ktvapi.IKtvService;
import com.bytedance.android.livesdk.ktvapi.util.KtvCommonSettingHelper;
import com.bytedance.android.livesdk.link.model.bridge.g2;
import com.bytedance.android.livesdk.link.model.bridge.u1;
import com.bytedance.android.livesdk.link.model.bridge.z0;
import com.bytedance.android.livesdk.link.model.l6;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.android.livesdk.schema.interfaces.IBaseLiveActionHandler;
import com.bytedance.android.livesdk.utils.d5;
import com.bytedance.android.livesdk.utils.r2;
import com.bytedance.android.livesdk.wrds.LinkMicRoomDataSyncModel;
import com.bytedance.android.livesdkapi.depend.message.ClientUIInfo;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveTheme;
import com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveThemeKt;
import com.bytedance.android.livesdkapi.depend.model.live.circleinfo.ICircleInfo;
import com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkerChangeMediaInfoContent;
import com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkerClientUIInfoChangeContent;
import com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkerUILayoutChangeContent;
import com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkmicMediaParam;
import com.bytedance.android.livesdkapi.model.LinkAudioInviteGuideConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.ies.sdk.widgets.WidgetManager;
import com.bytedance.kmp.live.livelink.api.model.VideoShowMode;
import com.bytedance.live.bizlink.api.platform.rtc.rtcinfo.MultiLinkInfoType;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.livelink.kmp.api.base.config.InteractMode;
import com.bytedance.live.livelink.kmp.api.core.mixer.MixStreamType;
import com.bytedance.mt.protector.impl.UriProtector;
import com.google.gson.JsonObject;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import hh1.v0;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.BehaviorSubject;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;
import uf2.m1;
import zg1.h1;
import zg1.l3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\b\u0012\u0004\u0012\u00020\b0\u00072\u00020\t2\u00020\n2\u00020\u000b2\u00020\f:\u0003\r\u000e\u000f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/live/liveinteract/videotalk/MultiLinkVideoTalkRoomAnchorWidget;", "Lcom/bytedance/android/live/liveinteract/plantform/widgt/videolink/MultiLinkVideoBaseAnchorLinkWidget;", "Lrj0/k;", "Lzj0/e$b;", "Lng6/b;", "Lhe0/c$a;", "Lyj0/a$a;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "Ltf0/o$a;", "Lrj0/n;", "Lvlc/l;", "Lrj0/i;", "a", "b", "c", "videolink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class MultiLinkVideoTalkRoomAnchorWidget extends MultiLinkVideoBaseAnchorLinkWidget implements rj0.k, zj0.e.b, ng6.b, yj0.a.InterfaceC0294a, Observer<KVData>, tf0.o.a, rj0.n, vlc.l, rj0.i {
    public static final /* synthetic */ int h2 = 0;
    public boolean A;
    public int B;
    public long C;
    public int D;
    public tf0.o E;
    public Disposable F;
    public Disposable G;
    public final com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.u G1;
    public yj0.a H;
    public ChatMatchWidget H0;
    public com.bytedance.android.live.liveinteract.plantform.utils.u H1;
    public boolean I;
    public int J;
    public boolean K;
    public gd0.d L;
    public com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b L0;
    public final VideoEffectPerfHelper L1;
    public InteractAnimationController M;
    public final com.bytedance.android.live.liveinteract.videotalk.h M1;
    public boolean N;
    public SwitchCameraManager O;
    public QuickInteractWidget P;
    public boolean P0;
    public boolean P1;
    public LinkCastAnchorWidget Q;
    public boolean Q1;
    public CPositionWidget R;
    public final cj0.e S;
    public boolean S1;
    public InteractiveSongWidget T;
    public final com.bytedance.android.live.liveinteract.videotalk.c T1;
    public RTSVideoWidget U;
    public Widget V;
    public zj0.e V0;
    public final com.bytedance.android.live.liveinteract.videotalk.d V1;
    public CPositionBeInvitedDialog W;
    public com.bytedance.android.live.liveinteract.videotalk.utils.a X;
    public final ArrayList<ILinkPlayerInfoBridge> Y;
    public final ArrayList<ILinkPlayerInfoBridge> Z;
    public boolean b1;
    public j50.a b2;
    public boolean g1;
    public k50.c g2;
    public boolean h1;
    public final HashMap<String, View> k0;
    public com.bytedance.android.live.liveinteract.voicechat.toolbar.f k1;
    public final HashMap<String, Boolean> p0;
    public int p1;
    public String v1;
    public sh0.i0 w;
    public boolean x;
    public final com.bytedance.android.live.liveinteract.plantform.utils.s x1;
    public boolean y;
    public MiddlewareRoomWidget y1;
    public boolean z;

    public static final class a {
    }

    public static final class b implements Consumer<Throwable> {
        public final long a;

        public b(long r1) {
            this.a = r1;
        }

        public final void accept(Object r6) {
            Throwable r7 = (Throwable) r6;
            TalkRoomBusinessFullLinkMonitor r0 = TalkRoomBusinessFullLinkMonitor.a;
            long r1 = this.a;
            r0.getClass();
            TalkRoomBusinessFullLinkMonitor.A(r1, "live_end", r7);
            long r2 = this.a;
            com.bytedance.android.live.liveinteract.plantform.utils.x.k(r7, System.currentTimeMillis() - r2, "live_end");
        }
    }

    public static final class c implements Consumer<ExtraResponse<LinkFinishResult, Extra>> {
        public final long a;
        public final int b;

        public final void accept(Object r6) {
            ExtraResponse r7 = (ExtraResponse) r6;
            if (r7 == null) goto L5;
            TalkRoomBusinessFullLinkMonitor r1 = TalkRoomBusinessFullLinkMonitor.a;
            long r2 = this.a;
            r1.getClass();
            TalkRoomBusinessFullLinkMonitor.B(r2, "live_end", r7);
        L5:
            long r3 = this.a;
            com.bytedance.android.live.liveinteract.plantform.utils.x.l(System.currentTimeMillis() - r3, "live_end");
            if (r7 == null) goto L11;
            LinkFinishResult r8 = (LinkFinishResult) r7.data;
            if (r8 == null) goto L12;
            TalkRoomLogUtils.V(r8.getTotalApplyNum(), r8.getTotalLinkedNum(), this.b);
            return;
        L12:
            return;
        }

        public c(long r1, int r3) {
            this.a = r1;
            this.b = r3;
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ Ref.ObjectRef a;
        public final /* synthetic */ long b;

        public d(Ref.ObjectRef r1, long r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r5) {
            TalkRoomBusinessFullLinkMonitor r0 = TalkRoomBusinessFullLinkMonitor.a;
            String r1 = (String) this.a.element;
            long r2 = this.b;
            String r6 = ((com.bytedance.android.live.network.response.e) r5).logId;
            r0.getClass();
            TalkRoomBusinessFullLinkMonitor.q(r1, r2, r6);
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ MultiLinkVideoTalkRoomAnchorWidget a;
        public final /* synthetic */ Ref.ObjectRef b;
        public final /* synthetic */ long c;

        public e(MultiLinkVideoTalkRoomAnchorWidget r1, Ref.ObjectRef r2, long r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r5) {
            ApiServerException r6 = (Throwable) r5;
            TalkRoomBusinessFullLinkMonitor r0 = TalkRoomBusinessFullLinkMonitor.a;
            String r1 = (String) this.b.element;
            long r2 = this.c;
            r0.getClass();
            TalkRoomBusinessFullLinkMonitor.o(r1, r2, r6);
            if ((r6 instanceof ApiServerException) == false) goto L13;
            ApiServerException r3 = r6;
            String r4 = r3.getPrompt();
            if (r4 != null) goto L7;
        L10:
            boolean r7 = true;
        L11:
            if (r7 == true) goto L13;
            f2.c(r3.getPrompt(), 0);
            return;
        L7:
            if (r4.length() == 0) goto L10;
            r7 = false;
        L13:
            ExceptionUtils.handleException(((Widget) this.a).context, r6);
        }
    }

    public static final class f<T> implements Consumer {
        public final /* synthetic */ MultiLinkVideoTalkRoomAnchorWidget a;

        public f(MultiLinkVideoTalkRoomAnchorWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            fd2.z r3 = (fd2.z) r2;
            MultiLinkVideoTalkRoomAnchorWidget r4 = this.a;
            tf0.o r0 = r4.E;
            if (r0 == null) goto L6;
            r0.u(Boolean.valueOf(r4.isEngineOn()));
            return;
        }
    }

    public static final class g implements Runnable {
        public final /* synthetic */ MultiLinkVideoTalkRoomAnchorWidget a;

        public g(MultiLinkVideoTalkRoomAnchorWidget r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            MultiLinkVideoTalkRoomAnchorWidget r0 = this.a;     // Catch: Throwable -> L4
            int r1 = MultiLinkVideoTalkRoomAnchorWidget.h2;     // Catch: Throwable -> L4
            r0.gr();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class h<T> implements Consumer {
        public final /* synthetic */ MultiLinkVideoTalkRoomAnchorWidget a;

        public h(MultiLinkVideoTalkRoomAnchorWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            Integer r5 = (Integer) r4;
            StringBuilder r0 = new StringBuilder("currentStrategyId onValueChanged : ");
            r0.append(r5);
            r0.append(" isSpatialAudioEnable: ");
            int r1 = -1;
            if (r5 == null) goto L5;
            int r2 = r5.intValue();
        L6:
            r0.append(com.bytedance.android.live.liveinteract.spatial.a.e(r2));
            com.bytedance.android.live.liveinteract.spatial.b.a("[VideoTalk]VideoTalkRoomAnchorWidget", r0.toString());
            hg6.g r3 = this.a.R1();
            if (r3 == null) goto L12;
            if (r5 == null) goto L10;
            int r6 = r5.intValue();
        L11:
            r3.i(com.bytedance.android.live.liveinteract.spatial.a.e(r6));
            goto L12
        L10:
            r6 = -1;
        L12:
            if (r5 == null) goto L15;
            r1 = r5.intValue();
        L15:
            if (com.bytedance.android.live.liveinteract.spatial.a.e(r1) == false) goto L20;
            MultiLinkVideoTalkRoomAnchorWidget r7 = this.a;
            tf0.o r8 = r7.E;
            if (r8 == null) goto L21;
            r8.u(Boolean.valueOf(r7.isEngineOn()));
            return;
        L21:
            return;
        L20:
            return;
        L5:
            r2 = -1;
            goto L6
        }
    }

    public static final class i<T> implements Consumer {
        public final /* synthetic */ MultiLinkVideoTalkRoomAnchorWidget a;

        public i(MultiLinkVideoTalkRoomAnchorWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            MultiLinkVideoTalkRoomAnchorWidget r0 = this.a;
            int r5 = ((com.bytedance.android.livesdk.chatroom.viewmodel.j) r4).a;
            int r1 = MultiLinkVideoTalkRoomAnchorWidget.h2;
            r0.getClass();
            if (r5 != 8) goto L5;
        L6:
            com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b r6 = r0.L0;
            if (r6 == null) goto L10;
            r6.setAlpha(1.0f);
        L10:
            if (((Boolean) mk.a.getValue()).booleanValue() == true) goto L12;
        L38:
            this.a.Rq();
            return;
        L12:
            if (jc0.a.c() == true) goto L35;
            com.bytedance.android.livesdk.chatroom.u r7 = com.bytedance.android.live.liveinteract.api.utils.m.d();
            if (r7 == null) goto L33;
            com.bytedance.live.datacontext.j r2 = r7.getVideoTalkRoomSubScene();
            if (r2 == null) goto L33;
            com.bytedance.android.livesdk.chatroom.viewmodel.e r3 = (com.bytedance.android.livesdk.chatroom.viewmodel.e) r2.getValue();
            if (r3 == null) goto L33;
            com.bytedance.android.livesdk.chatroom.viewmodel.j r8 = r3.t();
            if (r8 == null) goto L33;
            if (r8.a != 8) goto L33;
            com.bytedance.live.datacontext.j r9 = r7.getVideoTalkRoomSubScene();
            if (r9 == null) goto L33;
            com.bytedance.android.livesdk.chatroom.viewmodel.e r10 = (com.bytedance.android.livesdk.chatroom.viewmodel.e) r9.getValue();
            if (r10 == null) goto L33;
            com.bytedance.android.livesdk.chatroom.viewmodel.j r11 = r10.t();
            if (r11 == null) goto L33;
            if (r11.c != 62) goto L33;
            boolean r12 = true;
        L34:
            if (r12 == false) goto L38;
        L33:
            r12 = false;
        L35:
            MultiLinkVideoTalkRoomAnchorWidget r13 = this.a;
            if (r13.U == null) goto L40;
            r13.enableSubWidgetManager();
            ((Widget) r13).subWidgetManager.unload(r13.U);
            return;
        L40:
            return;
        L5:
            if (r5 != 12) goto L10;
            goto L6
        }
    }

    public static final class j<T> implements Consumer {
        public final /* synthetic */ MultiLinkVideoTalkRoomAnchorWidget a;

        public j(MultiLinkVideoTalkRoomAnchorWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r5) {
            Long r6 = (Long) r5;
            CopyOnWriteArrayList<ILinkPlayerInfoBridge> r7 = this.a.yq().c;
            MultiLinkVideoTalkRoomAnchorWidget r0 = this.a;
            if (((Widget) r0).isViewValid == false) goto L27;
            Disposable r1 = r0.G;
            if (r1 != null) goto L8;
            Intrinsics.throwUninitializedPropertyAccessException("mLogDisposable");
        L8:
            if (r1.isDisposed() == false) goto L10;
            return;
        L10:
            if ((!r7.isEmpty()) == false) goto L29;
            ArrayList r2 = new ArrayList();
            Iterator<ILinkPlayerInfoBridge> r8 = r7.iterator();
        L13:
            if (r8.hasNext() == false) goto L20;
            ILinkPlayerInfoBridge r3 = r8.next();
            if (r3.getRoleType() == 1) goto L17;
            boolean r4 = true;
        L18:
            if (r4 == false) goto L13;
            r2.add(r3);
            goto L13
        L17:
            r4 = false;
            goto L18
        L20:
            int r9 = r2.size();
            LinkedHashMap r10 = new LinkedHashMap();
            r10.put("connect_acu", String.valueOf(r9));
            r10.put("room_type", "video");
            mz0.n r11 = new mz0.n();
            Map r12 = r11.a;
            Intrinsics.checkNotNullParameter(r12, "map");
            Intrinsics.checkNotNullParameter(r10, "map");
            r12.putAll(r10);
            mz0.m r13 = new mz0.m();
            r13.b(LogCommon.ROOM);
            ((ArrayList) r11.b).addAll(r13.a);
            cy0.e.a.getClass();
            cy0.j r14 = cy0.e.a.a;
            com.bytedance.android.scope.m.e.getClass();
            Object r15 = com.bytedance.android.scope.m.b(r14).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
            Intrinsics.checkNotNull(r15);
            ((f80.a) r15).w3("anchor_audience_connection_onemin", r11.a, r11.b);
            return;
        L29:
            return;
        }
    }

    public static final class k<T> implements Consumer {
        public final /* synthetic */ MultiLinkVideoTalkRoomAnchorWidget a;

        public k(MultiLinkVideoTalkRoomAnchorWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            MultiLinkVideoTalkRoomAnchorWidget r0 = this.a;
            boolean r5 = ((Boolean) r4).booleanValue();
            int r1 = MultiLinkVideoTalkRoomAnchorWidget.h2;
            r0.getClass();
            StringBuilder r2 = new StringBuilder("onIsSingerChanged ");
            r2.append(r5);
            r2.append(" mute=");
            yj0.a r3 = r0.H;
            if (r3 == null) goto L5;
            Integer r6 = Integer.valueOf(r3.e0());
        L6:
            r2.append(r6);
            r2.append(" isOnBackground=");
            r2.append(r0.I);
            jy0.b.d("video_talk", r2.toString());
            if (r5 == false) goto L24;
            boolean r7 = jc1.k.n(IKtvService.class).isAudienceSingEnableSwitchOn();
            yj0.a r8 = r0.H;
            if (r8 == null) goto L13;
            if (r8.e0() != 0) goto L13;
        L17:
            if (r0.h1 == true) goto L24;
            jg6.a r9 = r0.Bq();
            if (r9 == null) goto L24;
            kg6.e r10 = r9.b();
            if (r10 == null) goto L24;
            r10.u(false, "ksong_start");
        L13:
            if (r0.I == true) goto L17;
            if (r7 == false) goto L17;
            f2.b(2131918609, 0);
        L24:
            if (com.bytedance.android.live.liveinteract.spatial.a.e(r0.C0()) == false) goto L29;
            com.bytedance.android.live.liveinteract.spatial.b.a("[VideoTalk]VideoTalkRoomAnchorWidget", "onKtvSingerStateChanged updateSpatialAudioPosition------");
            tf0.o r11 = r0.E;
            if (r11 == null) goto L30;
            r11.u(Boolean.valueOf(r0.isEngineOn()));
            return;
        L30:
            return;
        L29:
            return;
        L5:
            r6 = null;
            goto L6
        }
    }

    public static final class l implements Runnable {
        public final /* synthetic */ MultiLinkVideoTalkRoomAnchorWidget a;

        public l(MultiLinkVideoTalkRoomAnchorWidget r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.u8("fallback");     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class m<T> implements Consumer {
        public final /* synthetic */ MultiLinkVideoTalkRoomAnchorWidget a;

        public m(MultiLinkVideoTalkRoomAnchorWidget r1) {
            this.a = r1;
        }

        public final void accept(T r4) {
            if ((r4 instanceof n90.e) == false) goto L6;
            int r1 = MultiLinkVideoTalkRoomAnchorWidget.h2;
            this.a.Zq((n90.e) r4);
            return;
        L6:
            if ((r4 instanceof h1) == false) goto L11;
            MultiLinkVideoTalkRoomAnchorWidget r0 = this.a;
            int r2 = MultiLinkVideoTalkRoomAnchorWidget.h2;
            r0.getClass();
            if (((h1) r4).a != 3) goto L21;
            Observable.timer(500, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.bytedance.android.live.liveinteract.videotalk.l(r0));
            return;
        L21:
            return;
        L11:
            if ((r4 instanceof o42.g) == false) goto L17;
            final MultiLinkVideoTalkRoomAnchorWidget r3 = this.a;
            int r5 = MultiLinkVideoTalkRoomAnchorWidget.h2;
            r3.getClass();
            final IBaseUser r6 = ((o42.g) r4).a;
            if (r6 == null) goto L25;
            s0.a(((Widget) r3).context, new MultiLinkVideoTalkRoomAnchorWidget$onEvent$1(r3, r6));
            return;
        L25:
            return;
        L17:
            if ((r4 instanceof o42.l) == false) goto L24;
            MultiLinkVideoTalkRoomAnchorWidget r7 = this.a;
            int r8 = MultiLinkVideoTalkRoomAnchorWidget.h2;
            r7.getClass();
            ((o42.l) r4).getClass();
            return;
        }
    }

    public static final class n<T> implements Consumer {
        public final /* synthetic */ String a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ long c;

        public n(String r1, boolean r2, long r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r6) {
            com.bytedance.android.live.network.response.e r7 = (com.bytedance.android.live.network.response.e) r6;
            TalkRoomBusinessFullLinkMonitor r0 = TalkRoomBusinessFullLinkMonitor.a;
            String r1 = this.a;
            if (r1 != null) goto L5;
            r1 = "";
        L5:
            boolean r2 = this.b;
            long r3 = this.c;
            String r8 = r7.logId;
            r0.getClass();
            TalkRoomBusinessFullLinkMonitor.w(r1, r2, r3, r8);
            int r9 = com.bytedance.android.live.liveinteract.plantform.utils.x.a;
            com.bytedance.android.live.liveinteract.plantform.utils.x.E(this.a, this.b, null);
        }
    }

    public static final class o<T> implements Consumer {
        public final /* synthetic */ String a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ long c;
        public final /* synthetic */ long d;

        public o(String r1, boolean r2, long r3, long r5) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r5;
        }

        public final void accept(Object r6) {
            ApiServerException r7 = (Throwable) r6;
            TalkRoomBusinessFullLinkMonitor r0 = TalkRoomBusinessFullLinkMonitor.a;
            String r1 = this.a;
            if (r1 != null) goto L5;
            r1 = "";
        L5:
            boolean r2 = this.b;
            long r3 = this.c;
            r0.getClass();
            TalkRoomBusinessFullLinkMonitor.u(r1, r2, r3, r7);
            if ((r7 instanceof ApiServerException) == false) goto L16;
            ApiServerException r4 = r7;
            String r5 = r4.getPrompt();
            if (r5 != null) goto L10;
        L13:
            boolean r8 = true;
        L14:
            if (r8 == true) goto L16;
            f2.c(r4.getPrompt(), 0);
        L17:
            jy0.b.b("ttlive_link_video", "主咖邀请回复失败。accept=" + this.b + ",roomId=" + this.d + ", toUid=" + this.a, r7);
            int r9 = com.bytedance.android.live.liveinteract.plantform.utils.x.a;
            com.bytedance.android.live.liveinteract.plantform.utils.x.E(this.a, this.b, r7);
            return;
        L10:
            if (r5.length() == 0) goto L13;
            r8 = false;
        L16:
            f2.b(2131922756, 0);
            goto L17
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.liveinteract.videotalk.MultiLinkVideoTalkRoomAnchorWidget$onCreate$4, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "p1", "", "invoke"}, k = 3, mv = {1, 5, 1})
    public static final /* synthetic */ class AnonymousClass4 extends FunctionReferenceImpl implements Function1<Boolean, Unit> {
        public AnonymousClass4(MultiLinkVideoTalkRoomAnchorWidget r8) {
            super(1, r8, MultiLinkVideoTalkRoomAnchorWidget.class, "isMultipleKtvMode", "isMultipleKtvMode(Z)V", 0);
        }

        public final void invoke(boolean r2) {
            MultiLinkVideoTalkRoomAnchorWidget r0 = (MultiLinkVideoTalkRoomAnchorWidget) ((CallableReference) this).receiver;
            if (r2 == false) goto L7;
            com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b r3 = r0.L0;
            if (r3 == null) goto L11;
            r3.setAlpha(0.34f);
            return;
        L11:
            return;
        L7:
            com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b r4 = r0.L0;
            if (r4 == null) goto L13;
            r4.setAlpha(1.0f);
            return;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke(((Boolean) r1).booleanValue());
            return Unit.INSTANCE;
        }
    }

    public static final class q<T> implements Consumer {
        public final /* synthetic */ String a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ long c;
        public final /* synthetic */ long d;
        public final /* synthetic */ Function1 e;

        public q(String r1, boolean r2, long r3, long r5, Function1 r7) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r5;
            this.e = r7;
        }

        public final void accept(Object r9) {
            TalkRoomBusinessFullLinkMonitor r0 = TalkRoomBusinessFullLinkMonitor.a;
            String r1 = this.a;
            boolean r2 = this.b;
            long r3 = this.c;
            long r5 = this.d;
            String r7 = ((com.bytedance.android.live.network.response.e) r9).logId;
            r0.getClass();
            TalkRoomBusinessFullLinkMonitor.t(r1, r2, r3, r5, r7);
            int r10 = com.bytedance.android.live.liveinteract.plantform.utils.x.a;
            com.bytedance.android.live.liveinteract.plantform.utils.x.D(this.a, this.b, null);
            if (this.b == true) goto L5;
        L7:
            Function1 r11 = this.e;
            if (r11 == null) goto L11;
            Unit r12 = (Unit) r11.invoke(Boolean.TRUE);
            return;
        L11:
            return;
        L5:
            if ((!Intrinsics.areEqual(this.a, je0.d.b0())) == false) goto L7;
            f2.b(2131922715, 0);
            goto L7
        }
    }

    public static final class r<T> implements Consumer {
        public final /* synthetic */ String a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ long c;
        public final /* synthetic */ long d;
        public final /* synthetic */ Function1 e;
        public final /* synthetic */ long f;

        public r(String r1, boolean r2, long r3, long r5, Function1 r7, long r8) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r5;
            this.e = r7;
            this.f = r8;
        }

        public final void accept(Object r8) {
            ApiServerException r9 = (Throwable) r8;
            TalkRoomBusinessFullLinkMonitor r0 = TalkRoomBusinessFullLinkMonitor.a;
            String r1 = this.a;
            if (r1 != null) goto L5;
            r1 = "";
        L5:
            boolean r2 = this.b;
            long r3 = this.c;
            long r5 = this.d;
            r0.getClass();
            TalkRoomBusinessFullLinkMonitor.r(r1, r2, r3, r5, r9);
            Function1 r4 = this.e;
            if (r4 == null) goto L9;
            Unit r6 = (Unit) r4.invoke(Boolean.FALSE);
        L9:
            if ((r9 instanceof ApiServerException) == false) goto L20;
            ApiServerException r7 = r9;
            String r10 = r7.getPrompt();
            if (r10 != null) goto L13;
        L16:
            boolean r11 = true;
        L17:
            if (r11 == true) goto L20;
            f2.c(r7.getPrompt(), 0);
        L24:
            StringBuilder r12 = new StringBuilder();
            if (this.b == false) goto L27;
            String r13 = "设为主咖";
        L28:
            r12.append(r13);
            r12.append("失败。roomId=");
            r12.append(this.f);
            r12.append(", toUid=");
            r12.append(this.a);
            jy0.b.b("ttlive_link_video", r12.toString(), r9);
            int r14 = com.bytedance.android.live.liveinteract.plantform.utils.x.a;
            com.bytedance.android.live.liveinteract.plantform.utils.x.D(this.a, this.b, r9);
            return;
        L27:
            r13 = "取消主咖";
            goto L28
        L13:
            if (r10.length() == 0) goto L16;
            r11 = false;
        L20:
            if (this.b == false) goto L22;
            int r15 = 2131922759;
        L23:
            f2.b(r15, 0);
            goto L24
        L22:
            r15 = 2131922761;
            goto L23
        }
    }

    public static final class s<T, R> implements Function {
        public static final s a = null;

        static {
            a = new s();
        }

        public s() {
        }

        public final Object apply(Object r3) {
            com.bytedance.android.live.network.response.e r4 = (com.bytedance.android.live.network.response.e) r3;
            Intrinsics.checkNotNullParameter(r4, "it");
            LinkMicRoomDataSyncModel r0 = LinkWRDSHelper.b();
            Intrinsics.checkNotNullParameter(r4, "response");
            return Single.create(new com.bytedance.android.live.liveinteract.wrds.g(r0, r4));
        }
    }

    public static final class t<T> implements Consumer {
        public final /* synthetic */ MultiLinkVideoTalkRoomAnchorWidget a;
        public final /* synthetic */ com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.u b;
        public final /* synthetic */ int c;
        public final /* synthetic */ int d;
        public final /* synthetic */ Integer e;
        public final /* synthetic */ String f;
        public final /* synthetic */ long g;
        public final /* synthetic */ int h;
        public final /* synthetic */ boolean i;

        public t(MultiLinkVideoTalkRoomAnchorWidget r1, com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.u r2, int r3, int r4, Integer r5, String r6, long r7, int r9, boolean r10) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
            this.g = r7;
            this.h = r9;
            this.i = r10;
        }

        public final void accept(Object r18) {
            com.bytedance.android.live.network.response.e r7 = (com.bytedance.android.live.network.response.e) r18;
            boolean r8 = false;
            this.a.x = false;
            v1 r9 = (v1) r7.data;
            if (r9 == null) goto L67;
            ALogger.i("ttlive_link_video", "switchSceneApi success from=" + this.a.Qq() + " resp=" + ((v1) r7.data));
            com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.u r1 = this.b;
            if (r1 == null) goto L8;
            r1.c = System.currentTimeMillis();
        L8:
            TalkRoomBusinessFullLinkMonitor r2 = TalkRoomBusinessFullLinkMonitor.a;
            int r3 = this.c;
            int r4 = this.d;
            Integer r5 = this.e;
            if (r5 == null) goto L11;
            int r6 = r5.intValue();
        L12:
            long r10 = this.g;
            r2.getClass();
            TalkRoomBusinessFullLinkMonitor.z0(r3, r4, r6, r10, r7);
            com.bytedance.android.live.liveinteract.plantform.utils.x.B0(this.c, this.d, this.e, r9.getPlayModes());
            com.bytedance.live.datacontext.m r11 = com.bytedance.android.live.liveinteract.api.utils.m.e(this.a).c();
            if (r11 != null) goto L15;
        L16:
            com.bytedance.android.live.liveinteract.plantform.base.g r12 = com.bytedance.android.live.liveinteract.plantform.base.f.a();
            if (r12 == null) goto L19;
            r12.Nf();
        L19:
            com.bytedance.live.datacontext.j r13 = com.bytedance.android.live.liveinteract.api.utils.m.e(this.a).getVideoTalkRoomSubScene();
            if (r13 == null) goto L27;
            com.bytedance.android.livesdk.chatroom.viewmodel.e r14 = (com.bytedance.android.livesdk.chatroom.viewmodel.e) r13.getValue();
            if (r14 == null) goto L27;
            com.bytedance.android.livesdk.chatroom.viewmodel.j r15 = r14.t();
            if (r15 == null) goto L27;
            List<Integer> r16 = r15.b;
            if (r16 == null) goto L27;
        L28:
            zj0.e r17 = this.a.V0;
            if (r17 != null) goto L32;
            Intrinsics.throwUninitializedPropertyAccessException("layoutSwitcher");
        L32:
            if (r17.c(r9.getScene(), r9.getUiLayout(), r16, r9.getPlayModes()) == false) goto L38;
            List<? extends com.bytedance.android.livesdk.link.model.bridge.k> r19 = r9.getLinkedUsers();
            if (r19 == null) goto L36;
            this.a.yq().S4(r19, r9.getClientUiInfo(), r9.getVersion(), "switchSceneApi");
        L36:
            jy0.b.c("ttlive_link_video", "switchSceneApi success but already same layout", null, 4);
        L41:
            MultiLinkVideoTalkRoomAnchorWidget r20 = this.a;
            r20.B = this.d;
            r20.y = true;
            r20.A = false;
            Integer r21 = Integer.valueOf(this.c);
            Integer r22 = Integer.valueOf(this.h);
            Integer r23 = Integer.valueOf(this.d);
            Integer r24 = this.e;
            if (this.i == false) goto L45;
        L62:
            r8 = true;
        L63:
            if (r8 == true) goto L68;
            this.a.Sq();
            TalkRoomLogUtils.h0(this.c, this.d);
            this.a.z = true;
            TalkRoomLogUtils.V(r9.getTotalApply(), r9.getTotalLinked(), this.c);
            return;
        L68:
            return;
        L45:
            if (r21 != null) goto L48;
        L49:
            if (r23 != null) goto L52;
        L54:
            if (r22 != null) goto L57;
        L58:
            if (r24 == null) goto L63;
            if (r24.intValue() != 4) goto L63;
        L57:
            if (r22.intValue() == 4) goto L62;
        L52:
            if (r23.intValue() != 16) goto L54;
        L48:
            if (r21.intValue() == 16) goto L62;
        L38:
            if (vm2.d.v0() == false) goto L40;
            com.bytedance.android.live.liveinteract.plantform.utils.i0 r25 = TalkRoomLogUtils.a;
            String r26 = TalkRoomLogUtils.h;
            Intrinsics.checkNotNullParameter(r26, "<set-?>");
            TalkRoomLogUtils.j = r26;
            com.bytedance.android.live.liveinteract.plantform.utils.i.e(r9, r7.logId);
        L40:
            MultiLinkVideoTalkRoomAnchorWidget r27 = this.a;
            r27.v1 = "";
            r27.Yi(r9, "switchSceneApi", this.f);
        L27:
            r16 = CollectionsKt.emptyList();
            goto L28
        L15:
            if (((Number) r11.getValue()).intValue() == OpenPanelType.NONE.getValue()) goto L19;
        L11:
            r6 = 0;
            goto L12
        }
    }

    public static final class u<T> implements Consumer {
        public final /* synthetic */ MultiLinkVideoTalkRoomAnchorWidget a;
        public final /* synthetic */ int b;
        public final /* synthetic */ int c;
        public final /* synthetic */ Integer d;
        public final /* synthetic */ String e;
        public final /* synthetic */ long f;

        public u(MultiLinkVideoTalkRoomAnchorWidget r1, int r2, int r3, Integer r4, String r5, long r6) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
        }

        public final void accept(Object r9) {
            Throwable r10 = (Throwable) r9;
            MultiLinkVideoTalkRoomAnchorWidget r0 = this.a;
            r0.x = false;
            r0.A = false;
            TalkRoomBusinessFullLinkMonitor r1 = TalkRoomBusinessFullLinkMonitor.a;
            int r2 = this.b;
            int r3 = this.c;
            Integer r4 = this.d;
            if (r4 == null) goto L5;
            int r5 = r4.intValue();
        L6:
            String r6 = this.e;
            if (r6 != null) goto L9;
            r6 = "";
        L9:
            long r7 = this.f;
            r1.getClass();
            int r8 = r5;
            TalkRoomBusinessFullLinkMonitor.y0(r2, r3, r8, r6, r7, r10);
            com.bytedance.android.live.liveinteract.plantform.utils.x.A0(this.b, this.c, r10, this.d);
            ExceptionUtils.handleException(((Widget) this.a).context, r10);
            return;
        L5:
            r5 = 0;
            goto L6
        }
    }

    public static final class v<T> implements Consumer {
        public final /* synthetic */ String a;
        public final /* synthetic */ long b;
        public final /* synthetic */ long c;
        public final /* synthetic */ String d;
        public final /* synthetic */ Function1 e;

        public v(String r1, long r2, long r4, String r6, Function1 r7) {
            this.a = r1;
            this.b = r2;
            this.c = r4;
            this.d = r6;
            this.e = r7;
        }

        public final void accept(Object r9) {
            TalkRoomBusinessFullLinkMonitor r0 = TalkRoomBusinessFullLinkMonitor.a;
            String r1 = this.a;
            long r3 = this.b;
            long r5 = this.c;
            String r7 = ((com.bytedance.android.live.network.response.e) r9).logId;
            r0.getClass();
            TalkRoomBusinessFullLinkMonitor.t(r1, true, r3, r5, r7);
            if ((!Intrinsics.areEqual(this.a, je0.d.b0())) == true) goto L5;
        L8:
            Function1 r10 = this.e;
            if (r10 == null) goto L12;
            Unit r11 = (Unit) r10.invoke(Boolean.TRUE);
            return;
        L12:
            return;
        L5:
            if (TextUtils.equals(this.d, "add") == false) goto L7;
            f2.b(2131922754, 0);
            goto L8
        L7:
            f2.b(2131922715, 0);
            goto L8
        }
    }

    public static final class w<T> implements Consumer {
        public final /* synthetic */ String a;
        public final /* synthetic */ long b;
        public final /* synthetic */ long c;
        public final /* synthetic */ Function1 d;

        public w(String r1, long r2, long r4, Function1 r6) {
            this.a = r1;
            this.b = r2;
            this.c = r4;
            this.d = r6;
        }

        public final void accept(Object r8) {
            ApiServerException r9 = (Throwable) r8;
            TalkRoomBusinessFullLinkMonitor r0 = TalkRoomBusinessFullLinkMonitor.a;
            String r1 = this.a;
            long r3 = this.b;
            long r5 = this.c;
            r0.getClass();
            TalkRoomBusinessFullLinkMonitor.r(r1, true, r3, r5, r9);
            Function1 r2 = this.d;
            if (r2 == null) goto L6;
            Unit r4 = (Unit) r2.invoke(Boolean.FALSE);
        L6:
            if ((r9 instanceof ApiServerException) == false) goto L16;
            ApiServerException r10 = r9;
            String r6 = r10.getPrompt();
            if (r6 != null) goto L10;
        L13:
            boolean r7 = true;
        L14:
            if (r7 == true) goto L16;
            f2.c(r10.getPrompt(), 0);
            return;
        L10:
            if (r6.length() == 0) goto L13;
            r7 = false;
        L16:
            f2.b(2131922759, 0);
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.MultiLinkBaseAnchorLinkWidget, com.bytedance.android.live.liveinteract.plantform.core.v
    public final void D1(String r1, ByteBuffer r2, int r3) {
    }

    @Override // rj0.k, rj0.n
    public final void Q() {
        this.K = true;
        xf6.a r0 = Gq();
        if (r0 == null) goto L5;
        r0.Q();
    L5:
        hg6.g r1 = R1();
        if (r1 == null) goto L9;
        r1.n();
        return;
    }

    @Override // tf0.o.a
    public final j1 Zb() {
        return this;
    }

    public final int getLayoutId() {
        return 2131567591;
    }

    @Override // rj0.n
    public final Widget getWidget() {
        return this;
    }

    @Override // tf0.o.a
    public final /* synthetic */ String l6() {
        return null;
    }

    @Override // yj0.a.InterfaceC0294a
    public final void q(int r1) {
    }

    @Override // tf0.o.a
    public final SurfaceView q1() {
        return null;
    }

    @Override // rj0.i
    public final void v1() {
        Jq(false);
    }

    @Override // rj0.k
    public final void w5() {
    }

    @Override // yj0.a.InterfaceC0294a
    public final void A50() {
        if (((LinkAudioInviteGuideConfig) vm2.d.j0.getValue(null, vm2.d.a[59])).enabled != 1) goto L8;
        tf0.o r0 = this.E;
        if (r0 == null) goto L9;
        r0.f();
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.videolink.MultiLinkVideoBaseAnchorLinkWidget, he0.c.a
    public final int C0() {
        tf0.o r0 = this.E;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.C0();
    }

    @Override // zj0.b
    public final Pair<Integer, Integer> D3() {
        return new Pair(0, 0);
    }

    @Override // rj0.e
    public final boolean G7() {
        LinkCastAnchorWidget r0 = this.Q;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.f;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.videolink.MultiLinkVideoBaseAnchorLinkWidget, com.bytedance.android.live.liveinteract.plantform.widgt.MultiLinkBaseAnchorLinkWidget
    public final void H1() {
        int r0 = this.B;
        int r1 = this.r;
        int r2 = com.bytedance.android.live.liveinteract.plantform.utils.x.a;
        LinkedHashMap r3 = new LinkedHashMap();
        r3.put("switch_to_scene", Integer.valueOf(r0));
        r3.put("init_scene", Integer.valueOf(r1));
        com.bytedance.android.live.liveinteract.plantform.utils.x.t0("before_update_livecore_and_rtc_info", r3);
        VideoEffectPerfHelper r4 = this.L1;
        if (r4 == null) goto L5;
        r4.c();
    L5:
        sh0.i0 r5 = this.w;
        if (r5 == null) goto L9;
        r5.d0(sh0.a0.b, Boolean.TRUE);
    L9:
        if (this.B == 12) goto L13;
        if (this.r == 12) goto L13;
    L25:
        if (((Boolean) vm2.d.h0.getValue(null, vm2.d.a[57])).booleanValue() != true) goto L29;
        ViewGroup r6 = ((Widget) this).containerView;
        if (r6 == null) goto L29;
        r6.post(new l(this));
    L29:
        xf6.a r7 = Gq();
        if (r7 == null) goto L33;
        r7.e(null);
        return;
    L33:
        return;
    L13:
        if (this.r != 12) goto L20;
        hg6.g r8 = R1();
        if (r8 == null) goto L17;
        r8.a(InteractMode.EQUAL_TALK_ROOM);
    L17:
        hg6.g r9 = R1();
        if (r9 == null) goto L20;
        r9.D(this.r, "onStartSuccess");
    L20:
        hg6.g r10 = R1();
        if (r10 == null) goto L23;
        r10.f();
    L23:
        u8("rtcStartSuccess");
        this.r = 0;
        this.B = 0;
        goto L25
    }

    @Override // rj0.e
    public final com.bytedance.android.live.broadcast.api.model.t Hk() {
        LinkCastAnchorWidget r0 = this.Q;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.Hk();
    }

    @Override // rj0.e
    public final void Jj() {
        LinkCastAnchorWidget r0 = this.Q;
        if (r0 == null) goto L6;
        r0.Jj();
        return;
    }

    public final zj0.d Mq() {
        zj0.e r0 = this.V0;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("layoutSwitcher");
    L5:
        zj0.d r1 = r0.d;
        if (r1 == null) goto L8;
        return r1;
    L8:
        return zj0.d.a.h;
    }

    public final int Nq() {
        zj0.e r0 = this.V0;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("layoutSwitcher");
    L5:
        zj0.d r1 = r0.d;
        if (r1 != null) goto L10;
        return 0;
    L10:
        return r1.a;
    }

    @Override // zj0.b
    public final int Rm() {
        return this.Y.size();
    }

    public final void Rq() {
        if (this.U != null) goto L6;
        enableSubWidgetManager();
        RTSVideoWidget r0 = new RTSVideoWidget(R1(), (dn0.c) getScopeServiceOrNullInMultiLinkRoom(dn0.c.class), yq(), null);
        this.U = r0;
        ((Widget) this).subWidgetManager.load(r0);
        return;
    }

    public final void Sq() {
        DataCenter r0 = ((Widget) this).dataCenter;
        Boolean r1 = Boolean.FALSE;
        if (((Boolean) r0.get("data_talk_room_admin_allowed_flag", r1)).booleanValue() == false) goto L6;
        TalkRoomLogUtils.q1("live_chat", ((Boolean) com.bytedance.android.livesdk.sharedpref.c.v1.getValue()).booleanValue());
        ((Widget) this).dataCenter.put("data_talk_room_admin_allowed_flag", r1);
        return;
    }

    @Override // yj0.a.InterfaceC0294a
    public final void Y2() {
        int r0 = this.g;
        int r1 = Nq();
        long r2 = System.currentTimeMillis();
        c r4 = new c(r2, r1);
        b r3 = new b(r2);
        ((LinkApi) com.bytedance.android.live.network.c.b().e(LinkApi.class)).finishV1(getMRoom().getId(), r0, "stop_normally").compose(RxUtil.rxSchedulerHelper()).subscribe(r4, r3);
    }

    @Override // rj0.e
    public final void Yg() {
        LinkCastAnchorWidget r0 = this.Q;
        if (r0 == null) goto L6;
        r0.f = true;
        return;
    }

    public final void ar() {
        DataCenter r0 = ((Widget) this).dataCenter;
        if (r0 == null) goto L5;
        String r1 = (String) r0.get("data_room_unique_id", "");
    L6:
        l6 r2 = tc0.c.i(r1).O;
        tc0.c r4 = tc0.c.h();
        if (r2 == null) goto L9;
        String r5 = r2.getRtcExtInfo();
    L10:
        r4.k = r5;
        tc0.c r6 = tc0.c.h();
        if (r2 == null) goto L13;
        String r7 = r2.getLiveCoreExtInfo();
    L14:
        r6.m = r7;
        if (((Boolean) vm2.d.Z.getValue(null, vm2.d.a[49])).booleanValue() == false) goto L28;
        if (r2 == null) goto L28;
        List r8 = r2.getMLinkUsers();
        if (r8 == null) goto L28;
        Iterator r9 = r8.iterator();
    L21:
        if (r9.hasNext() == false) goto L28;
        com.bytedance.android.livesdk.link.model.bridge.k r10 = (com.bytedance.android.livesdk.link.model.bridge.k) r9.next();
        HashMap<String, Boolean> r11 = this.p0;
        String r12 = r10.getLinkMicIdStr();
        if (r10.getLinkType() == 1) goto L25;
        boolean r13 = true;
    L26:
        r11.put(r12, Boolean.valueOf(r13));
        goto L21
    L25:
        r13 = false;
    L28:
        if (vm2.d.a() == true) goto L38;
        com.bytedance.android.live.liveinteract.plantform.core.y r14 = yq();
        if ((r14 instanceof com.bytedance.android.live.liveinteract.plantform.core.y) == true) goto L32;
        r14 = null;
    L32:
        if (r14 == null) goto L38;
        DataCenter r15 = ((Widget) this).dataCenter;
        if (r15 == null) goto L36;
        String r16 = (String) r15.get("data_room_unique_id", "");
    L37:
        r14.K(tc0.c.i(r16).O);
        goto L38
    L36:
        r16 = null;
    L38:
        pc0.e r17 = jc1.k.n(IMultiLinkServiceExternal.class).getPkServiceExternal().e();
        if (r17 == null) goto L134;
        boolean r18 = r17.e;
        if (vm2.d.a() == false) goto L44;
        boolean r19 = r18;
    L59:
        StringBuilder r20 = new StringBuilder("updateFirstVideoFrame hasLinkAudience4Stop = ");
        r20.append(r18);
        r20.append(", needHandOver = ");
        r20.append(r19);
        r20.append(", isEngineOn = ");
        r20.append(r17.b);
        r20.append(", userSize = ");
        DataCenter r21 = ((Widget) this).dataCenter;
        if (r21 == null) goto L62;
        String r22 = (String) r21.get("data_room_unique_id", "");
    L63:
        l6 r23 = tc0.c.i(r22).O;
        if (r23 == null) goto L68;
        List r24 = r23.getMLinkUsers();
        if (r24 == null) goto L68;
        Integer r25 = Integer.valueOf(r24.size());
    L69:
        r20.append(r25);
        jy0.b.f("ttlive_link_audience", r20.toString(), null, 4);
        if (r19 == false) goto L134;
        com.bytedance.android.live.liveinteract.plantform.core.y r26 = yq();
        if ((r26 instanceof com.bytedance.android.live.liveinteract.plantform.core.y) == true) goto L74;
        r26 = null;
    L74:
        if (r26 == null) goto L80;
        DataCenter r27 = ((Widget) this).dataCenter;
        if (r27 == null) goto L78;
        String r28 = (String) r27.get("data_room_unique_id", "");
    L79:
        r26.K(tc0.c.i(r28).O);
        goto L80
    L78:
        r28 = null;
    L80:
        xf6.a r29 = Gq();
        if (r29 == null) goto L83;
        r29.Zp();
    L83:
        hg6.g r30 = R1();
        if (r30 == null) goto L86;
        r30.p(this);
    L86:
        hg6.g r31 = R1();
        if (r31 == null) goto L90;
        r31.a0(pg6.a.a(com.bytedance.android.live.liveinteract.plantform.widgt.s.a(r17)), this.q);
    L90:
        if (tc0.c.h().E == false) goto L92;
        InteractMode r32 = InteractMode.VIDEO_TALK_CAMERA;
    L93:
        hg6.g r33 = R1();
        if (r33 == null) goto L96;
        r33.a(r32);
    L96:
        hg6.g r34 = R1();
        if (r34 == null) goto L99;
        r34.d0(true);
    L99:
        hg6.g r35 = R1();
        if (r35 == null) goto L102;
        r35.f();
    L102:
        hg6.g r36 = R1();
        if (r36 == null) goto L113;
        DataCenter r37 = ((Widget) this).dataCenter;
        if (r37 == null) goto L107;
        String r38 = (String) r37.get("data_room_unique_id", "");
    L108:
        l6 r39 = tc0.c.i(r38).O;
        if (r39 == null) goto L111;
        String r40 = r39.getRtcExtInfo();
    L112:
        r36.c(r40);
        goto L113
    L111:
        r40 = null;
        goto L112
    L107:
        r38 = null;
    L113:
        hg6.g r41 = R1();
        if (r41 == null) goto L125;
        DataCenter r42 = ((Widget) this).dataCenter;
        if (r42 == null) goto L118;
        String r43 = (String) r42.get("data_room_unique_id", "");
    L119:
        l6 r44 = tc0.c.i(r43).O;
        if (r44 == null) goto L122;
        String r45 = r44.getLiveCoreExtInfo();
    L123:
        r41.J(r45);
        goto L125
    L122:
        r45 = null;
        goto L123
    L118:
        r43 = null;
    L125:
        if (vm2.f.a() == false) goto L129;
        com.bytedance.android.live.pushstream.d r46 = this.u.getLiveStream();
        if (r46 == null) goto L134;
        r46.I();
        goto L134
    L129:
        hg6.g r47 = R1();
        if (r47 == null) goto L134;
        pf6.a r48 = r47.f0();
        if (r48 == null) goto L134;
        r48.M();
        goto L134
    L92:
        r32 = InteractMode.VIDEO_TALK;
    L68:
        r25 = null;
        goto L69
    L62:
        r22 = null;
        goto L63
    L44:
        if (r17.b == true) goto L58;
        DataCenter r49 = ((Widget) this).dataCenter;
        if (r49 == null) goto L48;
        String r50 = (String) r49.get("data_room_unique_id", "");
    L49:
        l6 r51 = tc0.c.i(r50).O;
        if (r51 == null) goto L54;
        List r52 = r51.getMLinkUsers();
        if (r52 == null) goto L54;
        int r53 = r52.size();
    L55:
        if (r53 > 1) goto L58;
        r19 = false;
    L54:
        r53 = 0;
        goto L55
    L48:
        r50 = null;
    L58:
        r19 = true;
    L134:
        hd0.c.f().k(2);
        String r54 = getMRoom().getOwnerUserIdString();
        if (r2 == null) goto L152;
        List r3 = r2.getMLinkUsers();
        if (r3 == null) goto L152;
        Iterator r55 = r3.iterator();
    L140:
        if (r55.hasNext() == false) goto L148;
        Object r56 = r55.next();
        IBaseUser r57 = ((com.bytedance.android.livesdk.link.model.bridge.k) r56).getUser();
        if (r57 == null) goto L144;
        String r58 = r57.getIdString();
    L146:
        if (Intrinsics.areEqual(r58, r54) == false) goto L140;
    L149:
        com.bytedance.android.livesdk.link.model.bridge.k r59 = (com.bytedance.android.livesdk.link.model.bridge.k) r56;
        if (r59 == null) goto L152;
        int r60 = r59.getSilenceStatus();
    L153:
        if (r60 == 0) goto L157;
        rj0.k.m2.getClass();
        rj0.k r61 = rj0.k.a.a();
        if (r61 == null) goto L164;
        r61.Q5(r54, true, null);
    L164:
        us1.e.c = false;
        DataCenter r62 = ((Widget) this).dataCenter;
        if (r62 == null) goto L167;
        String r63 = (String) r62.get("data_room_unique_id", "");
    L168:
        l6 r65 = tc0.c.i(r63).O;
        if (r65 == null) goto L173;
        List r66 = r65.getMLinkUsers();
        if (r66 == null) goto L173;
        int r67 = r66.size();
    L174:
        if (r67 > 1) goto L176;
        v0(0, "audience_linkmic", -1, null);
    L176:
        Tq(8, 7, "recoveryDynamicVideoTalkAfterFinishPK", null);
        xf6.a r68 = Gq();
        if (r68 == null) goto L179;
        r68.e(null);
    L179:
        xf6.a r69 = Gq();
        if (r69 == null) goto L189;
        r69.c();
        return;
    L189:
        return;
    L173:
        r67 = 0;
        goto L174
    L167:
        r63 = null;
        goto L168
    L157:
        jg6.a r70 = Bq();
        if (r70 == null) goto L164;
        kg6.e r71 = r70.b();
        if (r71 == null) goto L164;
        if (r71.q() != true) goto L164;
        er(true, "back_from_pk");
        goto L164
    L144:
        r58 = null;
        goto L146
    L148:
        r56 = null;
    L152:
        r60 = -1;
        goto L153
    L13:
        r7 = null;
        goto L14
    L9:
        r5 = null;
        goto L10
    L5:
        r1 = null;
        goto L6
    }

    @Override // rj0.k
    public final String currentCPositionUserType() {
        CPositionContext.a r0 = CPositionContext.Companion;
        if (r0.d() != EnlargeGuestInfo.EnlargeGuestType.EnlargeGuestType_Double.ordinal()) goto L6;
        return "double";
    L6:
        com.bytedance.android.livesdk.chatroom.viewmodel.j r1 = Qq();
        String r4 = null;
        if (r1 != null) goto L9;
    L37:
        com.bytedance.android.livesdk.chatroom.viewmodel.j r2 = Qq();
        if (r2 == null) goto L40;
        List r3 = r2.b;
    L42:
        if (com.bytedance.android.livesdk.chatroom.interact.model.d0.c(r3) == false) goto L63;
        com.bytedance.android.live.liveinteract.plantform.core.y r5 = yq();
        if (r5 == null) goto L60;
        CopyOnWriteArrayList<ILinkPlayerInfoBridge> r6 = r5.c;
        if (r6 == null) goto L60;
        Iterator<T> r7 = r6.iterator();
    L49:
        if (r7.hasNext() == false) goto L53;
        Object r8 = r7.next();
        if (((ILinkPlayerInfoBridge) r8).isEnlarged() == false) goto L49;
    L54:
        ILinkPlayerInfoBridge r9 = (ILinkPlayerInfoBridge) r8;
        if (r9 == null) goto L60;
        IBaseUser r10 = r9.getUser();
        if (r10 == null) goto L60;
        r4 = r10.getIdString();
        goto L60
    L53:
        r8 = null;
    L60:
        if (Intrinsics.areEqual(r4, getMRoom().getOwnerUserIdString()) == false) goto L72;
        return "anchor";
    L72:
        return "guest";
    L63:
        return "normal";
    L40:
        r3 = null;
        goto L42
    L9:
        if (r1.c != 7) goto L37;
        CPositionContext r11 = r0.getContext();
        if (r11 == null) goto L37;
        com.bytedance.live.datacontext.m<Boolean> r12 = r11.isCPositionOpen();
        if (r12 == null) goto L37;
        if (((Boolean) r12.getValue()).booleanValue() != true) goto L37;
        com.bytedance.android.live.liveinteract.plantform.core.y r13 = yq();
        if (r13 == null) goto L33;
        CopyOnWriteArrayList<ILinkPlayerInfoBridge> r14 = r13.c;
        if (r14 == null) goto L33;
        Iterator<T> r15 = r14.iterator();
    L22:
        if (r15.hasNext() == false) goto L26;
        Object r16 = r15.next();
        if (((ILinkPlayerInfoBridge) r16).isEnlarged() == false) goto L22;
    L27:
        ILinkPlayerInfoBridge r17 = (ILinkPlayerInfoBridge) r16;
        if (r17 == null) goto L33;
        IBaseUser r18 = r17.getUser();
        if (r18 == null) goto L33;
        r4 = r18.getIdString();
        goto L33
    L26:
        r16 = null;
    L33:
        if (Intrinsics.areEqual(r4, getMRoom().getOwnerUserIdString()) == false) goto L36;
        return "anchor";
    L36:
        return "guest";
    }

    @Override // tf0.o.a
    public final int dn() {
        com.bytedance.android.live.liveinteract.plantform.utils.u r0 = this.H1;
        if (r0 == null) goto L8;
        Integer r1 = r0.d();
        if (r1 == null) goto L8;
        return r1.intValue();
    L8:
        return PublicStreamClientMixStrategy.None.ordinal();
    }

    @Override // rj0.k
    public final List<ILinkPlayerInfoBridge> getCrossRoomFightLinkUserInfoList() {
        tf0.o r0 = this.E;
        ArrayList r2 = null;
        if ((r0 instanceof MultiLinkLinkRoomFightWindowManager) == true) goto L5;
        r0 = null;
    L5:
        MultiLinkLinkRoomFightWindowManager r1 = (MultiLinkLinkRoomFightWindowManager) r0;
        if (r1 == null) goto L15;
        eh0.b r3 = r1.X;
        if (r3 == null) goto L15;
        List<ch0.e> r4 = r3.d();
        if (r4 == null) goto L15;
        List<ch0.e> r5 = r4;
        r2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r5, 10));
        Iterator<T> r6 = r5.iterator();
    L13:
        if (r6.hasNext() == false) goto L15;
        r2.add(((ch0.e) r6.next()).a);
    L15:
        return r2;
    }

    @Override // rj0.k
    public final JsonObject getLinkmicAreaFrameInfo() {
        tf0.o r0 = this.E;
        if (r0 == null) goto L8;
        sf0.b r1 = r0.getLinkmicAreaFrameInfo();
        if (r1 == null) goto L10;
        int r2 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.g.a;
        return com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.g.f(r1);
    L10:
        return null;
    L8:
        return null;
    }

    @Override // rj0.k
    public final JsonObject getLinkmicSeatListInfo() {
        List<tf0.e> r1 = null;
        if (this.E != null) goto L5;
        return null;
    L5:
        String r3 = "seat";
        nh0.e r4 = null;
        tf0.o r2 = this.E;
        if (r2 == null) goto L9;
        r1 = r2.e();
    L9:
        return new nh0.f(r3, r4, r1, null, null, null, false, 246).b();
    }

    @Override // tf0.o.a
    public final uf2.d0 getLiveCore() {
        return this.v.A();
    }

    @Override // zj0.e.b
    public final void h5() {
        View r0 = ((Widget) this).contentView;
        View r1 = null;
        if (r0 == null) goto L5;
        View r2 = r0.findViewById(2131365109);
    L7:
        if (r2 == null) goto L9;
        r2.setVisibility(8);
    L9:
        View r3 = ((Widget) this).contentView;
        if (r3 == null) goto L12;
        View r4 = r3.findViewById(2131365110);
    L13:
        if (r4 == null) goto L15;
        r4.setVisibility(8);
    L15:
        View r5 = ((Widget) this).contentView;
        if (r5 == null) goto L18;
        View r6 = r5.findViewById(2131380906);
    L19:
        if (r6 == null) goto L21;
        r6.setVisibility(8);
    L21:
        View r7 = ((Widget) this).contentView;
        if (r7 == null) goto L24;
        View r8 = r7.findViewById(2131363980);
    L25:
        if (r8 == null) goto L27;
        r8.setVisibility(8);
    L27:
        View r9 = ((Widget) this).contentView;
        if (r9 == null) goto L30;
        r1 = r9.findViewById(2131370474);
    L30:
        if (r1 == null) goto L33;
        r1.setVisibility(8);
        return;
    L33:
        return;
    L24:
        r8 = null;
        goto L25
    L18:
        r6 = null;
        goto L19
    L12:
        r4 = null;
        goto L13
    L5:
        r2 = null;
        goto L7
    }

    @Override // rj0.e
    public final boolean isLinkCasting() {
        LinkCastAnchorWidget r0 = this.Q;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.e;
    }

    @Override // rj0.e
    public final boolean isSupportLinkCastMiniApp() {
        LinkCastAnchorWidget r0 = this.Q;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.isSupportLinkCastMiniApp();
    }

    @Override // tf0.o.a
    public final int mc() {
        com.bytedance.android.live.liveinteract.plantform.utils.u r0 = this.H1;
        if (r0 == null) goto L8;
        Integer r1 = r0.e();
        if (r1 == null) goto L8;
        return r1.intValue();
    L8:
        return PublicStreamPlayState.None.ordinal();
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.videolink.MultiLinkVideoBaseAnchorLinkWidget, com.bytedance.android.live.liveinteract.plantform.widgt.MultiLinkBaseAnchorLinkWidget, com.bytedance.android.live.liveinteract.linkpanel.widget.PlatformMultiLinkWidget, com.bytedance.android.live.liveinteract.linkbase.api.BaseMultiLinkWidget
    public final void onCreate() {
        multiLinkRoomScopeFallback();
        super.onCreate();
        ALogger.i("[VideoTalk]VideoTalkRoomAnchorWidget", "MultiLinkVideoTalkRoomAnchorWidget#onCreate");
        int r1 = 6;
        int r10 = 0;
        Widget r11 = null;
        if (MultiLinkLoadWidgetUtils.g() == false) goto L13;
        int r0 = com.bytedance.android.live.liveinteract.plantform.multiroom.e.a;
        com.bytedance.android.live.liveinteract.plantform.commonwindow.l r2 = com.bytedance.android.live.liveinteract.plantform.multiroom.e.d(((Widget) this).dataCenter);
        if (r2 == null) goto L7;
        BaseLinkSeatWindowView r3 = r2.getLinkSeatWindowView();
    L8:
        if (r3 == null) goto L13;
        com.bytedance.android.live.liveinteract.plantform.commonwindow.l r4 = com.bytedance.android.live.liveinteract.plantform.multiroom.e.d(((Widget) this).dataCenter);
        if (r4 == null) goto L12;
        ConstraintLayout r5 = r4.getLinkSeatWindowView();
    L14:
        ALogger.i("[VideoTalk]VideoTalkRoomAnchorWidget", "updateWindowViewParent windowView=" + r5 + ", containerView=" + ((Widget) this).containerView);
        if (r5 == null) goto L34;
        ViewParent r6 = r5.getParent();
        if ((r6 instanceof ViewGroup) == true) goto L20;
        r6 = null;
    L20:
        ViewGroup r7 = (ViewGroup) r6;
        if (r7 == null) goto L23;
        r7.removeView(r5);
    L23:
        ViewGroup r8 = (ViewGroup) ((Widget) this).containerView.findViewById(2131378012);
        r8.removeAllViews();
        FrameLayout.LayoutParams r9 = new FrameLayout.LayoutParams(-1, -1);
        r9.gravity = 49;
        r8.addView(r5, r9);
        if (MultiLinkLoadWidgetUtils.g() == true) goto L34;
        ViewGroup r12 = (ViewGroup) ((Widget) this).containerView.findViewById(2131370474);
        if (r12 == null) goto L28;
        ViewGroup r13 = (ViewGroup) r12.findViewById(2131378012);
    L29:
        ConstraintLayout r14 = new CommonLinkSeatWindowView(((Widget) this).context, r11, r1, r10);
        r14.setId(2131378011);
        if (r13 == null) goto L34;
        if (r13.getChildCount() != 0) goto L34;
        r13.addView(r14);
        goto L34
    L28:
        r13 = null;
    L34:
        this.x1.c();
        sh0.i0 r15 = sh0.j0.a;
        this.w = sh0.j0.c(((Widget) this).dataCenter, this);
        if (vm2.d.q0().isUserInfoCenterForwardInit() == false) goto L42;
        CopyOnWriteArrayList<ILinkPlayerInfoBridge> r16 = yq().c;
        if (r16 == null) goto L39;
        this.Y.clear();
        this.Y.addAll(r16);
    L39:
        CopyOnWriteArrayList<ILinkPlayerInfoBridge> r17 = yq().d;
        if (r17 == null) goto L42;
        this.Z.clear();
        this.Z.addAll(r17);
    L42:
        this.o.setScene(8);
        ConstraintLayout r18 = ((Widget) this).contentView.findViewById(2131363980);
        if (r18 == null) goto L419;
        ConstraintLayout r19 = r18;
        Context r20 = ((Widget) this).context;
        DataCenter r21 = ((Widget) this).dataCenter;
        IRoom r22 = getMRoom();
        eh0.b r23 = this.e;
        if (r23 != null) goto L47;
        Intrinsics.throwUninitializedPropertyAccessException("linkRoomFightDataMergeCenter");
    L47:
        com.bytedance.android.live.liveinteract.plantform.utils.u r110 = new com.bytedance.android.live.liveinteract.plantform.utils.u(r20, r21, r19, r22, this, r23, this);
        this.H1 = r110;
        r110.j();
        Pair r24 = com.bytedance.live.datacontext.d.a(MultiLinkVideoTalkRoomAnchorWidget$initAdminInviteAndApplyViewModel$1.INSTANCE);
        AdminInviteAndApplyViewModel r25 = (AdminInviteAndApplyViewModel) r24.component1();
        Disposable r26 = (Disposable) r24.component2();
        com.bytedance.live.datacontext.b.a(r25, AdminInviteAndApplyViewModel.TAG);
        this.m.add(r26);
        Pair r27 = com.bytedance.live.datacontext.d.a(MultiLinkVideoTalkRoomAnchorWidget$onCreate$pair$1.INSTANCE);
        ((VideoTalkAnchorContext) r27.getFirst()).getService().d(this);
        com.bytedance.live.datacontext.b.a((DataContext) r27.getFirst(), "anchor_video_talk");
        this.F = (Disposable) r27.getSecond();
        this.M = new InteractAnimationController(((Widget) this).dataCenter);
        Pair r28 = com.bytedance.live.datacontext.d.a(MultiLinkVideoTalkRoomAnchorWidget$onCreate$animationContext$1.INSTANCE);
        ((InteractAnimationContext) r28.getFirst()).getController().d(this.M);
        com.bytedance.live.datacontext.b.a((DataContext) r28.getFirst(), InteractAnimationContext.class);
        DataCenter r29 = ((Widget) this).dataCenter;
        ViewGroup r30 = ((Widget) this).containerView;
        com.bytedance.android.livesdk.chatroom.u r31 = com.bytedance.android.live.liveinteract.api.utils.m.e(this);
        InteractAnimationController r32 = this.M;
        Intrinsics.checkNotNull(r32);
        zj0.e r33 = new zj0.e(r29, r30, r31, this, r32);
        this.V0 = r33;
        zj0.d.b r34 = new zj0.d.b(0, 0, 0, 0, 0, 31);
        MultiLinkVideoTalkRoomAnchorWidget$registerWindowMangers$1 r35 = new MultiLinkVideoTalkRoomAnchorWidget$registerWindowMangers$1(this);
        Intrinsics.checkNotNullParameter(r34, "layoutConfig");
        Intrinsics.checkNotNullParameter(r35, "provider");
        r33.a.add(r34);
        r33.b.put(r34.f, r35);
        jg6.a r36 = zq().e5();
        if (r36 == null) goto L52;
        lh6.b r37 = r36.a();
        if (r37 == null) goto L52;
        r37.p(this, "anchor widget create");
    L52:
        SwitchCameraManager r38 = new SwitchCameraManager(((Widget) this).context, ((Widget) this).dataCenter, yq(), this);
        this.O = r38;
        r38.k();
        if (w0.b() == true) goto L57;
        MultiRevenueDataContext.Companion.getClass();
        com.bytedance.android.live.liveinteract.chatroom.chatroom.playmode.a r39 = MultiRevenueDataContext.a.d();
        if (r39 == null) goto L57;
        r39.o(((Widget) this).dataCenter, this, SceneType.SCENE_VIDEO_TALKROOM, (ViewGroup) ((Widget) this).contentView.findViewById(2131388184));
    L57:
        MultiRevenueDataContext.Companion.getClass();
        com.bytedance.android.live.liveinteract.chatroom.chatroom.playmode.a r40 = MultiRevenueDataContext.a.d();
        if (r40 == null) goto L60;
        r40.d(((Widget) this).dataCenter);
    L60:
        com.bytedance.android.live.liveinteract.chatroom.chatroom.playmode.a r41 = MultiRevenueDataContext.a.d();
        if (r41 == null) goto L63;
        r41.p(this, SceneType.SCENE_VIDEO_TALKROOM, this.w, false);
    L63:
        ReadOnlyProperty r42 = vm2.d.z8;
        KProperty[] r43 = vm2.d.a;
        if (((Boolean) r42.getValue(null, r43[490(0x1ea, float:6.87E-43)])).booleanValue() == false) goto L73;
        View r44 = ((Widget) this).contentView;
        if (r44 == null) goto L82;
        HSImageView r45 = r44.findViewById(2131384400);
        if (r45 == null) goto L82;
        of0.b r46 = InteractiveSongContext.Companion.c();
        if (r46 == null) goto L82;
        r46.e7(r45);
    L82:
        InteractiveSongContext r47 = InteractiveSongContext.Companion.getContext();
        if (r47 == null) goto L92;
        com.bytedance.live.datacontext.m<String> r48 = r47.getSingingGuestId();
        if (r48 == null) goto L92;
        Observable r49 = r48.a();
        if (r49 == null) goto L92;
        Disposable r50 = r49.subscribe(new com.bytedance.android.live.liveinteract.videotalk.g(this));
        if (r50 == null) goto L92;
        RxUtilKt.c(r50, this.m);
    L92:
        if (this.P != null) goto L95;
        enableSubWidgetManager();
        QuickInteractWidget r51 = new QuickInteractWidget();
        this.P = r51;
        ((Widget) this).subWidgetManager.load(r51);
    L95:
        if (this.Q != null) goto L97;
        enableSubWidgetManager();
        hg6.g r52 = R1();
        Intrinsics.checkNotNull(r52);
        LinkCastAnchorWidget r53 = new LinkCastAnchorWidget(r52, getMRoom());
        this.Q = r53;
        ((Widget) this).subWidgetManager.load(r53);
    L97:
        Rq();
        com.bytedance.live.datacontext.j r54 = com.bytedance.android.live.liveinteract.api.utils.m.e(this).getVideoTalkRoomSubScene();
        if (r54 == null) goto L106;
        com.bytedance.android.livesdk.chatroom.viewmodel.e r55 = (com.bytedance.android.livesdk.chatroom.viewmodel.e) r54.getValue();
        if (r55 == null) goto L106;
        BehaviorSubject r56 = r55.a();
        if (r56 == null) goto L106;
        Disposable r57 = r56.subscribe(new i(this));
        if (r57 == null) goto L106;
        RxUtilKt.c(r57, this.m);
    L106:
        com.bytedance.live.datacontext.m r58 = jc1.k.n(IKtvService.class).getCurrentIsMultipleKtvModeObservable();
        if (r58 == null) goto L113;
        Observable r59 = r58.a();
        if (r59 == null) goto L113;
        final AnonymousClass4 r60 = new AnonymousClass4(this);
        Disposable r61 = r59.subscribe(new p(r60));
        if (r61 == null) goto L113;
        this.m.add(r61);
    L113:
        com.bytedance.live.datacontext.j r62 = com.bytedance.android.live.liveinteract.api.utils.m.e(this).getVideoTalkRoomSubScene();
        if (r62 == null) goto L131;
        com.bytedance.android.livesdk.chatroom.viewmodel.e r63 = (com.bytedance.android.livesdk.chatroom.viewmodel.e) r62.getValue();
        if (r63 == null) goto L131;
        com.bytedance.android.livesdk.chatroom.viewmodel.j r65 = r63.t();
        if (r65 == null) goto L131;
        zj0.e r66 = this.V0;
        if (r66 != null) goto L122;
        Intrinsics.throwUninitializedPropertyAccessException("layoutSwitcher");
    L122:
        r66.f(new zj0.c.b(r65.a, r65.c), r65.b, r65.e);
        int r67 = r65.a;
        if (r67 != 12) goto L125;
        this.o.setScene(12);
        this.r = 12;
    L127:
        com.bytedance.live.bizlink.impl.platform.manager.a r68 = zq().A0();
        if (r68 == null) goto L130;
        r68.g();
    L130:
        TalkRoomLogUtils.H(TalkRoomLogUtils.p(Integer.valueOf(r65.a), Integer.valueOf(r65.c), null), u0.j(Integer.valueOf(r65.c)), false, null, 20);
        goto L131
    L125:
        if (r67 != 8) goto L127;
        this.r = 8;
    L131:
        yj0.a r69 = new yj0.a(getMRoom(), true, ((Widget) this).dataCenter);
        this.H = r69;
        r69.c0(this);
        com.bytedance.live.datacontext.j r70 = com.bytedance.android.live.liveinteract.api.utils.m.e(this).getVideoTalkRoomSubScene();
        if (r70 == null) goto L151;
        com.bytedance.android.livesdk.chatroom.viewmodel.e r71 = (com.bytedance.android.livesdk.chatroom.viewmodel.e) r70.getValue();
        if (r71 == null) goto L151;
        if (r71.t() == null) goto L151;
        com.bytedance.android.livesdk.log.filter.o r72 = com.bytedance.android.livesdk.log.j0.l().c(am2.x.class);
        if (this.P0 == true) goto L140;
    L142:
        DataCenter r73 = ((Widget) this).dataCenter;
        Boolean r111 = Boolean.FALSE;
        if (Intrinsics.areEqual((Boolean) r73.get("pk_invite_fail_load_video_talk_widget", r111), r111) == false) goto L151;
        if (getUILayout() == 63) goto L151;
        if (((IInteractService) jc1.k.n(IInteractService.class)).dynamicFromAudience() == false) goto L149;
        f2.b(2131919223, 0);
        goto L151
    L149:
        f2.b(2131919222, 0);
        goto L151
    L140:
        if (Intrinsics.areEqual("convenient_page_ktv", (String) r72.getMap().get("enter_method")) == false) goto L142;
        this.P0 = false;
    L151:
        if (this.R != null) goto L153;
        enableSubWidgetManager();
        CPositionWidget r74 = new CPositionWidget();
        this.R = r74;
        ((Widget) this).subWidgetManager.load(r74);
    L153:
        yq().Q4(this.M1);
        this.S.g();
        this.C = System.currentTimeMillis();
        ((Widget) this).dataCenter.observe("cmd_video_talk_invite", this);
        ((Widget) this).dataCenter.observe("cmd_video_talk_guest_battle_open_panel", this);
        ((Widget) this).dataCenter.observe("cmd_open_paid_link_setting_panel_after_fetch_audience_setting", this);
        ((Widget) this).dataCenter.observe("cmd_video_talkroom_sensitive_permission_release", this);
        com.bytedance.android.live.core.utils.rxutils.j.a r75 = com.bytedance.android.live.core.utils.rxutils.j.a;
        this.G = com.bytedance.android.live.core.utils.rxutils.j.a(1, 1, TimeUnit.MINUTES).subscribe(new j(this));
        if (com.bytedance.android.live.liveinteract.api.utils.m.e(this) == null) goto L158;
        Disposable r76 = IKtvService.b.b(jc1.k.n(IKtvService.class), this, new k(this), 2);
        if (r76 == null) goto L158;
        RxUtilKt.c(r76, this.m);
    L158:
        IKtvService r77 = jc1.k.f(IKtvService.class);
        if (r77 == null) goto L166;
        com.bytedance.live.datacontext.k r78 = r77.ktvComponentSingerChangedEvent();
        if (r78 == null) goto L166;
        Disposable r79 = r78.onEvent().subscribe(new f(this));
        if (r79 == null) goto L166;
        RxUtilKt.c(r79, this.m);
    L166:
        if (vm2.d.w() == true) goto L169;
    L171:
        DataCenter r80 = ((Widget) this).dataCenter;
        if (r80 == null) goto L176;
        Boolean r81 = (Boolean) r80.get("data_need_restore_video_interact", Boolean.FALSE);
        if (r81 == null) goto L176;
        boolean r82 = r81.booleanValue();
    L178:
        if (r82 == true) goto L180;
    L182:
        enableSubWidgetManager();
        if (((Boolean) vm2.d.Y.getValue(null, r43[48])).booleanValue() == true) goto L185;
    L187:
        DigitAvatarContext r83 = DigitAvatarContext.Companion.getContext();
        if (r83 == null) goto L196;
        com.bytedance.live.datacontext.m<Boolean> r84 = r83.getUsedAvatarThisLinkRound();
        if (r84 == null) goto L196;
        Observable r85 = r84.a();
        if (r85 == null) goto L196;
        ObservableSubscribeProxy r86 = (ObservableSubscribeProxy) r85.as(AutoDispose.bind(this));
        if (r86 == null) goto L196;
        r86.subscribe(new com.bytedance.android.live.liveinteract.videotalk.e(this), com.bytedance.android.live.liveinteract.videotalk.f.a);
    L196:
        g3 r87 = y3.f(((Widget) this).dataCenter);
        if (this.k1 != null) goto L199;
        this.k1 = new com.bytedance.android.live.liveinteract.voicechat.toolbar.f(((Widget) this).context, this);
    L199:
        com.bytedance.android.live.liveinteract.voicechat.toolbar.f r88 = this.k1;
        if (r88 == null) goto L202;
        r87.k(ToolbarButton.VOICE_LIVE_THEME, r88);
    L202:
        IInteractService r89 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r89 == null) goto L207;
        x00.a r90 = r89.getThemeManager(true, ((Widget) this).dataCenter);
        if (r90 == null) goto L207;
        r90.g(3, null);
    L207:
        IInteractService r91 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r91 == null) goto L210;
        x00.a r92 = r91.getThemeManager(true, ((Widget) this).dataCenter);
    L212:
        if (getMRoom().getLinkMap() == null) goto L224;
        if (getMRoom().getLinkMap().isEmpty() == true) goto L224;
        if (getMRoom().getLinkMap() != null) goto L218;
    L240:
        com.bytedance.android.livesdk.chatroom.u r93 = com.bytedance.android.live.liveinteract.api.utils.m.e(this);
        com.bytedance.live.datacontext.m r94 = r93.c();
        if (r94 != null) goto L243;
    L288:
        DataCenter r95 = ((Widget) this).dataCenter;
        Boolean r96 = Boolean.FALSE;
        Boolean r97 = (Boolean) r95.get("pk_invite_fail_load_video_talk_widget", r96);
        Boolean r112 = Boolean.TRUE;
        if (Intrinsics.areEqual(r97, r112) == false) goto L291;
        ((Widget) this).dataCenter.put("pk_invite_fail_load_video_talk_widget", r96);
    L291:
        com.bytedance.live.datacontext.n r98 = r93.a();
        if (r98 == null) goto L302;
        ArrayList r99 = (ArrayList) r98.getValue();
        if (r99 == null) goto L302;
        if (r99.contains(22) != true) goto L302;
        com.bytedance.live.datacontext.n r100 = r93.a();
        if (r100 == null) goto L302;
        ArrayList r101 = (ArrayList) r100.getValue();
        if (r101 == null) goto L302;
        r101.remove(22);
    L302:
        com.bytedance.live.datacontext.m r102 = r93.u();
        if (r102 != null) goto L305;
    L330:
        com.bytedance.android.live.liveinteract.plantform.core.y r103 = yq();
        if (r103 == null) goto L333;
        this.X = new com.bytedance.android.live.liveinteract.videotalk.utils.a(r103, true, ((Widget) this).dataCenter);
    L333:
        com.bytedance.android.livesdk.chatroom.t r104 = com.bytedance.android.live.liveinteract.api.utils.m.b();
        if (r104 == null) goto L338;
        com.bytedance.live.datacontext.j r105 = r104.getMessageManager();
        if (r105 == null) goto L338;
        r105.c(new AnonymousClass13(this));
    L338:
        cr(n90.e.class);
        cr(h1.class);
        cr(o42.g.class);
        cr(o42.l.class);
        com.bytedance.android.live.liveinteract.linksecurity.b r106 = com.bytedance.android.live.liveinteract.linksecurity.b.g;
        r106.j();
        r106.k(((Widget) this).dataCenter);
        com.bytedance.live.datacontext.m r107 = jc1.k.n(IKtvService.class).getKtvComponentStatusChangedObservable();
        if (r107 == null) goto L346;
        Observable r108 = r107.a();
        if (r108 == null) goto L346;
        Disposable r109 = r108.subscribe(new com.bytedance.android.live.liveinteract.videotalk.i(this));
        if (r109 == null) goto L346;
        RxUtilKt.c(r109, this.m);
    L346:
        if (vm2.d.k0() == false) goto L350;
        IKtvService r113 = jc1.k.f(IKtvService.class);
        if (r113 == null) goto L350;
        IKtvService.b.b(r113, this, new com.bytedance.android.live.liveinteract.videotalk.j(this), 2);
    L350:
        IGameDataService r114 = com.bytedance.android.live.liveinteract.api.utils.m.a();
        if (r114 == null) goto L359;
        com.bytedance.live.datacontext.m r115 = r114.getXplayRunning();
        if (r115 == null) goto L359;
        Observable r116 = r115.a();
        if (r116 == null) goto L359;
        Disposable r117 = r116.subscribe(new com.bytedance.android.live.liveinteract.videotalk.k(this));
        if (r117 == null) goto L359;
        RxUtilKt.c(r117, this.m);
    L359:
        DataCenter r118 = ((Widget) this).dataCenter;
        if (r118 == null) goto L362;
        String r119 = (String) r118.get("data_room_unique_id", "");
    L364:
        if (tc0.c.i(r119).O == null) goto L366;
        ar();
    L366:
        SpatialAudioStrategyManager.c.a();
        SpatialAudioContext r120 = SpatialAudioContext.Companion.getContext();
        if (r120 == null) goto L376;
        com.bytedance.live.datacontext.m<Integer> r121 = r120.getCurrentStrategyId();
        if (r121 == null) goto L376;
        Observable r122 = r121.a();
        if (r122 == null) goto L376;
        Disposable r123 = r122.subscribe(new h(this));
        if (r123 == null) goto L376;
        RxUtilKt.c(r123, this.m);
    L376:
        if (vm2.d.K0() == true) goto L378;
    L391:
        com.bytedance.android.live.liveinteract.chatroom.chatroom.playmode.a r124 = MultiRevenueDataContext.a.d();
        if (r124 == null) goto L394;
        MultiLinkUniversalAnimWidget r125 = r124.e(this, SceneType.SCENE_VIDEO_TALKROOM, (ViewGroup) ((Widget) this).contentView.findViewById(2131388184));
    L395:
        this.y1 = r125;
        if (KtvCommonSettingHelper.b() == true) goto L398;
        return;
    L398:
        if (this.V != null) goto L421;
        Integer r126 = je0.d.h();
        if (r126 != null) goto L403;
    L405:
        boolean r127 = false;
    L406:
        if (r127 == false) goto L422;
        enableSubWidgetManager();
        FrameLayout r128 = (FrameLayout) ((Widget) this).contentView.findViewById(2131392274);
        if (r128 == null) goto L410;
        r128.setVisibility(0);
    L410:
        IKtvService r129 = jc1.k.f(IKtvService.class);
        if (r129 == null) goto L413;
        r11 = r129.createVideoChorusWidget();
    L413:
        this.V = r11;
        dr(true);
        WidgetManager r130 = ((Widget) this).subWidgetManager;
        if (r130 == null) goto L416;
        r130.load(r128, this.V, false);
    L416:
        ALogger.i("[VideoTalk]VideoTalkRoomAnchorWidget", "[video_chorus] loadVideoChorusWidget complete");
        return;
    L422:
        return;
    L403:
        if (r126.intValue() != 63) goto L405;
        r127 = true;
        goto L406
    L421:
        return;
    L394:
        r125 = null;
        goto L395
    L378:
        if (vm2.d.h() == false) goto L391;
        GLSurfaceView r131 = (GLSurfaceView) ((Widget) this).containerView.findViewById(2131375528);
        if (r131 == null) goto L382;
        n50.a r132 = k50.e.a(r131);
    L383:
        if (r132 == null) goto L385;
        r132.b();
        goto L391
    L385:
        j50.a r133 = new j50.a();
        this.b2 = r133;
        r133.e = new j50.b(r131);
        UtilityKotlinExtentionsKt.w(r131);
        Context r134 = ((Widget) this).context;
        j50.a r135 = this.b2;
        Intrinsics.checkNotNull(r135);
        v50.a.b(r131, r134, r135);
        k50.c r136 = new k50.c(r131);
        this.g2 = r136;
        r136.a();
        j50.a r137 = this.b2;
        if (r137 == null) goto L388;
        k50.e.c(r131, r137);
    L388:
        k50.c r138 = this.g2;
        if (r138 == null) goto L391;
        k50.e.b(r131, r138);
        goto L391
    L382:
        r132 = null;
        goto L383
    L362:
        r119 = null;
        goto L364
    L305:
        if (((Number) r102.getValue()).intValue() != 10) goto L330;
        com.bytedance.android.live.revenue.platform.log.impl.filterimpl.a r139 = mz0.d.b(LogCommon.PAGE_SOURCE_LOG);
        if (jc1.k.n(IKtvService.class).isKtvComponentV2Enable() == false) goto L321;
        if (r139 == null) goto L315;
        Map r140 = r139.getMap();
        if (r140 == null) goto L315;
        String r141 = (String) r140.get("enter_method");
        if (r141 == null) goto L315;
        String r210 = r141;
    L316:
        IKtvService r142 = jc1.k.f(IKtvService.class);
        if (r142 == null) goto L319;
        fd2.x r143 = r142.createKtvCommand(1, r112, r210, null, r96, null, null);
    L320:
        jc1.k.n(IKtvService.class).sendKtvComponentV2Command(r143);
        goto L330
    L319:
        r143 = null;
    L315:
        r210 = "";
        goto L316
    L321:
        DataCenter r144 = com.bytedance.android.live.liveinteract.api.utils.m.j(this).getDataCenter();
        if (r144 == null) goto L330;
        if (r139 == null) goto L328;
        Map r145 = r139.getMap();
        if (r145 == null) goto L328;
        String r146 = (String) r145.get("enter_method");
    L329:
        r144.put("cmd_open_ktv_component_with_link_check", new Pair(r112, r146));
    L328:
        r146 = null;
        goto L329
    L243:
        if (((Number) r94.getValue()).intValue() != OpenPanelType.NONE.getValue()) goto L288;
        com.bytedance.live.datacontext.m r147 = r93.u();
        if (r147 != null) goto L247;
    L248:
        com.bytedance.live.datacontext.n r148 = r93.a();
        if (r148 == null) goto L251;
        ArrayList r149 = (ArrayList) r148.getValue();
    L252:
        if (r149 == null) goto L259;
        com.bytedance.live.datacontext.n r150 = r93.a();
        if (r150 == null) goto L288;
        ArrayList r151 = (ArrayList) r150.getValue();
        if (r151 == null) goto L288;
        if (r151.contains(22) == true) goto L288;
    L259:
        com.bytedance.live.datacontext.m r152 = r93.o();
        if (r152 == null) goto L264;
        if (((Boolean) r152.getValue()).booleanValue() == true) goto L288;
    L264:
        if (us1.e.c == true) goto L288;
        if (((Boolean) ((Widget) this).dataCenter.get("pk_invite_fail_load_video_talk_widget", Boolean.FALSE)).booleanValue() == true) goto L288;
        Integer r153 = (Integer) ((Widget) this).dataCenter.get("cmd_mic_room_anchor_status", 0);
        if (r153 != null) goto L271;
    L272:
        if (r153 == null) goto L288;
        if (r153.intValue() != 3) goto L288;
    L276:
        t61 r154 = com.bytedance.android.live.liveinteract.linkpanel.util.z.a();
        if (r154 != null) goto L279;
    L287:
        gr();
        goto L288
    L279:
        if (u61.a(r154) != true) goto L287;
        View r155 = ((Widget) this).contentView;
        if (r155 == null) goto L288;
        g r156 = new g(this);
        t61 r157 = com.bytedance.android.live.liveinteract.linkpanel.util.z.a();
        if (r157 == null) goto L285;
        long r158 = r157.f3();
    L286:
        r155.postDelayed(r156, r158);
        goto L288
    L285:
        r158 = 3000;
        goto L286
    L271:
        if (r153.intValue() == 0) goto L276;
    L251:
        r149 = null;
        goto L252
    L247:
        if (((Number) r147.getValue()).intValue() == 10) goto L288;
    L218:
        if (getMRoom().getLinkMap().containsKey(String.valueOf(8)) == true) goto L224;
        if (getMRoom().getLinkMap().containsKey(String.valueOf(12)) == true) goto L224;
        if (getMRoom().getLinkMap().containsKey(String.valueOf(16)) == false) goto L240;
    L224:
        if (IVoiceLiveThemeKt.isValid(getMRoom().getVoiceLiveTheme()) == false) goto L240;
        IVoiceLiveTheme r159 = getMRoom().getVoiceLiveTheme();
        if (r159 == null) goto L228;
        Integer r160 = Integer.valueOf(r159.getBgType());
    L229:
        if (r160 != null) goto L232;
    L234:
        if (r160 == null) goto L240;
        if (r160.intValue() != 4) goto L240;
    L238:
        if (r92 == null) goto L240;
        IVoiceLiveTheme r161 = getMRoom().getVoiceLiveTheme();
        Intrinsics.checkNotNull(r161);
        IVoiceLiveTheme r162 = getMRoom().getVoiceLiveTheme();
        Intrinsics.checkNotNull(r162);
        r92.c(r161, r162.getBgType());
        goto L240
    L232:
        if (r160.intValue() != 3) goto L234;
    L228:
        r160 = null;
        goto L229
    L210:
        r92 = null;
        goto L212
    L185:
        if (tb1.d.a == true) goto L187;
        ((Widget) this).subWidgetManager.load(new VideoDigitAvatarWidget());
        goto L187
    L180:
        if (vm2.d.S() == false) goto L182;
        HashMap r163 = new HashMap();
        r163.put("scene", 4);
        JSONArray r164 = new JSONArray();
        JSONObject r165 = new JSONObject();
        r165.put("key", 8);
        r165.put("value", 1);
        r164.put(r165);
        r163.put("incremental_update", r164);
        ((LinkApi) com.bytedance.android.live.network.c.b().e(LinkApi.class)).updateSetting(getMRoom().getId(), r163).compose(RxUtil.rxSchedulerHelper()).subscribe(new com.bytedance.android.livesdk.user.h());
        jy0.b.d("ttlive_link", "update setting when finish");
    L176:
        r82 = false;
        goto L178
    L169:
        if (this.H0 != null) goto L171;
        enableSubWidgetManager();
        ChatMatchWidget r166 = new ChatMatchWidget(true, this);
        this.H0 = r166;
        ((Widget) this).subWidgetManager.load(r166);
        goto L171
    L73:
        if (this.T != null) goto L82;
        enableSubWidgetManager();
        this.T = qf0.b.a();
        View r167 = ((Widget) this).contentView;
        if (r167 == null) goto L81;
        HSImageView r168 = r167.findViewById(2131384400);
        if (r168 == null) goto L81;
        InteractiveSongWidget r169 = this.T;
        if (r169 == null) goto L81;
        Intrinsics.checkNotNullParameter(r168, "view");
        r169.v = r168;
    L81:
        ((Widget) this).subWidgetManager.load(this.T);
        goto L82
    L419:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
    L12:
        r5 = null;
        goto L14
    L7:
        r3 = null;
    L13:
        r5 = new CommonLinkSeatWindowView(((Widget) this).context, r11, r1, r10);
        r5.setId(2131378011);
        goto L14
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.videolink.MultiLinkVideoBaseAnchorLinkWidget, com.bytedance.android.live.liveinteract.plantform.widgt.MultiLinkBaseAnchorLinkWidget, com.bytedance.android.live.liveinteract.linkpanel.widget.PlatformMultiLinkWidget, com.bytedance.android.live.liveinteract.linkbase.api.BaseMultiLinkWidget
    public final void onDestroy() {
        multiLinkRoomScopeFallback();
        this.x1.b();
        xf6.a r1 = Gq();
        if (r1 == null) goto L5;
        r1.f();
    L5:
        VideoEffectPerfHelper r2 = this.L1;
        if (r2 == null) goto L9;
        r2.d();
    L9:
        if (vm2.d.j0() == false) goto L20;
        WidgetManager r3 = ((Widget) this).subWidgetManager;
        if (r3 == null) goto L20;
        List r4 = r3.widgets;
        if (r4 == null) goto L20;
        Iterator r5 = r4.iterator();
    L16:
        if (r5.hasNext() == false) goto L20;
        Widget r6 = (Widget) r5.next();
        WidgetManager r7 = ((Widget) this).subWidgetManager;
        if (r7 == null) goto L16;
        r7.unload(r6);
    L20:
        super.onDestroy();
        if (((Boolean) vm2.d.g0.getValue(null, vm2.d.a[56])).booleanValue() == false) goto L23;
        this.v.R0(false, "unmute when video talk finish", new uv0.a(LiveRequestSourceRole.Business, "LiveStreamWrapper.setAudioMuteRaw", null));
        InteractLinkFullLinkMonitor.k0(true, "force_open_anchor_mic_when_video_talk_finish");
    L23:
        com.bytedance.android.livesdk.chatroom.utils.g0.a();
        com.bytedance.android.live.liveinteract.revenue.adventure.linkcore.a r8 = com.bytedance.android.live.liveinteract.revenue.adventure.linkcore.g.a;
        com.bytedance.android.live.liveinteract.revenue.adventure.linkcore.g.d("talkroom destroy");
        if (je0.d.U() == false) goto L37;
        m1.b.a.getClass();
        m1.b r9 = m1.b.a.a();
        if (r9 == null) goto L28;
        r9.g();
        r9.h();
    L28:
        com.bytedance.android.live.pushstream.d r10 = this.v;
        if (r10 == null) goto L37;
        uf2.d0 r11 = r10.A();
        if (r11 == null) goto L37;
        uf2.z r12 = r11.C();
        if (r12 == null) goto L37;
        uf2.z.a r13 = r12.K0();
        if (r13 == null) goto L37;
        r13.b();
    L37:
        com.bytedance.android.live.liveinteract.videotalk.utils.a r14 = this.X;
        if (r14 == null) goto L40;
        r14.c();
    L40:
        InteractAnimationController r15 = this.M;
        if (r15 == null) goto L43;
        r15.l();
    L43:
        WidgetManager r16 = ((Widget) this).subWidgetManager;
        if (r16 == null) goto L46;
        r16.unload(this.y1);
    L46:
        this.y1 = null;
        com.bytedance.android.livesdk.chatroom.t r17 = com.bytedance.android.live.liveinteract.api.utils.m.b();
        if (r17 == null) goto L53;
        com.bytedance.live.datacontext.j r18 = r17.getMessageManager();
        if (r18 == null) goto L53;
        vlc.d r19 = (vlc.d) r18.getValue();
        if (r19 == null) goto L53;
        r19.removeMessageListener(this);
    L53:
        this.Y.clear();
        this.k0.clear();
        cg6.a r20 = getScopeServiceOrNullInMultiLinkRoom(cg6.a.class);
        if (r20 == null) goto L60;
        jg6.a r21 = r20.e5();
        if (r21 == null) goto L60;
        lh6.b r22 = r21.a();
        if (r22 == null) goto L60;
        r22.p(null, "anchor widget end");
    L60:
        SwitchCameraManager r23 = this.O;
        if (r23 == null) goto L65;
        r23.a.dispose();
        vlc.d r24 = r23.b;
        if (r24 == null) goto L65;
        r24.removeMessageListener(r23);
    L65:
        tf0.o r25 = this.E;
        if (r25 == null) goto L68;
        r25.end();
    L68:
        ViewGroup r26 = ((Widget) this).containerView;
        if (r26 == null) goto L71;
        r26.removeAllViews();
    L71:
        TalkRoomLogUtils.J(null, 11);
        HashMap r27 = new HashMap();
        r27.put("live_type", "video_live");
        TalkRoomLogUtils.B0(r27, Integer.valueOf(Nq()), null, 4);
        TalkRoomLogUtils.V0(r27);
        TalkRoomLogUtils.Q0(r27);
        String r28 = "on";
        if (((Boolean) b6.h.getValue()).booleanValue() == false) goto L74;
        Object r29 = "on";
    L75:
        r27.put("is_camera_allow", r29);
        long r110 = 1000;
        long r30 = (System.currentTimeMillis() - this.C) / r110;
        r27.put("duration", String.valueOf(r30));
        int r31 = this.D;
        if (r31 == 0) goto L78;
        int r32 = r31 - 1;
    L79:
        r27.put("connect_pcu", String.valueOf(r32));
        TalkRoomBusinessFullLinkMonitor.a.getClass();
        TalkRoomBusinessFullLinkMonitor.s0(r30 * r110, r32);
        DataCenter r33 = ((Widget) this).dataCenter;
        Boolean r34 = Boolean.FALSE;
        if (((Boolean) r33.get("data_big_party_support_send_gift_to_linker", r34)).booleanValue() == false) goto L82;
        Object r35 = "on";
    L83:
        r27.put("gift_guest_switch_type", r35);
        r27.put("send_gift_scene", "video_audience_multi");
        String r36 = "null";
        r27.put("shoot_way", "null");
        TalkRoomLogUtils.a(r27, true);
        Sq();
        mz0.e r111 = mz0.d.b(LogCommon.PAGE_SOURCE_LOG);
        if ((r111 instanceof mz0.f) == true) goto L86;
        r111 = null;
    L86:
        mz0.f r112 = (mz0.f) r111;
        if ((r112 instanceof mz0.f) == true) goto L89;
    L91:
        String r113 = "1";
        if (this.P1 == false) goto L94;
        Object r114 = "1";
    L95:
        r27.put("is_avatar_used", r114);
        IRoom r115 = getMRoom();
        if (r115 == null) goto L103;
        ICircleInfo r116 = r115.getCircleInfo();
        if (r116 == null) goto L103;
        String r117 = r116.getCircleName();
        if (r117 == null) goto L103;
        r27.put("circle_name", r117);
    L103:
        if (this.z == true) goto L105;
        r36 = (String) ((Widget) this).dataCenter.get("data_room_shoot_way_exact", "null");
    L105:
        r27.put("shoot_way", r36);
        if (Mq().b != 2) goto L108;
        boolean r37 = true;
    L109:
        int r118 = Nq();
        if (r118 == 8) goto L120;
        if (r118 != 12) goto L123;
        r27.put("function_type", "party");
        if (r37 == false) goto L117;
        Object r38 = "on";
    L118:
        r27.put("seat_fit_status", r38);
        goto L123
    L117:
        r38 = "off";
    L123:
        TalkRoomLogUtils.b1(r27, Integer.valueOf(je0.d.f()));
        DataCenter r39 = ((Widget) this).dataCenter;
        if (r39 == null) goto L127;
        String r40 = (String) r39.get("data_room_video_talk_log_over_for_over_path", "");
        if (r40 == null) goto L127;
    L129:
        if (TextUtils.isEmpty(r40) == true) goto L131;
        r27.put("over_path", r40);
        ((Widget) this).dataCenter.put("data_room_video_talk_log_over_for_over_path", "");
    L132:
        r27.put("auction_mode_status", "off");
        DataCenter r41 = ((Widget) this).dataCenter;
        if (r41 == null) goto L139;
        String r42 = (String) r41.get("data_room_video_talk_log_over_for_over_path", "");
        if (r42 == null) goto L139;
        if (TextUtils.isEmpty(r42) == true) goto L139;
        r27.put("over_path", r42);
        ((Widget) this).dataCenter.put("data_room_video_talk_log_over_for_over_path", "");
    L139:
        Integer r43 = (Integer) ((Widget) this).dataCenter.get("data_ktv_mode_before_close", -1);
        if (r43 != null) goto L143;
    L144:
        int r44 = Pq();
        com.bytedance.live.datacontext.j r119 = com.bytedance.android.live.liveinteract.api.utils.m.e(this).J();
        if (r119 == null) goto L149;
        LivePlayModeLogContext r45 = (LivePlayModeLogContext) r119.getValue();
        if (r45 == null) goto L149;
        r45.removePlayMode(r44);
    L149:
        com.bytedance.live.datacontext.j r46 = com.bytedance.android.live.liveinteract.api.utils.m.e(this).J();
        if (r46 == null) goto L154;
        LivePlayModeLogContext r47 = (LivePlayModeLogContext) r46.getValue();
        if (r47 == null) goto L154;
        r47.addPlayMode(((Number) ((Widget) this).dataCenter.get("data_ktv_mode_before_close", -1)).intValue());
    L154:
        r27.put("play_mode", u0.b());
        com.bytedance.live.datacontext.j r48 = com.bytedance.android.live.liveinteract.api.utils.m.e(this).J();
        if (r48 == null) goto L159;
        LivePlayModeLogContext r49 = (LivePlayModeLogContext) r48.getValue();
        if (r49 == null) goto L159;
        r49.removePlayMode(((Number) ((Widget) this).dataCenter.get("data_ktv_mode_before_close", -1)).intValue());
    L159:
        if (r44 == (-1)) goto L165;
        com.bytedance.live.datacontext.j r50 = com.bytedance.android.live.liveinteract.api.utils.m.e(this).J();
        if (r50 == null) goto L165;
        LivePlayModeLogContext r51 = (LivePlayModeLogContext) r50.getValue();
        if (r51 == null) goto L165;
        r51.addPlayMode(r44);
    L165:
        ((Widget) this).dataCenter.put("data_ktv_mode_before_close", -1);
    L167:
        com.bytedance.android.live.liveinteract.api.data.a.h.getClass();
        if (com.bytedance.android.live.liveinteract.api.data.a.C0017a.k().c == true) goto L171;
        r28 = "off";
    L171:
        r27.put("rechargeable_mode_status", r28);
        if (((Boolean) com.bytedance.android.livesdk.sharedpref.c.s1.getValue()).booleanValue() == true) goto L175;
        r113 = "0";
    L175:
        r27.put("is_invite_only", r113);
        TalkRoomLogUtils.H0(r27);
        String r52 = (String) ((Widget) this).dataCenter.get("data_anchor_video_talk_room_init_source");
        if (r52 != null) goto L179;
        r52 = "";
    L179:
        if ("pre_apply".equals(r52) == false) goto L181;
        r27.put("is_from_audience", "0");
    L181:
        com.bytedance.android.live.liveinteract.plantform.utils.i0 r53 = TalkRoomLogUtils.a;
        String r54 = TalkRoomLogUtils.d;
        if (r54 == null) goto L185;
        r27.put("source", r54);
    L185:
        if (r2.a(TalkRoomLogUtils.n) == false) goto L187;
        r27.put("source", TalkRoomLogUtils.n);
        r27.put("game_id", TalkRoomLogUtils.o);
        r27.put("game_name", TalkRoomLogUtils.p);
        TalkRoomLogUtils.n1();
    L187:
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_anchor_audience_connection_over", r27, new Object[]{IRoom.class, am2.x.class});
        if (vm2.d.A() == false) goto L192;
        LayerEventDispatcher r55 = o70.c.a(Integer.valueOf(((Widget) this).dataCenter.hashCode()));
        if (r55 == null) goto L192;
        boolean r56 = false;
        r55.b(new zg1.e(false));
    L193:
        hg6.g r57 = R1();
        if (r57 == null) goto L196;
        r57.i(r56);
    L196:
        g3 r58 = y3.f(((Widget) this).dataCenter);
        com.bytedance.android.live.liveinteract.voicechat.toolbar.f r59 = this.k1;
        if (r59 == null) goto L199;
        r58.d(ToolbarButton.VOICE_LIVE_THEME, r59);
    L199:
        Disposable r60 = this.F;
        if (r60 != null) goto L202;
        Intrinsics.throwUninitializedPropertyAccessException("mDiposable");
    L202:
        r60.dispose();
        Disposable r61 = this.G;
        if (r61 != null) goto L205;
        Intrinsics.throwUninitializedPropertyAccessException("mLogDisposable");
    L205:
        r61.dispose();
        this.S.i();
        ILinkPanelService r62 = com.bytedance.android.live.liveinteract.component.b.a();
        if (r62 == null) goto L208;
        r62.close();
    L208:
        ((Widget) this).dataCenter.put("data_self_is_silenced", r34);
        ((Widget) this).dataCenter.removeObserver(this);
        ((Widget) this).dataCenter.put("cmd_video_talkroom_state_change", new l3(1));
        hd0.c.f().k(0);
        this.m.dispose();
        com.bytedance.live.datacontext.j r63 = com.bytedance.android.live.liveinteract.api.utils.m.e(this).getVideoTalkRoomSubScene();
        if (r63 == null) goto L213;
        com.bytedance.android.livesdk.chatroom.viewmodel.e r65 = (com.bytedance.android.livesdk.chatroom.viewmodel.e) r63.getValue();
        if (r65 == null) goto L213;
        r65.reset();
    L213:
        com.bytedance.live.datacontext.n r66 = com.bytedance.android.live.liveinteract.api.utils.m.e(this).l();
        if (r66 == null) goto L216;
        r66.setValue(null);
    L216:
        yj0.a r67 = this.H;
        if (r67 == null) goto L219;
        r67.detachView();
    L219:
        zj0.e r68 = this.V0;
        if (r68 != null) goto L222;
        Intrinsics.throwUninitializedPropertyAccessException("layoutSwitcher");
    L222:
        r68.c.clear();
        com.bytedance.android.live.liveinteract.linksecurity.b.g.l();
        com.bytedance.live.datacontext.j r69 = com.bytedance.android.live.liveinteract.api.utils.m.e(this).J();
        if (r69 == null) goto L227;
        LivePlayModeLogContext r70 = (LivePlayModeLogContext) r69.getValue();
        if (r70 == null) goto L227;
        r70.clearPlayModesOnlySupportMultiPeople();
    L227:
        com.bytedance.android.live.liveinteract.plantform.utils.i.b();
        DataCenter r71 = ((Widget) this).dataCenter;
        if (r71 == null) goto L230;
        String r72 = (String) r71.get("data_room_unique_id", "");
    L231:
        tc0.c.i(r72).O = null;
        us1.e.c = false;
        sh0.i0 r73 = this.w;
        if (r73 == null) goto L234;
        r73.d0(sh0.d0.b, null);
    L234:
        sh0.i0 r74 = sh0.j0.a;
        sh0.j0.b(((Widget) this).dataCenter);
        if (vm2.d.K0() == true) goto L237;
    L242:
        boolean r75 = true;
    L243:
        com.bytedance.android.live.effect.api.h0 r76 = kh0.b.a(r75);
        if (r76 == null) goto L246;
        r76.b("multi_seat_widget", "[VideoTalk]VideoTalkRoomAnchorWidget_start#reset effect, multi link exit.");
    L246:
        Lazy r77 = MultiComponentManager.e;
        MultiComponentManager.a.a().b(((Widget) this).context);
        cg6.a r78 = getScopeServiceOrNullInMultiLinkRoom(cg6.a.class);
        if (r78 == null) goto L249;
        r78.release();
    L249:
        com.bytedance.android.live.liveinteract.plantform.utils.u r79 = this.H1;
        if (r79 == null) goto L252;
        r79.k();
    L252:
        com.bytedance.android.livesdk.chatroom.u r80 = com.bytedance.android.live.liveinteract.api.utils.m.e(this);
        if (r80 == null) goto L263;
        com.bytedance.live.datacontext.m r81 = r80.o();
        if (r81 == null) goto L264;
        r81.setValue(r34);
        return;
    L264:
        return;
    L263:
        return;
    L237:
        if (vm2.d.h() == false) goto L242;
        this.b2 = null;
        k50.c r82 = this.g2;
        r75 = true;
        if (r82 == null) goto L241;
        r82.b = true;
    L241:
        this.g2 = null;
        goto L243
    L230:
        r72 = null;
    L192:
        r56 = false;
        goto L193
    L143:
        if (r43.intValue() != (-1)) goto L144;
        r27.put("play_mode", u0.b());
        goto L167
    L131:
        r27.put("over_path", "live_over");
    L127:
        r40 = "";
        goto L129
    L120:
        if (((IInteractService) jc1.k.n(IInteractService.class)).dynamicFromAudience() == false) goto L122;
        r27.put("function_type2", "new_audience");
        r27.put("function_type", "new_audience");
        goto L123
    L122:
        r27.put("function_type", "radio");
        goto L123
    L108:
        r37 = false;
        goto L109
    L94:
        r114 = "0";
        goto L95
    L89:
        if (r112.j() == false) goto L91;
        r27.put("is_continue", "continue");
        goto L91
    L82:
        r35 = "off";
        goto L83
    L78:
        r32 = 0;
        goto L79
    L74:
        r29 = "off";
        goto L75
    }

    public final void onPause() {
        if (jc1.k.n(IMiddlewareLiveMiniAppService.class).getMiniAppActivityState() == false) goto L6;
        this.N = true;
        return;
    L6:
        this.I = true;
        Activity r0 = ContextUtil.contextToActivity(((Widget) this).context);
        if (r0 != null) goto L9;
    L31:
        super/*com.bytedance.android.live.core.tetris.widgets.LiveWidget*/.onPause();
        return;
    L9:
        if (r0.isFinishing() == true) goto L31;
        hg6.g r1 = R1();
        if (r1 == null) goto L31;
        if (r1.isEngineOn() != true) goto L31;
        if (((IInteractService) jc1.k.n(IInteractService.class)).enableCaptureAudioOnBackground(true) == true) goto L29;
        yj0.a r2 = this.H;
        if (r2 != null) goto L19;
    L25:
        yj0.a r3 = this.H;
        if (r3 == null) goto L28;
        r3.g = false;
    L28:
        er(false, "live pause");
    L30:
        yq().v();
        goto L31
    L19:
        if (r2.e0() != 0) goto L25;
        yj0.a r4 = this.H;
        if (r4 == null) goto L23;
        r4.g = true;
    L23:
        if (r4 == null) goto L28;
        r4.f0(jc1.k.n(IMiddlewareUserService.class).user().n(), 1, null);
        goto L28
    L29:
        com.bytedance.android.live.liveinteract.plantform.utils.x.J();
        goto L30
    }

    @Override // rj0.e
    public final void onProgramFrameErr() {
        LinkCastAnchorWidget r0 = this.Q;
        if (r0 == null) goto L6;
        r0.onProgramFrameErr();
        return;
    }

    @Override // rj0.e
    public final void onProgramHide() {
        if (this.N == false) goto L8;
        View r0 = ((Widget) this).contentView;
        if (r0 == null) goto L7;
        r0.postDelayed(this.T1, 1000);
    L7:
        xs2.b.a().post(new h1(61));
    L8:
        LinkCastAnchorWidget r1 = this.Q;
        if (r1 == null) goto L12;
        r1.onProgramHide();
        return;
    }

    @Override // rj0.e
    public final void onProgramShow() {
        View r0 = ((Widget) this).contentView;
        if (r0 == null) goto L6;
        r0.removeCallbacks(this.T1);
    L6:
        if (this.S1 == false) goto L11;
        View r1 = ((Widget) this).contentView;
        if (r1 == null) goto L10;
        r1.post(this.V1);
    L10:
        this.S1 = false;
    L11:
        LinkCastAnchorWidget r2 = this.Q;
        if (r2 == null) goto L14;
        r2.onProgramShow();
    L14:
        xs2.b.a().post(new h1(62));
    }

    @Override // rj0.e
    public final void onProgramStop() {
        LinkCastAnchorWidget r0 = this.Q;
        if (r0 == null) goto L6;
        r0.onProgramStop();
        return;
    }

    @Override // rj0.k
    public final void pm() {
        Intrinsics.checkNotNullParameter("card", "requestPage");
        rj0.k.b.c(this, "card", 0, 12);
    }

    @Override // rj0.k
    public final void s3() {
        if (((Boolean) ((Widget) this).dataCenter.get("cmd_ready_starting_live", Boolean.FALSE)).booleanValue() == false) goto L6;
        fr();
        return;
    }

    @Override // zj0.b
    public final Pair<Integer, Integer> x3() {
        return new Pair(0, 0);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.videolink.MultiLinkVideoBaseAnchorLinkWidget, com.bytedance.android.live.liveinteract.plantform.widgt.MultiLinkBaseAnchorLinkWidget
    public final void yi() {
        if (this.K == false) goto L7;
        this.K = false;
        gd0.d r0 = this.L;
        if (r0 == null) goto L8;
        r0.onSuccess();
    L8:
        sh0.i0 r1 = this.w;
        if (r1 == null) goto L11;
        r1.d0(sh0.z.b, Boolean.TRUE);
    L11:
        xf6.a r2 = Gq();
        if (r2 == null) goto L14;
        r2.f();
    L14:
        VideoEffectPerfHelper r3 = this.L1;
        if (r3 == null) goto L18;
        r3.d();
        return;
    L18:
        return;
    L7:
        super.yi();
        goto L8
    }

    public final int Pq() {
        com.bytedance.live.datacontext.j r0 = com.bytedance.android.live.liveinteract.api.utils.m.e(this).J();
        if (r0 == null) goto L19;
        LivePlayModeLogContext r1 = (LivePlayModeLogContext) r0.getValue();
        if (r1 == null) goto L19;
        if (((Set) r1.getPlayModes().getValue()).size() > 0) goto L9;
        return -1;
    L9:
        Iterator r2 = ((Set) r1.getPlayModes().getValue()).iterator();
    L11:
        if (r2.hasNext() == false) goto L19;
        int r3 = ((Number) r2.next()).intValue();
        if (r3 == 9) goto L18;
        if (r3 == 8) goto L18;
        if (r3 != 10) goto L11;
    L18:
        return r3;
    L19:
        return -1;
    }

    @Override // rj0.n
    public final void Qo() {
        com.bytedance.live.bizlink.impl.platform.manager.a r0 = zq().A0();
        if (r0 == null) goto L6;
        r0.g();
        return;
    }

    public final com.bytedance.android.livesdk.chatroom.viewmodel.j Qq() {
        com.bytedance.live.datacontext.j r0 = com.bytedance.android.live.liveinteract.api.utils.m.e(this).getVideoTalkRoomSubScene();
        if (r0 == null) goto L7;
        com.bytedance.android.livesdk.chatroom.viewmodel.e r1 = (com.bytedance.android.livesdk.chatroom.viewmodel.e) r0.getValue();
        if (r1 == null) goto L7;
        return r1.t();
    L7:
        return null;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.videolink.MultiLinkVideoBaseAnchorLinkWidget, he0.c.a
    public final List<Integer> R4() {
        com.bytedance.live.datacontext.j r0 = com.bytedance.android.live.liveinteract.api.utils.m.e(this).getVideoTalkRoomSubScene();
        if (r0 == null) goto L11;
        com.bytedance.android.livesdk.chatroom.viewmodel.e r1 = (com.bytedance.android.livesdk.chatroom.viewmodel.e) r0.getValue();
        if (r1 == null) goto L11;
        com.bytedance.android.livesdk.chatroom.viewmodel.j r2 = r1.t();
        if (r2 == null) goto L11;
        ClientUIInfo r3 = r2.e;
        if (r3 == null) goto L11;
        return r3.getUiFeatureList();
    L11:
        return null;
    }

    @Override // rj0.k
    public final /* bridge */ /* synthetic */ zj0.d U1() {
        return Mq();
    }

    @Override // rj0.k
    public final ei6.a Z0() {
        hg6.g r0 = R1();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.V0();
    }

    @Override // rj0.k
    public final ILinkPlayerInfoBridge currentCPositionUser() {
        com.bytedance.android.livesdk.chatroom.viewmodel.j r0 = Qq();
        Object r1 = null;
        if (r0 == null) goto L5;
        List r2 = r0.b;
    L7:
        if (com.bytedance.android.livesdk.chatroom.interact.model.d0.c(r2) == false) goto L23;
        com.bytedance.android.live.liveinteract.plantform.core.y r3 = yq();
        if (r3 == null) goto L24;
        CopyOnWriteArrayList<ILinkPlayerInfoBridge> r4 = r3.c;
        if (r4 == null) goto L25;
        Iterator<T> r5 = r4.iterator();
    L14:
        if (r5.hasNext() == false) goto L19;
        Object r6 = r5.next();
        if (((ILinkPlayerInfoBridge) r6).isEnlarged() == false) goto L14;
        r1 = r6;
    L19:
        return (ILinkPlayerInfoBridge) r1;
    L25:
        return null;
    L24:
        return null;
    L23:
        return null;
    L5:
        r2 = null;
        goto L7
    }

    @Override // tf0.o.a
    public final void f() {
        hg6.g r0 = R1();
        if (r0 == null) goto L6;
        r0.f();
        return;
    }

    @Override // rj0.k
    public final void forceReverseCamera() {
        jg6.a r0 = zq().e5();
        if (r0 == null) goto L8;
        lh6.b r1 = r0.a();
        if (r1 == null) goto L9;
        r1.m();
        return;
    L9:
        return;
    }

    public final void fr() {
        com.bytedance.android.livesdk.chatroom.u r0 = com.bytedance.android.live.liveinteract.api.utils.m.e(this);
        StringBuilder r1 = new StringBuilder("params : openPanelType = ");
        com.bytedance.live.datacontext.m r2 = r0.c();
        Unit r3 = null;
        if (r2 == null) goto L5;
        Integer r4 = (Integer) r2.getValue();
    L6:
        r1.append(r4);
        r1.append(", platformActivityId = ");
        com.bytedance.live.datacontext.m r5 = r0.p();
        if (r5 == null) goto L9;
        String r6 = (String) r5.getValue();
    L10:
        r1.append(r6);
        jy0.b.a("open_panel_for_schema", r1.toString());
        com.bytedance.live.datacontext.m r7 = r0.c();
        if (r7 == null) goto L13;
        Integer r8 = (Integer) r7.getValue();
    L14:
        com.bytedance.live.datacontext.m r9 = r0.p();
        if (r9 == null) goto L17;
        String r10 = (String) r9.getValue();
    L18:
        com.bytedance.android.live.liveinteract.plantform.utils.x.P(r8, r10);
        com.bytedance.live.datacontext.m r11 = r0.c();
        if (r11 == null) goto L21;
        Integer r12 = (Integer) r11.getValue();
    L22:
        int r13 = OpenPanelType.LINK_METHOD_SETTING_PANEL.getValue();
        String r14 = "";
        if (r12 != null) goto L26;
    L46:
        int r15 = OpenPanelType.PAID_LINK_SETTING_PANEL.getValue();
        if (r12 != null) goto L50;
    L80:
        com.bytedance.live.datacontext.m r16 = r0.c();
        if (r16 == null) goto L84;
        r16.setValue(Integer.valueOf(OpenPanelType.NONE.getValue()));
        return;
    L84:
        return;
    L50:
        if (r12.intValue() != r15) goto L80;
        com.bytedance.live.datacontext.m r17 = r0.p();
        if (r17 == null) goto L57;
        String r18 = (String) r17.getValue();
        if (r18 == null) goto L57;
        r14 = r18;
    L57:
        int r19 = fj0.e.a;
        com.bytedance.android.live.liveinteract.api.data.a.h.getClass();
        if (com.bytedance.android.live.liveinteract.api.data.a.C0017a.i() == true) goto L60;
        com.bytedance.live.datacontext.m r20 = com.bytedance.android.live.liveinteract.api.utils.m.e(this).c();
        if (r20 == null) goto L80;
        r20.setValue(Integer.valueOf(OpenPanelType.NONE.getValue()));
        goto L80
    L60:
        if (com.bytedance.android.live.liveinteract.api.data.a.C0017a.e() == true) goto L62;
        Context r21 = ((Widget) this).context;
        if (r21 == null) goto L80;
        ILinkPanelService r22 = com.bytedance.android.live.liveinteract.component.b.a();
        if (r22 == null) goto L80;
        DataCenter r23 = ((Widget) this).dataCenter;
        IRoom r24 = getMRoom();
        DataCenter r25 = ((Widget) this).dataCenter;
        if (r25 == null) goto L76;
        Boolean r26 = (Boolean) r25.get("data_is_portrait", Boolean.TRUE);
        if (r26 == null) goto L76;
        r26.booleanValue();
    L76:
        r22.JR(r21, r23, r24, fj0.e.l(), this);
        goto L80
    L62:
        if (cj0.h.a() == true) goto L64;
        ((IInteractService) jc1.k.n(IInteractService.class)).getVideoTalkService().c(((Widget) this).context, r14);
        goto L80
    L64:
        com.bytedance.live.datacontext.m r27 = com.bytedance.android.live.liveinteract.api.utils.m.e(this).c();
        if (r27 == null) goto L80;
        r27.setValue(Integer.valueOf(OpenPanelType.NONE.getValue()));
        goto L80
    L26:
        if (r12.intValue() != r13) goto L46;
        com.bytedance.live.datacontext.m r28 = r0.p();
        if (r28 == null) goto L31;
        String r29 = (String) r28.getValue();
        if (r29 == null) goto L31;
    L32:
        int r30 = us1.g.a;
        getMRoom();
        if (vm2.d.r0() == false) goto L35;
        jc1.k.n(IBaseLiveActionHandler.class).handle(((Widget) this).context, UriProtector.parse(vm2.d.Q().a()).buildUpon().appendQueryParameter("url", vm2.d.Q().b()).build().toString());
        goto L80
    L35:
        Ref.ObjectRef r31 = new Ref.ObjectRef();
        DataCenter r32 = ((Widget) this).dataCenter;
        long r33 = getMRoom().getRoomId();
        Intrinsics.checkNotNullParameter(this, "$this$multiLinkContext");
        Intrinsics.checkNotNullParameter(r32, "dataCenter");
        com.bytedance.android.livesdk.chatroom.u r34 = jc1.k.n(IRoomContextService.class).getRoomMultiLinkService(r32, r33);
        if (r34 == null) goto L45;
        com.bytedance.live.datacontext.n r35 = r34.l();
        if (r35 == null) goto L45;
        List r36 = (List) r35.getValue();
        if (r36 == null) goto L45;
        r31.element = r36;
        ILinkPanelService r37 = com.bytedance.android.live.liveinteract.component.b.a();
        if (r37 == null) goto L44;
        r37.uO(getContext(), ((Widget) this).dataCenter, getMRoom(), (List) r31.element, r29, this);
        r3 = Unit.INSTANCE;
    L44:
        if (r3 != null) goto L80;
    L45:
        long r38 = System.currentTimeMillis();
        this.m.add(((LinkAudienceApi) com.bytedance.android.live.network.c.b().e(LinkAudienceApi.class)).interactList(getMRoom().getId()).compose(RxUtil.rxSchedulerHelper()).subscribe(new com.bytedance.android.live.liveinteract.videotalk.m(r38, this, r31, r29), new com.bytedance.android.live.liveinteract.videotalk.n(r38)));
    L31:
        r29 = "";
        goto L32
    L21:
        r12 = null;
        goto L22
    L17:
        r10 = null;
        goto L18
    L13:
        r8 = null;
        goto L14
    L9:
        r6 = null;
        goto L10
    L5:
        r4 = null;
        goto L6
    }

    @Override // rj0.k
    public final com.bytedance.android.live.liveinteract.plantform.base.i<ILinkPlayerInfoBridge> getLinkUserInfoCenter() {
        return yq();
    }

    @Override // rj0.k
    public final MixStreamType getMixStreamType() {
        hg6.g r0 = R1();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getMixStreamType();
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.videolink.MultiLinkVideoBaseAnchorLinkWidget, he0.c.a
    public final int getUILayout() {
        if ((!Intrinsics.areEqual(Mq(), zj0.d.a.h)) == false) goto L7;
        return Mq().b;
    L7:
        return ((IInteractService) jc1.k.n(IInteractService.class)).getCurrentUiLayout();
    }

    public final void gr() {
        if (isViewValid() == true) goto L5;
        return;
    L5:
        if (getUILayout() == 63) goto L32;
        int r0 = us1.g.a;
        getMRoom();
        IRoom r1 = getMRoom();
        if (r1 == null) goto L14;
        com.bytedance.android.livesdk.chatroom.model.interact.j0 r2 = r1.getLinkInitResult();
        if (r2 == null) goto L14;
        if (r2.isFirstInit() != true) goto L14;
        boolean r3 = true;
    L15:
        if (r3 == true) goto L17;
        v0(0, "integration", -1, null);
        return;
    L17:
        if (vm2.h.X().a() == true) goto L29;
        VideoTalkIntegrationGuidDialog r4 = new VideoTalkIntegrationGuidDialog(((Widget) this).context, ((Widget) this).dataCenter);
        if (DialogLancet.shouldBlockDialogShow(r4) == false) goto L26;
        DialogLancet.handleBlockedDialogShow(r4);
        return;
    L26:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L25
    L22:
        DialogLancet.beforeDialogShow(r4);
        r4.show();
        DialogLancet.afterDialogShow(r4);
        return;
    L29:
        return;
    L14:
        r3 = false;
        goto L15
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.videolink.MultiLinkVideoBaseAnchorLinkWidget, he0.c.a
    public final int i1() {
        if ((!Intrinsics.areEqual(Mq(), zj0.d.a.h)) == true) goto L5;
        com.bytedance.live.datacontext.j r0 = com.bytedance.android.live.liveinteract.api.utils.m.e(this).getVideoTalkRoomSubScene();
        if (r0 == null) goto L41;
        com.bytedance.android.livesdk.chatroom.viewmodel.e r1 = (com.bytedance.android.livesdk.chatroom.viewmodel.e) r0.getValue();
        if (r1 == null) goto L43;
        com.bytedance.android.livesdk.chatroom.viewmodel.j r2 = r1.t();
        if (r2 == null) goto L44;
        int r3 = r2.a;
        if (r3 != 12) goto L17;
        return 9;
    L17:
        if (r3 != 8) goto L20;
        return 8;
    L20:
        if (r3 != 16) goto L45;
        int r4 = r2.c;
        if (r4 != 51) goto L26;
        return 17;
    L26:
        if (r4 != 56) goto L30;
        return 31;
    L30:
        if (r4 != 57) goto L34;
        return 32;
    L34:
        if (r4 != 58) goto L38;
        return 33;
    L38:
        if (r4 != 67) goto L46;
        return 39;
    L46:
        return 10;
    L45:
        return 10;
    L44:
        return 10;
    L43:
        return 10;
    L41:
        return 10;
    L5:
        return Mq().c;
    }

    @Override // rj0.k, rj0.n
    public final boolean isEngineOn() {
        hg6.g r0 = R1();
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.isEngineOn() != true) goto L7;
        return true;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.MultiLinkBaseAnchorLinkWidget
    public final void onResume() {
        super.onResume();
        tf0.o r0 = this.E;
        if (r0 == null) goto L6;
        r0.onResume();
    L6:
        if (this.N == true) goto L8;
    L15:
        this.N = false;
        this.I = false;
        hg6.g r2 = R1();
        if (r2 == null) goto L54;
        if (r2.isEngineOn() != true) goto L54;
        jg6.a r3 = Bq();
        if (r3 == null) goto L24;
        kg6.e r4 = r3.b();
        if (r4 == null) goto L24;
        r4.y(false, "onResume");
    L24:
        sb6.a r5 = GuestLinkContext.Companion.a();
        if (r5 != null) goto L27;
    L29:
        jy0.b.d("[VideoTalk]VideoTalkRoomAnchorWidget", "isEnterGuestLinkChannel false");
        boolean r6 = false;
    L30:
        if (r6 == true) goto L40;
        yj0.a r7 = this.H;
        if (r7 != null) goto L34;
    L35:
        yj0.a r8 = this.H;
        if (r8 == null) goto L40;
        if (r8.g != true) goto L40;
    L39:
        boolean r9 = true;
    L41:
        if (r9 == true) goto L43;
    L49:
        yj0.a r1 = this.H;
        if (r1 == null) goto L52;
        r1.g = false;
    L52:
        yq().r0();
        goto L54
    L43:
        if (this.b1 == false) goto L48;
        yj0.a r10 = this.H;
        if (r10 == null) goto L47;
        yj0.a.h0(r10, jc1.k.n(IMiddlewareUserService.class).user().n(), null, 6);
    L47:
        this.u.k();
        goto L49
    L48:
        this.g1 = true;
        goto L49
    L34:
        if (r7.e0() == 3) goto L39;
    L40:
        r9 = false;
        goto L41
    L27:
        if (r5.c != true) goto L29;
        jy0.b.d("[VideoTalk]VideoTalkRoomAnchorWidget", "isEnterGuestLinkChannel true");
        r6 = true;
    L54:
        if (com.bytedance.android.live.liveinteract.spatial.a.e(C0()) == false) goto L58;
        hg6.g r11 = R1();
        if (r11 == null) goto L58;
        r11.i(true);
    L58:
        View r12 = ((Widget) this).contentView;
        if (r12 == null) goto L62;
        r12.removeCallbacks(this.T1);
    L62:
        if (this.S1 == false) goto L68;
        View r13 = ((Widget) this).contentView;
        if (r13 == null) goto L66;
        r13.post(this.V1);
    L66:
        this.S1 = false;
        return;
    L68:
        return;
    L8:
        if (isLinkCasting() == false) goto L15;
        tf0.o r14 = this.E;
        if ((r14 instanceof CommonMultiLinkWindowManager) == true) goto L12;
        r14 = null;
    L12:
        CommonMultiLinkWindowManager r15 = (CommonMultiLinkWindowManager) r14;
        if (r15 == null) goto L15;
        r15.Y0();
        goto L15
    }

    @Override // tf0.o.a
    public final HashMap<String, Boolean> Y7() {
        return this.p0;
    }

    @Override // rj0.k
    public final String currentCPositionChangeTrackData() {
        return this.v1;
    }

    @Override // rj0.k
    public final int currentCPositionOpenSource() {
        return this.p1;
    }

    @Override // rj0.k
    public final tf0.h getInteractAnimationService() {
        return this.M;
    }

    @Override // rj0.k
    public final com.bytedance.android.live.pushstream.d getLiveStream() {
        return this.v;
    }

    @Override // rj0.k
    public final ArrayList<ILinkPlayerInfoBridge> getOnlineList() {
        return this.Y;
    }

    @Override // rj0.k
    public final tf0.m getSwitchLayoutStatisticsUtils() {
        return this.G1;
    }

    @Override // rj0.k
    public final cj0.e paidLinkManager() {
        return this.S;
    }

    @Override // rj0.k
    public final tf0.o windowManager() {
        return this.E;
    }

    @Override // tf0.o.a
    public final int Aa(SurfaceView r6) {
        com.bytedance.android.live.liveinteract.plantform.model.e0 r0 = tc0.c.h().s;
        Boolean r1 = null;
        if (r0 == null) goto L5;
        String r2 = r0.getRivalsStreamId();
    L6:
        StringBuilder r3 = new StringBuilder("setPublicStreamVideoCanvas isEngineOn: ");
        hg6.g r4 = R1();
        if (r4 == null) goto L9;
        r1 = Boolean.valueOf(r4.isEngineOn());
    L9:
        r3.append(r1);
        r3.append(" id ");
        r3.append(r2);
        r3.append(" view ");
        r3.append(r6);
        jy0.b.a(LinkRoomFightContext.TAG, r3.toString());
        int r5 = 0;
        if (r2 != null) goto L12;
    L19:
        hg6.g r7 = R1();
        if (r7 == null) goto L24;
        xi0.b r8 = r7.O();
        if (r8 == null) goto L24;
        r5 = r8.b0(String.valueOf(r2), r6);
    L24:
        jy0.b.a(LinkRoomFightContext.TAG, "setPublicStreamVideoCanvas result " + r5);
        return r5;
    L12:
        if (r2.length() != 0) goto L14;
        boolean r9 = true;
    L15:
        if (r9 != true) goto L19;
        return -1;
    L14:
        r9 = false;
        goto L15
    L5:
        r2 = null;
        goto L6
    }

    @Override // yj0.a.InterfaceC0294a
    public final void D(String r6) {
        Intrinsics.checkNotNullParameter(r6, "userId");
        if (Intrinsics.areEqual(jc1.k.n(IMiddlewareUserService.class).user().n(), r6) == false) goto L5;
        return;
    L5:
        com.bytedance.android.live.liveinteract.plantform.core.y r0 = yq();
        if (r0 == null) goto L16;
        IBaseUser r7 = r0.c5(r6);
        if (r7 != null) goto L10;
        return;
    L10:
        if (TextUtils.isEmpty(r7.getNickName()) == false) goto L12;
    L14:
        f2.c(s1.C(2131923165, new Object[]{r7.getNickName()}), 0);
        return;
    L12:
        if (r7.getNickName().length() <= 10) goto L14;
        f2.c(s1.C(2131923165, new Object[]{r7.getNickName().subSequence(0, 10).toString() + "..."}), 0);
        return;
    }

    @Override // yj0.a.InterfaceC0294a
    public final void G(String r6) {
        Intrinsics.checkNotNullParameter(r6, "userId");
        if (Intrinsics.areEqual(jc1.k.n(IMiddlewareUserService.class).user().n(), r6) == true) goto L5;
        com.bytedance.android.live.liveinteract.plantform.core.y r0 = yq();
        if (r0 == null) goto L20;
        IBaseUser r7 = r0.c5(r6);
        if (r7 != null) goto L13;
        return;
    L13:
        if (TextUtils.isEmpty(r7.getNickName()) == false) goto L15;
    L17:
        f2.c(s1.C(2131923172, new Object[]{r7.getNickName()}), 0);
        return;
    L15:
        if (r7.getNickName().length() <= 10) goto L17;
        f2.c(s1.C(2131923172, new Object[]{r7.getNickName().subSequence(0, 10).toString() + "..."}), 0);
        return;
    L20:
        return;
    L5:
        if (((Boolean) vm2.d.k0.getValue(null, vm2.d.a[60])).booleanValue() == false) goto L19;
        er(true, "unSilence success");
        return;
    }

    @Override // rj0.n
    public final void H9(com.bytedance.android.live.liveinteract.voicechat.toolbar.e r1) {
        this.L0 = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.MultiLinkBaseAnchorLinkWidget
    public final void M4(cc6.b r4) {
        Intrinsics.checkNotNullParameter(r4, "error");
        super.M4(r4);
        finishVideoTalk("rtcStartFailed_" + r4.a);
        if (this.r != 12) goto L6;
        this.r = 0;
    L6:
        if (this.B != 12) goto L9;
        this.B = 0;
        return;
    }

    @Override // tf0.o.a
    public final int Po(String r4) {
        jy0.b.a(LinkRoomFightContext.TAG, "livecore version " + ((IMiddlewareBroadcastService) va1.b.a.a.a(IMiddlewareBroadcastService.class)).getLiveCoreVersion());
        jy0.b.a(LinkRoomFightContext.TAG, "startPlayPublicStream id " + r4);
        if (r4 != null) goto L6;
        return -1;
    L6:
        hg6.g r0 = R1();
        if (r0 == null) goto L11;
        xi0.b r1 = r0.O();
        if (r1 == null) goto L11;
        int r5 = r1.l(r4);
    L12:
        jy0.b.a(LinkRoomFightContext.TAG, "startPlayPublicStream result " + r5);
        return r5;
    L11:
        r5 = 0;
        goto L12
    }

    public final void Zq(n90.e r5) {
        ReleaseStatus r0 = r5.a;
        ReleaseStatus r1 = ReleaseStatus.End;
        boolean r3 = false;
        if (r0 != r1) goto L8;
        if (this.g1 == false) goto L8;
        er(true, "live resume");
        this.u.k();
        this.g1 = false;
    L8:
        if (r5.a != r1) goto L10;
        r3 = true;
    L10:
        this.b1 = r3;
        if (r3 == true) goto L13;
        return;
    L13:
        if (this.I == true) goto L34;
        hg6.g r6 = R1();
        if (r6 != null) goto L17;
        return;
    L17:
        if (r6.isEngineOn() != true) goto L36;
        yj0.a r7 = this.H;
        if (r7 != null) goto L21;
    L22:
        yj0.a r8 = this.H;
        if (r8 != null) goto L25;
        return;
    L25:
        if (r8.g == true) goto L27;
        return;
    L27:
        if (this.b1 == false) goto L39;
        yj0.a r9 = this.H;
        if (r9 == null) goto L31;
        yj0.a.h0(r9, jc1.k.n(IMiddlewareUserService.class).user().n(), null, 6);
    L31:
        this.u.k();
        return;
    L39:
        return;
    L21:
        if (r7.e0() == 3) goto L27;
    L36:
        return;
    }

    @Override // tf0.o.a
    public final uf2.z.a c3(String r2) {
        if (TextUtils.equals(r2, tc0.c.h().f) == false) goto L10;
        uf2.d0 r3 = this.v.A();
        if (r3 == null) goto L16;
        uf2.z r4 = r3.C();
        if (r4 != null) goto L9;
        return null;
    L9:
        return r4.K0();
    L16:
        return null;
    L10:
        uf2.d0 r5 = this.v.A();
        if (r5 == null) goto L18;
        uf2.z r6 = r5.C();
        if (r6 != null) goto L15;
        return null;
    L15:
        return r6.l();
    L18:
        return null;
    }

    @Override // rj0.k
    public final void commonWMUpdateLiveCoreAndRtcInfo(String r6) {
        Intrinsics.checkNotNullParameter(r6, "from");
        jy0.b.d("ttlive_link_video", "updateLiveCoreRtcInfo " + r6);
        tf0.o r1 = this.E;
        if (r1 == null) goto L5;
        int r2 = r1.h(this.o.getInteractId());
    L6:
        String r3 = com.bytedance.android.live.liveinteract.plantform.commonwindow.utils.b.b(r2);
        String r4 = com.bytedance.android.live.liveinteract.plantform.commonwindow.utils.b.a(r2);
        ca(r3, r4);
        JSONObject r5 = new JSONObject();
        r5.put("from", r6);
        r5.put("selfPosition", r2);
        r5.put("rtcExtInfo", r3);
        r5.put("liveCoreExtInfo", r4);
        TalkRoomBusinessFullLinkMonitor.a.getClass();
        TalkRoomBusinessFullLinkMonitor.j(true, r5);
        return;
    L5:
        r2 = -1;
        goto L6
    }

    public final <T> void cr(Class<T> r3) {
        this.m.add(xs2.b.a().b(r3).subscribe(new m(this)));
    }

    public final void dr(boolean r10) {
        MiddlewareRoomContext r0 = MiddlewareRoomContext.a.c(MiddlewareRoomContext.Companion, ((Widget) this).dataCenter, 0, 2);
        nz.w r1 = null;
        if (r0 == null) goto L7;
        com.bytedance.live.datacontext.j r2 = r0.getAnchorRoomScopeViewModel();
        if (r2 == null) goto L7;
        nz.l r3 = (nz.l) r2.getValue();
    L8:
        if (r3 == null) goto L10;
        r1 = (nz.w) r3.a();
    L10:
        if (r10 == false) goto L12;
        int r11 = nz.b.a.a;
    L13:
        if (r1 == null) goto L16;
        int r12 = nz.f0.e.b;
        int r13 = nz.a.a.a;
        new AnchorInteractionData(null, 3L, 20L, null, 9, null);
        r1.a();
        return;
    L16:
        return;
    L12:
        int r14 = nz.b.b.a;
    L7:
        r3 = null;
        goto L8
    }

    @Override // rj0.k
    public final void finishVideoTalk(String r2) {
        Intrinsics.checkNotNullParameter(r2, "reason");
        Kq(r2);
    }

    @Override // rj0.k
    public final void g0(IBaseUser r3) {
        Intrinsics.checkNotNullParameter(r3, "user");
        xf6.a r0 = Gq();
        if (r0 == null) goto L5;
        r0.b(r3, this.s);
    L5:
        Jq(true);
    }

    @Override // rj0.k
    public final void h2(gd0.d r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        this.L = r2;
    }

    @Override // zj0.e.b
    public final void h4(tf0.o r2) {
        Intrinsics.checkNotNullParameter(r2, "windowManager");
        this.E = r2;
        RTSVideoWidget r0 = this.U;
        if (r0 == null) goto L6;
        r0.c = r2;
        return;
    }

    @Override // rj0.k
    public final void invite(com.bytedance.android.live.liveinteract.videolink.a r3) {
        Intrinsics.checkNotNullParameter(r3, "params");
        if (com.bytedance.android.live.liveinteract.utils.h1.d() == true) goto L5;
    L10:
        xf6.a r0 = Gq();
        if (r0 == null) goto L14;
        r0.a(r3, this.t);
        return;
    L14:
        return;
    L5:
        if (r3.i > 0) goto L10;
        if (r3.b != 0) goto L10;
        com.bytedance.android.live.liveinteract.utils.h1.e(this.w, ((Widget) this).context, r3);
    }

    @Override // rj0.k
    public final void j3(long r3) {
        tf0.o r0 = this.E;
        if ((r0 instanceof BaseMultiLinkWindowManager) == false) goto L8;
        if (r0 == null) goto L7;
        ((BaseMultiLinkWindowManager) r0).X0(r3);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.BaseMultiLinkWindowManager");
    }

    @Override // rj0.e
    public final void kh(com.bytedance.android.live.broadcast.api.model.t.b r2) {
        LinkCastAnchorWidget r0 = this.Q;
        if (r0 == null) goto L6;
        r0.kh(r2);
        return;
    }

    @Override // rj0.k
    public final void lm(boolean r7) {
        jy0.b.d("[VideoTalk]VideoTalkRoomAnchorWidget", "onGuestLinkMainPageVisibleChange, isVisible: " + r7);
        boolean r2 = true;
        if (r7 == false) goto L23;
        yj0.a r8 = this.H;
        if (r8 != null) goto L7;
    L12:
        sb6.a r9 = GuestLinkContext.Companion.a();
        if (r9 != null) goto L15;
    L17:
        jy0.b.d("[VideoTalk]VideoTalkRoomAnchorWidget", "isEnterGuestLinkChannel false");
        r2 = false;
    L18:
        if (r2 == false) goto L35;
        jy0.b.d("[VideoTalk]VideoTalkRoomAnchorWidget", "onGuestLinkMainPageVisibleChange, updateAudioPlaybackVolumeOnly 0");
        hg6.g r10 = R1();
        if (r10 == null) goto L36;
        r10.P(0);
        return;
    L36:
        return;
    L35:
        return;
    L15:
        if (r9.c != true) goto L17;
        jy0.b.d("[VideoTalk]VideoTalkRoomAnchorWidget", "isEnterGuestLinkChannel true");
        goto L18
    L7:
        if (r8.e0() != 0) goto L12;
        jy0.b.d("[VideoTalk]VideoTalkRoomAnchorWidget", "onGuestLinkMainPageVisibleChange, muteSelf");
        this.Q1 = true;
        yj0.a r11 = this.H;
        if (r11 == null) goto L11;
        r11.f0(jc1.k.n(IMiddlewareUserService.class).user().n(), 1, null);
    L11:
        er(false, "on particular page show");
        goto L12
    L23:
        if (this.Q1 == false) goto L30;
        WeakReference r12 = com.bytedance.android.live.core.utils.a.a;
        if (com.bytedance.android.live.core.utils.a.e(getContext()) == false) goto L30;
        jy0.b.d("[VideoTalk]VideoTalkRoomAnchorWidget", "onGuestLinkMainPageVisibleChange, unMuteSelf");
        yj0.a r13 = this.H;
        if (r13 == null) goto L29;
        yj0.a.h0(r13, jc1.k.n(IMiddlewareUserService.class).user().n(), null, 6);
    L29:
        er(true, "on particular page close");
    L30:
        jy0.b.d("[VideoTalk]VideoTalkRoomAnchorWidget", "onGuestLinkMainPageVisibleChange, updateAudioPlaybackVolumeOnly 100");
        hg6.g r14 = R1();
        if (r14 == null) goto L33;
        r14.P(100);
    L33:
        this.Q1 = false;
    }

    @Override // tf0.o.a
    public final void mk(String r2) {
        v4(r2, false);
    }

    @Override // tf0.o.a
    public final void n1(boolean r2) {
        hg6.g r3 = R1();
        if (r3 == null) goto L8;
        xi0.b r4 = r3.O();
        if (r4 == null) goto L9;
        r4.n1(true);
        return;
    L9:
        return;
    }

    public final void onChanged(Object r4) {
        KVData r5 = (KVData) r4;
        String r0 = null;
        if (r5 == null) goto L5;
        String r1 = r5.getKey();
    L7:
        if (Intrinsics.areEqual(r1, "cmd_video_talk_invite") == false) goto L11;
        final IBaseUser r6 = (IBaseUser) r5.getData();
        if (r6 == null) goto L33;
        s0.a(((Widget) this).context, new MultiLinkVideoTalkRoomAnchorWidget$onChanged$$inlined$let$lambda$1(r6, this));
        return;
    L33:
        return;
    L11:
        if (r5 == null) goto L13;
        String r2 = r5.getKey();
    L15:
        if (Intrinsics.areEqual(r2, "cmd_video_talk_guest_battle_open_panel") == false) goto L19;
        String r7 = (String) r5.getData();
        sh0.i0 r3 = this.w;
        if (r3 == null) goto L35;
        r3.d0(sh0.g.b, r7);
        return;
    L35:
        return;
    L19:
        if (r5 == null) goto L21;
        String r8 = r5.getKey();
    L23:
        if (Intrinsics.areEqual(r8, "cmd_open_paid_link_setting_panel_after_fetch_audience_setting") == false) goto L25;
        s3();
        return;
    L25:
        if (r5 == null) goto L28;
        r0 = r5.getKey();
    L28:
        if (Intrinsics.areEqual(r0, "cmd_video_talkroom_sensitive_permission_release") == false) goto L38;
        n90.e r9 = (n90.e) r5.getData();
        if (r9 == null) goto L39;
        Zq(r9);
        return;
    L39:
        return;
    L38:
        return;
    L21:
        r8 = null;
        goto L23
    L13:
        r2 = null;
        goto L15
    L5:
        r1 = null;
        goto L7
    }

    public final void onConfigurationChanged(Configuration r2) {
        Intrinsics.checkNotNullParameter(r2, "newConfig");
        super/*com.bytedance.ies.sdk.widgets.Widget*/.onConfigurationChanged(r2);
        if (FoldScreenUtils.f() == false) goto L5;
    L6:
        tf0.o r3 = this.E;
        if ((r3 instanceof BaseMultiLinkWindowManager) == true) goto L9;
        r3 = null;
    L9:
        BaseMultiLinkWindowManager r4 = (BaseMultiLinkWindowManager) r3;
        if (r4 == null) goto L14;
        r4.Y0();
        return;
    L14:
        return;
    L5:
        if (PadConfigUtils.a() == true) goto L6;
    }

    public final void onMessage(tlc.d r24) {
        String r2 = "";
        int r3 = 0;
        if ((r24 instanceof com.bytedance.android.livesdk.link.model.bridge.h1) == false) goto L121;
        com.bytedance.android.livesdk.link.model.bridge.h1 r14 = (com.bytedance.android.livesdk.link.model.bridge.h1) r24;
        int r0 = r14.getMType();
        String r8 = null;
        if (r0 == 46) goto L106;
        boolean r4 = true;
        if (r0 != 54) goto L9;
        ILinkerUILayoutChangeContent r1 = r14.getLinkerUILayoutChangeContent();
        if (r1 == null) goto L162;
        StringBuilder r5 = new StringBuilder("onUILayoutChangeMessage: \n messageId = ");
        r5.append(r14.getMessageId3());
        r5.append(", scene = ");
        r5.append(r14.getScene());
        r5.append(", content_ui_layout = ");
        r5.append(r1.getUiLayout());
        r5.append("\n multiLiveCoreInfo = ");
        if (r1.getMultiLiveCoreInfo() == null) goto L81;
        boolean r6 = true;
    L82:
        r5.append(r6);
        r5.append("\n liveCoreExtInfo = ");
        r5.append(r1.getLiveCoreExtInfo());
        r5.append("\n multiRtcInfo = ");
        if (r1.getMultiRtcInfo() != null) goto L86;
        r4 = false;
    L86:
        r5.append(r4);
        r5.append("\n rtcExtInfo = ");
        r5.append(r1.getRtcExtInfo());
        gh0.b.a("RtcParamsUpdate", r5.toString(), false);
        br(r1.getMultiLiveCoreInfo(), r1.getMultiRtcInfo(), r1.getLiveCoreExtInfo(), r1.getRtcExtInfo(), null);
        com.bytedance.android.live.liveinteract.plantform.core.y r15 = yq();
        List<? extends com.bytedance.android.livesdk.link.model.bridge.k> r7 = r1.getLinkedListUsers();
        if (r7 != null) goto L89;
        r7 = new ArrayList();
    L89:
        r15.Y4(r7, r1.getClientUiInfo(), r1.getVersion(), "UILayoutChangeMessage", r1.getLinkerContentMap());
        com.bytedance.live.datacontext.j r9 = com.bytedance.android.live.liveinteract.api.utils.m.e(this).getVideoTalkRoomSubScene();
        if (r9 == null) goto L94;
        com.bytedance.android.livesdk.chatroom.viewmodel.e r10 = (com.bytedance.android.livesdk.chatroom.viewmodel.e) r9.getValue();
        if (r10 == null) goto L94;
        r10.c(r10.t());
        r10.e(new com.bytedance.android.livesdk.chatroom.viewmodel.j(8, je0.d.d(), (int) r1.getUiLayout(), false, r1.getClientUiInfo(), false, 40));
    L94:
        com.bytedance.live.datacontext.j r11 = com.bytedance.android.live.liveinteract.api.utils.m.e(this).getVideoTalkRoomSubScene();
        if (r11 == null) goto L101;
        com.bytedance.android.livesdk.chatroom.viewmodel.e r12 = (com.bytedance.android.livesdk.chatroom.viewmodel.e) r11.getValue();
        if (r12 == null) goto L101;
        com.bytedance.android.livesdk.chatroom.viewmodel.j r13 = r12.t();
        if (r13 == null) goto L101;
        List<Integer> r16 = r13.b;
    L102:
        zj0.e r17 = this.V0;
        if (r17 != null) goto L105;
        Intrinsics.throwUninitializedPropertyAccessException("layoutSwitcher");
    L105:
        r17.f(new zj0.c.a((int) r14.getScene(), (int) r1.getUiLayout(), "onUiLayoutChangeMessage", null), r16, r1.getClientUiInfo());
        commonWMUpdateLiveCoreAndRtcInfo("UILayoutChangeMessage");
        return;
    L101:
        r16 = null;
        goto L102
    L81:
        r6 = false;
        goto L82
    L162:
        return;
    L9:
        switch(r0) {
            case 36: goto L50;
            case 37: goto L36;
            case 38: goto L12;
            default: goto L169;
        };
    L36:
        com.bytedance.android.livesdk.message.linker.g r18 = r14.getLinkerEnlargeGuestReplyContent();
        if (r18 == null) goto L155;
        TalkRoomBusinessFullLinkMonitor r19 = TalkRoomBusinessFullLinkMonitor.a;
        long r20 = r14.getMessageId3();
        r19.getClass();
        TalkRoomBusinessFullLinkMonitor.k0(r20, r18);
        if (r18.getReplyType() != CPositionReplyType.Reject.getValue()) goto L156;
        String r21 = r18.getReplyPrompts();
        if (r21 != null) goto L43;
    L46:
        if (r4 == true) goto L48;
        f2.c(r18.getReplyPrompts(), 0);
        return;
    L48:
        f2.b(2131922714, 0);
        return;
    L43:
        if (r21.length() == 0) goto L46;
        r4 = false;
        goto L46
    L156:
        return;
    L155:
        return;
    L169:
        return;
    L12:
        if (isEngineOn() == false) goto L170;
        com.bytedance.android.livesdk.message.linker.f r22 = r14.getLinkerEnlargeGuestApplyContent();
        if (r22 == null) goto L151;
        String r110 = r22.getFromUidStr();
        if (r110 == null) goto L171;
        CPositionBeInvitedDialog r23 = this.W;
        if (r23 != null) goto L22;
    L31:
        FragmentActivity r25 = ContextUtil.contextToFragmentActivity(getContext());
        if (r25 == null) goto L152;
        FragmentManager r26 = r25.getSupportFragmentManager();
        if (r26 == null) goto L153;
        int r27 = CPositionBeInvitedDialog.o;
        CPositionBeInvitedDialog r28 = CPositionBeInvitedDialog.a.a(CPositionBeInvitedDialog.ShowType.Apply, getMRoom().getRoomId(), CPositionBeInvitedDialog.RoomType.Video, true, r110, r14, ((Widget) this).dataCenter);
        this.W = r28;
        Lq(r28, r26);
        return;
    L153:
        return;
    L152:
        return;
    L22:
        if (r23.isShowing() != true) goto L31;
        CPositionBeInvitedDialog r29 = this.W;
        if (r29 == null) goto L31;
        r29.dismissAllowingStateLoss();     // Catch: Exception -> L27
    L27:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r30 = DialogFragmentLancet.sLastShowStack;
        if (r30 == null) goto L31;
        com.bytedance.crash.d.d(r30, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L31
    L171:
        return;
    L151:
        return;
    L170:
        return;
    L50:
        if (isEngineOn() == true) goto L53;
        return;
    L53:
        if (r14.getLinkerEnlargeGuestInviteContent() == null) goto L173;
        CPositionBeInvitedDialog r31 = this.W;
        if (r31 != null) goto L58;
    L67:
        FragmentActivity r32 = ContextUtil.contextToFragmentActivity(getContext());
        if (r32 == null) goto L159;
        FragmentManager r33 = r32.getSupportFragmentManager();
        if (r33 == null) goto L160;
        int r34 = CPositionBeInvitedDialog.o;
        CPositionBeInvitedDialog.ShowType r35 = CPositionBeInvitedDialog.ShowType.Invite;
        long r36 = getMRoom().getRoomId();
        CPositionBeInvitedDialog.RoomType r111 = CPositionBeInvitedDialog.RoomType.Video;
        com.bytedance.android.livesdk.message.linker.k r37 = r14.getLinkerEnlargeGuestInviteContent();
        if (r37 == null) goto L74;
        String r38 = com.bytedance.android.livesdk.message.linker.l.a(r37);
    L75:
        CPositionBeInvitedDialog r39 = CPositionBeInvitedDialog.a.a(r35, r36, r111, true, r38, r14, ((Widget) this).dataCenter);
        this.W = r39;
        Lq(r39, r33);
        return;
    L74:
        r38 = "0";
        goto L75
    L160:
        return;
    L159:
        return;
    L58:
        if (r31.isShowing() != true) goto L67;
        CPositionBeInvitedDialog r40 = this.W;
        if (r40 == null) goto L67;
        r40.dismissAllowingStateLoss();     // Catch: Exception -> L63
    L63:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r41 = DialogFragmentLancet.sLastShowStack;
        if (r41 == null) goto L67;
        com.bytedance.crash.d.d(r41, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L67
    L173:
        return;
    L106:
        DataCenter r42 = ((Widget) this).dataCenter;
        if (r42 == null) goto L109;
        String r43 = (String) r42.get("data_room_unique_id", "");
    L110:
        tc0.c.i(r43).O = r14.getLinkerResumeAudienceContent();
        DataCenter r44 = ((Widget) this).dataCenter;
        if (r44 == null) goto L113;
        String r45 = (String) r44.get("data_room_unique_id", "");
    L115:
        if (tc0.c.i(r45).O == null) goto L164;
        ar();
        com.bytedance.android.live.liveinteract.plantform.datamerge.d r46 = md();
        DataCenter r47 = ((Widget) this).dataCenter;
        if (r47 == null) goto L119;
        r8 = (String) r47.get("data_room_unique_id", "");
    L119:
        r46.i1(tc0.c.i(r8).O);
        return;
    L164:
        return;
    L113:
        r45 = null;
        goto L115
    L109:
        r43 = null;
        goto L110
    L121:
        if ((r24 instanceof ILinkmicEnlargeGuestMessage) == false) goto L166;
        ILinkmicEnlargeGuestMessage r48 = (ILinkmicEnlargeGuestMessage) r24;
        if (r48.getTurn_on_content() == null) goto L135;
        f6 r49 = r48.getTurn_on_content();
        if (r49 == null) goto L127;
        r3 = r49.getSource();
    L127:
        this.p1 = r3;
        f6 r50 = r48.getTurn_on_content();
        if (r50 == null) goto L133;
        String r51 = r50.getTrackingData();
        if (r51 == null) goto L133;
        r2 = r51;
    L133:
        this.v1 = r2;
        return;
    L135:
        if (r48.getTurn_off_content() == null) goto L168;
        e6 r52 = r48.getTurn_off_content();
        if (r52 == null) goto L139;
        r3 = r52.getSource();
    L139:
        this.p1 = r3;
        e6 r53 = r48.getTurn_off_content();
        if (r53 == null) goto L145;
        String r54 = r53.getTrackingData();
        if (r54 == null) goto L145;
        r2 = r54;
    L145:
        this.v1 = r2;
        return;
    L168:
        return;
    }

    @Override // rj0.k
    public final void onSwitchSceneMessage(z0 r19) {
        Intrinsics.checkNotNullParameter(r19, "msg");
        com.bytedance.android.live.liveinteract.multianchor.model.b r0 = (com.bytedance.android.live.liveinteract.multianchor.model.b) r19.castTo(com.bytedance.android.live.liveinteract.multianchor.model.b.class);
        boolean r1 = gh0.b.a;
        gh0.b.a("SceneOrUiLayoutChange", "onSwitchSceneMessage: messageId = " + r0.getMessageId2() + ", scene = " + r0.getScene() + ", ui_layout = " + r0.getUiLayout(), false);
        int r2 = (int) r0.getScene();
        int r3 = r0.getUiLayout();
        if (r2 == 8) goto L5;
    L7:
        v1 r5 = (v1) vh7.f.c(v1.class);
        r5.setScene(r0.getValidScene());
        r5.setPlayModes(r0.getPlayModes());
        r5.setUiLayout(r3);
        r5.setLinkedUsers(r0.getLinkedListUsers());
        r5.setVersion(r0.getVersion());
        r5.setMultiLiveCoreInfo(r0.getMultiLiveCoreInfo());
        r5.setMultiRtcInfo(r0.getMultiRtcInfo());
        r5.setLiveCoreExtInfo(r0.getLiveCoreExtInfo());
        r5.setRtcExtInfo(r0.getRtcExtInfo());
        r5.setLinkerContentMap(r0.getLinkerContentMap());
        r5.setMcuContent(r0.getMcuContent());
        r5.setClientUiInfo(r0.getClientUIInfo());
        String r7 = r0.getTrackingData();
        if (r7 != null) goto L10;
        r7 = "";
    L10:
        this.v1 = r7;
        int r8 = r5.getScene();
        int r9 = r5.getUiLayout();
        boolean r11 = true;
        if (this.y == true) goto L17;
        if (r8 != 8) goto L17;
        if (r9 != 1) goto L17;
        if (((IInteractService) jc1.k.n(IInteractService.class)).dynamicFromAudience() == false) goto L17;
        this.A = true;
    L17:
        com.bytedance.android.live.liveinteract.plantform.base.g r4 = com.bytedance.android.live.liveinteract.plantform.base.f.a();
        if (r4 == null) goto L20;
        r4.yg(r5.getScene(), r5.getUiLayout(), r5.getPlayModes());
    L20:
        com.bytedance.live.datacontext.j r6 = com.bytedance.android.live.liveinteract.api.utils.m.e(this).getVideoTalkRoomSubScene();
        if (r6 == null) goto L28;
        com.bytedance.android.livesdk.chatroom.viewmodel.e r10 = (com.bytedance.android.livesdk.chatroom.viewmodel.e) r6.getValue();
        if (r10 == null) goto L28;
        com.bytedance.android.livesdk.chatroom.viewmodel.j r12 = r10.t();
        if (r12 == null) goto L28;
        List<Integer> r13 = r12.b;
        if (r13 == null) goto L28;
    L29:
        zj0.e r14 = this.V0;
        if (r14 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("layoutSwitcher");
    L33:
        if (r14.c(r2, r3, r13, r5.getPlayModes()) == false) goto L48;
        List<com.bytedance.android.livesdk.link.model.bridge.k> r15 = r0.getLinkedListUsers();
        if (r15 == null) goto L45;
        yq().S4(r15, r0.getClientUIInfo(), r0.getVersion(), "switchSceneMsg");
        StringBuilder r16 = new StringBuilder("onSwitchSceneMessage#isSameLayout: \n multiLiveCoreInfo = ");
        if (r5.getMultiLiveCoreInfo() == null) goto L39;
        boolean r17 = true;
    L40:
        r16.append(r17);
        r16.append("\n liveCoreExtInfo = ");
        r16.append(r5.getLiveCoreExtInfo());
        r16.append("\n multiRtcInfo = ");
        if (r5.getMultiRtcInfo() != null) goto L44;
        r11 = false;
    L44:
        r16.append(r11);
        r16.append("\n rtcExtInfo = ");
        r16.append(r5.getRtcExtInfo());
        gh0.b.a("RtcParamsUpdate", r16.toString(), false);
        br(r5.getMultiLiveCoreInfo(), r5.getMultiRtcInfo(), r5.getLiveCoreExtInfo(), r5.getRtcExtInfo(), r5.getMcuContent());
        u8("");
        goto L45
    L39:
        r17 = false;
    L45:
        jy0.b.f("ttlive_link_video", "onSwitchSceneMessage already same layout, current=" + Mq() + ' ' + Qq(), null, 4);
        return;
    L48:
        if (vm2.d.v0() == false) goto L50;
        com.bytedance.android.live.liveinteract.plantform.utils.i.g(r0);
    L50:
        Yi(r5, "switchSceneMessage", null);
        return;
    L28:
        r13 = CollectionsKt.emptyList();
        goto L29
    L5:
        if (r3 != 52) goto L7;
        r3 = 7;
        goto L7
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.MultiLinkBaseAnchorLinkWidget, com.bytedance.android.live.liveinteract.plantform.core.v
    public final void onUserJoined(String r2) {
        Intrinsics.checkNotNullParameter(r2, "interactId");
        Intrinsics.checkNotNullParameter(r2, "s");
        Intrinsics.checkNotNullParameter(r2, "s");
        tf0.o r3 = this.E;
        if (r3 == null) goto L6;
        r3.i();
        return;
    }

    @Override // rj0.k
    public final void permit(ILinkPlayerInfoBridge r3) {
        Intrinsics.checkNotNullParameter(r3, "linkPlayerInfo");
        com.bytedance.live.bizlink.impl.platform.manager.a r0 = zq().A0();
        if (r0 == null) goto L5;
        IBaseUser r1 = r3.getUser();
        Intrinsics.checkNotNull(r1);
        r0.j(r1);
    L5:
        Jq(true);
        r3.getUserPosition();
    }

    @Override // rj0.k
    public final void setInviteCallback(uf0.c r1) {
        this.t = r1;
    }

    @Override // rj0.k
    public final void setPermitCallback(uf0.d r1) {
        this.s = r1;
    }

    @Override // rj0.k
    public final void u5(ILinkerClientUIInfoChangeContent r13) {
        if (r13 == null) goto L6;
        Long r0 = r13.getUiLayout();
        if (r0 == null) goto L6;
        int r1 = (int) r0.longValue();
    L7:
        com.bytedance.live.datacontext.j r2 = com.bytedance.android.live.liveinteract.api.utils.m.e(this).getVideoTalkRoomSubScene();
        ClientUIInfo r10 = null;
        if (r2 == null) goto L23;
        com.bytedance.android.livesdk.chatroom.viewmodel.e r3 = (com.bytedance.android.livesdk.chatroom.viewmodel.e) r2.getValue();
        if (r3 == null) goto L23;
        if (r1 == r3.t().c) goto L18;
        r3.c(r3.t());
        List<Integer> r4 = je0.d.d();
        if (r13 == null) goto L16;
        ClientUIInfo r7 = r13.getClientUIInfo();
    L17:
        r3.e(new com.bytedance.android.livesdk.chatroom.viewmodel.j(8, r4, r1, false, r7, false, 40));
        goto L23
    L16:
        r7 = null;
        goto L17
    L18:
        com.bytedance.android.livesdk.chatroom.viewmodel.j r5 = r3.t();
        if (r13 == null) goto L21;
        ClientUIInfo r6 = r13.getClientUIInfo();
    L22:
        r5.e = r6;
        goto L23
    L21:
        r6 = null;
    L23:
        sh0.i0 r8 = sh0.j0.a(((Widget) this).dataCenter);
        if (r8 == null) goto L30;
        sh0.d r9 = sh0.d.b;
        Integer r11 = Integer.valueOf(r1);
        if (r13 == null) goto L28;
        r10 = r13.getClientUIInfo();
    L28:
        r8.d0(r9, new sh0.h(r11, r10));
        return;
    L30:
        return;
    L6:
        r1 = 0;
        goto L7
    }

    public final void u8(String r5) {
        Intrinsics.checkNotNullParameter(r5, "from");
        jy0.b.d("ttlive_link_video", "updateLiveCoreRtcInfo " + r5);
        Mq();
        com.bytedance.live.datacontext.j r0 = com.bytedance.android.live.liveinteract.api.utils.m.e(this).getVideoTalkRoomSubScene();
        tc0.c r1 = null;
        if (r0 == null) goto L7;
        com.bytedance.android.livesdk.chatroom.viewmodel.e r2 = (com.bytedance.android.livesdk.chatroom.viewmodel.e) r0.getValue();
        if (r2 == null) goto L7;
        com.bytedance.android.livesdk.chatroom.viewmodel.j r3 = r2.t();
    L8:
        if (r3 != null) goto L10;
    L11:
        CollectionsKt.emptyList();
    L12:
        boolean r4 = false;
        if (r3 == null) goto L15;
        int r6 = r3.c;
    L17:
        if ((this.E instanceof CommonMultiLinkWindowManager) == true) goto L19;
    L21:
        tc0.c r7 = this.E;
        boolean r8 = r7 instanceof DynamicEqualMultiLinkWindowManager;
        if (r8 == false) goto L29;
        if (r8 == false) goto L26;
        r1 = r7;
    L26:
        DynamicEqualMultiLinkWindowManager r9 = (DynamicEqualMultiLinkWindowManager) r1;
        if (r9 == null) goto L57;
        r9.q1();
        return;
    L57:
        return;
    L29:
        tc0.c r10 = this.o;
        if ((r10 instanceof tc0.c) == false) goto L33;
        r1 = r10;
    L33:
        tc0.c r11 = r1;
        if (r11 == null) goto L59;
        String r12 = r11.k;
        if (r12 != null) goto L38;
    L41:
        boolean r13 = true;
    L42:
        if (r13 == true) goto L46;
        hg6.g r14 = R1();
        if (r14 == null) goto L46;
        r14.c(r11.k);
    L46:
        String r15 = r11.m;
        if (r15 != null) goto L49;
    L50:
        r4 = true;
    L51:
        if (r4 == true) goto L60;
        hg6.g r16 = R1();
        if (r16 == null) goto L61;
        r16.J(r11.m);
        return;
    L61:
        return;
    L60:
        return;
    L49:
        if (r15.length() != 0) goto L51;
    L38:
        if (r12.length() == 0) goto L41;
        r13 = false;
        goto L42
    L59:
        return;
    L19:
        if (uh0.a.a.contains(String.valueOf(r6)) == false) goto L21;
        commonWMUpdateLiveCoreAndRtcInfo(r5);
        return;
    L15:
        r6 = 0;
        goto L17
    L10:
        if (r3.b != null) goto L12;
    L7:
        r3 = null;
        goto L8
    }

    @Override // rj0.k
    public final void updateFullScreenDialogShowStatus(boolean r5) {
        ALogger.i("[VideoTalk]VideoTalkRoomAnchorWidget", "updateFullScreenDialogShowStatus isShow=" + r5 + ", isBackground=" + this.I);
        if (r5 == true) goto L5;
    L7:
        if (r5 == false) goto L9;
        return;
    L9:
        if (this.I == false) goto L14;
        this.v.U0(new uv0.a(LiveRequestSourceRole.Business, "MultiLinkVideoTalkRoomAnchorWidget.updateFullScreenDialogShowStatus.start", null));
        onResume();
        return;
    L14:
        return;
    L5:
        if (this.I == true) goto L7;
        this.v.k1(new uv0.a(LiveRequestSourceRole.Business, "MultiLinkVideoTalkRoomAnchorWidget.updateFullScreenDialogShowStatus.stop", null));
        onPause();
    }

    @Override // rj0.k
    public final boolean userIsCPosition(String r6) {
        Intrinsics.checkNotNullParameter(r6, "uid");
        CPositionContext r0 = CPositionContext.Companion.getContext();
        if (r0 == null) goto L28;
        com.bytedance.live.datacontext.m<Boolean> r1 = r0.isCPositionOpen();
        if (r1 != null) goto L7;
        return false;
    L7:
        if (((Boolean) r1.getValue()).booleanValue() != true) goto L30;
        com.bytedance.android.live.liveinteract.plantform.core.y r2 = yq();
        if (r2 == null) goto L31;
        CopyOnWriteArrayList<ILinkPlayerInfoBridge> r3 = r2.c;
        if (r3 == null) goto L32;
        Iterator<T> r4 = r3.iterator();
    L13:
        Object r5 = null;
        if (r4.hasNext() == false) goto L21;
        Object r7 = r4.next();
        IBaseUser r8 = ((ILinkPlayerInfoBridge) r7).getUser();
        if (r8 == null) goto L19;
        r5 = r8.getIdString();
    L19:
        if (Intrinsics.areEqual(r5, r6) == false) goto L13;
        r5 = r7;
    L21:
        ILinkPlayerInfoBridge r9 = (ILinkPlayerInfoBridge) r5;
        if (r9 != null) goto L24;
        return false;
    L24:
        return r9.isEnlarged();
    L32:
        return false;
    L31:
        return false;
    L30:
        return false;
    L28:
        return false;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.MultiLinkBaseAnchorLinkWidget, com.bytedance.android.live.liveinteract.plantform.core.v
    public final void wf(String r2) {
        com.bytedance.android.live.liveinteract.plantform.utils.u r0 = this.H1;
        if (r0 == null) goto L6;
        r0.l(r2);
        return;
    }

    @Override // rj0.i
    public final ti6.j x(fi6.a r4) {
        he0.c r0 = new he0.c(this, this);
        this.q = r0;
        r0.d = r4;
        j1 r5 = r0.c;
        if (r5 == null) goto L8;
        dn0.c r6 = (dn0.c) r5.getScopeServiceOrNullInMultiLinkRoom(dn0.c.class);
        if (r6 == null) goto L8;
        r6.Se("rtc_init", "VideoTalkRoomStreamMixer_setConfig", false);
    L8:
        return this.q;
    }

    public static void Lq(CPositionBeInvitedDialog r2, FragmentManager r3) {
        LandscapeRestrictionOperation r0 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r2, "VideoTalkCPositionBeInvitedDialog", r0);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r3, r2, r0) == false) goto L9;
        return;
    L9:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
    L6:
        r2.show(r3, "VideoTalkCPositionBeInvitedDialog");
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.MultiLinkBaseAnchorLinkWidget, com.bytedance.android.live.liveinteract.plantform.core.v
    public final void A(String r3, Boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "interactId");
        super.A(r3, r4);
        tf0.o r0 = this.E;
        if (r0 == null) goto L5;
        r0.c(r3, Intrinsics.areEqual(r4, Boolean.TRUE));
    L5:
        hg6.g r5 = R1();
        if (r5 == null) goto L9;
        r5.f();
        return;
    }

    @Override // yj0.a.InterfaceC0294a
    public final void F(String r2, Throwable r3) {
        Intrinsics.checkNotNullParameter(r2, "toUserId");
        ExceptionUtils.handleException(((Widget) this).context, r3, 2131919335);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.videolink.MultiLinkVideoBaseAnchorLinkWidget, com.bytedance.android.live.liveinteract.plantform.widgt.MultiLinkBaseAnchorLinkWidget, com.bytedance.android.live.liveinteract.plantform.core.v
    public final void G9(long r4, Exception r6) {
        if (this.K == false) goto L7;
        this.K = false;
        gd0.d r5 = this.L;
        if (r5 == null) goto L12;
        r5.onFailed(2);
        return;
    L12:
        return;
    L7:
        DataCenter r0 = ((Widget) this).dataCenter;
        if (r0 == null) goto L10;
        r0.put("cmd_audience_turn_off_engine", Boolean.FALSE);
    L10:
        boolean r1 = com.bytedance.android.live.revenue.core.util.h.a;
        com.bytedance.android.live.revenue.core.util.h.d(kc0.j.class).notifyAudienceEngineEvent();
        super.G9(r4, r6);
    }

    @Override // rj0.k
    public final void Kh(String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "toUserId");
        Intrinsics.checkNotNullParameter(r4, "secToUid");
        Intrinsics.checkNotNullParameter(r3, "toUserId");
        Intrinsics.checkNotNullParameter(r4, "toSecUid");
        IBaseUser r0 = vh7.f.c(IBaseUser.class);
        r0.setIdString(r3);
        Intrinsics.checkNotNullParameter(r0, "$this$secUidExt");
        r0.setCastSecUid(r4);
        xf6.a r5 = Gq();
        if (r5 == null) goto L6;
        r5.d(r0, "anchor_stop_normal");
        return;
    }

    @Override // rj0.k
    public final void Qj(String r6, String r7) {
        Intrinsics.checkNotNullParameter(r6, "userId");
        com.bytedance.android.live.liveinteract.plantform.core.y r0 = yq();
        if (r0 == null) goto L5;
        ILinkPlayerInfoBridge r8 = r0.o(r6, "");
    L6:
        if (r8 == null) goto L19;
        Context r1 = ((Widget) this).context;
        DataCenter r2 = ((Widget) this).dataCenter;
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r2, "dataCenter");
        Intrinsics.checkNotNullParameter(r8, "userInfo");
        if (r7 != null) goto L10;
        r7 = "seat";
    L10:
        Intrinsics.checkNotNullParameter(r7, "requestPage");
        if (hg6.i.a() == false) goto L13;
        ih0.d r3 = com.bytedance.android.live.liveinteract.videotalk.utils.panel.a.j;
        com.bytedance.android.live.liveinteract.videotalk.utils.panel.a.u(r8, r7, false);
    L17:
        r3.a();
        return;
    L13:
        VideoTalkInteractEmojiPanel r4 = new VideoTalkInteractEmojiPanel(r1, r2, r8);
        Intrinsics.checkNotNullParameter(r7, "<set-?>");
        r4.k = r7;
        r4.r = false;
        tb6.c r9 = r4.x;
        if (r9 == null) goto L16;
        r9.a();
        Intrinsics.checkNotNullParameter(r7, "requestPage");
        r9.d = r7;
    L16:
        r3 = r4;
        goto L17
    L19:
        return;
    L5:
        r8 = null;
        goto L6
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.MultiLinkBaseAnchorLinkWidget, com.bytedance.android.live.liveinteract.plantform.core.v
    public final void T6(String r1, zf2.s0 r2) {
        com.bytedance.android.live.liveinteract.plantform.utils.u r3 = this.H1;
        if (r3 == null) goto L6;
        r3.m(r1);
        return;
    }

    public final void Wq(String r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "interactId");
        jg6.a r5 = Bq();
        if (r5 == null) goto L7;
        kg6.e r6 = r5.b();
        if (r6 == null) goto L7;
        r6.h(r3, true, "room battle mcu");
    L7:
        hg6.g r7 = R1();
        if (r7 == null) goto L11;
        r7.f();
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.MultiLinkBaseAnchorLinkWidget, com.bytedance.android.live.liveinteract.plantform.core.v
    public final void Xi(int r2, int r3) {
        VideoEffectPerfHelper r0 = this.L1;
        if (r0 == null) goto L6;
        r0.e(r2, r3);
        return;
    }

    @Override // rj0.n
    public final void a(View r2, MotionEvent r3) {
        Intrinsics.checkNotNullParameter(r2, "v");
        Intrinsics.checkNotNullParameter(r3, "event");
        tf0.o r0 = this.E;
        if (r0 == null) goto L6;
        r0.a(r2, r3);
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.MultiLinkBaseAnchorLinkWidget, com.bytedance.android.live.liveinteract.plantform.core.v
    public final void al(String r2, int r3) {
        com.bytedance.android.live.liveinteract.plantform.utils.u r0 = this.H1;
        if (r0 == null) goto L6;
        r0.n(r2, r3);
        return;
    }

    @Override // tf0.o.a
    public final void ca(String r4, String r5) {
        gh0.b.a("RtcParamsUpdate", "updateLiveCoreAndRtcInfo: \nrtcExtInfo = " + r4 + ", \nliveCoreExtInfo = " + r5, false);
        if (r5 == null) goto L7;
        hg6.g r0 = R1();
        if (r0 == null) goto L7;
        r0.J(r5);
    L7:
        if (r4 == null) goto L12;
        hg6.g r6 = R1();
        if (r6 == null) goto L13;
        r6.c(r4);
        return;
    L13:
        return;
    }

    @Override // rj0.k
    public final void closeMultiEnlargePosition(long r6, List<String> r8) {
        Intrinsics.checkNotNullParameter(r8, "kickOutUserIdList");
        StringBuilder r0 = new StringBuilder();
        Iterator<String> r9 = r8.iterator();
    L4:
        if (r9.hasNext() == false) goto L6;
        r0.append(r9.next() + ',');
        goto L4
    L6:
        Ref.ObjectRef r10 = new Ref.ObjectRef();
        String r1 = r0.toString();
        r10.element = r1;
        if (StringsKt.endsWith$default(r1, ",", false, 2, null) == false) goto L13;
        String r2 = (String) r10.element;
        int r3 = r2.length() - 1;
        if (r2 == null) goto L12;
        r10.element = r2.substring(0, r3);
        goto L13
    L12:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L13:
        com.bytedance.android.live.liveinteract.plantform.utils.i0 r4 = TalkRoomLogUtils.a;
        TalkRoomLogUtils.W(true, "all_cancel");
        TalkRoomBusinessFullLinkMonitor r5 = TalkRoomBusinessFullLinkMonitor.a;
        String r7 = (String) r10.element;
        r5.getClass();
        TalkRoomBusinessFullLinkMonitor.p(r7);
        long r11 = System.currentTimeMillis();
        LinkAudienceApi r12 = (LinkAudienceApi) com.bytedance.android.live.network.c.b().e(LinkAudienceApi.class);
        String r13 = (String) r10.element;
        this.m.add(r12.closeCPosition(r6, r13, r13).compose(RxUtil.rxSchedulerHelper()).subscribe(new d(r10, r11), new e(this, r10, r11)));
    }

    @Override // tf0.o.a
    public final void d0(tf0.p r2, Object r3) {
        Intrinsics.checkNotNullParameter(r2, "action");
        sh0.i0 r0 = this.w;
        if (r0 == null) goto L6;
        r0.d0(r2, r3);
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.MultiLinkBaseAnchorLinkWidget, com.bytedance.android.live.liveinteract.plantform.core.v
    public final void e1(String r1, long r2) {
        super.e1(r1, r2);
        this.k0.remove(r1);
        tf0.o r3 = this.E;
        if (r3 == null) goto L6;
        r3.t(r1);
        return;
    }

    public final void er(boolean r5, String r6) {
        IKtvService r0 = jc1.k.f(IKtvService.class);
        if (r0 == null) goto L5;
        boolean r1 = r0.isInKtvState(1);
    L6:
        sh0.i0 r3 = sh0.j0.a(((Widget) this).dataCenter);
        if (r3 != null) goto L9;
    L17:
        boolean r4 = false;
    L18:
        if (r1 == true) goto L20;
        if (r4 == true) goto L20;
    L26:
        this.h1 = r5;
        if (r5 == false) goto L33;
        jg6.a r7 = Bq();
        if (r7 == null) goto L42;
        kg6.e r8 = r7.b();
        if (r8 == null) goto L43;
        r8.z(new kg6.d(false, true, r6, 8));
        return;
    L43:
        return;
    L42:
        return;
    L33:
        jg6.a r9 = Bq();
        if (r9 == null) goto L45;
        kg6.e r10 = r9.b();
        if (r10 == null) goto L46;
        r10.t(new kg6.b(false, true, r6, 8));
        return;
    L46:
        return;
    L45:
        return;
    L20:
        if (r5 == true) goto L26;
        InteractLinkFullLinkMonitor.k0(r5, "in_ktv_state:".concat(r6));
        hg6.g r2 = R1();
        if (r2 == null) goto L39;
        pf6.a r11 = r2.f0();
        if (r11 == null) goto L40;
        r11.c(!r5, r6);
        return;
    L40:
        return;
    L39:
        return;
    L9:
        if (r3.g() != true) goto L17;
        IGameDataService r12 = com.bytedance.android.live.liveinteract.api.utils.m.a();
        if (r12 == null) goto L17;
        com.bytedance.live.datacontext.m r13 = r12.getXplayRunning();
        if (r13 == null) goto L17;
        if (((Boolean) r13.getValue()).booleanValue() != true) goto L17;
        r4 = true;
        goto L18
    L5:
        r1 = false;
        goto L6
    }

    @Override // rj0.k
    public final void g2(int r4, int r5) {
        com.bytedance.live.bizlink.impl.platform.manager.a r0 = zq().A0();
        if (r0 == null) goto L6;
        r0.i(getMRoom().getId(), r4, r5);
        return;
    }

    @Override // rj0.k
    public final void j6(boolean r3, String r4) {
        jy0.b.d("ttlive_link_video", "enableDynamic " + r3 + " reason=" + r4 + "  scene:" + je0.d.f());
        int r5 = je0.d.f();
        if (r5 != 8) goto L5;
        if (r3 == false) goto L12;
        int r6 = 7;
    L13:
        rj0.k.b.f(this, r5, Integer.valueOf(r6), "enableDynamic", true);
        return;
    L12:
        r6 = 1;
        goto L13
    L5:
        if (r5 == 12) goto L7;
        r6 = 0;
        goto L13
    L7:
        if (r3 == false) goto L9;
        r6 = 2;
        goto L13
    L9:
        r6 = 5;
        goto L13
    }

    @Override // tf0.o.a
    public final void kd(String r5, String r6) {
        Intrinsics.checkNotNullParameter(r6, "source");
        jy0.b.a(LinkRoomFightContext.TAG, "livecore version " + ((IMiddlewareBroadcastService) va1.b.a.a.a(IMiddlewareBroadcastService.class)).getLiveCoreVersion());
        StringBuilder r0 = new StringBuilder("stopPlayPublicStream isEngineOn: ");
        hg6.g r2 = R1();
        Integer r3 = null;
        if (r2 == null) goto L5;
        Boolean r4 = Boolean.valueOf(r2.isEngineOn());
    L6:
        r0.append(r4);
        r0.append(" id ");
        r0.append(r5);
        jy0.b.a(LinkRoomFightContext.TAG, r0.toString());
        if (r5 != null) goto L9;
        return;
    L9:
        hg6.g r1 = R1();
        if (r1 == null) goto L14;
        xi0.b r7 = r1.O();
        if (r7 == null) goto L14;
        r3 = Integer.valueOf(r7.k(r5));
    L14:
        zi0.b.f(r5, r3, r6);
        jy0.b.a(LinkRoomFightContext.TAG, "stopPlayPublicStream result " + r3);
        return;
    L5:
        r4 = null;
        goto L6
    }

    @Override // rj0.k
    public final void onChangeMediaInfo(ILinkerChangeMediaInfoContent r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "info");
        ILinkmicMediaParam r0 = r4.getLinkmicMediaParam();
        if (r0 != null) goto L5;
        return;
    L5:
        List r6 = r4.getPlayModeList();
        if (r6 != null) goto L8;
        return;
    L8:
        if ((!r6.isEmpty()) == true) goto L10;
        return;
    L10:
        if (r6.contains(21) == false) goto L35;
        r0 r7 = r0.getKtvComponentMediaInfo();
        if (r7 == null) goto L36;
        String r1 = r7.getLiveCoreExtInfo();
        if (r1 != null) goto L16;
        return;
    L16:
        if (r1.length() <= 0) goto L18;
        boolean r2 = true;
    L19:
        if (r2 != true) goto L38;
        if (r5 <= 0) goto L24;
        hg6.g r3 = R1();
        if (r3 == null) goto L24;
        r3.I(r5);
    L24:
        hg6.g r8 = R1();
        if (r8 == null) goto L27;
        r8.J(r7.getLiveCoreExtInfo());
    L27:
        hg6.g r9 = R1();
        if (r9 == null) goto L39;
        ig6.a r10 = r9.x();
        if (r10 == null) goto L40;
        r10.a(MultiLinkInfoType.KTV_COMPONENT, new ig6.b(r7.getLiveCoreExtInfo(), null));
        return;
    L40:
        return;
    L39:
        return;
    L38:
        return;
    L18:
        r2 = false;
        goto L19
    L36:
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.videolink.MultiLinkVideoBaseAnchorLinkWidget, he0.c.a
    public final int q0(List<ti6.f> r7, Map<String, Integer> r8) {
        Intrinsics.checkNotNullParameter(r7, "list");
        Intrinsics.checkNotNullParameter(r8, "posMap");
        if (r7.isEmpty() == false) goto L6;
        return 0;
    L6:
        if (com.bytedance.android.live.liveinteract.linkpanel.util.o.d() != 63) goto L21;
        IKtvService r0 = jc1.k.f(IKtvService.class);
        if (r0 == null) goto L12;
        fd2.w r1 = r0.getVideoChorusService();
        if (r1 == null) goto L12;
        fd2.n r2 = r1.m1();
    L13:
        Iterator<ti6.f> r3 = r7.iterator();
    L15:
        if (r3.hasNext() == false) goto L21;
        ti6.f r4 = r3.next();
        if (r2 == null) goto L19;
        int r5 = r2.a(r4.b);
    L20:
        r4.h = r5;
        goto L15
    L19:
        r5 = 100;
    L12:
        r2 = null;
    L21:
        tf0.o r6 = this.E;
        if ((r6 instanceof BaseMultiLinkWindowManager) == false) goto L27;
        if (r6 == null) goto L26;
        int r9 = BaseMultiLinkWindowManager.H;
        return ((BaseMultiLinkWindowManager) r6).D0(r7, r8, null);
    L26:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.BaseMultiLinkWindowManager");
    L27:
        return 0;
    }

    @Override // yj0.a.InterfaceC0294a
    public final void r(String r2, Throwable r3) {
        Intrinsics.checkNotNullParameter(r2, "toUserId");
        if ((r3 instanceof ApiServerException) == false) goto L6;
        f2.c(((ApiServerException) r3).getPrompt(), 0);
        return;
    }

    @Override // tf0.o.a
    public final void r1(String r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "interactId");
        jg6.a r0 = Bq();
        if (r0 == null) goto L8;
        lh6.b r1 = r0.a();
        if (r1 == null) goto L9;
        r1.f(r3, r4, "muteRemoteVideoStream by video talk anchor widget");
        return;
    L9:
        return;
    }

    @Override // tf0.o.a
    public final void v4(String r4, boolean r5) {
        StringBuilder r0 = new StringBuilder("#PublicStreamMix# setPublicStreamVideoSink isEngineOn: ");
        hg6.g r1 = R1();
        if (r1 == null) goto L5;
        Boolean r2 = Boolean.valueOf(r1.isEngineOn());
    L6:
        r0.append(r2);
        r0.append(" id ");
        r0.append(r4);
        r0.append(" openMixer ");
        r0.append(r5);
        jy0.b.a(LinkRoomFightContext.TAG, r0.toString());
        if (r4 != null) goto L9;
    L14:
        hg6.g r3 = R1();
        if (r3 == null) goto L19;
        xi0.b r6 = r3.O();
        if (r6 == null) goto L19;
        r6.v4(String.valueOf(r4), r5);
    L19:
        jy0.b.a(LinkRoomFightContext.TAG, "#PublicStreamMix# setPublicStreamVideoSink result null");
        return;
    L9:
        if (r4.length() != 0) goto L11;
        boolean r7 = true;
    L12:
        if (r7 != true) goto L14;
        return;
    L11:
        r7 = false;
        goto L12
    L5:
        r2 = null;
        goto L6
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.MultiLinkBaseAnchorLinkWidget
    public final void v5(IBaseUser r3, List<? extends e1> r4) {
        Intrinsics.checkNotNullParameter(r3, "user");
        com.bytedance.android.live.liveinteract.plantform.core.y r5 = yq();
        String r6 = r3.getIdString();
        r5.getClass();
        Intrinsics.checkNotNullParameter(r6, "uid");
        if (r2.a(r6) == true) goto L7;
        Map<String, Long> r7 = r5.p;
        HashMap r8 = (HashMap) r7;
        r8.put(r6, Long.valueOf(SystemClock.elapsedRealtime()));
        return;
    }

    @Override // rj0.k
    public final void z0(boolean r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, "emptySeatUrl");
        tf0.o r0 = this.E;
        if (r0 == null) goto L6;
        r0.z0(r2, r3);
        return;
    }

    public MultiLinkVideoTalkRoomAnchorWidget(v0 r2, com.bytedance.android.live.pushstream.d r3, tc0.c r4) {
        Intrinsics.checkNotNullParameter(r2, "videoClientFactory");
        Intrinsics.checkNotNullParameter(r3, "liveStream");
        Intrinsics.checkNotNullParameter(r4, "dataHolder");
        super(r2, r3, r4);
        this.S = new cj0.e(true);
        this.Y = new ArrayList();
        this.Z = new ArrayList();
        this.k0 = new HashMap();
        this.p0 = new HashMap();
        new ToolbarRoomBattleBehavior();
        this.P0 = true;
        this.b1 = true;
        this.h1 = true;
        this.v1 = "";
        this.x1 = new com.bytedance.android.live.liveinteract.plantform.utils.s();
        this.G1 = new com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.u();
        this.L1 = new VideoEffectPerfHelper(true, this);
        this.M1 = new com.bytedance.android.live.liveinteract.videotalk.h(this);
        this.T1 = new com.bytedance.android.live.liveinteract.videotalk.c(this);
        this.V1 = new com.bytedance.android.live.liveinteract.videotalk.d(this);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.MultiLinkBaseAnchorLinkWidget, com.bytedance.android.live.liveinteract.plantform.core.v
    public final void J(String[] r1, boolean[] r2, int[] r3) {
        tf0.o r4 = this.E;
        if (r4 == null) goto L6;
        r4.onTalkStateUpdated(r1, r2);
        return;
    }

    @Override // rj0.k
    public final void Q5(String r3, boolean r4, MediaOperation.a r5) {
        Intrinsics.checkNotNullParameter(r3, "toUserId");
        if (r4 == false) goto L14;
        yj0.a r6 = this.H;
        if (r6 != null) goto L7;
        return;
    L7:
        if (r6.d0(true) == true) goto L9;
        return;
    L9:
        if (((Boolean) vm2.d.k0.getValue(null, vm2.d.a[60])).booleanValue() == true) goto L11;
        er(true, "unsilence");
    L11:
        yj0.a r7 = this.H;
        if (r7 == null) goto L20;
        yj0.a.h0(r7, jc1.k.n(IMiddlewareUserService.class).user().n(), r5, 4);
        return;
    L20:
        return;
    L14:
        yj0.a r8 = this.H;
        if (r8 == null) goto L22;
        r8.g0(r3, r5, false);
        return;
    }

    @Override // rj0.k, rj0.n
    public final void T1(int r7, Integer r8, String r9) {
        Cl(r7, r8, r9, false, false);
    }

    public final void Yi(v1 r26, String r27, String r28) {
        jy0.b.d("ttlive_link_video", "realSwitchScene by " + r27 + ", to:" + r26 + " current=" + Mq());
        StringBuilder r0 = new StringBuilder("realSwitchSceneByResponse: \n multiLiveCoreInfo = ");
        boolean r16 = true;
        if (r26.getMultiLiveCoreInfo() == null) goto L5;
        boolean r2 = true;
    L6:
        r0.append(r2);
        r0.append("\n liveCoreExtInfo = ");
        r0.append(r26.getLiveCoreExtInfo());
        r0.append("\n multiRtcInfo = ");
        if (r26.getMultiRtcInfo() == null) goto L9;
        boolean r3 = true;
    L10:
        r0.append(r3);
        r0.append("\n rtcExtInfo = ");
        r0.append(r26.getRtcExtInfo());
        gh0.b.a("RtcParamsUpdate", r0.toString(), false);
        int r4 = r26.getScene();
        List r19 = r26.getPlayModes();
        int r5 = r26.getUiLayout();
        List<? extends com.bytedance.android.livesdk.link.model.bridge.k> r8 = r26.getLinkedUsers();
        if (r8 == null) goto L13;
        jy0.b.d("ttlive_link_video", "realSwitchScene " + je0.d.g0(r8));
        yq().Y4(r8, r26.getClientUiInfo(), r26.getVersion(), r27, r26.getLinkerContentMap());
    L13:
        br(r26.getMultiLiveCoreInfo(), r26.getMultiRtcInfo(), r26.getLiveCoreExtInfo(), r26.getRtcExtInfo(), r26.getMcuContent());
        u8(r27);
        com.bytedance.live.datacontext.j r1 = com.bytedance.android.live.liveinteract.api.utils.m.e(this).getVideoTalkRoomSubScene();
        if (r1 == null) goto L18;
        com.bytedance.android.livesdk.chatroom.viewmodel.e r6 = (com.bytedance.android.livesdk.chatroom.viewmodel.e) r1.getValue();
        if (r6 == null) goto L18;
        r6.c(r6.t());
        r6.e(new com.bytedance.android.livesdk.chatroom.viewmodel.j(r4, r19, r5, false, r26.getClientUiInfo(), false, 40));
    L18:
        zj0.e r7 = this.V0;
        if (r7 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("layoutSwitcher");
    L21:
        r7.f(new zj0.c.a(r4, r5, r27, r28), r26.getPlayModes(), r26.getClientUiInfo());
        LinkCastAnchorWidget r9 = this.Q;
        if (r9 == null) goto L31;
        ALogger.i("LinkCastAnchorWidget", "continueStartOrStopLinkCast: needContinue = " + r9.g + " & isLinkCasting = " + r9.e);
        if (r9.g == false) goto L31;
        int r10 = com.bytedance.android.live.liveinteract.linkcast.d.a;
        boolean r11 = r9.e;
        JSONObject r12 = new JSONObject();
        r12.put("is_link_casting", String.valueOf(r11));
        nd0.c.o(nd0.c.a, LinkMonitorData.LinkCastAfterTask, r12, 0, null, false, 28);
        if (r9.e == false) goto L29;
        r9.wq();
    L30:
        r9.g = false;
        goto L31
    L29:
        r9.xq("stopAfterSwitchScene", false);
    L31:
        Integer r13 = je0.d.h();
        if (r13 != null) goto L35;
    L37:
        r16 = false;
    L38:
        if (r16 == false) goto L40;
        return;
    L40:
        if (this.V == null) goto L47;
        dr(false);
        WidgetManager r14 = ((Widget) this).subWidgetManager;
        if (r14 == null) goto L44;
        r14.unload(this.V);
    L44:
        this.V = null;
        ALogger.i("[VideoTalk]VideoTalkRoomAnchorWidget", "[video_chorus] unloadVideoChorusWidget complete");
        return;
    L47:
        return;
    L35:
        if (r13.intValue() != 63) goto L37;
    L9:
        r3 = false;
        goto L10
    L5:
        r2 = false;
        goto L6
    }

    @Override // yj0.a.InterfaceC0294a
    public final void Z(String r2, String r3, AckFromSource r4) {
        Intrinsics.checkNotNullParameter(r2, "toUserId");
        Intrinsics.checkNotNullParameter(r4, "fromSource");
        xf6.a r0 = Gq();
        if (r0 == null) goto L6;
        r0.Z(r2, r3, r4);
        return;
    }

    @Override // tf0.o.a
    public final void h(String r1, boolean r2, String r3) {
        Wq(r1, true);
    }

    @Override // rj0.k
    public final void im(String r3, boolean r4, MediaOperation.a r5) {
        Intrinsics.checkNotNullParameter(r3, "toUserId");
        if (r4 == false) goto L16;
        hg6.g r6 = R1();
        if (r6 != null) goto L7;
    L15:
        f2.b(2131919216, 0);
        return;
    L7:
        if (r6.isEngineOn() != true) goto L15;
        yj0.a r7 = this.H;
        if (r7 != null) goto L11;
        return;
    L11:
        if (r7.d0(false) != true) goto L21;
        er(false, "silence");
        yj0.a r8 = this.H;
        if (r8 == null) goto L22;
        String r9 = jc1.k.n(IMiddlewareUserService.class).user().n();
        Intrinsics.checkNotNullParameter(r9, "toUserId");
        r8.f0(r9, 0, r5);
        return;
    L22:
        return;
    L21:
        return;
    L16:
        yj0.a r10 = this.H;
        if (r10 == null) goto L25;
        Intrinsics.checkNotNullParameter(r3, "toUserId");
        r10.f0(r3, 0, r5);
        return;
    }

    @Override // rj0.e
    public final void logMiniAppShareIconClick(String r2, String r3, boolean r4) {
        LinkCastAnchorWidget r0 = this.Q;
        if (r0 == null) goto L6;
        r0.logMiniAppShareIconClick(r2, r3, r4);
        return;
    }

    @Override // rj0.e
    public final void logMiniAppShareIconShow(String r2, String r3, boolean r4) {
        LinkCastAnchorWidget r0 = this.Q;
        if (r0 == null) goto L6;
        r0.logMiniAppShareIconShow(r2, r3, r4);
        return;
    }

    @Override // rj0.k
    public final void replyCPosition(long r13, String r15, boolean r16) {
        TalkRoomBusinessFullLinkMonitor.a.getClass();
        TalkRoomBusinessFullLinkMonitor.v(r15, r16);
        long r3 = System.currentTimeMillis();
        LinkAudienceApi r5 = (LinkAudienceApi) com.bytedance.android.live.network.c.b().e(LinkAudienceApi.class);
        long r8 = d5.c(r15);
        if (r16 == false) goto L5;
        CPositionReplyType r0 = CPositionReplyType.Accept;
    L6:
        Disposable r1 = r5.replyCPosition(r13, r8, r15, r0.getValue()).compose(RxUtil.rxSchedulerHelper()).subscribe(new n(r15, r16, r3), new o(r15, r16, r3, r13));
        this.m.add(r1);
        return;
    L5:
        r0 = CPositionReplyType.Reject;
        goto L6
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.MultiLinkBaseAnchorLinkWidget, com.bytedance.android.live.liveinteract.plantform.core.v
    public final void L0(String r3, TextureView r4, int r5, int r6) {
        jy0.b.a(LinkRoomFightContext.TAG, "onFirstRemoteVideoFrame linkId " + r3 + " textureView " + r4);
        super.L0(r3, r4, r5, r6);
        this.k0.put(r3, r4);
        tf0.o r7 = this.E;
        if (r7 == null) goto L6;
        r7.b(r3);
        return;
    }

    public final void Te(VideoShowMode r19, VideoShowMode r20, lh6.b.b r21, String r22) {
        Intrinsics.checkNotNullParameter(r19, "newShowMode");
        Intrinsics.checkNotNullParameter(r20, "oldShowMode");
        int r1 = com.bytedance.android.live.liveinteract.videotalk.b.a[r19.ordinal()];
        if (r1 != 1) goto L5;
        int r2 = 1;
    L13:
        ArrayList r15 = new ArrayList();
        Context r4 = ((Widget) this).context;
        if (r4 != null) goto L16;
        r4 = s1.getContext();
    L16:
        int r7 = r2;
        r15.add(new qh0.f.h(r4, OperateType.APPLY, r7, 16, getMRoom(), je0.d.b0(), null, this, null, 1472));
        com.bytedance.android.live.liveinteract.plantform.permission.checker.s r3 = qh0.f.a(r15);
        if (aj0.a.a(r2, getMRoom()) == true) goto L19;
    L21:
        r3.a(new com.bytedance.android.live.liveinteract.videotalk.o(r21));
    L23:
        if (aj0.a.a(r2, getMRoom()) == false) goto L30;
        jg6.a r0 = zq().e5();
        if (r0 == null) goto L31;
        lh6.b r5 = r0.a();
        if (r5 == null) goto L32;
        r5.n(5, true, "openShowMode to audio");
        return;
    L32:
        return;
    L31:
        return;
    L30:
        return;
    L19:
        if (r19.getSource() == 1) goto L21;
        jy0.b.c("[VideoTalk]VideoTalkRoomAnchorWidget", "in room fight enlarge layout, intercept update link type audio update", null, 4);
        r21.a(Unit.INSTANCE);
        goto L23
    L5:
        if (r1 != 2) goto L7;
        r2 = 2;
        goto L13
    L7:
        if (r1 != 3) goto L10;
        r2 = 3;
        goto L13
    L10:
        throw new NoWhenBranchMatchedException();
    }

    public final void Tq(int r7, Integer r8, String r9, String r10) {
        HashMap r0 = new HashMap();
        TalkRoomLogUtils.A0(r0, Integer.valueOf(r7), r8);
        if (r7 != 8) goto L9;
        if (r8 == null) goto L9;
        if (r8.intValue() != 7) goto L9;
        boolean r11 = true;
    L10:
        if (r11 == true) goto L12;
    L14:
        TalkRoomLogUtils.V0(r0);
        TalkRoomLogUtils.Q0(r0);
        if (((Boolean) b6.h.getValue()).booleanValue() == false) goto L17;
        String r12 = "on";
    L18:
        r0.put("is_camera_allow", r12);
        ICircleInfo r13 = getMRoom().getCircleInfo();
        if (r13 == null) goto L23;
        String r14 = r13.getCircleName();
        if (r14 == null) goto L23;
        r0.put("circle_name", r14);
    L23:
        if (r10 != null) goto L25;
        r10 = "null";
    L25:
        r0.put("shoot_way", r10);
        if (r8 != null) goto L29;
    L31:
        DataCenter r15 = ((Widget) this).dataCenter;
        if (r15 == null) goto L39;
        String r16 = (String) r15.get("data_room_video_talk_log_open_success_for_enter_from", "");
        if (r16 == null) goto L39;
        if (TextUtils.isEmpty(r16) == true) goto L39;
        r0.put("enter_from", r16);
        ((Widget) this).dataCenter.put("data_room_video_talk_log_open_success_for_enter_from", "");
    L39:
        if (r8 == null) goto L44;
        if (r8.intValue() != 9) goto L44;
    L45:
        com.bytedance.live.datacontext.j r17 = com.bytedance.android.live.liveinteract.api.utils.m.e(this).J();
        if (r17 == null) goto L50;
        LivePlayModeLogContext r18 = (LivePlayModeLogContext) r17.getValue();
        if (r18 == null) goto L50;
        r18.addPlayMode(6);
    L50:
        com.bytedance.android.live.liveinteract.plantform.utils.i0 r19 = TalkRoomLogUtils.a;
        String r20 = TalkRoomLogUtils.d;
        if (r20 == null) goto L54;
        r0.put("source", r20);
    L54:
        if (Intrinsics.areEqual("SingChallengeOpen", r9) == false) goto L61;
        com.bytedance.live.datacontext.j r21 = com.bytedance.android.live.liveinteract.api.utils.m.e(this).J();
        if (r21 == null) goto L61;
        LivePlayModeLogContext r22 = (LivePlayModeLogContext) r21.getValue();
        if (r22 == null) goto L61;
        r22.addPlayMode(10);
    L61:
        if (((Boolean) com.bytedance.android.livesdk.sharedpref.c.s1.getValue()).booleanValue() == false) goto L63;
        String r23 = "1";
    L64:
        r0.put("is_invite_only", r23);
        r0.put("is_from_audience", "0");
        r0.put("over_path", "switch_link_type");
        TalkRoomLogUtils.H0(r0);
        if (Intrinsics.areEqual((String) r0.get("enter_from"), "solo_ktv") == false) goto L68;
        r0.put("source", "solo_ktv");
    L68:
        if (r2.a(TalkRoomLogUtils.n) == false) goto L70;
        r0.put("source", TalkRoomLogUtils.n);
        r0.put("game_id", TalkRoomLogUtils.o);
        r0.put("game_name", TalkRoomLogUtils.p);
    L70:
        com.bytedance.android.livesdk.log.j0.l().sendLog("anchor_audience_connection_open_success", r0, new Object[]{IRoom.class, am2.x.class});
        return;
    L63:
        r23 = "0";
    L44:
        if (Intrinsics.areEqual(r9, "SingChallengeOpen") == false) goto L50;
    L29:
        if (r8.intValue() != 4) goto L31;
        r0.put("grouppk_stage", "prepare");
        goto L31
    L17:
        r12 = "off";
        goto L18
    L12:
        if (((IInteractService) jc1.k.n(IInteractService.class)).dynamicFromAudience() == false) goto L14;
        r0.put("function_type2", "new_audience");
    L9:
        r11 = false;
        goto L10
    }

    public final boolean Yq(zj0.d r9, zj0.d.b r10, List r11, List r12) {
        StringBuilder r0 = new StringBuilder("needLogConnectionOpenOrOver: windowDynamic: from: ");
        r0.append(r9);
        r0.append(" isWindowDynamic: ");
        if (r9 != null) goto L5;
        Boolean r6 = null;
    L13:
        r0.append(r6);
        jy0.b.d("[VideoTalk]VideoTalkRoomAnchorWidget", r0.toString());
        jy0.b.d("[VideoTalk]VideoTalkRoomAnchorWidget", "needLogConnectionOpenOrOver: dynamicFromAudience: " + ((IInteractService) jc1.k.n(IInteractService.class)).dynamicFromAudience() + " , mDynamicAudienceCacheByMessage: " + this.A);
        if (r9 != null) goto L16;
    L28:
        if (r9 == null) goto L32;
        if (r9.b() != true) goto L32;
    L33:
        return false;
    L32:
        if (r10.b() == true) goto L33;
        if (r9 == null) goto L38;
        if (r9.c() != true) goto L38;
    L39:
        return false;
    L38:
        if (r10.c() == true) goto L39;
        if (r9 == null) goto L44;
        if (r9.isDynamic() != true) goto L44;
    L45:
        if (r9 != null) goto L47;
    L50:
        return true;
    L47:
        if (r9.a != r10.a) goto L50;
        return false;
    L44:
        if (r10.isDynamic() == true) goto L45;
        if (r9 == null) goto L53;
        int r13 = r9.b;
    L55:
        if (com.bytedance.android.livesdk.chatroom.interact.model.e0.a(r13) == true) goto L57;
    L63:
        return true;
    L57:
        if (com.bytedance.android.livesdk.chatroom.interact.model.e0.a(r10.b) == false) goto L63;
        if (com.bytedance.android.livesdk.chatroom.interact.model.d0.e(r11) == false) goto L63;
        if (com.bytedance.android.livesdk.chatroom.interact.model.d0.e(r12) == false) goto L63;
        return false;
    L53:
        r13 = 0;
        goto L55
    L16:
        if (r9.a != 8) goto L21;
        int r1 = r9.b;
        if (r1 == 7) goto L20;
        if (r1 != 52) goto L21;
    L20:
        boolean r2 = true;
    L22:
        if (r2 != true) goto L28;
        if (((IInteractService) jc1.k.n(IInteractService.class)).dynamicFromAudience() == false) goto L26;
    L27:
        return true;
    L26:
        if (this.A == false) goto L28;
    L21:
        r2 = false;
        goto L22
    L5:
        if (r9.a != 8) goto L10;
        int r7 = r9.b;
        if (r7 == 7) goto L9;
        if (r7 != 52) goto L10;
    L9:
        boolean r8 = true;
    L11:
        r6 = Boolean.valueOf(r8);
    L10:
        r8 = false;
        goto L11
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.MultiLinkBaseAnchorLinkWidget, com.bytedance.android.live.liveinteract.plantform.core.v
    public final void b4(String r3, uf2.z.a r4, int r5, int r6) {
        jy0.b.a(LinkRoomFightContext.TAG, "onFirstRemoteVideoFrame linkId " + r3 + " layer " + r4);
        super.b4(r3, r4, r5, r6);
        tf0.o r7 = this.E;
        if (r7 == null) goto L6;
        r7.b(r3);
        return;
    }

    @Override // rj0.e
    public final void ne(LinkScreenCastType r2, String r3, String r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r2, "type");
        Intrinsics.checkNotNullParameter(r3, "appId");
        Intrinsics.checkNotNullParameter("miniApp", "source");
        LinkCastAnchorWidget r6 = this.Q;
        if (r6 == null) goto L6;
        r6.ne(r2, r3, "miniApp", r5);
        return;
    }

    @Override // rj0.k
    public final void v0(int r11, String r12, int r13, String r14) {
        Intrinsics.checkNotNullParameter(r12, "requestPage");
        ((Widget) this).dataCenter.put("data_task_name_when_open_invite_panel", r14);
        ILinkPanelService r2 = com.bytedance.android.live.liveinteract.component.b.a();
        if (r2 == null) goto L5;
        r2.C70(((Widget) this).context, ((Widget) this).dataCenter, r11, r12, r13, getMRoom(), this);
    L5:
        com.bytedance.android.live.liveinteract.plantform.base.g r15 = com.bytedance.android.live.liveinteract.plantform.base.f.a();
        if (r15 == null) goto L9;
        r15.Nf();
        return;
    }

    @Override // rj0.k
    public final void Cl(int r21, Integer r22, String r23, boolean r24, boolean r25) {
        jy0.b.d("ttlive_link_video", "try switchScene to scene=" + r21 + " uiLayout=" + r22 + " reason=" + r23 + ", current:" + Qq());
        com.bytedance.android.livesdk.chatroom.viewmodel.j r0 = Qq();
        if (r0 == null) goto L5;
        int r15 = r0.a;
    L6:
        com.bytedance.android.livesdk.chatroom.viewmodel.j r1 = Qq();
        if (r1 == null) goto L9;
        int r10 = r1.c;
    L10:
        com.bytedance.android.livesdk.chatroom.viewmodel.j r2 = Qq();
        if (r2 == null) goto L14;
        List<Integer> r3 = r2.b;
        if (r3 == null) goto L14;
    L15:
        zj0.e r4 = this.V0;
        if (r4 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("layoutSwitcher");
    L18:
        tf0.m r5 = null;
        if (r4.d(r21, r22, r3) == false) goto L23;
        jy0.b.c("ttlive_link_video", "no switchScene, same layout " + Qq() + ' ' + Mq(), null, 4);
        return;
    L23:
        if (r21 != 8) goto L41;
        if (this.Y.size() <= 7) goto L41;
        if (vm2.h.X().a() != true) goto L29;
        f2.b(2131915467, 0);
    L30:
        HashMap r6 = new HashMap();
        r6.put("live_type", "video_live");
        com.bytedance.live.datacontext.j r7 = com.bytedance.android.live.liveinteract.api.utils.m.e(this).getVideoTalkRoomSubScene();
        if (r7 == null) goto L37;
        com.bytedance.android.livesdk.chatroom.viewmodel.e r8 = (com.bytedance.android.livesdk.chatroom.viewmodel.e) r7.getValue();
        if (r8 == null) goto L37;
        com.bytedance.android.livesdk.chatroom.viewmodel.j r9 = r8.t();
        if (r9 == null) goto L37;
        Integer r11 = Integer.valueOf(r9.a);
    L38:
        TalkRoomLogUtils.B0(r6, r11, null, 4);
        TalkRoomLogUtils.Q0(r6);
        mz0.n r12 = new mz0.n();
        Map r13 = r12.a;
        Intrinsics.checkNotNullParameter(r13, "map");
        Intrinsics.checkNotNullParameter(r6, "map");
        r13.putAll(r6);
        mz0.m r14 = new mz0.m();
        r14.b(LogCommon.ROOM);
        ((ArrayList) r12.b).addAll(r14.a);
        cy0.e.a.getClass();
        cy0.j r16 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r17 = com.bytedance.android.scope.m.b(r16).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r17);
        ((f80.a) r17).w3("livesdk_anchor_audience_connection_layout_change_toast_show", r12.a, r12.b);
        return;
    L37:
        r11 = null;
        goto L38
    L29:
        f2.b(2131915466, 0);
    L41:
        if (this.x == false) goto L43;
        return;
    L43:
        this.x = true;
        this.y = false;
        long r18 = System.currentTimeMillis();
        tf0.m r19 = com.bytedance.android.live.liveinteract.videotalk.utils.b0.b();
        if ((r19 instanceof com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.u) == false) goto L47;
        r5 = r19;
    L47:
        com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.u r20 = (com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.u) r5;
        if (r20 == null) goto L50;
        r20.a = false;
        r20.b = r18;
    L50:
        LinkApi r26 = (LinkApi) com.bytedance.android.live.network.c.b().e(LinkApi.class);
        long r27 = getMRoom().getId();
        long r28 = getMRoom().getId();
        if (r22 == null) goto L53;
        int r110 = r22.intValue();
    L54:
        this.m.add(r26.switchScene(r27, r28, r15, r21, r110, r23, r25).subscribeOn(Schedulers.io()).flatMap(s.a).observeOn(AndroidSchedulers.mainThread()).subscribe(new t(this, r20, r15, r21, r22, r23, r18, r10, r24), new u(this, r15, r21, r22, r23, r18)));
        return;
    L53:
        r110 = 0;
    L14:
        r3 = CollectionsKt.emptyList();
        goto L15
    L9:
        r10 = 0;
        goto L10
    L5:
        r15 = 8;
        goto L6
    }

    @Override // zj0.b
    public final void Ic(zj0.d r21, zj0.d.b r22, List r23, List r24, zj0.c r25) {
        Intrinsics.checkNotNullParameter(r22, "to");
        Intrinsics.checkNotNullParameter(r25, "switchType");
        if (r21 != null) goto L6;
        return;
    L6:
        if (r22.a != 16) goto L8;
        zi0.e r3 = zi0.b.d;
        com.bytedance.android.livesdk.utils.ntp.e.a();
        r3.getClass();
    L8:
        com.bytedance.android.live.liveinteract.plantform.utils.i0 r4 = TalkRoomLogUtils.a;
        if (TalkRoomLogUtils.i(Integer.valueOf(r21.a), Integer.valueOf(r21.b), Integer.valueOf(r22.a), Integer.valueOf(r22.b), r23, r24) == true) goto L32;
        String r5 = TalkRoomLogUtils.p(Integer.valueOf(r21.a), Integer.valueOf(r21.b), null);
        String r6 = TalkRoomLogUtils.p(Integer.valueOf(r22.a), Integer.valueOf(r22.b), null);
        String r7 = u0.j(Integer.valueOf(r21.b));
        String r8 = u0.j(Integer.valueOf(r22.b));
        String r10 = u0.f(Integer.valueOf(r21.b), Integer.valueOf(r21.a), r23, null, null, null, 56);
        String r9 = u0.f(Integer.valueOf(r22.b), Integer.valueOf(r22.a), r24, null, null, null, 56);
        String r11 = "function_switch";
        if ((!Intrinsics.areEqual(r5, r6)) == false) goto L20;
        if (r5 == null) goto L32;
        if (Intrinsics.areEqual(r7, r8) == true) goto L18;
        r11 = "layout_type_close";
    L18:
        TalkRoomLogUtils.I(r5, r7, r11, r10);
        goto L32
    L20:
        if ((!Intrinsics.areEqual(r7, r8)) == false) goto L24;
        if (r7 == null) goto L32;
        TalkRoomLogUtils.J(r7, 9);
        goto L32
    L24:
        if ((!Intrinsics.areEqual(r10, r9)) == false) goto L32;
        if (r10 == null) goto L32;
        if (Intrinsics.areEqual(r7, r8) == true) goto L30;
        r11 = "layout_type_close";
    L30:
        TalkRoomLogUtils.I(r5, r7, r11, r10);
    L32:
        if (Yq(r21, r22, r23, r24) == false) goto L129;
        int r12 = r21.a;
        String r13 = TalkRoomLogUtils.j;
        HashMap r14 = new HashMap();
        TalkRoomLogUtils.Q0(r14);
        TalkRoomLogUtils.B0(r14, Integer.valueOf(r12), null, 4);
        TalkRoomLogUtils.W0(r14, Boolean.valueOf(com.bytedance.android.livesdk.chatroom.interact.model.d0.e(r23)));
        if (TextUtils.isEmpty(r13) == false) goto L36;
    L38:
        String r15 = "off";
        if (((Boolean) b6.h.getValue()).booleanValue() == false) goto L41;
        Object r16 = "on";
    L42:
        r14.put("is_camera_allow", r16);
        long r17 = 1000;
        long r18 = (System.currentTimeMillis() - this.C) / r17;
        this.C = System.currentTimeMillis();
        r14.put("duration", String.valueOf(r18));
        int r19 = this.D;
        if (r19 == 0) goto L45;
        int r20 = r19 - 1;
    L46:
        r14.put("connect_pcu", String.valueOf(r20));
        TalkRoomBusinessFullLinkMonitor.a.getClass();
        TalkRoomBusinessFullLinkMonitor.s0(r18 * r17, r20);
        if (((Boolean) ((Widget) this).dataCenter.get("data_big_party_support_send_gift_to_linker", Boolean.FALSE)).booleanValue() == false) goto L49;
        Object r26 = "on";
    L50:
        r14.put("gift_guest_switch_type", r26);
        r14.put("send_gift_scene", "video_audience_multi");
        TalkRoomLogUtils.a(r14, true);
        com.bytedance.android.livesdk.log.filter.t r27 = com.bytedance.android.livesdk.log.j0.l().c(am2.x.class);
        if ((r27 instanceof com.bytedance.android.livesdk.log.filter.t) == true) goto L53;
    L55:
        String r28 = "1";
        if (this.P1 == false) goto L58;
        Object r29 = "1";
    L59:
        r14.put("is_avatar_used", r29);
        IRoom r30 = getMRoom();
        if (r30 == null) goto L66;
        ICircleInfo r31 = r30.getCircleInfo();
        if (r31 == null) goto L66;
        String r32 = r31.getCircleName();
        if (r32 == null) goto L66;
        r14.put("circle_name", r32);
    L66:
        String r110 = "null";
        if (this.z == true) goto L69;
        r110 = (String) ((Widget) this).dataCenter.get("data_room_shoot_way_exact", "null");
    L69:
        r14.put("shoot_way", r110);
        TalkRoomLogUtils.b1(r14, Integer.valueOf(je0.d.f()));
        DataCenter r33 = ((Widget) this).dataCenter;
        String r111 = "";
        if (r33 == null) goto L76;
        String r34 = (String) r33.get("data_room_video_talk_log_over_for_over_path", "");
        if (r34 == null) goto L76;
        if (TextUtils.isEmpty(r34) == true) goto L76;
        r14.put("over_path", r34);
        ((Widget) this).dataCenter.put("data_room_video_talk_log_over_for_over_path", "");
    L76:
        r14.put("auction_mode_status", "off");
        Integer r35 = (Integer) ((Widget) this).dataCenter.get("data_ktv_mode_before_close", -1);
        if (r35 != null) goto L80;
    L81:
        int r36 = Pq();
        com.bytedance.live.datacontext.j r112 = com.bytedance.android.live.liveinteract.api.utils.m.e(this).J();
        if (r112 == null) goto L86;
        LivePlayModeLogContext r37 = (LivePlayModeLogContext) r112.getValue();
        if (r37 == null) goto L86;
        r37.removePlayMode(r36);
    L86:
        com.bytedance.live.datacontext.j r38 = com.bytedance.android.live.liveinteract.api.utils.m.e(this).J();
        if (r38 == null) goto L91;
        LivePlayModeLogContext r39 = (LivePlayModeLogContext) r38.getValue();
        if (r39 == null) goto L91;
        r39.addPlayMode(((Number) ((Widget) this).dataCenter.get("data_ktv_mode_before_close", -1)).intValue());
    L91:
        r14.put("play_mode", u0.b());
        com.bytedance.live.datacontext.j r1 = com.bytedance.android.live.liveinteract.api.utils.m.e(this).J();
        if (r1 == null) goto L96;
        LivePlayModeLogContext r2 = (LivePlayModeLogContext) r1.getValue();
        if (r2 == null) goto L96;
        r2.removePlayMode(((Number) ((Widget) this).dataCenter.get("data_ktv_mode_before_close", -1)).intValue());
    L96:
        if (r36 == (-1)) goto L102;
        com.bytedance.live.datacontext.j r40 = com.bytedance.android.live.liveinteract.api.utils.m.e(this).J();
        if (r40 == null) goto L102;
        LivePlayModeLogContext r41 = (LivePlayModeLogContext) r40.getValue();
        if (r41 == null) goto L102;
        r41.addPlayMode(r36);
    L102:
        ((Widget) this).dataCenter.put("data_ktv_mode_before_close", -1);
    L104:
        com.bytedance.android.live.liveinteract.api.data.a.h.getClass();
        if (com.bytedance.android.live.liveinteract.api.data.a.C0017a.k().c == false) goto L107;
        r15 = "on";
    L107:
        r14.put("rechargeable_mode_status", r15);
        if (((Boolean) com.bytedance.android.livesdk.sharedpref.c.s1.getValue()).booleanValue() == true) goto L111;
        r28 = "0";
    L111:
        r14.put("is_invite_only", r28);
        TalkRoomLogUtils.H0(r14);
        String r42 = (String) ((Widget) this).dataCenter.get("data_anchor_video_talk_room_init_source");
        if (r42 == null) goto L116;
        r111 = r42;
    L116:
        if ("pre_apply".equals(r111) == false) goto L119;
        r14.put("is_from_audience", "0");
    L119:
        if (((IInteractService) jc1.k.n(IInteractService.class)).dynamicFromAudience() == false) goto L121;
        r14.put("function_type", "new_audience");
        r14.put("function_type2", "new_audience");
        r14.put("over_path", "switch_link_type");
    L121:
        String r43 = TalkRoomLogUtils.d;
        if (r43 == null) goto L125;
        r14.put("source", r43);
    L125:
        if (r2.a(TalkRoomLogUtils.n) == false) goto L127;
        r14.put("source", TalkRoomLogUtils.n);
        r14.put("game_id", TalkRoomLogUtils.o);
        r14.put("game_name", TalkRoomLogUtils.p);
        TalkRoomLogUtils.n1();
    L127:
        mz0.n r44 = new mz0.n();
        Map r45 = r44.a;
        Intrinsics.checkNotNullParameter(r45, "map");
        Intrinsics.checkNotNullParameter(r14, "map");
        r45.putAll(r14);
        mz0.m r46 = new mz0.m();
        r46.b(LogCommon.ROOM);
        r46.b(LogCommon.PAGE_SOURCE_LOG);
        ((ArrayList) r44.b).addAll(r46.a);
        cy0.e.a.getClass();
        cy0.j r47 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r48 = com.bytedance.android.scope.m.b(r47).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r48);
        ((f80.a) r48).w3("livesdk_anchor_audience_connection_over", r44.a, r44.b);
        goto L129
    L80:
        if (r35.intValue() != (-1)) goto L81;
        r14.put("play_mode", u0.b());
        goto L104
    L58:
        r29 = "0";
        goto L59
    L53:
        if (r27.j() == false) goto L55;
        r14.put("is_continue", "continue");
        goto L55
    L49:
        r26 = "off";
        goto L50
    L45:
        r20 = 0;
        goto L46
    L41:
        r16 = "off";
        goto L42
    L36:
        if (vm2.d.v0() == false) goto L38;
        Intrinsics.checkNotNull(r13);
        r14.put("function_type", r13);
        r14.put("function_type2", r13);
    L129:
        if (r21.b() == false) goto L131;
    L133:
        boolean r49 = false;
    L134:
        if (r49 == false) goto L137;
        yq().L();
        return;
    L137:
        return;
    L131:
        if (r22.b() == true) goto L133;
        r49 = true;
        goto L134
    }

    @Override // zj0.b
    public final void Jm(zj0.d r28, zj0.d.b r29, List r30, List r31, zj0.c r32) {
        Intrinsics.checkNotNullParameter(r29, "to");
        Intrinsics.checkNotNullParameter(r32, "switchType");
        com.bytedance.android.livesdk.chatroom.utils.g0.d(r29.b);
        com.bytedance.android.livesdk.chatroom.utils.g0.c(r29.a);
        if (r28 != null) goto L11;
        DataCenter r1 = ((Widget) this).dataCenter;
        String r3 = "linkmic";
        int r14 = r29.a;
        int r15 = r29.b;
        List<Integer> r16 = u0.d();
        if (r30 == null) goto L8;
        List r2 = CollectionsKt.toList(r30);
        if (r2 == null) goto L8;
    L9:
        r1.put("data_multi_lick_dynamic_event_change", new nh0.f(r3, new nh0.e(r14, r15, r16, 0, 0, r2, null, null, 192), null, null, null, null, false, 252));
        return;
    L8:
        r2 = CollectionsKt.emptyList();
        goto L9
    L11:
        com.bytedance.android.live.liveinteract.plantform.utils.i0 r4 = TalkRoomLogUtils.a;
        if (TalkRoomLogUtils.i(Integer.valueOf(r28.a), Integer.valueOf(r28.b), Integer.valueOf(r29.a), Integer.valueOf(r29.b), r30, r31) == false) goto L15;
        String r6 = null;
    L46:
        if (Yq(r28, r29, r30, r31) == false) goto L57;
        if ((r32 instanceof zj0.c.a) == true) goto L50;
        Object r5 = r6;
    L51:
        zj0.c.a r7 = (zj0.c.a) r5;
        if (r7 == null) goto L54;
        String r12 = r7.d;
    L55:
        Tq(r29.a, Integer.valueOf(r29.b), r12, "switch_layout");
        goto L57
    L54:
        r12 = r6;
        goto L55
    L50:
        r5 = r32;
    L57:
        if (r28.a != 9) goto L59;
        boolean r8 = true;
    L60:
        if (r8 == true) goto L71;
        if (r29.a != 9) goto L64;
        boolean r9 = true;
    L65:
        if (r9 == false) goto L71;
        if (r29.b != 61) goto L69;
        f2.b(2131919219, 0);
        goto L71
    L69:
        f2.b(2131919220, 0);
        goto L71
    L64:
        r9 = false;
    L71:
        com.bytedance.live.datacontext.m r10 = com.bytedance.android.live.liveinteract.api.utils.m.j(this).w2();
        if (r10 == null) goto L74;
        r10.setValue(Boolean.TRUE);
    L74:
        u8(r32.toString());
        hg6.g r11 = R1();
        if (r11 != null) goto L77;
    L84:
        hg6.g r13 = R1();
        if (r13 == null) goto L87;
        r13.D(r29.a, "videoAnchor#afterSwitchWindowLayout");
    L87:
        hg6.g r17 = R1();
        if (r17 == null) goto L90;
        r17.f();
    L90:
        int r18 = r29.a;
        if (r18 != 12) goto L93;
        boolean r19 = true;
    L94:
        if (r19 == false) goto L97;
        com.bytedance.android.livesdk.sharedpref.d.q(12);
    L102:
        MultiRevenueDataContext.Companion.getClass();
        com.bytedance.android.live.liveinteract.chatroom.chatroom.playmode.a r20 = MultiRevenueDataContext.a.d();
        if (r20 == null) goto L106;
        r20.d4(r29.a, r29.b);
    L106:
        if (fj0.c.a() == false) goto L110;
        com.bytedance.android.live.liveinteract.revenuebase.c r21 = MultiRevenueDataContext.a.c();
        if (r21 == null) goto L110;
        r21.b();
    L110:
        DataCenter r22 = ((Widget) this).dataCenter;
        String r110 = "linkmic";
        int r111 = r29.a;
        int r23 = r29.b;
        List<Integer> r112 = u0.d();
        int r24 = r28.a;
        int r25 = r28.b;
        if (r30 == null) goto L114;
        List r26 = CollectionsKt.toList(r30);
        if (r26 == null) goto L114;
    L115:
        r22.put("data_multi_lick_dynamic_event_change", new nh0.f(r110, new nh0.e(r111, r23, r112, r24, r25, r26, null, null, 192), null, null, null, null, false, 252));
        return;
    L114:
        r26 = CollectionsKt.emptyList();
        goto L115
    L97:
        if (r18 != 8) goto L99;
        boolean r113 = true;
    L100:
        if (r113 == false) goto L102;
        com.bytedance.android.livesdk.sharedpref.d.q(8);
        goto L102
    L99:
        r113 = false;
        goto L100
    L93:
        r19 = false;
        goto L94
    L77:
        if (r29.a != 12) goto L79;
        boolean r27 = true;
    L80:
        if (r27 == false) goto L82;
        InteractMode r33 = InteractMode.EQUAL_TALK_ROOM;
    L83:
        r11.a(r33);
        goto L84
    L82:
        r33 = InteractMode.VIDEO_TALK_CAMERA;
        goto L83
    L79:
        r27 = false;
        goto L80
    L59:
        r8 = false;
        goto L60
    L15:
        String r114 = TalkRoomLogUtils.p(Integer.valueOf(r28.a), Integer.valueOf(r28.b), null);
        String r34 = TalkRoomLogUtils.p(Integer.valueOf(r29.a), Integer.valueOf(r29.b), null);
        String r35 = u0.j(Integer.valueOf(r28.b));
        String r36 = u0.j(Integer.valueOf(r29.b));
        String r37 = u0.f(Integer.valueOf(r28.b), Integer.valueOf(r28.a), r30, null, null, null, 56);
        String r38 = u0.f(Integer.valueOf(r29.b), Integer.valueOf(r29.a), r31, null, null, null, 56);
        int r39 = r28.b;
        if (r39 != 6) goto L18;
    L24:
        boolean r40 = true;
    L26:
        if ((!Intrinsics.areEqual(r114, r34)) == false) goto L40;
        if (r114 != null) goto L29;
        boolean r41 = true;
    L31:
        if (vm2.h.X().a() == true) goto L37;
        if (r41 == true) goto L37;
        if (Intrinsics.areEqual(r35, r36) == false) goto L37;
        String r42 = "function_switch";
    L38:
        TalkRoomLogUtils.G(r34, r36, r42, r40, r38);
        r6 = null;
    L37:
        r42 = null;
        goto L38
    L29:
        r41 = false;
        goto L31
    L40:
        if ((!Intrinsics.areEqual(r35, r36)) == false) goto L42;
        r6 = null;
        TalkRoomLogUtils.H(null, r36, r40, r38, 5);
        goto L46
    L42:
        r6 = null;
        if ((!Intrinsics.areEqual(r37, r38)) == false) goto L46;
        TalkRoomLogUtils.H(null, r36, r40, r38, 5);
        goto L46
    L18:
        if (r39 == 3) goto L24;
        int r43 = r29.b;
        if (r43 == 6) goto L24;
        if (r43 == 3) goto L24;
        r40 = false;
        goto L26
    }

    @Override // rj0.k
    public final void Ub(long r22, String r24, boolean r25, String r26, Function1<? super Boolean, Unit> r27) {
        Intrinsics.checkNotNullParameter(r26, "enlargeTypeForLog");
        if (r24 != null) goto L5;
        String r8 = "";
    L7:
        if (r25 == false) goto L9;
        com.bytedance.android.live.liveinteract.plantform.utils.i0 r3 = TalkRoomLogUtils.a;
        TalkRoomLogUtils.X(true, r8, r26);
    L14:
        if (r25 == true) goto L16;
    L50:
        long r6 = CPositionToEnlargePosition.Default.getValue();
        TalkRoomBusinessFullLinkMonitor.a.getClass();
        TalkRoomBusinessFullLinkMonitor.s(r8, r25, r6);
        long r19 = System.currentTimeMillis();
        LinkAudienceApi r10 = (LinkAudienceApi) com.bytedance.android.live.network.c.b().e(LinkAudienceApi.class);
        long r13 = d5.c(r8);
        if (r25 == false) goto L53;
        CPositionInviteType r1 = CPositionInviteType.Enlarge;
    L54:
        this.m.add(r10.setCPosition(r22, r13, r8, r1.getValue(), r6).compose(RxUtil.rxSchedulerHelper()).subscribe(new q(r8, r25, r6, r19, r27), new r(r8, r25, r6, r19, r27, r22)));
        return;
    L53:
        r1 = CPositionInviteType.Reduce;
        goto L54
    L16:
        if (Intrinsics.areEqual(r8, je0.d.b0()) == false) goto L50;
        CopyOnWriteArrayList<ILinkPlayerInfoBridge> r2 = yq().c;
        Boolean r4 = null;
        if (r2 == null) goto L44;
        boolean r5 = false;
        if (r2.isEmpty() == true) goto L43;
        Iterator<ILinkPlayerInfoBridge> r7 = r2.iterator();
    L24:
        if (r7.hasNext() == false) goto L43;
        ILinkPlayerInfoBridge r9 = r7.next();
        if (r9.isEnlarged() == false) goto L40;
        IBaseUser r11 = r9.getUser();
        if (r11 == null) goto L30;
        String r12 = r11.getIdString();
    L31:
        com.bytedance.live.datacontext.m r14 = com.bytedance.android.live.liveinteract.api.utils.m.j(this).getRoom();
        if (r14 == null) goto L36;
        IRoom r15 = (IRoom) r14.getValue();
        if (r15 == null) goto L36;
        String r16 = r15.getOwnerUserIdString();
    L38:
        if (Intrinsics.areEqual(r12, r16) == false) goto L40;
        boolean r17 = true;
    L41:
        if (r17 == false) goto L24;
        r5 = true;
    L36:
        r16 = null;
        goto L38
    L30:
        r12 = null;
    L40:
        r17 = false;
    L43:
        r4 = Boolean.valueOf(r5);
    L44:
        r4.booleanValue();
        je0.d.j(yq());
        TalkRoomLogUtils r18 = TalkRoomLogUtils.B;
        CPositionContext r20 = CPositionContext.Companion.getContext();
        if (r20 == null) goto L49;
        com.bytedance.live.datacontext.m<Boolean> r21 = r20.isCPositionOpen();
        if (r21 == null) goto L49;
        ((Boolean) r21.getValue()).booleanValue();
    L49:
        r18.d0(true, false, je0.d.b0(), CPositionBeInvitedDialog.ShowType.Invite, false, ((Widget) this).dataCenter);
        goto L50
    L9:
        boolean r23 = Intrinsics.areEqual(r8, je0.d.a());
        com.bytedance.android.live.liveinteract.plantform.utils.i0 r28 = TalkRoomLogUtils.a;
        if (r23 == false) goto L12;
        String r29 = "anchor";
    L13:
        TalkRoomLogUtils.W(true, r29);
        goto L14
    L12:
        r29 = "guest";
        goto L13
    L5:
        r8 = r24;
        goto L7
    }

    @Override // rj0.k
    public final void a2(boolean r10, List<? extends com.bytedance.android.livesdk.link.model.bridge.k> r11, ClientUIInfo r12, long r13, Map<Long, ? extends g2> r15) {
        Intrinsics.checkNotNullParameter(r11, "linkedUsers");
        er(!r10, "self_panel");
        com.bytedance.android.live.liveinteract.plantform.core.y r2 = yq();
        if (r10 == false) goto L5;
        String r14 = "silence";
    L6:
        r2.Y4(r11, r12, r13, r14, r15);
        return;
    L5:
        r14 = "unSilence";
        goto L6
    }

    public final void br(u1 r3, com.bytedance.android.livesdk.link.model.bridge.v1 r4, String r5, String r6, com.bytedance.android.live.liveinteract.plantform.model.e0 r7) {
        tf0.i r0 = this.o;
        if ((r0 instanceof tc0.c) == true) goto L5;
        r0 = null;
    L5:
        tc0.c r1 = (tc0.c) r0;
        if (r1 == null) goto L9;
        r1.r = r3;
        r1.n = r4;
        r1.k = r6;
        r1.m = r5;
        r1.s = r7;
        return;
    }

    @Override // rj0.k
    public final void vl(long r17, String r19, long r20, String r22, Function1<? super Boolean, Unit> r23) {
        Intrinsics.checkNotNullParameter(r19, "targetUserId");
        Intrinsics.checkNotNullParameter(r22, "enlargeTypeForLog");
        if (Intrinsics.areEqual(r19, je0.d.b0()) == true) goto L5;
    L18:
        com.bytedance.android.live.liveinteract.plantform.utils.i0 r1 = TalkRoomLogUtils.a;
        TalkRoomLogUtils.X(true, r19, r22);
        TalkRoomBusinessFullLinkMonitor.a.getClass();
        TalkRoomBusinessFullLinkMonitor.s(r19, true, r20);
        long r14 = System.currentTimeMillis();
        Disposable r2 = ((LinkAudienceApi) com.bytedance.android.live.network.c.b().e(LinkAudienceApi.class)).setCPosition(r17, d5.c(r19), r19, CPositionInviteType.Enlarge.getValue(), r20).compose(RxUtil.rxSchedulerHelper()).subscribe(new v(r19, r20, r14, r22, r23), new w(r19, r20, r14, r23));
        this.m.add(r2);
        return;
    L5:
        if (r20 != CPositionToEnlargePosition.Left.getValue()) goto L7;
        int r3 = CPositionContext.Companion.d();
    L9:
        if (r3 != EnlargeGuestInfo.EnlargeGuestType.EnlargeGuestType_Double.ordinal()) goto L11;
        boolean r8 = true;
    L12:
        je0.d.j(yq());
        TalkRoomLogUtils r4 = TalkRoomLogUtils.B;
        CPositionContext r5 = CPositionContext.Companion.getContext();
        if (r5 == null) goto L17;
        com.bytedance.live.datacontext.m<Boolean> r6 = r5.isCPositionOpen();
        if (r6 == null) goto L17;
        ((Boolean) r6.getValue()).booleanValue();
    L17:
        r4.d0(true, false, je0.d.b0(), CPositionBeInvitedDialog.ShowType.Invite, r8, ((Widget) this).dataCenter);
        goto L18
    L11:
        r8 = false;
        goto L12
    L7:
        r3 = EnlargeGuestInfo.EnlargeGuestType.EnlargeGuestType_Double.ordinal();
        goto L9
    }

    @Override // rj0.e
    public final void ll(LinkScreenCastType r10, String r11, int r12, int r13, Bitmap r14, String r15, String r16) {
        Intrinsics.checkNotNullParameter(r10, "linkScreenCastType");
        Intrinsics.checkNotNullParameter(r11, "appId");
        Intrinsics.checkNotNullParameter(r16, "openSource");
        LinkCastAnchorWidget r1 = this.Q;
        if (r1 == null) goto L6;
        r1.ll(r10, r11, r12, r13, r14, r15, r16);
        return;
    }
}
