package com.bytedance.ai.resource.core.operations;

import androidx.constraintlayout.motion.widget.a;
import cn.nubia.neopush.commons.Constant;
import com.bytedance.ai.model.objects.AIPackage;
import com.bytedance.ai.resource.core.AIPackageConfig;
import com.bytedance.ai.resource.core.AIPackageStorage;
import com.bytedance.ai.resource.core.AIPackageZipExtractor;
import com.bytedance.ai.resource.core.bean.AIPackageManifestBean;
import com.bytedance.ai.resource.j;
import com.bytedance.ai.utils.c;
import f8.b;
import java.io.File;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Intrinsics;
import t0.d;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/ai/resource/core/operations/AIPackageUpdateOperation;", "Lcom/bytedance/ai/resource/core/operations/AbsAIPackageOperation;", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AIPackageUpdateOperation extends AbsAIPackageOperation {
    public AIPackageUpdateOperation() {
    }

    public static void a(AIPackage r5) {
        j r10 = j.f2734a;
        Intrinsics.checkNotNullParameter(r5, "packageInfo");
        String r11 = "===onAIPackageUpdateCompleted: " + r5.f2259b + ", appId: " + r5.c() + ", packageType: " + r5.e().name();
        Intrinsics.checkNotNullParameter("AIManager", "tag");
        d r12 = c.f2846a;
        if (r12 == null) goto L5;
        r12.d("AIManager", r11);
    L5:
        Iterator r13 = j.f2735b.iterator();
    L7:
        if (r13.hasNext() == false) goto L9;
        ((com.bytedance.ai.resource.c) r13.next()).b(r5.f2259b, r5.c());
        goto L7
    }

    public final Object b(ContinuationImpl r19) {
        AIPackageUpdateOperation r5 = this;
        if ((r19 instanceof AIPackageUpdateOperation$updateAIPackage$1) == false) goto L7;
        AIPackageUpdateOperation$updateAIPackage$1 r10 = (AIPackageUpdateOperation$updateAIPackage$1) r19;
        int r11 = r10.e;
        if ((r11 & Integer.MIN_VALUE) == 0) goto L7;
        r10.e = r11 - Integer.MIN_VALUE;
    L8:
        Object r12 = r10.f2686c;
        Object r13 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r14 = r10.e;
        if (r14 == 0) goto L14;
        if (r14 != 1) goto L13;
        AIPackage r15 = r10.f2685b;
        AIPackageUpdateOperation r16 = r10.f2684a;
        ResultKt.throwOnFailure(r12);
        AIPackage r17 = r15;
        r5 = r16;
        Object r18 = r12;
    L46:
        if (((Boolean) r18).booleanValue() == false) goto L52;
        String r20 = "packageName: " + r5.a().getPackageName() + ", appId: " + r5.a().getAppId() + " ===> update end";
        Intrinsics.checkNotNullParameter("AIPackageManager", "tag");
        d r21 = c.f2846a;
        if (r21 == null) goto L50;
        r21.i("AIPackageManager", r20);
    L50:
        String r22 = AIPackageConfig.f2571a;
        c.i(AIPackageConfig.c(r5.a()));
        a(r17);
        return AbsAIPackageOperation.a(r5, r17, 0);
    L52:
        String r23 = "packageName: " + r5.a().getPackageName() + ", appId: " + r5.a().getAppId() + " ===> update db failed";
        Intrinsics.checkNotNullParameter("AIPackageManager", "tag");
        d r24 = c.f2846a;
        if (r24 == null) goto L55;
        r24.e("AIPackageManager", r23);
    L55:
        a(r5.b());
        return AbsAIPackageOperation.a(r5, r5.b(), 5);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r12);
        String r25 = "packageName: " + a().getPackageName() + ", appId: " + a().getAppId() + " ===> start update";
        Intrinsics.checkNotNullParameter("AIPackageManager", "tag");
        d r26 = c.f2846a;
        if (r26 == null) goto L17;
        r26.d("AIPackageManager", r25);
    L17:
        AIPackageManifestBean r27 = r5.f2688b;
        if (r27 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("packageManifest");
        r27 = null;
    L21:
        r17 = r5.a(r27, "inactive");
        if (r17 != null) goto L28;
        String r28 = "packageName: " + a().getPackageName() + ", appId: " + a().getAppId() + " ===> update failed : create AIPackage is null";
        Intrinsics.checkNotNullParameter("AIPackageManager", "tag");
        d r29 = c.f2846a;
        if (r29 == null) goto L27;
        r29.e("AIPackageManager", r28);
    L27:
        return AbsAIPackageOperation.a(r5, b(), 8);
    L28:
        r17.f2270q = b().f2270q;
        r17.f2271r = b().f2271r;
        r17.f2273u = b().f2273u;
        r17.f2272t = b().f2272t;
        r17.s = System.currentTimeMillis() / 1000;
        String r110 = AIPackageConfig.f2571a;
        r17.f2269p = c.e(new File(AIPackageConfig.b(a())));
        j r30 = j.f2734a;
        String r31 = r17.c();
        AIPackage.AIPackageType r111 = r17.e();
        String r112 = r17.f2259b;
        Intrinsics.checkNotNullParameter(r112, "packageName");
        Intrinsics.checkNotNullParameter(r31, Constant.APPID);
        Intrinsics.checkNotNullParameter(r111, "packageType");
        StringBuilder r113 = new StringBuilder("===onAIPackageUpdatePrepared: ");
        a.C(r113, r112, ", appId: ", r31, ", packageType: ");
        r113.append(r111.name());
        String r114 = r113.toString();
        Intrinsics.checkNotNullParameter("AIManager", "tag");
        d r32 = c.f2846a;
        if (r32 == null) goto L31;
        r32.d("AIManager", r114);
    L31:
        Iterator r33 = j.f2735b.iterator();
    L33:
        if (r33.hasNext() == false) goto L35;
        ((com.bytedance.ai.resource.c) r33.next()).a(r112, r31);
        goto L33
    L35:
        String r34 = b().f2259b;
        String r35 = b().c();
        AIPackage.AIPackageType r115 = b().e();
        j r116 = j.f2734a;
        Intrinsics.checkNotNullParameter(r34, "packageName");
        Intrinsics.checkNotNullParameter(r35, Constant.APPID);
        Intrinsics.checkNotNullParameter(r115, "packageType");
        StringBuilder r117 = new StringBuilder("===onAIPackageUpdateStarted: ");
        b.e(r117, r34, ", appId: ", r35, ", packageType: ");
        r117.append(r115.name());
        String r36 = r117.toString();
        Intrinsics.checkNotNullParameter("AIManager", "tag");
        d r118 = c.f2846a;
        if (r118 == null) goto L38;
        r118.d("AIManager", r36);
    L38:
        Iterator r37 = j.f2735b.iterator();
    L40:
        if (r37.hasNext() == false) goto L42;
        ((com.bytedance.ai.resource.c) r37.next()).c(r34, r35);
        goto L40
    L42:
        AIPackageStorage r38 = AIPackageStorage.f2618a;
        r10.f2684a = r5;
        r10.f2685b = r17;
        r10.e = 1;
        r18 = r38.d(r17, r10);
        if (r18 != r13) goto L46;
        return r13;
    L7:
        r10 = new AIPackageUpdateOperation$updateAIPackage$1(r5, r19);
        goto L8
    }

    @Override // com.bytedance.ai.resource.core.operations.AbsAIPackageOperation
    public final AIPackage.PackageStatus c() {
        return AIPackage.PackageStatus.f2283b;
    }

    @Override // com.bytedance.ai.resource.core.operations.AbsAIPackageOperation
    public final Object a(Continuation r5) {
        if (this.f2687a == null) goto L10;
        String r10 = AIPackageConfig.f2571a;
        if (AIPackageZipExtractor.b(AIPackageConfig.c(a()), AIPackageConfig.b(a())) == true) goto L9;
        return AbsAIPackageOperation.a(this, b(), 11);
    L9:
        return b((ContinuationImpl) r5);
    L10:
        String r11 = "packageName: " + a().getPackageName() + ", appId: " + a().getAppId() + " ===> update failed : AIPackage not installed";
        Intrinsics.checkNotNullParameter("AIPackageManager", "tag");
        d r12 = c.f2846a;
        if (r12 == null) goto L14;
        r12.e("AIPackageManager", r11);
    L14:
        return AbsAIPackageOperation.a(this, null, 7);
    }
}
