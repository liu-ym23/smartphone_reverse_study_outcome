package com.obric.assistant.performance;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.performance.ObricMemoryUploadServiceImpl", f = "ObricMemoryUploadServiceImpl.kt", i = {0, 0, 0}, l = {235}, m = "mergeUploadMemoryFiles", n = {"config", "file", "timestamp"}, s = {"L$0", "L$1", "J$0"})
public final class ObricMemoryUploadServiceImpl$mergeUploadMemoryFiles$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ObricMemoryUploadServiceImpl this$0;

    public ObricMemoryUploadServiceImpl$mergeUploadMemoryFiles$1(ObricMemoryUploadServiceImpl r1, Continuation<? super ObricMemoryUploadServiceImpl$mergeUploadMemoryFiles$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        ObricMemoryUploadServiceImpl r3 = this.this$0;
        int r0 = ObricMemoryUploadServiceImpl.e;
        return r3.d(null, this);
    }
}
