package com.bytedance.android.live.liveinteract.api;

import ai0.e;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.SurfaceView;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.anchormodelink.BaseAnchorModeDynamicWidget;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.cloudgrouplive.widget.BaseCloudGroupLiveWidget;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.fifa.core.IChannelLinkService;
import com.bytedance.android.live.liveinteract.linkbase.api.MediaOperation;
import com.bytedance.android.live.liveinteract.model.LinkScreenCastType;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.m;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.plantform.model.UserType;
import com.bytedance.android.live.liveinteract.revenue.battle.b0;
import com.bytedance.android.live.liveinteract.utils.k;
import com.bytedance.android.live.liveinteract.utils.l;
import com.bytedance.android.live.liveinteract.utils.o;
import com.bytedance.android.live.liveinteract.utils.p;
import com.bytedance.android.live.liveinteract.utils.q;
import com.bytedance.android.live.liveinteract.videotalk.emoji.model.MultiLinkScriptInfo;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.live.pushstream.d;
import com.bytedance.android.live.room.g;
import com.bytedance.android.live.utility.ServiceLookup;
import com.bytedance.android.live.virtuallive.BaseVirtualLiveControlWidget;
import com.bytedance.android.livesdk.a;
import com.bytedance.android.livesdk.chatroom.interact.model.y;
import com.bytedance.android.livesdk.chatroom.model.interact.IAudioSubtitleContent;
import com.bytedance.android.livesdk.chatroom.model.interact.x;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0;
import com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget;
import com.bytedance.android.livesdk.log.filter.v;
import com.bytedance.android.livesdkapi.depend.message.ClientUIInfo;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
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
import com.bytedance.android.livesdkapi.model.LinkPreviewMonitorData;
import com.bytedance.android.livesdkapi.model.ParseSeiData;
import com.bytedance.android.livesdkapi.model.SeiAppData;
import com.bytedance.android.livesdkapi.multilink.IMultiLinkWRDSPreloadService;
import com.bytedance.android.livesdkapi.service.ILinkDistributionSettingCallback;
import com.bytedance.android.livesdkapi.util.IMultiScenePreviewStatistics;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.ies.sdk.widgets.WidgetManager;
import com.bytedance.ies.web.jsbridge2.f;
import com.bytedance.live.livelink.kmp.api.core.mixer.MixStreamType;
import com.google.gson.JsonObject;
import gd0.h;
import gd0.i;
import gd0.n;
import ih0.b;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.disposables.Disposable;
import iy.j;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;
import kotlin.Deprecated;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import nj0.c;
import org.json.JSONObject;
import uf2.d0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@ServiceLookup("com.bytedance.android.live.liveinteract.InteractService")
public interface IInteractService extends n {
    public static final String CMD_DRAW_GUESS = "cmd_draw_guess";
    public static final String CMD_KTV = "cmd_ktv";
    public static final String CMD_SMALL_GAME = "small_game";
    public static final int INTERACT_ING = 2;
    public static final int PK_ING = 1;
    public static final NextLiveData<List<? extends y>> linkMicSettings = null;
    public static final HashMap<String, Integer> micRoomHostStateMap = null;
    public static final NextLiveData<Map<String, Object>> playModeParams = null;

    Integer adapterPlayerAlignModeIfNeed(int r1, int r2);

    void addBusinessDegradeStrategy(a r1);

    void anchorAudioSubtitleSwitchSetting(boolean r1, String r2, c r3);

    void apply(int r1, String r2, int r3);

    boolean audioSubtitleOpen();

    void broadcastGameStartError();

    boolean canShowCommentShareVideoButton();

    boolean canShowCommentShareVideoOpenCloseToast();

    void changeExitCleanScreenStyle(@Nullable ImageView r1, @Nullable TextView r2);

    String changeMode2String(int r1);

    boolean chatRoomIsOpen();

    void clickLinkRoomFightIcon(Map<String, String> r1);

    void commonWMUpdateLiveCoreAndRtcInfo(String r1);

    void composeMultiLinkDisposableCall(Disposable r1);

    MiddlewareRoomWidget createAIMVWidget();

    BaseAnchorModeDynamicWidget createAnchorModeDynamicWidget(ViewGroup r1, j r2);

    com.bytedance.android.live.liveinteract.c createAudioSceneBasicWidget();

    @Nullable
    c0.b createBehavior(Object r1, Context r2);

    IChannelLinkService createChannelLinkService();

    BaseCloudGroupLiveWidget createCloudGroupLiveWidget(ViewGroup r1, com.bytedance.android.livesdk.chatroom.ui.framework.a r2);

    b createDynamicWidget(ViewGroup r1);

    c0.b createInteractActingBehavior(Context r1);

    c0.b createInteractiveSongBehavior(Context r1);

    c0.b createInteractiveToolsBehavior(Context r1);

    BaseLinkMultiControlWidget createLinkMultiControlWidget(BaseLinkMultiControlWidget.a r1, ViewGroup r2, Boolean r3);

    xi0.b createLinkRoomRtcManager(IRoomBase r1, Object r2, tc0.b r3);

    Widget createLiveAwemePlayControlWidghet(FragmentManager r1, d r2);

    md0.a createLiveSeiHelper(md0.a.InterfaceC0236a r1, md0.a.b r2, md0.a.c r3);

    Widget createLiveThemeBgUIWidget(boolean r1, String r2, IRoom r3, LiveMode r4, Integer r5, Integer r6, IMultiScenePreviewStatistics r7);

    MiddlewareRoomWidget createMultiLinkBgManager();

    Widget createMultiLinkDataCenterWidget();

    Widget createMultiLinkUIWidget();

    BaseVirtualLiveControlWidget createVirtualLiveControlWidget(ViewGroup r1, com.bytedance.android.livesdk.chatroom.ui.framework.a r2);

    x00.b createVoiceLiveThemeDialog(Context r1, boolean r2, g r3, int r4, @Nullable DataCenter r5);

    boolean currentIsCPositionUser();

    boolean currentUILayoutNeedAdjustCommentHeight(DataCenter r1);

    boolean dynamicFromAudience();

    boolean dynamicFromAudienceGuestCache();

    @Nullable
    b dynamicService(@Nullable DataCenter r1);

    @Nullable
    b dynamicService(@Nullable DataCenter r1, long r2);

    boolean enableCaptureAudioOnBackground(boolean r1);

    boolean enableMultiEnlarge(String r1);

    boolean enableMultiLinkInnerPreload();

    boolean enableVideoChorus(Boolean r1, Integer r2, String r3, h80.a<Boolean> r4);

    void exitRoom();

    void fastMatchJump(long r1, String r3, String r4);

    boolean finishAudioTalk(String r1);

    void finishVideoTalk(String r1);

    void forceReverseCamera();

    @Nullable
    e getAdventureService();

    List<zo2.a> getAllNitaInfos(boolean r1);

    SurfaceView getAnchorLinkmicSurfaceView();

    int getAnchorManualUiLayout();

    gd0.e getAnchorModeOutService();

    h getAnimationController();

    int getAudioTalkRadioBottomOffset(IRoom r1);

    int getAudioTalkRadioPublicScreenTopMargin();

    int getAudioTalkSeatBottomPos(IRoom r1);

    qd0.a getAudioTalkService();

    gd0.g getAvatarService();

    Map<String, Class> getChannelWRDSDataMap();

    z30.b getCloudGroupLiveService();

    rj0.d getCommonService();

    @Nullable
    List<ILinkPlayerInfoBridge> getCrossRoomFightLinkUserInfoList();

    int getCurUILayout();

    @Nullable
    ILinkPlayerInfoBridge getCurrentCPostion();

    String getCurrentFunctionType();

    @Nullable
    List<Integer> getCurrentPlayModes();

    int getCurrentScene();

    String getCurrentSwitchSceneSource();

    int getCurrentUiLayout();

    c0.b getDigitAvatarBehavior();

    String getDisplayTicketStr(long r1, List<Long> r3, String r4, String r5);

    @Nullable
    iy.g getDynamicCenterService(DataCenter r1);

    ih0.d getDynamicEmojiDialog(Context r1, DataCenter r2, String r3, boolean r4);

    int getEnlargeGuestType();

    f.b getFeedMultiLinkDynamicJsbMethodProvider(String r1, DataCenter r2);

    /* synthetic */ FeedViewRoomInfoStore getFeedViewRoomInfoStore();

    String getFunctionType2();

    String getFunctionType2BeforeReset();

    String getFunctionTypeForLog();

    long getGuestApplyPaidAmount();

    @Nullable
    ILinkPlayerInfoBridge getGuestInfo(String r1, String r2);

    @Nullable
    ei6.a getGuestRtcClient();

    d getGuestRtcLiveStream();

    @Nullable
    tf0.h getInteractAnimationService();

    tf0.h getInteractAnimationService(DataCenter r1);

    qd0.b getInteractAudienceService();

    IInteractFeedView getInteractFeedView(Context r1, SeiAppData r2, int r3, int r4);

    i getInteractFloatWindowService();

    k getInteractLogUtils();

    wi0.a getInteractiveSongService();

    IKtvComponentFeedViewManager getKtvComponentFeedViewManage();

    m getLayoutConfigBySei(JSONObject r1, boolean r2, Pair<Integer, Integer> r3, Pair<Integer, Integer> r4);

    void getLayoutConfigFromGecko(int r1, int r2, boolean r3, boolean r4, int r5, pn0.i r6, boolean r7, Triple<Integer, Integer, String> r8, ClientUIInfo r9, DataCenter r10, com.bytedance.android.live.liveinteract.plantform.commonwindow.g r11, long r12);

    pn0.f getLayoutConfigResult(m r1, int r2, int r3, String r4, Pair<Integer, Integer> r5);

    @Override // gd0.n
    String getLinkConnectionType();

    l getLinkMicGameFullLinkMonitor();

    com.bytedance.android.live.liveinteract.utils.m getLinkMicGameLogUtils();

    com.bytedance.android.live.liveinteract.utils.n getLinkMicGameTraceUtils();

    o getLinkMicXplayBasicFullLinkMonitor();

    p getLinkMicXplayBasicTraceUtils();

    int getLinkMode();

    gd0.l getLinkMultiOutService();

    gd0.m getLinkPanelTransitService();

    @Override // gd0.n
    com.bytedance.android.live.liveinteract.plantform.base.i<ILinkPlayerInfoBridge> getLinkUserInfoCenter();

    Class<? extends Widget> getLinkmicSubtitleUIWidget();

    @Nullable
    d0 getLiveCore(boolean r1);

    Class<? extends LiveRecyclableWidget> getLiveMatrixEntranceWidget();

    ILivePreviewAnchorModeLinkCommonWidget getLivePreviewAnchorModeDynamicWidget(Object r1);

    @Nullable
    ILivePreviewKtvComponentWidget getLivePreviewKtvComponentWidget(ViewGroup r1, @Nullable ISingleBroadcastPreviewKtvComponent r2);

    ILivePreviewMultiLinkCommonWidget getLivePreviewMultiLinkCommonWidget();

    String getLiveTypeForLog();

    RecyclerView getMicSeatRecyclerView();

    @Nullable
    MixStreamType getMixStreamType();

    int getMultiInteractMode();

    gd0.o getMultiLinkBridgeService();

    qj0.a getMultiLinkLayoutService();

    com.bytedance.android.live.liveinteract.plantform.performance.a getMultiLinkPerfAbilityManager(boolean r1);

    int getMultiLinkScene();

    qd0.c getMultiLinkToolbarService();

    IMultiLinkWRDSPreloadService getMultiLinkWRDSPreloadService();

    Pair<Integer, Integer> getNewLinkSizeForXScreenAdjust(int r1, int r2, int r3);

    List<zo2.a> getNitaInfosByScene(int r1, Set<String> r2, boolean r3, boolean r4);

    int getOnLineCountFromPk();

    ArrayList<ILinkPlayerInfoBridge> getOnlineList();

    @Nullable
    xh0.d getPlayModeService();

    @Nullable
    IInteractFeedViewManager getPreviewInteractFeedViewManager(ViewGroup r1, int r2);

    qd0.e getProfileCardOutService();

    qd0.f getRadioLinkService();

    ei6.a getRtcClient(Boolean r1);

    int getScene(@Nullable DataCenter r1);

    Pair<Integer, Integer> getSeiVersionAndUILayoutForMultiLink(int r1, int r2);

    int getSeiVersionFromUILayout(int r1);

    kj0.b getSelfDisciplineService();

    Pair<Integer, Integer> getSizeForXScreenAdjust(int r1, int r2, int r3, int r4);

    lj0.a getSpatialAudioService();

    @Nullable
    gj0.a getStarWishService();

    q getTalkRoomLogUtils();

    x00.a getThemeManager(boolean r1, @Nullable DataCenter r2);

    @Nullable
    pj0.b getThemedCompetitionService();

    int getUiLayout(DataCenter r1);

    void getUserWaitingInfo(String r1, int r2, com.bytedance.android.live.liveinteract.plantform.base.i.c r3);

    Single<com.bytedance.android.live.network.response.e<x>> getUserWaitingRankPosition(long r1, long r3, int r5);

    gd0.q getVideoCommentPanel(Context r1, Fragment r2, Boolean r3);

    int getVideoShowMode();

    rj0.m getVideoTalkService();

    String getXplayChannel();

    void guestAudioSubtitleSwitchSetting(boolean r1);

    @Deprecated(message = "尽量都使用guestBattleService向外提供能力，新增方法应该放在IGuestBattleOuterService中")
    @Nullable
    b0 guestBattleContext();

    @Nullable
    com.bytedance.android.live.liveinteract.revenue.battle.c0 guestBattleService();

    void guestDisconnect(int r1, rj0.c r2);

    void handleInteractClick();

    void handleInteractState(DataCenter r1, String r2, gd0.d r3);

    void handleLinkLynxPanelJsbChangeAction(String r1, String r2, JsonObject r3, ih0.h r4, @Nullable DataCenter r5);

    JsonObject handleLinkLynxPanelJsbGetAction(String r1, String r2, JsonObject r3);

    void handleLinkLynxPanelLinkControlAction(int r1, @Nullable DataCenter r2, String r3);

    void handleLinkLynxPanelMuteAction(int r1, boolean r2, boolean r3, boolean r4, boolean r5, String r6, String r7, @Nullable int r8, @Nullable Boolean r9);

    void handleServerPermissionErr(int r1, int r2, Throwable r3, Function0<Unit> r4, Function0<Unit> r5);

    boolean hasEmptySeatForLink();

    boolean hitEnlargeStageAb(IRoom r1);

    boolean hitStageAB();

    void initAndTurnOnChorusKTV();

    void initAndTurnOnKTV();

    void initAndTurnOnRadioLinkmicRoom(Runnable r1, Runnable r2);

    void initAndTurnOnVideoLinkmicRoom(Runnable r1, Runnable r2, int r3, int r4, String r5);

    void initAndTurnOnVoiceChatRoom();

    boolean isAIMVStage();

    boolean isAnonymousUser(Long r1);

    /* synthetic */ boolean isAnonymousUser(String r1);

    @Override // gd0.n
    boolean isAudienceLinkEngineOn();

    boolean isAudienceVideoLinkEngineOn();

    @Override // gd0.n
    /* synthetic */ boolean isCPositionOpen();

    boolean isCanShowLinkmicAnnounce(boolean r1);

    boolean isCanShowLinkmicAnnounce(boolean r1, IRoom r2);

    boolean isCurrentMicSeatFold(DataCenter r1);

    boolean isCurrentSceneSupportShowCastEntrance();

    boolean isEnableDanmuGameClearScreen();

    boolean isEnableDanmuGameServerMerge();

    boolean isEnableTalkRoomEmoji();

    boolean isFixFloatWindowLayout(int r1, int r2);

    boolean isGroupLiveGame();

    boolean isGuestLinker();

    boolean isInCustomizeStreamLayout();

    boolean isInLinkMicGameAnchorLinkMode();

    boolean isLinkCasting();

    boolean isLinkEverCast();

    boolean isLinkerUser(IBaseUser r1);

    boolean isLinkerUserUnSilence(IBaseUser r1);

    boolean isLiveShakeEnable();

    boolean isMicRoomHost(String r1);

    boolean isMultiLinkScene();

    boolean isMultiLinkScene(IRoom r1);

    @Deprecated(message = "废弃，后续使用下面的 @isMultiLinkScene")
    boolean isMultiLive();

    boolean isOpenInteractiveSong();

    boolean isPCLandscape(int r1, int r2);

    boolean isPaidInteractAudienceOnOrBiddingOpen();

    boolean isQuickInteractEnable();

    boolean isRoomFightSeiVersion(int r1);

    boolean isRoomFightUILayout(int r1);

    boolean isSelfVoiceChatRoomAudience();

    boolean isSupportLinkCastMiniApp();

    boolean isSupportedCommonUILayoutBySei(int r1, int r2);

    boolean isTalkRoomLoaded();

    Boolean isThemedCompetitionOn();

    boolean isVideoChorus();

    boolean isVideoEqualCenterAllFullLayout(int r1, int r2, int r3);

    boolean isVideoEqualCenterDynamicLayout(int r1, int r2);

    boolean isVideoEqualCenterNewLayout(int r1, int r2);

    boolean isVoiceMultiEnlargeSeat(int r1, int r2);

    boolean isVoiceRadioLink();

    boolean isXplayEnableAudioFrame();

    boolean isXplayFullScreenMode();

    void kickOutLinkUserInChatRoom(String r1, String r2, String r3);

    @Nullable
    xi0.a linkRoomFightService();

    void logMiniAppShareIconClick(String r1, String r2, boolean r3);

    void logMiniAppShareIconShow(String r1, String r2, boolean r3);

    void logPermit(IBaseUser r1, String r2);

    void monitor(LinkPreviewMonitorData r1);

    void multiAnchorLoadVideoTalk();

    void multiAnchorUnloadVideoTalk();

    boolean needAdjustBottomDpForSearchFeed(int r1, int r2, int r3);

    android.util.Pair<Boolean, Integer> needAdjustPublicScreenHeightForSubtitle(IRoom r1);

    boolean needAdjustScreen(int r1, int r2, int r3);

    boolean needSpecialAdjustScreen(int r1, int r2);

    void onAudienceEnterRoom(IRoom r1);

    void onAudienceEnterRoomWithPreload(IRoom r1, long r2, long r4);

    void onDownGradeInfo(boolean r1, int r2);

    void onFirstFrame(long r1);

    void onInnerPageSelected(int r1);

    void onLiveCoreAVLinkLogMonitor(String r1, String r2, JSONObject r3);

    void onProgramFrameErr();

    void onProgramHide();

    void onProgramShow();

    void onProgramStop();

    void onRtcAVLinkLogMonitor(String r1, JSONObject r2);

    void openEmojiDialog(String r1, String r2);

    void openInviteOrPermitPanel(String r1, int r2);

    void openInvitePanel(String r1);

    void openLinkmicSubtitleSettingDialog(Context r1, String r2, IAudioSubtitleContent r3);

    void openLiveTalkRoomDialog(Context r1, String r2, boolean r3, int r4, int r5, qd0.g r6);

    void openVideoTalkRoomManageDialog(Context r1, ILinkPlayerInfoBridge r2, Boolean r3, DataCenter r4);

    x00.b openVoiceLiveThemeDialog(Context r1, boolean r2, String r3, g r4, int r5, @Nullable DataCenter r6);

    cj0.a paidLinkMicContext();

    cj0.b paidLinkMicService();

    ClientUIInfo parseClientUIInfo(String r1);

    @Nullable
    ParseSeiData parseSeiDataBySei(String r1);

    void permit(IBaseUser r1, String r2);

    void permitPrepareApply(long r1, String r3);

    void pkInviteFailLoadWidget();

    void pkInviteUnloadWidget();

    void preloadDynamicContainer(Context r1);

    void preloadDynamicWidget(DataCenter r1, WidgetManager r2, @Nullable Room r3);

    void prepareApply(String r1);

    void prepareInvite(long r1, IBaseUser r3, String r4);

    android.util.Pair<String, v> provideAnchorModeLogInjector();

    android.util.Pair<String, v> provideChorusInfoLogInjector();

    Map<String, String> provideCommonParamsLog();

    android.util.Pair<String, v> provideFromAudienceSourceLogInjector();

    android.util.Pair<String, v> provideFunctionType2LogInjector();

    android.util.Pair<String, v> provideFunctionTypeLogInjector();

    android.util.Pair<String, v> providePlayModeLogInjector();

    android.util.Pair<String, v> provideSubscribeLogInjector();

    void refreshLayoutConfig();

    boolean rejectPkWhenReceiveCloudGroupLiveInvite();

    void removePreloadDynamicWidget(DataCenter r1, @Nullable BaseLinkMultiControlWidget.a r2);

    void reportNitaInner(IRoom r1);

    void resetAnchorLinkmicSurfaceView(SurfaceView r1);

    void resetBusinessDegradeStrategy(int r1, @Nullable String r2);

    void resetMultiLinkPerfAbilityManager();

    void setCposition(long r1, String r3, boolean r4, Function1<Boolean, Unit> r5);

    void setDynamicFromAudience(boolean r1);

    void setDynamicFromAudienceGuestCache(boolean r1);

    void setLinkEverCast(long r1);

    void setOnNeedMuteAudioFullPage(boolean r1);

    void showLinkDistributeSetting(Context r1, int r2, String r3, Boolean r4, ILinkDistributionSettingCallback r5);

    void showLynxGuestContributionRankList(Context r1, @Nullable DataCenter r2, IBaseUser r3, IRoom r4, Map<String, String> r5);

    void start3DAnim(com.bytedance.android.live.liveinteract.videotalk.emoji.model.g r1, com.bytedance.android.live.liveinteract.videotalk.emoji.model.c r2, com.bytedance.android.live.liveinteract.videotalk.emoji.model.n r3, com.bytedance.android.live.liveinteract.videotalk.emoji.model.m r4, String r5, com.bytedance.android.live.liveinteract.videotalk.emoji.model.o r6, MultiLinkScriptInfo r7, com.bytedance.android.live.liveinteract.animation.e r8);

    void startLinkCast(LinkScreenCastType r1, String r2, int r3, int r4, Bitmap r5, String r6, boolean r7);

    void stopLinkCast(LinkScreenCastType r1, String r2, boolean r3);

    android.util.Pair<Boolean, String> subtitleExceptPlayModeOpen();

    boolean subtitleHitNewStyleAB(IRoom r1);

    boolean supportInteractActing();

    void switchScene(int r1, int r2, String r3, Integer r4);

    void switchSceneWithConfirmCheck(Context r1, int r2, int r3, String r4, Integer r5, int r6);

    Observable<Response<com.bytedance.android.livesdk.rank.model.c>> syncLinkerRankList(long r1, String r3, String r4, String r5, String r6, long r7);

    @Nullable
    com.bytedance.android.live.liveinteract.revenue.fight.b teamFightService();

    UserType tryGetTargetUserType(String r1);

    void tryOpenChooseGuestPanelWithUsage(Context r1, String r2, String r3, DataCenter r4);

    void updateFromAudienceSource(IRoom r1);

    void updateFullScreenDialogShowStatus(boolean r1);

    void updateFunctionType2(IRoom r1);

    void updateLinkMicStatus(ih0.f r1, ih0.h r2, IJsBridgeManager r3);

    void updateSelfSilenceStatus(boolean r1, MediaOperation.a r2);

    void updateSwitchSceneSource(String r1);

    void updateVideoTalkRoomOpenSource(String r1);

    void updateViewInLiveBg(String r1, JsonObject r2, ih0.h r3);

    static {
        micRoomHostStateMap = new HashMap();
        linkMicSettings = new NextLiveData();
        playModeParams = new NextLiveData();
    }
}
