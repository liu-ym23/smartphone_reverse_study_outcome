package com.obric.livecard.api.impl;

import com.obric.livecard.api.IIslandService;
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
@DebugMetadata(c = "com.obric.livecard.api.impl.IslandImpl$onLauncherFocused$1", f = "IslandImpl.kt", i = {}, l = {224}, m = "invokeSuspend", n = {}, s = {})
public final class IslandImpl$onLauncherFocused$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ IslandImpl this$0;

    public IslandImpl$onLauncherFocused$1(IslandImpl r1, Continuation<? super IslandImpl$onLauncherFocused$1> r2) {
        this.this$0 = r1;
        super(1, r2);
    }

    public final Continuation<Unit> create(Continuation<?> r3) {
        return new IslandImpl$onLauncherFocused$1(this.this$0, r3);
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
        if (r1 == 0) goto L9;
        if (r1 != 1) goto L8;
        ResultKt.throwOnFailure(r4);     // Catch: Throwable -> L19
    L13:
        IIslandService r5 = (IIslandService) r4;     // Catch: Throwable -> L19
        if (r5 == null) goto L16;
        r5.onLauncherFocused();     // Catch: Throwable -> L19
        Unit r6 = Unit.INSTANCE;     // Catch: Throwable -> L19
    L17:
        Result.constructor-impl(r6);     // Catch: Throwable -> L19
    L22:
        return Unit.INSTANCE;
    L16:
        r6 = null;
        goto L17
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r4);
        IslandImpl r7 = this.this$0;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L19
        this.label = 1;     // Catch: Throwable -> L19
        r4 = r7.getService(this);     // Catch: Throwable -> L19
        if (r4 != r0) goto L13;
        return r0;
    L19:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L22
    }
}
