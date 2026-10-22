package com.obric.aikernel.runtime.subproc;

import com.obric.aikernel.runtime.AIInferRuntime;
import com.obric.aikernel.sdk.config.RequestParams;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.l0;

/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(c = "com.obric.aikernel.runtime.subproc.SubProcHost$preparePackage$6", f = "SubProcHost.kt", i = {}, l = {68}, m = "invokeSuspend", n = {}, s = {})
final class SubProcHost$preparePackage$6 extends SuspendLambda implements Function2<l0, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $biz;
    final /* synthetic */ RequestParams $params;
    int label;
    final /* synthetic */ SubProcHost this$0;

    SubProcHost$preparePackage$6(SubProcHost r10, String r11, RequestParams r12, Continuation<? super SubProcHost$preparePackage$6> r13) {
        this.this$0 = r10;
        this.$biz = r11;
        this.$params = r12;
        super(2, r13);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new SubProcHost$preparePackage$6(this.this$0, this.$biz, this.$params, r11);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(l0 r10, Continuation<? super Unit> r11) {
        return invoke2(r10, r11);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(l0 r10, Continuation<? super Unit> r11) {
        return ((SubProcHost$preparePackage$6) create(r10, r11)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        Object r11 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r12 = this.label;
        if (r12 == 0) goto L8;
        if (r12 != 1) goto L7;
        ResultKt.throwOnFailure(r10);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        AIInferRuntime r13 = this.this$0.a();
        String r14 = this.$biz;
        RequestParams r15 = this.$params;
        AnonymousClass1 r16 = AnonymousClass1.INSTANCE;
        this.label = 1;
        if (r13.L0(r14, r15, "preload", r16, this) != r11) goto L12;
        return r11;
    }
}
