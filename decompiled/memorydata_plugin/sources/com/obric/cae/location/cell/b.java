package com.obric.cae.location.cell;

import android.os.IBinder;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.os.SystemClock;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile b f7030a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f7031b;
    public final AtomicBoolean c;
    public final ExecutorService d;
    public final ArrayList e;
    public final ArrayList f;
    public IBinder g;
    public com.bytedance.radioservice.a.b h;
    public int i;
    public int j;
    public final IBinder.DeathRecipient k;
    public final com.bytedance.radioservice.a.a l;
    public final com.bytedance.radioservice.a.c m;

    public interface a {
        void onCellPoiStatusChange(int r1, int r2, int r3, long r4, int r6, String r7);
    }

    /* JADX INFO: renamed from: com.obric.cae.location.cell.b$b, reason: collision with other inner class name */
    public interface InterfaceC0350b {
        void onHighConfidenceCellPoiStatusChange(int r1, String r2);
    }

    public b() {
        this.f7031b = new Object();
        this.c = new AtomicBoolean(false);
        this.d = Executors.newSingleThreadExecutor();
        this.e = new ArrayList();
        this.f = new ArrayList();
        this.k = new $$Lambda$b$RyoHJHQB8KmxRRZLS6bJ0Q6JrQ(this);
        this.l = new AnonymousClass1(this);
        this.m = new AnonymousClass2(this);
    }

    public static b a() {
        if (f7030a != null) goto L15;
        monitor-enter(b.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f7030a != null) goto L9;
        f7030a = new b();     // Catch: Throwable -> L11
    L9:
        monitor-exit(b.class);     // Catch: Throwable -> L11
    L15:
        return f7030a;
    }

    private /* synthetic */ void g() {
        d();     // Catch: Throwable -> L6
        this.c.set(false);
        return;
    L6:
        th = move-exception;
        this.c.set(false);
        throw th;
    }

    private void h() {
        com.obric.cae.log.a.g("StarLocation-cellpoiService", "ICellPoiService binderDied");
        Object r0 = this.f7031b;
        monitor-enter(r0);
        this.g = null;     // Catch: Throwable -> L10
        this.h = null;     // Catch: Throwable -> L10
        this.i = 0;     // Catch: Throwable -> L10
        this.j = 0;     // Catch: Throwable -> L10
        boolean r1 = e();     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        if (r1 == false) goto L15;
        c();
        return;
    L15:
        return;
    L10:
        th = move-exception;
        throw th;
    }

    /* JADX INFO: renamed from: lambda$RyoHJHQ-B8KmxRRZLS6bJ0Q6JrQ, reason: not valid java name */
    public static /* synthetic */ void m374lambda$RyoHJHQB8KmxRRZLS6bJ0Q6JrQ(b r0) {
        r0.h();
    }

    public static /* synthetic */ void lambda$xgpXhZKM2XM4rkZ8BFrTcAaYWHk(b r0) {
        r0.g();
    }

    public final void a(com.bytedance.radioservice.a.b r5) {
        com.bytedance.radioservice.a.b r6 = (com.bytedance.radioservice.a.b) ZeusTransformUtils.wrapperContextForParams(r5, com.bytedance.radioservice.a.b.class, "com.obric.memorydata.plugin");
        Object r1 = this.f7031b;
        monitor-enter(r1);
    L47:
        th = move-exception;
        throw th;
    L5:
        if (e() == true) goto L7;
    L45:
        monitor-exit(r1);     // Catch: Throwable -> L47
        return;
    L7:
        if (this.h != r6) goto L45;
        monitor-exit(r1);     // Catch: Throwable -> L47
        if (this.e.isEmpty() == true) goto L28;
        if (this.i > 0) goto L28;
        int r2 = r6.a(this.l);     // Catch: RemoteException -> L25
        Object r3 = this.f7031b;     // Catch: RemoteException -> L25
        monitor-enter(r3);     // Catch: RemoteException -> L25
    L22:
        th = move-exception;
        throw th;     // Catch: RemoteException -> L25
    L17:
        if (this.h != r6) goto L19;
        this.i = r2;     // Catch: Throwable -> L22
    L19:
        monitor-exit(r3);     // Catch: Throwable -> L22
        com.obric.cae.log.a.e("StarLocation-cellpoiService", "ICellPoiService registerCallback ok, clientId=" + r2);     // Catch: RemoteException -> L25
        goto L28
    L25:
        e = move-exception;
        com.obric.cae.log.a.a("StarLocation-cellpoiService", "ICellPoiService registerCallback failed", e);
    L28:
        if (this.f.isEmpty() == false) goto L30;
        return;
    L30:
        if (this.j > 0) goto L58;
        int r0 = r6.a(this.m);     // Catch: RemoteException -> L42
        Object r4 = this.f7031b;     // Catch: RemoteException -> L42
        monitor-enter(r4);     // Catch: RemoteException -> L42
    L39:
        th = move-exception;
        throw th;     // Catch: RemoteException -> L42
    L34:
        if (this.h != r6) goto L36;
        this.j = r0;     // Catch: Throwable -> L39
    L36:
        monitor-exit(r4);     // Catch: Throwable -> L39
        com.obric.cae.log.a.e("StarLocation-cellpoiService", "ICellPoiService registerHighConfidenceCallback ok, clientId=" + r0);     // Catch: RemoteException -> L42
        return;
    L42:
        e = move-exception;
        com.obric.cae.log.a.a("StarLocation-cellpoiService", "ICellPoiService registerHighConfidenceCallback failed", e);
        return;
    }

    public void a(a r3) {
        a r4 = (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.memorydata.plugin");
        Object r0 = this.f7031b;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.e.contains(r4) == true) goto L7;
        this.e.add(r4);     // Catch: Throwable -> L10
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L10
        c();
    }

    public void a(InterfaceC0350b r3) {
        InterfaceC0350b r4 = (InterfaceC0350b) ZeusTransformUtils.wrapperContextForParams(r3, InterfaceC0350b.class, "com.obric.memorydata.plugin");
        Object r0 = this.f7031b;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.f.contains(r4) == true) goto L7;
        this.f.add(r4);     // Catch: Throwable -> L10
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L10
        c();
    }

    public final boolean a(IBinder r4, com.bytedance.radioservice.a.b r5) {
        IBinder r6 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r4, IBinder.class, "com.obric.memorydata.plugin");
        com.bytedance.radioservice.a.b r7 = (com.bytedance.radioservice.a.b) ZeusTransformUtils.wrapperContextForParams(r5, com.bytedance.radioservice.a.b.class, "com.obric.memorydata.plugin");
        Object r0 = this.f7031b;
        monitor-enter(r0);
    L19:
        th = move-exception;
        throw th;
    L5:
        if (e() == true) goto L8;
        monitor-exit(r0);     // Catch: Throwable -> L19
        return false;
    L8:
        if (r6 != null) goto L10;
    L16:
        this.h = r7;     // Catch: Throwable -> L19
        monitor-exit(r0);     // Catch: Throwable -> L19
        return true;
    L10:
        if (this.g == r6) goto L16;
        this.g = r6;     // Catch: Throwable -> L19
        r6.linkToDeath(this.k, 0);     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        com.obric.cae.log.a.a("StarLocation-cellpoiService", "ICellPoiService linkToDeath failed", th);     // Catch: Throwable -> L19
        goto L16
    }

    public final void b() {
        Object r0 = this.f7031b;
        monitor-enter(r0);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (e() == false) goto L8;
        monitor-exit(r0);     // Catch: Throwable -> L13
        return;
    L8:
        IBinder r1 = this.g;     // Catch: Throwable -> L13
        this.g = null;     // Catch: Throwable -> L13
        this.h = null;     // Catch: Throwable -> L13
        this.i = 0;     // Catch: Throwable -> L13
        this.j = 0;     // Catch: Throwable -> L13
        monitor-exit(r0);     // Catch: Throwable -> L13
        if (r1 == null) goto L20;
        r1.unlinkToDeath(this.k, 0);     // Catch: Throwable -> L16
        return;
    L21:
        return;
    }

    public void b(a r4) {
        a r5 = (a) ZeusTransformUtils.wrapperContextForParams(r4, a.class, "com.obric.memorydata.plugin");
        Object r0 = this.f7031b;
        monitor-enter(r0);
        this.e.remove(r5);     // Catch: Throwable -> L18
        if (this.e.isEmpty() == true) goto L8;
        monitor-exit(r0);     // Catch: Throwable -> L18
        return;
    L8:
        com.bytedance.radioservice.a.b r6 = this.h;     // Catch: Throwable -> L18
        int r1 = this.i;     // Catch: Throwable -> L18
        this.i = 0;     // Catch: Throwable -> L18
        monitor-exit(r0);     // Catch: Throwable -> L18
        if (r6 == null) goto L16;
        if (r1 <= 0) goto L16;
        r6.a(r1);     // Catch: RemoteException -> L14
    L14:
        e = move-exception;
        com.obric.cae.log.a.a("StarLocation-cellpoiService", "ICellPoiService unregisterCallback failed", e);
    L16:
        b();
        return;
    L18:
        th = move-exception;
        throw th;
    }

    public void b(InterfaceC0350b r4) {
        InterfaceC0350b r5 = (InterfaceC0350b) ZeusTransformUtils.wrapperContextForParams(r4, InterfaceC0350b.class, "com.obric.memorydata.plugin");
        Object r0 = this.f7031b;
        monitor-enter(r0);
        this.f.remove(r5);     // Catch: Throwable -> L18
        if (this.f.isEmpty() == true) goto L8;
        monitor-exit(r0);     // Catch: Throwable -> L18
        return;
    L8:
        com.bytedance.radioservice.a.b r6 = this.h;     // Catch: Throwable -> L18
        int r1 = this.j;     // Catch: Throwable -> L18
        this.j = 0;     // Catch: Throwable -> L18
        monitor-exit(r0);     // Catch: Throwable -> L18
        if (r6 == null) goto L16;
        if (r1 <= 0) goto L16;
        r6.b(r1);     // Catch: RemoteException -> L14
    L14:
        e = move-exception;
        com.obric.cae.log.a.a("StarLocation-cellpoiService", "ICellPoiService unregisterHighConfidenceCallback failed", e);
    L16:
        b();
        return;
    L18:
        th = move-exception;
        throw th;
    }

    public final void c() {
        Object r0 = this.f7031b;
        monitor-enter(r0);
    L22:
        th = move-exception;
        throw th;
    L5:
        if (e() == true) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L22
        return;
    L9:
        if (f() == false) goto L13;
        monitor-exit(r0);     // Catch: Throwable -> L22
        return;
    L13:
        if (this.c.compareAndSet(false, true) == true) goto L16;
        monitor-exit(r0);     // Catch: Throwable -> L22
        return;
    L16:
        monitor-exit(r0);     // Catch: Throwable -> L22
        this.d.execute(new $$Lambda$b$xgpXhZKM2XM4rkZ8BFrTcAaYWHk(this));     // Catch: Throwable -> L19
        return;
    L19:
        th = move-exception;
        this.c.set(false);
        throw th;
    }

    public final void d() {
        int r1 = 1;
    L4:
        if (r1 > 60) goto L60;
        Object r3 = this.f7031b;
        monitor-enter(r3);
    L57:
        th = move-exception;
        throw th;
    L8:
        if (e() == false) goto L9;
        if (f() == true) goto L13;
        IBinder r4 = this.g;     // Catch: Throwable -> L57
        if (r4 == null) goto L26;
        if (r4 != null) goto L19;
    L23:
        boolean r5 = false;
    L24:
        if (r5 == true) goto L26;
        this.g = null;     // Catch: Throwable -> L57
        this.h = null;     // Catch: Throwable -> L57
        this.i = 0;     // Catch: Throwable -> L57
        this.j = 0;     // Catch: Throwable -> L57
        goto L26
    L19:
        if (r4.isBinderAlive() == false) goto L23;
        if (this.g.pingBinder() == false) goto L23;
        r5 = true;
    L26:
        IBinder r6 = this.g;     // Catch: Throwable -> L57
        com.bytedance.radioservice.a.b r7 = this.h;     // Catch: Throwable -> L57
        monitor-exit(r3);     // Catch: Throwable -> L57
        if (r7 != null) goto L33;
        r6 = ServiceManager.getService("cellpoi_service");
        if (r6 == null) goto L33;
        r7 = com.bytedance.radioservice.a.b.a.a(r6);
    L33:
        if (r7 != null) goto L37;
        if (r1 >= 60) goto L70;
    L35:
        SystemClock.sleep(10000);
    L70:
        r1 = r1 + 1;     // Catch: Throwable -> L54
    L54:
        th = move-exception;
        throw th;
    L37:
        if (a(r6, r7) == false) goto L38;
        a(r7);
        Object r8 = this.f7031b;
        monitor-enter(r8);
        if (e() == false) goto L43;
        if (f() == true) goto L48;
        monitor-exit(r8);     // Catch: Throwable -> L54
        if (r1 >= 60) goto L70;
    L48:
        monitor-exit(r8);     // Catch: Throwable -> L54
        return;
    L43:
        this.g = null;     // Catch: Throwable -> L54
        this.h = null;     // Catch: Throwable -> L54
        this.i = 0;     // Catch: Throwable -> L54
        this.j = 0;     // Catch: Throwable -> L54
        monitor-exit(r8);     // Catch: Throwable -> L54
        return;
    L38:
        return;
    L13:
        monitor-exit(r3);     // Catch: Throwable -> L57
        return;
    L9:
        monitor-exit(r3);     // Catch: Throwable -> L57
        return;
    L60:
        Object r0 = this.f7031b;
        monitor-enter(r0);
    L67:
        th = move-exception;
        throw th;
    L63:
        if (e() == false) goto L65;
        com.obric.cae.log.a.g("StarLocation-cellpoiService", "ICellPoiService still not available: cellpoi_service");     // Catch: Throwable -> L67
    L65:
        monitor-exit(r0);     // Catch: Throwable -> L67
    }

    public final boolean e() {
        if (this.e.isEmpty() == true) goto L5;
    L8:
        return true;
    L5:
        if (this.f.isEmpty() == false) goto L8;
        return false;
    }

    public final boolean f() {
        boolean r0 = !this.e.isEmpty();
        boolean r2 = !this.f.isEmpty();
        if (this.h == null) goto L23;
        IBinder r3 = this.g;
        if (r3 != null) goto L7;
    L11:
        boolean r4 = false;
    L12:
        if (r4 == false) goto L23;
        if (r0 == true) goto L16;
    L18:
        if (r2 == true) goto L20;
    L22:
        return true;
    L20:
        if (this.j > 0) goto L22;
        return false;
    L16:
        if (this.i > 0) goto L18;
        return false;
    L7:
        if (r3.isBinderAlive() == false) goto L11;
        if (this.g.pingBinder() == false) goto L11;
        r4 = true;
    L23:
        return false;
    }
}
