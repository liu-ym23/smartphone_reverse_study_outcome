package com.obric.assistant.state.impl.v2.wakelock;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.state.impl.v2.wakelock.ObricWakelockTimeoutHandler$cancel$1", f = "ObricWakelockTimeoutHandler.kt", i = {0}, l = {80}, m = "invokeSuspend", n = {"$this$withLock_u24default$iv"}, s = {"L$0"})
final class ObricWakelockTimeoutHandler$cancel$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ ObricWakelockTimeoutHandler this$0;

    public ObricWakelockTimeoutHandler$cancel$1(ObricWakelockTimeoutHandler r1, Continuation<? super ObricWakelockTimeoutHandler$cancel$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new ObricWakelockTimeoutHandler$cancel$1(this.this$0, r3);
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
        ObricWakelockTimeoutHandler r2 = (ObricWakelockTimeoutHandler) this.L$1;
        kotlinx.coroutines.sync.a r3 = (kotlinx.coroutines.sync.a) this.L$0;
        ResultKt.throwOnFailure(r6);
    L21:
        Job r7 = r2.f;     // Catch: Throwable -> L18
        if (r7 == null) goto L15;
        Job.DefaultImpls.cancel$default(r7, null, 1, null);     // Catch: Throwable -> L18
    L15:
        r2.f = null;     // Catch: Throwable -> L18
        Unit r8 = Unit.INSTANCE;     // Catch: Throwable -> L18
        r3.unlock(null);
        return Unit.INSTANCE;
    L18:
        th = move-exception;
        r3.unlock(null);
        throw th;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        ObricWakelockTimeoutHandler r9 = this.this$0;
        r3 = r9.e;
        this.L$0 = r3;
        this.L$1 = r9;
        this.label = 1;
        if (r3.a(null, this) != r0) goto L11;
        return r0;
    L11:
        r2 = r9;
        goto L21
    }
}
