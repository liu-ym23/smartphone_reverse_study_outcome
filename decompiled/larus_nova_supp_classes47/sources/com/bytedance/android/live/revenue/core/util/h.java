package com.bytedance.android.live.revenue.core.util;

import com.bytedance.android.scope.m;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.ugc.aweme.debug.LocalTestManager;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class h {
    public static volatile boolean a;

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a() throws ClassNotFoundException {
        ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r2 = Class.forName("com.bytedance.android.live.revenue.RevenueInitializer");     // Catch: Throwable -> L8
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("com.bytedance.android.live.revenue.RevenueInitializer");     // Catch: Throwable -> L8
    L7:
        return r2;
    L8:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("com.bytedance.android.live.revenue.RevenueInitializer");
    L12:
        throw th;
    L34:
        Class<?> r3 = Class.forName("com.bytedance.android.live.revenue.RevenueInitializer");     // Catch: Throwable -> L17
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("com.bytedance.android.live.revenue.RevenueInitializer");     // Catch: Throwable -> L17
    L16:
        return r3;
    L17:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("com.bytedance.android.live.revenue.RevenueInitializer");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("com.bytedance.android.live.revenue.RevenueInitializer");
    }

    public static void c() {
        if (a == false) goto L11;
        return;
    L11:
        Class r2 = a();     // Catch: Throwable -> L8
        r2.getDeclaredMethod("ensureInitialized", new Class[0]).invoke(r2.getField("INSTANCE").get(null), new Object[0]);     // Catch: Throwable -> L8
    L9:
        a = true;
        return;
    L8:
        LocalTestManager.a(new Class[]{wy.a.class});
        goto L9
    }

    static {
    }

    public static dy0.c d(Class r2) {
        Intrinsics.checkNotNullParameter(r2, "serviceCls");
        c();
        m r0 = m.e;
        cy0.e.a.getClass();
        cy0.j r1 = cy0.e.a.a;
        dy0.c r3 = (dy0.c) r0.d(r1, r2);
        if (r3 == null) goto L5;
        return r3;
    L5:
        b.a(r2, r1);
        throw null;
    }

    public static dy0.c e(Class r2) {
        Intrinsics.checkNotNullParameter(r2, "serviceCls");
        c();
        m r0 = m.e;
        cy0.e.a.getClass();
        return (dy0.c) r0.d(cy0.e.a.a, r2);
    }

    public static dy0.d b(com.bytedance.android.live.revenue.core.b r1, Class r2) {
        Intrinsics.checkNotNullParameter(r2, "serviceCls");
        c();
        if (r1 != null) goto L7;
        return null;
    L7:
        return r1.getService(r2);
    }
}
