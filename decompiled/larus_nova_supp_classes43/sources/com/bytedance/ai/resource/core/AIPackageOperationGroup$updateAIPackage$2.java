package com.bytedance.ai.resource.core;

import com.bytedance.ai.model.AppletRuntimeManager;
import com.bytedance.ai.model.objects.AIPackage;
import com.bytedance.ai.resource.AIPackageManager;
import com.bytedance.ai.resource.core.operations.AIPackageUpdateOperation;
import com.bytedance.ai.resource.core.operations.AbsAIPackageOperation;
import com.bytedance.ai.utils.g;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.resource.core.AIPackageOperationGroup$updateAIPackage$2", f = "AIPackageOperationGroup.kt", i = {0, 0, 1, 1, 2, 2, 3, 3}, l = {182, 214, 219, 218}, m = "invokeSuspend", n = {"key", "updateOperation", "key", "updateOperation", "key", "updateOperation", "key", "updateOperation"}, s = {"L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$0", "L$1"})
public final class AIPackageOperationGroup$updateAIPackage$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ AIPackageDeployment.AIPackageDeploymentItem $deploymentInfo;
    final /* synthetic */ AIPackageManager.b $listener;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ AIPackageOperationGroup this$0;

    public AIPackageOperationGroup$updateAIPackage$2(AIPackageDeployment.AIPackageDeploymentItem r1, AIPackageManager.b r10, AIPackageOperationGroup r11, Continuation<? super AIPackageOperationGroup$updateAIPackage$2> r12) {
        this.$deploymentInfo = r1;
        this.$listener = r10;
        this.this$0 = r11;
        super(2, r12);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new AIPackageOperationGroup$updateAIPackage$2(this.$deploymentInfo, this.$listener, this.this$0, r11);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10) {
        return invoke((CoroutineScope) r1, (Continuation) r10);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r10) {
        return create(r1, r10).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r18) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r10 = this.label;
        if (r10 == 0) goto L26;
        if (r10 == 1) goto L25;
        if (r10 == 2) goto L20;
        if (r10 == 3) goto L15;
        if (r10 != 4) goto L14;
        AIPackageUpdateOperation r11 = (AIPackageUpdateOperation) this.L$1;
        String r12 = (String) this.L$0;
        ResultKt.throwOnFailure(r18);     // Catch: Throwable -> L11
    L73:
        if (this.this$0.a.remove(r12, r11) == false) goto L80;
        g r1 = g.a;
        StringBuilder r13 = new StringBuilder("packageName: ");
        r13.append(this.$deploymentInfo.getPackageName());
        r13.append(", appId: ");
        r13.append(this.$deploymentInfo.getAppId());
        r13.append(" ===> updateAIPackage remove current operation: pendingCount=");
        ConcurrentLinkedQueue<AIPackageOperationGroup.a> r14 = this.this$0.c.get(r12);
        if (r14 == null) goto L77;
        int r15 = r14.size();
    L78:
        r13.append(r15);
        r1.i("AIPackageManager", r13.toString());
        goto L80
    L77:
        r15 = 0;
    L80:
        return Unit.INSTANCE;
    L11:
        th = th;
    L84:
        if (this.this$0.a.remove(r12, r11) == false) goto L90;
        g r16 = g.a;
        StringBuilder r17 = new StringBuilder("packageName: ");
        r17.append(this.$deploymentInfo.getPackageName());
        r17.append(", appId: ");
        r17.append(this.$deploymentInfo.getAppId());
        r17.append(" ===> updateAIPackage remove current operation: pendingCount=");
        ConcurrentLinkedQueue<AIPackageOperationGroup.a> r19 = this.this$0.c.get(r12);
        if (r19 == null) goto L88;
        int r20 = r19.size();
    L89:
        r17.append(r20);
        r16.i("AIPackageManager", r17.toString());
        goto L90
    L88:
        r20 = 0;
    L90:
        throw th;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        AIPackageOperationGroup r21 = (AIPackageOperationGroup) this.L$2;
        AIPackageUpdateOperation r22 = (AIPackageUpdateOperation) this.L$1;
        String r23 = (String) this.L$0;
        ResultKt.throwOnFailure(r18);     // Catch: Throwable -> L18
        Object r24 = r18;
        AIPackageOperationGroup r25 = r21;
        r11 = r22;
    L68:
        this.L$0 = r23;     // Catch: Throwable -> L23
        this.L$1 = r11;     // Catch: Throwable -> L23
        this.L$2 = null;     // Catch: Throwable -> L23
        this.label = 4;     // Catch: Throwable -> L23
        if (r25.k((AbsAIPackageOperation.a) r24, this) != r0) goto L71;
        return r0;
    L71:
        r12 = r23;
    L18:
        th = th;
        r11 = r22;
    L24:
        r12 = r23;
        goto L84
    L20:
        AIPackage r26 = (AIPackage) this.L$2;
        r11 = (AIPackageUpdateOperation) this.L$1;
        r23 = (String) this.L$0;
        ResultKt.throwOnFailure(r18);     // Catch: Throwable -> L23
        Object r27 = r18;
    L55:
        if (((Boolean) r27).booleanValue() == true) goto L65;
        Unit r28 = Unit.INSTANCE;     // Catch: Throwable -> L23
        if (this.this$0.a.remove(r23, r11) == false) goto L64;
        g r29 = g.a;
        StringBuilder r30 = new StringBuilder("packageName: ");
        r30.append(this.$deploymentInfo.getPackageName());
        r30.append(", appId: ");
        r30.append(this.$deploymentInfo.getAppId());
        r30.append(" ===> updateAIPackage remove current operation: pendingCount=");
        ConcurrentLinkedQueue<AIPackageOperationGroup.a> r31 = this.this$0.c.get(r23);
        if (r31 == null) goto L62;
        int r32 = r31.size();
    L63:
        r30.append(r32);
        r29.i("AIPackageManager", r30.toString());
        goto L64
    L62:
        r32 = 0;
    L64:
        return r28;
    L65:
        r25 = this.this$0;     // Catch: Throwable -> L23
        AIPackageDeployment.AIPackageDeploymentItem r33 = this.$deploymentInfo;     // Catch: Throwable -> L23
        this.L$0 = r23;     // Catch: Throwable -> L23
        this.L$1 = r11;     // Catch: Throwable -> L23
        this.L$2 = r25;     // Catch: Throwable -> L23
        this.label = 3;     // Catch: Throwable -> L23
        r24 = AIPackageOperationGroup.b(r25, r11, r33, this);     // Catch: Throwable -> L23
        if (r24 != r0) goto L68;
        return r0;
    L23:
        th = th;
        goto L24
    L25:
        r11 = (AIPackageUpdateOperation) this.L$1;
        String r110 = (String) this.L$0;
        ResultKt.throwOnFailure(r18);
        Object r111 = r18;
    L30:
        AIPackage r112 = (AIPackage) r111;
        if (r112 != null) goto L37;
        g.a.e("AIPackageManager", "packageName: " + this.$deploymentInfo.getPackageName() + ", appId: " + this.$deploymentInfo.getAppId() + " ===> AIPackage is not installed");
        AIPackageManager.b r34 = this.$listener;
        if (r34 == null) goto L36;
        r34.a(null, this.$deploymentInfo.getPackageName(), this.$deploymentInfo.getAppId(), AIPackage.AIPackageType.UNKNOWN, 7, null);
    L36:
        return Unit.INSTANCE;
    L37:
        r11.i(r112);
        if (this.this$0.a.putIfAbsent(r110, r11) == null) goto L92;
        g.a.d("AIPackageManager", "packageName: " + this.$deploymentInfo.getPackageName() + ", appId: " + this.$deploymentInfo.getAppId() + " ===> " + r110 + " is updating");
        this.this$0.d(this.$deploymentInfo, AIPackage.PackageStatus.UPDATING, this.$listener, false);
        return Unit.INSTANCE;
    L92:
        AIPackageManager.b r113 = this.$listener;     // Catch: Throwable -> L81
        if (r113 == null) goto L46;
        AbsAIPackageOperation r35 = this.this$0.a.get(this.$deploymentInfo.getAppId());     // Catch: Throwable -> L81
        if (r35 == null) goto L46;
        r35.f(r113);     // Catch: Throwable -> L81
    L46:
        AIPackageOperationGroup r36 = this.this$0;     // Catch: Throwable -> L81
        AIPackageDeployment.AIPackageDeploymentItem r114 = this.$deploymentInfo;     // Catch: Throwable -> L81
        AppletRuntimeManager.INSTANCE.getClass();     // Catch: Throwable -> L81
        g2.b r115 = AppletRuntimeManager.d;     // Catch: Throwable -> L81
        if (r115 == null) goto L49;
        String r37 = r114.getAppId();     // Catch: Throwable -> L81
        String r38 = r114.getPackageName();     // Catch: Throwable -> L81
        r114.getVersionCode();     // Catch: Throwable -> L81
        boolean r39 = Intrinsics.areEqual(r115.N(r37, r38), Boxing.boxBoolean(true));     // Catch: Throwable -> L81
    L50:
        this.L$0 = r110;     // Catch: Throwable -> L81
        this.L$1 = r11;     // Catch: Throwable -> L81
        this.L$2 = r112;     // Catch: Throwable -> L81
        this.label = 2;     // Catch: Throwable -> L81
        r27 = r36.e(r112, r114, r39, this);     // Catch: Throwable -> L81
        if (r27 != r0) goto L53;
        return r0;
    L53:
        r23 = r110;
        goto L55
    L49:
        r39 = false;
    L81:
        th = th;
        r12 = r110;
        goto L84
    L26:
        ResultKt.throwOnFailure(r18);
        String r40 = this.$deploymentInfo.getAppId();
        g.a.d("AIPackageManager", "packageName: " + this.$deploymentInfo.getPackageName() + ", appId: " + this.$deploymentInfo.getAppId() + " ===> start updating AIPackage,key = " + r40);
        AIPackageUpdateOperation r116 = new AIPackageUpdateOperation();
        r116.h(this.$deploymentInfo);
        AIPackageStorage r117 = AIPackageStorage.a;
        AIPackageDeployment.AIPackageDeploymentItem r118 = this.$deploymentInfo;
        this.L$0 = r40;
        this.L$1 = r116;
        this.label = 1;
        r111 = r117.l(r118, this);
        if (r111 != r0) goto L29;
        return r0;
    L29:
        r110 = r40;
        r11 = r116;
        goto L30
    }
}
