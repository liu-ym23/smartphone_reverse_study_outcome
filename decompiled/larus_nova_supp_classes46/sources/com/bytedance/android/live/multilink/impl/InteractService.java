package com.bytedance.android.live.multilink.impl;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.app.NotificationManagerCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.anchormodelink.BaseAnchorModeDynamicWidget;
import com.bytedance.android.live.anchormodelink.feed.LivePreviewAnchorModeDynamicWidget;
import com.bytedance.android.live.anchormodelink.impl.AnchorModeLinkDynamicWidget;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.broadcast.api.IMiddlewareBroadcastService;
import com.bytedance.android.live.browser.jsbridge.base.UpdateLinkmicStatusResultModel;
import com.bytedance.android.live.browser.jsbridge.newmethods.v5;
import com.bytedance.android.live.cloudgrouplive.datacontext.CloudGroupContext;
import com.bytedance.android.live.cloudgrouplive.model.CloudGroupLivePipelineStatus;
import com.bytedance.android.live.cloudgrouplive.widget.BaseCloudGroupLiveWidget;
import com.bytedance.android.live.cloudgrouplive.widget.CloudGroupLiveWidget;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.BaseMonitor;
import com.bytedance.android.live.core.monitor.LiveTracingMonitor;
import com.bytedance.android.live.core.setting.b3;
import com.bytedance.android.live.core.setting.b6;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.JsonUtil;
import com.bytedance.android.live.core.utils.ListUtils;
import com.bytedance.android.live.core.utils.StatusBarUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.screen.FoldScreenUtils;
import com.bytedance.android.live.fifa.core.IChannelLinkService;
import com.bytedance.android.live.link.IMultiLinkServiceExternal;
import com.bytedance.android.live.liveinteract.aimv.LiveLinkmicAIMVWidget;
import com.bytedance.android.live.liveinteract.animation.InteractAnimationContext;
import com.bytedance.android.live.liveinteract.animation.InteractAnimationController;
import com.bytedance.android.live.liveinteract.api.BaseLinkMultiControlWidget;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.api.fulllink.InteractLinkFullLinkMonitor;
import com.bytedance.android.live.liveinteract.api.fulllink.TalkRoomBusinessFullLinkMonitor;
import com.bytedance.android.live.liveinteract.awemeplay.LiveAwemeVideoPlayWidget;
import com.bytedance.android.live.liveinteract.awemeplay.view.LiveVideoCommentSelectAwemePanelView;
import com.bytedance.android.live.liveinteract.awemeplay.viewmodel.LiveVideoCommentSelectAwemePanelViewModel;
import com.bytedance.android.live.liveinteract.bgComponent.platform.MultiLinkBgManagerWidget;
import com.bytedance.android.live.liveinteract.bgComponent.platform.MultiLinkThemeBgUIWidget;
import com.bytedance.android.live.liveinteract.bgComponent.theme.VoiceLiveThemeManageDialog;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.playmode.PlayModeService;
import com.bytedance.android.live.liveinteract.customizestream.CustomizeStreamContext;
import com.bytedance.android.live.liveinteract.digitavatar.DigitAvatarAuditStatus;
import com.bytedance.android.live.liveinteract.digitavatar.DigitAvatarContext;
import com.bytedance.android.live.liveinteract.enlarge.dialog.MultiLinkEnlargeSelectGuestDialog;
import com.bytedance.android.live.liveinteract.feed.CommonMultiLinkFeedView;
import com.bytedance.android.live.liveinteract.feed.EmptyFeedView;
import com.bytedance.android.live.liveinteract.feed.MultiLinkGameFeedView;
import com.bytedance.android.live.liveinteract.feed.MultiLinkLinkRoomFightFeedView;
import com.bytedance.android.live.liveinteract.feed.MultiLinkVideoTeamFightFeedView;
import com.bytedance.android.live.liveinteract.feed.MultiLinkVoiceChatFeedView;
import com.bytedance.android.live.liveinteract.feedv2.widget.LivePreviewMultiLinkCommonWidget;
import com.bytedance.android.live.liveinteract.hamlet.HamletAvatarContext;
import com.bytedance.android.live.liveinteract.interact.audience.dialog.fragment.OpenLiveVideoTalkFragment;
import com.bytedance.android.live.liveinteract.interact.audience.dialog.fragment.OpenLiveVideoTalkFragmentNew;
import com.bytedance.android.live.liveinteract.interactivesong.impl.InteractiveSongContext;
import com.bytedance.android.live.liveinteract.linkbase.api.MediaOperation;
import com.bytedance.android.live.liveinteract.linkpanel.vm.GuestApplyViewModel;
import com.bytedance.android.live.liveinteract.livematrix.LiveMatrixEntranceWidget;
import com.bytedance.android.live.liveinteract.manager.PreviewInteractFeedViewManager;
import com.bytedance.android.live.liveinteract.model.LinkScreenCastType;
import com.bytedance.android.live.liveinteract.plantform.api.LinkApi;
import com.bytedance.android.live.liveinteract.plantform.api.LinkAudienceApi;
import com.bytedance.android.live.liveinteract.plantform.dynamicframe.MultiLinkDynamicWidgetNew;
import com.bytedance.android.live.liveinteract.plantform.dynamicframe.context.MultiLinkDynamicContext;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.plantform.model.LinkerBaseInfo;
import com.bytedance.android.live.liveinteract.plantform.model.UserType;
import com.bytedance.android.live.liveinteract.plantform.monitor.MultiLinkEventModule;
import com.bytedance.android.live.liveinteract.plantform.monitor.MultiLinkEventType;
import com.bytedance.android.live.liveinteract.plantform.multiroom.MultiLinkMicSeatDataWidget;
import com.bytedance.android.live.liveinteract.plantform.multiroom.MultiLinkUIWidget;
import com.bytedance.android.live.liveinteract.plantform.spatial.SpatialAudioStrategyManager;
import com.bytedance.android.live.liveinteract.plantform.utils.InteractBusinessPerformanceStrategyTask;
import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomLogUtils;
import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomOperate;
import com.bytedance.android.live.liveinteract.plantform.widgt.AudioSceneBasicBusinessContentWidget;
import com.bytedance.android.live.liveinteract.pre.VerticalNitaInflate;
import com.bytedance.android.live.liveinteract.radio.api.IRadioService;
import com.bytedance.android.live.liveinteract.revenue.battle.GuestBattleContext;
import com.bytedance.android.live.liveinteract.revenue.fight.TeamFightContext;
import com.bytedance.android.live.liveinteract.revenue.game.LinkMicGameContext;
import com.bytedance.android.live.liveinteract.revenue.guestlink.GuestLinkContext;
import com.bytedance.android.live.liveinteract.revenue.linkroomfight.rtc.LinkRoomFightRtcManager;
import com.bytedance.android.live.liveinteract.revenue.paid.viewmodel.PaidLinkMicContext;
import com.bytedance.android.live.liveinteract.revenuebase.MultiRevenueDataContext;
import com.bytedance.android.live.liveinteract.service.LinkPanelTransitService;
import com.bytedance.android.live.liveinteract.service.r;
import com.bytedance.android.live.liveinteract.utils.MultiLinkLoadWidgetUtils;
import com.bytedance.android.live.liveinteract.videolink.IVideoLinkService;
import com.bytedance.android.live.liveinteract.videotalk.cposition.CPositionContext;
import com.bytedance.android.live.liveinteract.videotalk.emoji.model.MultiLinkScriptInfo;
import com.bytedance.android.live.liveinteract.videotalk.emoji.model.TaskState;
import com.bytedance.android.live.liveinteract.videotalk.selfdiscipline.SelfDisciplineContext;
import com.bytedance.android.live.liveinteract.videotalk.themecompetition.ThemedCompetitionContext;
import com.bytedance.android.live.liveinteract.videotalk.utils.panel.MultiLinkLynxSettingPanelActionHandler;
import com.bytedance.android.live.liveinteract.voicechat.IVoiceChatAdminService;
import com.bytedance.android.live.liveinteract.voicechat.IVoiceChatGuestService;
import com.bytedance.android.live.liveinteract.voicechat.VoiceChatMuteManager;
import com.bytedance.android.live.liveinteract.voicechat.emoji.InteractEmojiPanel;
import com.bytedance.android.live.liveinteract.voicechat.radio.context.RadioStageContext;
import com.bytedance.android.live.liveinteract.voicechat.stage.AudioChatStageContext;
import com.bytedance.android.live.liveinteract.voicechat.subtitle.LinkmicSubtitleBusinessContext;
import com.bytedance.android.live.liveinteract.voicechat.subtitle.LinkmicSubtitleSettingDialog;
import com.bytedance.android.live.liveinteract.voicechat.subtitle.LinkmicSubtitleUIWidget;
import com.bytedance.android.live.liveinteract.widget.widget.LinkDistributeSettingDialog;
import com.bytedance.android.live.liveinteract.wrds.ChannelRoomLinkSyncData;
import com.bytedance.android.live.liveinteract.wrdspreload.MultiLinkWRDSPreloadManager;
import com.bytedance.android.live.multilink.layoutconfig.model.LayoutConfigModel;
import com.bytedance.android.live.network.api.IMiddlewareNetworkService;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.live.pk.audience.IMultiPkAudienceLinkOutService;
import com.bytedance.android.live.pushstream.model.LiveRequestSourceRole;
import com.bytedance.android.live.room.IMiddlewareMicRoomService;
import com.bytedance.android.live.room.IMiddlewareRoomService;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.live.virtuallive.BaseVirtualLiveControlWidget;
import com.bytedance.android.live.virtuallive.impl.VirtualLiveControlWidget;
import com.bytedance.android.livesdk.chatroom.InteractionWidgetsPosContext;
import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.model.interact.IAudioSubtitleContent;
import com.bytedance.android.livesdk.chatroom.utils.o3;
import com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget;
import com.bytedance.android.livesdk.config.bc0;
import com.bytedance.android.livesdk.config.c60;
import com.bytedance.android.livesdk.config.fb0;
import com.bytedance.android.livesdk.config.mz;
import com.bytedance.android.livesdk.config.q7;
import com.bytedance.android.livesdk.config.rj1;
import com.bytedance.android.livesdk.config.tb0;
import com.bytedance.android.livesdk.config.y01;
import com.bytedance.android.livesdk.ktvapi.IKtvService;
import com.bytedance.android.livesdk.link.model.z5;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.bytedance.android.livesdk.message.model.nd;
import com.bytedance.android.livesdk.model.MultiLinkEnlargeTipsConfig;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdk.utils.d5;
import com.bytedance.android.livesdkapi.depend.message.ClientUIInfo;
import com.bytedance.android.livesdkapi.depend.message.RoomLinkMicSyncData;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomBase;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.feed.IInteractFeedView;
import com.bytedance.android.livesdkapi.feed.IKtvComponentFeedViewManager;
import com.bytedance.android.livesdkapi.feed.ILivePreviewMultiLinkCommonWidget;
import com.bytedance.android.livesdkapi.feed.anchormode.ILivePreviewAnchorModeLinkCommonWidget;
import com.bytedance.android.livesdkapi.feed.data.FeedViewRoomInfoStore;
import com.bytedance.android.livesdkapi.feed.manager.IInteractFeedViewManager;
import com.bytedance.android.livesdkapi.feed.manager.ILivePreviewKtvComponentWidget;
import com.bytedance.android.livesdkapi.feed.manager.ISingleBroadcastPreviewKtvComponent;
import com.bytedance.android.livesdkapi.hybridapi.IJsBridgeManager;
import com.bytedance.android.livesdkapi.interact.data.LinkFeedTypeConstant;
import com.bytedance.android.livesdkapi.model.CloudGroupLiveBeInvitedDialogConfig;
import com.bytedance.android.livesdkapi.model.LinkPreviewMonitorData;
import com.bytedance.android.livesdkapi.model.LiveInteractActingConfig;
import com.bytedance.android.livesdkapi.model.MultiLinkPreviewPointConfig;
import com.bytedance.android.livesdkapi.model.ParseSeiData;
import com.bytedance.android.livesdkapi.model.SeiAppData;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.live.core.utils.SettingUtilExtensionKt;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.GroupLiveGameConfig;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.MultiLinkPerfBalanceConfig;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdkapi.model.MultiLinkFrequencyOptConfig;
import com.bytedance.android.livesdkapi.multilink.IMultiLinkWRDSPreloadService;
import com.bytedance.android.livesdkapi.service.ILinkDistributionSettingCallback;
import com.bytedance.android.livesdkapi.service.IMiddlewareLiveVideoFloatWindowService;
import com.bytedance.android.livesdkapi.util.IMultiScenePreviewStatistics;
import com.bytedance.common.utility.Lists;
import com.bytedance.common.utility.concurrent.TTExecutors;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.ies.sdk.widgets.WidgetManager;
import com.bytedance.kmp.live.livelink.api.model.VideoShowMode;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.livelink.kmp.api.core.mixer.MixStreamType;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.ugc.aweme.live.preview.LivePreviewKtvComponentWidget;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public class InteractService implements IInteractService {
    private static final int DynamicLoadState_Ing = 1;
    private static final int DynamicLoadState_None = 0;
    private static final Set<Long> everCastingSet = null;
    static Set<Integer> multiLinkScene;
    String FunctionTypeLogInjectorId;
    String SubscribeLogInjectorId;
    private qd0.b audienceImp;
    private qd0.a audioTalkImp;
    private rj0.d commonImp;
    private FeedViewRoomInfoStore feedViewRoomInfoStore;
    private gd0.i interactFloatWindowService;
    private gd0.m linkPanelTransitService;
    private q7 logConfig;
    private gd0.e mAnchorModeOutService;
    private com.bytedance.android.live.liveinteract.plantform.performance.a mMultiLinkPerfManager;
    private gd0.l mMultiOutService;
    private InteractBusinessPerformanceStrategyTask mVerticalDegradeTask;
    private gd0.o multiLinkBridgeService;
    private qd0.c multiLinkToolbarServiceImpl;
    private boolean openDynamicFromAudience;
    private boolean openDynamicFromAudienceGuestCache;
    private qd0.e profileCardImp;
    private rj0.m videoTalkImp;

    public class a implements gd0.h {
        public a() {
        }

        public final Disposable a(DataCenter r3) {
            InteractAnimationController r0 = new InteractAnimationController(r3);
            Pair r4 = com.bytedance.live.datacontext.d.a(new f());
            ((InteractAnimationContext) r4.getFirst()).getController().d(r0);
            com.bytedance.live.datacontext.d.c((InteractAnimationContext) r4.getFirst(), InteractAnimationContext.class);
            return (Disposable) r4.getSecond();
        }
    }

    public static /* synthetic */ void b(String r0, String r1, List r2, List r3) {
        lambda$tryOpenChooseGuestPanelWithUsage$3(r0, r1, r2, r3);
    }

    public static /* synthetic */ Unit c(int r0, int r1, int r2, String r3, int r4) {
        return lambda$switchSceneWithConfirmCheck$0(r0, r1, r2, r3, r4);
    }

    public static /* synthetic */ Unit d(rj0.c r0, Boolean r1) {
        return lambda$guestDisconnect$1(r0, r1);
    }

    public static /* synthetic */ void e(Context r0, Long r1) {
        lambda$preloadDynamicContainer$2(r0, r1);
    }

    private String getOpenSource(boolean r1) {
        if (r1 == false) goto L4;
        return "live";
    L4:
        return "chatroom";
    }

    private boolean isVoiceChatRoomSeiVersion(int r2) {
        if (r2 != (-1)) goto L5;
    L8:
        return true;
    L5:
        if (r2 == 3) goto L8;
        return false;
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public void broadcastGameStartError() {
        IRoom r0 = je0.d.e(null);
        if (((MultiLinkPreviewPointConfig) b3.a.getValue()).getBroadcastGameStartErrorSwitchScene() == false) goto L12;
        if (r0 != null) goto L6;
        return;
    L6:
        if (TalkRoomLogUtils.o.isEmpty() == true) goto L14;
        qi0.d.a.a(true, "broadcast_open_game_start_error", 0, "switch to basic layout");
        if (r0.isLiveTypeAudio() == false) goto L10;
        switchScene(getCurrentScene(), 5, "broadcast_game_start_error", 27);
        return;
    L10:
        switchScene(getCurrentScene(), 12, "broadcast_game_start_error", 5);
        return;
    L14:
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public void setCposition(long r1, String r3, boolean r4, Function1<Boolean, Unit> r5) {
    }

    static {
        everCastingSet = new HashSet();
        multiLinkScene = new AnonymousClass2();
    }

    private q7 getAVMonitorLogConfig() {
        if (this.logConfig != null) goto L6;
        this.logConfig = vm2.i.k();
    L6:
        return this.logConfig;
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public boolean audioSubtitleOpen() {
        return LinkmicSubtitleBusinessContext.Companion.d();
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public boolean canShowCommentShareVideoButton() {
        int r0 = td0.a.a;
        com.bytedance.live.datacontext.m r1 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r1 == null) goto L9;
        IRoom r2 = (IRoom) r1.getValue();
        if (r2 == null) goto L9;
        String r3 = r2.getAnchorAbValue("live_video_share");
        if (r3 == null) goto L9;
        int r4 = CastIntegerProtector.parseInt(r3);
    L11:
        if (r4 <= 1) goto L13;
        boolean r5 = true;
    L14:
        Boolean r6 = com.bytedance.android.live.liveinteract.api.utils.m.i().isAnchor();
        if (r6 == null) goto L17;
        boolean r7 = r6.booleanValue();
    L18:
        com.bytedance.live.datacontext.m r8 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r8 == null) goto L27;
        IRoom r9 = (IRoom) r8.getValue();
        if (r9 == null) goto L27;
        IRoomAuthStatus r10 = r9.getRoomAuthStatus();
        if (r10 == null) goto L27;
        if (r10.getEnableVideoShare() != 1) goto L27;
        boolean r11 = true;
    L28:
        StringBuilder r12 = new StringBuilder("canShowCommentShareVideoButton: isAnchorHitAb=");
        com.bytedance.live.datacontext.m r13 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r13 == null) goto L33;
        IRoom r14 = (IRoom) r13.getValue();
        if (r14 == null) goto L33;
        String r15 = r14.getAnchorAbValue("live_video_share");
    L34:
        r12.append(r15);
        r12.append(", isAnchor=");
        r12.append(r7);
        r12.append(", currentScene=");
        r12.append(TalkRoomLogUtils.q());
        r12.append(", isOnline=");
        r12.append(hd0.c.f().h());
        ALogger.i("LivePureAwemePlay", r12.toString());
        if (r5 == false) goto L44;
        if (r11 == true) goto L38;
        return false;
    L38:
        if (td0.a.a() == false) goto L46;
        if (r7 == false) goto L41;
    L42:
        return true;
    L41:
        if (hd0.c.f().h() == true) goto L42;
        return false;
    L46:
        return false;
    L44:
        return false;
    L33:
        r15 = null;
    L27:
        r11 = false;
        goto L28
    L17:
        r7 = false;
        goto L18
    L13:
        r5 = false;
    L9:
        r4 = 0;
        goto L11
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public MiddlewareRoomWidget createAIMVWidget() {
        return new LiveLinkmicAIMVWidget();
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public com.bytedance.android.live.liveinteract.c createAudioSceneBasicWidget() {
        ALogger.e("createAudioSceneBasicWidget", "createWidget, trace=" + Log.getStackTraceString(new Throwable()));
        return new AudioSceneBasicBusinessContentWidget();
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public IChannelLinkService createChannelLinkService() {
        return new com.bytedance.android.live.liveinteract.channel.business.c();
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public MiddlewareRoomWidget createMultiLinkBgManager() {
        return new MultiLinkBgManagerWidget();
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public Widget createMultiLinkDataCenterWidget() {
        return new MultiLinkMicSeatDataWidget();
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public Widget createMultiLinkUIWidget() {
        return new MultiLinkUIWidget();
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public void exitRoom() {
        rj0.l.n2.getClass();
        rj0.l r0 = rj0.l.a.a();
        if (r0 == null) goto L5;
        r0.exitRoom();
    L5:
        IVoiceChatGuestService.Companion.getClass();
        IVoiceChatGuestService r1 = IVoiceChatGuestService.a.a();
        if (r1 == null) goto L9;
        r1.exitRoom();
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public SurfaceView getAnchorLinkmicSurfaceView() {
        com.bytedance.android.live.liveinteract.plantform.base.e.l0.getClass();
        if (com.bytedance.android.live.liveinteract.plantform.base.e.a.a() != null) goto L5;
        rj0.l.n2.getClass();
        if (rj0.l.a.a() != null) goto L9;
        return null;
    L9:
        return rj0.l.a.a().R0();
    L5:
        return com.bytedance.android.live.liveinteract.plantform.base.e.a.a().R0();
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public int getAnchorManualUiLayout() {
        com.bytedance.android.live.liveinteract.voicechat.d.s0.getClass();
        if (com.bytedance.android.live.liveinteract.voicechat.d.a.a() != null) goto L5;
        IVoiceChatGuestService.Companion.getClass();
        if (IVoiceChatGuestService.a.a() != null) goto L9;
        return 0;
    L9:
        return IVoiceChatGuestService.a.a().getAnchorManualUiLayout();
    L5:
        return com.bytedance.android.live.liveinteract.voicechat.d.a.a().getAnchorManualUiLayout();
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public gd0.e getAnchorModeOutService() {
        if (this.mAnchorModeOutService != null) goto L6;
        this.mAnchorModeOutService = new com.bytedance.android.live.liveinteract.service.c();
    L6:
        return this.mAnchorModeOutService;
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public gd0.h getAnimationController() {
        return new a();
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public qd0.a getAudioTalkService() {
        if (this.audioTalkImp != null) goto L6;
        this.audioTalkImp = new com.bytedance.android.live.liveinteract.service.d();
    L6:
        return this.audioTalkImp;
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public Map<String, Class> getChannelWRDSDataMap() {
        HashMap r0 = new HashMap();
        r0.put("RoomChannelLinkMicSyncData", ChannelRoomLinkSyncData.class);
        return r0;
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public z30.b getCloudGroupLiveService() {
        CloudGroupContext r0 = CloudGroupContext.Companion.getContext();
        if (r0 == null) goto L7;
        com.bytedance.live.datacontext.j r1 = r0.getService();
        if (r1 == null) goto L7;
        return (z30.b) r1.getValue();
    L7:
        return null;
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public String getCurrentSwitchSceneSource() {
        com.bytedance.android.live.liveinteract.plantform.utils.i0 r0 = TalkRoomLogUtils.a;
        return TalkRoomLogUtils.d;
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b getDigitAvatarBehavior() {
        return new com.bytedance.android.live.liveinteract.digitavatar.g0();
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public int getEnlargeGuestType() {
        return CPositionContext.Companion.d();
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public FeedViewRoomInfoStore getFeedViewRoomInfoStore() {
        if (this.feedViewRoomInfoStore != null) goto L6;
        this.feedViewRoomInfoStore = new FeedViewRoomInfoStore();
    L6:
        return this.feedViewRoomInfoStore;
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public String getFunctionType2() {
        com.bytedance.android.live.liveinteract.plantform.utils.i0 r0 = TalkRoomLogUtils.a;
        return TalkRoomLogUtils.h;
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public String getFunctionType2BeforeReset() {
        com.bytedance.android.live.liveinteract.plantform.utils.i0 r0 = TalkRoomLogUtils.a;
        String r1 = TalkRoomLogUtils.i;
        Intrinsics.checkNotNullParameter("live", "<set-?>");
        TalkRoomLogUtils.i = "live";
        return r1;
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public long getGuestApplyPaidAmount() {
        DataContext r0 = com.bytedance.live.datacontext.d.d(GuestApplyViewModel.TAG);
        if ((r0 instanceof GuestApplyViewModel) == true) goto L5;
        return 0;
    L5:
        return ((GuestApplyViewModel) r0).getCurrentUserPaidAmount();
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    @Nullable
    public ei6.a getGuestRtcClient() {
        com.bytedance.android.live.liveinteract.plantform.base.b.h0.getClass();
        com.bytedance.android.live.liveinteract.plantform.base.b r0 = com.bytedance.android.live.liveinteract.plantform.base.b.a.a();
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.V0();
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public com.bytedance.android.live.pushstream.d getGuestRtcLiveStream() {
        com.bytedance.android.live.liveinteract.plantform.base.b.h0.getClass();
        com.bytedance.android.live.liveinteract.plantform.base.b r0 = com.bytedance.android.live.liveinteract.plantform.base.b.a.a();
        if (r0 != null) goto L5;
        return null;
    L5:
        if (r0.getLiveVideoClientFactory() != null) goto L7;
        return null;
    L7:
        return r0.getLiveVideoClientFactory().getLiveStream();
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public qd0.b getInteractAudienceService() {
        if (this.audienceImp != null) goto L6;
        this.audienceImp = new com.bytedance.android.live.liveinteract.service.f();
    L6:
        return this.audienceImp;
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public gd0.i getInteractFloatWindowService() {
        if (this.interactFloatWindowService != null) goto L6;
        this.interactFloatWindowService = new com.bytedance.android.live.liveinteract.service.g();
    L6:
        return this.interactFloatWindowService;
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public wi0.a getInteractiveSongService() {
        MultiRevenueDataContext.Companion.getClass();
        MultiRevenueDataContext r0 = MultiRevenueDataContext.a.e();
        if (r0 == null) goto L7;
        com.bytedance.live.datacontext.i r1 = MultiRevenueDataContext.access$getInteractiveSongService$p(r0);
        if (r1 == null) goto L7;
        return (of0.a) r1.getValue();
    L7:
        return null;
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public IKtvComponentFeedViewManager getKtvComponentFeedViewManage() {
        return new com.bytedance.android.live.liveinteract.feedv2.feedview.f0();
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public gd0.l getLinkMultiOutService() {
        if (this.mMultiOutService != null) goto L6;
        this.mMultiOutService = new com.bytedance.android.live.liveinteract.service.h();
    L6:
        return this.mMultiOutService;
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public gd0.m getLinkPanelTransitService() {
        if (this.linkPanelTransitService != null) goto L6;
        this.linkPanelTransitService = new LinkPanelTransitService();
    L6:
        return this.linkPanelTransitService;
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public ILivePreviewMultiLinkCommonWidget getLivePreviewMultiLinkCommonWidget() {
        return new LivePreviewMultiLinkCommonWidget();
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public RecyclerView getMicSeatRecyclerView() {
        com.bytedance.android.live.liveinteract.voicechat.d.s0.getClass();
        com.bytedance.android.live.liveinteract.voicechat.d r0 = com.bytedance.android.live.liveinteract.voicechat.d.a.a();
        if (r0 == null) goto L9;
        tf0.o r1 = r0.commonWindowManager();
        if (r1 == null) goto L9;
        RecyclerView r2 = r1.getMicSeatRecyclerView();
        if (r2 == null) goto L9;
        return r2;
    L9:
        IVoiceChatGuestService.Companion.getClass();
        IVoiceChatGuestService r3 = IVoiceChatGuestService.a.a();
        if (r3 == null) goto L16;
        tf0.o r4 = r3.commonWindowManager();
        if (r4 == null) goto L16;
        RecyclerView r5 = r4.getMicSeatRecyclerView();
        if (r5 == null) goto L16;
        return r5;
    L16:
        rj0.k.m2.getClass();
        rj0.k r6 = rj0.k.a.a();
        if (r6 == null) goto L23;
        tf0.o r7 = r6.windowManager();
        if (r7 == null) goto L23;
        RecyclerView r8 = r7.getMicSeatRecyclerView();
        if (r8 == null) goto L23;
        return r8;
    L23:
        rj0.l.n2.getClass();
        rj0.l r9 = rj0.l.a.a();
        if (r9 == null) goto L30;
        tf0.o r10 = r9.windowManager();
        if (r10 == null) goto L30;
        RecyclerView r11 = r10.getMicSeatRecyclerView();
        if (r11 == null) goto L30;
        return r11;
    L30:
        return null;
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public MixStreamType getMixStreamType() {
        rj0.k.m2.getClass();
        if (rj0.k.a.a() != null) goto L5;
        com.bytedance.android.live.liveinteract.voicechat.d.s0.getClass();
        if (com.bytedance.android.live.liveinteract.voicechat.d.a.a() != null) goto L9;
        return null;
    L9:
        return com.bytedance.android.live.liveinteract.voicechat.d.a.a().getMixStreamType();
    L5:
        return rj0.k.a.a().getMixStreamType();
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public gd0.o getMultiLinkBridgeService() {
        if (this.multiLinkBridgeService != null) goto L6;
        this.multiLinkBridgeService = new com.bytedance.android.live.liveinteract.service.q();
    L6:
        return this.multiLinkBridgeService;
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public qj0.a getMultiLinkLayoutService() {
        com.bytedance.android.live.liveinteract.voicechat.d.s0.getClass();
        if (com.bytedance.android.live.liveinteract.voicechat.d.a.a() != null) goto L5;
        IVoiceChatGuestService.Companion.getClass();
        if (IVoiceChatGuestService.a.a() != null) goto L9;
        return null;
    L9:
        return IVoiceChatGuestService.a.a().getMultiLinkAudioLayoutService();
    L5:
        return com.bytedance.android.live.liveinteract.voicechat.d.a.a().getMultiLinkAudioLayoutService();
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public int getMultiLinkScene() {
        com.bytedance.android.live.liveinteract.voicechat.d.s0.getClass();
        if (com.bytedance.android.live.liveinteract.voicechat.d.a.a() != null) goto L5;
        IVoiceChatGuestService.Companion.getClass();
        if (IVoiceChatGuestService.a.a() != null) goto L9;
        com.bytedance.android.live.liveinteract.plantform.base.d.j0.getClass();
        if (com.bytedance.android.live.liveinteract.plantform.base.d.a.a() != null) goto L53;
        com.bytedance.android.live.liveinteract.plantform.base.e.l0.getClass();
        if (com.bytedance.android.live.liveinteract.plantform.base.e.a.a() != null) goto L62;
        rj0.k.m2.getClass();
        if (rj0.k.a.a() != null) goto L34;
        rj0.l.n2.getClass();
        if (rj0.l.a.a() != null) goto L34;
        com.bytedance.android.livesdk.chatroom.u r0 = com.bytedance.android.live.liveinteract.api.utils.m.d();
        if (r0 != null) goto L23;
        return 0;
    L23:
        if (r0.s() != null) goto L25;
        return 0;
    L25:
        if (r0.s() != null) goto L27;
        return 0;
    L27:
        if (r0.s().getValue() != null) goto L29;
        return 0;
    L29:
        if (((com.bytedance.android.livesdk.chatroom.viewmodel.f) r0.s().getValue()).t().a != 0) goto L31;
        return 0;
    L31:
        return ((com.bytedance.android.livesdk.chatroom.viewmodel.f) r0.s().getValue()).t().a;
    L34:
        com.bytedance.android.livesdk.chatroom.u r1 = com.bytedance.android.live.liveinteract.api.utils.m.d();
        if (r1 != null) goto L37;
    L43:
        if (r1 != null) goto L45;
        return 8;
    L45:
        if (r1.getVideoTalkRoomSubScene() != null) goto L47;
        return 8;
    L47:
        if (r1.getVideoTalkRoomSubScene().getValue() != null) goto L49;
        return 8;
    L49:
        if (((com.bytedance.android.livesdk.chatroom.viewmodel.e) r1.getVideoTalkRoomSubScene().getValue()).t().a != 16) goto L61;
        return 16;
    L61:
        return 8;
    L37:
        if (r1.getVideoTalkRoomSubScene() == null) goto L43;
        if (r1.getVideoTalkRoomSubScene().getValue() == null) goto L43;
        if (((com.bytedance.android.livesdk.chatroom.viewmodel.e) r1.getVideoTalkRoomSubScene().getValue()).t().a != 12) goto L43;
        return 12;
    L62:
        return 4;
    L53:
        return 4;
    L9:
        return IVoiceChatGuestService.a.a().getCurrentScene();
    L5:
        return com.bytedance.android.live.liveinteract.voicechat.d.a.a().getCurrentScene();
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public qd0.c getMultiLinkToolbarService() {
        if (this.multiLinkToolbarServiceImpl != null) goto L6;
        this.multiLinkToolbarServiceImpl = new r();
    L6:
        return this.multiLinkToolbarServiceImpl;
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public IMultiLinkWRDSPreloadService getMultiLinkWRDSPreloadService() {
        Lazy r0 = MultiLinkWRDSPreloadManager.i;
        return MultiLinkWRDSPreloadManager.a.a();
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public ArrayList<ILinkPlayerInfoBridge> getOnlineList() {
        rj0.k.m2.getClass();
        if (rj0.k.a.a() != null) goto L5;
        return null;
    L5:
        return rj0.k.a.a().getOnlineList();
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    @Nullable
    public xh0.d getPlayModeService() {
        MultiRevenueDataContext.Companion.getClass();
        return MultiRevenueDataContext.a.d();
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public qd0.e getProfileCardOutService() {
        if (this.profileCardImp != null) goto L6;
        this.profileCardImp = new com.bytedance.android.live.liveinteract.service.s();
    L6:
        return this.profileCardImp;
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public qd0.f getRadioLinkService() {
        return RadioStageContext.Companion.a();
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public kj0.b getSelfDisciplineService() {
        return SelfDisciplineContext.Companion.d();
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public lj0.a getSpatialAudioService() {
        return SpatialAudioStrategyManager.c.a();
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    @Nullable
    public pj0.b getThemedCompetitionService() {
        return ThemedCompetitionContext.Companion.c();
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public int getVideoShowMode() {
        DigitAvatarContext.a r0 = DigitAvatarContext.Companion;
        if (r0.getContext() != null) goto L5;
        return 0;
    L5:
        if (r0.getContext().getCurrentVideoShowMode() != null) goto L7;
        return 0;
    L7:
        return r0.getContext().getCurrentVideoShowMode().getType();
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public rj0.m getVideoTalkService() {
        return ((IVideoLinkService) jc1.k.f(IVideoLinkService.class)).getVideoTalkService();
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    @Nullable
    public com.bytedance.android.live.liveinteract.revenue.battle.c0 guestBattleService() {
        MultiRevenueDataContext.Companion.getClass();
        return MultiRevenueDataContext.a.a();
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService, gd0.n
    public boolean isAudienceLinkEngineOn() {
        com.bytedance.android.live.liveinteract.plantform.base.e.l0.getClass();
        if (com.bytedance.android.live.liveinteract.plantform.base.e.a.a() != null) goto L5;
        IVoiceChatAdminService.Companion.getClass();
        IVoiceChatAdminService r0 = IVoiceChatAdminService.a.a();
        if (r0 != null) goto L9;
        rj0.l.n2.getClass();
        rj0.l r1 = rj0.l.a.a();
        if (r1 == null) goto L15;
        return r1.isEngineOn();
    L15:
        if (jc1.k.f(IKtvService.class) != null) goto L17;
        return false;
    L17:
        if (jc1.k.f(IKtvService.class).isEngineOn() == false) goto L22;
        return true;
    L22:
        return false;
    L9:
        return r0.isEngineOn();
    L5:
        return com.bytedance.android.live.liveinteract.plantform.base.e.a.a().isEngineOn();
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public boolean isAudienceVideoLinkEngineOn() {
        rj0.l.n2.getClass();
        if (rj0.l.a.a() != null) goto L5;
        return false;
    L5:
        return rj0.l.a.a().isEngineOn();
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService, gd0.n
    public boolean isCPositionOpen() {
        CPositionContext r0 = CPositionContext.Companion.getContext();
        if (r0 != null) goto L5;
        return false;
    L5:
        if (((Boolean) r0.isCPositionOpen().getValue()).booleanValue() == false) goto L10;
        return true;
    L10:
        return false;
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public boolean isEnableDanmuGameClearScreen() {
        return LinkMicGameContext.Companion.c();
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public boolean isEnableDanmuGameServerMerge() {
        return LinkMicGameContext.Companion.d();
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public boolean isEnableTalkRoomEmoji() {
        if (((Boolean) vm2.d.y.getValue(null, vm2.d.a[22])).booleanValue() == false) goto L5;
        return false;
    L5:
        int r0 = getLinkMode();
        if (gd0.v.a(r0, 32) == false) goto L10;
        return ((Boolean) com.bytedance.android.livesdk.sharedpref.d.n.getValue(null, com.bytedance.android.livesdk.sharedpref.d.a[12])).booleanValue();
    L10:
        if (gd0.v.a(r0, 8) == true) goto L12;
        return false;
    L12:
        return ((Boolean) com.bytedance.android.livesdk.sharedpref.d.o.getValue(null, com.bytedance.android.livesdk.sharedpref.d.a[13])).booleanValue();
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public boolean isInCustomizeStreamLayout() {
        CustomizeStreamContext.a r0 = CustomizeStreamContext.Companion;
        if (r0.getContext() != null) goto L5;
        return false;
    L5:
        if (r0.getContext().getGuestInCustomizeStreamLayout() != null) goto L7;
        return false;
    L7:
        if (r0.getContext().getGuestInCustomizeStreamLayout().getValue() != null) goto L10;
        return false;
    L10:
        return ((Boolean) r0.getContext().getGuestInCustomizeStreamLayout().getValue()).booleanValue();
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public boolean isLiveShakeEnable() {
        return ((Boolean) b6.V.getValue()).booleanValue();
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public boolean isMultiLinkScene() {
        return multiLinkScene.contains(Integer.valueOf(getCurrentScene()));
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public boolean isOpenInteractiveSong() {
        return InteractiveSongContext.Companion.f();
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public boolean isQuickInteractEnable() {
        int r0 = com.bytedance.android.live.liveinteract.videotalk.quickinteract.a.a;
        com.bytedance.android.live.liveinteract.videotalk.quickinteract.b.r0.getClass();
        return com.bytedance.android.live.liveinteract.videotalk.quickinteract.b.C0101b.b();
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public boolean isTalkRoomLoaded() {
        rj0.k.m2.getClass();
        if (rj0.k.a.a() != null) goto L8;
        rj0.l.n2.getClass();
        if (rj0.l.a.a() != null) goto L8;
        boolean r0 = false;
    L9:
        if (r0 == true) goto L22;
        com.bytedance.live.datacontext.m r1 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r1 == null) goto L17;
        IRoom r2 = (IRoom) r1.getValue();
        if (r2 == null) goto L17;
        if (r2.isLiveTypeAudio() != true) goto L17;
        boolean r3 = true;
    L18:
        if (r3 == true) goto L23;
        return false;
    L23:
        return true;
    L17:
        r3 = false;
        goto L18
    L22:
        return true;
    L8:
        r0 = true;
        goto L9
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public Boolean isThemedCompetitionOn() {
        return Boolean.valueOf(ThemedCompetitionContext.Companion.g());
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    @Nullable
    public xi0.a linkRoomFightService() {
        MultiRevenueDataContext.Companion.getClass();
        return MultiRevenueDataContext.a.b();
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public void onProgramFrameErr() {
        rj0.k.m2.getClass();
        if (rj0.k.a.a() == null) goto L6;
        rj0.k.a.a().onProgramFrameErr();
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public void onProgramHide() {
        rj0.k.m2.getClass();
        if (rj0.k.a.a() == null) goto L6;
        rj0.k.a.a().onProgramHide();
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public void onProgramShow() {
        rj0.k.m2.getClass();
        if (rj0.k.a.a() == null) goto L6;
        rj0.k.a.a().onProgramShow();
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public void onProgramStop() {
        rj0.k.m2.getClass();
        if (rj0.k.a.a() == null) goto L6;
        rj0.k.a.a().onProgramStop();
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public cj0.a paidLinkMicContext() {
        return PaidLinkMicContext.Companion.getContext();
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public cj0.b paidLinkMicService() {
        MultiRevenueDataContext.Companion.getClass();
        return MultiRevenueDataContext.a.c();
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public android.util.Pair<String, com.bytedance.android.livesdk.log.filter.v> provideAnchorModeLogInjector() {
        return android.util.Pair.create("AnchorModeLogInjector", com.bytedance.android.live.anchormodelink.util.b.b);
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public android.util.Pair<String, com.bytedance.android.livesdk.log.filter.v> provideChorusInfoLogInjector() {
        return android.util.Pair.create("LiveChorusInfoSendLogFilterId", com.bytedance.android.live.liveinteract.plantform.utils.a0.a);
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public Map<String, String> provideCommonParamsLog() {
        HashMap r0 = new HashMap();
        com.bytedance.android.live.liveinteract.plantform.utils.g r1 = com.bytedance.android.live.liveinteract.plantform.utils.g.a;
        com.bytedance.android.live.liveinteract.plantform.utils.g.a(r0);
        return r0;
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public android.util.Pair<String, com.bytedance.android.livesdk.log.filter.v> provideFromAudienceSourceLogInjector() {
        return android.util.Pair.create("CommonParamsLogInjectorId", com.bytedance.android.live.liveinteract.plantform.utils.g.a);
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public android.util.Pair<String, com.bytedance.android.livesdk.log.filter.v> provideFunctionType2LogInjector() {
        return android.util.Pair.create("CommonParamsLogInjectorId", com.bytedance.android.live.liveinteract.plantform.utils.g.a);
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public android.util.Pair<String, com.bytedance.android.livesdk.log.filter.v> provideFunctionTypeLogInjector() {
        return android.util.Pair.create(this.FunctionTypeLogInjectorId, com.bytedance.android.live.liveinteract.plantform.utils.j.a);
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public android.util.Pair<String, com.bytedance.android.livesdk.log.filter.v> providePlayModeLogInjector() {
        return android.util.Pair.create("LivePlayModeLogInjectorId", com.bytedance.android.live.liveinteract.plantform.utils.b0.a);
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public android.util.Pair<String, com.bytedance.android.livesdk.log.filter.v> provideSubscribeLogInjector() {
        return android.util.Pair.create(this.SubscribeLogInjectorId, com.bytedance.android.live.liveinteract.plantform.utils.q0.b);
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public void refreshLayoutConfig() {
        ln0.a r0 = yg0.h.a;
        yg0.h.k(new com.bytedance.android.live.liveinteract.plantform.commonwindow.h(getCurrentUiLayout(), 0, null, false, 0, false, null, new Triple(0, 0, "refreshLayoutConfig"), null, null, null, 894), new yg0.f(), null);
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public boolean rejectPkWhenReceiveCloudGroupLiveInvite() {
        if (((CloudGroupLiveBeInvitedDialogConfig) com.bytedance.android.live.core.setting.d0.a.getValue()).getDisablePK() == true) goto L6;
        return false;
    L6:
        if (getCloudGroupLiveService() != null) goto L8;
    L11:
        return false;
    L8:
        if (getCloudGroupLiveService().b() != CloudGroupLivePipelineStatus.INVITING) goto L11;
        return true;
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public void resetMultiLinkPerfAbilityManager() {
        com.bytedance.android.live.liveinteract.plantform.performance.a r0 = this.mMultiLinkPerfManager;
        if (r0 == null) goto L6;
        r0.getClass();
        ALogger.i("MultiLinkAtomicAbility-Manager", "destroyPerfAbilityManager bizSize=" + r0.c.size());
        TTExecutors.getNormalExecutor().submit(new com.bytedance.android.live.liveinteract.plantform.performance.b(r0));
        r0.d = false;
        ALogger.i("MultiLinkAtomicAbility-Manager", "destroyPerfAbilityManager finish");
        this.mMultiLinkPerfManager = null;
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    @Nullable
    public com.bytedance.android.live.liveinteract.revenue.fight.b teamFightService() {
        MultiRevenueDataContext.Companion.getClass();
        return MultiRevenueDataContext.a.f();
    }

    public InteractService() {
        this.mVerticalDegradeTask = new InteractBusinessPerformanceStrategyTask();
        this.openDynamicFromAudience = false;
        this.openDynamicFromAudienceGuestCache = false;
        this.FunctionTypeLogInjectorId = "FunctionTypeLogInjectorId";
        this.SubscribeLogInjectorId = "SubscribeLogInjectorId";
        jc1.k.l(IInteractService.class, this);
        e33.l[] r0 = e03.a.a;
        com.bytedance.android.scope.m r1 = com.bytedance.android.scope.m.e;
        e03.a r2 = e03.a.b;
        r1.getClass();
        com.bytedance.android.scope.m.e(r2);
        HashMap r3 = new HashMap();
        if (jc1.k.f(IMiddlewareNetworkService.class) == null) goto L6;
        ((IMiddlewareNetworkService) jc1.k.f(IMiddlewareNetworkService.class)).injectProtoDecoders(r3);
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public boolean canShowCommentShareVideoOpenCloseToast() {
        if (td0.a.a() == true) goto L5;
    L7:
        return false;
    L5:
        if (hd0.c.f().h() == false) goto L7;
        return true;
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public boolean chatRoomIsOpen() {
        if (com.bytedance.android.live.liveinteract.plantform.base.f.a() != null) goto L5;
        return false;
    L5:
        if (com.bytedance.android.live.liveinteract.plantform.base.f.a().nd() == false) goto L7;
    L8:
        return true;
    L7:
        if (com.bytedance.android.live.liveinteract.plantform.base.f.a().s8() == true) goto L8;
        return false;
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public boolean currentIsCPositionUser() {
        return je0.d.j0(je0.d.b0());
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public boolean enableMultiLinkInnerPreload() {
        return MultiLinkLoadWidgetUtils.g();
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public void forceReverseCamera() {
        int r0 = getLinkMode();
        if (gd0.v.a(r0, 32) == false) goto L8;
        rj0.m r1 = getVideoTalkService();
        if (r1 == null) goto L22;
        r1.forceReverseCamera();
        return;
    L22:
        return;
    L8:
        if (gd0.v.a(r0, 2) == true) goto L10;
        return;
    L10:
        if (getInteractAudienceService() == null) goto L25;
        com.bytedance.android.live.liveinteract.plantform.base.d.j0.getClass();
        com.bytedance.android.live.liveinteract.plantform.base.d r2 = com.bytedance.android.live.liveinteract.plantform.base.d.a.a();
        if (r2 == null) goto L16;
        com.bytedance.android.live.pushstream.d r3 = r2.xd();
        if (r3 == null) goto L16;
        r3.i1(new uv0.a(LiveRequestSourceRole.Business, "InteractAudienceImp.switchCapture1", null));
    L16:
        com.bytedance.android.live.liveinteract.plantform.base.e.l0.getClass();
        com.bytedance.android.live.liveinteract.plantform.base.e r4 = com.bytedance.android.live.liveinteract.plantform.base.e.a.a();
        if (r4 == null) goto L26;
        com.bytedance.android.live.pushstream.d r5 = r4.getLiveStream();
        if (r5 == null) goto L27;
        r5.i1(new uv0.a(LiveRequestSourceRole.Business, "InteractAudienceImp.switchCapture2", null));
        return;
    L27:
        return;
    L26:
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public int getAudioTalkRadioPublicScreenTopMargin() {
        if (InteractionWidgetsPosContext.getShared() != null) goto L5;
        return 0;
    L5:
        return ((Integer) InteractionWidgetsPosContext.getShared().getAudioTalkRadioPublicScreenTopMargin().getValue()).intValue();
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public gd0.g getAvatarService() {
        HamletAvatarContext r0 = HamletAvatarContext.getContext();
        if (r0 != null) goto L5;
        return null;
    L5:
        return (gd0.g) r0.getHamletAvatarService().getValue();
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public rj0.d getCommonService() {
        int r0 = getLinkMode();
        if (gd0.v.a(r0, 32) == false) goto L7;
        return getVideoTalkService();
    L7:
        if (gd0.v.a(r0, 8) == false) goto L11;
        return getAudioTalkService();
    L11:
        if (gd0.v.a(r0, 2) == false) goto L15;
        return getInteractAudienceService();
    L15:
        if (this.commonImp != null) goto L18;
        this.commonImp = new com.bytedance.android.live.liveinteract.service.e();
    L18:
        return this.commonImp;
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public List<ILinkPlayerInfoBridge> getCrossRoomFightLinkUserInfoList() {
        int r0 = getLinkMode();
        if (gd0.v.a(r0, 32) == false) goto L13;
        rj0.k.m2.getClass();
        if (rj0.k.a.a() != null) goto L7;
        com.bytedance.android.live.liveinteract.plantform.base.k.n0.getClass();
        if (com.bytedance.android.live.liveinteract.plantform.base.k.a.a() != null) goto L11;
        return null;
    L11:
        return com.bytedance.android.live.liveinteract.plantform.base.k.a.a().getCrossRoomFightLinkUserInfoList();
    L7:
        return rj0.k.a.a().getCrossRoomFightLinkUserInfoList();
    L13:
        if (gd0.v.a(r0, 8) == false) goto L24;
        IVoiceChatAdminService.Companion.getClass();
        if (IVoiceChatAdminService.a.a() != null) goto L17;
        com.bytedance.android.live.liveinteract.voicechat.d.s0.getClass();
        if (com.bytedance.android.live.liveinteract.voicechat.d.a.a() != null) goto L21;
        return null;
    L21:
        return com.bytedance.android.live.liveinteract.voicechat.d.a.a().getCrossRoomFightLinkUserInfoList();
    L17:
        return IVoiceChatAdminService.a.a().getCrossRoomFightLinkUserInfoList();
    L24:
        return null;
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public int getCurUILayout() {
        if (je0.d.h() != null) goto L5;
        return 0;
    L5:
        return je0.d.h().intValue();
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    @Nullable
    public ILinkPlayerInfoBridge getCurrentCPostion() {
        return je0.d.c();
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public String getCurrentFunctionType() {
        return TalkRoomLogUtils.g();
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public List<Integer> getCurrentPlayModes() {
        return je0.d.d();
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public int getCurrentScene() {
        return je0.d.f();
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public int getCurrentUiLayout() {
        Integer r0 = je0.d.h();
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.intValue();
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public String getFunctionTypeForLog() {
        if (vm2.d.v0() == true) goto L5;
        int r0 = getCurrentScene();
        if (r0 != 4) goto L9;
        return "audience";
    L9:
        if (r0 != 5) goto L11;
        com.bytedance.android.livesdk.chatroom.o r1 = com.bytedance.android.live.liveinteract.api.utils.m.i();
        if (r1 != null) goto L21;
    L31:
        return "radio";
    L21:
        if (r1.getRoom().getValue() == null) goto L31;
        if (com.bytedance.android.livesdk.chatroom.interact.model.d0.h((IRoom) r1.getRoom().getValue()) == false) goto L31;
        return "party";
    L11:
        if (r0 == 8) goto L31;
        if (r0 != 9) goto L15;
        return "ktv";
    L15:
        if (r0 == 12) goto L28;
        return "live";
    L28:
        return "party";
    L5:
        return getFunctionType2();
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    @Nullable
    public tf0.h getInteractAnimationService() {
        if (gd0.v.a(getLinkMode(), 32) == false) goto L13;
        rj0.k.m2.getClass();
        if (rj0.k.a.a() != null) goto L7;
        rj0.l.n2.getClass();
        if (rj0.l.a.a() != null) goto L11;
        return null;
    L11:
        return rj0.l.a.a().getInteractAnimationService();
    L7:
        return rj0.k.a.a().getInteractAnimationService();
    L13:
        if (gd0.v.a(getLinkMode(), 8) == false) goto L28;
        com.bytedance.android.live.liveinteract.voicechat.d.s0.getClass();
        if (com.bytedance.android.live.liveinteract.voicechat.d.a.a() != null) goto L17;
        IVoiceChatGuestService.Companion.getClass();
        if (IVoiceChatGuestService.a.a() == null) goto L23;
        return IVoiceChatGuestService.a.a().getInteractAnimationService();
    L23:
        if (jc1.k.f(IKtvService.class).getInteractAnimationService() != null) goto L25;
        return null;
    L25:
        return (tf0.h) jc1.k.f(IKtvService.class).getInteractAnimationService();
    L17:
        return com.bytedance.android.live.liveinteract.voicechat.d.a.a().getInteractAnimationService();
    L28:
        return null;
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService, gd0.n
    public String getLinkConnectionType() {
        int r0 = getLinkMode();
        if (gd0.v.a(r0, 64) == true) goto L32;
        String r2 = "";
        if (gd0.v.a(r0, 4) == false) goto L20;
        int r1 = jc1.k.f(IMultiLinkServiceExternal.class).getMultiDataHolderExternal().getMatchType();
        int r3 = oc0.a.a;
        if (r1 != 0) goto L11;
        r2 = "manual_pk";
    L17:
        if (TextUtils.isEmpty(jc1.k.f(IMultiLinkServiceExternal.class).getMultiDataHolderExternal().w()) == true) goto L35;
        return jc1.k.f(IMultiLinkServiceExternal.class).getMultiDataHolderExternal().w();
    L35:
        return r2;
    L11:
        if (r1 != 1) goto L14;
    L12:
        r2 = "random_pk";
        goto L17
    L14:
        if (r1 != 3) goto L17;
    L20:
        if (gd0.v.a(r0, 2) == false) goto L22;
    L30:
        return "audience";
    L22:
        if (gd0.v.a(r0, 8) == true) goto L30;
        if (gd0.v.a(r0, 32) == true) goto L30;
        if (gd0.v.a(r0, 128) == false) goto L35;
        return "game_anchor_connection";
    L32:
        return jc1.k.f(IMultiLinkServiceExternal.class).getMultiDataHolderExternal().z();
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public int getLinkMode() {
        com.bytedance.android.live.liveinteract.plantform.base.g r0 = com.bytedance.android.live.liveinteract.plantform.base.f.a();
        if (r0 == null) goto L7;
        return r0.getCurrentMode() | jc1.k.f(IMultiLinkServiceExternal.class).getControlServiceExternal().getCurrentMode();
    L7:
        return jc1.k.f(IMultiLinkServiceExternal.class).getControlServiceExternal().getCurrentMode() | 0;
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService, gd0.n
    public com.bytedance.android.live.liveinteract.plantform.base.i<ILinkPlayerInfoBridge> getLinkUserInfoCenter() {
        int r0 = getLinkMode();
        ALogger.i("InteractService", "getLinkUserInfoCenter:" + r0);
        if (vm2.d.q0().isUserInfoCenterForwardInit() == false) goto L15;
        if (gd0.v.a(r0, 32) == true) goto L11;
        if (gd0.v.a(r0, 8) == true) goto L11;
        if (gd0.v.a(r0, 2) == true) goto L11;
        return null;
    L11:
        if (com.bytedance.android.live.liveinteract.plantform.base.f.a() != null) goto L13;
        return null;
    L13:
        return com.bytedance.android.live.liveinteract.plantform.base.f.a().getLinkUserInfoCenter();
    L15:
        if (gd0.v.a(r0, 32) == false) goto L25;
        rj0.k.m2.getClass();
        if (rj0.k.a.a() != null) goto L19;
        com.bytedance.android.live.liveinteract.plantform.base.k.n0.getClass();
        if (com.bytedance.android.live.liveinteract.plantform.base.k.a.a() != null) goto L23;
        return null;
    L23:
        return com.bytedance.android.live.liveinteract.plantform.base.k.a.a().getLinkUserInfoCenter();
    L19:
        return rj0.k.a.a().getLinkUserInfoCenter();
    L25:
        if (gd0.v.a(r0, 8) == false) goto L37;
        IVoiceChatAdminService.Companion.getClass();
        if (IVoiceChatAdminService.a.a() != null) goto L29;
        com.bytedance.android.live.liveinteract.voicechat.d.s0.getClass();
        if (com.bytedance.android.live.liveinteract.voicechat.d.a.a() != null) goto L33;
        int r1 = com.bytedance.android.live.liveinteract.plantform.utils.s0.a;
        return jc1.k.f(IKtvService.class).getLinkUserInfoCenter();
    L33:
        return com.bytedance.android.live.liveinteract.voicechat.d.a.a().getLinkUserInfoCenter();
    L29:
        return IVoiceChatAdminService.a.a().getLinkUserInfoCenter();
    L37:
        if (gd0.v.a(r0, 2) == false) goto L50;
        com.bytedance.android.live.liveinteract.plantform.base.d.j0.getClass();
        if (com.bytedance.android.live.liveinteract.plantform.base.d.a.a() != null) goto L41;
        com.bytedance.android.live.liveinteract.plantform.base.c.i0.getClass();
        if (com.bytedance.android.live.liveinteract.plantform.base.c.a.a() != null) goto L45;
        return null;
    L45:
        return com.bytedance.android.live.liveinteract.plantform.base.c.a.a().getLinkUserCenter();
    L41:
        return com.bytedance.android.live.liveinteract.plantform.base.d.a.a().getLinkUserCenter();
    L50:
        return null;
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public String getLiveTypeForLog() {
        com.bytedance.android.livesdk.chatroom.o r0 = com.bytedance.android.live.liveinteract.api.utils.m.i();
        if (r0 != null) goto L5;
        return "";
    L5:
        if (r0.getRoom() != null) goto L7;
        return "";
    L7:
        if (r0.getRoom().getValue() != null) goto L9;
        return "";
    L9:
        if (((IRoom) r0.getRoom().getValue()).getStreamType() != LiveMode.VIDEO) goto L12;
        return "video_live";
    L12:
        if (((IRoom) r0.getRoom().getValue()).getStreamType() != LiveMode.AUDIO) goto L15;
        return "voice_live";
    L15:
        if (((IRoom) r0.getRoom().getValue()).getStreamType() != LiveMode.SCREEN_RECORD) goto L18;
        return "game";
    L18:
        if (((IRoom) r0.getRoom().getValue()).getStreamType() != LiveMode.THIRD_PARTY) goto L27;
        return "third_party";
    L27:
        return "";
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public int getMultiInteractMode() {
        if (com.bytedance.android.live.liveinteract.plantform.base.f.a() != null) goto L5;
        return 0;
    L5:
        return com.bytedance.android.live.liveinteract.plantform.base.f.a().getCurrentMode();
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public int getOnLineCountFromPk() {
        if (gd0.v.a(getLinkMode(), 4) == false) goto L8;
        yr0.b r0 = ((IMultiPkAudienceLinkOutService) jc1.k.f(IMultiPkAudienceLinkOutService.class)).getPkLinkUserInfoCenter();
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.b();
    L8:
        return 0;
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public String getXplayChannel() {
        if (qi0.e.c() == true) goto L5;
        return null;
    L5:
        if (RoomContext.getShared() != null) goto L7;
        return null;
    L7:
        if (RoomContext.getShared().isPrivateRoom() == true) goto L9;
        return null;
    L9:
        return ((GroupLiveGameConfig) mz.a.getValue()).getChannel();
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    @Nullable
    public com.bytedance.android.live.liveinteract.revenue.battle.b0 guestBattleContext() {
        return GuestBattleContext.getContext();
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public void handleInteractClick() {
        if (com.bytedance.android.live.liveinteract.plantform.base.f.a() == null) goto L6;
        com.bytedance.android.live.liveinteract.plantform.base.f.a().handleInteractClick();
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public boolean hasEmptySeatForLink() {
        int r0 = getCurrentScene();
        if (r0 != 5) goto L5;
    L38:
        IVoiceChatGuestService.Companion.getClass();
        IVoiceChatGuestService r1 = IVoiceChatGuestService.a.a();
        if (r1 != null) goto L41;
    L43:
        int r2 = 0;
    L44:
        if (r2 < 9) goto L46;
        return false;
    L46:
        return true;
    L41:
        if (r1.getLinkUserInfoCenter() == null) goto L43;
        r2 = r1.getLinkUserInfoCenter().getOnlineUserList().size();
        goto L44
    L5:
        if (r0 != 12) goto L7;
        rj0.l.n2.getClass();
        rj0.l r3 = rj0.l.a.a();
        if (r3 != null) goto L33;
    L35:
        int r4 = 0;
    L36:
        if (r4 < 9) goto L46;
        return false;
    L33:
        if (r3.getLinkUserInfoCenter() == null) goto L35;
        r4 = r3.getLinkUserInfoCenter().getOnlineUserList().size();
        goto L36
    L7:
        if (r0 != 16) goto L9;
        rj0.l.n2.getClass();
        rj0.l r5 = rj0.l.a.a();
        if (r5 != null) goto L24;
    L26:
        int r6 = 0;
    L28:
        if (r6 < 6) goto L46;
        return false;
    L24:
        if (r5.getLinkUserInfoCenter() == null) goto L26;
        r6 = r5.getLinkUserInfoCenter().getOnlineUserList().size();
        goto L28
    L9:
        if (r0 == 8) goto L12;
        if (r0 == 9) goto L38;
        return false;
    L12:
        rj0.l.n2.getClass();
        rj0.l r7 = rj0.l.a.a();
        if (r7 != null) goto L15;
    L17:
        int r8 = 0;
    L19:
        if (r8 < 7) goto L46;
        return false;
    L15:
        if (r7.getLinkUserInfoCenter() == null) goto L17;
        r8 = r7.getLinkUserInfoCenter().getOnlineUserList().size();
        goto L19
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public boolean hitStageAB() {
        if (com.bytedance.android.live.liveinteract.api.utils.m.i() != null) goto L5;
        return false;
    L5:
        if (com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom() != null) goto L7;
        return false;
    L7:
        if (com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom().getValue() == null) goto L13;
        int r0 = com.bytedance.android.live.liveinteract.voicechat.stage.a.a;
        return com.bytedance.android.live.liveinteract.voicechat.stage.a.c((IRoom) com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom().getValue());
    L13:
        return false;
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public void initAndTurnOnChorusKTV() {
        if (com.bytedance.android.live.liveinteract.plantform.base.f.a() == null) goto L6;
        com.bytedance.android.live.liveinteract.plantform.base.f.a().initAndTurnOnChorusKTV();
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public void initAndTurnOnKTV() {
        if (com.bytedance.android.live.liveinteract.plantform.base.f.a() == null) goto L6;
        com.bytedance.android.live.liveinteract.plantform.base.f.a().initAndTurnOnKTV();
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public void initAndTurnOnVoiceChatRoom() {
        if (com.bytedance.android.live.liveinteract.plantform.base.f.a() == null) goto L6;
        com.bytedance.android.live.liveinteract.plantform.base.f.a().initAndTurnOnVoiceChatRoom();
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public boolean isAIMVStage() {
        InteractiveSongContext r0 = InteractiveSongContext.getContext();
        if (r0 == null) goto L8;
        com.bytedance.live.datacontext.m<Boolean> r1 = r0.isAIMVStage();
        if (r1.getValue() != null) goto L7;
        return false;
    L7:
        return ((Boolean) r1.getValue()).booleanValue();
    L8:
        return false;
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public boolean isCurrentSceneSupportShowCastEntrance() {
        if (getCurrentScene() != 8) goto L5;
    L12:
        return true;
    L5:
        if (getCurrentScene() == 12) goto L12;
        if (getCurrentScene() == 16) goto L12;
        if (getCurrentScene() == 0) goto L12;
        return false;
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public boolean isGroupLiveGame() {
        return qi0.e.c();
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public boolean isGuestLinker() {
        if (GuestLinkContext.getContext() != null) goto L5;
        return false;
    L5:
        return GuestLinkContext.getContext().isLinker();
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public boolean isInLinkMicGameAnchorLinkMode() {
        return qi0.e.d();
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public boolean isLinkCasting() {
        if (getCurrentScene() != 0) goto L12;
        va1.b r0 = va1.b.a.a;
        if (r0.a(IMiddlewareBroadcastService.class) == null) goto L12;
        if (((IMiddlewareBroadcastService) r0.a(IMiddlewareBroadcastService.class)).isCasting() == false) goto L9;
    L10:
        return true;
    L9:
        if (((IMiddlewareBroadcastService) r0.a(IMiddlewareBroadcastService.class)).isAudienceCasting() == true) goto L10;
        return false;
    L12:
        rj0.k.m2.getClass();
        if (rj0.k.a.a() != null) goto L15;
        rj0.l.n2.getClass();
        if (rj0.l.a.a() != null) goto L19;
        com.bytedance.android.livesdk.chatroom.o r1 = com.bytedance.android.live.liveinteract.api.utils.m.i();
        if (r1 != null) goto L23;
    L33:
        return false;
    L23:
        if (r1.getRoom() == null) goto L33;
        if (r1.getRoom().getValue() == null) goto L33;
        if (((IRoom) r1.getRoom().getValue()).getLinkerDetail() == null) goto L33;
        if (((IRoom) r1.getRoom().getValue()).getLinkerDetail().getPlayModes() == null) goto L33;
        if (((IRoom) r1.getRoom().getValue()).getLinkerDetail().getPlayModes().contains(20L) == false) goto L33;
        return true;
    L19:
        return rj0.l.a.a().isLinkCasting();
    L15:
        return rj0.k.a.a().isLinkCasting();
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public boolean isLinkEverCast() {
        com.bytedance.android.livesdk.chatroom.o r0 = com.bytedance.android.live.liveinteract.api.utils.m.i();
        if (isMultiLive() == false) goto L16;
        if (r0 == null) goto L16;
        if (r0.getRoom() == null) goto L16;
        if (r0.getRoom().getValue() == null) goto L16;
        if (((IRoom) r0.getRoom().getValue()).getLinkerDetail() == null) goto L16;
        if (((IRoom) r0.getRoom().getValue()).getLinkerDetail().getPlayModes() == null) goto L16;
        if (((IRoom) r0.getRoom().getValue()).getLinkerDetail().getPlayModes().contains(20L) == false) goto L16;
        return true;
    L16:
        if (r0 != null) goto L18;
    L22:
        if (r0 != null) goto L24;
    L30:
        return false;
    L24:
        if (r0.getRoom() == null) goto L30;
        if (r0.getRoom().getValue() == null) goto L30;
        if (everCastingSet.contains(Long.valueOf(((IRoom) r0.getRoom().getValue()).getRoomId())) == false) goto L30;
        return true;
    L18:
        if (r0.E2() == null) goto L22;
        if (((Boolean) r0.E2().getValue()).booleanValue() == false) goto L22;
        return true;
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public boolean isMultiLive() {
        com.bytedance.android.livesdk.chatroom.o r0 = com.bytedance.android.live.liveinteract.api.utils.m.i();
        if (r0 == null) goto L14;
        if (r0.getRoom() == null) goto L14;
        IRoom r1 = (IRoom) r0.getRoom().getValue();
        if (r1.getLinkMap() == null) goto L14;
        if (r1.getLinkMap().isEmpty() == true) goto L14;
        if (r1.getLinkMap().containsKey(String.valueOf(0)) == true) goto L14;
        return true;
    L14:
        if (getCurrentScene() != 0) goto L18;
        return false;
    L18:
        return true;
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public boolean isPaidInteractAudienceOnOrBiddingOpen() {
        return fj0.e.l();
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public boolean isSelfVoiceChatRoomAudience() {
        return getAudioTalkService().isSelfVoiceChatRoomAudience();
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public boolean isSupportLinkCastMiniApp() {
        if (getCurrentScene() != 0) goto L14;
        com.bytedance.android.livesdk.chatroom.o r0 = com.bytedance.android.live.liveinteract.api.utils.m.i();
        if (r0 != null) goto L7;
        return false;
    L7:
        if (r0.getRoom() != null) goto L9;
        return false;
    L9:
        if (r0.getRoom().getValue() != null) goto L11;
        return false;
    L11:
        if (((IRoom) r0.getRoom().getValue()).getStreamType() != LiveMode.VIDEO) goto L22;
        return true;
    L22:
        return false;
    L14:
        rj0.k.m2.getClass();
        if (rj0.k.a.a() != null) goto L17;
        return false;
    L17:
        return rj0.k.a.a().isSupportLinkCastMiniApp();
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public boolean isVideoChorus() {
        return je0.d.L();
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public boolean isVoiceRadioLink() {
        return je0.d.P();
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public boolean isXplayEnableAudioFrame() {
        return qi0.e.b();
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public boolean isXplayFullScreenMode() {
        if (FoldScreenUtils.e() == false) goto L5;
    L14:
        return false;
    L5:
        if (PadConfigUtils.c() == true) goto L14;
        if (qi0.e.c() == false) goto L14;
        if (RoomContext.getShared() == null) goto L14;
        if (RoomContext.getShared().isPrivateRoom() != true) goto L14;
        return true;
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public void multiAnchorLoadVideoTalk() {
        if (com.bytedance.android.live.liveinteract.plantform.base.f.a() == null) goto L6;
        com.bytedance.android.live.liveinteract.plantform.base.f.a().multiAnchorLoadVideoTalk();
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public void multiAnchorUnloadVideoTalk() {
        if (com.bytedance.android.live.liveinteract.plantform.base.f.a() == null) goto L6;
        com.bytedance.android.live.liveinteract.plantform.base.f.a().multiAnchorUnloadVideoTalk();
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public void pkInviteFailLoadWidget() {
        if (com.bytedance.android.live.liveinteract.plantform.base.f.a() == null) goto L6;
        com.bytedance.android.live.liveinteract.plantform.base.f.a().pkInviteFailLoadWidget();
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public void pkInviteUnloadWidget() {
        if (com.bytedance.android.live.liveinteract.plantform.base.f.a() == null) goto L6;
        com.bytedance.android.live.liveinteract.plantform.base.f.a().pkInviteUnloadWidget();
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public android.util.Pair<Boolean, String> subtitleExceptPlayModeOpen() {
        if (linkRoomFightService() == null) goto L9;
        if (linkRoomFightService().isFightShowing() == false) goto L9;
        return new android.util.Pair(Boolean.TRUE, com.bytedance.android.live.core.utils.s1.B(2131919515));
    L9:
        return new android.util.Pair(Boolean.FALSE, "");
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public boolean supportInteractActing() {
        int r0 = getCurrentScene();
        return ((LiveInteractActingConfig) com.bytedance.android.live.core.setting.z1.a.getValue()).getSupportSceneList().contains(String.valueOf(r0));
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public boolean dynamicFromAudience() {
        return this.openDynamicFromAudience;
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public boolean dynamicFromAudienceGuestCache() {
        return this.openDynamicFromAudienceGuestCache;
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    @Nullable
    public ai0.e getAdventureService() {
        return ai0.c.a;
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public com.bytedance.android.live.liveinteract.utils.k getInteractLogUtils() {
        return jf0.c.b;
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public com.bytedance.android.live.liveinteract.utils.l getLinkMicGameFullLinkMonitor() {
        return qi0.a.j;
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public com.bytedance.android.live.liveinteract.utils.m getLinkMicGameLogUtils() {
        return qi0.c.d;
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public com.bytedance.android.live.liveinteract.utils.n getLinkMicGameTraceUtils() {
        return qi0.d.a;
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public com.bytedance.android.live.liveinteract.utils.o getLinkMicXplayBasicFullLinkMonitor() {
        return ff0.g.e;
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public com.bytedance.android.live.liveinteract.utils.p getLinkMicXplayBasicTraceUtils() {
        return ff0.h.a;
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public Class<? extends Widget> getLinkmicSubtitleUIWidget() {
        return LinkmicSubtitleUIWidget.class;
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public Class<? extends LiveRecyclableWidget> getLiveMatrixEntranceWidget() {
        return LiveMatrixEntranceWidget.class;
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public gj0.a getStarWishService() {
        return gj0.f.a;
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public com.bytedance.android.live.liveinteract.utils.q getTalkRoomLogUtils() {
        return TalkRoomLogUtils.B;
    }

    public static void INVOKEVIRTUAL_com_bytedance_android_live_multilink_impl_InteractService_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(MultiLinkEnlargeSelectGuestDialog r1) {
        if (DialogLancet.shouldBlockDialogShow(r1) == false) goto L10;
        DialogLancet.handleBlockedDialogShow(r1);
        return;
    L10:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L9
    L7:
        DialogLancet.beforeDialogShow(r1);
        r1.show();
        DialogLancet.afterDialogShow(r1);
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public void addBusinessDegradeStrategy(com.bytedance.android.livesdk.a r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        InteractBusinessPerformanceStrategyTask r0 = this.mVerticalDegradeTask;
        if (r0.isInit == true) goto L7;
        r0.init();
    L7:
        this.mVerticalDegradeTask.addBusinessDegradeStrategy(r3);
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public String changeMode2String(int r4) {
        com.bytedance.android.livesdk.chatroom.u r0 = com.bytedance.android.live.liveinteract.api.utils.m.d();
        com.bytedance.android.livesdk.chatroom.o r1 = com.bytedance.android.live.liveinteract.api.utils.m.i();
        if (r0 == null) goto L11;
        if (r0.I1() == null) goto L11;
        if (((Boolean) r0.I1().getValue()).booleanValue() == false) goto L11;
        return "voice_sing_room";
    L11:
        if (gd0.v.a(r4, 64) == false) goto L15;
        return "video_anchor_connect";
    L15:
        if (gd0.v.a(r4, 32) == false) goto L23;
        if (getCurrentScene() != 12) goto L20;
        return "video_friend_room";
    L20:
        return "video_audience_multi";
    L23:
        if (gd0.v.a(r4, 8) == false) goto L27;
        return "voice_audience_multi";
    L27:
        if (gd0.v.a(r4, 4) == false) goto L31;
        return "video_anchor_pk";
    L31:
        if (gd0.v.a(r4, 2) == false) goto L34;
        return "video_audience_double";
    L34:
        if (r1 != null) goto L36;
        return "";
    L36:
        if (r1.getRoom() != null) goto L38;
        return "";
    L38:
        if (jc1.k.f(IMiddlewareMicRoomService.class) != null) goto L40;
        return "";
    L40:
        if (jc1.k.f(IMiddlewareMicRoomService.class).isMicRoom((IRoom) r1.getRoom().getValue()) == false) goto L47;
        return "video_anchor_order";
    L47:
        return "";
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public void clickLinkRoomFightIcon(Map<String, String> r3) {
        xi0.a r0 = linkRoomFightService();
        if (r0 == null) goto L6;
        r0.d0(bj0.a.b, r3);
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public void commonWMUpdateLiveCoreAndRtcInfo(String r2) {
        rj0.k.m2.getClass();
        if (rj0.k.a.a() == null) goto L5;
        rj0.k.a.a().commonWMUpdateLiveCoreAndRtcInfo(r2);
        return;
    L5:
        rj0.l.n2.getClass();
        if (rj0.l.a.a() == null) goto L10;
        rj0.l.a.a().commonWMUpdateLiveCoreAndRtcInfo(r2);
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public void composeMultiLinkDisposableCall(Disposable r2) {
        if (com.bytedance.android.live.liveinteract.plantform.base.f.a() == null) goto L6;
        com.bytedance.android.live.liveinteract.plantform.base.f.a().mq(r2);
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public ih0.b createDynamicWidget(ViewGroup r3) {
        int r0 = PlayModeService.g;
        if (r3 != null) goto L6;
        return null;
    L6:
        return new MultiLinkDynamicWidgetNew(r3, null);
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b createInteractActingBehavior(Context r2) {
        return new mf0.c(r2);
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b createInteractiveSongBehavior(Context r2) {
        return new nf0.a(r2);
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b createInteractiveToolsBehavior(Context r2) {
        return new rf0.a(r2);
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public boolean currentUILayoutNeedAdjustCommentHeight(DataCenter r3) {
        MultiLinkFrequencyOptConfig r0 = com.bytedance.android.live.liveinteract.plantform.commonwindow.utils.f.a;
        int r4 = getUiLayout(r3);
        if (r4 != 5) goto L5;
    L19:
        return true;
    L5:
        if (r4 == 2) goto L19;
        if (r4 == 3) goto L19;
        if (r4 == 11) goto L19;
        if (r4 == 12) goto L19;
        if (r4 == 3) goto L19;
        if (r4 == 43) goto L19;
        if (aj0.b.c(r4) == true) goto L19;
        return false;
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    @Nullable
    public ih0.b dynamicService(@Nullable DataCenter r3) {
        return MultiLinkDynamicContext.Companion.a(r3, null);
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public boolean enableCaptureAudioOnBackground(boolean r11) {
        if (NotificationManagerCompat.from(jc1.a.b()).areNotificationsEnabled() == true) goto L5;
        return false;
    L5:
        ReadOnlyProperty r0 = vm2.c.u;
        KProperty[] r2 = vm2.c.a;
        if (((Boolean) r0.getValue(null, r2[19])).booleanValue() == false) goto L8;
    L13:
        ALogger.d("zbd-test", "roomService2 = " + jc1.k.f(IMiddlewareRoomService.class));
        if (jc1.k.f(IMiddlewareRoomService.class).isOnNeedMuteAudioFullPage() == false) goto L16;
        return false;
    L16:
        IMiddlewareRoomService r1 = jc1.k.f(IMiddlewareRoomService.class);
        if (r1 == null) goto L24;
        if (r1.isOpenImagePickerForCustomEmoji() == false) goto L24;
        if (((Boolean) vm2.c.v.getValue(null, r2[20])).booleanValue() == false) goto L24;
        return false;
    L24:
        if (com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom() == null) goto L26;
        IRoom r3 = (IRoom) com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom().getValue();
    L27:
        if (r3 != null) goto L29;
        String r4 = "";
    L30:
        String r5 = jc1.k.f(IMiddlewareUserService.class).user().n();
        if (TextUtils.equals(r4, r5) == false) goto L33;
        boolean r6 = ((Boolean) vm2.c.x.getValue(null, r2[22])).booleanValue();
    L34:
        int r7 = ((IInteractService) jc1.k.f(IInteractService.class)).getLinkMode();
        if (r7 == 32) goto L37;
        if (r7 == 8) goto L43;
    L52:
        int r8 = -1;
    L54:
        if (r8 == (-1)) goto L64;
        if (r8 == 0) goto L63;
        if (r8 == 1) goto L64;
        if (r8 == 2) goto L64;
        if (r8 != 3) goto L64;
        boolean r12 = !r11;
    L65:
        if (r7 != 8) goto L72;
        if (Objects.equals(r4, r5) == false) goto L72;
        ((IMiddlewareBroadcastService) va1.b.a.a.a(IMiddlewareBroadcastService.class)).broadcastFloatWindowManager();
        throw null;
    L72:
        if (jc1.k.f(IMiddlewareLiveVideoFloatWindowService.class).isFloatOpen() == true) goto L74;
    L76:
        boolean r9 = false;
    L77:
        if (r12 == false) goto L82;
        if (r6 == false) goto L83;
        if (r9 == true) goto L84;
        return true;
    L84:
        return false;
    L83:
        return false;
    L82:
        return false;
    L74:
        if (((Integer) ((ge1.a) hd0.c.f()).b).intValue() != 0) goto L76;
        r9 = true;
        goto L77
    L63:
        r12 = true;
    L64:
        r12 = false;
        goto L65
    L43:
        if (Objects.equals(r4, r5) == false) goto L48;
        com.bytedance.android.live.liveinteract.voicechat.d.s0.getClass();
        if (com.bytedance.android.live.liveinteract.voicechat.d.a.a() == null) goto L47;
        r8 = com.bytedance.android.live.liveinteract.voicechat.d.a.a().getSelfSilenceType();
        goto L54
    L47:
        r8 = jc1.k.f(IKtvService.class).getSelfSilenceType();
        goto L54
    L48:
        IVoiceChatGuestService.Companion.getClass();
        if (IVoiceChatGuestService.a.a() == null) goto L51;
        r8 = IVoiceChatGuestService.a.a().getSelfSilenceType();
        goto L54
    L51:
        r8 = jc1.k.f(IKtvService.class).getSelfSilenceType();
        goto L54
    L37:
        if (Objects.equals(r4, r5) == true) goto L52;
        rj0.l.n2.getClass();
        if (rj0.l.a.a() == null) goto L52;
        r8 = rj0.l.a.a().getSelfSilenceType();
        goto L54
    L33:
        r6 = ((Boolean) vm2.c.y.getValue(null, r2[23])).booleanValue();
        goto L34
    L29:
        r4 = r3.getOwnerUserIdString();
        goto L30
    L26:
        r3 = null;
        goto L27
    L8:
        if (tb1.c.c == true) goto L11;
        return false;
    L11:
        if (((Boolean) vm2.c.w.getValue(null, r2[21])).booleanValue() == true) goto L13;
        return false;
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public boolean enableMultiEnlarge(String r2) {
        CPositionContext.Companion.getClass();
        return CPositionContext.a.a(r2);
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public boolean finishAudioTalk(String r3) {
        com.bytedance.android.live.liveinteract.voicechat.d.s0.getClass();
        com.bytedance.android.live.liveinteract.voicechat.d r4 = com.bytedance.android.live.liveinteract.voicechat.d.a.a();
        if (r4 == null) goto L9;
        IInteractService r0 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r0 == null) goto L7;
        r0.updateSwitchSceneSource("link_setting_panel");
    L7:
        r4.finishAudioTalk("link_setting_panel");
        return true;
    L9:
        return false;
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public void finishVideoTalk(String r2) {
        com.bytedance.android.live.liveinteract.plantform.base.d.j0.getClass();
        if (com.bytedance.android.live.liveinteract.plantform.base.d.a.a() == null) goto L6;
        com.bytedance.android.live.liveinteract.plantform.base.d.a.a().finishInteract(r2);
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public List<zo2.a> getAllNitaInfos(boolean r4) {
        SparseArray<List<zo2.a>> r0 = VerticalNitaInflate.a;
        HashSet r1 = new HashSet();
        if (r4 == false) goto L5;
        SparseArray<List<zo2.a>> r5 = VerticalNitaInflate.b;
    L6:
        int r2 = 0;
    L8:
        if (r2 >= r5.size()) goto L11;
        r1.addAll(r5.valueAt(r2));
        r2 = r2 + 1;
        goto L8
    L11:
        return new ArrayList(r1);
    L5:
        r5 = VerticalNitaInflate.a;
        goto L6
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public int getAudioTalkRadioBottomOffset(IRoom r6) {
        long r0 = 0;
        if (r6 == null) goto L5;
        long r2 = r6.getRoomId();
    L7:
        if (InteractionWidgetsPosContext.getShared(null, r2) == null) goto L12;
        if (r6 == null) goto L11;
        r0 = r6.getRoomId();
    L11:
        return ((Integer) InteractionWidgetsPosContext.getShared(null, r0).getAudioTalkRadioBottomOffset().getValue()).intValue();
    L12:
        return 0;
    L5:
        r2 = 0;
        goto L7
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public int getAudioTalkSeatBottomPos(IRoom r7) {
        int r0 = (com.bytedance.android.live.core.utils.s1.j(2131169237) + com.bytedance.android.live.core.utils.s1.j(2131169234)) + com.bytedance.android.live.core.utils.s1.j(2131169276);
        long r1 = 0;
        if (r7 == null) goto L5;
        long r3 = r7.getRoomId();
    L7:
        if (InteractionWidgetsPosContext.getShared(null, r3) == null) goto L16;
        if (r7 == null) goto L10;
        long r4 = r7.getRoomId();
    L12:
        if (InteractionWidgetsPosContext.getShared(null, r4).getAudioTalkBottomPos() == null) goto L16;
        if (r7 == null) goto L15;
        r1 = r7.getRoomId();
    L15:
        r0 = ((Integer) InteractionWidgetsPosContext.getShared(null, r1).getAudioTalkBottomPos().getValue()).intValue();
        goto L16
    L10:
        r4 = 0;
    L16:
        com.bytedance.android.livesdk.chatroom.u r2 = com.bytedance.android.live.liveinteract.api.utils.m.d();
        if (r2 != null) goto L19;
    L25:
        Integer r5 = je0.d.h();
        if (r5 != null) goto L29;
    L31:
        boolean r6 = false;
    L32:
        if (r6 == false) goto L35;
        r0 = r0 + com.bytedance.android.live.core.utils.s1.f(((Float) fb0.a.getValue()).floatValue());
    L35:
        if (teamFightService() != null) goto L37;
    L39:
        android.util.Pair<Boolean, Integer> r8 = needAdjustPublicScreenHeightForSubtitle(r7);
        if (((Boolean) r8.first).booleanValue() == true) goto L42;
        return r0;
    L42:
        return r0 + ((Integer) r8.second).intValue();
    L37:
        if (teamFightService().s5() == false) goto L39;
        r0 = r0 + com.bytedance.android.live.core.utils.s1.f(32.0f);
        goto L39
    L29:
        if (r5.intValue() != 66) goto L31;
        r6 = true;
        goto L32
    L19:
        if (r2.s() == null) goto L25;
        if (r2.s().getValue() == null) goto L25;
        if (((com.bytedance.android.livesdk.chatroom.viewmodel.f) r2.s().getValue()).t().b != 24) goto L25;
        r0 = r0 + com.bytedance.android.live.core.utils.s1.f(32.0f);
        goto L25
    L5:
        r3 = 0;
        goto L7
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    @Nullable
    public iy.g getDynamicCenterService(DataCenter r1) {
        return com.bytedance.android.live.anchormodelink.linkroom.a.a(r1);
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    @Nullable
    public tf0.h getInteractAnimationService(DataCenter r3) {
        iy.g r4 = getDynamicCenterService(r3);
        if (r4 == null) goto L9;
        if (r4.getCurrentScene() != 20) goto L9;
        return r4.getInteractAnimationService();
    L9:
        return getInteractAnimationService();
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public uf2.d0 getLiveCore(boolean r3) {
        if (r3 == false) goto L10;
        com.bytedance.android.livesdk.chatroom.o r4 = com.bytedance.android.live.liveinteract.api.utils.m.i();
        if (r4 == null) goto L33;
        com.bytedance.android.live.pushstream.d r5 = (com.bytedance.android.live.pushstream.d) r4.getLiveStream().getValue();
        if (r5 == null) goto L33;
        return r5.A();
    L33:
        return null;
    L10:
        com.bytedance.android.live.liveinteract.plantform.base.e.l0.getClass();
        com.bytedance.android.live.liveinteract.plantform.base.e r6 = com.bytedance.android.live.liveinteract.plantform.base.e.a.a();
        if (r6 == null) goto L16;
        com.bytedance.android.live.pushstream.d r7 = r6.getLiveStream();
        if (r7 == null) goto L16;
        return r7.A();
    L16:
        rj0.l.n2.getClass();
        rj0.l r8 = rj0.l.a.a();
        if (r8 == null) goto L22;
        com.bytedance.android.live.pushstream.d r9 = r8.getLiveStream();
        if (r9 == null) goto L22;
        return r9.A();
    L22:
        IVoiceChatAdminService.Companion.getClass();
        IVoiceChatAdminService r10 = IVoiceChatAdminService.a.a();
        if (r10 == null) goto L33;
        if (r10.rtcManger() == null) goto L33;
        ec6.b r11 = r10.rtcManger().R();
        if (r11 == null) goto L29;
        com.bytedance.android.live.pushstream.d r12 = gc6.b.a(r11);
    L30:
        if (r12 == null) goto L33;
        return r12.A();
    L29:
        r12 = null;
        goto L30
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public ILivePreviewAnchorModeLinkCommonWidget getLivePreviewAnchorModeDynamicWidget(Object r2) {
        return new LivePreviewAnchorModeDynamicWidget(r2);
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public com.bytedance.android.live.liveinteract.plantform.performance.a getMultiLinkPerfAbilityManager(boolean r5) {
        if (this.mMultiLinkPerfManager != null) goto L12;
        if (r5 == false) goto L12;
        com.bytedance.android.live.liveinteract.plantform.performance.a r6 = new com.bytedance.android.live.liveinteract.plantform.performance.a();
        this.mMultiLinkPerfManager = r6;
        StringBuilder r0 = new StringBuilder("initPerfAbilityManager init=");
        r0.append(r6.d);
        r0.append(" enable=");
        c60 r1 = c60.a;
        r0.append(((MultiLinkPerfBalanceConfig) r1.getValue()).getPerfBalanceEnable());
        ALogger.i("MultiLinkAtomicAbility-Manager", r0.toString());
        if (((MultiLinkPerfBalanceConfig) r1.getValue()).getPerfBalanceEnable() == false) goto L12;
        if (r6.d == true) goto L12;
        LinkedHashMap r2 = new LinkedHashMap();
        r2.put("multilink_base_degrade", com.bytedance.android.live.liveinteract.plantform.performance.h.a);
        r2.put("multilink_dynamic_bg", com.bytedance.android.live.liveinteract.plantform.performance.j.b);
        r2.put("multilink_extreme_degrade", com.bytedance.android.live.liveinteract.plantform.performance.l.a);
        r2.put("multilink_ktv_base", com.bytedance.android.live.liveinteract.plantform.performance.n.a);
        r2.put("multilink_ktv_preview_song", com.bytedance.android.live.liveinteract.plantform.performance.p.a);
        r2.put("multilink_radio_base_degrade", com.bytedance.android.live.liveinteract.plantform.performance.r.a);
        r2.put("multilink_sei_consume", com.bytedance.android.live.liveinteract.plantform.performance.t.a);
        r2.put("multilink_battle_base_degrade", com.bytedance.android.live.liveinteract.plantform.performance.v.a);
        r2.put("multilink_toolbar_degrade", com.bytedance.android.live.liveinteract.plantform.performance.x.a);
        r2.put("multilink_video_effect", com.bytedance.android.live.liveinteract.plantform.performance.z.a);
        r2.put("multilink_video_link_enable", com.bytedance.android.live.liveinteract.plantform.performance.b0.a);
        Unit r3 = Unit.INSTANCE;
        r6.a = Collections.unmodifiableMap(r2);
        TTExecutors.getNormalExecutor().submit(new com.bytedance.android.live.liveinteract.plantform.performance.c(r6));
        r6.d = true;
        ALogger.i("MultiLinkAtomicAbility-Manager", "initPerfAbilityManager init finish");
    L12:
        return this.mMultiLinkPerfManager;
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public ei6.a getRtcClient(Boolean r2) {
        rj0.k.m2.getClass();
        if (rj0.k.a.a() != null) goto L5;
        rj0.l.n2.getClass();
        if (rj0.l.a.a() != null) goto L9;
        com.bytedance.android.live.liveinteract.voicechat.d.s0.getClass();
        if (com.bytedance.android.live.liveinteract.voicechat.d.a.a() == null) goto L16;
        com.bytedance.android.live.liveinteract.voicechat.d r3 = com.bytedance.android.live.liveinteract.voicechat.d.a.a();
        if (r3.rtcManger() != null) goto L15;
        return null;
    L15:
        return r3.rtcManger().V0();
    L16:
        IVoiceChatGuestService.Companion.getClass();
        if (IVoiceChatGuestService.a.a() == null) goto L24;
        IVoiceChatGuestService r4 = IVoiceChatGuestService.a.a();
        if (r4.rtcManger() != null) goto L21;
        return null;
    L21:
        return r4.rtcManger().V0();
    L24:
        return null;
    L9:
        return rj0.l.a.a().Z0();
    L5:
        return rj0.k.a.a().Z0();
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public int getScene(@Nullable DataCenter r11) {
        boolean r2 = true;
        Integer r3 = null;
        if (je0.d.E(r11) == false) goto L5;
    L35:
        com.bytedance.android.live.liveinteract.voicechat.d.s0.getClass();
        if (com.bytedance.android.live.liveinteract.voicechat.d.a.a() == null) goto L42;
        com.bytedance.android.live.liveinteract.voicechat.d r12 = com.bytedance.android.live.liveinteract.voicechat.d.a.a();
        if (r12 == null) goto L40;
        int r13 = r12.getCurrentScene();
    L41:
        Integer r14 = Integer.valueOf(r13);
    L91:
        if (r14 != null) goto L93;
        return 0;
    L93:
        return r14.intValue();
    L40:
        r13 = 0;
        goto L41
    L42:
        IVoiceChatGuestService.Companion.getClass();
        if (IVoiceChatGuestService.a.a() == null) goto L49;
        IVoiceChatGuestService r15 = IVoiceChatGuestService.a.a();
        if (r15 == null) goto L47;
        int r16 = r15.getCurrentScene();
    L48:
        r14 = Integer.valueOf(r16);
        goto L91
    L47:
        r16 = 0;
        goto L48
    L49:
        com.bytedance.android.live.liveinteract.plantform.base.d.j0.getClass();
        if (com.bytedance.android.live.liveinteract.plantform.base.d.a.a() != null) goto L90;
        com.bytedance.android.live.liveinteract.plantform.base.e.l0.getClass();
        if (com.bytedance.android.live.liveinteract.plantform.base.e.a.a() != null) goto L90;
        rj0.k.m2.getClass();
        if (rj0.k.a.a() != null) goto L79;
        rj0.l.n2.getClass();
        if (rj0.l.a.a() != null) goto L79;
        IInteractService r0 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r0 == null) goto L62;
        int r1 = r0.getLinkMode();
    L64:
        if (gd0.v.a(r1, 4) == false) goto L67;
        r14 = 1;
        goto L91
    L67:
        if (gd0.v.a(r1, 64) == false) goto L69;
        r14 = 7;
        goto L91
    L69:
        com.bytedance.android.livesdk.chatroom.u r17 = com.bytedance.android.live.liveinteract.api.utils.m.h(r11, null, 2);
        if (r17 == null) goto L78;
        com.bytedance.live.datacontext.j r18 = r17.s();
        if (r18 == null) goto L78;
        com.bytedance.android.livesdk.chatroom.viewmodel.f r19 = (com.bytedance.android.livesdk.chatroom.viewmodel.f) r18.getValue();
        if (r19 == null) goto L78;
        com.bytedance.android.livesdk.chatroom.viewmodel.i r110 = r19.t();
        if (r110 == null) goto L78;
        r14 = Integer.valueOf(r110.a);
    L78:
        r14 = 0;
        goto L91
    L62:
        r1 = 0;
    L79:
        com.bytedance.android.livesdk.chatroom.u r111 = com.bytedance.android.live.liveinteract.api.utils.m.h(r11, null, 2);
        if (r111 == null) goto L88;
        com.bytedance.live.datacontext.j r112 = r111.getVideoTalkRoomSubScene();
        if (r112 == null) goto L88;
        com.bytedance.android.livesdk.chatroom.viewmodel.e r113 = (com.bytedance.android.livesdk.chatroom.viewmodel.e) r112.getValue();
        if (r113 == null) goto L88;
        com.bytedance.android.livesdk.chatroom.viewmodel.j r114 = r113.t();
        if (r114 == null) goto L88;
        int r115 = r114.a;
    L89:
        r14 = Integer.valueOf(r115);
    L88:
        r115 = 0;
    L90:
        r14 = 4;
        goto L91
    L5:
        if (MultiLinkLoadWidgetUtils.h() == false) goto L35;
        MiddlewareRoomContext r4 = o3.c(r11);
        if (r4 == null) goto L11;
        com.bytedance.live.datacontext.n r5 = r4.isRoomVisible();
        if (r5 == null) goto L11;
        Boolean r6 = (Boolean) r5.getValue();
    L13:
        if (Intrinsics.areEqual(r6, Boolean.FALSE) == false) goto L35;
        if (r11 == null) goto L16;
        IRoom r116 = com.bytedance.android.live.core.utils.a0.o(r11);
    L18:
        if (MultiLinkLoadWidgetUtils.a() == false) goto L26;
        Lazy r7 = MultiLinkWRDSPreloadManager.i;
        RoomLinkMicSyncData r8 = IMultiLinkWRDSPreloadService.DefaultImpls.getRoomLinkMicSyncData$default(MultiLinkWRDSPreloadManager.a.a(), "inner_feed", r116, false, 4, null);
        if (r8 == null) goto L26;
        LinkerBaseInfo r9 = r8.linkerBaseInfo;
        if (r9 == null) goto L26;
        int r10 = r9.getScene();
        if (r10 <= 0) goto L26;
        r14 = Integer.valueOf(r10);
    L26:
        if (r116 == null) goto L34;
        Map r20 = r116.getLinkMap();
        if (r20 == null) goto L34;
        if (r116.isLiveTypeAudio() == true) goto L33;
        r2 = false;
    L33:
        r3 = Integer.valueOf(je0.d.m(r20, r2));
    L34:
        r14 = r3;
        goto L91
    L16:
        r116 = null;
    L11:
        r6 = null;
        goto L13
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public int getSeiVersionFromUILayout(int r2) {
        ln0.a r0 = yg0.h.a;
        return yg0.h.d(r2);
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public int getUiLayout(DataCenter r9) {
        Integer r1 = null;
        if (je0.d.E(r9) == false) goto L5;
    L30:
        rj0.k.m2.getClass();
        if (rj0.k.a.a() != null) goto L48;
        rj0.l.n2.getClass();
        if (rj0.l.a.a() != null) goto L48;
        com.bytedance.android.live.liveinteract.voicechat.d.s0.getClass();
        if (com.bytedance.android.live.liveinteract.voicechat.d.a.a() != null) goto L41;
        IVoiceChatGuestService.Companion.getClass();
        if (IVoiceChatGuestService.a.a() != null) goto L41;
        if (jc0.a.a() == true) goto L41;
    L55:
        if (r1 != null) goto L59;
        return 0;
    L59:
        return r1.intValue();
    L41:
        com.bytedance.live.datacontext.j r10 = com.bytedance.android.live.liveinteract.api.utils.m.h(r9, null, 2).s();
        if (r10 == null) goto L55;
        com.bytedance.android.livesdk.chatroom.viewmodel.f r11 = (com.bytedance.android.livesdk.chatroom.viewmodel.f) r10.getValue();
        if (r11 == null) goto L55;
        com.bytedance.android.livesdk.chatroom.viewmodel.i r12 = r11.t();
        if (r12 == null) goto L55;
        r1 = Integer.valueOf(r12.b);
    L48:
        com.bytedance.live.datacontext.j r13 = com.bytedance.android.live.liveinteract.api.utils.m.h(r9, null, 2).getVideoTalkRoomSubScene();
        if (r13 == null) goto L55;
        com.bytedance.android.livesdk.chatroom.viewmodel.e r14 = (com.bytedance.android.livesdk.chatroom.viewmodel.e) r13.getValue();
        if (r14 == null) goto L55;
        com.bytedance.android.livesdk.chatroom.viewmodel.j r15 = r14.t();
        if (r15 == null) goto L55;
        r1 = Integer.valueOf(r15.c);
        goto L55
    L5:
        if (MultiLinkLoadWidgetUtils.h() == false) goto L30;
        MiddlewareRoomContext r0 = o3.c(r9);
        if (r0 == null) goto L11;
        com.bytedance.live.datacontext.n r2 = r0.isRoomVisible();
        if (r2 == null) goto L11;
        Boolean r3 = (Boolean) r2.getValue();
    L13:
        if (Intrinsics.areEqual(r3, Boolean.FALSE) == false) goto L30;
        if (r9 == null) goto L16;
        IRoom r16 = com.bytedance.android.live.core.utils.a0.o(r9);
    L18:
        if (MultiLinkLoadWidgetUtils.a() == false) goto L26;
        Lazy r4 = MultiLinkWRDSPreloadManager.i;
        RoomLinkMicSyncData r5 = IMultiLinkWRDSPreloadService.DefaultImpls.getRoomLinkMicSyncData$default(MultiLinkWRDSPreloadManager.a.a(), "inner_feed", r16, false, 4, null);
        if (r5 == null) goto L26;
        LinkerBaseInfo r6 = r5.linkerBaseInfo;
        if (r6 == null) goto L26;
        int r7 = r6.getUiLayout();
        if (r7 <= 0) goto L26;
        r1 = Integer.valueOf(r7);
    L26:
        if (r16 == null) goto L55;
        z5 r17 = r16.getLinkerDetail();
        if (r17 == null) goto L55;
        r1 = Integer.valueOf(r17.getUiLayout());
        goto L55
    L16:
        r16 = null;
    L11:
        r3 = null;
        goto L13
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public void guestAudioSubtitleSwitchSetting(boolean r3) {
        LinkmicSubtitleBusinessContext.a r0 = LinkmicSubtitleBusinessContext.Companion;
        if (r0.b() == null) goto L6;
        r0.b().guestAudioSubtitleSwitchSetting(r3);
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public boolean hitEnlargeStageAb(IRoom r2) {
        int r0 = com.bytedance.android.live.liveinteract.voicechat.stage.a.a;
        return com.bytedance.android.live.liveinteract.voicechat.stage.a.b(r2);
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public boolean isAnonymousUser(Long r5) {
        if (((IInteractService) jc1.k.f(IInteractService.class)).getLinkUserInfoCenter() == null) goto L5;
        List r0 = ((IInteractService) jc1.k.f(IInteractService.class)).getLinkUserInfoCenter().getOnlineUserList();
    L6:
        ArrayList r1 = new ArrayList();
        if (ListUtils.notEmpty(r0) == false) goto L19;
        Iterator r2 = r0.iterator();
    L10:
        if (r2.hasNext() == false) goto L19;
        ILinkPlayerInfoBridge r3 = (ILinkPlayerInfoBridge) r2.next();
        if (r3 == null) goto L10;
        if (r3.getUser() == null) goto L10;
        if (r3.isAnonymous() == false) goto L10;
        r1.add(r3.getUser().getIdString());
    L19:
        return r1.contains(String.valueOf(r5));
    L5:
        r0 = new ArrayList();
        goto L6
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public boolean isCanShowLinkmicAnnounce(boolean r2) {
        return isCanShowLinkmicAnnounce(r2, null);
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public boolean isCurrentMicSeatFold(DataCenter r2) {
        if (sh0.j0.e(r2) != null) goto L5;
    L7:
        return false;
    L5:
        if (sh0.j0.e(r2).h() == false) goto L7;
        return true;
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public boolean isLinkerUser(IBaseUser r4) {
        int r0 = getLinkMode();
        boolean r1 = je0.d.r();
        if (gd0.v.a(r0, 32) == false) goto L8;
        rj0.m r2 = getVideoTalkService();
        if (r2 != null) goto L19;
    L17:
        return false;
    L19:
        return r2.u(r1, r4.getIdString());
    L8:
        if (gd0.v.a(r0, 8) == false) goto L13;
        qd0.a r3 = getAudioTalkService();
        if (r3 == null) goto L17;
        return r3.B(r4.getIdString());
    L13:
        if (gd0.v.a(r0, 2) == false) goto L17;
        qd0.b r5 = getInteractAudienceService();
        if (r5 == null) goto L17;
        return ((com.bytedance.android.live.liveinteract.service.f) r5).R(r1, r4);
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public boolean isLinkerUserUnSilence(IBaseUser r5) {
        int r0 = getLinkMode();
        boolean r1 = je0.d.r();
        if (gd0.v.a(r0, 32) == false) goto L8;
        rj0.m r2 = getVideoTalkService();
        if (r2 != null) goto L41;
        return false;
    L41:
        return r2.e(r1, r5.getIdString());
    L8:
        if (gd0.v.a(r0, 8) == false) goto L13;
        qd0.a r3 = getAudioTalkService();
        if (r3 != null) goto L43;
        return false;
    L43:
        return r3.e(r1, r5.getIdString());
    L13:
        if (gd0.v.a(r0, 2) == true) goto L15;
        return false;
    L15:
        if (getInteractAudienceService() == null) goto L45;
        String r6 = r5.getIdString();
        List<ILinkPlayerInfoBridge> r4 = com.bytedance.android.live.liveinteract.service.f.O(r1);
        if (Lists.isEmpty(r4) == true) goto L47;
        Iterator<ILinkPlayerInfoBridge> r7 = r4.iterator();
    L21:
        if (r7.hasNext() == false) goto L48;
        ILinkPlayerInfoBridge r8 = r7.next();
        if (r8 == null) goto L21;
        if (r8.getUser() == null) goto L21;
        if (r8.getUser().getIdString().equals(r6) == false) goto L21;
        if (r8.getSilenceStatus() != 0) goto L46;
        return true;
    L46:
        return false;
    L48:
        return false;
    L47:
        return false;
    L45:
        return false;
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public boolean isMicRoomHost(String r2) {
        if (com.bytedance.android.live.liveinteract.plantform.base.f.a() != null) goto L5;
        return false;
    L5:
        return com.bytedance.android.live.liveinteract.plantform.base.f.a().isMicRoomHost(r2);
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public boolean isMultiLinkScene(IRoom r5) {
        if (r5 != null) goto L5;
    L16:
        return false;
    L5:
        if (r5.getLinkMap() == null) goto L16;
        if (r5.getLinkMap().isEmpty() == true) goto L16;
        Iterator<Integer> r1 = multiLinkScene.iterator();
    L11:
        if (r1.hasNext() == false) goto L16;
        Integer r2 = r1.next();
        if (r5.getLinkMap().containsKey(String.valueOf(r2)) == false) goto L11;
        return true;
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public boolean isRoomFightSeiVersion(int r1) {
        return aj0.b.b(Integer.valueOf(r1));
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public boolean isRoomFightUILayout(int r1) {
        return aj0.b.c(r1);
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public void monitor(LinkPreviewMonitorData r15) {
        int r0 = r15.getStatusCode();
        String r1 = r15.getStatusMsg();
        r15.getSyncToTrace();
        JSONObject r2 = r15.getMetrics();
        JSONObject r3 = r15.getCategory();
        Intrinsics.checkNotNullParameter(r15, "monitorData");
        Intrinsics.checkNotNullParameter(r1, "statusMsg");
        Intrinsics.checkNotNullParameter(r2, "metrics");
        Intrinsics.checkNotNullParameter(r3, "category");
        nd0.c.a.getClass();
        Intrinsics.checkNotNullParameter(r15, "monitorData");
        Intrinsics.checkNotNullParameter(r1, "statusMsg");
        Intrinsics.checkNotNullParameter(r2, "metrics");
        Intrinsics.checkNotNullParameter(r3, "category");
        MultiLinkEventModule r4 = nd0.c.m(Integer.valueOf(r15.getScene()), Boolean.valueOf(r15.isLiveTypeAudio()));
        MultiLinkEventType r5 = nd0.c.n(r15.getEventType());
        JSONObject r6 = r15.getExtra();
        BaseMonitor.add(r6, r15.getEventType(), r15.getEventTypeValue());
        boolean r7 = r15.getNeedRoomCommonParams();
        boolean r8 = r15.getNeedLinkCommonParams();
        boolean r9 = r15.getNeedTalkRoomCommonParams();
        if (r7 == false) goto L5;
        od0.c.a(r6);
    L5:
        if (r8 == false) goto L7;
        od0.a.a(r6);
    L7:
        if (r9 == false) goto L9;
        od0.d.a(r6);
    L9:
        BaseMonitor.add(r2, "phone_score", String.valueOf(((Number) vm2.g.d.getValue(null, vm2.g.a[2])).floatValue()));
        int r10 = rd0.b.a;
        String r11 = r15.getServiceName();
        JSONObject r12 = new JSONObject();
        JSONObject r13 = new JSONObject();
        JSONObject r14 = new JSONObject();
        Intrinsics.checkNotNullParameter(r14, "extra");
        Intrinsics.checkNotNullParameter(r13, "metric");
        Intrinsics.checkNotNullParameter(r12, "map");
        Gson r16 = l97.a.a;
        JSONObject r17 = r15.getCategory();
        Intrinsics.checkNotNullParameter(r17, "jsonObject");
        Map r18 = JsonUtil.jsonObjectToMap(r17);
        Intrinsics.checkNotNullParameter(r18, "value");
        Iterator r19 = r18.entrySet().iterator();
    L11:
        if (r19.hasNext() == false) goto L13;
        Map.Entry r110 = (Map.Entry) r19.next();
        r12.put((String) r110.getKey(), r110.getValue());
        goto L11
    L13:
        Intrinsics.checkNotNullParameter(r13, "map");
        JSONObject r20 = r15.getMetrics();
        Intrinsics.checkNotNullParameter(r20, "jsonObject");
        Map r21 = JsonUtil.jsonObjectToMap(r20);
        Intrinsics.checkNotNullParameter(r21, "value");
        Iterator r22 = r21.entrySet().iterator();
    L15:
        if (r22.hasNext() == false) goto L17;
        Map.Entry r111 = (Map.Entry) r22.next();
        r13.put((String) r111.getKey(), r111.getValue());
        goto L15
    L17:
        Intrinsics.checkNotNullParameter(r14, "map");
        JSONObject r112 = r15.getExtra();
        Intrinsics.checkNotNullParameter(r112, "jsonObject");
        Map r113 = JsonUtil.jsonObjectToMap(r112);
        Intrinsics.checkNotNullParameter(r113, "value");
        Iterator r114 = r113.entrySet().iterator();
    L19:
        if (r114.hasNext() == false) goto L21;
        Map.Entry r23 = (Map.Entry) r114.next();
        r14.put((String) r23.getKey(), r23.getValue());
        goto L19
    L21:
        String r24 = r4.getName();
        Intrinsics.checkNotNullParameter(r24, "eventModuleString");
        String r25 = r5.getName();
        Intrinsics.checkNotNullParameter(r25, "eventTypeString");
        r13.put("status_code", String.valueOf(r0));
        r14.put("status_code", String.valueOf(r0));
        Intrinsics.checkNotNullParameter(r1, "string");
        r14.put("status_message", r1);
        cy0.e.a.getClass();
        cy0.j r26 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r115 = com.bytedance.android.scope.m.b(r26).b(n97.a.class);
        Intrinsics.checkNotNull(r115);
        ((com.bytedance.live.kmp.core.c) r115).g(r11, r24, r25, r12, r13, r14);
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public android.util.Pair<Boolean, Integer> needAdjustPublicScreenHeightForSubtitle(IRoom r7) {
        boolean r1 = true;
        boolean r2 = false;
        if (com.bytedance.android.live.liveinteract.voicechat.subtitle.g0.b(r7) == true) goto L5;
    L7:
        boolean r0 = false;
    L8:
        int r3 = com.bytedance.android.live.liveinteract.voicechat.stage.a.a;
        if (com.bytedance.android.live.liveinteract.voicechat.stage.a.c(r7) == false) goto L20;
        AudioChatStageContext r4 = AudioChatStageContext.Companion.getContext();
        if (r4 == null) goto L17;
        com.bytedance.live.datacontext.m<Boolean> r5 = r4.isStageShowing();
        if (r5 == null) goto L17;
        Boolean r6 = (Boolean) r5.getValue();
        if (r6 == null) goto L17;
        boolean r8 = r6.booleanValue();
    L18:
        if (r8 == false) goto L20;
        r0 = false;
    L17:
        r8 = false;
    L20:
        CustomizeStreamContext.a r9 = CustomizeStreamContext.Companion;
        if (r9.getContext() != null) goto L23;
    L29:
        boolean r10 = false;
    L31:
        if (com.bytedance.android.live.liveinteract.voicechat.stage.a.a(je0.d.h(), li0.d.f(TeamFightContext.currentTeamFightInfo()), r10) == true) goto L33;
    L37:
        r2 = r0;
    L39:
        if (com.bytedance.android.live.liveinteract.voicechat.subtitle.g0.a(r7) == false) goto L41;
        int r11 = LinkmicSubtitleUIWidget.u;
    L42:
        if (r2 == true) goto L48;
        com.bytedance.android.live.liveinteract.revenue.battle.b0 r12 = guestBattleContext();
        if (r12 == null) goto L48;
        if (r12.isChestUiShown() == false) goto L48;
        r11 = com.bytedance.android.live.liveinteract.utils.g.a;
    L50:
        return new android.util.Pair(Boolean.valueOf(r1), Integer.valueOf(r11));
    L48:
        r1 = r2;
        goto L50
    L41:
        r11 = LinkmicSubtitleUIWidget.t;
        goto L42
    L33:
        if (TeamFightContext.isTeamFightShowing() == false) goto L39;
        if (li0.d.g(TeamFightContext.currentTeamFightInfo()) == false) goto L37;
    L23:
        if (r9.getContext().getGuestInCustomizeStreamLayout() == null) goto L29;
        if (r9.getContext().getGuestInCustomizeStreamLayout().getValue() == null) goto L29;
        if (((Boolean) r9.getContext().getGuestInCustomizeStreamLayout().getValue()).booleanValue() != true) goto L29;
        r10 = true;
        goto L31
    L5:
        if (LinkmicSubtitleBusinessContext.Companion.d() == false) goto L7;
        je0.d.r();
        r0 = true;
        goto L8
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public void onAudienceEnterRoom(IRoom r6) {
        long r0 = System.currentTimeMillis();
        com.bytedance.android.live.liveinteract.plantform.utils.i0 r2 = TalkRoomLogUtils.a;
        TalkRoomLogUtils.A = r0;
        if (r6 != null) goto L5;
        ALogger.e("TalkRoomLogUtils", "logVoiceRoomShowV3 error, room is null!");
        return;
    L5:
        HashMap r1 = new HashMap();
        String r3 = ((IInteractService) jc1.k.n(IInteractService.class)).getLiveTypeForLog();
        if (r3 != null) goto L8;
    L13:
        z5 r4 = r6.getLinkerDetail();
        if (r4 == null) goto L18;
        String r5 = r4.getFunctionType2();
        if (r5 == null) goto L18;
        r1.put("function_type", r5);
        r1.put("function_type2", r5);
    L18:
        r1.put("play_mode", com.bytedance.android.live.liveinteract.plantform.utils.u0.c(r6));
        z5 r7 = r6.getLinkerDetail();
        if (r7 == null) goto L24;
        String r8 = com.bytedance.android.live.liveinteract.plantform.utils.u0.j(Integer.valueOf(r7.getUiLayout()));
        if (r8 != null) goto L23;
        r8 = "";
    L23:
        r1.put("layout_type", r8);
    L24:
        z5 r9 = r6.getLinkerDetail();
        if (r9 == null) goto L29;
        List r10 = r9.getPlayModes();
        if (r10 == null) goto L29;
        TalkRoomLogUtils.W0(r1, Boolean.valueOf(com.bytedance.android.livesdk.chatroom.interact.model.d0.f(r10)));
    L29:
        TalkRoomLogUtils.w0(r1);
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_audience_voice_room_show_v3", r1, new Object[]{IRoom.class, am2.x.class});
        return;
    L8:
        if (r3.length() != 0) goto L10;
        boolean r11 = true;
    L11:
        if (r11 == true) goto L13;
        r1.put("live_type", r3);
        goto L13
    L10:
        r11 = false;
        goto L11
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public void onFirstFrame(long r2) {
        com.bytedance.android.live.liveinteract.plantform.utils.i0 r0 = TalkRoomLogUtils.a;
        TalkRoomLogUtils.z = r2;
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public void onInnerPageSelected(int r3) {
        com.bytedance.android.live.liveinteract.pre.a r4 = com.bytedance.android.live.liveinteract.pre.a.c.a;
        r4.getClass();
        r4.e = System.currentTimeMillis();
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public void openInvitePanel(String r5) {
        if (gd0.v.a(getLinkMode(), 32) == false) goto L16;
        rj0.k.m2.getClass();
        if (rj0.k.a.a() == null) goto L8;
        rj0.k.a.a().v0(1, "", -1, r5);
        return;
    L8:
        if (jc1.k.f(IMiddlewareUserService.class).user().c() == false) goto L12;
        com.bytedance.android.live.liveinteract.plantform.base.k.n0.getClass();
        if (com.bytedance.android.live.liveinteract.plantform.base.k.a.a() == null) goto L12;
        com.bytedance.android.live.liveinteract.plantform.base.k.a.a().v0(1, "", -1, r5);
        return;
    L12:
        rj0.l.n2.getClass();
        if (rj0.l.a.a() == null) goto L34;
        rj0.l.a.a().S8("", -1, r5);
        return;
    L34:
        return;
    L16:
        if (gd0.v.a(getLinkMode(), 8) == false) goto L36;
        com.bytedance.android.live.liveinteract.voicechat.d.s0.getClass();
        if (com.bytedance.android.live.liveinteract.voicechat.d.a.a() == null) goto L21;
        com.bytedance.android.live.liveinteract.voicechat.d.a.a().showInviteAndPermitDialog(false, "", -1, r5);
        return;
    L21:
        if (jc1.k.f(IMiddlewareUserService.class).user().c() == false) goto L25;
        IVoiceChatAdminService.Companion.getClass();
        if (IVoiceChatAdminService.a.a() == null) goto L25;
        IVoiceChatAdminService.a.a().showInviteAndPermitDialog(false, "", -1, r5);
        return;
    L25:
        IVoiceChatGuestService.Companion.getClass();
        if (IVoiceChatGuestService.a.a() == null) goto L29;
        IVoiceChatGuestService.a.a().showInviteDialog(false, "", -1, r5);
        return;
    L29:
        if (com.bytedance.android.live.liveinteract.plantform.base.f.a() == null) goto L40;
        com.bytedance.android.live.liveinteract.plantform.base.f.a().oa(r5, -1, 0, null);
        return;
    L40:
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public ClientUIInfo parseClientUIInfo(String r1) {
        return com.bytedance.android.live.liveinteract.plantform.commonwindow.utils.a.a(r1);
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public ParseSeiData parseSeiDataBySei(String r1) {
        return ve0.a.b(r1);
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public void preloadDynamicContainer(final Context r7) {
        int r0 = com.bytedance.android.live.liveinteract.utils.w0.a;
        long r1 = vm2.h.i().getPreloadIdleDelay();
        if (r1 <= 0) goto L5;
        Observable.timer(r1, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).doOnNext(new d(r7)).subscribe();
        return;
    L5:
        int r2 = vm2.h.i().getPreLoadRootWidgetSize();
        int r3 = 0;
        int r4 = 0;
    L7:
        if (r4 >= r2) goto L9;
        com.bytedance.android.live.liveinteract.plantform.dynamicframe.d0.f.c(r7, null, true);
        r4 = r4 + 1;
        goto L7
    L9:
        int r5 = com.bytedance.android.live.liveinteract.utils.w0.a;
        int r6 = vm2.h.i().getPreLoadRenderWidgetSize();
    L10:
        if (r3 >= r6) goto L15;
        com.bytedance.android.live.liveinteract.plantform.dynamicframe.z0.g.f(r7, null, true);
        r3 = r3 + 1;
        goto L10
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public void prepareApply(String r2) {
        if (com.bytedance.android.live.liveinteract.plantform.base.f.a() == null) goto L6;
        com.bytedance.android.live.liveinteract.plantform.base.f.a().prepareApply(r2);
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public void reportNitaInner(IRoom r4) {
        com.bytedance.android.live.liveinteract.pre.a r0 = com.bytedance.android.live.liveinteract.pre.a.c.a;
        r0.getClass();
        if (r4 != null) goto L5;
        return;
    L5:
        if (r4.getLinkerDetail() != null) goto L7;
        return;
    L7:
        if (r4.getLinkerDetail().getUiLayout() > 0) goto L9;
        return;
    L9:
        if (r4.getLinkMap() != null) goto L11;
        return;
    L11:
        if (r4.getLinkMap().size() == 0) goto L19;
        r0.c(r4, false);
        com.bytedance.android.live.liveinteract.pre.a.RunnableC0064a r5 = r0.i;
        Handler r1 = r0.a;
        r1.post(new com.bytedance.android.live.liveinteract.pre.a.b(r1, 3, r5));
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public void resetAnchorLinkmicSurfaceView(SurfaceView r2) {
        com.bytedance.android.live.liveinteract.plantform.base.e.l0.getClass();
        if (com.bytedance.android.live.liveinteract.plantform.base.e.a.a() == null) goto L6;
        com.bytedance.android.live.liveinteract.plantform.base.e.a.a().n4(r2);
        return;
    L6:
        rj0.l.n2.getClass();
        if (rj0.l.a.a() == null) goto L10;
        rj0.l.a.a().n4(r2);
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public void setDynamicFromAudience(boolean r1) {
        this.openDynamicFromAudience = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public void setDynamicFromAudienceGuestCache(boolean r1) {
        this.openDynamicFromAudienceGuestCache = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public void setLinkEverCast(long r2) {
        everCastingSet.add(Long.valueOf(r2));
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public void setOnNeedMuteAudioFullPage(boolean r2) {
        if (jc1.k.f(IMiddlewareRoomService.class) == null) goto L6;
        jc1.k.f(IMiddlewareRoomService.class).setOnNeedMuteAudioFullPage(r2);
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public boolean subtitleHitNewStyleAB(IRoom r1) {
        return com.bytedance.android.live.liveinteract.voicechat.subtitle.g0.a(r1);
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public UserType tryGetTargetUserType(String r4) {
        if (com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom() == null) goto L5;
        IRoom r0 = (IRoom) com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom().getValue();
    L6:
        if (r0 == null) goto L14;
        if (r0.getOwnerUserIdString() == null) goto L14;
        if (r0.getOwnerUserIdString().equals(r4) == false) goto L14;
        return UserType.ANCHOR;
    L14:
        if (gd0.v.a(getLinkMode(), 32) == false) goto L34;
        rj0.k.m2.getClass();
        if (rj0.k.a.a() == null) goto L24;
        rj0.k r1 = rj0.k.a.a();
        if (r1.getLinkUserInfoCenter() == null) goto L23;
        if (r1.getLinkUserInfoCenter().a5(r4, "") == null) goto L23;
        return UserType.AUDIENCE;
    L23:
        return UserType.GUEST;
    L24:
        rj0.l.n2.getClass();
        if (rj0.l.a.a() == null) goto L54;
        rj0.l r2 = rj0.l.a.a();
        if (r2.getLinkUserInfoCenter() == null) goto L32;
        if (r2.getLinkUserInfoCenter().a5(r4, "") == null) goto L32;
        return UserType.AUDIENCE;
    L32:
        return UserType.GUEST;
    L54:
        return UserType.UNKNOWN;
    L34:
        if (gd0.v.a(getLinkMode(), 8) == false) goto L54;
        com.bytedance.android.live.liveinteract.voicechat.d.s0.getClass();
        if (com.bytedance.android.live.liveinteract.voicechat.d.a.a() == null) goto L44;
        com.bytedance.android.live.liveinteract.voicechat.d r3 = com.bytedance.android.live.liveinteract.voicechat.d.a.a();
        if (r3.getLinkUserInfoCenter() == null) goto L43;
        if (r3.getLinkUserInfoCenter().a5(r4, "") == null) goto L43;
        return UserType.AUDIENCE;
    L43:
        return UserType.GUEST;
    L44:
        IVoiceChatGuestService.Companion.getClass();
        if (IVoiceChatGuestService.a.a() == null) goto L54;
        IVoiceChatGuestService r5 = IVoiceChatGuestService.a.a();
        if (r5.getLinkUserInfoCenter() == null) goto L52;
        if (r5.getLinkUserInfoCenter().a5(r4, "") == null) goto L52;
        return UserType.AUDIENCE;
    L52:
        return UserType.GUEST;
    L5:
        r0 = null;
        goto L6
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public void updateFromAudienceSource(IRoom r3) {
        if (Objects.equals(jc1.k.f(IMiddlewareUserService.class).user().n(), r3.getOwnerUserIdString()) == false) goto L5;
        return;
    L5:
        if (r3.getLinkerDetail() == null) goto L7;
        String r4 = r3.getLinkerDetail().getFunctionType2();
    L8:
        updateVideoTalkRoomOpenSource(r4);
        return;
    L7:
        r4 = "";
        goto L8
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public void updateFullScreenDialogShowStatus(boolean r2) {
        if (((Boolean) com.bytedance.android.live.core.setting.w2.a.getValue()).booleanValue() == true) goto L5;
        return;
    L5:
        rj0.k.m2.getClass();
        if (rj0.k.a.a() == null) goto L8;
        rj0.k.a.a().updateFullScreenDialogShowStatus(r2);
        return;
    L8:
        rj0.l.n2.getClass();
        if (rj0.l.a.a() == null) goto L11;
        rj0.l.a.a().updateFullScreenDialogShowStatus(r2);
        return;
    L11:
        com.bytedance.android.live.liveinteract.voicechat.d.s0.getClass();
        if (com.bytedance.android.live.liveinteract.voicechat.d.a.a() == null) goto L14;
        com.bytedance.android.live.liveinteract.voicechat.d.a.a().updateFullScreenDialogShowStatus(r2);
        return;
    L14:
        IVoiceChatGuestService.Companion.getClass();
        if (IVoiceChatGuestService.a.a() == null) goto L17;
        IVoiceChatGuestService.a.a().updateFullScreenDialogShowStatus(r2);
        return;
    L17:
        iy.g r0 = getDynamicCenterService(null);
        if (r0 == null) goto L25;
        r0.updateFullScreenDialogShowStatus(r2);
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public void updateFunctionType2(IRoom r2) {
        if (r2.getLinkerDetail() == null) goto L6;
        com.bytedance.android.live.liveinteract.plantform.utils.i.f(r2.getLinkerDetail());
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public void updateSwitchSceneSource(String r2) {
        com.bytedance.android.live.liveinteract.plantform.utils.i0 r0 = TalkRoomLogUtils.a;
        TalkRoomLogUtils.o1(r2);
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public void updateVideoTalkRoomOpenSource(String r3) {
        Lazy r0 = MultiLinkLoadWidgetUtils.a;
        MultiLinkLoadWidgetUtils.o("InteractService", "call updateVideoTalkRoomOpenSource, openSource = " + r3);
        if ("new_audience".equals(r3) == false) goto L5;
        this.openDynamicFromAudience = true;
        setDynamicFromAudienceGuestCache(true);
        return;
    L5:
        this.openDynamicFromAudience = false;
    }

    public static void INVOKEVIRTUAL_com_bytedance_android_live_multilink_impl_InteractService_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(com.bytedance.android.live.liveinteract.videotalk.dialog.n r1) {
        if (DialogLancet.shouldBlockDialogShow(r1) == false) goto L10;
        DialogLancet.handleBlockedDialogShow(r1);
        return;
    L10:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L9
    L7:
        DialogLancet.beforeDialogShow(r1);
        r1.show();
        DialogLancet.afterDialogShow(r1);
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public boolean isAnonymousUser(String r5) {
        if (((IInteractService) jc1.k.f(IInteractService.class)).getLinkUserInfoCenter() == null) goto L5;
        List r0 = ((IInteractService) jc1.k.f(IInteractService.class)).getLinkUserInfoCenter().getOnlineUserList();
    L6:
        ArrayList r1 = new ArrayList();
        if (ListUtils.notEmpty(r0) == false) goto L19;
        Iterator r2 = r0.iterator();
    L10:
        if (r2.hasNext() == false) goto L19;
        ILinkPlayerInfoBridge r3 = (ILinkPlayerInfoBridge) r2.next();
        if (r3 == null) goto L10;
        if (r3.getUser() == null) goto L10;
        if (r3.isAnonymous() == false) goto L10;
        r1.add(r3.getUser().getIdString());
    L19:
        return r1.contains(r5);
    L5:
        r0 = new ArrayList();
        goto L6
    }

    public static void INVOKEVIRTUAL_com_bytedance_android_live_multilink_impl_InteractService_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(LinkDistributeSettingDialog r1) {
        if (DialogLancet.shouldBlockDialogShow(r1) == false) goto L10;
        DialogLancet.handleBlockedDialogShow(r1);
        return;
    L10:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L9
    L7:
        DialogLancet.beforeDialogShow(r1);
        r1.show();
        DialogLancet.afterDialogShow(r1);
    }

    private static /* synthetic */ Unit lambda$guestDisconnect$1(rj0.c r0, Boolean r1) {
        if (r0 != null) goto L4;
        return null;
    L4:
        if (r1.booleanValue() == false) goto L6;
        r0.disconnectSuccess();
        return null;
    L6:
        r0.disconnectFailed();
        return null;
    }

    private static void lambda$preloadDynamicContainer$2(Context r5, Long r6) throws Exception {
        int r7 = com.bytedance.android.live.liveinteract.utils.w0.a;
        int r8 = vm2.h.i().getPreLoadRootWidgetSize();
        int r0 = 0;
        int r1 = 0;
    L4:
        if (r1 >= r8) goto L6;
        com.bytedance.android.live.liveinteract.plantform.dynamicframe.d0.f.c(r5, null, true);
        r1 = r1 + 1;
        goto L4
    L6:
        int r9 = com.bytedance.android.live.liveinteract.utils.w0.a;
        int r10 = vm2.h.i().getPreLoadRenderWidgetSize();
    L7:
        if (r0 >= r10) goto L9;
        com.bytedance.android.live.liveinteract.plantform.dynamicframe.z0.g.f(r5, null, true);
        r0 = r0 + 1;
        goto L7
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public Integer adapterPlayerAlignModeIfNeed(int r2, int r3) {
        if (r2 == 3) goto L5;
        return null;
    L5:
        if (r3 == 28) goto L7;
        return null;
    L7:
        return 5;
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public void changeExitCleanScreenStyle(@Nullable ImageView r4, @Nullable TextView r5) {
        int r0 = qi0.e.a;
        String r2 = null;
        rs1.a r1 = (rs1.a) vm2.d.x1.getValue(null, vm2.d.a[125(0x7d, float:1.75E-43)]);
        if (r1 == null) goto L7;
        rs1.b r3 = r1.a();
        if (r3 == null) goto L7;
        String r6 = r3.b();
    L8:
        if (r4 == null) goto L11;
        if (r6 == null) goto L11;
        ImageUtil.loadRoundImage(r4, qy.a.a(r6));
    L11:
        if (r1 == null) goto L15;
        rs1.b r7 = r1.a();
        if (r7 == null) goto L15;
        r2 = r7.c();
    L15:
        if (r5 == null) goto L19;
        if (r2 == null) goto L20;
        r5.setText(r2);
        return;
    L20:
        return;
    L19:
        return;
    L7:
        r6 = null;
        goto L8
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    @Nullable
    public BaseAnchorModeDynamicWidget createAnchorModeDynamicWidget(ViewGroup r2, iy.j r3) {
        boolean r0 = ky.a.a;
        if (ky.a.a == true) goto L7;
        return null;
    L7:
        return new AnchorModeLinkDynamicWidget(r2, r3);
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b createBehavior(Object r1, Context r2) {
        return new com.bytedance.android.live.liveinteract.digitavatar.g0();
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public BaseCloudGroupLiveWidget createCloudGroupLiveWidget(ViewGroup r2, com.bytedance.android.livesdk.chatroom.ui.framework.a r3) {
        return new CloudGroupLiveWidget(r2, r3);
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public Widget createLiveAwemePlayControlWidghet(FragmentManager r2, com.bytedance.android.live.pushstream.d r3) {
        return new LiveAwemeVideoPlayWidget(r2, r3);
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public BaseVirtualLiveControlWidget createVirtualLiveControlWidget(ViewGroup r2, com.bytedance.android.livesdk.chatroom.ui.framework.a r3) {
        return new VirtualLiveControlWidget(r2, r3);
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    @Nullable
    public ih0.b dynamicService(@Nullable DataCenter r2, long r3) {
        return MultiLinkDynamicContext.Companion.a(r2, Long.valueOf(r3));
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public com.bytedance.ies.web.jsbridge2.f.b getFeedMultiLinkDynamicJsbMethodProvider(String r4, DataCenter r5) {
        int r0 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.x.a;
        Intrinsics.checkNotNullParameter(r5, "dataCenter");
        if (r4 != null) goto L5;
    L8:
        boolean r1 = true;
    L10:
        if (r1 == true) goto L29;
        if (r4 == null) goto L30;
        int r2 = r4.hashCode();
        if (r2 == (-1632485354)) goto L23;
        if (r2 == 1597290153) goto L20;
        return null;
    L20:
        if (r4.equals("getLinkmicStatus") == true) goto L27;
        return null;
    L27:
        return new com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.v(r5);
    L23:
        if (r4.equals("updateLinkmicStatus") == true) goto L25;
        return null;
    L25:
        return new com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.w(r5);
    L30:
        return null;
    L29:
        return null;
    L5:
        if (r4.length() == 0) goto L8;
        r1 = false;
        goto L10
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public ILinkPlayerInfoBridge getGuestInfo(String r3, String r4) {
        if (gd0.v.a(getLinkMode(), 4) == false) goto L8;
        yr0.b r0 = ((IMultiPkAudienceLinkOutService) jc1.k.f(IMultiPkAudienceLinkOutService.class)).getPkLinkUserInfoCenter();
        if (r0 == null) goto L8;
        return r0.getGuestInfo(r3, r4);
    L8:
        com.bytedance.android.live.liveinteract.plantform.base.i<ILinkPlayerInfoBridge> r1 = getLinkUserInfoCenter();
        if (r1 != null) goto L11;
        return null;
    L11:
        return (ILinkPlayerInfoBridge) r1.getGuestInfo(r3, r4);
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public ILivePreviewKtvComponentWidget getLivePreviewKtvComponentWidget(ViewGroup r2, @Nullable ISingleBroadcastPreviewKtvComponent r3) {
        return new LivePreviewKtvComponentWidget(r2, r3);
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public IInteractFeedViewManager getPreviewInteractFeedViewManager(ViewGroup r2, int r3) {
        return new PreviewInteractFeedViewManager(r2, r3);
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public Pair<Integer, Integer> getSeiVersionAndUILayoutForMultiLink(int r2, int r3) {
        ln0.a r0 = yg0.h.a;
        int r1 = -1;
        if (r2 != (-1)) goto L7;
        if (r3 <= 0) goto L16;
        r1 = yg0.h.d(r3);
    L16:
        return new Pair(Integer.valueOf(r1), Integer.valueOf(r3));
    L7:
        if (r2 > 0) goto L11;
        if (r3 <= 0) goto L11;
        Pair<Integer, Integer> r4 = new Pair(Integer.valueOf(yg0.h.d(r3)), Integer.valueOf(r3));
    L17:
        return r4;
    L11:
        if (r2 <= 0) goto L15;
        if (r3 > 0) goto L15;
        int r5 = yg0.h.e(r2);
        r4 = new Pair(Integer.valueOf(r2), Integer.valueOf(r5));
    L15:
        return new Pair(0, 0);
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public x00.a getThemeManager(boolean r3, @Nullable DataCenter r4) {
        boolean r0 = MultiLinkLoadWidgetUtils.g();
        if (r0 == false) goto L10;
        if (r4 == null) goto L10;
        com.bytedance.android.live.liveinteract.bgComponent.platform.a r1 = com.bytedance.android.live.liveinteract.plantform.multiroom.e.c(r4);
        if (r1 == null) goto L10;
        x00.c r2 = r1.an();
        if (r2 == null) goto L10;
        return r2;
    L10:
        if (r3 == false) goto L12;
        x00.a r5 = com.bytedance.android.live.liveinteract.bgComponent.theme.j.l;
    L13:
        if (r0 == false) goto L16;
        if (r4 == null) goto L16;
        r4.put("data_multi_link_theme_manager", r5);
    L16:
        return r5;
    L12:
        r5 = com.bytedance.android.live.liveinteract.bgComponent.theme.a.d;
        goto L13
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public void guestDisconnect(int r9, final rj0.c r10) {
        rj0.l.n2.getClass();
        rj0.l r0 = rj0.l.a.a();
        IVoiceChatGuestService.Companion.getClass();
        IVoiceChatGuestService r2 = IVoiceChatGuestService.a.a();
        if (r0 == null) goto L5;
        r0.Cb(r9, false, true, r10);
        return;
    L5:
        if (r2 == null) goto L7;
        r2.disconnect(r9, false, false, true, r10);
        return;
    L7:
        IKtvService r1 = jc1.k.f(IKtvService.class);
        if (r1 == null) goto L13;
        r1.disconnect(r9, false, true, false, new b(r10));
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public void initAndTurnOnRadioLinkmicRoom(Runnable r2, Runnable r3) {
        if (com.bytedance.android.live.liveinteract.plantform.base.f.a() == null) goto L6;
        com.bytedance.android.live.liveinteract.plantform.base.f.a().initAndTurnOnRadioLinkmicRoom(r2, r3);
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public boolean isCanShowLinkmicAnnounce(boolean r4, IRoom r5) {
        String r0 = null;
        if (r4 == false) goto L39;
        if (((y01) vm2.h.l6.getValue(null, vm2.h.a[374(0x176, float:5.24E-43)])).a() == false) goto L40;
        int r6 = je0.d.f();
        Integer r7 = je0.d.h();
        if (r7 == null) goto L14;
        if (r7.intValue() == 61) goto L40;
    L14:
        if (r6 != 5) goto L20;
        if (r7 == null) goto L20;
        if (r7.intValue() == 29) goto L40;
    L20:
        if (r6 != 5) goto L22;
    L37:
        return true;
    L22:
        if (r6 != 8) goto L24;
        if (r7 == null) goto L37;
        if (r7.intValue() == 7) goto L40;
    L24:
        if (r6 != 12) goto L26;
        if (r7 == null) goto L37;
        if (r7.intValue() == 109) goto L40;
    L26:
        if (r6 == 16) goto L37;
    L40:
        return false;
    L39:
        if (com.bytedance.android.live.liveinteract.linkpanel.util.o.o(null) == true) goto L40;
        if (r5 == null) goto L46;
        Map r8 = r5.getAnchorABMap();
        if (r8 == null) goto L46;
        r0 = (String) r8.get("linkmic_announce");
    L46:
        return Intrinsics.areEqual(r0, "1");
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public boolean isFixFloatWindowLayout(int r2, int r3) {
        MultiLinkFrequencyOptConfig r0 = com.bytedance.android.live.liveinteract.plantform.commonwindow.utils.f.a;
        return com.bytedance.android.live.liveinteract.plantform.commonwindow.utils.f.e(Integer.valueOf(r2), Integer.valueOf(r3));
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public boolean isPCLandscape(int r2, int r3) {
        int r0 = com.bytedance.android.live.liveinteract.utils.c1.a;
        return com.bytedance.android.live.liveinteract.utils.c1.a(Integer.valueOf(r2), Integer.valueOf(r3));
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public boolean isSupportedCommonUILayoutBySei(int r2, int r3) {
        ln0.a r0 = yg0.h.a;
        return yg0.h.j(r2, r3);
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public boolean isVideoEqualCenterDynamicLayout(int r2, int r3) {
        MultiLinkFrequencyOptConfig r0 = com.bytedance.android.live.liveinteract.plantform.commonwindow.utils.f.a;
        return com.bytedance.android.live.liveinteract.plantform.commonwindow.utils.f.k(Integer.valueOf(r2), Integer.valueOf(r3));
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public boolean isVideoEqualCenterNewLayout(int r2, int r3) {
        MultiLinkFrequencyOptConfig r0 = com.bytedance.android.live.liveinteract.plantform.commonwindow.utils.f.a;
        return com.bytedance.android.live.liveinteract.plantform.commonwindow.utils.f.m(Integer.valueOf(r2), Integer.valueOf(r3));
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public boolean isVoiceMultiEnlargeSeat(int r2, int r3) {
        Integer r4 = Integer.valueOf(r2);
        if (r4 != null) goto L6;
    L11:
        return false;
    L6:
        if (r4.intValue() != 26) goto L11;
        if (r3 == 0) goto L13;
        if (r3 != 1) goto L11;
        return true;
    L13:
        return true;
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public void logPermit(IBaseUser r12, String r13) {
        com.bytedance.android.live.liveinteract.plantform.base.i<ILinkPlayerInfoBridge> r0 = ((IInteractService) jc1.k.f(IInteractService.class)).getLinkUserInfoCenter();
        String r1 = null;
        if (r0 == null) goto L18;
        List<T> r2 = r0.a();
        if (r2 == 0) goto L18;
        if (r2.isEmpty() == true) goto L18;
        Iterator r3 = r2.iterator();
    L10:
        if (r3.hasNext() == false) goto L18;
        ILinkPlayerInfoBridge r4 = (ILinkPlayerInfoBridge) r3.next();
        IBaseUser r5 = r4.getUser();
        if (r5 == null) goto L10;
        if (r12.getIdString() == null) goto L10;
        if (r12.getIdString().equals(r5.getIdString()) == false) goto L10;
    L19:
        boolean r9 = r12.isSubscriber();
        if (r4 == null) goto L25;
        List<KtvMusic> r6 = r4.getSongList();
        if (r4.getWaitingListUserInfo() == null) goto L24;
        r1 = r4.getWaitingListUserInfo().getApplyReason();
    L24:
        List<KtvMusic> r7 = r6;
        Long r10 = Long.valueOf(r4.getLinkMicPosTagType());
    L26:
        TalkRoomLogUtils r8 = TalkRoomLogUtils.B;
        String r11 = r12.getIdString();
        if (r1 != null) goto L29;
    L31:
        boolean r14 = false;
    L32:
        r8.r0(r11, "anchor", r7, r13, r14, r9, r10);
        return;
    L29:
        if (r1.isEmpty() == true) goto L31;
        r14 = true;
        goto L32
    L25:
        r7 = null;
        r10 = null;
    L18:
        r4 = null;
        goto L19
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public boolean needSpecialAdjustScreen(int r4, int r5) {
        if (((Boolean) vm2.c.z.getValue(null, vm2.c.a[24])).booleanValue() == false) goto L9;
        MultiLinkFrequencyOptConfig r0 = com.bytedance.android.live.liveinteract.plantform.commonwindow.utils.f.a;
        if (com.bytedance.android.live.liveinteract.plantform.commonwindow.utils.f.e(Integer.valueOf(r4), Integer.valueOf(r5)) == false) goto L7;
    L8:
        return true;
    L7:
        if (r5 == 112) goto L8;
    L9:
        return false;
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public void onDownGradeInfo(boolean r2, int r3) {
        this.mVerticalDegradeTask.onDownGradeInfo(r2, r3);
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public void onRtcAVLinkLogMonitor(String r6, JSONObject r7) {
        q7 r0 = getAVMonitorLogConfig();
        if (r0.getEnable() == true) goto L5;
        return;
    L5:
        List r1 = r0.N5();
        Intrinsics.checkNotNullParameter(r1, "rtcLogType");
        Intrinsics.checkNotNullParameter(r6, "logType");
        if (r1.contains(r6) == true) goto L8;
        return;
    L8:
        String r8 = r7.optString("mode");
        String r2 = r7.optString("event_key");
        Map r3 = r0.getEventMap();
        Intrinsics.checkNotNullParameter(r3, "eventMap");
        Intrinsics.checkNotNullParameter(r2, "eventKey");
        String r4 = (String) r3.get(r2);
        IInteractService r5 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r5 == null) goto L15;
        int r9 = r5.getCurrentScene();
        int r10 = r5.getCurrentUiLayout();
        r7.put("multi_link_scene", r9);     // Catch: JSONException -> L13
        r7.put("multi_link_ui_layout", r10);     // Catch: JSONException -> L13
    L15:
        if ("rtc".equals(r8) == false) goto L24;
        if (r4 != null) goto L18;
        return;
    L18:
        if (LiveTracingMonitor.EventType.SDK_INTERFACE_CALL.getName().equalsIgnoreCase(r4) == false) goto L20;
        r2 = "rtc_" + r7.optString("engine_api_name");
    L20:
        v2.a(r4, r2, r7);
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public void openEmojiDialog(String r3, String r4) {
        String r0 = getLiveTypeForLog();
        if (r0 != null) goto L5;
        return;
    L5:
        if (TextUtils.equals(r0, "voice_live") == false) goto L8;
        getAudioTalkService().openEmojiDialog(r3, r4);
        return;
    L8:
        if (TextUtils.equals(r0, "video_live") == false) goto L13;
        getVideoTalkService().openEmojiDialog(r3, r4);
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public void openInviteOrPermitPanel(String r4, int r5) {
        if (com.bytedance.android.live.liveinteract.plantform.base.f.a() == null) goto L6;
        com.bytedance.android.live.liveinteract.plantform.base.f.a().oa(r4, -1, r5, null);
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public void permit(IBaseUser r3, String r4) {
        com.bytedance.android.live.liveinteract.plantform.base.d.j0.getClass();
        com.bytedance.android.live.liveinteract.plantform.base.d r5 = com.bytedance.android.live.liveinteract.plantform.base.d.a.a();
        if (r5 == null) goto L5;
        r5.g0(r3);
    L5:
        rj0.k.m2.getClass();
        rj0.k r6 = rj0.k.a.a();
        if (r6 == null) goto L8;
        r6.g0(r3);
    L8:
        com.bytedance.android.live.liveinteract.plantform.base.k.n0.getClass();
        com.bytedance.android.live.liveinteract.plantform.base.k r7 = com.bytedance.android.live.liveinteract.plantform.base.k.a.a();
        if (r7 == null) goto L11;
        r7.dj(r3.getIdString(), r3.getCastSecUid());
    L11:
        com.bytedance.android.live.liveinteract.voicechat.d.s0.getClass();
        com.bytedance.android.live.liveinteract.voicechat.d r8 = com.bytedance.android.live.liveinteract.voicechat.d.a.a();
        if (r8 == null) goto L14;
        r8.accept(r3);
    L17:
        IKtvService r9 = jc1.k.f(IKtvService.class);
        if (r9 != null) goto L20;
        return;
    L20:
        if (r3.getCastSecUid() == null) goto L24;
        r9.accept(r3.getIdString(), r3.getCastSecUid());
        return;
    L24:
        return;
    L14:
        IVoiceChatAdminService.Companion.getClass();
        IVoiceChatAdminService r10 = IVoiceChatAdminService.a.a();
        if (r10 == null) goto L17;
        r10.accept(r3.getIdString(), r3.getCastSecUid());
        goto L17
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public void permitPrepareApply(long r2, String r4) {
        if (com.bytedance.android.live.liveinteract.plantform.base.f.a() == null) goto L6;
        com.bytedance.android.live.liveinteract.plantform.base.f.a().permitPrepareApply(r2, r4);
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public void removePreloadDynamicWidget(DataCenter r5, @Nullable BaseLinkMultiControlWidget.a r6) {
        Widget r0 = (Widget) com.bytedance.android.live.liveinteract.plantform.multiroom.e.b(r5);
        Intrinsics.checkNotNullParameter(r5, "dataCenter");
        WidgetManager r3 = (WidgetManager) r5.get("data_multi_link_dynamic_widget_manager");
        if (r3 == null) goto L7;
        if (r0 == null) goto L7;
        r3.unload(r0);
        com.bytedance.android.live.liveinteract.plantform.multiroom.e.e(r5, null, null);
        Intrinsics.checkNotNullParameter(r5, "dataCenter");
        r5.put("data_multi_link_dynamic_widget_manager", null);
    L7:
        if (MultiLinkLoadWidgetUtils.g() == true) goto L9;
    L11:
        boolean r7 = false;
    L12:
        if (r7 == false) goto L17;
        if (r6 == null) goto L18;
        if (r0 == null) goto L19;
        r6.k(r0);
        return;
    L19:
        return;
    L18:
        return;
    L17:
        return;
    L9:
        if (vm2.h.W().unloadDynamicWidget() == false) goto L11;
        r7 = true;
        goto L12
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public void resetBusinessDegradeStrategy(int r2, String r3) {
        this.mVerticalDegradeTask.resetBusinessDegradeStrategy(r2, r3);
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public void updateSelfSilenceStatus(boolean r4, MediaOperation.a r5) {
        String r0 = jc1.k.f(IMiddlewareUserService.class).user().n();
        rj0.k.m2.getClass();
        if (rj0.k.a.a() == null) goto L8;
        rj0.k r1 = rj0.k.a.a();
        if (r4 == false) goto L7;
        r1.im(r0, true, r5);
    L14:
        com.bytedance.android.live.liveinteract.voicechat.d.s0.getClass();
        if (com.bytedance.android.live.liveinteract.voicechat.d.a.a() == null) goto L17;
        com.bytedance.android.live.liveinteract.voicechat.d.a.a().updateSelfMuteStatus(r4, false, r5);
        return;
    L17:
        IVoiceChatGuestService.Companion.getClass();
        if (IVoiceChatGuestService.a.a() == null) goto L22;
        IVoiceChatGuestService.a.a().updateSelfMuteStatus(r4, false, r5);
        return;
    L22:
        return;
    L7:
        r1.Q5(r0, true, r5);
        goto L14
    L8:
        rj0.l.n2.getClass();
        if (rj0.l.a.a() == null) goto L14;
        rj0.l r2 = rj0.l.a.a();
        if (r4 == false) goto L13;
        r2.li(r0, r5);
        goto L14
    L13:
        r2.Td(r0, r5);
        goto L14
    }

    public static void INVOKEVIRTUAL_com_bytedance_android_live_multilink_impl_InteractService_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_show(LinkmicSubtitleSettingDialog r2, FragmentManager r3, String r4) {
        if ((r2 instanceof Fragment) == false) goto L5;
        LinkmicSubtitleSettingDialog r0 = r2;
    L6:
        LandscapeRestrictionOperation r1 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r0, r4, r1);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r3, r0, r1) == false) goto L13;
        return;
    L13:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L12
    L10:
        r2.show(r3, r4);
        return;
    L5:
        r0 = null;
        goto L6
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public void anchorAudioSubtitleSwitchSetting(boolean r3, String r4, nj0.c r5) {
        LinkmicSubtitleBusinessContext.a r0 = LinkmicSubtitleBusinessContext.Companion;
        if (r0.b() == null) goto L6;
        r0.b().anchorAudioSubtitleSwitchSetting(r3, r4, r5);
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public void apply(int r8, String r9, int r10) {
        if (gd0.v.a(getLinkMode(), 32) == false) goto L7;
        rj0.l.n2.getClass();
        if (rj0.l.a.a() == null) goto L16;
        rj0.l.a.a().M8(-1, r8, r9, com.bytedance.android.live.liveinteract.api.chatroom.model.a.a(r10), null);
        return;
    L16:
        return;
    L7:
        qd0.a r11 = getAudioTalkService();
        if (r11 == null) goto L11;
        r11.i(r9);
        return;
    L11:
        IVoiceChatGuestService.Companion.getClass();
        IVoiceChatGuestService r12 = IVoiceChatGuestService.a.a();
        if (r12 == null) goto L14;
        r12.checkAndApply(-1, String.valueOf(115), r10, r9);
    L14:
        jc1.k.f(IKtvService.class).checkAndApply(-1, String.valueOf(115), r10, r9);
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public BaseLinkMultiControlWidget createLinkMultiControlWidget(BaseLinkMultiControlWidget.a r2, ViewGroup r3, Boolean r4) {
        return new LinkMultiControlWidget(r2, r3, r4);
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public xi0.b createLinkRoomRtcManager(IRoomBase r2, Object r3, tc0.b r4) {
        if (r2.getIdStr().trim().isEmpty() == true) goto L7;
        CastLongProtector.parseLong(r2.getIdStr());
    L7:
        return new LinkRoomFightRtcManager((hg6.g) r3, r4);
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public md0.a createLiveSeiHelper(md0.a.InterfaceC0236a r2, md0.a.b r3, md0.a.c r4) {
        return new com.bytedance.android.live.liveinteract.api.utils.j(r2, r3, r4);
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public void fastMatchJump(long r2, String r4, String r5) {
        if (com.bytedance.android.live.liveinteract.plantform.base.f.a() == null) goto L6;
        com.bytedance.android.live.liveinteract.plantform.base.f.a().fastMatchJump(r2, r4, r5);
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public Pair<Integer, Integer> getNewLinkSizeForXScreenAdjust(int r7, int r8, int r9) {
        int r10 = com.bytedance.android.live.anchormodelink.util.a.a;
        float r0 = r9;
        boolean r1 = true;
        if ((r8 / r0) <= 0.5625f) goto L5;
        boolean r11 = true;
    L7:
        if (FoldScreenUtils.e() == false) goto L9;
    L13:
        if (r1 == false) goto L15;
        int r12 = Math.min(r8, (int) (r0 * 0.5625f));
    L16:
        int r2 = x8.a.a;
        StringBuilder r3 = new StringBuilder("adjustUIForXScreen, screen[");
        r3.append(com.bytedance.android.live.core.utils.s1.y());
        r3.append(", ");
        r3.append(com.bytedance.android.live.core.utils.s1.w());
        r3.append("], livePlayerParent[");
        hs0.a r4 = hs0.a.b;
        View r5 = r4.getCurrentLivePlayerParent();
        Integer r6 = null;
        if (r5 == null) goto L19;
        Integer r13 = Integer.valueOf(r5.getWidth());
    L20:
        r3.append(r13);
        r3.append(", ");
        View r14 = r4.getCurrentLivePlayerParent();
        if (r14 == null) goto L23;
        r6 = Integer.valueOf(r14.getHeight());
    L23:
        r3.append(r6);
        r3.append("], containerWH[");
        r3.append(r8);
        r3.append(", ");
        r3.append(r9);
        r3.append("], adjustWH[");
        r3.append(r12);
        r3.append(", ");
        r3.append(r9);
        r3.append(']');
        x8.a.b("ScreenAdjust", r3.toString(), false);
        return new Pair(Integer.valueOf(r12), Integer.valueOf(r9));
    L19:
        r13 = null;
        goto L20
    L15:
        r12 = r8;
        goto L16
    L9:
        if (PadConfigUtils.c() == true) goto L13;
        if (r11 == true) goto L13;
        r1 = false;
        goto L13
    L5:
        r11 = false;
        goto L7
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public void getUserWaitingInfo(String r2, int r3, com.bytedance.android.live.liveinteract.plantform.base.i.c r4) {
        if (com.bytedance.android.live.liveinteract.plantform.base.f.a() == null) goto L6;
        com.bytedance.android.live.liveinteract.plantform.base.f.a().getUserWaitingInfo(r2, r3, r4);
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public Single<com.bytedance.android.live.network.response.e<com.bytedance.android.livesdk.chatroom.model.interact.x>> getUserWaitingRankPosition(long r9, long r11, int r13) {
        return ((LinkAudienceApi) com.bytedance.android.live.network.c.b().e(LinkAudienceApi.class)).getUserWaitingRankPosition(r9, r11, r13, 0);
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public gd0.q getVideoCommentPanel(Context r2, Fragment r3, Boolean r4) {
        LiveVideoCommentSelectAwemePanelView r0 = new LiveVideoCommentSelectAwemePanelView(r2, r4.booleanValue());
        Intrinsics.checkNotNullParameter(r3, "parentFragment");
        r0.l = r3;
        LiveVideoCommentSelectAwemePanelViewModel r5 = (LiveVideoCommentSelectAwemePanelViewModel) ViewModelProviders.of(r3).get(LiveVideoCommentSelectAwemePanelViewModel.class);
        r0.a = r5;
        if (r5 == null) goto L7;
        MutableLiveData<ud0.d> r6 = r5.getViewEvent();
        if (r6 == null) goto L7;
        r6.observe(r3, new com.bytedance.android.live.liveinteract.awemeplay.view.a(r0));
    L7:
        LiveVideoCommentSelectAwemePanelViewModel r7 = r0.a;
        if (r7 == null) goto L12;
        MutableLiveData<sd0.a> r8 = r7.getSelectedAwemeVideo();
        if (r8 == null) goto L12;
        r8.observe(r3, new com.bytedance.android.live.liveinteract.awemeplay.view.b(r0));
    L12:
        LiveVideoCommentSelectAwemePanelViewModel r9 = r0.a;
        if (r9 == null) goto L15;
        r9.doAction(ud0.c.a.a);
    L15:
        return r0;
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public void handleInteractState(DataCenter r8, String r9, gd0.d r10) {
        if (r8 != null) goto L4;
        return;
    L4:
        yr0.d r11 = jc1.k.f(IMultiLinkServiceExternal.class).getMultiDataHolderExternal();
        int r12 = ((Integer) r8.get("data_link_state", 0)).intValue();
        int r1 = 2;
        if (jc1.k.f(IMultiLinkServiceExternal.class).getPkServiceExternal().isMatching() == true) goto L26;
        if (r11.getChannelId() != 0) goto L26;
        if (r12 != 0) goto L11;
        r10.onSuccess();
        return;
    L11:
        if (r12 != 2) goto L22;
        if (((com.bytedance.android.live.liveinteract.service.f) getInteractAudienceService()).P() == false) goto L15;
        r10.onFailed(2);
        return;
    L15:
        com.bytedance.android.live.liveinteract.plantform.base.d.j0.getClass();
        if (com.bytedance.android.live.liveinteract.plantform.base.d.a.a() != null) goto L18;
        return;
    L18:
        if (com.bytedance.android.live.liveinteract.plantform.base.d.a.a().isEngineOn() == false) goto L20;
        com.bytedance.android.live.liveinteract.plantform.base.d.a.a().h2(r10);
        com.bytedance.android.live.liveinteract.plantform.base.d.a.a().finishInteract("intimate_exclude");
        return;
    L20:
        r10.onSuccess();
        return;
    L22:
        if (r11.getDuration() <= 0) goto L24;
        r1 = 1;
    L24:
        r10.onFailed(r1);
        return;
    L26:
        if (r11.getDuration() <= 0) goto L28;
        r1 = 1;
    L28:
        r10.onFailed(r1);
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public JsonObject handleLinkLynxPanelJsbGetAction(String r17, String r18, JsonObject r19) {
        if ("setting_panel_type".equals(r17) == false) goto L25;
        Lazy r3 = MultiLinkLynxSettingPanelActionHandler.a;
        String r4 = com.bytedance.android.live.liveinteract.linkpanel.util.u.b;
        Intrinsics.checkNotNullParameter(r17, "panelType");
        Intrinsics.checkNotNullParameter(r18, "callType");
        Intrinsics.checkNotNullParameter(r19, "extraData");
        Intrinsics.checkNotNullParameter(r4, "requestPage");
        ALogger.d("LynxSettingPanelHandler", "handleLinkLynxPanelJsbGetAction call panelType=" + r17 + " callType=" + r18 + " extraData=" + r19);
        JsonObject r0 = new JsonObject();
        if (r18.hashCode() == (-1215101076)) goto L8;
    L23:
        return r0;
    L8:
        if (r18.equals("setting_panel_config") == false) goto L23;
        JsonObject r1 = new JsonObject();
        JsonObject r8 = MultiLinkLynxSettingPanelActionHandler.b(r19);
        if (r8 == null) goto L12;
        r1.add("settings", r8);
    L12:
        JsonObject r2 = MultiLinkLynxSettingPanelActionHandler.a(r19);
        if (r2 == null) goto L15;
        r1.add("local_storage", r2);
    L15:
        r1.addProperty("support_camera", Boolean.valueOf(tc0.c.h().E));
        IKtvService r5 = jc1.k.f(IKtvService.class);
        if (r5 == null) goto L18;
        Boolean r6 = Boolean.valueOf(r5.isAudienceSingEnableSwitchOn());
    L19:
        r1.addProperty("is_audience_enable_sing", r6);
        r1.addProperty("function_type", ((IInteractService) jc1.k.n(IInteractService.class)).getCurrentFunctionType());
        r1.addProperty("is_dynamic_from_audience", Boolean.valueOf(((IInteractService) jc1.k.n(IInteractService.class)).dynamicFromAudience()));
        if (com.bytedance.android.livesdk.utils.r2.a(r4) == false) goto L22;
        r1.addProperty("request_page", r4);
    L22:
        r0.add("panel_config", r1);
        goto L23
    L18:
        r6 = null;
        goto L19
    L25:
        if ("emoji_interact_panel_type".equals(r17) == false) goto L378;
        ILinkPlayerInfoBridge r7 = com.bytedance.android.live.liveinteract.videotalk.utils.panel.a.a;
        Intrinsics.checkNotNullParameter(r17, "panelType");
        Intrinsics.checkNotNullParameter(r18, "callType");
        Intrinsics.checkNotNullParameter(r19, "extraData");
        String r9 = "";
        Intrinsics.checkNotNullParameter("", "requestPage");
        ALogger.d("LynxEmojiPanelHandler", "handleLinkLynxPanelJsbGetAction call panelType=" + r17 + " callType=" + r18 + " extraData=" + r19);
        JsonObject r10 = new JsonObject();
        int r11 = r18.hashCode();
        if (r11 == (-762772154)) goto L54;
        if (r11 == 1961082449) goto L32;
    L376:
        return r10;
    L32:
        if (r18.equals("ktv_order_info") == false) goto L376;
        JsonElement r12 = r19.get("user_id");
        if (r12 == null) goto L52;
        String r13 = r12.getAsString();
        if (r13 == null) goto L52;
        if (com.bytedance.android.livesdk.utils.r2.a(r13) != true) goto L52;
        JsonElement r14 = r19.get("user_id");
        if (r14 == null) goto L42;
        String r15 = r14.getAsString();
    L43:
        JsonArray r16 = new JsonArray();
        if (r15 == null) goto L47;
        r9 = r15;
    L47:
        Iterator<T> r20 = je0.d.k0(r9).iterator();
    L49:
        if (r20.hasNext() == false) goto L51;
        KtvMusic r21 = (KtvMusic) r20.next();
        JsonObject r22 = new JsonObject();
        r22.addProperty("id", Long.valueOf(r21.getId()));
        r22.addProperty("title", r21.getTitle());
        r16.add(r22);
        goto L49
    L51:
        r10.add("song_list", r16);
        goto L376
    L42:
        r15 = null;
    L52:
        ALogger.w("LynxEmojiPanelHandler", "handleLinkLynxPanelJsbGetAction ktv_order_info call return, currentUser is null");
        goto L376
    L54:
        if (r18.equals("interact_panel_config") == false) goto L376;
        boolean r23 = false;
        com.bytedance.android.live.liveinteract.videotalk.utils.panel.a.g = false;
        com.bytedance.android.live.liveinteract.videotalk.utils.panel.a.h = false;
        com.bytedance.android.live.liveinteract.videotalk.utils.panel.a.i = false;
        JsonObject r24 = new JsonObject();
        JsonElement r110 = r19.get("target_user_id");
        if (r110 == null) goto L375;
        String r111 = r110.getAsString();
        if (r111 == null) goto L375;
        if (com.bytedance.android.livesdk.utils.r2.a(r111) != true) goto L375;
        JsonElement r112 = r19.get("target_user_id");
        if (r112 == null) goto L64;
        String r113 = r112.getAsString();
    L65:
        IInteractService r114 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r114 == null) goto L86;
        com.bytedance.android.live.liveinteract.plantform.base.i<ILinkPlayerInfoBridge> r115 = r114.getLinkUserInfoCenter();
        if (r115 == null) goto L86;
        Iterable r116 = r115.getOnlineUserList();
        if (r116 == null) goto L86;
        Iterator r117 = r116.iterator();
    L73:
        if (r117.hasNext() == false) goto L84;
        Object r118 = r117.next();
        IBaseUser r119 = ((ILinkPlayerInfoBridge) r118).getUser();
        if (r119 == null) goto L77;
        String r120 = r119.getIdString();
    L78:
        if (r113 != null) goto L80;
        String r121 = "";
    L82:
        if (Intrinsics.areEqual(r120, r121) == false) goto L73;
    L85:
        ILinkPlayerInfoBridge r122 = (ILinkPlayerInfoBridge) r118;
    L88:
        if (r122 == null) goto L125;
        com.bytedance.android.live.liveinteract.videotalk.utils.panel.a.d = r122.getUserPosition();
        com.bytedance.android.live.liveinteract.videotalk.utils.panel.a.a = r122;
        String r123 = je0.d.b0();
        ILinkPlayerInfoBridge r124 = com.bytedance.android.live.liveinteract.videotalk.utils.panel.a.a;
        if (r124 == null) goto L94;
        IBaseUser r125 = r124.getUser();
        if (r125 == null) goto L94;
        String r126 = r125.getIdString();
    L96:
        if (Intrinsics.areEqual(r123, r126) == false) goto L115;
        if (je0.d.y() == true) goto L100;
    L102:
        DigitAvatarContext r127 = DigitAvatarContext.Companion.getContext();
        if (r127 == null) goto L107;
        VideoShowMode r128 = r127.getCurrentVideoShowMode();
        if (r128 == null) goto L107;
        Integer r129 = Integer.valueOf(r128.getType());
    L111:
        if (r129 == null) goto L113;
        int r130 = r129.intValue();
    L123:
        r122.setLinkType(r130);
        int r131 = nh0.f.i;
        r24.addProperty("target_user", nh0.f.a.b(r122).toString());
    L249:
        String r25 = je0.d.b0();
        ILinkPlayerInfoBridge r132 = com.bytedance.android.live.liveinteract.videotalk.utils.panel.a.a;
        if (r132 == null) goto L254;
        IBaseUser r133 = r132.getUser();
        if (r133 == null) goto L254;
        String r134 = r133.getIdString();
    L256:
        if (Intrinsics.areEqual(r25, r134) == false) goto L282;
        DigitAvatarContext r26 = DigitAvatarContext.Companion.getContext();
        if (r26 == null) goto L262;
        VideoShowMode r27 = r26.getCurrentVideoShowMode();
        if (r27 == null) goto L262;
        Integer r28 = Integer.valueOf(r27.getType());
    L266:
        if (r28 == null) goto L268;
        int r29 = r28.intValue();
    L269:
        r24.addProperty("link_type", Integer.valueOf(r29));
        if (r29 != VideoShowMode.VIDEO.getType()) goto L272;
    L281:
        r24.addProperty("degrade_video", Boolean.FALSE);
    L287:
        ILinkPlayerInfoBridge r30 = com.bytedance.android.live.liveinteract.videotalk.utils.panel.a.a;
        if (r30 == null) goto L290;
        Long r31 = Long.valueOf(r30.getLinkRoomId());
    L291:
        if (r31 == null) goto L294;
        r24.addProperty("target_room_id", r31);
    L294:
        if (r19.has("setting_list") == false) goto L307;
        JsonObject r135 = new JsonObject();     // Catch: Exception -> L305
        JsonArray r32 = r19.get("setting_list").getAsJsonArray();     // Catch: Exception -> L305
        ArrayList r136 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r32, 10));     // Catch: Exception -> L305
        Iterator r33 = r32.iterator();     // Catch: Exception -> L305
    L297:
        if (r33.hasNext() == false) goto L299;
        r136.add(((JsonElement) r33.next()).getAsString());     // Catch: Exception -> L305
        goto L297
    L299:
        Iterator r34 = SettingUtilExtensionKt.getSettingsValue(r136).iterator();     // Catch: Exception -> L305
    L301:
        if (r34.hasNext() == false) goto L303;
        Pair r137 = (Pair) r34.next();     // Catch: Exception -> L305
        r135.add((String) r137.getFirst(), (JsonElement) r137.getSecond());     // Catch: Exception -> L305
        goto L301
    L303:
        r24.add("settings", r135);     // Catch: Exception -> L305
    L305:
        ALogger.w("LynxEmojiPanelHandler", "handleLinkLynxPanelJsbGetAction call settings_list not array");
    L307:
        if (r19.has("local_data") == true) goto L379;
    L315:
        r24.addProperty("enable_camera", Boolean.valueOf(tc0.c.h().E));
        r24.addProperty("themed_competition_status", Integer.valueOf(ThemedCompetitionContext.Companion.g() ? 1 : 0));
        CPositionContext.Companion.getClass();
        if (CPositionContext.a.a("") == false) goto L325;
        com.bytedance.live.datacontext.m r35 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r35 == null) goto L324;
        IRoom r36 = (IRoom) r35.getValue();
        if (r36 == null) goto L324;
        if (r36.isLiveTypeAudio() != true) goto L324;
        r23 = ((MultiLinkEnlargeTipsConfig) com.bytedance.android.livesdk.sharedpref.c.d.getValue()).getHasClicked();
    L324:
        r23 = ((MultiLinkEnlargeTipsConfig) com.bytedance.android.livesdk.sharedpref.c.c.getValue()).getHasClicked();
    L325:
        r24.addProperty("show_enlarge_button_tip", Boolean.valueOf(!r23));
        Pair r37 = com.bytedance.android.live.liveinteract.videotalk.utils.panel.a.q();
        if (r37 == null) goto L328;
        JsonObject r38 = new JsonObject();
        r38.addProperty("type", Integer.valueOf(((LinkScreenCastType) r37.getFirst()).getTypeValue()));
        r38.addProperty("app_id", ((com.bytedance.android.live.liveinteract.linkcast.c) r37.getSecond()).a);
        r38.addProperty("icon_url", ((com.bytedance.android.live.liveinteract.linkcast.c) r37.getSecond()).b);
        r38.addProperty("icon_name", ((com.bytedance.android.live.liveinteract.linkcast.c) r37.getSecond()).c);
    L329:
        if (r38 == null) goto L332;
        r24.add("cast_info", r38);
    L332:
        if (gd0.v.a(((IInteractService) jc1.k.n(IInteractService.class)).getLinkMode(), 32) == true) goto L334;
    L363:
        Integer r39 = null;
    L364:
        if (r39 == null) goto L367;
        r24.addProperty("avatar_audit_status", Integer.valueOf(r39.intValue()));
    L367:
        if (je0.d.y() == false) goto L373;
        r24.addProperty("ktv_singer_id", je0.d.g());
        com.bytedance.live.datacontext.m r40 = com.bytedance.android.live.liveinteract.api.utils.m.d().q();
        if (r40 == null) goto L373;
        nd r41 = (nd) r40.getValue();
        if (r41 == null) goto L373;
        r24.addProperty("ktv_host_max_num", Integer.valueOf(r41.b));
    L373:
        r10.add("panel_config", r24);
        goto L376
    L334:
        if (hd0.c.f().h() == false) goto L363;
        List<VideoShowMode> r42 = com.bytedance.android.live.liveinteract.digitavatar.c0.a(je0.d.r(), com.bytedance.android.live.liveinteract.api.utils.m.i().getCurrentRoom(), true);
        int r43 = com.bytedance.android.live.liveinteract.plantform.utils.x.a;
        ArrayList r44 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r42, 10));
        ArrayList r45 = (ArrayList) r42;
        Iterator r46 = r45.iterator();
    L337:
        if (r46.hasNext() == false) goto L339;
        r44.add(((VideoShowMode) r46.next()).name());
        goto L337
    L339:
        Intrinsics.checkNotNullParameter(r44, "modes");
        LinkedHashMap r47 = new LinkedHashMap();
        r47.put("modes", r44.toString());
        com.bytedance.android.live.liveinteract.plantform.utils.x.t0("digit_avatar_supported_video_show_mode", r47);
        TalkRoomBusinessFullLinkMonitor r48 = TalkRoomBusinessFullLinkMonitor.a;
        ArrayList r49 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r42, 10));
        Iterator r50 = r45.iterator();
    L341:
        if (r50.hasNext() == false) goto L343;
        r49.add(((VideoShowMode) r50.next()).name());
        goto L341
    L343:
        r48.getClass();
        TalkRoomBusinessFullLinkMonitor.m(r49);
        if (r45.size() <= 1) goto L363;
        int r51 = DigitAvatarAuditStatus.PASS.getStatusValue();
        DigitAvatarContext r52 = DigitAvatarContext.Companion.getContext();
        if (r52 == null) goto L362;
        com.bytedance.live.datacontext.m<com.bytedance.android.live.liveinteract.digitavatar.n> r53 = r52.getDigitAvatar();
        if (r53 == null) goto L362;
        com.bytedance.android.live.liveinteract.digitavatar.n r54 = (com.bytedance.android.live.liveinteract.digitavatar.n) r53.getValue();
        if (r54 == null) goto L362;
        boolean r55 = r54.a;
        if (r55 == false) goto L354;
    L356:
        if (r55 == true) goto L362;
        if (r54.e == false) goto L362;
        if (r54.c == true) goto L362;
        r51 = DigitAvatarAuditStatus.NOT_PASS.getStatusValue();
        goto L362
    L354:
        if (r54.e == true) goto L356;
        r51 = DigitAvatarAuditStatus.AUDITING.getStatusValue();
    L362:
        r39 = Integer.valueOf(r51);
        goto L364
    L328:
        r38 = null;
        goto L329
    L379:
        JsonObject r56 = new JsonObject();     // Catch: Exception -> L314
        Application r138 = jc1.a.b();     // Catch: Exception -> L314
        ExecutorService r139 = v5.a;     // Catch: Exception -> L314
        SharedPreferences r140 = r138.getSharedPreferences("js_kv_methods_20191113", 0);     // Catch: Exception -> L314
        Iterator r57 = r19.get("local_data").getAsJsonArray().iterator();     // Catch: Exception -> L314
    L310:
        if (r57.hasNext() == false) goto L312;
        String r58 = ((JsonElement) r57.next()).getAsString();     // Catch: Exception -> L314
        r56.addProperty(r58, r140.getString(r58, ""));     // Catch: Exception -> L314
        goto L310
    L312:
        r24.add("local_storage", r56);     // Catch: Exception -> L314
    L314:
        ALogger.w("LynxEmojiPanelHandler", "handleLinkLynxPanelJsbGetAction call local_data not array");
        goto L315
    L290:
        r31 = null;
        goto L291
    L272:
        if (r29 == VideoShowMode.DIGIT_AVATAR.getType()) goto L281;
        com.bytedance.android.live.liveinteract.plantform.performance.a r59 = ((IInteractService) jc1.k.n(IInteractService.class)).getMultiLinkPerfAbilityManager(true);
        if (r59 != null) goto L277;
    L279:
        boolean r60 = false;
    L280:
        r24.addProperty("degrade_video", Boolean.valueOf(r60));
        goto L287
    L277:
        if (r59.a("multilink_video_link_enable") == true) goto L279;
        r60 = true;
        goto L280
    L268:
        r29 = VideoShowMode.AUDIO.getType();
    L262:
        ILinkPlayerInfoBridge r61 = com.bytedance.android.live.liveinteract.videotalk.utils.panel.a.a;
        if (r61 == null) goto L265;
        r28 = Integer.valueOf(r61.getLinkType());
        goto L266
    L265:
        r28 = null;
        goto L266
    L282:
        ILinkPlayerInfoBridge r62 = com.bytedance.android.live.liveinteract.videotalk.utils.panel.a.a;
        if (r62 == null) goto L285;
        int r63 = r62.getLinkType();
    L286:
        r24.addProperty("link_type", Integer.valueOf(r63));
        goto L287
    L285:
        r63 = VideoShowMode.AUDIO.getType();
    L254:
        r134 = null;
        goto L256
    L113:
        r130 = VideoShowMode.AUDIO.getType();
    L107:
        ILinkPlayerInfoBridge r141 = com.bytedance.android.live.liveinteract.videotalk.utils.panel.a.a;
        if (r141 == null) goto L110;
        r129 = Integer.valueOf(r141.getLinkType());
        goto L111
    L110:
        r129 = null;
        goto L111
    L100:
        if (jc0.a.a() == true) goto L102;
        r130 = VideoShowMode.AUDIO.getType();
        goto L123
    L115:
        if (je0.d.y() == true) goto L117;
    L119:
        ILinkPlayerInfoBridge r142 = com.bytedance.android.live.liveinteract.videotalk.utils.panel.a.a;
        if (r142 == null) goto L122;
        r130 = r142.getLinkType();
        goto L123
    L122:
        r130 = VideoShowMode.AUDIO.getType();
        goto L123
    L117:
        if (jc0.a.a() == true) goto L119;
        r130 = VideoShowMode.AUDIO.getType();
    L94:
        r126 = null;
        goto L96
    L125:
        if (je0.d.z() == false) goto L152;
        IInteractService r143 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r143 == null) goto L129;
        com.bytedance.android.live.liveinteract.plantform.base.i<ILinkPlayerInfoBridge> r144 = r143.getLinkUserInfoCenter();
    L131:
        if ((r144 instanceof com.bytedance.android.live.liveinteract.plantform.core.y) == true) goto L133;
        r144 = null;
    L133:
        com.bytedance.android.live.liveinteract.plantform.core.y r145 = (com.bytedance.android.live.liveinteract.plantform.core.y) r144;
        if (r145 == null) goto L171;
        CopyOnWriteArrayList<ILinkPlayerInfoBridge> r146 = r145.d;
        if (r146 == null) goto L171;
        Iterator<T> r147 = r146.iterator();
    L139:
        if (r147.hasNext() == false) goto L150;
        Object r148 = r147.next();
        IBaseUser r149 = ((ILinkPlayerInfoBridge) r148).getUser();
        if (r149 == null) goto L143;
        String r150 = r149.getIdString();
    L144:
        if (r113 != null) goto L146;
        String r65 = "";
    L148:
        if (Intrinsics.areEqual(r150, r65) == false) goto L139;
    L151:
        ILinkPlayerInfoBridge r151 = (ILinkPlayerInfoBridge) r148;
    L172:
        if (r151 == null) goto L200;
        com.bytedance.android.live.liveinteract.videotalk.utils.panel.a.d = r151.getUserPosition();
        com.bytedance.android.live.liveinteract.videotalk.utils.panel.a.a = r151;
        String r66 = je0.d.b0();
        ILinkPlayerInfoBridge r152 = com.bytedance.android.live.liveinteract.videotalk.utils.panel.a.a;
        if (r152 == null) goto L178;
        IBaseUser r153 = r152.getUser();
        if (r153 == null) goto L178;
        String r154 = r153.getIdString();
    L180:
        if (Intrinsics.areEqual(r66, r154) == false) goto L194;
        DigitAvatarContext r67 = DigitAvatarContext.Companion.getContext();
        if (r67 == null) goto L186;
        VideoShowMode r68 = r67.getCurrentVideoShowMode();
        if (r68 == null) goto L186;
        int r69 = r68.getType();
    L189:
        Integer r70 = Integer.valueOf(r69);
    L191:
        if (r70 == null) goto L193;
        int r71 = r70.intValue();
    L198:
        r151.setLinkType(r71);
        int r72 = nh0.f.i;
        r24.addProperty("target_user", nh0.f.a.b(r151).toString());
        goto L249
    L193:
        r71 = VideoShowMode.AUDIO.getType();
    L186:
        ILinkPlayerInfoBridge r73 = com.bytedance.android.live.liveinteract.videotalk.utils.panel.a.a;
        if (r73 == null) goto L190;
        r69 = r73.getLinkType();
        goto L189
    L190:
        r70 = null;
        goto L191
    L194:
        ILinkPlayerInfoBridge r74 = com.bytedance.android.live.liveinteract.videotalk.utils.panel.a.a;
        if (r74 == null) goto L197;
        r71 = r74.getLinkType();
        goto L198
    L197:
        r71 = VideoShowMode.AUDIO.getType();
    L178:
        r154 = null;
        goto L180
    L200:
        if (je0.d.f() != 0) goto L374;
        int r75 = nh0.f.i;
        JsonElement r76 = new JsonObject();
        com.bytedance.live.datacontext.m r155 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r155 == null) goto L248;
        IRoom r156 = (IRoom) r155.getValue();
        if (r156 == null) goto L248;
        IBaseUser r157 = r156.getOwner();
        if (r157 == null) goto L248;
        r76.addProperty("id_str", r157.getIdString());
        r76.addProperty("short_id", Long.valueOf(r157.getShortId()));
        Intrinsics.checkNotNullParameter(r157, "$this$secUidExt");
        r76.addProperty("sec_uid", r157.getCastSecUid());
        r76.addProperty("nickname", r157.getRealNickName());
        r76.addProperty("is_anonymous", Boolean.valueOf(r157.isAnonymous()));
        r76.addProperty("signature", r157.getSignature());
        py.k r158 = r157.getAvatarThumbKt();
        if (r158 == null) goto L211;
        List r159 = r158.getUrls();
    L212:
        if (r159 == null) goto L214;
        int r160 = r159.size();
    L215:
        if (r160 <= 0) goto L221;
        if (r159 == null) goto L219;
        String r161 = (String) ListProtector.get(r159, 0);
        if (r161 == null) goto L219;
    L220:
        r76.addProperty("avatar", r161);
    L219:
        r161 = "";
    L221:
        py.k r162 = r157.getAvatarMedium();
        if (r162 == null) goto L224;
        List r163 = r162.getUrls();
    L225:
        if (r163 == null) goto L227;
        int r164 = r163.size();
    L228:
        if (r164 <= 0) goto L234;
        if (r163 == null) goto L232;
        String r165 = (String) ListProtector.get(r163, 0);
        if (r165 == null) goto L232;
    L233:
        r76.addProperty("avatar_medium", r165);
    L232:
        r165 = "";
    L234:
        py.k r166 = r157.getAvatarLarge();
        if (r166 == null) goto L237;
        List r167 = r166.getUrls();
    L238:
        if (r167 == null) goto L240;
        int r168 = r167.size();
    L241:
        if (r168 <= 0) goto L247;
        if (r167 == null) goto L245;
        String r169 = (String) ListProtector.get(r167, 0);
        if (r169 == null) goto L245;
    L246:
        r76.addProperty("avatar_large", r169);
    L245:
        r169 = "";
    L247:
        JsonElement r170 = new JsonObject();
        r170.add("user", r76);
        r76 = r170;
        goto L248
    L240:
        r168 = 0;
        goto L241
    L237:
        r167 = null;
        goto L238
    L227:
        r164 = 0;
        goto L228
    L224:
        r163 = null;
        goto L225
    L214:
        r160 = 0;
        goto L215
    L211:
        r159 = null;
    L248:
        r24.addProperty("target_user", r76.toString());
        goto L249
    L374:
        ALogger.w("LynxEmojiPanelHandler", "handleLinkLynxPanelJsbGetAction call return, currentUser is null and onlineList not found");
        goto L376
    L146:
        r65 = r113;
        goto L148
    L143:
        r150 = null;
        goto L144
    L150:
        r148 = null;
    L171:
        r151 = null;
        goto L172
    L129:
        r144 = null;
        goto L131
    L152:
        IInteractService r77 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r77 == null) goto L171;
        List<ILinkPlayerInfoBridge> r78 = r77.getCrossRoomFightLinkUserInfoList();
        if (r78 == null) goto L171;
        Iterator<T> r79 = r78.iterator();
    L158:
        if (r79.hasNext() == false) goto L169;
        Object r171 = r79.next();
        IBaseUser r172 = ((ILinkPlayerInfoBridge) r171).getUser();
        if (r172 == null) goto L162;
        String r173 = r172.getIdString();
    L163:
        if (r113 != null) goto L165;
        String r174 = "";
    L167:
        if (Intrinsics.areEqual(r173, r174) == false) goto L158;
    L170:
        r151 = (ILinkPlayerInfoBridge) r171;
        goto L172
    L165:
        r174 = r113;
        goto L167
    L162:
        r173 = null;
        goto L163
    L169:
        r171 = null;
        goto L170
    L80:
        r121 = r113;
        goto L82
    L77:
        r120 = null;
        goto L78
    L84:
        r118 = null;
    L86:
        r122 = null;
        goto L88
    L64:
        r113 = null;
    L375:
        ALogger.w("LynxEmojiPanelHandler", "handleLinkLynxPanelJsbGetAction call return, currentUser is null");
        goto L376
    L378:
        return new JsonObject();
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public void handleLinkLynxPanelLinkControlAction(int r2, DataCenter r3, String r4) {
        if (r2 != 0) goto L19;
        ILinkPlayerInfoBridge r5 = com.bytedance.android.live.liveinteract.videotalk.utils.panel.a.a;
        Intrinsics.checkNotNullParameter(r4, "actionSource");
        Activity r6 = com.bytedance.android.live.core.utils.a.d();
        if (r6 == null) goto L21;
        if (r3 != null) goto L9;
        return;
    L9:
        if (com.bytedance.android.livesdk.utils.r2.a(r4) == true) goto L12;
        r4 = com.bytedance.android.live.liveinteract.videotalk.utils.panel.a.b;
    L12:
        com.bytedance.android.live.liveinteract.videotalk.utils.panel.a.b = "seat";
        je0.d.y();
        TalkRoomLogUtils.B(r4, je0.d.Z());
        if (com.bytedance.android.live.liveinteract.plantform.utils.s0.b() == true) goto L15;
    L17:
        com.bytedance.android.live.liveinteract.videotalk.emoji.y.e(r3, r6, r4);
        return;
    L15:
        if (com.bytedance.android.live.liveinteract.videotalk.emoji.y.c() == true) goto L17;
        com.bytedance.android.live.liveinteract.videotalk.emoji.y.d(r4);
        return;
    L21:
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public boolean isVideoEqualCenterAllFullLayout(int r4, int r5, int r6) {
        MultiLinkFrequencyOptConfig r0 = com.bytedance.android.live.liveinteract.plantform.commonwindow.utils.f.a;
        if (r4 == 12) goto L5;
    L10:
        if (r4 == 12) goto L12;
    L18:
        return false;
    L12:
        if (r6 != 7) goto L14;
    L17:
        return true;
    L14:
        if (r6 == 6) goto L17;
        if (com.bytedance.android.live.liveinteract.plantform.commonwindow.utils.f.m(Integer.valueOf(r5), Integer.valueOf(r6)) == false) goto L18;
    L5:
        if (r5 == 15) goto L17;
        if (r5 == 12) goto L17;
        if (com.bytedance.android.live.liveinteract.plantform.commonwindow.utils.f.m(Integer.valueOf(r5), Integer.valueOf(r6)) == false) goto L10;
        goto L10
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public void kickOutLinkUserInChatRoom(String r6, String r7, String r8) {
        if (jc1.k.f(IMiddlewareUserService.class) != null) goto L6;
        return;
    L6:
        if (com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom() != null) goto L8;
        return;
    L8:
        boolean r0 = TextUtils.equals(jc1.k.f(IMiddlewareUserService.class).user().n(), ((IRoom) com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom().getValue()).getOwnerUserIdString());
        int r1 = getLinkMode();
        if (gd0.v.a(r1, 32) == false) goto L26;
        if (r0 == false) goto L18;
        rj0.k.m2.getClass();
        if (rj0.k.a.a() == null) goto L15;
        IBaseUser r9 = vh7.f.c(IBaseUser.class);
        r9.setIdString(r6);
        r9.setCastSecUid(r7);
        rj0.k.a.a().Kh(r6, r7);
        return;
    L15:
        if (jc1.k.f(IMultiLinkServiceExternal.class).getControlServiceExternal().c() == false) goto L59;
        ((IMultiPkAudienceLinkOutService) jc1.k.f(IMultiPkAudienceLinkOutService.class)).kickOut(r6, r7, "anchor_stop_normal");
        return;
    L59:
        return;
    L18:
        if (jc1.k.f(IMiddlewareUserService.class).user().c() == false) goto L61;
        com.bytedance.android.live.liveinteract.plantform.base.k.n0.getClass();
        if (com.bytedance.android.live.liveinteract.plantform.base.k.a.a() == null) goto L23;
        IBaseUser r10 = vh7.f.c(IBaseUser.class);
        r10.setIdString(r6);
        r10.setCastSecUid(r7);
        com.bytedance.android.live.liveinteract.plantform.base.k.a.a().ge(r6, r7);
        return;
    L23:
        if (jc1.k.f(IMultiLinkServiceExternal.class).getControlServiceExternal().c() == false) goto L63;
        ((IMultiPkAudienceLinkOutService) jc1.k.f(IMultiPkAudienceLinkOutService.class)).kickOut(r6, r7, "admin_stop_normal");
        return;
    L63:
        return;
    L61:
        return;
    L26:
        if (gd0.v.a(r1, 8) == false) goto L28;
    L35:
        Intrinsics.checkNotNullParameter(r6, "userId");
        Intrinsics.checkNotNullParameter(r7, "secId");
        Intrinsics.checkNotNullParameter(r8, "name");
        IBaseUser r2 = vh7.f.c(IBaseUser.class);
        r2.setIdString(r6);
        Intrinsics.checkNotNullParameter(r2, "$this$secUidExt");
        r2.setCastSecUid(r7);
        r2.setNickName(r8);
        if (r0 == false) goto L47;
        com.bytedance.android.live.liveinteract.plantform.base.d.j0.getClass();
        if (com.bytedance.android.live.liveinteract.plantform.base.d.a.a() == null) goto L41;
        com.bytedance.android.live.liveinteract.plantform.base.d.a.a().kickOut(r6, r7, "anchor_stop_normal");
        return;
    L41:
        if (jc1.k.f(IMultiLinkServiceExternal.class).getControlServiceExternal().c() == false) goto L43;
        ((IMultiPkAudienceLinkOutService) jc1.k.f(IMultiPkAudienceLinkOutService.class)).kickOut(r6, r7, "anchor_stop_normal");
        return;
    L43:
        IVoiceChatAdminService.Companion.getClass();
        IVoiceChatAdminService r11 = IVoiceChatAdminService.a.a();
        if (r11 == null) goto L70;
        r11.kickOut(r2);
        return;
    L70:
        return;
    L47:
        if (jc1.k.f(IMiddlewareUserService.class).user().c() == false) goto L72;
        com.bytedance.android.live.liveinteract.plantform.base.c.i0.getClass();
        if (com.bytedance.android.live.liveinteract.plantform.base.c.a.a() == null) goto L52;
        com.bytedance.android.live.liveinteract.plantform.base.c.a.a().kickOut(r6, r7, "admin_stop_normal");
        return;
    L52:
        if (jc1.k.f(IMultiLinkServiceExternal.class).getControlServiceExternal().c() == false) goto L54;
        ((IMultiPkAudienceLinkOutService) jc1.k.f(IMultiPkAudienceLinkOutService.class)).kickOut(r6, r7, "anchor_stop_normal");
        return;
    L54:
        IVoiceChatAdminService.Companion.getClass();
        IVoiceChatAdminService r12 = IVoiceChatAdminService.a.a();
        if (r12 == null) goto L75;
        r12.kickOut(r2);
        return;
    L75:
        return;
    L72:
        return;
    L28:
        if (gd0.v.a(r1, 2) == true) goto L35;
        iy.g r13 = getDynamicCenterService(null);
        if (r13 == null) goto L65;
        r13.getCurrentScene();
        if (r13.getCurrentScene() != 20) goto L66;
        r13.Io(r6);
        return;
    L66:
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public void logMiniAppShareIconClick(String r2, String r3, boolean r4) {
        rj0.k.m2.getClass();
        if (rj0.k.a.a() == null) goto L6;
        rj0.k.a.a().logMiniAppShareIconClick(r2, r3, r4);
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public void logMiniAppShareIconShow(String r2, String r3, boolean r4) {
        rj0.k.m2.getClass();
        if (rj0.k.a.a() == null) goto L6;
        rj0.k.a.a().logMiniAppShareIconShow(r2, r3, r4);
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public boolean needAdjustBottomDpForSearchFeed(int r2, int r3, int r4) {
        if (r2 != 5) goto L9;
        MultiLinkFrequencyOptConfig r5 = com.bytedance.android.live.liveinteract.plantform.commonwindow.utils.f.a;
        if (com.bytedance.android.live.liveinteract.plantform.commonwindow.utils.f.e(Integer.valueOf(r3), Integer.valueOf(r4)) == false) goto L7;
    L8:
        return true;
    L7:
        if (r4 == 112) goto L8;
    L9:
        return false;
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public boolean needAdjustScreen(int r1, int r2, int r3) {
        return com.bytedance.android.live.liveinteract.plantform.commonwindow.utils.f.o(r1, r2, r3);
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public void onAudienceEnterRoomWithPreload(IRoom r2, long r3, long r5) {
        com.bytedance.android.live.liveinteract.plantform.utils.i0 r0 = TalkRoomLogUtils.a;
        TalkRoomLogUtils.y = r3;
        TalkRoomLogUtils.z = r5;
        TalkRoomLogUtils.m0(r2, r3, r5);
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public void onLiveCoreAVLinkLogMonitor(String r3, String r4, JSONObject r5) {
        if (vm2.i.k().getEnable() == true) goto L5;
        return;
    L5:
        if (r3 != null) goto L7;
        return;
    L7:
        if (LiveTracingMonitor.EventType.SDK_INTERFACE_CALL.getName().equalsIgnoreCase(r3) == false) goto L9;
        r4 = "liveCore_" + r4;
    L9:
        v2.a(r3, r4, r5);
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public void openLinkmicSubtitleSettingDialog(Context r3, String r4, IAudioSubtitleContent r5) {
        if (((Boolean) subtitleExceptPlayModeOpen().first).booleanValue() != true) goto L7;
        com.bytedance.android.live.core.utils.f2.c((String) subtitleExceptPlayModeOpen().second, 0);
        return;
    L7:
        if (ContextUtil.contextToFragmentActivity(r3) == null) goto L9;
        FragmentManager r6 = ContextUtil.contextToFragmentActivity(r3).getSupportFragmentManager();
    L10:
        if (r6 == null) goto L13;
        String r0 = LinkmicSubtitleSettingDialog.j;
        INVOKEVIRTUAL_com_bytedance_android_live_multilink_impl_InteractService_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_show(LinkmicSubtitleSettingDialog.a.a(r5, r4), r6, "LinkmicSubtitleSettingDialog");
        return;
    L13:
        return;
    L9:
        r6 = null;
        goto L10
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public void preloadDynamicWidget(DataCenter r5, WidgetManager r6, @Nullable Room r7) {
        if (com.bytedance.android.live.liveinteract.plantform.multiroom.e.b(r5) != null) goto L18;
        MultiLinkDynamicWidgetNew r0 = null;
        if (r7 == null) goto L10;
        ViewGroup r1 = (ViewGroup) r6.contentView;
        Long r8 = Long.valueOf(r7.getRoomId());
        int r2 = PlayModeService.g;
        if (r1 == null) goto L14;
        r0 = new MultiLinkDynamicWidgetNew(r1, r8);
    L14:
        ALogger.i("yzc", "InteractService#preloadDynamicWidget stack= " + Log.getStackTraceString(new Throwable()));
        r6.load(r0);
        if ((r0 instanceof ih0.b) == false) goto L19;
        com.bytedance.android.live.liveinteract.plantform.multiroom.e.e(r5, r0, r6);
        return;
    L19:
        return;
    L10:
        ViewGroup r9 = (ViewGroup) r6.contentView;
        int r3 = PlayModeService.g;
        if (r9 == null) goto L14;
        r0 = new MultiLinkDynamicWidgetNew(r9, null);
        goto L14
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public void prepareInvite(long r2, IBaseUser r4, String r5) {
        if (com.bytedance.android.live.liveinteract.plantform.base.f.a() == null) goto L6;
        com.bytedance.android.live.liveinteract.plantform.base.f.a().prepareInvite(r2, r4, r5);
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public void stopLinkCast(LinkScreenCastType r3, String r4, boolean r5) {
        rj0.k.m2.getClass();
        if (rj0.k.a.a() == null) goto L6;
        rj0.k.a.a().ne(r3, r4, "miniApp", r5);
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public void updateLinkMicStatus(ih0.f r2, ih0.h r3, IJsBridgeManager r4) {
        if (com.bytedance.android.live.liveinteract.plantform.base.f.a() == null) goto L6;
        com.bytedance.android.live.liveinteract.plantform.base.f.a().updateLinkMicStatus(r2, r3, r4);
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public void updateViewInLiveBg(String r2, JsonObject r3, ih0.h r4) {
        if (com.bytedance.android.live.liveinteract.plantform.base.f.a() == null) goto L6;
        com.bytedance.android.live.liveinteract.plantform.base.f.a().updateViewInLiveBg(r2, r3, r4);
        return;
    }

    private static /* synthetic */ void lambda$tryOpenChooseGuestPanelWithUsage$3(String r2, String r3, List r4, List r5) {
        if (TextUtils.equals(r2, "create_team_fight") == false) goto L13;
        JSONObject r6 = new JSONObject(r3);     // Catch: JSONException -> L8
        long r0 = JSONObjectProtectorUtils.getLong(r6, "duration");     // Catch: JSONException -> L8
        String r7 = JSONObjectProtectorUtils.getString(r6, "requestPage");     // Catch: JSONException -> L8
        if (TeamFightContext.getTeamFightWidget() == null) goto L14;
        TeamFightContext.getTeamFightWidget().M5(r0, r7, r4);     // Catch: JSONException -> L8
        return;
    L14:
        return;
    L8:
        e = move-exception;
        ALogger.e("ttlive_link", e);
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public boolean enableVideoChorus(Boolean r12, Integer r13, String r14, h80.a<Boolean> r15) {
        if (je0.d.L() == false) goto L9;
        IKtvService r0 = jc1.k.f(IKtvService.class);
        if (r0 == null) goto L11;
        r0.enableVideoChorus(new jd2.g(r12.booleanValue(), true, false, r13.intValue(), 0, r14, r15, null));
        return true;
    L11:
        return true;
    L9:
        return false;
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public String getDisplayTicketStr(long r2, List<Long> r4, String r5, String r6) {
        int r0 = com.bytedance.android.live.liveinteract.utils.y.a;
        return com.bytedance.android.live.liveinteract.utils.y.a(String.valueOf(r2), jc1.m.a(r4), r5, r6);
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public ih0.d getDynamicEmojiDialog(Context r3, DataCenter r4, String r5, boolean r6) {
        com.bytedance.android.live.liveinteract.videotalk.emoji.t r0 = new com.bytedance.android.live.liveinteract.videotalk.emoji.t();
        Intrinsics.checkNotNullParameter(r3, "context");
        r0.a = r3;
        Intrinsics.checkNotNullParameter(r4, "dataCenter");
        r0.b = r4;
        r0.g(false);
        Intrinsics.checkNotNullParameter(r5, "requestPage");
        r0.d = r5;
        r0.e = false;
        r0.f = r6;
        return r0.a();
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public IInteractFeedView getInteractFeedView(Context r8, SeiAppData r9, int r10, int r11) {
        if (r11 != 0) goto L4;
        r11 = -1;
    L4:
        int r3 = r9.getVersion();
        if (((List) vm2.c.A.getValue(null, vm2.c.a[25])).contains(Integer.valueOf(r3)) == true) goto L7;
        ln0.a r0 = yg0.h.a;
        if (yg0.h.j(r3, r9.getUiLayout()) == false) goto L31;
        if (isVoiceChatRoomSeiVersion(r3) == true) goto L31;
        int r1 = com.bytedance.android.live.liveinteract.utils.c1.a;
        if (com.bytedance.android.live.liveinteract.utils.c1.a(Integer.valueOf(r3), Integer.valueOf(r10)) == false) goto L17;
        if (r11 != 5) goto L17;
        return null;
    L17:
        if (r3 != 16) goto L21;
        return new MultiLinkVideoTeamFightFeedView(r8, r3, r10, r11);
    L21:
        if (isRoomFightSeiVersion(r3) == false) goto L25;
        return new MultiLinkLinkRoomFightFeedView(r8, r3, r10, r11);
    L25:
        if (r3 != 30) goto L29;
        return new MultiLinkGameFeedView(r8, r9, r3, r10, r11);
    L29:
        return new CommonMultiLinkFeedView(r8, r3, r10, r11, null, 0);
    L31:
        if (isVoiceChatRoomSeiVersion(r3) == true) goto L33;
    L52:
        return null;
    L33:
        if (r9.getSubScene() != 0) goto L37;
        return new com.bytedance.android.live.liveinteract.feed.c0(r8, r11);
    L37:
        if (r9.getSubScene() != 5) goto L41;
        return new MultiLinkVoiceChatFeedView(r8, r3, r10, r11);
    L41:
        if (r9.getSubScene() != 9) goto L52;
        boolean r12 = !LinkFeedTypeConstant.Companion.isDouyinFullScreen(r11);
        IKtvService r2 = jc1.k.f(IKtvService.class);
        if (r2 == null) goto L52;
        if (r10 != 61) goto L51;
        if (vm2.c.k() == false) goto L51;
        return r2.getRealTimeChorusFeedView(r8, r11);
    L51:
        return r2.getKtvRoomFeedView(r8, r12, r11);
    L7:
        return new EmptyFeedView(r8);
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public com.bytedance.android.live.liveinteract.plantform.commonwindow.m getLayoutConfigBySei(JSONObject r9, boolean r10, Pair<Integer, Integer> r11, Pair<Integer, Integer> r12) {
        boolean r0 = ky.a.a;
        Intrinsics.checkNotNullParameter(r9, "appData");
        Intrinsics.checkNotNullParameter(r11, "adjustSize");
        Intrinsics.checkNotNullParameter(r12, "playerVideoSize");
        JSONObject r13 = JSONObjectProtectorUtils.getJSONObject(r9, "layout_info");     // Catch: JSONException -> L14
        LayoutConfigModel r4 = new LayoutConfigModel();     // Catch: JSONException -> L14
        r4.s(JSONObjectProtectorUtils.getInt(r13, "align_type"));     // Catch: JSONException -> L14
        r4.y(JSONObjectProtectorUtils.getInt(r13, "scale_mode"));     // Catch: JSONException -> L14
        JSONObject r5 = JSONObjectProtectorUtils.getJSONObject(r13, "ui_container_android");     // Catch: JSONException -> L14
        LayoutConfigModel.g r6 = new LayoutConfigModel.g();     // Catch: JSONException -> L14
        r6.i(JSONObjectProtectorUtils.getInt(r5, "top"));     // Catch: JSONException -> L14
        r6.g(JSONObjectProtectorUtils.getInt(r5, "left"));     // Catch: JSONException -> L14
        r6.h(JSONObjectProtectorUtils.getInt(r5, "right"));     // Catch: JSONException -> L14
        r6.f(JSONObjectProtectorUtils.getInt(r5, "bottom"));     // Catch: JSONException -> L14
        Unit r7 = Unit.INSTANCE;     // Catch: JSONException -> L14
        r4.E(r6);     // Catch: JSONException -> L14
        JSONObject r8 = JSONObjectProtectorUtils.getJSONObject(r13, "canvas");     // Catch: JSONException -> L14
        LayoutConfigModel.b r14 = new LayoutConfigModel.b();     // Catch: JSONException -> L14
        r14.g(JSONObjectProtectorUtils.getInt(r8, "w"));     // Catch: JSONException -> L14
        r14.f(JSONObjectProtectorUtils.getInt(r8, "h"));     // Catch: JSONException -> L14
        r14.e(JSONObjectProtectorUtils.getString(r8, "background_color"));     // Catch: JSONException -> L14
        r4.t(r14);     // Catch: JSONException -> L14
        JSONObject r15 = JSONObjectProtectorUtils.getJSONObject(r13, "content");     // Catch: JSONException -> L14
        LayoutConfigModel.d r16 = new LayoutConfigModel.d();     // Catch: JSONException -> L14
        r16.h(JSONObjectProtectorUtils.getDouble(r15, "x"));     // Catch: JSONException -> L14
        r16.i(JSONObjectProtectorUtils.getDouble(r15, "y"));     // Catch: JSONException -> L14
        r16.g(JSONObjectProtectorUtils.getInt(r15, "w"));     // Catch: JSONException -> L14
        r16.f(JSONObjectProtectorUtils.getInt(r15, "h"));     // Catch: JSONException -> L14
        r4.u(r16);     // Catch: JSONException -> L14
        if (r10 == true) goto L12;
        int r17 = (int) com.bytedance.android.live.core.utils.s1.G(StatusBarUtil.getStatusBarHeight(com.bytedance.android.live.core.utils.s1.getContext()));     // Catch: JSONException -> L14
        LayoutConfigModel.g r18 = r4.p();     // Catch: JSONException -> L14
        if (r18 == null) goto L8;
        int r19 = r18.e();     // Catch: JSONException -> L14
    L9:
        LayoutConfigModel.g r1 = r4.p();     // Catch: JSONException -> L14
        if (r1 == null) goto L12;
        r1.i(r19 + r17);     // Catch: JSONException -> L14
        goto L12
    L8:
        r19 = 0;
    L12:
        com.bytedance.android.live.liveinteract.plantform.commonwindow.m r20 = ah0.a.a(r4);     // Catch: JSONException -> L14
        r20.d = ky.a.a(r4, new Triple(r11.getFirst(), r11.getSecond(), "calculateLayoutConfig"), r12);     // Catch: JSONException -> L14
        boolean r110 = iy.b.a;     // Catch: JSONException -> L14
        iy.b.e("LinkMicDynamicCenterConfig", "getLayoutConfigBySei layoutConfig:" + r20);     // Catch: JSONException -> L14
        return r20;
    L14:
        e = move-exception;
        boolean r111 = iy.b.a;
        iy.b.c("LinkMicDynamicCenterConfig", "error message: " + e);
        return null;
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public List<zo2.a> getNitaInfosByScene(int r7, Set<String> r8, boolean r9, boolean r10) {
        SparseArray<List<zo2.a>> r0 = VerticalNitaInflate.a;
        ArrayList r1 = new ArrayList();
        if (r9 == true) goto L17;
        SparseArray<List<zo2.a>> r2 = VerticalNitaInflate.a;
        List<zo2.a> r3 = r2.get(r7);
        Collection r4 = r3;
        if (r3 != null) goto L16;
        ArrayList r5 = new ArrayList();
        r4 = r5;
        if (r8 == null) goto L16;
        r4 = r5;
        if (r8.size() == 0) goto L16;
        int r6 = com.bytedance.android.live.liveinteract.utils.t0.a;
        com.bytedance.android.live.liveinteract.utils.t0.a("VerticalNitaInflate", "[Nita] VerticalNitaInflate getInnerNitaList, uiLayout=" + r7 + ", linkerScene=" + r8 + ", isAudioLiveType=" + r10);
        if (r10 == false) goto L14;
        r5.add(new VerticalNitaInflate.a(VerticalNitaInflate.Tag.MultiLinkVoiceCommonWindowView, 2131566838));
        r5.add(new VerticalNitaInflate.a(VerticalNitaInflate.Tag.MultiLinkRadioWidgetView, ((IRadioService) jc1.k.f(IRadioService.class)).getRadioWidgetXmlRes()));
        r5.add(new VerticalNitaInflate.a(VerticalNitaInflate.Tag.MultiLinkVoiceGuestWidgetView, 2131567766));
        r5.add(new VerticalNitaInflate.a(VerticalNitaInflate.Tag.MultiLinkDynamicTeamFightView, 2131567146));
    L15:
        r2.put(r7, r5);
        r4 = r5;
        goto L16
    L14:
        r5.add(new VerticalNitaInflate.a(VerticalNitaInflate.Tag.MultiLinkVideoCommonWindowView, 2131566837));
        VerticalNitaInflate.Tag r11 = VerticalNitaInflate.Tag.MultiLinkVideoGuestWidgetViewV2;
        ((IInteractService) jc1.k.f(IInteractService.class)).getVideoTalkService().r();
        r5.add(new VerticalNitaInflate.a(r11, 2131567592));
    L16:
        r1 = new ArrayList(r4);
    L17:
        com.bytedance.android.live.liveinteract.pre.a.c.a.getClass();
        int r12 = 0;
        if (r1.size() == 0) goto L36;
        HashMap r13 = new HashMap();
        r13.put("cache_type", "create");
        if (r9 == false) goto L23;
        String r14 = "1";
    L24:
        r13.put("cache_scene", r14);
        if (r8 != null) goto L27;
    L29:
        String r15 = "";
    L30:
        r13.put("room_scene", r15);
        r13.put("room_uilayout", String.valueOf(r7));
        HashMap r16 = new HashMap();
        Iterator r17 = r1.iterator();
        int r18 = 0;
    L32:
        if (r17.hasNext() == false) goto L34;
        zo2.a r19 = (zo2.a) r17.next();
        r18 = r18 + r19.getCount();
        r16.put(r19.getTag(), String.valueOf(r19.getCount()));
        goto L32
    L34:
        r13.put("create_count", String.valueOf(r18));
        r13.put("create_detail", new JSONObject(r16).toString());
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_vertical_preinflate_count", r13, new Object[0]);
        goto L36
    L27:
        if (r8.size() <= 0) goto L29;
        r15 = (String) r8.toArray()[0];
        goto L30
    L23:
        r14 = "2";
    L36:
        if (r12 >= r1.size()) goto L38;
        int r20 = com.bytedance.android.live.liveinteract.utils.t0.a;
        com.bytedance.android.live.liveinteract.utils.t0.a("VerticalNitaInflate", "[Nita] getNitaInfosByScene tag=" + ((zo2.a) ListProtector.get(r1, r12)).getTag());
        r12 = r12 + 1;
        goto L36
    L38:
        return r1;
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public Pair<Integer, Integer> getSizeForXScreenAdjust(int r1, int r2, int r3, int r4) {
        return ug0.b.b(r1, r2, r3, r4);
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public void openVideoTalkRoomManageDialog(Context r8, ILinkPlayerInfoBridge r9, Boolean r10, DataCenter r11) {
        com.bytedance.android.live.liveinteract.videotalk.dialog.n r6 = new com.bytedance.android.live.liveinteract.videotalk.dialog.n(r8, r9, r10.booleanValue(), "", r11);
        Intrinsics.checkNotNullParameter("seat", "requestPage");
        r6.n = "seat";
        INVOKEVIRTUAL_com_bytedance_android_live_multilink_impl_InteractService_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(r6);
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public void switchScene(int r2, int r3, @Nullable String r4, @Nullable Integer r5) {
        if (com.bytedance.android.live.liveinteract.plantform.base.f.a() != null) goto L5;
    L9:
        rj0.k.m2.getClass();
        if (rj0.k.a.a() == null) goto L12;
        rj0.k.a.a().T1(r3, r5, r4);
        return;
    L12:
        rj0.l.n2.getClass();
        if (rj0.l.a.a() == null) goto L18;
        rj0.l.a.a().j1(r3, r5, r4, Boolean.FALSE);
        return;
    L18:
        return;
    L5:
        if (com.bytedance.android.live.liveinteract.plantform.base.f.a().Sd() == false) goto L9;
        if (r5 != null) goto L8;
        r5 = 0;
    L8:
        com.bytedance.android.live.liveinteract.plantform.base.f.a().ld(r2, r3, r5.intValue(), r4);
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public void tryOpenChooseGuestPanelWithUsage(Context r2, final String r3, final String r4, DataCenter r5) {
        int r0 = MultiLinkEnlargeSelectGuestDialog.F;
        je0.d.e(null).getRoomId();
        MultiLinkEnlargeSelectGuestDialog.b r1 = new e(r3, r4);
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r1, "selectedResultListener");
        MultiLinkEnlargeSelectGuestDialog r6 = new MultiLinkEnlargeSelectGuestDialog(r2);
        r6.B = r1;
        r6.E = r5;
        INVOKEVIRTUAL_com_bytedance_android_live_multilink_impl_InteractService_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(r6);
    }

    private static /* synthetic */ Unit lambda$switchSceneWithConfirmCheck$0(int r7, int r8, int r9, String r10, int r11) {
        com.bytedance.android.live.liveinteract.plantform.base.f.a().y6(false, r7, r8, r9, r10, r11);
        return null;
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public x00.b createVoiceLiveThemeDialog(Context r9, boolean r10, com.bytedance.android.live.room.g r11, int r12, @Nullable DataCenter r13) {
        return new VoiceLiveThemeManageDialog(r9, r10, null, r11, r12, r13);
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public pn0.f getLayoutConfigResult(com.bytedance.android.live.liveinteract.plantform.commonwindow.m r2, int r3, int r4, String r5, Pair r6) {
        ln0.a r0 = yg0.h.a;
        return yg0.h.a(r2, new Triple(Integer.valueOf(r3), Integer.valueOf(r4), r5), r6);
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public void handleLinkLynxPanelJsbChangeAction(String r17, String r18, JsonObject r19, ih0.h r20, @Nullable DataCenter r21) {
        if ("setting_panel_type".equals(r17) == false) goto L169;
        Lazy r1 = MultiLinkLynxSettingPanelActionHandler.a;
        Intrinsics.checkNotNullParameter(r17, "panelType");
        Intrinsics.checkNotNullParameter(r18, "callType");
        Intrinsics.checkNotNullParameter(r19, "extraData");
        Intrinsics.checkNotNullParameter(r20, "updateCallback");
        ALogger.i("LynxSettingPanelHandler", "handleSettingLynxPanelAction call panelType=" + r17 + " callType=" + r18 + " extraData=" + r19);
        switch(r18.hashCode()) {
            case -870575074: goto L83;
            case 1690336917: goto L40;
            case 1804231690: goto L13;
            case 2078836526: goto L8;
            default: goto L167;
        };
    L167:
        ALogger.e("LynxSettingPanelHandler", "settingPanelUpdateAction callType=" + r18 + " not found");
        r20.a(UpdateLinkmicStatusResultModel.Code.Failed, "settingPanel " + r18 + " not define", null);
        return;
    L8:
        if (r18.equals("get_client_settings") == false) goto L167;
        com.bytedance.android.live.liveinteract.plantform.base.g r0 = com.bytedance.android.live.liveinteract.plantform.base.f.a();
        if (r0 == null) goto L190;
        r0.mq(Observable.fromCallable(new com.bytedance.android.live.liveinteract.videotalk.utils.panel.o(r19)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.bytedance.android.live.liveinteract.videotalk.utils.panel.p(r20), new com.bytedance.android.live.liveinteract.videotalk.utils.panel.q(r20)));
        return;
    L190:
        return;
    L13:
        if (r18.equals("linkmic_setting_update") == false) goto L167;
        if (r19.has("setting_key_list") == true) goto L175;
        r20.a(UpdateLinkmicStatusResultModel.Code.Failed, "linkmic_setting_update setting_key_List not found", null);
        return;
    L175:
        Iterator r2 = r19.get("setting_key_list").getAsJsonArray().iterator();     // Catch: Exception -> L35
    L19:
        if (r2.hasNext() == false) goto L37;
        JsonObject r3 = GsonHelper.parser().parse(((JsonElement) r2.next()).getAsString()).getAsJsonObject();     // Catch: Exception -> L35
        if (r3 == null) goto L19;
        int r4 = r3.get("key").getAsInt();     // Catch: Exception -> L35
        int r5 = r3.get("value").getAsInt();     // Catch: Exception -> L35
        if (r5 == 0) goto L27;
        if (r5 == 1) goto L27;
        boolean r6 = false;
    L29:
        if (r4 != 62) goto L19;
        if (r6 == true) goto L19;
        if (r21 == null) goto L19;
        r21.put("data_video_talk_dot_with_number_show", "");     // Catch: Exception -> L35
    L27:
        r6 = true;
    L37:
        r20.a(UpdateLinkmicStatusResultModel.Code.Success, "", null);
        return;
    L35:
        e = move-exception;
        ALogger.e("LynxSettingPanelHandler", "handleSettingUpdate err=" + e.getMessage());
        goto L37
    L40:
        if (r18.equals("switch_layout") == false) goto L167;
        if (r19.has("to_scene") == true) goto L44;
    L81:
        ALogger.w("LynxSettingPanelHandler", "handleSettingLynxPanelAction fail switch_layout extra not ready");
        r20.a(UpdateLinkmicStatusResultModel.Code.Failed, "switch_layout to_scene or to_layout not found", null);
        return;
    L44:
        if (r19.has("to_ui_layout") == false) goto L81;
        if (r19.has("android_dynamic_seat") == false) goto L81;
        int r7 = r19.get("to_scene").getAsInt();     // Catch: Exception -> L79
        int r8 = r19.get("to_ui_layout").getAsInt();     // Catch: Exception -> L79
        JsonElement r11 = r19.get("source");     // Catch: Exception -> L79
        if (r11 == null) goto L51;
        String r12 = r11.getAsString();     // Catch: Exception -> L79
        if (r12 == null) goto L51;
    L52:
        JsonElement r14 = r19.get("reason");     // Catch: Exception -> L79
        if (r14 == null) goto L56;
        String r15 = r14.getAsString();     // Catch: Exception -> L79
        if (r15 == null) goto L56;
    L57:
        boolean r9 = r19.get("android_dynamic_seat").getAsBoolean();     // Catch: Exception -> L79
        ALogger.i("LynxSettingPanelHandler", "switchLayout currentUiLayout=" + je0.d.h() + " currentScene:" + je0.d.f() + " toUiLayout:" + r8 + " toScene:" + r7 + " isDynamicSeat:" + r9);     // Catch: Exception -> L79
        ((TalkRoomLogUtils) ((IInteractService) jc1.k.n(IInteractService.class)).getTalkRoomLogUtils()).getClass();     // Catch: Exception -> L79
        Intrinsics.checkNotNullParameter(r12, "source");     // Catch: Exception -> L79
        TalkRoomLogUtils.o1(r12);     // Catch: Exception -> L79
        if (com.bytedance.android.live.liveinteract.linkpanel.util.o.m() == false) goto L60;
        if (r21 == null) goto L73;
        r21.put("data_voice_chat_room_close_page", "interact_panel");     // Catch: Exception -> L79
    L73:
        if (((IInteractService) jc1.k.n(IInteractService.class)).getLinkPanelTransitService() == null) goto L77;
        int r10 = je0.d.f();     // Catch: Exception -> L79
        com.bytedance.android.live.liveinteract.plantform.base.g r13 = com.bytedance.android.live.liveinteract.plantform.base.f.a();     // Catch: Exception -> L79
        if (r13 == null) goto L77;
        r13.ld(r10, r7, r8, "");     // Catch: Exception -> L79
    L77:
        r20.a(UpdateLinkmicStatusResultModel.Code.Success, "", null);     // Catch: Exception -> L79
        return;
    L60:
        if (((com.bytedance.android.live.liveinteract.linkpanel.util.g) MultiLinkLynxSettingPanelActionHandler.a.getValue()).a() == false) goto L69;
        if (r9 == false) goto L65;
        rj0.k.m2.getClass();     // Catch: Exception -> L79
        rj0.k r16 = rj0.k.a.a();     // Catch: Exception -> L79
        if (r16 == null) goto L68;
        rj0.k.b.f(r16, r7, Integer.valueOf(r8), r15, r9);     // Catch: Exception -> L79
    L68:
        r20.a(UpdateLinkmicStatusResultModel.Code.Success, "", null);     // Catch: Exception -> L79
        return;
    L65:
        rj0.k.m2.getClass();     // Catch: Exception -> L79
        rj0.k r22 = rj0.k.a.a();     // Catch: Exception -> L79
        if (r22 == null) goto L68;
        r22.T1(r7, Integer.valueOf(r8), r15);     // Catch: Exception -> L79
        goto L68
    L69:
        com.bytedance.android.live.core.utils.f2.b(2131917584, 0);     // Catch: Exception -> L79
        return;
    L56:
        r15 = "";
    L51:
        r12 = "link_setting_panel";
    L79:
        e = move-exception;
        ALogger.w("LynxSettingPanelHandler", "handleSettingLynxPanelAction fail switch_layout " + e.getMessage());
        r20.a(UpdateLinkmicStatusResultModel.Code.Failed, " " + e.getMessage(), null);
        return;
    L83:
        if (r18.equals("setting_panel_click") == false) goto L167;
        JsonElement r23 = r19.get("action_type");
        if (r23 == null) goto L88;
        String r24 = r23.getAsString();
        if (r24 == null) goto L88;
    L89:
        JsonElement r25 = r19.get("data");
        if (r25 == null) goto L92;
        JsonObject r26 = r25.getAsJsonObject();
    L94:
        switch(r24.hashCode()) {
            case -1367989380: goto L163;
            case -1080915637: goto L159;
            case -832779009: goto L136;
            case -394649460: goto L116;
            case 111185: goto L111;
            case 3452698: goto L97;
            default: goto L166;
        };
    L166:
        ALogger.e("LynxSettingPanelHandler", "settingPanelUpdateAction action_type=" + r24 + " not found");
        r20.a(UpdateLinkmicStatusResultModel.Code.Failed, "setting_panel_click#action_type " + r18 + " not define", null);
        return;
    L97:
        if (r24.equals("push") == false) goto L166;
        if (r26 != null) goto L100;
        return;
    L100:
        if (r26.has("url") == true) goto L102;
        return;
    L102:
        if (r26.has("title") == false) goto L200;
        String r27 = r26.get("url").getAsString();     // Catch: Exception -> L108
        String r28 = r26.get("title").getAsString();     // Catch: Exception -> L108
        if (r21 == null) goto L106;
        r21.put("linkmic_panel_sub_panel_push", new Pair(r27, r28));     // Catch: Exception -> L108
    L106:
        r20.a(UpdateLinkmicStatusResultModel.Code.Success, "", null);     // Catch: Exception -> L108
        return;
    L108:
        e = move-exception;
        ALogger.w("LynxSettingPanelHandler", "handleSettingLynxPanelAction fail setting_panel_click#push " + e.getMessage());
        r20.a(UpdateLinkmicStatusResultModel.Code.Failed, "setting_panel_click#push " + e.getMessage(), null);
        return;
    L200:
        return;
    L111:
        if (r24.equals("pop") == false) goto L166;
        if (r21 == null) goto L114;
        r21.put("linkmic_panel_sub_panel_pop", Boolean.TRUE);
    L114:
        r20.a(UpdateLinkmicStatusResultModel.Code.Success, "", null);
        return;
    L116:
        if (r24.equals("close_link_and_pre_apply") == false) goto L166;
        IInteractService r29 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r29 == null) goto L120;
        rj0.d r30 = r29.getCommonService();
    L122:
        if ((r30 instanceof rj0.m) == false) goto L129;
        boolean r31 = ((rj0.m) r30).finishVideoTalk("pre_apply");
        if (r31 == false) goto L126;
        UpdateLinkmicStatusResultModel.Code r32 = UpdateLinkmicStatusResultModel.Code.Success;
    L127:
        r20.a(r32, "setting_panel_click#action_type " + r18 + " result=" + r31, null);
        return;
    L126:
        r32 = UpdateLinkmicStatusResultModel.Code.Failed;
        goto L127
    L129:
        if ((r30 instanceof qd0.a) == false) goto L204;
        boolean r33 = ((IInteractService) jc1.k.n(IInteractService.class)).finishAudioTalk("pre_apply");
        if (r33 == false) goto L133;
        UpdateLinkmicStatusResultModel.Code r34 = UpdateLinkmicStatusResultModel.Code.Success;
    L134:
        r20.a(r34, "setting_panel_click#action_type " + r18 + " result=" + r33, null);
        return;
    L133:
        r34 = UpdateLinkmicStatusResultModel.Code.Failed;
        goto L134
    L204:
        return;
    L120:
        r30 = null;
        goto L122
    L136:
        if (r24.equals("change_mic_lock_status") == false) goto L166;
        if (r26 != null) goto L139;
        return;
    L139:
        if (r26.has("position") == true) goto L141;
        return;
    L141:
        if (r26.has("action") == false) goto L208;
        int r35 = r26.get("position").getAsInt();     // Catch: Exception -> L156
        int r36 = r26.get("action").getAsInt();     // Catch: Exception -> L156
        if (r36 != 1) goto L145;
        gd0.m r37 = ((IInteractService) jc1.k.n(IInteractService.class)).getLinkPanelTransitService();     // Catch: Exception -> L156
        if (r37 == null) goto L154;
        ((LinkPanelTransitService) r37).h(r35, true);     // Catch: Exception -> L156
    L154:
        r20.a(UpdateLinkmicStatusResultModel.Code.Success, "", null);     // Catch: Exception -> L156
        return;
    L145:
        if (r36 == 2) goto L147;
        ALogger.w("LynxSettingPanelHandler", "handleSettingLynxPanelAction action fail setting_panel_click#change_mic_lock_status action=" + r36);     // Catch: Exception -> L156
        r20.a(UpdateLinkmicStatusResultModel.Code.Failed, r18 + ' ' + r24 + " not found", null);     // Catch: Exception -> L156
        return;
    L147:
        gd0.m r38 = ((IInteractService) jc1.k.n(IInteractService.class)).getLinkPanelTransitService();     // Catch: Exception -> L156
        if (r38 == null) goto L150;
        ((LinkPanelTransitService) r38).h(r35, false);     // Catch: Exception -> L156
    L150:
        r20.a(UpdateLinkmicStatusResultModel.Code.Success, "", null);     // Catch: Exception -> L156
        return;
    L156:
        e = move-exception;
        ALogger.w("LynxSettingPanelHandler", "handleSettingLynxPanelAction fail setting_panel_click#change_mic_lock_status " + e.getMessage());
        r20.a(UpdateLinkmicStatusResultModel.Code.Failed, "setting_panel_click#change_mic_lock_status " + e.getMessage(), null);
        return;
    L208:
        return;
    L159:
        if (r24.equals("close_linkmic_panel") == false) goto L166;
        if (r21 == null) goto L212;
        r21.put("linkmic_panel_dismiss", Boolean.TRUE);
        return;
    L212:
        return;
    L163:
        if (r24.equals("open_more_play_method_panel") == false) goto L166;
        if (r21 == null) goto L214;
        r21.put("linkmic_panel_open_play_mode_panel", Boolean.TRUE);
        return;
    L214:
        return;
    L92:
        r26 = null;
    L88:
        r24 = "";
        goto L89
    L169:
        if ("emoji_interact_panel_type".equals(r17) == false) goto L218;
        com.bytedance.android.live.liveinteract.videotalk.utils.panel.a.j.t(r17, r18, r19, r20, r21);
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public void handleServerPermissionErr(int r1, int r2, Throwable r3, Function0<Unit> r4, Function0<Unit> r5) {
        new qh0.h(r2, r4, r5).c(r3);
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public void initAndTurnOnVideoLinkmicRoom(Runnable r8, Runnable r9, int r10, int r11, String r12) {
        if (com.bytedance.android.live.liveinteract.plantform.base.f.a() == null) goto L6;
        com.bytedance.android.live.liveinteract.plantform.base.f.a().initAndTurnOnVideoLinkmicRoom(r8, r9, r10, r11, r12);
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public void showLinkDistributeSetting(Context r8, int r9, String r10, Boolean r11, ILinkDistributionSettingCallback r12) {
        if (r8 != null) goto L4;
        return;
    L4:
        LinkDistributeSettingDialog r6 = new LinkDistributeSettingDialog(r8, r9, r10, r11.booleanValue(), r12);
        r6.M0();
        INVOKEVIRTUAL_com_bytedance_android_live_multilink_impl_InteractService_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(r6);
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public void showLynxGuestContributionRankList(Context r8, @Nullable DataCenter r9, IBaseUser r10, IRoom r11, Map<String, String> r12) {
        hi0.a r0 = hi0.a.a;
        hi0.a.a(r8, r9, r10, r11, false, r12);
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public void openLiveTalkRoomDialog(Context r11, String r12, boolean r13, int r14, int r15, qd0.g r16) {
        if (((rj1) bc0.a.getValue()).a() == false) goto L5;
        int r0 = OpenLiveVideoTalkFragmentNew.w;
        Intrinsics.checkNotNullParameter(r11, "activity");
        Intrinsics.checkNotNullParameter(r12, "source");
        Intrinsics.checkNotNullParameter(r16, "callback");
        OpenLiveVideoTalkFragmentNew r3 = new OpenLiveVideoTalkFragmentNew();
        Bundle r4 = new Bundle();
        r4.putString("source", r12);
        r4.putBoolean("autoOpen", r13);
        r4.putInt("scene", r14);
        r4.putInt("uiLayout", r15);
        r3.setArguments(r4);
        r3.d = r11;
        r3.i = r16;
        r3.show();
        return;
    L5:
        new OpenLiveVideoTalkFragment(r11, r12, r13, r14, r15, r16).show();
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public x00.b openVoiceLiveThemeDialog(Context r9, boolean r10, String r11, com.bytedance.android.live.room.g r12, int r13, @Nullable DataCenter r14) {
        return new VoiceLiveThemeManageDialog(r9, r10, r11, r12, r13, r14);
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public void switchSceneWithConfirmCheck(Context r14, final int r15, final int r16, @Nullable String r17, @Nullable Integer r18, final int r19) {
        String r0 = r17;
        if (com.bytedance.android.live.liveinteract.plantform.base.f.a() == null) goto L32;
        boolean r2 = false;
        if (r18 != null) goto L7;
        int r7 = 0;
    L8:
        Integer r3 = je0.d.h();
        if (r3 != null) goto L11;
        int r8 = 0;
    L12:
        if (r0 != null) goto L14;
        r0 = "";
    L14:
        final String r9 = r0;
        IRoom r1 = je0.d.e(null);
        List r4 = (List) tb0.a.getValue();
        if (r15 != 0) goto L20;
        if (r16 != 5) goto L20;
        com.bytedance.android.live.liveinteract.plantform.base.f.a().y6(true, r15, r16, r7, r9, r19);
        return;
    L20:
        if (com.bytedance.android.live.liveinteract.plantform.base.f.a().Sd() == false) goto L22;
        int r5 = com.bytedance.android.live.liveinteract.voicechat.util.y.a;
        final int r6 = r7;
        com.bytedance.android.live.liveinteract.voicechat.util.y.a(r14, new c(r15, r16, r6, r9, r19), new com.bytedance.android.live.liveinteract.voicechat.util.v(r15, r16, r8, r7, r9), null);
        return;
    L22:
        if (r4 != null) goto L24;
        return;
    L24:
        if (r4.contains(r18) == false) goto L42;
        if (r1 != null) goto L27;
        return;
    L27:
        if (r1.isLiveTypeAudio() == true) goto L44;
        com.bytedance.android.live.liveinteract.plantform.base.g r10 = com.bytedance.android.live.liveinteract.plantform.base.f.a();
        if (r8 != 0) goto L31;
        r2 = true;
    L31:
        r10.v7(r2, r16, r7, r9);
        return;
    L44:
        return;
    L42:
        return;
    L11:
        r8 = r3.intValue();
        goto L12
    L7:
        r7 = r18.intValue();
        goto L8
    L32:
        rj0.k.m2.getClass();
        if (rj0.k.a.a() == null) goto L35;
        rj0.k.a.a().T1(r16, r18, r0);
        return;
    L35:
        rj0.l.n2.getClass();
        if (rj0.l.a.a() == null) goto L47;
        rj0.l.a.a().j1(r16, r18, r0, Boolean.FALSE);
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public Observable<Response<com.bytedance.android.livesdk.rank.model.c>> syncLinkerRankList(long r11, String r13, String r14, String r15, String r16, long r17) {
        return ((LinkApi) com.bytedance.android.live.network.c.b().e(LinkApi.class)).getLinkerRankList(r11, r13, r14, r15, r16, r17);
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public Widget createLiveThemeBgUIWidget(boolean r9, String r10, IRoom r11, LiveMode r12, Integer r13, Integer r14, IMultiScenePreviewStatistics r15) {
        ALogger.e("MultiLinkThemeBgUIWidget", "createLiveThemeBgUIWidget, trace=" + Log.getStackTraceString(new Throwable()));
        return new MultiLinkThemeBgUIWidget(r9, r10, r11, r13, r14, r15);
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public void startLinkCast(LinkScreenCastType r10, String r11, int r12, int r13, Bitmap r14, String r15, boolean r16) {
        rj0.k.m2.getClass();
        if (rj0.k.a.a() == null) goto L6;
        rj0.k.a.a().ll(r10, r11, r12, r13, r14, r15, getOpenSource(r16));
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public void start3DAnim(com.bytedance.android.live.liveinteract.videotalk.emoji.model.g r10, com.bytedance.android.live.liveinteract.videotalk.emoji.model.c r11, com.bytedance.android.live.liveinteract.videotalk.emoji.model.n r12, com.bytedance.android.live.liveinteract.videotalk.emoji.model.m r13, String r14, com.bytedance.android.live.liveinteract.videotalk.emoji.model.o r15, MultiLinkScriptInfo r16, com.bytedance.android.live.liveinteract.animation.e r17) {
        com.bytedance.android.live.liveinteract.animation.universalwidget.a.f0.getClass();
        com.bytedance.android.live.liveinteract.animation.universalwidget.a r0 = com.bytedance.android.live.liveinteract.animation.universalwidget.a.C0014a.a();
        if (r0 == null) goto L5;
        r0.start3DAnim(r10, r11, r12, r13, r14, r15, r16, r17);
        return;
    L5:
        if (r10 == null) goto L9;
        r10.c(r11, TaskState.COMPLETE);
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public void handleLinkLynxPanelMuteAction(int r20, boolean r21, boolean r22, boolean r23, boolean r24, String r25, String r26, int r27, @Nullable Boolean r28) {
        com.bytedance.android.live.liveinteract.videotalk.utils.panel.a r5 = com.bytedance.android.live.liveinteract.videotalk.utils.panel.a.j;
        Integer r6 = Integer.valueOf(r27);
        ALogger.d("LynxEmojiPanelHandler", "handleLinkLynxPanelMuteAction muteType=" + r20 + " muteEnable=" + r21 + " isMuteSelf=" + r22 + " isMuteOtherRoom=" + r23 + " targetUserId=" + r25 + " targetRoomId=" + r26);
        boolean r7 = false;
        String r9 = "";
        Long r10 = null;
        com.bytedance.android.live.liveinteract.voicechat.b r11 = null;
        com.bytedance.android.live.liveinteract.voicechat.b r12 = null;
        r10 = null;
        if (r22 == false) goto L74;
        long r1 = 0;
        if (r21 == false) goto L51;
        if (r6 == null) goto L8;
        int r17 = r6.intValue();
    L9:
        if (r28 == null) goto L11;
        boolean r18 = r28.booleanValue();
    L12:
        com.bytedance.android.live.liveinteract.plantform.base.g r0 = com.bytedance.android.live.liveinteract.plantform.base.f.a();
        if (r0 != null) goto L15;
    L24:
        r7 = true;
    L25:
        if (r7 == true) goto L27;
        return;
    L27:
        if (com.bytedance.android.live.liveinteract.videotalk.utils.panel.a.h == true) goto L197;
        com.bytedance.android.live.liveinteract.videotalk.utils.panel.a.h = true;
        com.bytedance.android.live.liveinteract.voicechat.b r2 = com.bytedance.android.live.liveinteract.videotalk.utils.panel.a.o();
        if ((r2 instanceof VoiceChatMuteManager) == false) goto L33;
        r11 = r2;
    L33:
        VoiceChatMuteManager r13 = (VoiceChatMuteManager) r11;
        if (r13 == null) goto L36;
        r13.h = System.currentTimeMillis();
    L36:
        long r4 = System.currentTimeMillis();
        if (r25 != null) goto L39;
        String r3 = "";
    L40:
        InteractLinkFullLinkMonitor.V(r3);
        com.bytedance.android.live.liveinteract.plantform.base.g r8 = com.bytedance.android.live.liveinteract.plantform.base.f.a();
        if (r8 == null) goto L171;
        LinkApi r14 = (LinkApi) com.bytedance.android.live.network.c.b().e(LinkApi.class);
        Room r15 = com.bytedance.android.live.liveinteract.api.utils.m.i().getCurrentRoom();
        if (r15 == null) goto L45;
        r1 = r15.getRoomId();
    L45:
        long r16 = r1;
        long r19 = d5.c(r25);
        if (r25 != null) goto L48;
        String r110 = "";
    L49:
        r8.mq(r14.silence(r16, r19, r110, r17, r18).subscribeOn(Schedulers.io()).flatMap(com.bytedance.android.live.liveinteract.videotalk.utils.panel.g.a).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.bytedance.android.live.liveinteract.videotalk.utils.panel.h(r25, r4), new com.bytedance.android.live.liveinteract.videotalk.utils.panel.i(r25, r4)));
        return;
    L48:
        r110 = r25;
        goto L49
    L171:
        return;
    L39:
        r3 = r25;
        goto L40
    L197:
        return;
    L15:
        if (r0.s8() != true) goto L24;
        if (je0.d.y() == false) goto L21;
        IKtvService r29 = jc1.k.f(IKtvService.class);
        if (r29 == null) goto L25;
        r7 = r29.canSilenceSelf();
        goto L25
    L21:
        IVoiceChatAdminService.Companion.getClass();
        IVoiceChatAdminService r30 = IVoiceChatAdminService.a.a();
        if (r30 == null) goto L25;
        r7 = r30.canSilenceSelf();
        goto L25
    L11:
        r18 = false;
        goto L12
    L8:
        r17 = 0;
        goto L9
    L51:
        if (com.bytedance.android.live.liveinteract.videotalk.utils.panel.a.i == true) goto L198;
        com.bytedance.android.live.liveinteract.videotalk.utils.panel.a.i = true;
        com.bytedance.android.live.liveinteract.voicechat.b r31 = com.bytedance.android.live.liveinteract.videotalk.utils.panel.a.o();
        if ((r31 instanceof VoiceChatMuteManager) == false) goto L57;
        r12 = r31;
    L57:
        VoiceChatMuteManager r111 = (VoiceChatMuteManager) r12;
        if (r111 == null) goto L60;
        r111.h = System.currentTimeMillis();
    L60:
        long r32 = System.currentTimeMillis();
        if (r25 != null) goto L63;
        String r33 = "";
    L64:
        InteractLinkFullLinkMonitor.n0(r33);
        com.bytedance.android.live.liveinteract.plantform.base.g r34 = com.bytedance.android.live.liveinteract.plantform.base.f.a();
        if (r34 == null) goto L173;
        LinkApi r112 = (LinkApi) com.bytedance.android.live.network.c.b().e(LinkApi.class);
        Room r35 = com.bytedance.android.live.liveinteract.api.utils.m.i().getCurrentRoom();
        if (r35 == null) goto L69;
        r1 = r35.getRoomId();
    L69:
        long r113 = r1;
        long r114 = d5.c(r25);
        if (r25 != null) goto L72;
        String r115 = "";
    L73:
        r34.mq(r112.unSilence(r113, r114, r115, r24).subscribeOn(Schedulers.io()).flatMap(com.bytedance.android.live.liveinteract.videotalk.utils.panel.l.a).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.bytedance.android.live.liveinteract.videotalk.utils.panel.m(r25, r32), new com.bytedance.android.live.liveinteract.videotalk.utils.panel.n(r25, r32)));
        return;
    L72:
        r115 = r25;
        goto L73
    L173:
        return;
    L63:
        r33 = r25;
        goto L64
    L198:
        return;
    L74:
        if (r23 == false) goto L92;
        com.bytedance.live.datacontext.m r36 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r36 == null) goto L80;
        IRoom r37 = (IRoom) r36.getValue();
        if (r37 == null) goto L80;
        r10 = Long.valueOf(r37.getRoomId());
    L80:
        if (r26 != null) goto L82;
        String r38 = "0";
    L83:
        long r39 = d5.c(r38);
        if (r10 == null) goto L175;
        long r40 = r10.longValue();
        if (r21 == false) goto L88;
        Single<com.bytedance.android.live.network.response.e<com.bytedance.android.livesdk.chatroom.model.interact.r1>> r41 = ((LinkApi) com.bytedance.android.live.network.c.b().e(LinkApi.class)).silenceLinkRoom(r40, r39, 2);
    L89:
        com.bytedance.android.live.liveinteract.plantform.base.g r42 = com.bytedance.android.live.liveinteract.plantform.base.f.a();
        if (r42 == null) goto L176;
        r42.mq(r41.compose(RxUtil.rxSchedulerHelper()).subscribe(com.bytedance.android.live.liveinteract.videotalk.utils.panel.f.a, new com.bytedance.android.live.liveinteract.videotalk.utils.panel.e(r21)));
        return;
    L176:
        return;
    L88:
        r41 = ((LinkApi) com.bytedance.android.live.network.c.b().e(LinkApi.class)).unSilenceLinkRoom(r40, r39, 1);
        goto L89
    L175:
        return;
    L82:
        r38 = r26;
        goto L83
    L92:
        if (r21 == false) goto L132;
        if (je0.d.r() == false) goto L96;
    L98:
        com.bytedance.android.live.liveinteract.plantform.base.g r43 = com.bytedance.android.live.liveinteract.plantform.base.f.a();
        if (r43 != null) goto L101;
    L118:
        com.bytedance.android.live.liveinteract.plantform.base.g r44 = com.bytedance.android.live.liveinteract.plantform.base.f.a();
        if (r44 != null) goto L121;
        return;
    L121:
        if (r44.s8() != true) goto L185;
        com.bytedance.android.live.liveinteract.voicechat.b r45 = com.bytedance.android.live.liveinteract.videotalk.utils.panel.a.o();
        if (r45 == null) goto L125;
        r45.a(r5);
    L125:
        com.bytedance.android.live.liveinteract.voicechat.b r46 = com.bytedance.android.live.liveinteract.videotalk.utils.panel.a.o();
        if (r46 == null) goto L186;
        if (r25 == null) goto L130;
        r9 = r25;
    L130:
        r46.h(r9);
        return;
    L186:
        return;
    L185:
        return;
    L101:
        if (r43.nd() != true) goto L118;
        if (je0.d.r() == false) goto L111;
        rj0.k.m2.getClass();
        rj0.k r47 = rj0.k.a.a();
        if (r47 == null) goto L179;
        if (r25 == null) goto L109;
        r9 = r25;
    L109:
        rj0.k.b.d(r47, r9);
        return;
    L179:
        return;
    L111:
        if (je0.d.Y() == false) goto L181;
        com.bytedance.android.live.liveinteract.plantform.base.k.n0.getClass();
        com.bytedance.android.live.liveinteract.plantform.base.k r48 = com.bytedance.android.live.liveinteract.plantform.base.k.a.a();
        if (r48 == null) goto L182;
        if (r25 == null) goto L117;
        r9 = r25;
    L117:
        r48.li(r9, null);
        return;
    L182:
        return;
    L181:
        return;
    L96:
        if (je0.d.Y() == true) goto L98;
        int r49 = InteractEmojiPanel.E;
        InteractEmojiPanel.a.a(TalkRoomOperate.SILENCE);
        return;
    L132:
        if (je0.d.r() == false) goto L134;
    L136:
        com.bytedance.android.live.liveinteract.plantform.base.g r50 = com.bytedance.android.live.liveinteract.plantform.base.f.a();
        if (r50 != null) goto L139;
    L156:
        com.bytedance.android.live.liveinteract.plantform.base.g r51 = com.bytedance.android.live.liveinteract.plantform.base.f.a();
        if (r51 != null) goto L159;
        return;
    L159:
        if (r51.s8() != true) goto L195;
        com.bytedance.android.live.liveinteract.voicechat.b r52 = com.bytedance.android.live.liveinteract.videotalk.utils.panel.a.o();
        if (r52 == null) goto L163;
        r52.a(r5);
    L163:
        com.bytedance.android.live.liveinteract.voicechat.b r53 = com.bytedance.android.live.liveinteract.videotalk.utils.panel.a.o();
        if (r53 == null) goto L196;
        if (r25 == null) goto L168;
        r9 = r25;
    L168:
        r53.f(r9, new com.bytedance.android.live.liveinteract.videotalk.utils.panel.k());
        return;
    L196:
        return;
    L195:
        return;
    L139:
        if (r50.nd() != true) goto L156;
        if (je0.d.r() == false) goto L149;
        rj0.k.m2.getClass();
        rj0.k r54 = rj0.k.a.a();
        if (r54 == null) goto L189;
        if (r25 == null) goto L147;
        r9 = r25;
    L147:
        r54.Q5(r9, false, null);
        return;
    L189:
        return;
    L149:
        if (je0.d.Y() == false) goto L191;
        com.bytedance.android.live.liveinteract.plantform.base.k.n0.getClass();
        com.bytedance.android.live.liveinteract.plantform.base.k r55 = com.bytedance.android.live.liveinteract.plantform.base.k.a.a();
        if (r55 == null) goto L192;
        if (r25 == null) goto L155;
        r9 = r25;
    L155:
        r55.Td(r9, null);
        return;
    L192:
        return;
    L191:
        return;
    L134:
        if (je0.d.Y() == true) goto L136;
        int r56 = InteractEmojiPanel.E;
        InteractEmojiPanel.a.a(TalkRoomOperate.UNSILENCE);
    }

    @Override // com.bytedance.android.live.liveinteract.api.IInteractService
    public void getLayoutConfigFromGecko(int r15, int r16, boolean r17, boolean r18, int r19, pn0.i r20, boolean r21, Triple<Integer, Integer, String> r22, ClientUIInfo r23, DataCenter r24, com.bytedance.android.live.liveinteract.plantform.commonwindow.g r25, long r26) {
        if (r16 <= 0) goto L5;
        int r1 = r16;
    L6:
        ln0.a r2 = yg0.h.a;
        int r3 = yg0.h.h(r17, r15, r16);
        if (r23 == null) goto L9;
        List r0 = r23.getUiFeatureList();
    L11:
        if (MultiLinkLoadWidgetUtils.g() == false) goto L18;
        long r4 = 0L;
        if (r24 != null) goto L15;
    L17:
        com.bytedance.android.livesdk.chatroom.u r5 = com.bytedance.android.live.liveinteract.api.utils.m.f(r24, r4);
    L20:
        if (r5.s() == null) goto L29;
        if (r5.s().getValue() == null) goto L29;
        if (((com.bytedance.android.livesdk.chatroom.viewmodel.f) r5.s().getValue()).t() == null) goto L29;
        if (((com.bytedance.android.livesdk.chatroom.viewmodel.f) r5.s().getValue()).t().a() == null) goto L29;
        r0 = ((com.bytedance.android.livesdk.chatroom.viewmodel.f) r5.s().getValue()).t().a().getUiFeatureList();
    L29:
        if (r5.getVideoTalkRoomSubScene() != null) goto L31;
    L37:
        yg0.h.k(new com.bytedance.android.live.liveinteract.plantform.commonwindow.h(r1, r3, new com.bytedance.android.live.liveinteract.plantform.commonwindow.j(new StringBuilder()), r18, r19, r21, r20, r22, r0, Long.valueOf(r26), r24), r25, null);
        return;
    L31:
        if (r5.getVideoTalkRoomSubScene().getValue() == null) goto L37;
        if (((com.bytedance.android.livesdk.chatroom.viewmodel.e) r5.getVideoTalkRoomSubScene().getValue()).t() == null) goto L37;
        if (((com.bytedance.android.livesdk.chatroom.viewmodel.e) r5.getVideoTalkRoomSubScene().getValue()).t().e == null) goto L37;
        r0 = ((com.bytedance.android.livesdk.chatroom.viewmodel.e) r5.getVideoTalkRoomSubScene().getValue()).t().e.getUiFeatureList();
        goto L37
    L15:
        if (r24.get("data_room") == null) goto L17;
        r4 = Long.valueOf(((IRoom) r24.get("data_room")).getId());
        goto L17
    L18:
        r5 = com.bytedance.android.live.liveinteract.api.utils.m.d();
        goto L20
    L9:
        r0 = null;
        goto L11
    L5:
        ln0.a r6 = yg0.h.a;
        r1 = yg0.h.e(r15);
        goto L6
    }
}
