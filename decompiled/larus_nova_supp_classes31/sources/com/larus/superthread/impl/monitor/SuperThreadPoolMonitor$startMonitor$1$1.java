package com.larus.superthread.impl.monitor;

import com.ss.android.ugc.bytex.pthread.base.convergence.executor.Instrumentation;
import com.tencent.open.log.TraceLevel;
import java.security.SecureRandom;
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
import px9.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.superthread.impl.monitor.SuperThreadPoolMonitor$startMonitor$1$1", f = "SuperThreadPoolMonitor.kt", i = {}, l = {78}, m = "invokeSuspend", n = {}, s = {})
public final class SuperThreadPoolMonitor$startMonitor$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Instrumentation $it;
    int label;

    public SuperThreadPoolMonitor$startMonitor$1$1(Instrumentation r1, Continuation<? super SuperThreadPoolMonitor$startMonitor$1$1> r2) {
        this.$it = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new SuperThreadPoolMonitor$startMonitor$1$1(this.$it, r3);
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
        int r9 = SuperThreadPoolMonitor.b;
        SuperThreadPoolMonitor.a(this.$it, SuperThreadPoolMonitor.d);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r8);
        long r3 = ((long) new SecureRandom().nextInt((int) SuperThreadPoolMonitor.d)) * 1000;
        int r10 = a.a;
        a.a("first delay: " + r3 + " ms");
        this.label = 1;
        if (DelayKt.delay(r3, this) != r0) goto L11;
        return r0;
    }
}
