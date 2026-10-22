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
@DebugMetadata(c = "com.bytedance.ai.applet.moa.MoaLoginGrantingStep$requestConfirmation$2$1$1", f = "MoaLoginGrantingStep.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class MoaLoginGrantingStep$requestConfirmation$2$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ kotlinx.coroutines.i<MoaStepResult> $continuation;
    int label;
    final /* synthetic */ MoaLoginGrantingStep this$0;

    /* JADX WARN: Multi-variable type inference failed */
    public MoaLoginGrantingStep$requestConfirmation$2$1$1(MoaLoginGrantingStep r1, kotlinx.coroutines.i<? super MoaStepResult> r10, Continuation<? super MoaLoginGrantingStep$requestConfirmation$2$1$1> r11) {
        this.this$0 = r1;
        this.$continuation = r10;
        super(2, r11);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new MoaLoginGrantingStep$requestConfirmation$2$1$1(this.this$0, this.$continuation, r11);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10) {
        return invoke((CoroutineScope) r1, (Continuation) r10);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r10) {
        return create(r1, r10).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L10;
        ResultKt.throwOnFailure(r10);
        MoaLoginGrantingStep r11 = this.this$0;
        if (r11.h != this.$continuation) goto L8;
        r11.h = null;
        r11.f = MoaLoginGrantingStep.State.IDLE;
        r11.i = false;
        r11.e.b();
        r11.q();
    L8:
        return Unit.INSTANCE;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
