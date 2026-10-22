package com.obric.audio.continuous_talk.session.impl;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.audio.continuous_talk.session.impl.ObricContTalkMgrImpl$stopAsync$1", f = "ObricContTalkMgrImpl.kt", i = {}, l = {310}, m = "invokeSuspend", n = {}, s = {})
final class ObricContTalkMgrImpl$stopAsync$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<hia.a.d, Unit> $onResult;
    int label;
    final /* synthetic */ ObricContTalkMgrImpl this$0;

    /* JADX WARN: Multi-variable type inference failed */
    public ObricContTalkMgrImpl$stopAsync$1(ObricContTalkMgrImpl r1, Function1<? super hia.a.d, Unit> r2, Continuation<? super ObricContTalkMgrImpl$stopAsync$1> r3) {
        this.this$0 = r1;
        this.$onResult = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new ObricContTalkMgrImpl$stopAsync$1(this.this$0, this.$onResult, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r4);
    L13:
        this.$onResult.invoke(hia.a.d.b.a);
        com.larus.audio.call.util.e.a.i(this.this$0.v, "stopAsync result: SUCCESS Pending Finished");
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r4);
        Job r5 = this.this$0.G;
        if (r5 == null) goto L13;
        this.label = 1;
        if (r5.join(this) != r0) goto L13;
        return r0;
    }
}
