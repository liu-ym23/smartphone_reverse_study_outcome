package com.larus.dora.impl.file;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.file.DoraFileFetchManager", f = "DoraFileFetchManager.kt", i = {0, 1, 1, 1, 2, 2, 3, 3}, l = {426, 471, 533, 541}, m = "processTask", n = {"taskId", "taskId", "startTime", "previousDownloadSize", "taskId", "task", "taskId", "task"}, s = {"L$0", "L$0", "J$0", "J$1", "L$0", "L$1", "L$0", "L$1"})
final class DoraFileFetchManager$processTask$1 extends ContinuationImpl {
    long J$0;
    long J$1;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DoraFileFetchManager this$0;

    public DoraFileFetchManager$processTask$1(DoraFileFetchManager r1, Continuation<? super DoraFileFetchManager$processTask$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return DoraFileFetchManager.a(this.this$0, null, this);
    }
}
