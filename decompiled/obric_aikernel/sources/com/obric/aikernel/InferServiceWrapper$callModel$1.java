package com.obric.aikernel;

import android.os.Bundle;
import com.obric.aikernel.model.cloud.CloudRequestInjector;
import com.obric.aikernel.multiusr.MultiUsrAdapter;
import com.obric.aikernel.request.track.ApiPerfDetails;
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
@DebugMetadata(c = "com.obric.aikernel.InferServiceWrapper$callModel$1", f = "InferServiceWrapper.kt", i = {1}, l = {157, 159, 160}, m = "invokeSuspend", n = {"callback"}, s = {"L$0"})
final class InferServiceWrapper$callModel$1 extends SuspendLambda implements Function2<l0, Continuation<? super Unit>, Object> {
    final /* synthetic */ Bundle $args;
    final /* synthetic */ b $cb;
    final /* synthetic */ RequestParams $params;
    Object L$0;
    int label;
    final /* synthetic */ InferServiceWrapper this$0;

    InferServiceWrapper$callModel$1(RequestParams r10, InferServiceWrapper r11, b r12, Bundle r13, Continuation<? super InferServiceWrapper$callModel$1> r14) {
        this.$params = r10;
        this.this$0 = r11;
        this.$cb = r12;
        this.$args = r13;
        super(2, r14);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new InferServiceWrapper$callModel$1(this.$params, this.this$0, this.$cb, this.$args, r11);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(l0 r10, Continuation<? super Unit> r11) {
        return invoke2(r10, r11);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(l0 r10, Continuation<? super Unit> r11) {
        return ((InferServiceWrapper$callModel$1) create(r10, r11)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r12) {
        Object r10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r11 = this.label;
        if (r11 == 0) goto L17;
        if (r11 == 1) goto L16;
        if (r11 == 2) goto L13;
        if (r11 != 3) goto L12;
        ResultKt.throwOnFailure(r12);     // Catch: Throwable -> L9
    L29:
        MultiUsrAdapter.f4720a.e(this.$args);
        return Unit.INSTANCE;
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L13:
        b r13 = (b) this.L$0;
        ResultKt.throwOnFailure(r12);     // Catch: Throwable -> L9
    L25:
        if (((Boolean) r12).booleanValue() == true) goto L29;
        e r14 = this.this$0.q2();     // Catch: Throwable -> L9
        RequestParams r15 = this.$params;     // Catch: Throwable -> L9
        this.L$0 = null;     // Catch: Throwable -> L9
        this.label = 3;     // Catch: Throwable -> L9
        if (r14.c(r15, r13, this) != r10) goto L29;
        return r10;
    L16:
        ResultKt.throwOnFailure(r12);
    L20:
        r13 = (b) r12;
        CloudRequestInjector r16 = InferServiceWrapper.f2(this.this$0);     // Catch: Throwable -> L9
        RequestParams r17 = this.$params;     // Catch: Throwable -> L9
        this.L$0 = r13;     // Catch: Throwable -> L9
        this.label = 2;     // Catch: Throwable -> L9
        r12 = r16.a(r17, r13, this);     // Catch: Throwable -> L9
        if (r12 != r10) goto L25;
        return r10;
    L17:
        ResultKt.throwOnFailure(r12);
        ApiPerfDetails.a.j(ApiPerfDetails.Companion, this.$params.getBackend(), ApiPerfDetails.onStartApiCoroutine, false, 2, null);
        e r18 = this.this$0.q2();
        RequestParams r19 = this.$params;
        b r20 = this.$cb;
        this.label = 1;
        r12 = r18.d(r19, r20, this);
        if (r12 != r10) goto L20;
        return r10;
    L9:
        th = move-exception;
        MultiUsrAdapter.f4720a.e(this.$args);
        throw th;
    }
}
