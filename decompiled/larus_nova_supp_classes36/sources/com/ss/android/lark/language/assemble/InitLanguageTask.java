package com.ss.android.lark.language.assemble;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.core.content.ContextCompat;
import apb.b;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.larksuite.framework.launch.task.AbstractLaunchTask;
import com.ss.android.lark.appcontext.applifecycle.q;
import com.ss.android.lark.language.service.impl.SystemLocaleChangeReceiver;
import com.ss.android.lark.language.service.impl.a;
import com.ss.android.lark.log.Log;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import yob.c;
import yob.d;
import yob.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class InitLanguageTask extends AbstractLaunchTask {
    public InitLanguageTask() {
    }

    public final void a(Context r11) {
        if ((r11 instanceof Application) == false) goto L36;
        d r0 = e.a();
        Application r12 = (Application) r11;
        r0.getClass();
        int r1 = a.f;
        b r2 = a.b.a;
        r2.l(r12);
        r2.f(r12, new yob.b(r0, r12));
        SystemLocaleChangeReceiver r8 = new SystemLocaleChangeReceiver();
        IntentFilter r9 = new IntentFilter("android.intent.action.LOCALE_CHANGED");
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L38;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L38:
    L30:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L35;
        ReceiverRegisterCrashOptimizer.registerReceiver(r8, r9);
    L34:
        Object r13 = q.c;
        q r14 = q.a.a;
        c r3 = new c(r0);
        Map r15 = r14.a;
        ConcurrentHashMap r16 = (ConcurrentHashMap) r15;
        r16.put(r3, q.c);
        return;
    L35:
        throw e;
    L8:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L21;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r9) == false) goto L21;
        int r4 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r8, r9, 0, null, null, 2, r12).result;     // Catch: Exception -> L30
        if (r4 != 1) goto L14;
        r12.registerReceiver(r8, r9);     // Catch: Exception -> L30
        goto L34
    L14:
        if (r4 != 2) goto L16;
        new Intent();     // Catch: Exception -> L30
        goto L34
    L16:
        if (r4 == 3) goto L34;
        r12.registerReceiver(r8, r9);     // Catch: Exception -> L30
    L21:
        if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L24;
        ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L30
        r12.registerReceiver(r8, r9, null, ReceiverRegisterLancet.sReceiverHandler);     // Catch: Exception -> L30
        goto L34
    L24:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() != null) goto L26;
    L28:
        r12.registerReceiver(r8, r9);     // Catch: Exception -> L30
        goto L34
    L26:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r9) == false) goto L28;
        ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L30
        ContextCompat.registerReceiver(r12, r8, r9, null, ReceiverRegisterLancet.sProxyHandler, 2);     // Catch: Exception -> L30
        goto L34
    L36:
        Log.e("InitLanguageTask", new IllegalArgumentException("initLanguage failed! not application context"));
    }
}
