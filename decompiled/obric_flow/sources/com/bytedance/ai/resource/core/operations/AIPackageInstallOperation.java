package com.bytedance.ai.resource.core.operations;

import com.bytedance.ai.model.objects.AIPackage;
import com.bytedance.ai.resource.core.AIPackageConfig;
import com.bytedance.ai.resource.core.AIPackageStorage;
import com.bytedance.ai.resource.core.AIPackageZipExtractor;
import com.bytedance.ai.resource.core.bean.AIPackageManifestBean;
import com.bytedance.ai.resource.k;
import com.bytedance.ai.resource.y;
import com.bytedance.ai.utils.c;
import java.io.File;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Intrinsics;
import t0.d;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/ai/resource/core/operations/AIPackageInstallOperation;", "Lcom/bytedance/ai/resource/core/operations/AbsAIPackageOperation;", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AIPackageInstallOperation extends AbsAIPackageOperation {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f2677h;

    public AIPackageInstallOperation() {
        Intrinsics.checkNotNullParameter("installed", "flag");
        this.f2677h = "installed";
    }

    @Override // com.bytedance.ai.resource.core.operations.AbsAIPackageOperation
    public final Object a(Continuation r5) {
        a("UNZIPPING");
        String r10 = AIPackageConfig.f2571a;
        AIPackageManifestBean r11 = null;
        if (AIPackageZipExtractor.b(AIPackageConfig.c(a()), AIPackageConfig.b(a())) == true) goto L6;
        a("UNZIP_FAILED");
        return AbsAIPackageOperation.a(this, null, 11);
    L6:
        a("UNZIP_COMPLETE");
        AIPackageManifestBean r12 = this.f2688b;
        if (r12 == null) goto L9;
        r11 = r12;
    L11:
        return a(r11, (ContinuationImpl) r5);
    L9:
        Intrinsics.throwUninitializedPropertyAccessException("packageManifest");
        goto L11
    }

    @Override // com.bytedance.ai.resource.core.operations.AbsAIPackageOperation
    public final AIPackage.PackageStatus c() {
        return AIPackage.PackageStatus.f2284c;
    }

    public final Object a(AIPackageManifestBean r18, ContinuationImpl r19) {
        AIPackageInstallOperation r5 = this;
        if ((r19 instanceof AIPackageInstallOperation$installAIPackage$1) == false) goto L7;
        AIPackageInstallOperation$installAIPackage$1 r10 = (AIPackageInstallOperation$installAIPackage$1) r19;
        int r11 = r10.e;
        if ((r11 & Integer.MIN_VALUE) == 0) goto L7;
        r10.e = r11 - Integer.MIN_VALUE;
    L8:
        Object r12 = r10.f2680c;
        Object r13 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r14 = r10.e;
        if (r14 == 0) goto L16;
        if (r14 == 1) goto L15;
        if (r14 != 2) goto L14;
        AIPackage r15 = r10.f2679b;
        AIPackageInstallOperation r16 = r10.f2678a;
        ResultKt.throwOnFailure(r12);
    L39:
        if (((Boolean) r12).booleanValue() == false) goto L45;
        r16.a("INSERT_PACKAGE_TO_DB_COMPLETE");
        String r17 = "packageName: " + r16.a().getPackageName() + ", appId: " + r16.a().getAppId() + " ===> install end";
        Intrinsics.checkNotNullParameter("AIPackageManager", "tag");
        d r20 = c.f2846a;
        if (r20 == null) goto L43;
        r20.i("AIPackageManager", r17);
    L43:
        String r21 = AIPackageConfig.f2571a;
        c.i(AIPackageConfig.c(r16.a()));
        return AbsAIPackageOperation.a(r16, r15, 0);
    L45:
        String r22 = "packageName: " + r16.a().getPackageName() + ", appId: " + r16.a().getAppId() + " ===> insert db failed";
        Intrinsics.checkNotNullParameter("AIPackageManager", "tag");
        d r23 = c.f2846a;
        if (r23 == null) goto L49;
        r23.e("AIPackageManager", r22);
    L49:
        return AbsAIPackageOperation.a(r16, null, 4);
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        AIPackage r24 = r10.f2679b;
        AIPackageInstallOperation r25 = r10.f2678a;
        ResultKt.throwOnFailure(r12);
        AIPackage r26 = r24;
        r5 = r25;
    L34:
        long r110 = System.currentTimeMillis() / 1000;
        r26.f2270q = r110;
        r26.f2271r = r110;
        r26.s = r110;
        r26.f2273u = r110;
        r26.f2272t = r110;
        r5.a("CALCULATE_UNZIPPED_DIRECTORY_SIZE");
        String r27 = AIPackageConfig.f2571a;
        r26.f2269p = c.e(new File(AIPackageConfig.b(r5.a())));
        r5.a("INSERT_PACKAGE_TO_DB");
        AIPackageStorage r28 = AIPackageStorage.f2618a;
        r10.f2678a = r5;
        r10.f2679b = r26;
        r10.e = 2;
        Object r29 = r28.c(r26, r10);
        if (r29 != r13) goto L37;
    L36:
        return r13;
    L37:
        r16 = r5;
        r15 = r26;
        r12 = r29;
        goto L39
    L16:
        ResultKt.throwOnFailure(r12);
        r5.a("CREATE_AI_PACKAGE");
        String r30 = "packageName: " + a().getPackageName() + ", appId: " + a().getAppId() + " ===> start install";
        Intrinsics.checkNotNullParameter("AIPackageManager", "tag");
        d r31 = c.f2846a;
        if (r31 == null) goto L19;
        r31.d("AIPackageManager", r30);
    L19:
        r26 = r5.a(r18, r5.f2677h);
        if (r26 != null) goto L27;
        String r32 = "packageName: " + a().getPackageName() + ", appId: " + a().getAppId() + " ===> install failed : create AIPackage is null";
        Intrinsics.checkNotNullParameter("AIPackageManager", "tag");
        d r33 = c.f2846a;
        if (r33 == null) goto L25;
        r33.e("AIPackageManager", r32);
    L25:
        return AbsAIPackageOperation.a(r5, null, 8);
    L27:
        if (r5.f2687a == null) goto L34;
        r5.a("DELETE_OLD_PACKAGE_FROM_DB");
        String r34 = "packageName: " + a().getPackageName() + ", appId: " + a().getAppId() + " ===> delete old AIPackage";
        Intrinsics.checkNotNullParameter("AIPackageManager", "tag");
        d r111 = c.f2846a;
        if (r111 == null) goto L31;
        r111.d("AIPackageManager", r34);
    L31:
        AIPackageStorage r35 = AIPackageStorage.f2618a;
        k r112 = new k(r26.c(), r26.f2259b);
        AIPackage.AIPackageType r113 = r26.e();
        r10.f2678a = r5;
        r10.f2679b = r26;
        r10.e = 1;
        if (r35.a(r112, r113, r10) != r13) goto L34;
    L7:
        r10 = new AIPackageInstallOperation$installAIPackage$1(r5, r19);
        goto L8
    }

    public final void a(String r10) {
        y r5 = y.f2766a;
        y.e(a().getPackageName(), a().getAppId(), "install", r10, "versionCode=" + a().getVersionCode());
    }
}
