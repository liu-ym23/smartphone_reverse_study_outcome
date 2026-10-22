package com.obric.assistant.component;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class r6 implements Function1 {
    public /* synthetic */ r6() {
    }

    public final Object invoke(Object r2) {
        qha.e r3 = (qha.e) r2;
        int r0 = OrionInstructionComponent.p1;
        Intrinsics.checkNotNullParameter(r3, "it");
        return Boolean.valueOf(r3 instanceof qha.j);
    }
}
