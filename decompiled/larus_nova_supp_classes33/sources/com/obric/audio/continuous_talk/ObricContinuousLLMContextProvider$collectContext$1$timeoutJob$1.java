package com.obric.audio.continuous_talk;

import com.larus.utils.logger.FLogger;
import java.util.HashMap;
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
import kotlinx.coroutines.channels.SendChannel;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.audio.continuous_talk.ObricContinuousLLMContextProvider$collectContext$1$timeoutJob$1", f = "ObricContinuousLLMContextProvider.kt", i = {}, l = {89}, m = "invokeSuspend", n = {}, s = {})
public final class ObricContinuousLLMContextProvider$collectContext$1$timeoutJob$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ kotlinx.coroutines.channels.k<hia.a.c> $$this$callbackFlow;
    final /* synthetic */ HashMap<String, String> $actualMap;
    final /* synthetic */ long $roundId;
    int label;
    final /* synthetic */ i this$0;

    /* JADX WARN: Multi-variable type inference failed */
    public ObricContinuousLLMContextProvider$collectContext$1$timeoutJob$1(i r1, long r2, kotlinx.coroutines.channels.k<? super hia.a.c> r4, HashMap<String, String> r5, Continuation<? super ObricContinuousLLMContextProvider$collectContext$1$timeoutJob$1> r6) {
        this.this$0 = r1;
        this.$roundId = r2;
        this.$$this$callbackFlow = r4;
        this.$actualMap = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        return new ObricContinuousLLMContextProvider$collectContext$1$timeoutJob$1(this.this$0, this.$roundId, this.$$this$callbackFlow, this.$actualMap, r9);
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
        FLogger r7 = FLogger.a;
        this.this$0.getClass();
        this.this$0.getClass();
        r7.w("ObricContinuousLLMContextProvider", "collectContext timeout : roundId=" + this.$roundId + ", timeout=5000ms");
        this.$$this$callbackFlow.trySend-JP2dKIU(new hia.a.c(this.$actualMap, true));
        SendChannel.a.a(this.$$this$callbackFlow);
        this.this$0.c.set(false);
        this.this$0.a = null;
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        this.this$0.getClass();
        this.label = 1;
        if (DelayKt.delay(5000, this) != r0) goto L11;
        return r0;
    }
}
