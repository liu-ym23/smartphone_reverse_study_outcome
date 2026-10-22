package com.larus.browsertakeover.transport;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.browsertakeover.transport.RtcBrowserTransport", f = "RtcBrowserTransport.kt", i = {0, 0, 0, 0}, l = {435}, m = "renewRoomToken", n = {"current", "session", "previous", "deadline"}, s = {"L$0", "L$1", "L$2", "J$0"})
final class RtcBrowserTransport$renewRoomToken$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ RtcBrowserTransport this$0;

    public RtcBrowserTransport$renewRoomToken$1(RtcBrowserTransport r1, Continuation<? super RtcBrowserTransport$renewRoomToken$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r8) {
        this.result = r8;
        this.label |= Integer.MIN_VALUE;
        return RtcBrowserTransport.e(this.this$0, null, null, null, 0, this);
    }
}
