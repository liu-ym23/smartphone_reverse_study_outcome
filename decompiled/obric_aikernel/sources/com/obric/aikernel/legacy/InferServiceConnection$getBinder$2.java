package com.obric.aikernel.legacy;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.h;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.r0;

/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(c = "com.obric.aikernel.legacy.InferServiceConnection$getBinder$2", f = "InferServiceConnection.kt", i = {0}, l = {62, 72}, m = "invokeSuspend", n = {"$this$withTimeoutOrNull"}, s = {"L$0"})
final class InferServiceConnection$getBinder$2 extends SuspendLambda implements Function2<l0, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ InferServiceConnection this$0;

    InferServiceConnection$getBinder$2(InferServiceConnection r10, Continuation<? super InferServiceConnection$getBinder$2> r11) {
        this.this$0 = r10;
        super(2, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        InferServiceConnection$getBinder$2 r12 = new InferServiceConnection$getBinder$2(this.this$0, r11);
        r12.L$0 = r10;
        return r12;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(l0 r10, Continuation<? super Unit> r11) {
        return invoke2(r10, r11);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(l0 r10, Continuation<? super Unit> r11) {
        return ((InferServiceConnection$getBinder$2) create(r10, r11)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r12) {
        Object r10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r11 = this.label;
        if (r11 == 0) goto L10;
        if (r11 == 1) goto L9;
        if (r11 != 2) goto L8;
        ResultKt.throwOnFailure(r12);
    L28:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        l0 r13 = (l0) this.L$0;
        ResultKt.throwOnFailure(r12);
    L13:
        com.obric.aikernel.a r14 = (com.obric.aikernel.a) r12;
        if (r14 != null) goto L16;
    L17:
        InferServiceConnection r15 = this.this$0;
        monitor-enter(r13);
    L29:
        th = move-exception;
        throw th;
    L20:
        if (InferServiceConnection.d(r15).a() == false) goto L22;
        InferServiceConnection.f(r15, h.b(InferServiceConnection.b(r15), null, null, new InferServiceConnection$getBinder$2$1$1(r15, null), 3, null));     // Catch: Throwable -> L29
    L22:
        Unit r16 = Unit.INSTANCE;     // Catch: Throwable -> L29
        monitor-exit(r13);
        r0 r17 = InferServiceConnection.d(this.this$0);
        this.L$0 = null;
        this.label = 2;
        if (r17.r(this) != r10) goto L28;
        return r10;
    L16:
        if (r14.asBinder().pingBinder() == true) goto L28;
    L10:
        ResultKt.throwOnFailure(r12);
        r13 = (l0) this.L$0;
        r0 r18 = InferServiceConnection.d(this.this$0);
        this.L$0 = r13;
        this.label = 1;
        r12 = r18.r(this);
        if (r12 != r10) goto L13;
        return r10;
    }
}
