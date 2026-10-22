package com.larus.bmhome.chat.standarduikit.localfileblock.remote;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.chat.standarduikit.localfileblock.remote.PcRemoteFileDispatcher", f = "PcRemoteFileDispatcher.kt", i = {0}, l = {50}, m = "requestUrl", n = {"commandId"}, s = {"L$0"})
public final class PcRemoteFileDispatcher$requestUrl$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PcRemoteFileDispatcher this$0;

    public PcRemoteFileDispatcher$requestUrl$1(PcRemoteFileDispatcher r1, Continuation<? super PcRemoteFileDispatcher$requestUrl$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.b(null, this);
    }
}
