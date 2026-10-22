package qoa;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.SystemClock;
import androidx.core.content.ContextCompat;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.privacy.azerothprivacy.alarm.receiver.AzerothCustomReceiver;
import fpa.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class b {

    public static class a extends BroadcastReceiver {
        public final AzerothCustomReceiver a;

        public a(AzerothCustomReceiver r1) {
            this.a = r1;
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(final Context r2, final Intent r3) {
            Runnable r0 = new qoa.a(this, r2, r3);
            c.a.execute(r0);
        }
    }

    public static void a(Context r13, AzerothCustomReceiver r14) {
        if (Build.VERSION.SDK_INT < 33) goto L34;
        a r0 = new a(r14);
        IntentFilter r1 = new IntentFilter(r14.getClass().getName());
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L65;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L65:
    L29:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L33;
        ReceiverRegisterCrashOptimizer.registerReceiver(r0, r1, 4);
        return;
    L33:
        throw e;
    L9:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L20;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r1) == false) goto L20;
        int r5 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r0, r1, 4, null, null, 3, r13).result;     // Catch: Exception -> L29
        if (r5 == 1) goto L18;
        if (r5 == 2) goto L17;
        if (r5 == 3) goto L64;
        r13.registerReceiver(r0, r1, 4);     // Catch: Exception -> L29
    L64:
        return;
    L17:
        new Intent();     // Catch: Exception -> L29
        goto L64
    L18:
        r13.registerReceiver(r0, r1, 4);     // Catch: Exception -> L29
    L20:
        if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L23;
        ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L29
        r13.registerReceiver(r0, r1, null, ReceiverRegisterLancet.sReceiverHandler);     // Catch: Exception -> L29
        goto L64
    L23:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() != null) goto L25;
    L27:
        r13.registerReceiver(r0, r1, 4);     // Catch: Exception -> L29
        goto L64
    L25:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r1) == false) goto L27;
        ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L29
        ContextCompat.registerReceiver(r13, r0, r1, null, ReceiverRegisterLancet.sProxyHandler, 4);     // Catch: Exception -> L29
        goto L64
    L34:
        a r2 = new a(r14);
        IntentFilter r3 = new IntentFilter(r14.getClass().getName());
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L68;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L68:
    L58:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L63;
        ReceiverRegisterCrashOptimizer.registerReceiver(r2, r3);
        return;
    L63:
        throw e;
    L38:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L49;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r3) == false) goto L49;
        int r15 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r2, r3, 0, null, null, 2, r13).result;     // Catch: Exception -> L58
        if (r15 == 1) goto L47;
        if (r15 == 2) goto L46;
        if (r15 == 3) goto L67;
        r13.registerReceiver(r2, r3);     // Catch: Exception -> L58
    L67:
        return;
    L46:
        new Intent();     // Catch: Exception -> L58
        goto L67
    L47:
        r13.registerReceiver(r2, r3);     // Catch: Exception -> L58
    L49:
        if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L52;
        ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L58
        r13.registerReceiver(r2, r3, null, ReceiverRegisterLancet.sReceiverHandler);     // Catch: Exception -> L58
        goto L67
    L52:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() != null) goto L54;
    L56:
        r13.registerReceiver(r2, r3);     // Catch: Exception -> L58
        goto L67
    L54:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r3) == false) goto L56;
        ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L58
        ContextCompat.registerReceiver(r13, r2, r3, null, ReceiverRegisterLancet.sProxyHandler, 2);     // Catch: Exception -> L58
        goto L67
    }

    public static void b(Context r5, AzerothCustomReceiver r6) {
        if (r5 == null) goto L7;
        AlarmManager r0 = (AlarmManager) r5.getSystemService("alarm");     // Catch: Exception -> L9
        if (r0 != null) goto L6;
        return;
    L6:
        Intent r1 = new Intent(r6.getClass().getName());     // Catch: Exception -> L9
        r1.setPackage(r5.getPackageName());     // Catch: Exception -> L9
        PendingIntent r7 = PendingIntent.getBroadcast(r5, 0, r1, 201326592);     // Catch: Exception -> L9
        r0.set(3, SystemClock.elapsedRealtime() + r6.a(), r7);     // Catch: Exception -> L9
        return;
    L7:
        apa.a.b("AzerothAlarmUtil", "setCustomAlarm: context or receiver is null");     // Catch: Exception -> L9
        return;
    L9:
        e = move-exception;
        xoa.a.a(e, "setCustomAlarm execute failed", null);
    }
}
