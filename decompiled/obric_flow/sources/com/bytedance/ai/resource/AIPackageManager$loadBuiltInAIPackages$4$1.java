package com.bytedance.ai.resource;

import com.bytedance.ai.resource.core.AIPackageDeployment;
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
import kotlinx.coroutines.j0;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.resource.AIPackageManager$loadBuiltInAIPackages$4$1", f = "AIPackageManager.kt", i = {0}, l = {635, 657}, m = "invokeSuspend", n = {"deferred"}, s = {"L$0"})
final class AIPackageManager$loadBuiltInAIPackages$4$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public kotlinx.coroutines.r f2523a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f2524b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ AIPackageDeployment.AIPackageDeploymentItem f2525c;

    public AIPackageManager$loadBuiltInAIPackages$4$1(AIPackageDeployment.AIPackageDeploymentItem r5, Continuation r10) {
        this.f2525c = r5;
        super(2, r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object r5, Continuation r10) {
        return new AIPackageManager$loadBuiltInAIPackages$4$1(this.f2525c, r10);
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public final Object mo2invoke(CoroutineScope r5, Continuation<? super Unit> r10) {
        AIPackageDeployment.AIPackageDeploymentItem r11 = this.f2525c;
        return new AIPackageManager$loadBuiltInAIPackages$4$1(r11, r10).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r11 = this.f2524b;
        if (r11 == 0) goto L10;
        if (r11 == 1) goto L9;
        if (r11 != 2) goto L8;
        ResultKt.throwOnFailure(r10);
    L20:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        kotlinx.coroutines.r r12 = this.f2523a;
        ResultKt.throwOnFailure(r10);
        kotlinx.coroutines.r r13 = r12;
    L16:
        this.f2523a = null;
        this.f2524b = 2;
        if (((kotlinx.coroutines.s) r13).d(this) != r5) goto L20;
    L18:
        return r5;
    L10:
        ResultKt.throwOnFailure(r10);
        y r14 = y.f2766a;
        y.d(this.f2525c.getPackageName(), this.f2525c.getAppId(), "INSTALL_STARTED", "versionCode=" + this.f2525c.getVersionCode());
        StringBuilder r15 = new StringBuilder("loadBuiltInAIPackages: packageName: ");
        jm.c.f(this.f2525c, r15, ", appId: ");
        r15.append(this.f2525c.getAppId());
        r15.append(", versionCode: ");
        r15.append(this.f2525c.getVersionCode());
        String r16 = r15.toString();
        Intrinsics.checkNotNullParameter("AIPackageManager", "tag");
        t0.d r17 = com.bytedance.ai.utils.c.f2846a;
        if (r17 == null) goto L13;
        r17.i("AIPackageManager", r16);
    L13:
        kotlinx.coroutines.s r18 = j0.a();
        y.d(this.f2525c.getPackageName(), this.f2525c.getAppId(), "WAITING_INSTALL_CALLBACK", "versionCode=" + this.f2525c.getVersionCode());
        r r19 = r.f2752a;
        AIPackageDeployment.AIPackageDeploymentItem r110 = this.f2525c;
        long r20 = r110.getVersionCode();
        n r21 = new n(r18);
        this.f2523a = r18;
        this.f2524b = 1;
        r13 = r18;
        if (r.d(r110, r20, r21, this) != r5) goto L16;
        goto L16
    }
}
