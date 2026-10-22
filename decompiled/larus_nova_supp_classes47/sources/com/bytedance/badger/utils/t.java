package com.bytedance.badger.utils;

import android.content.ServiceConnection;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
final class t extends Lambda implements Function3 {
    final /* synthetic */ AtomicReference a;
    final /* synthetic */ AtomicBoolean b;
    final /* synthetic */ CountDownLatch c;
    final /* synthetic */ r d;

    public t(AtomicReference r1, AtomicBoolean r2, CountDownLatch r3, r r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        super(3);
    }

    public final void a(ServiceConnection r4, ServiceConnection r5, Throwable r6) {
        this.a.set(r6);
        f.c(f.d, this.b, this.c, new s(this, r4, r5));
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2, Object r3) {
        a((ServiceConnection) r1, (ServiceConnection) r2, (Throwable) r3);
        return Unit.INSTANCE;
    }
}
