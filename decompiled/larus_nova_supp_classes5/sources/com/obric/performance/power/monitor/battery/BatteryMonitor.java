package com.obric.performance.power.monitor.battery;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import androidx.core.content.ContextCompat;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.obric.aiagent.platform.depend.ILogDepend;
import fna.g;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class BatteryMonitor {
    public static final BatteryMonitor a = null;
    public static Context b;
    public static BatteryInfoReceiver c;
    public static final List<a> d = null;
    public static float e;
    public static boolean f;
    public static float g;
    public static int h;

    public interface a {
        void a(boolean r1);
    }

    public BatteryMonitor() {
    }

    static {
        a = new BatteryMonitor();
        d = Collections.synchronizedList(new ArrayList());
    }

    public static void c(Intent r5) {
        String r1 = null;
        Object r0 = BatteryManager.class.getField("EXTRA_CHARGE_COUNTER").get(null);     // Catch: Throwable -> L6
        if ((r0 instanceof String) == false) goto L8;
        r1 = (String) r0;     // Catch: Throwable -> L6
    L8:
        if (r1 != null) goto L10;
        int r2 = -1;
    L11:
        h = r2;
        e = 100 * (r5.getIntExtra("level", -1) / r5.getIntExtra("scale", -1));
        int r3 = r5.getIntExtra("status", -1);
        if (r3 != 2) goto L14;
    L17:
        boolean r4 = true;
    L19:
        if (f == r4) goto L32;
        List<a> r6 = d;
        monitor-enter(r6);
        Iterator<T> r7 = r6.iterator();     // Catch: Throwable -> L29
    L24:
        if (r7.hasNext() == false) goto L26;
        ((a) r7.next()).a(r4);     // Catch: Throwable -> L29
        goto L24
    L26:
        Unit r8 = Unit.INSTANCE;     // Catch: Throwable -> L29
        monitor-exit(r6);
    L29:
        th = move-exception;
        throw th;
    L32:
        f = r4;
        ILogDepend.a.d("PowerMonitor", "BatteryMonitor resetValue: cap=" + e + ", charger=" + f);
        g = ((float) r5.getIntExtra("temperature", 0)) / 10.0f;
        return;
    L14:
        if (r3 == 5) goto L17;
        r4 = false;
        goto L19
    L10:
        r2 = r5.getIntExtra(r1, -1);
    L6:
        r1 = "android.os.extra.CHARGE_COUNTER";
        goto L8
    }

    public final synchronized void b(g.a r3) {
        monitor-enter(this);
        if (r3 != null) goto L15;
    L13:
        monitor-exit(this);
        return;
    L15:
        List<a> r0 = d;     // Catch: Throwable -> L10
        if (r0.contains(r3) == true) goto L13;
        r3.a(f);     // Catch: Throwable -> L10
        r0.add(r3);     // Catch: Throwable -> L10
        ILogDepend.a.d("PowerMonitor", "BatteryMonitor registerChargeCallback");     // Catch: Throwable -> L10
        monitor-exit(this);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public final synchronized void d(g.a r3) {
        monitor-enter(this);
        if (r3 != null) goto L15;
    L13:
        monitor-exit(this);
        return;
    L15:
        List<a> r0 = d;     // Catch: Throwable -> L10
        if (r0.contains(r3) == false) goto L13;
        r0.remove(r3);     // Catch: Throwable -> L10
        ILogDepend.a.d("PowerMonitor", "BatteryMonitor unregisterChargeCallback");     // Catch: Throwable -> L10
        monitor-exit(this);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static Intent a(Context r8, BatteryInfoReceiver r9, IntentFilter r10) {
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
