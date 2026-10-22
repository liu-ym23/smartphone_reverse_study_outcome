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

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/bytedance/ai/resource/core/operations/AbsAIPackageOperation$Result;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.resource.core.AIPackageOperationGroup$loadManifestBean$job$1$1", f = "AIPackageOperationGroup.kt", i = {}, l = {402}, m = "invokeSuspend", n = {}, s = {})
final class AIPackageOperationGroup$loadManifestBean$job$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super AbsAIPackageOperation.Result>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f2595a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ BaseAIPackageHelper f2596b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ AIPackageOperationGroup f2597c;
    public final /* synthetic */ AIPackageDeployment.AIPackageDeploymentItem d;

    public AIPackageOperationGroup$loadManifestBean$job$1$1(BaseAIPackageHelper r5, AIPackageOperationGroup r10, AIPackageDeployment.AIPackageDeploymentItem r11, Continuation r12) {
        this.f2596b = r5;
        this.f2597c = r10;
        this.d = r11;
        super(2, r12);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object r5, Continuation r10) {
        return new AIPackageOperationGroup$loadManifestBean$job$1$1(this.f2596b, this.f2597c, this.d, r10);
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public final Object mo2invoke(CoroutineScope r5, Continuation<? super AbsAIPackageOperation.Result> r10) {
        return ((AIPackageOperationGroup$loadManifestBean$job$1$1) create(r5, r10)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r11 = this.f2595a;
        if (r11 == 0) goto L8;
        if (r11 != 1) goto L7;
        ResultKt.throwOnFailure(r10);
    L11:
        AbsAIPackageOperation.Result r12 = (AbsAIPackageOperation.Result) r10;
        AIPackageOperationGroup r13 = this.f2597c;
        AIPackageDeployment.AIPackageDeploymentItem r14 = this.d;
        AIPackageManifestBean r15 = this.f2596b.f2697b;
        r13.getClass();
        if (r12.e != 0) goto L16;
        String r16 = r14.getPackageName();
        long r17 = r14.getVersionCode();
        if (r15 == null) goto L16;
        AIPackageManifestBean r18 = (AIPackageManifestBean) r13.d.putIfAbsent(r16 + '_' + r17, r15);
    L16:
        return r12;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        BaseAIPackageHelper r19 = this.f2596b;
        this.f2595a = 1;
        r10 = r19.a(this);
        if (r10 != r5) goto L11;
        return r5;
    }
}
