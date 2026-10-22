package com.larus.dora.impl.nl;

import com.larus.dora.impl.databinding.LarusDoraPageProactiveBinding;
import com.larus.utils.e1;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class v0<T> implements FlowCollector {
    public final /* synthetic */ LarusDoraPageProactiveBinding a;

    public v0(LarusDoraPageProactiveBinding r1) {
        this.a = r1;
    }

    public final Object emit(Object r1, Continuation r2) {
        Boolean r3 = (Boolean) r1;
        if (r3 != null) goto L5;
        e1.o(this.a.u);
        e1.o(this.a.v);
    L7:
        return Unit.INSTANCE;
    L5:
        e1.x(this.a.u);
        e1.x(this.a.v);
        this.a.t.getToggleView().setChecked(r3.booleanValue());
        goto L7
    }
}
