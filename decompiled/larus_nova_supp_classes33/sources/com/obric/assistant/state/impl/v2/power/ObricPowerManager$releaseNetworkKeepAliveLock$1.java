package com.obric.assistant.state.impl.v2.power;

import com.larus.utils.logger.FLogger;
import com.obric.assistant.state.api.v2.core.AssistantAliveReason;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.state.impl.v2.power.ObricPowerManager$releaseNetworkKeepAliveLock$1", f = "ObricPowerManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ObricPowerManager$releaseNetworkKeepAliveLock$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $delayMs;
    final /* synthetic */ AssistantAliveReason $reason;
    int label;

    public ObricPowerManager$releaseNetworkKeepAliveLock$1(AssistantAliveReason r1, long r2, Continuation<? super ObricPowerManager$releaseNetworkKeepAliveLock$1> r4) {
        this.$reason = r1;
        this.$delayMs = r2;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new ObricPowerManager$releaseNetworkKeepAliveLock$1(this.$reason, this.$delayMs, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r13) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L19;
        ResultKt.throwOnFailure(r13);
        int r14 = ObricPowerManager.b;
        ConcurrentHashMap r0 = ObricPowerManager.c;
        if (r0.containsKey(this.$reason) == false) goto L16;
        if (r14 <= 0) goto L16;
        r0.remove(this.$reason);
        ObricPowerManager.b--;
        FLogger r1 = FLogger.a;
        r1.i("[ObricPowerManager]", "lock=network action=release result=accepted reason=" + this.$reason + " countBefore=" + r14 + " countAfter=" + ObricPowerManager.b + " reasons=" + r0.keySet());
        if (ObricPowerManager.b != 0) goto L15;
        CoroutineScope r15 = ObricPowerManager.a;
        AssistantAliveReason r16 = this.$reason;
        long r4 = this.$delayMs;
        Job r2 = ObricPowerManager.i;
        if (r2 == null) goto L13;
        Job.DefaultImpls.cancel$default(r2, null, 1, null);
    L13:
        r1.i("[ObricPowerManager]", "lock=network action=schedule_release reason=" + r16 + " delayMs=" + r4);
        ObricPowerManager.i = BuildersKt.launch$default(ObricPowerManager.a, null, null, new ObricPowerManager$scheduleNetworkKeepAliveLockRelease$1(r4, r16, null), 3, null);
    L15:
        return Unit.INSTANCE;
    L16:
        FLogger.a.i("[ObricPowerManager]", "lock=network action=release result=ignored_missing reason=" + this.$reason + " count=" + r14 + " reasons=" + r0.keySet());
        return Unit.INSTANCE;
    L19:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
