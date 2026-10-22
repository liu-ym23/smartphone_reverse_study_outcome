package com.obric.assistant.util;

import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.common.apphost.AppHost;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.larus.utils.logger.FLogger;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class j2 implements f09.a.b {
    public final /* synthetic */ OrionChatExtensionUtils a;

    public final void onAllActivityDestroyed() {
    }

    public final void onAppBackground() {
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a() throws ClassNotFoundException {
        ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r2 = Class.forName("com.larus.home.impl.MainActivity");     // Catch: Throwable -> L8
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("com.larus.home.impl.MainActivity");     // Catch: Throwable -> L8
    L7:
        return r2;
    L8:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("com.larus.home.impl.MainActivity");
    L12:
        throw th;
    L34:
        Class<?> r3 = Class.forName("com.larus.home.impl.MainActivity");     // Catch: Throwable -> L17
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("com.larus.home.impl.MainActivity");     // Catch: Throwable -> L17
    L16:
        return r3;
    L17:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("com.larus.home.impl.MainActivity");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("com.larus.home.impl.MainActivity");
    }

    public final void onAppForeground() {
        Class r0 = a();     // Catch: Exception -> L6
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type java.lang.Class<out android.app.Activity>");     // Catch: Exception -> L6
        if (AppHost.a.a().h(r0) == true) goto L11;
        OrionChatExtensionUtils.l(this.a);     // Catch: Exception -> L6
        return;
    L11:
        return;
    L6:
        e = move-exception;
        FLogger.a.e(this.a.a, "onAppForeground error", e);
    }

    public j2(OrionChatExtensionUtils r1) {
        this.a = r1;
    }
}
