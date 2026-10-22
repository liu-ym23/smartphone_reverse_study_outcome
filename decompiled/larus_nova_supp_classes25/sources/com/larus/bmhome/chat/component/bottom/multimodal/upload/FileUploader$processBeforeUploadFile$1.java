package com.larus.bmhome.chat.component.bottom.multimodal.upload;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.component.bottom.multimodal.upload.FileUploader", f = "FileUploader.kt", i = {0, 0}, l = {267, 281}, m = "processBeforeUploadFile", n = {"param", "processConfig"}, s = {"L$0", "L$1"})
public final class FileUploader$processBeforeUploadFile$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FileUploader this$0;

    public FileUploader$processBeforeUploadFile$1(FileUploader r1, Continuation<? super FileUploader$processBeforeUploadFile$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.f(null, null, null, this);
    }
}
