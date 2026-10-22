package com.ss.android.ugc.aweme.framework.services.plugin;

import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.agilelogger.ALog;
import el9.a;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.TypeCastException;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0004H\u0002J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/ss/android/ugc/aweme/framework/services/plugin/PluginInstaller;", "", "()V", "GEN_CLASS_NAME", "", "TAG", "logD", "", "msg", "onPluginInstall", "", "pluginPackageName", "spi_release"}, k = 1, mv = {1, 1, 15})
public final class PluginInstaller {
    private static final String GEN_CLASS_NAME = "SpiPluginBinder";
    public static final PluginInstaller INSTANCE = null;
    private static final String TAG = "SPIPluginInstaller";

    private PluginInstaller() {
    }

    public static /* synthetic */ Class access$000(String r0) throws ClassNotFoundException {
        return Class.forName(r0);
    }

    static {
        INSTANCE = new PluginInstaller();
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_ss_android_ugc_aweme_framework_services_plugin_PluginInstaller_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r3) throws ClassNotFoundException {
        ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (a.a() == true) goto L34;
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

    private final void logD(String r2) {
        ALog.d(TAG, r2);
    }

    public final boolean onPluginInstall(String r4) {
        Class r1 = INVOKESTATIC_com_ss_android_ugc_aweme_framework_services_plugin_PluginInstaller_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(r4 + ".SpiPluginBinder");     // Catch: Throwable -> L12
        if (r1 == null) goto L10;
        Object r2 = r1.newInstance();     // Catch: Throwable -> L12
        if (r2 == null) goto L9;
        ((IPluginBinder) r2).bindPluginSpi();     // Catch: Throwable -> L12
        goto L10
    L9:
        throw new TypeCastException("null cannot be cast to non-null type com.ss.android.ugc.aweme.framework.services.plugin.IPluginBinder");     // Catch: Throwable -> L12
    L10:
        logD("Install service for " + r4 + " success");
        return true;
    L12:
        th = move-exception;
        th.printStackTrace();
        logD("Install service for " + r4 + " failed with " + th + " \n classLoader -> " + PluginInstaller.class.getClassLoader());
        return false;
    }
}
