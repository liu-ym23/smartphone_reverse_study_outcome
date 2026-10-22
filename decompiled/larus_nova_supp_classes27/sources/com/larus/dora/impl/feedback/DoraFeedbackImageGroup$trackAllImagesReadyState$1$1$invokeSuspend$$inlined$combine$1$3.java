package com.larus.dora.impl.feedback;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001\"\u0004\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0006H\u008a@¨\u0006\u0007"}, d2 = {"<anonymous>", "", "T", "R", "Lkotlinx/coroutines/flow/FlowCollector;", "it", "", "kotlinx/coroutines/flow/FlowKt__ZipKt$combine$6$2"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.feedback.DoraFeedbackImageGroup$trackAllImagesReadyState$1$1$invokeSuspend$$inlined$combine$1$3", f = "DoraGFeedbackViewModel.kt", i = {}, l = {288}, m = "invokeSuspend", n = {}, s = {})
public final class DoraFeedbackImageGroup$trackAllImagesReadyState$1$1$invokeSuspend$$inlined$combine$1$3 extends SuspendLambda implements Function3<FlowCollector<? super Boolean>, ImageState[], Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    public DoraFeedbackImageGroup$trackAllImagesReadyState$1$1$invokeSuspend$$inlined$combine$1$3(Continuation r2) {
        super(3, r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2, Object r3) {
        return invoke((FlowCollector) r1, (Object[]) r2, (Continuation) r3);
    }

    public final Object invoke(FlowCollector<? super Boolean> r2, ImageState[] r3, Continuation<? super Unit> r4) {
        DoraFeedbackImageGroup$trackAllImagesReadyState$1$1$invokeSuspend$$inlined$combine$1$3 r0 = new DoraFeedbackImageGroup$trackAllImagesReadyState$1$1$invokeSuspend$$inlined$combine$1$3(r4);
        r0.L$0 = r2;
        r0.L$1 = r3;
        return r0.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r9) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r9);
    L22:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r9);
        FlowCollector r10 = (FlowCollector) this.L$0;
        ImageState[] r2 = (ImageState[]) ((Object[]) this.L$1);
        int r3 = r2.length;
        boolean r4 = false;
        int r5 = 0;
    L9:
        if (r5 >= r3) goto L17;
        if (r2[r5] != ImageState.READY) goto L13;
        boolean r6 = true;
    L14:
        if (r6 == false) goto L18;
        r5 = r5 + 1;
    L18:
        Boolean r7 = Boxing.boxBoolean(r4);
        this.label = 1;
        if (r10.emit(r7, this) != r0) goto L22;
        return r0;
    L13:
        r6 = false;
        goto L14
    L17:
        r4 = true;
        goto L18
    }
}
