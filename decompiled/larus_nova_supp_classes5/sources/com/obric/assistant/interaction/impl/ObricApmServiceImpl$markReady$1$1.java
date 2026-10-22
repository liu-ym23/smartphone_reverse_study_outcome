package com.obric.assistant.interaction.impl;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.sync.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.interaction.impl.ObricApmServiceImpl$markReady$1$1", f = "ObricApmServiceImpl.kt", i = {1}, l = {40, 90}, m = "invokeSuspend", n = {"$this$withLock_u24default$iv"}, s = {"L$0"})
public final class ObricApmServiceImpl$markReady$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ ObricApmServiceImpl this$0;

    public ObricApmServiceImpl$markReady$1$1(ObricApmServiceImpl r1, Continuation<? super ObricApmServiceImpl$markReady$1$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new ObricApmServiceImpl$markReady$1$1(this.this$0, r3);
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
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ObricApmServiceImpl r2 = (ObricApmServiceImpl) this.L$1;
        a r3 = (a) this.L$0;
        ResultKt.throwOnFailure(r8);
    L27:
        ObricApmServiceImpl.access$isReady$p(r2).set(true);     // Catch: Throwable -> L24
        Iterator r9 = ObricApmServiceImpl.access$getPendingSlardarEvents$p(r2).iterator();     // Catch: Throwable -> L24
    L19:
        if (r9.hasNext() == false) goto L21;
        ObricApmServiceImpl.SlardarEventParams r4 = (ObricApmServiceImpl.SlardarEventParams) r9.next();     // Catch: Throwable -> L24
        ObricApmServiceImpl.access$reportEventForSlardar(r2, r4.getEvent(), r4.getCategory(), r4.getMetric(), r4.getExtraLog());     // Catch: Throwable -> L24
        goto L19
    L21:
        ObricApmServiceImpl.access$getPendingSlardarEvents$p(r2).clear();     // Catch: Throwable -> L24
        Unit r10 = Unit.INSTANCE;     // Catch: Throwable -> L24
        r3.unlock(null);
        return Unit.INSTANCE;
    L24:
        th = move-exception;
        r3.unlock(null);
        throw th;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r8);
    L13:
        r3 = ObricApmServiceImpl.access$getLock$p(this.this$0);
        ObricApmServiceImpl r11 = this.this$0;
        this.L$0 = r3;
        this.L$1 = r11;
        this.label = 2;
        if (r3.a(null, this) != r0) goto L16;
        return r0;
    L16:
        r2 = r11;
        goto L27
    L10:
        ResultKt.throwOnFailure(r8);
        this.label = 1;
        if (DelayKt.delay(1000, this) != r0) goto L13;
        return r0;
    }
}
