package com.larus.dora.impl.nl;

import com.larus.dora.impl.databinding.LarusDoraPageProactiveBinding;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class p0<T> implements FlowCollector {
    public final /* synthetic */ ProactiveSettingsFragment a;

    public p0(ProactiveSettingsFragment r1) {
        this.a = r1;
    }

    public final Object emit(Object r3, Continuation r4) {
        int r5 = ((Number) r3).intValue();
        LarusDoraPageProactiveBinding r6 = this.a.f;
        if (r6 == null) goto L6;
        g49.d.d("ProactiveSettingsFragment", "updateProactiveChatFreq: freq=" + r5);
        r6.w.setProgress(r5);
        Unit r7 = Unit.INSTANCE;
    L6:
        return Unit.INSTANCE;
    }
}
