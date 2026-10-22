package com.ss.android.lark.framework.assembly.network;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.core.content.ContextCompat;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.larksuite.framework.launch.task.AbstractLaunchTask;
import com.ss.android.lark.appcontext.applifecycle.LifecycleHandler;
import com.ss.android.lark.appcontext.applifecycle.t;
import com.ss.android.lark.http.netstate.NetworkBroadcastReceiver;
import com.ss.android.lark.http.netstate.NetworkUtils;
import com.ss.android.lark.http.netstate.c;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class InitNetworkTask extends AbstractLaunchTask {
    public final a c;

    public class a implements t {
        public a() {
        }

        public final void a(Activity r2) {
            NetworkUtils.NetworkType r3 = NetworkUtils.a(r2);
            c.a.a.b(r3);
        }
    }

    public InitNetworkTask() {
        this.c = new a();
    }

    public final void a(Context r10) {
        a r0 = this.c;
        if (r0 != null) goto L5;
        List r1 = LifecycleHandler.a;
    L7:
        if (NetworkBroadcastReceiver.a != null) goto L9;
        NetworkBroadcastReceiver.a = new NetworkBroadcastReceiver();
    L9:
        IntentFilter r2 = new IntentFilter();
        r2.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        NetworkBroadcastReceiver r8 = NetworkBroadcastReceiver.a;
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L41;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L41:
    L35:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L40;
        ReceiverRegisterCrashOptimizer.registerReceiver(r8, r2);
        return;
    L40:
        throw e;
    L13:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L26;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r2) == false) goto L26;
        int r3 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r8, r2, 0, null, null, 2, r10).result;     // Catch: Exception -> L35
        if (r3 != 1) goto L19;
        r10.registerReceiver(r8, r2);     // Catch: Exception -> L35
        return;
    L19:
        if (r3 != 2) goto L21;
        new Intent();     // Catch: Exception -> L35
        return;
    L21:
        if (r3 == 3) goto L42;
        r10.registerReceiver(r8, r2);     // Catch: Exception -> L35
        return;
    L42:
        return;
    L26:
        if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L29;
        ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L35
        r10.registerReceiver(r8, r2, null, ReceiverRegisterLancet.sReceiverHandler);     // Catch: Exception -> L35
        return;
    L29:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() != null) goto L31;
    L33:
        r10.registerReceiver(r8, r2);     // Catch: Exception -> L35
        return;
    L31:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r2) == false) goto L33;
        ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L35
        ContextCompat.registerReceiver(r10, r8, r2, null, ReceiverRegisterLancet.sProxyHandler, 2);     // Catch: Exception -> L35
        return;
    L5:
        ((CopyOnWriteArrayList) LifecycleHandler.a).add(r0);
        goto L7
    }
}
