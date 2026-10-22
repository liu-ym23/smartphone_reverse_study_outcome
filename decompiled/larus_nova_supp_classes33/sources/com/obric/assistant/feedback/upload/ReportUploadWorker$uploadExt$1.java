package com.obric.assistant.feedback.upload;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.feedback.upload.ReportUploadWorker", f = "ReportUploadWorker.kt", i = {}, l = {382}, m = "uploadExt", n = {}, s = {})
public final class ReportUploadWorker$uploadExt$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ReportUploadWorker this$0;

    public ReportUploadWorker$uploadExt$1(ReportUploadWorker r1, Continuation<? super ReportUploadWorker$uploadExt$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        ReportUploadWorker r3 = this.this$0;
        int r0 = ReportUploadWorker.c;
        return r3.e(null, this);
    }
}
