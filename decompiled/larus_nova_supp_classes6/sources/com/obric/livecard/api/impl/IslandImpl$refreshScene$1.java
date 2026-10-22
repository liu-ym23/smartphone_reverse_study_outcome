package com.obric.livecard.api.impl;

import com.obric.livecard.api.IIslandService;
import com.obric.livecard.api.entity.IslandSession;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0002\u0010\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.obric.livecard.api.impl.IslandImpl$refreshScene$1", f = "IslandImpl.kt", i = {}, l = {170}, m = "invokeSuspend", n = {}, s = {})
public final class IslandImpl$refreshScene$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ IslandSession $session;
    Object L$0;
    int label;
    final /* synthetic */ IslandImpl this$0;

    public IslandImpl$refreshScene$1(IslandImpl r1, IslandSession r2, Continuation<? super IslandImpl$refreshScene$1> r3) {
        this.this$0 = r1;
        this.$session = r2;
        super(1, r3);
    }

    public final Continuation<Unit> create(Continuation<?> r4) {
        return new IslandImpl$refreshScene$1(this.this$0, this.$session, r4);
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
        if (r1 == 0) goto L10;
        if (r1 != 1) goto L9;
        IslandSession r2 = (IslandSession) this.L$0;
        ResultKt.throwOnFailure(r5);     // Catch: Throwable -> L21
    L15:
        IIslandService r6 = (IIslandService) r5;     // Catch: Throwable -> L21
        if (r6 == null) goto L18;
        r6.refreshScene(r2);     // Catch: Throwable -> L21
        Unit r7 = Unit.INSTANCE;     // Catch: Throwable -> L21
    L19:
        Result.constructor-impl(r7);     // Catch: Throwable -> L21
    L24:
        return Unit.INSTANCE;
    L18:
        r7 = null;
        goto L19
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        ResultKt.throwOnFailure(r5);
        IslandImpl r8 = this.this$0;
        IslandSession r3 = this.$session;
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L21
        this.L$0 = r3;     // Catch: Throwable -> L21
        this.label = 1;     // Catch: Throwable -> L21
        r5 = r8.getService(this);     // Catch: Throwable -> L21
        if (r5 != r0) goto L14;
        return r0;
    L14:
        r2 = r3;
    L21:
        th = move-exception;
        Result.Companion r9 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L24
    }
}
