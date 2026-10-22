package com.obric.aikernel.runtime;

import java.util.List;
import kotlin.ExceptionsKt;
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
@DebugMetadata(c = "com.obric.aikernel.runtime.AIInferRuntime$schedulePreparePackage$1", f = "AIInferRuntime.kt", i = {0}, l = {1260}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
final class AIInferRuntime$schedulePreparePackage$1 extends SuspendLambda implements Function2<l0, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $biz;
    final /* synthetic */ AIInferRuntime.g $state;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ AIInferRuntime this$0;

    AIInferRuntime$schedulePreparePackage$1(AIInferRuntime.g r10, String r11, AIInferRuntime r12, Continuation<? super AIInferRuntime$schedulePreparePackage$1> r13) {
        this.$state = r10;
        this.$biz = r11;
        this.this$0 = r12;
        super(2, r13);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        AIInferRuntime$schedulePreparePackage$1 r12 = new AIInferRuntime$schedulePreparePackage$1(this.$state, this.$biz, this.this$0, r11);
        r12.L$0 = r10;
        return r12;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(l0 r10, Continuation<? super Unit> r11) {
        return invoke2(r10, r11);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(l0 r10, Continuation<? super Unit> r11) {
        return ((AIInferRuntime$schedulePreparePackage$1) create(r10, r11)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x003a -> B:17:0x003d). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r12) {
        Object r10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r11 = this.label;
        if (r11 == 0) goto L12;
        if (r11 != 1) goto L11;
        l0 r13 = (l0) this.L$0;
        ResultKt.throwOnFailure(r12);     // Catch: Throwable -> L8
    L17:
        Object r14 = Result.m32constructorimpl((List) r12);     // Catch: Throwable -> L8
    L20:
        String r15 = this.$biz;
        Throwable r16 = Result.m35exceptionOrNullimpl(r14);
        if (r16 == null) goto L23;
        com.obric.aikernel.runtime.utils.d.f5417a.e("AIInferRuntime", "schedulePreparePackage failed " + r15 + ' ' + ExceptionsKt.stackTraceToString(r16));
    L23:
        AIInferRuntime.g r17 = this.$state;
        AIInferRuntime r18 = this.this$0;
        String r19 = this.$biz;
        monitor-enter(r17);
        boolean r20 = false;
        if (r17.a() == false) goto L28;
        r17.c(false);     // Catch: Throwable -> L34
        r20 = true;
    L29:
        monitor-exit(r17);
        if (r20 == false) goto L32;
        com.obric.aikernel.runtime.utils.d.f5417a.g("AIInferRuntime", "schedulePreparePackage rerun " + this.$biz + " due to pending update");
    L13:
        AIInferRuntime r21 = this.this$0;
        String r22 = this.$biz;
        Result.Companion r110 = Result.Companion;     // Catch: Throwable -> L8
        this.L$0 = r13;     // Catch: Throwable -> L8
        this.label = 1;     // Catch: Throwable -> L8
        r12 = AIInferRuntime.m0(r21, r22, null, false, null, this, 14, null);     // Catch: Throwable -> L8
        if (r12 != r10) goto L17;
        return r10;
    L32:
        return Unit.INSTANCE;
    L28:
        r17.d(false);     // Catch: Throwable -> L34
        AIInferRuntime.o(r18).remove(r19, r17);     // Catch: Throwable -> L34
    L34:
        th = move-exception;
        throw th;
    L8:
        th = move-exception;
        Result.Companion r23 = Result.Companion;
        r14 = Result.m32constructorimpl(ResultKt.createFailure(th));
        goto L20
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L12:
        ResultKt.throwOnFailure(r12);
        r13 = (l0) this.L$0;
        goto L13
    }
}
