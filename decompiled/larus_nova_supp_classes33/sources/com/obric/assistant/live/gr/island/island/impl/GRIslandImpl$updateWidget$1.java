package com.obric.assistant.live.gr.island.island.impl;

import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import pea.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.live.gr.island.island.impl.GRIslandImpl$updateWidget$1", f = "GRIslandImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class GRIslandImpl$updateWidget$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ j $targetSession;
    int label;
    final /* synthetic */ GRIslandImpl this$0;

    public GRIslandImpl$updateWidget$1(j r1, GRIslandImpl r2, Continuation<? super GRIslandImpl$updateWidget$1> r3) {
        this.$targetSession = r1;
        this.this$0 = r2;
        super(1, r3);
    }

    public final Continuation<Unit> create(Continuation<?> r4) {
        return new GRIslandImpl$updateWidget$1(this.$targetSession, this.this$0, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((Continuation) r1);
    }

    public final Object invoke(Continuation<? super Unit> r2) {
        return create(r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r4);
        FLogger.a.d("GRIslandImpl", "updateWidget()  taskId: " + this.$targetSession.g);
        GRIslandImpl.a(this.this$0, this.$targetSession, AppHost.a.getApplication().getApplicationContext());
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
