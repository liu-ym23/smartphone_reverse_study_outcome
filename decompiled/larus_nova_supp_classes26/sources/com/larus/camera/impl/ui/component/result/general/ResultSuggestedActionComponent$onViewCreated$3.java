package com.larus.camera.impl.ui.component.result.general;

import com.larus.utils.logger.FLogger;
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
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\n"}, d2 = {"<anonymous>", "", "<destruct>", "Lkotlin/Pair;", "", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.camera.impl.ui.component.result.general.ResultSuggestedActionComponent$onViewCreated$3", f = "ResultSuggestedActionComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ResultSuggestedActionComponent$onViewCreated$3 extends SuspendLambda implements Function2<Pair<? extends Long, ? extends Boolean>, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ResultSuggestedActionComponent this$0;

    public ResultSuggestedActionComponent$onViewCreated$3(ResultSuggestedActionComponent r1, Continuation<? super ResultSuggestedActionComponent$onViewCreated$3> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        ResultSuggestedActionComponent$onViewCreated$3 r0 = new ResultSuggestedActionComponent$onViewCreated$3(this.this$0, r4);
        r0.L$0 = r3;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((Pair) r1, (Continuation) r2);
    }

    public final Object invoke(Pair<Long, Boolean> r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L17;
        ResultKt.throwOnFailure(r6);
        Pair r7 = (Pair) this.L$0;
        long r0 = ((Number) r7.component1()).longValue();
        boolean r8 = ((Boolean) r7.component2()).booleanValue();
        FLogger.a.i("ResultSuggestedActionComponent", "previewThumbListDeleteStateFlow isDeleteVideo:" + r8 + ' ' + r0);
        if (r0 == (-1)) goto L7;
        com.larus.camera.impl.ui.viewmodel.t r1 = com.larus.camera.impl.ui.viewmodel.t.a;
        if (com.larus.camera.impl.ui.viewmodel.t.e() <= 1) goto L11;
    L12:
        if (r8 == false) goto L15;
    L13:
        ResultSuggestedActionComponent r2 = this.this$0;
        int r3 = ResultSuggestedActionComponent.w;
        r2.x(r8);
    L15:
        return Unit.INSTANCE;
    L11:
        if (this.this$0.v == 8) goto L13;
    L7:
        return Unit.INSTANCE;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
