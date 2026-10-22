package com.bytedance.android.ec.core.event;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.core.content.ContextCompat;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b {
    public static final b a = null;

    public b() {
    }

    static {
        a = new b();
    }

    public final void registerReceiver(Context r10, BroadcastReceiver r11, IntentFilter r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "var1");
        Intrinsics.checkNotNullParameter(r12, "var2");
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L35;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L35:
    L29:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L34;
        ReceiverRegisterCrashOptimizer.registerReceiver(r11, r12);
        return;
    L34:
        throw e;
    L6:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L20;
        if (r12 == null) goto L20;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r12) == false) goto L20;
        int r0 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r11, r12, 0, null, null, 2, r10).result;     // Catch: Exception -> L29
        if (r0 != 1) goto L13;
        r10.registerReceiver(r11, r12);     // Catch: Exception -> L29
        return;
    L13:
        if (r0 != 2) goto L15;
        new Intent();     // Catch: Exception -> L29
        return;
    L15:
        if (r0 == 3) goto L36;
        r10.registerReceiver(r11, r12);     // Catch: Exception -> L29
        return;
    L36:
        return;
    L20:
        if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L23;
        ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L29
        r10.registerReceiver(r11, r12, null, ReceiverRegisterLancet.sReceiverHandler);     // Catch: Exception -> L29
        return;
    L23:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() != null) goto L25;
    L27:
        r10.registerReceiver(r11, r12);     // Catch: Exception -> L29
        return;
    L25:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r12) == false) goto L27;
        ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L29
        ContextCompat.registerReceiver(r10, r11, r12, null, ReceiverRegisterLancet.sProxyHandler, 2);     // Catch: Exception -> L29
    }
}
