package com.larus.dora.impl.nl;

import com.larus.dora.impl.databinding.LarusDoraPageProactiveBinding;
import com.larus.utils.e1;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class n0<T> implements FlowCollector {
    public final /* synthetic */ ProactiveSettingsFragment a;

    public n0(ProactiveSettingsFragment r1) {
        this.a = r1;
    }

    public final Object emit(Object r3, Continuation r4) {
        boolean r5 = ((Boolean) r3).booleanValue();
        LarusDoraPageProactiveBinding r6 = this.a.f;
        if (r6 == null) goto L10;
        g49.d.d("ProactiveSettingsFragment", "updateProactiveChatState: enabled=" + r5);
        r6.g.getToggleView().setChecked(r5);
        if (r5 == false) goto L7;
        e1.x(r6.n);
        r6.g.setBackgroundResource(2131239212);
    L8:
        Unit r7 = Unit.INSTANCE;
        goto L10
    L7:
        e1.o(r6.n);
        r6.g.setBackgroundResource(2131239210);
    L10:
        return Unit.INSTANCE;
    }
}
