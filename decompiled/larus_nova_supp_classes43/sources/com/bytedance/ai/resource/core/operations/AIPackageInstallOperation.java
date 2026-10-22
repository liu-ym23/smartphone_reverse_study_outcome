package com.bytedance.ai.resource.core.operations;

import com.bytedance.ai.model.objects.AIPackage;
import com.bytedance.ai.resource.AIPackageManager;
import com.bytedance.ai.resource.core.AIPackageStorage;
import com.bytedance.ai.resource.core.bean.AIPackageManifestBean;
import com.bytedance.ai.utils.f;
import com.bytedance.ai.utils.g;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class AIPackageInstallOperation extends AbsAIPackageOperation {
    public final String h;

    @Override // com.bytedance.ai.resource.core.operations.AbsAIPackageOperation
    public final AIPackage.PackageStatus j() {
        return AIPackage.PackageStatus.INSTALLING;
    }

    public AIPackageInstallOperation(String r10) {
        Intrinsics.checkNotNullParameter(r10, "flag");
        this.h = r10;
    }

    @Override // com.bytedance.ai.resource.core.operations.AbsAIPackageOperation
    public final Object g(Continuation<? super AbsAIPackageOperation.a> r10) {
        AIPackageManifestBean r1 = null;
        if (k() == false) goto L5;
        AIPackageManifestBean r0 = this.b;
        if (r0 == null) goto L9;
        r1 = r0;
    L11:
        return l(r1, r10);
    L9:
        Intrinsics.throwUninitializedPropertyAccessException("packageManifest");
        goto L11
    L5:
        return AbsAIPackageOperation.b(this, null, 11);
    }

    public final Object l(AIPackageManifestBean r17, Continuation<? super AbsAIPackageOperation.a> r18) {
        if ((r18 instanceof AIPackageInstallOperation$installAIPackage$1) == false) goto L7;
        AIPackageInstallOperation$installAIPackage$1 r10 = (AIPackageInstallOperation$installAIPackage$1) r18;
        int r11 = r10.label;
        if ((r11 & Integer.MIN_VALUE) == 0) goto L7;
        r10.label = r11 - Integer.MIN_VALUE;
    L8:
        Object r1 = r10.result;
        Object r12 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r13 = r10.label;
        if (r13 == 0) goto L16;
        if (r13 == 1) goto L15;
        if (r13 != 2) goto L14;
        AIPackage r14 = (AIPackage) r10.L$0;
        ResultKt.throwOnFailure(r1);
    L33:
        if (((Boolean) r1).booleanValue() == false) goto L35;
        g.a.i("AIPackageManager", "packageName: " + d().getPackageName() + ", appId: " + d().getAppId() + " ===> install end");
        String r15 = com.bytedance.ai.resource.core.a.a;
        f.d(com.bytedance.ai.resource.core.a.f(d()));
        return AbsAIPackageOperation.b(this, r14, 0);
    L35:
        g.a.e("AIPackageManager", "packageName: " + d().getPackageName() + ", appId: " + d().getAppId() + " ===> insert db failed");
        return AbsAIPackageOperation.b(this, null, 4);
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        AIPackage r16 = (AIPackage) r10.L$0;
        ResultKt.throwOnFailure(r1);
    L28:
        long r19 = System.currentTimeMillis() / 1000;
        r16.q = r19;
        r16.r = r19;
        r16.s = r19;
        r16.u = r19;
        r16.t = r19;
        String r20 = com.bytedance.ai.resource.core.a.a;
        r16.p = f.f(new PolarisFileWrapper(com.bytedance.ai.resource.core.a.e(d())));
        AIPackageStorage r21 = AIPackageStorage.a;
        r10.L$0 = r16;
        r10.label = 2;
        r1 = r21.d(r16, r10);
        if (r1 != r12) goto L31;
        return r12;
    L31:
        r14 = r16;
        goto L33
    L16:
        ResultKt.throwOnFailure(r1);
        g r22 = g.a;
        r22.d("AIPackageManager", "packageName: " + d().getPackageName() + ", appId: " + d().getAppId() + " ===> start install");
        r16 = a(r17, this.h);
        if (r16 != null) goto L21;
        r22.e("AIPackageManager", "packageName: " + d().getPackageName() + ", appId: " + d().getAppId() + " ===> install failed : create AIPackage is null");
        return AbsAIPackageOperation.b(this, null, 8);
    L21:
        if (this.a == null) goto L23;
        boolean r110 = true;
    L24:
        if (r110 == false) goto L28;
        r22.d("AIPackageManager", "packageName: " + d().getPackageName() + ", appId: " + d().getAppId() + " ===> delete old AIPackage");
        AIPackageStorage r23 = AIPackageStorage.a;
        AIPackageManager.a r111 = new AIPackageManager.a(r16.a(), r16.b);
        AIPackage.AIPackageType r112 = r16.c();
        r10.L$0 = r16;
        r10.label = 1;
        if (r23.b(r111, r112, r10) != r12) goto L28;
        return r12;
    L23:
        r110 = false;
    L7:
        r10 = new AIPackageInstallOperation$installAIPackage$1(this, r18);
        goto L8
    }
}
