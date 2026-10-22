package com.obric.assistant.state.impl.multitask.producer;

import com.obric.assistant.state.api.multitask.state.ModeRefreshSource;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.state.impl.multitask.producer.InteractionModeStateProducer$refreshMode$1", f = "InteractionModeStateProducer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class InteractionModeStateProducer$refreshMode$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Map<String, Object> $ext;
    final /* synthetic */ String $sessionId;
    final /* synthetic */ ModeRefreshSource $source;
    final /* synthetic */ Long $timeoutMillis;
    int label;
    final /* synthetic */ InteractionModeStateProducer this$0;

    public InteractionModeStateProducer$refreshMode$1(InteractionModeStateProducer r1, String r2, Long r3, ModeRefreshSource r4, Map<String, ? extends Object> r5, Continuation<? super InteractionModeStateProducer$refreshMode$1> r6) {
        this.this$0 = r1;
        this.$sessionId = r2;
        this.$timeoutMillis = r3;
        this.$source = r4;
        this.$ext = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        return new InteractionModeStateProducer$refreshMode$1(this.this$0, this.$sessionId, this.$timeoutMillis, this.$source, this.$ext, r9);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L14;
        ResultKt.throwOnFailure(r5);
        Map r6 = this.this$0.d;
        LinkedHashMap r7 = (LinkedHashMap) r6;
        InteractionModeStateProducer$a r8 = (InteractionModeStateProducer$a) r7.get(this.$sessionId);
        if (r8 == null) goto L7;
        Long r0 = this.$timeoutMillis;
        if (r0 != null) goto L11;
        r0 = r8.c;
    L11:
        this.this$0.g(r8, this.$source, r0, this.$ext);
        return Unit.INSTANCE;
    L7:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
