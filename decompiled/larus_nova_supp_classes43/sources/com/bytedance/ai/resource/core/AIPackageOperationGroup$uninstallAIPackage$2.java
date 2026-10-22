package com.bytedance.ai.resource.core;

import com.bytedance.ai.model.objects.AIPackage;
import com.bytedance.ai.resource.AIPackageManager;
import com.bytedance.ai.resource.core.operations.AIPackageUninstallOperation;
import com.bytedance.ai.resource.core.operations.AbsAIPackageOperation;
import com.bytedance.ai.utils.g;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.resource.core.AIPackageOperationGroup$uninstallAIPackage$2", f = "AIPackageOperationGroup.kt", i = {0, 0, 1, 1, 2, 2}, l = {241, 272, 271}, m = "invokeSuspend", n = {"key", "uninstallOperation", "key", "uninstallOperation", "key", "uninstallOperation"}, s = {"L$0", "L$1", "L$0", "L$1", "L$0", "L$1"})
public final class AIPackageOperationGroup$uninstallAIPackage$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ AIPackageDeployment.AIPackageDeploymentItem $deploymentInfo;
    final /* synthetic */ AIPackageManager.b $listener;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ AIPackageOperationGroup this$0;

    public AIPackageOperationGroup$uninstallAIPackage$2(AIPackageDeployment.AIPackageDeploymentItem r1, AIPackageManager.b r10, AIPackageOperationGroup r11, Continuation<? super AIPackageOperationGroup$uninstallAIPackage$2> r12) {
        this.$deploymentInfo = r1;
        this.$listener = r10;
        this.this$0 = r11;
        super(2, r12);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new AIPackageOperationGroup$uninstallAIPackage$2(this.$deploymentInfo, this.$listener, this.this$0, r11);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10) {
        return invoke((CoroutineScope) r1, (Continuation) r10);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r10) {
        return create(r1, r10).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object invokeSuspend(Object r25) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        int r12 = 0;
        if (r1 == 0) goto L22;
        if (r1 == 1) goto L21;
        if (r1 == 2) goto L14;
        if (r1 != 3) goto L13;
        Object r10 = (AIPackageUninstallOperation) this.L$1;
        String r11 = (String) this.L$0;
        ResultKt.throwOnFailure(r25);     // Catch: Throwable -> L10
        Object r13 = r10;
    L50:
        if (this.this$0.a.remove(r11, r13) == false) goto L56;
        g r14 = g.a;
        StringBuilder r15 = new StringBuilder("packageName: ");
        r15.append(this.$deploymentInfo.getPackageName());
        r15.append(", appId: ");
        r15.append(this.$deploymentInfo.getAppId());
        r15.append(" ===> uninstallAIPackage remove current operation: pendingCount=");
        ConcurrentLinkedQueue<AIPackageOperationGroup.a> r16 = this.this$0.c.get(r11);
        if (r16 == null) goto L54;
        r12 = r16.size();
    L54:
        r15.append(r12);
        r14.i("AIPackageManager", r15.toString());
    L56:
        return Unit.INSTANCE;
    L10:
        th = th;
    L60:
        if (this.this$0.a.remove(r11, r10) == false) goto L65;
        g r17 = g.a;
        StringBuilder r18 = new StringBuilder("packageName: ");
        r18.append(this.$deploymentInfo.getPackageName());
        r18.append(", appId: ");
        r18.append(this.$deploymentInfo.getAppId());
        r18.append(" ===> uninstallAIPackage remove current operation: pendingCount=");
        ConcurrentLinkedQueue<AIPackageOperationGroup.a> r19 = this.this$0.c.get(r11);
        if (r19 == null) goto L64;
        r12 = r19.size();
    L64:
        r18.append(r12);
        r17.i("AIPackageManager", r18.toString());
    L65:
        throw th;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        AIPackageOperationGroup r20 = (AIPackageOperationGroup) this.L$2;
        AIPackageUninstallOperation r21 = (AIPackageUninstallOperation) this.L$1;
        String r22 = (String) this.L$0;
        ResultKt.throwOnFailure(r25);     // Catch: Throwable -> L18
        Object r23 = r25;
    L17:
        AIPackageUninstallOperation r24 = r21;
        AIPackageOperationGroup r26 = r20;
        r10 = r24;
        this.L$0 = r22;     // Catch: Throwable -> L57
        this.L$1 = r10;     // Catch: Throwable -> L57
        this.L$2 = null;     // Catch: Throwable -> L57
        this.label = 3;     // Catch: Throwable -> L57
        if (r26.k((AbsAIPackageOperation.a) r23, this) != r0) goto L48;
        return r0;
    L48:
        r11 = r22;
        r13 = r10;
    L57:
        th = th;
    L20:
        r11 = r22;
        goto L60
    L21:
        AIPackageUninstallOperation r27 = (AIPackageUninstallOperation) this.L$1;
        String r28 = (String) this.L$0;
        ResultKt.throwOnFailure(r25);
        r22 = r28;
        r21 = r27;
        Object r29 = r25;
    L26:
        AIPackage r30 = (AIPackage) r29;
        if (r30 != null) goto L33;
        g.a.e("AIPackageManager", "packageName: " + this.$deploymentInfo.getPackageName() + ", appId: " + this.$deploymentInfo.getAppId() + " ===> AIPackage is not installed");
        AIPackageManager.b r31 = this.$listener;
        if (r31 == null) goto L32;
        r31.a(null, this.$deploymentInfo.getPackageName(), this.$deploymentInfo.getAppId(), AIPackage.AIPackageType.UNKNOWN, 7, null);
    L32:
        return Unit.INSTANCE;
    L33:
        r21.i(r30);
        if (this.this$0.a.putIfAbsent(r22, r21) == null) goto L37;
        g.a.d("AIPackageManager", "packageName: " + this.$deploymentInfo.getPackageName() + ", appId: " + this.$deploymentInfo.getAppId() + " ===> " + r22 + " is being uninstalled");
        this.this$0.d(this.$deploymentInfo, AIPackage.PackageStatus.DELETING, this.$listener, false);
        return Unit.INSTANCE;
    L37:
        AIPackageManager.b r32 = this.$listener;     // Catch: Throwable -> L18
        if (r32 == null) goto L42;
        AbsAIPackageOperation r33 = this.this$0.a.get(this.$deploymentInfo.getAppId());     // Catch: Throwable -> L18
        if (r33 == null) goto L42;
        r33.f(r32);     // Catch: Throwable -> L18
    L42:
        r20 = this.this$0;     // Catch: Throwable -> L18
        AIPackageDeployment.AIPackageDeploymentItem r34 = this.$deploymentInfo;     // Catch: Throwable -> L18
        this.L$0 = r22;     // Catch: Throwable -> L18
        this.L$1 = r21;     // Catch: Throwable -> L18
        this.L$2 = r20;     // Catch: Throwable -> L18
        this.label = 2;     // Catch: Throwable -> L18
        r23 = AIPackageOperationGroup.b(r20, r21, r34, this);     // Catch: Throwable -> L18
        if (r23 != r0) goto L17;
        return r0;
    L22:
        ResultKt.throwOnFailure(r25);
        String r35 = this.$deploymentInfo.getAppId();
        g.a.d("AIPackageManager", "packageName: " + this.$deploymentInfo.getPackageName() + ", appId: " + this.$deploymentInfo.getAppId() + " ===> start uninstall AIPackage,key = " + r35);
        AIPackageUninstallOperation r36 = new AIPackageUninstallOperation();
        r36.h(this.$deploymentInfo);
        AIPackageStorage r37 = AIPackageStorage.a;
        AIPackageDeployment.AIPackageDeploymentItem r38 = this.$deploymentInfo;
        this.L$0 = r35;
        this.L$1 = r36;
        this.label = 1;
        r29 = r37.k(r38, AIPackage.AIPackageType.UNKNOWN, false, 0, this);
        if (r29 != r0) goto L25;
        return r0;
    L25:
        r22 = r35;
        r21 = r36;
    L18:
        th = th;
        r10 = 1;
        goto L20
    }
}
