package com.obric.livecard.api.impl;

import com.obric.livecard.api.IslandCardCallback;
import com.obric.livecard.api.entity.IslandSession;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.sync.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.obric.livecard.api.impl.IslandImpl$onServiceDied$1", f = "IslandImpl.kt", i = {0}, l = {359}, m = "invokeSuspend", n = {"$this$withLock$iv"}, s = {"L$0"})
public final class IslandImpl$onServiceDied$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ IslandImpl this$0;

    public IslandImpl$onServiceDied$1(IslandImpl r1, Continuation<? super IslandImpl$onServiceDied$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new IslandImpl$onServiceDied$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        IslandImpl r2 = (IslandImpl) this.L$1;
        a r3 = (a) this.L$0;
        ResultKt.throwOnFailure(r8);
    L28:
        Iterator r9 = r2.getMSessionMap().entrySet().iterator();     // Catch: Throwable -> L25
    L14:
        if (r9.hasNext() == false) goto L18;
        Map.Entry r4 = (Map.Entry) r9.next();     // Catch: Throwable -> L25
        IslandCardCallback r5 = ((IslandSession) r4.getKey()).getCallback();     // Catch: Throwable -> L25
        if (r5 == null) goto L14;
        r5.onSessionDestroy((IslandSession) r4.getKey(), Boxing.boxInt(1));     // Catch: Throwable -> L25
        goto L14
    L18:
        r2.getMSessionMap().clear();     // Catch: Throwable -> L25
        Unit r10 = Unit.INSTANCE;     // Catch: Throwable -> L25
        r3.unlock(null);
        Iterator r11 = IslandImpl.access$getLiveCardServiceDiedListeners$p(this.this$0).iterator();
    L21:
        if (r11.hasNext() == false) goto L23;
        ((TopSessionChangedCallbackImpl) r11.next()).onServiceDied();
        goto L21
    L23:
        IslandImpl.access$getLiveCardServiceDiedListeners$p(this.this$0).clear();
        return Unit.INSTANCE;
    L25:
        th = move-exception;
        r3.unlock(null);
        throw th;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r8);
        r3 = IslandImpl.access$getSessionLock$p(this.this$0);
        IslandImpl r12 = this.this$0;
        this.L$0 = r3;
        this.L$1 = r12;
        this.label = 1;
        if (r3.a(null, this) != r0) goto L11;
        return r0;
    L11:
        r2 = r12;
        goto L28
    }
}
