package com.obric.aikernel.runtime.subproc;

import com.obric.aikernel.b;
import com.obric.aikernel.runtime.AIInferRuntime;
import e8.a;
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
@DebugMetadata(c = "com.obric.aikernel.runtime.subproc.MainHost$updatePackage$1", f = "MainHost.kt", i = {}, l = {57}, m = "invokeSuspend", n = {}, s = {})
final class MainHost$updatePackage$1 extends SuspendLambda implements Function2<l0, Continuation<? super Unit>, Object> {
    final /* synthetic */ b $callback;
    final /* synthetic */ String $caller;
    final /* synthetic */ String $lora;
    final /* synthetic */ String $name;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ MainHost this$0;

    MainHost$updatePackage$1(b r10, MainHost r11, String r12, String r13, String r14, Continuation<? super MainHost$updatePackage$1> r15) {
        this.$callback = r10;
        this.this$0 = r11;
        this.$name = r12;
        this.$caller = r13;
        this.$lora = r14;
        super(2, r15);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        MainHost$updatePackage$1 r12 = new MainHost$updatePackage$1(this.$callback, this.this$0, this.$name, this.$caller, this.$lora, r11);
        r12.L$0 = r10;
        return r12;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(l0 r10, Continuation<? super Unit> r11) {
        return invoke2(r10, r11);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(l0 r10, Continuation<? super Unit> r11) {
        return ((MainHost$updatePackage$1) create(r10, r11)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        Object r11 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r12 = this.label;
        if (r12 == 0) goto L9;
        if (r12 != 1) goto L8;
        ResultKt.throwOnFailure(r10);     // Catch: Throwable -> L15
    L13:
        Result.m32constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L15
    L17:
        a.s(this.$callback, null, 1, null);
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r10);
        l0 r13 = (l0) this.L$0;
        MainHost r14 = this.this$0;
        String r15 = this.$name;
        String r16 = this.$caller;
        String r17 = this.$lora;
        Result.Companion r18 = Result.Companion;     // Catch: Throwable -> L15
        AIInferRuntime r19 = r14.b();     // Catch: Throwable -> L15
        this.label = 1;     // Catch: Throwable -> L15
        if (r19.I0(r15, r16, r17, this) != r11) goto L13;
        return r11;
    L15:
        th = move-exception;
        Result.Companion r20 = Result.Companion;
        Result.m32constructorimpl(ResultKt.createFailure(th));
        goto L17
    }
}
