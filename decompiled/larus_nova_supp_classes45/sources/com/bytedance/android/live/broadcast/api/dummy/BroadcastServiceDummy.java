package com.bytedance.android.live.broadcast.api.dummy;

import android.app.Activity;
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
import com.bytedance.android.live.broadcast.api.IAnchorBizPanelService;
import com.bytedance.android.live.broadcast.api.IBroadcastService;
import com.bytedance.android.live.broadcast.api.IBroadcastServiceForSaas;
import com.bytedance.android.live.broadcast.api.IGameCPPreviewService;
import com.bytedance.android.live.broadcast.api.IXTBroadcastService;
import com.bytedance.android.live.broadcast.api.interacttools.IInteractPluginWidget;
import com.bytedance.android.live.broadcast.api.link.BaseScreenLinkControlWidget;
import com.bytedance.android.live.broadcast.api.model.LiveToolbarMountType;
import com.bytedance.android.live.broadcast.api.model.ScheduledSettingInfo;
import com.bytedance.android.live.broadcast.api.model.o0;
import com.bytedance.android.live.broadcast.api.model.s0;
import com.bytedance.android.live.broadcast.api.model.t;
import com.bytedance.android.live.browser.jsbridge.base.LiveGetReplaySettingResultModel;
import com.bytedance.android.live.browser.jsbridge.base.LiveOpenRoomMemberLimitExemptionDialogResultModel;
import com.bytedance.android.live.browser.jsbridge.base.LiveUpdateReplaySettingResultModel;
import com.bytedance.android.live.browser.jsbridge.base.PaidPreviewVisibilityOptionsResultModel;
import com.bytedance.android.live.core.tetris.widgets.LiveWidget;
import com.bytedance.android.live.effect.api.b;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.live.network.response.g;
import com.bytedance.android.live.pushstream.d;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0;
import com.bytedance.android.livesdk.schema.interfaces.IBaseSchemaHandler;
import com.bytedance.android.livesdkapi.IStartLiveInterceptor;
import com.bytedance.android.livesdkapi.LiveActivityProxy;
import com.bytedance.android.livesdkapi.broadcast.IBgBroadcastService;
import com.bytedance.android.livesdkapi.config.FastStartLiveConfig;
import com.bytedance.android.livesdkapi.depend.model.broadcast.ILiveBgBroadcastFragment;
import com.bytedance.android.livesdkapi.depend.model.broadcast.ILiveBroadcastCallback;
import com.bytedance.android.livesdkapi.depend.model.broadcast.ILivePreviewContainer;
import com.bytedance.android.livesdkapi.depend.model.broadcast.IStartLiveFragment;
import com.bytedance.android.livesdkapi.depend.model.broadcast.IStartLiveManager;
import com.bytedance.android.livesdkapi.depend.model.broadcast.LiveBroadcastHashTagUpdateParams;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.StreamUrlExtra;
import com.bytedance.android.livesdkapi.depend.model.live.episode.Episode;
import com.bytedance.android.livesdkapi.model.AnchorColumnPosterInfo;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.sdk.xbridge.cn.protocol.MethodFinder;
import com.google.gson.JsonObject;
import hh1.v0;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
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
import nz.q;
import nz.u;
import nz.x;
import nz.y;
import org.json.JSONObject;
import w20.nb;
import w20.yc;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class BroadcastServiceDummy implements IBroadcastService {
    @Override // com.bytedance.android.live.broadcast.api.IBroadcastService, com.bytedance.android.live.broadcast.api.IMiddlewareBroadcastService
    public a broadcastFloatWindowManager() {
        return null;
    }

    public void cameraDirtyDetect(float r1, int r2) {
    }

    @Override // com.bytedance.android.live.broadcast.api.IBroadcastService
    public void checkAndRequestBroadcastPermission(Fragment r1, LiveMode r2, String r3, c r4, m r5) {
    }

    @Override // com.bytedance.android.live.broadcast.api.IBroadcastService
    public void checkAndRequestBroadcastPermission(FragmentActivity r1, LiveMode r2, String r3, c r4, m r5) {
    }

    @Override // com.bytedance.android.live.broadcast.api.IBroadcastService
    public Observable<g<Room>> checkGameRoomState() {
        return null;
    }

    @Override // com.bytedance.android.live.broadcast.api.IMiddlewareBroadcastService
    public Disposable checkToolbarPermission(Context r1, Long r2, String r3, o0 r4) {
        return null;
    }

    @Override // com.bytedance.android.live.broadcast.api.IBroadcastService
    public boolean closeAllInteractPlugin(boolean r1) {
        return false;
    }

    @Override // com.bytedance.android.live.broadcast.api.IBroadcastService
    public void closeAndRestartBroadcast(Context r1, boolean r2) {
    }

    @Override // com.bytedance.android.live.broadcast.api.IBroadcastService
    public boolean closeInteractPluginCard(String r1, boolean r2) {
        return false;
    }

    @Override // com.bytedance.android.live.broadcast.api.IBroadcastService
    public boolean closeLynxPlugin(s0 r1) {
        return false;
    }

    @Override // com.bytedance.android.live.broadcast.api.IBroadcastService
    public IBgBroadcastService createBgBroadcastBinder() {
        return null;
    }

    @Override // com.bytedance.android.live.broadcast.api.IBroadcastService
    public Fragment createBgBroadcastFragment(k r1, Bundle r2) {
        return null;
    }

    @Override // com.bytedance.android.live.broadcast.api.IBroadcastService
    public ILiveBgBroadcastFragment createBgBrowseFragment(Bundle r1) {
        return null;
    }

    @Override // com.bytedance.android.live.broadcast.api.IBroadcastService
    public ILiveBgBroadcastFragment createBgMirrorFragment(Bundle r1) {
        return null;
    }

    @Override // com.bytedance.android.live.broadcast.api.IBroadcastService
    public Fragment createBroadcastStreamFragment(k r1, LiveMode r2, StreamUrlExtra r3, String r4) {
        return null;
    }

    @Override // com.bytedance.android.live.broadcast.api.IBroadcastService
    public Fragment createBroadcastStreamFragment(k r1, LiveMode r2, StreamUrlExtra r3, String r4, Bundle r5) {
        return null;
    }

    @Override // com.bytedance.android.live.broadcast.api.IBroadcastService
    public f createCoverController(Fragment r1, Room r2) {
        return null;
    }

    @Override // com.bytedance.android.live.broadcast.api.IBroadcastService, com.bytedance.android.live.broadcast.api.IMiddlewareBroadcastService
    public m00.c createDigitAvatarPreView(Context r1) {
        return null;
    }

    @Override // com.bytedance.android.live.broadcast.api.IBroadcastService
    public b createEffectGestureDetector(Context r1) {
        return null;
    }

    @Override // com.bytedance.android.live.broadcast.api.IBroadcastService
    public void createInteractPluginCard(String r1, View r2) {
    }

    @Override // com.bytedance.android.live.broadcast.api.IBroadcastService, com.bytedance.android.live.broadcast.api.IMiddlewareBroadcastService
    public e createLinkInRoomView(d r1, Context r2, int r3) {
        return null;
    }

    @Override // com.bytedance.android.live.broadcast.api.IBroadcastService, com.bytedance.android.live.broadcast.api.IMiddlewareBroadcastService
    public m00.d createLinkVideoView(Context r1, m00.d.a r2, String r3, boolean r4) {
        return null;
    }

    @Override // com.bytedance.android.live.broadcast.api.IBroadcastService
    public Fragment createLiveBroadcastFragment(k r1, ILiveBroadcastCallback r2, Bundle r3) {
        return null;
    }

    @Override // com.bytedance.android.live.broadcast.api.IBroadcastService
    public ILivePreviewContainer createPreviewContainerFragment(Bundle r1) {
        return null;
    }

    @Override // com.bytedance.android.live.broadcast.api.IBroadcastServiceForSaas
    public final /* synthetic */ void createPreviewContainerFragment(Context r1, Bundle r2, ld1.b r3) {
        IBroadcastServiceForSaas.CC.$default$createPreviewContainerFragment(this, r1, r2, null);
    }

    @Override // com.bytedance.android.live.broadcast.api.IBroadcastService
    public c0.b createReplayVisibilityBehavior(Context r1, Episode r2) {
        return null;
    }

    @Override // com.bytedance.android.live.broadcast.api.IBroadcastService
    public BaseScreenLinkControlWidget createScreenControlWidget(BaseScreenLinkControlWidget.a r1, ViewGroup r2, tlc.d r3) {
        return null;
    }

    @Override // com.bytedance.android.live.broadcast.api.IBroadcastService
    public Widget createScreenLiveWidget(v0 r1) {
        return null;
    }

    @Override // com.bytedance.android.live.broadcast.api.IBroadcastService
    public LiveActivityProxy createStartLiveActivityProxy(FragmentActivity r1) {
        return null;
    }

    @Override // com.bytedance.android.live.broadcast.api.IBroadcastService
    public IStartLiveFragment createStartLiveFragment() {
        return null;
    }

    @Override // com.bytedance.android.live.broadcast.api.IBroadcastServiceForSaas
    public final /* synthetic */ void createStartLiveFragment(Context r1, ld1.c r2) {
        IBroadcastServiceForSaas.CC.$default$createStartLiveFragment(this, r1, r2);
    }

    @Override // com.bytedance.android.live.broadcast.api.IBroadcastService
    public com.bytedance.android.live.effect.api.m createStickerStatusReportUtil() {
        return null;
    }

    @Override // com.bytedance.android.live.broadcast.api.IBroadcastService, com.bytedance.android.live.broadcast.api.IMiddlewareBroadcastService
    public m00.g createVideoTalkView(Context r1, String r2, boolean r3, boolean r4, boolean r5, m00.g.a r6) {
        return null;
    }

    @Override // com.bytedance.android.live.broadcast.api.IBroadcastService, com.bytedance.android.live.broadcast.api.IMiddlewareBroadcastService
    public h createVoiceRoomVideoView(Context r1, String r2) {
        return null;
    }

    @Override // com.bytedance.android.live.broadcast.api.IBroadcastService
    public Fragment createXTMediaBroadcastFragment(ILiveBroadcastCallback r1, Bundle r2) {
        return null;
    }

    @Override // com.bytedance.android.live.broadcast.api.IBroadcastService
    public void destroyInitStartLiveData(boolean r1) {
    }

    @Override // com.bytedance.android.live.broadcast.api.IBroadcastService
    public p digitAvatarEffectHelper() {
        return null;
    }

    @Override // com.bytedance.android.live.broadcast.api.IBroadcastService
    public void downloadRequirements(List<String> r1) {
    }

    public void enterStableModel(boolean r1, String r2) {
    }

    @Override // com.bytedance.android.live.broadcast.api.IBroadcastService
    public void exitStableModel(String r1) {
    }

    public void fastStartLive(FragmentActivity r1, FastStartLiveConfig r2, ArrayList<IStartLiveInterceptor> r3, nz.e r4) {
    }

    public void fastStartLiveForSchema(Context r1, FastStartLiveConfig r2, ArrayList<IStartLiveInterceptor> r3, nz.e r4) {
    }

    @Override // com.bytedance.android.live.broadcast.api.IBroadcastService
    public boolean fastStartLivePreCheck(FragmentActivity r1, LiveMode r2) {
        return false;
    }

    @Override // com.bytedance.android.live.broadcast.api.IBroadcastService
    public void fastStartLivePreLoad(FragmentActivity r1, FastStartLiveConfig r2) {
    }

    @Override // com.bytedance.android.live.broadcast.api.IBroadcastService
    public IAnchorBizPanelService fetchAnchorBizPanelService() {
        return null;
    }

    @Override // com.bytedance.android.live.broadcast.api.IBroadcastService
    public nz.g fetchAnchorStatusPanelService() {
        return null;
    }

    @Override // com.bytedance.android.live.broadcast.api.IBroadcastService
    public Observable<g<Room>> fetchContinueRoom() {
        return null;
    }

    @Override // com.bytedance.android.live.broadcast.api.IBroadcastService
    public Observable<com.bytedance.android.live.network.response.e<Room>> fetchContinueRoomWithPb() {
        return null;
    }

    @Override // com.bytedance.android.live.broadcast.api.IBroadcastService
    public j70.h<? extends h70.b> getAddPictureWidgetDescriptor() {
        return null;
    }

    @Override // com.bytedance.android.live.broadcast.api.IBroadcastService
    public String getAuthString(String r1) {
        return null;
    }

    @Override // com.bytedance.android.live.broadcast.api.IBroadcastService
    public nz.h getBroadcastBubbleManager() {
        return null;
    }

    @Override // com.bytedance.android.live.broadcast.api.IBroadcastService
    public i getBroadcastDotManager() {
        return null;
    }

    @Override // com.bytedance.android.live.broadcast.api.IMiddlewareBroadcastService
    public int getCastingType() {
        return 0;
    }

    @Override // com.bytedance.android.live.broadcast.api.IBroadcastService
    public String getDeviceNum(String r1) {
        return null;
    }

    @Override // com.bytedance.android.live.broadcast.api.IBroadcastService
    public ArrayList<String> getDeviceNumList(String r1) {
        return null;
    }

    @Override // com.bytedance.android.live.broadcast.api.IBroadcastService
    public rz.a getDotManager() {
        return null;
    }

    @Override // com.bytedance.android.live.broadcast.api.IBroadcastService
    public IGameCPPreviewService getGameCPPreviewService() {
        return null;
    }

    @Override // com.bytedance.android.live.broadcast.api.IBroadcastService
    public com.bytedance.ies.web.jsbridge2.f<JsonObject, LiveGetReplaySettingResultModel> getGetReplaySettingMethod() {
        return null;
    }

    @Override // com.bytedance.android.live.broadcast.api.IBroadcastService
    public j70.h<? extends h70.b> getGroupLiveStreamWidgetDescriptor() {
        return null;
    }

    @Override // com.bytedance.android.live.broadcast.api.IBroadcastService
    public IInteractPluginWidget getInteractPluginWidget(Fragment r1, FragmentManager r2) {
        return null;
    }

    @Override // com.bytedance.android.live.broadcast.api.IBroadcastService
    public j70.h<? extends h70.b> getInteractToolInfoUploadServiceWidgetDescriptor() {
        return null;
    }

    @Override // com.bytedance.android.live.broadcast.api.IBroadcastService
    public j70.h<? extends h70.b> getInteractToolPerformanceWidgetDescriptor() {
        return null;
    }

    @Override // com.bytedance.android.live.broadcast.api.IBroadcastService
    public a00.a getInteractToolsMobInfo(String r1) {
        return null;
    }

    @Override // com.bytedance.android.live.broadcast.api.IBroadcastService
    public LiveWidget getInteractToolsServiceWidget() {
        return null;
    }

    @Override // com.bytedance.android.live.broadcast.api.IBroadcastService
    public l getInteractionScopeManager(Long r1, DataCenter r2) {
        return null;
    }

    @Override // com.bytedance.android.live.broadcast.api.IBroadcastService
    public j70.h<? extends h70.b> getLiveAnchorTrialServiceWidget() {
        return null;
    }

    @Override // com.bytedance.android.live.broadcast.api.IBroadcastService
    public sz.a getLiveByteCastSinkService() {
        return null;
    }

    @Override // com.bytedance.android.live.broadcast.api.IMiddlewareBroadcastService
    public String getLiveCoreVersion() {
        return "";
    }

    @Override // com.bytedance.android.live.broadcast.api.IBroadcastService
    public IBaseSchemaHandler getOpenLiveVisiblePageActionHandler() {
        return null;
    }

    @Override // com.bytedance.android.live.broadcast.api.IBroadcastService
    public com.bytedance.ies.web.jsbridge2.f<JsonObject, LiveOpenRoomMemberLimitExemptionDialogResultModel> getOpenRoomMemberLimitExemptionDialogMethod() {
        return null;
    }

    @Override // com.bytedance.android.live.broadcast.api.IBroadcastService
    public com.bytedance.ies.web.jsbridge2.f<yc, PaidPreviewVisibilityOptionsResultModel> getPaidPreviewVisibilityOptionsMethod() {
        return null;
    }

    @Override // com.bytedance.android.live.broadcast.api.IBroadcastService
    public j70.h<? extends h70.b> getPicturePresentationWidgetDescriptor() {
        return null;
    }

    @Override // com.bytedance.android.live.broadcast.api.IBroadcastService
    public Bitmap getPreviewBitmap() {
        return null;
    }

    @Override // com.bytedance.android.live.broadcast.api.IBroadcastService
    public Boolean getPreviewToolbarDotInfo(String r1, int r2) {
        return null;
    }

    @Override // com.bytedance.android.live.broadcast.api.IBroadcastService
    public Map<String, String> getRestartContinueLogExtra() {
        return null;
    }

    @Override // com.bytedance.android.live.broadcast.api.IBroadcastService
    public Room getRestartContinueRoom() {
        return null;
    }

    @Override // com.bytedance.android.live.broadcast.api.IBroadcastService
    public j70.h<? extends h70.b> getScreenRecordMonitorWidgetDescriptor() {
        return null;
    }

    @Override // com.bytedance.android.live.broadcast.api.IBroadcastService
    public n getStableManager(DataCenter r1) {
        return null;
    }

    @Override // com.bytedance.android.live.broadcast.api.IBroadcastService
    public Class<? extends Widget> getStartLiveVisibilityTransformWidgetClass() {
        return null;
    }

    @Override // com.bytedance.android.live.broadcast.api.IBroadcastService
    public com.bytedance.ies.web.jsbridge2.f<nb, LiveUpdateReplaySettingResultModel> getUpdateReplaySettingMethod() {
        return null;
    }

    @Override // com.bytedance.android.live.broadcast.api.IBroadcastService
    public <T> Class<T> getWidgetClass(int r1) {
        return null;
    }

    @Override // com.bytedance.android.live.broadcast.api.IBroadcastService
    public IXTBroadcastService getXTBroadcastService() {
        return null;
    }

    @Override // com.bytedance.android.live.broadcast.api.IBroadcastService
    public x getXTMediaBroadcastService() {
        return null;
    }

    @Override // com.bytedance.android.live.broadcast.api.IBroadcastService
    public void handleAnchorPerformanceLevel(int r1) {
    }

    @Override // com.bytedance.android.live.broadcast.api.IBroadcastService
    public void handleLowMemory() {
    }

    @Override // com.bytedance.android.live.broadcast.api.IBroadcastService
    public boolean handlerRestartBroadcastActivity(Context r1, String r2) {
        return false;
    }

    @Override // com.bytedance.android.live.broadcast.api.IMiddlewareBroadcastService
    public boolean hasPoiPermission() {
        return false;
    }

    @Override // com.bytedance.android.live.broadcast.api.IBroadcastService
    public void hideInteractPluginCard(String r1) {
    }

    @Override // com.bytedance.android.live.broadcast.api.IBroadcastService, com.bytedance.android.live.broadcast.api.IMiddlewareBroadcastService
    public void init() {
    }

    public void injectRouteOutCertIdToIntent(String r1, Intent r2) {
    }

    @Override // com.bytedance.android.live.broadcast.api.IBroadcastService
    public void installPlugin(pz.a r1) {
    }

    @Override // com.bytedance.android.live.broadcast.api.IMiddlewareBroadcastService
    public boolean isAudienceCasting() {
        return false;
    }

    @Override // com.bytedance.android.live.broadcast.api.IMiddlewareBroadcastService
    public boolean isCasting() {
        return false;
    }

    @Override // com.bytedance.android.live.broadcast.api.IBroadcastService
    public boolean isInAudioPlayBackCapture() {
        return false;
    }

    @Override // com.bytedance.android.live.broadcast.api.IBroadcastService
    public boolean isInterceptOnClickToolBar(DataCenter r1, ToolbarButton r2) {
        return false;
    }

    @Override // com.bytedance.android.live.broadcast.api.IMiddlewareBroadcastService
    public boolean isPlayingGame() {
        return false;
    }

    @Override // com.bytedance.android.live.broadcast.api.IBroadcastService
    public boolean isPluginRunning(String r1) {
        return false;
    }

    @Override // com.bytedance.android.live.broadcast.api.IBroadcastService
    public boolean isRequirementsDownloaded(List<String> r1) {
        return false;
    }

    @Override // com.bytedance.android.live.broadcast.api.IBroadcastService
    public boolean isUserInAnchorLink(String r1) {
        return false;
    }

    @Override // com.bytedance.android.live.broadcast.api.IBroadcastService
    public boolean isWiredCasting(String r1) {
        return false;
    }

    @Override // com.bytedance.android.live.broadcast.api.IMiddlewareBroadcastService
    public void justReportRoomEvent(int r1, long r2, int r4, String r5) {
    }

    @Override // com.bytedance.android.live.broadcast.api.IMiddlewareBroadcastService
    public q linkEffectHelper() {
        return null;
    }

    @Override // com.bytedance.android.live.broadcast.api.IBroadcastService
    public AnnieXWebKit loadAnnieXWebKit(Context r1, Uri r2, String r3, MethodFinder r4, Map<String, Object> r5, Function2<String, WebView, Void> r6, Function2<String, Throwable, Void> r7) {
        return null;
    }

    @Override // com.bytedance.android.live.broadcast.api.IBroadcastService, com.bytedance.android.live.broadcast.api.IMiddlewareBroadcastService
    public Observable<Integer> loadShortVideoRes() {
        return null;
    }

    @Override // com.bytedance.android.live.broadcast.api.IBroadcastService
    public void markDotClicked(String r1) {
    }

    @Override // com.bytedance.android.live.broadcast.api.IBroadcastService
    public void markEnterSceneFromJsb(int r1) {
    }

    @Override // com.bytedance.android.live.broadcast.api.IMiddlewareBroadcastService
    public void markPopupShown(int r1) {
    }

    @Override // com.bytedance.android.live.broadcast.api.IMiddlewareBroadcastService
    public void minimizeCast() {
    }

    @Override // com.bytedance.android.live.broadcast.api.IBroadcastService
    public void mountToolbarComponent(int r1, LiveToolbarMountType r2) {
    }

    @Override // com.bytedance.android.live.broadcast.api.IBroadcastService
    public void onActivityResult(int r1, int r2, Intent r3, String r4) {
    }

    public void onInnerPushViewClick(int r1) {
    }

    public void onSaveInstanceState(Bundle r1) {
    }

    @Override // com.bytedance.android.live.broadcast.api.IBroadcastService
    public void openAnnouncementPushDialog(Context r1, Boolean r2) {
    }

    @Override // com.bytedance.android.live.broadcast.api.IBroadcastService
    public void openCategoryDialog(Context r1, DataCenter r2) {
    }

    @Override // com.bytedance.android.live.broadcast.api.IBroadcastService
    public void openForenoticeDialog(Context r1, boolean r2, boolean r3, ScheduledSettingInfo r4, y r5, int r6, String r7) {
    }

    @Override // com.bytedance.android.live.broadcast.api.IBroadcastService
    public void openLiveDelaySchemeActivity(Context r1, String r2, long r3) {
    }

    @Override // com.bytedance.android.live.broadcast.api.IBroadcastService
    public boolean openPluginMiniApp(String r1, String r2, String r3, Map<String, String> r4) {
        return false;
    }

    @Override // com.bytedance.android.live.broadcast.api.IBroadcastService
    public void openPosterGenerateDialog(Context r1, AnchorColumnPosterInfo r2) {
    }

    @Override // com.bytedance.android.live.broadcast.api.IBroadcastService
    public void openPreviewSettingDialog(Context r1) {
    }

    @Override // com.bytedance.android.live.broadcast.api.IBroadcastService
    public void openPrivilegeDetailSettingDialog(Context r1) {
    }

    @Override // com.bytedance.android.live.broadcast.api.IBroadcastService
    public void openRoomChoosePVCountDialog(FragmentActivity r1, Room r2, LiveMode r3) {
    }

    @Override // com.bytedance.android.live.broadcast.api.IMiddlewareBroadcastService
    public void openRoomIntroDialog(FragmentActivity r1, IRoom r2, LiveMode r3, Long r4, gz.b r5, Function1<? super gz.b, Unit> r6, Function1<? super Boolean, Unit> r7) {
    }

    @Override // com.bytedance.android.live.broadcast.api.IBroadcastService
    public void openRoomIntroMediaDialog(FragmentActivity r1, Room r2, LiveMode r3, Function0<Unit> r4) {
    }

    @Override // com.bytedance.android.live.broadcast.api.IBroadcastService
    public void openStableModeDialog(String r1) {
    }

    @Override // com.bytedance.android.live.broadcast.api.IBroadcastService
    public void openVideoCategoryDialog(Context r1, String r2) {
    }

    @Override // com.bytedance.android.live.broadcast.api.IMiddlewareBroadcastService
    public void pauseCast(Integer r1) {
    }

    @Override // com.bytedance.android.live.broadcast.api.IBroadcastService
    public void preInitStartLiveData(Long r1, String... r2) {
    }

    @Override // com.bytedance.android.live.broadcast.api.IBroadcastService
    public void preInitStartLiveData(String... r1) {
    }

    @Override // com.bytedance.android.live.broadcast.api.IBroadcastService
    public void preInitStartLiveDataWithBundle(Bundle r1, Long r2, String... r3) {
    }

    @Override // com.bytedance.android.live.broadcast.api.IBroadcastService
    public void preInitStartLiveOnComponentCreate(Long r1, String... r2) {
    }

    @Override // com.bytedance.android.live.broadcast.api.IBroadcastService
    public Object provideToolbarBehavior(int r1, List<Object> r2) {
        return null;
    }

    @Override // com.bytedance.android.live.broadcast.api.IBroadcastService
    public void putInteractToolsMobInfo(String r1, a00.a r2) {
    }

    @Override // com.bytedance.android.live.broadcast.api.IBroadcastService
    public void recordLiveStart() {
    }

    @Override // com.bytedance.android.live.broadcast.api.IBroadcastService
    public void recordPublishSuccess() {
    }

    @Override // com.bytedance.android.live.broadcast.api.IBroadcastService
    public void recyclerPreviewBitmap() {
    }

    @Override // com.bytedance.android.live.broadcast.api.IBroadcastService
    public void registerScopeService() {
    }

    @Override // com.bytedance.android.live.broadcast.api.IMiddlewareBroadcastService
    public void releaseCastService() {
    }

    @Override // com.bytedance.android.live.broadcast.api.IBroadcastService
    public void removeInteractToolsMobInfo(String r1) {
    }

    @Override // com.bytedance.android.live.broadcast.api.IBroadcastService
    public void removeToolbarComponent(int r1) {
    }

    @Override // com.bytedance.android.live.broadcast.api.IBroadcastService
    public void reply(String r1, int r2, int r3, boolean r4, long r5, long r7, int r9, String r11, String r12, pc0.b r13) {
    }

    @Override // com.bytedance.android.live.broadcast.api.IBroadcastService
    public Observable<Response<Object>> reportRoomEvent(int r1, long r2, int r4, String r5) {
        return null;
    }

    @Override // com.bytedance.android.live.broadcast.api.IBroadcastService
    public void resetHeap(LiveMode r1, Context r2) {
    }

    @Override // com.bytedance.android.live.broadcast.api.IBroadcastService
    public void restoreVideoRecordActivity(Context r1) {
    }

    @Override // com.bytedance.android.live.broadcast.api.IMiddlewareBroadcastService
    public void resumeCast(Integer r1) {
    }

    @Override // com.bytedance.android.live.broadcast.api.IBroadcastService
    public void savePerfKeva(JSONObject r1) {
    }

    @Override // com.bytedance.android.live.broadcast.api.IBroadcastService
    public void setMetadata(String r1, String r2, Map<String, String> r3) {
    }

    @Override // com.bytedance.android.live.broadcast.api.IBroadcastService
    public void setOnInvitedListener(mc0.a r1) {
    }

    @Override // com.bytedance.android.live.broadcast.api.IBroadcastService
    public boolean shouldDefaultToLive() {
        return false;
    }

    @Override // com.bytedance.android.live.broadcast.api.IMiddlewareBroadcastService
    public boolean shouldShowGuidePromptBubble(int r1) {
        return false;
    }

    @Override // com.bytedance.android.live.broadcast.api.IBroadcastService
    public void showAddAnchorShowDialog(Context r1, int r2, int r3, m00.b r4) {
    }

    @Override // com.bytedance.android.live.broadcast.api.IBroadcastService
    public void showAnchorManagerInputDialog(Context r1, int r2, String r3, m00.a r4) {
    }

    @Override // com.bytedance.android.live.broadcast.api.IBroadcastService
    public boolean showInteractPluginCard(String r1) {
        return false;
    }

    @Override // com.bytedance.android.live.broadcast.api.IBroadcastService
    public void showLiveGameDiscoveryDialog(Context r1, Bundle r2) {
    }

    @Override // com.bytedance.android.live.broadcast.api.IBroadcastService
    public boolean showMultiCameraConnectionPanel(Context r1, DataCenter r2, Map<String, String> r3) {
        return false;
    }

    public void showRestartBroadcastConfirmDialog(Context r1) {
    }

    @Override // com.bytedance.android.live.broadcast.api.IBroadcastService
    public void startBrowse(String r1) {
    }

    @Override // com.bytedance.android.live.broadcast.api.IMiddlewareBroadcastService
    public boolean startCast(t r1) {
        return false;
    }

    public void startContinueBroadcastActivity(Activity r1, String r2, nz.e r3) {
    }

    @Override // com.bytedance.android.live.broadcast.api.IBroadcastService
    public IStartLiveManager startLiveManager() {
        return null;
    }

    @Override // com.bytedance.android.live.broadcast.api.IBroadcastService
    public boolean startLynxPlugin(s0 r1) {
        return false;
    }

    public void startMultiProcessContinueBroadcastActivity(Activity r1, String r2) {
    }

    @Override // com.bytedance.android.live.broadcast.api.IBroadcastService
    public void startWirelessBrowse(String r1, String r2) {
    }

    @Override // com.bytedance.android.live.broadcast.api.IBroadcastService
    public void startWirelessMirror(HashMap<String, Object> r1, String r2) {
    }

    @Override // com.bytedance.android.live.broadcast.api.IBroadcastService
    public void stopBrowse(String r1) {
    }

    @Override // com.bytedance.android.live.broadcast.api.IBroadcastService
    public void stopBrowseMirror() {
    }

    @Override // com.bytedance.android.live.broadcast.api.IMiddlewareBroadcastService
    public void stopCast(Integer r1) {
    }

    @Override // com.bytedance.android.live.broadcast.api.IMiddlewareBroadcastService
    public void stopCast(Integer r1, String r2) {
    }

    @Override // com.bytedance.android.live.broadcast.api.IBroadcastService
    public void stopCastWithDialog(Context r1, String r2) {
    }

    @Override // com.bytedance.android.live.broadcast.api.IBroadcastService
    public void stopPoll(String r1) {
    }

    @Override // com.bytedance.android.live.broadcast.api.IBroadcastService
    public void stopWirelessMirror(String r1) {
    }

    @Override // com.bytedance.android.live.broadcast.api.IBroadcastService
    public void traceLandingSwitch(String r1) {
    }

    @Override // com.bytedance.android.live.broadcast.api.IBroadcastService
    public void tryInitBrowseCastService(pz.a r1) {
    }

    @Override // com.bytedance.android.live.broadcast.api.IBroadcastService
    public void tryInitCastService(Intent r1, pz.a r2) {
    }

    @Override // com.bytedance.android.live.broadcast.api.IBroadcastService
    public void tryInitWiredCastService(Intent r1, pz.a r2) {
    }

    @Override // com.bytedance.android.live.broadcast.api.IBroadcastService
    public void tryInitWirelessCastService(pz.a r1) {
    }

    @Override // com.bytedance.android.live.broadcast.api.IBroadcastService
    public Observable<Integer> updateBroadcastRoomHashTag(LiveBroadcastHashTagUpdateParams r1) {
        return null;
    }

    @Override // com.bytedance.android.live.broadcast.api.IMiddlewareBroadcastService
    public void updateCastSize(String r1, float r2, float r3, float r4, float r5, int r6, int r7) {
    }

    @Override // com.bytedance.android.live.broadcast.api.IBroadcastService
    public Observable<String> updateForenoticeInfo(ScheduledSettingInfo r1) {
        return null;
    }

    @Override // com.bytedance.android.live.broadcast.api.IBroadcastService
    public void updateGameMsgViewUserCount(Long r1) {
    }

    @Override // com.bytedance.android.live.broadcast.api.IBroadcastService
    public boolean updateLynxPlugin(s0 r1) {
        return false;
    }

    @Override // com.bytedance.android.live.broadcast.api.IMiddlewareBroadcastService
    public void updateOriginalStreamCastSize(float r1, float r2, float r3, float r4, int r5) {
    }

    @Override // com.bytedance.android.live.broadcast.api.IBroadcastService
    public List<String> getRunningInteractPluginIds() {
        return new ArrayList();
    }

    public BroadcastServiceDummy() {
        jc1.k.l(IBroadcastService.class, this);
    }

    @Override // com.bytedance.android.live.broadcast.api.IBroadcastService
    public Set<String> getRunningInteractPlugins() {
        return Collections.emptySet();
    }

    @Override // com.bytedance.android.live.broadcast.api.IMiddlewareBroadcastService
    public /* bridge */ /* synthetic */ u linkEffectHelper() {
        linkEffectHelper();
        return null;
    }

    @Override // com.bytedance.android.live.broadcast.api.IBroadcastService
    public LiveMode getPreviewLiveMode() {
        return LiveMode.UNDEFINED;
    }
}
