package com.obric.activeness.impl;

import com.larus.utils.logger.FLogger;
import com.obric.activeness.ObricActiveReason;
import com.obric.aivoice.core.data.NameKeys;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.activeness.impl.ObricActivenessMonitorServiceImpl$setActiveState$1$1", f = "ObricAssistantActivenessMonitorServiceImpl.kt", i = {}, l = {382}, m = "invokeSuspend", n = {}, s = {})
public final class ObricActivenessMonitorServiceImpl$setActiveState$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $normalizedTimeout;
    final /* synthetic */ ObricActiveReason $reason;
    final /* synthetic */ Ref.ObjectRef<Job> $timeoutJob;
    int label;
    final /* synthetic */ ObricActivenessMonitorServiceImpl this$0;

    public ObricActivenessMonitorServiceImpl$setActiveState$1$1(long r1, ObricActivenessMonitorServiceImpl r3, ObricActiveReason r4, Ref.ObjectRef<Job> r5, Continuation<? super ObricActivenessMonitorServiceImpl$setActiveState$1$1> r6) {
        this.$normalizedTimeout = r1;
        this.this$0 = r3;
        this.$reason = r4;
        this.$timeoutJob = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        return new ObricActivenessMonitorServiceImpl$setActiveState$1$1(this.$normalizedTimeout, this.this$0, this.$reason, this.$timeoutJob, r9);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r8);
    L11:
        Ref.BooleanRef r9 = new Ref.BooleanRef();
        ObricActivenessMonitorServiceImpl r2 = this.this$0;
        Object r3 = r2.v;
        ObricActiveReason r4 = this.$reason;
        Ref.ObjectRef<Job> r5 = this.$timeoutJob;
        monitor-enter(r3);
        boolean r6 = Intrinsics.areEqual(((LinkedHashMap) r2.s).get(r4), Boxing.boxBoolean(true));     // Catch: Throwable -> L24
        if (((LinkedHashMap) r2.t).get(r4) != r5.element) goto L17;
        if (r6 == false) goto L17;
        r2.s.remove(r4);     // Catch: Throwable -> L24
        r2.t.remove(r4);     // Catch: Throwable -> L24
        r9.element = true;     // Catch: Throwable -> L24
    L17:
        Unit r7 = Unit.INSTANCE;     // Catch: Throwable -> L24
        monitor-exit(r3);
        if (r9.element == false) goto L23;
        FLogger.a.i("ObricActivenessMonitor", "setActiveState timeout release, reason=" + this.$reason);
        this.this$0.h(this.$reason);
    L23:
        return Unit.INSTANCE;
    L24:
        th = move-exception;
        throw th;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r8);
        long r10 = this.$normalizedTimeout;
        this.label = 1;
        if (DelayKt.delay(r10, this) != r0) goto L11;
        return r0;
    }
}
