package com.bytedance.ai.resource.core.operations;

import com.byted.mgl.merge.service.api.aweme.BdpAwemeConstant;
import com.bytedance.ai.model.objects.AIPackage;
import com.bytedance.ai.resource.AIManager;
import com.bytedance.ai.resource.core.AIPackageStorage;
import com.bytedance.ai.resource.core.bean.AIPackageManifestBean;
import com.bytedance.ai.utils.f;
import com.bytedance.ai.utils.g;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.util.Iterator;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class AIPackageUpdateOperation extends AbsAIPackageOperation {
    public AIPackageUpdateOperation() {
    }

    @Override // com.bytedance.ai.resource.core.operations.AbsAIPackageOperation
    public final AIPackage.PackageStatus j() {
        return AIPackage.PackageStatus.UPDATING;
    }

    public static void l(AIPackage r10) {
        AIManager r0 = AIManager.a;
        Intrinsics.checkNotNullParameter(r10, "packageInfo");
        g.a.d("AIManager", "===onAIPackageUpdateCompleted: " + r10.b + ", appId: " + r10.a() + ", packageType: " + r10.c().name());
        Iterator<AIManager.c> r1 = AIManager.d.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r1.next().a(r10.b, r10.a());
        goto L4
    }

    @Override // com.bytedance.ai.resource.core.operations.AbsAIPackageOperation
    public final Object g(Continuation<? super AbsAIPackageOperation.a> r10) {
        if (this.a == null) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L10;
        g.a.e("AIPackageManager", "packageName: " + d().getPackageName() + ", appId: " + d().getAppId() + " ===> update failed : AIPackage not installed");
        return AbsAIPackageOperation.b(this, null, 7);
    L10:
        if (k() == true) goto L14;
        return AbsAIPackageOperation.b(this, e(), 11);
    L14:
        return m(r10);
    L5:
        r0 = false;
        goto L6
    }

    public final Object m(Continuation<? super AbsAIPackageOperation.a> r17) {
        if ((r17 instanceof AIPackageUpdateOperation$updateAIPackage$1) == false) goto L7;
        AIPackageUpdateOperation$updateAIPackage$1 r10 = (AIPackageUpdateOperation$updateAIPackage$1) r17;
        int r11 = r10.label;
        if ((r11 & Integer.MIN_VALUE) == 0) goto L7;
        r10.label = r11 - Integer.MIN_VALUE;
    L8:
        Object r1 = r10.result;
        Object r12 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r13 = r10.label;
        if (r13 == 0) goto L14;
        if (r13 != 1) goto L13;
        AIPackage r14 = (AIPackage) r10.L$0;
        ResultKt.throwOnFailure(r1);
    L35:
        if (((Boolean) r1).booleanValue() == false) goto L38;
        g.a.i("AIPackageManager", "packageName: " + d().getPackageName() + ", appId: " + d().getAppId() + " ===> update end");
        String r15 = com.bytedance.ai.resource.core.a.a;
        f.d(com.bytedance.ai.resource.core.a.f(d()));
        l(r14);
        return AbsAIPackageOperation.b(this, r14, 0);
    L38:
        g.a.e("AIPackageManager", "packageName: " + d().getPackageName() + ", appId: " + d().getAppId() + " ===> update db failed");
        l(e());
        return AbsAIPackageOperation.b(this, e(), 5);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r1);
        g r16 = g.a;
        r16.d("AIPackageManager", "packageName: " + d().getPackageName() + ", appId: " + d().getAppId() + " ===> start update");
        AIPackageManifestBean r18 = this.b;
        if (r18 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("packageManifest");
        r18 = null;
    L18:
        AIPackage r19 = a(r18, "inactive");
        if (r19 != null) goto L22;
        r16.e("AIPackageManager", "packageName: " + d().getPackageName() + ", appId: " + d().getAppId() + " ===> update failed : create AIPackage is null");
        return AbsAIPackageOperation.b(this, e(), 8);
    L22:
        r19.q = e().q;
        r19.r = e().r;
        r19.u = e().u;
        r19.t = e().t;
        r19.s = System.currentTimeMillis() / 1000;
        String r110 = com.bytedance.ai.resource.core.a.a;
        r19.p = f.f(new PolarisFileWrapper(com.bytedance.ai.resource.core.a.e(d())));
        AIManager r20 = AIManager.a;
        String r21 = r19.b;
        String r111 = r19.a();
        AIPackage.AIPackageType r112 = r19.c();
        Intrinsics.checkNotNullParameter(r21, "packageName");
        Intrinsics.checkNotNullParameter(r111, BdpAwemeConstant.KEY_APP_ID);
        Intrinsics.checkNotNullParameter(r112, "packageType");
        r16.d("AIManager", "===onAIPackageUpdatePrepared: " + r21 + ", appId: " + r111 + ", packageType: " + r112.name());
        Iterator<AIManager.c> r22 = AIManager.d.iterator();
    L24:
        if (r22.hasNext() == false) goto L26;
        r22.next().c(r21, r111);
        goto L24
    L26:
        String r23 = e().b;
        String r24 = e().a();
        AIPackage.AIPackageType r113 = e().c();
        AIManager r114 = AIManager.a;
        Intrinsics.checkNotNullParameter(r23, "packageName");
        Intrinsics.checkNotNullParameter(r24, BdpAwemeConstant.KEY_APP_ID);
        Intrinsics.checkNotNullParameter(r113, "packageType");
        g.a.d("AIManager", "===onAIPackageUpdateStarted: " + r23 + ", appId: " + r24 + ", packageType: " + r113.name());
        Iterator<AIManager.c> r25 = AIManager.d.iterator();
    L28:
        if (r25.hasNext() == false) goto L30;
        r25.next().b(r23, r24);
        goto L28
    L30:
        AIPackageStorage r26 = AIPackageStorage.a;
        r10.L$0 = r19;
        r10.label = 1;
        r1 = r26.e(r19, r10);
        if (r1 != r12) goto L33;
        return r12;
    L33:
        r14 = r19;
    L7:
        r10 = new AIPackageUpdateOperation$updateAIPackage$1(this, r17);
        goto L8
    }
}
