package com.bytedance.ai.resource.core;

import com.bytedance.ai.resource.core.operations.AbsAIPackageOperation;
import com.bytedance.ai.resource.y;
import com.bytedance.ies.bullet.lynx.impl.LynxErrorCode;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/bytedance/ai/resource/core/operations/AbsAIPackageOperation$Result;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.resource.core.AIPackageOperationGroup$operationRun$3", f = "AIPackageOperationGroup.kt", i = {}, l = {LynxErrorCode.LYNX_ERROR_CODE_RESOURCE}, m = "invokeSuspend", n = {}, s = {})
final class AIPackageOperationGroup$operationRun$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super AbsAIPackageOperation.Result>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f2604a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AIPackageDeployment.AIPackageDeploymentItem f2605b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ AIPackageOperationGroup f2606c;
    public final /* synthetic */ AbsAIPackageOperation d;

    public AIPackageOperationGroup$operationRun$3(AIPackageDeployment.AIPackageDeploymentItem r5, AIPackageOperationGroup r10, AbsAIPackageOperation r11, Continuation r12) {
        this.f2605b = r5;
        this.f2606c = r10;
        this.d = r11;
        super(2, r12);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object r5, Continuation r10) {
        return new AIPackageOperationGroup$operationRun$3(this.f2605b, this.f2606c, this.d, r10);
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public final Object mo2invoke(CoroutineScope r5, Continuation<? super AbsAIPackageOperation.Result> r10) {
        return ((AIPackageOperationGroup$operationRun$3) create(r5, r10)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r11 = this.f2604a;
        if (r11 == 0) goto L9;
        if (r11 != 1) goto L8;
        ResultKt.throwOnFailure(r10);
        return r10;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r10);
        y r12 = y.f2766a;
        y.e(this.f2605b.getPackageName(), this.f2605b.getAppId(), "download", "DOWNLOADING", null);
        AIPackageOperationGroup r13 = this.f2606c;
        AIPackageDeployment.AIPackageDeploymentItem r14 = this.f2605b;
        AbsAIPackageOperation r15 = this.d;
        this.f2604a = 1;
        Object r16 = AIPackageOperationGroup.a(r13, r14, r15, this);
        if (r16 != r5) goto L12;
        return r5;
    L12:
        return r16;
    }
}
