package com.obric.assistant.live.strategy;

import com.larus.utils.logger.FLogger;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import pea.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.live.strategy.GRIslandStrategy$startTimer$1", f = "GRIslandStrategy.kt", i = {}, l = {361}, m = "invokeSuspend", n = {}, s = {})
public final class GRIslandStrategy$startTimer$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function0<Unit> $action;
    final /* synthetic */ boolean $checkComplexSession;
    final /* synthetic */ long $delayTime;
    int label;

    public GRIslandStrategy$startTimer$1(long r1, boolean r3, Function0<Unit> r4, Continuation<? super GRIslandStrategy$startTimer$1> r5) {
        this.$delayTime = r1;
        this.$checkComplexSession = r3;
        this.$action = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new GRIslandStrategy$startTimer$1(this.$delayTime, this.$checkComplexSession, this.$action, r8);
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
        GRIslandStrategy.h.set(true);
        if (this.$checkComplexSession == false) goto L18;
        AtomicReference<j> r7 = GRIslandStrategy.e.get("complex_task");
        if (r7 == null) goto L16;
        j r8 = r7.get();
    L17:
        if (r8 != null) goto L18;
    L19:
        FLogger.a.i("GRIslandStrategy", "startTimer, job is down");
        return Unit.INSTANCE;
    L16:
        r8 = null;
    L18:
        FLogger.a.i("GRIslandStrategy", "task is not stopped");
        this.$action.invoke();
        goto L19
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        long r3 = this.$delayTime;
        this.label = 1;
        if (DelayKt.delay(r3, this) != r0) goto L11;
        return r0;
    }
}
