package com.obric.aikernel.runtime;

import com.obric.aikernel.res.PackageResourceManager;
import java.util.Map;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.l0;

/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(c = "com.obric.aikernel.runtime.AIInferRuntime$dump$1$1", f = "AIInferRuntime.kt", i = {}, l = {289}, m = "invokeSuspend", n = {}, s = {})
final class AIInferRuntime$dump$1$1 extends SuspendLambda implements Function2<l0, Continuation<? super Unit>, Object> {
    final /* synthetic */ e $command;
    int label;
    final /* synthetic */ AIInferRuntime this$0;

    AIInferRuntime$dump$1$1(AIInferRuntime r10, e r11, Continuation<? super AIInferRuntime$dump$1$1> r12) {
        this.this$0 = r10;
        this.$command = r11;
        super(2, r12);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new AIInferRuntime$dump$1$1(this.this$0, this.$command, r11);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(l0 r10, Continuation<? super Unit> r11) {
        return invoke2(r10, r11);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(l0 r10, Continuation<? super Unit> r11) {
        return ((AIInferRuntime$dump$1$1) create(r10, r11)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        Object r11 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r12 = this.label;
        if (r12 == 0) goto L8;
        if (r12 != 1) goto L7;
        ResultKt.throwOnFailure(r10);
    L13:
        Map r13 = (Map) r10;
    L15:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        PackageResourceManager r14 = AIInferRuntime.f(this.this$0);
        if (r14 == null) goto L15;
        String r15 = ((e.b) this.$command).a();
        this.label = 1;
        r10 = r14.updateAll(r15, true, this);
        if (r10 != r11) goto L13;
        return r11;
    }
}
