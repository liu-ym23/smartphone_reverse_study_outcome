package com.bytedance.ai.resource.core;

import androidx.room.jarjarred.org.stringtemplate.v4.STGroup;
import com.bytedance.ai.model.objects.AIPackage;
import com.bytedance.ai.resource.core.operations.AIPackageUninstallOperation;
import com.bytedance.ai.resource.core.operations.AbsAIPackageOperation;
import com.bytedance.ai.resource.l;
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
@DebugMetadata(c = "com.bytedance.ai.resource.core.AIPackageOperationGroup$uninstallAIPackage$2", f = "AIPackageOperationGroup.kt", i = {0, 0}, l = {244, 274, 273}, m = "invokeSuspend", n = {STGroup.DICT_KEY, "uninstallOperation"}, s = {"L$0", "L$1"})
@SourceDebugExtension({"SMAP\nAIPackageOperationGroup.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AIPackageOperationGroup.kt\ncom/bytedance/ai/resource/core/AIPackageOperationGroup$uninstallAIPackage$2\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,620:1\n1#2:621\n*E\n"})
final class AIPackageOperationGroup$uninstallAIPackage$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object f2610a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public AIPackageUninstallOperation f2611b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f2612c;
    public final /* synthetic */ AIPackageDeployment.AIPackageDeploymentItem d;
    public final /* synthetic */ l e;
    public final /* synthetic */ AIPackageOperationGroup f;

    public AIPackageOperationGroup$uninstallAIPackage$2(AIPackageDeployment.AIPackageDeploymentItem r5, l r10, AIPackageOperationGroup r11, Continuation r12) {
        this.d = r5;
        this.e = r10;
        this.f = r11;
        super(2, r12);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object r5, Continuation r10) {
        return new AIPackageOperationGroup$uninstallAIPackage$2(this.d, this.e, this.f, r10);
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public final Object mo2invoke(CoroutineScope r5, Continuation<? super Unit> r10) {
        return ((AIPackageOperationGroup$uninstallAIPackage$2) create(r5, r10)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r21) {
        Object r10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = this.f2612c;
        if (r5 == 0) goto L12;
        if (r5 == 1) goto L11;
        if (r5 == 2) goto L10;
        if (r5 != 3) goto L9;
        ResultKt.throwOnFailure(r21);
    L48:
        return Unit.INSTANCE;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        AIPackageOperationGroup r11 = (AIPackageOperationGroup) this.f2610a;
        ResultKt.throwOnFailure(r21);
        Object r12 = r21;
    L44:
        this.f2610a = null;
        this.f2612c = 3;
        if (r11.a((AbsAIPackageOperation.Result) r12, this) != r10) goto L48;
    L46:
        return r10;
    L11:
        AIPackageUninstallOperation r13 = this.f2611b;
        String r14 = (String) this.f2610a;
        ResultKt.throwOnFailure(r21);
        String r15 = r14;
        AIPackageUninstallOperation r16 = r13;
        Object r17 = r21;
    L19:
        AIPackage r18 = (AIPackage) r17;
        if (r18 != null) goto L29;
        StringBuilder r19 = new StringBuilder("packageName: ");
        c.f(this.d, r19, ", appId: ");
        r19.append(this.d.getAppId());
        r19.append(" ===> AIPackage is not installed");
        String r20 = r19.toString();
        Intrinsics.checkNotNullParameter(r6, "tag");
        d r22 = com.bytedance.ai.utils.c.f2846a;
        if (r22 == null) goto L24;
        r22.e("AIPackageManager", r20);
    L24:
        l r23 = this.e;
        if (r23 == null) goto L28;
        r23.a(null, this.d.getPackageName(), this.d.getAppId(), AIPackage.AIPackageType.f2281c, 7, null);
    L28:
        return Unit.INSTANCE;
    L29:
        r16.getClass();
        Intrinsics.checkNotNullParameter(r18, "oldPackage");
        Intrinsics.checkNotNullParameter(r18, "<set-?>");
        r16.f2687a = r18;
        if (this.f.f2574a.putIfAbsent(r15, r16) == null) goto L36;
        StringBuilder r24 = new StringBuilder("packageName: ");
        c.f(this.d, r24, ", appId: ");
        r24.append(this.d.getAppId());
        r24.append(" ===> ");
        r24.append(r15);
        r24.append(" is being uninstalled");
        String r25 = r24.toString();
        Intrinsics.checkNotNullParameter(r6, "tag");
        d r26 = com.bytedance.ai.utils.c.f2846a;
        if (r26 == null) goto L34;
        r26.d(r6, r25);
    L34:
        this.f.a(this.d, AIPackage.PackageStatus.d, this.e, false);
        return Unit.INSTANCE;
    L36:
        l r27 = this.e;
        if (r27 == null) goto L41;
        AIPackageOperationGroup r28 = this.f;
        AIPackageDeployment.AIPackageDeploymentItem r29 = this.d;
        AbsAIPackageOperation r30 = (AbsAIPackageOperation) r28.f2574a.get(r29.getAppId());
        if (r30 == null) goto L41;
        r30.a(r27);
    L41:
        r11 = this.f;
        AIPackageDeployment.AIPackageDeploymentItem r31 = this.d;
        this.f2610a = r11;
        this.f2611b = null;
        this.f2612c = 2;
        r12 = AIPackageOperationGroup.a(r11, r16, r31, this);
        if (r12 != r10) goto L44;
    L12:
        ResultKt.throwOnFailure(r21);
        String r32 = this.d.getAppId();
        StringBuilder r33 = new StringBuilder("packageName: ");
        c.f(this.d, r33, ", appId: ");
        r33.append(this.d.getAppId());
        r33.append(" ===> start uninstall AIPackage,key = ");
        r33.append(r32);
        String r34 = r33.toString();
        Intrinsics.checkNotNullParameter("AIPackageManager", "tag");
        d r35 = com.bytedance.ai.utils.c.f2846a;
        if (r35 == null) goto L15;
        r35.d("AIPackageManager", r34);
    L15:
        AIPackageUninstallOperation r36 = new AIPackageUninstallOperation();
        AIPackageDeployment.AIPackageDeploymentItem r37 = this.d;
        Intrinsics.checkNotNullParameter(r37, "info");
        Intrinsics.checkNotNullParameter(r37, "<set-?>");
        r36.f2689c = r37;
        AIPackageStorage r38 = AIPackageStorage.f2618a;
        AIPackageDeployment.AIPackageDeploymentItem r39 = this.d;
        this.f2610a = r32;
        this.f2611b = r36;
        this.f2612c = 1;
        r17 = r38.a(r39, AIPackage.AIPackageType.f2281c, false, 0, this);
        if (r17 == r10) goto L46;
        r15 = r32;
        r16 = r36;
        goto L19
    }
}
