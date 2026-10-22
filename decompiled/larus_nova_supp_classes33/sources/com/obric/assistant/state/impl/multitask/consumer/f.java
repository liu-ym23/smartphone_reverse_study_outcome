package com.obric.assistant.state.impl.multitask.consumer;

import java.util.function.Predicate;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class f implements Predicate {
    public final /* synthetic */ Function1 a;

    public /* synthetic */ f(e r1) {
        this.a = r1;
    }

    @Override // java.util.function.Predicate
    public final boolean test(Object r3) {
        Function1 r0 = this.a;
        int r1 = InteractionProjectionServiceImpl.f;
        return ((Boolean) r0.invoke(r3)).booleanValue();
    }
}
