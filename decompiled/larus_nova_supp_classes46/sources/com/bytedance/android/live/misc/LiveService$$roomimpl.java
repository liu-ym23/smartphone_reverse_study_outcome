package com.bytedance.android.live.misc;

import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.SafetyGuard;
import com.bytedance.android.live.profile.api.service.ILiveProfileProxyService;
import com.bytedance.android.live.room.api.IAudienceRankService;
import com.bytedance.android.live.room.api.IDiscoveryService;
import com.bytedance.android.live.room.api.ILiveExperienceProxyService;
import com.bytedance.android.live.room.api.ILiveShareService;
import com.bytedance.android.live.room.api.IReportService;
import com.bytedance.android.live.room.api.ISoundCardService;
import com.bytedance.android.live.room.api.IVisibilityControlBrickService;
import com.bytedance.android.live.room.api.IVisibilityControlService;
import com.bytedance.android.live.room.api.draggablecomponent.IDraggableComponentService;
import com.bytedance.android.live.room.api.login.ILoginGuideService;
import com.bytedance.android.live.room.api.messagewindow.service.dependenceproxy.IMsgWindowProxyService;
import com.bytedance.android.live.room.api.panel.IPanelService;
import com.bytedance.android.live.room.api.report.IMiddlewareReportService;
import com.bytedance.android.live.room.api.screenrotation.api.IScreenRotateService;
import com.bytedance.android.live.room.api.share.ILiveMiddlewareShareService;
import com.bytedance.android.live.room.api.userinfo.INavigationProxyService;
import com.bytedance.android.livesdk.experience.service.IExperienceProjectModeService;
import com.bytedance.android.livesdk.toolbarservice.api.IToolbarPlatformService;
import com.bytedance.android.livesdkapi.util.JavaCalls;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.ugc.aweme.debug.LocalTestManager;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public class LiveService$$roomimpl {
    private static final String CLASS_AudienceRankService = "com.bytedance.android.live.room.AudienceRankService";
    private static final String CLASS_DiscoveryService = "com.bytedance.android.live.room.discovery.DiscoveryService";
    private static final String CLASS_DraggableComponentService = "com.bytedance.android.live.draggablecomponent.DraggableComponentService";
    private static final String CLASS_ExperienceBusinessSv = "com.bytedance.android.live.LiveExperienceProxyService";
    private static final String CLASS_LoginGuideService = "com.bytedance.android.live.login.LoginGuideService";
    private static final String CLASS_MsgWindowProxyService = "com.bytedance.android.live.MsgWindowProxyService";
    private static final String CLASS_NavigationProxyService = "com.bytedance.android.live.NavigationProxyService";
    private static final String CLASS_PanelService = "com.bytedance.android.live.panel.PanelService";
    private static final String CLASS_ProfileBusinessSv = "com.bytedance.android.live.service.LiveProfileProxyService";
    private static final String CLASS_ProjectModeSv = "com.bytedance.android.live.projectmode.ExperienceProjectModeService";
    private static final String CLASS_ReportService = "com.bytedance.android.live.room.report.ReportService";
    private static final String CLASS_ScreenRotateService = "com.bytedance.android.live.screenrotate.ScreenRotateService";
    private static final String CLASS_ShareService = "com.bytedance.android.live.room.share.LiveShareService";
    private static final String CLASS_SoundCardService = "com.bytedance.android.live.room.discovery.SoundCardService";
    private static final String CLASS_ToolbarBusinessService = "com.bytedance.android.live.service.ToolbarPlatformService";
    private static final String CLASS_VisibilityControlBrickService = "com.bytedance.android.live.room.VisibilityControlBrickService";
    private static final String CLASS_VisibilityControlService = "com.bytedance.android.live.room.VisibilityControlService";

    public LiveService$$roomimpl() {
    }

    public static /* synthetic */ Class access$000(String r0) throws ClassNotFoundException {
        return Class.forName(r0);
    }

    public static void registerP0Service() {
    }

    public static void registerP1Service() {
        safeRegister(IDiscoveryService.class, (IDiscoveryService) safeNewEmptyInstance(CLASS_DiscoveryService));
        safeRegister(IDraggableComponentService.class, (IDraggableComponentService) safeNewEmptyInstance(CLASS_DraggableComponentService));
        safeRegister(IAudienceRankService.class, (IAudienceRankService) safeNewEmptyInstance(CLASS_AudienceRankService));
        safeRegister(IVisibilityControlService.class, (IVisibilityControlService) safeNewEmptyInstance(CLASS_VisibilityControlService));
        safeRegister(IVisibilityControlBrickService.class, (IVisibilityControlBrickService) safeNewEmptyInstance(CLASS_VisibilityControlBrickService));
        safeRegister(IScreenRotateService.class, (IScreenRotateService) safeNewEmptyInstance(CLASS_ScreenRotateService));
        safeRegister(ILoginGuideService.class, (ILoginGuideService) safeNewEmptyInstance(CLASS_LoginGuideService));
        safeRegister(IToolbarPlatformService.class, (IToolbarPlatformService) safeNewEmptyInstance(CLASS_ToolbarBusinessService));
        safeRegister(ILiveProfileProxyService.class, (ILiveProfileProxyService) safeNewEmptyInstance(CLASS_ProfileBusinessSv));
        safeRegister(ILiveExperienceProxyService.class, (ILiveExperienceProxyService) safeNewEmptyInstance(CLASS_ExperienceBusinessSv));
        safeRegister(IExperienceProjectModeService.class, (IExperienceProjectModeService) safeNewEmptyInstance(CLASS_ProjectModeSv));
        safeRegister(IMsgWindowProxyService.class, (IMsgWindowProxyService) safeNewEmptyInstance(CLASS_MsgWindowProxyService));
        safeRegister(INavigationProxyService.class, (INavigationProxyService) safeNewEmptyInstance(CLASS_NavigationProxyService));
    }

    public static void registerP2Service() {
        safeRegister(IReportService.class, (IReportService) safeNewEmptyInstance(CLASS_ReportService));
        safeRegister(IMiddlewareReportService.class, (IMiddlewareReportService) safeNewEmptyInstance(CLASS_ReportService));
        safeRegister(ILiveShareService.class, (ILiveShareService) safeNewEmptyInstance(CLASS_ShareService));
        safeRegister(ILiveMiddlewareShareService.class, (ILiveMiddlewareShareService) safeNewEmptyInstance(CLASS_ShareService));
        safeRegister(IPanelService.class, (IPanelService) safeNewEmptyInstance(CLASS_PanelService));
    }

    public static void registerService() {
        safeRegister(IDiscoveryService.class, (IDiscoveryService) safeNewEmptyInstance(CLASS_DiscoveryService));
        safeRegister(IReportService.class, (IReportService) safeNewEmptyInstance(CLASS_ReportService));
        safeRegister(IMiddlewareReportService.class, (IMiddlewareReportService) safeNewEmptyInstance(CLASS_ReportService));
        safeRegister(ILiveShareService.class, (ILiveShareService) safeNewEmptyInstance(CLASS_ShareService));
        safeRegister(ILiveMiddlewareShareService.class, (ILiveMiddlewareShareService) safeNewEmptyInstance(CLASS_ShareService));
        safeRegister(IVisibilityControlService.class, (IVisibilityControlService) safeNewEmptyInstance(CLASS_VisibilityControlService));
        safeRegister(IVisibilityControlBrickService.class, (IVisibilityControlBrickService) safeNewEmptyInstance(CLASS_VisibilityControlBrickService));
        safeRegister(IDraggableComponentService.class, (IDraggableComponentService) safeNewEmptyInstance(CLASS_DraggableComponentService));
        safeRegister(IAudienceRankService.class, (IAudienceRankService) safeNewEmptyInstance(CLASS_AudienceRankService));
        safeRegister(IScreenRotateService.class, (IScreenRotateService) safeNewEmptyInstance(CLASS_ScreenRotateService));
        safeRegister(ILoginGuideService.class, (ILoginGuideService) safeNewEmptyInstance(CLASS_LoginGuideService));
        safeRegister(IToolbarPlatformService.class, (IToolbarPlatformService) safeNewEmptyInstance(CLASS_ToolbarBusinessService));
        safeRegister(ILiveProfileProxyService.class, (ILiveProfileProxyService) safeNewEmptyInstance(CLASS_ProfileBusinessSv));
        safeRegister(ILiveExperienceProxyService.class, (ILiveExperienceProxyService) safeNewEmptyInstance(CLASS_ExperienceBusinessSv));
        safeRegister(IExperienceProjectModeService.class, (IExperienceProjectModeService) safeNewEmptyInstance(CLASS_ProjectModeSv));
        safeRegister(IPanelService.class, (IPanelService) safeNewEmptyInstance(CLASS_PanelService));
        safeRegister(ISoundCardService.class, (ISoundCardService) safeNewEmptyInstance(CLASS_SoundCardService));
        safeRegister(IMsgWindowProxyService.class, (IMsgWindowProxyService) safeNewEmptyInstance(CLASS_MsgWindowProxyService));
        safeRegister(INavigationProxyService.class, (INavigationProxyService) safeNewEmptyInstance(CLASS_NavigationProxyService));
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_bytedance_android_live_misc_LiveService$$roomimpl_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r3) throws ClassNotFoundException {
        ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class r2 = access$000(r3);     // Catch: Throwable -> L8
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r3);     // Catch: Throwable -> L8
    L7:
        return r2;
    L8:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r3);
    L12:
        throw th;
    L34:
        Class r4 = access$000(r3);     // Catch: Throwable -> L17
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r3);     // Catch: Throwable -> L17
    L16:
        return r4;
    L17:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r3);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r3);
    }

    private static <T> T safeNewEmptyInstance(String r3) {
        return (T) JavaCalls.newEmptyInstanceOrThrow(INVOKESTATIC_com_bytedance_android_live_misc_LiveService$$roomimpl_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(r3));
    L4:
        e = move-exception;
        handleComponentInitException("safeNewEmptyInstance " + r3, e);
        return null;
    }

    private static void handleComponentInitException(String r2, Exception r3) {
        if ((r3 instanceof InvocationTargetException) == false) goto L5;
        Throwable r0 = ((InvocationTargetException) r3).getTargetException();
    L6:
        ALogger.e("TTLiveSDKContext", r2, r0);
        SafetyGuard.a(null, r3, "[room-impl]-" + r2);
        LocalTestManager.a(new Class[]{wy.a.class});
        return;
    L5:
        r0 = r3;
        goto L6
    }

    private static <T extends IService> void safeRegister(Class<T> r0, T r1) {
        if (r1 == null) goto L5;
        jc1.k.l(r0, r1);
        return;
    }
}
