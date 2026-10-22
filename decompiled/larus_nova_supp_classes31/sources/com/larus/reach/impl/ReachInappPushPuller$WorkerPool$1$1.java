package com.larus.reach.impl;

import com.larus.utils.logger.FLogger;
import com.tencent.open.log.TraceLevel;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.ChannelIterator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.reach.impl.ReachInappPushPuller$WorkerPool$1$1", f = "ReachInappPushPuller.kt", i = {1}, l = {186, 188}, m = "invokeSuspend", n = {"task"}, s = {"L$1"})
public final class ReachInappPushPuller$WorkerPool$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ ReachInappPushPuller$WorkerPool this$0;
    final /* synthetic */ ReachInappPushPuller this$1;

    public ReachInappPushPuller$WorkerPool$1$1(ReachInappPushPuller$WorkerPool r1, ReachInappPushPuller r2, Continuation<? super ReachInappPushPuller$WorkerPool$1$1> r3) {
        this.this$0 = r1;
        this.this$1 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new ReachInappPushPuller$WorkerPool$1$1(this.this$0, this.this$1, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x006b -> B:9:0x001a). Please report as a decompilation issue!!! */
    public final Object invokeSuspend(Object r11) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L17;
        if (r1 == 1) goto L16;
        if (r1 != 2) goto L15;
        ReachInappPushPuller$b r2 = (ReachInappPushPuller$b) this.L$1;
        ChannelIterator r4 = (ChannelIterator) this.L$0;
        ResultKt.throwOnFailure(r11);     // Catch: Exception -> L10 CancellationException -> L12
        ReachInappPushPuller$WorkerPool$1$1 r3 = this;
    L9:
        ChannelIterator r12 = r4;
    L18:
        r3.L$0 = r12;
        r3.L$1 = null;
        r3.label = 1;
        Object r5 = r12.hasNext(r3);
        if (r5 != r0) goto L21;
        return r0;
    L21:
        r4 = r12;
        r11 = r5;
    L23:
        if (((Boolean) r11).booleanValue() == false) goto L33;
        ReachInappPushPuller$b r13 = (ReachInappPushPuller$b) r4.next();
        ReachInappPushPuller r6 = r3.this$1;     // Catch: CancellationException -> L12 Exception -> L28
        r3.L$0 = r4;     // Catch: CancellationException -> L12 Exception -> L28
        r3.L$1 = r13;     // Catch: CancellationException -> L12 Exception -> L28
        r3.label = 2;     // Catch: CancellationException -> L12 Exception -> L28
        if (ReachInappPushPuller.a(r6, r13, r3) != r0) goto L9;
        return r0;
    L28:
        e = move-exception;
        ReachInappPushPuller$WorkerPool$1$1 r9 = r3;
        FLogger.a.e("ReachInappPushPull", "inapp push pull aborted by unexpected error, scene=" + r13.a, e);
        r12 = r4;
        r3 = r9;
        goto L18
    L33:
        return Unit.INSTANCE;
    L12:
        e = move-exception;
        throw e;
    L10:
        e = move-exception;
        FLogger.a.e("ReachInappPushPull", "inapp push pull aborted by unexpected error, scene=" + r2.a, e);
        r12 = r4;
        r3 = this;
        goto L18
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ChannelIterator r7 = (ChannelIterator) this.L$0;
        ResultKt.throwOnFailure(r11);
        r4 = r7;
        r3 = this;
        goto L23
    L17:
        ResultKt.throwOnFailure(r11);
        r12 = this.this$0.b.iterator();
        r3 = this;
        goto L18
    }
}
