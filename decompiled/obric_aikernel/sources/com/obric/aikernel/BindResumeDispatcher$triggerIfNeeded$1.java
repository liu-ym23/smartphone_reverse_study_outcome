package com.obric.aikernel;

import com.obric.aikernel.middleware.api.log.AIKLog;
import com.obric.aikernel.sdk.config.RequestParams;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.l0;

/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(c = "com.obric.aikernel.BindResumeDispatcher$triggerIfNeeded$1", f = "BindResumeDispatcher.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class BindResumeDispatcher$triggerIfNeeded$1 extends SuspendLambda implements Function2<l0, Continuation<? super Unit>, Object> {
    final /* synthetic */ RequestParams $params;
    final /* synthetic */ String $source;
    private /* synthetic */ Object L$0;
    int label;

    BindResumeDispatcher$triggerIfNeeded$1(RequestParams r10, String r11, Continuation<? super BindResumeDispatcher$triggerIfNeeded$1> r12) {
        this.$params = r10;
        this.$source = r11;
        super(2, r12);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        BindResumeDispatcher$triggerIfNeeded$1 r12 = new BindResumeDispatcher$triggerIfNeeded$1(this.$params, this.$source, r11);
        r12.L$0 = r10;
        return r12;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(l0 r10, Continuation<? super Unit> r11) {
        return invoke2(r10, r11);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(l0 r10, Continuation<? super Unit> r11) {
        return ((BindResumeDispatcher$triggerIfNeeded$1) create(r10, r11)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L18;
        ResultKt.throwOnFailure(r10);
        l0 r11 = (l0) this.L$0;
        RequestParams r12 = this.$params;
        String r13 = this.$source;
        Result.Companion r14 = Result.Companion;     // Catch: Throwable -> L10
        if (com.obric.aikernel.service.c.f5440a.a().a(r12) == true) goto L8;
        AIKLog.INSTANCE.w("BindResumeDispatcher", "bind resume event not handled source=" + r13);     // Catch: Throwable -> L10
    L8:
        Object r15 = Result.m32constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L10
    L12:
        String r16 = this.$source;
        Throwable r17 = Result.m35exceptionOrNullimpl(r15);
        if (r17 == null) goto L16;
        AIKLog.INSTANCE.e("BindResumeDispatcher", "trigger bind resume failed source=" + r16 + ": " + r17);
    L16:
        return Unit.INSTANCE;
    L10:
        th = move-exception;
        Result.Companion r18 = Result.Companion;
        r15 = Result.m32constructorimpl(ResultKt.createFailure(th));
        goto L12
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
