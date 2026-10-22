package com.obric.assistant.feedback.upload;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.feedback.upload.ReportUploadWorker", f = "ReportUploadWorker.kt", i = {}, l = {315}, m = "uploadFiles", n = {}, s = {})
public final class ReportUploadWorker$uploadFiles$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ReportUploadWorker this$0;

    public ReportUploadWorker$uploadFiles$1(ReportUploadWorker r1, Continuation<? super ReportUploadWorker$uploadFiles$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r7) {
        this.result = r7;
        this.label |= Integer.MIN_VALUE;
        ReportUploadWorker r0 = this.this$0;
        int r8 = ReportUploadWorker.c;
        return r0.f(null, null, null, null, this);
    }
}
