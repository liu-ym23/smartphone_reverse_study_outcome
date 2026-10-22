package com.obric.aikernel.phx.core.conn;

import androidx.work.WorkRequest;
import com.obric.aikernel.core.log.AIKLog;
import java.util.concurrent.CancellationException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.r0;

/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(c = "com.obric.aikernel.phx.core.conn.ServiceConnector$getService$2$1$2", f = "ServiceConnector.kt", i = {0, 0}, l = {261}, m = "invokeSuspend", n = {"$this$launch", "connectTimeoutMs"}, s = {"L$0", "J$0"})
final class ServiceConnector$getService$2$1$2 extends SuspendLambda implements Function2<l0, Continuation<? super Unit>, Object> {
    final /* synthetic */ r0<com.obric.aikernel.a> $task;
    long J$0;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    ServiceConnector$getService$2$1$2(r0<? extends com.obric.aikernel.a> r10, Continuation<? super ServiceConnector$getService$2$1$2> r11) {
        this.$task = r10;
        super(2, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        ServiceConnector$getService$2$1$2 r12 = new ServiceConnector$getService$2$1$2(this.$task, r11);
        r12.L$0 = r10;
        return r12;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(l0 r10, Continuation<? super Unit> r11) {
        return invoke2(r10, r11);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(l0 r10, Continuation<? super Unit> r11) {
        return ((ServiceConnector$getService$2$1$2) create(r10, r11)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        Object r11 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r12 = this.label;
        boolean r13 = true;
        if (r12 == 0) goto L8;
        if (r12 != 1) goto L7;
        long r14 = this.J$0;
        l0 r15 = (l0) this.L$0;
        ResultKt.throwOnFailure(r10);
    L12:
        r0<com.obric.aikernel.a> r16 = this.$task;
        if (r16 != null) goto L15;
    L17:
        r13 = false;
    L18:
        r0<com.obric.aikernel.a> r17 = this.$task;
        Result.Companion r18 = Result.Companion;     // Catch: Throwable -> L25
        if (r13 == false) goto L23;
        if (r17 == null) goto L23;
        r17.c(new CancellationException("connectTask timeout by " + r14));     // Catch: Throwable -> L25
    L23:
        Object r19 = Result.m32constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L25
    L27:
        r0<com.obric.aikernel.a> r20 = this.$task;
        AIKLog.INSTANCE.i("ServiceConnector", "cancel active:" + r13 + ' ' + r20 + " success:" + Result.m39isSuccessimpl(r19) + " exception:" + Result.m35exceptionOrNullimpl(r19));
        return Unit.INSTANCE;
    L25:
        th = move-exception;
        Result.Companion r21 = Result.Companion;
        r19 = Result.m32constructorimpl(ResultKt.createFailure(th));
        goto L27
    L15:
        if (r16.isActive() != true) goto L17;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        this.L$0 = (l0) this.L$0;
        this.J$0 = WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS;
        this.label = 1;
        if (DelayKt.b(WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS, this) != r11) goto L11;
        return r11;
    L11:
        r14 = 30000;
        goto L12
    }
}
