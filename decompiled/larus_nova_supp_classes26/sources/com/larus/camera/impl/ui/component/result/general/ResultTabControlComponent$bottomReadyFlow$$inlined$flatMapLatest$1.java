package com.larus.camera.impl.ui.component.result.general;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.StateFlowImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u00042\u0006\u0010\u0005\u001a\u0002H\u0002H\u008a@¨\u0006\u0006"}, d2 = {"<anonymous>", "", "T", "R", "Lkotlinx/coroutines/flow/FlowCollector;", "it", "kotlinx/coroutines/flow/FlowKt__MergeKt$flatMapLatest$1"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.camera.impl.ui.component.result.general.ResultTabControlComponent$bottomReadyFlow$$inlined$flatMapLatest$1", f = "ResultTabControlComponent.kt", i = {}, l = {189}, m = "invokeSuspend", n = {}, s = {})
public final class ResultTabControlComponent$bottomReadyFlow$$inlined$flatMapLatest$1 extends SuspendLambda implements Function3<FlowCollector<? super nx8.f>, nx8.m, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    public ResultTabControlComponent$bottomReadyFlow$$inlined$flatMapLatest$1(Continuation r2) {
        super(3, r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2, Object r3) {
        return invoke((FlowCollector) r1, r2, (Continuation) r3);
    }

    public final Object invoke(FlowCollector<? super nx8.f> r2, nx8.m r3, Continuation<? super Unit> r4) {
        ResultTabControlComponent$bottomReadyFlow$$inlined$flatMapLatest$1 r0 = new ResultTabControlComponent$bottomReadyFlow$$inlined$flatMapLatest$1(r4);
        r0.L$0 = r2;
        r0.L$1 = r3;
        return r0.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r4);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r4);
        FlowCollector r5 = (FlowCollector) this.L$0;
        StateFlowImpl r2 = ((nx8.m) this.L$1).i();
        this.label = 1;
        if (kotlinx.coroutines.flow.e.r(r5, r2, this) != r0) goto L12;
        return r0;
    }
}
