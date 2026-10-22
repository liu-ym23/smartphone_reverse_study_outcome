package com.obric.aikernel.runtime;

import android.os.Bundle;
import android.os.IBinder;
import com.obric.aikernel.res.PackageResourceManager;
import com.obric.aikernel.res.metadata.data.AIPackage;
import com.obric.aikernel.runtime.subproc.SubProcHost;
import java.util.Map;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.l0;

/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(c = "com.obric.aikernel.runtime.AIInferRuntime$getSubProcProxy$result$1$1$2", f = "AIInferRuntime.kt", i = {}, l = {664}, m = "invokeSuspend", n = {}, s = {})
final class AIInferRuntime$getSubProcProxy$result$1$1$2 extends SuspendLambda implements Function2<l0, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $proc;
    final /* synthetic */ Map<String, SubProcHost.c> $proxyMap;
    final /* synthetic */ IBinder $remote;
    final /* synthetic */ Bundle $subProcInfo;
    int label;
    final /* synthetic */ AIInferRuntime this$0;

    public static final class a implements IBinder.DeathRecipient {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Map<String, SubProcHost.c> f5297a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f5298b;

        a(Map<String, SubProcHost.c> r10, String r11) {
            this.f5297a = r10;
            this.f5298b = r11;
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            this.f5297a.remove(this.f5298b);
        }
    }

    AIInferRuntime$getSubProcProxy$result$1$1$2(AIInferRuntime r10, String r11, Bundle r12, IBinder r13, Map<String, SubProcHost.c> r14, Continuation<? super AIInferRuntime$getSubProcProxy$result$1$1$2> r15) {
        this.this$0 = r10;
        this.$proc = r11;
        this.$subProcInfo = r12;
        this.$remote = r13;
        this.$proxyMap = r14;
        super(2, r15);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new AIInferRuntime$getSubProcProxy$result$1$1$2(this.this$0, this.$proc, this.$subProcInfo, this.$remote, this.$proxyMap, r11);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(l0 r10, Continuation<? super Unit> r11) {
        return invoke2(r10, r11);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(l0 r10, Continuation<? super Unit> r11) {
        return ((AIInferRuntime$getSubProcProxy$result$1$1$2) create(r10, r11)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        Object r11 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r12 = this.label;
        boolean r13 = true;
        if (r12 == 0) goto L8;
        if (r12 != 1) goto L7;
        ResultKt.throwOnFailure(r10);
    L12:
        if (Intrinsics.areEqual(this.$proc, this.this$0.R().f().e()) == false) goto L31;
        String r14 = this.$subProcInfo.getString("@vlm_local_ver");
        if (r14 == null) goto L31;
        if (r14.length() == 0) goto L19;
        r13 = false;
    L19:
        String r15 = null;
        if (r13 == false) goto L25;
        com.obric.aikernel.runtime.utils.d.f5417a.g("AIInferRuntime", "getSubProcProxy vlm_local reset null and refresh!");
        com.obric.aikernel.res.metadata.d.f5055a.c(null);
        PackageResourceManager r16 = AIInferRuntime.f(this.this$0);
        if (r16 == null) goto L24;
        r16.refreshPackageState("vlm_local");
    L24:
        AIInferRuntime.m(this.this$0).clear();
        goto L31
    L25:
        com.obric.aikernel.res.metadata.d r17 = com.obric.aikernel.res.metadata.d.f5055a;
        AIPackage r18 = r17.a();
        if (r18 == null) goto L29;
        r15 = r18.D();
    L29:
        if (Intrinsics.areEqual(r15, r14) == true) goto L31;
        com.obric.aikernel.runtime.utils.d.f5417a.g("AIInferRuntime", "getSubProcProxy vlm_local sync transferPackage " + r15 + " to " + r14);
        AIPackage r19 = new AIPackage("vlm_local", r14, this.this$0.R().h());
        r17.c(r19);
        AIInferRuntime.C(this.this$0, r19);
    L31:
        this.$remote.linkToDeath(new a(this.$proxyMap, this.$proc), 0);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        AIInferRuntime r20 = this.this$0;
        String r21 = this.$proc;
        Bundle r22 = this.$subProcInfo;
        this.label = 1;
        if (AIInferRuntime.A(r20, r21, r22, this) != r11) goto L12;
        return r11;
    }
}
