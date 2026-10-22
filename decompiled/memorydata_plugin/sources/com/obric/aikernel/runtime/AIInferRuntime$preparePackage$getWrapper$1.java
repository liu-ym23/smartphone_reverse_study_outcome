package com.obric.aikernel.runtime;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\u008a@"}, d2 = {"<anonymous>", "Lcom/obric/aikernel/runtime/AIInferRuntime$PackageWrapper;"}, k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.obric.aikernel.runtime.AIInferRuntime$preparePackage$getWrapper$1", f = "AIInferRuntime.kt", i = {}, l = {651}, m = "invokeSuspend", n = {}, s = {})
final class AIInferRuntime$preparePackage$getWrapper$1 extends SuspendLambda implements Function1<Continuation<? super AIInferRuntime.g>, Object> {
    final /* synthetic */ String $biz;
    final /* synthetic */ String $lora;
    final /* synthetic */ boolean $update;
    int label;
    final /* synthetic */ AIInferRuntime this$0;

    AIInferRuntime$preparePackage$getWrapper$1(AIInferRuntime r3, String r4, String r5, boolean r6, Continuation<? super AIInferRuntime$preparePackage$getWrapper$1> r7) {
        Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r7, Continuation.class, "com.obric.memorydata.plugin");
        this.this$0 = r3;
        this.$biz = r4;
        this.$lora = r5;
        this.$update = r6;
        super(1, r8);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> r9) {
        Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r9, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new AIInferRuntime$preparePackage$getWrapper$1(this.this$0, this.$biz, this.$lora, this.$update, r7), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function1
    public /* synthetic */ Object invoke(Continuation<? super AIInferRuntime.g> r3) {
        return invoke2((Continuation) ZeusTransformUtils.preCheckCast(r3, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(Continuation<? super AIInferRuntime.g> r3) {
        return ((AIInferRuntime$preparePackage$getWrapper$1) ZeusTransformUtils.preCheckCast(create((Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin")), AIInferRuntime$preparePackage$getWrapper$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r8) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r8);
    L11:
        String r2 = this.$biz;
        String r7 = this.$lora;
        if (((AIInferRuntime.g) ZeusTransformUtils.preCheckCast(r8, AIInferRuntime.g.class, "com.obric.memorydata.plugin")) != null) goto L14;
        com.obric.aikernel.runtime.utils.d.f6216a.e("AIInferRuntime", "preparePackage: " + r2 + ',' + r7 + " get null packageInfo.");
    L14:
        return r8;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r8);
        AIInferRuntime r9 = this.this$0;
        String r3 = this.$biz;
        String r4 = this.$lora;
        boolean r5 = !this.$update;
        Continuation r6 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.label = 1;
        r8 = AIInferRuntime.a(r9, r3, r4, r5, r6);
        if (r8 != r0) goto L11;
        return r0;
    }
}
