package com.obric.assistant.state.impl.multitask.producer;

import kl9.p;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class k implements Function1 {
    public final /* synthetic */ ObricAigcGenerationStateProducer a;

    public /* synthetic */ k(ObricAigcGenerationStateProducer r1) {
        this.a = r1;
    }

    public final Object invoke(Object r3) {
        ObricAigcGenerationStateProducer r0 = this.a;
        p r4 = (p) r3;
        int r1 = ObricAigcGenerationStateProducer.c;
        if (r4 == null) goto L5;
        String r5 = r4.d;
    L6:
        r0.getClass();
        return ObricAigcGenerationStateProducer.b(r5);
    L5:
        r5 = null;
        goto L6
    }
}
