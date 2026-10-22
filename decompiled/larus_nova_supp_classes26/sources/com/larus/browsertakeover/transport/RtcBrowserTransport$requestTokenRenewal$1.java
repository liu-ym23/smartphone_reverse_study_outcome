package com.larus.browsertakeover.transport;

import com.larus.im.internal.jni.bean.RoomMeta;
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
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.browsertakeover.transport.RtcBrowserTransport$requestTokenRenewal$1", f = "RtcBrowserTransport.kt", i = {}, l = {429}, m = "invokeSuspend", n = {}, s = {})
final class RtcBrowserTransport$requestTokenRenewal$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ RtcBrowserTransport.b $current;
    final /* synthetic */ long $deadline;
    final /* synthetic */ RoomMeta $previous;
    final /* synthetic */ id9.e $session;
    int label;
    final /* synthetic */ RtcBrowserTransport this$0;

    public RtcBrowserTransport$requestTokenRenewal$1(RtcBrowserTransport r1, RtcBrowserTransport.b r2, id9.e r3, RoomMeta r4, long r5, Continuation<? super RtcBrowserTransport$requestTokenRenewal$1> r7) {
        this.this$0 = r1;
        this.$current = r2;
        this.$session = r3;
        this.$previous = r4;
        this.$deadline = r5;
        super(2, r7);
    }

    public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
        return new RtcBrowserTransport$requestTokenRenewal$1(this.this$0, this.$current, this.$session, this.$previous, this.$deadline, r10);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r9) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r9);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r9);
        RtcBrowserTransport r2 = this.this$0;
        RtcBrowserTransport.b r10 = this.$current;
        id9.e r3 = this.$session;
        RoomMeta r4 = this.$previous;
        long r5 = this.$deadline;
        this.label = 1;
        if (RtcBrowserTransport.e(r2, r10, r3, r4, r5, this) != r0) goto L12;
        return r0;
    }
}
