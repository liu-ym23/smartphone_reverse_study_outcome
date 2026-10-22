package com.obric.livecard.api.impl;

import com.obric.livecard.api.IIslandService;
import com.obric.livecard.api.entity.IslandSession;
import com.obric.livecard.api.entity.IslandWidget;
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
@DebugMetadata(c = "com.obric.livecard.api.impl.IslandImpl$sendEvent$1", f = "IslandImpl.kt", i = {}, l = {91}, m = "invokeSuspend", n = {}, s = {})
public final class IslandImpl$sendEvent$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ String $eventId;
    final /* synthetic */ String $jsonString;
    final /* synthetic */ IslandSession $targetSession;
    final /* synthetic */ IslandWidget $targetWidget;
    int label;
    final /* synthetic */ IslandImpl this$0;

    public IslandImpl$sendEvent$1(IslandImpl r1, IslandSession r2, IslandWidget r3, String r4, String r5, Continuation<? super IslandImpl$sendEvent$1> r6) {
        this.this$0 = r1;
        this.$targetSession = r2;
        this.$targetWidget = r3;
        this.$eventId = r4;
        this.$jsonString = r5;
        super(1, r6);
    }

    public final Continuation<Unit> create(Continuation<?> r9) {
        return new IslandImpl$sendEvent$1(this.this$0, this.$targetSession, this.$targetWidget, this.$eventId, this.$jsonString, r9);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((Continuation) r1);
    }

    public final Object invoke(Continuation<? super Unit> r2) {
        return create(r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r5);
    L11:
        IIslandService r6 = (IIslandService) r5;
        if (r6 == null) goto L15;
        r6.sendEvent(this.$targetSession, this.$targetWidget, this.$eventId, this.$jsonString);
    L15:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        IslandImpl r7 = this.this$0;
        this.label = 1;
        r5 = r7.getService(this);
        if (r5 != r0) goto L11;
        return r0;
    }
}
