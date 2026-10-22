package com.obric.memorydata.memory.llm;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* synthetic */ class MemoryLLMBuildHelperV2$execute$2$rejectedMemoryCleanup$2 extends FunctionReferenceImpl implements SuspendFunction, Function2<Set<? extends f.a>, Continuation<? super Unit>, Object> {
    MemoryLLMBuildHelperV2$execute$2$rejectedMemoryCleanup$2(Object r8) {
        super(2, r8, f.class, "notifyRemoved", "notifyRemoved(Ljava/util/Set;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(Set<? extends f.a> r3, Continuation<? super Unit> r4) {
        return invoke2((Set) ZeusTransformUtils.preCheckCast(r3, Set.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(Set<f.a> r3, Continuation<? super Unit> r4) {
        Set<f.a> r5 = (Set) ZeusTransformUtils.wrapperContextForParams(r3, Set.class, "com.obric.memorydata.plugin");
        Continuation<? super Unit> r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        return ((f) ZeusTransformUtils.preCheckCast(this.receiver, f.class, "com.obric.memorydata.plugin")).a(r5, r6);
    }
}
