package com.obric.memorydata.memory.ui.automemory.create;

import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.al;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.memory.ui.automemory.create.AutoMemoryCollectionAiTaskQueue$resumePendingTask$1", f = "AutoMemoryCollectionAiTaskQueue.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class AutoMemoryCollectionAiTaskQueue$resumePendingTask$1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
    int label;

    AutoMemoryCollectionAiTaskQueue$resumePendingTask$1(Continuation<? super AutoMemoryCollectionAiTaskQueue$resumePendingTask$1> r3) {
        super(2, (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin"));
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
        return (Continuation) ZeusTransformUtils.preCheckCast(new AutoMemoryCollectionAiTaskQueue$resumePendingTask$1((Continuation) ZeusTransformUtils.wrapperContextForParams(r2, Continuation.class, "com.obric.memorydata.plugin")), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super Unit> r4) {
        return ((AutoMemoryCollectionAiTaskQueue$resumePendingTask$1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AutoMemoryCollectionAiTaskQueue$resumePendingTask$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r7) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L14;
        ResultKt.throwOnFailure(r7);
        Iterator r6 = ((Iterable) ZeusTransformUtils.preCheckCast(AutoMemoryCollectionAiTaskQueue.a(AutoMemoryCollectionAiTaskQueue.f10615a), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L6:
        if (r6.hasNext() == false) goto L9;
        AutoMemoryCollectionAiTaskQueue.a r8 = (AutoMemoryCollectionAiTaskQueue.a) ZeusTransformUtils.preCheckCast(r6.next(), AutoMemoryCollectionAiTaskQueue.a.class, "com.obric.memorydata.plugin");
        r8.a(System.currentTimeMillis());
        AutoMemoryCollectionAiTaskQueue.a().add(r8);
        goto L6
    L9:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(AutoMemoryCollectionAiTaskQueue.a(), Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L12;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AutoMemoryCollectionAiTaskQueue", "store has task ,size:" + AutoMemoryCollectionAiTaskQueue.a().size(), false, 4, null);
        AutoMemoryCollectionAiTaskQueue.b(AutoMemoryCollectionAiTaskQueue.f10615a);
        AutoMemoryCollectionAiTaskQueue.b().mo54trySendJP2dKIU(Unit.INSTANCE);
    L12:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
