package com.bytedance.ai.resource.core.operations;

import com.bytedance.ai.model.objects.AIPackage;
import com.bytedance.ai.resource.core.bean.AIPackageManifestBean;
import com.bytedance.ai.utils.f;
import com.bytedance.ai.utils.g;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a extends AbsAIPackageOperation {
    public final String h;

    @Override // com.bytedance.ai.resource.core.operations.AbsAIPackageOperation
    public final AIPackage.PackageStatus j() {
        return AIPackage.PackageStatus.INSTALLING;
    }

    public a(String r10) {
        Intrinsics.checkNotNullParameter(r10, "flag");
        this.h = r10;
    }

    @Override // com.bytedance.ai.resource.core.operations.AbsAIPackageOperation
    public final Object g(Continuation<? super AbsAIPackageOperation.a> r11) {
        if (k() == false) goto L5;
        AIPackageManifestBean r12 = this.b;
        if (r12 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("packageManifest");
        r12 = null;
    L10:
        g r1 = g.a;
        r1.i("AIPackageManager", "packageName: " + d().getPackageName() + ", appId: " + d().getAppId() + " ===> start install in memory");
        AIPackage r13 = a(r12, this.h);
        if (r13 != null) goto L13;
        r1.e("AIPackageManager", "packageName: " + d().getPackageName() + ", appId: " + d().getAppId() + " ===> install in memory failed : create AIPackage is null");
        return AbsAIPackageOperation.b(this, null, 8);
    L13:
        long r10 = System.currentTimeMillis() / 1000;
        r13.q = r10;
        r13.r = r10;
        r13.s = r10;
        r13.u = r10;
        r13.t = r10;
        String r14 = com.bytedance.ai.resource.core.a.a;
        r13.p = f.f(new PolarisFileWrapper(com.bytedance.ai.resource.core.a.e(d())));
        r1.i("AIPackageManager", "packageName: " + d().getPackageName() + ", appId: " + d().getAppId() + " ===> install in memory end");
        f.d(com.bytedance.ai.resource.core.a.f(d()));
        return AbsAIPackageOperation.b(this, r13, 0);
    L5:
        return AbsAIPackageOperation.b(this, null, 11);
    }
}
