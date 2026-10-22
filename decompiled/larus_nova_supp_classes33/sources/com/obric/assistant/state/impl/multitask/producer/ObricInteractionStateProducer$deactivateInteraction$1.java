package com.obric.assistant.state.impl.multitask.producer;

import aha.n;
import java.util.Map;
import jha.g;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.sync.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.state.impl.multitask.producer.ObricInteractionStateProducer$deactivateInteraction$1", f = "ObricInteractionStateProducer.kt", i = {0}, l = {124}, m = "invokeSuspend", n = {"$this$withLock_u24default$iv"}, s = {"L$0"})
public final class ObricInteractionStateProducer$deactivateInteraction$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Map<String, Object> $snapshotExt;
    final /* synthetic */ g<n> $taskId;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    final /* synthetic */ ObricInteractionStateProducer this$0;

    public ObricInteractionStateProducer$deactivateInteraction$1(ObricInteractionStateProducer r1, g<n> r2, Map<String, ? extends Object> r3, Continuation<? super ObricInteractionStateProducer$deactivateInteraction$1> r4) {
        this.this$0 = r1;
        this.$taskId = r2;
        this.$snapshotExt = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new ObricInteractionStateProducer$deactivateInteraction$1(this.this$0, this.$taskId, this.$snapshotExt, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        Map<String, Object> r2 = (Map) this.L$3;
        g<n> r3 = (g) this.L$2;
        ObricInteractionStateProducer r4 = (ObricInteractionStateProducer) this.L$1;
        a r5 = (a) this.L$0;
        ResultKt.throwOnFailure(r7);
    L18:
        ObricInteractionStateProducer.d(r4, r3, r2);     // Catch: Throwable -> L15
        Unit r8 = Unit.INSTANCE;     // Catch: Throwable -> L15
        r5.unlock(null);
        return Unit.INSTANCE;
    L15:
        th = move-exception;
        r5.unlock(null);
        throw th;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r7);
        ObricInteractionStateProducer r9 = this.this$0;
        r5 = r9.c;
        r3 = this.$taskId;
        Map<String, Object> r6 = this.$snapshotExt;
        this.L$0 = r5;
        this.L$1 = r9;
        this.L$2 = r3;
        this.L$3 = r6;
        this.label = 1;
        if (r5.a(null, this) != r0) goto L11;
        return r0;
    L11:
        r4 = r9;
        r2 = r6;
        goto L18
    }
}
