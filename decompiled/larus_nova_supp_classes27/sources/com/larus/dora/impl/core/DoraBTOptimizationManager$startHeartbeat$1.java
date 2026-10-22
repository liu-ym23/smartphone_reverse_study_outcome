package com.larus.dora.impl.core;

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
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.core.DoraBTOptimizationManager$startHeartbeat$1", f = "DoraBTOptimizationManager.kt", i = {0}, l = {563}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
final class DoraBTOptimizationManager$startHeartbeat$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $intervalMs;
    private /* synthetic */ Object L$0;
    int label;

    public DoraBTOptimizationManager$startHeartbeat$1(long r1, Continuation<? super DoraBTOptimizationManager$startHeartbeat$1> r3) {
        this.$intervalMs = r1;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        DoraBTOptimizationManager$startHeartbeat$1 r0 = new DoraBTOptimizationManager$startHeartbeat$1(this.$intervalMs, r5);
        r0.L$0 = r4;
        return r0;
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
        CoroutineScope r2 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r7);
    L10:
        if (CoroutineScopeKt.isActive(r2) == false) goto L19;
        DoraBTOptimizationManager r8 = DoraBTOptimizationManager.a;     // Catch: Exception -> L13
        DoraBTOptimizationManager.a().c.d.g(4, 10, new byte[]{2, 1, 0});     // Catch: Exception -> L13
    L15:
        long r3 = this.$intervalMs;
        this.L$0 = r2;
        this.label = 1;
        if (DelayKt.delay(r3, this) != r0) goto L10;
        return r0;
    L13:
        e = move-exception;
        g49.d.c("DoraBTOptimizationManager", "sendHeartbeatPacket error", e);
        goto L15
    L19:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r7);
        r2 = (CoroutineScope) this.L$0;
        goto L10
    }
}
