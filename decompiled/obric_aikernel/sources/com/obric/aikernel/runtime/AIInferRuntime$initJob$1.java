package com.obric.aikernel.runtime;

import com.obric.aee.ExecutionEngine;
import com.obric.aikernel.runtime.utils.CommonExtension;
import java.util.Iterator;
import java.util.List;
import kotlin.ExceptionsKt;
import kotlin.Pair;
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
@DebugMetadata(c = "com.obric.aikernel.runtime.AIInferRuntime$initJob$1", f = "AIInferRuntime.kt", i = {}, l = {188, 189, 202, 204}, m = "invokeSuspend", n = {}, s = {})
final class AIInferRuntime$initJob$1 extends SuspendLambda implements Function2<l0, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ AIInferRuntime this$0;

    AIInferRuntime$initJob$1(AIInferRuntime r10, Continuation<? super AIInferRuntime$initJob$1> r11) {
        this.this$0 = r10;
        super(2, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        AIInferRuntime$initJob$1 r12 = new AIInferRuntime$initJob$1(this.this$0, r11);
        r12.L$0 = r10;
        return r12;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(l0 r10, Continuation<? super Unit> r11) {
        return invoke2(r10, r11);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(l0 r10, Continuation<? super Unit> r11) {
        return ((AIInferRuntime$initJob$1) create(r10, r11)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r11) {
        Object r10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r12 = this.label;
        if (r12 == 0) goto L20;
        if (r12 == 1) goto L15;
        if (r12 == 2) goto L12;
        if (r12 == 3) goto L11;
        if (r12 != 4) goto L10;
        ResultKt.throwOnFailure(r11);
    L53:
        com.obric.aikernel.runtime.utils.d.f5417a.g("AIInferRuntime", "init job finished");
        return Unit.INSTANCE;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L11:
        ResultKt.throwOnFailure(r11);
    L50:
        AIInferRuntime r13 = this.this$0;
        this.L$0 = null;
        this.label = 4;
        if (AIInferRuntime.E(r13, this) != r10) goto L53;
        return r10;
    L12:
        AIInferRuntime r14 = (AIInferRuntime) this.L$0;
        ResultKt.throwOnFailure(r11);     // Catch: Throwable -> L18
    L33:
        List<Pair<String, Object>> r15 = r14.R().j();     // Catch: Throwable -> L18
        if (r15 == null) goto L39;
        Iterator<T> r16 = r15.iterator();     // Catch: Throwable -> L18
    L37:
        if (r16.hasNext() == false) goto L39;
        Pair r17 = (Pair) r16.next();     // Catch: Throwable -> L18
        String r18 = (String) r17.component1();     // Catch: Throwable -> L18
        ExecutionEngine.f4305a.f(r17.component2(), r18);     // Catch: Throwable -> L18
    L39:
        com.obric.aikernel.runtime.utils.b.f5415a.a(AIInferRuntime.k(r14).getContext());     // Catch: Throwable -> L18
        ExecutionEngine r19 = ExecutionEngine.f4305a;     // Catch: Throwable -> L18
        r19.f(r14, "aik");     // Catch: Throwable -> L18
        r19.f(new CommonExtension(), "common");     // Catch: Throwable -> L18
        com.obric.aikernel.runtime.utils.d.f5417a.g("AIInferRuntime", "vm init finished");     // Catch: Throwable -> L18
        Object r110 = Result.m32constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L18
    L42:
        Throwable r111 = Result.m35exceptionOrNullimpl(r110);
        if (r111 == null) goto L45;
        com.obric.aikernel.runtime.utils.d.f5417a.e("AIInferRuntime", "vm init failed " + ExceptionsKt.stackTraceToString(r111));
    L45:
        AIInferRuntime.c r112 = this.this$0.R().a();
        if (r112 == null) goto L50;
        this.L$0 = null;
        this.label = 3;
        if (r112.d(this) != r10) goto L50;
        return r10;
    L15:
        r14 = (AIInferRuntime) this.L$0;
        ResultKt.throwOnFailure(r11);     // Catch: Throwable -> L18
    L30:
        ExecutionEngine r113 = ExecutionEngine.f4305a;     // Catch: Throwable -> L18
        AIInferRuntime.h r20 = AIInferRuntime.k(r14);     // Catch: Throwable -> L18
        this.L$0 = r14;     // Catch: Throwable -> L18
        this.label = 2;     // Catch: Throwable -> L18
        if (r113.d(r20, this) != r10) goto L33;
        return r10;
    L20:
        ResultKt.throwOnFailure(r11);
        l0 r114 = (l0) this.L$0;
        if (this.this$0.R().f().d() != null) goto L23;
        r14 = this.this$0;
        Result.Companion r115 = Result.Companion;     // Catch: Throwable -> L18
        com.obric.aikernel.runtime.utils.d.f5417a.g("AIInferRuntime", "vm init start root = " + AIInferRuntime.k(r14).c());     // Catch: Throwable -> L18
        AIInferRuntime.c r116 = r14.R().a();     // Catch: Throwable -> L18
        if (r116 == null) goto L30;
        this.L$0 = r14;     // Catch: Throwable -> L18
        this.label = 1;     // Catch: Throwable -> L18
        if (r116.k(this) != r10) goto L30;
        return r10;
    L23:
        return Unit.INSTANCE;
    L18:
        th = move-exception;
        Result.Companion r21 = Result.Companion;
        r110 = Result.m32constructorimpl(ResultKt.createFailure(th));
        goto L42
    }
}
