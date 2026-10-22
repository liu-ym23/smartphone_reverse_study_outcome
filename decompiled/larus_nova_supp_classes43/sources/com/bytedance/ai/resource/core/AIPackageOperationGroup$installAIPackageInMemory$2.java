package com.bytedance.ai.resource.core;

import com.bytedance.ai.debug.IAISDKDebugService;
import com.bytedance.ai.model.objects.AIPackage;
import com.bytedance.ai.resource.AIPackageManager;
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
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.resource.core.AIPackageOperationGroup$installAIPackageInMemory$2", f = "AIPackageOperationGroup.kt", i = {0, 1, 2, 2, 3, 4, 5}, l = {76, 78, 81, 88, 99, 98}, m = "invokeSuspend", n = {"installOperation", "installOperation", "installOperation", "oldPackage", "installOperation", "installOperation", "installOperation"}, s = {"L$0", "L$0", "L$0", "L$1", "L$0", "L$0", "L$0"})
final class AIPackageOperationGroup$installAIPackageInMemory$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ AIPackageDeployment.AIPackageDeploymentItem $deploymentInfo;
    final /* synthetic */ AIPackageManager.b $listener;
    final /* synthetic */ String $status;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ AIPackageOperationGroup this$0;

    public AIPackageOperationGroup$installAIPackageInMemory$2(AIPackageDeployment.AIPackageDeploymentItem r1, String r10, AIPackageOperationGroup r11, AIPackageManager.b r12, Continuation<? super AIPackageOperationGroup$installAIPackageInMemory$2> r13) {
        this.$deploymentInfo = r1;
        this.$status = r10;
        this.this$0 = r11;
        this.$listener = r12;
        super(2, r13);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new AIPackageOperationGroup$installAIPackageInMemory$2(this.$deploymentInfo, this.$status, this.this$0, this.$listener, r11);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10) {
        return invoke((CoroutineScope) r1, (Continuation) r10);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r10) {
        return create(r1, r10).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [int] */
    /* JADX WARN: Type inference failed for: r2v34 */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r9v1, types: [java.lang.Object] */
    public final Object invokeSuspend(Object r19) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ?? r10 = this.label;
        int r11 = 0;
        switch(r10) {
            case 0: goto L23;
            case 1: goto L18;
            case 2: goto L15;
            case 3: goto L12;
            case 4: goto L9;
            case 5: goto L6;
            case 6: goto L9;
            default: goto L5;
        };
    L6:
        AIPackageOperationGroup r12 = (AIPackageOperationGroup) this.L$1;
        com.bytedance.ai.resource.core.operations.a r13 = (com.bytedance.ai.resource.core.operations.a) this.L$0;
        ResultKt.throwOnFailure(r19);     // Catch: Throwable -> L67
        AIPackageOperationGroup r14 = r12;
        Object r15 = r19;
    L77:
        this.L$0 = r13;     // Catch: Throwable -> L67
        this.L$1 = null;     // Catch: Throwable -> L67
        this.label = 6;     // Catch: Throwable -> L67
        if (r14.k((AbsAIPackageOperation.a) r15, this) != r0) goto L80;
        return r0;
    L80:
        com.bytedance.ai.resource.core.operations.a r16 = r13;
    L82:
        if (this.this$0.a.remove(this.$deploymentInfo.getAppId(), r16) == false) goto L89;
        g r1 = g.a;
        StringBuilder r17 = new StringBuilder("packageName: ");
        r17.append(this.$deploymentInfo.getPackageName());
        r17.append(", appId: ");
        r17.append(this.$deploymentInfo.getAppId());
        r17.append(" ===> installAIPackageInMemory remove current operation: pendingCount=");
        ConcurrentLinkedQueue<AIPackageOperationGroup.a> r18 = this.this$0.c.get(this.$deploymentInfo.getAppId());
        if (r18 == null) goto L86;
        int r20 = r18.size();
    L87:
        r17.append(r20);
        r1.i("AIPackageManager", r17.toString());
        goto L89
    L86:
        r20 = 0;
    L89:
        return Unit.INSTANCE;
    L9:
        r16 = (com.bytedance.ai.resource.core.operations.a) this.L$0;
        ResultKt.throwOnFailure(r19);     // Catch: Throwable -> L21
        goto L82
    L12:
        AIPackage r21 = (AIPackage) this.L$2;
        AIPackage r22 = (AIPackage) this.L$1;
        r13 = (com.bytedance.ai.resource.core.operations.a) this.L$0;
        ResultKt.throwOnFailure(r19);     // Catch: Throwable -> L67
        Object r110 = r19;
    L56:
        if (((Boolean) r110).booleanValue() == true) goto L65;
        Unit r23 = Unit.INSTANCE;     // Catch: Throwable -> L67
        if (this.this$0.a.remove(this.$deploymentInfo.getAppId(), r13) == false) goto L64;
        g r24 = g.a;
        StringBuilder r25 = new StringBuilder("packageName: ");
        r25.append(this.$deploymentInfo.getPackageName());
        r25.append(", appId: ");
        r25.append(this.$deploymentInfo.getAppId());
        r25.append(" ===> installAIPackageInMemory remove current operation: pendingCount=");
        ConcurrentLinkedQueue<AIPackageOperationGroup.a> r26 = this.this$0.c.get(this.$deploymentInfo.getAppId());
        if (r26 == null) goto L63;
        r11 = r26.size();
    L63:
        r25.append(r11);
        r24.i("AIPackageManager", r25.toString());
    L64:
        return r23;
    L65:
        r13.i(r22);     // Catch: Throwable -> L67
    L102:
        ConcurrentHashMap<String, AIPackageDeployment.AIPackageDeploymentItem> r27 = AIPackageDeployment.a;     // Catch: Throwable -> L90
        AIPackageDeployment.AIPackageDeploymentItem r28 = AIPackageDeployment.b(this.$deploymentInfo);     // Catch: Throwable -> L90
        if (r28 != null) goto L74;
        AIPackageOperationGroup r29 = this.this$0;     // Catch: Throwable -> L90
        AbsAIPackageOperation.a r111 = new AbsAIPackageOperation.a(null, this.$deploymentInfo.getPackageName(), this.$deploymentInfo.getAppId(), AIPackage.AIPackageType.UNKNOWN, 12, 32);     // Catch: Throwable -> L90
        this.L$0 = r13;     // Catch: Throwable -> L90
        this.L$1 = null;     // Catch: Throwable -> L90
        this.L$2 = null;     // Catch: Throwable -> L90
        this.label = 4;     // Catch: Throwable -> L90
        if (r29.k(r111, this) != r0) goto L80;
        return r0;
    L74:
        r14 = this.this$0;     // Catch: Throwable -> L90
        this.L$0 = r13;     // Catch: Throwable -> L90
        this.L$1 = r14;     // Catch: Throwable -> L90
        this.L$2 = null;     // Catch: Throwable -> L90
        this.label = 5;     // Catch: Throwable -> L90
        r15 = AIPackageOperationGroup.b(r14, r13, r28, this);     // Catch: Throwable -> L90
        if (r15 != r0) goto L77;
        return r0;
    L90:
        th = th;
        r10 = r13;
    L92:
        ?? r30 = r10;
    L94:
        if (this.this$0.a.remove(this.$deploymentInfo.getAppId(), r30) == false) goto L100;
        g r31 = g.a;
        StringBuilder r32 = new StringBuilder("packageName: ");
        r32.append(this.$deploymentInfo.getPackageName());
        r32.append(", appId: ");
        r32.append(this.$deploymentInfo.getAppId());
        r32.append(" ===> installAIPackageInMemory remove current operation: pendingCount=");
        ConcurrentLinkedQueue<AIPackageOperationGroup.a> r33 = this.this$0.c.get(this.$deploymentInfo.getAppId());
        if (r33 == null) goto L98;
        int r34 = r33.size();
    L99:
        r32.append(r34);
        r31.i("AIPackageManager", r32.toString());
        goto L100
    L98:
        r34 = 0;
    L100:
        throw th;
    L15:
        com.bytedance.ai.resource.core.operations.a r35 = (com.bytedance.ai.resource.core.operations.a) this.L$0;
        ResultKt.throwOnFailure(r19);     // Catch: Throwable -> L21
        r13 = r35;
        Object r36 = r19;
    L50:
        r22 = (AIPackage) r36;     // Catch: Throwable -> L67
    L51:
        if (r22 == null) goto L102;
        AIPackageOperationGroup r112 = this.this$0;     // Catch: Throwable -> L67
        AIPackageDeployment.AIPackageDeploymentItem r113 = this.$deploymentInfo;     // Catch: Throwable -> L67
        this.L$0 = r13;     // Catch: Throwable -> L67
        this.L$1 = r22;     // Catch: Throwable -> L67
        this.L$2 = r22;     // Catch: Throwable -> L67
        this.label = 3;     // Catch: Throwable -> L67
        r110 = r112.e(r22, r113, false, this);     // Catch: Throwable -> L67
        if (r110 != r0) goto L56;
        return r0;
    L18:
        com.bytedance.ai.resource.core.operations.a r37 = (com.bytedance.ai.resource.core.operations.a) this.L$0;
        ResultKt.throwOnFailure(r19);     // Catch: Throwable -> L21
        r13 = r37;
        Object r38 = r19;
    L46:
        r22 = (AIPackage) r38;     // Catch: Throwable -> L67
        goto L51
    L23:
        ResultKt.throwOnFailure(r19);
        g r39 = g.a;
        r39.i("AIPackageManager", "packageName: " + this.$deploymentInfo.getPackageName() + ", appId: " + this.$deploymentInfo.getAppId() + " ===> installAIPackageInMemory start, appId = " + this.$deploymentInfo.getAppId());
        r13 = new com.bytedance.ai.resource.core.operations.a(this.$status);
        r13.h(this.$deploymentInfo);
        if (this.this$0.a.putIfAbsent(this.$deploymentInfo.getAppId(), r13) == null) goto L27;
        r39.d("AIPackageManager", "packageName: " + this.$deploymentInfo.getPackageName() + ", appId: " + this.$deploymentInfo.getAppId() + " ===> " + this.$deploymentInfo.getAppId() + " is installing");
        this.this$0.d(this.$deploymentInfo, AIPackage.PackageStatus.INSTALLING, this.$listener, true);
        return Unit.INSTANCE;
    L27:
        AIPackageManager.b r40 = this.$listener;     // Catch: Throwable -> L67
        if (r40 == null) goto L32;
        AbsAIPackageOperation r114 = this.this$0.a.get(this.$deploymentInfo.getAppId());     // Catch: Throwable -> L67
        if (r114 == null) goto L32;
        r114.f(r40);     // Catch: Throwable -> L67
    L32:
        String r41 = this.$deploymentInfo.getVersionTag();     // Catch: Throwable -> L67
        if (r41 != null) goto L35;
    L38:
        boolean r42 = true;
    L39:
        if (r42 == true) goto L42;
        r22 = null;
        goto L51
    L42:
        if (Intrinsics.areEqual(this.$deploymentInfo.getPackageName(), this.$deploymentInfo.getAppId()) == false) goto L47;
        IAISDKDebugService.Companion r43 = IAISDKDebugService.a;     // Catch: Throwable -> L67
        String r115 = this.$deploymentInfo.getPackageName();     // Catch: Throwable -> L67
        this.L$0 = r13;     // Catch: Throwable -> L67
        this.label = 1;     // Catch: Throwable -> L67
        r38 = r43.y(r115, null, this);     // Catch: Throwable -> L67
        if (r38 != r0) goto L46;
        return r0;
    L47:
        IAISDKDebugService.Companion r44 = IAISDKDebugService.a;     // Catch: Throwable -> L67
        String r116 = this.$deploymentInfo.getPackageName();     // Catch: Throwable -> L67
        String r117 = this.$deploymentInfo.getAppId();     // Catch: Throwable -> L67
        this.L$0 = r13;     // Catch: Throwable -> L67
        this.label = 2;     // Catch: Throwable -> L67
        r36 = r44.x(r116, r117, null, this);     // Catch: Throwable -> L67
        if (r36 != r0) goto L50;
        return r0;
    L35:
        if (r41.length() == 0) goto L38;
        r42 = false;
        goto L39
    L5:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L21:
        th = th;
    L67:
        th = th;
        goto L94
    }
}
