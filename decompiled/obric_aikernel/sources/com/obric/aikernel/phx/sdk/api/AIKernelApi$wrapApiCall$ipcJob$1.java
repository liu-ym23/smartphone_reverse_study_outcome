package com.obric.aikernel.phx.sdk.api;

import com.obric.aikernel.core.log.AIKLog;
import com.obric.aikernel.phx.compat.ParamsCompat;
import com.obric.aikernel.sdk.config.RequestParams;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.l0;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(c = "com.obric.aikernel.phx.sdk.api.AIKernelApi$wrapApiCall$ipcJob$1", f = "AIKernelApi.kt", i = {}, l = {391, 392}, m = "invokeSuspend", n = {}, s = {})
final class AIKernelApi$wrapApiCall$ipcJob$1<T> extends SuspendLambda implements Function2<l0, Continuation<? super T>, Object> {
    final /* synthetic */ Function1<Continuation<? super T>, Object> $block;
    final /* synthetic */ RequestParams $params;
    Object L$0;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    AIKernelApi$wrapApiCall$ipcJob$1(RequestParams r10, Function1<? super Continuation<? super T>, ? extends Object> r11, Continuation<? super AIKernelApi$wrapApiCall$ipcJob$1> r12) {
        this.$params = r10;
        this.$block = r11;
        super(2, r12);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new AIKernelApi$wrapApiCall$ipcJob$1(this.$params, this.$block, r11);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(l0 r10, Object r11) {
        return invoke(r10, (Continuation) r11);
    }

    public final Object invoke(l0 r10, Continuation<? super T> r11) {
        return ((AIKernelApi$wrapApiCall$ipcJob$1) create(r10, r11)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        Object r11 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r12 = this.label;
        if (r12 == 0) goto L13;
        if (r12 == 1) goto L10;
        if (r12 != 2) goto L9;
        ResultKt.throwOnFailure(r10);     // Catch: Throwable -> L22
    L20:
        Object r13 = Result.m32constructorimpl(r10);     // Catch: Throwable -> L22
    L24:
        Throwable r14 = Result.m35exceptionOrNullimpl(r13);
        if (r14 == null) goto L28;
        AIKLog.INSTANCE.w("AIKernelApi", "asyncTransact got exception: " + r14);
    L28:
        if (Result.m38isFailureimpl(r13) == false) goto L31;
        return null;
    L31:
        return r13;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        Function1<Continuation<? super T>, Object> r15 = (Function1) this.L$0;
        ResultKt.throwOnFailure(r10);     // Catch: Throwable -> L22
    L17:
        this.L$0 = null;     // Catch: Throwable -> L22
        this.label = 2;     // Catch: Throwable -> L22
        r10 = r15.invoke(this);     // Catch: Throwable -> L22
        if (r10 != r11) goto L20;
        return r11;
    L13:
        ResultKt.throwOnFailure(r10);
        RequestParams r16 = this.$params;
        r15 = this.$block;
        Result.Companion r17 = Result.Companion;     // Catch: Throwable -> L22
        ParamsCompat r18 = ParamsCompat.f4752a;     // Catch: Throwable -> L22
        this.L$0 = r15;     // Catch: Throwable -> L22
        this.label = 1;     // Catch: Throwable -> L22
        if (r18.f(r16, this) != r11) goto L17;
        return r11;
    L22:
        th = move-exception;
        Result.Companion r19 = Result.Companion;
        r13 = Result.m32constructorimpl(ResultKt.createFailure(th));
        goto L24
    }
}
