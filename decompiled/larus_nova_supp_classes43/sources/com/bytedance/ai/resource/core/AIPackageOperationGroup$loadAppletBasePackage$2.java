package com.bytedance.ai.resource.core;

import com.bytedance.ai.model.objects.AIPackage;
import com.bytedance.ai.model.objects.Applet;
import com.bytedance.ai.resource.core.bean.AIPackageManifestBean;
import com.bytedance.ai.resource.core.operations.AbsAIPackageOperation;
import com.bytedance.ai.utils.g;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/bytedance/ai/resource/core/operations/AbsAIPackageOperation$Result;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.resource.core.AIPackageOperationGroup$loadAppletBasePackage$2", f = "AIPackageOperationGroup.kt", i = {0}, l = {449}, m = "invokeSuspend", n = {"info"}, s = {"L$0"})
public final class AIPackageOperationGroup$loadAppletBasePackage$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super AbsAIPackageOperation.a>, Object> {
    final /* synthetic */ AIPackageDeployment.AIPackageDeploymentItem $deploymentInfo;
    Object L$0;
    int label;
    final /* synthetic */ AIPackageOperationGroup this$0;

    public AIPackageOperationGroup$loadAppletBasePackage$2(AIPackageDeployment.AIPackageDeploymentItem r1, AIPackageOperationGroup r10, Continuation<? super AIPackageOperationGroup$loadAppletBasePackage$2> r11) {
        this.$deploymentInfo = r1;
        this.this$0 = r10;
        super(2, r11);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new AIPackageOperationGroup$loadAppletBasePackage$2(this.$deploymentInfo, this.this$0, r11);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10) {
        return invoke((CoroutineScope) r1, (Continuation) r10);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super AbsAIPackageOperation.a> r10) {
        return create(r1, r10).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r18) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r10 = this.label;
        if (r10 == 0) goto L8;
        if (r10 != 1) goto L7;
        AIPackageDeployment.AIPackageDeploymentItem r11 = (AIPackageDeployment.AIPackageDeploymentItem) this.L$0;
        ResultKt.throwOnFailure(r18);
        Object r12 = r18;
    L16:
        AbsAIPackageOperation.a r13 = (AbsAIPackageOperation.a) r12;
        if (r13.e == 0) goto L19;
        return r13;
    L19:
        AIPackageManifestBean r14 = this.this$0.d.get(AIPackageOperationGroup.f(r11.getPackageName(), r11.getVersionCode()));
        if (r14 == null) goto L22;
        Applet r15 = com.bytedance.ai.resource.core.bean.a.a(r14);
        if (r15 == null) goto L26;
        String r16 = r15.o();
    L28:
        if (Intrinsics.areEqual(r16, r11.getAppId()) == true) goto L31;
        g.a.e("AIPackageManager", "packageName: " + r11.getPackageName() + ", appId: " + r11.getAppId() + " ===> base package does not contain target applet");
        return new AbsAIPackageOperation.a(null, r11.getPackageName(), r11.getAppId(), AIPackage.AIPackageType.APPLET, 8, 32);
    L31:
        r15.D = r14.getHasKeyStore();
        r15.E = r14.getVerifySignature();
        AIPackage.PackageStatus r17 = AIPackage.PackageStatus.BASE_READY;
        Intrinsics.checkNotNullParameter(r17, "<set-?>");
        r15.y = r17;
        return new AbsAIPackageOperation.a(r15, r11.getPackageName(), r11.getAppId(), AIPackage.AIPackageType.APPLET, 0, 32);
    L26:
        r16 = null;
        goto L28
    L22:
        return new AbsAIPackageOperation.a(null, r11.getPackageName(), r11.getAppId(), AIPackage.AIPackageType.UNKNOWN, 6, 32);
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r18);
        ConcurrentHashMap<String, AIPackageDeployment.AIPackageDeploymentItem> r19 = AIPackageDeployment.a;
        AIPackageDeployment.AIPackageDeploymentItem r20 = AIPackageDeployment.b(this.$deploymentInfo);
        if (r20 == null) goto L11;
        AIPackageOperationGroup r21 = this.this$0;
        this.L$0 = r20;
        this.label = 1;
        r12 = r21.j(r20, this);
        if (r12 != r1) goto L15;
        return r1;
    L15:
        r11 = r20;
        goto L16
    L11:
        return new AbsAIPackageOperation.a(null, this.$deploymentInfo.getPackageName(), this.$deploymentInfo.getAppId(), AIPackage.AIPackageType.UNKNOWN, 12, 32);
    }
}
