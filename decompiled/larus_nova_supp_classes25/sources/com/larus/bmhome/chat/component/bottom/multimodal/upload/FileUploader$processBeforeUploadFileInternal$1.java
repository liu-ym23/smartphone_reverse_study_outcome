package com.larus.bmhome.chat.component.bottom.multimodal.upload;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.component.bottom.multimodal.upload.FileUploader", f = "FileUploader.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2}, l = {303, 304, 312, 338}, m = "processBeforeUploadFileInternal", n = {"processConfig", "$this$processBeforeUploadFileInternal_u24lambda_u2414", "audioTracker", "audioAttempt", "tempUploaderIdentifier", "processConfig", "$this$processBeforeUploadFileInternal_u24lambda_u2414", "audioTracker", "audioAttempt", "tempUploaderIdentifier", "interceptResult", "processConfig", "$this$processBeforeUploadFileInternal_u24lambda_u2414", "audioTracker", "audioAttempt", "tempUploaderIdentifier"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4"})
public final class FileUploader$processBeforeUploadFileInternal$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FileUploader this$0;

    public FileUploader$processBeforeUploadFileInternal$1(FileUploader r1, Continuation<? super FileUploader$processBeforeUploadFileInternal$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        FileUploader r3 = this.this$0;
        FileUploader r0 = FileUploader.a;
        return r3.h(null, null, this);
    }
}
