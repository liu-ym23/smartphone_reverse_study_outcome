package com.larus.dora.impl.onboarding.othersmart.streamlined;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class l<T> implements FlowCollector {
    public final /* synthetic */ DoraHStreamlinedInterruptFragment a;

    public l(DoraHStreamlinedInterruptFragment r1) {
        this.a = r1;
    }

    public final Object emit(Object r2, Continuation r3) {
        DoraHStreamlinedInterruptFragment r4 = this.a;
        float r0 = DoraHStreamlinedInterruptFragment.z;
        r4.ha0((o) r2);
        return Unit.INSTANCE;
    }
}
