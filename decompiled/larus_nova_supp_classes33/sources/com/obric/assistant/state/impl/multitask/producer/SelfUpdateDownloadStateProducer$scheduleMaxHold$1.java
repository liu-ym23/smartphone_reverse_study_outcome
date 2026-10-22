package com.obric.assistant.state.impl.multitask.producer;

import aha.c0;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.state.impl.v2.utils.CoroutineExtKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.state.impl.multitask.producer.SelfUpdateDownloadStateProducer$scheduleMaxHold$1", f = "SelfUpdateDownloadStateProducer.kt", i = {0}, l = {122}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
final class SelfUpdateDownloadStateProducer$scheduleMaxHold$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ jha.l<c0> $handle;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ SelfUpdateDownloadStateProducer this$0;

    public SelfUpdateDownloadStateProducer$scheduleMaxHold$1(SelfUpdateDownloadStateProducer r1, jha.l<c0> r2, Continuation<? super SelfUpdateDownloadStateProducer$scheduleMaxHold$1> r3) {
        this.this$0 = r1;
        this.$handle = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        SelfUpdateDownloadStateProducer$scheduleMaxHold$1 r0 = new SelfUpdateDownloadStateProducer$scheduleMaxHold$1(this.this$0, this.$handle, r5);
        r0.L$0 = r4;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        CoroutineScope r2 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r6);
    L13:
        if (CoroutineScopeKt.isActive(r2) == false) goto L20;
        SelfUpdateDownloadStateProducer r7 = this.this$0;
        if (r7.c != this.$handle) goto L20;
        r7.f = true;
        FLogger.a.w("SelfUpdateDownloadStateProducer", "self-update network lock reached max hold duration");
        this.this$0.a("max_hold_timeout");
        return Unit.INSTANCE;
    L20:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        CoroutineScope r8 = (CoroutineScope) this.L$0;
        this.L$0 = r8;
        this.label = 1;
        if (CoroutineExtKt.a(1800000, this) != r0) goto L11;
        return r0;
    L11:
        r2 = r8;
        goto L13
    }
}
