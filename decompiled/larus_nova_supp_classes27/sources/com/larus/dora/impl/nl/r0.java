package com.larus.dora.impl.nl;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class r0<T> implements FlowCollector {
    public final /* synthetic */ ProactiveSettingsFragment a;

    public r0(ProactiveSettingsFragment r1) {
        this.a = r1;
    }

    public final Object emit(Object r1, Continuation r2) {
        if (((Boolean) r1).booleanValue() == false) goto L6;
        ProactiveSettingsFragment r3 = this.a;
        int r4 = ProactiveSettingsFragment.l;
        r3.W90();
    L6:
        return Unit.INSTANCE;
    }
}
