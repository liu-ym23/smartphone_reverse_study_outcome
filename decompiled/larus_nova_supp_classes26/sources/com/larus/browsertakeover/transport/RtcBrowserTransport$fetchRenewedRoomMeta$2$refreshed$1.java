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
import kotlinx.coroutines.JobKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/larus/im/internal/jni/bean/RoomMeta;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.browsertakeover.transport.RtcBrowserTransport$fetchRenewedRoomMeta$2$refreshed$1", f = "RtcBrowserTransport.kt", i = {}, l = {489}, m = "invokeSuspend", n = {}, s = {})
public final class RtcBrowserTransport$fetchRenewedRoomMeta$2$refreshed$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super RoomMeta>, Object> {
    final /* synthetic */ String $sessionId;
    int label;
    final /* synthetic */ RtcBrowserTransport this$0;

    public RtcBrowserTransport$fetchRenewedRoomMeta$2$refreshed$1(RtcBrowserTransport r1, String r2, Continuation<? super RtcBrowserTransport$fetchRenewedRoomMeta$2$refreshed$1> r3) {
        this.this$0 = r1;
        this.$sessionId = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new RtcBrowserTransport$fetchRenewedRoomMeta$2$refreshed$1(this.this$0, this.$sessionId, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super RoomMeta> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r4);
    L11:
        RoomMeta r2 = (RoomMeta) r4;
        JobKt.ensureActive(getContext());
        return r4;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r4);
        Function2<String, Continuation<? super RoomMeta>, Object> r5 = this.this$0.c;
        String r3 = this.$sessionId;
        this.label = 1;
        r4 = r5.invoke(r3, this);
        if (r4 != r0) goto L11;
        return r0;
    }
}
