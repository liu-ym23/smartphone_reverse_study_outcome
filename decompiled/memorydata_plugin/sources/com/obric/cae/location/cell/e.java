package com.obric.cae.location.cell;

import android.os.IBinder;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.os.SystemClock;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f7040a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicBoolean f7041b;
    public final a c;
    public boolean d;
    public IBinder e;
    public vendor.a.a.a f;
    public int g;
    public ExecutorService h;
    public final IBinder.DeathRecipient i;
    public final vendor.a.a.b j;

    public interface a {
        void onCellPoiStatusChange(int r1, int r2, int r3, int r4, long r5, int r7);
    }

    public e(a r3) {
        a r4 = (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.memorydata.plugin");
        this.f7040a = new Object();
        this.f7041b = new AtomicBoolean(false);
        this.i = new $$Lambda$e$y7qswcfnRIODBnKMNNY0Aa3e1_k(this);
        this.j = new AnonymousClass1(this);
        this.c = r4;
    }

    private /* synthetic */ void e() {
        d();     // Catch: Throwable -> L6
        this.f7041b.set(false);
        return;
    L6:
        th = move-exception;
        this.f7041b.set(false);
        throw th;
    }

    private void f() {
        com.obric.cae.log.a.g("StarLocation-wwansensor", "ISensorNotify binder died");
        Object r0 = this.f7040a;
        monitor-enter(r0);
        this.e = null;     // Catch: Throwable -> L9
        this.f = null;     // Catch: Throwable -> L9
        this.g = 0;     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        c();
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public static /* synthetic */ void lambda$1R3f7Jau81kmumV5abIYSgFqxnI(e r0) {
        r0.e();
    }

    public static /* synthetic */ void lambda$y7qswcfnRIODBnKMNNY0Aa3e1_k(e r0) {
        r0.f();
    }

    public final void a() {
        Object r0 = this.f7040a;
        monitor-enter(r0);
        this.d = true;     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        c();
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public final void b() {
        Object r0 = this.f7040a;
        monitor-enter(r0);
        this.d = false;     // Catch: Throwable -> L20
        vendor.a.a.a r2 = this.f;     // Catch: Throwable -> L20
        if (r2 == null) goto L13;
        int r3 = this.g;     // Catch: Throwable -> L20
        if (r3 <= 0) goto L13;
        r2.a(r3);     // Catch: RemoteException -> L11 Throwable -> L20
    L11:
        e = move-exception;
        com.obric.cae.log.a.a("StarLocation-wwansensor", "ISensorNotify unregisterCallback failed", e);     // Catch: Throwable -> L20
    L13:
        IBinder r4 = this.e;     // Catch: Throwable -> L20
        if (r4 == null) goto L17;
        r4.unlinkToDeath(this.i, 0);     // Catch: Throwable -> L23
    L17:
        this.e = null;     // Catch: Throwable -> L20
        this.f = null;     // Catch: Throwable -> L20
        this.g = 0;     // Catch: Throwable -> L20
        monitor-exit(r0);     // Catch: Throwable -> L20
        return;
    L20:
        th = move-exception;
        throw th;
    }

    public final void c() {
        Object r0 = this.f7040a;
        monitor-enter(r0);
    L40:
        th = move-exception;
        throw th;
    L5:
        if (this.d == true) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L40
        return;
    L9:
        if (this.f != null) goto L11;
    L22:
        boolean r1 = false;
    L23:
        if (r1 == false) goto L27;
        monitor-exit(r0);     // Catch: Throwable -> L40
        return;
    L27:
        if (this.f7041b.compareAndSet(false, true) == true) goto L31;
        monitor-exit(r0);     // Catch: Throwable -> L40
        return;
    L31:
        if (this.h != null) goto L33;
        this.h = Executors.newSingleThreadExecutor();     // Catch: Throwable -> L40
    L33:
        ExecutorService r2 = this.h;     // Catch: Throwable -> L40
        monitor-exit(r0);     // Catch: Throwable -> L40
        r2.execute(new $$Lambda$e$1R3f7Jau81kmumV5abIYSgFqxnI(this));     // Catch: Throwable -> L37
        return;
    L37:
        th = move-exception;
        this.f7041b.set(false);
        throw th;
    L11:
        if (this.g <= 0) goto L22;
        IBinder r3 = this.e;     // Catch: Throwable -> L40
        if (r3 != null) goto L15;
    L19:
        boolean r4 = false;
    L20:
        if (r4 == false) goto L22;
        r1 = true;
        goto L23
    L15:
        if (r3.isBinderAlive() == false) goto L19;
        if (this.e.pingBinder() == false) goto L19;
        r4 = true;
        goto L20
    }

    public final void d() {
        int r1 = 1;
    L4:
        if (r1 > 3) goto L100;
        Object r3 = this.f7040a;
        monitor-enter(r3);
    L97:
        th = move-exception;
        throw th;
    L8:
        if (this.d == false) goto L9;
        if (this.f != null) goto L14;
    L25:
        boolean r4 = false;
    L26:
        if (r4 == true) goto L27;
        IBinder r5 = this.e;     // Catch: Throwable -> L97
        if (r5 == null) goto L40;
        if (r5 != null) goto L33;
    L37:
        boolean r6 = false;
    L38:
        if (r6 == true) goto L40;
        this.e = null;     // Catch: Throwable -> L97
        this.f = null;     // Catch: Throwable -> L97
        this.g = 0;     // Catch: Throwable -> L97
        goto L40
    L33:
        if (r5.isBinderAlive() == false) goto L37;
        if (this.e.pingBinder() == false) goto L37;
        r6 = true;
    L40:
        monitor-exit(r3);     // Catch: Throwable -> L97
        IBinder r7 = ServiceManager.getService("vendor.bytedance.wwansensor.ISensorNotify/default");
        if (r7 != null) goto L45;
        if (r1 >= 3) goto L119;
    L44:
        SystemClock.sleep(5000);
    L119:
        r1 = r1 + 1;     // Catch: Throwable -> L94
    L94:
        th = move-exception;
        throw th;
    L45:
        Object r8 = this.f7040a;
        monitor-enter(r8);
        if (this.d == false) goto L49;
        if (this.f != null) goto L54;
    L65:
        boolean r9 = false;
    L66:
        if (r9 == true) goto L67;
        this.e = r7;     // Catch: Throwable -> L94
        r7.linkToDeath(this.i, 0);     // Catch: Throwable -> L72
    L74:
        vendor.a.a.a r10 = vendor.a.a.a.AbstractBinderC0905a.a(this.e);     // Catch: Throwable -> L94
        this.f = r10;     // Catch: Throwable -> L94
        if (r10 != null) goto L115;
        com.obric.cae.log.a.g("StarLocation-wwansensor", "ISensorNotify service is null");     // Catch: Throwable -> L94
        this.e = null;     // Catch: Throwable -> L94
        this.f = null;     // Catch: Throwable -> L94
    L77:
        this.g = 0;     // Catch: Throwable -> L94
        monitor-exit(r8);     // Catch: Throwable -> L94
        if (r1 >= 3) goto L119;
    L115:
        this.g = r10.a(this.j);     // Catch: RemoteException -> L87 Throwable -> L94
        com.obric.cae.log.a.e("StarLocation-wwansensor", "ISensorNotify connected, clientId=" + this.g);     // Catch: RemoteException -> L87 Throwable -> L94
        int r11 = this.g;     // Catch: RemoteException -> L87 Throwable -> L94
        if (r11 > 0) goto L113;
    L89:
        this.e = null;     // Catch: Throwable -> L94
        this.f = null;     // Catch: Throwable -> L94
        goto L77
    L113:
        this.f.a(r11, 0, 2, true);     // Catch: RemoteException -> L83 Throwable -> L94
        com.obric.cae.log.a.e("StarLocation-wwansensor", "ISensorNotify startOemSensor enable store, clientId=" + this.g + ", dbType=2");     // Catch: RemoteException -> L83 Throwable -> L94
    L85:
        monitor-exit(r8);     // Catch: Throwable -> L94
        return;
    L83:
        e = move-exception;
        com.obric.cae.log.a.a("StarLocation-wwansensor", "ISensorNotify startOemSensor failed", e);     // Catch: RemoteException -> L87 Throwable -> L94
    L87:
        e = move-exception;
        com.obric.cae.log.a.a("StarLocation-wwansensor", "ISensorNotify registerCallback failed", e);     // Catch: Throwable -> L94
        goto L89
    L72:
        th = move-exception;
        com.obric.cae.log.a.a("StarLocation-wwansensor", "ISensorNotify linkToDeath failed", th);     // Catch: Throwable -> L94
        goto L74
    L67:
        monitor-exit(r8);     // Catch: Throwable -> L94
        return;
    L54:
        if (this.g <= 0) goto L65;
        IBinder r12 = this.e;     // Catch: Throwable -> L94
        if (r12 != null) goto L58;
    L62:
        boolean r13 = false;
    L63:
        if (r13 == false) goto L65;
        r9 = true;
        goto L66
    L58:
        if (r12.isBinderAlive() == false) goto L62;
        if (this.e.pingBinder() == false) goto L62;
        r13 = true;
        goto L63
    L49:
        monitor-exit(r8);     // Catch: Throwable -> L94
        return;
    L27:
        monitor-exit(r3);     // Catch: Throwable -> L97
        return;
    L14:
        if (this.g <= 0) goto L25;
        IBinder r14 = this.e;     // Catch: Throwable -> L97
        if (r14 != null) goto L18;
    L22:
        boolean r15 = false;
    L23:
        if (r15 == false) goto L25;
        r4 = true;
        goto L26
    L18:
        if (r14.isBinderAlive() == false) goto L22;
        if (this.e.pingBinder() == false) goto L22;
        r15 = true;
        goto L23
    L9:
        monitor-exit(r3);     // Catch: Throwable -> L97
        return;
    L100:
        Object r0 = this.f7040a;
        monitor-enter(r0);
    L107:
        th = move-exception;
        throw th;
    L103:
        if (this.d == false) goto L105;
        com.obric.cae.log.a.g("StarLocation-wwansensor", "ISensorNotify still not available: vendor.bytedance.wwansensor.ISensorNotify/default");     // Catch: Throwable -> L107
    L105:
        monitor-exit(r0);     // Catch: Throwable -> L107
    }
}
