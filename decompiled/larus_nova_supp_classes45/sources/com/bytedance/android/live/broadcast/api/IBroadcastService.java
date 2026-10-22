package com.bytedance.android.live.broadcast.api;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.anniex.web.AnnieXWebKit;
import com.bytedance.android.live.broadcast.api.interacttools.IInteractPluginWidget;
import com.bytedance.android.live.broadcast.api.link.BaseScreenLinkControlWidget;
import com.bytedance.android.live.broadcast.api.model.LiveToolbarMountType;
import com.bytedance.android.live.broadcast.api.model.ScheduledSettingInfo;
import com.bytedance.android.live.broadcast.api.model.s0;
import com.bytedance.android.live.browser.jsbridge.base.LiveGetReplaySettingResultModel;
import com.bytedance.android.live.browser.jsbridge.base.LiveOpenRoomMemberLimitExemptionDialogResultModel;
import com.bytedance.android.live.browser.jsbridge.base.LiveUpdateReplaySettingResultModel;
import com.bytedance.android.live.browser.jsbridge.base.PaidPreviewVisibilityOptionsResultModel;
import com.bytedance.android.live.core.tetris.widgets.LiveWidget;
import com.bytedance.android.live.effect.api.b;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.live.network.response.g;
import com.bytedance.android.live.pushstream.d;
import com.bytedance.android.live.utility.ServiceDummyLookup;
import com.bytedance.android.live.utility.ServiceLookup;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0;
import com.bytedance.android.livesdk.schema.interfaces.IBaseSchemaHandler;
import com.bytedance.android.livesdkapi.LiveActivityProxy;
import com.bytedance.android.livesdkapi.broadcast.IBgBroadcastService;
import com.bytedance.android.livesdkapi.config.FastStartLiveConfig;
import com.bytedance.android.livesdkapi.depend.model.broadcast.ILiveBgBroadcastFragment;
import com.bytedance.android.livesdkapi.depend.model.broadcast.ILiveBroadcastCallback;
import com.bytedance.android.livesdkapi.depend.model.broadcast.ILivePreviewContainer;
import com.bytedance.android.livesdkapi.depend.model.broadcast.IStartLiveFragment;
import com.bytedance.android.livesdkapi.depend.model.broadcast.IStartLiveManager;
import com.bytedance.android.livesdkapi.depend.model.broadcast.LiveBroadcastHashTagUpdateParams;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.StreamUrlExtra;
import com.bytedance.android.livesdkapi.depend.model.live.episode.Episode;
import com.bytedance.android.livesdkapi.model.AnchorColumnPosterInfo;
import com.bytedance.android.livesdkapi.service.IBaseBroadcastService;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.sdk.xbridge.cn.protocol.MethodFinder;
import com.google.gson.JsonObject;
import hh1.v0;
import io.reactivex.Observable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import m00.e;
import m00.f;
import m00.h;
import n00.a;
import nz.c;
import nz.i;
import nz.k;
import nz.l;
import nz.m;
import nz.n;
import nz.p;
import nz.x;
import nz.y;
import org.json.JSONObject;
import w20.nb;
import w20.yc;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@ServiceLookup("com.bytedance.android.live.broadcast.BroadcastService")
@ServiceDummyLookup("com.bytedance.android.live.broadcast.api.dummy.BroadcastServiceDummy")
public interface IBroadcastService extends IBaseBroadcastService, IMiddlewareBroadcastService, IBroadcastServiceForSaas {
    public static final int COPYING = 1;
    public static final String LIVE_HEALTH_SCORE_URL = "https://webcast.huoshan.com/falcon/webcast_huoshan/page/health_score/main/index.html?showHeader=1";
    public static final int REC_COPY_DONE = 2;
    public static final String TAG_MSG_VIEW = "msg_view";
    public static final int TYPE_LINK_IN_ROOM_VIEW_AUDIO = 1;
    public static final int WIDGET_TYPE_ANCHOR_FANS_GROUP_MANAGER = 4;
    public static final int WIDGET_TYPE_BROADCAST_INFO = 0;
    public static final int WIDGET_TYPE_BROADCAST_KTV = 3;
    public static final int WIDGET_TYPE_STAR_GRAPH_WIDGET = 5;
    public static final int WIDGET_TYPE_STICKER_TIP = 1;
    public static final int WIDGET_TYPE_TASK_FINISH_ANIM = 2;
    public static final int WIDGET_TYPE_VIDEO_PLAY_CONTROL = 2333;

    @Override // com.bytedance.android.live.broadcast.api.IMiddlewareBroadcastService
    a broadcastFloatWindowManager();

    void checkAndRequestBroadcastPermission(Fragment r1, LiveMode r2, String r3, c r4, m r5);

    void checkAndRequestBroadcastPermission(FragmentActivity r1, LiveMode r2, String r3, c r4, m r5);

    Observable<g<Room>> checkGameRoomState();

    boolean closeAllInteractPlugin(boolean r1);

    void closeAndRestartBroadcast(Context r1, boolean r2);

    boolean closeInteractPluginCard(String r1, boolean r2);

    boolean closeLynxPlugin(s0 r1);

    IBgBroadcastService createBgBroadcastBinder();

    Fragment createBgBroadcastFragment(k r1, Bundle r2);

    ILiveBgBroadcastFragment createBgBrowseFragment(Bundle r1);

    ILiveBgBroadcastFragment createBgMirrorFragment(Bundle r1);

    Fragment createBroadcastStreamFragment(k r1, LiveMode r2, StreamUrlExtra r3, String r4);

    Fragment createBroadcastStreamFragment(k r1, LiveMode r2, StreamUrlExtra r3, String r4, Bundle r5);

    f createCoverController(Fragment r1, Room r2);

    @Override // com.bytedance.android.live.broadcast.api.IMiddlewareBroadcastService
    m00.c createDigitAvatarPreView(Context r1);

    b createEffectGestureDetector(Context r1);

    void createInteractPluginCard(String r1, View r2);

    @Override // com.bytedance.android.live.broadcast.api.IMiddlewareBroadcastService
    e createLinkInRoomView(d r1, Context r2, int r3);

    @Override // com.bytedance.android.live.broadcast.api.IMiddlewareBroadcastService
    m00.d createLinkVideoView(Context r1, m00.d.a r2, String r3, boolean r4);

    Fragment createLiveBroadcastFragment(k r1, ILiveBroadcastCallback r2, Bundle r3);

    ILivePreviewContainer createPreviewContainerFragment(Bundle r1);

    c0.b createReplayVisibilityBehavior(Context r1, Episode r2);

    BaseScreenLinkControlWidget createScreenControlWidget(BaseScreenLinkControlWidget.a r1, ViewGroup r2, tlc.d r3);

    Widget createScreenLiveWidget(v0 r1);

    LiveActivityProxy createStartLiveActivityProxy(FragmentActivity r1);

    IStartLiveFragment createStartLiveFragment();

    com.bytedance.android.live.effect.api.m createStickerStatusReportUtil();

    @Override // com.bytedance.android.live.broadcast.api.IMiddlewareBroadcastService
    m00.g createVideoTalkView(Context r1, String r2, boolean r3, boolean r4, boolean r5, m00.g.a r6);

    @Override // com.bytedance.android.live.broadcast.api.IMiddlewareBroadcastService
    h createVoiceRoomVideoView(Context r1, String r2);

    Fragment createXTMediaBroadcastFragment(ILiveBroadcastCallback r1, Bundle r2);

    void destroyInitStartLiveData(boolean r1);

    p digitAvatarEffectHelper();

    void downloadRequirements(List<String> r1);

    void exitStableModel(String r1);

    boolean fastStartLivePreCheck(FragmentActivity r1, LiveMode r2);

    void fastStartLivePreLoad(FragmentActivity r1, FastStartLiveConfig r2);

    IAnchorBizPanelService fetchAnchorBizPanelService();

    nz.g fetchAnchorStatusPanelService();

    Observable<g<Room>> fetchContinueRoom();

    Observable<com.bytedance.android.live.network.response.e<Room>> fetchContinueRoomWithPb();

    j70.h<? extends h70.b> getAddPictureWidgetDescriptor();

    String getAuthString(String r1);

    nz.h getBroadcastBubbleManager();

    i getBroadcastDotManager();

    String getDeviceNum(String r1);

    ArrayList<String> getDeviceNumList(String r1);

    rz.a getDotManager();

    IGameCPPreviewService getGameCPPreviewService();

    com.bytedance.ies.web.jsbridge2.f<JsonObject, LiveGetReplaySettingResultModel> getGetReplaySettingMethod();

    j70.h<? extends h70.b> getGroupLiveStreamWidgetDescriptor();

    IInteractPluginWidget getInteractPluginWidget(Fragment r1, FragmentManager r2);

    j70.h<? extends h70.b> getInteractToolInfoUploadServiceWidgetDescriptor();

    j70.h<? extends h70.b> getInteractToolPerformanceWidgetDescriptor();

    a00.a getInteractToolsMobInfo(String r1);

    LiveWidget getInteractToolsServiceWidget();

    l getInteractionScopeManager(Long r1, DataCenter r2);

    j70.h<? extends h70.b> getLiveAnchorTrialServiceWidget();

    sz.a getLiveByteCastSinkService();

    IBaseSchemaHandler getOpenLiveVisiblePageActionHandler();

    com.bytedance.ies.web.jsbridge2.f<JsonObject, LiveOpenRoomMemberLimitExemptionDialogResultModel> getOpenRoomMemberLimitExemptionDialogMethod();

    com.bytedance.ies.web.jsbridge2.f<yc, PaidPreviewVisibilityOptionsResultModel> getPaidPreviewVisibilityOptionsMethod();

    j70.h<? extends h70.b> getPicturePresentationWidgetDescriptor();

    Bitmap getPreviewBitmap();

    LiveMode getPreviewLiveMode();

    Boolean getPreviewToolbarDotInfo(String r1, int r2);

    Map<String, String> getRestartContinueLogExtra();

    Room getRestartContinueRoom();

    List<String> getRunningInteractPluginIds();

    Set<String> getRunningInteractPlugins();

    j70.h<? extends h70.b> getScreenRecordMonitorWidgetDescriptor();

    n getStableManager(DataCenter r1);

    Class<? extends Widget> getStartLiveVisibilityTransformWidgetClass();

    com.bytedance.ies.web.jsbridge2.f<nb, LiveUpdateReplaySettingResultModel> getUpdateReplaySettingMethod();

    <T> Class<T> getWidgetClass(int r1);

    IXTBroadcastService getXTBroadcastService();

    x getXTMediaBroadcastService();

    void handleAnchorPerformanceLevel(int r1);

    void handleLowMemory();

    boolean handlerRestartBroadcastActivity(Context r1, String r2);

    void hideInteractPluginCard(String r1);

    @Override // com.bytedance.android.live.broadcast.api.IMiddlewareBroadcastService
    void init();

    void installPlugin(pz.a r1);

    boolean isInAudioPlayBackCapture();

    boolean isInterceptOnClickToolBar(DataCenter r1, ToolbarButton r2);

    boolean isPluginRunning(String r1);

    boolean isRequirementsDownloaded(List<String> r1);

    boolean isUserInAnchorLink(String r1);

    boolean isWiredCasting(String r1);

    AnnieXWebKit loadAnnieXWebKit(Context r1, Uri r2, String r3, MethodFinder r4, Map<String, Object> r5, Function2<String, WebView, Void> r6, Function2<String, Throwable, Void> r7);

    @Override // com.bytedance.android.live.broadcast.api.IMiddlewareBroadcastService
    Observable<Integer> loadShortVideoRes();

    void markDotClicked(String r1);

    void markEnterSceneFromJsb(int r1);

    void mountToolbarComponent(int r1, LiveToolbarMountType r2);

    void onActivityResult(int r1, int r2, Intent r3, String r4);

    void openAnnouncementPushDialog(Context r1, Boolean r2);

    void openCategoryDialog(Context r1, DataCenter r2);

    void openForenoticeDialog(Context r1, boolean r2, boolean r3, ScheduledSettingInfo r4, y r5, int r6, String r7);

    void openLiveDelaySchemeActivity(Context r1, String r2, long r3);

    boolean openPluginMiniApp(String r1, String r2, String r3, Map<String, String> r4);

    void openPosterGenerateDialog(Context r1, AnchorColumnPosterInfo r2);

    void openPreviewSettingDialog(Context r1);

    void openPrivilegeDetailSettingDialog(Context r1);

    void openRoomChoosePVCountDialog(FragmentActivity r1, Room r2, LiveMode r3);

    void openRoomIntroMediaDialog(FragmentActivity r1, Room r2, LiveMode r3, Function0<Unit> r4);

    void openStableModeDialog(String r1);

    void openVideoCategoryDialog(Context r1, String r2);

    void preInitStartLiveData(Long r1, String... r2);

    void preInitStartLiveData(String... r1);

    void preInitStartLiveDataWithBundle(Bundle r1, Long r2, String... r3);

    void preInitStartLiveOnComponentCreate(Long r1, String... r2);

    Object provideToolbarBehavior(int r1, List<Object> r2);

    void putInteractToolsMobInfo(String r1, a00.a r2);

    void recordLiveStart();

    void recordPublishSuccess();

    void recyclerPreviewBitmap();

    void registerScopeService();

    void removeInteractToolsMobInfo(String r1);

    void removeToolbarComponent(int r1);

    void reply(String r1, int r2, int r3, boolean r4, long r5, long r7, int r9, String r11, String r12, pc0.b r13);

    Observable<Response<Object>> reportRoomEvent(int r1, long r2, int r4, String r5);

    void resetHeap(LiveMode r1, Context r2);

    void restoreVideoRecordActivity(Context r1);

    void savePerfKeva(JSONObject r1);

    void setMetadata(String r1, String r2, Map<String, String> r3);

    void setOnInvitedListener(mc0.a r1);

    boolean shouldDefaultToLive();

    void showAddAnchorShowDialog(Context r1, int r2, int r3, m00.b r4);

    void showAnchorManagerInputDialog(Context r1, int r2, String r3, m00.a r4);

    boolean showInteractPluginCard(String r1);

    void showLiveGameDiscoveryDialog(Context r1, Bundle r2);

    boolean showMultiCameraConnectionPanel(Context r1, DataCenter r2, Map<String, String> r3);

    void startBrowse(String r1);

    IStartLiveManager startLiveManager();

    boolean startLynxPlugin(s0 r1);

    void startWirelessBrowse(String r1, String r2);

    void startWirelessMirror(HashMap<String, Object> r1, String r2);

    void stopBrowse(String r1);

    void stopBrowseMirror();

    void stopCastWithDialog(Context r1, String r2);

    void stopPoll(String r1);

    void stopWirelessMirror(String r1);

    void traceLandingSwitch(String r1);

    void tryInitBrowseCastService(pz.a r1);

    void tryInitCastService(Intent r1, pz.a r2);

    void tryInitWiredCastService(Intent r1, pz.a r2);

    void tryInitWirelessCastService(pz.a r1);

    Observable<Integer> updateBroadcastRoomHashTag(LiveBroadcastHashTagUpdateParams r1);

    Observable<String> updateForenoticeInfo(ScheduledSettingInfo r1);

    void updateGameMsgViewUserCount(Long r1);

    boolean updateLynxPlugin(s0 r1);
}
