package com.bytedance.ai.resource.core;

import com.bytedance.ai.model.objects.AIPackage;
import com.bytedance.ai.resource.AIPackageManager;
import com.bytedance.ai.resource.core.operations.AIPackageInstallOperation;
import com.bytedance.ai.resource.core.operations.AbsAIPackageOperation;
import com.bytedance.ai.utils.g;
import java.util.concurrent.ConcurrentHashMap;
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
@DebugMetadata(c = "com.bytedance.ai.resource.core.AIPackageOperationGroup$installAIPackage$2", f = "AIPackageOperationGroup.kt", i = {0, 1, 1, 2, 3, 4}, l = {138, 140, 147, 158, 157}, m = "invokeSuspend", n = {"installOperation", "installOperation", "oldPackage", "installOperation", "installOperation", "installOperation"}, s = {"L$0", "L$0", "L$1", "L$0", "L$0", "L$0"})
final class AIPackageOperationGroup$installAIPackage$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ AIPackageDeployment.AIPackageDeploymentItem $deploymentInfo;
    final /* synthetic */ AIPackageManager.b $listener;
    final /* synthetic */ String $status;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ AIPackageOperationGroup this$0;

    public AIPackageOperationGroup$installAIPackage$2(AIPackageDeployment.AIPackageDeploymentItem r1, String r10, AIPackageOperationGroup r11, AIPackageManager.b r12, Continuation<? super AIPackageOperationGroup$installAIPackage$2> r13) {
        this.$deploymentInfo = r1;
        this.$status = r10;
        this.this$0 = r11;
        this.$listener = r12;
        super(2, r13);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new AIPackageOperationGroup$installAIPackage$2(this.$deploymentInfo, this.$status, this.this$0, this.$listener, r11);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10) {
        return invoke((CoroutineScope) r1, (Continuation) r10);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r10) {
        return create(r1, r10).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [int] */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v29 */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v21 */
    public final Object invokeSuspend(Object r26) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ?? r1 = this.label;
        int r10 = 0;
        ?? r11 = 1;
        if (r1 != 0) goto L101;
        ResultKt.throwOnFailure(r26);
        g r12 = g.a;
        r12.i("AIPackageManager", "packageName: " + this.$deploymentInfo.getPackageName() + ", appId: " + this.$deploymentInfo.getAppId() + " ===> installAIPackage start, appId = " + this.$deploymentInfo.getAppId());
        AIPackageInstallOperation r13 = new AIPackageInstallOperation(this.$status);
        r13.h(this.$deploymentInfo);
        if (this.this$0.a.putIfAbsent(this.$deploymentInfo.getAppId(), r13) == null) goto L105;
        r12.d("AIPackageManager", "packageName: " + this.$deploymentInfo.getPackageName() + ", appId: " + this.$deploymentInfo.getAppId() + " ===> " + this.$deploymentInfo.getAppId() + " is installing");
        this.this$0.d(this.$deploymentInfo, AIPackage.PackageStatus.INSTALLING, this.$listener, false);
        return Unit.INSTANCE;
    L105:
        AIPackageManager.b r14 = this.$listener;     // Catch: Throwable -> L88
        if (r14 != null) goto L99;
    L41:
        AIPackageStorage r15 = AIPackageStorage.a;     // Catch: Throwable -> L88
        AIPackageDeployment.AIPackageDeploymentItem r16 = this.$deploymentInfo;     // Catch: Throwable -> L88
        this.L$0 = r13;     // Catch: Throwable -> L88
        this.label = 1;     // Catch: Throwable -> L88
        AIPackageInstallOperation r17 = r13;
        String r18 = "packageName: ";
        String r19 = "AIPackageManager";
        String r110 = ", appId: ";
        Object r20 = r15.k(r16, AIPackage.AIPackageType.UNKNOWN, false, 0, this);     // Catch: Throwable -> L86
        if (r20 != r0) goto L46;
        return r0;
    L46:
        AIPackageInstallOperation r21 = r17;
    L102:
        AIPackage r22 = (AIPackage) r20;     // Catch: Throwable -> L63
        if (r22 == null) goto L65;
        AIPackageOperationGroup r23 = this.this$0;     // Catch: Throwable -> L63
        AIPackageDeployment.AIPackageDeploymentItem r24 = this.$deploymentInfo;     // Catch: Throwable -> L63
        this.L$0 = r21;     // Catch: Throwable -> L63
        this.L$1 = r22;     // Catch: Throwable -> L63
        this.L$2 = r22;     // Catch: Throwable -> L63
        this.label = 2;     // Catch: Throwable -> L63
        Object r25 = r23.e(r22, r24, false, this);     // Catch: Throwable -> L63
        if (r25 != r0) goto L53;
        return r0;
    L53:
        if (((Boolean) r25).booleanValue() == true) goto L62;
        Unit r27 = Unit.INSTANCE;     // Catch: Throwable -> L63
        if (this.this$0.a.remove(this.$deploymentInfo.getAppId(), r21) == false) goto L61;
        g r28 = g.a;
        StringBuilder r29 = new StringBuilder(r18);
        r29.append(this.$deploymentInfo.getPackageName());
        r29.append(r110);
        r29.append(this.$deploymentInfo.getAppId());
        r29.append(" ===> installAIPackage remove current operation: pendingCount=");
        ConcurrentLinkedQueue<AIPackageOperationGroup.a> r30 = this.this$0.c.get(this.$deploymentInfo.getAppId());
        if (r30 == null) goto L60;
        r10 = r30.size();
    L60:
        r29.append(r10);
        r28.i(r19, r29.toString());
    L61:
        return r27;
    L62:
        r21.i(r22);     // Catch: Throwable -> L63
    L65:
        ConcurrentHashMap<String, AIPackageDeployment.AIPackageDeploymentItem> r31 = AIPackageDeployment.a;     // Catch: Throwable -> L63
        AIPackageDeployment.AIPackageDeploymentItem r32 = AIPackageDeployment.b(this.$deploymentInfo);     // Catch: Throwable -> L63
        if (r32 != null) goto L70;
        AIPackageOperationGroup r33 = this.this$0;     // Catch: Throwable -> L63
        AbsAIPackageOperation.a r34 = new AbsAIPackageOperation.a(null, this.$deploymentInfo.getPackageName(), this.$deploymentInfo.getAppId(), AIPackage.AIPackageType.UNKNOWN, 12, 32);     // Catch: Throwable -> L63
        this.L$0 = r21;     // Catch: Throwable -> L63
        this.L$1 = null;     // Catch: Throwable -> L63
        this.L$2 = null;     // Catch: Throwable -> L63
        this.label = 3;     // Catch: Throwable -> L63
        if (r33.k(r34, this) != r0) goto L76;
        return r0;
    L76:
        AIPackageInstallOperation r35 = r21;
    L78:
        if (this.this$0.a.remove(this.$deploymentInfo.getAppId(), r35) == false) goto L84;
        g r36 = g.a;
        StringBuilder r37 = new StringBuilder(r18);
        r37.append(this.$deploymentInfo.getPackageName());
        r37.append(r110);
        r37.append(this.$deploymentInfo.getAppId());
        r37.append(" ===> installAIPackage remove current operation: pendingCount=");
        ConcurrentLinkedQueue<AIPackageOperationGroup.a> r38 = this.this$0.c.get(this.$deploymentInfo.getAppId());
        if (r38 == null) goto L82;
        r10 = r38.size();
    L82:
        r37.append(r10);
        r36.i(r19, r37.toString());
    L84:
        return Unit.INSTANCE;
    L70:
        AIPackageOperationGroup r39 = this.this$0;     // Catch: Throwable -> L63
        this.L$0 = r21;     // Catch: Throwable -> L63
        this.L$1 = r39;     // Catch: Throwable -> L63
        this.L$2 = null;     // Catch: Throwable -> L63
        this.label = 4;     // Catch: Throwable -> L63
        Object r40 = AIPackageOperationGroup.b(r39, r21, r32, this);     // Catch: Throwable -> L63
        if (r40 != r0) goto L73;
        return r0;
    L73:
        this.L$0 = r21;     // Catch: Throwable -> L63
        this.L$1 = null;     // Catch: Throwable -> L63
        this.label = 5;     // Catch: Throwable -> L63
        if (r39.k((AbsAIPackageOperation.a) r40, this) != r0) goto L76;
        return r0;
    L63:
        th = th;
        ?? r41 = r21;
    L92:
        if (this.this$0.a.remove(this.$deploymentInfo.getAppId(), r41) == false) goto L97;
        g r42 = g.a;
        StringBuilder r43 = new StringBuilder(r18);
        r43.append(this.$deploymentInfo.getPackageName());
        r43.append(r110);
        r43.append(this.$deploymentInfo.getAppId());
        r43.append(" ===> installAIPackage remove current operation: pendingCount=");
        ConcurrentLinkedQueue<AIPackageOperationGroup.a> r44 = this.this$0.c.get(this.$deploymentInfo.getAppId());
        if (r44 == null) goto L96;
        r10 = r44.size();
    L96:
        r43.append(r10);
        r42.i(r19, r43.toString());
    L97:
        throw th;
    L86:
        th = th;
    L90:
        r41 = r17;
        goto L92
    L99:
        AbsAIPackageOperation r45 = this.this$0.a.get(this.$deploymentInfo.getAppId());     // Catch: Throwable -> L38
        if (r45 == null) goto L41;
        r45.f(r14);     // Catch: Throwable -> L38
    L38:
        th = th;
        r11 = r13;
    L40:
        r41 = r11;
        r18 = "packageName: ";
        r19 = "AIPackageManager";
        r110 = ", appId: ";
    L88:
        th = th;
        r17 = r13;
        r18 = "packageName: ";
        r19 = "AIPackageManager";
        r110 = ", appId: ";
        goto L90
    L101:
        if (r1 != 1) goto L98;
        AIPackageInstallOperation r46 = (AIPackageInstallOperation) this.L$0;
        ResultKt.throwOnFailure(r26);     // Catch: Throwable -> L26
        r21 = r46;
        r18 = "packageName: ";
        r19 = "AIPackageManager";
        r110 = ", appId: ";
        r20 = r26;
        goto L102
    L98:
        if (r1 == 2) goto L18;
        if (r1 == 3) goto L15;
        if (r1 == 4) goto L12;
        if (r1 == 5) goto L15;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L12:
        AIPackageOperationGroup r47 = (AIPackageOperationGroup) this.L$1;
        r21 = (AIPackageInstallOperation) this.L$0;
        ResultKt.throwOnFailure(r26);     // Catch: Throwable -> L21
        r39 = r47;
        r18 = "packageName: ";
        r19 = "AIPackageManager";
        r110 = ", appId: ";
        r40 = r26;
    L15:
        r35 = (AIPackageInstallOperation) this.L$0;
        ResultKt.throwOnFailure(r26);     // Catch: Throwable -> L26
        r18 = "packageName: ";
        r19 = "AIPackageManager";
        r110 = ", appId: ";
        goto L78
    L18:
        AIPackage r48 = (AIPackage) this.L$2;
        r22 = (AIPackage) this.L$1;
        r21 = (AIPackageInstallOperation) this.L$0;
        ResultKt.throwOnFailure(r26);     // Catch: Throwable -> L21
        r25 = r26;
        r18 = "packageName: ";
        r19 = "AIPackageManager";
        r110 = ", appId: ";
    L21:
        th = th;
    L26:
        th = th;
        r11 = r1;
        goto L40
    }
}
