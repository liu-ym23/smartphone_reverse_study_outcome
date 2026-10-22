package com.obric.assistant.activation.presentation.runtime.session.client;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.SystemClock;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.AutoEndConversationTime;
import com.obric.assistant.activation.presentation.contract.ipc.IObricInteractorBridgeService;
import com.obric.assistant.activation.presentation.runtime.manager.ObricListeningChildCoordinator;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class a implements ServiceConnection {
    public static final C0072a i = null;
    public static volatile a j;
    public final ComponentName a;
    public IBinder b;
    public Function1<? super IObricInteractorBridgeService, Unit> c;
    public Function1<? super String, Unit> d;
    public boolean e;
    public Context f;
    public long g;
    public volatile boolean h;

    /* JADX INFO: renamed from: com.obric.assistant.activation.presentation.runtime.session.client.a$a, reason: collision with other inner class name */
    public static final class C0072a {
        public C0072a() {
        }
    }

    static {
        i = new C0072a();
    }

    public final IObricInteractorBridgeService c() {
        IBinder r0 = this.b;
        if (r0 != null) goto L5;
        return null;
    L5:
        if (r0.isBinderAlive() == true) goto L8;
        r0 = null;
    L8:
        if (r0 != null) goto L10;
        return null;
    L10:
        return IObricInteractorBridgeService.Stub.asInterface(r0);
    }

    public final String g() {
        StringBuilder r0 = new StringBuilder("bound=");
        r0.append(this.e);
        r0.append(", binding=");
        r0.append(this.h);
        r0.append(", binderAlive=");
        IBinder r1 = this.b;
        boolean r2 = false;
        if (r1 != null) goto L5;
    L7:
        r0.append(r2);
        return r0.toString();
    L5:
        if (r1.isBinderAlive() != true) goto L7;
        r2 = true;
        goto L7
    }

    public a(ComponentName r1) {
        this.a = r1;
    }

    public final synchronized void a(Context r14) {
        monitor-enter(this);
        boolean r8 = false;
        if (this.h == false) goto L13;
        long r9 = SystemClock.elapsedRealtime() - this.g;     // Catch: Throwable -> L42
        if (r9 >= AutoEndConversationTime.AFTER_10_SECONDS) goto L11;
        FLogger.a.i("ClientServiceConn", "skip bind: request already in progress, " + g());     // Catch: Throwable -> L42
        monitor-exit(this);
        return;
    L11:
        FLogger.a.w("ClientServiceConn", "retry expired bind on real event, ageMs=" + r9 + ", " + g());     // Catch: Throwable -> L42
        this.e = false;     // Catch: Throwable -> L42
        this.h = false;     // Catch: Throwable -> L42
    L13:
        if (this.e == false) goto L17;
        FLogger.a.i("ClientServiceConn", "skip bind: binding already active, " + g());     // Catch: Throwable -> L42
        monitor-exit(this);
        return;
    L17:
        IBinder r4 = this.b;     // Catch: Throwable -> L42
        if (r4 != null) goto L20;
    L22:
        boolean r5 = false;
    L23:
        if (r5 == false) goto L27;
        FLogger.a.i("ClientServiceConn", "skip bind: Binder is alive, " + g());     // Catch: Throwable -> L42
        monitor-exit(this);
        return;
    L27:
        if (r14 != null) goto L31;
        FLogger.a.e("ClientServiceConn", "skip bind: application context is null, " + g());     // Catch: Throwable -> L42
        monitor-exit(this);
        return;
    L31:
        Context r15 = r14.getApplicationContext();     // Catch: Throwable -> L42
        this.f = r15;     // Catch: Throwable -> L42
        Intent r2 = new Intent();     // Catch: Throwable -> L42
        r2.setComponent(this.a);     // Catch: Throwable -> L42
        r2.addFlags(1);     // Catch: Throwable -> L42
        r15.startService(r2);     // Catch: RuntimeException -> L34 Throwable -> L42
        r8 = r15.bindService(r2, this, 32);     // Catch: RuntimeException -> L34 Throwable -> L42
    L36:
        this.h = r8;     // Catch: Throwable -> L42
        if (this.h == false) goto L39;
        this.g = SystemClock.elapsedRealtime();     // Catch: Throwable -> L42
    L39:
        this.e = this.h;     // Catch: Throwable -> L42
        FLogger.a.i("ClientServiceConn", "bindService requested, component=" + this.a.getClassName() + ", accepted=" + this.h);     // Catch: Throwable -> L42
        monitor-exit(this);
        return;
    L34:
        e = move-exception;
        FLogger.a.w("ClientServiceConn", "start/bind service threw, component=" + this.a.getClassName(), e);     // Catch: Throwable -> L42
        goto L36
    L20:
        if (r4.isBinderAlive() != true) goto L22;
        r5 = true;
    L42:
        th = move-exception;
        throw th;
    }

    public final synchronized void b(Context r8) {
        monitor-enter(this);
        Context r2 = this.f;     // Catch: Throwable -> L29
        if (r2 != null) goto L10;
        if (r8 == null) goto L8;
        r2 = r8.getApplicationContext();     // Catch: Throwable -> L29
        goto L10
    L8:
        r2 = null;
    L10:
        if (r2 != null) goto L14;
        FLogger.a.e("ClientServiceConn", "disconnect without application context, force clear local state");     // Catch: Throwable -> L29
        this.b = null;     // Catch: Throwable -> L29
        this.e = false;     // Catch: Throwable -> L29
        this.h = false;     // Catch: Throwable -> L29
        this.f = null;     // Catch: Throwable -> L29
        monitor-exit(this);
        return;
    L14:
        FLogger.a.i("ClientServiceConn", "disconnect start, " + g());     // Catch: Throwable -> L29
        if (this.e == true) goto L33;
    L26:
        this.b = null;     // Catch: Throwable -> L29
        this.e = false;     // Catch: Throwable -> L29
        this.h = false;     // Catch: Throwable -> L29
        this.f = null;     // Catch: Throwable -> L29
        FLogger.a.i("ClientServiceConn", "disconnect complete, " + g());     // Catch: Throwable -> L29
        monitor-exit(this);
        return;
    L33:
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L18
        r2.unbindService(this);     // Catch: Throwable -> L18
        Object r3 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L18
    L21:
        if (Result.isSuccess-impl(r3) == false) goto L23;
        Unit r4 = (Unit) r3;     // Catch: Throwable -> L29
        FLogger.a.i("ClientServiceConn", "unbindService complete");     // Catch: Throwable -> L29
    L23:
        Throwable r5 = Result.exceptionOrNull-impl(r3);     // Catch: Throwable -> L29
        if (r5 == null) goto L26;
        FLogger.a.w("ClientServiceConn", "unbind service failed", r5);     // Catch: Throwable -> L29
    L18:
        th = move-exception;
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L29
        r3 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L29
    L29:
        th = move-exception;
        throw th;
    }

    public final synchronized void d(Context r7) {
        monitor-enter(this);
        FLogger.a.i("ClientServiceConn", "reconnect start, " + g());     // Catch: Throwable -> L22
        Context r1 = this.f;     // Catch: Throwable -> L22
        if (r1 != null) goto L10;
        if (r7 == null) goto L8;
        r1 = r7.getApplicationContext();     // Catch: Throwable -> L22
        goto L10
    L8:
        r1 = null;
    L10:
        if (this.e == false) goto L19;
        if (r1 == null) goto L19;
        Result.Companion r8 = Result.Companion;     // Catch: Throwable -> L14
        r1.unbindService(this);     // Catch: Throwable -> L14
        Object r9 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L14
    L16:
        Throwable r10 = Result.exceptionOrNull-impl(r9);     // Catch: Throwable -> L22
        if (r10 == null) goto L19;
        FLogger.a.w("ClientServiceConn", "unbind before reconnect failed", r10);     // Catch: Throwable -> L22
        goto L19
    L14:
        th = move-exception;
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L22
        r9 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L22
    L19:
        this.b = null;     // Catch: Throwable -> L22
        this.e = false;     // Catch: Throwable -> L22
        this.h = false;     // Catch: Throwable -> L22
        a(r1);     // Catch: Throwable -> L22
        FLogger.a.i("ClientServiceConn", "reconnect requested, " + g());     // Catch: Throwable -> L22
        monitor-exit(this);
        return;
    L22:
        th = move-exception;
        throw th;
    }

    public final synchronized void e(d r6) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r6, "listener");     // Catch: Throwable -> L13
        this.c = r6;     // Catch: Throwable -> L13
        IObricInteractorBridgeService r1 = c();     // Catch: Throwable -> L13
        FLogger r2 = FLogger.a;     // Catch: Throwable -> L13
        StringBuilder r4 = new StringBuilder("setConnectedListener, dispatchImmediately=");     // Catch: Throwable -> L13
        if (r1 == null) goto L7;
        boolean r0 = true;
    L8:
        r4.append(r0);     // Catch: Throwable -> L13
        r2.i("ClientServiceConn", r4.toString());     // Catch: Throwable -> L13
        if (r1 == null) goto L11;
        r6.invoke(r1);     // Catch: Throwable -> L13
    L11:
        monitor-exit(this);
        return;
    L7:
        r0 = false;
    L13:
        th = move-exception;
        throw th;
    }

    public final synchronized void f(c r2) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r2, "listener");     // Catch: Throwable -> L6
        this.d = r2;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // android.content.ServiceConnection
    public final void onBindingDied(ComponentName r7) {
        FLogger r0 = FLogger.a;
        StringBuilder r1 = new StringBuilder("onBindingDied, component=");
        if (r7 == null) goto L5;
        String r3 = r7.getClassName();
    L6:
        r1.append(r3);
        r1.append("; release binding and wait for real event");
        r0.w("ClientServiceConn", r1.toString());
        Function1<? super String, Unit> r2 = this.d;
        if (r2 == null) goto L9;
        r2.invoke("binding_died");
    L9:
        this.h = false;
        this.b = null;
        Context r4 = this.f;
        if (this.e == false) goto L20;
        if (r4 == null) goto L20;
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L14
        r4.unbindService(this);     // Catch: Throwable -> L14
        Object r6 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L14
    L16:
        Throwable r8 = Result.exceptionOrNull-impl(r6);
        if (r8 == null) goto L19;
        FLogger.a.w("ClientServiceConn", "unbind dead binding failed", r8);
    L19:
        this.e = false;
    L14:
        th = move-exception;
        Result.Companion r9 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
    L20:
        this.b = null;
        this.e = false;
        this.h = false;
        this.f = null;
        super.onBindingDied(r7);
        return;
    L5:
        r3 = null;
        goto L6
    }

    @Override // android.content.ServiceConnection
    public final void onNullBinding(ComponentName r5) {
        this.h = false;
        String r0 = null;
        this.b = null;
        FLogger r1 = FLogger.a;
        StringBuilder r2 = new StringBuilder("onNullBinding, component=");
        if (r5 == null) goto L5;
        r0 = r5.getClassName();
    L5:
        r2.append(r0);
        r2.append("; release unusable binding");
        r1.w("ClientServiceConn", r2.toString());
        Function1<? super String, Unit> r6 = this.d;
        if (r6 == null) goto L8;
        r6.invoke("null_binding");
    L8:
        b(this.f);
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName r4) {
        FLogger r0 = FLogger.a;
        StringBuilder r1 = new StringBuilder("onServiceDisconnected, component=");
        if (r4 == null) goto L5;
        String r5 = r4.getClassName();
    L6:
        r1.append(r5);
        r1.append(", release binding; ");
        r1.append(g());
        r0.w("ClientServiceConn", r1.toString());
        Function1<? super String, Unit> r6 = this.d;
        if (r6 == null) goto L9;
        r6.invoke("service_disconnected");
    L9:
        ObricListeningChildCoordinator.a.getClass();
        ObricListeningChildCoordinator.i(new com.obric.assistant.activation.presentation.runtime.manager.p());
        b(this.f);
        return;
    L5:
        r5 = null;
        goto L6
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName r6, IBinder r7) {
        boolean r0 = false;
        this.h = false;
        this.e = true;
        this.b = r7;
        FLogger r2 = FLogger.a;
        StringBuilder r3 = new StringBuilder("onServiceConnected, component=");
        if (r6 == null) goto L5;
        String r8 = r6.getClassName();
    L6:
        r3.append(r8);
        r3.append(", hasBinder=");
        if (r7 == null) goto L9;
        boolean r9 = true;
    L10:
        r3.append(r9);
        r3.append(", binderAlive=");
        if (r7 != null) goto L13;
    L15:
        boolean r10 = false;
    L16:
        r3.append(r10);
        r3.append(", hasListener=");
        if (this.c == null) goto L19;
        r0 = true;
    L19:
        r3.append(r0);
        r2.i("ClientServiceConn", r3.toString());
        IObricInteractorBridgeService r11 = IObricInteractorBridgeService.Stub.asInterface(r7);
        if (r11 != null) goto L23;
        r2.w("ClientServiceConn", "connected Binder cannot resolve bridge interface");
        return;
    L23:
        Function1<? super IObricInteractorBridgeService, Unit> r12 = this.c;
        if (r12 == null) goto L27;
        r12.invoke(r11);
        return;
    L27:
        return;
    L13:
        if (r7.isBinderAlive() != true) goto L15;
        r10 = true;
        goto L16
    L9:
        r9 = false;
        goto L10
    L5:
        r8 = null;
        goto L6
    }
}
