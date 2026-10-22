package com.larus.bmhome.social.page.datasource.event;

import kotlin.Pair;
import kotlin.TuplesKt;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.j1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class ConflatedFlow<T> {
    public final T a;
    public final StateFlowImpl b;
    public final ConflatedFlow$special$$inlined$mapNotNull$1 c;

    public final T a() {
        return (T) ((Pair) this.b.getValue()).getSecond();
    }

    public ConflatedFlow(T r2) {
        this.a = r2;
        StateFlowImpl r3 = j1.a(TuplesKt.to(Integer.MIN_VALUE, r2));
        this.b = r3;
        this.c = new ConflatedFlow$special$$inlined$mapNotNull$1(r3);
    }

    public final void b(T r4) {
        StateFlowImpl r0 = this.b;
        r0.setValue(new Pair(Integer.valueOf(((Number) ((Pair) r0.getValue()).getFirst()).intValue() + 1), r4));
    }
}
