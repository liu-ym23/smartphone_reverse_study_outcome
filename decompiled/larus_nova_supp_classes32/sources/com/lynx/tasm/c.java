package com.lynx.tasm;

import android.os.SystemClock;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.lynx.jsbridge.CallbackImpl;
import com.lynx.jsbridge.LynxModuleFactory;
import com.lynx.tasm.behavior.XElementBehavior;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class c implements Runnable {
    public c() {
    }

    public static void b() {
        SystemClock.uptimeMillis();
        a(d8a.b.class.getName());     // Catch: Throwable -> L11
        a(com.lynx.tasm.behavior.utils.d.class.getName());     // Catch: Throwable -> L11
        a(com.lynx.tasm.behavior.d.class.getName());     // Catch: Throwable -> L11
        a(com.lynx.tasm.behavior.a.class.getName());     // Catch: Throwable -> L11
        a(LynxModuleFactory.class.getName());     // Catch: Throwable -> L11
        a(CallbackImpl.class.getName());     // Catch: Throwable -> L11
        a(z.class.getName());     // Catch: Throwable -> L11
        a(j7a.a.class.getName());     // Catch: Throwable -> L11
        a(com.lynx.jsbridge.f.class.getName());     // Catch: Throwable -> L11
        a(XElementBehavior.class.getName());     // Catch: Throwable -> L11
        Iterator<String> r0 = XElementBehavior.GENERATOR_FILE_NAME_SETS.iterator();     // Catch: Throwable -> L11
    L5:
        if (r0.hasNext() == false) goto L9;
        e.a(r0.next() + ".BehaviorGenerator");     // Catch: Throwable -> L14
        goto L5
    L9:
        SystemClock.uptimeMillis();     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        th.printStackTrace();
    }

    @Override // java.lang.Runnable
    public final void run() {
        b();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static void a(String r3) throws ClassNotFoundException {
        ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class.forName(r3);     // Catch: Throwable -> L8
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L36;
        FastClassNotFoundHandler.a(r3);     // Catch: Throwable -> L8
        return;
    L36:
        return;
    L8:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r3);
    L12:
        throw th;
    L34:
        Class.forName(r3);     // Catch: Throwable -> L17
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L37;
        FastClassNotFoundHandler.a(r3);     // Catch: Throwable -> L17
        return;
    L37:
        return;
    L17:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r3);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == false) goto L26;
    L29:
        MiraPluginFix.forName(r3);
        return;
    L26:
        if ((th instanceof NoClassDefFoundError) == true) goto L29;
        throw th;
    }
}
