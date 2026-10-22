package com.obric.assistant.dora;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.larus.utils.logger.FLogger;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class e {
    public static final e a = null;
    public static final CopyOnWriteArrayList<a> b = null;
    public static volatile Context c;
    public static volatile IDoraMainProcessBridgeService d;
    public static volatile boolean e;
    public static volatile boolean f;
    public static final b g = null;

    public interface a {
        void a();

        void b();
    }

    public static final class b implements ServiceConnection {
        public b() {
        }

        @Override // android.content.ServiceConnection
        public final void onBindingDied(ComponentName r4) {
            FLogger r0 = FLogger.a;
            r0.w("DoraInteractorBridgeHub", "bridge onBindingDied: name=" + r4);
            e r5 = e.a;
            r5.getClass();
            e.c();
            e.a(r5);
            if (e.f == true) goto L5;
            r0.i("DoraInteractorBridgeHub", "rebindMainProcessBridgeServiceIfNeeded skipped: no active demand");
            return;
        L5:
            e.b();
        }

        @Override // android.content.ServiceConnection
        public final void onNullBinding(ComponentName r4) {
            FLogger.a.w("DoraInteractorBridgeHub", "bridge onNullBinding: name=" + r4);
            e r5 = e.a;
            r5.getClass();
            e.c();
            e.a(r5);
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName r4) {
            FLogger r0 = FLogger.a;
            r0.w("DoraInteractorBridgeHub", "bridge onServiceDisconnected: name=" + r4);
            e r5 = e.a;
            r5.getClass();
            e.c();
            e.a(r5);
            if (e.f == true) goto L5;
            r0.i("DoraInteractorBridgeHub", "rebindMainProcessBridgeServiceIfNeeded skipped: no active demand");
            return;
        L5:
            e.b();
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName r4, IBinder r5) {
            FLogger r0 = FLogger.a;
            r0.i("DoraInteractorBridgeHub", "bridge onServiceConnected: name=" + r4);
            IDoraMainProcessBridgeService r6 = IDoraMainProcessBridgeService.Stub.asInterface(r5);
            e r7 = e.a;
            e.d = r6;
            e.e = true;
            if (r6 != null) goto L18;
            r0.e("DoraInteractorBridgeHub", "bridge onServiceConnected failed: binder is null");
            return;
        L18:
            Result.Companion r8 = Result.Companion;     // Catch: Throwable -> L12
            int r9 = r6.getStateSnapshot().a;     // Catch: Throwable -> L12
            e.a.getClass();     // Catch: Throwable -> L12
            Iterator<a> r10 = e.b.iterator();     // Catch: Throwable -> L12
        L8:
            if (r10.hasNext() == false) goto L10;
            a r11 = r10.next();     // Catch: Throwable -> L12
            e r1 = e.a;     // Catch: Throwable -> L12
            Intrinsics.checkNotNull(r11);     // Catch: Throwable -> L12
            r1.getClass();     // Catch: Throwable -> L12
            e.d(r11);     // Catch: Throwable -> L12
            goto L8
        L10:
            Object r12 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L12
        L14:
            Throwable r13 = Result.exceptionOrNull-impl(r12);
            if (r13 == null) goto L21;
            FLogger.a.e("DoraInteractorBridgeHub", "bridge onServiceConnected init failed: " + r13.getMessage());
            return;
        L21:
            return;
        L12:
            th = move-exception;
            Result.Companion r14 = Result.Companion;
            r12 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L14
        }
    }

    public e() {
    }

    public static void c() {
        d = null;
        e = false;
    }

    static {
        a = new e();
        b = new CopyOnWriteArrayList();
        g = new b();
    }

    public static void b() {
        if (e == false) goto L5;
        return;
    L5:
        Context r0 = c;
        if (r0 != null) goto L9;
        FLogger.a.e("DoraInteractorBridgeHub", "bindMainProcessBridgeService failed: applicationContext is null");
        return;
    L9:
        Intent r2 = new Intent(r0, DoraMainProcessBridgeService.class);
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L12
        FLogger.a.i("DoraInteractorBridgeHub", "bindMainProcessBridgeService startService before bindService");     // Catch: Throwable -> L12
        r0.startService(r2);     // Catch: Throwable -> L12
        Object r1 = Result.constructor-impl(Boolean.valueOf(r0.bindService(r2, g, 1)));     // Catch: Throwable -> L12
    L14:
        Throwable r4 = Result.exceptionOrNull-impl(r1);
        if (r4 == null) goto L18;
        FLogger.a.e("DoraInteractorBridgeHub", "bindMainProcessBridgeService failed: " + r4.getMessage());
        r1 = Boolean.FALSE;
    L18:
        e = ((Boolean) r1).booleanValue();
        FLogger.a.i("DoraInteractorBridgeHub", "bindMainProcessBridgeService: isBridgeBound=" + e);
        return;
    L12:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L14
    }

    public static final void a(e r4) {
        r4.getClass();
        Iterator<a> r5 = b.iterator();
    L4:
        if (r5.hasNext() == false) goto L13;
        a r0 = r5.next();
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L8
        r0.b();     // Catch: Throwable -> L8
        Object r2 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L8
    L10:
        Throwable r3 = Result.exceptionOrNull-impl(r2);
        if (r3 == null) goto L4;
        FLogger.a.e("DoraInteractorBridgeHub", "notifyBridgeUnavailable failed: " + r3.getMessage());
    L8:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        r2 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L10
    }

    public static void d(a r3) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        r3.a();     // Catch: Throwable -> L4
        Object r4 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L4
    L6:
        Throwable r5 = Result.exceptionOrNull-impl(r4);
        if (r5 == null) goto L12;
        FLogger.a.e("DoraInteractorBridgeHub", "notifySingleBridgeAvailable failed: " + r5.getMessage());
        return;
    L12:
        return;
    L4:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        r4 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L6
    }
}
