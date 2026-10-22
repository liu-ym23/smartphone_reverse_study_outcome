package com.bytedance.badger.utils;

import android.os.Binder;
import android.os.Parcel;
import com.bytedance.badger.BadgerCore;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class e0 extends Binder {
    public final /* synthetic */ f0 a;
    public final /* synthetic */ f0 b;

    public e0(f0 r1, f0 r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.os.Binder
    public final boolean onTransact(int r5, Parcel r6, Parcel r7, int r8) {
        if (r5 != 1) goto L5;
        f r9 = f.d;     // Catch: Throwable -> L19
        r9.getClass();     // Catch: Throwable -> L19
        BadgerCore.Companion.getClass();     // Catch: Throwable -> L19
        r6.enforceInterface(com.bytedance.badger.j.b(2079221550204419682L));     // Catch: Throwable -> L19
        r6.readString();     // Catch: Throwable -> L19
        String r10 = r6.readString();     // Catch: Throwable -> L19
        r6.readString();     // Catch: Throwable -> L19
        r6.readInt();     // Catch: Throwable -> L19
        if (this.a.d.compareAndSet(0, 1) == false) goto L12;
        this.a.e.set(r10);     // Catch: Throwable -> L19
        com.bytedance.badger.e.f("vivo#", "get result done, t=" + ThreadMethodProxy.currentThread().getName());     // Catch: Throwable -> L19
    L16:
        if (r7 == null) goto L18;
        r7.writeNoException();     // Catch: Throwable -> L19
    L18:
        f0 r12 = this.a;
        AtomicBoolean r13 = r12.i;
        CountDownLatch r14 = r12.j;
        w r15 = new w(this);
    L22:
        f.c(r9, r13, r14, r15);
        return true;
    L12:
        if (r10 != null) goto L15;
        r10 = "";
    L15:
        f.a(r9).post(new d0(this, r10));     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        this.a.l.set(th);     // Catch: Throwable -> L24
        r9 = f.d;
        f0 r16 = this.a;
        r13 = r16.i;
        r14 = r16.j;
        r15 = new w(this);
    L24:
        th = move-exception;
        f r17 = f.d;
        f0 r18 = this.a;
        f.c(r17, r18.i, r18.j, new w(this));
        throw th;
    L5:
        return super.onTransact(r5, r6, r7, r8);
    }
}
