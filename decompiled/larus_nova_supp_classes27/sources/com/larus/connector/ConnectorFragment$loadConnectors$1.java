package com.larus.connector;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.connector.ConnectorFragment$loadConnectors$1", f = "ConnectorFragment.kt", i = {}, l = {355}, m = "invokeSuspend", n = {}, s = {})
public final class ConnectorFragment$loadConnectors$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ ConnectorFragment this$0;

    public ConnectorFragment$loadConnectors$1(ConnectorFragment r1, Continuation<? super ConnectorFragment$loadConnectors$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new ConnectorFragment$loadConnectors$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        boolean r3 = true;
        if (r1 == 0) goto L9;
        if (r1 != 1) goto L8;
        ResultKt.throwOnFailure(r5);     // Catch: Throwable -> L22
    L13:
        p.a r6 = (p) r5;     // Catch: Throwable -> L22
        if ((r6 instanceof p.c) == false) goto L16;
    L29:
        this.this$0.j = false;
        return Unit.INSTANCE;
    L16:
        if ((r6 instanceof p.a) == false) goto L25;
        ConnectorFragment r2 = this.this$0;     // Catch: Throwable -> L22
        String r7 = r6.a;     // Catch: Throwable -> L22
        r2.q.getClass();     // Catch: Throwable -> L22
        if (ConnectorListRepository.b() != null) goto L21;
        r3 = false;
    L21:
        ConnectorFragment.W90(r2, r7, r3);     // Catch: Throwable -> L22
        goto L29
    L25:
        if (Intrinsics.areEqual(r6, p$b.a) == true) goto L29;
        throw new NoWhenBranchMatchedException();     // Catch: Throwable -> L22
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r5);
        ConnectorListRepository r8 = this.this$0.q;     // Catch: Throwable -> L22
        this.label = 1;     // Catch: Throwable -> L22
        r5 = r8.e("connectorPage", this);     // Catch: Throwable -> L22
        if (r5 != r0) goto L13;
        return r0;
    L22:
        th = move-exception;
        this.this$0.j = false;
        throw th;
    }
}
