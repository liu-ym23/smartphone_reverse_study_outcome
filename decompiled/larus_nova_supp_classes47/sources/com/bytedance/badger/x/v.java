package com.bytedance.badger.x;

import android.content.Context;
import com.bytedance.badger.network.y0;
import com.bytedance.badger.network.z0;
import java.util.List;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
final class v extends Lambda implements Function2 {
    final /* synthetic */ f0 a;
    final /* synthetic */ q b;
    final /* synthetic */ Context c;
    final /* synthetic */ Function1 d;
    final /* synthetic */ List e;
    final /* synthetic */ int f;
    final /* synthetic */ List g;

    public v(f0 r1, q r2, Context r3, Function1 r4, List r5, int r6, List r7) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        super(2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r3, Object r4) {
        a(((Number) r3).intValue(), ((Number) r4).longValue());
        return Unit.INSTANCE;
    }

    public final void a(int r6, long r7) {
        d0 r0 = new d0(this, r6);
        z0 r1 = this.a.d;     // Catch: RejectedExecutionException -> L8
        if (r7 > 0) goto L6;
        r1.a(r0);     // Catch: RejectedExecutionException -> L8
    L11:
        return;
    L6:
        Lazy r2 = r1.b;     // Catch: RejectedExecutionException -> L8
        KProperty r3 = z0.f[1];     // Catch: RejectedExecutionException -> L8
        ((ScheduledExecutorService) r2.getValue()).schedule(new y0(r1, r0), r7, TimeUnit.MILLISECONDS);     // Catch: RejectedExecutionException -> L8
    L8:
        e = move-exception;
        List r8 = CollectionsKt.toMutableList(this.e);
        r8.add(e);
        this.d.invoke(new a0(r6, r8, 2));
    }
}
