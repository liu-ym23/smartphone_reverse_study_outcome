package com.bytedance.ai.resource.core;

import com.bytedance.ai.model.objects.AIPackage;
import com.bytedance.ai.resource.core.operations.AIPackageInstallOperation;
import com.bytedance.ai.resource.core.operations.AbsAIPackageOperation;
import com.bytedance.ai.resource.l;
import com.bytedance.ai.resource.y;
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
@DebugMetadata(c = "com.bytedance.ai.resource.core.AIPackageOperationGroup$installAIPackage$2", f = "AIPackageOperationGroup.kt", i = {0, 1, 1}, l = {148, 150, 163, 174, 173}, m = "invokeSuspend", n = {"installOperation", "installOperation", "oldPackage"}, s = {"L$0", "L$0", "L$1"})
@SourceDebugExtension({"SMAP\nAIPackageOperationGroup.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AIPackageOperationGroup.kt\ncom/bytedance/ai/resource/core/AIPackageOperationGroup$installAIPackage$2\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,620:1\n1#2:621\n*E\n"})
final class AIPackageOperationGroup$installAIPackage$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object f2586a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public AIPackage f2587b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f2588c;
    public final /* synthetic */ AIPackageDeployment.AIPackageDeploymentItem d;
    public final /* synthetic */ AIPackageOperationGroup e;
    public final /* synthetic */ l f;

    public AIPackageOperationGroup$installAIPackage$2(AIPackageDeployment.AIPackageDeploymentItem r5, AIPackageOperationGroup r10, l r11, Continuation r12) {
        this.d = r5;
        this.e = r10;
        this.f = r11;
        super(2, r12);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object r5, Continuation r10) {
        return new AIPackageOperationGroup$installAIPackage$2(this.d, this.e, this.f, r10);
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public final Object mo2invoke(CoroutineScope r5, Continuation<? super Unit> r10) {
        return ((AIPackageOperationGroup$installAIPackage$2) create(r5, r10)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v10 */
    /* JADX WARN: Type inference failed for: r9v11 */
    /* JADX WARN: Type inference failed for: r9v4, types: [com.bytedance.ai.model.objects.AIPackage, java.lang.Object, java.lang.String] */
    /* JADX WARN: Type inference failed for: r9v6, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r9v9 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r19) {
        Object r10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = this.f2588c;
        String r11 = "<set-?>";
        boolean r12 = false;
        Object r13 = null;
        if (r5 == 0) goto L16;
        if (r5 == 1) goto L15;
        if (r5 == 2) goto L14;
        if (r5 == 3) goto L13;
        if (r5 == 4) goto L12;
        if (r5 == 5) goto L13;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L12:
        AIPackageOperationGroup r14 = (AIPackageOperationGroup) this.f2586a;
        ResultKt.throwOnFailure(r19);
        AIPackageOperationGroup r15 = r14;
        ?? r16 = 0;
        Object r17 = r19;
    L53:
        this.f2586a = r16;
        this.f2588c = 5;
        if (r15.a((AbsAIPackageOperation.Result) r17, this) != r10) goto L57;
    L55:
        return r10;
    L57:
        return Unit.INSTANCE;
    L13:
        ResultKt.throwOnFailure(r19);
        goto L57
    L14:
        AIPackage r18 = this.f2587b;
        AIPackageInstallOperation r20 = (AIPackageInstallOperation) this.f2586a;
        ResultKt.throwOnFailure(r19);
        Object r21 = r19;
        r13 = null;
        r11 = "<set-?>";
    L41:
        if (((Boolean) r21).booleanValue() == false) goto L43;
        r20.getClass();
        Intrinsics.checkNotNullParameter(r18, "oldPackage");
        Intrinsics.checkNotNullParameter(r18, r11);
        r20.f2687a = r18;
        r12 = r13;
    L45:
        y r22 = y.f2766a;
        y.e(this.d.getPackageName(), this.d.getAppId(), "operation", "QUERY_DEPLOYMENT_ITEM", r12);
        ConcurrentHashMap r23 = AIPackageDeployment.f2573a;
        AIPackageDeployment.AIPackageDeploymentItem r24 = AIPackageDeployment.a(this.d);
        if (r24 != null) goto L50;
        AIPackageOperationGroup r25 = this.e;
        AbsAIPackageOperation.Result r26 = new AbsAIPackageOperation.Result(null, this.d.getPackageName(), this.d.getAppId(), AIPackage.AIPackageType.f2281c, 12, null);
        this.f2586a = r12;
        this.f2587b = r12;
        this.f2588c = 3;
        if (r25.a(r26, this) != r10) goto L57;
    L50:
        r15 = this.e;
        this.f2586a = r15;
        this.f2587b = r12;
        this.f2588c = 4;
        r17 = AIPackageOperationGroup.a(r15, r20, r24, this);
        r16 = r12;
        if (r17 != r10) goto L53;
    L43:
        return Unit.INSTANCE;
    L15:
        AIPackageInstallOperation r27 = (AIPackageInstallOperation) this.f2586a;
        ResultKt.throwOnFailure(r19);
        r20 = r27;
        Object r28 = r19;
    L35:
        r18 = (AIPackage) r28;
        if (r18 == null) goto L45;
        AIPackageOperationGroup r29 = this.e;
        AIPackageDeployment.AIPackageDeploymentItem r30 = this.d;
        this.f2586a = r20;
        this.f2587b = r18;
        this.f2588c = 2;
        r21 = r29.a(r18, r30, false, this);
        if (r21 != r10) goto L41;
    L16:
        ResultKt.throwOnFailure(r19);
        StringBuilder r31 = new StringBuilder("packageName: ");
        c.f(this.d, r31, ", appId: ");
        r31.append(this.d.getAppId());
        r31.append(" ===> installAIPackage start, appId = ");
        r31.append(this.d.getAppId());
        String r32 = r31.toString();
        Intrinsics.checkNotNullParameter("AIPackageManager", "tag");
        d r110 = com.bytedance.ai.utils.c.f2846a;
        if (r110 == null) goto L19;
        r110.i("AIPackageManager", r32);
    L19:
        AIPackageInstallOperation r111 = new AIPackageInstallOperation();
        AIPackageDeployment.AIPackageDeploymentItem r33 = this.d;
        Intrinsics.checkNotNullParameter(r33, "info");
        Intrinsics.checkNotNullParameter(r33, "<set-?>");
        r111.f2689c = r33;
        y r34 = y.f2766a;
        y.e(this.d.getPackageName(), this.d.getAppId(), "operation", "REGISTER_OPERATION", "versionCode=" + this.d.getVersionCode());
        if (this.e.f2574a.putIfAbsent(this.d.getAppId(), r111) == null) goto L26;
        y.e(this.d.getPackageName(), this.d.getAppId(), "operation", "WAITING_EXISTING_OPERATION", "versionCode=" + this.d.getVersionCode());
        StringBuilder r35 = new StringBuilder("packageName: ");
        c.f(this.d, r35, ", appId: ");
        r35.append(this.d.getAppId());
        r35.append(" ===> ");
        r35.append(this.d.getAppId());
        r35.append(" is installing");
        String r36 = r35.toString();
        Intrinsics.checkNotNullParameter("AIPackageManager", "tag");
        d r37 = com.bytedance.ai.utils.c.f2846a;
        if (r37 == null) goto L24;
        r37.d("AIPackageManager", r36);
    L24:
        this.e.a(this.d, AIPackage.PackageStatus.f2284c, this.f, false);
        return Unit.INSTANCE;
    L26:
        l r38 = this.f;
        if (r38 == null) goto L31;
        AbsAIPackageOperation r39 = (AbsAIPackageOperation) this.e.f2574a.get(this.d.getAppId());
        if (r39 == null) goto L31;
        r39.a(r38);
    L31:
        y.e(this.d.getPackageName(), this.d.getAppId(), "operation", "QUERY_OLD_PACKAGE", null);
        AIPackageStorage r40 = AIPackageStorage.f2618a;
        AIPackageDeployment.AIPackageDeploymentItem r41 = this.d;
        this.f2586a = r111;
        this.f2588c = 1;
        r28 = r40.a(r41, AIPackage.AIPackageType.f2281c, false, 0, this);
        if (r28 == r10) goto L55;
        r20 = r111;
        goto L35
    }
}
