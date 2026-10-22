package com.obric.assistant.state.impl.multitask.producer;

import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.state.impl.multitask.producer.SelfUpdateDownloadStateProducer$updateListener$1$onStateUpdate$1", f = "SelfUpdateDownloadStateProducer.kt", i = {}, l = {53}, m = "invokeSuspend", n = {}, s = {})
public final class SelfUpdateDownloadStateProducer$updateListener$1$onStateUpdate$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $state;
    int label;
    final /* synthetic */ SelfUpdateDownloadStateProducer this$0;

    public SelfUpdateDownloadStateProducer$updateListener$1$onStateUpdate$1(SelfUpdateDownloadStateProducer r1, int r2, Continuation<? super SelfUpdateDownloadStateProducer$updateListener$1$onStateUpdate$1> r3) {
        this.this$0 = r1;
        this.$state = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new SelfUpdateDownloadStateProducer$updateListener$1$onStateUpdate$1(this.this$0, this.$state, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r4);
    L21:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r4);
        SelfUpdateDownloadStateProducer r5 = this.this$0;
        int r2 = this.$state;
        this.label = 1;
        if (r2 == 2) goto L11;
        r5.f = false;
        r5.a("state_changed");
        Object r6 = Unit.INSTANCE;
    L18:
        if (r6 != r0) goto L21;
        return r0;
    L11:
        if (r5.f == false) goto L13;
        FLogger.a.i("SelfUpdateDownloadStateProducer", "ignore downloading after max hold timeout until state exits");
        r6 = Unit.INSTANCE;
        goto L18
    L13:
        r6 = r5.b(this);
        if (r6 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L18;
        r6 = Unit.INSTANCE;
        goto L18
    }
}
