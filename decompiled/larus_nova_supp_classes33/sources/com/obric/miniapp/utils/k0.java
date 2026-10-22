package com.obric.miniapp.utils;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.PowerManager;
import com.bytedance.crash.Npth;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.larus.common.apphost.AppHost;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.larus.utils.logger.FLogger;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class k0 {
    public static volatile boolean a;
    public static volatile String b;
    public static DevicePowerManager$registerSleepModeReceiver$1 c;
    public static final Lazy d = null;
    public static final Set<b> e = null;
    public static final Set<a> f = null;

    public interface a {
        void a(boolean r1);
    }

    public interface b {
        void a(String r1);
    }

    public k0() {
    }

    static {
        a = true;
        d = LazyKt.lazy(new j0());
        e = new LinkedHashSet();
        f = new LinkedHashSet();
    }

    public static String e() {
        String r3 = b;
        if (r3 == null) goto L34;
        return r3;
    L34:
        AppHost.Companion r4 = AppHost.a;     // Catch: Exception -> L31
        Application r5 = r4.getApplication();     // Catch: Exception -> L31
        Object r6 = r5.getSystemService("power");     // Catch: Exception -> L31
        PowerManager r7 = null;
        if ((r6 instanceof PowerManager) == false) goto L8;
        PowerManager r8 = (PowerManager) r6;     // Catch: Exception -> L31
    L9:
        if (r8 != null) goto L11;
        return "screenOff";
    L11:
        boolean r9 = r8.isInteractive();     // Catch: Exception -> L31
        Object r0 = r5.getSystemService("power");     // Catch: Exception -> L22
        if ((r0 instanceof PowerManager) == false) goto L15;
        r7 = (PowerManager) r0;     // Catch: Exception -> L22
    L15:
        if (r7 != null) goto L18;
    L24:
        boolean r1 = false;
    L25:
        if (r9 == false) goto L37;
        if (r1 == false) goto L29;
        String r2 = "userPresent";
    L38:
        return r2;
    L29:
        r2 = "screenOn";
        goto L38
    L37:
        return "screenOff";
    L18:
        if (r7.isInteractive() == false) goto L24;
        if (r4.a().getCurrentActivity() == null) goto L24;
        r1 = true;
        goto L25
    L22:
        e = move-exception;
        FLogger.a.w("DevicePowerManager", "Error checking user present", e);     // Catch: Exception -> L31
        goto L24
    L8:
        r8 = null;
    L31:
        e = move-exception;
        FLogger.a.e("DevicePowerManager", "Error getting screen mode", e);
        return "screenOff";
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a(String r3) throws ClassNotFoundException {
        ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r2 = Class.forName(r3);     // Catch: Throwable -> L8
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
        Class<?> r4 = Class.forName(r3);     // Catch: Throwable -> L17
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

    public static final void d(String r5) {
        String r0 = b;
        b = r5;
        if (Intrinsics.areEqual(r0, r5) == true) goto L12;
        FLogger.a.d("DevicePowerManager", "Screen mode changed from " + r0 + " to " + r5);
        Iterator<T> r1 = e.iterator();
    L6:
        if (r1.hasNext() == false) goto L19;
        ((b) r1.next()).a(r5);     // Catch: Exception -> L10
    L10:
        e = move-exception;
        FLogger.a.e("DevicePowerManager", "Error notifying screen mode listener", e);
        goto L6
    L19:
        return;
    }

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static void c(Application r1, BroadcastReceiver r2) {
        ReceiverRegisterLancet.loge(r2, false);
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == true) goto L12;
        r1.unregisterReceiver(r2);
        return;
    L12:
    L8:
        e = move-exception;
        Npth.addTag("unregisterReceiver", r2.toString());
        e.printStackTrace();
        return;
    L5:
        if (ReceiverRegisterAnrOptimizer.unregisterReceiverHasNonScreenFilter(r2, r1) == false) goto L14;
        r1.unregisterReceiver(r2);     // Catch: Exception -> L8
        return;
    }

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static void b(Application r8, BroadcastReceiver r9, IntentFilter r10, Handler r11, int r12) {
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L29;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L29:
    L23:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L28;
        ReceiverRegisterCrashOptimizer.registerReceiver(r9, r10, "android.permission.WRITE_SECURE_SETTINGS", r11, r12);
        return;
    L28:
        throw e;
    L6:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == true) goto L8;
    L21:
        r8.registerReceiver(r9, r10, "android.permission.WRITE_SECURE_SETTINGS", r11, r12);     // Catch: Exception -> L23
        return;
    L8:
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r10) == false) goto L21;
        int r0 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r9, r10, r12, "android.permission.WRITE_SECURE_SETTINGS", r11, 5, r8).result;     // Catch: Exception -> L23
        if (r0 != 1) goto L12;
        r8.registerReceiver(r9, r10, "android.permission.WRITE_SECURE_SETTINGS", r11, r12);     // Catch: Exception -> L23
        return;
    L12:
        if (r0 != 2) goto L14;
        new Intent();     // Catch: Exception -> L23
        return;
    L14:
        if (r0 == 3) goto L30;
        r8.registerReceiver(r9, r10, "android.permission.WRITE_SECURE_SETTINGS", r11, r12);     // Catch: Exception -> L23
        return;
    }
}
