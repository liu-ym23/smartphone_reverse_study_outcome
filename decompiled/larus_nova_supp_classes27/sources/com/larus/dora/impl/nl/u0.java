package com.larus.dora.impl.nl;

import com.larus.dora.impl.databinding.LarusDoraPageProactiveBinding;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class u0<T> implements FlowCollector {
    public final /* synthetic */ ProactiveSettingsFragment a;

    public u0(ProactiveSettingsFragment r1) {
        this.a = r1;
    }

    public final Object emit(Object r3, Continuation r4) {
        ProactiveSettingsFragment r5 = this.a;
        boolean r6 = ((y0) r3).a;
        LarusDoraPageProactiveBinding r7 = r5.f;
        if (r7 == null) goto L6;
        g49.d.d("ProactiveSettingsFragment", "updateProactivePriorityState: enabled=" + r6);
        r7.k.getToggleView().setChecked(r6);
        Unit r8 = Unit.INSTANCE;
    L6:
        return Unit.INSTANCE;
    }
}
