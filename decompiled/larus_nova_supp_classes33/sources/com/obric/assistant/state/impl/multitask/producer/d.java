package com.obric.assistant.state.impl.multitask.producer;

import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import zga.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class d implements Function2 {
    public final /* synthetic */ String a;

    public /* synthetic */ d(String r1) {
        this.a = r1;
    }

    public final Object invoke(Object r3, Object r4) {
        String r0 = this.a;
        a r5 = (a) r4;
        int r1 = InteractionModeStateProducer.g;
        Intrinsics.checkNotNullParameter((String) r3, "<unused var>");
        Intrinsics.checkNotNullParameter(r5, "snapshot");
        if (Intrinsics.areEqual(r5.c, r0) == false) goto L7;
        return null;
    L7:
        return r5;
    }
}
