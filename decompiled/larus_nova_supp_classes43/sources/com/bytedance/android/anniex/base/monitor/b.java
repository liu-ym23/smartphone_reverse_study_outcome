package com.bytedance.android.anniex.base.monitor;

import java.util.concurrent.Callable;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b<V> implements Callable {
    public final /* synthetic */ MonitorCenter a;
    public final /* synthetic */ String b;
    public final /* synthetic */ long c;

    public b(MonitorCenter r1, String r10, long r11) {
        this.a = r1;
        this.b = r10;
        this.c = r11;
    }

    @Override // java.util.concurrent.Callable
    public final Unit call() {
        MonitorCenter.b r0 = this.a.b.get(this.b);
        if (r0 == null) goto L5;
        r0.getClass();
        throw null;
    L5:
        return Unit.INSTANCE;
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Object call() {
        return call();
    }
}
