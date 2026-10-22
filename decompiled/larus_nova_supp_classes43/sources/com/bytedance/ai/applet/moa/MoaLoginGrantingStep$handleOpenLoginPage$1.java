package com.bytedance.ai.applet.moa;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.applet.moa.MoaLoginGrantingStep$handleOpenLoginPage$1", f = "MoaLoginGrantingStep.kt", i = {}, l = {256}, m = "invokeSuspend", n = {}, s = {})
final class MoaLoginGrantingStep$handleOpenLoginPage$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<Result<Unit>, Unit> $completion;
    final /* synthetic */ String $url;
    int label;
    final /* synthetic */ MoaLoginGrantingStep this$0;

    public MoaLoginGrantingStep$handleOpenLoginPage$1(MoaLoginGrantingStep r1, String r10, Function1<? super Result<Unit>, Unit> r11, Continuation<? super MoaLoginGrantingStep$handleOpenLoginPage$1> r12) {
        this.this$0 = r1;
        this.$url = r10;
        this.$completion = r11;
        super(2, r12);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new MoaLoginGrantingStep$handleOpenLoginPage$1(this.this$0, this.$url, this.$completion, r11);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10) {
        return invoke((CoroutineScope) r1, (Continuation) r10);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r10) {
        return create(r1, r10).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r10);
        Object r11 = ((Result) r10).unbox-impl();
    L11:
        this.$completion.invoke(Result.box-impl(r11));
        if (Result.isFailure-impl(r11) == false) goto L17;
        MoaLoginGrantingStep r12 = this.this$0;
        if (r12.h == null) goto L17;
        r12.k(MoaStepResult.FAILED);
    L17:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        MoaLoginGrantingStep r13 = this.this$0;
        String r14 = this.$url;
        this.label = 1;
        int r15 = MoaLoginGrantingStep.m;
        r11 = r13.m(r14, this);
        if (r11 != r0) goto L11;
        return r0;
    }
}
