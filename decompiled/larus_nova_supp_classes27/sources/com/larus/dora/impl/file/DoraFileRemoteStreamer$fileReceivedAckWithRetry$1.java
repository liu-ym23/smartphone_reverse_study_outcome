package com.larus.dora.impl.file;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.file.DoraFileRemoteStreamer", f = "DoraFileRemoteStreamer.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1}, l = {67, 78}, m = "fileReceivedAckWithRetry", n = {"fileName", "requestEvent", "maxRetryCount", "ackAttempt", "ackSuccess", "fileName", "requestEvent", "maxRetryCount", "ackAttempt", "ackSuccess"}, s = {"L$0", "L$1", "I$0", "I$1", "I$2", "L$0", "L$1", "I$0", "I$1", "I$2"})
public final class DoraFileRemoteStreamer$fileReceivedAckWithRetry$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    int I$2;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DoraFileRemoteStreamer this$0;

    public DoraFileRemoteStreamer$fileReceivedAckWithRetry$1(DoraFileRemoteStreamer r1, Continuation<? super DoraFileRemoteStreamer$fileReceivedAckWithRetry$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r3) {
        this.result = r3;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.b(null, 0, this);
    }
}
