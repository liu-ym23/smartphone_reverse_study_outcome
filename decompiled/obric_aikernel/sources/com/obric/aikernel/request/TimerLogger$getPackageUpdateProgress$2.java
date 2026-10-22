package com.obric.aikernel.request;

import com.obric.aikernel.sdk.config.RequestParams;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(c = "com.obric.aikernel.request.TimerLogger$getPackageUpdateProgress$2", f = "TimerLogger.kt", i = {}, l = {65}, m = "invokeSuspend", n = {}, s = {})
final class TimerLogger$getPackageUpdateProgress$2 extends SuspendLambda implements Function1<Continuation<? super b>, Object> {
    final /* synthetic */ String $biz;
    final /* synthetic */ RequestParams $params;
    int label;
    final /* synthetic */ TimerLogger this$0;

    TimerLogger$getPackageUpdateProgress$2(TimerLogger r10, String r11, RequestParams r12, Continuation<? super TimerLogger$getPackageUpdateProgress$2> r13) {
        this.$biz = r11;
        this.$params = r12;
        super(1, r13);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> r10) {
        return new TimerLogger$getPackageUpdateProgress$2(this.this$0, this.$biz, this.$params, r10);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Continuation<? super b> r10) {
        return invoke2(r10);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(Continuation<? super b> r10) {
        return ((TimerLogger$getPackageUpdateProgress$2) create(r10)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        Object r11 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r12 = this.label;
        if (r12 == 0) goto L8;
        if (r12 != 1) goto L7;
        ResultKt.throwOnFailure(r10);
    L11:
        return r10;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        a r13 = TimerLogger.i(this.this$0);
        String r14 = this.$biz;
        RequestParams r15 = this.$params;
        this.label = 1;
        r10 = r13.a(r14, r15, this);
        if (r10 != r11) goto L11;
        return r11;
    }
}
