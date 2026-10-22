package com.bytedance.ai.resource.core.operations;

import com.bytedance.ai.model.objects.AIPackage;
import com.bytedance.ai.resource.core.AIPackageStorage;
import com.bytedance.ai.resource.k;
import com.bytedance.ai.utils.c;
import com.lynx.tasm.base.a;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Intrinsics;
import t0.d;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/ai/resource/core/operations/AIPackageUninstallOperation;", "Lcom/bytedance/ai/resource/core/operations/AbsAIPackageOperation;", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AIPackageUninstallOperation extends AbsAIPackageOperation {
    public AIPackageUninstallOperation() {
    }

    @Override // com.bytedance.ai.resource.core.operations.AbsAIPackageOperation
    public final Object a(Continuation r10) {
        if ((r10 instanceof AIPackageUninstallOperation$run$1) == false) goto L7;
        AIPackageUninstallOperation$run$1 r5 = (AIPackageUninstallOperation$run$1) r10;
        int r11 = r5.d;
        if ((r11 & Integer.MIN_VALUE) == 0) goto L7;
        r5.d = r11 - Integer.MIN_VALUE;
    L8:
        Object r12 = r5.f2682b;
        Object r13 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r14 = r5.d;
        if (r14 == 0) goto L14;
        if (r14 != 1) goto L13;
        AIPackageUninstallOperation this = r5.f2681a;
        ResultKt.throwOnFailure(r12);
    L25:
        if (((Boolean) r12).booleanValue() == false) goto L27;
        int r15 = 0;
    L29:
        return AbsAIPackageOperation.a(this, null, r15);
    L27:
        r15 = 5;
        goto L29
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r12);
        String r16 = a().getPackageName();
        String r17 = a().getAppId();
        if (Intrinsics.areEqual(r16, r17) == false) goto L17;
        AIPackage.AIPackageType r18 = AIPackage.AIPackageType.f2279a;
    L18:
        k r19 = new k(r17, r16);
        StringBuilder r110 = a.e("packageName: ", r16, ", appId: ", r17, ", type: ");
        r110.append(r18);
        r110.append(" ===> markPackageAsDeleted");
        String r111 = r110.toString();
        Intrinsics.checkNotNullParameter("AIPackageManager", "tag");
        d r20 = c.f2846a;
        if (r20 == null) goto L21;
        r20.d("AIPackageManager", r111);
    L21:
        AIPackageStorage r112 = AIPackageStorage.f2618a;
        r5.f2681a = this;
        r5.d = 1;
        r12 = r112.b(r19, r18, r5);
        if (r12 != r13) goto L25;
        return r13;
    L17:
        r18 = AIPackage.AIPackageType.f2280b;
    L7:
        r5 = new AIPackageUninstallOperation$run$1(this, (ContinuationImpl) r10);
        goto L8
    }

    @Override // com.bytedance.ai.resource.core.operations.AbsAIPackageOperation
    public final AIPackage.PackageStatus c() {
        return AIPackage.PackageStatus.d;
    }
}
