package androidx.core.content;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class ContextCompat$Api26Impl {
    private ContextCompat$Api26Impl() {
    }

    public static ComponentName startForegroundService(Context r0, Intent r1) {
        return r0.startForegroundService(r1);
    }

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static Intent INVOKEVIRTUAL_androidx_core_content_ContextCompat$Api26Impl_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(Context r8, BroadcastReceiver r9, IntentFilter r10, String r11, Handler r12) {
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L32;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L32:
    L26:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == true) goto L30;
        throw e;
    L30:
        return ReceiverRegisterCrashOptimizer.registerReceiver(r9, r10, r11, r12);
    L6:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L25;
        if (r10 == null) goto L25;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r10) == false) goto L25;
        ReceiverRegisterAnrOptimizer.ResultWrapper r0 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r9, r10, 0, r11, r12, 4, r8);     // Catch: Exception -> L26
        int r1 = r0.result;     // Catch: Exception -> L26
        if (r1 == 1) goto L23;
        if (r1 == 2) goto L21;
        if (r1 == 3) goto L19;
        return r8.registerReceiver(r9, r10, r11, r12);
    L19:
        return r0.intent;
    L21:
        return new Intent();
    L23:
        return r8.registerReceiver(r9, r10, r11, r12);
    L25:
        return r8.registerReceiver(r9, r10, r11, r12);
    }

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static Intent INVOKEVIRTUAL_androidx_core_content_ContextCompat$Api26Impl_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(Context r8, BroadcastReceiver r9, IntentFilter r10, String r11, Handler r12, int r13) {
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L32;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L32:
    L26:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == true) goto L30;
        throw e;
    L30:
        return ReceiverRegisterCrashOptimizer.registerReceiver(r9, r10, r11, r12, r13);
    L6:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L25;
        if (r10 == null) goto L25;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r10) == false) goto L25;
        ReceiverRegisterAnrOptimizer.ResultWrapper r0 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r9, r10, r13, r11, r12, 5, r8);     // Catch: Exception -> L26
        int r1 = r0.result;     // Catch: Exception -> L26
        if (r1 == 1) goto L23;
        if (r1 == 2) goto L21;
        if (r1 == 3) goto L19;
        return r8.registerReceiver(r9, r10, r11, r12, r13);
    L19:
        return r0.intent;
    L21:
        return new Intent();
    L23:
        return r8.registerReceiver(r9, r10, r11, r12, r13);
    L25:
        return r8.registerReceiver(r9, r10, r11, r12, r13);
    }

    public static Intent registerReceiver(Context r6, BroadcastReceiver r7, IntentFilter r8, String r9, Handler r10, int r11) {
        if ((r11 & 4) == 0) goto L8;
        if (r9 != null) goto L8;
        return INVOKEVIRTUAL_androidx_core_content_ContextCompat$Api26Impl_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(r6, r7, r8, ContextCompat.obtainAndCheckReceiverPermission(r6), r10);
    L8:
        return INVOKEVIRTUAL_androidx_core_content_ContextCompat$Api26Impl_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(r6, r7, r8, r9, r10, r11 & 1);
    }
}
