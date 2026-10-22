package com.larus.camera.impl.ui.component.result.general;

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
@DebugMetadata(c = "com.larus.camera.impl.ui.component.result.general.ResultSuggestedActionComponent$subscribeToChangeSuggestedActionSuppressedForInputText$$inlined$subscribe$2", f = "ResultSuggestedActionComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ResultSuggestedActionComponent$subscribeToChangeSuggestedActionSuppressedForInputText$$inlined$subscribe$2 extends SuspendLambda implements Function2<com.larus.camera.impl.utils.eventbus.e, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ResultSuggestedActionComponent this$0;

    public ResultSuggestedActionComponent$subscribeToChangeSuggestedActionSuppressedForInputText$$inlined$subscribe$2(Continuation r1, ResultSuggestedActionComponent r2) {
        this.this$0 = r2;
        super(2, r1);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        ResultSuggestedActionComponent$subscribeToChangeSuggestedActionSuppressedForInputText$$inlined$subscribe$2 r0 = new ResultSuggestedActionComponent$subscribeToChangeSuggestedActionSuppressedForInputText$$inlined$subscribe$2(r4, this.this$0);
        r0.L$0 = r3;
        return r0;
    }

    public final Object invoke(com.larus.camera.impl.utils.eventbus.e r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((com.larus.camera.impl.utils.eventbus.g) r1, (Continuation) r2);
    }

    public final Object invokeSuspend(Object r3) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L19;
        ResultKt.throwOnFailure(r3);
        com.larus.camera.impl.utils.eventbus.e r4 = (com.larus.camera.impl.utils.eventbus.e) ((com.larus.camera.impl.utils.eventbus.g) this.L$0);
        ResultSuggestedActionComponent r0 = this.this$0;
        boolean r1 = r0.u;
        boolean r5 = r4.a;
        if (r1 == r5) goto L17;
        r0.u = r5;
        if (r5 == true) goto L9;
        r0.w(true);
        goto L17
    L9:
        if (r0.t().getVisibility() != 0) goto L11;
        boolean r6 = true;
    L12:
        if (r6 == false) goto L14;
        this.this$0.t().g = true;
        this.this$0.t().b(null);
        this.this$0.t().requestLayout();
        goto L17
    L14:
        com.larus.utils.e1.o(this.this$0.t());
        goto L17
    L11:
        r6 = false;
    L17:
        return Unit.INSTANCE;
    L19:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
