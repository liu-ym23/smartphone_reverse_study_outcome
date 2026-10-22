package com.obric.livecard.api.impl;

import com.obric.livecard.api.IIslandService;
import com.obric.livecard.api.entity.IslandSession;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0002\u0010\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.obric.livecard.api.impl.IslandImpl$updateSessionFlags$2", f = "IslandImpl.kt", i = {}, l = {118}, m = "invokeSuspend", n = {}, s = {})
public final class IslandImpl$updateSessionFlags$2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ IslandSession $session;
    int label;
    final /* synthetic */ IslandImpl this$0;

    public IslandImpl$updateSessionFlags$2(IslandImpl r1, IslandSession r2, Continuation<? super IslandImpl$updateSessionFlags$2> r3) {
        this.this$0 = r1;
        this.$session = r2;
        super(1, r3);
    }

    public final Continuation<Unit> create(Continuation<?> r4) {
        return new IslandImpl$updateSessionFlags$2(this.this$0, this.$session, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((Continuation) r1);
    }

    public final Object invoke(Continuation<? super Unit> r2) {
        return create(r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r4);
    L11:
        IIslandService r5 = (IIslandService) r4;
        if (r5 == null) goto L15;
        r5.updateSessionFlags(this.$session);
    L15:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r4);
        IslandImpl r6 = this.this$0;
        this.label = 1;
        r4 = r6.getService(this);
        if (r4 != r0) goto L11;
        return r0;
    }
}
