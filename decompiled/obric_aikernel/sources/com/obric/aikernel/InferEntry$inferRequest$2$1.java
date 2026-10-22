package com.obric.aikernel;

import com.google.gson.k;
import com.obric.aikernel.service.res.PythonRuntimeService;
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
@DebugMetadata(c = "com.obric.aikernel.InferEntry$inferRequest$2$1", f = "InferEntry.kt", i = {}, l = {222}, m = "invokeSuspend", n = {}, s = {})
final class InferEntry$inferRequest$2$1 extends SuspendLambda implements Function2<l0, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $it;
    int label;
    final /* synthetic */ InferEntry this$0;

    InferEntry$inferRequest$2$1(InferEntry r10, String r11, Continuation<? super InferEntry$inferRequest$2$1> r12) {
        this.this$0 = r10;
        this.$it = r11;
        super(2, r12);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new InferEntry$inferRequest$2$1(this.this$0, this.$it, r11);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(l0 r10, Continuation<? super Unit> r11) {
        return invoke2(r10, r11);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(l0 r10, Continuation<? super Unit> r11) {
        return ((InferEntry$inferRequest$2$1) create(r10, r11)).invokeSuspend(Unit.INSTANCE);
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
        PythonRuntimeService r13 = InferEntry.f(this.this$0);
        k r14 = ((k) new com.google.gson.d().k(this.$it, k.class)).u("package");
        Intrinsics.checkNotNullExpressionValue(r14, "Gson().fromJson(it, Json…etAsJsonObject(\"package\")");
        this.label = 1;
        if (r13.J(r14, this) != r11) goto L12;
        return r11;
    }
}
