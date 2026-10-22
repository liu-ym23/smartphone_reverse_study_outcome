package com.obric.aikernel.runtime;

import com.google.gson.k;
import java.io.PrintWriter;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.l0;

/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(c = "com.obric.aikernel.runtime.AIInferRuntime$dump$1$3", f = "AIInferRuntime.kt", i = {}, l = {307}, m = "invokeSuspend", n = {}, s = {})
final class AIInferRuntime$dump$1$3 extends SuspendLambda implements Function2<l0, Continuation<? super Unit>, Object> {
    final /* synthetic */ e $command;
    final /* synthetic */ PrintWriter $fout;
    Object L$0;
    int label;
    final /* synthetic */ AIInferRuntime this$0;

    AIInferRuntime$dump$1$3(PrintWriter r10, AIInferRuntime r11, e r12, Continuation<? super AIInferRuntime$dump$1$3> r13) {
        this.$fout = r10;
        this.this$0 = r11;
        this.$command = r12;
        super(2, r13);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new AIInferRuntime$dump$1$3(this.$fout, this.this$0, this.$command, r11);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(l0 r10, Continuation<? super Unit> r11) {
        return invoke2(r10, r11);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(l0 r10, Continuation<? super Unit> r11) {
        return ((AIInferRuntime$dump$1$3) create(r10, r11)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        Object r11 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r12 = this.label;
        if (r12 == 0) goto L8;
        if (r12 != 1) goto L7;
        PrintWriter r13 = (PrintWriter) this.L$0;
        ResultKt.throwOnFailure(r10);
    L12:
        r13.println(((k) r10).toString());
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        PrintWriter r14 = this.$fout;
        AIInferRuntime r15 = this.this$0;
        String r16 = ((e.a) this.$command).b();
        String r17 = ((e.a) this.$command).a();
        this.L$0 = r14;
        this.label = 1;
        Object r18 = AIInferRuntime.c(r15, r16, r17, this);
        if (r18 != r11) goto L11;
        return r11;
    L11:
        r10 = r18;
        r13 = r14;
        goto L12
    }
}
