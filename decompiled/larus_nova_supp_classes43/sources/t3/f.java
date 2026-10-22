package t3;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.core.content.ContextCompat;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class f {
    static {
    }

    public static g a(Context r11) {
        Intrinsics.checkNotNullParameter(r11, "context");
        IntentFilter r0 = new IntentFilter("android.intent.action.BATTERY_CHANGED");
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L5;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L5:
        boolean r10 = true;
    L29:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L46;
        Intent r12 = ReceiverRegisterCrashOptimizer.registerReceiver(null, r0);
    L33:
        if (r12 != null) goto L35;
        return null;
    L35:
        int r1 = r12.getIntExtra(com.bytedance.android.ec.core.event.a.KEY_STATUS, -1);
        int r13 = 0;
        if (r1 != 2) goto L38;
    L41:
        int r14 = r12.getIntExtra("level", 0);
        int r15 = r12.getIntExtra("scale", 100);
        if (r15 <= 0) goto L45;
        r13 = RangesKt.coerceIn((r14 * 100) / r15, 0, 100);
    L45:
        return new g(r13, r10);
    L38:
        if (r1 == 5) goto L41;
        r10 = false;
        goto L41
    L46:
        throw e;
    L7:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L20;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r0) == false) goto L20;
        ReceiverRegisterAnrOptimizer.ResultWrapper r16 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(null, r0, 0, null, null, 2, r11);     // Catch: Exception -> L29
        int r17 = r16.result;     // Catch: Exception -> L29
        if (r17 == 1) goto L18;
        if (r17 != 2) goto L14;
        r12 = new Intent();     // Catch: Exception -> L29
    L47:
        goto L33
    L14:
        if (r17 == 3) goto L16;
        r12 = r11.registerReceiver(null, r0);     // Catch: Exception -> L29
        goto L47
    L16:
        r12 = r16.intent;     // Catch: Exception -> L29
        goto L47
    L18:
        r12 = r11.registerReceiver(null, r0);     // Catch: Exception -> L29
    L20:
        if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L23;
        ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L29
        r12 = r11.registerReceiver(null, r0, null, ReceiverRegisterLancet.sReceiverHandler);     // Catch: Exception -> L29
        goto L47
    L23:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() != null) goto L25;
    L27:
        r12 = r11.registerReceiver(null, r0);     // Catch: Exception -> L29
        goto L47
    L25:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r0) == false) goto L27;
        ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L29
        r12 = ContextCompat.registerReceiver(r11, null, r0, null, ReceiverRegisterLancet.sProxyHandler, 2);     // Catch: Exception -> L29
        goto L47
    }
}
