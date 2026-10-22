package com.larus.dora.impl.feedback;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "newState", "Lcom/larus/dora/impl/feedback/ImageState;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.feedback.DoraFeedbackImage$setupStateLogging$1", f = "DoraGFeedbackViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class DoraFeedbackImage$setupStateLogging$1 extends SuspendLambda implements Function2<ImageState, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ g this$0;

    public DoraFeedbackImage$setupStateLogging$1(g r1, Continuation<? super DoraFeedbackImage$setupStateLogging$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        DoraFeedbackImage$setupStateLogging$1 r0 = new DoraFeedbackImage$setupStateLogging$1(this.this$0, r4);
        r0.L$0 = r3;
        return r0;
    }

    public final Object invoke(ImageState r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((ImageState) r1, (Continuation) r2);
    }

    public final Object invokeSuspend(Object r4) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L10;
        ResultKt.throwOnFailure(r4);
        ImageState r5 = (ImageState) this.L$0;
        pk4.j.a("DoraGFeedbackViewModel", "Image [" + this.this$0.a + "] state changed to: " + r5);
        if (r5 != ImageState.READY) goto L8;
        pk4.j.a("DoraGFeedbackViewModel", "Image [" + this.this$0.a + "] processing completed. Token: " + this.this$0.g);
    L8:
        return Unit.INSTANCE;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
