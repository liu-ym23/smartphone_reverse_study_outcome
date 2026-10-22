package com.bytedance.android.live.liveinteract.videotalk;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.opengl.GLSurfaceView;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.appcompat.app.AppCompatDialog;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.base.model.message.ILinkmicEnlargeGuestMessage;
import com.bytedance.android.live.base.model.message.a5;
import com.bytedance.android.live.base.model.message.e6;
import com.bytedance.android.live.base.model.message.f6;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.broadcast.api.IMiddlewareBroadcastService;
import com.bytedance.android.live.browser.IBaseBrowserService;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.LiveTracingMonitor;
import com.bytedance.android.live.core.setting.b6;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.live.core.utils.ExceptionUtils;
import com.bytedance.android.live.core.utils.ListUtils;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.i1;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.utils.screen.FoldScreenUtils;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.link.IMultiLinkServiceExternal;
import com.bytedance.android.live.liveinteract.animation.InteractAnimationContext;
import com.bytedance.android.live.liveinteract.animation.InteractAnimationController;
import com.bytedance.android.live.liveinteract.animation.universalwidget.MultiLinkUniversalAnimWidget;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.api.MultiLinkOpenSource;
import com.bytedance.android.live.liveinteract.api.chatroom.model.LinkApplyType;
import com.bytedance.android.live.liveinteract.api.chatroom.model.LinkMatchType;
import com.bytedance.android.live.liveinteract.api.fulllink.InteractLinkFullLinkMonitor;
import com.bytedance.android.live.liveinteract.api.fulllink.LinkMonitorData;
import com.bytedance.android.live.liveinteract.api.fulllink.TalkRoomBusinessFullLinkMonitor;
import com.bytedance.android.live.liveinteract.banner.BannerWidget;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.ToolbarVideoInteractBehavior;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.dialog.LinkResultDialogFragment;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.dialog.LinkResultDialogFragmentV2;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.model.CPositionInviteType;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.model.CPositionReplyType;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.model.CPositionToEnlargePosition;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.interactivesong.RequestSongSingState;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.ui.VideoTalkRoomApplyCancelDialog;
import com.bytedance.android.live.liveinteract.component.MultiComponentManager;
import com.bytedance.android.live.liveinteract.component.api.linkpanel.ILinkPanelService;
import com.bytedance.android.live.liveinteract.digitavatar.DigitAvatarContext;
import com.bytedance.android.live.liveinteract.digitavatar.DigitAvatarMsgController;
import com.bytedance.android.live.liveinteract.digitavatar.videoavatar.VideoDigitAvatarWidget;
import com.bytedance.android.live.liveinteract.floatwindow.applywindow.LinkmicApplyFloatWindowManager;
import com.bytedance.android.live.liveinteract.floatwindow.dialog.LinkmicApplyFloatWindowRetainDialog;
import com.bytedance.android.live.liveinteract.floatwindow.dialog.LinkmicOnlineFloatWindowRetainDialog;
import com.bytedance.android.live.liveinteract.floatwindow.onlinewindow.LinkmicOnlineFloatWindowManager;
import com.bytedance.android.live.liveinteract.interactivesong.impl.InteractiveSongContext;
import com.bytedance.android.live.liveinteract.interactivesong.impl.InteractiveSongWidget;
import com.bytedance.android.live.liveinteract.interactivesong.logger.InteractiveSongLoggerKt;
import com.bytedance.android.live.liveinteract.linkbase.api.MediaOperation;
import com.bytedance.android.live.liveinteract.linkcast.LinkCastGuestWidget;
import com.bytedance.android.live.liveinteract.linkpanel.dialog.GuestTalkBeInvitedDialog;
import com.bytedance.android.live.liveinteract.linkpanel.vm.AdminInviteAndApplyViewModel;
import com.bytedance.android.live.liveinteract.linkpanel.vm.GuestApplyViewModel;
import com.bytedance.android.live.liveinteract.multianchor.model.LinkmicPositionItem;
import com.bytedance.android.live.liveinteract.plantform.api.LinkApi;
import com.bytedance.android.live.liveinteract.plantform.api.LinkAudienceApi;
import com.bytedance.android.live.liveinteract.plantform.camera.SwitchCameraManager;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.BaseLinkSeatWindowView;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.CommonLinkSeatWindowView;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkNormalEmptyViewBinder;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.BaseMultiLinkWindowManager;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.CommonMultiLinkWindowManager;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.DynamicEqualMultiLinkWindowManager;
import com.bytedance.android.live.liveinteract.plantform.datamerge.LinkUserDataMergeContext;
import com.bytedance.android.live.liveinteract.plantform.linksecurity.rts.RTSVideoWidget;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.plantform.model.LinkerBaseInfo;
import com.bytedance.android.live.liveinteract.plantform.model.n0;
import com.bytedance.android.live.liveinteract.plantform.model.p0;
import com.bytedance.android.live.liveinteract.plantform.permission.model.OperateType;
import com.bytedance.android.live.liveinteract.plantform.spatial.SpatialAudioStrategyManager;
import com.bytedance.android.live.liveinteract.plantform.utils.PublicStreamClientMixStrategy;
import com.bytedance.android.live.liveinteract.plantform.utils.PublicStreamPlayState;
import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomLogUtils;
import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomOperate;
import com.bytedance.android.live.liveinteract.plantform.utils.m0;
import com.bytedance.android.live.liveinteract.plantform.utils.s0;
import com.bytedance.android.live.liveinteract.plantform.utils.u0;
import com.bytedance.android.live.liveinteract.plantform.widgt.videolink.MultiLinkVideoBaseGuestLinkWidget;
import com.bytedance.android.live.liveinteract.playmode.SceneType;
import com.bytedance.android.live.liveinteract.revenue.fight.TeamFightContext;
import com.bytedance.android.live.liveinteract.revenue.fight.wm.MultiLinkVideoTeamFightWindowManager;
import com.bytedance.android.live.liveinteract.revenue.game.LinkMicGameContext;
import com.bytedance.android.live.liveinteract.revenue.guestlink.GuestLinkContext;
import com.bytedance.android.live.liveinteract.revenue.linkroomfight.core.LinkRoomFightContext;
import com.bytedance.android.live.liveinteract.revenue.linkroomfight.ui.MultiLinkLinkRoomFightWindowManager;
import com.bytedance.android.live.liveinteract.revenue.paid.viewmodel.PaidLinkMicContext;
import com.bytedance.android.live.liveinteract.revenuebase.MultiRevenueDataContext;
import com.bytedance.android.live.liveinteract.spatial.SpatialAudioContext;
import com.bytedance.android.live.liveinteract.utils.InteractLiveCorePermissionGuarantor;
import com.bytedance.android.live.liveinteract.utils.MultiLinkLoadWidgetUtils;
import com.bytedance.android.live.liveinteract.utils.MultiSceneEnterRoomStatisticsUtils;
import com.bytedance.android.live.liveinteract.utils.c1;
import com.bytedance.android.live.liveinteract.utils.n1;
import com.bytedance.android.live.liveinteract.utils.t0;
import com.bytedance.android.live.liveinteract.utils.w0;
import com.bytedance.android.live.liveinteract.videolink.VideoTalkGuestContext;
import com.bytedance.android.live.liveinteract.videotalk.cposition.CPositionContext;
import com.bytedance.android.live.liveinteract.videotalk.cposition.CPositionWidget;
import com.bytedance.android.live.liveinteract.videotalk.dialog.CPositionBeInvitedDialog;
import com.bytedance.android.live.liveinteract.videotalk.dialog.InteractBeautyPreviewDialog;
import com.bytedance.android.live.liveinteract.videotalk.dialog.VideoTalkBeInvitedDialogV2;
import com.bytedance.android.live.liveinteract.videotalk.perf.VideoEffectPerfHelper;
import com.bytedance.android.live.liveinteract.videotalk.quickinteract.QuickInteractWidget;
import com.bytedance.android.live.liveinteract.videotalk.themecompetition.ThemedCompetitionContext;
import com.bytedance.android.live.liveinteract.voicechat.MuteStateChecker;
import com.bytedance.android.live.liveinteract.voicechat.emoji.VideoTalkInteractEmojiPanel;
import com.bytedance.android.live.liveinteract.voicechat.match.viewmodel.ChatMatchViewModel;
import com.bytedance.android.live.liveinteract.voicechat.match.widget.ChatMatchWidget;
import com.bytedance.android.live.liveinteract.widget.widget.ChatRoomGuestAppliedDialog;
import com.bytedance.android.live.liveinteract.wrds.LinkWRDSHelper;
import com.bytedance.android.live.liveinteract.wrdspreload.MultiLinkWRDSPreloadManager;
import com.bytedance.android.live.matchroom.MatchRoomLandScapeAnimUtil;
import com.bytedance.android.live.multilink.external.api.core.type.AckFromSource;
import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.live.network.response.EnterRoomInfoResult;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.live.plugin_api.LivePluginSPIManager;
import com.bytedance.android.live.pushstream.model.LiveRequestSourceRole;
import com.bytedance.android.live.recharge.IMultiRechargeServiceExternal;
import com.bytedance.android.live.soloktv.IPlatformSoloKtvService;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.android.livesdk.chatroom.model.AudienceLeaveSourceEnum;
import com.bytedance.android.livesdk.chatroom.model.IApplyResult;
import com.bytedance.android.livesdk.chatroom.model.b1;
import com.bytedance.android.livesdk.chatroom.model.g1;
import com.bytedance.android.livesdk.chatroom.model.interact.EnlargeGuestInfo;
import com.bytedance.android.livesdk.chatroom.model.interact.v1;
import com.bytedance.android.livesdk.chatroom.model.y0;
import com.bytedance.android.livesdk.chatroom.viewmodel.LivePlayModeLogContext;
import com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget;
import com.bytedance.android.livesdk.chatroom.widget.j1;
import com.bytedance.android.livesdk.config.bc0;
import com.bytedance.android.livesdk.config.bj1;
import com.bytedance.android.livesdk.config.h30;
import com.bytedance.android.livesdk.config.ib0;
import com.bytedance.android.livesdk.config.rj1;
import com.bytedance.android.livesdk.config.sj1;
import com.bytedance.android.livesdk.config.sn;
import com.bytedance.android.livesdk.config.yl0;
import com.bytedance.android.livesdk.ktvapi.IKtvService;
import com.bytedance.android.livesdk.ktvapi.util.KtvCommonSettingHelper;
import com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvmode.view.secondleveltab.SongListItemViewHolder;
import com.bytedance.android.livesdk.link.model.bridge.g2;
import com.bytedance.android.livesdk.link.model.bridge.h1;
import com.bytedance.android.livesdk.link.model.bridge.z0;
import com.bytedance.android.livesdk.link.model.l6;
import com.bytedance.android.livesdk.link.model.u5;
import com.bytedance.android.livesdk.link.model.z5;
import com.bytedance.android.livesdk.live.extension.plugin.api.livepusher.ILiveWrappedLivePusher;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.bytedance.android.livesdk.message.model.ReplyType;
import com.bytedance.android.livesdk.message.model.ab;
import com.bytedance.android.livesdk.message.model.d9;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.android.livesdk.schema.interfaces.IBaseLiveActionHandler;
import com.bytedance.android.livesdk.utils.d5;
import com.bytedance.android.livesdk.utils.e5;
import com.bytedance.android.livesdk.utils.r2;
import com.bytedance.android.livesdk.widget.x0;
import com.bytedance.android.livesdk.wrds.LinkMicRoomDataSyncModel;
import com.bytedance.android.livesdkapi.depend.message.ClientUIInfo;
import com.bytedance.android.livesdkapi.depend.message.RoomLinkMicSyncData;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.RoomStampInfo;
import com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveTheme;
import com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveThemeKt;
import com.bytedance.android.livesdkapi.depend.model.live.circleinfo.ICircleInfo;
import com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkerBattleConnectContent;
import com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkerChangeMediaInfoContent;
import com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkerClientUIInfoChangeContent;
import com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkerKickOutContent;
import com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkerUILayoutChangeContent;
import com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkmicMediaParam;
import com.bytedance.android.livesdkapi.depend.model.live.linker.LinkerRemoveWaitingUserContent;
import com.bytedance.android.livesdkapi.depend.model.live.linker.LinkerSysKickOutContent;
import com.bytedance.android.livesdkapi.eventbus.HorizontalPlayEvent;
import com.bytedance.android.livesdkapi.model.ILiveLinkCameraBackUpConfig;
import com.bytedance.android.livesdkapi.model.ILiveLinkCameraBackUpConfigKt;
import com.bytedance.android.livesdkapi.model.SeiAppData;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.rxbus.RxBusAbility;
import com.bytedance.android.livesdkapi.multilink.IMultiLinkWRDSPreloadService;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.roomplayer.IRoomEventHub;
import com.bytedance.android.livesdkapi.util.IMultiSceneCommonStatistics;
import com.bytedance.common.utility.Lists;
import com.bytedance.common.utility.Logger;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.ies.sdk.widgets.WidgetManager;
import com.bytedance.kmp.live.livelink.api.model.VideoShowMode;
import com.bytedance.live.bizlink.api.platform.rtc.rtcinfo.MultiLinkInfoType;
import com.bytedance.live.bizlink.impl.platform.manager.MultiLinkGuestManager;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.livelink.kmp.api.base.config.InteractMode;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.gson.JsonObject;
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
import io.reactivex.subjects.PublishSubject;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import uf2.m1;
import w20.xc;
import zg1.a1;
import zg1.l3;
import zg1.r0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u00032\u00020\u00052\u00020\u00062\u00020\u00072\u00020\b2\u00020\t2\u00020\n2\u00020\u000b2\u00020\f2\u00020\r2\u00020\u000e2\u00020\u000f:\u0001\u0010¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/live/liveinteract/videotalk/MultiLinkVideoTalkRoomGuestWidget;", "Lcom/bytedance/android/live/liveinteract/plantform/widgt/videolink/MultiLinkVideoBaseGuestLinkWidget;", "Lcom/bytedance/android/live/liveinteract/plantform/base/k;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "Lyj0/a$a;", "Ltf0/o$a;", "Lzj0/e$b;", "Lmd0/a$a;", "Lm00/g$a;", "Lng6/b;", "Lng6/a;", "Lrj0/o;", "Lvlc/l;", "Lcom/bytedance/android/live/liveinteract/digitavatar/videoavatar/VideoDigitAvatarWidget$b;", "Lrj0/j;", "a", "videolink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class MultiLinkVideoTalkRoomGuestWidget extends MultiLinkVideoBaseGuestLinkWidget implements com.bytedance.android.live.liveinteract.plantform.base.k, Observer<KVData>, yj0.a.InterfaceC0294a, tf0.o.a, zj0.e.b, md0.a.InterfaceC0236a, ng6.b, ng6.a, rj0.o, vlc.l, VideoDigitAvatarWidget.b, rj0.j {
    public static final /* synthetic */ int i3 = 0;
    public long E2;
    public long F2;
    public final cj0.e G1;
    public long G2;
    public final com.bytedance.android.live.liveinteract.api.utils.j H0;
    public QuickInteractWidget H1;
    public boolean H2;
    public boolean I2;
    public boolean J2;
    public SeiAppData K2;
    public com.bytedance.android.live.liveinteract.utils.g0 L0;
    public LinkCastGuestWidget L1;
    public int L2;
    public InteractiveSongWidget M1;
    public final com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.u M2;
    public boolean N;
    public int N2;
    public boolean O;
    public String O2;
    public com.bytedance.android.live.liveinteract.plantform.core.h P;
    public com.bytedance.android.live.liveinteract.videotalk.utils.a P0;
    public CPositionWidget P1;
    public final Lazy P2;
    public Disposable Q;
    public RTSVideoWidget Q1;
    public final long Q2;
    public boolean R;
    public Disposable R2;
    public yj0.a S;
    public Widget S1;
    public final q S2;
    public tf0.o T;
    public Widget T1;
    public final j T2;
    public m00.g U;
    public boolean U2;
    public SwitchCameraManager V;
    public oe0.b V0;
    public boolean V1;
    public final com.bytedance.android.live.liveinteract.utils.k0 V2;
    public final HashMap<String, SurfaceView> W;
    public VideoDigitAvatarWidget W2;
    public MuteStateChecker X;
    public zj0.e X2;
    public x00.a Y;
    public MiddlewareRoomWidget Y2;
    public ToolbarVideoInteractBehavior Z;
    public final VideoEffectPerfHelper Z2;
    public View a3;
    public final ArrayList<ILinkPlayerInfoBridge> b1;
    public com.bytedance.android.live.liveinteract.plantform.utils.u b2;
    public final i b3;
    public int c3;
    public boolean d3;
    public Boolean e3;
    public j50.a f3;
    public final ArrayList<ILinkPlayerInfoBridge> g1;
    public int g2;
    public k50.c g3;
    public final HashMap<String, View> h1;
    public int h2;
    public final gd0.p h3;
    public InteractAnimationController k0;
    public final HashMap<String, Boolean> k1;
    public CPositionBeInvitedDialog p0;
    public boolean p1;
    public ClientUIInfo p2;
    public Disposable v1;
    public long v2;
    public boolean x1;
    public long x2;
    public LinkApplyType y1;
    public long y2;

    public static final class a {
    }

    public static final class a0 implements BannerWidget.a {
        public final /* synthetic */ MultiLinkVideoTalkRoomGuestWidget a;

        @Override // com.bytedance.android.live.liveinteract.banner.BannerWidget.a
        public final boolean a() {
            return true;
        }

        public a0(MultiLinkVideoTalkRoomGuestWidget r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.live.liveinteract.banner.BannerWidget.a
        public final void b(boolean r11, Map<String, String> r12) {
            IRoom r1 = this.a.getMRoom();
            MultiLinkVideoTalkRoomGuestWidget r2 = this.a;
            String r3 = r2.x.a;
            int r4 = r2.y;
            boolean r5 = r2.Pq();
            xf6.b r6 = this.a.Tq();
            if (r6 == null) goto L7;
            vf6.a r7 = r6.a9();
            if (r7 == null) goto L7;
            int r8 = r7.c;
        L8:
            int r9 = r8;
            TalkRoomLogUtils.e0(null, r1, r3, r4, r5, r9, r11, je0.d.Z(), this.a.A, r12);
            return;
        L7:
            r8 = 200;
            goto L8
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ Function0 a;
        public final /* synthetic */ int b;
        public final /* synthetic */ long c;

        public b(Function0 r1, int r2, long r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r5) {
            this.a.invoke();
            TalkRoomBusinessFullLinkMonitor r0 = TalkRoomBusinessFullLinkMonitor.a;
            int r1 = this.b;
            long r2 = this.c;
            String r6 = ((com.bytedance.android.live.network.response.a) r5).logId;
            r0.getClass();
            TalkRoomBusinessFullLinkMonitor.c(r1, r2, null, r6);
        }
    }

    public static final class b0 implements rj0.a {
        public final /* synthetic */ MultiLinkVideoTalkRoomGuestWidget a;
        public final /* synthetic */ sf0.e b;

        @Override // rj0.a
        public final boolean a() {
            return false;
        }

        @Override // rj0.a
        public final boolean b() {
            return true;
        }

        @Override // rj0.a
        public final void c() {
        }

        @Override // rj0.a
        public final vc0.a getSurfaceView() {
            IMiddlewareBroadcastService r1 = jc1.k.n(IMiddlewareBroadcastService.class);
            MultiLinkVideoTalkRoomGuestWidget r7 = this.a;
            m00.g r0 = r1.createVideoTalkView(((Widget) r7).context, "", true, false, false, r7);
            if (r0 == null) goto L9;
            com.bytedance.android.live.pushstream.d r2 = r0.getLiveStream();
            if (r2 == null) goto L8;
            r2.f1("open beauty dialog", new uv0.a(LiveRequestSourceRole.Business, "MultiLinkVideoTalkRoomGuestWidget.showVideoShowBeautyDialog.reply.stopAudio", null));
        L8:
            return new vc0.a(r0);
        L9:
            return null;
        }

        @Override // rj0.a
        public final void onConfirm() {
            cg6.a r0 = this.a.Bq();
            if (r0 == null) goto L7;
            MultiLinkGuestManager r1 = r0.W4();
            if (r1 == null) goto L7;
            r1.j(this.b);
        L7:
            TalkRoomBusinessFullLinkMonitor.a.getClass();
            TalkRoomBusinessFullLinkMonitor.V();
            com.bytedance.android.live.liveinteract.plantform.utils.x.L();
        }

        @Override // rj0.a
        public final String getCancelText() {
            if (vm2.d.b0() == true) goto L7;
            return "";
        L7:
            return s1.B(2131917572);
        }

        @Override // rj0.a
        public final String getConfirmText() {
            if (vm2.d.b0() == false) goto L6;
            return s1.B(2131917573);
        L6:
            return s1.B(2131917566);
        }

        @Override // rj0.a
        public final void onCancel() {
            if (vm2.d.b0() == false) goto L13;
            jy0.b.f("KtvDigitAvatar", "beauty dialog user change show mode to audio", null, 4);
            DigitAvatarContext r0 = DigitAvatarContext.Companion.getContext();
            if (r0 == null) goto L7;
            DigitAvatarContext.setVideoShowMode$default(r0, VideoShowMode.AUDIO, null, 2, null);
        L7:
            this.b.e = 2;
            cg6.a r1 = this.a.Bq();
            if (r1 == null) goto L14;
            MultiLinkGuestManager r2 = r1.W4();
            if (r2 == null) goto L15;
            r2.j(this.b);
            return;
        L15:
            return;
        L14:
            return;
        }

        public b0(MultiLinkVideoTalkRoomGuestWidget r1, sf0.e r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ Function1 a;
        public final /* synthetic */ int b;
        public final /* synthetic */ long c;

        public c(Function1 r1, int r2, long r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r5) {
            Throwable r6 = (Throwable) r5;
            this.a.invoke(r6);
            TalkRoomBusinessFullLinkMonitor r0 = TalkRoomBusinessFullLinkMonitor.a;
            int r1 = this.b;
            long r2 = this.c;
            r0.getClass();
            TalkRoomBusinessFullLinkMonitor.b(r1, r2, r6);
            if ((r6 instanceof ApiServerException) == false) goto L13;
            String r7 = com.bytedance.android.live.broadcastgame.api.openplatform.h.b(r6);
            if (r7 != null) goto L7;
            return;
        L7:
            if (r7.length() <= 0) goto L9;
            boolean r3 = true;
        L10:
            if (r3 == false) goto L17;
            f2.c(r7, 0);
            return;
        L17:
            return;
        L9:
            r3 = false;
            goto L10
        L13:
            if (this.b != 0) goto L19;
            f2.c(s1.B(2131917744), 0);
            return;
        }
    }

    public static final class c0 implements rj0.a {
        public final /* synthetic */ MultiLinkVideoTalkRoomGuestWidget a;
        public final /* synthetic */ sf0.a b;

        @Override // rj0.a
        public final boolean a() {
            return false;
        }

        @Override // rj0.a
        public final boolean b() {
            return true;
        }

        @Override // rj0.a
        public final void c() {
        }

        @Override // rj0.a
        public final vc0.a getSurfaceView() {
            IMiddlewareBroadcastService r1 = jc1.k.n(IMiddlewareBroadcastService.class);
            MultiLinkVideoTalkRoomGuestWidget r7 = this.a;
            m00.g r0 = r1.createVideoTalkView(((Widget) r7).context, "", true, false, false, r7);
            if (r0 == null) goto L9;
            com.bytedance.android.live.pushstream.d r2 = r0.getLiveStream();
            if (r2 == null) goto L8;
            r2.f1("open beauty dialog", new uv0.a(LiveRequestSourceRole.Business, "MultiLinkVideoTalkRoomGuestWidget.showVideoShowBeautyDialog.apply.stopAudio", null));
        L8:
            return new vc0.a(r0);
        L9:
            return null;
        }

        @Override // rj0.a
        public final void onConfirm() {
            cg6.a r0 = this.a.Bq();
            if (r0 == null) goto L8;
            MultiLinkGuestManager r1 = r0.W4();
            if (r1 == null) goto L9;
            r1.d(this.b);
            return;
        L9:
            return;
        }

        @Override // rj0.a
        public final String getCancelText() {
            if (vm2.d.b0() == true) goto L7;
            return "";
        L7:
            return s1.B(2131917565);
        }

        @Override // rj0.a
        public final String getConfirmText() {
            return s1.B(2131917566);
        }

        @Override // rj0.a
        public final void onCancel() {
            if (vm2.d.b0() == false) goto L13;
            jy0.b.f("KtvDigitAvatar", "beauty dialog user change show mode to audio", null, 4);
            DigitAvatarContext r0 = DigitAvatarContext.Companion.getContext();
            if (r0 == null) goto L7;
            DigitAvatarContext.setVideoShowMode$default(r0, VideoShowMode.AUDIO, null, 2, null);
        L7:
            this.b.r = 2;
            cg6.a r1 = this.a.Bq();
            if (r1 == null) goto L14;
            MultiLinkGuestManager r2 = r1.W4();
            if (r2 == null) goto L15;
            r2.d(this.b);
            return;
        L15:
            return;
        L14:
            return;
        }

        public c0(MultiLinkVideoTalkRoomGuestWidget r1, sf0.a r2) {
            this.a = r1;
            this.b = r2;
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

    public static final class d0<T, R> implements Function {
        public static final d0 a = null;

        static {
            a = new d0();
        }

        public d0() {
        }

        public final Object apply(Object r3) {
            com.bytedance.android.live.network.response.e r4 = (com.bytedance.android.live.network.response.e) r3;
            Intrinsics.checkNotNullParameter(r4, "it");
            LinkMicRoomDataSyncModel r0 = LinkWRDSHelper.b();
            Intrinsics.checkNotNullParameter(r4, "response");
            return Single.create(new com.bytedance.android.live.liveinteract.wrds.g(r0, r4));
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ MultiLinkVideoTalkRoomGuestWidget a;
        public final /* synthetic */ Ref.ObjectRef b;
        public final /* synthetic */ long c;

        public e(MultiLinkVideoTalkRoomGuestWidget r1, Ref.ObjectRef r2, long r3) {
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

    public static final class e0<T> implements Consumer {
        public final /* synthetic */ MultiLinkVideoTalkRoomGuestWidget a;
        public final /* synthetic */ int b;
        public final /* synthetic */ int c;
        public final /* synthetic */ Integer d;
        public final /* synthetic */ long e;
        public final /* synthetic */ Boolean f;

        public e0(MultiLinkVideoTalkRoomGuestWidget r1, int r2, int r3, Integer r4, String r5, long r6, Boolean r8) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r6;
            this.f = r8;
        }

        public final void accept(Object r9) {
            com.bytedance.android.live.network.response.e r5 = (com.bytedance.android.live.network.response.e) r9;
            this.a.d3 = false;
            v1 r10 = (v1) r5.data;
            if (r10 == null) goto L14;
            ALogger.i("ttlive_link_video", "switchSceneApi success from=" + this.a.ur() + " resp=" + ((v1) r5.data));
            TalkRoomBusinessFullLinkMonitor r1 = TalkRoomBusinessFullLinkMonitor.a;
            int r2 = this.b;
            int r3 = this.c;
            Integer r4 = this.d;
            if (r4 == null) goto L8;
            int r6 = r4.intValue();
        L9:
            long r7 = this.e;
            r1.getClass();
            TalkRoomBusinessFullLinkMonitor.z0(r2, r3, r6, r7, r5);
            com.bytedance.android.live.liveinteract.plantform.utils.x.B0(this.b, this.c, this.d, r10.getPlayModes());
            this.a.getClass();
            if (Intrinsics.areEqual(this.f, Boolean.TRUE) == true) goto L15;
            TalkRoomLogUtils.h0(this.b, this.c);
            TalkRoomLogUtils.V(r10.getTotalApply(), r10.getTotalLinked(), this.b);
            return;
        L15:
            return;
        L8:
            r6 = 0;
            goto L9
        }
    }

    public static final class f implements xb6.b {
        public final /* synthetic */ MultiLinkVideoTalkRoomGuestWidget a;

        public final Pair<Boolean, String> a() {
            return xb6.b.a.k();
        }

        public final Pair<Boolean, String> b() {
            return xb6.b.a.a();
        }

        public final Pair<Boolean, String> c() {
            return xb6.b.a.b();
        }

        public final Pair<Boolean, String> e() {
            return xb6.b.a.e();
        }

        public final Pair<Boolean, String> g() {
            return xb6.b.a.l();
        }

        public final Pair<Boolean, String> h() {
            return xb6.b.a.g();
        }

        public final Pair<Boolean, String> k() {
            return xb6.b.a.i();
        }

        public final Pair<Boolean, String> m() {
            return xb6.b.a.c();
        }

        public f(MultiLinkVideoTalkRoomGuestWidget r1) {
            this.a = r1;
        }

        public final Pair<Boolean, String> d(z0 r2) {
            Intrinsics.checkNotNullParameter(r2, "msg");
            return xb6.b.a.f(r2);
        }

        public final Pair f(com.bytedance.android.live.liveinteract.multianchor.model.b r2) {
            Intrinsics.checkNotNullParameter(r2, "msg");
            return xb6.b.a.d(r2);
        }

        public final Pair<Boolean, String> j(z0 r6) {
            Intrinsics.checkNotNullParameter(r6, "msg");
            jy0.b.d("MultiLinkVideoTalkRoomGuestWidget", "[PCLandscape] switch to portrait when receive permit msg");
            we0.b r0 = this.a.getLinkmicReturnRoomParams();
            r0.B = r6;
            Boolean r7 = Boolean.TRUE;
            r0.D = r7;
            com.bytedance.live.datacontext.n r1 = com.bytedance.android.live.liveinteract.api.utils.m.e(this.a).getLinkmicReturnRoomParams();
            if (r1 == null) goto L5;
            r1.setValue(r0);
        L5:
            xs2.b.a().post(new HorizontalPlayEvent(1, 0, "source_portrait_linkmic"));
            f2.b(2131917757, 0);
            return TuplesKt.to(r7, "pc horizontal need switch portrait before linkmic");
        }

        public final Pair<Boolean, String> l(h1 r2) {
            Intrinsics.checkNotNullParameter(r2, "msg");
            return xb6.b.a.m(r2);
        }

        public final Pair<Boolean, String> i(long r14, String r16, String r17, int r18, int r19) {
            Intrinsics.checkNotNullParameter(r16, "secToUserId");
            Intrinsics.checkNotNullParameter(r17, "toUserIdString");
            jy0.b.d("MultiLinkVideoTalkRoomGuestWidget", "[PCLandscape] switch to portrait when reply");
            we0.b r1 = this.a.getLinkmicReturnRoomParams();
            Boolean r11 = Boolean.TRUE;
            r1.D = r11;
            r1.F = new sf0.e(r14, r16, r17, r18, r19, 32, 0);
            com.bytedance.live.datacontext.n r2 = com.bytedance.android.live.liveinteract.api.utils.m.e(this.a).getLinkmicReturnRoomParams();
            if (r2 == null) goto L5;
            r2.setValue(r1);
        L5:
            xs2.b.a().post(new HorizontalPlayEvent(1, 0, "source_portrait_linkmic"));
            f2.b(2131917757, 0);
            return TuplesKt.to(r11, "pc horizontal need switch portrait before linkmic");
        }
    }

    public static final class f0<T> implements Consumer {
        public final /* synthetic */ MultiLinkVideoTalkRoomGuestWidget a;
        public final /* synthetic */ int b;
        public final /* synthetic */ int c;
        public final /* synthetic */ Integer d;
        public final /* synthetic */ String e;
        public final /* synthetic */ long f;

        public f0(MultiLinkVideoTalkRoomGuestWidget r1, int r2, int r3, Integer r4, String r5, long r6) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
        }

        public final void accept(Object r9) {
            Throwable r10 = (Throwable) r9;
            this.a.d3 = false;
            TalkRoomBusinessFullLinkMonitor r0 = TalkRoomBusinessFullLinkMonitor.a;
            int r2 = this.b;
            int r3 = this.c;
            Integer r4 = this.d;
            if (r4 == null) goto L5;
            int r5 = r4.intValue();
        L6:
            String r1 = this.e;
            if (r1 != null) goto L9;
            r1 = "";
        L9:
            long r6 = this.f;
            r0.getClass();
            int r7 = r5;
            TalkRoomBusinessFullLinkMonitor.y0(r2, r3, r7, r1, r6, r10);
            com.bytedance.android.live.liveinteract.plantform.utils.x.A0(this.b, this.c, r10, this.d);
            ExceptionUtils.handleException(((Widget) this.a).context, r10);
            return;
        L5:
            r5 = 0;
            goto L6
        }
    }

    public static final class g implements DialogInterface.OnClickListener {
        public final /* synthetic */ MultiLinkVideoTalkRoomGuestWidget a;
        public final /* synthetic */ Runnable b;

        public g(MultiLinkVideoTalkRoomGuestWidget r1, Runnable r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r2, int r3) {
            r2.dismiss();
            MultiLinkVideoTalkRoomGuestWidget r4 = this.a;
            Runnable r5 = this.b;
            int r0 = MultiLinkVideoTalkRoomGuestWidget.i3;
            r4.H = r5;
            xf6.b r6 = r4.Tq();
            if (r6 == null) goto L6;
            r6.F3("leave_normally");
            return;
        }
    }

    public static final class g0<T> implements Consumer {
        public final /* synthetic */ we0.b a;
        public final /* synthetic */ MultiLinkVideoTalkRoomGuestWidget b;

        public g0(we0.b r1, MultiLinkVideoTalkRoomGuestWidget r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r6) {
            Long r7 = (Long) r6;
            FragmentActivity r8 = ((Widget) this.b).context;
            if (r8 == null) goto L19;
            FragmentManager r9 = r8.getSupportFragmentManager();
            LinkResultDialogFragment.l.getClass();
            String r1 = LinkResultDialogFragment.k;
            if (r9.findFragmentByTag(r1) != null) goto L17;
            MultiLinkVideoTalkRoomGuestWidget r10 = this.b;
            LinkResultDialogFragmentV2.a r2 = LinkResultDialogFragmentV2.u;
            ILinkerKickOutContent r3 = this.a.G;
            Intrinsics.checkNotNull(r3);
            AudienceLeaveSourceEnum r4 = AudienceLeaveSourceEnum.AudienceLeave_Kick_Out;
            r2.getClass();
            LinkResultDialogFragmentV2 r5 = LinkResultDialogFragmentV2.a.b(r3, r4, null);
            int r11 = MultiLinkVideoTalkRoomGuestWidget.i3;
            r10.M = r5;
            MultiLinkVideoTalkRoomGuestWidget r12 = this.b;
            LinkResultDialogFragmentV2 r13 = r12.M;
            if (r13 == null) goto L23;
            FragmentActivity r14 = ((Widget) r12).context;
            if (r14 == null) goto L16;
            FragmentManager r15 = r14.getSupportFragmentManager();
            LandscapeRestrictionOperation r0 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW_NOW;
            LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r13, r1, r0);
            if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r15, r13, r0) == true) goto L25;
            DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L20
        L14:
            r13.showNow(r15, r1);
            return;
        L25:
            return;
        L16:
            throw new NullPointerException("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
        L23:
            return;
        L17:
            return;
        L19:
            throw new NullPointerException("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
        }
    }

    public static final class h implements DialogInterface.OnClickListener {
        public static final h a = null;

        static {
            a = new h();
        }

        public h() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r1, int r2) {
            r1.dismiss();
        }
    }

    public static final class h0<T> implements Consumer {
        public final /* synthetic */ we0.b a;
        public final /* synthetic */ MultiLinkVideoTalkRoomGuestWidget b;

        public h0(we0.b r1, MultiLinkVideoTalkRoomGuestWidget r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r6) {
            Long r7 = (Long) r6;
            FragmentActivity r8 = ((Widget) this.b).context;
            if (r8 == null) goto L19;
            FragmentManager r9 = r8.getSupportFragmentManager();
            LinkResultDialogFragment.l.getClass();
            String r1 = LinkResultDialogFragment.k;
            if (r9.findFragmentByTag(r1) != null) goto L17;
            MultiLinkVideoTalkRoomGuestWidget r10 = this.b;
            LinkResultDialogFragmentV2.a r2 = LinkResultDialogFragmentV2.u;
            LinkerSysKickOutContent r3 = this.a.H;
            Intrinsics.checkNotNull(r3);
            AudienceLeaveSourceEnum r4 = AudienceLeaveSourceEnum.AudienceLeave_Sys_Kick_Out;
            r2.getClass();
            LinkResultDialogFragmentV2 r5 = LinkResultDialogFragmentV2.a.c(r3, r4, null);
            int r11 = MultiLinkVideoTalkRoomGuestWidget.i3;
            r10.M = r5;
            MultiLinkVideoTalkRoomGuestWidget r12 = this.b;
            LinkResultDialogFragmentV2 r13 = r12.M;
            if (r13 == null) goto L23;
            FragmentActivity r14 = ((Widget) r12).context;
            if (r14 == null) goto L16;
            FragmentManager r15 = r14.getSupportFragmentManager();
            LandscapeRestrictionOperation r0 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW_NOW;
            LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r13, r1, r0);
            if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r15, r13, r0) == true) goto L25;
            DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L20
        L14:
            r13.showNow(r15, r1);
            return;
        L25:
            return;
        L16:
            throw new NullPointerException("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
        L23:
            return;
        L17:
            return;
        L19:
            throw new NullPointerException("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
        }
    }

    public static final class i implements View.OnLayoutChangeListener {
        public final /* synthetic */ MultiLinkVideoTalkRoomGuestWidget a;

        public i(MultiLinkVideoTalkRoomGuestWidget r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
            if (this.a.isViewValid() == true) goto L5;
            return;
        L5:
            tf0.o r10 = this.a.T;
            if (r10 == null) goto L9;
            r10.y(r1.getWidth(), r1.getHeight());
            return;
        }
    }

    public static final class i0<T> implements Consumer {
        public final /* synthetic */ we0.b a;
        public final /* synthetic */ MultiLinkVideoTalkRoomGuestWidget b;

        public i0(we0.b r1, MultiLinkVideoTalkRoomGuestWidget r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r6) {
            Long r7 = (Long) r6;
            FragmentActivity r8 = ((Widget) this.b).context;
            if (r8 == null) goto L19;
            FragmentManager r9 = r8.getSupportFragmentManager();
            LinkResultDialogFragment.l.getClass();
            String r1 = LinkResultDialogFragment.k;
            if (r9.findFragmentByTag(r1) != null) goto L17;
            MultiLinkVideoTalkRoomGuestWidget r10 = this.b;
            LinkResultDialogFragmentV2.a r2 = LinkResultDialogFragmentV2.u;
            g1 r3 = this.a.I;
            Intrinsics.checkNotNull(r3);
            AudienceLeaveSourceEnum r4 = AudienceLeaveSourceEnum.AudienceLeave_Leave;
            r2.getClass();
            LinkResultDialogFragmentV2 r5 = LinkResultDialogFragmentV2.a.a(r3, r4, null);
            int r11 = MultiLinkVideoTalkRoomGuestWidget.i3;
            r10.M = r5;
            MultiLinkVideoTalkRoomGuestWidget r12 = this.b;
            LinkResultDialogFragmentV2 r13 = r12.M;
            if (r13 == null) goto L23;
            FragmentActivity r14 = ((Widget) r12).context;
            if (r14 == null) goto L16;
            FragmentManager r15 = r14.getSupportFragmentManager();
            LandscapeRestrictionOperation r0 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW_NOW;
            LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r13, r1, r0);
            if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r15, r13, r0) == true) goto L25;
            DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L20
        L14:
            r13.showNow(r15, r1);
            return;
        L25:
            return;
        L16:
            throw new NullPointerException("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
        L23:
            return;
        L17:
            return;
        L19:
            throw new NullPointerException("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
        }
    }

    public static final class j extends com.bytedance.android.live.liveinteract.plantform.base.i.d {
        public final /* synthetic */ MultiLinkVideoTalkRoomGuestWidget a;

        public j(MultiLinkVideoTalkRoomGuestWidget r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.live.liveinteract.plantform.base.i.d, com.bytedance.android.live.liveinteract.plantform.base.i.b
        public final void onOnlineListChanged(List<ILinkPlayerInfoBridge> r20) {
            ArrayList r1 = new ArrayList();
            if (r20 == null) goto L5;
            List<ILinkPlayerInfoBridge> r2 = r20;
            r1.addAll(r2);
            this.a.b1.clear();
            this.a.b1.addAll(r2);
            com.bytedance.android.live.liveinteract.plantform.utils.t.a(r20);
        L5:
            this.a.G1.k(r1);
            if (this.a.mr() == 16) goto L8;
            com.bytedance.android.livesdk.chatroom.utils.g0.e(r1.size());
        L8:
            ((Widget) this.a).dataCenter.put("data_online_changed_list", r1);
            bn0.b r3 = this.a.getMultiLinkRoomScope();
            if (r3 == null) goto L15;
            jn0.b r4 = jn0.c.a(r3);
            if (r4 == null) goto L15;
            BehaviorSubject<List<ILinkPlayerInfoBridge>> r5 = r4.Xh();
            if (r5 == null) goto L15;
            r5.onNext(r1);
        L15:
            if (r20 == null) goto L118;
            Iterator<T> r6 = r20.iterator();
        L18:
            if (r6.hasNext() == false) goto L26;
            Object r7 = r6.next();
            IBaseUser r8 = ((ILinkPlayerInfoBridge) r7).getUser();
            if (r8 == null) goto L22;
            String r9 = r8.getIdString();
        L24:
            if (Intrinsics.areEqual(r9, je0.d.b0()) == false) goto L18;
        L27:
            ILinkPlayerInfoBridge r10 = (ILinkPlayerInfoBridge) r7;
            if (r10 == null) goto L119;
            MultiLinkVideoTalkRoomGuestWidget r11 = this.a;
            r11.getClass();
            ILiveLinkCameraBackUpConfig r12 = vm2.g.c();
            if (ILiveLinkCameraBackUpConfigKt.supportMsgUpdateForAudience(r12) == false) goto L96;
            IBaseUser r13 = r10.getUser();
            if (r13 == null) goto L35;
            String r14 = r13.getIdString();
        L37:
            if ((!Intrinsics.areEqual(r14, je0.d.b0())) == true) goto L96;
            if (r10.isBackground() == true) goto L96;
            if (r11.l == true) goto L96;
            if (r10.getLinkType() != 2) goto L77;
            m00.g r15 = r11.U;
            if (r15 == null) goto L49;
            Boolean r16 = Boolean.valueOf(r15.isCameraOpen());
        L51:
            if (jc1.k.n(IKtvService.class).currentIsMultipleKtvMode() == false) goto L53;
        L54:
            je0.d.G();
        L55:
            m00.g r17 = r11.U;
            if (r17 != null) goto L58;
        L78:
            uf2.d0 r18 = r11.getLiveCore();
            if (r18 == null) goto L81;
            Boolean r19 = Boolean.valueOf(r18.t0());
        L83:
            if (r10.getSilenceStatus() != 0) goto L85;
            r11.h2 = 0;
            goto L96
        L85:
            if (Intrinsics.areEqual(r19, Boolean.FALSE) == false) goto L94;
            int r21 = r11.h2 + 1;
            r11.h2 = r21;
            Set<Long> r22 = InteractLinkFullLinkMonitor.a;
            InteractLinkFullLinkMonitor.y(r21, null, r19, r10.getSilenceStatus(), r10.getLinkType());
            if (r11.h2 < ILiveLinkCameraBackUpConfigKt.getSafeMaxDiffCount(r12)) goto L96;
            jg6.a r23 = r11.Eq();
            if (r23 == null) goto L93;
            kg6.e r24 = r23.b();
            if (r24 == null) goto L93;
            r24.t(new kg6.b(false, false, "link security", 8));
        L93:
            r11.h2 = 0;
            goto L96
        L94:
            r11.h2 = 0;
            goto L96
        L81:
            r19 = null;
            goto L83
        L58:
            if (Intrinsics.areEqual(r16, Boolean.TRUE) == true) goto L60;
        L76:
            r11.g2 = 0;
            goto L78
        L60:
            if (r17.s() == true) goto L76;
            int r110 = r11.g2 + 1;
            r11.g2 = r110;
            Set<Long> r111 = InteractLinkFullLinkMonitor.a;
            InteractLinkFullLinkMonitor.y(r110, Boolean.valueOf(!r16.booleanValue()), null, r10.getSilenceStatus(), r10.getLinkType());
            if (r11.g2 < ILiveLinkCameraBackUpConfigKt.getSafeMaxDiffCount(r12)) goto L78;
            nd0.c.o(nd0.c.a, LinkMonitorData.MuteLiveCoreVideoForLinkSecurity, new JSONObject(), 0, null, false, 28);
            r17.closeCamera();
            r11.g2 = 0;
            ViewGroup r25 = ((Widget) r11).containerView;
            if (r25 == null) goto L66;
            r25.post(new com.bytedance.android.live.liveinteract.videotalk.c0(r11, r10, r12));
        L66:
            int r26 = r10.getLinkType();
            int r112 = com.bytedance.android.live.liveinteract.plantform.utils.x.a;
            LinkedHashMap r113 = new LinkedHashMap();
            r113.put("is_camera_capture", r16);
            if (r26 == 1) goto L74;
            if (r26 != 2) goto L70;
            String r27 = "audio";
        L75:
            r113.put("server_link_type", r27);
            com.bytedance.android.live.liveinteract.plantform.utils.x.t0("video_state_conflict", r113);
            goto L78
        L70:
            if (r26 == 3) goto L72;
            r27 = "unknown:" + r26;
            goto L75
        L72:
            r27 = "avatar";
            goto L75
        L74:
            r27 = "video";
            goto L75
        L53:
            if (jc1.k.n(IKtvService.class).currentIsAudienceSingEnable() == false) goto L55;
        L49:
            r16 = null;
            goto L51
        L77:
            r11.g2 = 0;
            goto L78
        L35:
            r14 = null;
        L96:
            MultiLinkVideoTalkRoomGuestWidget r28 = this.a;
            r28.getClass();
            IBaseUser r29 = r10.getUser();
            if (r29 == null) goto L99;
            String r30 = r29.getIdString();
        L101:
            if ((!Intrinsics.areEqual(r30, je0.d.b0())) == false) goto L104;
            return;
        L104:
            if (r10.isBackground() == false) goto L106;
            return;
        L106:
            if (r28.l == false) goto L109;
            return;
        L109:
            if (r10.getLinkType() != 1) goto L124;
            ne0.c r31 = r28.G;
            if (r31 == null) goto L121;
            r31.d0(sh0.e0.b, null);
            return;
        L121:
            return;
        L124:
            return;
        L99:
            r30 = null;
            goto L101
        L119:
            return;
        L22:
            r9 = null;
            goto L24
        L26:
            r7 = null;
            goto L27
        }

        @Override // com.bytedance.android.live.liveinteract.plantform.base.i.d, com.bytedance.android.live.liveinteract.plantform.base.i.b
        public final void a(String r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "userId");
            this.a.h1.remove(r3);
            tf0.o r4 = this.a.T;
            if (r4 == null) goto L5;
            r4.t(r3);
        L5:
            com.bytedance.android.live.liveinteract.plantform.commonwindow.utils.e.a r5 = com.bytedance.android.live.liveinteract.plantform.commonwindow.utils.e.c;
            MultiLinkVideoTalkRoomGuestWidget r0 = this.a;
            r5.getClass();
            com.bytedance.android.live.liveinteract.plantform.commonwindow.utils.e.a.c("user leaved", r3, r0);
        }

        @Override // com.bytedance.android.live.liveinteract.plantform.base.i.d, com.bytedance.android.live.liveinteract.plantform.base.i.b
        public final void d(List<ILinkPlayerInfoBridge> r3, List<ILinkPlayerInfoBridge> r4) {
            if (r4 == null) goto L4;
            this.a.g1.clear();
            this.a.g1.addAll(r4);
        L4:
            int r0 = 0;
            if (r3 == null) goto L7;
            int r5 = r3.size();
        L8:
            if (r4 == null) goto L10;
            r0 = r4.size();
        L10:
            com.bytedance.android.livesdk.chatroom.utils.g0.e(r5 + r0);
            hg6.g r6 = this.a.P2();
            if (r6 == null) goto L14;
            r6.f();
            return;
        L14:
            return;
        L7:
            r5 = 0;
            goto L8
        }

        @Override // com.bytedance.android.live.liveinteract.plantform.base.i.d, com.bytedance.android.live.liveinteract.plantform.base.i.b
        public final void n(List<ILinkPlayerInfoBridge> r3, long r4, n0 r6) {
            Intrinsics.checkNotNullParameter(r3, "list");
            String r5 = null;
            if (gd0.v.a(((Integer) ((Widget) this.a).dataCenter.get("data_link_state", 0)).intValue(), 32) == false) goto L32;
            IMiddlewareUserService r7 = jc1.k.f(IMiddlewareUserService.class);
            if (r7 == null) goto L9;
            com.bytedance.android.livesdk.user.e r8 = r7.user();
            if (r8 == null) goto L9;
            String r9 = r8.n();
        L10:
            if (r9 == null) goto L32;
            if (vm2.d.k() == false) goto L21;
            if (r6 == null) goto L17;
            IBaseUser r10 = r6.getUserFlex();
            if (r10 == null) goto L17;
            String r11 = r10.getIdString();
        L19:
            if (Intrinsics.areEqual(r11, r9) == false) goto L32;
            hd0.c.f().k(1);
        L17:
            r11 = null;
            goto L19
        L21:
            Iterator r12 = ((CopyOnWriteArrayList) r3).iterator();
        L23:
            if (r12.hasNext() == false) goto L32;
            IBaseUser r0 = ((ILinkPlayerInfoBridge) r12.next()).getUser();
            if (r0 == null) goto L27;
            String r1 = r0.getIdString();
        L29:
            if (Intrinsics.areEqual(r1, r9) == false) goto L23;
            hd0.c.f().k(1);
            goto L32
        L27:
            r1 = null;
        L9:
            r9 = null;
        L32:
            if (jc1.k.n(IMiddlewareUserService.class).user().c() == false) goto L68;
            String r13 = "";
            if (Lists.isEmpty(r3) == false) goto L38;
            DataCenter r14 = ((Widget) this.a).dataCenter;
            if (r14 == null) goto L69;
            r14.put("data_video_talk_dot_with_number_show", "");
            return;
        L69:
            return;
        L38:
            com.bytedance.android.live.liveinteract.plantform.base.k.n0.getClass();
            com.bytedance.android.live.liveinteract.plantform.base.k r15 = com.bytedance.android.live.liveinteract.plantform.base.k.a.a();
            if (r15 == null) goto L45;
            com.bytedance.android.live.liveinteract.plantform.base.i<ILinkPlayerInfoBridge> r16 = r15.getLinkUserInfoCenter();
            if (r16 == null) goto L45;
            List<T> r17 = r16.V4();
            if (r17 == 0) goto L45;
            Integer r18 = Integer.valueOf(r17.size());
        L47:
            if (r18 != null) goto L49;
        L51:
            if (r18 == null) goto L53;
            r5 = String.valueOf(r18.intValue());
        L53:
            if (r18 != null) goto L55;
        L60:
            r13 = r5;
        L61:
            DataCenter r19 = ((Widget) this.a).dataCenter;
            if (r19 == null) goto L71;
            r19.put("data_video_talk_dot_with_number_show", r13);
            return;
        L71:
            return;
        L55:
            if (r18.intValue() <= 99) goto L58;
            r5 = "99+";
        L58:
            if (r18.intValue() > 0) goto L60;
        L49:
            if (r18.intValue() > 99) goto L51;
            r18 = Integer.valueOf(r18.intValue() + fj0.e.a());
        L45:
            r18 = null;
            goto L47
        }
    }

    public static final class j0<T> implements Consumer {
        public final /* synthetic */ String a;
        public final /* synthetic */ long b;
        public final /* synthetic */ long c;
        public final /* synthetic */ String d;

        public j0(String r1, long r2, long r4, String r6) {
            this.a = r1;
            this.b = r2;
            this.c = r4;
            this.d = r6;
        }

        public final void accept(Object r9) {
            com.bytedance.android.live.network.response.e r10 = (com.bytedance.android.live.network.response.e) r9;
            TalkRoomBusinessFullLinkMonitor r0 = TalkRoomBusinessFullLinkMonitor.a;
            String r1 = this.a;
            long r3 = this.b;
            long r5 = this.c;
            String r7 = r10.logId;
            r0.getClass();
            TalkRoomBusinessFullLinkMonitor.t(r1, true, r3, r5, r7);
            DATA r2 = r10.data;
            if (r2 == 0) goto L8;
            Intrinsics.checkNotNull(r2);
            if (TextUtils.isEmpty(((y0) r2).getPrompts()) == true) goto L8;
            DATA r11 = r10.data;
            Intrinsics.checkNotNull(r11);
            f2.c(((y0) r11).getPrompts(), 0);
            return;
        L8:
            if ((!Intrinsics.areEqual(this.a, je0.d.b0())) == true) goto L10;
            return;
        L10:
            if (TextUtils.equals(this.d, "add") == false) goto L12;
            f2.b(2131922754, 0);
            return;
        L12:
            f2.b(2131922715, 0);
        }
    }

    public static final class k<T> implements Consumer {
        public final /* synthetic */ MultiLinkVideoTalkRoomGuestWidget a;

        public k(MultiLinkVideoTalkRoomGuestWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            Integer r5 = (Integer) r4;
            int r0 = ((IInteractService) jc1.k.n(IInteractService.class)).getCurrentScene();
            hg6.g r1 = this.a.P2();
            if (r1 == null) goto L5;
            r1.D(r0, "ktvPlayModeChanged");
        L5:
            if (r5 != null) goto L8;
            return;
        L8:
            if (r5.intValue() != 0) goto L18;
            hg6.g r6 = this.a.P2();
            if (r6 == null) goto L14;
            ig6.a r7 = r6.x();
            if (r7 == null) goto L14;
            r7.b(MultiLinkInfoType.KTV_COMPONENT);
        L14:
            hg6.g r8 = this.a.P2();
            if (r8 == null) goto L19;
            r8.K();
            return;
        L19:
            return;
        }
    }

    public static final class k0<T> implements Consumer {
        public final /* synthetic */ String a;
        public final /* synthetic */ long b;
        public final /* synthetic */ long c;

        public k0(String r1, long r2, long r4) {
            this.a = r1;
            this.b = r2;
            this.c = r4;
        }

        public final void accept(Object r8) {
            ApiServerException r9 = (Throwable) r8;
            TalkRoomBusinessFullLinkMonitor r0 = TalkRoomBusinessFullLinkMonitor.a;
            String r1 = this.a;
            long r3 = this.b;
            long r5 = this.c;
            r0.getClass();
            TalkRoomBusinessFullLinkMonitor.r(r1, true, r3, r5, r9);
            if ((r9 instanceof ApiServerException) == false) goto L13;
            ApiServerException r10 = r9;
            String r2 = r10.getPrompt();
            if (r2 != null) goto L7;
        L10:
            boolean r4 = true;
        L11:
            if (r4 == true) goto L13;
            f2.c(r10.getPrompt(), 0);
            return;
        L7:
            if (r2.length() == 0) goto L10;
            r4 = false;
        L13:
            f2.b(2131922759, 0);
        }
    }

    public static final class l<T> implements Consumer {
        public final /* synthetic */ MultiLinkVideoTalkRoomGuestWidget a;

        public l(MultiLinkVideoTalkRoomGuestWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            if (((Boolean) r3).booleanValue() == false) goto L5;
            int r4 = 4;
        L6:
            hg6.g r0 = this.a.P2();
            if (r0 == null) goto L10;
            r0.X(r4, "currentUserSingerChanged");
            return;
        L10:
            return;
        L5:
            r4 = 3;
            goto L6
        }
    }

    public static final class m implements js0.b {
        public m() {
        }

        @Override // js0.b
        public final void onSuccess(String r2) {
            Intrinsics.checkNotNullParameter(r2, "track");
            ((IMiddlewareBroadcastService) va1.b.a.a.a(IMiddlewareBroadcastService.class)).linkEffectHelper();
        }
    }

    public static final class n<T> implements Consumer {
        public final /* synthetic */ MultiLinkVideoTalkRoomGuestWidget a;

        public n(MultiLinkVideoTalkRoomGuestWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            Long r3 = (Long) r2;
            DigitAvatarContext r4 = DigitAvatarContext.Companion.getContext();
            if (r4 == null) goto L5;
            r4.setIsDigitAvatarLoaded(true);
        L5:
            jg6.a r5 = this.a.Eq();
            if (r5 == null) goto L10;
            lh6.b r6 = r5.a();
            if (r6 == null) goto L10;
            ng6.c.a.a(r6, false);
        L10:
            jy0.b.d("VideoDigitAvatar", "digit avatar load success , digitAvatarReadyPublishStream");
        }
    }

    public static final class o<T> implements Consumer {
        public static final o a = null;

        static {
            a = new o();
        }

        public o() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object r1) {
            Throwable r2 = (Throwable) r1;
        }
    }

    public static final class p implements MediaOperation.a {
        public p() {
        }

        @Override // com.bytedance.android.live.liveinteract.linkbase.api.MediaOperation.a
        public final void onError(Throwable r1) {
        }

        @Override // com.bytedance.android.live.liveinteract.linkbase.api.MediaOperation.a
        public final void onSuccess() {
            f2.b(2131918610, 0);
        }
    }

    public static final class q implements InteractLiveCorePermissionGuarantor.a {
        public final /* synthetic */ MultiLinkVideoTalkRoomGuestWidget a;

        public static final class a<T> implements Consumer {
            public final /* synthetic */ q a;
            public final /* synthetic */ boolean b;

            public a(q r1, boolean r2) {
                this.a = r1;
                this.b = r2;
            }

            public final void accept(Object r3) {
                Long r4 = (Long) r3;
                if (this.b == false) goto L5;
                MultiLinkVideoTalkRoomGuestWidget r5 = this.a.a;
                int r0 = MultiLinkVideoTalkRoomGuestWidget.i3;
                r5.yr("on particular white page show");
                return;
            L5:
                MultiLinkVideoTalkRoomGuestWidget r6 = this.a.a;
                int r1 = MultiLinkVideoTalkRoomGuestWidget.i3;
                r6.xr("on particular white page close", false);
            }
        }

        public q(MultiLinkVideoTalkRoomGuestWidget r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.live.liveinteract.utils.InteractLiveCorePermissionGuarantor.a
        public final void a(boolean r3) {
            if (r3 == false) goto L5;
            MultiLinkVideoTalkRoomGuestWidget r4 = this.a;
            int r0 = MultiLinkVideoTalkRoomGuestWidget.i3;
            r4.xr("on particular page show", true);
            return;
        L5:
            if (vm2.d.g() == false) goto L8;
            WeakReference r5 = com.bytedance.android.live.core.utils.a.a;
            if (com.bytedance.android.live.core.utils.a.e(this.a.getContext()) == true) goto L8;
            return;
        L8:
            MultiLinkVideoTalkRoomGuestWidget r6 = this.a;
            int r1 = MultiLinkVideoTalkRoomGuestWidget.i3;
            r6.yr("on particular page close");
        }

        @Override // com.bytedance.android.live.liveinteract.utils.InteractLiveCorePermissionGuarantor.a
        public final void b(boolean r5) {
            jy0.b.a("MultiLinkVideoTalkRoomGuestWidget", "onKeepAudioTargetPageShow, isShow: " + r5);
            Disposable r0 = this.a.R2;
            if (r0 == null) goto L5;
            r0.dispose();
        L5:
            MultiLinkVideoTalkRoomGuestWidget r1 = this.a;
            r1.R2 = RxUtilKt.h(Observable.timer(r1.Q2, TimeUnit.MILLISECONDS)).subscribe(new a(this, r5));
        }
    }

    public static final class r<T> implements Consumer {
        public final /* synthetic */ MultiLinkVideoTalkRoomGuestWidget a;

        public r(MultiLinkVideoTalkRoomGuestWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            fd2.z r3 = (fd2.z) r2;
            com.bytedance.android.live.liveinteract.spatial.b.a("MultiLinkVideoTalkRoomGuestWidget", "onKtvSingerStateChanged updateSpatialAudioPosition------");
            MultiLinkVideoTalkRoomGuestWidget r4 = this.a;
            tf0.o r0 = r4.T;
            if (r0 == null) goto L6;
            r0.u(Boolean.valueOf(r4.isEngineOn()));
            return;
        }
    }

    public static final class s<T> implements Consumer {
        public final /* synthetic */ MultiLinkVideoTalkRoomGuestWidget a;

        public s(MultiLinkVideoTalkRoomGuestWidget r1) {
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
            com.bytedance.android.live.liveinteract.spatial.b.a("MultiLinkVideoTalkRoomGuestWidget", r0.toString());
            hg6.g r3 = this.a.P2();
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
            MultiLinkVideoTalkRoomGuestWidget r7 = this.a;
            tf0.o r8 = r7.T;
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

    public static final class t<T> implements Consumer {
        public final /* synthetic */ MultiLinkVideoTalkRoomGuestWidget a;

        public t(MultiLinkVideoTalkRoomGuestWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r5) {
            o42.g r6 = (o42.g) r5;
            Intrinsics.checkNotNullParameter(r6, "t");
            MultiLinkVideoTalkRoomGuestWidget r0 = this.a;
            int r1 = MultiLinkVideoTalkRoomGuestWidget.i3;
            r0.getClass();
            IBaseUser r7 = r6.a;
            if (r7 == null) goto L7;
            com.bytedance.android.live.liveinteract.videolink.a r2 = new com.bytedance.android.live.liveinteract.videolink.a(r0.getMRoom(), r7, -1);
            r2.e = 3;
            Unit r8 = Unit.INSTANCE;
            r0.invite(r2);
            return;
        }
    }

    public static final class u<T> implements Consumer {
        public final /* synthetic */ MultiLinkVideoTalkRoomGuestWidget a;

        public u(MultiLinkVideoTalkRoomGuestWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            u22.b r5 = (u22.b) r4;
            Intrinsics.checkNotNullParameter(r5, "event");
            Iterator r0 = r5.a.iterator();
        L4:
            if (r0.hasNext() == false) goto L19;
            String r1 = (String) r0.next();
            int r2 = u22.b.c;
            if (r1 != "30000001") goto L4;
            com.bytedance.android.live.liveinteract.plantform.utils.i0 r3 = TalkRoomLogUtils.a;
            com.bytedance.live.datacontext.m r6 = com.bytedance.android.live.liveinteract.api.utils.m.j(this.a).getRoom();
            if (r6 == null) goto L13;
            IRoom r7 = (IRoom) r6.getValue();
            if (r7 == null) goto L13;
            String r8 = r7.getOwnerUserIdString();
            if (r8 == null) goto L13;
        L14:
            TalkRoomLogUtils.m1(r8, r5.b);
            return;
        L13:
            r8 = "";
            goto L14
        }
    }

    public static final class v<T> implements Consumer {
        public final /* synthetic */ MultiLinkVideoTalkRoomGuestWidget a;

        public v(MultiLinkVideoTalkRoomGuestWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            Boolean r4 = (Boolean) r3;
            MultiLinkVideoTalkRoomGuestWidget r0 = this.a;
            Intrinsics.checkNotNull(r4);
            boolean r5 = r4.booleanValue();
            int r1 = MultiLinkVideoTalkRoomGuestWidget.i3;
            r0.Qr(r5);
        }
    }

    public static final class w<T> implements Consumer {
        public final /* synthetic */ String a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ long c;

        public w(String r1, boolean r2, long r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r6) {
            TalkRoomBusinessFullLinkMonitor r0 = TalkRoomBusinessFullLinkMonitor.a;
            String r1 = this.a;
            boolean r2 = this.b;
            long r3 = this.c;
            String r7 = ((com.bytedance.android.live.network.response.e) r6).logId;
            r0.getClass();
            TalkRoomBusinessFullLinkMonitor.w(r1, r2, r3, r7);
            int r8 = com.bytedance.android.live.liveinteract.plantform.utils.x.a;
            com.bytedance.android.live.liveinteract.plantform.utils.x.E(this.a, this.b, null);
        }
    }

    public static final class x<T> implements Consumer {
        public final /* synthetic */ String a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ long c;
        public final /* synthetic */ long d;

        public x(String r1, boolean r2, long r3, long r5) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r5;
        }

        public final void accept(Object r6) {
            ApiServerException r7 = (Throwable) r6;
            TalkRoomBusinessFullLinkMonitor r0 = TalkRoomBusinessFullLinkMonitor.a;
            String r1 = this.a;
            boolean r2 = this.b;
            long r3 = this.c;
            r0.getClass();
            TalkRoomBusinessFullLinkMonitor.u(r1, r2, r3, r7);
            if ((r7 instanceof ApiServerException) == false) goto L13;
            ApiServerException r4 = r7;
            String r5 = r4.getPrompt();
            if (r5 != null) goto L7;
        L10:
            boolean r8 = true;
        L11:
            if (r8 == true) goto L13;
            f2.c(r4.getPrompt(), 0);
        L14:
            jy0.b.b("ttlive_link_video", "主咖邀请回复失败。accept=" + this.b + ",roomId=" + this.d + ", toUid=" + this.a, r7);
            int r9 = com.bytedance.android.live.liveinteract.plantform.utils.x.a;
            com.bytedance.android.live.liveinteract.plantform.utils.x.E(this.a, this.b, r7);
            return;
        L7:
            if (r5.length() == 0) goto L10;
            r8 = false;
        L13:
            f2.b(2131922756, 0);
            goto L14
        }
    }

    public static final class y<T> implements Consumer {
        public final /* synthetic */ String a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ long c;
        public final /* synthetic */ long d;

        public y(String r1, boolean r2, long r3, long r5) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r5;
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
            return;
        L5:
            if (Intrinsics.areEqual(this.a, je0.d.b0()) == false) goto L7;
            f2.b(2131922709, 0);
            return;
        L7:
            f2.b(2131922715, 0);
        }
    }

    public static final class z<T> implements Consumer {
        public final /* synthetic */ String a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ long c;
        public final /* synthetic */ long d;
        public final /* synthetic */ long e;

        public z(String r1, boolean r2, long r3, long r5, long r7) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r5;
            this.e = r7;
        }

        public final void accept(Object r8) {
            ApiServerException r9 = (Throwable) r8;
            TalkRoomBusinessFullLinkMonitor r0 = TalkRoomBusinessFullLinkMonitor.a;
            String r1 = this.a;
            boolean r2 = this.b;
            long r3 = this.c;
            long r5 = this.d;
            r0.getClass();
            TalkRoomBusinessFullLinkMonitor.r(r1, r2, r3, r5, r9);
            if ((r9 instanceof ApiServerException) == false) goto L14;
            ApiServerException r4 = r9;
            String r6 = r4.getPrompt();
            if (r6 != null) goto L7;
        L10:
            boolean r7 = true;
        L11:
            if (r7 == true) goto L14;
            f2.c(r4.getPrompt(), 0);
        L18:
            StringBuilder r10 = new StringBuilder();
            if (this.b == false) goto L21;
            String r11 = "设为主咖";
        L22:
            r10.append(r11);
            r10.append("失败。roomId=");
            r10.append(this.e);
            r10.append(", toUid=");
            r10.append(this.a);
            jy0.b.b("ttlive_link_video", r10.toString(), r9);
            int r12 = com.bytedance.android.live.liveinteract.plantform.utils.x.a;
            com.bytedance.android.live.liveinteract.plantform.utils.x.D(this.a, this.b, r9);
            return;
        L21:
            r11 = "取消主咖";
            goto L22
        L7:
            if (r6.length() == 0) goto L10;
            r7 = false;
        L14:
            if (this.b == false) goto L16;
            int r13 = 2131922759;
        L17:
            f2.b(r13, 0);
            goto L18
        L16:
            r13 = 2131922761;
            goto L17
        }
    }

    static {
    }

    @Override // yj0.a.InterfaceC0294a
    public final void A50() {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.videolink.MultiLinkVideoBaseGuestLinkWidget, com.bytedance.android.live.liveinteract.plantform.widgt.MultiLinkBaseGuestLinkWidget
    public final int Cq() {
        return 16;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.MultiLinkBaseGuestLinkWidget, com.bytedance.android.live.liveinteract.plantform.core.v
    public final void D1(String r1, ByteBuffer r2, int r3) {
    }

    @Override // tf0.o.a
    public final j1 Zb() {
        return this;
    }

    @Override // tf0.o.a
    public final void f() {
    }

    public final int getLayoutId() {
        return 2131567592;
    }

    public final String getSpm() {
        return "a100.a100.a178";
    }

    @Override // rj0.o
    public final Widget getWidget() {
        return this;
    }

    @Override // tf0.o.a
    public final /* synthetic */ void n1(boolean r1) {
    }

    public final InteractLiveCorePermissionGuarantor or() {
        return (InteractLiveCorePermissionGuarantor) this.P2.getValue();
    }

    @Override // rj0.l
    public final void w4() {
    }

    @Override // rj0.j
    public final void B() {
        com.bytedance.android.livesdk.app.dataholder.Observer r0 = this.u;
        if (r0 != null) goto L5;
    L7:
        ChatRoomGuestAppliedDialog r1 = new ChatRoomGuestAppliedDialog(((Widget) this).context, ((Widget) this).dataCenter, new th0.b(this));
        this.u = r1;
        if (DialogLancet.shouldBlockDialogShow(r1) == false) goto L14;
        DialogLancet.handleBlockedDialogShow(r1);
        return;
    L14:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L13
    L11:
        DialogLancet.beforeDialogShow(r1);
        r1.show();
        DialogLancet.afterDialogShow(r1);
        return;
    L5:
        if (r0.isShowing() != true) goto L7;
    }

    public final void Cr() {
        if (this.y2 == 0) goto L6;
        return;
    L6:
        if (MultiLinkLoadWidgetUtils.g() == false) goto L14;
        int r0 = com.bytedance.android.live.liveinteract.plantform.multiroom.e.a;
        com.bytedance.android.live.liveinteract.plantform.commonwindow.l r1 = com.bytedance.android.live.liveinteract.plantform.multiroom.e.d(((Widget) this).dataCenter);
        if (r1 == null) goto L12;
        Long r2 = r1.getEnterRoomTime();
        if (r2 == null) goto L12;
        long r3 = r2.longValue();
    L13:
        this.y2 = r3;
    L15:
        long r4 = this.y2;
        long r5 = TalkRoomLogUtils.y;
        long r6 = r4 - r5;
        if (0 <= r6) goto L19;
    L21:
        this.v2 = r4;
    L22:
        TalkRoomLogUtils.y = 0;
        long r7 = TalkRoomLogUtils.A;
        long r8 = r4 - r7;
        if (0 <= r8) goto L26;
    L28:
        this.x2 = r4;
    L29:
        TalkRoomLogUtils.A = 0;
        return;
    L26:
        if (15000 < r8) goto L28;
        this.x2 = r7;
        goto L29
    L19:
        if (15000 < r6) goto L21;
        this.v2 = r5;
    L12:
        r3 = System.currentTimeMillis();
        goto L13
    L14:
        this.y2 = System.currentTimeMillis();
        goto L15
    }

    @Override // zj0.b
    public final Pair<Integer, Integer> D3() {
        ILivePlayerClient r0 = hs0.a.b.getCurrentClient();
        if (r0 == null) goto L13;
        IRoomEventHub r1 = r0.getEventHub();
        if (r1 == null) goto L13;
        MutableLiveData r2 = r1.getVideoSizeChanged();
        if (r2 == null) goto L13;
        Pair r3 = (Pair) r2.getValue();
        if (r3 == null) goto L13;
        return new Pair(r3.getFirst(), r3.getSecond());
    L13:
        return new Pair(0, 0);
    }

    public final void Dr() {
        GLSurfaceView r0 = (GLSurfaceView) ((Widget) this).containerView.findViewById(2131375528);
        if (r0 == null) goto L5;
        n50.a r1 = k50.e.a(r0);
    L6:
        if (r1 == null) goto L9;
        r1.b();
        return;
    L9:
        j50.a r2 = new j50.a();
        this.f3 = r2;
        r2.e = new j50.b(r0);
        UtilityKotlinExtentionsKt.w(r0);
        Context r3 = ((Widget) this).context;
        j50.a r4 = this.f3;
        Intrinsics.checkNotNull(r4);
        v50.a.b(r0, r3, r4);
        k50.c r5 = new k50.c(r0);
        this.g3 = r5;
        r5.a();
        j50.a r6 = this.f3;
        if (r6 == null) goto L12;
        k50.e.c(r0, r6);
    L12:
        k50.c r7 = this.g3;
        if (r7 == null) goto L16;
        k50.e.b(r0, r7);
        return;
    L16:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final void Er() {
        Pair r0 = com.bytedance.live.datacontext.d.a(MultiLinkVideoTalkRoomGuestWidget$initGuestApplyViewModel$1.INSTANCE);
        GuestApplyViewModel r1 = (GuestApplyViewModel) r0.component1();
        Disposable r2 = (Disposable) r0.component2();
        com.bytedance.live.datacontext.b.a(r1, GuestApplyViewModel.TAG);
        this.F.add(r2);
    }

    public final void Gr() {
        Integer r1 = null;
        if (this.Y != null) goto L10;
        IInteractService r0 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r0 == null) goto L7;
        x00.a r2 = r0.getThemeManager(false, ((Widget) this).dataCenter);
    L8:
        this.Y = r2;
        goto L10
    L7:
        r2 = null;
    L10:
        if (getMRoom().getLinkMap() == null) goto L20;
        if (getMRoom().getLinkMap() != null) goto L14;
        return;
    L14:
        if (getMRoom().getLinkMap().containsKey(String.valueOf(8)) == true) goto L20;
        if (getMRoom().getLinkMap().containsKey(String.valueOf(12)) == true) goto L20;
        if (getMRoom().getLinkMap().containsKey(String.valueOf(16)) == true) goto L20;
        return;
    L20:
        if (IVoiceLiveThemeKt.isValid(getMRoom().getVoiceLiveTheme()) == false) goto L43;
        IVoiceLiveTheme r3 = getMRoom().getVoiceLiveTheme();
        if (r3 == null) goto L24;
        Integer r4 = Integer.valueOf(r3.getBgType());
    L25:
        if (r4 != null) goto L28;
    L30:
        if (r4 != null) goto L33;
        return;
    L33:
        if (r4.intValue() != 4) goto L44;
    L34:
        Lazy r5 = MultiLinkLoadWidgetUtils.a;
        DataCenter r6 = ((Widget) this).dataCenter;
        StringBuilder r7 = new StringBuilder("call initVideoTalkTheme, bgType = ");
        IVoiceLiveTheme r8 = getMRoom().getVoiceLiveTheme();
        if (r8 == null) goto L37;
        r1 = Integer.valueOf(r8.getBgType());
    L37:
        r7.append(r1);
        r7.append(", theme = ");
        r7.append(getMRoom().getVoiceLiveTheme());
        MultiLinkLoadWidgetUtils.n(r6, "MultiLinkVideoTalkRoomGuestWidget", r7.toString());
        x00.a r9 = this.Y;
        if (r9 == null) goto L45;
        IVoiceLiveTheme r10 = getMRoom().getVoiceLiveTheme();
        Intrinsics.checkNotNull(r10);
        IVoiceLiveTheme r11 = getMRoom().getVoiceLiveTheme();
        Intrinsics.checkNotNull(r11);
        r9.c(r10, r11.getBgType());
        return;
    L45:
        return;
    L44:
        return;
    L28:
        if (r4.intValue() != 3) goto L30;
    L24:
        r4 = null;
        goto L25
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.MultiLinkBaseGuestLinkWidget
    public final void H1() {
        super.H1();
        ChatMatchWidget r1 = this.t;
        if (r1 == null) goto L5;
        r1.H1();
    L5:
        com.bytedance.android.live.liveinteract.plantform.core.h r2 = this.P;
        if (r2 == null) goto L20;
        hg6.g r4 = P2();
        if (r4 == null) goto L10;
        ei6.a r5 = r4.V0();
    L11:
        WeakReference<ei6.a> r3 = new WeakReference(r5);
        hg6.g r6 = P2();
        if (r6 == null) goto L18;
        ec6.b r7 = r6.R();
        if (r7 == null) goto L18;
        com.bytedance.android.live.pushstream.d r8 = gc6.b.a(r7);
        if (r8 == null) goto L18;
        uf2.d0 r9 = r8.getLiveCore();
    L19:
        r2.d(r3, new WeakReference(r9));
    L18:
        r9 = null;
        goto L19
    L10:
        r5 = null;
    L20:
        IRoom r10 = getMRoom();
        String r11 = "";
        if (r10 == null) goto L26;
        z5 r12 = r10.getLinkerDetail();
        if (r12 == null) goto L26;
        String r13 = r12.getInitSource();
        if (r13 == null) goto L26;
    L27:
        boolean r14 = true;
        if ("pre_apply_chat_room".equals(r13) == false) goto L30;
        us1.e.a = true;
    L31:
        n1.b r15 = n1.f;
        uf2.d0 r16 = getLiveCore();
        r15.getClass();
        n1.b.b(r16);
        VideoEffectPerfHelper r17 = this.Z2;
        if (r17 == null) goto L34;
        r17.c();
    L34:
        ALogger.i("SingleView", "multi_link_service MultiLinkVideoTalkRoomGuestWidget  onLinkSuccess mWindowManager " + this.T);
        tf0.o r18 = this.T;
        if (r18 == null) goto L37;
        r18.L();
    L37:
        com.bytedance.android.live.liveinteract.plantform.utils.u r19 = this.b2;
        if (r19 == null) goto L41;
        r19.o();
    L41:
        if (tc0.c.h().C == false) goto L44;
        Sq(false, "match apply");
        tc0.c.h().C = false;
    L47:
        if (tc0.c.h().D == true) goto L49;
    L51:
        m00.g r20 = this.U;
        if (r20 != null) goto L54;
    L104:
        this.F2 = System.currentTimeMillis();
        com.bytedance.live.datacontext.j r21 = com.bytedance.android.live.liveinteract.api.utils.m.e(this).getVideoTalkRoomSubScene();
        if (r21 == null) goto L115;
        com.bytedance.android.livesdk.chatroom.viewmodel.e r22 = (com.bytedance.android.livesdk.chatroom.viewmodel.e) r21.getValue();
        if (r22 == null) goto L115;
        com.bytedance.android.livesdk.chatroom.viewmodel.j r23 = r22.t();
        if (r23 == null) goto L115;
        zj0.e r24 = this.X2;
        if (r24 != null) goto L113;
        Intrinsics.throwUninitializedPropertyAccessException("layoutSwitcher");
    L113:
        r24.f(new zj0.c.a(r23.a, r23.c, "rtcStarted", null), r23.b, r23.e);
        ALogger.e("ttlive_link_video", "rtcStartSuccess switchScene:" + Unit.INSTANCE + ", current:" + ur() + ' ' + kr());
    L115:
        if (fj0.e.l() == false) goto L117;
        jc1.k.n(IMultiRechargeServiceExternal.class).rechargeCenter().sync("paid_link");
    L117:
        VideoDigitAvatarWidget r25 = this.W2;
        if (r25 == null) goto L127;
        ALogger.i("KtvDigitAvatar", "监听到rtc【开启】成功消息");
        DigitAvatarMsgController r26 = r25.f;
        if (r26 != null) goto L122;
        Intrinsics.throwUninitializedPropertyAccessException("avatarMsgController");
    L122:
        rj0.l.n2.getClass();
        rj0.l r27 = rj0.l.a.a();
        if (r27 == null) goto L125;
        com.bytedance.android.live.pushstream.d r28 = r27.getLiveStream();
    L126:
        r26.b = r28;
        goto L127
    L125:
        r28 = null;
    L127:
        ne0.c r29 = this.G;
        if (r29 == null) goto L130;
        r29.d0(sh0.a0.b, Boolean.FALSE);
    L130:
        pj0.b r30 = ThemedCompetitionContext.Companion.c();
        if (r30 == null) goto L133;
        r30.Q1();
    L133:
        String r31 = tc0.c.h().f;
        if (r31 != null) goto L136;
    L139:
        if (r14 == true) goto L141;
        this.V2.c(r31, false);
    L142:
        MuteStateChecker r32 = Hg();
        if (r32 == null) goto L145;
        r32.b();
    L145:
        u8("rtcStartSuccess");
        HashMap r210 = new HashMap();
        InteractiveSongLoggerKt.b(r210);
        int r33 = this.y;
        String r34 = this.x.a;
        Long r35 = Long.valueOf((this.F2 - this.s) / ((long) 1000));
        Long r36 = Long.valueOf(jr());
        boolean r37 = Pq();
        boolean r110 = this.B;
        IRoom r111 = getMRoom();
        String r112 = nr();
        String r113 = u0.j(Integer.valueOf(kr().b));
        zj0.e r38 = this.X2;
        if (r38 != null) goto L148;
        Intrinsics.throwUninitializedPropertyAccessException("layoutSwitcher");
    L148:
        Integer r39 = Integer.valueOf(r38.a());
        zj0.e r114 = this.X2;
        if (r114 != null) goto L151;
        Intrinsics.throwUninitializedPropertyAccessException("layoutSwitcher");
    L151:
        String r115 = u0.h(r39, r114.h);
        com.bytedance.android.live.liveinteract.plantform.core.y r40 = Aq();
        if (r40 == null) goto L154;
        Integer r41 = Integer.valueOf(je0.d.j(r40));
    L155:
        String r42 = String.valueOf(r41.intValue());
        String r43 = "0";
        if (r42 != null) goto L158;
        String r116 = "0";
    L159:
        boolean r44 = this.C;
        boolean r117 = l5();
        DataCenter r45 = ((Widget) this).dataCenter;
        if (r45 == null) goto L162;
        Boolean r46 = (Boolean) r45.get("data_link_mic_is_quick_invite", Boolean.FALSE);
    L164:
        if (Intrinsics.areEqual(r46, Boolean.TRUE) == false) goto L166;
        r43 = "1";
    L166:
        TalkRoomLogUtils.a0(r34, r35, r36, r33, r37, r110, r111, r112, r113, r115, r116, r44, r117, r43, wr(), this.Y, this.x, r210, qr(), this.A);
        this.C = false;
        xf6.b r47 = Tq();
        if (r47 == null) goto L169;
        r47.h("on_start_rtc_success", new MultiLinkVideoTalkRoomGuestWidget$onLinkSuccess$3(this), new MultiLinkVideoTalkRoomGuestWidget$onLinkSuccess$4(this), new MultiLinkVideoTalkRoomGuestWidget$onLinkSuccess$5(this));
    L169:
        com.bytedance.android.live.liveinteract.linkcast.g.b.getClass();
        if (com.bytedance.android.live.liveinteract.linkcast.g.a.c() == false) goto L173;
        com.bytedance.android.live.liveinteract.linkcast.g.a.h(false);
        com.bytedance.android.live.liveinteract.linkcast.g.a.g();
        return;
    L173:
        return;
    L162:
        r46 = null;
        goto L164
    L158:
        r116 = r42;
        goto L159
    L154:
        r41 = null;
        goto L155
    L141:
        this.V2.b();
        goto L142
    L136:
        if (r31.length() == 0) goto L139;
        r14 = false;
        goto L139
    L54:
        if (vm2.e.d() == false) goto L62;
        DigitAvatarContext r48 = DigitAvatarContext.Companion.getContext();
        if (r48 == null) goto L58;
        VideoShowMode r49 = r48.getCurrentVideoShowMode();
    L60:
        if (r49 != VideoShowMode.DIGIT_AVATAR) goto L62;
        jy0.b.d("VideoDigitAvatar", "waiting digit avatar loading, source == onStartSuccess");
    L68:
        if (vm2.e.d() == false) goto L77;
        DigitAvatarContext r50 = DigitAvatarContext.Companion.getContext();
        if (r50 == null) goto L72;
        VideoShowMode r51 = r50.getCurrentVideoShowMode();
    L74:
        if (r51 != VideoShowMode.DIGIT_AVATAR) goto L77;
        jy0.b.d("VideoDigitAvatar", "waiting digit avatar loading, source == onStartSuccess");
    L98:
        if (hd0.c.f().g != 1) goto L104;
        com.bytedance.android.livesdk.sharedpref.e r52 = b6.E;
        if (((Boolean) r52.getValue()).booleanValue() == false) goto L104;
        if (us1.d.a() == false) goto L104;
        com.bytedance.android.livesdk.sharedpref.f.d(r52, Boolean.FALSE);
        f2.b(2131917575, 0);
        goto L104
    L72:
        r51 = null;
    L77:
        if (r20.isCameraOpen() == false) goto L82;
        this.h1.put(tc0.c.h().f, r20.getSurfaceView());
        tf0.o r53 = this.T;
        if (r53 == null) goto L98;
        String r54 = tc0.c.h().f;
        r20.getSurfaceView();
        r53.b(r54);
        goto L98
    L82:
        if (je0.d.U() == false) goto L98;
        ILiveWrappedLivePusher.Companion.getClass();
        ILiveWrappedLivePusher r55 = ILiveWrappedLivePusher.a.b();
        if (r55 == null) goto L88;
        m1.b r56 = r55.newVideoMixerDescription(null);
        if (r56 == null) goto L88;
        r56.e();
        r56.b();
        r56.c();
        r56.f();
        r56.i();
    L88:
        v0 r57 = this.c;
        if (r57 == null) goto L98;
        uf2.d0 r58 = r57.A();
        if (r58 == null) goto L98;
        uf2.z r59 = r58.C();
        if (r59 == null) goto L98;
        uf2.z.a r60 = r59.K0();
        if (r60 == null) goto L98;
        r60.b();
        goto L98
    L58:
        r49 = null;
    L62:
        String r61 = tc0.c.h().f;
        if (r61 == null) goto L66;
        r11 = r61;
    L66:
        A(r11, Boolean.valueOf(!r20.isCameraOpen()));
        goto L68
    L49:
        if (this.l == false) goto L51;
        xr("isOnBackgroundWhenStart", true);
        goto L51
    L44:
        if (Aq().b5(je0.d.b0()) == true) goto L47;
        Sq(true, "normal start");
        goto L47
    L30:
        us1.e.a = false;
    L26:
        r13 = "";
        goto L27
    }

    @Override // rj0.l
    public final void Hi() {
        if (this.p1 == false) goto L5;
        return;
    L5:
        if (this.x1 == false) goto L30;
        this.p1 = true;
        Disposable r2 = this.v1;
        if (r2 == null) goto L10;
        r2.dispose();
    L10:
        this.x1 = false;
        if (((Boolean) vm2.e.h.getValue(null, vm2.e.a[6])).booleanValue() == false) goto L16;
        DigitAvatarContext r3 = DigitAvatarContext.Companion.getContext();
        if (r3 == null) goto L15;
        DigitAvatarContext.setVideoShowMode$default(r3, VideoShowMode.AUDIO, null, 2, null);
    L15:
        int r4 = 2;
    L18:
        if (r4 != 1) goto L20;
        jy0.b.f("KtvDigitAvatar", " auto apply set show_mode to video by audience_default_open_camera", null, 4);
        VideoShowMode r1 = VideoShowMode.VIDEO;
    L24:
        DigitAvatarContext r5 = DigitAvatarContext.Companion.getContext();
        if (r5 == null) goto L27;
        DigitAvatarContext.setVideoShowMode$default(r5, r1, null, 2, null);
    L27:
        apply(new sf0.a(0, 0, this.y1.getValue(), 16, null, null, "video_auto_link_mic", 0, 0, 0, false, false, 0, null, null, r4, 393075));
        return;
    L20:
        if (r4 == 2) goto L22;
        jy0.b.f("KtvDigitAvatar", " auto apply set show_mode to audio", null, 4);
        r1 = VideoShowMode.AUDIO;
        goto L24
    L22:
        jy0.b.f("KtvDigitAvatar", " auto apply set show_mode to audio", null, 4);
        r1 = VideoShowMode.AUDIO;
        goto L24
    L16:
        r4 = sj1.d(mr(), je0.f.a());
        goto L18
    }

    public final void Ir() {
        MultiRevenueDataContext.Companion.getClass();
        com.bytedance.android.live.liveinteract.chatroom.chatroom.playmode.a r0 = MultiRevenueDataContext.a.d();
        if (r0 == null) goto L5;
        MultiLinkUniversalAnimWidget r1 = r0.e(this, SceneType.SCENE_VIDEO_TALKROOM, (ViewGroup) ((Widget) this).contentView.findViewById(2131388184));
    L6:
        this.Y2 = r1;
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final void Jr() {
        if (((Boolean) vm2.d.Y.getValue(null, vm2.d.a[48])).booleanValue() == false) goto L8;
        enableSubWidgetManager();
        VideoDigitAvatarWidget r0 = new VideoDigitAvatarWidget();
        this.W2 = r0;
        ((Widget) this).subWidgetManager.load(r0);
        VideoDigitAvatarWidget r1 = this.W2;
        if (r1 == null) goto L9;
        Intrinsics.checkNotNullParameter(this, "digitAvatarReadyCallback");
        r1.i = this;
        return;
    L9:
        return;
    }

    public final void Or() {
        com.bytedance.live.datacontext.m r0 = jc1.k.n(IKtvService.class).getKtvComponentStatusChangedObservable();
        if (r0 == null) goto L10;
        Observable r1 = r0.a();
        if (r1 == null) goto L10;
        Disposable r2 = r1.subscribe(new k(this));
        if (r2 == null) goto L10;
        RxUtilKt.c(r2, this.F);
    L10:
        if (vm2.d.k0() == false) goto L15;
        IKtvService r3 = jc1.k.f(IKtvService.class);
        if (r3 == null) goto L16;
        IKtvService.b.b(r3, this, new l(this), 2);
        return;
    L16:
        return;
    }

    @Override // rj0.l
    public final SurfaceView R0() {
        tf0.o r0 = this.T;
        if (r0 == null) goto L7;
        r0.o0();
        return null;
    L7:
        return null;
    }

    @Override // zj0.b
    public final int Rm() {
        if (this.b1.isEmpty() == false) goto L15;
        Integer r0 = je0.d.h();
        if (r0 == null) goto L15;
        if (r0.intValue() != 2) goto L15;
        List r1 = (List) md().N0().getValue();
        if (r1 != null) goto L16;
        return 0;
    L16:
        return r1.size();
    L15:
        return this.b1.size();
    }

    public final void Sr() {
        Lazy r1 = MultiLinkLoadWidgetUtils.a;
        MultiLinkLoadWidgetUtils.n(((Widget) this).dataCenter, "MultiLinkVideoTalkRoomGuestWidget#" + hashCode(), "call realOnCreate, hasRealOnCreate = " + this.O);
        if (this.O == false) goto L6;
        TalkRoomBusinessFullLinkMonitor.a.getClass();
        TalkRoomBusinessFullLinkMonitor.h0();
        return;
    L6:
        this.O = true;
        com.bytedance.android.livesdk.chatroom.u r2 = com.bytedance.android.live.liveinteract.api.utils.m.e(this);
        if (r2 == null) goto L12;
        com.bytedance.live.datacontext.m r3 = r2.y();
        if (r3 == null) goto L12;
        r3.setValue(Boolean.FALSE);
    L12:
        if (vm2.d.q0().isUserInfoCenterForwardInit() == false) goto L19;
        CopyOnWriteArrayList<ILinkPlayerInfoBridge> r4 = Aq().c;
        if (r4 == null) goto L16;
        this.b1.clear();
        this.b1.addAll(r4);
    L16:
        CopyOnWriteArrayList<ILinkPlayerInfoBridge> r5 = Aq().d;
        if (r5 == null) goto L19;
        this.g1.clear();
        this.g1.addAll(r5);
    L19:
        DataCenter r6 = ((Widget) this).dataCenter;
        if (r6 == null) goto L22;
        EnterRoomInfoResult r7 = (EnterRoomInfoResult) r6.get("data_room_enter_info", null);
    L23:
        if (r7 == null) goto L25;
        long r8 = r7.getRoomId();
    L26:
        if (r7 != null) goto L28;
    L35:
        ne0.c r9 = this.G;
        if (r9 == null) goto L40;
        ne0.e r10 = r9.d(sh0.r.b, new com.bytedance.android.live.liveinteract.videotalk.v(this));
        if (r10 == null) goto L40;
        r10.d(sh0.i.b, new com.bytedance.android.live.liveinteract.videotalk.w(this));
    L40:
        tf0.i r11 = this.r;
        if (je0.d.w() == false) goto L43;
        int r12 = 12;
    L44:
        r11.setScene(r12);
        this.F.add(xs2.b.a().b(o42.g.class).subscribe(new t(this)));
        this.F.add(xs2.b.a().b(u22.b.class).subscribe(new u(this)));
        if (PadConfigUtils.c() == false) goto L47;
        this.F.add(xs2.b.a().b(m81.a.class).subscribe(new com.bytedance.android.live.liveinteract.videotalk.a0(this)));
    L47:
        com.bytedance.android.livesdk.chatroom.t r13 = com.bytedance.android.live.liveinteract.api.utils.m.b();
        if (r13 == null) goto L52;
        com.bytedance.live.datacontext.j r14 = r13.getMessageManager();
        if (r14 == null) goto L52;
        r14.c(new MultiLinkVideoTalkRoomGuestWidget$realOnCreate$5(this));
    L52:
        z5 r15 = getMRoom().getLinkerDetail();
        if (r15 == null) goto L55;
        this.N2 = (int) r15.getEnlargeGuestTurnOnSource();
    L55:
        Cr();
        cg6.a r16 = Bq();
        if (r16 == null) goto L62;
        jg6.a r17 = r16.e5();
        if (r17 == null) goto L62;
        lh6.b r18 = r17.a();
        if (r18 == null) goto L62;
        r18.p(this, "guest widget create");
    L62:
        cg6.a r19 = Bq();
        if (r19 == null) goto L69;
        jg6.a r20 = r19.e5();
        if (r20 == null) goto L69;
        lh6.b r21 = r20.a();
        if (r21 == null) goto L69;
        r21.o(this, "guest widget create");
    L69:
        SwitchCameraManager r22 = new SwitchCameraManager(((Widget) this).context, ((Widget) this).dataCenter, Aq(), this);
        this.V = r22;
        r22.k();
        if (w0.b() == true) goto L74;
        MultiRevenueDataContext.Companion.getClass();
        com.bytedance.android.live.liveinteract.chatroom.chatroom.playmode.a r23 = MultiRevenueDataContext.a.d();
        if (r23 == null) goto L74;
        r23.o(((Widget) this).dataCenter, this, SceneType.SCENE_VIDEO_TALKROOM, (ViewGroup) ((Widget) this).contentView.findViewById(2131388184));
    L74:
        MultiRevenueDataContext.a r24 = MultiRevenueDataContext.Companion;
        r24.getClass();
        com.bytedance.android.live.liveinteract.chatroom.chatroom.playmode.a r25 = MultiRevenueDataContext.a.d();
        if (r25 == null) goto L77;
        r25.d(((Widget) this).dataCenter);
    L77:
        int r26 = com.bytedance.android.live.liveinteract.utils.h1.a;
        com.bytedance.android.live.liveinteract.utils.h1.b(getMRoom());
        com.bytedance.android.live.liveinteract.chatroom.chatroom.playmode.a r27 = MultiRevenueDataContext.a.d();
        if (r27 == null) goto L81;
        r27.p(this, SceneType.SCENE_VIDEO_TALKROOM, this.G, false);
    L81:
        if (((Boolean) ib0.a.getValue()).booleanValue() == false) goto L90;
        View r28 = ((Widget) this).contentView;
        if (r28 == null) goto L99;
        HSImageView r29 = r28.findViewById(2131384400);
        if (r29 == null) goto L99;
        of0.b r30 = InteractiveSongContext.Companion.c();
        if (r30 == null) goto L99;
        r30.e7(r29);
    L99:
        InteractiveSongContext r31 = InteractiveSongContext.Companion.getContext();
        if (r31 == null) goto L109;
        com.bytedance.live.datacontext.m<String> r32 = r31.getSingingGuestId();
        if (r32 == null) goto L109;
        Observable r33 = r32.a();
        if (r33 == null) goto L109;
        Disposable r34 = r33.subscribe(new com.bytedance.android.live.liveinteract.videotalk.x(this));
        if (r34 == null) goto L109;
        RxUtilKt.c(r34, this.F);
    L109:
        if (this.H1 != null) goto L112;
        enableSubWidgetManager();
        QuickInteractWidget r35 = new QuickInteractWidget();
        this.H1 = r35;
        ((Widget) this).subWidgetManager.load(r35);
    L112:
        if (this.L1 != null) goto L115;
        enableSubWidgetManager();
        LinkCastGuestWidget r36 = new LinkCastGuestWidget(this);
        this.L1 = r36;
        ((Widget) this).subWidgetManager.load(r36);
    L115:
        if (this.Q1 != null) goto L118;
        enableSubWidgetManager();
        RTSVideoWidget r37 = new RTSVideoWidget(P2(), (dn0.c) getScopeServiceOrNullInMultiLinkRoom(dn0.c.class), Aq(), null);
        this.Q1 = r37;
        ((Widget) this).subWidgetManager.load(r37);
    L118:
        if (this.P1 != null) goto L121;
        enableSubWidgetManager();
        CPositionWidget r38 = new CPositionWidget();
        this.P1 = r38;
        ((Widget) this).subWidgetManager.load(r38);
    L121:
        if (this.S1 != null) goto L140;
        Integer r39 = je0.d.h();
        if (r39 != null) goto L126;
    L130:
        boolean r40 = false;
    L131:
        if (r40 == false) goto L140;
        enableSubWidgetManager();
        FrameLayout r41 = (FrameLayout) ((Widget) this).contentView.findViewById(2131376893);
        if (r41 == null) goto L135;
        r41.setVisibility(0);
    L135:
        IKtvService r42 = jc1.k.f(IKtvService.class);
        if (r42 == null) goto L138;
        Widget r43 = r42.createConcertWidget();
    L139:
        this.S1 = r43;
        ((Widget) this).subWidgetManager.load(r41, r43, false);
        ALogger.i("MultiLinkVideoTalkRoomGuestWidget", "[chorus_concert] loadConcertWidget complete");
        goto L140
    L138:
        r43 = null;
        goto L139
    L126:
        if (r39.intValue() != 62) goto L130;
        if (((Boolean) yl0.a.getValue()).booleanValue() == false) goto L130;
        r40 = true;
    L140:
        Lazy r44 = KtvCommonSettingHelper.a;
        if (((Boolean) KtvCommonSettingHelper.a.getValue()).booleanValue() == true) goto L143;
    L160:
        Gr();
        com.bytedance.android.live.liveinteract.plantform.core.y r45 = Aq();
        if (r45 == null) goto L163;
        this.P0 = new com.bytedance.android.live.liveinteract.videotalk.utils.a(r45, false, ((Widget) this).dataCenter);
        this.V0 = new oe0.b(r45);
    L163:
        hg6.g r46 = P2();
        if (r46 != null) goto L166;
    L174:
        Fr(false);
        com.bytedance.android.live.liveinteract.plantform.utils.w0 r47 = this.x;
        com.bytedance.live.datacontext.m r48 = com.bytedance.android.live.liveinteract.api.utils.m.j(this).getRoom();
        if (r48 == null) goto L180;
        IRoom r49 = (IRoom) r48.getValue();
        if (r49 == null) goto L180;
        String r50 = r49.getOwnerUserIdString();
        if (r50 == null) goto L180;
    L181:
        r47.getClass();
        Intrinsics.checkNotNullParameter(r50, "<set-?>");
        r47.c = r50;
        if (fj0.c.a() == false) goto L186;
        r24.getClass();
        com.bytedance.android.live.liveinteract.revenuebase.c r51 = MultiRevenueDataContext.a.c();
        if (r51 == null) goto L186;
        r51.b();
    L186:
        Aq().Q4(this.T2);
        CopyOnWriteArrayList<ILinkPlayerInfoBridge> r52 = Aq().c;
        if (r52.size() <= 0) goto L189;
        this.T2.onOnlineListChanged(r52);
    L189:
        yj0.a r53 = this.S;
        if (r53 == null) goto L192;
        r53.c0(this);
    L192:
        this.G1.g();
        hg6.g r54 = P2();
        if (r54 == null) goto L201;
        if (r54.isEngineOn() != true) goto L201;
        v0 r55 = this.c;
        if ((r55 instanceof m00.g) == true) goto L199;
        r55 = null;
    L199:
        this.U = (m00.g) r55;
        hd0.c.f().k(2);
    L203:
        tc0.c r56 = tc0.c.h();
        System.currentTimeMillis();
        r56.getClass();
        ((Widget) this).dataCenter.observe("cmd_video_talk_guest_battle_open_panel", this);
        ((Widget) this).dataCenter.observe("cmd_open_interact_manage_dialog_by_anchor", this);
        ((Widget) this).dataCenter.observe("cmd_video_talk_invite", this);
        ((Widget) this).dataCenter.observe("cmd_show_guest_apply_dialog", this);
        ((Widget) this).dataCenter.observe("cmd_operate_interact_media", this);
        ((Widget) this).dataCenter.observe("cmd_self_join_channel_anonymous", this);
        if (vm2.e.a() == false) goto L213;
        if ((getContext() instanceof FragmentActivity) == false) goto L213;
        InteractLiveCorePermissionGuarantor r57 = or();
        Context r58 = getContext();
        if (r58 == null) goto L211;
        r57.i((FragmentActivity) r58);
        goto L213
    L211:
        throw new NullPointerException("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
    L213:
        if (com.bytedance.android.live.liveinteract.api.utils.m.j(this) == null) goto L217;
        Disposable r59 = IKtvService.b.b(jc1.k.n(IKtvService.class), this, new v(this), 2);
        if (r59 == null) goto L217;
        RxUtilKt.c(r59, this.F);
    L217:
        IKtvService r60 = jc1.k.f(IKtvService.class);
        if (r60 == null) goto L224;
        com.bytedance.live.datacontext.k r61 = r60.ktvComponentSingerChangedEvent();
        if (r61 == null) goto L224;
        Disposable r62 = r61.onEvent().subscribe(new r(this));
        if (r62 == null) goto L224;
        RxUtilKt.c(r62, this.F);
    L224:
        hg6.g r63 = P2();
        if (r63 == null) goto L236;
        if (r63.isEngineOn() != true) goto L236;
        DataCenter r65 = ((Widget) this).dataCenter;
        if (r65 == null) goto L231;
        String r66 = (String) r65.get("data_room_unique_id", "");
    L233:
        if (tc0.c.i(r66).O == null) goto L236;
        Tr();
        goto L236
    L231:
        r66 = null;
    L236:
        if (xe0.j.d() == false) goto L295;
        String r67 = LinkmicOnlineFloatWindowManager.Y;
        LinkmicOnlineFloatWindowManager.c.a().e = false;
        br(1, new MultiLinkVideoTalkRoomGuestWidget$realOnCreate$10(this), new MultiLinkVideoTalkRoomGuestWidget$realOnCreate$11(this), LinkApi.ApplyStashType.ONLINE_WINDOW.ordinal());
        hd0.c.f().k(2);
        Iterator r68 = ((ArrayList) LinkmicOnlineFloatWindowManager.c.a().o).iterator();
    L239:
        if (r68.hasNext() == false) goto L245;
        ILinkPlayerInfoBridge r69 = (ILinkPlayerInfoBridge) r68.next();
        HashMap<String, Boolean> r70 = this.k1;
        String r71 = r69.getMInteractIdStr();
        if (r69.getMLinkType() == 1) goto L243;
        boolean r72 = true;
    L244:
        r70.put(r71, Boolean.valueOf(r72));
        goto L239
    L243:
        r72 = false;
        goto L244
    L245:
        String r73 = LinkmicOnlineFloatWindowManager.Y;
        List<ILinkPlayerInfoBridge> r74 = LinkmicOnlineFloatWindowManager.c.a().o;
        if (r74 == null) goto L257;
        Iterator r75 = ((ArrayList) r74).iterator();
    L249:
        if (r75.hasNext() == false) goto L253;
        Object r76 = r75.next();
        if (je0.d.C((ILinkPlayerInfoBridge) r76) == false) goto L249;
    L254:
        ILinkPlayerInfoBridge r77 = (ILinkPlayerInfoBridge) r76;
        if (r77 == null) goto L257;
        r77.getMLinkType();
        goto L257
    L253:
        r76 = null;
    L257:
        m00.g r78 = this.U;
        if (r78 == null) goto L260;
        r78.u();
    L260:
        DigitAvatarContext.a r79 = DigitAvatarContext.Companion;
        DigitAvatarContext r80 = r79.getContext();
        if (r80 == null) goto L263;
        r80.setSkipFrequencyCheck(true);
    L263:
        DigitAvatarContext r81 = r79.getContext();
        if (r81 == null) goto L266;
        DigitAvatarContext.setVideoShowMode$default(r81, VideoShowMode.AUDIO, null, 2, null);
    L266:
        com.bytedance.android.livesdk.sharedpref.e r82 = com.bytedance.android.livesdk.sharedpref.c.Y0;
        Integer r83 = Integer.valueOf(VideoShowMode.AUDIO.getType());
        r82.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r82, r83);
        hg6.g r84 = P2();
        if (r84 == null) goto L270;
        Map r85 = r84.m();
        if (r85 == null) goto L270;
    L271:
        Iterator r86 = r85.entrySet().iterator();
    L273:
        if (r86.hasNext() == false) goto L297;
        Map.Entry r87 = (Map.Entry) r86.next();
        String r88 = (String) r87.getKey();
        Object r89 = r87.getValue();
        if (TextUtils.equals(r88, tc0.c.h().f) == true) goto L273;
        if ((r89 instanceof yb6.j) == true) goto L280;
        r89 = null;
    L280:
        yb6.j r90 = (yb6.j) r89;
        if (r90 == null) goto L283;
        Object r91 = r90.a;
    L285:
        if ((r91 instanceof SurfaceView) == true) goto L286;
        if ((r91 instanceof TextureView) == true) goto L289;
        ILiveWrappedLivePusher.Companion.getClass();
        ILiveWrappedLivePusher r92 = ILiveWrappedLivePusher.a.b();
        if (r92 == null) goto L293;
        uf2.z.a r93 = r92.buildLayerControlLayer(r91);
    L294:
        b4(r88, r93, 0, 0);
        goto L273
    L293:
        r93 = null;
        goto L294
    L289:
        L0(r88, (TextureView) r91, 0, 0);
        goto L273
    L286:
        h1(r88, (SurfaceView) r91, 0, 0);
        goto L273
    L283:
        r91 = null;
    L297:
        if (vm2.d.w() == true) goto L299;
    L304:
        com.bytedance.android.live.liveinteract.plantform.base.g r94 = com.bytedance.android.live.liveinteract.plantform.base.f.a();
        if (r94 != null) goto L307;
    L309:
        boolean r95 = false;
    L310:
        com.bytedance.android.live.liveinteract.plantform.core.y r96 = Aq();
        if (r96 == null) goto L313;
        Integer r97 = Integer.valueOf(r96.b());
    L314:
        int r98 = r97.intValue();
        Integer r99 = je0.d.h();
        jy0.b.a("ttlive_multi_mic_room", "tryMicRoomHostAutoApply isMicRoomHost " + r95 + " onlineGuestCount " + r98 + " currentUiLayout " + r99);
        if (r95 == false) goto L347;
        if (r98 != 0) goto L347;
        if (r99 == null) goto L347;
        if (r99.intValue() != 7) goto L347;
        HashMap<String, Integer> r100 = IInteractService.micRoomHostStateMap;
        if (r100 == null) goto L325;
        Integer r101 = r100.get("is_host_auto_apply");
        if (r101 == null) goto L325;
    L326:
        int r102 = r101.intValue();
        if (r100 == null) goto L329;
        Integer r103 = r100.remove("is_host_auto_apply");
    L329:
        jy0.b.a("ttlive_multi_mic_room", "last mic room host linkType " + r102);
        if (r102 <= 0) goto L347;
        jy0.b.d("ttlive_multi_mic_room", "auto apply set show_mode to " + r102);
        if (r102 == 1) goto L343;
        if (r102 != 2) goto L335;
        DigitAvatarContext r104 = DigitAvatarContext.Companion.getContext();
        if (r104 == null) goto L346;
        DigitAvatarContext.setVideoShowMode$default(r104, VideoShowMode.AUDIO, null, 2, null);
    L346:
        apply(new sf0.a(0, 0, LinkApplyType.NORMAL.getValue(), 16, null, null, "apply_big_party_for_msequence", 0, 0, 0, false, false, 0, null, null, r102, 393075));
        jy0.b.a("ttlive_multi_mic_room", "start checkAndApply");
        boolean r105 = true;
    L348:
        if (r105 == true) goto L430;
        fj0.b.a.b = false;
        mz0.f r106 = mz0.d.b(LogCommon.PAGE_SOURCE_LOG);
        if ((r106 instanceof mz0.f) == false) goto L430;
        mz0.f r107 = r106;
        if (TextUtils.equals(r107.d(), "true") == false) goto L363;
        jy0.b.d("ttlive_link_video", "auto apply video_city_auto_apply");
        if (sj1.c() == false) goto L359;
        this.x1 = true;
        this.y1 = LinkApplyType.CITY;
        Disposable r108 = Observable.timer(2, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.bytedance.android.live.liveinteract.videotalk.q(this));
        this.v1 = r108;
        if (r108 == null) goto L363;
        this.F.add(r108);
        goto L363
    L359:
        jy0.b.f("ttlive_link_video", " auto apply set show_mode to audio", null, 4);
        DigitAvatarContext r109 = DigitAvatarContext.Companion.getContext();
        if (r109 == null) goto L362;
        DigitAvatarContext.setVideoShowMode$default(r109, VideoShowMode.AUDIO, null, 2, null);
    L362:
        apply(new sf0.a(0, 0, LinkApplyType.CITY.getValue(), 16, null, null, "video_city_auto_apply", 0, 0, 0, false, false, 0, null, null, 2, 393075));
    L363:
        String r110 = r107.l();
        String r111 = r107.e();
        if (r111 != null) goto L366;
        r111 = "";
    L366:
        String r112 = r107.k();
        String r113 = r107.f();
        if (r113 != null) goto L369;
        String r310 = "";
    L370:
        String r114 = r107.m();
        if (r114 != null) goto L373;
    L375:
        int r115 = bh0.a.a;
        int r116 = 100;
    L377:
        if (((Boolean) vm2.k.b.getValue(null, vm2.k.a[0])).booleanValue() == false) goto L384;
        if (fj0.e.j(getMRoom()) == false) goto L384;
        if (TextUtils.equals(r110, "true") == false) goto L384;
        Intrinsics.areEqual(r111, "apply");
    L384:
        if (Intrinsics.areEqual(r111, "") == true) goto L388;
        if (Intrinsics.areEqual(r111, "apply") == true) goto L388;
    L408:
        if (Intrinsics.areEqual(r111, "reply") == false) goto L430;
        if (TextUtils.equals(r110, "true") == false) goto L430;
        if (((Boolean) ((Widget) this).dataCenter.get("data_strong_reach_auto_apply_already", Boolean.FALSE)).booleanValue() == true) goto L430;
        if (sj1.c() == false) goto L418;
        Disposable r117 = Observable.timer(2, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.bytedance.android.live.liveinteract.videotalk.t(this, r112, r310));
        this.v1 = r117;
        if (r117 == null) goto L430;
        this.F.add(r117);
        goto L430
    L418:
        String r118 = r310;
        jy0.b.f("KtvDigitAvatar", " auto reply set show_mode to audio", null, 4);
        DigitAvatarContext r119 = DigitAvatarContext.Companion.getContext();
        if (r119 == null) goto L421;
        DigitAvatarContext.setVideoShowMode$default(r119, VideoShowMode.AUDIO, null, 2, null);
    L421:
        cg6.a r120 = Bq();
        if (r120 == null) goto L430;
        MultiLinkGuestManager r121 = r120.W4();
        if (r121 == null) goto L430;
        long r122 = getMRoom().getId();
        if (r112 != null) goto L428;
        String r210 = "";
    L429:
        r121.j(new sf0.e(r122, r210, r118, ReplyType.Agree.ordinal(), 2, 32, 0));
        goto L430
    L428:
        r210 = r112;
    L388:
        if (TextUtils.equals(r110, "true") == false) goto L408;
        if (((Boolean) ((Widget) this).dataCenter.get("data_strong_reach_auto_apply_already", Boolean.FALSE)).booleanValue() == true) goto L408;
        ((Widget) this).dataCenter.put("data_strong_reach_auto_apply_already", Boolean.TRUE);
        jy0.b.d("ttlive_link_video", "auto apply video_auto_link_mic");
        if (r107.getApplyType() <= 0) goto L394;
        int r123 = r107.getApplyType();
    L396:
        if (sj1.c() == false) goto L403;
        this.x1 = true;
        LinkApplyType r124 = com.bytedance.android.live.liveinteract.api.chatroom.model.a.a(r123);
        this.y1 = r124;
        if (r124 != LinkApplyType.ANCHOR_POINT_ENTER) goto L400;
        this.x1 = false;
    L400:
        Disposable r125 = Observable.timer(2, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.bytedance.android.live.liveinteract.videotalk.s(this, r123, r116));
        this.v1 = r125;
        if (r125 == null) goto L430;
        this.F.add(r125);
        goto L430
    L403:
        jy0.b.f("KtvDigitAvatar", " auto apply set show_mode to audio", null, 4);
        DigitAvatarContext r126 = DigitAvatarContext.Companion.getContext();
        if (r126 == null) goto L406;
        DigitAvatarContext.setVideoShowMode$default(r126, VideoShowMode.AUDIO, null, 2, null);
    L406:
        apply(new sf0.a(0, r116, r123, 16, null, null, "video_auto_link_mic", 0, 0, 0, false, false, 0, null, null, 2, 393073));
        goto L430
    L394:
        r123 = LinkApplyType.STRONG_REACH.getValue();
        goto L396
    L373:
        if (r2.a(r114) != true) goto L375;
        r116 = d5.b(r107.m());
        goto L377
    L369:
        r310 = r113;
    L430:
        cr();
        er();
        if (s0.a(getMRoom()) == false) goto L433;
    L434:
        Er();
    L435:
        zr();
        if (vm2.d.U0() == false) goto L444;
        com.bytedance.live.datacontext.k r127 = com.bytedance.android.live.liveinteract.api.utils.m.e(this).L();
        if (r127 == null) goto L444;
        PublishSubject r128 = r127.onEvent();
        if (r128 == null) goto L444;
        Disposable r129 = RxUtilKt.p(r128, "guest_video_talk", new MultiLinkVideoTalkRoomGuestWidget$realOnCreate$12(this));
        if (r129 == null) goto L444;
        RxUtilKt.c(r129, this.F);
    L444:
        com.bytedance.android.live.liveinteract.linksecurity.b.g.k(((Widget) this).dataCenter);
        Or();
        com.bytedance.android.live.liveinteract.plantform.utils.i0 r130 = TalkRoomLogUtils.a;
        uf2.d0 r131 = null;
        TalkRoomLogUtils.x = null;
        SpatialAudioStrategyManager.c.a();
        SpatialAudioContext r132 = SpatialAudioContext.Companion.getContext();
        if (r132 == null) goto L453;
        com.bytedance.live.datacontext.m<Integer> r133 = r132.getCurrentStrategyId();
        if (r133 == null) goto L453;
        Observable r134 = r133.a();
        if (r134 == null) goto L453;
        Disposable r135 = r134.subscribe(new s(this));
        if (r135 == null) goto L453;
        RxUtilKt.c(r135, this.F);
    L453:
        LinkedHashMap r136 = new LinkedHashMap();
        Kr("livesdk_audience_voice_room_show_v4", r136);
        if (Intrinsics.areEqual(getSource(), MultiLinkOpenSource.SYNC_ROOM) == false) goto L459;
        long r137 = this.v2;
        long r138 = this.y2;
        if (r137 >= r138) goto L458;
        TalkRoomLogUtils.U(Long.valueOf(r138 - r137));
    L461:
        if (Intrinsics.areEqual(getSource(), MultiLinkOpenSource.SYNC_ROOM) == true) goto L464;
        TalkRoomLogUtils.o0(r136);
    L464:
        if (vm2.d.y() == true) goto L466;
    L477:
        com.bytedance.android.livesdk.log.filter.t r139 = com.bytedance.android.livesdk.log.j0.l().c(am2.x.class);
        if ((r139 instanceof com.bytedance.android.livesdk.log.filter.t) == true) goto L480;
    L482:
        com.bytedance.android.live.liveinteract.plantform.core.h r140 = new com.bytedance.android.live.liveinteract.plantform.core.h(getMRoom(), ((Widget) this).dataCenter, Aq());
        this.P = r140;
        r140.a();
        hg6.g r141 = P2();
        if (r141 == null) goto L497;
        ei6.a r142 = r141.V0();
        if (r142 == null) goto L497;
        com.bytedance.android.live.liveinteract.plantform.core.h r143 = this.P;
        if (r143 == null) goto L497;
        WeakReference<ei6.a> r144 = new WeakReference(r142);
        hg6.g r145 = P2();
        if (r145 == null) goto L495;
        ec6.b r146 = r145.R();
        if (r146 == null) goto L495;
        com.bytedance.android.live.pushstream.d r147 = gc6.b.a(r146);
        if (r147 == null) goto L495;
        uf2.d0 r148 = r147.getLiveCore();
    L496:
        r143.d(r144, new WeakReference(r148));
    L495:
        r148 = null;
    L497:
        hg6.g r149 = P2();
        if (r149 == null) goto L508;
        if (r149.isEngineOn() == false) goto L508;
        n1.b r150 = n1.f;
        ec6.b r151 = r149.R();
        if (r151 == null) goto L506;
        com.bytedance.android.live.pushstream.d r152 = gc6.b.a(r151);
        if (r152 == null) goto L506;
        r131 = r152.getLiveCore();
    L506:
        r150.getClass();
        n1.b.b(r131);
    L508:
        if (vm2.d.K0() == true) goto L510;
    L512:
        Ir();
        boolean r153 = MatchRoomLandScapeAnimUtil.a;
        this.I2 = MatchRoomLandScapeAnimUtil.a;
        MatchRoomLandScapeAnimUtil.t(false);
        if (MultiLinkLoadWidgetUtils.f() == false) goto L518;
        tf0.o r154 = this.T;
        if (r154 == null) goto L518;
        r154.w();
    L518:
        if (je0.d.A() == false) goto L538;
        Xr();
        return;
    L538:
        return;
    L510:
        if (vm2.d.h() == false) goto L512;
        Dr();
        goto L512
    L480:
        if (TextUtils.equals(r139.g(), "1") == false) goto L482;
        f2.c(s1.B(2131917753), 0);
        goto L482
    L466:
        if (vm2.d.x() == false) goto L477;
        com.bytedance.live.datacontext.j r155 = com.bytedance.android.live.liveinteract.api.utils.m.k(this, ((Widget) this).dataCenter).getCompactTbLoader();
        if (r155 == null) goto L470;
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.m r156 = (com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.m) r155.getValue();
    L472:
        if ((r156 instanceof com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.m) == true) goto L474;
        r156 = null;
    L474:
        if (r156 == null) goto L476;
        r156.refreshExistComponent(26);
    L476:
        jy0.b.d("guest_video_talk", "[LinkmicIconDoubleCheck] MultiLinkVideoTalkRoomGuestWidget load refresh icon");
        goto L477
    L470:
        r156 = null;
        goto L472
    L458:
        TalkRoomLogUtils.m0(getMRoom(), System.currentTimeMillis(), TalkRoomLogUtils.z);
        goto L461
    L459:
        TalkRoomLogUtils.n0(r136);
        goto L461
    L433:
        if (fj0.e.g(getMRoom()) == false) goto L435;
    L335:
        if (r102 != 3) goto L346;
        DigitAvatarContext r157 = DigitAvatarContext.Companion.getContext();
        if (r157 == null) goto L346;
        DigitAvatarContext.setVideoShowMode$default(r157, VideoShowMode.DIGIT_AVATAR, null, 2, null);
        goto L346
    L343:
        DigitAvatarContext r158 = DigitAvatarContext.Companion.getContext();
        if (r158 == null) goto L346;
        DigitAvatarContext.setVideoShowMode$default(r158, VideoShowMode.VIDEO, null, 2, null);
    L325:
        r101 = 0;
    L347:
        r105 = false;
        goto L348
    L313:
        r97 = null;
        goto L314
    L307:
        if (r94.W1() != true) goto L309;
        r95 = true;
        goto L310
    L299:
        if (com.bytedance.android.live.liveinteract.linkpanel.util.o.o(null) == true) goto L304;
        if (this.t != null) goto L304;
        enableSubWidgetManager();
        ChatMatchWidget r159 = new ChatMatchWidget(true, this);
        this.t = r159;
        ((Widget) this).subWidgetManager.load(r159);
    L270:
        r85 = MapsKt.emptyMap();
        goto L271
    L295:
        Jr();
    L201:
        if (hd0.c.f().j() == true) goto L203;
        hd0.c.f().k(0);
    L180:
        r50 = "";
        goto L181
    L166:
        if (r46.isEngineOn() != true) goto L174;
        DataCenter r160 = ((Widget) this).dataCenter;
        if (r160 == null) goto L170;
        String r161 = (String) r160.get("data_room_unique_id", "");
    L172:
        if (tc0.c.i(r161).O == null) goto L174;
        this.H2 = true;
        goto L174
    L170:
        r161 = null;
        goto L172
    L143:
        if (this.T1 != null) goto L160;
        Integer r162 = je0.d.h();
        if (r162 != null) goto L148;
    L150:
        boolean r163 = false;
    L151:
        if (r163 == false) goto L160;
        enableSubWidgetManager();
        FrameLayout r164 = (FrameLayout) ((Widget) this).contentView.findViewById(2131392274);
        if (r164 == null) goto L155;
        r164.setVisibility(0);
    L155:
        IKtvService r165 = jc1.k.f(IKtvService.class);
        if (r165 == null) goto L158;
        Widget r166 = r165.createVideoChorusWidget();
    L159:
        this.T1 = r166;
        ((Widget) this).subWidgetManager.load(r164, r166, false);
        ALogger.i("MultiLinkVideoTalkRoomGuestWidget", "[video_chorus] loadVideoChorusWidget complete");
        goto L160
    L158:
        r166 = null;
        goto L159
    L148:
        if (r162.intValue() != 63) goto L150;
        r163 = true;
        goto L151
    L90:
        if (this.M1 != null) goto L99;
        enableSubWidgetManager();
        this.M1 = qf0.b.a();
        View r167 = ((Widget) this).contentView;
        if (r167 == null) goto L98;
        HSImageView r168 = r167.findViewById(2131384400);
        if (r168 == null) goto L98;
        InteractiveSongWidget r169 = this.M1;
        if (r169 == null) goto L98;
        Intrinsics.checkNotNullParameter(r168, "view");
        r169.v = r168;
    L98:
        ((Widget) this).subWidgetManager.load(this.M1);
        goto L99
    L43:
        r12 = 8;
        goto L44
    L28:
        if (r8 != getMRoom().getRoomId()) goto L35;
        com.bytedance.live.datacontext.j r170 = com.bytedance.android.live.liveinteract.api.utils.m.e(this).getVideoTalkRoomSubScene();
        if (r170 == null) goto L35;
        com.bytedance.android.livesdk.chatroom.viewmodel.e r171 = (com.bytedance.android.livesdk.chatroom.viewmodel.e) r170.getValue();
        if (r171 == null) goto L35;
        r171.e(new com.bytedance.android.livesdk.chatroom.viewmodel.j(r7.getScene(), r7.getPlayModes(), r7.getUiLayout(), false, r7.getClientUIInfo(), false, 40));
        goto L35
    L25:
        r8 = -1;
        goto L26
    L22:
        r7 = null;
        goto L23
    }

    @Override // rj0.l
    public final boolean T2() {
        m00.g r0 = this.U;
        if (r0 == null) goto L11;
        uf2.d0 r1 = r0.A();
        if (r1 == null) goto L11;
        uf2.d0.a r2 = r1.getBuilder();
        if (r2 == null) goto L11;
        if (r2.g() != 1) goto L11;
        return true;
    L11:
        return false;
    }

    public final void Tr() {
        IMiddlewareUserService r0 = jc1.k.f(IMiddlewareUserService.class);
        if (r0 == null) goto L7;
        com.bytedance.android.livesdk.user.e r1 = r0.user();
        if (r1 == null) goto L7;
        String r2 = r1.n();
    L8:
        DataCenter r3 = ((Widget) this).dataCenter;
        if (r3 == null) goto L11;
        String r4 = (String) r3.get("data_room_unique_id", "");
    L12:
        l6 r5 = tc0.c.i(r4).O;
        if (r5 == null) goto L15;
        List r6 = r5.getMLinkUsers();
    L17:
        if (((Boolean) vm2.d.Z.getValue(null, vm2.d.a[49])).booleanValue() == false) goto L27;
        if (r6 == null) goto L27;
        Iterator r7 = r6.iterator();
    L21:
        if (r7.hasNext() == false) goto L27;
        com.bytedance.android.livesdk.link.model.bridge.k r8 = (com.bytedance.android.livesdk.link.model.bridge.k) r7.next();
        HashMap<String, Boolean> r9 = this.k1;
        String r10 = r8.getLinkMicIdStr();
        if (r8.getLinkType() == 1) goto L25;
        boolean r11 = true;
    L26:
        r9.put(r10, Boolean.valueOf(r11));
        goto L21
    L25:
        r11 = false;
    L27:
        if (r6 == null) goto L44;
        Iterator r12 = r6.iterator();
    L30:
        if (r12.hasNext() == false) goto L40;
        Object r13 = r12.next();
        com.bytedance.android.livesdk.link.model.bridge.k r14 = (com.bytedance.android.livesdk.link.model.bridge.k) r13;
        if (r14 == null) goto L36;
        IBaseUser r15 = r14.getUser();
        if (r15 == null) goto L36;
        String r16 = r15.getIdString();
    L38:
        if (Intrinsics.areEqual(r16, r2) == false) goto L30;
    L41:
        com.bytedance.android.livesdk.link.model.bridge.k r17 = (com.bytedance.android.livesdk.link.model.bridge.k) r13;
        if (r17 == null) goto L44;
        int r18 = r17.getLinkType();
    L45:
        hg6.g r19 = P2();
        if (r19 == null) goto L51;
        if (r5 == null) goto L49;
        String r20 = r5.getRtcExtInfo();
    L50:
        r19.c(r20);
        goto L51
    L49:
        r20 = null;
    L51:
        hg6.g r21 = P2();
        if (r21 == null) goto L57;
        if (r5 == null) goto L55;
        String r22 = r5.getLiveCoreExtInfo();
    L56:
        r21.J(r22);
        goto L57
    L55:
        r22 = null;
    L57:
        m00.g r23 = this.U;
        if (r23 == null) goto L60;
        r23.u();
    L60:
        DigitAvatarContext.a r24 = DigitAvatarContext.Companion;
        DigitAvatarContext r25 = r24.getContext();
        if (r25 == null) goto L64;
        r25.setSkipFrequencyCheck(true);
    L64:
        if (r18 != 1) goto L69;
        DigitAvatarContext r26 = r24.getContext();
        if (r26 == null) goto L68;
        DigitAvatarContext.setVideoShowMode$default(r26, VideoShowMode.VIDEO, null, 2, null);
    L68:
        com.bytedance.android.livesdk.sharedpref.e r27 = com.bytedance.android.livesdk.sharedpref.c.Y0;
        Integer r28 = Integer.valueOf(VideoShowMode.VIDEO.getType());
        r27.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r27, r28);
    L73:
        j r29 = this.T2;
        if (r5 == null) goto L78;
        List r30 = r5.getMLinkUsers();
        if (r30 == null) goto L78;
        List<ILinkPlayerInfoBridge> r31 = CollectionsKt.toMutableList(je0.d.f0(r30, false));
    L79:
        r29.onOnlineListChanged(r31);
        hg6.g r32 = P2();
        if (r32 == null) goto L83;
        Map r33 = r32.m();
        if (r33 == null) goto L83;
    L84:
        Iterator r34 = r33.entrySet().iterator();
    L86:
        if (r34.hasNext() == false) goto L108;
        Map.Entry r35 = (Map.Entry) r34.next();
        String r36 = (String) r35.getKey();
        Object r37 = r35.getValue();
        if (TextUtils.equals(r36, tc0.c.h().f) == true) goto L86;
        if ((r37 instanceof yb6.j) == true) goto L93;
        r37 = null;
    L93:
        yb6.j r38 = (yb6.j) r37;
        if (r38 == null) goto L96;
        Object r39 = r38.a;
    L98:
        if ((r39 instanceof SurfaceView) == true) goto L99;
        if ((r39 instanceof TextureView) == true) goto L102;
        ILiveWrappedLivePusher.Companion.getClass();
        ILiveWrappedLivePusher r40 = ILiveWrappedLivePusher.a.b();
        if (r40 == null) goto L106;
        uf2.z.a r41 = r40.buildLayerControlLayer(r39);
    L107:
        b4(r36, r41, 0, 0);
        goto L86
    L106:
        r41 = null;
        goto L107
    L102:
        L0(r36, (TextureView) r39, 0, 0);
        goto L86
    L99:
        h1(r36, (SurfaceView) r39, 0, 0);
        goto L86
    L96:
        r39 = null;
        goto L98
    L108:
        VideoDigitAvatarWidget r42 = this.W2;
        if (r42 == null) goto L114;
        com.bytedance.android.live.liveinteract.digitavatar.videoavatar.o r43 = r42.e;
        if (r43 != null) goto L113;
        Intrinsics.throwUninitializedPropertyAccessException("showModeProcessor");
    L113:
        r43.o.b("livedigitavatar", "VideoShowModeProcessor_removeEffectDigitAvatar");
    L114:
        hg6.g r44 = P2();
        if (r44 != null) goto L117;
    L119:
        xf6.b r45 = Tq();
        if (r45 == null) goto L140;
        r45.h("resume_from_pk", new MultiLinkVideoTalkRoomGuestWidget$recoverResumeAudienceStatusFromPK$2(this), new MultiLinkVideoTalkRoomGuestWidget$recoverResumeAudienceStatusFromPK$3(this), new MultiLinkVideoTalkRoomGuestWidget$recoverResumeAudienceStatusFromPK$4(this));
        return;
    L140:
        return;
    L117:
        if (r44.isEngineOn() != true) goto L119;
        TalkRoomLogUtils.B.g0();
    L83:
        r33 = MapsKt.emptyMap();
    L78:
        r31 = null;
        goto L79
    L69:
        DigitAvatarContext r46 = r24.getContext();
        if (r46 == null) goto L72;
        DigitAvatarContext.setVideoShowMode$default(r46, VideoShowMode.AUDIO, null, 2, null);
    L72:
        com.bytedance.android.livesdk.sharedpref.e r47 = com.bytedance.android.livesdk.sharedpref.c.Y0;
        Integer r48 = Integer.valueOf(VideoShowMode.AUDIO.getType());
        r47.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r47, r48);
    L36:
        r16 = null;
        goto L38
    L40:
        r13 = null;
    L44:
        r18 = 0;
        goto L45
    L15:
        r6 = null;
        goto L17
    L11:
        r4 = null;
    L7:
        r2 = null;
        goto L8
    }

    public final void Wr() {
        Activity r0 = ContextUtil.contextToActivity(((Widget) this).context);
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isFinishing() == true) goto L58;
        hg6.g r1 = P2();
        if (r1 != null) goto L9;
        return;
    L9:
        if (r1.isEngineOn() == true) goto L11;
        return;
    L11:
        if (jc1.k.n(IKtvService.class).isCurrentUserIsSinger() != true) goto L13;
        boolean r2 = true;
    L14:
        if (r2 == true) goto L61;
        jg6.a r3 = Eq();
        if (r3 == null) goto L20;
        kg6.e r4 = r3.b();
        if (r4 == null) goto L20;
        boolean r5 = r4.q();
    L55:
        PowerManager r6 = (PowerManager) ((Widget) this).context.getSystemService("power");     // Catch: Throwable -> L27
        if (r6.isInteractive() == true) goto L26;
        if (r6.isScreenOn() == true) goto L26;
    L29:
        boolean r7 = false;
    L31:
        if (r7 == false) goto L49;
        Boolean r8 = this.e3;
        if (r8 != null) goto L35;
        return;
    L35:
        if ((!Intrinsics.areEqual(r8, Boolean.valueOf(r5))) == true) goto L37;
        return;
    L37:
        if (r5 == false) goto L43;
        jg6.a r9 = Eq();
        if (r9 == null) goto L48;
        kg6.e r10 = r9.b();
        if (r10 == null) goto L48;
        r10.z(new kg6.d(false, true, "screen on", 8));
    L48:
        this.e3 = null;
        return;
    L43:
        jg6.a r11 = Eq();
        if (r11 == null) goto L48;
        kg6.e r12 = r11.b();
        if (r12 == null) goto L48;
        r12.t(new kg6.b(false, true, "screen on", 8));
        goto L48
    L49:
        this.e3 = Boolean.valueOf(r5);
        jg6.a r13 = Eq();
        if (r13 == null) goto L65;
        kg6.e r14 = r13.b();
        if (r14 == null) goto L66;
        r14.t(new kg6.b(false, true, "screen lock", 8));
        return;
    L66:
        return;
    L65:
        return;
    L26:
        r7 = true;
    L27:
        th = move-exception;
        th.printStackTrace();
    L20:
        r5 = false;
        goto L55
    L61:
        return;
    L13:
        r2 = false;
        goto L14
    }

    public final void Xr() {
        String r0 = LinkmicOnlineFloatWindowManager.Y;
        we0.b r1 = LinkmicOnlineFloatWindowManager.c.a().u;
        if (r1 != null) goto L5;
        return;
    L5:
        if (r1.G == null) goto L10;
        if (je0.d.t(je0.d.h()) == false) goto L19;
        LinkResultDialogFragmentV2.u.getClass();
        RxUtilKt.h(Observable.timer(LinkResultDialogFragmentV2.t, TimeUnit.MILLISECONDS)).doOnNext(new g0(r1, this)).subscribe();
    L19:
        LinkmicOnlineFloatWindowManager r2 = LinkmicOnlineFloatWindowManager.c.a();
        we0.b r3 = new we0.b.a().a();
        r2.getClass();
        Intrinsics.checkNotNullParameter(r3, "params");
        r2.u = r3;
        return;
    L10:
        if (r1.H == null) goto L15;
        if (je0.d.t(je0.d.h()) == false) goto L19;
        LinkResultDialogFragmentV2.u.getClass();
        RxUtilKt.h(Observable.timer(LinkResultDialogFragmentV2.t, TimeUnit.MILLISECONDS)).doOnNext(new h0(r1, this)).subscribe();
        goto L19
    L15:
        if (r1.I == null) goto L19;
        if (je0.d.t(je0.d.h()) == false) goto L19;
        LinkResultDialogFragmentV2.u.getClass();
        RxUtilKt.h(Observable.timer(LinkResultDialogFragmentV2.t, TimeUnit.MILLISECONDS)).doOnNext(new i0(r1, this)).subscribe();
        goto L19
    }

    @Override // rj0.l
    public final void b3() {
        ChatMatchWidget r0 = this.t;
        if (r0 == null) goto L6;
        ChatMatchWidget.Aq(r0, null, true, null, 12);
        return;
    }

    public final void cr() {
        int r0 = xe0.j.a;
        getMRoom();
        if (xe0.j.a() == true) goto L5;
        return;
    L5:
        LinkmicApplyFloatWindowManager.d r1 = LinkmicApplyFloatWindowManager.y;
        we0.b r2 = LinkmicApplyFloatWindowManager.e.a().i(getMRoom().getRoomId());
        if (r2 == null) goto L24;
        br(1, MultiLinkVideoTalkRoomGuestWidget$autoJoinChannel$1$1.INSTANCE, MultiLinkVideoTalkRoomGuestWidget$autoJoinChannel$1$2.INSTANCE, LinkApi.ApplyStashType.APPLY_WINDOW.ordinal());
        Ur(r2);
        hd0.c.f().k(1);
        z0 r3 = r2.B;
        if (r3 == null) goto L22;
        DigitAvatarContext r4 = DigitAvatarContext.Companion.getContext();
        if (r4 == null) goto L12;
        DigitAvatarContext.setVideoShowMode$default(r4, VideoShowMode.AUDIO, null, 2, null);
    L12:
        this.r.c1(r3.getAnchorLinkMicIdStr());
        this.r.D0(r3.getBackupInfo());
        this.r.a(r3.getRtcExtInfo());
        H4((z0) r3.castTo(com.bytedance.android.live.liveinteract.multianchor.model.b.class));
        cg6.a r5 = Bq();
        if (r5 == null) goto L17;
        MultiLinkGuestManager r6 = r5.W4();
        if (r6 == null) goto L17;
        r6.g();
    L17:
        TalkRoomBusinessFullLinkMonitor r7 = TalkRoomBusinessFullLinkMonitor.a;
        String r8 = this.r.getInteractId();
        Long r9 = r2.C;
        if (r9 == null) goto L20;
        long r10 = r9.longValue();
    L21:
        r7.getClass();
        TalkRoomBusinessFullLinkMonitor.f(r8, r10);
        goto L22
    L20:
        r10 = 0;
    L22:
        LinkmicApplyFloatWindowManager.e.a().s = null;
        return;
    }

    @Override // rj0.l
    public final String currentCPositionUserType() {
        CPositionContext.a r0 = CPositionContext.Companion;
        if (r0.d() != EnlargeGuestInfo.EnlargeGuestType.EnlargeGuestType_Double.ordinal()) goto L6;
        return "double";
    L6:
        com.bytedance.android.livesdk.chatroom.viewmodel.j r1 = ur();
        String r4 = null;
        if (r1 != null) goto L9;
    L37:
        com.bytedance.android.livesdk.chatroom.viewmodel.j r2 = ur();
        if (r2 == null) goto L40;
        List r3 = r2.b;
    L42:
        if (com.bytedance.android.livesdk.chatroom.interact.model.d0.c(r3) == false) goto L63;
        com.bytedance.android.live.liveinteract.plantform.core.y r5 = Aq();
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
        com.bytedance.android.live.liveinteract.plantform.core.y r13 = Aq();
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
        com.bytedance.android.live.liveinteract.plantform.utils.u r0 = this.b2;
        if (r0 == null) goto L8;
        Integer r1 = r0.d();
        if (r1 == null) goto L8;
        return r1.intValue();
    L8:
        return PublicStreamClientMixStrategy.None.ordinal();
    }

    public final void er() {
        if (((Boolean) vm2.d.h.getValue(null, vm2.d.a[6])).booleanValue() == true) goto L5;
        return;
    L5:
        int r0 = c1.a;
        if (c1.a(0, je0.d.h()) == false) goto L40;
        if (e5.n() == true) goto L40;
        com.bytedance.live.datacontext.n r1 = com.bytedance.android.live.liveinteract.api.utils.m.e(this).getLinkmicReturnRoomParams();
        if (r1 == null) goto L12;
        Object r2 = r1.getValue();
    L14:
        if ((r2 instanceof we0.b) == true) goto L16;
        r2 = null;
    L16:
        we0.b r3 = (we0.b) r2;
        if (r3 != null) goto L19;
    L36:
        com.bytedance.live.datacontext.n r4 = com.bytedance.android.live.liveinteract.api.utils.m.e(this).getLinkmicReturnRoomParams();
        if (r4 == null) goto L40;
        r4.setValue(null);
        goto L40
    L19:
        if (Intrinsics.areEqual(r3.D, Boolean.TRUE) == false) goto L36;
        jy0.b.d("MultiLinkVideoTalkRoomGuestWidget", "[PCLandscape] joinchannel after switch to portrait");
        Ur(r3);
        z0 r5 = r3.B;
        if (r5 == null) goto L29;
        cg6.a r6 = Bq();
        if (r6 == null) goto L29;
        vb6.g r7 = r6.O5();
        if (r7 == null) goto L29;
        ac6.a r8 = r7.a();
        if (r8 == null) goto L29;
        r8.j0(r5.castTo(com.bytedance.android.live.liveinteract.multianchor.model.b.class));
    L29:
        sf0.e r9 = r3.F;
        if (r9 == null) goto L36;
        cg6.a r10 = Bq();
        if (r10 == null) goto L36;
        MultiLinkGuestManager r11 = r10.W4();
        if (r11 == null) goto L36;
        r11.j(r9);
        goto L36
    L12:
        r2 = null;
    L40:
        if (c1.a(0, je0.d.h()) == true) goto L42;
        return;
    L42:
        if (e5.n() == false) goto L50;
        cg6.a r12 = Bq();
        if (r12 == null) goto L51;
        vb6.g r13 = r12.O5();
        if (r13 == null) goto L52;
        r13.e1(new f(this), false);
        return;
    L52:
        return;
    L51:
        return;
    }

    @Override // rj0.l
    public final void exitRoom() {
        t0.a("MultiLinkVideoTalkRoomGuestWidget", "exitRoom");
        tf0.o r0 = this.T;
        if (r0 == null) goto L6;
        r0.exitRoom();
        return;
    }

    @Override // rj0.l
    public final void forceReverseCamera() {
        m00.g r0 = this.U;
        if (r0 == null) goto L6;
        r0.q();
        return;
    }

    @Override // rj0.l
    public final List<ILinkPlayerInfoBridge> getCrossRoomFightLinkUserInfoList() {
        tf0.o r0 = this.T;
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

    @Override // rj0.l
    public final JsonObject getLinkmicAreaFrameInfo() {
        tf0.o r0 = this.T;
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

    @Override // rj0.l
    public final JsonObject getLinkmicSeatListInfo() {
        tf0.o r0 = this.T;
        List<tf0.e> r1 = null;
        if (r0 != null) goto L5;
        return null;
    L5:
        List<tf0.e> r2 = r0.e();
        if (r2 == null) goto L15;
        Iterator<T> r3 = r2.iterator();
    L9:
        if (r3.hasNext() == false) goto L13;
        Object r4 = r3.next();
        if ((!(((tf0.e) r4) instanceof MultiLinkNormalEmptyViewBinder.a)) == false) goto L9;
    L14:
        tf0.e r5 = (tf0.e) r4;
    L16:
        if (r5 == null) goto L22;
        String r6 = "seat";
        nh0.e r7 = null;
        tf0.o r8 = this.T;
        if (r8 == null) goto L21;
        r1 = r8.e();
    L21:
        return new nh0.f(r6, r7, r1, null, null, null, false, 246).b();
    L22:
        return null;
    L13:
        r4 = null;
        goto L14
    L15:
        r5 = null;
        goto L16
    }

    @Override // tf0.o.a
    public final uf2.d0 getLiveCore() {
        v0 r0 = this.c;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.A();
    }

    @Override // rj0.l
    public final com.bytedance.android.live.pushstream.d getLiveStream() {
        m00.g r0 = this.U;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getLiveStream();
    }

    public final String gr() {
        m00.g r0 = this.U;
        long r1 = 0;
        if (r0 != null) goto L5;
    L9:
        m00.g r2 = this.U;
        if (r2 == null) goto L13;
        r1 = r2.b();
    L13:
        return String.valueOf(r1 / ((long) 1000));
    L5:
        if (r0.b() != 0) goto L9;
        return null;
    }

    @Override // zj0.e.b
    public final void h5() {
        View r0 = ((Widget) this).contentView;
        if (r0 == null) goto L5;
        View r1 = r0.findViewById(2131363980);
    L6:
        if (r1 == null) goto L9;
        r1.setVisibility(8);
        return;
    L9:
        return;
    L5:
        r1 = null;
        goto L6
    }

    @Override // rj0.f
    public final boolean isLinkCasting() {
        LinkCastGuestWidget r0 = this.L1;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.isLinkCasting();
    }

    public final long jr() {
        if (this.G2 >= 0) goto L6;
        this.G2 = (this.s - this.y2) / ((long) 1000);
    L6:
        return this.G2;
    }

    public final zj0.d kr() {
        zj0.e r0 = this.X2;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("layoutSwitcher");
    L5:
        zj0.d r1 = r0.d;
        if (r1 == null) goto L8;
        return r1;
    L8:
        return zj0.d.a.h;
    }

    public final boolean l5() {
        m00.g r0 = this.U;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.isCameraOpen() != true) goto L7;
        return true;
    }

    @Override // tf0.o.a
    public final String l6() {
        return this.x.a;
    }

    @Override // tf0.o.a
    public final int mc() {
        com.bytedance.android.live.liveinteract.plantform.utils.u r0 = this.b2;
        if (r0 == null) goto L8;
        Integer r1 = r0.e();
        if (r1 == null) goto L8;
        return r1.intValue();
    L8:
        return PublicStreamPlayState.None.ordinal();
    }

    public final int mr() {
        zj0.e r0 = this.X2;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("layoutSwitcher");
    L5:
        zj0.d r1 = r0.d;
        if (r1 == null) goto L8;
        int r2 = r1.a;
    L9:
        if (r2 == 0) goto L16;
        zj0.e r3 = this.X2;
        if (r3 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("layoutSwitcher");
    L13:
        zj0.d r4 = r3.d;
        if (r4 != null) goto L25;
        return 0;
    L25:
        return r4.a;
    L16:
        com.bytedance.live.datacontext.j r5 = com.bytedance.android.live.liveinteract.api.utils.m.e(this).getVideoTalkRoomSubScene();
        if (r5 == null) goto L26;
        com.bytedance.android.livesdk.chatroom.viewmodel.e r6 = (com.bytedance.android.livesdk.chatroom.viewmodel.e) r5.getValue();
        if (r6 == null) goto L27;
        com.bytedance.android.livesdk.chatroom.viewmodel.j r7 = r6.t();
        if (r7 != null) goto L23;
        return 0;
    L23:
        return r7.a;
    L27:
        return 0;
    L26:
        return 0;
    L8:
        r2 = 0;
        goto L9
    }

    public final String nr() {
        if (((Boolean) vm2.d.b0.getValue(null, vm2.d.a[51])).booleanValue() == false) goto L6;
        return null;
    L6:
        return TalkRoomLogUtils.p(Integer.valueOf(kr().a), Integer.valueOf(kr().b), null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [android.view.View, android.view.ViewGroup, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v57 */
    /* JADX WARN: Type inference failed for: r0v60 */
    /* JADX WARN: Type inference failed for: r0v61 */
    /* JADX WARN: Type inference failed for: r18v0, types: [androidx.lifecycle.LifecycleOwner, com.bytedance.android.live.liveinteract.linkpanel.widget.PlatformMultiLinkWidget, com.bytedance.android.live.liveinteract.plantform.widgt.MultiLinkBaseGuestLinkWidget, com.bytedance.android.live.liveinteract.plantform.widgt.videolink.MultiLinkVideoBaseGuestLinkWidget, com.bytedance.android.live.liveinteract.videotalk.MultiLinkVideoTalkRoomGuestWidget, com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget, com.bytedance.android.livesdk.chatroom.widget.j1, com.bytedance.ies.sdk.widgets.Widget, java.lang.Object, tf0.o$a, zj0.e$b] */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r4v12, types: [android.view.ViewGroup] */
    /* JADX WARN: Type inference failed for: r4v15, types: [android.view.ViewGroup] */
    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.videolink.MultiLinkVideoBaseGuestLinkWidget, com.bytedance.android.live.liveinteract.plantform.widgt.MultiLinkBaseGuestLinkWidget, com.bytedance.android.live.liveinteract.linkpanel.widget.PlatformMultiLinkWidget, com.bytedance.android.live.liveinteract.linkbase.api.BaseMultiLinkWidget
    public final void onCreate() {
        multiLinkRoomScopeFallback();
        super.onCreate();
        Lazy r0 = MultiLinkLoadWidgetUtils.a;
        MultiLinkLoadWidgetUtils.n(((Widget) this).dataCenter, "MultiLinkVideoTalkRoomGuestWidget#" + hashCode(), "call onCreate");
        boolean r10 = false;
        r10 = false;
        Integer r1 = null;
        boolean r2 = false;
        if (MultiLinkLoadWidgetUtils.g() == false) goto L13;
        int r3 = com.bytedance.android.live.liveinteract.plantform.multiroom.e.a;
        com.bytedance.android.live.liveinteract.plantform.commonwindow.l r4 = com.bytedance.android.live.liveinteract.plantform.multiroom.e.d(((Widget) this).dataCenter);
        if (r4 == null) goto L7;
        BaseLinkSeatWindowView r5 = r4.getLinkSeatWindowView();
    L8:
        if (r5 == null) goto L13;
        com.bytedance.android.live.liveinteract.plantform.commonwindow.l r6 = com.bytedance.android.live.liveinteract.plantform.multiroom.e.d(((Widget) this).dataCenter);
        if (r6 == null) goto L12;
        ?? r7 = r6.getLinkSeatWindowView();
    L14:
        ALogger.i("MultiLinkVideoTalkRoomGuestWidget", "updateWindowViewParent windowView=" + r7 + ", containerView=" + ((Widget) this).containerView);
        if (r7 == null) goto L30;
        ViewGroup.LayoutParams r8 = r7.getLayoutParams();
        if ((r8 instanceof FrameLayout.LayoutParams) == true) goto L20;
        r8 = null;
    L20:
        FrameLayout.LayoutParams r9 = (FrameLayout.LayoutParams) r8;
        ViewParent r11 = r7.getParent();
        if ((r11 instanceof ViewGroup) == true) goto L23;
        r11 = null;
    L23:
        ?? r12 = (ViewGroup) r11;
        if (r12 == null) goto L26;
        r12.removeView(r7);
    L26:
        ?? r13 = (ViewGroup) ((Widget) this).containerView.findViewById(2131378012);
        r13.removeAllViews();
        if (r9 != null) goto L29;
        r9 = new FrameLayout.LayoutParams(-1, -1);
        r9.gravity = 49;
    L29:
        r13.addView(r7, r9);
    L30:
        int r14 = MultiSceneEnterRoomStatisticsUtils.u;
        DataCenter r15 = ((Widget) this).dataCenter;
        IRoom r16 = getMRoom();
        if (r16 == null) goto L33;
        Long r17 = Long.valueOf(r16.getId());
    L34:
        MultiSceneEnterRoomStatisticsUtils r18 = MultiSceneEnterRoomStatisticsUtils.a.a(r15, Long.valueOf(r17.longValue()));
        if (r18 == null) goto L38;
        IMultiSceneCommonStatistics.DefaultImpls.recordSubElementShow$default(r18, "widget_load", 0, 2, null);
    L38:
        if (vm2.d.P0() == false) goto L47;
        ILivePlayerClient r19 = hs0.a.b.getCurrentClient();
        if (r19 == null) goto L47;
        IRoomEventHub r20 = r19.getEventHub();
        if (r20 == null) goto L47;
        MutableLiveData r21 = r20.getVideoSizeChanged();
        if (r21 == null) goto L47;
        r21.observe(this, new com.bytedance.android.live.liveinteract.videotalk.z(this));
    L47:
        if (vm2.d.O0() == false) goto L55;
        View r22 = hs0.a.b.getCurrentLivePlayerParent();
        this.a3 = r22;
        if (r22 == null) goto L51;
        r22.addOnLayoutChangeListener(this.b3);
    L51:
        StringBuilder r23 = new StringBuilder("registerLivePlayerSizeUpdateEvent addListener, GuestWidget=");
        r23.append(hashCode());
        r23.append(", livePlayerParent=");
        View r24 = this.a3;
        if (r24 == null) goto L54;
        r1 = Integer.valueOf(r24.hashCode());
    L54:
        r23.append(r1);
        jy0.b.d("MultiLinkVideoTalkRoomGuestWidget", r23.toString());
    L55:
        ConstraintLayout r25 = ((Widget) this).contentView.findViewById(2131363980);
        if (r25 == null) goto L78;
        com.bytedance.android.live.liveinteract.plantform.utils.u r110 = new com.bytedance.android.live.liveinteract.plantform.utils.u(((Widget) this).context, ((Widget) this).dataCenter, r25, getMRoom(), this, p5(), this);
        this.b2 = r110;
        r110.j();
        Cr();
        MultiLinkLoadWidgetUtils.n(((Widget) this).dataCenter, "MultiLinkVideoTalkRoomGuestWidget#" + hashCode(), "call initOnCreate");
        Pair r26 = com.bytedance.live.datacontext.d.a(MultiLinkVideoTalkRoomGuestWidget$initOnCreate$pair$1.INSTANCE);
        ((VideoTalkGuestContext) r26.getFirst()).getService().d(this);
        com.bytedance.live.datacontext.b.a((DataContext) r26.getFirst(), "guest_video_talk");
        this.F.add((Disposable) r26.getSecond());
        Pair r27 = com.bytedance.live.datacontext.d.a(MultiLinkVideoTalkRoomGuestWidget$initOnCreate$pair2$1.INSTANCE);
        ((VideoTalkAdminContext) r27.getFirst()).getService().d(this);
        com.bytedance.live.datacontext.b.a((DataContext) r27.getFirst(), "admin_video_talk");
        this.F.add((Disposable) r27.getSecond());
        this.k0 = new InteractAnimationController(((Widget) this).dataCenter);
        Pair r28 = com.bytedance.live.datacontext.d.a(MultiLinkVideoTalkRoomGuestWidget$initOnCreate$animationContext$1.INSTANCE);
        ((InteractAnimationContext) r28.getFirst()).getController().d(this.k0);
        com.bytedance.live.datacontext.b.a((DataContext) r28.getFirst(), InteractAnimationContext.class);
        sh0.i0 r29 = sh0.j0.a;
        this.G = sh0.j0.c(((Widget) this).dataCenter, this);
        this.S = new yj0.a(getMRoom(), false, ((Widget) this).dataCenter);
        DataCenter r30 = ((Widget) this).dataCenter;
        ViewGroup r31 = ((Widget) this).containerView;
        com.bytedance.android.livesdk.chatroom.u r32 = com.bytedance.android.live.liveinteract.api.utils.m.e(this);
        InteractAnimationController r33 = this.k0;
        Intrinsics.checkNotNull(r33);
        zj0.e r34 = new zj0.e(r30, r31, r32, this, r33);
        this.X2 = r34;
        zj0.d.b r35 = new zj0.d.b(0, 0, 0, 0, 0, 31);
        MultiLinkVideoTalkRoomGuestWidget$registerWindowMangers$1 r36 = new MultiLinkVideoTalkRoomGuestWidget$registerWindowMangers$1(this);
        Intrinsics.checkNotNullParameter(r35, "layoutConfig");
        Intrinsics.checkNotNullParameter(r36, "provider");
        r34.a.add(r35);
        r34.b.put(r35.f, r36);
        LinkedHashMap r37 = new LinkedHashMap();
        if (vm2.h.R() == false) goto L60;
        r37.put("room_id", String.valueOf(getMRoom().getId()));
        r37.put("anchor_id", String.valueOf(getMRoom().getAnchorId()));
        LiveMode r38 = getMRoom().getStreamType();
        int r39 = com.bytedance.android.live.core.utils.h1.a;
        r37.put("live_type", i1.a(r38));
    L60:
        r37.put("play_mode", u0.b());
        if (MultiLinkLoadWidgetUtils.g() == true) goto L64;
        Kr("livesdk_audience_voice_room_show", r37);
        int r40 = com.bytedance.android.live.liveinteract.plantform.multiroom.b.a;
        com.bytedance.android.live.liveinteract.plantform.multiroom.b.c(((Widget) this).dataCenter, (String) r37.get("function_type2"), "MultiLinkVideoTalkRoomGuestWidget#initOnCreate");
    L64:
        if (MultiLinkLoadWidgetUtils.d() == false) goto L72;
        DataCenter r41 = ((Widget) this).dataCenter;
        if (r41 == null) goto L70;
        Boolean r42 = (Boolean) r41.get("data_multi_link_log_enter", Boolean.FALSE);
        if (r42 == null) goto L70;
        r10 = r42.booleanValue();
    L70:
        if (r10 == true) goto L72;
        r37.put("ui_widget_source", "FallbackLog on Create");
        Kr("livesdk_audience_voice_room_show", r37);
        int r43 = com.bytedance.android.live.liveinteract.plantform.multiroom.b.a;
        com.bytedance.android.live.liveinteract.plantform.multiroom.b.c(((Widget) this).dataCenter, (String) r37.get("function_type2"), "MultiLinkVideoTalkRoomGuestWidget#initOnCreate LogFallback");
        String r44 = vm2.h.W().fallbackLogType();
        int r45 = mr();
        int r46 = kr().b;
        String r47 = TalkRoomLogUtils.h;
        LiveTracingMonitor.a(r44, new Throwable("MultiLinkFallbackLog"), "fall back log: rid: " + getMRoom().getIdStr() + ", scene: " + r45 + ", uiLayout: " + r46 + ", function_type2: " + r47);
    L72:
        this.L0 = new com.bytedance.android.live.liveinteract.utils.g0(getMRoom(), Aq());
        if (MultiLinkLoadWidgetUtils.f() == true) goto L75;
        Sr();
    L75:
        this.h3.a(this);
        return;
    L78:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
    L33:
        r17 = null;
        goto L34
    L12:
        r7 = null;
        goto L14
    L7:
        r5 = null;
    L13:
        int r111 = r10 ? 1 : 0;
        CommonLinkSeatWindowView r48 = new CommonLinkSeatWindowView(((Widget) this).context, r2 ? 1 : 0, 6, r111);
        r48.setId(2131378011);
        r7 = r48;
        goto L14
    }

    /* JADX WARN: Type inference failed for: r10v22, types: [android.app.Dialog, com.bytedance.android.live.liveinteract.widget.widget.q, java.lang.Object] */
    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.videolink.MultiLinkVideoBaseGuestLinkWidget, com.bytedance.android.live.liveinteract.plantform.widgt.MultiLinkBaseGuestLinkWidget, com.bytedance.android.live.liveinteract.linkpanel.widget.PlatformMultiLinkWidget, com.bytedance.android.live.liveinteract.linkbase.api.BaseMultiLinkWidget
    public final void onDestroy() {
        multiLinkRoomScopeFallback();
        Lazy r0 = MultiLinkLoadWidgetUtils.a;
        MultiLinkLoadWidgetUtils.n(((Widget) this).dataCenter, "MultiLinkVideoTalkRoomGuestWidget#" + hashCode(), "call onDestroy");
        StringBuilder r1 = new StringBuilder("unregisterLivePlayerVideoSizeEvent removeListener, GuestWidget=");
        r1.append(hashCode());
        r1.append(", livePlayerParent=");
        View r2 = this.a3;
        if (r2 == null) goto L5;
        int r3 = r2.hashCode();
    L6:
        r1.append(r3);
        jy0.b.d("MultiLinkVideoTalkRoomGuestWidget", r1.toString());
        View r4 = this.a3;
        if (r4 == null) goto L9;
        r4.removeOnLayoutChangeListener(this.b3);
    L9:
        this.a3 = null;
        hg6.g r5 = P2();
        if (r5 == null) goto L18;
        ei6.a r6 = r5.V0();
        if (r6 == null) goto L18;
        xi6.c r7 = r6.t();
        if (r7 == null) goto L18;
        com.bytedance.live.livelink.kmp.impl.core.video.b r8 = r7.f();
        if (r8 == null) goto L18;
        r8.j(false);
        Unit r9 = Unit.INSTANCE;
    L18:
        VideoEffectPerfHelper r10 = this.Z2;
        if (r10 == null) goto L21;
        r10.d();
        Unit r11 = Unit.INSTANCE;
    L21:
        n1.b r12 = n1.f;
        uf2.d0 r13 = getLiveCore();
        r12.getClass();
        n1.b.c(r13);
        com.bytedance.android.live.liveinteract.plantform.core.h r14 = this.P;
        if (r14 == null) goto L24;
        r14.b();
        Unit r15 = Unit.INSTANCE;
    L24:
        ILinkPanelService r16 = com.bytedance.android.live.liveinteract.component.b.a();
        if (r16 == null) goto L27;
        r16.close();
        Unit r17 = Unit.INSTANCE;
    L27:
        InteractAnimationController r18 = this.k0;
        if (r18 == null) goto L30;
        r18.l();
        Unit r19 = Unit.INSTANCE;
    L30:
        WidgetManager r20 = ((Widget) this).subWidgetManager;
        if (r20 == null) goto L33;
        r20.unload(this.Y2);
    L33:
        this.Y2 = null;
        com.bytedance.android.livesdk.chatroom.t r21 = com.bytedance.android.live.liveinteract.api.utils.m.b();
        if (r21 == null) goto L40;
        com.bytedance.live.datacontext.j r22 = r21.getMessageManager();
        if (r22 == null) goto L40;
        vlc.d r23 = (vlc.d) r22.getValue();
        if (r23 == null) goto L40;
        r23.removeMessageListener(this);
        Unit r24 = Unit.INSTANCE;
    L40:
        GuestTalkBeInvitedDialog r25 = this.E;
        if (r25 != null) goto L43;
    L53:
        InteractBeautyPreviewDialog r26 = this.w;
        if (r26 == null) goto L65;
        if (r26.isShowing() == true) goto L354;
    L63:
        this.w = null;
        goto L65
    L354:
        r26.dismiss();     // Catch: Exception -> L59
    L59:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r27 = DialogFragmentLancet.sLastShowStack;
        if (r27 == null) goto L63;
        com.bytedance.crash.d.d(r27, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
    L65:
        if (vm2.e.a() == false) goto L67;
        or().e();
    L67:
        com.bytedance.android.livesdk.chatroom.utils.g0.a();
        com.bytedance.android.live.liveinteract.revenue.adventure.linkcore.a r28 = com.bytedance.android.live.liveinteract.revenue.adventure.linkcore.g.a;
        com.bytedance.android.live.liveinteract.revenue.adventure.linkcore.g.d("talkroom destroy");
        com.bytedance.android.live.liveinteract.linksecurity.b r29 = com.bytedance.android.live.liveinteract.linksecurity.b.g;
        LinkedHashMap r30 = new LinkedHashMap();
        com.bytedance.android.live.core.privacy.av.api.b.a.getClass();
        com.bytedance.android.live.core.privacy.av.api.b.a.a r31 = com.bytedance.android.live.core.privacy.av.api.b.a.a;
        com.bytedance.android.live.core.privacy.av.api.a r32 = com.bytedance.android.live.core.privacy.av.api.a.b;
        r29.getClass();
        Intrinsics.checkNotNullParameter(r30, "params");
        Intrinsics.checkNotNullParameter(r31, "callback");
        Intrinsics.checkNotNullParameter(r32, "config");
        r29.c("on_link_destroyed", r30, r31, r32);
        zj0.e r33 = this.X2;
        if (r33 != null) goto L70;
        Intrinsics.throwUninitializedPropertyAccessException("layoutSwitcher");
    L70:
        String r34 = u0.j(Integer.valueOf(r33.a()));
        zj0.e r35 = this.X2;
        if (r35 != null) goto L73;
        Intrinsics.throwUninitializedPropertyAccessException("layoutSwitcher");
    L73:
        Integer r36 = Integer.valueOf(r35.a());
        zj0.e r37 = this.X2;
        if (r37 != null) goto L76;
        Intrinsics.throwUninitializedPropertyAccessException("layoutSwitcher");
    L76:
        zj0.d r38 = r37.d;
        if (r38 == null) goto L79;
        int r39 = r38.a;
    L80:
        Integer r110 = Integer.valueOf(r39);
        zj0.e r40 = this.X2;
        if (r40 != null) goto L83;
        Intrinsics.throwUninitializedPropertyAccessException("layoutSwitcher");
    L83:
        TalkRoomLogUtils.Q(r34, u0.f(r36, r110, r40.h, null, null, null, 56), 1);
        com.bytedance.android.live.liveinteract.linkcast.g.b.getClass();
        if (com.bytedance.android.live.liveinteract.linkcast.g.a.c() == false) goto L92;
        hg6.g r41 = P2();
        if (r41 != null) goto L88;
    L90:
        boolean r42 = false;
    L91:
        com.bytedance.android.live.liveinteract.linkcast.g.a.h(r42);
        goto L92
    L88:
        if (r41.A() != true) goto L90;
        r42 = true;
    L92:
        hg6.g r43 = P2();
        if (r43 != null) goto L95;
    L119:
        this.b1.clear();
        this.h1.clear();
        SwitchCameraManager r44 = this.V;
        if (r44 == null) goto L125;
        r44.a.dispose();
        vlc.d r45 = r44.b;
        if (r45 == null) goto L124;
        r45.removeMessageListener(r44);
    L124:
        Unit r46 = Unit.INSTANCE;
    L125:
        cg6.a r47 = Bq();
        if (r47 == null) goto L132;
        jg6.a r48 = r47.e5();
        if (r48 == null) goto L132;
        lh6.b r49 = r48.a();
        if (r49 == null) goto L132;
        r49.p(null, "guest widget end");
        Unit r50 = Unit.INSTANCE;
    L132:
        cg6.a r51 = Bq();
        if (r51 == null) goto L139;
        jg6.a r52 = r51.e5();
        if (r52 == null) goto L139;
        lh6.b r53 = r52.a();
        if (r53 == null) goto L139;
        r53.o(null, "guest widget end");
        Unit r54 = Unit.INSTANCE;
    L139:
        this.G1.i();
        com.bytedance.android.live.liveinteract.utils.g0 r55 = this.L0;
        if (r55 == null) goto L142;
        int r56 = com.bytedance.android.live.liveinteract.utils.g0.g;
        r55.c(0);
        Unit r57 = Unit.INSTANCE;
    L142:
        com.bytedance.android.live.liveinteract.videotalk.utils.a r58 = this.P0;
        if (r58 == null) goto L145;
        r58.c();
        Unit r59 = Unit.INSTANCE;
    L145:
        oe0.b r60 = this.V0;
        if (r60 != null) goto L148;
    L152:
        HashMap r61 = new HashMap();
        r61.put("live_type", "video_live");
        Long r111 = rr();
        r61.put("duration", String.valueOf(r111));
        r61.put("function_type", "radio");
        TalkRoomLogUtils.B0(r61, Integer.valueOf(mr()), null, 4);
        if (((IInteractService) jc1.k.n(IInteractService.class)).dynamicFromAudience() == false) goto L156;
        r61.put("function_type2", "new_audience");
        r61.put("function_type", "new_audience");
    L156:
        if (vm2.d.v0() == false) goto L158;
        r61.put("function_type2", TalkRoomLogUtils.h);
        r61.put("function_type", TalkRoomLogUtils.h);
    L158:
        TalkRoomLogUtils.W0(r61, Boolean.valueOf(kr().isDynamic()));
        TalkRoomLogUtils.Q0(r61);
        tf0.o r112 = this.T;
        if (r112 != null) goto L161;
    L163:
        IRoom r113 = getMRoom();
        if (r113 == null) goto L170;
        ICircleInfo r114 = r113.getCircleInfo();
        if (r114 == null) goto L170;
        String r115 = r114.getCircleName();
        if (r115 == null) goto L170;
        r61.put("circle_name", r115);
        Unit r116 = Unit.INSTANCE;
    L170:
        com.bytedance.android.live.liveinteract.plantform.utils.i0 r117 = TalkRoomLogUtils.a;
        TalkRoomLogUtils.w0(r61);
        com.bytedance.android.live.liveinteract.plantform.core.y r118 = Aq();
        if (r118 != null) goto L173;
    L177:
        TalkRoomLogUtils.d1(r61, ((Widget) this).dataCenter);
        tf0.o r119 = this.T;
        if ((r119 instanceof MultiLinkVideoTeamFightWindowManager) == false) goto L180;
        r61.put("grouppk_duration", String.valueOf(r111));
        li0.b r120 = li0.b.b;
        ((MultiLinkVideoTeamFightWindowManager) r119).getClass();
        r61.put("grouppk_stage", li0.b.c(MultiLinkVideoTeamFightWindowManager.q1()));
    L180:
        Unit r121 = Unit.INSTANCE;
        TalkRoomLogUtils.T0(r61, true);
        if (com.bytedance.android.live.liveinteract.voicechat.util.e.a(true) == false) goto L183;
        r61.put("is_pre_link", "1");
    L184:
        TalkRoomLogUtils.O0(r61);
        com.bytedance.android.live.liveinteract.linkcast.g.a.a();
        com.bytedance.android.live.liveinteract.linkcast.g.a.f(r61, null);
        IRoom r62 = getMRoom();
        if (r62 == null) goto L190;
        z5 r63 = r62.getLinkerDetail();
        if (r63 == null) goto L190;
        r61.put("enlarge_open_from", String.valueOf(r63.getEnlargeGuestTurnOnSource()));
    L190:
        if (vm2.h.R() == false) goto L192;
        r61.put("room_id", String.valueOf(getMRoom().getId()));
        r61.put("anchor_id", String.valueOf(getMRoom().getAnchorId()));
        LiveMode r65 = getMRoom().getStreamType();
        int r122 = com.bytedance.android.live.core.utils.h1.a;
        r61.put("live_type", i1.a(r65));
    L192:
        r61.put("play_mode", u0.b());
        int r66 = com.bytedance.android.live.liveinteract.plantform.multiroom.b.a;
        if (com.bytedance.android.live.liveinteract.plantform.multiroom.b.a(((Widget) this).dataCenter, (String) r61.get("function_type2"), "MultiLinkVideoTalkRoomGuestWidget#onDestroy") == false) goto L198;
        HashMap r67 = new HashMap();
        r67.put("ui_widget_source", "FallbackLog on destroy");
        if (vm2.h.R() == false) goto L197;
        r67.put("room_id", String.valueOf(getMRoom().getId()));
        r67.put("anchor_id", String.valueOf(getMRoom().getAnchorId()));
        LiveMode r123 = getMRoom().getStreamType();
        int r124 = com.bytedance.android.live.core.utils.h1.a;
        r67.put("live_type", i1.a(r123));
    L197:
        Kr("livesdk_audience_voice_room_show", r67);
        com.bytedance.android.live.liveinteract.plantform.multiroom.b.b(((Widget) this).dataCenter, "MultiLinkVideoTalkRoomGuestWidget#onDestroy");
    L198:
        mz0.n r68 = new mz0.n();
        Map r69 = r68.a;
        Intrinsics.checkNotNullParameter(r69, "map");
        Intrinsics.checkNotNullParameter(r61, "map");
        r69.putAll(r61);
        mz0.m r70 = new mz0.m();
        r70.b(LogCommon.ROOM);
        r70.b(LogCommon.PAGE_SOURCE_LOG);
        r70.b(LogCommon.GAME_PARAM_ITEM);
        ((ArrayList) r68.b).addAll(r70.a);
        cy0.e.a.getClass();
        cy0.j r71 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r72 = com.bytedance.android.scope.m.b(r71).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r72);
        ((f80.a) r72).w3("livesdk_voice_room_watch_duration", r68.a, r68.b);
        TalkRoomLogUtils.p0(r61, sr());
        TalkRoomLogUtils.q0(r61, tr());
        com.bytedance.live.datacontext.j r73 = com.bytedance.android.live.liveinteract.api.utils.m.e(this).getVideoTalkRoomSubScene();
        if (r73 == null) goto L205;
        com.bytedance.android.livesdk.chatroom.viewmodel.e r74 = (com.bytedance.android.livesdk.chatroom.viewmodel.e) r73.getValue();
        if (r74 == null) goto L205;
        com.bytedance.android.livesdk.chatroom.viewmodel.j r75 = r74.t();
        if (r75 == null) goto L205;
        List r76 = r75.b;
    L206:
        List r77 = CollectionsKt.emptyList();
        if (mr() != 16) goto L209;
        Lr(kr(), zj0.d.a.h, r76, r77);
    L209:
        xf6.b r78 = Tq();
        if (r78 == null) goto L213;
        r78.f("MultiLinkVideoTalkRoomGuestWidget onEngineEndSuccess");
    L213:
        if (vm2.d.j0() == false) goto L224;
        WidgetManager r79 = ((Widget) this).subWidgetManager;
        if (r79 == null) goto L224;
        List r80 = r79.widgets;
        if (r80 == null) goto L224;
        if (r80.size() <= 0) goto L224;
        Iterator r81 = ((Widget) this).subWidgetManager.widgets.iterator();
    L222:
        if (r81.hasNext() == false) goto L224;
        ((Widget) this).subWidgetManager.unload((Widget) r81.next());
    L224:
        super.onDestroy();
        DataCenter r82 = ((Widget) this).dataCenter;
        if (r82 == null) goto L227;
        String r83 = (String) r82.get("data_room_unique_id", "");
    L228:
        tc0.c.i(r83).O = null;
        tf0.o r84 = this.T;
        if (r84 == null) goto L231;
        r84.end();
        Unit r85 = Unit.INSTANCE;
    L231:
        ((Widget) this).dataCenter.put("cmd_video_talkroom_state_change", new l3(1));
        tc0.c r86 = tc0.c.h();
        Boolean r87 = Boolean.FALSE;
        r86.j(r87);
        com.bytedance.live.datacontext.m r88 = com.bytedance.android.live.liveinteract.api.utils.m.e(this).m();
        if (r88 == null) goto L234;
        r88.setValue(r87);
    L234:
        this.F.clear();
        ((Widget) this).dataCenter.removeObserver(this);
        ILinkPanelService r89 = com.bytedance.android.live.liveinteract.component.b.a();
        if (r89 == null) goto L237;
        r89.close();
        Unit r90 = Unit.INSTANCE;
    L237:
        com.bytedance.android.livesdk.common.b r91 = this.v;
        if (r91 != null) goto L240;
    L262:
        com.bytedance.android.livesdk.app.dataholder.Observer r125 = this.u;
        if (r125 == null) goto L283;
        Handler r92 = DialogLancet.resolveDialogHandler(r125);
        if (r92 != null) goto L267;
    L269:
        DialogLancet.beforeDialogDismiss(r125);
        r125.dismiss();     // Catch: Throwable -> L272 Exception -> L274
    L279:
        DialogLancet.afterDialogDismiss(r125);
    L280:
        Unit r93 = Unit.INSTANCE;
        goto L283
    L274:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L272
        Throwable r94 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L272
        if (r94 == null) goto L279;
        com.bytedance.crash.d.d(r94, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L272
    L272:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r125);
        throw th;
    L267:
        if (Looper.myLooper() == r92.getLooper()) goto L269;
        r92.post(DialogLancet.createDismissRunnable(r125));
    L283:
        LivePluginSPIManager.e.getClass();
        LivePluginSPIManager.a().addOnSuccess(new m()).callbackOnMainThread().syncCallbackIfReady(true).requireByUser("MultiLinkVideoTalkRoomGuestWidget");
        int r95 = us1.g.a;
        us1.g.a(((Widget) this).dataCenter, false);
        com.bytedance.live.datacontext.j r96 = com.bytedance.android.live.liveinteract.api.utils.m.e(this).getVideoTalkRoomSubScene();
        if (r96 == null) goto L288;
        com.bytedance.android.livesdk.chatroom.viewmodel.e r97 = (com.bytedance.android.livesdk.chatroom.viewmodel.e) r96.getValue();
        if (r97 == null) goto L288;
        r97.reset();
        Unit r98 = Unit.INSTANCE;
    L288:
        this.V2.b();
        zj0.e r99 = this.X2;
        if (r99 != null) goto L291;
        Intrinsics.throwUninitializedPropertyAccessException("layoutSwitcher");
    L291:
        r99.c.clear();
        yj0.a r100 = this.S;
        if (r100 == null) goto L294;
        r100.detachView();
        Unit r101 = Unit.INSTANCE;
    L294:
        x00.a r102 = this.Y;
        if (r102 == null) goto L297;
        r102.c(vh7.f.c(IVoiceLiveTheme.class), 3);
    L297:
        x00.a r103 = this.Y;
        if (r103 == null) goto L300;
        r103.c(vh7.f.c(IVoiceLiveTheme.class), 4);
    L300:
        com.bytedance.android.live.liveinteract.linksecurity.b.g.l();
        com.bytedance.live.datacontext.j r104 = com.bytedance.android.live.liveinteract.api.utils.m.e(this).J();
        if (r104 == null) goto L305;
        LivePlayModeLogContext r105 = (LivePlayModeLogContext) r104.getValue();
        if (r105 == null) goto L305;
        r105.clearPlayModesOnlySupportMultiPeople();
        Unit r106 = Unit.INSTANCE;
    L305:
        com.bytedance.android.live.liveinteract.plantform.utils.i.b();
        this.H2 = false;
        ne0.c r107 = this.G;
        if (r107 == null) goto L308;
        r107.d0(sh0.d0.b, null);
        Unit r108 = Unit.INSTANCE;
    L308:
        sh0.i0 r109 = sh0.j0.a;
        sh0.j0.b(((Widget) this).dataCenter);
        hg6.g r126 = P2();
        if (r126 == null) goto L312;
        r126.i(false);
        Unit r127 = Unit.INSTANCE;
    L312:
        if (vm2.d.K0() == true) goto L314;
    L319:
        Lazy r128 = MultiComponentManager.e;
        MultiComponentManager.a.a().b(((Widget) this).context);
        cg6.a r129 = Bq();
        if (r129 == null) goto L322;
        r129.release();
    L322:
        boolean r130 = MatchRoomLandScapeAnimUtil.a;
        MatchRoomLandScapeAnimUtil.t(this.I2);
        Disposable r131 = this.R2;
        if (r131 == null) goto L325;
        r131.dispose();
        Unit r132 = Unit.INSTANCE;
    L325:
        this.R2 = null;
        this.M = null;
        Context r133 = ((Widget) this).context;
        if ((r133 instanceof FragmentActivity) == true) goto L328;
        r133 = null;
    L328:
        FragmentActivity r134 = (FragmentActivity) r133;
        if (r134 == null) goto L333;
        FragmentManager r135 = r134.getSupportFragmentManager();
        if (r135 == null) goto L333;
        LinkResultDialogFragment.l.getClass();
        Fragment r136 = r135.findFragmentByTag(LinkResultDialogFragment.k);
    L335:
        if ((r136 instanceof DialogFragment) == true) goto L337;
        r136 = null;
    L337:
        DialogFragment r137 = (DialogFragment) r136;
        if (r137 != null) goto L358;
    L346:
        com.bytedance.android.live.liveinteract.plantform.commonwindow.utils.e.c.getClass();
        com.bytedance.android.live.liveinteract.plantform.commonwindow.utils.e.a.c("onDestroy", null, this);
        return;
    L358:
        r137.dismissAllowingStateLoss();     // Catch: Exception -> L341
    L345:
        Unit r138 = Unit.INSTANCE;
    L341:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r139 = DialogFragmentLancet.sLastShowStack;
        if (r139 == null) goto L345;
        com.bytedance.crash.d.d(r139, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
    L333:
        r136 = null;
        goto L335
    L314:
        if (vm2.d.h() == false) goto L319;
        this.f3 = null;
        k50.c r140 = this.g3;
        if (r140 == null) goto L318;
        r140.b = true;
    L318:
        this.g3 = null;
        goto L319
    L240:
        if (r91.isShowing() != true) goto L262;
        ?? r141 = this.v;
        if (r141 == 0) goto L262;
        Handler r142 = DialogLancet.resolveDialogHandler(r141);
        if (r142 != null) goto L246;
    L248:
        DialogLancet.beforeDialogDismiss(r141);
        r141.dismiss();     // Catch: Throwable -> L251 Exception -> L253
    L258:
        DialogLancet.afterDialogDismiss(r141);
    L259:
        Unit r143 = Unit.INSTANCE;
        goto L262
    L251:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r141);
        throw th;
    L253:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L251
        Throwable r144 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L251
        if (r144 == null) goto L258;
        com.bytedance.crash.d.d(r144, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L251
        goto L258
    L246:
        if (Looper.myLooper() == r142.getLooper()) goto L248;
        r142.post(DialogLancet.createDismissRunnable(r141));
        goto L259
    L227:
        r83 = null;
    L205:
        r76 = null;
        goto L206
    L183:
        r61.put("is_pre_link", "0");
        goto L184
    L173:
        if (r118.n() <= 0) goto L175;
        Object r145 = "1";
    L176:
        r61.put("is_set_seat_name", r145);
        r61.put("seat_num", String.valueOf(r118.n()));
        goto L177
    L175:
        r145 = "0";
        goto L176
    L161:
        if (r112.J() != true) goto L163;
        ii0.a.a(r61);
        goto L163
    L148:
        if (r60.b == true) goto L151;
        r60.h.T4(r60.a);
        r60.c.clear();
        r60.b = true;
        r60.f = 0;
        r60.d = false;
        r60.e = false;
    L151:
        Unit r146 = Unit.INSTANCE;
        goto L152
    L95:
        if (r43.A() != true) goto L119;
        int r147 = c1.a;
        zj0.e r148 = this.X2;
        if (r148 != null) goto L100;
        Intrinsics.throwUninitializedPropertyAccessException("layoutSwitcher");
    L100:
        if (c1.a(0, Integer.valueOf(r148.a())) == false) goto L104;
        DataCenter r149 = ((Widget) this).dataCenter;
        Boolean r150 = Boolean.FALSE;
        if (Intrinsics.areEqual((Boolean) r149.get("data_audience_pre_linkmic_waiting", r150), Boolean.TRUE) == false) goto L104;
        ((Widget) this).dataCenter.put("data_audience_pre_linkmic_waiting", r150);
    L104:
        com.bytedance.android.live.liveinteract.plantform.utils.x.j0();
        HashMap r310 = new HashMap();
        InteractiveSongLoggerKt.b(r310);
        String r311 = qr();
        String r151 = this.x.a;
        Long r152 = Long.valueOf(hr());
        Long r153 = Long.valueOf((this.F2 - this.s) / ((long) 1000));
        Long r154 = Long.valueOf(jr());
        int r155 = Mq();
        LinkApplyType r156 = this.A;
        boolean r157 = Pq();
        com.bytedance.android.live.liveinteract.plantform.core.y r158 = Aq();
        if (r158 == null) goto L107;
        Integer r159 = Integer.valueOf(je0.d.j(r158));
    L108:
        String r160 = String.valueOf(r159.intValue());
        if (r160 != null) goto L111;
        String r161 = "0";
    L112:
        IRoom r162 = getMRoom();
        String r210 = pr();
        String r211 = fr();
        String r212 = nr();
        String r213 = u0.j(Integer.valueOf(kr().b));
        zj0.e r163 = this.X2;
        if (r163 != null) goto L115;
        Intrinsics.throwUninitializedPropertyAccessException("layoutSwitcher");
    L115:
        Integer r164 = Integer.valueOf(r163.a());
        zj0.e r165 = this.X2;
        if (r165 != null) goto L118;
        Intrinsics.throwUninitializedPropertyAccessException("layoutSwitcher");
    L118:
        TalkRoomLogUtils.Y(r151, r152, r153, r154, r155, r156, r157, r161, r162, r210, r211, r212, r213, u0.h(r164, r165.h), wr(), l5(), gr(), String.valueOf(this.V2.b), vr(), this.Y, this.P0, this.V0, this.x, r310, r311, this.j);
        this.z = null;
        fj0.e.n(false);
        fj0.b.a.b = false;
        goto L119
    L111:
        r161 = r160;
        goto L112
    L107:
        r159 = null;
        goto L108
    L79:
        r39 = 0;
        goto L80
    L43:
        if (r25.isShowing() != true) goto L53;
        GuestTalkBeInvitedDialog r166 = this.E;
        if (r166 == null) goto L53;
        r166.dismiss();     // Catch: Exception -> L48
    L52:
        Unit r167 = Unit.INSTANCE;
    L48:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r168 = DialogFragmentLancet.sLastShowStack;
        if (r168 == null) goto L52;
        com.bytedance.crash.d.d(r168, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L52
    L5:
        r3 = 0;
        goto L6
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.MultiLinkBaseGuestLinkWidget
    public final void onPause() {
        IMultiLinkServiceExternal r0 = jc1.k.n(IMultiLinkServiceExternal.class);
        boolean r1 = r0.getControlServiceExternal().c();
        if (r0.getPkServiceExternal().getPkState() != 1) goto L5;
        boolean r2 = true;
    L6:
        IInteractService r4 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r4 == null) goto L13;
        gd0.i r5 = r4.getInteractFloatWindowService();
        if (r5 == null) goto L13;
        if (((com.bytedance.android.live.liveinteract.service.g) r5).b() != true) goto L13;
        boolean r6 = true;
    L14:
        if (r1 == true) goto L30;
        if (r2 == true) goto L31;
        if (r6 == false) goto L19;
        return;
    L19:
        if (isEngineOn() == true) goto L21;
    L28:
        this.l = true;
        super.onPause();
        return;
    L21:
        if (vm2.e.a() == false) goto L24;
        or().f();
    L24:
        if (vm2.e.a() == true) goto L26;
    L27:
        xr("pause", false);
        goto L28
    L26:
        if (or().p == true) goto L28;
    L31:
        return;
    L30:
        return;
    L13:
        r6 = false;
        goto L14
    L5:
        r2 = false;
        goto L6
    }

    public final String pr() {
        IInteractService r0 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r0 != null) goto L5;
    L9:
        cg6.a r1 = Bq();
        if (r1 == null) goto L16;
        MultiLinkGuestManager r2 = r1.W4();
        if (r2 == null) goto L16;
        if (r2.h != true) goto L16;
        return "game";
    L16:
        cg6.a r3 = Bq();
        if (r3 == null) goto L23;
        MultiLinkGuestManager r4 = r3.W4();
        if (r4 == null) goto L23;
        if (r4.g != true) goto L23;
    L27:
        return "anchor";
    L23:
        com.bytedance.live.datacontext.m r5 = com.bytedance.android.live.liveinteract.api.utils.m.e(this).y();
        if (r5 != null) goto L26;
    L28:
        return "audience";
    L26:
        if (((Boolean) r5.getValue()).booleanValue() != true) goto L28;
    L5:
        if (r0.getAdventureService() == null) goto L9;
        if (com.bytedance.android.live.liveinteract.revenue.adventure.linkcore.g.f != true) goto L9;
        return "meetgame_call";
    }

    @Override // tf0.o.a
    public final SurfaceView q1() {
        return (SurfaceView) this.p.getValue();
    }

    public final String qr() {
        com.bytedance.android.live.liveinteract.plantform.model.f r0 = this.z;
        if (r0 == null) goto L8;
        Integer r1 = r0.getInviteSource();
        if (r1 == null) goto L7;
        int r2 = r1.intValue();
    L10:
        if (Intrinsics.areEqual("invite", this.x.a) == false) goto L13;
        if (r2 <= 0) goto L13;
        int r3 = p0.a;
        return p0.a.a(r2);
    L13:
        return null;
    L7:
        r2 = 0;
        goto L10
    L8:
        r2 = -1;
        goto L10
    }

    public final Long rr() {
        long r0 = Math.max(this.E2, this.y2);
        if (r0 != 0) goto L7;
        return 0L;
    L7:
        return Long.valueOf((System.currentTimeMillis() - r0) / ((long) 1000));
    }

    @Override // rj0.l
    public final void se() {
        jy0.b.d("MultiLinkVideoTalkRoomGuestWidget", "updateCurrentLayoutConfig");
        tf0.o r0 = this.T;
        if (r0 == null) goto L6;
        r0.A();
    L6:
        if (MultiLinkLoadWidgetUtils.g() == false) goto L8;
        String r1 = je0.d.k(((Widget) this).dataCenter);
        RxBusAbility.INSTANCE.getRxBus(r1).post(new r0());
        return;
    L8:
        xs2.b.a().post(new r0());
    }

    @Override // rj0.o
    public final void sg() {
        if (isViewValid() == true) goto L5;
        return;
    L5:
        if (((Widget) this).context == null) goto L101;
        boolean r2 = false;
        if (jc1.k.n(IMiddlewareUserService.class).user().isLogin() == true) goto L11;
        com.bytedance.android.livesdk.user.e r1 = jc1.k.n(IMiddlewareUserService.class).user();
        Context r3 = ((Widget) this).context;
        com.bytedance.android.livesdk.user.l.a r4 = new com.bytedance.android.livesdk.user.l.a();
        r4.a = s1.B(2131919339);
        r4.d = "interact";
        r4.c = 0;
        r1.login(r3, new com.bytedance.android.livesdk.user.l(r4)).compose(getAutoUnbindTransformer()).subscribe(new com.bytedance.android.livesdk.user.h());
        return;
    L11:
        ILinkPlayerInfoBridge r5 = null;
        if (vm2.d.p0() == true) goto L14;
    L24:
        Integer r6 = (Integer) ((ge1.a) hd0.c.f()).b;
        if (r6 != null) goto L28;
    L37:
        Integer r7 = (Integer) ((ge1.a) hd0.c.f()).b;
        if (r7 != null) goto L41;
    L61:
        Integer r8 = (Integer) ((ge1.a) hd0.c.f()).b;
        if (r8 != null) goto L65;
        return;
    L65:
        if (2 != r8.intValue()) goto L98;
        com.bytedance.android.live.liveinteract.plantform.core.y r9 = Aq();
        if (r9 == null) goto L69;
        r5 = (ILinkPlayerInfoBridge) r9.a5(je0.d.b0(), tc0.c.h().f);
    L69:
        if (r5 == null) goto L75;
        DataCenter r10 = ((Widget) this).dataCenter;
        if (r5.getSilenceStatus() == 0) goto L73;
        r2 = true;
    L73:
        r10.put("data_self_is_silenced", Boolean.valueOf(r2));
    L75:
        if (((IInteractService) jc1.k.n(IInteractService.class)).isEnableTalkRoomEmoji() == false) goto L77;
        com.bytedance.android.live.liveinteract.videotalk.emoji.t r11 = new com.bytedance.android.live.liveinteract.videotalk.emoji.t();
        r11.e(((Widget) this).context);
        r11.f(((Widget) this).dataCenter);
        r11.g(true);
        Intrinsics.checkNotNullParameter("bottom", "requestPage");
        r11.d = "bottom";
        r11.b().a();
        return;
    L77:
        com.bytedance.android.live.liveinteract.videotalk.dialog.n r12 = new com.bytedance.android.live.liveinteract.videotalk.dialog.n(((Widget) this).context, null, false, jc1.k.n(IMiddlewareUserService.class).user().n(), ((Widget) this).dataCenter);
        Intrinsics.checkNotNullParameter("bottom", "requestPage");
        r12.n = "bottom";
        if (DialogLancet.shouldBlockDialogShow(r12) == false) goto L87;
        DialogLancet.handleBlockedDialogShow(r12);
        return;
    L87:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L84
    L81:
        DialogLancet.beforeDialogShow(r12);
        r12.show();
        DialogLancet.afterDialogShow(r12);
        return;
    L98:
        return;
    L41:
        if (1 != r7.intValue()) goto L61;
        if (com.bytedance.android.live.liveinteract.utils.h1.a() == false) goto L46;
        com.bytedance.android.live.liveinteract.utils.h1.f(this.G, ((Widget) this).context, ((Widget) this).dataCenter);
        return;
    L46:
        if (com.bytedance.android.live.liveinteract.chatroom.chatroom.a.a(getMRoom()) == false) goto L49;
        B();
        return;
    L49:
        if (s0.a(getMRoom()) == false) goto L52;
        Sj();
        return;
    L52:
        if (com.bytedance.android.live.liveinteract.chatroom.chatroom.a.b() == false) goto L56;
        ChatMatchWidget r13 = this.t;
        if (r13 == null) goto L94;
        ChatMatchWidget.Aq(r13, null, false, null, 14);
        return;
    L94:
        return;
    L56:
        VideoTalkRoomApplyCancelDialog r14 = new VideoTalkRoomApplyCancelDialog(((Widget) this).context, ((Widget) this).dataCenter, -1);
        if (DialogLancet.shouldBlockDialogShow(r14) == false) goto L85;
        DialogLancet.handleBlockedDialogShow(r14);
        return;
    L85:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L83
    L60:
        DialogLancet.beforeDialogShow(r14);
        r14.show();
        DialogLancet.afterDialogShow(r14);
        return;
    L28:
        if (r6.intValue() != 0) goto L37;
        boolean r15 = tc0.c.h().E;
        if (((Boolean) bj1.a.getValue()).booleanValue() == false) goto L36;
        com.bytedance.android.livesdk.sharedpref.e r16 = b6.p;
        if (((Integer) r16.getValue()).intValue() <= 0) goto L36;
        if (us1.d.b(false, r15) == false) goto L36;
        ((Integer) r16.getValue()).intValue();
    L36:
        int r17 = bh0.a.a;
        apply(new sf0.a(0, 102, 0, 0, null, null, "video_interact_icon_click", 0, 0, 0, false, false, 0, null, null, 0, 524157));
        return;
    L14:
        if (this.a == null) goto L16;
        boolean r18 = true;
    L17:
        if (r18 == false) goto L24;
        if (com.bytedance.android.livesdk.chatroom.paidlive.e.e(getMRoom(), null) == false) goto L24;
        if (com.bytedance.android.livesdk.chatroom.paidlive.e.b(getMRoom()) == true) goto L24;
        f2.b(2131921181, 0);
        TalkRoomBusinessFullLinkMonitor r19 = TalkRoomBusinessFullLinkMonitor.a;
        boolean r20 = com.bytedance.android.livesdk.chatroom.paidlive.e.e(getMRoom(), null);
        boolean r21 = com.bytedance.android.livesdk.chatroom.paidlive.e.b(getMRoom());
        r19.getClass();
        TalkRoomBusinessFullLinkMonitor.e0(r20, r21);
        return;
    L16:
        r18 = false;
        goto L17
    }

    public final Long sr() {
        long r0 = Math.max(this.E2, this.v2);
        if (r0 != 0) goto L7;
        return 0L;
    L7:
        return Long.valueOf((System.currentTimeMillis() - r0) / ((long) 1000));
    }

    public final Long tr() {
        if (Math.max(this.E2, this.x2) != 0) goto L7;
        return 0L;
    L7:
        return Long.valueOf((System.currentTimeMillis() - Math.max(this.E2, this.x2)) / ((long) 1000));
    }

    @Override // rj0.l
    public final void tryAutoFastMatch() {
        String r0 = ChatMatchWidget.o;
        Intrinsics.checkNotNullParameter("apply_panel", "requestPage");
        ChatMatchWidget.o = "apply_panel";
        ChatMatchWidget r1 = this.t;
        if (r1 == null) goto L6;
        ChatMatchWidget.Aq(r1, null, true, "apply_panel", 8);
        return;
    }

    public final String wr() {
        DataCenter r0 = ((Widget) this).dataCenter;
        if (r0 == null) goto L5;
        com.bytedance.android.live.liveinteract.plantform.model.g0 r1 = (com.bytedance.android.live.liveinteract.plantform.model.g0) r0.get("data_link_mic_pos_tag_info", null);
    L6:
        if (r1 == null) goto L11;
        r1.getTagType();
        if (r1.getTagType() <= 0) goto L11;
        return String.valueOf(r1.getTagType());
    L11:
        return null;
    L5:
        r1 = null;
        goto L6
    }

    @Override // zj0.b
    public final Pair<Integer, Integer> x3() {
        View r0 = hs0.a.b.getCurrentLivePlayerParent();
        if (r0 == null) goto L7;
        return new Pair(Integer.valueOf(r0.getWidth()), Integer.valueOf(r0.getHeight()));
    L7:
        return new Pair(0, 0);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.MultiLinkBaseGuestLinkWidget
    public final void yi() {
        this.c = null;
        xf6.b r2 = Tq();
        if (r2 == null) goto L5;
        r2.f("MultiLinkVideoTalkRoomGuestWidget onEngineEndSuccess");
    L5:
        v0 r3 = this.c;
        if (r3 == null) goto L8;
        r3.release();
    L8:
        this.c = null;
        tf0.o r4 = this.T;
        if (r4 == null) goto L11;
        r4.O();
    L11:
        com.bytedance.android.live.liveinteract.plantform.utils.u r5 = this.b2;
        if (r5 == null) goto L14;
        r5.p();
    L14:
        cj0.e r6 = this.G1;
        r6.b = 0;
        r6.c = 0;
        VideoDigitAvatarWidget r7 = this.W2;
        if (r7 == null) goto L20;
        ALogger.i("KtvDigitAvatar", "监听到rtc【关闭】成功消息");
        DigitAvatarMsgController r8 = r7.f;
        if (r8 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("avatarMsgController");
    L19:
        r8.b = null;
    L20:
        QuickInteractWidget r9 = this.H1;
        if (r9 == null) goto L23;
        r9.xq();
    L23:
        this.V2.b();
        ne0.c r10 = this.G;
        if (r10 == null) goto L26;
        r10.d0(sh0.z.b, Boolean.FALSE);
    L26:
        pj0.b r11 = ThemedCompetitionContext.Companion.c();
        if (r11 == null) goto L30;
        r11.m4();
    L30:
        if (isViewValid() == true) goto L33;
        return;
    L33:
        if (((IInteractService) jc1.k.n(IInteractService.class)).dynamicFromAudience() == false) goto L35;
        ((Boolean) vm2.d.z1.getValue(null, vm2.d.a[127(0x7f, float:1.78E-43)])).booleanValue();
    L35:
        Jq();
        HashMap r26 = new HashMap();
        InteractiveSongLoggerKt.b(r26);
        String r12 = this.x.a;
        Long r13 = Long.valueOf(hr());
        Long r14 = Long.valueOf((this.F2 - this.s) / ((long) 1000));
        Long r15 = Long.valueOf(jr());
        int r16 = Mq();
        LinkApplyType r17 = this.A;
        boolean r18 = Pq();
        com.bytedance.android.live.liveinteract.plantform.core.y r19 = Aq();
        if (r19 == null) goto L38;
        Integer r20 = Integer.valueOf(je0.d.j(r19));
    L39:
        String r21 = String.valueOf(r20.intValue());
        if (r21 != null) goto L42;
        r21 = "0";
    L42:
        String r110 = r21;
        IRoom r111 = getMRoom();
        String r112 = pr();
        String r113 = fr();
        String r114 = nr();
        String r115 = u0.j(Integer.valueOf(kr().b));
        zj0.e r22 = this.X2;
        if (r22 != null) goto L45;
        Intrinsics.throwUninitializedPropertyAccessException("layoutSwitcher");
    L45:
        Integer r23 = Integer.valueOf(r22.a());
        zj0.e r1 = this.X2;
        if (r1 != null) goto L48;
        Intrinsics.throwUninitializedPropertyAccessException("layoutSwitcher");
    L48:
        TalkRoomLogUtils.Y(r12, r13, r14, r15, r16, r17, r18, r110, r111, r112, r113, r114, r115, u0.h(r23, r1.h), wr(), l5(), gr(), String.valueOf(this.V2.b), vr(), this.Y, this.P0, this.V0, this.x, r26, qr(), this.j);
        this.z = null;
        com.bytedance.android.live.liveinteract.linkcast.g.b.getClass();
        if (com.bytedance.android.live.liveinteract.linkcast.g.a.c() == false) goto L51;
        com.bytedance.android.live.liveinteract.linkcast.g.a.h(true);
        com.bytedance.android.live.liveinteract.linkcast.g.a.g();
    L51:
        DataCenter r24 = ((Widget) this).dataCenter;
        Boolean r25 = Boolean.FALSE;
        if (Intrinsics.areEqual((Boolean) r24.get("data_audience_pre_linkmic_waiting", r25), Boolean.TRUE) == false) goto L54;
        ((Widget) this).dataCenter.put("data_audience_pre_linkmic_waiting", r25);
    L54:
        com.bytedance.android.live.liveinteract.plantform.commonwindow.utils.e.c.getClass();
        com.bytedance.android.live.liveinteract.plantform.commonwindow.utils.e.a.c("self leave", null, this);
        return;
    L38:
        r20 = null;
        goto L39
    }

    public final void zr() {
        Pair r0 = com.bytedance.live.datacontext.d.a(MultiLinkVideoTalkRoomGuestWidget$initAdminInviteAndApplyViewModel$1.INSTANCE);
        AdminInviteAndApplyViewModel r1 = (AdminInviteAndApplyViewModel) r0.component1();
        Disposable r2 = (Disposable) r0.component2();
        com.bytedance.live.datacontext.b.a(r1, AdminInviteAndApplyViewModel.TAG);
        this.F.add(r2);
    }

    @Override // rj0.l
    public final MuteStateChecker Hg() {
        com.bytedance.android.live.liveinteract.plantform.core.y r0 = Aq();
        if (r0 != null) goto L6;
        return null;
    L6:
        if (((Widget) this).dataCenter != null) goto L8;
        return null;
    L8:
        MuteStateChecker r2 = this.X;
        if (r2 != null) goto L12;
        MuteStateChecker r3 = new MuteStateChecker(((Widget) this).dataCenter, r0, null);
        this.X = r3;
        return r3;
    L12:
        return r2;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.MultiLinkBaseGuestLinkWidget
    public final void Jq() {
        super.Jq();
        n1.b r0 = n1.f;
        uf2.d0 r1 = getLiveCore();
        r0.getClass();
        n1.b.c(r1);
        VideoEffectPerfHelper r2 = this.Z2;
        if (r2 == null) goto L6;
        r2.d();
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.videolink.MultiLinkVideoBaseGuestLinkWidget
    public final int Lq() {
        return mr();
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.MultiLinkBaseGuestLinkWidget, com.bytedance.android.live.liveinteract.plantform.core.u
    public final void Qc() {
        boolean r1 = true;
        if (vm2.e.d() == false) goto L19;
        DigitAvatarContext.a r0 = DigitAvatarContext.Companion;
        DigitAvatarContext r2 = r0.getContext();
        if (r2 == null) goto L7;
        VideoShowMode r3 = r2.getCurrentVideoShowMode();
    L9:
        if (r3 != VideoShowMode.DIGIT_AVATAR) goto L19;
        DigitAvatarContext r4 = r0.getContext();
        if (r4 == null) goto L13;
        r4.setIsDigitAvatarLoading(true);
    L13:
        jg6.a r5 = Eq();
        if (r5 == null) goto L18;
        lh6.b r6 = r5.a();
        if (r6 == null) goto L18;
        ng6.c.a.a(r6, true);
    L18:
        jy0.b.d("VideoDigitAvatar", "waiting digit avatar loading, source == beforeStartEngine");
    L33:
        if (this.l == false) goto L41;
        m00.g r7 = this.U;
        if (r7 == null) goto L39;
        uf2.d0 r8 = r7.A();
        if (r8 == null) goto L39;
        r8.d();
    L39:
        com.bytedance.android.live.liveinteract.plantform.utils.x.A(tc0.c.h(), "background_start");
        return;
    L41:
        return;
    L7:
        r3 = null;
    L19:
        jg6.a r9 = Eq();
        if (r9 == null) goto L33;
        lh6.b r10 = r9.a();
        if (r10 == null) goto L33;
        if (je0.d.G() == true) goto L30;
        m00.g r11 = this.U;
        if (r11 == null) goto L30;
        if (r11.isCameraOpen() == true) goto L30;
    L31:
        ng6.c.a.a(r10, r1);
    L30:
        r1 = false;
        goto L31
    }

    @Override // rj0.l
    public final void Sj() {
        ILinkPanelService r0 = com.bytedance.android.live.liveinteract.component.b.a();
        if (r0 == null) goto L6;
        Context r1 = ((Widget) this).context;
        IRoom r2 = getMRoom();
        com.bytedance.android.live.liveinteract.plantform.utils.i0 r3 = TalkRoomLogUtils.a;
        ILinkPanelService.a.a(r0, r1, r2, null, TalkRoomLogUtils.w(this.y, this.A));
        return;
    }

    @Override // rj0.l
    public final /* bridge */ /* synthetic */ zj0.d U1() {
        return kr();
    }

    @Override // yj0.a.InterfaceC0294a
    public final void Y2() {
        jg6.a r0 = Eq();
        if (r0 == null) goto L8;
        kg6.e r1 = r0.b();
        if (r1 == null) goto L9;
        r1.t(new kg6.b(false, true, "live end", 8));
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.MultiLinkBaseGuestLinkWidget
    public final void Y4() {
        super.Y4();
        tf0.o r0 = this.T;
        if (r0 == null) goto L6;
        r0.g(getLiveCore());
        return;
    }

    @Override // rj0.l
    public final ei6.a Z0() {
        hg6.g r0 = P2();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.V0();
    }

    @Override // rj0.l
    public final ILinkPlayerInfoBridge currentCPositionUser() {
        com.bytedance.android.livesdk.chatroom.viewmodel.j r0 = ur();
        Object r1 = null;
        if (r0 == null) goto L5;
        List r2 = r0.b;
    L7:
        if (com.bytedance.android.livesdk.chatroom.interact.model.d0.c(r2) == false) goto L23;
        com.bytedance.android.live.liveinteract.plantform.core.y r3 = Aq();
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

    public final String fr() {
        xf6.b r0 = Tq();
        if (r0 == null) goto L18;
        vf6.a r1 = r0.a9();
        if (r1 == null) goto L18;
        if (r1.d == false) goto L18;
        int r2 = r1.c;
        if (r2 != 201) goto L12;
        return "seat";
    L12:
        if (r2 != 202) goto L18;
        return "bottom";
    L18:
        return null;
    }

    @Override // rj0.l
    public final com.bytedance.android.live.liveinteract.plantform.base.i<ILinkPlayerInfoBridge> getLinkUserInfoCenter() {
        return Aq();
    }

    @Override // rj0.l
    public final we0.b getLinkmicReturnRoomParams() {
        tc0.c r0 = tc0.c.h();
        we0.b.a r1 = new we0.b.a();
        r1.a = r0.M;
        r1.b = fj0.b.a.d();
        com.bytedance.android.live.liveinteract.plantform.utils.w0 r2 = this.x;
        r2.getClass();
        com.bytedance.android.live.liveinteract.plantform.utils.w0 r3 = new com.bytedance.android.live.liveinteract.plantform.utils.w0();
        r3.a = r2.a;
        r3.b = r2.b;
        r3.c = r2.c;
        r3.d = r2.d;
        r1.c = r3;
        r1.d = this.A;
        r1.e = Integer.valueOf(r0.K);
        r1.f = Integer.valueOf(this.y);
        r1.h = Boolean.valueOf(Pq());
        r1.i = Boolean.valueOf(this.B);
        r1.j = Boolean.valueOf(this.C);
        DataCenter r4 = ((Widget) this).dataCenter;
        Boolean r5 = null;
        if (r4 == null) goto L5;
        com.bytedance.android.live.liveinteract.plantform.model.g0 r6 = (com.bytedance.android.live.liveinteract.plantform.model.g0) r4.get("data_link_mic_pos_tag_info", null);
    L6:
        r1.k = r6;
        DataCenter r7 = ((Widget) this).dataCenter;
        if (r7 == null) goto L9;
        r5 = (Boolean) r7.get("data_link_mic_is_quick_invite", Boolean.FALSE);
    L9:
        r1.l = r5;
        r1.m = Long.valueOf(this.y2);
        r1.n = Long.valueOf(this.v2);
        r1.o = Long.valueOf(this.x2);
        r1.p = Long.valueOf(this.E2);
        r1.q = Long.valueOf(this.s);
        r1.r = Long.valueOf(this.F2);
        r1.s = Long.valueOf(this.G2);
        r1.t = r0.f;
        r1.u = Integer.valueOf(r0.j);
        r1.v = Integer.valueOf(hd0.c.f().g);
        r1.w = Boolean.valueOf(r0.C);
        r1.x = Boolean.valueOf(fj0.e.d());
        r1.y = Integer.valueOf(com.bytedance.android.live.liveinteract.utils.h1.c());
        r1.A = r0.F;
        return r1.a();
    L5:
        r6 = null;
        goto L6
    }

    @Override // rj0.l
    public final int getSelfSilenceType() {
        if (isEngineOn() == true) goto L5;
        return -1;
    L5:
        return lr();
    }

    @Override // com.bytedance.android.live.liveinteract.digitavatar.videoavatar.VideoDigitAvatarWidget.b
    public final void gn() {
        if (vm2.e.d() == false) goto L35;
        DigitAvatarContext r0 = DigitAvatarContext.Companion.getContext();
        if (r0 == null) goto L7;
        r0.setIsDigitAvatarLoading(false);
    L7:
        Disposable r1 = this.Q;
        if (r1 == null) goto L10;
        this.F.remove(r1);
    L10:
        SurfaceView r3 = null;
        Disposable r2 = Observable.timer(((Number) vm2.d.r0.getValue(null, vm2.d.a[67])).longValue(), TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new n(this), o.a);
        this.Q = r2;
        if (r2 == null) goto L13;
        this.F.add(r2);
    L13:
        m00.g r4 = this.U;
        if (r4 == null) goto L18;
        SurfaceView r5 = r4.getSurfaceView();
        if (r5 == null) goto L18;
        UtilityKotlinExtentionsKt.w(r5);
    L18:
        HashMap<String, View> r6 = this.h1;
        String r7 = tc0.c.h().f;
        m00.g r8 = this.U;
        if (r8 == null) goto L21;
        r3 = r8.getSurfaceView();
    L21:
        r6.put(r7, r3);
        tf0.o r9 = this.T;
        if (r9 == null) goto L27;
        String r10 = tc0.c.h().f;
        m00.g r11 = this.U;
        if (r11 == null) goto L26;
        r11.getSurfaceView();
    L26:
        r9.b(r10);
    L27:
        com.bytedance.android.live.liveinteract.plantform.datamerge.d r12 = LinkUserDataMergeContext.a.b(LinkUserDataMergeContext.Companion, ((Widget) this).dataCenter);
        if (r12 == null) goto L30;
        r12.K0(tc0.c.h().f);
    L30:
        this.k1.put(tc0.c.h().f, Boolean.FALSE);
        tf0.o r13 = this.T;
        if (r13 == null) goto L33;
        r13.c(tc0.c.h().f, false);
    L33:
        jy0.b.d("VideoDigitAvatar", "digit avatar load success , source == onDigitAvatarReady");
        return;
    }

    public final long hr() {
        return (System.currentTimeMillis() - Math.max(this.F2, this.E2)) / ((long) 1000);
    }

    @Override // rj0.l
    public final boolean isEngineOn() {
        hg6.g r0 = P2();
        if (r0 != null) goto L12;
        String r1 = LinkmicOnlineFloatWindowManager.Y;
        hg6.g r2 = LinkmicOnlineFloatWindowManager.c.a().s;
        if (r2 != null) goto L8;
    L10:
        return false;
    L8:
        if (r2.isEngineOn() != true) goto L10;
        return true;
    L12:
        return r0.A();
    }

    public final int lr() {
        com.bytedance.android.live.liveinteract.plantform.core.y r0 = Aq();
        if (r0 == null) goto L5;
        ILinkPlayerInfoBridge r1 = r0.p(jc1.k.n(IMiddlewareUserService.class).user().n(), tc0.c.h().f);
    L6:
        if (r1 != null) goto L10;
        return -1;
    L10:
        return r1.getSilenceStatus();
    L5:
        r1 = null;
        goto L6
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.MultiLinkBaseGuestLinkWidget
    public final void onResume() {
        super.onResume();
        tf0.o r0 = this.T;
        if (r0 == null) goto L5;
        r0.onResume();
    L5:
        int r1 = 0;
        this.l = false;
        if (this.N == false) goto L8;
        Qr(jc1.k.n(IKtvService.class).isCurrentUserIsSinger());
        this.N = false;
    L8:
        hg6.g r2 = P2();
        if (r2 != null) goto L11;
    L23:
        tf0.o r3 = this.T;
        if (r3 == null) goto L27;
        r1 = r3.C0();
    L27:
        if (com.bytedance.android.live.liveinteract.spatial.a.e(r1) == false) goto L32;
        hg6.g r4 = P2();
        if (r4 == null) goto L33;
        r4.i(true);
        return;
    L33:
        return;
    L32:
        return;
    L11:
        if (r2.A() != true) goto L23;
        if (vm2.e.a() == false) goto L16;
        or().g();
    L16:
        if (vm2.e.a() == true) goto L18;
    L21:
        yr("resume");
    L22:
        ((Widget) this).dataCenter.put("cmd_interact_state_change", new a1(3));
        goto L23
    L18:
        if (or().p == true) goto L22;
        if (or().i == true) goto L22;
        goto L21
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.MultiLinkBaseGuestLinkWidget
    public final void onStart() {
        super.onStart();
        Wr();
    }

    public final void onStop() {
        super/*com.bytedance.android.live.core.tetris.widgets.LiveWidget*/.onStop();
        if (vm2.e.a() == false) goto L5;
        or().h();
    L5:
        Wr();
    }

    public final com.bytedance.android.livesdk.chatroom.viewmodel.j ur() {
        com.bytedance.live.datacontext.j r0 = com.bytedance.android.live.liveinteract.api.utils.m.e(this).getVideoTalkRoomSubScene();
        if (r0 == null) goto L7;
        com.bytedance.android.livesdk.chatroom.viewmodel.e r1 = (com.bytedance.android.livesdk.chatroom.viewmodel.e) r0.getValue();
        if (r1 == null) goto L7;
        return r1.t();
    L7:
        return null;
    }

    public final String vr() {
        com.bytedance.android.live.liveinteract.plantform.core.y r0 = Aq();
        if (r0 == null) goto L20;
        CopyOnWriteArrayList<ILinkPlayerInfoBridge> r1 = r0.c;
        if (r1 == null) goto L20;
        Iterator<ILinkPlayerInfoBridge> r2 = r1.iterator();
    L8:
        if (r2.hasNext() == false) goto L16;
        ILinkPlayerInfoBridge r3 = r2.next();
        IBaseUser r4 = r3.getUser();
        if (r4 == null) goto L12;
        String r5 = r4.getIdString();
    L14:
        if (Intrinsics.areEqual(r5, je0.d.b0()) == false) goto L8;
    L17:
        ILinkPlayerInfoBridge r6 = r3;
        if (r6 == null) goto L20;
        Integer r7 = Integer.valueOf(r6.getUserPosition());
    L21:
        if (r7 != null) goto L23;
        return null;
    L23:
        return String.valueOf(r7.intValue() + 1);
    L12:
        r5 = null;
        goto L14
    L16:
        r3 = null;
    L20:
        r7 = null;
        goto L21
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.videolink.MultiLinkVideoBaseGuestLinkWidget
    public final tf0.o Nq() {
        return this.T;
    }

    @Override // tf0.o.a
    public final HashMap<String, Boolean> Y7() {
        return this.k1;
    }

    @Override // rj0.l
    public final String currentCPositionChangeTrackData() {
        return this.O2;
    }

    @Override // rj0.l
    public final int currentCPositionOpenSource() {
        return this.N2;
    }

    @Override // rj0.l
    public final tf0.h getInteractAnimationService() {
        return this.k0;
    }

    @Override // rj0.l
    public final tf0.m getSwitchLayoutStatisticsUtils() {
        return this.M2;
    }

    @Override // rj0.l
    public final m00.g hh() {
        return this.U;
    }

    @Override // rj0.l
    public final boolean isCurrentLinkPaid() {
        return this.i;
    }

    @Override // rj0.l
    public final cj0.e paidLinkManager() {
        return this.G1;
    }

    @Override // rj0.l
    public final tf0.o windowManager() {
        return this.T;
    }

    @Override // rj0.l
    public final /* bridge */ /* synthetic */ tf0.k getLinkmicReturnRoomParams() {
        return getLinkmicReturnRoomParams();
    }

    public MultiLinkVideoTalkRoomGuestWidget(gd0.p r6) {
        Intrinsics.checkNotNullParameter(r6, "liveCycleCallback");
        super(tc0.c.h());
        this.h3 = r6;
        this.W = new HashMap();
        this.H0 = new com.bytedance.android.live.liveinteract.api.utils.j(this);
        this.b1 = new ArrayList();
        this.g1 = new ArrayList();
        this.h1 = new HashMap();
        this.k1 = new HashMap();
        this.y1 = LinkApplyType.STRONG_REACH;
        this.G1 = new cj0.e(false);
        this.G2 = -1;
        this.M2 = new com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.u();
        this.O2 = "";
        this.P2 = LazyKt.lazy(new MultiLinkVideoTalkRoomGuestWidget$mInteractLiveCorePermissionGuarantor$2(this));
        this.Q2 = ((Number) vm2.d.I7.getValue(null, vm2.d.a[447(0x1bf, float:6.26E-43)])).longValue();
        this.S2 = new q(this);
        this.T2 = new j(this);
        this.V2 = new com.bytedance.android.live.liveinteract.utils.k0();
        this.Z2 = new VideoEffectPerfHelper(false, this);
        Integer r7 = TalkRoomLogUtils.a.b;
        if (r7 == null) goto L5;
        this.y = r7.intValue();
    L5:
        String r8 = TalkRoomLogUtils.a.a;
        if (r8 == null) goto L8;
        Intrinsics.checkNotNullParameter(r8, "<set-?>");
        this.D = r8;
    L8:
        LinkApplyType r9 = TalkRoomLogUtils.a.c;
        if (r9 == null) goto L11;
        Intrinsics.checkNotNullParameter(r9, "<set-?>");
        this.A = r9;
    L11:
        com.bytedance.android.live.liveinteract.plantform.utils.i0 r10 = new com.bytedance.android.live.liveinteract.plantform.utils.i0(null, null, null);
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        TalkRoomLogUtils.a = r10;
        this.b3 = new i(this);
        this.c3 = -1;
    }

    public static final void Zq(MultiLinkVideoTalkRoomGuestWidget r0) {
        xf6.b r1 = r0.Tq();
        if (r1 == null) goto L6;
        r1.np();
        return;
    }

    @Override // tf0.o.a
    public final int Aa(SurfaceView r7) {
        com.bytedance.android.live.liveinteract.plantform.model.e0 r0 = tc0.c.h().s;
        Integer r1 = null;
        if (r0 == null) goto L5;
        String r2 = r0.getRivalsStreamId();
    L6:
        jy0.b.a(LinkRoomFightContext.TAG, "livecore version " + jc1.k.n(IMiddlewareBroadcastService.class).getLiveCoreVersion());
        StringBuilder r3 = new StringBuilder("setPublicStreamVideoCanvas isEngineOn: ");
        hg6.g r4 = P2();
        if (r4 == null) goto L9;
        Boolean r5 = Boolean.valueOf(r4.isEngineOn());
    L10:
        r3.append(r5);
        r3.append(" id ");
        r3.append(r2);
        r3.append(" view ");
        r3.append(r7);
        jy0.b.a(LinkRoomFightContext.TAG, r3.toString());
        if (r2 != null) goto L13;
    L19:
        hg6.g r6 = P2();
        if (r6 == null) goto L24;
        xi0.b r8 = r6.O();
        if (r8 == null) goto L24;
        r1 = Integer.valueOf(r8.b0(String.valueOf(r2), r7));
    L24:
        jy0.b.a(LinkRoomFightContext.TAG, "setPublicStreamVideoCanvas result " + r1);
        if (r1 != null) goto L27;
        return -1;
    L27:
        return r1.intValue();
    L13:
        if (r2.length() != 0) goto L15;
        boolean r9 = true;
    L16:
        if (r9 != true) goto L19;
        return -1;
    L15:
        r9 = false;
        goto L16
    L9:
        r5 = null;
        goto L10
    L5:
        r2 = null;
        goto L6
    }

    @Override // yj0.a.InterfaceC0294a
    public final void D(String r6) {
        Intrinsics.checkNotNullParameter(r6, "toUserId");
        if (Intrinsics.areEqual(r6, jc1.k.n(IMiddlewareUserService.class).user().n()) == false) goto L7;
        Sq(false, "silence success");
        if (this.U2 == true) goto L18;
        f2.c(s1.B(2131923166), 0);
        return;
    L18:
        return;
    L7:
        com.bytedance.android.live.liveinteract.plantform.core.y r0 = Aq();
        if (r0 == null) goto L20;
        IBaseUser r7 = r0.c5(r6);
        if (r7 != null) goto L12;
        return;
    L12:
        if (TextUtils.isEmpty(r7.getNickName()) == false) goto L14;
    L16:
        f2.c(s1.C(2131923165, new Object[]{r7.getNickName()}), 0);
        return;
    L14:
        if (r7.getNickName().length() <= 10) goto L16;
        f2.c(s1.C(2131923165, new Object[]{r7.getNickName().subSequence(0, 10).toString() + "..."}), 0);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v7, types: [zj0.e] */
    /* JADX WARN: Type inference failed for: r7v1, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r7v2, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r7v3, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void Fr(boolean r12) {
        if (this.J2 == false) goto L5;
        return;
    L5:
        Lazy r0 = MultiLinkLoadWidgetUtils.a;
        DataCenter r1 = ((Widget) this).dataCenter;
        StringBuilder r2 = new StringBuilder("initScene, scene = ");
        com.bytedance.android.livesdk.chatroom.viewmodel.j r3 = ur();
        View r4 = null;
        if (r3 == null) goto L8;
        Integer r5 = Integer.valueOf(r3.a);
    L9:
        r2.append(r5);
        r2.append(", uiLayout = ");
        com.bytedance.android.livesdk.chatroom.viewmodel.j r6 = ur();
        if (r6 == null) goto L12;
        Integer r7 = Integer.valueOf(r6.c);
    L13:
        r2.append(r7);
        r2.append(", linkDetail: ");
        r2.append(String.valueOf(getMRoom().getLinkerDetail()));
        MultiLinkLoadWidgetUtils.n(r1, "GuestWidget", r2.toString());
        com.bytedance.android.livesdk.chatroom.viewmodel.j r8 = ur();
        if (r8 != null) goto L16;
        return;
    L16:
        if (r8.a != 0) goto L18;
        return;
    L18:
        if (r8.c == 0) goto L83;
        boolean r9 = true;
        this.J2 = true;
        int r10 = MultiSceneEnterRoomStatisticsUtils.u;
        DataCenter r11 = ((Widget) this).dataCenter;
        IRoom r13 = getMRoom();
        if (r13 == null) goto L23;
        Long r14 = Long.valueOf(r13.getId());
    L24:
        MultiSceneEnterRoomStatisticsUtils r15 = MultiSceneEnterRoomStatisticsUtils.a.a(r11, Long.valueOf(r14.longValue()));
        if (r15 == null) goto L28;
        IMultiSceneCommonStatistics.DefaultImpls.recordSubElementShow$default(r15, "native_receive_ui_layout", 0, 2, null);
    L28:
        if (r12 == false) goto L72;
        Lazy r16 = MultiLinkWRDSPreloadManager.i;
        RoomLinkMicSyncData r17 = IMultiLinkWRDSPreloadService.DefaultImpls.getRoomLinkMicSyncData$default(MultiLinkWRDSPreloadManager.a.a(), "inner_feed", getMRoom(), false, 4, null);
        if (MultiLinkLoadWidgetUtils.g() == false) goto L68;
        if (r17 == null) goto L68;
        if (MultiLinkLoadWidgetUtils.g() == true) goto L35;
    L37:
        r9 = false;
    L38:
        if (r9 == false) goto L63;
        LinkerBaseInfo r18 = r17.linkerBaseInfo;
        if (r18 == null) goto L42;
        int r19 = r18.getScene();
    L43:
        LinkerBaseInfo r20 = r17.linkerBaseInfo;
        if (r20 == null) goto L46;
        int r21 = r20.getUiLayout();
    L47:
        LinkerBaseInfo r22 = r17.linkerBaseInfo;
        if (r22 == null) goto L55;
        List<Long> r23 = r22.getPlayModes();
        if (r23 == null) goto L55;
        List<Long> r24 = r23;
        ?? r25 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r24, 10));
        Iterator r26 = r24.iterator();
    L53:
        if (r26.hasNext() == false) goto L56;
        r25.add(Integer.valueOf((int) ((Number) r26.next()).longValue()));
    L56:
        ClientUIInfo r110 = r17.clientUIInfo;
        if (r110 != null) goto L59;
        r110 = r8.e;
    L59:
        ?? r27 = this.X2;
        if (r27 != 0) goto L62;
        Intrinsics.throwUninitializedPropertyAccessException("layoutSwitcher");
    L62:
        r27.f(new zj0.c.C0300c(r19, r21), r25, r110);
    L55:
        r25 = r8.b;
        goto L56
    L46:
        r21 = r8.c;
        goto L47
    L42:
        r19 = r8.a;
    L63:
        View r111 = ((Widget) this).contentView;
        if (r111 == null) goto L66;
        r4 = r111.findViewById(2131363980);
    L66:
        if (r4 == null) goto L80;
        r4.setVisibility(0);
        return;
    L80:
        return;
    L35:
        if (vm2.h.W().fixSmallWindow() == false) goto L37;
    L68:
        zj0.e r112 = this.X2;
        if (r112 != null) goto L71;
        Intrinsics.throwUninitializedPropertyAccessException("layoutSwitcher");
    L71:
        r112.f(new zj0.c.C0300c(r8.a, r8.c), r8.b, r8.e);
        return;
    L72:
        zj0.e r113 = this.X2;
        if (r113 != null) goto L75;
        Intrinsics.throwUninitializedPropertyAccessException("layoutSwitcher");
    L75:
        r113.f(new zj0.c.b(r8.a, r8.c), r8.b, r8.e);
        return;
    L23:
        r14 = null;
        goto L24
    L83:
        return;
    L12:
        r7 = null;
        goto L13
    L8:
        r5 = null;
        goto L9
    }

    @Override // yj0.a.InterfaceC0294a
    public final void G(String r6) {
        Intrinsics.checkNotNullParameter(r6, "toUserId");
        if (Intrinsics.areEqual(r6, jc1.k.n(IMiddlewareUserService.class).user().n()) == false) goto L8;
        Sq(true, "unSilence success");
        if (this.U2 == true) goto L7;
        f2.c(s1.B(2131923173), 0);
    L7:
        this.U2 = false;
        return;
    L8:
        com.bytedance.android.live.liveinteract.plantform.core.y r0 = Aq();
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
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.MultiLinkBaseGuestLinkWidget
    public final void G1(h1 r6) {
        Intrinsics.checkNotNullParameter(r6, MultiLinkOpenSource.MESSAGE);
        Intrinsics.checkNotNullParameter(r6, MultiLinkOpenSource.MESSAGE);
        Intrinsics.checkNotNullParameter(r6, MultiLinkOpenSource.MESSAGE);
        u5 r7 = r6.getAnchorStreamSwitchContent();
        if (r7 == null) goto L63;
        com.bytedance.android.livesdk.message.linker.b r0 = tc0.c.h().A;
        if (r0 == null) goto L64;
        r0.setUseBackup(r7.isUseBackUp());
        if (r7.isUseBackUp() == false) goto L35;
        jg6.a r8 = Eq();
        if (r8 == null) goto L13;
        lh6.b r9 = r8.a();
        if (r9 == null) goto L13;
        r9.f(r0.getLinkmicIdStr(), false, "swtich backup stream");
    L13:
        jg6.a r10 = Eq();
        if (r10 == null) goto L18;
        kg6.e r11 = r10.b();
        if (r11 == null) goto L18;
        r11.h(r0.getLinkmicIdStr(), false, "swtich backup stream");
    L18:
        jg6.a r12 = Eq();
        if (r12 == null) goto L23;
        lh6.b r13 = r12.a();
        if (r13 == null) goto L23;
        r13.f(this.r.u(), true, "swtich backup stream");
    L23:
        jg6.a r14 = Eq();
        if (r14 == null) goto L28;
        kg6.e r15 = r14.b();
        if (r15 == null) goto L28;
        r15.h(this.r.u(), true, "swtich backup stream");
    L28:
        String r16 = r0.getLinkmicIdStr();
        if (r16 != null) goto L31;
        return;
    L31:
        if (this.W.get(r16) == null) goto L66;
        tf0.o r1 = this.T;
        if (r1 == null) goto L67;
        SurfaceView r2 = this.W.get(r16);
        r1.b(r16);
        return;
    L67:
        return;
    L66:
        return;
    L35:
        jg6.a r17 = Eq();
        if (r17 == null) goto L40;
        lh6.b r18 = r17.a();
        if (r18 == null) goto L40;
        r18.f(r0.getLinkmicIdStr(), true, "swtich backup stream");
    L40:
        jg6.a r19 = Eq();
        if (r19 == null) goto L45;
        kg6.e r20 = r19.b();
        if (r20 == null) goto L45;
        r20.h(r0.getLinkmicIdStr(), true, "swtich backup stream");
    L45:
        jg6.a r21 = Eq();
        if (r21 == null) goto L50;
        lh6.b r22 = r21.a();
        if (r22 == null) goto L50;
        r22.f(this.r.u(), false, "swtich backup stream");
    L50:
        jg6.a r23 = Eq();
        if (r23 == null) goto L55;
        kg6.e r24 = r23.b();
        if (r24 == null) goto L55;
        r24.h(this.r.u(), false, "swtich backup stream");
    L55:
        String r25 = this.r.u();
        if (r25 != null) goto L58;
        return;
    L58:
        if (this.W.get(r25) == null) goto L70;
        tf0.o r3 = this.T;
        if (r3 == null) goto L71;
        SurfaceView r4 = this.W.get(r25);
        r3.b(r25);
        return;
    L71:
        return;
    L70:
        return;
    L64:
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.MultiLinkBaseGuestLinkWidget
    public final void G2(d9 r4) {
        Intrinsics.checkNotNullParameter(r4, MultiLinkOpenSource.MESSAGE);
        jy0.b.d("ttlive_link_paid", "paidLinkConfigChanged " + r4);
        ab r5 = r4.getPaidOrTimeLimitChangeContent();
        if (r5 != null) goto L6;
        return;
    L6:
        if (r5.isNeedLeave() == true) goto L8;
        return;
    L8:
        if (hd0.c.f().j() == false) goto L24;
        cg6.a r0 = Bq();
        boolean r1 = true;
        if (r0 == null) goto L14;
        MultiLinkGuestManager r2 = r0.W4();
        if (r2 == null) goto L14;
        r2.e("paid_change", true);
    L14:
        String r3 = r5.getToast();
        if (r3 != null) goto L17;
    L20:
        if (r1 == true) goto L25;
        f2.c(r5.getToast(), 0);
        return;
    L25:
        return;
    L17:
        if (r3.length() == 0) goto L20;
        r1 = false;
        goto L20
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.MultiLinkBaseGuestLinkWidget
    public final void H4(z0 r2) {
        Intrinsics.checkNotNullParameter(r2, MultiLinkOpenSource.MESSAGE);
        IPlatformSoloKtvService r3 = jc1.k.f(IPlatformSoloKtvService.class);
        if (r3 == null) goto L6;
        r3.onGuestLinkPermit();
        return;
    }

    @Override // rj0.o
    public final void Li(ToolbarVideoInteractBehavior r2) {
        Intrinsics.checkNotNullParameter(r2, "behavior");
        this.Z = r2;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.MultiLinkBaseGuestLinkWidget
    public final void M4(cc6.b r13) {
        Intrinsics.checkNotNullParameter(r13, "error");
        Intrinsics.checkNotNullParameter(r13, "error");
        gg6.a.a(r13);
        int r0 = Mq();
        LinkApplyType r1 = this.A;
        String r2 = qr();
        com.bytedance.android.live.liveinteract.plantform.utils.w0 r3 = this.x;
        long r4 = r13.a;
        String r14 = r13.b;
        com.bytedance.android.live.liveinteract.plantform.utils.i0 r6 = TalkRoomLogUtils.a;
        Intrinsics.checkNotNullParameter(r1, "applyType");
        Intrinsics.checkNotNullParameter(r3, "logParams");
        HashMap r7 = new HashMap();
        TalkRoomLogUtils.J0(r7);
        TalkRoomLogUtils.u0(r7);
        r7.put("function_type2", TalkRoomLogUtils.h);
        r7.put("from_user_id", r3.b);
        r7.put("connect_type", r3.a);
        if (Intrinsics.areEqual(r3.a, "apply") == true) goto L5;
        r7.put("from_user_type", "");
    L10:
        if (Intrinsics.areEqual(r3.a, "apply") == false) goto L40;
        int r5 = bh0.a.a;
        if (r0 != 101) goto L15;
        r7.put("request_page", "seat");
    L45:
        if (tc0.c.h().K != LinkApplyType.MATCH.getValue()) goto L47;
        r7.put("request_page", tc0.c.h().L.getValue());
    L47:
        r7.put("error_code", String.valueOf(r4));
        r7.put("error_msg", String.valueOf(r14));
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_guest_connection_failed", r7, new Object[]{IRoom.class, am2.x.class});
        return;
    L15:
        if (r0 != 102) goto L18;
        r7.put("request_page", "bottom");
        goto L45
    L18:
        if (r0 != 103) goto L21;
        r7.put("request_page", "popup");
        goto L45
    L21:
        if (r0 != 110) goto L24;
        r7.put("request_page", "task");
        goto L45
    L24:
        if (r0 != 111) goto L27;
        r7.put("request_page", "top");
        goto L45
    L27:
        if (r0 != 113) goto L30;
        r7.put("request_page", "card");
        goto L45
    L30:
        if (r0 != 112) goto L33;
        r7.put("request_page", "apply_panel");
        goto L45
    L33:
        if (r0 != 114) goto L45;
        if (r1 != LinkApplyType.KTV_MULTI_CHORUS) goto L37;
        String r8 = "live_chorus";
    L38:
        r7.put("request_page", r8);
        goto L45
    L37:
        r8 = "live_song";
        goto L38
    L40:
        if (TextUtils.isEmpty(r2) == true) goto L45;
        if (r2 != null) goto L43;
        r2 = "";
    L43:
        r7.put("request_page", r2);
        goto L45
    L5:
        if (Intrinsics.areEqual(r3.b, r3.c) == false) goto L7;
        r7.put("from_user_type", "anchor");
        goto L10
    L7:
        r7.put("from_user_type", "admin");
        goto L10
    }

    @Override // rj0.j
    public final void O(sf0.a r6) {
        Intrinsics.checkNotNullParameter(r6, "applyParams");
        Intrinsics.checkNotNullParameter(r6, "applyParams");
        ILinkPanelService r0 = com.bytedance.android.live.liveinteract.component.b.a();
        if (r0 == null) goto L5;
        r0.close();
    L5:
        int r1 = com.bytedance.android.live.liveinteract.utils.h1.a;
        ne0.c r2 = this.G;
        Context r3 = ((Widget) this).context;
        DataCenter r4 = ((Widget) this).dataCenter;
        String r5 = String.valueOf(this.y);
        LinkApplyType r7 = com.bytedance.android.live.liveinteract.api.chatroom.model.a.a(r6.c);
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "dataCenter");
        Intrinsics.checkNotNullParameter(r7, "applyType");
        if (r2 == null) goto L9;
        r2.d0(mi0.c.b, new mi0.d(0, r5, r7));
        return;
    }

    @Override // rj0.j
    public final void P(h1 r6) {
        Intrinsics.checkNotNullParameter(r6, MultiLinkOpenSource.MESSAGE);
        a0 r0 = new a0(this);
        FragmentActivity r1 = ((Widget) this).context;
        if (r1 == null) goto L17;
        FragmentManager r2 = r1.getSupportFragmentManager();
        LinkResultDialogFragment.l.getClass();
        String r3 = LinkResultDialogFragment.k;
        if (r2.findFragmentByTag(r3) != null) goto L15;
        LinkResultDialogFragmentV2.a r4 = LinkResultDialogFragmentV2.u;
        ILinkerKickOutContent r7 = r6.getMKickOut();
        Intrinsics.checkNotNull(r7);
        AudienceLeaveSourceEnum r5 = AudienceLeaveSourceEnum.AudienceLeave_Kick_Out;
        r4.getClass();
        LinkResultDialogFragmentV2 r8 = LinkResultDialogFragmentV2.a.b(r7, r5, r0);
        this.M = r8;
        FragmentActivity r9 = ((Widget) this).context;
        if (r9 == null) goto L14;
        FragmentManager r10 = r9.getSupportFragmentManager();
        LandscapeRestrictionOperation r11 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW_NOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r8, r3, r11);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r10, r8, r11) == true) goto L22;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L18
    L12:
        r8.showNow(r10, r3);
        return;
    L22:
        return;
    L14:
        throw new NullPointerException("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
    L15:
        return;
    L17:
        throw new NullPointerException("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.MultiLinkBaseGuestLinkWidget
    public final void P8(final com.bytedance.android.live.liveinteract.multianchor.model.b r4) {
        Intrinsics.checkNotNullParameter(r4, MultiLinkOpenSource.MESSAGE);
        this.s = System.currentTimeMillis();
        InteractBeautyPreviewDialog r0 = this.w;
        if (r0 != null) goto L5;
    L7:
        com.bytedance.android.live.liveinteract.plantform.model.e r1 = r4.getGameInviteInfo();
        if (r1 == null) goto L13;
        if (r1.isGameInvite() != true) goto L13;
        com.bytedance.android.live.liveinteract.plantform.utils.w0 r2 = this.x;
        r2.getClass();
        Intrinsics.checkNotNullParameter("game_invite", "<set-?>");
        r2.a = "game_invite";
    L16:
        com.bytedance.android.live.liveinteract.plantform.utils.w0 r3 = this.x;
        String r5 = r4.getFromUserIdStr();
        r3.getClass();
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        r3.b = r5;
        fj0.b.a.b = false;
        if (((Boolean) vm2.d.B1.getValue(null, vm2.d.a[129(0x81, float:1.81E-43)])).booleanValue() == false) goto L19;
        int r6 = VideoTalkBeInvitedDialogV2.t;
        IRoom r7 = getMRoom();
        Intrinsics.checkNotNullParameter(r7, PbRequest.SwitchType.ROOM);
        Intrinsics.checkNotNullParameter(r4, "msg");
        GuestTalkBeInvitedDialog r8 = new VideoTalkBeInvitedDialogV2();
        r8.i = r7;
        r8.j = r4;
    L20:
        r8.p = new MultiLinkVideoTalkRoomGuestWidget$onReceiveInvitation$$inlined$apply$lambda$1(this, r4);
        Unit r9 = Unit.INSTANCE;
        this.E = r8;
        int r10 = com.bytedance.android.live.broadcastgame.api.g.a;
        FragmentActivity r11 = com.bytedance.android.live.broadcastgame.api.g.a(getContext());
        if (r11 == null) goto L35;
        FragmentManager r12 = r11.getSupportFragmentManager();
        if (r12 == null) goto L36;
        GuestTalkBeInvitedDialog r13 = this.E;
        if (r13 == null) goto L37;
        LandscapeRestrictionOperation r14 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r13, "GuestTalkBeInvitedDialog", r14);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r12, r13, r14) == true) goto L38;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L32
    L30:
        r13.show(r12, "GuestTalkBeInvitedDialog");
        return;
    L38:
        return;
    L37:
        return;
    L36:
        return;
    L35:
        return;
    L19:
        int r15 = GuestTalkBeInvitedDialog.q;
        IRoom r16 = getMRoom();
        Intrinsics.checkNotNullParameter(r16, PbRequest.SwitchType.ROOM);
        Intrinsics.checkNotNullParameter(r4, "linkMicMessage");
        r8 = new GuestTalkBeInvitedDialog();
        r8.i = r16;
        r8.j = r4;
    L13:
        if (r4.getMessageBoardInfo() == null) goto L15;
        com.bytedance.android.live.liveinteract.plantform.utils.w0 r17 = this.x;
        r17.getClass();
        Intrinsics.checkNotNullParameter("gift_message_invite", "<set-?>");
        r17.a = "gift_message_invite";
        com.bytedance.android.live.liveinteract.plantform.utils.w0 r18 = this.x;
        r18.d = r4.getMessageBoardInfo();
        goto L16
    L15:
        com.bytedance.android.live.liveinteract.plantform.utils.w0 r19 = this.x;
        r19.getClass();
        Intrinsics.checkNotNullParameter("invite", "<set-?>");
        r19.a = "invite";
        goto L16
    L5:
        if (r0.isShowing() != true) goto L7;
    }

    @Override // tf0.o.a
    public final int Po(String r4) {
        jy0.b.a(LinkRoomFightContext.TAG, "livecore version " + jc1.k.n(IMiddlewareBroadcastService.class).getLiveCoreVersion());
        jy0.b.a(LinkRoomFightContext.TAG, "startPlayPublicStream id " + r4);
        int r0 = -1;
        if (r4 != null) goto L5;
        return -1;
    L5:
        hg6.g r2 = P2();
        if (r2 == null) goto L10;
        xi0.b r3 = r2.O();
        if (r3 == null) goto L10;
        r0 = r3.l(r4);
    L10:
        jy0.b.a(LinkRoomFightContext.TAG, "startPlayPublicStream result " + r0);
        return r0;
    }

    public final void Pr(m00.g r2) {
        Intrinsics.checkNotNullParameter(r2, "linkView");
        r2.g();
        this.U = r2;
    }

    public final void Qr(boolean r19) {
        StringBuilder r2 = new StringBuilder("onIsSingerChanged ");
        r2.append(r19);
        r2.append(" mute=");
        yj0.a r3 = this.S;
        if (r3 == null) goto L5;
        Integer r4 = Integer.valueOf(r3.e0());
    L6:
        r2.append(r4);
        r2.append(" isOnBackground=");
        r2.append(this.l);
        r2.append(" rtcOn=");
        r2.append(isEngineOn());
        jy0.b.d("video_talk", r2.toString());
        if (isEngineOn() == true) goto L9;
        return;
    L9:
        boolean r5 = true;
        if (r19 == false) goto L31;
        yj0.a r6 = this.S;
        if (r6 == null) goto L16;
        if (r6.e0() != 0) goto L16;
    L22:
        if (this.V1 == true) goto L25;
        this.L = false;
    L25:
        if (this.l == false) goto L31;
        yj0.a r7 = this.S;
        if (r7 != null) goto L29;
    L30:
        this.N = true;
        goto L31
    L29:
        if (r7.e0() == 0) goto L31;
    L16:
        if (this.l == true) goto L22;
        yj0.a r8 = this.S;
        if (r8 == null) goto L20;
        r8.g0(je0.d.b0(), new p(), true);
    L20:
        this.L = true;
    L31:
        jy0.b.d("video_talk", "curScene:" + ((IInteractService) jc1.k.n(IInteractService.class)).getCurrentScene());
        if (r19 == false) goto L91;
        m00.g r9 = this.U;
        if (r9 == null) goto L44;
        if (r9.j() != 0) goto L44;
        m00.g r10 = this.U;
        if (r10 == null) goto L40;
        r10.p();
    L40:
        jy0.b.d("video_talk", "video ktv startVideoCapture");
        m00.g r11 = this.U;
        if (r11 == null) goto L44;
        r11.e();
    L44:
        if (Intrinsics.areEqual(sn.a.getValue(), Boolean.TRUE) == true) goto L46;
    L76:
        jg6.a r12 = Eq();
        if (r12 == null) goto L81;
        lh6.b r13 = r12.a();
        if (r13 == null) goto L81;
        ng6.c.a.a(r13, false);
    L81:
        jg6.a r14 = Eq();
        if (r14 == null) goto L86;
        kg6.e r15 = r14.b();
        if (r15 == null) goto L86;
        r15.u(false, "");
    L86:
        Pair<Boolean, String> r16 = this.K;
        if (r16 == null) goto L139;
        Boolean r17 = (Boolean) r16.getFirst();
        if (r17 == null) goto L139;
        final boolean r18 = r17.booleanValue();
        new MultiLinkVideoTalkRoomGuestWidget$onKtvSingerStateChanged$$inlined$let$lambda$1(r18, this);
    L139:
        this.V1 = r19;
        tf0.o r1 = this.T;
        if (r1 == null) goto L142;
        int r20 = r1.C0();
    L144:
        if (com.bytedance.android.live.liveinteract.spatial.a.e(r20) == false) goto L148;
        com.bytedance.android.live.liveinteract.spatial.b.a("MultiLinkVideoTalkRoomGuestWidget", "onKtvSingerStateChanged updateSpatialAudioPosition------");
        tf0.o r21 = this.T;
        if (r21 == null) goto L148;
        r21.u(Boolean.valueOf(isEngineOn()));
    L148:
        StringBuilder r22 = new StringBuilder("video ktv VideoCapture： ");
        m00.g r23 = this.U;
        if (r23 == null) goto L151;
        Integer r24 = Integer.valueOf(r23.j());
    L152:
        r22.append(r24);
        jy0.b.d("video_talk", r22.toString());
        return;
    L151:
        r24 = null;
        goto L152
    L142:
        r20 = -1;
        goto L144
    L46:
        if (vm2.e.d() == false) goto L76;
        DigitAvatarContext.a r25 = DigitAvatarContext.Companion;
        DigitAvatarContext r26 = r25.getContext();
        if (r26 == null) goto L50;
        VideoShowMode r27 = r26.getCurrentVideoShowMode();
    L52:
        if (r27 != VideoShowMode.DIGIT_AVATAR) goto L76;
        jg6.a r28 = Eq();
        if (r28 == null) goto L68;
        lh6.b r29 = r28.a();
        if (r29 == null) goto L68;
        if (r29.e() != true) goto L68;
        DigitAvatarContext r30 = r25.getContext();
        if (r30 != null) goto L62;
    L63:
        DigitAvatarContext r31 = r25.getContext();
        if (r31 == null) goto L68;
        if (r31.getIsDigitAvatarLoaded() != true) goto L68;
    L69:
        jy0.b.d("VideoDigitAvatar", "digit avatar ktv scene shouldUnMute=" + r5);
        if (r5 == false) goto L81;
        jg6.a r32 = Eq();
        if (r32 == null) goto L81;
        lh6.b r33 = r32.a();
        if (r33 == null) goto L81;
        ng6.c.a.a(r33, false);
        goto L81
    L62:
        if (r30.getIsDigitAvatarLoading() == false) goto L69;
    L68:
        r5 = false;
        goto L69
    L50:
        r27 = null;
        goto L52
    L91:
        m00.g r34 = this.U;
        if (r34 != null) goto L94;
    L109:
        Pair<Boolean, String> r35 = this.K;
        if (r35 == null) goto L112;
        Boolean r36 = (Boolean) r35.getFirst();
    L113:
        Pair<Boolean, String> r37 = this.K;
        if (r37 == null) goto L116;
        String r38 = (String) r37.getSecond();
    L117:
        if (r36 == null) goto L139;
        if (r38 == null) goto L139;
        if (r36.booleanValue() == false) goto L126;
        jg6.a r39 = Eq();
        if (r39 == null) goto L132;
        kg6.e r40 = r39.b();
        if (r40 == null) goto L132;
        r40.z(new kg6.d(false, true, r38, 8));
    L132:
        if (this.L == false) goto L139;
        if (isEngineOn() == false) goto L138;
        yj0.a r41 = this.S;
        if (r41 == null) goto L138;
        String r110 = je0.d.b0();
        long r111 = System.currentTimeMillis();
        InteractLinkFullLinkMonitor.V(r110);
        r41.c.add(((LinkApi) com.bytedance.android.live.network.c.b().e(LinkApi.class)).silence(r41.i.getId(), d5.c(r110), r110, 0, true).subscribeOn(Schedulers.io()).flatMap(yj0.b.a).observeOn(AndroidSchedulers.mainThread()).subscribe(new yj0.c(r41, r110, r111), new yj0.d(r41, r110, r111)));
    L138:
        this.L = false;
        goto L139
    L126:
        jg6.a r42 = Eq();
        if (r42 == null) goto L132;
        kg6.e r43 = r42.b();
        if (r43 == null) goto L132;
        r43.t(new kg6.b(false, true, r38, 8));
        goto L132
    L116:
        r38 = null;
        goto L117
    L112:
        r36 = null;
        goto L113
    L94:
        if (r34.j() != 5) goto L109;
        m00.g r44 = this.U;
        if (r44 == null) goto L98;
        r44.p();
    L98:
        jg6.a r45 = Eq();
        if (r45 == null) goto L109;
        lh6.b r46 = r45.a();
        if (r46 == null) goto L109;
        m00.g r47 = this.U;
        if (r47 != null) goto L105;
    L107:
        boolean r48 = false;
    L108:
        ng6.c.a.a(r46, r48);
        goto L109
    L105:
        if (r47.isCameraOpen() == true) goto L107;
        r48 = true;
        goto L108
    L5:
        r4 = null;
        goto L6
    }

    @Override // rj0.o
    public final void U0(IRoom r4) {
        Intrinsics.checkNotNullParameter(r4, PbRequest.SwitchType.ROOM);
        Lazy r0 = MultiLinkLoadWidgetUtils.a;
        MultiLinkLoadWidgetUtils.n(((Widget) this).dataCenter, "MultiLinkVideoTalkRoomGuestWidget#" + hashCode(), "call updateFullMode");
        Intrinsics.checkNotNullParameter(r4, "<set-?>");
        this.a = r4;
        Sr();
    }

    public final void Ur(we0.b r5) {
        Intrinsics.checkNotNullParameter(r5, "params");
        tc0.c r1 = tc0.c.h();
        String r2 = r5.a;
        if (r2 == null) goto L5;
        r1.M = r2;
    L5:
        tf0.l r3 = r5.b;
        if (r3 == null) goto L8;
        fj0.b.a.c((fj0.a) r3);
    L8:
        tf0.n r4 = r5.c;
        if (r4 == null) goto L11;
        com.bytedance.android.live.liveinteract.plantform.utils.w0 r6 = this.x;
        com.bytedance.android.live.liveinteract.plantform.utils.w0 r7 = (com.bytedance.android.live.liveinteract.plantform.utils.w0) r4;
        r6.getClass();
        Intrinsics.checkNotNullParameter(r7, "params");
        r6.a = r7.a;
        r6.b = r7.b;
        r6.c = r7.c;
        r6.d = r7.d;
    L11:
        LinkApplyType r0 = r5.d;
        if (r0 == null) goto L14;
        Intrinsics.checkNotNullParameter(r0, "<set-?>");
        this.A = r0;
    L14:
        Integer r8 = r5.e;
        if (r8 == null) goto L17;
        r1.K = r8.intValue();
    L17:
        Integer r9 = r5.f;
        if (r9 == null) goto L20;
        this.y = r9.intValue();
    L20:
        boolean r10 = Pq();
        xf6.b r11 = Tq();
        if (r11 == null) goto L25;
        vf6.a r12 = r11.a9();
        if (r12 == null) goto L25;
        r12.a = r10;
    L25:
        this.B = this.B;
        this.C = this.C;
        com.bytedance.android.live.liveinteract.plantform.model.g0 r13 = r5.k;
        if (r13 == null) goto L30;
        DataCenter r14 = ((Widget) this).dataCenter;
        if (r14 == null) goto L30;
        r14.put("data_link_mic_pos_tag_info", r13);
    L30:
        Boolean r15 = r5.l;
        if (r15 == null) goto L35;
        boolean r16 = r15.booleanValue();
        DataCenter r17 = ((Widget) this).dataCenter;
        if (r17 == null) goto L35;
        r17.put("data_link_mic_is_quick_invite", Boolean.valueOf(r16));
    L35:
        Long r18 = r5.m;
        if (r18 == null) goto L38;
        this.y2 = r18.longValue();
    L38:
        Long r19 = r5.n;
        if (r19 == null) goto L41;
        this.v2 = r19.longValue();
    L41:
        Long r20 = r5.o;
        if (r20 == null) goto L44;
        this.x2 = r20.longValue();
    L44:
        Long r21 = r5.p;
        if (r21 == null) goto L47;
        this.E2 = r21.longValue();
    L47:
        Long r22 = r5.q;
        if (r22 == null) goto L50;
        this.s = r22.longValue();
    L50:
        Long r23 = r5.r;
        if (r23 == null) goto L53;
        this.F2 = r23.longValue();
    L53:
        Long r24 = r5.s;
        if (r24 == null) goto L56;
        this.G2 = r24.longValue();
    L56:
        String r25 = r5.t;
        if (r25 == null) goto L59;
        r1.f = r25;
    L59:
        Integer r26 = r5.u;
        if (r26 == null) goto L62;
        r1.j = r26.intValue();
    L62:
        Integer r27 = r5.v;
        if (r27 == null) goto L65;
        hd0.c.f().g = r27.intValue();
    L65:
        Boolean r28 = r5.w;
        if (r28 == null) goto L68;
        r1.C = r28.booleanValue();
    L68:
        Boolean r29 = r5.x;
        if (r29 == null) goto L71;
        fj0.e.n(r29.booleanValue());
    L71:
        Integer r30 = r5.y;
        if (r30 == null) goto L76;
        int r31 = r30.intValue();
        int r32 = com.bytedance.android.live.liveinteract.utils.h1.a;
        com.bytedance.android.live.liveinteract.revenue.fight.b r33 = ((IInteractService) jc1.k.n(IInteractService.class)).teamFightService();
        if (r33 == null) goto L76;
        r33.q5(r31);
    L76:
        String r34 = r5.A;
        if (r34 == null) goto L80;
        r1.F = r34;
        return;
    }

    @Override // rj0.l
    public final void Wg(z0 r18) {
        Intrinsics.checkNotNullParameter(r18, "msg");
        com.bytedance.android.live.liveinteract.multianchor.model.b r2 = (com.bytedance.android.live.liveinteract.multianchor.model.b) r18.castTo(com.bytedance.android.live.liveinteract.multianchor.model.b.class);
        boolean r3 = gh0.b.a;
        boolean r7 = false;
        gh0.b.a("SceneOrUiLayoutChange", "switchSceneByMessage: messageId = " + r2.getMessageId2() + ", scene = " + r2.getScene() + ", ui_layout = " + r2.getUiLayout(), false);
        gh0.b.a("RtcParamsUpdate", "switchSceneByMessage: \n messageId = " + r2.getMessageId2() + ", scene = " + r2.getScene() + ", ui_layout = " + r2.getUiLayout() + "\n multiLiveCoreInfo = " + r2.getMultiLiveCoreInfo() + "\n liveCoreExtInfo = " + r2.getLiveCoreExtInfo() + "\n multiRtcInfo = " + r2.getMultiRtcInfo() + "\n rtcExtInfo = " + r2.getRtcExtInfo(), false);
        com.bytedance.android.livesdk.chatroom.viewmodel.j r4 = ur();
        if (r4 == null) goto L7;
        List r5 = r4.b;
        if (r5 == null) goto L7;
        boolean r6 = r5.contains(1);
    L8:
        this.R = r6;
        tf0.i r8 = this.r;
        if ((r8 instanceof tc0.c) == true) goto L11;
        r8 = null;
    L11:
        tc0.c r9 = (tc0.c) r8;
        if (r9 == null) goto L15;
        r9.r = r2.getMultiLiveCoreInfo();
        r9.m = r2.getLiveCoreExtInfo();
        r9.n = r2.getMultiRtcInfo();
        r9.k = r2.getRtcExtInfo();
    L15:
        if (vm2.d.v0() == false) goto L17;
        com.bytedance.android.live.liveinteract.plantform.utils.i0 r10 = TalkRoomLogUtils.a;
        String r11 = TalkRoomLogUtils.h;
        Intrinsics.checkNotNullParameter(r11, "<set-?>");
        TalkRoomLogUtils.j = r11;
        com.bytedance.android.live.liveinteract.plantform.utils.i.g(r2);
    L17:
        int r12 = r2.getUiLayout();
        if (((int) r2.getScene()) == 8) goto L20;
    L22:
        this.p2 = r2.getClientUIInfo();
        com.bytedance.live.datacontext.j r13 = com.bytedance.android.live.liveinteract.api.utils.m.e(this).getVideoTalkRoomSubScene();
        if (r13 == null) goto L27;
        com.bytedance.android.livesdk.chatroom.viewmodel.e r14 = (com.bytedance.android.livesdk.chatroom.viewmodel.e) r13.getValue();
        if (r14 == null) goto L27;
        r14.c(r14.t());
        r14.e(new com.bytedance.android.livesdk.chatroom.viewmodel.j(r2.getValidScene(), r2.getPlayModes(), r12, false, r2.getClientUIInfo(), false, 40));
    L27:
        String r1 = r18.getTrackingData();
        if (r1 != null) goto L30;
        r1 = "";
    L30:
        this.O2 = r1;
        List<com.bytedance.android.livesdk.link.model.bridge.k> r15 = r2.getLinkedListUsers();
        if (r15 == null) goto L34;
        ALogger.i("ttlive_link_video", "switchSceneByMessage ListUser=" + je0.d.g0(r15));
        Aq().Y4(r15, r2.getClientUIInfo(), r2.getVersion(), "switchSceneMsg", r2.getLinkerContentMap());
    L34:
        if (isEngineOn() == false) goto L39;
        zj0.e r16 = this.X2;
        if (r16 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("layoutSwitcher");
    L38:
        r16.f(new zj0.c.a(r2.getValidScene(), r12, "switchSceneMessage", null), r2.getPlayModes(), r2.getClientUIInfo());
        u8("switchSceneMessage");
    L39:
        Integer r17 = je0.d.h();
        if (r17 != null) goto L43;
    L45:
        if (r7 == true) goto L50;
        Widget r19 = this.T1;
        if (r19 == null) goto L51;
        ((Widget) this).subWidgetManager.unload(r19);
        this.T1 = null;
        ALogger.i("MultiLinkVideoTalkRoomGuestWidget", "[video_chorus] unloadVideoChorusWidget complete");
        return;
    L51:
        return;
    L50:
        return;
    L43:
        if (r17.intValue() != 63) goto L45;
        r7 = true;
        goto L45
    L20:
        if (r2.getUiLayout() != 52) goto L22;
        r12 = 7;
    L7:
        r6 = false;
        goto L8
    }

    @Override // rj0.l
    public final void apply(sf0.a r6) {
        Intrinsics.checkNotNullParameter(r6, "applyParams");
        Intrinsics.checkNotNullParameter(r6, "applyParams");
        i97.a r0 = i97.a.a;
        this.s = System.currentTimeMillis();
        fj0.a r1 = fj0.b.a;
        boolean r2 = true;
        if (r6.j <= 0) goto L5;
        boolean r3 = true;
    L6:
        r1.b = r3;
        boolean r4 = r6.m;
        int r5 = r6.n;
        r1.g = r4;
        r1.h = r5;
        xc.a r7 = r6.p;
        if (r7 == null) goto L11;
        Integer r8 = r7.a();
        if (r8 == null) goto L11;
        int r9 = r8.intValue();
    L12:
        r1.i = r9;
        if (vm2.d.p0() == true) goto L15;
    L24:
        this.y = r6.b;
        xf6.b r10 = Tq();
        if (r10 == null) goto L29;
        r10.apply(r6);
        return;
    L29:
        return;
    L15:
        if (this.a != null) goto L18;
        r2 = false;
    L18:
        if (r2 == false) goto L24;
        if (com.bytedance.android.livesdk.chatroom.paidlive.e.e(getMRoom(), null) == false) goto L24;
        if (com.bytedance.android.livesdk.chatroom.paidlive.e.b(getMRoom()) == true) goto L24;
        f2.b(2131921181, 0);
        TalkRoomBusinessFullLinkMonitor r11 = TalkRoomBusinessFullLinkMonitor.a;
        boolean r12 = com.bytedance.android.livesdk.chatroom.paidlive.e.e(getMRoom(), null);
        boolean r13 = com.bytedance.android.livesdk.chatroom.paidlive.e.b(getMRoom());
        r11.getClass();
        TalkRoomBusinessFullLinkMonitor.e0(r12, r13);
        return;
    L11:
        r9 = 0;
        goto L12
    L5:
        r3 = false;
        goto L6
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.MultiLinkBaseGuestLinkWidget
    public final void c0(Throwable r1) {
        m0 r2 = this.k;
        if (r2 == null) goto L6;
        r2.c();
        return;
    }

    @Override // rj0.l, tf0.o.a
    public final uf2.z.a c3(String r2) {
        if (TextUtils.equals(r2, tc0.c.h().f) == false) goto L12;
        v0 r3 = this.c;
        if (r3 == null) goto L20;
        uf2.d0 r4 = r3.A();
        if (r4 == null) goto L21;
        uf2.z r5 = r4.C();
        if (r5 != null) goto L11;
        return null;
    L11:
        return r5.K0();
    L21:
        return null;
    L20:
        return null;
    L12:
        v0 r6 = this.c;
        if (r6 == null) goto L23;
        uf2.d0 r7 = r6.A();
        if (r7 == null) goto L24;
        uf2.z r8 = r7.C();
        if (r8 != null) goto L19;
        return null;
    L19:
        return r8.l();
    L24:
        return null;
    L23:
        return null;
    }

    @Override // rj0.l
    public final void commonWMUpdateLiveCoreAndRtcInfo(String r6) {
        Intrinsics.checkNotNullParameter(r6, "from");
        jy0.b.d("ttlive_link_video", "updateLiveCoreRtcInfo " + r6);
        tf0.o r1 = this.T;
        if (r1 == null) goto L5;
        int r2 = r1.h(this.r.getInteractId());
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
        TalkRoomBusinessFullLinkMonitor.j(false, r5);
        return;
    L5:
        r2 = -1;
        goto L6
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.base.k
    public final void g0(IBaseUser r2) {
        Intrinsics.checkNotNullParameter(r2, "user");
        Wq(r2);
    }

    @Override // rj0.o
    public final void h0(IRoom r5) {
        Intrinsics.checkNotNullParameter(r5, PbRequest.SwitchType.ROOM);
        Lazy r0 = MultiLinkLoadWidgetUtils.a;
        MultiLinkLoadWidgetUtils.o("MultiLinkVideoTalkRoomGuestWidget#" + hashCode(), "call initFastMode");
        if (w0.b() == false) goto L10;
        jy0.b.a("livesdk_audience_loading_statistics", "start native dynamic widget: ");
        MultiRevenueDataContext.Companion.getClass();
        com.bytedance.android.live.liveinteract.chatroom.chatroom.playmode.a r1 = MultiRevenueDataContext.a.d();
        if (r1 == null) goto L7;
        r1.d(((Widget) this).dataCenter);
    L7:
        enableSubWidgetManager();
        com.bytedance.android.live.liveinteract.chatroom.chatroom.playmode.a r2 = MultiRevenueDataContext.a.d();
        if (r2 == null) goto L10;
        r2.p(this, SceneType.SCENE_VIDEO_TALKROOM, this.G, true);
    L10:
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        this.a = r5;
        Gr();
        Fr(true);
    }

    @Override // zj0.e.b
    public final void h4(tf0.o r2) {
        Intrinsics.checkNotNullParameter(r2, "windowManager");
        this.T = r2;
        RTSVideoWidget r0 = this.Q1;
        if (r0 == null) goto L6;
        r0.c = r2;
        return;
    }

    @Override // rj0.j
    public final void i(IApplyResult r5) {
        ChatMatchWidget r0 = this.t;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r5 == null) goto L7;
        a5 r6 = r5.getDisplayText();
    L8:
        ChatMatchWidget.Aq(r0, r6, false, null, 14);
        return;
    L7:
        r6 = null;
        goto L8
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.base.k
    public final void invite(com.bytedance.android.live.liveinteract.videolink.a r3) {
        Intrinsics.checkNotNullParameter(r3, "params");
        Intrinsics.checkNotNullParameter(r3, "params");
        xf6.b r0 = Tq();
        if (r0 == null) goto L6;
        r0.a(r3, this.J);
        return;
    }

    @Override // rj0.l
    public final void j3(long r3) {
        tf0.o r0 = this.T;
        if ((r0 instanceof CommonMultiLinkWindowManager) == false) goto L8;
        if (r0 == null) goto L7;
        ((CommonMultiLinkWindowManager) r0).X0(r3);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.CommonMultiLinkWindowManager");
    }

    @Override // rj0.j
    public final void j4(com.bytedance.android.live.liveinteract.videolink.a r3) {
        Intrinsics.checkNotNullParameter(r3, "params");
        int r0 = com.bytedance.android.live.liveinteract.utils.h1.a;
        com.bytedance.android.live.liveinteract.utils.h1.e(this.G, ((Widget) this).context, r3);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.videolink.MultiLinkVideoBaseGuestLinkWidget, com.bytedance.android.live.liveinteract.plantform.widgt.MultiLinkBaseGuestLinkWidget
    public final void l1(g1 r1) {
        super.l1(r1);
        m0 r2 = this.k;
        if (r2 == null) goto L6;
        r2.c();
        return;
    }

    @Override // tf0.o.a
    public final void mk(String r2) {
        v4(r2, false);
    }

    @Override // rj0.l
    public final void n4(SurfaceView r2) {
        Intrinsics.checkNotNullParameter(r2, "view");
        tf0.o r3 = this.T;
        if (r3 == null) goto L6;
        r3.b(tc0.c.h().e);
        return;
    }

    @Override // md0.a.InterfaceC0236a
    public final void onBusinessAppSeiUpdate(JSONObject r5) {
        Intrinsics.checkNotNullParameter(r5, "seiJsonObject");
        int r6 = r5.optInt("hide_micseat");
        if (r6 <= 0) goto L5;
    L6:
        JSONObject r0 = new JSONObject();
        r0.put("eventName", "live_effect_hide_micseat");     // Catch: Throwable -> L9
        r0.put("value", r6);     // Catch: Throwable -> L9
    L11:
        jc1.k.n(IBaseBrowserService.class).sendEventToAllJsBridges("H5_webcastNotification", r0);
        this.c3 = r6;
        return;
    L9:
        th = move-exception;
        ALogger.e("MultiLinkVideoTalkRoomGuestWidget", "handleSeiUpdate", th);
        goto L11
    L5:
        if (this.c3 != r6) goto L6;
    }

    public final void onChanged(Object r5) {
        KVData r6 = (KVData) r5;
        if (isViewValid() == false) goto L75;
        if (r6 != null) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(r6.getKey()) == false) goto L8;
        return;
    L8:
        if (r6.getData() == null) goto L91;
        String r0 = r6.getKey();
        if (Intrinsics.areEqual(r0, "cmd_open_interact_manage_dialog_by_anchor") == false) goto L14;
        xs2.b.a().post(new UserProfileEvent(getMRoom().getOwner()));
        return;
    L14:
        if (Intrinsics.areEqual(r0, "cmd_video_talk_invite") == false) goto L27;
        final IBaseUser r7 = (IBaseUser) r6.getData();
        if (r7 != null) goto L18;
        return;
    L18:
        if (jc1.k.n(IMiddlewareUserService.class).user().c() == false) goto L21;
        com.bytedance.android.live.liveinteract.utils.s0.a(((Widget) this).context, new MultiLinkVideoTalkRoomGuestWidget$onChanged$$inlined$let$lambda$1(r7, this));
    L25:
        TalkRoomLogUtils.C("administrator", r7.getIdString(), "card", -1);
        return;
    L21:
        if (jc1.k.n(IMiddlewareUserService.class).user().isAdmin() == false) goto L23;
        f2.b(2131914522, 0);
    L24:
        com.bytedance.android.live.liveinteract.plantform.utils.x.C0(TalkRoomOperate.INVITE);
        goto L25
    L23:
        f2.b(2131917298, 0);
        goto L24
    L27:
        if (Intrinsics.areEqual(r0, "cmd_show_guest_apply_dialog") == false) goto L31;
        Object r8 = r6.getData();
        Intrinsics.checkNotNull(r8);
        if (((Boolean) r8).booleanValue() == false) goto L81;
        Sj();
        return;
    L81:
        return;
    L31:
        m00.g r1 = null;
        if (Intrinsics.areEqual(r0, "cmd_operate_interact_media") == false) goto L49;
        MediaOperation r9 = (MediaOperation) r6.getData();
        if (r9 == null) goto L92;
        MediaOperation.Type r10 = r9.getType();
        int r11 = com.bytedance.android.live.liveinteract.videotalk.p.a[r10.ordinal()];
        if (r11 != 1) goto L39;
        DigitAvatarContext r12 = DigitAvatarContext.Companion.getContext();
        if (r12 != null) goto L45;
    L46:
        VideoShowMode r13 = VideoShowMode.VIDEO;
        throw null;
    L45:
        if (r12.getCurrentVideoShowMode() == null) goto L46;
        throw null;
    L39:
        if (r11 != 2) goto L93;
        throw null;
    L93:
        return;
    L92:
        return;
    L49:
        if (Intrinsics.areEqual(r6.getKey(), "cmd_video_talk_guest_battle_open_panel") == false) goto L54;
        String r14 = (String) r6.getData();
        ne0.c r2 = this.G;
        if (r2 == null) goto L83;
        r2.d0(sh0.g.b, r14);
        return;
    L83:
        return;
    L54:
        if (Intrinsics.areEqual(r6.getKey(), "cmd_self_join_channel_anonymous") == false) goto L85;
        com.bytedance.android.livesdk.link.model.bridge.k r15 = (com.bytedance.android.livesdk.link.model.bridge.k) r6.getData();
        if (r15 == null) goto L94;
        IBaseUser r16 = r15.getUser();
        if (r16 == null) goto L86;
        py.k r17 = r16.getAvatarThumbKt();
        if (r17 == null) goto L87;
        List r18 = r17.getUrls();
        if (r18 != null) goto L65;
        return;
    L65:
        if (((String) ListProtector.get(r18, 0)) == null) goto L89;
        m00.g r19 = this.c;
        if ((r19 instanceof m00.g) == false) goto L70;
        r1 = r19;
    L70:
        m00.g r3 = r1;
        if (r3 == null) goto L90;
        r3.m();
        return;
    L90:
        return;
    L89:
        return;
    L87:
        return;
    L86:
        return;
    L94:
        return;
    L85:
        return;
    L91:
        return;
    }

    public final void onConfigurationChanged(Configuration r2) {
        Intrinsics.checkNotNullParameter(r2, "newConfig");
        super/*com.bytedance.ies.sdk.widgets.Widget*/.onConfigurationChanged(r2);
        if (FoldScreenUtils.f() == false) goto L5;
    L6:
        tf0.o r3 = this.T;
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

    public final void onMessage(tlc.d r21) {
        String r3 = "";
        int r4 = 0;
        if ((r21 instanceof h1) == false) goto L130;
        h1 r11 = (h1) r21;
        int r0 = r11.getMType();
        boolean r5 = true;
        if (r0 == 36) goto L100;
        if (r0 == 37) goto L86;
        String r6 = null;
        if (r0 != 46) goto L11;
        hg6.g r1 = P2();
        if (r1 != null) goto L75;
        return;
    L75:
        if (r1.isEngineOn() == true) goto L77;
        return;
    L77:
        if (r11.getLinkerResumeAudienceContent() == null) goto L175;
        DataCenter r2 = ((Widget) this).dataCenter;
        if (r2 == null) goto L81;
        String r7 = (String) r2.get("data_room_unique_id", "");
    L82:
        tc0.c.i(r7).O = r11.getLinkerResumeAudienceContent();
        Tr();
        com.bytedance.android.live.liveinteract.plantform.datamerge.d r8 = md();
        DataCenter r9 = ((Widget) this).dataCenter;
        if (r9 == null) goto L85;
        r6 = (String) r9.get("data_room_unique_id", "");
    L85:
        r8.i1(tc0.c.i(r6).O);
        return;
    L81:
        r7 = null;
        goto L82
    L175:
        return;
    L11:
        if (r0 != 47) goto L13;
        ILinkerBattleConnectContent r10 = r11.getLinkerBattleConnectContent();
        if (r10 == null) goto L169;
        this.o = r10;
        jg6.a r12 = Eq();
        if (r12 == null) goto L170;
        lh6.b r13 = r12.a();
        if (r13 == null) goto L171;
        ng6.c.a.a(r13, false);
        return;
    L171:
        return;
    L170:
        return;
    L169:
        return;
    L13:
        if (r0 != 54) goto L15;
        ILinkerUILayoutChangeContent r14 = r11.getLinkerUILayoutChangeContent();
        if (r14 == null) goto L166;
        gh0.b.a("RtcParamsUpdate", "onUILayoutChangeMessage: \n messageId = " + r11.getMessageId3() + ", scene = " + r11.getScene() + ", content_ui_layout = " + r14.getUiLayout() + "\n multiLiveCoreInfo = " + r14.getMultiLiveCoreInfo() + "\n liveCoreExtInfo = " + r14.getLiveCoreExtInfo() + "\n multiRtcInfo = " + r14.getMultiRtcInfo() + "\n rtcExtInfo = " + r14.getRtcExtInfo(), false);
        tf0.i r15 = this.r;
        if ((r15 instanceof tc0.c) == true) goto L40;
        r15 = null;
    L40:
        tc0.c r16 = (tc0.c) r15;
        if (r16 == null) goto L43;
        r16.r = r14.getMultiLiveCoreInfo();
        r16.n = r14.getMultiRtcInfo();
        r16.m = r14.getLiveCoreExtInfo();
        r16.k = r14.getRtcExtInfo();
    L43:
        com.bytedance.android.live.liveinteract.plantform.core.y r17 = Aq();
        List<? extends com.bytedance.android.livesdk.link.model.bridge.k> r18 = r14.getLinkedListUsers();
        if (r18 != null) goto L46;
        r18 = new ArrayList();
    L46:
        r17.Y4(r18, r14.getClientUiInfo(), r14.getVersion(), "UILayoutChangeMessage", r14.getLinkerContentMap());
        com.bytedance.live.datacontext.j r19 = com.bytedance.android.live.liveinteract.api.utils.m.e(this).getVideoTalkRoomSubScene();
        if (r19 == null) goto L52;
        com.bytedance.android.livesdk.chatroom.viewmodel.e r20 = (com.bytedance.android.livesdk.chatroom.viewmodel.e) r19.getValue();
        if (r20 == null) goto L52;
        r20.c(r20.t());
        r20.t().getClass();
        r20.e(new com.bytedance.android.livesdk.chatroom.viewmodel.j(r20.t().a, r20.t().b, (int) r14.getUiLayout(), false, r14.getClientUiInfo(), false, 40));
    L52:
        if (isEngineOn() == false) goto L167;
        com.bytedance.live.datacontext.j r22 = com.bytedance.android.live.liveinteract.api.utils.m.e(this).getVideoTalkRoomSubScene();
        if (r22 == null) goto L60;
        com.bytedance.android.livesdk.chatroom.viewmodel.e r23 = (com.bytedance.android.livesdk.chatroom.viewmodel.e) r22.getValue();
        if (r23 == null) goto L60;
        com.bytedance.android.livesdk.chatroom.viewmodel.j r24 = r23.t();
        if (r24 == null) goto L60;
        List<Integer> r25 = r24.b;
    L61:
        zj0.e r26 = this.X2;
        if (r26 != null) goto L64;
        Intrinsics.throwUninitializedPropertyAccessException("layoutSwitcher");
    L64:
        r26.f(new zj0.c.a((int) r11.getScene(), (int) r14.getUiLayout(), "onUiLayoutChangeMessage", null), r25, r14.getClientUiInfo());
        commonWMUpdateLiveCoreAndRtcInfo("UILayoutChangeMessage");
        return;
    L60:
        r25 = null;
        goto L61
    L167:
        return;
    L166:
        return;
    L15:
        if (r0 != 56) goto L187;
        Integer r27 = (Integer) ((ge1.a) hd0.c.f()).b;
        if (r27 != null) goto L21;
        return;
    L21:
        if (r27.intValue() == 1) goto L23;
        return;
    L23:
        if (com.bytedance.android.live.liveinteract.plantform.base.f.a().k0(32) == false) goto L25;
        rj0.l.b.c(this, "leave_from_remove_apply_msg", 3);
    L25:
        LinkerRemoveWaitingUserContent r28 = r11.getLinkerRemoveWaitingUserContent();
        if (r28 == null) goto L162;
        String r29 = r28.getWaitingUserToast();
        if (r29 != null) goto L30;
        return;
    L30:
        if (r29.length() <= 0) goto L32;
        boolean r30 = true;
    L33:
        if (r30 != true) goto L164;
        f2.c(r28.getWaitingUserToast(), 0);
        return;
    L164:
        return;
    L32:
        r30 = false;
        goto L33
    L162:
        return;
    L187:
        return;
    L86:
        com.bytedance.android.livesdk.message.linker.g r31 = r11.getLinkerEnlargeGuestReplyContent();
        if (r31 == null) goto L177;
        TalkRoomBusinessFullLinkMonitor r32 = TalkRoomBusinessFullLinkMonitor.a;
        long r33 = r11.getMessageId3();
        r32.getClass();
        TalkRoomBusinessFullLinkMonitor.k0(r33, r31);
        if (r31.getReplyType() != CPositionReplyType.Reject.getValue()) goto L178;
        String r34 = r31.getReplyPrompts();
        if (r34 != null) goto L93;
    L96:
        if (r5 == true) goto L98;
        f2.c(r31.getReplyPrompts(), 0);
        return;
    L98:
        f2.b(2131922714, 0);
        return;
    L93:
        if (r34.length() == 0) goto L96;
        r5 = false;
        goto L96
    L178:
        return;
    L177:
        return;
    L100:
        if (isEngineOn() == true) goto L103;
        return;
    L103:
        if (r11.getLinkerEnlargeGuestInviteContent() == null) goto L190;
        TalkRoomBusinessFullLinkMonitor r35 = TalkRoomBusinessFullLinkMonitor.a;
        long r36 = r11.getMessageId3();
        com.bytedance.android.livesdk.message.linker.k r37 = r11.getLinkerEnlargeGuestInviteContent();
        r35.getClass();
        TalkRoomBusinessFullLinkMonitor.j0(r36, r37);
        CPositionBeInvitedDialog r38 = this.p0;
        if (r38 != null) goto L108;
    L117:
        FragmentActivity r39 = ContextUtil.contextToFragmentActivity(getContext());
        if (r39 == null) goto L181;
        FragmentManager r40 = r39.getSupportFragmentManager();
        if (r40 == null) goto L182;
        int r41 = CPositionBeInvitedDialog.o;
        CPositionBeInvitedDialog.ShowType r42 = CPositionBeInvitedDialog.ShowType.Invite;
        long r43 = getMRoom().getRoomId();
        CPositionBeInvitedDialog.RoomType r44 = CPositionBeInvitedDialog.RoomType.Video;
        com.bytedance.android.livesdk.message.linker.k r45 = r11.getLinkerEnlargeGuestInviteContent();
        if (r45 == null) goto L124;
        r3 = com.bytedance.android.livesdk.message.linker.l.a(r45);
    L124:
        CPositionBeInvitedDialog r46 = CPositionBeInvitedDialog.a.a(r42, r43, r44, false, r3, r11, ((Widget) this).dataCenter);
        this.p0 = r46;
        LandscapeRestrictionOperation r47 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r46, "VideoTalkCPositionBeInvitedDialog", r47);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r40, r46, r47) == true) goto L191;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L156
    L128:
        r46.show(r40, "VideoTalkCPositionBeInvitedDialog");
        return;
    L191:
        return;
    L182:
        return;
    L181:
        return;
    L108:
        if (r38.isShowing() != true) goto L117;
        CPositionBeInvitedDialog r48 = this.p0;
        if (r48 == null) goto L117;
        r48.dismissAllowingStateLoss();     // Catch: Exception -> L113
    L113:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r49 = DialogFragmentLancet.sLastShowStack;
        if (r49 == null) goto L117;
        com.bytedance.crash.d.d(r49, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L117
    L190:
        return;
    L130:
        if ((r21 instanceof ILinkmicEnlargeGuestMessage) == false) goto L184;
        ILinkmicEnlargeGuestMessage r50 = (ILinkmicEnlargeGuestMessage) r21;
        if (r50.getTurn_on_content() == null) goto L144;
        f6 r51 = r50.getTurn_on_content();
        if (r51 == null) goto L136;
        r4 = r51.getSource();
    L136:
        this.N2 = r4;
        f6 r52 = r50.getTurn_on_content();
        if (r52 == null) goto L142;
        String r53 = r52.getTrackingData();
        if (r53 == null) goto L142;
        r3 = r53;
    L142:
        this.O2 = r3;
        return;
    L144:
        if (r50.getTurn_off_content() == null) goto L186;
        e6 r54 = r50.getTurn_off_content();
        if (r54 == null) goto L148;
        r4 = r54.getSource();
    L148:
        this.N2 = r4;
        e6 r55 = r50.getTurn_off_content();
        if (r55 == null) goto L154;
        String r56 = r55.getTrackingData();
        if (r56 == null) goto L154;
        r3 = r56;
    L154:
        this.O2 = r3;
        return;
    L186:
        return;
    }

    @Override // md0.a.InterfaceC0236a
    public final void onSeiUpdated(SeiAppData r7) {
        if (r7 != null) goto L4;
        return;
    L4:
        boolean r1 = false;
        if (r7.getUiLayout() <= 0) goto L7;
        int r0 = r7.getUiLayout();
    L12:
        if (vm2.d.v0() == false) goto L21;
        LinkedHashMap r2 = new LinkedHashMap();
        r2.put("reason", "sei_update");
        Unit r3 = Unit.INSTANCE;
        int r4 = com.bytedance.android.live.liveinteract.plantform.utils.i.a;
        Intrinsics.checkNotNullParameter(r2, "logExtra");
        JSONObject r5 = r7.getEventParams();
        if (r5 == null) goto L21;
        String r6 = r5.optString("func_type");
        if (TextUtils.isEmpty(r6) == false) goto L18;
    L20:
        com.bytedance.android.live.liveinteract.plantform.utils.i.c(r7.getSubScene(), r0, r2);
        goto L21
    L18:
        if (TextUtils.equals(r6, "null") == true) goto L20;
        com.bytedance.android.live.liveinteract.plantform.utils.i0 r8 = TalkRoomLogUtils.a;
        Intrinsics.checkNotNullParameter(r6, "<set-?>");
        TalkRoomLogUtils.h = r6;
    L21:
        ClientUIInfo r9 = null;
        if (((Boolean) h30.a.getValue()).booleanValue() == false) goto L45;
        zj0.e r10 = this.X2;
        if (r10 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("layoutSwitcher");
    L27:
        if (r10.e(r7, r0) == false) goto L49;
        com.bytedance.live.datacontext.j r11 = com.bytedance.android.live.liveinteract.api.utils.m.e(this).getVideoTalkRoomSubScene();
        if (r11 == null) goto L37;
        com.bytedance.android.livesdk.chatroom.viewmodel.e r12 = (com.bytedance.android.livesdk.chatroom.viewmodel.e) r11.getValue();
        if (r12 == null) goto L37;
        com.bytedance.android.livesdk.chatroom.viewmodel.j r13 = r12.t();
        if (r13 == null) goto L37;
        ClientUIInfo r14 = r13.e;
        if (r14 == null) goto L37;
        List r15 = r14.getUiFeatureList();
    L38:
        ClientUIInfo r16 = this.p2;
        if (r16 == null) goto L41;
        List r17 = r16.getUiFeatureList();
    L43:
        if (Intrinsics.areEqual(r15, r17) == false) goto L49;
        r1 = true;
        goto L49
    L41:
        r17 = null;
    L37:
        r15 = null;
    L49:
        if (r1 == true) goto L71;
        com.bytedance.live.datacontext.j r18 = com.bytedance.android.live.liveinteract.api.utils.m.e(this).getVideoTalkRoomSubScene();
        if (r18 == null) goto L57;
        com.bytedance.android.livesdk.chatroom.viewmodel.e r19 = (com.bytedance.android.livesdk.chatroom.viewmodel.e) r18.getValue();
        if (r19 == null) goto L57;
        com.bytedance.android.livesdk.chatroom.viewmodel.j r20 = r19.t();
        if (r20 == null) goto L57;
        List<Integer> r21 = r20.b;
    L58:
        com.bytedance.android.livesdk.chatroom.u r22 = com.bytedance.android.live.liveinteract.api.utils.m.e(this);
        if (r22 == null) goto L67;
        com.bytedance.live.datacontext.j r23 = r22.getVideoTalkRoomSubScene();
        if (r23 == null) goto L67;
        com.bytedance.android.livesdk.chatroom.viewmodel.e r24 = (com.bytedance.android.livesdk.chatroom.viewmodel.e) r23.getValue();
        if (r24 == null) goto L67;
        com.bytedance.android.livesdk.chatroom.viewmodel.j r25 = r24.t();
        if (r25 == null) goto L67;
        r9 = r25.e;
    L67:
        zj0.e r26 = this.X2;
        if (r26 != null) goto L70;
        Intrinsics.throwUninitializedPropertyAccessException("layoutSwitcher");
    L70:
        r26.f(new zj0.c.e(r7, r0), r21, r9);
        this.p2 = r9;
    L57:
        r21 = null;
    L71:
        md().t0(r7);
        eh0.b r27 = this.g;
        if (r27 != null) goto L74;
        Intrinsics.throwUninitializedPropertyAccessException("linkCrossRoomGameDataMergeCenter");
    L74:
        r27.t0(r7);
        p5().t0(r7);
        tf0.o r28 = this.T;
        if (r28 == null) goto L77;
        r28.onSeiUpdated(r7);
    L77:
        this.K2 = r7;
        this.L2 = r0;
        return;
    L45:
        zj0.e r29 = this.X2;
        if (r29 != null) goto L48;
        Intrinsics.throwUninitializedPropertyAccessException("layoutSwitcher");
    L48:
        r1 = r29.e(r7, r0);
        goto L49
    L7:
        com.bytedance.android.livesdk.chatroom.viewmodel.j r30 = ur();
        if (r30 == null) goto L10;
        r0 = r30.c;
        goto L12
    L10:
        r0 = 0;
        goto L12
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.MultiLinkBaseGuestLinkWidget, com.bytedance.android.live.liveinteract.plantform.core.v
    public final void onUserJoined(String r2) {
        Intrinsics.checkNotNullParameter(r2, "interactId");
        Intrinsics.checkNotNullParameter(r2, "s");
        Intrinsics.checkNotNullParameter(r2, "s");
        tf0.o r3 = this.T;
        if (r3 == null) goto L6;
        r3.i();
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.base.k
    public final void permit(ILinkPlayerInfoBridge r2) {
        Intrinsics.checkNotNullParameter(r2, "user");
        IBaseUser r3 = r2.getUser();
        if (r3 == null) goto L6;
        Wq(r3);
        return;
    }

    @Override // yj0.a.InterfaceC0294a
    public final void q(int r5) {
        if (isViewValid() == true) goto L6;
        return;
    L6:
        if (r5 == 0) goto L24;
        if (r5 != 1) goto L9;
    L18:
        Sq(false, "silence message " + r5);
        f2.b(2131919412, 0);
        if (this.l == false) goto L21;
        com.bytedance.android.live.liveinteract.plantform.utils.x.M();
        ((Widget) this).dataCenter.put("data_talk_room_capture_audio_notification_show_state", Boolean.FALSE);
    L21:
        ToolbarVideoInteractBehavior r6 = this.Z;
        if (r6 == null) goto L30;
        r6.d(false);
        return;
    L30:
        return;
    L9:
        if (r5 == 2) goto L18;
        if (r5 != 3) goto L13;
        Sq(false, "silence message " + r5);
        Aq().T(jc1.k.n(IMiddlewareUserService.class).user().n(), tc0.c.h().f, 3);
        ToolbarVideoInteractBehavior r7 = this.Z;
        if (r7 == null) goto L28;
        r7.d(false);
        return;
    L28:
        return;
    L13:
        if (r5 == 4) goto L18;
        return;
    L24:
        Sq(true, "silence message " + r5);
        f2.b(2131919449, 0);
        ToolbarVideoInteractBehavior r8 = this.Z;
        if (r8 == null) goto L32;
        r8.d(true);
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.base.k
    public final void setInviteCallback(uf0.c r1) {
        this.J = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.base.k
    public final void setPermitCallback(uf0.d r1) {
        this.I = r1;
    }

    @Override // rj0.j
    public final void u(sf0.a r2) {
        Intrinsics.checkNotNullParameter(r2, "applyParams");
        Qq();
    }

    @Override // rj0.l
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
        r3.e(new com.bytedance.android.livesdk.chatroom.viewmodel.j(16, r4, r1, false, r7, false, 40));
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
        jy0.b.d("ttlive_link_video", "updateLiveCoreRtcInfo ".concat(r5));
        com.bytedance.live.datacontext.j r0 = com.bytedance.android.live.liveinteract.api.utils.m.e(this).getVideoTalkRoomSubScene();
        boolean r1 = false;
        if (r0 == null) goto L9;
        com.bytedance.android.livesdk.chatroom.viewmodel.e r2 = (com.bytedance.android.livesdk.chatroom.viewmodel.e) r0.getValue();
        if (r2 == null) goto L9;
        com.bytedance.android.livesdk.chatroom.viewmodel.j r3 = r2.t();
        if (r3 == null) goto L9;
        int r4 = r3.c;
    L11:
        if ((this.T instanceof CommonMultiLinkWindowManager) == true) goto L13;
    L15:
        tf0.o r6 = this.T;
        boolean r7 = r6 instanceof DynamicEqualMultiLinkWindowManager;
        tc0.c r8 = null;
        if (r7 == false) goto L22;
        if (r7 == true) goto L19;
        r6 = null;
    L19:
        DynamicEqualMultiLinkWindowManager r9 = (DynamicEqualMultiLinkWindowManager) r6;
        if (r9 == null) goto L50;
        r9.q1();
        return;
    L50:
        return;
    L22:
        tc0.c r10 = this.r;
        if ((r10 instanceof tc0.c) == false) goto L26;
        r8 = r10;
    L26:
        tc0.c r11 = r8;
        if (r11 == null) goto L52;
        String r12 = r11.k;
        if (r12 != null) goto L31;
    L34:
        boolean r13 = true;
    L35:
        if (r13 == true) goto L39;
        hg6.g r14 = P2();
        if (r14 == null) goto L39;
        r14.c(r11.k);
    L39:
        String r15 = r11.m;
        if (r15 != null) goto L42;
    L43:
        r1 = true;
    L44:
        if (r1 == true) goto L53;
        hg6.g r16 = P2();
        if (r16 == null) goto L54;
        r16.J(r11.m);
        return;
    L54:
        return;
    L53:
        return;
    L42:
        if (r15.length() != 0) goto L44;
    L31:
        if (r12.length() == 0) goto L34;
        r13 = false;
        goto L35
    L52:
        return;
    L13:
        if (uh0.a.a.contains(String.valueOf(r4)) == false) goto L15;
        commonWMUpdateLiveCoreAndRtcInfo(r5);
        return;
    L9:
        r4 = 0;
        goto L11
    }

    @Override // rj0.l
    public final void updateFullScreenDialogShowStatus(boolean r3) {
        ALogger.i("MultiLinkVideoTalkRoomGuestWidget", "updateFullScreenDialogShowStatus isShow=" + r3 + ", isBackground=" + this.l);
        if (r3 == true) goto L5;
    L7:
        if (r3 == false) goto L9;
        return;
    L9:
        if (this.l == false) goto L14;
        onResume();
        return;
    L14:
        return;
    L5:
        if (this.l == true) goto L7;
        onPause();
    }

    @Override // rj0.l
    public final boolean userIsCPosition(String r6) {
        Intrinsics.checkNotNullParameter(r6, "uid");
        CPositionContext r0 = CPositionContext.Companion.getContext();
        if (r0 == null) goto L28;
        com.bytedance.live.datacontext.m<Boolean> r1 = r0.isCPositionOpen();
        if (r1 != null) goto L7;
        return false;
    L7:
        if (((Boolean) r1.getValue()).booleanValue() != true) goto L30;
        com.bytedance.android.live.liveinteract.plantform.core.y r2 = Aq();
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

    @Override // rj0.j
    public final void w(g1 r5) {
        StringCompanionObject r0 = StringCompanionObject.INSTANCE;
        jy0.b.d("ttlive_link_video", String.format("showLinkResultDialog, showLinkResultDialog: %s", Arrays.copyOf(new Object[]{r5}, 1)));
        if (r5 == null) goto L18;
        th0.d r1 = new th0.d(this, r5);
        if (je0.d.t(je0.d.h()) == true) goto L7;
        return;
    L7:
        if (je0.d.A() == false) goto L9;
        LinkResultDialogFragmentV2.u.getClass();
        RxUtilKt.c(RxUtilKt.h(Observable.timer(LinkResultDialogFragmentV2.s, TimeUnit.MILLISECONDS)).subscribe(new th0.c(this, r5, r1)), this.F);
        return;
    L9:
        LinkResultDialogFragment.l.getClass();
        LinkResultDialogFragment r6 = LinkResultDialogFragment.a.a(r5, r1);
        FragmentActivity r2 = ((Widget) this).context;
        if (r2 == null) goto L17;
        FragmentManager r3 = r2.getSupportFragmentManager();
        String r4 = LinkResultDialogFragment.k;
        LandscapeRestrictionOperation r7 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r6, r4, r7);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r3, r6, r7) == true) goto L25;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L19
    L15:
        r6.show(r3, r4);
        return;
    L25:
        return;
    L17:
        throw new NullPointerException("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.MultiLinkBaseGuestLinkWidget, com.bytedance.android.live.liveinteract.plantform.core.v
    public final void wf(String r2) {
        com.bytedance.android.live.liveinteract.plantform.utils.u r0 = this.b2;
        if (r0 == null) goto L6;
        r0.l(r2);
        return;
    }

    public final void yr(String r8) {
        jy0.b.d("MultiLinkVideoTalkRoomGuestWidget", "handleAVPermissionOnResume, reason: ".concat(r8));
        Disposable r0 = this.R2;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        this.R2 = null;
        hg6.g r2 = P2();
        if (r2 != null) goto L8;
        return;
    L8:
        if (r2.A() != true) goto L36;
        jy0.b.d("MultiLinkVideoTalkRoomGuestWidget", "handleAVPermissionOnResume, start");
        jg6.a r1 = Eq();
        if (r1 == null) goto L14;
        kg6.e r3 = r1.b();
        if (r3 == null) goto L14;
        r3.y(false, r8);
    L14:
        Aq().r0();
        if (lr() != 3) goto L26;
        hg6.g r9 = P2();
        if (r9 == null) goto L26;
        if (r9.A() != true) goto L26;
        jg6.a r10 = Eq();
        if (r10 == null) goto L26;
        kg6.e r11 = r10.b();
        if (r11 == null) goto L26;
        r11.z(new kg6.d(false, true, "onResume", 8));
    L26:
        if (lr() != 3) goto L30;
        yj0.a r12 = this.S;
        if (r12 == null) goto L30;
        yj0.a.h0(r12, jc1.k.n(IMiddlewareUserService.class).user().n(), null, 6);
    L30:
        m00.g r13 = this.U;
        if (r13 == null) goto L33;
        r13.e();
    L33:
        tc0.c r14 = tc0.c.h();
        int r4 = com.bytedance.android.live.liveinteract.plantform.utils.x.a;
        Intrinsics.checkNotNullParameter(r14, "dataHolder");
        Intrinsics.checkNotNullParameter("resume", "reason");
        HashMap r5 = new HashMap();
        r5.put("reason", "resume");
        com.bytedance.android.live.liveinteract.plantform.utils.x.u0("livecore_start", r5, r14);
        return;
    }

    public static final void ar(MultiLinkVideoTalkRoomGuestWidget r1, boolean r2) {
        r1.getClass();
        IInteractService r0 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r0 == null) goto L7;
        gd0.i r3 = r0.getInteractFloatWindowService();
        if (r3 == null) goto L7;
        ((com.bytedance.android.live.liveinteract.service.g) r3).e(r2);
    L7:
        DataCenter r4 = ((Widget) r1).dataCenter;
        jg6.a r5 = r1.Eq();
        if (r5 == null) goto L12;
        kg6.e r6 = r5.b();
        if (r6 == null) goto L12;
        boolean r7 = r6.q();
    L13:
        r4.put("data_self_is_silenced", Boolean.valueOf(r7));
        return;
    L12:
        r7 = true;
        goto L13
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.MultiLinkBaseGuestLinkWidget, com.bytedance.android.live.liveinteract.plantform.core.v
    public final void A(String r3, Boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "interactId");
        Intrinsics.checkNotNullParameter(r3, "interactId");
        Intrinsics.checkNotNullParameter(r3, "interactId");
        this.k1.put(r3, r4);
        tf0.o r0 = this.T;
        if (r0 == null) goto L6;
        r0.c(r3, Intrinsics.areEqual(r4, Boolean.TRUE));
        return;
    }

    @Override // rj0.j
    public final void Cc(sf0.a r3, sf0.e r4) {
        if (r4 == null) goto L5;
        Yq(r4.e, new b0(this, r4), "link_invite", false);
        return;
    L5:
        if (r3 == null) goto L9;
        Yq(r3.r, new c0(this, r3), "link_apply", false);
        return;
    }

    @Override // yj0.a.InterfaceC0294a
    public final void F(String r2, Throwable r3) {
        Intrinsics.checkNotNullParameter(r2, "toUserId");
        ExceptionUtils.handleException(((Widget) this).context, r3, 2131919335);
    }

    public final void Hr(int r4, Runnable r5) {
        x0.b r0 = new x0.b(getContext(), 4);
        r0.l(r4);
        r0.i(0, 2131920806, new g(this, r5));
        r0.i(1, 2131915442, h.a);
        r0.n();
    }

    public final void Kr(String r8, Map<String, String> r9) {
        r9.put("live_type", "video_live");
        IRoom r0 = getMRoom();
        if (r0 == null) goto L7;
        z5 r1 = r0.getLinkerDetail();
        if (r1 == null) goto L7;
        r9.put("enlarge_open_from", String.valueOf(r1.getEnlargeGuestTurnOnSource()));
    L7:
        com.bytedance.android.live.liveinteract.plantform.utils.i0 r2 = TalkRoomLogUtils.a;
        boolean r3 = false;
        TalkRoomLogUtils.y0(r9, false);
        RoomStampInfo r4 = null;
        TalkRoomLogUtils.B0(r9, Integer.valueOf(mr()), null, 4);
        if (((IInteractService) jc1.k.n(IInteractService.class)).dynamicFromAudience() == false) goto L11;
        r9.put("function_type2", "new_audience");
    L11:
        if (us1.e.a == false) goto L13;
        r9.put("is_from_audience", "0");
    L13:
        TalkRoomLogUtils.V0(r9);
        TalkRoomLogUtils.Q0(r9);
        IRoom r5 = getMRoom();
        if (r5 == null) goto L20;
        ICircleInfo r6 = r5.getCircleInfo();
        if (r6 == null) goto L20;
        String r7 = r6.getCircleName();
        if (r7 == null) goto L20;
        r9.put("circle_name", r7);
    L20:
        TalkRoomLogUtils.w0(r9);
        TalkRoomLogUtils.d1(r9, ((Widget) this).dataCenter);
        TalkRoomLogUtils.T0(r9, true);
        LogCommon r10 = LogCommon.PAGE_SOURCE_LOG;
        com.bytedance.android.live.revenue.platform.log.impl.filterimpl.a r11 = mz0.d.b(r10);
        if (r11 == null) goto L25;
        Map r12 = r11.getMap();
        if (r12 == null) goto L25;
        String r13 = (String) r12.get("enter_method");
    L26:
        if (r13 == null) goto L35;
        if (r11 == null) goto L31;
        Map r14 = r11.getMap();
        if (r14 == null) goto L31;
        String r15 = (String) r14.get("enter_method");
    L33:
        if ("convenient_match_ktv".equals(r15) == false) goto L35;
        r9.put("play_mode", "[ktv]");
    L31:
        r15 = null;
    L35:
        IRoom r16 = getMRoom();
        if (r16 == null) goto L38;
        List r17 = r16.getRoomStamps();
    L40:
        if (ListUtils.isEmpty(r17) == true) goto L47;
        IRoom r18 = getMRoom();
        if (r18 == null) goto L47;
        List r19 = r18.getRoomStamps();
        if (r19 == null) goto L47;
        r4 = (RoomStampInfo) ListProtector.get(r19, 0);
    L47:
        com.bytedance.android.live.liveinteract.linkcast.g.b.getClass();
        com.bytedance.android.live.liveinteract.linkcast.g.a.f(r9, r4);
        TalkRoomLogUtils.O0(r9);
        if ((r11 instanceof mz0.f) == false) goto L59;
        mz0.f r20 = (mz0.f) r11;
        String r21 = r20.getRoomTag();
        if (r21 == null) goto L59;
        if (r21.length() <= 0) goto L54;
        r3 = true;
    L54:
        if (r3 != true) goto L59;
        String r22 = r20.getRoomTag();
        if (r22 != null) goto L58;
        r22 = "";
    L58:
        r9.put("room_tag", r22);
    L59:
        mz0.n r23 = new mz0.n();
        Map r24 = r23.a;
        Intrinsics.checkNotNullParameter(r24, "map");
        Intrinsics.checkNotNullParameter(r9, "map");
        r24.putAll(r9);
        mz0.m r25 = new mz0.m();
        r25.b(LogCommon.ROOM);
        r25.b(r10);
        r25.b(LogCommon.GAME_PARAM_ITEM);
        ((ArrayList) r23.b).addAll(r25.a);
        cy0.e.a.getClass();
        cy0.j r26 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r27 = com.bytedance.android.scope.m.b(r26).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r27);
        ((f80.a) r27).w3(r8, r23.a, r23.b);
        return;
    L38:
        r17 = null;
    L25:
        r13 = null;
        goto L26
    }

    public final void Nr(String r3, boolean r4) {
        jg6.a r5 = Eq();
        if (r5 == null) goto L7;
        kg6.e r6 = r5.b();
        if (r6 == null) goto L7;
        r6.h(r3, true, "room battle mcu");
    L7:
        hg6.g r7 = P2();
        if (r7 == null) goto L11;
        r7.f();
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.MultiLinkBaseGuestLinkWidget
    public final void T3(com.bytedance.android.livesdk.chatroom.model.interact.m r1, int r2) {
        GuestTalkBeInvitedDialog r3 = this.E;
        if (r3 == null) goto L6;
        r3.X90();
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.MultiLinkBaseGuestLinkWidget, com.bytedance.android.live.liveinteract.plantform.core.v
    public final void T6(String r1, zf2.s0 r2) {
        com.bytedance.android.live.liveinteract.plantform.utils.u r3 = this.b2;
        if (r3 == null) goto L6;
        r3.m(r1);
        return;
    }

    @Override // rj0.l
    public final void Td(String r4, MediaOperation.a r5) {
        if (Intrinsics.areEqual(r4, jc1.k.n(IMiddlewareUserService.class).user().n()) == false) goto L10;
        hg6.g r0 = P2();
        if (r0 != null) goto L7;
    L8:
        f2.b(2131919299, 0);
        return;
    L7:
        if (r0.isEngineOn() != true) goto L8;
    L10:
        yj0.a r1 = this.S;
        if (r1 == null) goto L16;
        if (r4 != null) goto L14;
        r4 = "";
    L14:
        r1.g0(r4, r5, false);
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.MultiLinkBaseGuestLinkWidget, com.bytedance.android.live.liveinteract.plantform.core.v
    public final void Xi(int r2, int r3) {
        VideoEffectPerfHelper r0 = this.Z2;
        if (r0 == null) goto L6;
        r0.e(r2, r3);
        return;
    }

    @Override // rj0.o
    public final void a(View r2, MotionEvent r3) {
        Intrinsics.checkNotNullParameter(r2, "v");
        Intrinsics.checkNotNullParameter(r3, "event");
        tf0.o r0 = this.T;
        if (r0 == null) goto L6;
        r0.a(r2, r3);
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.MultiLinkBaseGuestLinkWidget, com.bytedance.android.live.liveinteract.plantform.core.v
    public final void al(String r2, int r3) {
        com.bytedance.android.live.liveinteract.plantform.utils.u r0 = this.b2;
        if (r0 == null) goto L6;
        r0.n(r2, r3);
        return;
    }

    @Override // tf0.o.a
    public final void ca(String r4, String r5) {
        gh0.b.a("RtcParamsUpdate", "updateLiveCoreAndRtcInfo: \nrtcExtInfo = " + r4 + ", \nliveCoreExtInfo = " + r5, false);
        if (r5 == null) goto L7;
        hg6.g r0 = P2();
        if (r0 == null) goto L7;
        r0.J(r5);
    L7:
        if (r4 == null) goto L12;
        hg6.g r6 = P2();
        if (r6 == null) goto L13;
        r6.c(r4);
        return;
    L13:
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.base.k
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
        TalkRoomLogUtils.W(false, "all_cancel");
        TalkRoomBusinessFullLinkMonitor r5 = TalkRoomBusinessFullLinkMonitor.a;
        String r7 = (String) r10.element;
        r5.getClass();
        TalkRoomBusinessFullLinkMonitor.p(r7);
        long r11 = System.currentTimeMillis();
        LinkAudienceApi r12 = (LinkAudienceApi) com.bytedance.android.live.network.c.b().e(LinkAudienceApi.class);
        String r13 = (String) r10.element;
        this.F.add(r12.closeCPosition(r6, r13, r13).compose(RxUtil.rxSchedulerHelper()).subscribe(new d(r10, r11), new e(this, r10, r11)));
    }

    @Override // tf0.o.a
    public final void d0(tf0.p r2, Object r3) {
        Intrinsics.checkNotNullParameter(r2, "action");
        ne0.c r0 = this.G;
        if (r0 == null) goto L6;
        r0.d0(r2, r3);
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.base.k
    public final void dj(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "userId");
        Intrinsics.checkNotNullParameter(r3, "secUid");
        IBaseUser r0 = (IBaseUser) vh7.f.c(IBaseUser.class);
        r0.setIdString(r2);
        Intrinsics.checkNotNullParameter(r0, "$this$secUidExt");
        r0.setCastSecUid(r3);
        Wq(r0);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.MultiLinkBaseGuestLinkWidget, com.bytedance.android.live.liveinteract.plantform.core.v
    public final void f1(long r2, long r4) {
        StringBuilder r0 = new StringBuilder();
        r0.append(r2);
        r0.append(' ');
        r0.append(r4);
        Logger.d("bitrate_callback", r0.toString());
    }

    @Override // rj0.l
    public final void g2(int r3, int r4) {
        cg6.a r0 = Bq();
        if (r0 == null) goto L8;
        MultiLinkGuestManager r1 = r0.W4();
        if (r1 == null) goto L9;
        r1.h(((Widget) this).context, r3, r4);
        return;
    L9:
        return;
    }

    @Override // rj0.j
    public final v0 ga(String r12, boolean r13) {
        boolean r2 = true;
        if (hd0.c.f().g != 1) goto L5;
    L8:
        IMiddlewareBroadcastService r3 = jc1.k.n(IMiddlewareBroadcastService.class);
        Context r4 = ((Widget) this).context;
        v0 r10 = null;
        if (((Boolean) vm2.h.P4.getValue(null, vm2.h.a[300(0x12c, float:4.2E-43)])).booleanValue() == false) goto L11;
        boolean r6 = r2;
    L12:
        v0 r14 = r3.createVideoTalkView(r4, r12, r6, r13, false, this);
        if (r14 == null) goto L15;
        Pr(r14);
        Unit r15 = Unit.INSTANCE;
        r10 = r14;
    L15:
        this.c = r10;
        if (je0.d.U() == false) goto L23;
        v0 r16 = this.c;
        if (r16 == null) goto L23;
        uf2.d0 r17 = r16.getLiveCore();
        if (r17 == null) goto L23;
        SurfaceView r18 = (SurfaceView) this.p.getValue();
        r17.x();
    L23:
        return this.c;
    L11:
        r6 = false;
        goto L12
    L5:
        if (hd0.c.f().g == 3) goto L8;
        r2 = false;
        goto L8
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.base.k
    public final void ge(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "userId");
        Intrinsics.checkNotNullParameter(r3, "secUid");
        Intrinsics.checkNotNullParameter(r2, "toUserId");
        Intrinsics.checkNotNullParameter(r3, "secToUid");
        IBaseUser r0 = vh7.f.c(IBaseUser.class);
        r0.setIdString(r2);
        Intrinsics.checkNotNullParameter(r0, "$this$secUidExt");
        r0.setCastSecUid(r3);
        xf6.b r4 = Tq();
        if (r4 == null) goto L6;
        r4.d(r0, "admin_stop_normal");
        return;
    }

    @Override // rj0.o
    public final boolean interceptCloseRoom(final Runnable r10, boolean r11) {
        Integer r0 = (Integer) ((ge1.a) hd0.c.f()).b;
        b1 r1 = null;
        if (r0 == null) goto L19;
        if (2 != r0.intValue()) goto L19;
        com.bytedance.android.live.liveinteract.plantform.base.g r2 = com.bytedance.android.live.liveinteract.plantform.base.f.a();
        if (r2 != null) goto L10;
    L11:
        DataCenter r3 = ((Widget) this).dataCenter;
        if (r3 == null) goto L14;
        Boolean r4 = (Boolean) r3.get("cmd_mic_room_jump", Boolean.FALSE);
    L16:
        if (Intrinsics.areEqual(r4, Boolean.TRUE) == false) goto L19;
    L17:
        return false;
    L14:
        r4 = null;
        goto L16
    L10:
        if (r2.W1() == true) goto L17;
    L19:
        if (xe0.j.c() == true) goto L22;
    L68:
        boolean r5 = false;
    L69:
        if (r5 == false) goto L72;
        return true;
    L72:
        if (this.a == null) goto L74;
        boolean r6 = true;
    L75:
        if (r6 == false) goto L80;
        int r7 = xe0.j.a;
        getMRoom();
        if (xe0.j.a() == true) goto L80;
    L118:
        boolean r12 = false;
    L119:
        if (r12 == false) goto L121;
        return true;
    L121:
        String r13 = ChatMatchWidget.o;
        ChatMatchViewModel r14 = (ChatMatchViewModel) com.bytedance.live.datacontext.d.e("ChatMatchWidget", ChatMatchViewModel.class);
        if (r14 == null) goto L126;
        MutableLiveData<b1> r15 = r14.getMatchData();
        if (r15 == null) goto L126;
        r1 = (b1) r15.getValue();
    L126:
        if (r1 == null) goto L128;
        return false;
    L128:
        mz0.f r16 = mz0.d.b(LogCommon.PAGE_SOURCE_LOG);
        if ((r16 instanceof mz0.f) == false) goto L140;
        mz0.f r17 = r16;
        String r8 = r17.d();
        if (r8 != null) goto L133;
    L135:
        String r18 = r17.l();
        if (r18 == null) goto L140;
        if (TextUtils.equals(r18, "true") == false) goto L140;
        return false;
    L133:
        if (TextUtils.equals(r8, "true") == false) goto L135;
        return false;
    L140:
        int r9 = 2131917595;
        if (com.bytedance.android.live.liveinteract.linkpanel.util.o.o(Integer.valueOf(kr().b)) == false) goto L148;
        hg6.g r19 = P2();
        if (r19 == null) goto L148;
        if (r19.isEngineOn() != true) goto L148;
        Hr(2131917595, r10);
        return true;
    L148:
        Integer r110 = (Integer) ((ge1.a) hd0.c.f()).b;
        if (r110 != null) goto L152;
    L153:
        Integer r111 = (Integer) ((ge1.a) hd0.c.f()).b;
        if (r111 != null) goto L157;
    L163:
        return false;
    L157:
        if (2 != r111.intValue()) goto L163;
        if (com.bytedance.android.live.liveinteract.linkpanel.util.o.o(Integer.valueOf(kr().b)) == true) goto L162;
        r9 = 2131919394;
    L162:
        Hr(r9, r10);
        return true;
    L152:
        if (r110.intValue() == 0) goto L163;
    L80:
        if (com.bytedance.android.live.liveinteract.linkpanel.util.o.o(null) == true) goto L118;
        if (LinkMicGameContext.Companion.e() == true) goto L118;
        Integer r20 = (Integer) ((ge1.a) hd0.c.f()).b;
        if (r20 == null) goto L118;
        if (r20.intValue() != 1) goto L118;
        if (r11 == true) goto L118;
        if (((Boolean) ((Widget) this).dataCenter.get("data_close_room_from_small_window_play", Boolean.FALSE)).booleanValue() == true) goto L94;
        Integer r112 = (Integer) b6.j.getValue();
        if (r112 == null) goto L106;
        if (r112.intValue() != 1) goto L106;
        if (rx1.m.e(((Widget) this).context) == false) goto L106;
        br(0, new MultiLinkVideoTalkRoomGuestWidget$interceptCloseRoomByLinkmicApplyFloatWindow$3(r10), new MultiLinkVideoTalkRoomGuestWidget$interceptCloseRoomByLinkmicApplyFloatWindow$4(this, r10), LinkApi.ApplyStashType.APPLY_WINDOW.ordinal());
    L117:
        r12 = true;
    L106:
        if (this.a == null) goto L108;
        boolean r113 = true;
    L109:
        if (r113 == false) goto L118;
        if (xe0.j.b() == false) goto L118;
        AppCompatDialog r114 = new LinkmicApplyFloatWindowRetainDialog(((Widget) this).context, getMRoom(), r10);
        if (DialogLancet.shouldBlockDialogShow(r114) == false) goto L169;
        DialogLancet.handleBlockedDialogShow(r114);
        goto L117
    L169:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L165
    L116:
        DialogLancet.beforeDialogShow(r114);
        r114.show();
        DialogLancet.afterDialogShow(r114);
        goto L117
    L108:
        r113 = false;
        goto L109
    L94:
        if (rx1.m.e(((Widget) this).context) == false) goto L96;
        br(0, new MultiLinkVideoTalkRoomGuestWidget$interceptCloseRoomByLinkmicApplyFloatWindow$1(this, r10), new MultiLinkVideoTalkRoomGuestWidget$interceptCloseRoomByLinkmicApplyFloatWindow$2(this, r10), LinkApi.ApplyStashType.APPLY_WINDOW.ordinal());
        goto L117
    L96:
        rx1.m.h(((Widget) this).context);
        goto L117
    L74:
        r6 = false;
        goto L75
    L22:
        if (com.bytedance.android.live.liveinteract.linkpanel.util.o.o(null) == true) goto L68;
        if (LinkMicGameContext.Companion.e() == true) goto L68;
        Integer r21 = (Integer) ((ge1.a) hd0.c.f()).b;
        if (r21 == null) goto L68;
        if (r21.intValue() != 2) goto L68;
        if (r11 == true) goto L68;
        IKtvService r22 = jc1.k.f(IKtvService.class);
        if (r22 == null) goto L68;
        if (r22.isCurrentUserIsSinger() == true) goto L68;
        InteractiveSongContext r23 = InteractiveSongContext.Companion.getContext();
        if (r23 == null) goto L42;
        if (r23.getSelfSingingState() == RequestSongSingState.STATE_SINGING.getValue()) goto L68;
    L42:
        if (((Boolean) ((Widget) this).dataCenter.get("data_close_room_from_small_window_play", Boolean.FALSE)).booleanValue() == true) goto L44;
        Integer r24 = (Integer) b6.j.getValue();
        if (r24 == null) goto L56;
        if (r24.intValue() != 1) goto L56;
        if (rx1.m.e(((Widget) this).context) == false) goto L56;
        br(0, new MultiLinkVideoTalkRoomGuestWidget$interceptCloseRoomByLinkmicOnlineFloatWindow$3(this, r10), new MultiLinkVideoTalkRoomGuestWidget$interceptCloseRoomByLinkmicOnlineFloatWindow$4(this, r10), LinkApi.ApplyStashType.ONLINE_WINDOW.ordinal());
    L67:
        r5 = true;
    L56:
        if (this.a == null) goto L58;
        boolean r25 = true;
    L59:
        if (r25 == false) goto L68;
        if (xe0.j.b() == false) goto L68;
        AppCompatDialog r26 = new LinkmicOnlineFloatWindowRetainDialog(((Widget) this).context, getMRoom(), r10, new MultiLinkVideoTalkRoomGuestWidget$interceptCloseRoomByLinkmicOnlineFloatWindow$5(this));
        if (DialogLancet.shouldBlockDialogShow(r26) == false) goto L167;
        DialogLancet.handleBlockedDialogShow(r26);
        goto L67
    L167:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L166
    L66:
        DialogLancet.beforeDialogShow(r26);
        r26.show();
        DialogLancet.afterDialogShow(r26);
        goto L67
    L58:
        r25 = false;
        goto L59
    L44:
        if (rx1.m.e(((Widget) this).context) == false) goto L46;
        br(0, new MultiLinkVideoTalkRoomGuestWidget$interceptCloseRoomByLinkmicOnlineFloatWindow$1(this, r10), new MultiLinkVideoTalkRoomGuestWidget$interceptCloseRoomByLinkmicOnlineFloatWindow$2(this, r10), LinkApi.ApplyStashType.ONLINE_WINDOW.ordinal());
        goto L67
    L46:
        rx1.m.h(((Widget) this).context);
        goto L67
    }

    @Override // md0.a.InterfaceC0236a
    public final boolean isVersionSupported(int r4, int r5) {
        if (r4 != 9) goto L5;
    L12:
        boolean r0 = true;
    L13:
        if (r0 == false) goto L15;
    L36:
        boolean r6 = true;
    L37:
        if (r6 == true) goto L40;
        ln0.a r7 = yg0.h.a;
        if (yg0.h.i(r5) == true) goto L40;
        return false;
    L40:
        return true;
    L15:
        if (r4 != 10) goto L17;
    L22:
        boolean r1 = true;
    L23:
        if (r1 == true) goto L36;
        if (r4 != 8) goto L27;
    L30:
        boolean r2 = true;
    L31:
        if (r2 == true) goto L36;
        if (aj0.b.b(Integer.valueOf(r4)) == true) goto L36;
        r6 = false;
        goto L37
    L27:
        if (r4 == 5) goto L30;
        r2 = false;
        goto L31
    L17:
        if (r4 == 12) goto L22;
        if (r4 == 15) goto L22;
        r1 = false;
        goto L23
    L5:
        if (r4 == 11) goto L12;
        if (r4 == 13) goto L12;
        if (r4 == 16) goto L12;
        r0 = false;
        goto L13
    }

    @Override // tf0.o.a
    public final void kd(String r5, String r6) {
        Intrinsics.checkNotNullParameter(r6, "source");
        jy0.b.a(LinkRoomFightContext.TAG, "livecore version " + jc1.k.n(IMiddlewareBroadcastService.class).getLiveCoreVersion());
        StringBuilder r0 = new StringBuilder("stopPlayPublicStream isEngineOn: ");
        hg6.g r2 = P2();
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
        hg6.g r1 = P2();
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

    @Override // rj0.l
    public final void li(String r4, MediaOperation.a r5) {
        if (Intrinsics.areEqual(r4, jc1.k.n(IMiddlewareUserService.class).user().n()) == false) goto L10;
        hg6.g r0 = P2();
        if (r0 != null) goto L7;
    L8:
        f2.b(2131919299, 0);
        return;
    L7:
        if (r0.isEngineOn() != true) goto L8;
    L10:
        this.U2 = false;
        yj0.a r1 = this.S;
        if (r1 == null) goto L16;
        if (r4 != null) goto L14;
        r4 = "";
    L14:
        Intrinsics.checkNotNullParameter(r4, "toUserId");
        r1.f0(r4, 0, r5);
        return;
    }

    @Override // rj0.l
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
        com.bytedance.android.live.liveinteract.plantform.model.r0 r7 = r0.getKtvComponentMediaInfo();
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
        hg6.g r3 = P2();
        if (r3 == null) goto L24;
        r3.I(r5);
    L24:
        hg6.g r8 = P2();
        if (r8 == null) goto L27;
        r8.J(r7.getLiveCoreExtInfo());
    L27:
        hg6.g r9 = P2();
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

    @Override // rj0.o
    public final void onSei(String r3, ye1.a r4) {
        Intrinsics.checkNotNullParameter(r4, "info");
        if (((Widget) this).isViewValid == true) goto L6;
        return;
    L6:
        if (isEngineOn() == true) goto L14;
        this.H0.e(r3, r4);
        Widget r0 = this.T1;
        if ((r0 instanceof fd2.u) == true) goto L10;
        r0 = null;
    L10:
        fd2.u r1 = (fd2.u) r0;
        if (r1 == null) goto L15;
        r1.onSei(r3, r4);
        return;
    L15:
        return;
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
        jg6.a r0 = Eq();
        if (r0 == null) goto L8;
        lh6.b r1 = r0.a();
        if (r1 == null) goto L9;
        r1.f(r3, r4, "muteRemoteVideoStream by video talk guest widget");
        return;
    L9:
        return;
    }

    @Override // rj0.j
    public final void t(sf0.a r5, IApplyResult r6) {
        Intrinsics.checkNotNullParameter(r5, "applyParams");
        Intrinsics.checkNotNullParameter(r6, "applyResult");
        if (je0.d.Y() == false) goto L8;
        ILinkPanelService r0 = com.bytedance.android.live.liveinteract.component.b.a();
        if (r0 == null) goto L8;
        if (r0.isShowing() != true) goto L8;
        return;
    L8:
        ILinkPanelService r1 = com.bytedance.android.live.liveinteract.component.b.a();
        if (r1 == null) goto L13;
        Context r2 = ((Widget) this).context;
        IRoom r3 = getMRoom();
        a5 r7 = r6.getDisplayText();
        com.bytedance.android.live.liveinteract.plantform.utils.i0 r4 = TalkRoomLogUtils.a;
        ILinkPanelService.a.a(r1, r2, r3, r7, TalkRoomLogUtils.w(r5.b, com.bytedance.android.live.liveinteract.api.chatroom.model.a.a(r5.c)));
        return;
    }

    @Override // rj0.l
    public final void tm(String r7, String r8) {
        Intrinsics.checkNotNullParameter(r7, "userId");
        com.bytedance.android.live.liveinteract.plantform.core.y r0 = Aq();
        String r1 = "";
        if (r0 == null) goto L5;
        ILinkPlayerInfoBridge r9 = r0.o(r7, "");
    L6:
        tf0.o r2 = this.T;
        if (r2 == null) goto L16;
        if (r9 == null) goto L15;
        IBaseUser r3 = r9.getUser();
        if (r3 == null) goto L15;
        String r4 = r3.getIdString();
        if (r4 == null) goto L15;
        r1 = r4;
    L15:
        int r5 = r2.h(r1);
    L17:
        if (r9 == null) goto L30;
        Context r6 = ((Widget) this).context;
        DataCenter r10 = ((Widget) this).dataCenter;
        Intrinsics.checkNotNullParameter(r6, "context");
        Intrinsics.checkNotNullParameter(r10, "dataCenter");
        Intrinsics.checkNotNullParameter(r9, "userInfo");
        if (r8 != null) goto L21;
        r8 = "seat";
    L21:
        Intrinsics.checkNotNullParameter(r8, "requestPage");
        if (hg6.i.a() == false) goto L24;
        ih0.d r11 = com.bytedance.android.live.liveinteract.videotalk.utils.panel.a.j;
        com.bytedance.android.live.liveinteract.videotalk.utils.panel.a.u(r9, r8, false);
    L28:
        r11.v0(r5);
        r11.a();
        return;
    L24:
        VideoTalkInteractEmojiPanel r12 = new VideoTalkInteractEmojiPanel(r6, r10, r9);
        Intrinsics.checkNotNullParameter(r8, "<set-?>");
        r12.k = r8;
        r12.r = false;
        tb6.c r13 = r12.x;
        if (r13 == null) goto L27;
        r13.a();
        Intrinsics.checkNotNullParameter(r8, "requestPage");
        r13.d = r8;
    L27:
        r11 = r12;
        goto L28
    L30:
        return;
    L16:
        r5 = 0;
        goto L17
    L5:
        r9 = null;
        goto L6
    }

    @Override // tf0.o.a
    public final void v4(String r4, boolean r5) {
        jy0.b.a(LinkRoomFightContext.TAG, "#PublicStreamMix# livecore version " + ((IMiddlewareBroadcastService) va1.b.a.a.a(IMiddlewareBroadcastService.class)).getLiveCoreVersion());
        StringBuilder r6 = new StringBuilder("#PublicStreamMix# setPublicStreamVideoSink isEngineOn: ");
        hg6.g r1 = P2();
        if (r1 == null) goto L5;
        Boolean r2 = Boolean.valueOf(r1.isEngineOn());
    L6:
        r6.append(r2);
        r6.append(" id ");
        r6.append(r4);
        jy0.b.a(LinkRoomFightContext.TAG, r6.toString());
        if (r4 != null) goto L9;
    L14:
        hg6.g r3 = P2();
        if (r3 == null) goto L19;
        xi0.b r7 = r3.O();
        if (r7 == null) goto L19;
        r7.v4(String.valueOf(r4), false);
    L19:
        jy0.b.a(LinkRoomFightContext.TAG, "#PublicStreamMix# setPublicStreamVideoSink result null");
        return;
    L9:
        if (r4.length() != 0) goto L11;
        boolean r8 = true;
    L12:
        if (r8 != true) goto L14;
        return;
    L11:
        r8 = false;
        goto L12
    L5:
        r2 = null;
        goto L6
    }

    public final void xr(String r10, boolean r11) {
        jy0.b.d("MultiLinkVideoTalkRoomGuestWidget", "handleAVPermissionOnPause, reason: " + r10 + ", forceSilence: " + r11);
        Disposable r0 = this.R2;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        this.R2 = null;
        hg6.g r2 = P2();
        if (r2 != null) goto L8;
        return;
    L8:
        if (r2.A() != true) goto L55;
        Activity r3 = ContextUtil.contextToActivity(((Widget) this).context);
        sb6.a r4 = GuestLinkContext.Companion.a();
        if (r4 != null) goto L12;
    L14:
        boolean r5 = false;
    L15:
        if (r5 == false) goto L21;
        jy0.b.d("MultiLinkVideoTalkRoomGuestWidget", "handleAVPermissionOnPause, muteAllRemoteAudioStreams");
        jg6.a r6 = Eq();
        if (r6 == null) goto L21;
        kg6.e r7 = r6.b();
        if (r7 == null) goto L21;
        r7.y(true, r10);
    L21:
        if (r11 == true) goto L27;
        if (((IInteractService) jc1.k.n(IInteractService.class)).enableCaptureAudioOnBackground(true) == false) goto L27;
        com.bytedance.android.live.liveinteract.plantform.utils.x.J();
    L45:
        if (r3 != null) goto L47;
    L49:
        m00.g r12 = this.U;
        if (r12 == null) goto L52;
        r12.d();
    L52:
        com.bytedance.android.live.liveinteract.plantform.utils.x.A(tc0.c.h(), r10);
        return;
    L47:
        if (r3.isFinishing() == true) goto L49;
        jy0.b.d("MultiLinkVideoTalkRoomGuestWidget", "handleAVPermissionOnPause, onEnterBackground");
        Aq().v();
    L27:
        if (lr() != 3) goto L29;
    L30:
        hg6.g r13 = P2();
        if (r13 != null) goto L33;
    L39:
        if (r3 == null) goto L45;
        if (r3.isFinishing() == true) goto L45;
        jy0.b.d("MultiLinkVideoTalkRoomGuestWidget", "handleAVPermissionOnPause, update SilenceStatus to SILENCE_PASSIVE");
        this.U2 = true;
        Aq().T(jc1.k.n(IMiddlewareUserService.class).user().n(), tc0.c.h().f, 3);
        yj0.a r14 = this.S;
        if (r14 == null) goto L45;
        r14.f0(jc1.k.n(IMiddlewareUserService.class).user().n(), 1, null);
        goto L45
    L33:
        if (r13.A() != true) goto L39;
        jy0.b.d("MultiLinkVideoTalkRoomGuestWidget", "handleAVPermissionOnPause, switchAudioMuteAndPublish false");
        jg6.a r15 = Eq();
        if (r15 == null) goto L39;
        kg6.e r16 = r15.b();
        if (r16 == null) goto L39;
        r16.t(new kg6.b(false, true, "onPause", 8));
        goto L39
    L29:
        if (lr() != 0) goto L45;
    L12:
        if (r4.c != true) goto L14;
        r5 = true;
        goto L15
    }

    @Override // rj0.l
    public final void z0(boolean r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, "emptySeatUrl");
        tf0.o r0 = this.T;
        if (r0 == null) goto L6;
        r0.z0(r2, r3);
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.MultiLinkBaseGuestLinkWidget, com.bytedance.android.live.liveinteract.plantform.core.v
    public final void J(String[] r2, boolean[] r3, int[] r4) {
        super.J(r2, r3, r4);
        tf0.o r0 = this.T;
        if (r0 == null) goto L5;
        r0.onTalkStateUpdated(r2, r3);
    L5:
        this.V2.a(r2, r4);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.MultiLinkBaseGuestLinkWidget
    public final void Ng(sf0.a r17, long r18, ExtraResponse<? extends IApplyResult, Extra> r20) {
        Intrinsics.checkNotNullParameter(r17, "applyParams");
        Intrinsics.checkNotNullParameter(r20, "response");
        IApplyResult r4 = (IApplyResult) r20.data;
        super.Ng(r17, r18, r20);
        TeamFightContext.Companion.i(r17.i, r17.a);
        com.bytedance.android.live.liveinteract.plantform.utils.w0 r2 = this.x;
        r2.getClass();
        Intrinsics.checkNotNullParameter("apply", "<set-?>");
        r2.a = "apply";
        String r3 = getScopeServiceInMultiLinkRoom(tc0.b.class).getApplyReason();
        Intrinsics.checkNotNullParameter(r17, "applyParams");
        HashMap r5 = new HashMap();
        r5.put("live_type", "video_live");
        int r6 = this.y;
        int r7 = bh0.a.a;
        String r9 = "";
        if (r6 != 101) goto L6;
        r5.put("request_page", "seat");
    L47:
        List<KtvMusic> r8 = je0.d.Z();
        if (Intrinsics.areEqual((String) r5.get("request_page"), "live_song") == false) goto L50;
    L60:
        r5.put("guest_connection_type", "live_song");
    L61:
        List<KtvMusic> r10 = r8;
        if (r10 != null) goto L64;
    L67:
        boolean r11 = true;
    L68:
        if (r11 == true) goto L70;
        r5.put("from_request_type", this.D);
        com.bytedance.android.live.liveinteract.plantform.utils.i0 r12 = TalkRoomLogUtils.a;
        TalkRoomLogUtils.a1(r5, r8);
    L70:
        String r13 = tc0.c.h().M;
        if (TextUtils.isEmpty(r13) == true) goto L74;
        r5.put("is_task", "1");
        r5.put("activity_name", r13);
    L74:
        if (tc0.c.h().K != LinkApplyType.MATCH.getValue()) goto L77;
        r5.put("request_page", tc0.c.h().L.getValue());
    L77:
        if (Pq() == false) goto L79;
        r5.put("is_approve_needed", "0");
    L80:
        r5.put("connect_type", this.x.a);
        if (this.B == false) goto L83;
        Object r14 = "1";
    L84:
        r5.put("is_full", r14);
        if (this.C == false) goto L87;
        Object r15 = "1";
    L88:
        r5.put("is_fans_guide", r15);
        com.bytedance.android.live.liveinteract.plantform.core.y r16 = Aq();
        if (r16 == null) goto L91;
        Integer r19 = Integer.valueOf(je0.d.j(r16));
    L92:
        String r21 = String.valueOf(r19.intValue());
        if (r21 != null) goto L95;
        r21 = "0";
    L95:
        r5.put("link_cnt", r21);
        com.bytedance.android.live.liveinteract.plantform.utils.i0 r22 = TalkRoomLogUtils.a;
        TalkRoomLogUtils.y0(r5, false);
        if (fj0.e.l() == true) goto L98;
    L100:
        Object r23 = "0";
    L101:
        r5.put("is_rechargeble", r23);
        if (fj0.e.l() == false) goto L111;
        fj0.a r24 = fj0.b.a;
        if (r24.b == false) goto L107;
        r5.put("recharge_mode", "normal");
    L107:
        if (r24.b == false) goto L109;
        com.bytedance.android.live.liveinteract.api.data.a.h.getClass();
        String r25 = String.valueOf(com.bytedance.android.live.liveinteract.api.data.a.C0017a.g());
    L110:
        r5.put("recharge_price", r25);
        goto L111
    L109:
        r25 = "0";
    L111:
        if (r3 != null) goto L113;
        r3 = "";
    L113:
        r5.put("apply_reason", r3);
        if (fj0.e.l() == false) goto L149;
        com.bytedance.android.live.liveinteract.api.data.a.h.getClass();
        r5.put("time", String.valueOf(com.bytedance.android.live.liveinteract.api.data.a.C0017a.f()));
        int r26 = com.bytedance.android.live.liveinteract.api.data.a.C0017a.g();
        r5.put("money", String.valueOf(r26));
        if (fj0.e.d() == false) goto L118;
        r5.put("anonymous_switch", "on");
    L119:
        PaidLinkMicContext r27 = PaidLinkMicContext.Companion.getContext();
        if (r27 == null) goto L126;
        com.bytedance.live.datacontext.m<Integer> r28 = r27.getDiscountMode();
        if (r28 == null) goto L126;
        Integer r29 = (Integer) r28.getValue();
        if (r29 == null) goto L126;
        int r30 = r29.intValue();
    L128:
        if (r30 == 1) goto L134;
        if (r30 == 2) goto L133;
        if (r30 == 3) goto L132;
        String r110 = "";
    L135:
        r5.put("discount_type", r110);
        fj0.a r111 = fj0.b.a;
        int r112 = r111.h;
        int r113 = r111.i;
        if (r30 != 1) goto L138;
        int r31 = r26 - r112;
    L143:
        if (r31 < 0) goto L145;
        String r32 = String.valueOf(r31);
    L146:
        r5.put("pay_price", r32);
        if (r111.g == false) goto L149;
        r5.put("is_vip_recharge_privilege", "1");
        goto L149
    L145:
        r32 = "0";
        goto L146
    L138:
        if (r30 == 2) goto L142;
        if (r30 == 3) goto L142;
        r31 = 0;
    L142:
        r31 = r26 - r113;
        goto L143
    L132:
        r110 = "strategy";
        goto L135
    L133:
        r110 = "activity";
        goto L135
    L134:
        r110 = "vip";
    L126:
        r30 = 0;
        goto L128
    L118:
        r5.put("anonymous_switch", "off");
    L149:
        TalkRoomLogUtils.B0(r5, Integer.valueOf(((IInteractService) jc1.k.n(IInteractService.class)).getCurrentScene()), null, 4);
        TalkRoomLogUtils.V0(r5);
        TalkRoomLogUtils.Q0(r5);
        gk0.a.b.getClass();
        r5.put("previous_page", gk0.a.C0214a.c());
        TalkRoomLogUtils.L0(r5);
        TalkRoomLogUtils.T0(r5, false);
        IRoom r33 = getMRoom();
        if (r33 == null) goto L156;
        ICircleInfo r34 = r33.getCircleInfo();
        if (r34 == null) goto L156;
        String r35 = r34.getCircleName();
        if (r35 == null) goto L156;
        r5.put("circle_name", r35);
    L156:
        TalkRoomLogUtils.w0(r5);
        com.bytedance.android.live.liveinteract.plantform.core.y r36 = Aq();
        r5.put("seat_num", String.valueOf(r36.n()));
        CopyOnWriteArrayList<LinkmicPositionItem> r37 = r36.e;
        if (r37 == null) goto L175;
        Iterator<LinkmicPositionItem> r38 = r37.iterator();
    L160:
        if (r38.hasNext() == false) goto L167;
        LinkmicPositionItem r39 = r38.next();
        if (r39.getPosition() != r17.a) goto L164;
        boolean r114 = true;
    L165:
        if (r114 == false) goto L160;
    L168:
        LinkmicPositionItem r40 = r39;
        if (r40 == null) goto L175;
        String r41 = r40.getActiveName();
        if (r41 != null) goto L173;
        r41 = "";
    L173:
        r5.put("seat_name", r41);
        goto L175
    L164:
        r114 = false;
        goto L165
    L167:
        r39 = null;
    L175:
        if (com.bytedance.android.live.liveinteract.voicechat.util.e.a(true) == false) goto L177;
        r5.put("is_pre_link", "1");
    L179:
        if (((IInteractService) jc1.k.n(IInteractService.class)).dynamicFromAudience() == false) goto L181;
        r5.put("function_type2", "new_audience");
    L181:
        TalkRoomLogUtils.M0(r5, this.y, null, false, 12);
        if (com.bytedance.android.live.liveinteract.utils.h1.d() == false) goto L184;
        int r42 = com.bytedance.android.live.liveinteract.utils.h1.c();
        li0.b r43 = li0.b.b;
        r5.put("grouppk_group", li0.b.d(r42));
    L184:
        com.bytedance.android.livesdk.chatroom.model.interact.b1 r44 = (com.bytedance.android.livesdk.chatroom.model.interact.b1) com.bytedance.android.livesdk.sharedpref.c.g1.getValue();
        fj0.a r45 = fj0.b.a;
        r5.put("rechargeable_label", fj0.b.i(r44.getSavedTagInfos()));
        r5.put("rechargeable_intro", r44.getSavedDesc());
        com.bytedance.android.live.liveinteract.plantform.core.y r46 = Aq();
        if (r46 == null) goto L202;
        CopyOnWriteArrayList<ILinkPlayerInfoBridge> r47 = r46.c;
        if (r47 == null) goto L202;
        Iterator<ILinkPlayerInfoBridge> r48 = r47.iterator();
    L190:
        if (r48.hasNext() == false) goto L198;
        ILinkPlayerInfoBridge r49 = r48.next();
        IBaseUser r50 = r49.getUser();
        if (r50 == null) goto L194;
        String r51 = r50.getIdString();
    L196:
        if (Intrinsics.areEqual(r51, je0.d.b0()) == false) goto L190;
    L199:
        ILinkPlayerInfoBridge r52 = r49;
        if (r52 == null) goto L202;
        Integer r53 = Integer.valueOf(r52.getUserPosition());
    L203:
        if (r53 == null) goto L205;
        r5.put("seat_position", String.valueOf(r53.intValue() + 1));
    L205:
        com.bytedance.android.live.liveinteract.plantform.model.g0 r54 = (com.bytedance.android.live.liveinteract.plantform.model.g0) ((Widget) this).dataCenter.get("data_link_mic_pos_tag_info", null);
        if (r54 != null) goto L208;
    L209:
        if (r4 == null) goto L211;
        com.bytedance.android.live.liveinteract.plantform.model.g0 r115 = r4.getMicPosTagInfo();
    L212:
        if (r115 == null) goto L214;
        r54 = r4.getMicPosTagInfo();
        ((Widget) this).dataCenter.put("data_link_mic_pos_tag_info", r4.getMicPosTagInfo());
    L214:
        if (r54 == null) goto L218;
        long r55 = r54.getTagType();
        if (r55 <= 0) goto L218;
        r5.put("tag_type", String.valueOf(r55));
    L218:
        InteractiveSongLoggerKt.b(r5);
        ii0.a.c(r5, true);
        TalkRoomLogUtils.O0(r5);
        com.bytedance.android.live.liveinteract.linkcast.g.b.getClass();
        com.bytedance.android.live.liveinteract.linkcast.g.a.f(r5, null);
        int r56 = com.bytedance.android.live.liveinteract.utils.f0.a;
        Intrinsics.checkNotNullParameter(r5, "logMap");
        sh0.i0 r57 = sh0.j0.a(null);
        if (r57 != null) goto L221;
    L234:
        TalkRoomLogUtils.R0(r5);
        TalkRoomLogUtils.G0(r17.a, r5);
        mz0.n r1 = new mz0.n();
        Map r58 = r1.a;
        Intrinsics.checkNotNullParameter(r58, "map");
        Intrinsics.checkNotNullParameter(r5, "map");
        r58.putAll(r5);
        mz0.m r59 = new mz0.m();
        r59.b(LogCommon.ROOM);
        r59.b(LogCommon.PAGE_SOURCE_LOG);
        r59.b(LogCommon.GAME_PARAM_ITEM);
        ((ArrayList) r1.b).addAll(r59.a);
        cy0.e.a.getClass();
        cy0.j r60 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r61 = com.bytedance.android.scope.m.b(r60).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r61);
        ((f80.a) r61).w3("livesdk_guest_connection_apply", r1.a, r1.b);
        return;
    L221:
        if (r57.g() != true) goto L234;
        int r62 = sh0.h0.a;
        com.bytedance.android.live.liveinteract.revenue.game.e r63 = (com.bytedance.android.live.liveinteract.revenue.game.e) sh0.j0.d(null, "linkmic_game_state");
        if (r63 == null) goto L226;
        String r65 = r63.c;
        if (r65 == null) goto L226;
    L227:
        r5.put("play_mode", r65);
        if (r63 == null) goto L233;
        String r66 = r63.b;
        if (r66 == null) goto L233;
        r9 = r66;
    L233:
        r5.put("game_id", r9);
    L226:
        r65 = "danmu";
        goto L227
    L211:
        r115 = null;
        goto L212
    L208:
        if (r54.getTagType() != 0) goto L214;
    L194:
        r51 = null;
        goto L196
    L198:
        r49 = null;
    L202:
        r53 = null;
        goto L203
    L177:
        r5.put("is_pre_link", "0");
        goto L179
    L98:
        if (fj0.b.a.b == false) goto L100;
        r23 = "1";
        goto L101
    L91:
        r19 = null;
        goto L92
    L87:
        r15 = "0";
        goto L88
    L83:
        r14 = "0";
        goto L84
    L79:
        r5.put("is_approve_needed", "1");
        goto L80
    L64:
        if (r10.isEmpty() == true) goto L67;
        r11 = false;
        goto L68
    L50:
        if (Intrinsics.areEqual((String) r5.get("request_page"), "live_chorus") == true) goto L60;
        Integer r67 = Integer.valueOf(mr());
        List<KtvMusic> r68 = r8;
        if (r68 != null) goto L55;
    L58:
        boolean r69 = true;
    L59:
        TalkRoomLogUtils.D0(r5, r67, !r69);
        goto L61
    L55:
        if (r68.isEmpty() == true) goto L58;
        r69 = false;
        goto L59
    L6:
        if (r6 != 102) goto L9;
        r5.put("request_page", "bottom");
        goto L47
    L9:
        if (r6 != 103) goto L12;
        r5.put("request_page", "popup");
        goto L47
    L12:
        if (r6 != 110) goto L15;
        r5.put("request_page", "task");
        goto L47
    L15:
        if (r6 != 111) goto L18;
        r5.put("request_page", "top");
        goto L47
    L18:
        if (r6 != 113) goto L21;
        r5.put("request_page", "card");
        goto L47
    L21:
        if (r6 != 112) goto L24;
        r5.put("request_page", "apply_panel");
        goto L47
    L24:
        if (r6 != 114) goto L31;
        if (this.A != LinkApplyType.KTV_MULTI_CHORUS) goto L28;
        Object r70 = "live_chorus";
    L29:
        r5.put("request_page", r70);
        goto L47
    L28:
        r70 = "live_song";
        goto L29
    L31:
        if (r6 != 115) goto L34;
        r5.put("request_page", "associated_apply");
        goto L47
    L34:
        if (r6 != 118) goto L37;
        r5.put("request_page", "preview_theme_promote_link");
        goto L47
    L37:
        if (r6 != 119) goto L40;
        r5.put("request_page", "preview_game_promote_link");
        goto L47
    L40:
        if (tc0.c.h().J == 114) goto L43;
        r5.put("request_page", "");
        goto L47
    L43:
        if (this.A != LinkApplyType.KTV_MULTI_CHORUS) goto L45;
        Object r71 = "live_chorus";
    L46:
        r5.put("request_page", r71);
        goto L47
    L45:
        r71 = "live_song";
        goto L46
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.MultiLinkBaseGuestLinkWidget, com.bytedance.android.live.liveinteract.plantform.core.v
    public final void S(String r2, int r3, int r4) {
        tf0.o r0 = this.T;
        if (r0 == null) goto L6;
        r0.S(r2, r3, r4);
        return;
    }

    @Override // rj0.l
    public final void S8(String r9, int r10, String r11) {
        Intrinsics.checkNotNullParameter(r9, "requestPage");
        if (isViewValid() == true) goto L5;
        return;
    L5:
        ((Widget) this).dataCenter.put("data_task_name_when_open_invite_panel", r11);
        ILinkPanelService r2 = com.bytedance.android.live.liveinteract.component.b.a();
        if (r2 == null) goto L9;
        r2.ad(((Widget) this).context, ((Widget) this).dataCenter, r9, r10, this);
        return;
    }

    @Override // yj0.a.InterfaceC0294a
    public final void Z(String r2, String r3, AckFromSource r4) {
        Intrinsics.checkNotNullParameter(r2, "toUserId");
        Intrinsics.checkNotNullParameter(r4, "fromSource");
        xf6.b r0 = Tq();
        if (r0 == null) goto L6;
        r0.Z(r2, r3, r4);
        return;
    }

    @Override // rj0.l
    public final void cancelApply(h80.a<Boolean> r2, boolean r3, String r4) {
        xf6.b r5 = Tq();
        if (r5 != null) goto L5;
        return;
    L5:
        if (r4 != null) goto L7;
        r4 = "";
    L7:
        r5.e(new wf6.a(r3, r4));
    }

    @Override // rj0.l
    public final void ec(LinkApplyType r20, LinkMatchType r21, String r22) {
        Intrinsics.checkNotNullParameter(r20, "applyType");
        Intrinsics.checkNotNullParameter(r21, "matchType");
        Intrinsics.checkNotNullParameter(r22, "fromSource");
        apply(new sf0.a(-1, com.bytedance.android.live.liveinteract.multianchor.model.b.TYPE_CANCELED_BY_SERVER, r20.getValue(), 0, r21, null, r22, 0, 0, 0, false, false, 0, null, null, 0, 524136));
    }

    @Override // tf0.o.a
    public final void h(String r1, boolean r2, String r3) {
        Nr(r1, true);
    }

    @Override // rj0.l, rj0.j
    public final void o2(boolean r7, SongListItemViewHolder.bindClickListener.3.c r8, sf0.a r9) {
        if (r9 == null) goto L22;
        Intrinsics.checkNotNullParameter(r9, "applyParams");
        this.C = true;
        ILinkPanelService r10 = com.bytedance.android.live.liveinteract.component.b.a();
        if (r10 == null) goto L6;
        r10.close();
    L6:
        com.bytedance.android.livesdk.chatroom.o r2 = com.bytedance.android.live.liveinteract.api.utils.m.j(this);
        if (r2 == null) goto L45;
        com.bytedance.live.datacontext.m r11 = r2.y1();
        if (r11 == null) goto L12;
        r11.setValue(Boolean.TRUE);
    L12:
        com.bytedance.android.livesdk.common.b r12 = this.v;
        if (r12 != null) goto L15;
    L17:
        com.bytedance.android.live.liveinteract.widget.widget.q r13 = new com.bytedance.android.live.liveinteract.widget.widget.q(((Widget) this).context, r2, this, false, new th0.a(this, r9));
        this.v = r13;
        if (DialogLancet.shouldBlockDialogShow(r13) == false) goto L40;
        DialogLancet.handleBlockedDialogShow(r13);
        return;
    L40:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L36
    L21:
        DialogLancet.beforeDialogShow(r13);
        r13.show();
        DialogLancet.afterDialogShow(r13);
        return;
    L15:
        if (r12.isShowing() != true) goto L17;
        return;
    L45:
        return;
    L22:
        com.bytedance.live.datacontext.m r14 = com.bytedance.android.live.liveinteract.api.utils.m.e(this).y1();
        if (r14 == null) goto L25;
        r14.setValue(Boolean.TRUE);
    L25:
        com.bytedance.android.livesdk.common.b r15 = this.v;
        if (r15 == null) goto L30;
        Intrinsics.checkNotNull(r15);
        if (r15.isShowing() == false) goto L30;
        return;
    L30:
        com.bytedance.android.live.liveinteract.widget.widget.q r16 = new com.bytedance.android.live.liveinteract.widget.widget.q(((Widget) this).context, com.bytedance.android.live.liveinteract.api.utils.m.j(this), this, r7, r8);
        this.v = r16;
        if (DialogLancet.shouldBlockDialogShow(r16) == false) goto L38;
        DialogLancet.handleBlockedDialogShow(r16);
        return;
    L38:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L37
    L34:
        DialogLancet.beforeDialogShow(r16);
        r16.show();
        DialogLancet.afterDialogShow(r16);
    }

    @Override // rj0.l
    public final void onProfileCardClick(String r20, int r21, String r22) {
        Intrinsics.checkNotNullParameter("card", "requestPage");
        Intrinsics.checkNotNullParameter("video_talk_room_guest_widget_profile_confirm", "from");
        Integer r0 = (Integer) ((ge1.a) hd0.c.f()).b;
        if (r0 != null) goto L6;
    L9:
        if (r0 != null) goto L12;
    L15:
        return;
    L12:
        if (r0.intValue() != 0) goto L15;
        apply(new sf0.a(0, 113, 0, 0, null, null, "video_talk_room_guest_widget_profile_confirm", 0, 0, 0, false, false, 0, null, null, 0, 524157));
        return;
    L6:
        if (r0.intValue() != 2) goto L9;
        f2.b(2131917547, 0);
        goto L15
    }

    @Override // rj0.l
    public final void r0(Context r5, IRoom r6, rj0.b r7) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r6, PbRequest.SwitchType.ROOM);
        Intrinsics.checkNotNullParameter(r7, "listener");
        OperateType r8 = OperateType.APPLY;
        com.bytedance.android.live.liveinteract.videotalk.u r9 = new com.bytedance.android.live.liveinteract.videotalk.u(r7);
        Intrinsics.checkNotNullParameter(r8, "operateType");
        Intrinsics.checkNotNullParameter(r9, "consumer");
        ArrayList r10 = new ArrayList();
        r10.add(qh0.g.a(r8, 2));
        r10.add(new qh0.f.g(((Widget) this).context, r8, 2));
        r10.add(new qh0.f.c(((Widget) this).context, r8, 2));
        r10.add(new qh0.f.a(((Widget) this).context));
        r10.add(new qh0.f.d(((Widget) this).context, r8, 2, true));
        r10.add(new qh0.f.C0257f(((Widget) this).context, r8, 2, true));
        r10.add(new qh0.f.e(((Widget) this).context, r8));
        qh0.f.a(r10).a(r9);
    }

    @Override // rj0.l
    public final void replyCPosition(long r15, String r17, boolean r18) {
        Intrinsics.checkNotNullParameter(r17, "toUid");
        TalkRoomBusinessFullLinkMonitor.a.getClass();
        TalkRoomBusinessFullLinkMonitor.v(r17, r18);
        long r9 = System.currentTimeMillis();
        LinkAudienceApi r0 = (LinkAudienceApi) com.bytedance.android.live.network.c.b().e(LinkAudienceApi.class);
        long r3 = d5.c(r17);
        if (r18 == false) goto L5;
        CPositionReplyType r1 = CPositionReplyType.Accept;
    L6:
        Disposable r2 = r0.replyCPosition(r15, r3, r17, r1.getValue()).compose(RxUtil.rxSchedulerHelper()).subscribe(new w(r17, r18, r9), new x(r17, r18, r9, r15));
        this.F.add(r2);
        return;
    L5:
        r1 = CPositionReplyType.Reject;
        goto L6
    }

    @Override // rj0.j
    public final void v(String r11, String r12, String r13) {
        Intrinsics.checkNotNullParameter(r11, "from");
        Intrinsics.checkNotNullParameter(r11, "from");
        String r0 = vm2.d.l().commentSchema;
        com.bytedance.android.live.revenue.platform.log.impl.filterimpl.a r1 = mz0.d.b(LogCommon.PAGE_SOURCE_LOG);
        String r3 = "";
        if (r1 == null) goto L8;
        Map r4 = r1.getMap();
        if (r4 == null) goto L8;
        String r5 = (String) r4.get("enter_from_merge");
        if (r5 == null) goto L8;
    L10:
        if (r1 == null) goto L15;
        Map r6 = r1.getMap();
        if (r6 == null) goto L15;
        String r7 = (String) r6.get("enter_method");
        if (r7 == null) goto L15;
    L17:
        if (r1 == null) goto L24;
        Map r2 = r1.getMap();
        if (r2 == null) goto L24;
        String r8 = (String) r2.get("action_type");
        if (r8 == null) goto L24;
        r3 = r8;
    L24:
        Pair[] r9 = new Pair[10];
        r9[0] = TuplesKt.to("service_provider_id", getMRoom().getOwnerUserIdString());
        r9[1] = TuplesKt.to("service_order_id", this.h);
        r9[2] = TuplesKt.to("room_id", String.valueOf(getMRoom().getId()));
        r9[3] = TuplesKt.to("anchor_id", getMRoom().getOwnerUserIdString());
        r9[4] = TuplesKt.to("live_type", "video_live");
        r9[5] = TuplesKt.to("enter_from_merge", r5);
        r9[6] = TuplesKt.to("enter_method", r7);
        r9[7] = TuplesKt.to("action_type", r3);
        if (je0.d.w() == false) goto L27;
        String r10 = "party";
    L28:
        r9[8] = TuplesKt.to("function_type", r10);
        com.bytedance.android.live.liveinteract.api.data.a.h.getClass();
        r9[9] = TuplesKt.to("limited_time", String.valueOf(com.bytedance.android.live.liveinteract.api.data.a.C0017a.k().b));
        String r14 = com.bytedance.android.livesdk.chatroom.y0.b(r0, MapsKt.plus(MapsKt.plus(MapsKt.mapOf(r9), TuplesKt.to("connection_time", String.valueOf(r12))), TuplesKt.to("connection_cost", String.valueOf(r13))));
        jy0.b.d("ttlive_link_paid", "showPaidLinkCommentDialog from=" + r11 + " commentSchema=" + r14);
        jc1.k.n(IBaseLiveActionHandler.class).handle(((Widget) this).context, r14);
        return;
    L27:
        r10 = "radio";
    L15:
        r7 = "";
    L8:
        r5 = "";
        goto L10
    }

    @Override // rj0.l
    public final void Cb(int r10, boolean r11, boolean r12, rj0.c r13) {
        xf6.b r0 = Tq();
        if (r0 == null) goto L6;
        r0.k(new wf6.b(null, r10, r11, r12, r13, 33));
        return;
    }

    public final void Lr(zj0.d r36, zj0.d r37, List r38, List r39) {
        if (r36 != null) goto L5;
    L11:
        boolean r4 = false;
    L12:
        com.bytedance.android.live.liveinteract.plantform.utils.i0 r5 = TalkRoomLogUtils.a;
        if (r36 == null) goto L15;
        Integer r7 = Integer.valueOf(r36.a);
    L16:
        if (r36 == null) goto L18;
        Integer r8 = Integer.valueOf(r36.b);
    L20:
        if (TalkRoomLogUtils.i(r7, r8, Integer.valueOf(r37.a), Integer.valueOf(r37.b), r38, r39) == false) goto L23;
        if (r4 == true) goto L23;
        return;
    L23:
        if (r36 == null) goto L25;
        Integer r6 = Integer.valueOf(r36.a);
    L26:
        if (r36 == null) goto L28;
        Integer r9 = Integer.valueOf(r36.b);
    L29:
        String r10 = TalkRoomLogUtils.p(r6, r9, null);
        String r11 = TalkRoomLogUtils.p(Integer.valueOf(r37.a), Integer.valueOf(r37.b), null);
        if (r36 == null) goto L32;
        Integer r12 = Integer.valueOf(r36.b);
    L33:
        String r13 = u0.j(r12);
        String r14 = u0.j(Integer.valueOf(r37.b));
        if (r36 == null) goto L36;
        Integer r15 = Integer.valueOf(r36.b);
    L37:
        if (r36 == null) goto L39;
        Integer r16 = Integer.valueOf(r36.a);
    L40:
        String r17 = u0.f(r15, r16, r38, null, null, null, 56);
        String r2 = u0.f(Integer.valueOf(r37.b), Integer.valueOf(r37.a), r39, null, null, null, 56);
        if (vm2.d.v0() == true) goto L43;
    L45:
        HashMap r32 = new HashMap();
        InteractiveSongLoggerKt.b(r32);
        if ((!Intrinsics.areEqual(r10, r11)) == true) goto L57;
        if (r4 == true) goto L57;
        if ((!Intrinsics.areEqual(r13, r14)) == false) goto L54;
        if (r13 == null) goto L75;
        TalkRoomLogUtils.Q(r13, r17, 1);
        return;
    L75:
        return;
    L54:
        if ((!Intrinsics.areEqual(r17, r2)) == false) goto L77;
        if (r17 == null) goto L78;
        TalkRoomLogUtils.Q(r13, r17, 1);
        return;
    L78:
        return;
    L77:
        return;
    L57:
        if (r10 != null) goto L59;
        return;
    L59:
        if (hd0.c.f().h() == false) goto L73;
        String r18 = this.x.a;
        Long r19 = Long.valueOf(hr());
        Long r110 = Long.valueOf(jr());
        int r111 = Mq();
        LinkApplyType r112 = this.A;
        boolean r3 = Pq();
        com.bytedance.android.live.liveinteract.plantform.core.y r20 = Aq();
        if (r20 == null) goto L63;
        Integer r21 = Integer.valueOf(je0.d.j(r20));
    L64:
        String r22 = String.valueOf(r21.intValue());
        if (r22 != null) goto L67;
        r22 = "0";
    L67:
        String r113 = r22;
        IRoom r114 = getMRoom();
        String r115 = fr();
        if (r36 == null) goto L70;
        Integer r1 = Integer.valueOf(r36.b);
    L71:
        TalkRoomLogUtils.Z(r18, r19, null, r110, r111, r112, r3, r113, r114, "anchor", r115, r10, r13, u0.h(r1, r38), wr(), l5(), gr(), String.valueOf(this.V2.b), vr(), this.Y, this.P0, this.V0, this.x, r32, qr(), 67108864);
        goto L73
    L70:
        r1 = null;
        goto L71
    L63:
        r21 = null;
    L73:
        this.z = null;
        TalkRoomLogUtils.P(r10, r13, r17);
        return;
    L43:
        if (TextUtils.isEmpty(TalkRoomLogUtils.j) == true) goto L45;
        r10 = TalkRoomLogUtils.j;
        goto L45
    L39:
        r16 = null;
        goto L40
    L36:
        r15 = null;
        goto L37
    L32:
        r12 = null;
        goto L33
    L28:
        r9 = null;
        goto L29
    L25:
        r6 = null;
        goto L26
    L18:
        r8 = null;
        goto L20
    L15:
        r7 = null;
        goto L16
    L5:
        if (r36.a != 8) goto L11;
        if (r36.b != 7) goto L11;
        if (((IInteractService) jc1.k.n(IInteractService.class)).dynamicFromAudienceGuestCache() == false) goto L11;
        r4 = true;
        goto L12
    }

    @Override // rj0.l
    public final void So(int r2, rj0.a r3, String r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r4, "eventPage");
        Yq(r2, r3, r4, r5);
    }

    public final void Te(VideoShowMode r25, VideoShowMode r26, lh6.b.b r27, String r28) {
        Intrinsics.checkNotNullParameter(r25, "newShowMode");
        Intrinsics.checkNotNullParameter(r26, "oldShowMode");
        int r0 = com.bytedance.android.live.liveinteract.videotalk.p.b[r25.ordinal()];
        if (r0 != 1) goto L5;
        int r15 = 1;
    L13:
        VideoShowMode r1 = VideoShowMode.VIDEO;
        if (r26 != r1) goto L16;
    L19:
        boolean r2 = true;
    L20:
        if (r25 != r1) goto L22;
    L25:
        boolean r16 = true;
    L26:
        if (r2 == false) goto L28;
        boolean r3 = false;
    L29:
        jy0.b.d("KtvDigitAvatar", "openShowMode: " + r26 + " -> " + r25 + ", needCameraPermission=" + r3);
        int r4 = com.bytedance.android.live.liveinteract.plantform.utils.x.a;
        String r5 = r26.name();
        String r6 = r25.name();
        m00.g r7 = this.U;
        if (r7 != null) goto L32;
    L34:
        boolean r8 = false;
    L35:
        Intrinsics.checkNotNullParameter(r5, "fromMode");
        Intrinsics.checkNotNullParameter(r6, "toMode");
        LinkedHashMap r9 = new LinkedHashMap();
        r9.put("from", r5);
        r9.put("to", r6);
        r9.put("curHaveCameraPermission", Boolean.valueOf(r2));
        r9.put("needCameraPermission", Boolean.valueOf(r3));
        r9.put("cameraOpen", Boolean.valueOf(r8));
        com.bytedance.android.live.liveinteract.plantform.utils.x.t0("digit_avatar_video_open_show_mode", r9);
        TalkRoomBusinessFullLinkMonitor r10 = TalkRoomBusinessFullLinkMonitor.a;
        String r11 = r26.name();
        String r14 = r25.name();
        m00.g r12 = this.U;
        if (r12 != null) goto L38;
    L40:
        boolean r13 = false;
    L41:
        r10.getClass();
        Intrinsics.checkNotNullParameter(r11, "fromMode");
        Intrinsics.checkNotNullParameter(r14, "toMode");
        JSONObject r17 = new JSONObject();
        r17.put("from", r11);
        r17.put("to", r14);
        r17.put("curHaveCameraPermission", r2);
        r17.put("needCameraPermission", r3);
        r17.put("cameraOpen", r13);
        nd0.c.o(nd0.c.a, LinkMonitorData.AvatarOpenShowModeMonitorData, r17, 0, null, false, 28);
        ArrayList r18 = new ArrayList();
        if (r3 == false) goto L48;
        Context r19 = ((Widget) this).context;
        if (r19 != null) goto L46;
        r19 = s1.getContext();
    L46:
        r18.add(new qh0.f.b(r19, OperateType.APPLY, r15));
    L48:
        if (((Boolean) vm2.h.q6.getValue(null, vm2.h.a[379(0x17b, float:5.31E-43)])).booleanValue() == false) goto L53;
        if (Intrinsics.areEqual(r28, "online") == false) goto L53;
        boolean r20 = true;
    L54:
        if (r20 == true) goto L63;
        Context r21 = ((Widget) this).context;
        if (r21 != null) goto L58;
        r21 = s1.getContext();
    L58:
        Context r22 = r21;
        OperateType r23 = OperateType.APPLY;
        IRoom r24 = getMRoom();
        String r29 = je0.d.b0();
        DigitAvatarContext r30 = DigitAvatarContext.Companion.getContext();
        if (r30 == null) goto L61;
        String r31 = r30.getUpdateShowModeSource();
    L62:
        r18.add(new qh0.f.h(r22, r23, r15, 16, r24, r29, r31, this, null, 1216));
        goto L63
    L61:
        r31 = null;
    L63:
        com.bytedance.android.live.liveinteract.plantform.permission.checker.s r32 = qh0.f.a(r18);
        if (aj0.a.a(r15, getMRoom()) == true) goto L66;
    L68:
        r32.a(new com.bytedance.android.live.liveinteract.videotalk.y(this, r27, r25, r26, r28, r15, r16));
    L70:
        if (aj0.a.a(r15, getMRoom()) == false) goto L79;
        cg6.a r33 = Bq();
        if (r33 == null) goto L80;
        jg6.a r34 = r33.e5();
        if (r34 == null) goto L81;
        lh6.b r35 = r34.a();
        if (r35 == null) goto L82;
        r35.n(5, true, "openShowMode to audio");
        return;
    L82:
        return;
    L81:
        return;
    L80:
        return;
    L79:
        return;
    L66:
        if (r25.getSource() == 1) goto L68;
        ALogger.e("MultiLinkVideoTalkRoomGuestWidget", "in room fight enlarge layout, intercept update link type audio update");
        dr(r25, r26, r27, r15, r16);
    L53:
        r20 = false;
        goto L54
    L38:
        if (r12.isCameraOpen() != true) goto L40;
        r13 = true;
        goto L41
    L32:
        if (r7.isCameraOpen() != true) goto L34;
        r8 = true;
        goto L35
    L28:
        r3 = r16;
        goto L29
    L22:
        if (r25 == VideoShowMode.DIGIT_AVATAR) goto L25;
        r16 = false;
        goto L26
    L16:
        if (r26 == VideoShowMode.DIGIT_AVATAR) goto L19;
        r2 = false;
        goto L20
    L5:
        if (r0 != 2) goto L7;
        r15 = 2;
        goto L13
    L7:
        if (r0 != 3) goto L10;
        r15 = 3;
        goto L13
    L10:
        throw new NoWhenBranchMatchedException();
    }

    @Override // rj0.l
    public final void X3(long r13, String r15, String r16, int r17) {
        Intrinsics.checkNotNullParameter(r15, "secToUserId");
        Intrinsics.checkNotNullParameter(r16, "toUserIdString");
        Intrinsics.checkNotNullParameter(r15, "secToUserId");
        Intrinsics.checkNotNullParameter(r16, "toUserIdString");
        this.C = false;
        xf6.b r10 = Tq();
        if (r10 == null) goto L6;
        r10.c(new sf0.e(r13, r15, r16, r17, 2, 32, 0));
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.MultiLinkBaseGuestLinkWidget, com.bytedance.android.live.liveinteract.plantform.core.v
    public final void b4(String r3, uf2.z.a r4, int r5, int r6) {
        jy0.b.a(LinkRoomFightContext.TAG, "onFirstRemoteVideoFrame linkId " + r3 + " layer");
        super.b4(r3, r4, r5, r6);
        tf0.o r7 = this.T;
        if (r7 == null) goto L6;
        r7.b(r3);
        return;
    }

    public final void br(int r6, Function0<Unit> r7, Function1<? super Throwable, Unit> r8, int r9) {
        long r0 = System.currentTimeMillis();
        RxUtilKt.c(((LinkApi) com.bytedance.android.live.network.c.b().e(LinkApi.class)).applyStash(getMRoom().getRoomId(), r6, r9).compose(RxUtil.rxSchedulerHelper()).subscribe(new b(r7, r6, r0), new c(r8, r6, r0)), this.F);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.widgt.MultiLinkBaseGuestLinkWidget, com.bytedance.android.live.liveinteract.plantform.core.v
    public final void h1(String r3, SurfaceView r4, int r5, int r6) {
        jy0.b.a(LinkRoomFightContext.TAG, "onFirstRemoteVideoFrame linkId " + r3 + " surfaceview");
        super.h1(r3, r4, r5, r6);
        this.h1.put(r3, r4);
        if (r4 == null) goto L5;
        r4.setTag(new Pair(Integer.valueOf(r5), Integer.valueOf(r6)));
    L5:
        tf0.o r7 = this.T;
        if (r7 == null) goto L9;
        r7.b(r3);
    L9:
        if (Intrinsics.areEqual(r3, tc0.c.h().e) == false) goto L11;
        this.W.put(r3, r4);
        return;
    L11:
        com.bytedance.android.livesdk.message.linker.b r8 = tc0.c.h().A;
        if (r8 != null) goto L14;
        return;
    L14:
        if (Intrinsics.areEqual(r3, r8.getLinkmicIdStr()) == false) goto L19;
        this.W.put(r3, r4);
        return;
    }

    @Override // rj0.l, rj0.o
    public final void j1(int r17, Integer r18, String r19, Boolean r20) {
        jy0.b.d("ttlive_link_video", "try switchScene to scene=" + r17 + " uiLayout=" + r18 + " reason=" + r19 + ", current:" + ur());
        com.bytedance.android.livesdk.chatroom.viewmodel.j r0 = ur();
        if (r0 == null) goto L5;
        int r13 = r0.a;
    L6:
        ur();
        com.bytedance.android.livesdk.chatroom.viewmodel.j r1 = ur();
        if (r1 == null) goto L10;
        List<Integer> r2 = r1.b;
        if (r2 == null) goto L10;
    L11:
        zj0.e r3 = this.X2;
        if (r3 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("layoutSwitcher");
    L15:
        if (r3.d(r17, r18, r2) == false) goto L19;
        jy0.b.c("ttlive_link_video", "no switchScene, same layout " + ur() + ' ' + kr(), null, 4);
        return;
    L19:
        if (r17 != 8) goto L37;
        if (this.b1.size() <= 7) goto L37;
        if (((rj1) bc0.a.getValue()).a() != true) goto L25;
        f2.b(2131915467, 0);
    L26:
        HashMap r4 = new HashMap();
        r4.put("live_type", "video_live");
        com.bytedance.live.datacontext.j r5 = com.bytedance.android.live.liveinteract.api.utils.m.e(this).getVideoTalkRoomSubScene();
        if (r5 == null) goto L33;
        com.bytedance.android.livesdk.chatroom.viewmodel.e r6 = (com.bytedance.android.livesdk.chatroom.viewmodel.e) r5.getValue();
        if (r6 == null) goto L33;
        com.bytedance.android.livesdk.chatroom.viewmodel.j r7 = r6.t();
        if (r7 == null) goto L33;
        Integer r8 = Integer.valueOf(r7.a);
    L34:
        TalkRoomLogUtils.B0(r4, r8, null, 4);
        TalkRoomLogUtils.Q0(r4);
        mz0.n r9 = new mz0.n();
        Map r10 = r9.a;
        Intrinsics.checkNotNullParameter(r10, "map");
        Intrinsics.checkNotNullParameter(r4, "map");
        r10.putAll(r4);
        mz0.m r11 = new mz0.m();
        r11.b(LogCommon.ROOM);
        ((ArrayList) r9.b).addAll(r11.a);
        cy0.e.a.getClass();
        cy0.j r12 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r14 = com.bytedance.android.scope.m.b(r12).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r14);
        ((f80.a) r14).w3("livesdk_anchor_audience_connection_layout_change_toast_show", r9.a, r9.b);
        return;
    L33:
        r8 = null;
        goto L34
    L25:
        f2.b(2131915466, 0);
    L37:
        if (this.d3 == false) goto L39;
        return;
    L39:
        this.d3 = true;
        long r15 = System.currentTimeMillis();
        LinkApi r16 = (LinkApi) com.bytedance.android.live.network.c.b().e(LinkApi.class);
        long r21 = getMRoom().getId();
        long r22 = getMRoom().getId();
        if (r18 == null) goto L42;
        int r23 = r18.intValue();
    L43:
        Single r24 = r16.switchScene(r21, r22, r13, r17, r23, r19).subscribeOn(Schedulers.io()).flatMap(d0.a).observeOn(AndroidSchedulers.mainThread());
        int r25 = r13;
        this.F.add(r24.subscribe(new e0(this, r25, r17, r18, r19, r15, r20), new f0(this, r25, r17, r18, r19, r15)));
        return;
    L42:
        r23 = 0;
    L10:
        r2 = CollectionsKt.emptyList();
        goto L11
    L5:
        r13 = 8;
        goto L6
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.base.k
    public final void setCPosition(long r17, String r19, boolean r20, String r21) {
        Intrinsics.checkNotNullParameter(r19, "toUid");
        Intrinsics.checkNotNullParameter(r21, "enlargeTypeForLog");
        if (r20 == false) goto L5;
        com.bytedance.android.live.liveinteract.plantform.utils.i0 r2 = TalkRoomLogUtils.a;
        TalkRoomLogUtils.X(false, r19, r21);
    L10:
        long r11 = CPositionToEnlargePosition.Default.getValue();
        long r13 = System.currentTimeMillis();
        TalkRoomBusinessFullLinkMonitor.a.getClass();
        TalkRoomBusinessFullLinkMonitor.s(r19, r20, r11);
        LinkAudienceApi r0 = (LinkAudienceApi) com.bytedance.android.live.network.c.b().e(LinkAudienceApi.class);
        long r3 = d5.c(r19);
        if (r20 == false) goto L13;
        int r6 = 1;
    L14:
        Disposable r1 = r0.setCPosition(r17, r3, r19, r6, r11).compose(RxUtil.rxSchedulerHelper()).subscribe(new y(r19, r20, r11, r13), new z(r19, r20, r11, r13, r17));
        this.F.add(r1);
        return;
    L13:
        r6 = 2;
        goto L14
    L5:
        boolean r4 = Intrinsics.areEqual(r19, je0.d.a());
        com.bytedance.android.live.liveinteract.plantform.utils.i0 r5 = TalkRoomLogUtils.a;
        if (r4 == false) goto L8;
        String r7 = "anchor";
    L9:
        TalkRoomLogUtils.W(false, r7);
        goto L10
    L8:
        r7 = "guest";
        goto L9
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.base.k
    public final void updateMultiEnlargePosition(long r16, String r18, long r19, String r21) {
        Intrinsics.checkNotNullParameter(r18, "targetUserId");
        Intrinsics.checkNotNullParameter(r21, "enlargeTypeForLog");
        com.bytedance.android.live.liveinteract.plantform.utils.i0 r0 = TalkRoomLogUtils.a;
        TalkRoomLogUtils.X(false, r18, r21);
        TalkRoomBusinessFullLinkMonitor.a.getClass();
        TalkRoomBusinessFullLinkMonitor.s(r18, true, r19);
        long r13 = System.currentTimeMillis();
        Disposable r1 = ((LinkAudienceApi) com.bytedance.android.live.network.c.b().e(LinkAudienceApi.class)).setCPosition(r16, d5.c(r18), r18, CPositionInviteType.Enlarge.getValue(), r19).compose(RxUtil.rxSchedulerHelper()).subscribe(new j0(r18, r19, r13, r21), new k0(r18, r19, r13));
        this.F.add(r1);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.base.k
    public final void v0(int r11, String r12, int r13, String r14) {
        Intrinsics.checkNotNullParameter(r12, "requestPage");
        if (jc1.k.n(IMiddlewareUserService.class).user().c() == false) goto L8;
        ((Widget) this).dataCenter.put("data_task_name_when_open_invite_panel", r14);
        ILinkPanelService r2 = com.bytedance.android.live.liveinteract.component.b.a();
        if (r2 == null) goto L9;
        r2.C70(((Widget) this).context, ((Widget) this).dataCenter, r11, r12, r13, getMRoom(), this);
        return;
    L9:
        return;
    }

    @Override // zj0.b
    public final void Ic(zj0.d r17, zj0.d.b r18, List r19, List r20, zj0.c r21) {
        Intrinsics.checkNotNullParameter(r18, "to");
        Intrinsics.checkNotNullParameter(r21, "switchType");
        if (r17 == null) goto L10;
        if (r17.a == r18.a) goto L10;
        Aq().L();
        com.bytedance.android.live.liveinteract.utils.g0 r6 = this.L0;
        if (r6 == null) goto L10;
        r6.a(r17.a, Integer.valueOf(r17.b), r18.a, Integer.valueOf(r18.b));
    L10:
        if (r18.a != 16) goto L12;
        zi0.e r7 = zi0.b.d;
        com.bytedance.android.livesdk.utils.ntp.e.a();
        r7.getClass();
    L12:
        Lr(r17, r18, r19, r20);
        HashMap r8 = new HashMap();
        r8.put("live_type", "video_live");
        Long r9 = rr();
        r8.put("duration", String.valueOf(r9));
        TalkRoomLogUtils.B0(r8, Integer.valueOf(mr()), null, 4);
        TalkRoomLogUtils.W0(r8, Boolean.valueOf(kr().isDynamic()));
        boolean r10 = false;
        if (this.R == false) goto L15;
        r8.put("play_type", "video_friend");
        this.R = false;
    L15:
        tf0.o r11 = this.T;
        if (r11 != null) goto L18;
    L20:
        IRoom r12 = getMRoom();
        if (r12 == null) goto L27;
        ICircleInfo r13 = r12.getCircleInfo();
        if (r13 == null) goto L27;
        String r14 = r13.getCircleName();
        if (r14 == null) goto L27;
        r8.put("circle_name", r14);
    L27:
        com.bytedance.android.live.liveinteract.plantform.utils.i0 r15 = TalkRoomLogUtils.a;
        TalkRoomLogUtils.w0(r8);
        com.bytedance.android.live.liveinteract.plantform.core.y r16 = Aq();
        if (r16 != null) goto L30;
    L34:
        TalkRoomLogUtils.d1(r8, ((Widget) this).dataCenter);
        tf0.o r22 = this.T;
        if ((r22 instanceof MultiLinkVideoTeamFightWindowManager) == false) goto L37;
        r8.put("grouppk_duration", String.valueOf(r9));
        li0.b r23 = li0.b.b;
        ((MultiLinkVideoTeamFightWindowManager) r22).getClass();
        r8.put("grouppk_stage", li0.b.c(MultiLinkVideoTeamFightWindowManager.q1()));
    L37:
        TalkRoomLogUtils.T0(r8, false);
        if (r17 != null) goto L40;
    L46:
        boolean r110 = false;
    L47:
        Intrinsics.checkNotNullParameter(r18, "to");
        Intrinsics.checkNotNullParameter(r21, "switchType");
        com.bytedance.live.datacontext.m r3 = com.bytedance.android.live.liveinteract.api.utils.m.d().m();
        if (r3 != null) goto L50;
    L52:
        if (r17 != null) goto L55;
    L81:
        if (r10 == true) goto L84;
        if (r110 == true) goto L84;
        return;
    L84:
        if (com.bytedance.android.live.liveinteract.voicechat.util.e.a(true) == false) goto L86;
        r8.put("is_pre_link", "1");
    L87:
        TalkRoomLogUtils.O0(r8);
        com.bytedance.android.live.liveinteract.linkcast.g.b.getClass();
        com.bytedance.android.live.liveinteract.linkcast.g.a.f(r8, null);
        if (vm2.d.v0() == false) goto L96;
        String r4 = TalkRoomLogUtils.j;
        if (r4 != null) goto L92;
        r4 = TalkRoomLogUtils.h;
    L92:
        r8.put("function_type2", r4);
        String r5 = TalkRoomLogUtils.j;
        if (r5 != null) goto L95;
        r5 = TalkRoomLogUtils.h;
    L95:
        r8.put("function_type", r5);
    L105:
        if (vm2.h.R() == false) goto L107;
        r8.put("room_id", String.valueOf(getMRoom().getId()));
        r8.put("anchor_id", String.valueOf(getMRoom().getAnchorId()));
        LiveMode r24 = getMRoom().getStreamType();
        int r25 = com.bytedance.android.live.core.utils.h1.a;
        r8.put("live_type", i1.a(r24));
    L107:
        r8.put("play_mode", u0.b());
        int r26 = com.bytedance.android.live.liveinteract.plantform.multiroom.b.a;
        if (com.bytedance.android.live.liveinteract.plantform.multiroom.b.a(((Widget) this).dataCenter, (String) r8.get("function_type2"), "MultiLinkVideoTalkRoomGuestWidget#beforeSwitchWindowLayout from=" + r17 + ", to=" + r18) == false) goto L113;
        HashMap r1 = new HashMap();
        r1.put("ui_widget_source", "FallbackLog on switch");
        if (vm2.h.R() == false) goto L112;
        r1.put("room_id", String.valueOf(getMRoom().getId()));
        r1.put("anchor_id", String.valueOf(getMRoom().getAnchorId()));
        LiveMode r2 = getMRoom().getStreamType();
        int r27 = com.bytedance.android.live.core.utils.h1.a;
        r1.put("live_type", i1.a(r2));
    L112:
        Kr("livesdk_audience_voice_room_show", r1);
        com.bytedance.android.live.liveinteract.plantform.multiroom.b.b(((Widget) this).dataCenter, "MultiLinkVideoTalkRoomGuestWidget#beforeSwitchWindowLayout");
    L113:
        mz0.n r28 = new mz0.n();
        Map r29 = r28.a;
        Intrinsics.checkNotNullParameter(r29, "map");
        Intrinsics.checkNotNullParameter(r8, "map");
        r29.putAll(r8);
        mz0.m r30 = new mz0.m();
        r30.b(LogCommon.ROOM);
        r30.b(LogCommon.PAGE_SOURCE_LOG);
        r30.b(LogCommon.GAME_PARAM_ITEM);
        ((ArrayList) r28.b).addAll(r30.a);
        cy0.e.a.getClass();
        cy0.j r31 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r32 = com.bytedance.android.scope.m.b(r31).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r32);
        ((f80.a) r32).w3("livesdk_voice_room_watch_duration", r28.a, r28.b);
        TalkRoomLogUtils.p0(r8, sr());
        TalkRoomLogUtils.q0(r8, tr());
        this.E2 = System.currentTimeMillis();
        return;
    L96:
        if (r17 == null) goto L105;
        if (r17.a != 8) goto L105;
        if (r17.b != 7) goto L105;
        if (((IInteractService) jc1.k.n(IInteractService.class)).dynamicFromAudienceGuestCache() == false) goto L105;
        r8.put("function_type2", "new_audience");
        r8.put("function_type", "new_audience");
        goto L105
    L86:
        r8.put("is_pre_link", "0");
        goto L87
    L55:
        if (r17.b() == true) goto L81;
        if (r18.b() == true) goto L81;
        if (r17.c() == true) goto L81;
        if (r18.c() == true) goto L81;
        if (r17.isDynamic() == true) goto L79;
        if (r18.isDynamic() == true) goto L79;
        if (com.bytedance.android.livesdk.chatroom.interact.model.e0.a(r17.b) == true) goto L72;
    L80:
        r10 = true;
        goto L81
    L72:
        if (com.bytedance.android.livesdk.chatroom.interact.model.e0.a(r18.b) == false) goto L80;
        if (com.bytedance.android.livesdk.chatroom.interact.model.d0.e(r19) == false) goto L80;
        if (com.bytedance.android.livesdk.chatroom.interact.model.d0.e(r20) == false) goto L80;
    L79:
        if (r17.a == r18.a) goto L81;
    L50:
        if (((Boolean) r3.getValue()).booleanValue() != true) goto L52;
    L40:
        if (r17.a != 8) goto L46;
        if (r17.b != 7) goto L46;
        if (((IInteractService) jc1.k.n(IInteractService.class)).dynamicFromAudienceGuestCache() == false) goto L46;
        r110 = true;
        goto L47
    L30:
        if (r16.n() <= 0) goto L32;
        Object r111 = "1";
    L33:
        r8.put("is_set_seat_name", r111);
        r8.put("seat_num", String.valueOf(r16.n()));
        goto L34
    L32:
        r111 = "0";
        goto L33
    L18:
        if (r11.J() != true) goto L20;
        ii0.a.a(r8);
        goto L20
    }

    @Override // zj0.b
    public final void Jm(zj0.d r40, zj0.d.b r41, List r42, List r43, zj0.c r44) {
        Intrinsics.checkNotNullParameter(r41, "to");
        Intrinsics.checkNotNullParameter(r44, "switchType");
        if (r41.a != 12) goto L5;
        boolean r6 = true;
    L6:
        if (r6 == false) goto L9;
        InteractMode r7 = InteractMode.EQUAL_TALK_ROOM;
    L12:
        com.bytedance.android.livesdk.chatroom.utils.g0.d(r41.b);
        com.bytedance.android.livesdk.chatroom.utils.g0.c(r41.a);
        if (r40 != null) goto L15;
    L21:
        boolean r11 = false;
    L22:
        com.bytedance.android.live.liveinteract.plantform.utils.i0 r12 = TalkRoomLogUtils.a;
        if (r40 == null) goto L25;
        Integer r14 = Integer.valueOf(r40.a);
    L26:
        if (r40 == null) goto L28;
        Integer r15 = Integer.valueOf(r40.b);
    L30:
        if (TalkRoomLogUtils.i(r14, r15, Integer.valueOf(r41.a), Integer.valueOf(r41.b), r42, r43) == false) goto L33;
        if (r11 == true) goto L33;
        String r38 = "0";
    L81:
        hg6.g r3 = P2();
        if (r3 == null) goto L84;
        r3.a(r7);
    L84:
        hg6.g r4 = P2();
        if (r4 == null) goto L87;
        r4.D(r41.a, "videoGuest#afterSwitchWindowLayout");
    L87:
        int r5 = r41.a;
        boolean r8 = ((IInteractService) jc1.k.n(IInteractService.class)).dynamicFromAudienceGuestCache();
        if (((IInteractService) jc1.k.n(IInteractService.class)).dynamicFromAudience() == true) goto L90;
    L94:
        boolean r9 = false;
    L95:
        if (r9 == true) goto L97;
        ((IInteractService) jc1.k.n(IInteractService.class)).setDynamicFromAudienceGuestCache(false);
    L97:
        MultiRevenueDataContext.a r10 = MultiRevenueDataContext.Companion;
        r10.getClass();
        com.bytedance.android.live.liveinteract.chatroom.chatroom.playmode.a r13 = MultiRevenueDataContext.a.d();
        if (r13 == null) goto L100;
        r13.d4(r5, r41.b);
    L100:
        HashMap r16 = new HashMap();
        r16.put("live_type", "video_live");
        TalkRoomLogUtils.y0(r16, false);
        TalkRoomLogUtils.B0(r16, Integer.valueOf(r5), null, 4);
        TalkRoomLogUtils.W0(r16, Boolean.valueOf(kr().isDynamic()));
        TalkRoomLogUtils.Q0(r16);
        TalkRoomLogUtils.T0(r16, true);
        IRoom r17 = getMRoom();
        if (r17 == null) goto L107;
        ICircleInfo r18 = r17.getCircleInfo();
        if (r18 == null) goto L107;
        String r19 = r18.getCircleName();
        if (r19 == null) goto L107;
        r16.put("circle_name", r19);
    L107:
        com.bytedance.android.live.liveinteract.linkcast.g.b.getClass();
        com.bytedance.android.live.liveinteract.linkcast.g.a.f(r16, null);
        if (r40 != null) goto L110;
    L115:
        boolean r20 = false;
    L116:
        Intrinsics.checkNotNullParameter(r41, "to");
        Intrinsics.checkNotNullParameter(r44, "switchType");
        if (r40 != null) goto L120;
    L146:
        boolean r21 = false;
    L147:
        if (r21 == true) goto L149;
        if (r20 == true) goto L149;
    L174:
        if (fj0.c.a() == false) goto L178;
        r10.getClass();
        com.bytedance.android.live.liveinteract.revenuebase.c r22 = MultiRevenueDataContext.a.c();
        if (r22 == null) goto L178;
        r22.b();
    L178:
        SpatialAudioContext r23 = SpatialAudioContext.Companion.getContext();
        if (r23 == null) goto L187;
        com.bytedance.live.datacontext.m<Integer> r24 = r23.getCurrentStrategyId();
        if (r24 == null) goto L187;
        tf0.o r25 = this.T;
        if (r25 == null) goto L185;
        int r26 = r25.C0();
    L186:
        r24.setValue(Integer.valueOf(r26));
        goto L187
    L185:
        r26 = -1;
    L187:
        DataCenter r27 = ((Widget) this).dataCenter;
        String r28 = "linkmic";
        int r29 = r41.a;
        int r2 = r41.b;
        List<Integer> r110 = u0.d();
        if (r40 == null) goto L190;
        int r111 = r40.a;
    L191:
        if (r40 == null) goto L193;
        int r210 = r40.b;
    L194:
        if (r42 == null) goto L197;
        List r1 = CollectionsKt.toList(r42);
        if (r1 == null) goto L197;
    L198:
        r27.put("data_multi_lick_dynamic_event_change", new nh0.f(r28, new nh0.e(r29, r2, r110, r111, r210, r1, null, null, 192), null, null, null, null, false, 252));
        return;
    L197:
        r1 = CollectionsKt.emptyList();
        goto L198
    L193:
        r210 = -1;
        goto L194
    L190:
        r111 = -1;
    L149:
        TalkRoomLogUtils.O0(r16);
        LogCommon r30 = LogCommon.PAGE_SOURCE_LOG;
        mz0.f r31 = mz0.d.b(r30);
        if ((r31 instanceof mz0.f) == false) goto L164;
        mz0.f r32 = r31;
        String r33 = r32.getRoomTag();
        if (r33 == null) goto L164;
        if (r33.length() <= 0) goto L156;
        boolean r34 = true;
    L158:
        if (r34 != true) goto L164;
        String r35 = r32.getRoomTag();
        if (r35 != null) goto L162;
        r35 = "";
    L162:
        r16.put("room_tag", r35);
        goto L164
    L156:
        r34 = false;
    L164:
        if (((IInteractService) jc1.k.n(IInteractService.class)).dynamicFromAudience() == false) goto L167;
        r16.put("function_type2", "new_audience");
    L167:
        if (us1.e.a == false) goto L170;
        r16.put("is_from_audience", r38);
    L170:
        if (vm2.h.R() == false) goto L172;
        r16.put("room_id", String.valueOf(getMRoom().getId()));
        r16.put("anchor_id", String.valueOf(getMRoom().getAnchorId()));
        LiveMode r36 = getMRoom().getStreamType();
        int r37 = com.bytedance.android.live.core.utils.h1.a;
        r16.put("live_type", i1.a(r36));
    L172:
        r16.put("play_mode", u0.b());
        mz0.n r39 = new mz0.n();
        Map r45 = r39.a;
        Intrinsics.checkNotNullParameter(r45, "map");
        Intrinsics.checkNotNullParameter(r16, "map");
        r45.putAll(r16);
        mz0.m r46 = new mz0.m();
        r46.b(LogCommon.ROOM);
        r46.b(r30);
        r46.b(LogCommon.GAME_PARAM_ITEM);
        ((ArrayList) r39.b).addAll(r46.a);
        cy0.e.a.getClass();
        cy0.j r47 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r48 = com.bytedance.android.scope.m.b(r47).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r48);
        ((f80.a) r48).w3("livesdk_audience_voice_room_show", r39.a, r39.b);
        int r49 = com.bytedance.android.live.liveinteract.plantform.multiroom.b.a;
        com.bytedance.android.live.liveinteract.plantform.multiroom.b.c(((Widget) this).dataCenter, "live", "MultiLinkVideoTalkRoomGuestWidget#afterSwitchWindowLayout from=" + r40 + ", to=" + r41);
        TalkRoomLogUtils.n0(r16);
        TalkRoomLogUtils.o0(r16);
        Intrinsics.checkNotNullParameter(r16, "logMap");
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_audience_voice_room_show_v4", new HashMap(r16), new Object[]{IRoom.class, am2.x.class});
        goto L174
    L120:
        if (r40.b() == true) goto L146;
        if (r41.b() == true) goto L146;
        if (r40.c() == true) goto L146;
        if (r41.c() == true) goto L146;
        if (r40.isDynamic() == true) goto L144;
        if (r41.isDynamic() == true) goto L144;
        if (com.bytedance.android.livesdk.chatroom.interact.model.e0.a(r40.b) == true) goto L137;
    L145:
        r21 = true;
        goto L147
    L137:
        if (com.bytedance.android.livesdk.chatroom.interact.model.e0.a(r41.b) == false) goto L145;
        if (com.bytedance.android.livesdk.chatroom.interact.model.d0.e(r42) == false) goto L145;
        if (com.bytedance.android.livesdk.chatroom.interact.model.d0.e(r43) == false) goto L145;
    L144:
        if (r40.a == r41.a) goto L146;
    L110:
        if (r40.a != 8) goto L115;
        if (r40.b != 7) goto L115;
        if (r8 == false) goto L115;
        r20 = true;
        goto L116
    L90:
        if (r41.a != 8) goto L94;
        if (r41.b != 7) goto L94;
        r9 = true;
    L33:
        if (r40 == null) goto L35;
        Integer r112 = Integer.valueOf(r40.a);
    L36:
        if (r40 == null) goto L38;
        Integer r113 = Integer.valueOf(r40.b);
    L39:
        String r114 = TalkRoomLogUtils.p(r112, r113, null);
        String r115 = TalkRoomLogUtils.p(Integer.valueOf(r41.a), Integer.valueOf(r41.b), null);
        if (r40 == null) goto L42;
        Integer r116 = Integer.valueOf(r40.b);
    L43:
        String r117 = u0.j(r116);
        String r118 = u0.j(Integer.valueOf(r41.b));
        if (r40 == null) goto L46;
        Integer r119 = Integer.valueOf(r40.b);
    L47:
        if (r40 == null) goto L49;
        Integer r120 = Integer.valueOf(r40.a);
    L50:
        String r50 = u0.f(r119, r120, r42, null, null, null, 56);
        String r51 = u0.f(Integer.valueOf(r41.b), Integer.valueOf(r41.a), r43, null, null, null, 56);
        if ((!Intrinsics.areEqual(r114, r115)) == true) goto L62;
        if (r11 == true) goto L62;
        if ((!Intrinsics.areEqual(r117, r118)) == false) goto L58;
        TalkRoomLogUtils.S(r118, r51, 1);
    L60:
        r38 = "0";
    L80:
        this.H2 = false;
        goto L81
    L58:
        if ((!Intrinsics.areEqual(r50, r51)) == false) goto L60;
        TalkRoomLogUtils.S(r118, r51, 1);
    L62:
        if (hd0.c.f().h() == true) goto L64;
    L78:
        r38 = "0";
    L79:
        TalkRoomLogUtils.R(r115, r118, r51);
        goto L80
    L64:
        if (this.H2 == true) goto L78;
        String r52 = this.x.a;
        Long r121 = Long.valueOf(jr());
        int r122 = this.y;
        boolean r211 = Pq();
        boolean r123 = this.B;
        IRoom r212 = getMRoom();
        String r213 = u0.h(Integer.valueOf(r41.b), r43);
        com.bytedance.android.live.liveinteract.plantform.core.y r124 = Aq();
        if (r124 == null) goto L68;
        Integer r125 = Integer.valueOf(je0.d.j(r124));
    L69:
        String r126 = String.valueOf(r125.intValue());
        if (r126 != null) goto L72;
        String r214 = "0";
    L73:
        boolean r127 = this.C;
        boolean r215 = l5();
        r38 = "0";
        if (((Boolean) ((Widget) this).dataCenter.get("data_link_mic_is_quick_invite", Boolean.FALSE)).booleanValue() == false) goto L76;
        String r310 = "1";
    L77:
        TalkRoomLogUtils.b0(r52, null, r121, r122, r211, r123, r212, r115, r118, r213, r214, r127, r215, r310, wr(), this.Y, this.x, null, qr(), this.A, 262144);
        goto L79
    L76:
        r310 = r38;
        goto L77
    L72:
        r214 = r126;
        goto L73
    L68:
        r125 = null;
        goto L69
    L49:
        r120 = null;
        goto L50
    L46:
        r119 = null;
        goto L47
    L42:
        r116 = null;
        goto L43
    L38:
        r113 = null;
        goto L39
    L35:
        r112 = null;
        goto L36
    L28:
        r15 = null;
        goto L30
    L25:
        r14 = null;
        goto L26
    L15:
        if (r40.a != 8) goto L21;
        if (r40.b != 7) goto L21;
        if (((IInteractService) jc1.k.n(IInteractService.class)).dynamicFromAudienceGuestCache() == false) goto L21;
        r11 = true;
        goto L22
    L9:
        if (getMRoom().isVideoCameraVersion() == false) goto L11;
        r7 = InteractMode.VIDEO_TALK_CAMERA;
        goto L12
    L11:
        r7 = InteractMode.VIDEO_TALK;
        goto L12
    L5:
        r6 = false;
        goto L6
    }

    @Override // rj0.l
    public final void M8(int r20, int r21, String r22, LinkApplyType r23, tf0.b r24) {
        Intrinsics.checkNotNullParameter(r22, "from");
        if (r23 == null) goto L5;
        int r1 = r23.getValue();
    L6:
        apply(new sf0.a(r20, r21, r1, 0, null, null, r22, 0, 0, 0, false, false, 0, r24, null, 0, 507768));
        return;
    L5:
        r1 = LinkApplyType.NORMAL.getValue();
        goto L6
    }

    @Override // rj0.l
    public final void a2(boolean r10, List<? extends com.bytedance.android.livesdk.link.model.bridge.k> r11, ClientUIInfo r12, long r13, Map<Long, ? extends g2> r15) {
        Intrinsics.checkNotNullParameter(r11, "linkedUsers");
        Sq(!r10, "self_panel");
        ToolbarVideoInteractBehavior r0 = this.Z;
        if (r0 == null) goto L5;
        r0.d(!r10);
    L5:
        com.bytedance.android.live.liveinteract.plantform.core.y r2 = Aq();
        if (r10 == false) goto L8;
        String r14 = "silence";
    L9:
        r2.Y4(r11, r12, r13, r14, r15);
        return;
    L8:
        r14 = "unSilence";
        goto L9
    }

    public final void dr(VideoShowMode r8, VideoShowMode r9, lg6.a r10, int r11, boolean r12) {
        VideoShowMode r0 = VideoShowMode.DIGIT_AVATAR;
        if (r9 != r0) goto L8;
        if (r8 != VideoShowMode.AUDIO) goto L8;
        com.bytedance.android.live.liveinteract.linksecurity.b r2 = com.bytedance.android.live.liveinteract.linksecurity.b.g;
        LinkedHashMap r3 = new LinkedHashMap();
        com.bytedance.android.live.core.privacy.av.api.b.a.getClass();
        com.bytedance.android.live.core.privacy.av.api.b.a.a r4 = com.bytedance.android.live.core.privacy.av.api.b.a.a;
        com.bytedance.android.live.core.privacy.av.api.a r5 = com.bytedance.android.live.core.privacy.av.api.a.b;
        r2.getClass();
        Intrinsics.checkNotNullParameter(r3, "params");
        Intrinsics.checkNotNullParameter(r4, "callback");
        Intrinsics.checkNotNullParameter(r5, "config");
        r2.e("switch_to_audio", r3, r4, r5);
    L12:
        InteractBeautyPreviewDialog r6 = this.w;
        if (r6 != null) goto L15;
    L25:
        hd0.c.f().g = r11;
        if (vm2.e.d() == true) goto L28;
    L43:
        jg6.a r7 = Eq();
        if (r7 == null) goto L53;
        lh6.b r13 = r7.a();
        if (r13 == null) goto L53;
        if (je0.d.G() == true) goto L51;
        if (r12 == true) goto L51;
        boolean r14 = true;
    L52:
        ng6.c.a.a(r13, r14);
    L51:
        r14 = false;
    L53:
        if (r12 == false) goto L57;
        m00.g r15 = this.U;
        if (r15 == null) goto L61;
        r15.openCamera();
    L61:
        if (vm2.e.d() == true) goto L63;
    L66:
        ALogger.i("VideoDigitAvatar", "waiting digit avatar loading, newShowMode=" + r8 + " oldShowMode=" + r9 + " source == openShowMode_after_else");
        if (r12 == false) goto L83;
        m00.g r16 = this.U;
        if (r16 == null) goto L73;
        SurfaceView r17 = r16.getSurfaceView();
        if (r17 == null) goto L73;
        UtilityKotlinExtentionsKt.w(r17);
    L73:
        HashMap<String, View> r18 = this.h1;
        String r1 = tc0.c.h().f;
        m00.g r19 = this.U;
        if (r19 == null) goto L76;
        SurfaceView r20 = r19.getSurfaceView();
    L77:
        r18.put(r1, r20);
        tf0.o r21 = this.T;
        if (r21 == null) goto L83;
        String r22 = tc0.c.h().f;
        m00.g r23 = this.U;
        if (r23 == null) goto L82;
        r23.getSurfaceView();
    L82:
        r21.b(r22);
        goto L83
    L76:
        r20 = null;
    L83:
        tf0.o r24 = this.T;
        if (r24 == null) goto L86;
        r24.c(tc0.c.h().f, !r12);
    L86:
        com.bytedance.android.livesdk.sharedpref.e r25 = b6.p;
        Integer r110 = Integer.valueOf(r11);
        r25.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r25, r110);
        if (r10 == null) goto L89;
        r10.a(Unit.INSTANCE);
    L89:
        com.bytedance.live.datacontext.j r26 = com.bytedance.android.live.liveinteract.api.utils.m.e(this).getVideoTalkRoomSubScene();
        if (r26 == null) goto L108;
        com.bytedance.android.livesdk.chatroom.viewmodel.e r27 = (com.bytedance.android.livesdk.chatroom.viewmodel.e) r26.getValue();
        if (r27 == null) goto L108;
        com.bytedance.android.livesdk.chatroom.viewmodel.j r28 = r27.t();
        if (r28 == null) goto L108;
        if (r28.a != 12) goto L108;
        List r29 = r28.b;
        if (r29 != null) goto L100;
    L105:
        int r30 = 2;
    L106:
        ((Map) b6.U.getValue()).put(Integer.valueOf(r30), Integer.valueOf(r11));
        goto L108
    L100:
        if (r29.contains(1) == true) goto L103;
        r29 = null;
    L103:
        if (r29 == null) goto L105;
        r30 = 1;
    L108:
        if (r8 != VideoShowMode.VIDEO) goto L113;
        HashMap r31 = new HashMap();
        r31.put("user_type", "guest");
        r31.put("flip_status", "before");
        r31.put("scene_type", "normal");
        TalkRoomLogUtils.B0(r31, null, null, 6);
        TalkRoomLogUtils.J0(r31);
        com.bytedance.android.live.liveinteract.utils.f0.a(r31);
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_audience_connection_user_camera_open_success", r31, new Object[]{am2.x.class, IRoom.class});
        return;
    L113:
        return;
    L63:
        if (r9 != VideoShowMode.AUDIO) goto L66;
        if (r8 != r0) goto L66;
        ALogger.i("VideoDigitAvatar", "waiting digit avatar loading, source == openShowMode_after");
        goto L86
    L57:
        m00.g r32 = this.U;
        if (r32 == null) goto L61;
        r32.closeCamera();
        goto L61
    L28:
        if (r9 != VideoShowMode.AUDIO) goto L43;
        if (r8 != r0) goto L43;
        ALogger.i("VideoDigitAvatar", "waiting digit avatar loading, source == openShowMode_before");
        hg6.g r33 = P2();
        if (r33 == null) goto L53;
        ei6.a r34 = r33.V0();
        if (r34 == null) goto L53;
        xi6.c r35 = r34.t();
        if (r35 == null) goto L53;
        com.bytedance.live.livelink.kmp.impl.core.video.b r36 = r35.f();
        if (r36 == null) goto L53;
        if (((com.bytedance.live.livelink.kmp.impl.core.video.f) r36).g == true) goto L53;
        hg6.g r37 = P2();
        if (r37 == null) goto L53;
        r37.S();
        goto L53
    L15:
        if (r6.isShowing() != true) goto L25;
        if (r9 == r0) goto L25;
        ALogger.e("InteractBeautyPreviewDialog", "beauty preview dialog is showing when switch");
        InteractBeautyPreviewDialog r38 = this.w;
        if (r38 == null) goto L25;
        r38.dismiss();     // Catch: Exception -> L21
    L21:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r39 = DialogFragmentLancet.sLastShowStack;
        if (r39 == null) goto L25;
        com.bytedance.crash.d.d(r39, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
    L8:
        if (r8 != VideoShowMode.AUDIO) goto L12;
        if (r8.getSource() != 1) goto L12;
        com.bytedance.android.live.liveinteract.linksecurity.b.m(com.bytedance.android.live.liveinteract.linksecurity.b.g);
        goto L12
    }

    public final void yf(boolean r17, boolean r18, boolean r19, boolean r20, lh6.c r21) {
        if (r17 == false) goto L9;
        if (r18 == false) goto L9;
        r21.a(Unit.INSTANCE);
        m00.g r0 = this.U;
        if (r0 == null) goto L80;
        r0.r();
        return;
    L80:
        return;
    L9:
        m00.g r1 = this.U;
        if (r1 == null) goto L16;
        if (r17 != r1.isCameraOpen()) goto L16;
        if (r18 == true) goto L16;
        return;
    L16:
        if (((Boolean) com.bytedance.android.livesdk.sharedpref.b.M1.getValue()).booleanValue() == false) goto L66;
        if (r20 == true) goto L66;
        LinkedHashMap r2 = new LinkedHashMap();
        r2.put("live_type", "video_live");
        TalkRoomLogUtils.B0(r2, null, null, 6);
        TalkRoomLogUtils.Q0(r2);
        r2.put("user_type", "guest");
        if (l5() == false) goto L21;
        String r3 = "off";
    L22:
        r2.put("button_type", r3);
        Integer r4 = Integer.valueOf(mr());
        List<KtvMusic> r5 = je0.d.k0(jc1.k.n(IMiddlewareUserService.class).user().n());
        if (r5 != null) goto L25;
    L28:
        boolean r6 = true;
    L29:
        TalkRoomLogUtils.D0(r2, r4, !r6);
        r2.put("connect_type", this.x.a);
        if (Intrinsics.areEqual(this.x.a, "apply") == false) goto L65;
        int r7 = this.y;
        int r8 = bh0.a.a;
        if (r7 != 101) goto L35;
        r2.put("request_page", "seat");
    L62:
        if (Pq() == false) goto L64;
        r2.put("is_approve_needed", "0");
        goto L65
    L64:
        r2.put("is_approve_needed", "1");
        goto L65
    L35:
        if (r7 != 102) goto L38;
        r2.put("request_page", "bottom");
        goto L62
    L38:
        if (r7 != 103) goto L41;
        r2.put("request_page", "popup");
        goto L62
    L41:
        if (r7 != 111) goto L44;
        r2.put("request_page", "top");
        goto L62
    L44:
        if (r7 != 113) goto L46;
        r2.put("request_page", "card");
        goto L62
    L46:
        String r9 = "live_chorus";
        if (r7 != 114) goto L54;
        if (this.A == LinkApplyType.KTV_MULTI_CHORUS) goto L52;
        r9 = "live_song";
    L52:
        r2.put("request_page", r9);
        goto L62
    L54:
        if (tc0.c.h().J == 114) goto L57;
        r2.put("request_page", "");
        goto L62
    L57:
        if (this.A == LinkApplyType.KTV_MULTI_CHORUS) goto L60;
        r9 = "live_song";
    L60:
        r2.put("request_page", r9);
    L65:
        TalkRoomLogUtils.g1(r2, je0.d.b0());
        mz0.n r10 = new mz0.n();
        Map r11 = r10.a;
        Intrinsics.checkNotNullParameter(r11, "map");
        Intrinsics.checkNotNullParameter(r2, "map");
        r11.putAll(r2);
        mz0.m r12 = new mz0.m();
        LogCommon r13 = LogCommon.PAGE_SOURCE_LOG;
        r12.b(r13);
        LogCommon r14 = LogCommon.ROOM;
        r12.b(r14);
        ((ArrayList) r10.b).addAll(r12.a);
        cy0.e.a.getClass();
        cy0.j r15 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r16 = com.bytedance.android.scope.m.b(r15).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r16);
        ((f80.a) r16).w3("livesdk_audience_connection_user_camera_open_click", r10.a, r10.b);
        mz0.n r22 = new mz0.n();
        Map r23 = r22.a;
        Intrinsics.checkNotNullParameter(r23, "map");
        Intrinsics.checkNotNullParameter(r2, "map");
        r23.putAll(r2);
        mz0.m r24 = new mz0.m();
        r24.b(r14);
        r24.b(r13);
        ((ArrayList) r22.b).addAll(r24.a);
        Object r25 = com.bytedance.android.scope.m.b(r15).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r25);
        ((f80.a) r25).w3("livesdk_audience_connection_user_camera_open_click", r22.a, r22.b);
        goto L66
    L25:
        if (r5.isEmpty() == true) goto L28;
        r6 = false;
        goto L29
    L21:
        r3 = "on";
    L66:
        if (r17 == false) goto L68;
        int r26 = 1;
    L69:
        ArrayList r110 = new ArrayList();
        Context r27 = ((Widget) this).context;
        if (r27 != null) goto L72;
        r27 = s1.getContext();
    L72:
        OperateType r28 = OperateType.APPLY;
        r110.add(new qh0.f.b(r27, r28, r26));
        if (r19 == true) goto L78;
        Context r29 = ((Widget) this).context;
        if (r29 != null) goto L77;
        r29 = s1.getContext();
    L77:
        r110.add(new qh0.f.h(r29, r28, r26, 16, getMRoom(), je0.d.b0(), null, this, null, 1472));
    L78:
        qh0.f.a(r110).a(new com.bytedance.android.live.liveinteract.videotalk.b0(this, r21, r17));
        return;
    L68:
        r26 = 2;
        goto L69
    }

    @Override // rj0.l
    public final void kc(int r20, int r21, String r22, String r23, Integer r24, LinkApplyType r25, tf0.b r26) {
        Intrinsics.checkNotNullParameter(r22, "from");
        Intrinsics.checkNotNullParameter(r23, "taskName");
        if (r24 == null) goto L5;
        int r9 = r24.intValue();
    L6:
        if (r25 == null) goto L8;
        int r1 = r25.getValue();
    L9:
        apply(new sf0.a(r20, r21, r1, 0, null, r23, r22, r9, 0, 0, false, false, 0, r26, null, 0, 507448));
        return;
    L8:
        r1 = LinkApplyType.NORMAL.getValue();
        goto L9
    L5:
        r9 = 0;
        goto L6
    }
}
