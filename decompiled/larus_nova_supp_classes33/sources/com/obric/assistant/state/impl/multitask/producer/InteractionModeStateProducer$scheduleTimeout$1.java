package com.obric.assistant.state.impl.multitask.producer;

import com.larus.utils.logger.FLogger;
import com.obric.assistant.state.api.multitask.state.ModeEndReason;
import com.obric.assistant.state.impl.v2.utils.CoroutineExtKt;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.state.impl.multitask.producer.InteractionModeStateProducer$scheduleTimeout$1", f = "InteractionModeStateProducer.kt", i = {}, l = {252}, m = "invokeSuspend", n = {}, s = {})
public final class InteractionModeStateProducer$scheduleTimeout$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $sessionId;
    final /* synthetic */ Long $timeoutMillis;
    int label;
    final /* synthetic */ InteractionModeStateProducer this$0;

    public InteractionModeStateProducer$scheduleTimeout$1(Long r1, InteractionModeStateProducer r2, String r3, Continuation<? super InteractionModeStateProducer$scheduleTimeout$1> r4) {
        this.$timeoutMillis = r1;
        this.this$0 = r2;
        this.$sessionId = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new InteractionModeStateProducer$scheduleTimeout$1(this.$timeoutMillis, this.this$0, this.$sessionId, r5);
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
        ResultKt.throwOnFailure(r6);
    L11:
        InteractionModeStateProducer$a r7 = (InteractionModeStateProducer$a) ((LinkedHashMap) this.this$0.d).get(this.$sessionId);
        if (r7 == null) goto L14;
        FLogger.a.i("InteractionModeStateProducer", "mode timeout botId=" + r7.a.h + ", mode=" + r7.a.k + ", sessionId=" + this.$sessionId + ", timeoutMillis=" + this.$timeoutMillis);
    L14:
        this.this$0.f(this.$sessionId, ModeEndReason.TIMEOUT, MapsKt.mapOf(TuplesKt.to("timeout_millis", this.$timeoutMillis)));
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        long r3 = this.$timeoutMillis.longValue();
        this.label = 1;
        if (CoroutineExtKt.a(r3, this) != r0) goto L11;
        return r0;
    }
}
