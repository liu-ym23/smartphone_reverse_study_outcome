package com.bytedance.ai.resource.core.operations;

import com.bytedance.ai.model.objects.AIPackage;
import com.bytedance.ai.resource.core.AIPackageConfig;
import com.bytedance.ai.resource.core.AIPackageZipExtractor;
import com.bytedance.ai.resource.core.bean.AIPackageManifestBean;
import com.bytedance.ai.utils.c;
import java.io.File;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import t0.d;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/ai/resource/core/operations/AIPackageInstallInMemoryOperation;", "Lcom/bytedance/ai/resource/core/operations/AbsAIPackageOperation;", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AIPackageInstallInMemoryOperation extends AbsAIPackageOperation {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f2676h;

    public AIPackageInstallInMemoryOperation() {
        Intrinsics.checkNotNullParameter("installed", "flag");
        this.f2676h = "installed";
    }

    @Override // com.bytedance.ai.resource.core.operations.AbsAIPackageOperation
    public final Object a(Continuation r10) {
        String r11 = AIPackageConfig.f2571a;
        if (AIPackageZipExtractor.b(AIPackageConfig.c(a()), AIPackageConfig.b(a())) == false) goto L5;
        AIPackageManifestBean r12 = this.f2688b;
        if (r12 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("packageManifest");
        r12 = null;
    L10:
        String r5 = "packageName: " + a().getPackageName() + ", appId: " + a().getAppId() + " ===> start install in memory";
        Intrinsics.checkNotNullParameter("AIPackageManager", "tag");
        d r13 = c.f2846a;
        if (r13 == null) goto L13;
        r13.i("AIPackageManager", r5);
    L13:
        AIPackage r14 = a(r12, this.f2676h);
        if (r14 != null) goto L20;
        String r15 = "packageName: " + a().getPackageName() + ", appId: " + a().getAppId() + " ===> install in memory failed : create AIPackage is null";
        Intrinsics.checkNotNullParameter("AIPackageManager", "tag");
        d r16 = c.f2846a;
        if (r16 == null) goto L19;
        r16.e("AIPackageManager", r15);
    L19:
        return AbsAIPackageOperation.a(this, null, 8);
    L20:
        long r17 = System.currentTimeMillis() / 1000;
        r14.f2270q = r17;
        r14.f2271r = r17;
        r14.s = r17;
        r14.f2273u = r17;
        r14.f2272t = r17;
        r14.f2269p = c.e(new File(AIPackageConfig.b(a())));
        String r18 = "packageName: " + a().getPackageName() + ", appId: " + a().getAppId() + " ===> install in memory end";
        Intrinsics.checkNotNullParameter("AIPackageManager", "tag");
        d r19 = c.f2846a;
        if (r19 == null) goto L23;
        r19.i("AIPackageManager", r18);
    L23:
        c.i(AIPackageConfig.c(a()));
        return AbsAIPackageOperation.a(this, r14, 0);
    L5:
        return AbsAIPackageOperation.a(this, null, 11);
    }

    @Override // com.bytedance.ai.resource.core.operations.AbsAIPackageOperation
    public final AIPackage.PackageStatus c() {
        return AIPackage.PackageStatus.f2284c;
    }
}
