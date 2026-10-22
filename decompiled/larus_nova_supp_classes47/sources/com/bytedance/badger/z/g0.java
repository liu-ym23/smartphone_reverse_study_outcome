package com.bytedance.badger.z;

import com.bytedance.badger.data.DataString;
import com.bytedance.badger.module.BadgerModuleBase;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class g0 implements com.bytedance.badger.utils.o {
    public final /* synthetic */ h0 a;
    public final /* synthetic */ AtomicInteger b;
    public final /* synthetic */ Ref.ObjectRef c;
    public final /* synthetic */ BadgerModuleBase.BadgerRequestData d;
    public final /* synthetic */ long e;
    public final /* synthetic */ CountDownLatch f;
    public final /* synthetic */ com.bytedance.badger.utils.x g;
    public final /* synthetic */ Ref.ObjectRef h;

    public g0(h0 r1, AtomicInteger r2, Ref.ObjectRef r3, BadgerModuleBase.BadgerRequestData r4, long r5, CountDownLatch r7, com.bytedance.badger.utils.x r8, Ref.ObjectRef r9) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r7;
        this.g = r8;
        this.h = r9;
    }

    public final void a(com.bytedance.badger.utils.p r2) {
        Ref.ObjectRef r0 = this.h;     // Catch: Throwable -> L5
        r0.element = r2.a();     // Catch: Throwable -> L5
        this.f.countDown();
        this.g.d();
        return;
    L5:
        th = move-exception;
        this.f.countDown();
        this.g.d();
        throw th;
    }

    public final void b(String r9) {
    L8:
        th = move-exception;
        Ref.ObjectRef r0 = this.h;     // Catch: Throwable -> L15
        r0.element = th.toString();     // Catch: Throwable -> L15
    L13:
        this.f.countDown();
        this.g.d();
        return;
    L15:
        th = move-exception;
        this.f.countDown();
        this.g.d();
        throw th;
    L3:
        if (this.b.compareAndSet(0, 1) == false) goto L5;
        this.c.element = r9;     // Catch: Throwable -> L8
    L20:
        goto L13
    L5:
        h0 r1 = this.a;     // Catch: Throwable -> L8
        Long r2 = Long.valueOf(this.d.getToken());     // Catch: Throwable -> L8
        DataString r3 = new DataString(r9);     // Catch: Throwable -> L8
        long r4 = System.currentTimeMillis() - this.e;     // Catch: Throwable -> L8
        r1.getClass();     // Catch: Throwable -> L8
        if (u0.b(r2, r3, r4) == false) goto L10;
        com.bytedance.badger.network.z0 r10 = com.bytedance.badger.network.d0.a;     // Catch: Throwable -> L8
        com.bytedance.badger.network.d0.b(23, z64.h.b.a, new f0(), true);     // Catch: Throwable -> L8
        goto L20
    L10:
        com.bytedance.badger.e.g("oppo#", " complete fail.");     // Catch: Throwable -> L8
        goto L20
    }
}
