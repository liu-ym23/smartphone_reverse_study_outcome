package com.obric.aikernel.phx.core.api;

import f8.a;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.d;

/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(c = "com.obric.aikernel.phx.core.api.ScriptBizApi$inferenceAsFlow$binder$1", f = "ScriptBizApi.kt", i = {}, l = {62}, m = "invokeSuspend", n = {}, s = {})
final class ScriptBizApi$inferenceAsFlow$binder$1 extends SuspendLambda implements Function2<d<? super a<Object>>, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;

    ScriptBizApi$inferenceAsFlow$binder$1(Continuation<? super ScriptBizApi$inferenceAsFlow$binder$1> r10) {
        super(2, r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        ScriptBizApi$inferenceAsFlow$binder$1 r12 = new ScriptBizApi$inferenceAsFlow$binder$1(r11);
        r12.L$0 = r10;
        return r12;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(d<? super a<Object>> r10, Continuation<? super Unit> r11) {
        return invoke2(r10, r11);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(d<? super a<Object>> r10, Continuation<? super Unit> r11) {
        return ((ScriptBizApi$inferenceAsFlow$binder$1) create(r10, r11)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r14) {
        Object r10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r11 = this.label;
        if (r11 == 0) goto L8;
        if (r11 != 1) goto L7;
        ResultKt.throwOnFailure(r14);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r14);
        d r15 = (d) this.L$0;
        a r12 = new a(102, null, null, false, false, null, null, 126, null);
        this.label = 1;
        if (r15.emit(r12, this) != r10) goto L12;
        return r10;
    }
}
