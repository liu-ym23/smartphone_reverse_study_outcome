package com.bytedance.ai.resource.core;

import com.bytedance.ai.model.objects.AIPackage;
import com.bytedance.ai.resource.core.operations.AIPackageInstallInMemoryOperation;
import com.bytedance.ai.resource.core.operations.AbsAIPackageOperation;
import com.bytedance.ai.resource.l;
import java.util.concurrent.ConcurrentHashMap;
import jm.c;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import t0.d;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.resource.core.AIPackageOperationGroup$installAIPackageInMemory$2", f = "AIPackageOperationGroup.kt", i = {0, 1, 2, 2}, l = {73, 75, 78, 85, 96, 95}, m = "invokeSuspend", n = {"installOperation", "installOperation", "installOperation", "oldPackage"}, s = {"L$0", "L$0", "L$0", "L$1"})
@SourceDebugExtension({"SMAP\nAIPackageOperationGroup.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AIPackageOperationGroup.kt\ncom/bytedance/ai/resource/core/AIPackageOperationGroup$installAIPackageInMemory$2\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,620:1\n1#2:621\n*E\n"})
final class AIPackageOperationGroup$installAIPackageInMemory$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object f2589a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public AIPackage f2590b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f2591c;
    public final /* synthetic */ AIPackageDeployment.AIPackageDeploymentItem d;
    public final /* synthetic */ AIPackageOperationGroup e;
    public final /* synthetic */ l f;

    public AIPackageOperationGroup$installAIPackageInMemory$2(AIPackageDeployment.AIPackageDeploymentItem r5, AIPackageOperationGroup r10, l r11, Continuation r12) {
        this.d = r5;
        this.e = r10;
        this.f = r11;
        super(2, r12);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object r5, Continuation r10) {
        return new AIPackageOperationGroup$installAIPackageInMemory$2(this.d, this.e, this.f, r10);
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public final Object mo2invoke(CoroutineScope r5, Continuation<? super Unit> r10) {
        return ((AIPackageOperationGroup$installAIPackageInMemory$2) create(r5, r10)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r12) {
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch(this.f2591c) {
            case 0: goto L11;
            case 1: goto L10;
            case 2: goto L9;
            case 3: goto L8;
            case 4: goto L7;
            case 5: goto L6;
            case 6: goto L7;
            default: goto L5;
        };
    L6:
        AIPackageOperationGroup r10 = (AIPackageOperationGroup) this.f2589a;
        ResultKt.throwOnFailure(r12);
    L56:
        this.f2589a = null;
        this.f2591c = 6;
        if (r10.a((AbsAIPackageOperation.Result) r12, this) != r5) goto L60;
    L58:
        return r5;
    L60:
        return Unit.INSTANCE;
    L7:
        ResultKt.throwOnFailure(r12);
        goto L60
    L8:
        AIPackage r11 = this.f2590b;
        AIPackageInstallInMemoryOperation r13 = (AIPackageInstallInMemoryOperation) this.f2589a;
        ResultKt.throwOnFailure(r12);
    L44:
        if (((Boolean) r12).booleanValue() == false) goto L46;
        r13.getClass();
        Intrinsics.checkNotNullParameter(r11, "oldPackage");
        Intrinsics.checkNotNullParameter(r11, "<set-?>");
        r13.f2687a = r11;
    L48:
        ConcurrentHashMap r14 = AIPackageDeployment.f2573a;
        AIPackageDeployment.AIPackageDeploymentItem r15 = AIPackageDeployment.a(this.d);
        if (r15 != null) goto L53;
        AIPackageOperationGroup r16 = this.e;
        AbsAIPackageOperation.Result r17 = new AbsAIPackageOperation.Result(null, this.d.getPackageName(), this.d.getAppId(), AIPackage.AIPackageType.f2281c, 12, null);
        this.f2589a = null;
        this.f2590b = null;
        this.f2591c = 4;
        if (r16.a(r17, this) != r5) goto L60;
    L53:
        r10 = this.e;
        this.f2589a = r10;
        this.f2590b = null;
        this.f2591c = 5;
        r12 = AIPackageOperationGroup.a(r10, r13, r15, this);
        if (r12 != r5) goto L56;
    L46:
        return Unit.INSTANCE;
    L9:
        AIPackageInstallInMemoryOperation r18 = (AIPackageInstallInMemoryOperation) this.f2589a;
        ResultKt.throwOnFailure(r12);
    L38:
        AIPackage r19 = (AIPackage) r12;
    L33:
        r13 = r18;
        r11 = r19;
        if (r11 == null) goto L48;
        AIPackageOperationGroup r110 = this.e;
        AIPackageDeployment.AIPackageDeploymentItem r20 = this.d;
        this.f2589a = r13;
        this.f2590b = r11;
        this.f2591c = 3;
        r12 = r110.a(r11, r20, false, this);
        if (r12 != r5) goto L44;
    L10:
        r18 = (AIPackageInstallInMemoryOperation) this.f2589a;
        ResultKt.throwOnFailure(r12);
    L32:
        r19 = (AIPackage) r12;
        goto L33
    L11:
        ResultKt.throwOnFailure(r12);
        StringBuilder r111 = new StringBuilder("packageName: ");
        c.f(this.d, r111, ", appId: ");
        r111.append(this.d.getAppId());
        r111.append(" ===> installAIPackageInMemory start, appId = ");
        r111.append(this.d.getAppId());
        String r112 = r111.toString();
        Intrinsics.checkNotNullParameter("AIPackageManager", "tag");
        d r21 = com.bytedance.ai.utils.c.f2846a;
        if (r21 == null) goto L14;
        r21.i("AIPackageManager", r112);
    L14:
        AIPackageInstallInMemoryOperation r113 = new AIPackageInstallInMemoryOperation();
        AIPackageDeployment.AIPackageDeploymentItem r22 = this.d;
        Intrinsics.checkNotNullParameter(r22, "info");
        Intrinsics.checkNotNullParameter(r22, "<set-?>");
        r113.f2689c = r22;
        if (this.e.f2574a.putIfAbsent(this.d.getAppId(), r113) == null) goto L21;
        StringBuilder r114 = new StringBuilder("packageName: ");
        c.f(this.d, r114, ", appId: ");
        r114.append(this.d.getAppId());
        r114.append(" ===> ");
        r114.append(this.d.getAppId());
        r114.append(" is installing");
        String r115 = r114.toString();
        Intrinsics.checkNotNullParameter("AIPackageManager", "tag");
        d r23 = com.bytedance.ai.utils.c.f2846a;
        if (r23 == null) goto L19;
        r23.d("AIPackageManager", r115);
    L19:
        this.e.a(this.d, AIPackage.PackageStatus.f2284c, this.f, true);
        return Unit.INSTANCE;
    L21:
        l r24 = this.f;
        if (r24 == null) goto L27;
        AbsAIPackageOperation r25 = (AbsAIPackageOperation) this.e.f2574a.get(this.d.getAppId());
        if (r25 == null) goto L27;
        r25.a(r24);
    L27:
        if (Intrinsics.areEqual(this.d.getPackageName(), this.d.getAppId()) == false) goto L34;
        this.d.getPackageName();
        this.f2589a = r113;
        this.f2591c = 1;
        if (r5 == null) goto L58;
        r18 = r113;
        r12 = null;
        goto L32
    L34:
        this.d.getPackageName();
        this.d.getAppId();
        this.f2589a = r113;
        this.f2591c = 2;
        if (r5 == null) goto L58;
        r18 = r113;
        r12 = null;
        goto L38
    L5:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
