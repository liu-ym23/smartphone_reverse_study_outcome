package com.obric.assistant.performance;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.performance.ObricMemoryUploadServiceImpl", f = "ObricMemoryUploadServiceImpl.kt", i = {0}, l = {151}, m = "uploadMemoryInfoFilesOnce", n = {"did"}, s = {"L$0"})
final class ObricMemoryUploadServiceImpl$uploadMemoryInfoFilesOnce$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ObricMemoryUploadServiceImpl this$0;

    public ObricMemoryUploadServiceImpl$uploadMemoryInfoFilesOnce$1(ObricMemoryUploadServiceImpl r1, Continuation<? super ObricMemoryUploadServiceImpl$uploadMemoryInfoFilesOnce$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return ObricMemoryUploadServiceImpl.b(this.this$0, null, null, this);
    }
}
