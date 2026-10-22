package com.larus.bmhome.chat.component.bottom.multimodal.upload;

import com.larus.avlink.model.DoraCallStateCode;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.component.bottom.multimodal.upload.FileUploader", f = "FileUploader.kt", i = {0, 0, 0, 0, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7}, l = {91, 94, 121, DoraCallStateCode.DOUBAO_STOP_SI_BY_TIMEOUT, DoraCallStateCode.DOUBAO_STOP_RECORD_BY_EXCEPTION, DoraCallStateCode.ENV_OBSERVE_AUTO_TIMER_ENTER_PAUSE, 194, 203}, m = "doPreprocess", n = {"param", "processConfig", "$this$doPreprocess_u24lambda_u249", "previewAttachment", "param", "$this$doPreprocess_u24lambda_u249", "$this$doPreprocess_u24lambda_u249", "processResult", "$this$doPreprocess_u24lambda_u249", "processResult", "$this$doPreprocess_u24lambda_u249", "processResult", "$this$doPreprocess_u24lambda_u249", "processResult", "processResult"}, s = {"L$0", "L$1", "L$2", "Z$0", "L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$0"})
public final class FileUploader$doPreprocess$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FileUploader this$0;

    public FileUploader$doPreprocess$1(FileUploader r1, Continuation<? super FileUploader$doPreprocess$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        FileUploader r3 = this.this$0;
        FileUploader r0 = FileUploader.a;
        return r3.b(null, null, this);
    }
}
