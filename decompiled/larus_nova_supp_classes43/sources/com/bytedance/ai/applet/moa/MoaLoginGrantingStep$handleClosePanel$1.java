package com.bytedance.ai.applet.moa;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.applet.moa.MoaLoginGrantingStep$handleClosePanel$1", f = "MoaLoginGrantingStep.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class MoaLoginGrantingStep$handleClosePanel$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ MoaLoginGrantingStep this$0;

    public MoaLoginGrantingStep$handleClosePanel$1(MoaLoginGrantingStep r1, Continuation<? super MoaLoginGrantingStep$handleClosePanel$1> r10) {
        this.this$0 = r1;
        super(2, r10);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new MoaLoginGrantingStep$handleClosePanel$1(this.this$0, r11);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10) {
        return invoke((CoroutineScope) r1, (Continuation) r10);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r10) {
        return create(r1, r10).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L12;
        ResultKt.throwOnFailure(r10);
        this.this$0.e.b();
        MoaLoginGrantingStep r11 = this.this$0;
        if (r11.f != MoaLoginGrantingStep.State.DISMISSING) goto L10;
        if (r11.h == null) goto L10;
        r11.k(MoaStepResult.WAITING_ACTION);
    L10:
        return Unit.INSTANCE;
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
