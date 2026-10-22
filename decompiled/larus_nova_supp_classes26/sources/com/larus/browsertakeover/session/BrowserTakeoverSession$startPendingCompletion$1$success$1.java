package com.larus.browsertakeover.session;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.browsertakeover.session.BrowserTakeoverSession$startPendingCompletion$1$success$1", f = "BrowserTakeoverSession.kt", i = {}, l = {295}, m = "invokeSuspend", n = {}, s = {})
public final class BrowserTakeoverSession$startPendingCompletion$1$success$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ com.larus.browsertakeover.entry.a.C0068a $current;
    int label;

    public BrowserTakeoverSession$startPendingCompletion$1$success$1(com.larus.browsertakeover.entry.a.C0068a r1, Continuation<? super BrowserTakeoverSession$startPendingCompletion$1$success$1> r2) {
        this.$current = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new BrowserTakeoverSession$startPendingCompletion$1$success$1(this.$current, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Boolean> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r4);
    L11:
        return r4;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r4);
        com.larus.browsertakeover.entry.a.C0068a r5 = this.$current;
        hv8.d r2 = r5.b;
        hv8.a r6 = r5.a;
        this.label = 1;
        r4 = r2.a(r6, this);
        if (r4 != r0) goto L11;
        return r0;
    }
}
