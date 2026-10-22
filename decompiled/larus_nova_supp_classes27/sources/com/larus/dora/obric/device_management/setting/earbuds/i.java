package com.larus.dora.obric.device_management.setting.earbuds;

import java.util.ArrayList;
import java.util.List;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class i<T> implements FlowCollector {
    public final /* synthetic */ DoraObricEarbudsDSLSettingsFragment a;

    public i(DoraObricEarbudsDSLSettingsFragment r1) {
        this.a = r1;
    }

    public final Object emit(Object r6, Continuation r7) {
        Triple r8 = (Triple) r6;
        List r9 = (List) r8.component1();
        d59.b r0 = (d59.b) r8.component2();
        e59.b r10 = (e59.b) r8.component3();
        final DoraObricEarbudsDslCardAdapter r1 = this.a.h;
        if (r1 == null) goto L14;
        if (r0 == null) goto L8;
        r1.c = r0;
        g49.d.d("DoraObricEarbudsDslCardAdapter", "setCardContext, cardContext: " + r0);
    L8:
        Intrinsics.checkNotNullParameter(r10, "newState");
        if (Intrinsics.areEqual(r1.d, r10) == true) goto L12;
        r1.d = r10;
        r1.e.post(new m(r1));
    L12:
        Intrinsics.checkNotNullParameter(r9, "newItems");
        g49.d.d("DoraObricEarbudsDslCardAdapter", "setCards, newItems: " + r9.size());
        ((ArrayList) r1.b).clear();
        ((ArrayList) r1.b).addAll(r9);
        r1.e.post(new n(r1));
    L14:
        return Unit.INSTANCE;
    }
}
