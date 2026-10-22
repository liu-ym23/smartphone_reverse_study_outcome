package com.ss.android.lark.monitor;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class ChildProcessMetricsReceiver extends BroadcastReceiver {
    public static final /* synthetic */ int a = 0;

    public ChildProcessMetricsReceiver() {
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context r3, Intent r4) {
        String r5 = r4.getAction();
        LarkMetrics r0 = LarkMetrics.a.a;
        if ("com.ss.android.lark.metrics.doMetrics".equals(r5) == false) goto L10;
        String r6 = r4.getStringExtra("activity_name");
        if (r0.h == true) goto L7;
        return;
    L7:
        if (r0.d.d == true) goto L12;
        r0.b(r6);
        return;
    L12:
        return;
    }

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static void a(Context r8, ChildProcessMetricsReceiver r9, IntentFilter r10, String r11) {
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L29;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L29:
    L23:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L28;
        ReceiverRegisterCrashOptimizer.registerReceiver(r9, r10, r11, null, 4);
        return;
    L28:
        throw e;
    L6:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == true) goto L8;
    L21:
        r8.registerReceiver(r9, r10, r11, null, 4);     // Catch: Exception -> L23
        return;
    L8:
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r10) == false) goto L21;
        int r0 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r9, r10, 4, r11, null, 5, r8).result;     // Catch: Exception -> L23
        if (r0 != 1) goto L12;
        r8.registerReceiver(r9, r10, r11, null, 4);     // Catch: Exception -> L23
        return;
    L12:
        if (r0 != 2) goto L14;
        new Intent();     // Catch: Exception -> L23
        return;
    L14:
        if (r0 == 3) goto L30;
        r8.registerReceiver(r9, r10, r11, null, 4);     // Catch: Exception -> L23
        return;
    }

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static void b(Context r9, ChildProcessMetricsReceiver r10, IntentFilter r11, String r12) {
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L30;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L30:
    L24:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L29;
        ReceiverRegisterCrashOptimizer.registerReceiver(r10, r11, r12, null);
        return;
    L29:
        throw e;
    L7:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == true) goto L9;
    L22:
        r9.registerReceiver(r10, r11, r12, null);     // Catch: Exception -> L24
        return;
    L9:
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r11) == false) goto L22;
        int r1 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r10, r11, 0, r12, null, 4, r9).result;     // Catch: Exception -> L24
        if (r1 != 1) goto L13;
        r9.registerReceiver(r10, r11, r12, null);     // Catch: Exception -> L24
        return;
    L13:
        if (r1 != 2) goto L15;
        new Intent();     // Catch: Exception -> L24
        return;
    L15:
        if (r1 == 3) goto L31;
        r9.registerReceiver(r10, r11, r12, null);     // Catch: Exception -> L24
        return;
    }
}
