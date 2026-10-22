package com.bytedance.android.live.misc;

import com.bytedance.android.live.i18n.I18nService;
import com.bytedance.android.live.lottie.ILottieService;
import com.bytedance.android.live.room.IExternalFunctionInjector;
import com.bytedance.android.live.room.IHighlightAnnouncementService;
import com.bytedance.android.live.room.ILiveSDKService;
import com.bytedance.android.live.room.IMicRoomService;
import com.bytedance.android.live.room.IRoomService;
import com.bytedance.android.live.room.IRoomUserInfoService;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livehostapi.business.depend.livead.ILiveAdService;
import com.bytedance.android.livehostapi.business.depend.livead.ILiveMiniAppService;
import com.bytedance.android.livehostapi.business.depend.locallife.ILiveLocalLifeService;
import com.bytedance.android.livesdk.announcement.AnnouncementServiceImpl;
import com.bytedance.android.livesdk.browse.LiveBrowserService;
import com.bytedance.android.livesdk.chatroom.helper.LiveUserInterfaceTracer;
import com.bytedance.android.livesdk.chatroom.paidlive.PaidOuterService;
import com.bytedance.android.livesdk.dislike.LiveLongPressPanelService;
import com.bytedance.android.livesdk.explore.LiveExploreService;
import com.bytedance.android.livesdk.feedback.LiveFeedbackService;
import com.bytedance.android.livesdk.floatview.VideoFloatWindowOuterService;
import com.bytedance.android.livesdk.floatview.inner.InnerLiveFloatWindowOuterService;
import com.bytedance.android.livesdk.gamecp.GamecpDependService;
import com.bytedance.android.livesdk.jsbridge.JsMethodsProvideServiceImpl;
import com.bytedance.android.livesdk.lifecycle.LifeCycleService;
import com.bytedance.android.livesdk.livead.LiveAdServiceImpl;
import com.bytedance.android.livesdk.livead.LiveMiniAppService;
import com.bytedance.android.livesdk.locallife.LiveLocalLifeServiceImpl;
import com.bytedance.android.livesdk.lottie.LottieService;
import com.bytedance.android.livesdk.microom.MicRoomService;
import com.bytedance.android.livesdk.module.HighlightAnnouncementService;
import com.bytedance.android.livesdk.module.I18nServices;
import com.bytedance.android.livesdk.module.LiveSDKService;
import com.bytedance.android.livesdk.module.RoomService;
import com.bytedance.android.livesdk.module.UserService;
import com.bytedance.android.livesdk.network.predict.LiveNetworkPredict;
import com.bytedance.android.livesdk.performance.LiveCleanScreenManager;
import com.bytedance.android.livesdk.performance.LiveFloatWindowDegradeManager;
import com.bytedance.android.livesdk.performance.LiveHotRoomManager;
import com.bytedance.android.livesdk.performance.LivePerformanceManager;
import com.bytedance.android.livesdk.performance.LivePreviewPerformanceManager;
import com.bytedance.android.livesdk.performance.y;
import com.bytedance.android.livesdk.player.LiveCellularService;
import com.bytedance.android.livesdk.provideservices.RoomUserInfoService;
import com.bytedance.android.livesdk.room.service.ExternalFunctionInjectorService;
import com.bytedance.android.livesdk.schema.LiveActionHandlerImpl;
import com.bytedance.android.livesdk.schema.interfaces.ILiveActionHandler;
import com.bytedance.android.livesdk.service.LiveMiscService;
import com.bytedance.android.livesdk.vscore_api.paidlive.IPaidOuterService;
import com.bytedance.android.livesdkapi.ILiveLongPressPanelService;
import com.bytedance.android.livesdkapi.ILiveMiscService;
import com.bytedance.android.livesdkapi.announcement.IAnnouncementService;
import com.bytedance.android.livesdkapi.browse.ILiveBrowserService;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomService;
import com.bytedance.android.livesdkapi.explore.ILiveExploreService;
import com.bytedance.android.livesdkapi.feedback.ILiveFeedbackService;
import com.bytedance.android.livesdkapi.init.LiveInitAssistant;
import com.bytedance.android.livesdkapi.jsb.IJsMethodsProvideService;
import com.bytedance.android.livesdkapi.lifecycle.ILiveLifecycle;
import com.bytedance.android.livesdkapi.service.ICleanScreenManager;
import com.bytedance.android.livesdkapi.service.IFloatWindowDegradeManager;
import com.bytedance.android.livesdkapi.service.IHotRoomManager;
import com.bytedance.android.livesdkapi.service.IInnerLiveFloatWindowService;
import com.bytedance.android.livesdkapi.service.ILiveCellularService;
import com.bytedance.android.livesdkapi.service.ILiveNetworkPredict;
import com.bytedance.android.livesdkapi.service.ILiveOptManager;
import com.bytedance.android.livesdkapi.service.ILiveUxTracer;
import com.bytedance.android.livesdkapi.service.ILiveVideoFloatWindowService;
import com.bytedance.android.livesdkapi.service.IPerformanceEventKitService;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import com.bytedance.android.livesdkapi.service.IPreviewPerformanceManager;
import com.bytedance.android.livesdkapi.service.gamecp.IGamecpDependService;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public class LiveService$$livesdk {
    public LiveService$$livesdk() {
    }

    private static void internalRegisterService() {
        LiveInitAssistant r0 = LiveInitAssistant.INSTANCE;
        r0.markTimeStart("livesdk_service_init_duration");
        jc1.k.l(IRoomUserInfoService.class, new RoomUserInfoService());
        jc1.k.l(IExternalFunctionInjector.class, new ExternalFunctionInjectorService());
        jc1.k.l(IUserService.class, new UserService());
        jc1.k.l(ILiveLifecycle.class, new LifeCycleService());
        jc1.k.l(ILiveUxTracer.class, new LiveUserInterfaceTracer());
        jc1.k.l(ILiveVideoFloatWindowService.class, new VideoFloatWindowOuterService());
        jc1.k.l(IInnerLiveFloatWindowService.class, new InnerLiveFloatWindowOuterService());
        jc1.k.l(ILiveMiscService.class, new LiveMiscService());
        jc1.k.l(IAnnouncementService.class, new AnnouncementServiceImpl());
        jc1.k.l(ILiveAdService.class, new LiveAdServiceImpl());
        jc1.k.l(ILiveLocalLifeService.class, new LiveLocalLifeServiceImpl());
        jc1.k.l(ILiveMiniAppService.class, new LiveMiniAppService());
        RoomService r2 = new RoomService();
        jc1.k.l(IRoomService.class, r2);
        jc1.k.l(ILiveRoomService.class, r2);
        jc1.k.l(ILiveSDKService.class, new LiveSDKService());
        jc1.k.l(I18nService.class, new I18nServices());
        jc1.k.l(IMicRoomService.class, new MicRoomService());
        jc1.k.l(IPaidOuterService.class, new PaidOuterService());
        if (r0.getInitOptimizeConfig().getPreInitLiveOptV2() == false) goto L5;
        jc1.k.k(ILiveActionHandler.class, new j());
    L6:
        jc1.k.l(ILottieService.class, new LottieService());
        jc1.k.l(IPerformanceManager.class, new LivePerformanceManager());
        jc1.k.l(ICleanScreenManager.class, new LiveCleanScreenManager());
        jc1.k.l(IFloatWindowDegradeManager.class, new LiveFloatWindowDegradeManager());
        jc1.k.l(IPreviewPerformanceManager.class, new LivePreviewPerformanceManager());
        jc1.k.l(IHotRoomManager.class, new LiveHotRoomManager());
        jc1.k.l(IJsMethodsProvideService.class, new JsMethodsProvideServiceImpl());
        jc1.k.l(ILiveExploreService.class, new LiveExploreService());
        jc1.k.l(ILiveFeedbackService.class, new LiveFeedbackService());
        jc1.k.l(ILiveLongPressPanelService.class, new LiveLongPressPanelService());
        jc1.k.l(IHighlightAnnouncementService.class, new HighlightAnnouncementService());
        jc1.k.l(IGamecpDependService.class, new GamecpDependService());
        jc1.k.l(ILiveCellularService.class, new LiveCellularService());
        jc1.k.l(ILiveNetworkPredict.class, new LiveNetworkPredict());
        jc1.k.l(IPerformanceEventKitService.class, new com.bytedance.android.livesdk.performance.event.d());
        jc1.k.l(ILiveOptManager.class, new y());
        if (r0.optimizeConfig().getLiveRegisterServiceOpt() == false) goto L9;
        jc1.k.k(ILiveBrowserService.class, new k());
    L10:
        r0.markTimeEnd("livesdk_service_init_duration");
        return;
    L9:
        jc1.k.l(ILiveBrowserService.class, new LiveBrowserService());
        goto L10
    L5:
        jc1.k.l(ILiveActionHandler.class, new LiveActionHandlerImpl());
        goto L6
    }

    public static void registerP0Service() {
        jc1.k.l(IExternalFunctionInjector.class, new ExternalFunctionInjectorService());
        jc1.k.l(IUserService.class, new UserService());
        jc1.k.l(ILiveLifecycle.class, new LifeCycleService());
        jc1.k.l(ILiveUxTracer.class, new LiveUserInterfaceTracer());
        jc1.k.l(ILiveVideoFloatWindowService.class, new VideoFloatWindowOuterService());
        jc1.k.l(IInnerLiveFloatWindowService.class, new InnerLiveFloatWindowOuterService());
        jc1.k.l(ILiveMiscService.class, new LiveMiscService());
        jc1.k.l(IAnnouncementService.class, new AnnouncementServiceImpl());
        jc1.k.l(ILiveAdService.class, new LiveAdServiceImpl());
        RoomService r0 = new RoomService();
        jc1.k.l(IRoomService.class, r0);
        jc1.k.l(ILiveRoomService.class, r0);
        jc1.k.l(ILiveSDKService.class, new LiveSDKService());
        jc1.k.l(ILiveActionHandler.class, new LiveActionHandlerImpl());
        jc1.k.l(IPerformanceManager.class, new LivePerformanceManager());
        jc1.k.l(ICleanScreenManager.class, new LiveCleanScreenManager());
        jc1.k.l(IFloatWindowDegradeManager.class, new LiveFloatWindowDegradeManager());
        jc1.k.l(IPreviewPerformanceManager.class, new LivePreviewPerformanceManager());
        jc1.k.l(IHotRoomManager.class, new LiveHotRoomManager());
        jc1.k.l(IJsMethodsProvideService.class, new JsMethodsProvideServiceImpl());
        jc1.k.l(ILiveExploreService.class, new LiveExploreService());
        jc1.k.l(ILiveFeedbackService.class, new LiveFeedbackService());
        jc1.k.l(ILiveLongPressPanelService.class, new LiveLongPressPanelService());
        jc1.k.l(IGamecpDependService.class, new GamecpDependService());
        jc1.k.l(ILiveCellularService.class, new LiveCellularService());
        jc1.k.l(ILiveNetworkPredict.class, new LiveNetworkPredict());
        jc1.k.l(IPerformanceEventKitService.class, new com.bytedance.android.livesdk.performance.event.d());
        if (LiveInitAssistant.INSTANCE.getInitConfigInner().isLiveInitArcOpt() == true) goto L6;
        LiveTask$$livesdk.registerTask();
        return;
    }

    public static void registerP1Service() {
        jc1.k.l(IRoomUserInfoService.class, new RoomUserInfoService());
        jc1.k.l(ILiveLocalLifeService.class, new LiveLocalLifeServiceImpl());
        jc1.k.l(ILiveMiniAppService.class, new LiveMiniAppService());
        jc1.k.l(IMicRoomService.class, new MicRoomService());
        jc1.k.l(ILottieService.class, new LottieService());
        jc1.k.l(ILiveBrowserService.class, new LiveBrowserService());
        jc1.k.l(IHighlightAnnouncementService.class, new HighlightAnnouncementService());
        jc1.k.l(ILiveOptManager.class, new y());
    }

    public static void registerP2Service() {
        jc1.k.l(I18nService.class, new I18nServices());
    }

    public static void registerService() {
        internalRegisterService();
        if (LiveInitAssistant.INSTANCE.getInitConfigInner().isLiveInitArcOpt() == true) goto L6;
        LiveTask$$livesdk.registerTask();
        return;
    }
}
