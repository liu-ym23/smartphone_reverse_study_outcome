package com.obric.aikernel.phx.core.conn;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.l0;

/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(c = "com.obric.aikernel.phx.core.conn.ChildProcessLifecycleBinding$release$1$1", f = "ChildProcessLifecycleBinding.kt", i = {}, l = {169}, m = "invokeSuspend", n = {}, s = {})
final class ChildProcessLifecycleBinding$release$1$1 extends SuspendLambda implements Function2<l0, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $bindingKey;
    int label;

    ChildProcessLifecycleBinding$release$1$1(String r10, Continuation<? super ChildProcessLifecycleBinding$release$1$1> r11) {
        this.$bindingKey = r10;
        super(2, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new ChildProcessLifecycleBinding$release$1$1(this.$bindingKey, r11);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(l0 r10, Continuation<? super Unit> r11) {
        return invoke2(r10, r11);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(l0 r10, Continuation<? super Unit> r11) {
        return ((ChildProcessLifecycleBinding$release$1$1) create(r10, r11)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        Object r11 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r12 = this.label;
        if (r12 == 0) goto L8;
        if (r12 != 1) goto L7;
        ResultKt.throwOnFailure(r10);
    L11:
        ChildProcessLifecycleBinding.c(ChildProcessLifecycleBinding.f4776a, this.$bindingKey);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        long r13 = ChildProcessLifecycleBinding.f4776a.g();
        this.label = 1;
        if (DelayKt.b(r13, this) != r11) goto L11;
        return r11;
    }
}
