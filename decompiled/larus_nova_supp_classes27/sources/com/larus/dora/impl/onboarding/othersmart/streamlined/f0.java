package com.larus.dora.impl.onboarding.othersmart.streamlined;

import com.larus.dora.impl.settings.SimplifiedTopic;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class f0<T> implements FlowCollector {
    public final /* synthetic */ DoraHStreamlinedWakeupFragment a;

    public f0(DoraHStreamlinedWakeupFragment r1) {
        this.a = r1;
    }

    public final Object emit(Object r1, Continuation r2) {
        List<SimplifiedTopic> r3 = (List) r1;
        if (Intrinsics.areEqual(this.a.r, r3) == true) goto L5;
        DoraHStreamlinedWakeupFragment r4 = this.a;
        r4.r = r3;
        r4.s = CollectionsKt.emptyList();
        this.a.t = 0;
    L5:
        this.a.sa0();
        return Unit.INSTANCE;
    }
}
