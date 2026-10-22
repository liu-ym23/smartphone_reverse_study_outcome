package com.obric.assistant.state.impl.v2.core;

import cha.b;
import com.obric.assistant.state.api.v2.core.bean.ObricNetworkKeepAliveLockState;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.state.impl.v2.core.ObricStateDispatcher$onNetworkKeepAliveLockStateChanged$1", f = "ObricStateDispatcher.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ObricStateDispatcher$onNetworkKeepAliveLockStateChanged$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ObricNetworkKeepAliveLockState $state;
    int label;

    public ObricStateDispatcher$onNetworkKeepAliveLockStateChanged$1(ObricNetworkKeepAliveLockState r1, Continuation<? super ObricStateDispatcher$onNetworkKeepAliveLockStateChanged$1> r2) {
        this.$state = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new ObricStateDispatcher$onNetworkKeepAliveLockStateChanged$1(this.$state, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r3) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L11;
        ResultKt.throwOnFailure(r3);
        CopyOnWriteArraySet r4 = ObricStateDispatcher.d;
        ObricNetworkKeepAliveLockState r0 = this.$state;
        Iterator r5 = r4.iterator();
    L6:
        if (r5.hasNext() == false) goto L9;
        ((b) r5.next()).d(r0);
        goto L6
    L9:
        return Unit.INSTANCE;
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
