package com.obric.memorydata.personalcontext.impl;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* synthetic */ class AgentRuntimeContextReader$get$2 extends FunctionReferenceImpl implements Function3<String, Integer, Exception, Unit> {
    AgentRuntimeContextReader$get$2(Object r8) {
        super(3, r8, a.class, "logFailure", "logFailure(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Exception;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* synthetic */ Unit invoke(String r3, Integer r4, Exception r5) {
        invoke2((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.memorydata.plugin"), (Integer) ZeusTransformUtils.preCheckCast(r4, Integer.class, "com.obric.memorydata.plugin"), (Exception) ZeusTransformUtils.preCheckCast(r5, Exception.class, "com.obric.memorydata.plugin"));
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(String r3, Integer r4, Exception r5) {
        Intrinsics.checkNotNullParameter(r3, "p0");
        a.a((a) ZeusTransformUtils.preCheckCast(this.receiver, a.class, "com.obric.memorydata.plugin"), r3, r4, r5);
    }
}
