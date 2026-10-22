package com.bytedance.android.livesdk.floatwindow;

import android.app.Activity;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import androidx.core.content.ContextCompat;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.larus.apm.impl.protector.RunnableProtector;
import rx1.d;
import rx1.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class FloatWindowLifecycle extends BroadcastReceiver implements Application.ActivityLifecycleCallbacks {
    public final boolean a;
    public final Class[] b;
    public final d c;
    public final Handler d;
    public int e;
    public int f;
    public boolean g;

    public class a implements Runnable {
        public final /* synthetic */ FloatWindowLifecycle a;

        @Override // java.lang.Runnable
        public final void run() {
            FloatWindowLifecycle r0 = this.a;     // Catch: Throwable -> L6
            if (r0.f != 0) goto L9;
            r0.g = true;     // Catch: Throwable -> L6
            ((g.a) r0.c).a();     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }

        public a(FloatWindowLifecycle r1) {
            this.a = r1;
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity r1, Bundle r2) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity r1) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity r1, Bundle r2) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity r4) {
        this.f--;
        this.d.postDelayed(new a(this), 300);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity r7) {
        boolean r1 = true;
        this.f++;
        Class[] r0 = this.b;
        if (r0 == null) goto L12;
        int r3 = r0.length;
        int r4 = 0;
    L6:
        if (r4 >= r3) goto L11;
        if (r0[r4].isInstance(r7) == true) goto L9;
        r4 = r4 + 1;
        goto L6
    L9:
        r1 = this.a;
        goto L12
    L11:
        r1 = true ^ this.a;
    L12:
        if (r1 == false) goto L14;
        this.c.getClass();
    L16:
        if (this.g == false) goto L21;
        this.g = false;
        return;
    L21:
        return;
    L14:
        this.c.getClass();
        goto L16
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity r1) {
        this.e++;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity r1) {
        int r2 = this.e - 1;
        this.e = r2;
        if (r2 != 0) goto L6;
        ((g.a) this.c).a();
        return;
    }

    public FloatWindowLifecycle(Context r14, g.a r15) {
        this.a = true;
        this.b = null;
        this.c = r15;
        this.d = new Handler();
        ((Application) r14).registerActivityLifecycleCallbacks(this);
        if (Build.VERSION.SDK_INT < 34) goto L34;
        IntentFilter r16 = new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS");
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L68;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L68:
    L29:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L33;
        ReceiverRegisterCrashOptimizer.registerReceiver(this, r16, 4);
        return;
    L33:
        throw e;
    L9:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L20;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r16) == false) goto L20;
        int r1 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(this, r16, 4, null, null, 3, r14).result;     // Catch: Exception -> L29
        if (r1 == 1) goto L18;
        if (r1 == 2) goto L17;
        if (r1 == 3) goto L67;
        r14.registerReceiver(this, r16, 4);     // Catch: Exception -> L29
    L67:
        return;
    L17:
        new Intent();     // Catch: Exception -> L29
        goto L67
    L18:
        r14.registerReceiver(this, r16, 4);     // Catch: Exception -> L29
    L20:
        if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L23;
        ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L29
        r14.registerReceiver(this, r16, null, ReceiverRegisterLancet.sReceiverHandler);     // Catch: Exception -> L29
        goto L67
    L23:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() != null) goto L25;
    L27:
        r14.registerReceiver(this, r16, 4);     // Catch: Exception -> L29
        goto L67
    L25:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r16) == false) goto L27;
        ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L29
        ContextCompat.registerReceiver(r14, this, r16, null, ReceiverRegisterLancet.sProxyHandler, 4);     // Catch: Exception -> L29
        goto L67
    L34:
        IntentFilter r17 = new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS");
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L65;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L65:
    L58:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L63;
        ReceiverRegisterCrashOptimizer.registerReceiver(this, r17);
        return;
    L63:
        throw e;
    L38:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L49;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r17) == false) goto L49;
        int r2 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(this, r17, 0, null, null, 2, r14).result;     // Catch: Exception -> L58
        if (r2 == 1) goto L47;
        if (r2 == 2) goto L46;
        if (r2 == 3) goto L64;
        r14.registerReceiver(this, r17);     // Catch: Exception -> L58
    L64:
        return;
    L46:
        new Intent();     // Catch: Exception -> L58
        goto L64
    L47:
        r14.registerReceiver(this, r17);     // Catch: Exception -> L58
    L49:
        if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L52;
        ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L58
        r14.registerReceiver(this, r17, null, ReceiverRegisterLancet.sReceiverHandler);     // Catch: Exception -> L58
        goto L64
    L52:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() != null) goto L54;
    L56:
        r14.registerReceiver(this, r17);     // Catch: Exception -> L58
        goto L64
    L54:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r17) == false) goto L56;
        ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L58
        ContextCompat.registerReceiver(r14, this, r17, null, ReceiverRegisterLancet.sProxyHandler, 2);     // Catch: Exception -> L58
        goto L64
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context r2, Intent r3) {
        String r4 = r3.getAction();
        if (r4 != null) goto L5;
        return;
    L5:
        if (r4.equals("android.intent.action.CLOSE_SYSTEM_DIALOGS") == true) goto L7;
        return;
    L7:
        if ("homekey".equals(r3.getStringExtra("reason")) == false) goto L12;
        ((g.a) this.c).a();
        return;
    }
}
