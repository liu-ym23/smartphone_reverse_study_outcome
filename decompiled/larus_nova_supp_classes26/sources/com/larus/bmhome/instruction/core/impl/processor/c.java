package com.larus.bmhome.instruction.core.impl.processor;

import cq8.y;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final /* synthetic */ class c implements Function1 {
    public final /* synthetic */ InstructionPanelManageProcessor a;

    public /* synthetic */ c(InstructionPanelManageProcessor r1) {
        this.a = r1;
    }

    public final Object invoke(Object r3) {
        InstructionPanelManageProcessor r0 = this.a;
        y r4 = (y) r3;
        Intrinsics.checkNotNullParameter(r4, "action");
        r0.d(r4);
        return Unit.INSTANCE;
    }
}
