package com.bytedance.ai.resource.core.operations;

import com.bytedance.ai.model.objects.AIPackage;
import com.bytedance.ai.resource.AIPackageManager;
import com.bytedance.ai.resource.core.AIPackageStorage;
import com.bytedance.ai.utils.g;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class AIPackageUninstallOperation extends AbsAIPackageOperation {
    public AIPackageUninstallOperation() {
    }

    @Override // com.bytedance.ai.resource.core.operations.AbsAIPackageOperation
    public final AIPackage.PackageStatus j() {
        return AIPackage.PackageStatus.DELETING;
    }

    @Override // com.bytedance.ai.resource.core.operations.AbsAIPackageOperation
    public final Object g(Continuation<? super AbsAIPackageOperation.a> r10) {
        if ((r10 instanceof AIPackageUninstallOperation$run$1) == false) goto L7;
        AIPackageUninstallOperation$run$1 r0 = (AIPackageUninstallOperation$run$1) r10;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r11 = r0.result;
        Object r12 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r13 = r0.label;
        if (r13 == 0) goto L14;
        if (r13 != 1) goto L13;
        ResultKt.throwOnFailure(r11);
    L22:
        if (((Boolean) r11).booleanValue() == false) goto L24;
        int r14 = 0;
    L26:
        return AbsAIPackageOperation.b(this, null, r14);
    L24:
        r14 = 5;
        goto L26
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r11);
        String r15 = d().getPackageName();
        String r16 = d().getAppId();
        if (Intrinsics.areEqual(r15, r16) == false) goto L17;
        AIPackage.AIPackageType r17 = AIPackage.AIPackageType.APPLET;
    L18:
        AIPackageManager.a r18 = new AIPackageManager.a(r16, r15);
        g.a.d("AIPackageManager", "packageName: " + r15 + ", appId: " + r16 + ", type: " + r17 + " ===> markPackageAsDeleted");
        AIPackageStorage r19 = AIPackageStorage.a;
        r0.label = 1;
        r11 = r19.f(r18, r17, r0);
        if (r11 != r12) goto L22;
        return r12;
    L17:
        r17 = AIPackage.AIPackageType.WIDGET;
    L7:
        r0 = new AIPackageUninstallOperation$run$1(this, r10);
        goto L8
    }
}
