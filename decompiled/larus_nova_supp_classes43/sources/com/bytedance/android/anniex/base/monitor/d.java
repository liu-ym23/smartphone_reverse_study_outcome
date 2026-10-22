package com.bytedance.android.anniex.base.monitor;

import java.util.concurrent.Callable;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class d<V> implements Callable {
    public final /* synthetic */ MonitorCenter a;
    public final /* synthetic */ String b;

    public d(MonitorCenter r1, String r10) {
        this.a = r1;
        this.b = r10;
    }

    @Override // java.util.concurrent.Callable
    public final Unit call() {
        if (this.a.b.get(this.b) == null) goto L5;
        MonitorCenter r0 = this.a;
        MapsKt.mapOf(new Pair[]{TuplesKt.to("event_type", "event_type_container"), TuplesKt.to("container_event", "container_event_navigate_success")});
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
