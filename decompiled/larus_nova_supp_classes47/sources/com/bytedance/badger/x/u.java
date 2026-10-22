package com.bytedance.badger.x;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.bytedance.badger.BadgerCore;
import com.bytedance.badger.v.d;
import java.util.concurrent.CountDownLatch;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class u extends q {
    public final Object a;
    public volatile D b;
    public Context c;
    public volatile s d;

    public u() {
        this.a = new Object();
    }

    @Override // com.bytedance.badger.x.q
    public final String c() {
        return "service";
    }

    public final void h() {
        Context r0 = this.c;
        s r1 = this.d;
        if (r0 == null) goto L6;
        if (r1 == null) goto L6;
        r0.unbindService(r1);     // Catch: Throwable -> L8
    L6:
        this.d = null;
        this.b = null;
    }

    @Override // com.bytedance.badger.x.q
    public final String a() {
        D r0 = this.b;
        if (r0 == null) goto L27;
        boolean r1 = false;
        A r2 = r0.d(0);
        if (r2 == null) goto L25;
        if (r2.a != 0) goto L23;
        byte[] r3 = r2.b;
        if (r3 == null) goto L21;
        if (r3.length != 0) goto L14;
        r1 = true;
    L14:
        if ((!r1) == false) goto L21;
        String r4 = p.c(r3);
        if (r4 == null) goto L19;
        return r4;
    L19:
        throw new IllegalStateException("parse failed");
    L21:
        throw new IllegalStateException("exportResult.exportData is null");
    L23:
        throw new IllegalStateException("exportResult.resultCode != 0");
    L25:
        throw new IllegalStateException("exportResult is null");
    L27:
        throw new h("service target is null", null);
    }

    @Override // com.bytedance.badger.x.q
    public final void b() {
        D r0 = this.b;
        if (r0 == null) goto L7;
        r0.b(0);
        return;
    L7:
        throw new h("service target is null", null);
    }

    @Override // com.bytedance.badger.x.q
    public final boolean e() {
        D r0 = this.b;
        if (r0 == null) goto L7;
        return r0.c(0);
    L7:
        throw new h("service target is null", null);
    }

    @Override // com.bytedance.badger.x.q
    public final void f() {
        D r0 = this.b;
        if (r0 == null) goto L7;
        r0.a(0);
        return;
    L7:
        throw new h("service target is null", null);
    }

    @Override // com.bytedance.badger.x.q
    public final void d(Context r5) {
        this.c = r5.getApplicationContext();
        D r6 = this.b;
        boolean r0 = true;
        if (r6 == null) goto L11;
        IBinder r7 = r6.asBinder();
        if (r7 == null) goto L11;
        if (r7.isBinderAlive() == false) goto L11;
        if (r7.pingBinder() == false) goto L11;
        boolean r8 = true;
    L12:
        if (r8 == false) goto L14;
        return;
    L14:
        Object r9 = this.a;
        monitor-enter(r9);
        D r2 = this.b;     // Catch: Throwable -> L40
        if (r2 == null) goto L25;
        IBinder r3 = r2.asBinder();     // Catch: Throwable -> L40
        if (r3 == null) goto L25;
        if (r3.isBinderAlive() == false) goto L25;
        if (r3.pingBinder() == false) goto L25;
    L26:
        if (r0 == false) goto L44;
        monitor-exit(r9);
        return;
    L44:
        h();     // Catch: Throwable -> L35 i -> L38
        Context r1 = this.c;     // Catch: Throwable -> L35 i -> L38
        if (r1 != null) goto L32;
        Intrinsics.throwNpe();     // Catch: Throwable -> L35 i -> L38
    L32:
        this.b = g(r1);     // Catch: Throwable -> L35 i -> L38
        monitor-exit(r9);
        return;
    L35:
        th = move-exception;
        throw new h("service init failed", th);     // Catch: Throwable -> L40
    L38:
        e = move-exception;
        throw e;     // Catch: Throwable -> L40
    L25:
        r0 = false;
    L40:
        th = move-exception;
        throw th;
    L11:
        r8 = false;
        goto L12
    }

    public final D g(Context r10) {
        CountDownLatch r1 = new CountDownLatch(1);
        Ref.ObjectRef r3 = new Ref.ObjectRef();
        r3.element = null;
        s r5 = new s(this, r1, r3);
        this.d = r5;
        Intent r6 = new Intent();
        BadgerCore.Companion.getClass();
        r6.setAction(com.bytedance.badger.j.b(2418618557650235769L));
        r6.setPackage(com.bytedance.badger.j.b(8129550834698778238L));
        if (r10.bindService(r6, r5, 1) == false) goto L18;
        d.f0.getClass();
        com.bytedance.badger.v.g r12 = d.h;
        KProperty r0 = d.a[7];
        com.bytedance.badger.v.w r13 = (com.bytedance.badger.v.w) r12.a();
        if (r1.await(r13.a, r13.b) == false) goto L16;
        Throwable r14 = (Throwable) r3.element;
        if (r14 != null) goto L14;
        D r15 = this.b;
        if (r15 == null) goto L12;
        return r15;
    L12:
        h();
        throw new h("service target is null after bind", null);
    L14:
        h();
        throw r14;
    L16:
        h();
        throw new g("wait service connect timeout");
    L18:
        this.d = null;
        throw new C0390f("bind service failed", null);
    L20:
        th = move-exception;
        this.d = null;
        throw new C0390f("bind service failed", th);
    }
}
