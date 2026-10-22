package com.larus.browsertakeover.transport;

import android.os.Handler;
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
import kotlinx.coroutines.channels.ChannelIterator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.browsertakeover.transport.RtcBrowserTransport$Lease$startReaders$1", f = "RtcBrowserTransport.kt", i = {}, l = {276}, m = "invokeSuspend", n = {}, s = {})
final class RtcBrowserTransport$Lease$startReaders$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ RtcBrowserTransport.b this$0;
    final /* synthetic */ RtcBrowserTransport this$1;

    public RtcBrowserTransport$Lease$startReaders$1(RtcBrowserTransport.b r1, RtcBrowserTransport r2, Continuation<? super RtcBrowserTransport$Lease$startReaders$1> r3) {
        this.this$0 = r1;
        this.this$1 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new RtcBrowserTransport$Lease$startReaders$1(this.this$0, this.this$1, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0034 -> B:12:0x0037). Please report as a decompilation issue!!! */
    public final Object invokeSuspend(Object r22) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L8;
        if (r2 != 1) goto L7;
        ChannelIterator r3 = (ChannelIterator) this.L$0;
        ResultKt.throwOnFailure(r22);
        Object r5 = r22;
        RtcBrowserTransport$Lease$startReaders$1 r4 = this;
    L13:
        if (((Boolean) r5).booleanValue() == false) goto L52;
        RtcBrowserTransport.c r6 = (RtcBrowserTransport.c) r3.next();
        c0 r7 = c0.a;     // Catch: Throwable -> L48
        byte[] r8 = r6.a;     // Catch: Throwable -> L48
        r7.getClass();     // Catch: Throwable -> L48
        String r9 = c0.a(r8);     // Catch: Throwable -> L48
        if (r9 != null) goto L18;
        RtcBrowserTransport.o(r4.this$1, r4.this$0.a, "rts_decode_rejected", "bytes=" + r6.a.length, false, 8);     // Catch: Throwable -> L48
        final RtcBrowserTransport r10 = r4.this$1;     // Catch: Throwable -> L48
        Handler r11 = r10.g;     // Catch: Throwable -> L48
        final RtcBrowserTransport.b r12 = r4.this$0;     // Catch: Throwable -> L48
        Boxing.boxBoolean(r11.post(new a0(r10, r12)));     // Catch: Throwable -> L48
    L44:
        r6.a(r4.this$0.u);
    L9:
        r4.L$0 = r3;
        r4.label = 1;
        r5 = r3.hasNext(r4);
        if (r5 != r0) goto L13;
        return r0;
    L18:
        f.a.getClass();     // Catch: Throwable -> L48
        boolean r13 = false;
        if (f.a(r9) == true) goto L30;
        long r14 = r4.this$0.g.incrementAndGet();     // Catch: Throwable -> L48
        if (r14 != 1) goto L23;
    L24:
        RtcBrowserTransport r15 = r4.this$1;     // Catch: Throwable -> L48
        long r16 = r4.this$0.a;     // Catch: Throwable -> L48
        String r19 = "count=" + r14;     // Catch: Throwable -> L48
        if (r14 == 1) goto L27;
        boolean r20 = true;
    L28:
        int r17 = RtcBrowserTransport.o;     // Catch: Throwable -> L48
        r15.n(r16, "rts_data_filtered", r19, r20);     // Catch: Throwable -> L48
    L29:
        Unit r18 = Unit.INSTANCE;     // Catch: Throwable -> L48
        goto L44
    L27:
        r20 = false;
        goto L28
    L23:
        if ((r14 % 30) != 0) goto L29;
    L30:
        RtcBrowserTransport r21 = r4.this$1;     // Catch: Throwable -> L48
        RtcBrowserTransport.b r23 = r4.this$0;     // Catch: Throwable -> L48
        Object r110 = r21.h;     // Catch: Throwable -> L48
        monitor-enter(r110);     // Catch: Throwable -> L48
        BrowserTransport.a r111 = r21.m;     // Catch: Throwable -> L45
        if (r21.k == false) goto L35;
    L42:
        monitor-exit(r110);     // Catch: Throwable -> L48
        Boxing.boxBoolean(r13);     // Catch: Throwable -> L48
        goto L44
    L35:
        if (r21.j != r23.a) goto L42;
        if (r21.n != r23) goto L42;
        if (r111 == null) goto L42;
        r23.h.incrementAndGet();     // Catch: Throwable -> L45
        r111.onMessage(r9);     // Catch: Throwable -> L45
        r13 = true;
        goto L42
    L45:
        th = move-exception;
        throw th;     // Catch: Throwable -> L48
    L48:
        th = move-exception;
        r6.a(r4.this$0.u);
        throw th;
    L52:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r22);
        r3 = this.this$0.v.iterator();
        r4 = this;
        goto L9
    }
}
