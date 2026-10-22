package com.larus.dora.impl.file;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.file.DoraFileRemoteStreamer", f = "DoraFileRemoteStreamer.kt", i = {0, 0}, l = {116}, m = "sendEvent", n = {"requestEvent", "convertor$iv"}, s = {"L$0", "L$1"})
public final class DoraFileRemoteStreamer$sendEvent$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DoraFileRemoteStreamer this$0;

    public DoraFileRemoteStreamer$sendEvent$1(DoraFileRemoteStreamer r1, Continuation<? super DoraFileRemoteStreamer$sendEvent$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r4) {
        this.result = r4;
        this.label |= Integer.MIN_VALUE;
        DoraFileRemoteStreamer r5 = this.this$0;
        int r0 = DoraFileRemoteStreamer.a;
        return r5.e(null, 0, this);
    }
}
