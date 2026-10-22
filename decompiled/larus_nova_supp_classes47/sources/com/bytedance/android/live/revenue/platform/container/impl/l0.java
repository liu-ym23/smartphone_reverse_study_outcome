package com.bytedance.android.live.revenue.platform.container.impl;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import java.util.concurrent.Callable;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class l0<V> implements Callable {
    public final /* synthetic */ RevenueNativeServiceDriver a;
    public final /* synthetic */ v b;
    public final /* synthetic */ Function0 c;
    public final /* synthetic */ String d;
    public final /* synthetic */ String e;

    public l0(RevenueNativeServiceDriver r1, v r2, Function0 r3, String r4, String r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }

    @Override // java.util.concurrent.Callable
    public final ObservableSource<? extends j57.a<Object>> call() {
        RevenueNativeServiceDriver r0 = this.a;     // Catch: Exception -> L4
        String r1 = this.b.d;     // Catch: Exception -> L4
        Object r2 = this.c.invoke();     // Catch: Exception -> L4
        r0.getClass();     // Catch: Exception -> L4
        return Observable.just(RevenueNativeServiceDriver.j(r1, r2));
    L4:
        e = move-exception;
        int r3 = d.a;
        v r4 = this.b;
        d.a(r4.b, r4.c, r4.d, this.d, this.e, e);
        String r5 = e.getMessage();
        if (r5 != null) goto L9;
        r5 = "";
    L9:
        return Observable.error(com.bytedance.platform.aio.d.b(r5, e));
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Object call() {
        return call();
    }
}
