package com.larus.suggest.impl.wcb.request;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.suggest.impl.wcb.request.WcbNetworkRequester", f = "WcbNetworkRequester.kt", i = {0}, l = {80}, m = "fetch", n = {"snapshot"}, s = {"L$0"})
final class WcbNetworkRequester$fetch$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ b this$0;

    public WcbNetworkRequester$fetch$1(b r1, Continuation<? super WcbNetworkRequester$fetch$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r4) {
        this.result = r4;
        this.label |= Integer.MIN_VALUE;
        return b.a(this.this$0, null, 0, this);
    }
}
