package com.larus.dora.impl.core.wifi;

import android.app.Application;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.core.content.ContextCompat;
import com.bytedance.crash.Npth;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.larus.account.base.api.ILoginService;
import com.larus.common.apphost.AppHost;
import com.larus.dora.impl.core.settingsconfig.DoraXLinkTransportMode;
import com.larus.dora.impl.core.settingsconfig.c;
import com.larus.dora.impl.util.b0;
import g49.d;
import kj4.a;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.sync.MutexImpl;
import kotlinx.coroutines.sync.b;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class DoraP2pRtcSwitchSync {
    public static final CoroutineScope a = null;
    public static final Object b = null;
    public static final MutexImpl c = null;
    public static Boolean d;
    public static boolean e;
    public static final DoraP2pRtcSwitchSync$networkReceiver$1 f = null;

    /* JADX WARN: Type inference failed for: r0v5, types: [com.larus.dora.impl.core.wifi.DoraP2pRtcSwitchSync$networkReceiver$1] */
    static {
        a = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO());
        b = new Object();
        c = b.a();
        f = new DoraP2pRtcSwitchSync$networkReceiver$1();
    }

    public static void b() {
        c.unlock(null);
    }

    public static void d() {
        DoraWifiLinkWrapper.a.getClass();
        if (DoraWifiLinkWrapper.h() == false) goto L7;
        boolean r0 = true;
        if (c(true) == false) goto L7;
    L8:
        if (r0 == false) goto L10;
        f();
        return;
    L10:
        Object r1 = b;
        monitor-enter(r1);
    L34:
        th = move-exception;
        throw th;
    L13:
        if (e == true) goto L39;
        monitor-exit(r1);
        return;
    L39:
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L29
        Application r3 = AppHost.a.getApplication();     // Catch: Throwable -> L29
        DoraP2pRtcSwitchSync$networkReceiver$1 r4 = f;     // Catch: Throwable -> L29
        ReceiverRegisterLancet.loge(r4, false);     // Catch: Throwable -> L29
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == true) goto L41;
        r3.unregisterReceiver(r4);     // Catch: Throwable -> L29
    L27:
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L29
    L31:
        e = false;     // Catch: Throwable -> L34
        d.d("DoraP2pRtcSwitchSync", "stopApMonitor: unregistered");     // Catch: Throwable -> L34
        Unit r5 = Unit.INSTANCE;     // Catch: Throwable -> L34
        monitor-exit(r1);
        return;
    L41:
    L22:
        e = move-exception;
        if (r4 == null) goto L25;
        Npth.addTag("unregisterReceiver", r4.toString());     // Catch: Throwable -> L29
    L25:
        e.printStackTrace();     // Catch: Throwable -> L29
        goto L27
    L19:
        if (ReceiverRegisterAnrOptimizer.unregisterReceiverHasNonScreenFilter(r4, r3) == false) goto L27;
        r3.unregisterReceiver(r4);     // Catch: Exception -> L22 Throwable -> L29
    L29:
        th = move-exception;
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L34
        Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L34
    L7:
        r0 = false;
        goto L8
    }

    public static void f() {
        Object r1 = b;
        monitor-enter(r1);
    L15:
        th = move-exception;
        throw th;
    L5:
        if (e == false) goto L18;
        monitor-exit(r1);
        return;
    L18:
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L10
        Object r3 = Result.constructor-impl(a(AppHost.a.getApplication(), f, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE")));     // Catch: Throwable -> L10
    L12:
        e = Result.isSuccess-impl(r3);     // Catch: Throwable -> L15
        d.d("DoraP2pRtcSwitchSync", "startApMonitor: registered=" + e);     // Catch: Throwable -> L15
        Unit r0 = Unit.INSTANCE;     // Catch: Throwable -> L15
        monitor-exit(r1);
        return;
    L10:
        th = move-exception;
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L15
        r3 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L15
        goto L12
    }

    public static boolean c(boolean r4) {
        String r0 = ILoginService.a.getAccountInfo().c;
        if (r0 != null) goto L5;
        r0 = "";
    L5:
        c r1 = c.a;
        b0.a.getClass();
        boolean r2 = b0.p(r0);
        boolean r3 = b0.u(r0);
        DoraWifiLinkWrapper.a.getClass();
        boolean r5 = DoraWifiLinkWrapper.n().a();
        r1.getClass();
        if (c.e(r2, r3, r5, r4) != DoraXLinkTransportMode.WIFI) goto L8;
        return true;
    L8:
        return false;
    }

    public static void e(String r7) {
        Intrinsics.checkNotNullParameter(r7, "reason");
        BuildersKt.launch$default(a, null, null, new DoraP2pRtcSwitchSync$resyncP2pSwitch$1(r7, null), 3, null);
    }

    public static int g(boolean r8, Long r9) {
        Object r0 = b;
        monitor-enter(r0);
        if (r9 != null) goto L6;
        int r10 = a.g().u(r8);     // Catch: Throwable -> L13
    L7:
        if (r10 != 0) goto L9;
        Boolean r11 = Boolean.valueOf(r8);     // Catch: Throwable -> L13
    L10:
        d = r11;     // Catch: Throwable -> L13
        monitor-exit(r0);
        return r10;
    L9:
        r11 = null;
        goto L10
    L6:
        a r1 = a.g();     // Catch: Throwable -> L13
        long r6 = r9.longValue();     // Catch: Throwable -> L13
        r10 = r1.c.d.j(2, 5, new byte[]{53, 1, r8 ? 1 : 0}, r6);     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;
    }

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static Intent a(Application r8, DoraP2pRtcSwitchSync$networkReceiver$1 r9, IntentFilter r10) {
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L41;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L41:
    L35:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == true) goto L39;
        throw e;
    L39:
        return ReceiverRegisterCrashOptimizer.registerReceiver(r9, r10);
    L6:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L24;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r10) == false) goto L24;
        ReceiverRegisterAnrOptimizer.ResultWrapper r0 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r9, r10, 0, null, null, 2, r8);     // Catch: Exception -> L35
        int r1 = r0.result;     // Catch: Exception -> L35
        if (r1 == 1) goto L22;
        if (r1 == 2) goto L20;
        if (r1 == 3) goto L18;
        return r8.registerReceiver(r9, r10);
    L18:
        return r0.intent;
    L20:
        return new Intent();
    L22:
        return r8.registerReceiver(r9, r10);
    L24:
        if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L28;
        ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L35
        return r8.registerReceiver(r9, r10, null, ReceiverRegisterLancet.sReceiverHandler);
    L28:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() == null) goto L34;
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r10) == false) goto L34;
        ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L35
        return ContextCompat.registerReceiver(r8, r9, r10, null, ReceiverRegisterLancet.sProxyHandler, 2);
    L34:
        return r8.registerReceiver(r9, r10);
    }
}
