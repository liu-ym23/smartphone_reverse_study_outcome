package com.bytedance.android.anniex.base.monitor;

import java.util.concurrent.Callable;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class c<V> implements Callable {
    public final /* synthetic */ MonitorCenter a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;

    public c(MonitorCenter r1, String r10, String r11) {
        this.a = r1;
        this.b = r10;
        this.c = r11;
    }

    @Override // java.util.concurrent.Callable
    public final Unit call() {
        MonitorCenter.b r0 = this.a.b.get(this.b);
        if (r0 == null) goto L11;
        String r1 = this.c;
        MonitorCenter r10 = this.a;
        if (r1 == null) goto L8;
        r0.getClass();
        throw null;
    L8:
        MapsKt.mapOf(new Pair[]{TuplesKt.to("event_type", "event_type_container"), TuplesKt.to("container_event", "container_event_navigate_fail")});
        r10.getClass();
        throw null;
    L11:
        return Unit.INSTANCE;
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Object call() {
        return call();
    }
}
