package com.larus.dora.impl.nl;

import com.larus.dora.impl.databinding.LarusDoraPageProactiveBinding;
import com.larus.dora.impl.view.DoraMovieView;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class o0<T> implements FlowCollector {
    public final /* synthetic */ ProactiveSettingsFragment a;

    public o0(ProactiveSettingsFragment r1) {
        this.a = r1;
    }

    public final Object emit(Object r3, Continuation r4) {
        final String r5 = (String) r3;
        final LarusDoraPageProactiveBinding r6 = this.a.f;
        if (r6 == null) goto L10;
        g49.d.d("ProactiveSettingsFragment", "updateProactiveChatMethodState: method=" + r5);
        if (Intrinsics.areEqual(r5, "2") == false) goto L7;
        r6.o.b(r6.p);
    L8:
        final DoraMovieView r0 = r6.r;
        r0.post(new h0(r0, r6, r5));
        goto L10
    L7:
        r6.o.b(r6.s);
    L10:
        return Unit.INSTANCE;
    }
}
