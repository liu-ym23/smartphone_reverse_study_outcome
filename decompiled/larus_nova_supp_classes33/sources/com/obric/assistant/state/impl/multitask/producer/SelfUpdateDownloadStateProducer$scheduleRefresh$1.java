package com.obric.assistant.state.impl.multitask.producer;

import aha.c0;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.state.impl.v2.utils.CoroutineExtKt;
import com.obric.assistant.state.multitask.ext.TaskFlowDslKt;
import com.obric.cae.libs.useraware.ApWakeEvent;
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
@DebugMetadata(c = "com.obric.assistant.state.impl.multitask.producer.SelfUpdateDownloadStateProducer$scheduleRefresh$1", f = "SelfUpdateDownloadStateProducer.kt", i = {0}, l = {ApWakeEvent.RUNNING_START}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
final class SelfUpdateDownloadStateProducer$scheduleRefresh$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ jha.l<c0> $handle;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ SelfUpdateDownloadStateProducer this$0;

    public SelfUpdateDownloadStateProducer$scheduleRefresh$1(SelfUpdateDownloadStateProducer r1, jha.l<c0> r2, Continuation<? super SelfUpdateDownloadStateProducer$scheduleRefresh$1> r3) {
        this.this$0 = r1;
        this.$handle = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        SelfUpdateDownloadStateProducer$scheduleRefresh$1 r0 = new SelfUpdateDownloadStateProducer$scheduleRefresh$1(this.this$0, this.$handle, r5);
        r0.L$0 = r4;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x003e -> B:16:0x0041). Please report as a decompilation issue!!! */
    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        CoroutineScope r2 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r7);
        SelfUpdateDownloadStateProducer$scheduleRefresh$1 r8 = this;
    L17:
        if (CoroutineScopeKt.isActive(r2) == false) goto L23;
        SelfUpdateDownloadStateProducer r3 = r8.this$0;
        if (r3.c != r8.$handle) goto L23;
        r3.g++;
        FLogger.a.i("SelfUpdateDownloadStateProducer", "refresh self-update network lock, sequence=" + r8.this$0.g);
        TaskFlowDslKt.f(r8.$handle, new c0.a(r8.this$0.g));
    L10:
        if (CoroutineScopeKt.isActive(r2) == false) goto L23;
        if (r8.this$0.c != r8.$handle) goto L23;
        r8.L$0 = r2;
        r8.label = 1;
        if (CoroutineExtKt.a(180000, r8) != r0) goto L17;
        return r0;
    L23:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r7);
        r2 = (CoroutineScope) this.L$0;
        r8 = this;
        goto L10
    }
}
