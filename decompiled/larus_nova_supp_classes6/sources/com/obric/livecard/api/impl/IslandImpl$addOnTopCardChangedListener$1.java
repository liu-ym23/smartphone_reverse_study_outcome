package com.obric.livecard.api.impl;

import com.obric.livecard.api.IIslandService;
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
@DebugMetadata(c = "com.obric.livecard.api.impl.IslandImpl$addOnTopCardChangedListener$1", f = "IslandImpl.kt", i = {0}, l = {124}, m = "invokeSuspend", n = {"$this$invokeSuspend_u24lambda_u240"}, s = {"L$2"})
public final class IslandImpl$addOnTopCardChangedListener$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ OnTopCardChangedListener $callback;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ IslandImpl this$0;

    public IslandImpl$addOnTopCardChangedListener$1(OnTopCardChangedListener r1, IslandImpl r2, Continuation<? super IslandImpl$addOnTopCardChangedListener$1> r3) {
        this.$callback = r1;
        this.this$0 = r2;
        super(1, r3);
    }

    public final Continuation<Unit> create(Continuation<?> r4) {
        return new IslandImpl$addOnTopCardChangedListener$1(this.$callback, this.this$0, r4);
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
        TopSessionChangedCallbackImpl r2 = (TopSessionChangedCallbackImpl) this.L$2;
        IslandImpl r3 = (IslandImpl) this.L$1;
        TopSessionChangedCallbackImpl r5 = (TopSessionChangedCallbackImpl) this.L$0;
        ResultKt.throwOnFailure(r4);
    L12:
        IIslandService r6 = (IIslandService) r4;
        if (r6 == null) goto L15;
        r6.addOnTopCardChangedListener(r2);
    L15:
        IslandImpl.access$getLiveCardServiceDiedListeners$p(r3).add(r2);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r4);
        TopSessionChangedCallbackImpl r7 = new TopSessionChangedCallbackImpl(this.$callback);
        r3 = this.this$0;
        this.L$0 = r7;
        this.L$1 = r3;
        this.L$2 = r7;
        this.label = 1;
        Object r8 = r3.getService(this);
        if (r8 != r0) goto L11;
        return r0;
    L11:
        r2 = r7;
        r4 = r8;
        goto L12
    }
}
