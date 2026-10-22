package com.larus.camera.impl.ui.component.result.general;

import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\n¨\u0006\u0005"}, d2 = {"<anonymous>", "", "T", "Lcom/larus/camera/impl/utils/eventbus/Event;", "it", "com/larus/camera/impl/utils/eventbus/CameraEventBus$subscribe$1"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.camera.impl.ui.component.result.general.ResultSuggestedActionComponent$subscribeToInputStatus$$inlined$subscribe$2", f = "ResultSuggestedActionComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ResultSuggestedActionComponent$subscribeToInputStatus$$inlined$subscribe$2 extends SuspendLambda implements Function2<com.larus.camera.impl.utils.eventbus.h, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ResultSuggestedActionComponent this$0;

    public ResultSuggestedActionComponent$subscribeToInputStatus$$inlined$subscribe$2(Continuation r1, ResultSuggestedActionComponent r2) {
        this.this$0 = r2;
        super(2, r1);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        ResultSuggestedActionComponent$subscribeToInputStatus$$inlined$subscribe$2 r0 = new ResultSuggestedActionComponent$subscribeToInputStatus$$inlined$subscribe$2(r4, this.this$0);
        r0.L$0 = r3;
        return r0;
    }

    public final Object invoke(com.larus.camera.impl.utils.eventbus.h r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((com.larus.camera.impl.utils.eventbus.g) r1, (Continuation) r2);
    }

    public final Object invokeSuspend(Object r4) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r4);
        com.larus.camera.impl.utils.eventbus.h r5 = (com.larus.camera.impl.utils.eventbus.h) ((com.larus.camera.impl.utils.eventbus.g) this.L$0);
        FLogger.a.i("ResultSuggestedActionComponent", "[subscribe] received " + r5);
        ResultSuggestedActionComponent r6 = this.this$0;
        int r0 = ResultSuggestedActionComponent.w;
        r6.t().setAlpha(0.5f);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
