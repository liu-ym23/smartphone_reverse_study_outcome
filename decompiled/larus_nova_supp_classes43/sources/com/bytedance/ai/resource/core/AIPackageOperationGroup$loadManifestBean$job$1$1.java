package com.bytedance.ai.resource.core;

import com.bytedance.ai.resource.core.bean.AIPackageManifestBean;
import com.bytedance.ai.resource.core.operations.AbsAIPackageOperation;
import com.bytedance.ai.resource.core.operations.BaseAIPackageHelper;
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
@DebugMetadata(c = "com.bytedance.ai.resource.core.AIPackageOperationGroup$loadManifestBean$job$1$1", f = "AIPackageOperationGroup.kt", i = {}, l = {377}, m = "invokeSuspend", n = {}, s = {})
public final class AIPackageOperationGroup$loadManifestBean$job$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super AbsAIPackageOperation.a>, Object> {
    final /* synthetic */ BaseAIPackageHelper $baseAIPackageHelper;
    final /* synthetic */ AIPackageDeployment.AIPackageDeploymentItem $deploymentInfo;
    int label;
    final /* synthetic */ AIPackageOperationGroup this$0;

    public AIPackageOperationGroup$loadManifestBean$job$1$1(BaseAIPackageHelper r1, AIPackageOperationGroup r10, AIPackageDeployment.AIPackageDeploymentItem r11, Continuation<? super AIPackageOperationGroup$loadManifestBean$job$1$1> r12) {
        this.$baseAIPackageHelper = r1;
        this.this$0 = r10;
        this.$deploymentInfo = r11;
        super(2, r12);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new AIPackageOperationGroup$loadManifestBean$job$1$1(this.$baseAIPackageHelper, this.this$0, this.$deploymentInfo, r11);
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
        AbsAIPackageOperation.a r11 = (AbsAIPackageOperation.a) r10;
        AIPackageOperationGroup r12 = this.this$0;
        AIPackageDeployment.AIPackageDeploymentItem r13 = this.$deploymentInfo;
        AIPackageManifestBean r14 = this.$baseAIPackageHelper.b;
        r12.getClass();
        if (r11.e != 0) goto L16;
        String r15 = r13.getPackageName();
        long r16 = r13.getVersionCode();
        if (r14 == null) goto L16;
        AIPackageManifestBean r17 = r12.d.putIfAbsent(AIPackageOperationGroup.f(r15, r16), r14);
    L16:
        return r11;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        BaseAIPackageHelper r18 = this.$baseAIPackageHelper;
        this.label = 1;
        r10 = r18.c(this);
        if (r10 != r0) goto L11;
        return r0;
    }
}
