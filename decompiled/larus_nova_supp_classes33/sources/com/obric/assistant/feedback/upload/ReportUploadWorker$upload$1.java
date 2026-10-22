package com.obric.assistant.feedback.upload;

import com.obric.capabilitykit.common.ErrorCode;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.feedback.upload.ReportUploadWorker", f = "ReportUploadWorker.kt", i = {0, 1, 1, 2}, l = {ErrorCode.PRIVACY_STATEMENT_NOT_AGREE_ERROR, 217, 243}, m = "upload", n = {"task", "task", "reportId", "zipFile"}, s = {"L$0", "L$0", "L$1", "L$0"})
public final class ReportUploadWorker$upload$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ReportUploadWorker this$0;

    public ReportUploadWorker$upload$1(ReportUploadWorker r1, Continuation<? super ReportUploadWorker$upload$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.d(null, this);
    }
}
