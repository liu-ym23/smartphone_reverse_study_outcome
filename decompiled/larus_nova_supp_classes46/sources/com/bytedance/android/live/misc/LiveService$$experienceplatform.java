package com.bytedance.android.live.misc;

import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.SafetyGuard;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.live.room.api.INavigationService;
import com.bytedance.android.live.room.api.messagewindow.service.ICardInnerService;
import com.bytedance.android.live.room.api.messagewindow.service.IMiddlewareMsgWindowService;
import com.bytedance.android.live.room.api.messagewindow.service.IMsgWindowService;
import com.bytedance.android.live.room.api.messagewindow.service.IPlatformCardService;
import com.bytedance.android.livesdkapi.util.JavaCalls;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public class LiveService$$experienceplatform {
    private static final String CLASS_CardInnerSv = "com.bytedance.android.live.messagewindow.framework.CardInnerService";
    private static final String CLASS_MsgWindowSv = "com.bytedance.android.live.messagewindow.MsgWindowService";
    private static final String CLASS_NavigationService = "com.bytedance.android.live.room.navi.NavigationService";
    private static final String CLASS_PlatformCardService = "com.bytedance.android.live.messagewindow.service.PlatformCardService";

    public LiveService$$experienceplatform() {
    }

    public static /* synthetic */ Class access$000(String r0) throws ClassNotFoundException {
        return Class.forName(r0);
    }

    public static void registerP0Service() {
    }

    public static void registerP2Service() {
    }

    public static void registerP1Service() {
        safeRegister(INavigationService.class, (INavigationService) safeNewEmptyInstance(CLASS_NavigationService));
        safeRegister(IMsgWindowService.class, (IMsgWindowService) safeNewEmptyInstance(CLASS_MsgWindowSv));
        safeRegister(IMiddlewareMsgWindowService.class, (IMiddlewareMsgWindowService) safeNewEmptyInstance(CLASS_MsgWindowSv));
        safeRegister(IPlatformCardService.class, (IPlatformCardService) safeNewEmptyInstance(CLASS_PlatformCardService));
        safeRegister(ICardInnerService.class, (ICardInnerService) safeNewEmptyInstance(CLASS_CardInnerSv));
    }

    public static void registerService() {
        safeRegister(INavigationService.class, (INavigationService) safeNewEmptyInstance(CLASS_NavigationService));
        safeRegister(IMsgWindowService.class, (IMsgWindowService) safeNewEmptyInstance(CLASS_MsgWindowSv));
        safeRegister(IMiddlewareMsgWindowService.class, (IMiddlewareMsgWindowService) safeNewEmptyInstance(CLASS_MsgWindowSv));
        safeRegister(IPlatformCardService.class, (IPlatformCardService) safeNewEmptyInstance(CLASS_PlatformCardService));
        safeRegister(ICardInnerService.class, (ICardInnerService) safeNewEmptyInstance(CLASS_CardInnerSv));
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_bytedance_android_live_misc_LiveService$$experienceplatform_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r3) throws ClassNotFoundException {
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
        return (T) JavaCalls.newEmptyInstanceOrThrow(INVOKESTATIC_com_bytedance_android_live_misc_LiveService$$experienceplatform_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(r3));
    L4:
        e = move-exception;
        handleComponentInitException("safeNewEmptyInstance " + r3, e);
        return null;
    }

    private static void handleComponentInitException(String r3, Exception r4) {
        if ((r4 instanceof InvocationTargetException) == false) goto L5;
        Throwable r0 = ((InvocationTargetException) r4).getTargetException();
    L6:
        ALogger.e("TTLiveSDKContext", r3, r0);
        SafetyGuard.a(null, r4, "[room-impl]-" + r3);
        if (v.a() == true) goto L10;
        return;
    L10:
        throw new RuntimeException(r0);
    L5:
        r0 = r4;
        goto L6
    }

    private static <T extends IService> void safeRegister(Class<T> r0, T r1) {
        if (r1 == null) goto L5;
        jc1.k.l(r0, r1);
        return;
    }
}
