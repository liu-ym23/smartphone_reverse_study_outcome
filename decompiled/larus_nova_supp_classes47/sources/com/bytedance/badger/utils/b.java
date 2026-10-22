package com.bytedance.badger.utils;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b implements ServiceConnection {
    public final /* synthetic */ AtomicBoolean a;
    public final /* synthetic */ AtomicReference b;
    public final /* synthetic */ Object c;
    public final /* synthetic */ Ref.BooleanRef d;
    public final /* synthetic */ Context e;
    public final /* synthetic */ Ref.ObjectRef f;
    public final /* synthetic */ t g;
    public final /* synthetic */ Ref.BooleanRef h;

    public b(AtomicBoolean r1, AtomicReference r2, Object r3, Ref.BooleanRef r4, Context r5, Ref.ObjectRef r6, t r7, Ref.BooleanRef r8) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName r2, IBinder r3) {
        com.bytedance.badger.e.f("vivo#", "accountConnection# onServiceConnected " + ThreadMethodProxy.currentThread().getName());
        f.a(f.d).post(new g0(this, r3, this));
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName r4) {
        t r5 = this.g;
        Object r0 = this.f.element;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("isolatedConnection");
    L5:
        r5.a(this, (ServiceConnection) r0, new IllegalStateException("account service disconnected"));
    }
}
