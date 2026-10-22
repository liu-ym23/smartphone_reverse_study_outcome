package com.bytedance.badger.network;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.core.content.ContextCompat;
import com.bytedance.badger.e;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class j0 {
    public final Set a;
    public final AtomicBoolean b;
    public final Context c;

    public j0(Context r3) {
        this.a = Collections.synchronizedSet(new HashSet());
        this.b = new AtomicBoolean(false);
        this.c = r3;
    }

    public final synchronized void c(i0 r4) {
        monitor-enter(this);
        Iterator r0 = this.a.iterator();     // Catch: Throwable -> L13 Exception -> L15
        e.f("NetObserver#", "unObserve");     // Catch: Throwable -> L13 Exception -> L15
    L5:
        if (r0.hasNext() == false) goto L17;
        WeakReference r1 = (WeakReference) r0.next();     // Catch: Throwable -> L13 Exception -> L15
        if (r1 == null) goto L8;
        if (((i0) r1.get()) != r4) goto L5;
        r0.remove();     // Catch: Throwable -> L13 Exception -> L15
    L8:
        r0.remove();     // Catch: Throwable -> L13 Exception -> L15
    L17:
        monitor-exit(this);
        return;
    L15:
        e = move-exception;
        e.c("NetObserver#", "unObserve error", e);     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;
    }

    public final synchronized void b(t0 r3) {
        monitor-enter(this);
        this.a.add(new WeakReference(r3));     // Catch: Throwable -> L12
        if (this.b.compareAndSet(false, true) == false) goto L10;
        h0 r4 = new h0(this);     // Catch: Throwable -> L12
        IntentFilter r0 = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");     // Catch: Throwable -> L12
        a(this.c, r4, r0);     // Catch: Exception -> L8 Throwable -> L12
    L8:
        e = move-exception;
        e.c("NetObserver#", "net observer error", e);     // Catch: Throwable -> L12
    L10:
        monitor-exit(this);
        return;
    L12:
        th = move-exception;
        throw th;
    }

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static void a(Context r8, h0 r9, IntentFilter r10) {
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L39;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L39:
    L33:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L38;
        ReceiverRegisterCrashOptimizer.registerReceiver(r9, r10);
        return;
    L38:
        throw e;
    L6:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L22;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r10) == false) goto L22;
        int r0 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r9, r10, 0, null, null, 2, r8).result;     // Catch: Exception -> L33
        if (r0 != 1) goto L12;
        r8.registerReceiver(r9, r10);     // Catch: Exception -> L33
        return;
    L12:
        if (r0 != 2) goto L14;
        new Intent();     // Catch: Exception -> L33
        return;
    L14:
        if (r0 == 3) goto L40;
        r8.registerReceiver(r9, r10);     // Catch: Exception -> L33
        return;
    L40:
        return;
    L22:
        if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L26;
        ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L33
        r8.registerReceiver(r9, r10, null, ReceiverRegisterLancet.sReceiverHandler);     // Catch: Exception -> L33
        return;
    L26:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() != null) goto L28;
    L31:
        r8.registerReceiver(r9, r10);     // Catch: Exception -> L33
        return;
    L28:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r10) == false) goto L31;
        ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L33
        ContextCompat.registerReceiver(r8, r9, r10, null, ReceiverRegisterLancet.sProxyHandler, 2);     // Catch: Exception -> L33
    }
}
