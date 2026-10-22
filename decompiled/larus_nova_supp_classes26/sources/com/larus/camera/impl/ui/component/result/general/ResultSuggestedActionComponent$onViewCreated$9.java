package com.larus.camera.impl.ui.component.result.general;

import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lkotlin/Pair;", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.camera.impl.ui.component.result.general.ResultSuggestedActionComponent$onViewCreated$9", f = "ResultSuggestedActionComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ResultSuggestedActionComponent$onViewCreated$9 extends SuspendLambda implements Function2<Pair<? extends Boolean, ? extends Boolean>, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ResultSuggestedActionComponent this$0;

    public ResultSuggestedActionComponent$onViewCreated$9(ResultSuggestedActionComponent r1, Continuation<? super ResultSuggestedActionComponent$onViewCreated$9> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        ResultSuggestedActionComponent$onViewCreated$9 r0 = new ResultSuggestedActionComponent$onViewCreated$9(this.this$0, r4);
        r0.L$0 = r3;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((Pair) r1, (Continuation) r2);
    }

    public final Object invoke(Pair<Boolean, Boolean> r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r2) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L17;
        ResultKt.throwOnFailure(r2);
        Pair r3 = (Pair) this.L$0;
        if (((Boolean) r3.getFirst()).booleanValue() == false) goto L7;
    L13:
        ResultSuggestedActionComponent r4 = this.this$0;
        int r0 = ResultSuggestedActionComponent.w;
        com.larus.utils.e1.o(r4.t());
    L15:
        return Unit.INSTANCE;
    L7:
        if (((Boolean) r3.getSecond()).booleanValue() == true) goto L13;
        ResultSuggestedActionComponent r5 = this.this$0;
        int r1 = ResultSuggestedActionComponent.w;
        if (r5.v() == false) goto L12;
        com.larus.utils.e1.o(this.this$0.t());
        goto L15
    L12:
        this.this$0.w(false);
        goto L15
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
