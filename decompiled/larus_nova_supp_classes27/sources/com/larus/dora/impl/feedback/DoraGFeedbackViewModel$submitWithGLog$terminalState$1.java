package com.larus.dora.impl.feedback;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "state", "Lcom/larus/dora/impl/feedback/LogState;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.feedback.DoraGFeedbackViewModel$submitWithGLog$terminalState$1", f = "DoraGFeedbackViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class DoraGFeedbackViewModel$submitWithGLog$terminalState$1 extends SuspendLambda implements Function2<LogState, Continuation<? super Boolean>, Object> {
    /* synthetic */ Object L$0;
    int label;

    public DoraGFeedbackViewModel$submitWithGLog$terminalState$1(Continuation<? super DoraGFeedbackViewModel$submitWithGLog$terminalState$1> r2) {
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        DoraGFeedbackViewModel$submitWithGLog$terminalState$1 r0 = new DoraGFeedbackViewModel$submitWithGLog$terminalState$1(r3);
        r0.L$0 = r2;
        return r0;
    }

    public final Object invoke(LogState r1, Continuation<? super Boolean> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((LogState) r1, (Continuation) r2);
    }

    public final Object invokeSuspend(Object r2) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L18;
        ResultKt.throwOnFailure(r2);
        LogState r3 = (LogState) this.L$0;
        if (r3 != LogState.READY) goto L7;
    L14:
        boolean r4 = true;
    L16:
        return Boxing.boxBoolean(r4);
    L7:
        if (r3 == LogState.P2P_CONNECTION_FAILED) goto L14;
        if (r3 == LogState.LOG_FETCH_FAILED) goto L14;
        if (r3 == LogState.LOG_UPLOAD_FAILED) goto L14;
        r4 = false;
        goto L16
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
