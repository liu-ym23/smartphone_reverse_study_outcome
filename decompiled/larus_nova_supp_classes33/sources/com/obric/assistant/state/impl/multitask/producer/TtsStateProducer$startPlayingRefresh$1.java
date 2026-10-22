package com.obric.assistant.state.impl.multitask.producer;

import aha.e0;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.state.multitask.ext.TaskFlowDslKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.state.impl.multitask.producer.TtsStateProducer$startPlayingRefresh$1", f = "TtsStateProducer.kt", i = {}, l = {211}, m = "invokeSuspend", n = {}, s = {})
final class TtsStateProducer$startPlayingRefresh$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ TtsStateProducer$a $activeTask;
    final /* synthetic */ String $taskKey;
    int label;
    final /* synthetic */ TtsStateProducer this$0;

    public TtsStateProducer$startPlayingRefresh$1(TtsStateProducer r1, String r2, TtsStateProducer$a r3, Continuation<? super TtsStateProducer$startPlayingRefresh$1> r4) {
        this.this$0 = r1;
        this.$taskKey = r2;
        this.$activeTask = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new TtsStateProducer$startPlayingRefresh$1(this.this$0, this.$taskKey, this.$activeTask, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0024 -> B:12:0x0027). Please report as a decompilation issue!!! */
    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r7);
        TtsStateProducer$startPlayingRefresh$1 r8 = this;
    L12:
        TtsStateProducer$a r2 = (TtsStateProducer$a) r8.this$0.b.get(r8.$taskKey);
        if (r2 != r8.$activeTask) goto L19;
        if ((r2.b instanceof e0.b) == false) goto L19;
        FLogger.a.i("TtsStateProducer", "refresh active TTS playing state, taskKey=" + r8.$taskKey);
        TaskFlowDslKt.f(r2.a, r2.b);
    L9:
        r8.label = 1;
        if (DelayKt.delay(5000, r8) != r0) goto L12;
        return r0;
    L19:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r7);
        r8 = this;
        goto L9
    }
}
