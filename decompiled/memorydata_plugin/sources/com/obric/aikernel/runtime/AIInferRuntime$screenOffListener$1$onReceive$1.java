package com.obric.aikernel.runtime;

import com.obric.aikernel.res.PackageResourceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
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

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.obric.aikernel.runtime.AIInferRuntime$screenOffListener$1$onReceive$1", f = "AIInferRuntime.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class AIInferRuntime$screenOffListener$1$onReceive$1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ AIInferRuntime this$0;

    AIInferRuntime$screenOffListener$1$onReceive$1(AIInferRuntime r3, Continuation<? super AIInferRuntime$screenOffListener$1$onReceive$1> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        this.this$0 = r3;
        super(2, r5);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new AIInferRuntime$screenOffListener$1$onReceive$1(this.this$0, r4), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super Unit> r4) {
        return ((AIInferRuntime$screenOffListener$1$onReceive$1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AIInferRuntime$screenOffListener$1$onReceive$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r8) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L18;
        ResultKt.throwOnFailure(r8);
        PackageResourceManager r9 = AIInferRuntime.b(this.this$0);
        if (r9 == null) goto L7;
        r9.flushPackageUsage();
    L7:
        Iterator r10 = ((Iterable) ZeusTransformUtils.preCheckCast(AIInferRuntime.g(this.this$0).values(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L9:
        if (r10.hasNext() == false) goto L11;
        com.obric.aikernel.res.metadata.data.d.a((com.obric.aikernel.res.metadata.data.d) ZeusTransformUtils.preCheckCast(((AIInferRuntime.g) ZeusTransformUtils.preCheckCast(r10.next(), AIInferRuntime.g.class, "com.obric.memorydata.plugin")).a(), com.obric.aikernel.res.metadata.data.d.class, "com.obric.memorydata.plugin"), 0, 1, null);
        goto L9
    L11:
        Iterator r7 = ((Iterable) ZeusTransformUtils.preCheckCast(AIInferRuntime.d(this.this$0).values(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L13:
        if (r7.hasNext() == false) goto L16;
        com.obric.aikernel.res.metadata.data.d.a((com.obric.aikernel.res.metadata.data.d) ZeusTransformUtils.preCheckCast(((AIInferRuntime.g) ZeusTransformUtils.preCheckCast(r7.next(), AIInferRuntime.g.class, "com.obric.memorydata.plugin")).a(), com.obric.aikernel.res.metadata.data.d.class, "com.obric.memorydata.plugin"), 0, 1, null);
        goto L13
    L16:
        return Unit.INSTANCE;
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
