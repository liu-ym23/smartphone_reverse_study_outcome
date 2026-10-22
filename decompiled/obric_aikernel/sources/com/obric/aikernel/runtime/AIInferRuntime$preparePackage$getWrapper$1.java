package com.obric.aikernel.runtime;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(c = "com.obric.aikernel.runtime.AIInferRuntime$preparePackage$getWrapper$1", f = "AIInferRuntime.kt", i = {}, l = {625}, m = "invokeSuspend", n = {}, s = {})
final class AIInferRuntime$preparePackage$getWrapper$1 extends SuspendLambda implements Function1<Continuation<? super AIInferRuntime.PackageWrapper>, Object> {
    final /* synthetic */ String $biz;
    final /* synthetic */ String $lora;
    final /* synthetic */ boolean $update;
    int label;
    final /* synthetic */ AIInferRuntime this$0;

    AIInferRuntime$preparePackage$getWrapper$1(AIInferRuntime r10, String r11, String r12, boolean r13, Continuation<? super AIInferRuntime$preparePackage$getWrapper$1> r14) {
        this.this$0 = r10;
        this.$biz = r11;
        this.$lora = r12;
        this.$update = r13;
        super(1, r14);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> r10) {
        return new AIInferRuntime$preparePackage$getWrapper$1(this.this$0, this.$biz, this.$lora, this.$update, r10);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Continuation<? super AIInferRuntime.PackageWrapper> r10) {
        return invoke2(r10);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(Continuation<? super AIInferRuntime.PackageWrapper> r10) {
        return ((AIInferRuntime$preparePackage$getWrapper$1) create(r10)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        Object r11 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r12 = this.label;
        if (r12 == 0) goto L8;
        if (r12 != 1) goto L7;
        ResultKt.throwOnFailure(r10);
    L11:
        String r13 = this.$biz;
        String r14 = this.$lora;
        if (((AIInferRuntime.PackageWrapper) r10) != null) goto L14;
        com.obric.aikernel.runtime.utils.d.f5417a.g("AIInferRuntime", "preparePackage: " + r13 + ',' + r14 + " get null packageInfo.");
    L14:
        return r10;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        AIInferRuntime r15 = this.this$0;
        String r16 = this.$biz;
        String r17 = this.$lora;
        boolean r18 = !this.$update;
        this.label = 1;
        r10 = AIInferRuntime.n(r15, r16, r17, r18, this);
        if (r10 != r11) goto L11;
        return r11;
    }
}
