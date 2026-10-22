package com.obric.assistant.state.impl.v2.power;

import com.larus.utils.logger.FLogger;
import com.obric.assistant.state.impl.v2.utils.CoroutineExtKt;
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
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.state.impl.v2.power.ObricPowerlockTimeoutHandler$scheduleTimeout$1$1$1", f = "ObricPowerlockTimeoutHandler.kt", i = {0, 0}, l = {60}, m = "invokeSuspend", n = {"$this$launch", "currentTimeoutJob"}, s = {"L$0", "L$1"})
public final class ObricPowerlockTimeoutHandler$scheduleTimeout$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ ObricPowerlockTimeoutHandler this$0;

    public ObricPowerlockTimeoutHandler$scheduleTimeout$1$1$1(ObricPowerlockTimeoutHandler r1, Continuation<? super ObricPowerlockTimeoutHandler$scheduleTimeout$1$1$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        ObricPowerlockTimeoutHandler$scheduleTimeout$1$1$1 r0 = new ObricPowerlockTimeoutHandler$scheduleTimeout$1$1$1(this.this$0, r4);
        r0.L$0 = r3;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L12;
        if (r2 != 1) goto L11;
        Job r3 = (Job) this.L$1;
        CoroutineScope r4 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r8);     // Catch: Throwable -> L8
    L18:
        if (CoroutineScopeKt.isActive(r4) == false) goto L20;
        FLogger.a.i(this.this$0.c, "timeout reached after " + this.this$0.a + "ms");     // Catch: Throwable -> L8
        this.this$0.b.invoke();     // Catch: Throwable -> L8
    L20:
        ObricPowerlockTimeoutHandler r9 = this.this$0;
        if (r9.f != r3) goto L24;
        r9.f = null;
    L24:
        return Unit.INSTANCE;
    L8:
        Throwable th = th;
    L27:
        ObricPowerlockTimeoutHandler r0 = this.this$0;
        if (r0.f != r3) goto L30;
        r0.f = null;
    L30:
        throw th;
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L12:
        ResultKt.throwOnFailure(r8);
        r4 = (CoroutineScope) this.L$0;
        Job r10 = r4.getCoroutineContext().get(Job.Key);
        long r5 = this.this$0.a;     // Catch: Throwable -> L25
        this.L$0 = r4;     // Catch: Throwable -> L25
        this.L$1 = r10;     // Catch: Throwable -> L25
        this.label = 1;     // Catch: Throwable -> L25
        if (CoroutineExtKt.a(r5, this) != r1) goto L16;
        return r1;
    L16:
        r3 = r10;
    L25:
        th = move-exception;
        r3 = r10;
        th = th;
        goto L27
    }
}
