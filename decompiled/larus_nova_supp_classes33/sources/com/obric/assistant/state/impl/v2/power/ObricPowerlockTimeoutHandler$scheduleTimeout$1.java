package com.obric.assistant.state.impl.v2.power;

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
import kotlinx.coroutines.sync.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.state.impl.v2.power.ObricPowerlockTimeoutHandler$scheduleTimeout$1", f = "ObricPowerlockTimeoutHandler.kt", i = {0, 0}, l = {80}, m = "invokeSuspend", n = {"$this$launch", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1"})
public final class ObricPowerlockTimeoutHandler$scheduleTimeout$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ ObricPowerlockTimeoutHandler this$0;

    public ObricPowerlockTimeoutHandler$scheduleTimeout$1(ObricPowerlockTimeoutHandler r1, Continuation<? super ObricPowerlockTimeoutHandler$scheduleTimeout$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        ObricPowerlockTimeoutHandler$scheduleTimeout$1 r0 = new ObricPowerlockTimeoutHandler$scheduleTimeout$1(this.this$0, r4);
        r0.L$0 = r3;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r11) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ObricPowerlockTimeoutHandler r2 = (ObricPowerlockTimeoutHandler) this.L$2;
        a r3 = (a) this.L$1;
        CoroutineScope r4 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r11);
    L21:
        Job r12 = r2.f;     // Catch: Throwable -> L18
        if (r12 == null) goto L15;
        Job.DefaultImpls.cancel$default(r12, null, 1, null);     // Catch: Throwable -> L18
    L15:
        r2.f = BuildersKt.launch$default(r4, null, null, new ObricPowerlockTimeoutHandler$scheduleTimeout$1$1$1(r2, null), 3, null);     // Catch: Throwable -> L18
        Unit r13 = Unit.INSTANCE;     // Catch: Throwable -> L18
        r3.unlock(null);
        return Unit.INSTANCE;
    L18:
        th = move-exception;
        r3.unlock(null);
        throw th;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r11);
        r4 = (CoroutineScope) this.L$0;
        ObricPowerlockTimeoutHandler r14 = this.this$0;
        r3 = r14.e;
        this.L$0 = r4;
        this.L$1 = r3;
        this.L$2 = r14;
        this.label = 1;
        if (r3.a(null, this) != r0) goto L11;
        return r0;
    L11:
        r2 = r14;
        goto L21
    }
}
