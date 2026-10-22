package com.obric.memorydata.memory.ui.automemory.create;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "", "it"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.memory.ui.automemory.create.AutoMemoryCollectionAiTaskQueue$runOneOrWait$2$1", f = "AutoMemoryCollectionAiTaskQueue.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class AutoMemoryCollectionAiTaskQueue$runOneOrWait$2$1 extends SuspendLambda implements Function2<Unit, Continuation<? super Unit>, Object> {
    int label;

    AutoMemoryCollectionAiTaskQueue$runOneOrWait$2$1(Continuation<? super AutoMemoryCollectionAiTaskQueue$runOneOrWait$2$1> r3) {
        super(2, (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin"));
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
        return (Continuation) ZeusTransformUtils.preCheckCast(new AutoMemoryCollectionAiTaskQueue$runOneOrWait$2$1((Continuation) ZeusTransformUtils.wrapperContextForParams(r2, Continuation.class, "com.obric.memorydata.plugin")), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(Unit r3, Continuation<? super Unit> r4) {
        return invoke2((Unit) ZeusTransformUtils.preCheckCast(r3, Unit.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(Unit r3, Continuation<? super Unit> r4) {
        return ((AutoMemoryCollectionAiTaskQueue$runOneOrWait$2$1) ZeusTransformUtils.preCheckCast(create(r3, (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AutoMemoryCollectionAiTaskQueue$runOneOrWait$2$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r1) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r1);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
