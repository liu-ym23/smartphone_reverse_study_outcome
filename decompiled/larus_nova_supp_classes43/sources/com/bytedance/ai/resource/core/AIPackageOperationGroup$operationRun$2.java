package com.bytedance.ai.resource.core;

import com.bytedance.ai.resource.core.operations.AbsAIPackageOperation;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/bytedance/ai/resource/core/operations/AbsAIPackageOperation$Result;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.resource.core.AIPackageOperationGroup$operationRun$2", f = "AIPackageOperationGroup.kt", i = {}, l = {290}, m = "invokeSuspend", n = {}, s = {})
final class AIPackageOperationGroup$operationRun$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super AbsAIPackageOperation.a>, Object> {
    final /* synthetic */ AIPackageDeployment.AIPackageDeploymentItem $deploymentInfo;
    final /* synthetic */ AbsAIPackageOperation $operation;
    int label;
    final /* synthetic */ AIPackageOperationGroup this$0;

    public AIPackageOperationGroup$operationRun$2(AIPackageOperationGroup r1, AIPackageDeployment.AIPackageDeploymentItem r10, AbsAIPackageOperation r11, Continuation<? super AIPackageOperationGroup$operationRun$2> r12) {
        this.this$0 = r1;
        this.$deploymentInfo = r10;
        this.$operation = r11;
        super(2, r12);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new AIPackageOperationGroup$operationRun$2(this.this$0, this.$deploymentInfo, this.$operation, r11);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10) {
        return invoke((CoroutineScope) r1, (Continuation) r10);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super AbsAIPackageOperation.a> r10) {
        return create(r1, r10).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r10);
    L11:
        return r10;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        AIPackageOperationGroup r11 = this.this$0;
        AIPackageDeployment.AIPackageDeploymentItem r12 = this.$deploymentInfo;
        AbsAIPackageOperation r13 = this.$operation;
        this.label = 1;
        r10 = AIPackageOperationGroup.c(r11, r12, r13, this);
        if (r10 != r0) goto L11;
        return r0;
    }
}
