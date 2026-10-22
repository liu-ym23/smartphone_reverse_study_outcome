package com.obric.aee;

import com.obric.aee.impl.EngineBridge;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
/* synthetic */ class ExecutionEngine$init$2$1 extends FunctionReferenceImpl implements Function2<String, byte[], Unit> {
    ExecutionEngine$init$2$1(Object r10) {
        super(2, r10, EngineBridge.class, "handlePipeData", "handlePipeData(Ljava/lang/String;[B)V", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(String r10, byte[] r11) {
        invoke2(r10, r11);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(String r10, byte[] r11) {
        Intrinsics.checkNotNullParameter(r10, "p0");
        Intrinsics.checkNotNullParameter(r11, "p1");
        ((EngineBridge) this.receiver).handlePipeData(r10, r11);
    }
}
