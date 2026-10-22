package com.larus.doc.impl.operation.download;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.doc.impl.operation.download.DocDownloadManager", f = "DocDownloadManager.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1}, l = {381, 384}, m = "pollDownloadUrl", n = {"jobId", "firstQuerySec", "querySec", "maxAttempts", "attempt", "jobId", "firstQuerySec", "querySec", "maxAttempts", "attempt"}, s = {"L$0", "I$0", "I$1", "I$2", "I$4", "L$0", "I$0", "I$1", "I$2", "I$4"})
final class DocDownloadManager$pollDownloadUrl$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    int I$2;
    int I$3;
    int I$4;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DocDownloadManager this$0;

    public DocDownloadManager$pollDownloadUrl$1(DocDownloadManager r1, Continuation<? super DocDownloadManager$pollDownloadUrl$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return DocDownloadManager.c(this.this$0, null, this);
    }
}
