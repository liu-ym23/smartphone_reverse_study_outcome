package com.larus.canvas.core.impl.sse;

import cy8.u;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "event", "Lcom/larus/canvas/core/api/model/CanvasSSEEvent;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.canvas.core.impl.sse.CanvasStreamPullHandler$start$1$streamResult$1", f = "CanvasStreamPullHandler.kt", i = {}, l = {57}, m = "invokeSuspend", n = {}, s = {})
public final class CanvasStreamPullHandler$start$1$streamResult$1 extends SuspendLambda implements Function2<u, Continuation<? super Unit>, Object> {
    final /* synthetic */ FlowCollector<u> $$this$flow;
    final /* synthetic */ Ref.ObjectRef<Long> $sequenceId;
    /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public CanvasStreamPullHandler$start$1$streamResult$1(Ref.ObjectRef<Long> r1, FlowCollector<? super u> r2, Continuation<? super CanvasStreamPullHandler$start$1$streamResult$1> r3) {
        this.$sequenceId = r1;
        this.$$this$flow = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        CanvasStreamPullHandler$start$1$streamResult$1 r0 = new CanvasStreamPullHandler$start$1$streamResult$1(this.$sequenceId, this.$$this$flow, r5);
        r0.L$0 = r4;
        return r0;
    }

    public final Object invoke(u r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((u) r1, (Continuation) r2);
    }

    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r5);
    L18:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        u r6 = (u) this.L$0;
        if ((r6 instanceof u.a) == false) goto L14;
        Ref.ObjectRef<Long> r2 = this.$sequenceId;
        Long r3 = ((u.a) r6).a.b;
        if (r3 != null) goto L13;
        r3 = (Long) r2.element;
    L13:
        r2.element = r3;
    L14:
        FlowCollector<u> r4 = this.$$this$flow;
        this.label = 1;
        if (r4.emit(r6, this) != r0) goto L18;
        return r0;
    }
}
