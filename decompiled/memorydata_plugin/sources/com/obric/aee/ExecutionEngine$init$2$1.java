package com.obric.aee;

import com.obric.aee.impl.EngineBridge;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* synthetic */ class ExecutionEngine$init$2$1 extends FunctionReferenceImpl implements Function2<String, byte[], Unit> {
    ExecutionEngine$init$2$1(Object r8) {
        super(2, r8, EngineBridge.class, "handlePipeData", "handlePipeData(Ljava/lang/String;[B)V", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Unit invoke(String r3, byte[] r4) {
        invoke2((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.memorydata.plugin"), (byte[]) ZeusTransformUtils.preCheckCast(r4, byte[].class, "com.obric.memorydata.plugin"));
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(String r3, byte[] r4) {
        Intrinsics.checkNotNullParameter(r3, "p0");
        Intrinsics.checkNotNullParameter(r4, "p1");
        ((EngineBridge) ZeusTransformUtils.preCheckCast(this.receiver, EngineBridge.class, "com.obric.memorydata.plugin")).handlePipeData(r3, r4);
    }
}
