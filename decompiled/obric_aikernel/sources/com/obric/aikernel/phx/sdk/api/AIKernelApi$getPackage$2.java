package com.obric.aikernel.phx.sdk.api;

import com.bytedance.crash.constants.Constants;
import com.obric.aikernel.sdk.config.RequestParams;
import com.obric.aikernel.sdk.data.PackageResource;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(c = "com.obric.aikernel.phx.sdk.api.AIKernelApi$getPackage$2", f = "AIKernelApi.kt", i = {}, l = {Constants.UPLOAD_DISASTER_DROP}, m = "invokeSuspend", n = {}, s = {})
final class AIKernelApi$getPackage$2 extends SuspendLambda implements Function1<Continuation<? super Result<? extends PackageResource>>, Object> {
    final /* synthetic */ String $business;
    final /* synthetic */ RequestParams $params;
    int label;
    final /* synthetic */ AIKernelApi this$0;

    AIKernelApi$getPackage$2(AIKernelApi r10, String r11, RequestParams r12, Continuation<? super AIKernelApi$getPackage$2> r13) {
        this.this$0 = r10;
        this.$business = r11;
        this.$params = r12;
        super(1, r13);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> r10) {
        return new AIKernelApi$getPackage$2(this.this$0, this.$business, this.$params, r10);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Continuation<? super Result<? extends PackageResource>> r10) {
        return invoke2(r10);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(Continuation<? super Result<PackageResource>> r10) {
        return ((AIKernelApi$getPackage$2) create(r10)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        Object r11 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r12 = this.label;
        if (r12 == 0) goto L8;
        if (r12 != 1) goto L7;
        ResultKt.throwOnFailure(r10);
        Object r13 = ((Result) r10).m41unboximpl();
    L12:
        return Result.m31boximpl(r13);
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        AIKernelApi r14 = this.this$0;
        String r15 = this.$business;
        RequestParams r16 = this.$params;
        this.label = 1;
        r13 = AIKernelApi.d(r14, r15, r16, this);
        if (r13 != r11) goto L12;
        return r11;
    }
}
