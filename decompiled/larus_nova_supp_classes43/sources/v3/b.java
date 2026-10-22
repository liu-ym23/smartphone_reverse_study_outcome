package v3;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import androidx.core.content.ContextCompat;
import com.bytedance.ai.bridge.method.device.wifi.WifiConnectedEventPublisher$ensureMonitoring$1$changeReceiver$1;
import com.bytedance.crash.Npth;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.google.gson.JsonObject;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b {
    public static final Object a = null;
    public static Context b;
    public static WifiConnectedEventPublisher$ensureMonitoring$1$changeReceiver$1 c;
    public static String d;

    static {
        a = new Object();
    }

    public static void g() {
        Object r0 = a;
        monitor-enter(r0);
        WifiConnectedEventPublisher$ensureMonitoring$1$changeReceiver$1 r1 = c;     // Catch: Throwable -> L19
        if (r1 != null) goto L24;
    L16:
        b = null;     // Catch: Throwable -> L19
        c = null;     // Catch: Throwable -> L19
        d = null;     // Catch: Throwable -> L19
        Unit r10 = Unit.INSTANCE;     // Catch: Throwable -> L19
        monitor-exit(r0);
        return;
    L24:
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L13
        Context r12 = b;     // Catch: Throwable -> L13
        if (r12 == null) goto L10;
        c(r12, r1);     // Catch: Throwable -> L13
        Unit r13 = Unit.INSTANCE;     // Catch: Throwable -> L13
    L11:
        Object r14 = Result.constructor-impl(r13);     // Catch: Throwable -> L13
    L15:
        Result.box-impl(r14);     // Catch: Throwable -> L19
        goto L16
    L10:
        r13 = null;
    L13:
        th = move-exception;
        Result.Companion r15 = Result.Companion;     // Catch: Throwable -> L19
        r14 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        throw th;
    }

    public static void d(Context r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Object r0 = a;
        monitor-enter(r0);
    L19:
        th = move-exception;
        throw th;
    L5:
        if (c != null) goto L8;
        monitor-exit(r0);
        return;
    L8:
        Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L19
        monitor-exit(r0);
        d r11 = d.a;
        Context r12 = r10.getApplicationContext();
        if (r12 == null) goto L14;
        r10 = r12;
    L14:
        r11.getClass();
        e r13 = d.f(r10, false);
        if (r13 != null) goto L17;
        return;
    L17:
        e(r13);
    }

    public static void e(e r10) {
        StringBuilder r0 = new StringBuilder();
        r0.append(r10.a);
        r0.append('#');
        String r1 = r10.b;
        if (r1 != null) goto L5;
        r1 = "";
    L5:
        r0.append(r1);
        String r11 = r0.toString();
        Object r12 = a;
        monitor-enter(r12);
    L30:
        th = move-exception;
        throw th;
    L8:
        if (c != null) goto L10;
    L28:
        monitor-exit(r12);
        return;
    L10:
        if (Intrinsics.areEqual(d, r11) == true) goto L28;
        d = r11;     // Catch: Throwable -> L30
        Unit r13 = Unit.INSTANCE;     // Catch: Throwable -> L30
        monitor-exit(r12);
        JsonObject r14 = new JsonObject();
        JsonObject r15 = new JsonObject();
        r15.addProperty("ssid", r10.a);
        String r16 = r10.b;
        if (r16 == null) goto L17;
        r15.addProperty("bssid", r16);
    L17:
        Boolean r17 = r10.c;
        if (r17 == null) goto L20;
        r15.addProperty("secure", Boolean.valueOf(r17.booleanValue()));
    L20:
        Double r18 = r10.d;
        if (r18 == null) goto L23;
        r15.addProperty("signalStrength", Double.valueOf(r18.doubleValue()));
    L23:
        Integer r19 = r10.e;
        if (r19 == null) goto L26;
        r15.addProperty("frequency", Integer.valueOf(r19.intValue()));
    L26:
        r14.add("wifi", r15);
        l3.d.c(new l3.a("doubao.onWifiConnected", r14, 4));
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [android.content.BroadcastReceiver, com.bytedance.ai.bridge.method.device.wifi.WifiConnectedEventPublisher$ensureMonitoring$1$changeReceiver$1] */
    public static void f(Context r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Context r0 = r10.getApplicationContext();
        if (r0 == null) goto L6;
        r10 = r0;
    L6:
        Object r1 = a;
        monitor-enter(r1);
    L27:
        th = move-exception;
        throw th;
    L9:
        if (c == null) goto L12;
        monitor-exit(r1);
        return;
    L12:
        ?? r11 = new WifiConnectedEventPublisher$ensureMonitoring$1$changeReceiver$1();     // Catch: Throwable -> L27
        IntentFilter r12 = new IntentFilter("android.net.wifi.STATE_CHANGE");     // Catch: RuntimeException -> L19 Throwable -> L27
        if (Build.VERSION.SDK_INT < 33) goto L16;
        a(r10, r11, r12);     // Catch: RuntimeException -> L19 Throwable -> L27
    L17:
        b = r10;     // Catch: RuntimeException -> L19 Throwable -> L27
        c = r11;     // Catch: RuntimeException -> L19 Throwable -> L27
    L24:
        Unit r13 = Unit.INSTANCE;     // Catch: Throwable -> L27
        monitor-exit(r1);
        return;
    L16:
        b(r10, r11, r12);     // Catch: RuntimeException -> L19 Throwable -> L27
    L19:
        Result.Companion r14 = Result.Companion;     // Catch: Throwable -> L21
        c(r10, r11);     // Catch: Throwable -> L21
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L21
    L23:
        b = null;     // Catch: Throwable -> L27
        c = null;     // Catch: Throwable -> L27
        d = null;     // Catch: Throwable -> L27
        goto L24
    L21:
        th = move-exception;
        Result.Companion r15 = Result.Companion;     // Catch: Throwable -> L27
        Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L27
        goto L23
    }

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static void c(Context r1, BroadcastReceiver r10) {
        ReceiverRegisterLancet.loge(r10, false);
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == true) goto L12;
        r1.unregisterReceiver(r10);
        return;
    L12:
    L8:
        e = move-exception;
        Npth.addTag("unregisterReceiver", r10.toString());
        e.printStackTrace();
        return;
    L5:
        if (ReceiverRegisterAnrOptimizer.unregisterReceiverHasNonScreenFilter(r10, r1) == false) goto L14;
        r1.unregisterReceiver(r10);     // Catch: Exception -> L8
        return;
    }

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static void a(Context r10, WifiConnectedEventPublisher$ensureMonitoring$1$changeReceiver$1 r11, IntentFilter r12) {
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L40;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L40:
    L34:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L39;
        ReceiverRegisterCrashOptimizer.registerReceiver(r11, r12, 4);
        return;
    L39:
        throw e;
    L7:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L23;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r12) == false) goto L23;
        int r1 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r11, r12, 4, null, null, 3, r10).result;     // Catch: Exception -> L34
        if (r1 != 1) goto L13;
        r10.registerReceiver(r11, r12, 4);     // Catch: Exception -> L34
        return;
    L13:
        if (r1 != 2) goto L15;
        new Intent();     // Catch: Exception -> L34
        return;
    L15:
        if (r1 == 3) goto L41;
        r10.registerReceiver(r11, r12, 4);     // Catch: Exception -> L34
        return;
    L41:
        return;
    L23:
        if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L27;
        ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L34
        r10.registerReceiver(r11, r12, null, ReceiverRegisterLancet.sReceiverHandler);     // Catch: Exception -> L34
        return;
    L27:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() != null) goto L29;
    L32:
        r10.registerReceiver(r11, r12, 4);     // Catch: Exception -> L34
        return;
    L29:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r12) == false) goto L32;
        ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L34
        ContextCompat.registerReceiver(r10, r11, r12, null, ReceiverRegisterLancet.sProxyHandler, 4);     // Catch: Exception -> L34
    }

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static void b(Context r10, WifiConnectedEventPublisher$ensureMonitoring$1$changeReceiver$1 r11, IntentFilter r12) {
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L39;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L39:
    L33:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L38;
        ReceiverRegisterCrashOptimizer.registerReceiver(r11, r12);
        return;
    L38:
        throw e;
    L6:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L22;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r12) == false) goto L22;
        int r0 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r11, r12, 0, null, null, 2, r10).result;     // Catch: Exception -> L33
        if (r0 != 1) goto L12;
        r10.registerReceiver(r11, r12);     // Catch: Exception -> L33
        return;
    L12:
        if (r0 != 2) goto L14;
        new Intent();     // Catch: Exception -> L33
        return;
    L14:
        if (r0 == 3) goto L40;
        r10.registerReceiver(r11, r12);     // Catch: Exception -> L33
        return;
    L40:
        return;
    L22:
        if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L26;
        ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L33
        r10.registerReceiver(r11, r12, null, ReceiverRegisterLancet.sReceiverHandler);     // Catch: Exception -> L33
        return;
    L26:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() != null) goto L28;
    L31:
        r10.registerReceiver(r11, r12);     // Catch: Exception -> L33
        return;
    L28:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r12) == false) goto L31;
        ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L33
        ContextCompat.registerReceiver(r10, r11, r12, null, ReceiverRegisterLancet.sProxyHandler, 2);     // Catch: Exception -> L33
    }
}
