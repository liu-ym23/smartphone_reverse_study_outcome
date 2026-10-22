package com.bytedance.badger.utils;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class f0 implements ServiceConnection {
    public final /* synthetic */ AtomicReference a;
    public final /* synthetic */ t b;
    public final /* synthetic */ b c;
    public final /* synthetic */ AtomicInteger d;
    public final /* synthetic */ AtomicReference e;
    public final /* synthetic */ Long f;
    public final /* synthetic */ long g;
    public final /* synthetic */ Function3 h;
    public final /* synthetic */ AtomicBoolean i;
    public final /* synthetic */ CountDownLatch j;
    public final /* synthetic */ r k;
    public final /* synthetic */ AtomicReference l;

    public f0(AtomicReference r1, t r2, b r3, AtomicInteger r4, AtomicReference r5, Long r6, long r7, Function3 r9, AtomicBoolean r10, CountDownLatch r12, r r13, AtomicReference r14) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r9;
        this.i = r10;
        this.j = r12;
        this.k = r13;
        this.l = r14;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName r8, IBinder r9) {
        com.bytedance.badger.e.f("vivo#", "isolatedConnection# onServiceConnected " + ThreadMethodProxy.currentThread().getName());
        IBinder r3 = (IBinder) this.a.get();
        if (r3 != null) goto L6;
        this.b.a(this.c, this, new IllegalStateException("account binder is null"));
        return;
    L6:
        f.a(f.d).post(new c0(this, r9, r3, new e0(this, this), this));
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName r4) {
        this.b.a(this.c, this, new IllegalStateException("isolated service disconnected"));
    }
}
