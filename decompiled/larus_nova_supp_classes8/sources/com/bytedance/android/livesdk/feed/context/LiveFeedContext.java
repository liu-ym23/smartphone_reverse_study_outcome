package com.bytedance.android.livesdk.feed.context;

import android.content.Context;
import com.bytedance.android.live.core.InnerSDKCore;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.log.g;
import com.bytedance.android.live.core.setting.SettingUtil;
import com.bytedance.android.live.core.utils.m0;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.live.initialize.LiveWTO;
import com.bytedance.android.live.network.api.INetworkService;
import com.bytedance.android.live.network.impl.NetWorkService;
import com.bytedance.android.livehostapi.IHostService;
import com.bytedance.android.livehostapi.LiveSdkInitHelper;
import com.bytedance.android.livehostapi.foundation.IHostNetwork;
import com.bytedance.android.livesdk.log.b0;
import com.bytedance.android.livesdk.model.a1;
import com.bytedance.android.livesdkapi.init.LiveInitAssistant;
import com.bytedance.android.livesdkapi.init.LiveInitializeSettingConfig;
import com.bytedance.android.livesdkapi.util.JavaCalls;
import com.bytedance.android.tools.pbadapter.annotation.GenProtoDecoders;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import jc1.k;
import me.ele.lancet.base.annotations.Skip;
import nv1.b;
import nv1.c;
import nv1.d;
import nv1.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@GenProtoDecoders
public class LiveFeedContext {
    private static final String CLASS_NetworkService = "com.bytedance.android.live.network.impl.NetWorkService";
    private static volatile Context appContext;
    private static boolean hasInjected;
    private static volatile IHostService hostService;
    private static volatile boolean inited;
    private static volatile LiveFeedContext instance;
    private static m0<Locale> localeProxy;
    private static final Object lock = null;

    public static /* synthetic */ Class access$000(String r0) throws ClassNotFoundException {
        return Class.forName(r0);
    }

    public static void setLocaleObjectProxy(m0<Locale> r0) {
    }

    static {
        instance = new LiveFeedContext();
        lock = new Object();
    }

    public static Context appContext() {
        if (appContext != null) goto L6;
        Context r0 = hostService().appContext().context();
        appContext = r0;
        return r0;
    L6:
        return appContext;
    }

    public static void delayInit() {
        LiveWTO.INSTANCE.ensureTaskReady(29);
        if (LiveSdkInitHelper.isEnableFeedOpt() == false) goto L6;
        feedProtoInit();
        return;
    }

    public static void feedProtoInit() {
        Object r0 = lock;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (hasInjected == false) goto L8;
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L8:
        hasInjected = true;     // Catch: Throwable -> L11
        b0.o().getClass();     // Catch: Throwable -> L11
        g.i("ttlive_init", "feedProtoInit: run");     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
    }

    public static b getService() {
        return new e();
    }

    public static Locale currentLocale() {
        if (hostService() == null) goto L7;
        return hostService().appContext().currentLocale();
    L7:
        return Locale.getDefault();
    }

    private LiveFeedContext() {
    }

    public static IHostService hostService() {
        return hostService;
    }

    public static LiveFeedContext inst() {
        return instance;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_bytedance_android_livesdk_feed_context_LiveFeedContext_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r3) throws ClassNotFoundException {
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

    public static void init(IHostService r2) {
        if (r2 != null) goto L5;
        ALogger.e("LiveFeedContext_", "feedHostService init err feedHostService = null");
    L5:
        if (inited == false) goto L7;
        return;
    L7:
        monitor-enter(LiveFeedContext.class);
    L13:
        th = move-exception;
        throw th;
    L9:
        if (inited == true) goto L11;
        inited = true;     // Catch: Throwable -> L13
        hostService = new FeedHostServiceWrapper(r2);     // Catch: Throwable -> L13
        appContext = r2.appContext().context();     // Catch: Throwable -> L13
        initInternal(r2);     // Catch: Throwable -> L13
    L11:
        monitor-exit(LiveFeedContext.class);     // Catch: Throwable -> L13
    }

    private static void initInternal(IHostService r5) {
        b0.o().getClass();
        g.i("ttlive_init", "LiveFeedContext initInternal");
        LiveInitAssistant r0 = LiveInitAssistant.INSTANCE;
        LiveInitializeSettingConfig r1 = r0.optimizeConfig();
        new d();     // Catch: ClassNotFoundException -> L13
        if (r0.getInitConfigInner().isLiveInitArcOpt() == false) goto L9;
        if (k.h(INetworkService.class) == true) goto L26;
        new NetWorkService(r5.network());     // Catch: ClassNotFoundException -> L13
    L26:
    L16:
        if (LiveInitAssistant.INSTANCE.getInitOptimizeConfig().getPreInitLiveOptV2() == false) goto L18;
    L21:
        k.f(INetworkService.class).ensureFeedProtoInjected(new a());
    L22:
        InnerSDKCore.setLiveSDKCore(new c());
        if (v.a() == false) goto L29;
        SettingUtil.setLocalTest(true);
        return;
    L29:
        return;
    L18:
        if (LiveSdkInitHelper.isEnableFeedOpt() == true) goto L21;
        feedProtoInit();
        goto L22
    L9:
        if (r1.getPreInitLiveOptV2() == false) goto L11;
        new NetWorkService(r5.network());     // Catch: ClassNotFoundException -> L13
        goto L26
    L11:
        JavaCalls.newInstance(INVOKESTATIC_com_bytedance_android_livesdk_feed_context_LiveFeedContext_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(CLASS_NetworkService), new Object[]{new JavaCalls.JavaParam(IHostNetwork.class, r5.network())});     // Catch: ClassNotFoundException -> L13
    L13:
        e = move-exception;
        e.printStackTrace();
        kw1.b.o().getClass();
        g.c("ttlive_feed", "NetWorkService init fail");
        kw1.b r2 = kw1.b.o();
        StackTraceElement[] r6 = e.getStackTrace();
        r2.getClass();
        g.m(6, r6);
        goto L16
    }

    private static /* synthetic */ void lambda$delayInit$0(List r0) throws Exception {
        a1.a = true;
    }

    private static /* synthetic */ void lambda$delayInit$1(Throwable r1) throws Exception {
        ALogger.e("Tab Request", r1);
    }

    private static /* synthetic */ void lambda$initInternal$2(List r0) throws Exception {
        a1.a = true;
    }

    private static /* synthetic */ void lambda$initInternal$3(Throwable r1) throws Exception {
        ALogger.e("Drawer Tab Request", r1);
    }

    public static void setAppContext(Context r0) {
        appContext = r0;
    }
}
