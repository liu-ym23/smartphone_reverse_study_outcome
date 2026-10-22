package com.bytedance.ai.resource.core;

import androidx.room.jarjarred.org.stringtemplate.v4.STGroup;
import com.bytedance.ai.model.objects.AIPackage;
import com.bytedance.ai.model.p;
import com.bytedance.ai.resource.core.operations.AIPackageUpdateOperation;
import com.bytedance.ai.resource.core.operations.AbsAIPackageOperation;
import com.bytedance.ai.resource.l;
import jm.c;
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
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import t0.b;
import t0.d;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.resource.core.AIPackageOperationGroup$updateAIPackage$2", f = "AIPackageOperationGroup.kt", i = {0, 0, 1}, l = {192, 223, 228, 227}, m = "invokeSuspend", n = {STGroup.DICT_KEY, "updateOperation", "updateOperation"}, s = {"L$0", "L$1", "L$0"})
@SourceDebugExtension({"SMAP\nAIPackageOperationGroup.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AIPackageOperationGroup.kt\ncom/bytedance/ai/resource/core/AIPackageOperationGroup$updateAIPackage$2\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,620:1\n1#2:621\n*E\n"})
final class AIPackageOperationGroup$updateAIPackage$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object f2613a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f2614b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f2615c;
    public final /* synthetic */ AIPackageDeployment.AIPackageDeploymentItem d;
    public final /* synthetic */ l e;
    public final /* synthetic */ AIPackageOperationGroup f;

    public AIPackageOperationGroup$updateAIPackage$2(AIPackageDeployment.AIPackageDeploymentItem r5, l r10, AIPackageOperationGroup r11, Continuation r12) {
        this.d = r5;
        this.e = r10;
        this.f = r11;
        super(2, r12);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object r5, Continuation r10) {
        return new AIPackageOperationGroup$updateAIPackage$2(this.d, this.e, this.f, r10);
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public final Object mo2invoke(CoroutineScope r5, Continuation<? super Unit> r10) {
        return ((AIPackageOperationGroup$updateAIPackage$2) create(r5, r10)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r17) {
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r10 = this.f2615c;
        if (r10 == 0) goto L14;
        if (r10 == 1) goto L13;
        if (r10 == 2) goto L12;
        if (r10 == 3) goto L11;
        if (r10 != 4) goto L10;
        ResultKt.throwOnFailure(r17);
    L59:
        return Unit.INSTANCE;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L11:
        AIPackageOperationGroup r11 = (AIPackageOperationGroup) this.f2613a;
        ResultKt.throwOnFailure(r17);
        AIPackageOperationGroup r12 = r11;
        Object r13 = r17;
    L55:
        this.f2613a = null;
        this.f2615c = 4;
        if (r12.a((AbsAIPackageOperation.Result) r13, this) != r5) goto L59;
    L57:
        return r5;
    L12:
        AIPackage r14 = (AIPackage) this.f2614b;
        AIPackageUpdateOperation r15 = (AIPackageUpdateOperation) this.f2613a;
        ResultKt.throwOnFailure(r17);
        Object r16 = r17;
    L49:
        if (((Boolean) r16).booleanValue() == false) goto L51;
        r12 = this.f;
        AIPackageDeployment.AIPackageDeploymentItem r18 = this.d;
        this.f2613a = r12;
        this.f2614b = null;
        this.f2615c = 3;
        r13 = AIPackageOperationGroup.a(r12, r15, r18, this);
        if (r13 != r5) goto L55;
    L51:
        return Unit.INSTANCE;
    L13:
        r15 = (AIPackageUpdateOperation) this.f2614b;
        String r19 = (String) this.f2613a;
        ResultKt.throwOnFailure(r17);
        Object r110 = r17;
    L20:
        AIPackage r111 = (AIPackage) r110;
        if (r111 != null) goto L30;
        StringBuilder r20 = new StringBuilder("packageName: ");
        c.f(this.d, r20, ", appId: ");
        r20.append(this.d.getAppId());
        r20.append(" ===> AIPackage is not installed");
        String r21 = r20.toString();
        Intrinsics.checkNotNullParameter("AIPackageManager", "tag");
        d r22 = com.bytedance.ai.utils.c.f2846a;
        if (r22 == null) goto L25;
        r22.e("AIPackageManager", r21);
    L25:
        l r23 = this.e;
        if (r23 == null) goto L29;
        r23.a(null, this.d.getPackageName(), this.d.getAppId(), AIPackage.AIPackageType.f2281c, 7, null);
    L29:
        return Unit.INSTANCE;
    L30:
        r15.getClass();
        Intrinsics.checkNotNullParameter(r111, "oldPackage");
        Intrinsics.checkNotNullParameter(r111, "<set-?>");
        r15.f2687a = r111;
        boolean r112 = false;
        if (this.f.f2574a.putIfAbsent(r19, r15) == null) goto L37;
        StringBuilder r24 = new StringBuilder("packageName: ");
        c.f(this.d, r24, ", appId: ");
        r24.append(this.d.getAppId());
        r24.append(" ===> ");
        r24.append(r19);
        r24.append(" is updating");
        String r25 = r24.toString();
        Intrinsics.checkNotNullParameter("AIPackageManager", "tag");
        d r26 = com.bytedance.ai.utils.c.f2846a;
        if (r26 == null) goto L35;
        r26.d("AIPackageManager", r25);
    L35:
        this.f.a(this.d, AIPackage.PackageStatus.f2283b, this.e, false);
        return Unit.INSTANCE;
    L37:
        l r27 = this.e;
        if (r27 == null) goto L42;
        AIPackageOperationGroup r28 = this.f;
        AIPackageDeployment.AIPackageDeploymentItem r29 = this.d;
        AbsAIPackageOperation r30 = (AbsAIPackageOperation) r28.f2574a.get(r29.getAppId());
        if (r30 == null) goto L42;
        r30.a(r27);
    L42:
        AIPackageOperationGroup r31 = this.f;
        AIPackageDeployment.AIPackageDeploymentItem r32 = this.d;
        b r33 = p.f2294c;
        if (r33 == null) goto L45;
        r112 = Intrinsics.areEqual(r33.ignoreLowVersionWhenUpdate(r32.getAppId(), r32.getPackageName(), r32.getVersionCode()), Boxing.boxBoolean(true));
    L45:
        this.f2613a = r15;
        this.f2614b = r111;
        this.f2615c = 2;
        r16 = r31.a(r111, r32, r112, this);
        if (r16 != r5) goto L49;
    L14:
        ResultKt.throwOnFailure(r17);
        r19 = this.d.getAppId();
        StringBuilder r34 = new StringBuilder("packageName: ");
        c.f(this.d, r34, ", appId: ");
        r34.append(this.d.getAppId());
        r34.append(" ===> start updating AIPackage,key = ");
        r34.append(r19);
        String r35 = r34.toString();
        Intrinsics.checkNotNullParameter("AIPackageManager", "tag");
        d r113 = com.bytedance.ai.utils.c.f2846a;
        if (r113 == null) goto L17;
        r113.d("AIPackageManager", r35);
    L17:
        r15 = new AIPackageUpdateOperation();
        AIPackageDeployment.AIPackageDeploymentItem r114 = this.d;
        Intrinsics.checkNotNullParameter(r114, "info");
        Intrinsics.checkNotNullParameter(r114, "<set-?>");
        r15.f2689c = r114;
        AIPackageStorage r115 = AIPackageStorage.f2618a;
        AIPackageDeployment.AIPackageDeploymentItem r116 = this.d;
        this.f2613a = r19;
        this.f2614b = r15;
        this.f2615c = 1;
        r110 = r115.a(r116, this);
        if (r110 != r5) goto L20;
        goto L20
    }
}
