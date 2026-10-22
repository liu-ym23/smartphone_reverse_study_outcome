package com.larus.dora.impl.serviceimpl;

import com.larus.utils.logger.FLogger;
import kj4.a;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.serviceimpl.SessionService$updateVUIStateAsync$2", f = "SessionService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class SessionService$updateVUIStateAsync$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Integer>, Object> {
    final /* synthetic */ int $state;
    int label;
    final /* synthetic */ SessionService this$0;

    public SessionService$updateVUIStateAsync$2(SessionService r1, int r2, Continuation<? super SessionService$updateVUIStateAsync$2> r3) {
        this.this$0 = r1;
        this.$state = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new SessionService$updateVUIStateAsync$2(this.this$0, this.$state, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Integer> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r4);
        SessionService r5 = this.this$0;
        int r0 = this.$state;
        r5.getClass();
        FLogger.a.i("DoraOTA", "updateVUIState>>>> state is " + r0);
        return Boxing.boxInt(a.g().updateVUIState(r0));
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
