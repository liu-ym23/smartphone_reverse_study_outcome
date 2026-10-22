package com.ttnet.org.chromium.net.impl;

import android.content.Context;
import android.os.Build;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import el9.a;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class CronetLoggerFactory {
    private static final String CRONET_LOGGER_IMPL_CLASS = "com.google.net.cronet.telemetry.CronetLoggerImpl";
    private static final int SAMPLE_RATE_PER_SECOND = 1;
    private static final CronetLogger sDefaultLogger = null;
    private static CronetLogger sTestingLogger;

    private CronetLoggerFactory() {
    }

    static {
        sDefaultLogger = new NoOpLogger();
    }

    private static Class<? extends CronetLogger> fetchLoggerImplClass() {
        return INVOKEVIRTUAL_com_ttnet_org_chromium_net_impl_CronetLoggerFactory_com_larus_mirabridge_impl_lancet_MiraReflectLancet_loadClass(CronetLoggerFactory.class.getClassLoader(), CRONET_LOGGER_IMPL_CLASS).asSubclass(CronetLogger.class);
    L5:
        return null;
    }

    public static CronetLogger createNoOpLogger() {
        return sDefaultLogger;
    }

    public static /* synthetic */ void access$000(CronetLogger r0) {
        setLoggerForTesting(r0);
    }

    private static void setLoggerForTesting(CronetLogger r0) {
        sTestingLogger = r0;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKEVIRTUAL_com_ttnet_org_chromium_net_impl_CronetLoggerFactory_com_larus_mirabridge_impl_lancet_MiraReflectLancet_loadClass(ClassLoader r2, String r3) throws ClassNotFoundException {
        ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (a.a() == true) goto L34;
        Class<?> r4 = r2.loadClass(r3);     // Catch: Throwable -> L8
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r3);     // Catch: Throwable -> L8
    L7:
        return r4;
    L8:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r3);
    L12:
        throw th;
    L34:
        Class<?> r5 = r2.loadClass(r3);     // Catch: Throwable -> L17
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r3);     // Catch: Throwable -> L17
    L16:
        return r5;
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
        return MiraPluginFix.loadClass(r3);
    }

    public static CronetLogger createLogger(Context r3, CronetLogger.CronetSource r4) {
        CronetLogger r0 = sTestingLogger;
        if (r0 == null) goto L6;
        return r0;
    L6:
        if (CronetManifest.isAppOptedInForTelemetry(r3, r4) == false) goto L20;
        if (Build.VERSION.SDK_INT < 30) goto L20;
        Class<? extends CronetLogger> r5 = fetchLoggerImplClass();
        if (r5 != null) goto L21;
        return sDefaultLogger;
    L21:
        return r5.getConstructor(new Class[]{Integer.TYPE}).newInstance(new Object[]{1});
    L18:
        return sDefaultLogger;
    L20:
        return sDefaultLogger;
    }
}
