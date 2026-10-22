package com.lynx.animax.util;

import android.content.Context;
import android.content.res.Resources;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import el9.a;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;
import q4a.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class AnimaX {
    public static volatile AnimaX d;
    public volatile boolean a;
    public c b;
    public Context c;

    private native void nativeRegisterLogger(long r1);

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class b() throws ClassNotFoundException {
        ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (a.a() == true) goto L34;
        Class<?> r2 = Class.forName("com.ss.android.agilelogger.ALog");     // Catch: Throwable -> L8
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("com.ss.android.agilelogger.ALog");     // Catch: Throwable -> L8
    L7:
        return r2;
    L8:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("com.ss.android.agilelogger.ALog");
    L12:
        throw th;
    L34:
        Class<?> r3 = Class.forName("com.ss.android.agilelogger.ALog");     // Catch: Throwable -> L17
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("com.ss.android.agilelogger.ALog");     // Catch: Throwable -> L17
    L16:
        return r3;
    L17:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("com.ss.android.agilelogger.ALog");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("com.ss.android.agilelogger.ALog");
    }

    public static AnimaX e() {
        if (d != null) goto L15;
        monitor-enter(AnimaX.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (d != null) goto L9;
        d = new AnimaX();     // Catch: Throwable -> L11
    L9:
        monitor-exit(AnimaX.class);     // Catch: Throwable -> L11
    L15:
        return d;
    }

    public AnimaX() {
        this.a = false;
    }

    public static long c() {
        return ((Long) b().getMethod("getALogSimpleWriteFuncAddr", new Class[0]).invoke(null, new Object[0])).longValue();
    L4:
        e = move-exception;
        AnimaXLog.a("AnimaX", "No ALog found in the host [ " + e.getMessage() + " ]");
        return 0;
    }

    @JvmStatic
    public static void a(String r3) {
        Intrinsics.checkNotNullParameter(r3, "libName");
        FLogger r0 = FLogger.a;
        r0.i("Librarian_loadLib", "loadLibrary start libName -> ".concat(r3));
        com.bytedance.librarian.a.c(r3);
        r0.i("Librarian_loadLib", "loadLibrary success by librarian -> ".concat(r3));
    }

    public final void d(LynxAnimaX.a r3) {
        if (this.a == true) goto L29;
        monitor-enter(this);
    L22:
        th = move-exception;
        throw th;
    L6:
        if (this.a == false) goto L9;
        monitor-exit(this);
    L26:
        return;
    L9:
        this.b = r3;     // Catch: Throwable -> L22
        if (f("lynxbase") == true) goto L15;
        AnimaXLog.a("AnimaX", "AnimaX failed to load liblynxbase.so");     // Catch: Throwable -> L22
        monitor-exit(this);
        goto L26
    L15:
        if (f("animax") == true) goto L19;
        AnimaXLog.a("AnimaX", "AnimaX failed to load libanimax.so");     // Catch: Throwable -> L22
        monitor-exit(this);
        goto L26
    L19:
        f("animax_textra");     // Catch: Throwable -> L22
        f("animax_bytevc1");     // Catch: Throwable -> L22
        nativeRegisterLogger(c());     // Catch: Throwable -> L22
        this.a = true;     // Catch: Throwable -> L22
        monitor-exit(this);
        goto L26
    }

    public final boolean f(String r5) {
        c r2 = this.b;     // Catch: UnsatisfiedLinkError -> L9
        if (r2 == null) goto L6;
        ((LynxAnimaX.a) r2).a.loadLibrary(r5);     // Catch: UnsatisfiedLinkError -> L9
        AnimaXLog.b("AnimaX", "Native library load " + r5 + " success with native library loader");     // Catch: UnsatisfiedLinkError -> L9
        return true;
    L6:
        a(r5);     // Catch: UnsatisfiedLinkError -> L9
        AnimaXLog.b("AnimaX", "Native library load " + r5 + " success with System.loadLibrary");     // Catch: UnsatisfiedLinkError -> L9
        return true;
    L9:
        e = move-exception;
        if (this.b != null) goto L13;
        AnimaXLog.a("AnimaX", "Native library load " + r5 + " from system with error message " + e.getMessage());
        return false;
    L13:
        AnimaXLog.a("AnimaX", "Native Library load from " + this.b.getClass().getName() + " with error message " + e.getMessage());
        return false;
    }

    public final void g(Context r3) {
        if (this.c != null) goto L19;
        if (r3 == null) goto L20;
        this.c = r3;
        Context r4 = e().c;
        if (r4 == null) goto L8;
        Resources r5 = r4.getResources();
        float r6 = WindowDisplayMetricsOverride.apply(r5, r5.getDisplayMetrics()).density;
    L10:
        if (y4a.a.f == false) goto L12;
        return;
    L12:
        if (r6 < 2.0f) goto L14;
    L16:
        boolean r7 = false;
    L17:
        y4a.a.g = r7;
        y4a.a.f = true;
        return;
    L14:
        if (r6 <= 0.01f) goto L16;
        r7 = true;
        goto L17
    L8:
        AnimaXLog.a("AnimaX", "getDensity failed, context is null");
        r6 = 1.0f;
        goto L10
    L20:
        return;
    }
}
