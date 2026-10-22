package com.bytedance.android.btm.impl;

import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class BtmServiceImpl$b implements Runnable {
    public static final BtmServiceImpl$b a = null;

    static {
        a = new BtmServiceImpl$b();
    }

    public BtmServiceImpl$b() {
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a() throws ClassNotFoundException {
        ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r10 = Class.forName("com.bytedance.android.btm.debugtool.base.DebugToolInitializer");     // Catch: Throwable -> L8
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("com.bytedance.android.btm.debugtool.base.DebugToolInitializer");     // Catch: Throwable -> L8
    L7:
        return r10;
    L8:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("com.bytedance.android.btm.debugtool.base.DebugToolInitializer");
    L12:
        throw th;
    L34:
        Class<?> r11 = Class.forName("com.bytedance.android.btm.debugtool.base.DebugToolInitializer");     // Catch: Throwable -> L17
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("com.bytedance.android.btm.debugtool.base.DebugToolInitializer");     // Catch: Throwable -> L17
    L16:
        return r11;
    L17:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("com.bytedance.android.btm.debugtool.base.DebugToolInitializer");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("com.bytedance.android.btm.debugtool.base.DebugToolInitializer");
    }

    @Override // java.lang.Runnable
    public final void run() {
        Class r0 = a();     // Catch: Throwable -> L4
        Constructor r10 = r0.getDeclaredConstructor(new Class[0]);     // Catch: Throwable -> L4
        r10.setAccessible(true);     // Catch: Throwable -> L4
        Object r11 = r10.newInstance(new Object[0]);     // Catch: Throwable -> L4
        Method r1 = r0.getMethod("init", new Class[0]);     // Catch: Throwable -> L4
        r1.setAccessible(true);     // Catch: Throwable -> L4
        r1.invoke(r11, new Object[0]);     // Catch: Throwable -> L4
        return;
    }
}
