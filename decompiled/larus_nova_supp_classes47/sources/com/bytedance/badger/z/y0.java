package com.bytedance.badger.z;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Build;
import android.os.Bundle;
import androidx.core.content.ContextCompat;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.badger.BadgerCore;
import com.bytedance.badger.data.BadgerResult;
import com.bytedance.badger.data.DataJson;
import com.bytedance.badger.module.BadgerModuleBase;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import kotlin.Pair;
import kotlin.TuplesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class y0 extends u0 {
    public y0() {
    }

    @Override // com.bytedance.badger.module.BadgerModuleBase
    public final BadgerResult a(Context r17, BadgerModuleBase.BadgerRequestData r18) {
        int r1 = Build.VERSION.SDK_INT;
        if (r1 < 23) goto L5;
        Object r2 = r17.getSystemService("batterymanager");
        if ((r2 instanceof BatteryManager) == true) goto L9;
        r2 = null;
    L9:
        BatteryManager r3 = (BatteryManager) r2;
        if (r3 == null) goto L12;
        int r9 = 1;
        int r4 = r3.getIntProperty(1);
        int r5 = r3.getIntProperty(4);
        int r6 = com.bytedance.badger.t.d.a(com.bytedance.badger.t.a.a(652451082, null, null, 6), 0, 3);
        if (r6 >= 0) goto L23;
        if (r4 <= 0) goto L22;
        if (r5 <= 0) goto L22;
        float r7 = r4 / 1000.0f;
        float r8 = 100.0f / r5;
        if (r8 <= 100.0f) goto L21;
        r6 = 0;
        goto L23
    L21:
        r6 = (int) (r7 * r8);
    L22:
        r6 = Integer.MIN_VALUE;
    L23:
        Pair[] r14 = new Pair[4];
        if (r1 < 26) goto L32;
        int r10 = r3.getIntProperty(6);
        if (r10 == 2) goto L35;
        if (r10 == 3) goto L34;
        if (r10 == 4) goto L34;
        if (r10 != 5) goto L32;
        int r12 = 3;
    L36:
        r14[0] = TuplesKt.to(DataType.TRUE, Integer.valueOf(r12));
        if (r5 >= 0) goto L39;
        float r13 = -1.0f;
    L40:
        r14[1] = TuplesKt.to("2", Float.valueOf(r13));
        r14[2] = TuplesKt.to("3", Integer.valueOf(r6));
        BadgerCore.Companion.getClass();
        IntentFilter r15 = new IntentFilter(com.bytedance.badger.j.b(4193255389545460266L));
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L79;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L79:
    L65:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L78;
        Intent r0 = ReceiverRegisterCrashOptimizer.registerReceiver(null, r15);
    L69:
        if (r0 == null) goto L75;
        Bundle r16 = r0.getExtras();
        if (r16 == null) goto L75;
        if (r16.getBoolean(com.bytedance.badger.j.b(5733181997070332015L)) != true) goto L75;
    L76:
        r14[3] = TuplesKt.to("4", Integer.valueOf(r9));
        return new BadgerResult.Success(new DataJson(com.bm.badgervi.b.f(r14)));
    L75:
        r9 = 0;
        goto L76
    L78:
        throw e;
    L44:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L56;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r15) == false) goto L56;
        ReceiverRegisterAnrOptimizer.ResultWrapper r19 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(null, r15, 0, null, null, 2, r17);     // Catch: Exception -> L65
        int r20 = r19.result;     // Catch: Exception -> L65
        if (r20 == 1) goto L54;
        if (r20 == 2) goto L53;
        if (r20 == 3) goto L52;
        r0 = r17.registerReceiver(null, r15);     // Catch: Exception -> L65
        goto L69
    L52:
        r0 = r19.intent;     // Catch: Exception -> L65
        goto L69
    L53:
        r0 = new Intent();     // Catch: Exception -> L65
        goto L69
    L54:
        r0 = r17.registerReceiver(null, r15);     // Catch: Exception -> L65
    L56:
        if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L59;
        ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L65
        r0 = r17.registerReceiver(null, r15, null, ReceiverRegisterLancet.sReceiverHandler);     // Catch: Exception -> L65
        goto L69
    L59:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() != null) goto L61;
    L63:
        r0 = r17.registerReceiver(null, r15);     // Catch: Exception -> L65
        goto L69
    L61:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r15) == false) goto L63;
        ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L65
        r0 = ContextCompat.registerReceiver(r17, null, r15, null, ReceiverRegisterLancet.sProxyHandler, 2);     // Catch: Exception -> L65
        goto L69
    L39:
        r13 = r5 / 100.0f;
    L34:
        r12 = 1;
        goto L36
    L35:
        r12 = 2;
    L32:
        r12 = 0;
        goto L36
    L12:
        return new BadgerResult.Failure(-1, "Get service failed");
    L5:
        return new BadgerResult.Failure(-1, "Not supported");
    }
}
