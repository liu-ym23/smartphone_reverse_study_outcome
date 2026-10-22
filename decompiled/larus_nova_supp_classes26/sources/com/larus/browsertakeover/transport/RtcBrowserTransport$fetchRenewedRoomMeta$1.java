package com.larus.browsertakeover.transport;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.browsertakeover.transport.RtcBrowserTransport", f = "RtcBrowserTransport.kt", i = {0, 0, 0, 0, 1, 1, 1}, l = {488, 502}, m = "fetchRenewedRoomMeta", n = {"current", "sessionId", "deadline", "index", "current", "sessionId", "deadline"}, s = {"L$0", "L$1", "J$0", "I$2", "L$0", "L$1", "J$0"})
public final class RtcBrowserTransport$fetchRenewedRoomMeta$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    int I$2;
    long J$0;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ RtcBrowserTransport this$0;

    public RtcBrowserTransport$fetchRenewedRoomMeta$1(RtcBrowserTransport r1, Continuation<? super RtcBrowserTransport$fetchRenewedRoomMeta$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r7) {
        this.result = r7;
        this.label |= Integer.MIN_VALUE;
        RtcBrowserTransport r0 = this.this$0;
        int r8 = RtcBrowserTransport.o;
        return r0.k(null, null, 0, this);
    }
}
