package com.obric.assistant.state.impl.multitask.producer;

import java.util.function.BiFunction;
import kotlin.jvm.functions.Function2;
import zga.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class e implements BiFunction {
    public final /* synthetic */ Function2 a;

    public /* synthetic */ e(d r1) {
        this.a = r1;
    }

    @Override // java.util.function.BiFunction
    public final Object apply(Object r3, Object r4) {
        Function2 r0 = this.a;
        int r1 = InteractionModeStateProducer.g;
        return (a) r0.invoke(r3, r4);
    }
}
