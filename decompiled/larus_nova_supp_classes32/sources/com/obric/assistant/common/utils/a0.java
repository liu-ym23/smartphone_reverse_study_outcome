package com.obric.assistant.common.utils;

import android.os.PowerManager;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class a0 {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static boolean a() {
        Object r0 = AppHost.a.getApplication().getSystemService("power");
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type android.os.PowerManager");
        return ((PowerManager) r0).isInteractive();
    }

    public static void b() {
        Object r1 = AppHost.a.getApplication().getSystemService("power");     // Catch: Throwable -> L8
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type android.os.PowerManager");     // Catch: Throwable -> L8
        FLogger.a.i("Utils", "turnOnScreen");     // Catch: Throwable -> L8
        PowerManager.WakeLock r2 = ((PowerManager) r1).newWakeLock(268435466, "AssistantWakeLock:TurnOnScreen");     // Catch: Throwable -> L8
        if (fna.g.d() == true) goto L6;
        r2.acquire(100);     // Catch: Throwable -> L8
    L11:
        return;
    L6:
        r2.acquire(100);     // Catch: Throwable -> L8
        com.obric.performance.power.monitor.cpu.d.a(r2);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        FLogger.a.e("Utils", "turnScreenOn error!", th);
    }
}
