package com.bytedance.badger.network;

import com.bytedance.badger.e;
import java.util.concurrent.ScheduledExecutorService;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class t0 implements i0 {
    public final /* synthetic */ String a;
    public final /* synthetic */ Function0 b;

    public t0(String r1, Function0 r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // com.bytedance.badger.network.i0
    public final void a() {
        u0 r0 = u0.h;     // Catch: Exception -> L8
        u0.f.remove(this.a);     // Catch: Exception -> L8
        r0.getClass();     // Catch: Exception -> L8
        Lazy r1 = u0.e;     // Catch: Exception -> L8
        KProperty r2 = u0.a[1];     // Catch: Exception -> L8
        ((j0) r1.getValue()).c(this);     // Catch: Exception -> L8
    L11:
        u0.h.getClass();     // Catch: Exception -> L5
        Lazy r3 = u0.b;     // Catch: Exception -> L5
        KProperty r4 = u0.a[0];     // Catch: Exception -> L5
        ((ScheduledExecutorService) r3.getValue()).execute(new s0(this));     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        e.c("BadgerNetworkRetryHandler", "Failed to execute network-ready task: " + this.a, e);
    }
}
