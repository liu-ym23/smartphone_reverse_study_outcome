package com.bytedance.android.live.misc;

import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.SafetyGuard;
import com.bytedance.android.livesdk.interactivity.api.IAnchorAsrService;
import com.bytedance.android.livesdk.interactivity.api.IBarrageService;
import com.bytedance.android.livesdk.interactivity.api.IBaseDiggService;
import com.bytedance.android.livesdk.interactivity.api.ICommentService;
import com.bytedance.android.livesdk.interactivity.api.IDiggService;
import com.bytedance.android.livesdk.interactivity.api.IEnterAnimService;
import com.bytedance.android.livesdk.interactivity.api.IHighlightService;
import com.bytedance.android.livesdk.interactivity.api.IIMService;
import com.bytedance.android.livesdk.interactivity.api.IImageRecognitionService;
import com.bytedance.android.livesdk.interactivity.api.IInteractivityDegradeService;
import com.bytedance.android.livesdk.interactivity.api.IInteractivityInjectService;
import com.bytedance.android.livesdk.interactivity.api.IInteractivityPlatformService;
import com.bytedance.android.livesdk.interactivity.api.IInteractivityService;
import com.bytedance.android.livesdk.interactivity.api.IMultiCameraService;
import com.bytedance.android.livesdk.interactivity.api.INotifyService;
import com.bytedance.android.livesdk.interactivity.api.IPSTopContainerService;
import com.bytedance.android.livesdk.interactivity.api.IPinService;
import com.bytedance.android.livesdk.interactivity.api.IPublicScreenPluginService;
import com.bytedance.android.livesdk.interactivity.api.IPublicScreenService;
import com.bytedance.android.livesdk.interactivity.api.IQuickCommentService;
import com.bytedance.android.livesdk.interactivity.api.IRoomChannelService;
import com.bytedance.android.livesdk.interactivity.api.IRoomIntroService;
import com.bytedance.android.livesdk.interactivity.api.IRoomNoticeService;
import com.bytedance.android.livesdk.interactivity.api.ITextAudioService;
import com.bytedance.android.livesdk.interactivity.api.IVirtualInteractService;
import com.bytedance.android.livesdk.interactivity.service.textrender.inject.IFansClubMemberUser;
import com.bytedance.android.livesdk.interactivity.service.textrender.inject.IGiftImageGetter;
import com.bytedance.android.livesdk.vscore_api.IEpisodeInteractiveService;
import com.bytedance.android.livesdkapi.util.JavaCalls;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.ugc.aweme.debug.LocalTestManager;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public class LiveService$$interactivityimpl {
    private static final String CLASS_AnchorAsrService = "com.bytedance.android.livesdk.interactivity.api.AnchorAsrService";
    private static final String CLASS_BarrageService = "com.bytedance.android.livesdk.interactivity.api.BarrageService";
    private static final String CLASS_CommentService = "com.bytedance.android.livesdk.interactivity.api.CommentService";
    private static final String CLASS_DiggService = "com.bytedance.android.livesdk.interactivity.api.DiggService";
    private static final String CLASS_EnterAnimService = "com.bytedance.android.livesdk.interactivity.api.EnterAnimService";
    private static final String CLASS_EpisodeInteractiveService = "com.bytedance.android.livesdk.interactivity.api.EpisodeInteractiveService";
    private static final String CLASS_FansClubMemberUser = "com.bytedance.android.livesdk.interactivity.FansClubMemberUser";
    private static final String CLASS_GiftImageGetter = "com.bytedance.android.livesdk.interactivity.GiftImageGetter";
    private static final String CLASS_HighlightService = "com.bytedance.android.livesdk.interactivity.api.HighlightService";
    private static final String CLASS_IMService = "com.bytedance.android.livesdk.interactivity.api.IMService";
    private static final String CLASS_ImageRecognitionService = "com.bytedance.android.livesdk.interactivity.api.ImageRecognitionService";
    private static final String CLASS_InteractivityDegradeService = "com.bytedance.android.livesdk.interactivity.api.InteractivityDegradeService";
    private static final String CLASS_InteractivityInjectService = "com.bytedance.android.livesdk.interactivity.InteractivityInjectService";
    private static final String CLASS_InteractivityPlatformService = "com.bytedance.android.livesdk.interactivity.InteractivityPlatformService";
    private static final String CLASS_InteractivityService = "com.bytedance.android.livesdk.interactivity.InteractivityService";
    private static final String CLASS_MultiCameraService = "com.bytedance.android.livesdk.interactivity.api.MultiCameraService";
    private static final String CLASS_NotifyService = "com.bytedance.android.livesdk.interactivity.api.NotifyService";
    private static final String CLASS_PSTopContainerService = "com.bytedance.android.livesdk.interactivity.api.PSTopContainerService";
    private static final String CLASS_PinService = "com.bytedance.android.livesdk.interactivity.api.PinService";
    private static final String CLASS_PublicScreenPluginService = "com.bytedance.android.livesdk.interactivity.api.PublicScreenPluginService";
    private static final String CLASS_PublicScreenService = "com.bytedance.android.livesdk.interactivity.api.PublicScreenService";
    private static final String CLASS_QuickCommentService = "com.bytedance.android.livesdk.interactivity.api.QuickCommentService";
    private static final String CLASS_RoomChannelService = "com.bytedance.android.livesdk.interactivity.api.RoomChannelService";
    private static final String CLASS_RoomIntroService = "com.bytedance.android.livesdk.interactivity.api.RoomIntroService";
    private static final String CLASS_RoomNoticeService = "com.bytedance.android.livesdk.interactivity.api.RoomNoticeService";
    private static final String CLASS_TextAudioService = "com.bytedance.android.livesdk.interactivity.api.TextAudioService";
    private static final String CLASS_VirtualInteractService = "com.bytedance.android.livesdk.interactivity.api.VirtualInteractService";

    public LiveService$$interactivityimpl() {
    }

    public static /* synthetic */ Class access$000(String r0) throws ClassNotFoundException {
        return Class.forName(r0);
    }

    public static void postRegister() {
        int r0 = b.a;
        rb.a.call("modelx");
    }

    public static void registerP0Service() {
        safeRegister(IInteractivityService.class, (IInteractivityService) safeNewEmptyInstance(CLASS_InteractivityService));
        safeRegister(ITextAudioService.class, (ITextAudioService) safeNewEmptyInstance(CLASS_TextAudioService));
        safeRegister(IIMService.class, (IIMService) safeNewEmptyInstance(CLASS_IMService));
        safeRegister(IHighlightService.class, (IHighlightService) safeNewEmptyInstance(CLASS_HighlightService));
    }

    public static void registerP1Service() {
        safeRegister(IBarrageService.class, (IBarrageService) safeNewEmptyInstance(CLASS_BarrageService));
        safeRegister(ICommentService.class, (ICommentService) safeNewEmptyInstance(CLASS_CommentService));
        safeRegister(IEnterAnimService.class, (IEnterAnimService) safeNewEmptyInstance(CLASS_EnterAnimService));
        safeRegister(IDiggService.class, (IDiggService) safeNewEmptyInstance(CLASS_DiggService));
        safeRegister(IPinService.class, (IPinService) safeNewEmptyInstance(CLASS_PinService));
        safeRegister(IPublicScreenService.class, (IPublicScreenService) safeNewEmptyInstance(CLASS_PublicScreenService));
        safeRegister(IPublicScreenPluginService.class, (IPublicScreenPluginService) safeNewEmptyInstance(CLASS_PublicScreenPluginService));
        safeRegister(IQuickCommentService.class, (IQuickCommentService) safeNewEmptyInstance(CLASS_QuickCommentService));
        safeRegister(IPSTopContainerService.class, (IPSTopContainerService) safeNewEmptyInstance(CLASS_PSTopContainerService));
        safeRegister(IRoomNoticeService.class, (IRoomNoticeService) safeNewEmptyInstance(CLASS_RoomNoticeService));
        safeRegister(IEpisodeInteractiveService.class, (IEpisodeInteractiveService) safeNewEmptyInstance(CLASS_EpisodeInteractiveService));
        safeRegister(IInteractivityDegradeService.class, (IInteractivityDegradeService) safeNewEmptyInstance(CLASS_InteractivityDegradeService));
        safeRegister(IAnchorAsrService.class, (IAnchorAsrService) safeNewEmptyInstance(CLASS_AnchorAsrService));
        safeRegister(IImageRecognitionService.class, (IImageRecognitionService) safeNewEmptyInstance(CLASS_ImageRecognitionService));
    }

    public static void registerP2Service() {
        safeRegister(INotifyService.class, (INotifyService) safeNewEmptyInstance(CLASS_NotifyService));
        safeRegister(IRoomIntroService.class, (IRoomIntroService) safeNewEmptyInstance(CLASS_RoomIntroService));
        safeRegister(IRoomNoticeService.class, (IRoomNoticeService) safeNewEmptyInstance(CLASS_RoomNoticeService));
        safeRegister(IVirtualInteractService.class, (IVirtualInteractService) safeNewEmptyInstance(CLASS_VirtualInteractService));
        safeRegister(IMultiCameraService.class, (IMultiCameraService) safeNewEmptyInstance(CLASS_MultiCameraService));
    }

    public static void registerService() {
        safeRegister(IInteractivityService.class, (IInteractivityService) safeNewEmptyInstance(CLASS_InteractivityService));
        safeRegister(IMultiCameraService.class, (IMultiCameraService) safeNewEmptyInstance(CLASS_MultiCameraService));
        safeRegister(IInteractivityPlatformService.class, (IInteractivityPlatformService) safeNewEmptyInstance(CLASS_InteractivityPlatformService));
        safeRegister(IGiftImageGetter.class, (IGiftImageGetter) safeNewEmptyInstance(CLASS_GiftImageGetter));
        safeRegister(IFansClubMemberUser.class, (IFansClubMemberUser) safeNewEmptyInstance(CLASS_FansClubMemberUser));
        safeRegister(IBarrageService.class, (IBarrageService) safeNewEmptyInstance(CLASS_BarrageService));
        safeRegister(ICommentService.class, (ICommentService) safeNewEmptyInstance(CLASS_CommentService));
        safeRegister(IInteractivityInjectService.class, (IInteractivityInjectService) safeNewEmptyInstance(CLASS_InteractivityInjectService));
        safeRegister(IEnterAnimService.class, (IEnterAnimService) safeNewEmptyInstance(CLASS_EnterAnimService));
        safeRegister(IDiggService.class, (IDiggService) safeNewEmptyInstance(CLASS_DiggService));
        safeRegister(IBaseDiggService.class, (IBaseDiggService) safeNewEmptyInstance(CLASS_DiggService));
        safeRegister(INotifyService.class, (INotifyService) safeNewEmptyInstance(CLASS_NotifyService));
        safeRegister(IPinService.class, (IPinService) safeNewEmptyInstance(CLASS_PinService));
        safeRegister(IPublicScreenService.class, (IPublicScreenService) safeNewEmptyInstance(CLASS_PublicScreenService));
        safeRegister(IPublicScreenPluginService.class, (IPublicScreenPluginService) safeNewEmptyInstance(CLASS_PublicScreenPluginService));
        safeRegister(IQuickCommentService.class, (IQuickCommentService) safeNewEmptyInstance(CLASS_QuickCommentService));
        safeRegister(IPSTopContainerService.class, (IPSTopContainerService) safeNewEmptyInstance(CLASS_PSTopContainerService));
        safeRegister(IAnchorAsrService.class, (IAnchorAsrService) safeNewEmptyInstance(CLASS_AnchorAsrService));
        safeRegister(IImageRecognitionService.class, (IImageRecognitionService) safeNewEmptyInstance(CLASS_ImageRecognitionService));
        safeRegister(IRoomChannelService.class, (IRoomChannelService) safeNewEmptyInstance(CLASS_RoomChannelService));
        safeRegister(IRoomIntroService.class, (IRoomIntroService) safeNewEmptyInstance(CLASS_RoomIntroService));
        safeRegister(IRoomNoticeService.class, (IRoomNoticeService) safeNewEmptyInstance(CLASS_RoomNoticeService));
        safeRegister(ITextAudioService.class, (ITextAudioService) safeNewEmptyInstance(CLASS_TextAudioService));
        safeRegister(IIMService.class, (IIMService) safeNewEmptyInstance(CLASS_IMService));
        safeRegister(IEpisodeInteractiveService.class, (IEpisodeInteractiveService) safeNewEmptyInstance(CLASS_EpisodeInteractiveService));
        safeRegister(IHighlightService.class, (IHighlightService) safeNewEmptyInstance(CLASS_HighlightService));
        safeRegister(IVirtualInteractService.class, (IVirtualInteractService) safeNewEmptyInstance(CLASS_VirtualInteractService));
        safeRegister(IInteractivityDegradeService.class, (IInteractivityDegradeService) safeNewEmptyInstance(CLASS_InteractivityDegradeService));
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_bytedance_android_live_misc_LiveService$$interactivityimpl_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r3) throws ClassNotFoundException {
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
        return (T) JavaCalls.newEmptyInstanceOrThrow(INVOKESTATIC_com_bytedance_android_live_misc_LiveService$$interactivityimpl_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(r3));
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
        SafetyGuard.a(null, r3, "[interactivity-impl]-" + r2);
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
