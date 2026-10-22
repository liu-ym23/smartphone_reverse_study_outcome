package com.obric.aikernel.runtime;

import java.util.List;
import java.util.Map;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.l0;

/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(c = "com.obric.aikernel.runtime.AIInferRuntime$dump$4", f = "AIInferRuntime.kt", i = {}, l = {331, 332}, m = "invokeSuspend", n = {}, s = {})
final class AIInferRuntime$dump$4 extends SuspendLambda implements Function2<l0, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<String> $args;
    int label;
    final /* synthetic */ AIInferRuntime this$0;

    AIInferRuntime$dump$4(List<String> r10, AIInferRuntime r11, Continuation<? super AIInferRuntime$dump$4> r12) {
        this.$args = r10;
        this.this$0 = r11;
        super(2, r12);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new AIInferRuntime$dump$4(this.$args, this.this$0, r11);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(l0 r10, Continuation<? super Unit> r11) {
        return invoke2(r10, r11);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(l0 r10, Continuation<? super Unit> r11) {
        return ((AIInferRuntime$dump$4) create(r10, r11)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        Object r11 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r12 = this.label;
        if (r12 == 0) goto L10;
        if (r12 == 1) goto L9;
        if (r12 != 2) goto L8;
        ResultKt.throwOnFailure(r10);
    L20:
        Map r13 = (Map) r10;
    L22:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r10);
    L16:
        if (((Map) r10) != null) goto L22;
    L17:
        AIInferRuntime r14 = this.this$0;
        this.label = 2;
        r10 = AIInferRuntime.G0(r14, null, false, this, 3, null);
        if (r10 != r11) goto L20;
        return r11;
    L10:
        ResultKt.throwOnFailure(r10);
        String r15 = (String) CollectionsKt.getOrNull(this.$args, 1);
        if (r15 == null) goto L17;
        AIInferRuntime r16 = this.this$0;
        this.label = 1;
        r10 = r16.F0(r15, false, this);
        if (r10 != r11) goto L16;
        return r11;
    }
}
