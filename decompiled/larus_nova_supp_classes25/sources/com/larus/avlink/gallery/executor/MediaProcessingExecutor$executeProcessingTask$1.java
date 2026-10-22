package com.larus.avlink.gallery.executor;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.avlink.gallery.executor.MediaProcessingExecutor", f = "MediaProcessingExecutor.kt", i = {0, 0, 0, 0, 1, 1, 2, 2, 3, 3, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 7, 7, 8, 8, 9, 9, 9, 9, 9, 10, 10, 10, 10, 10, 10, 10, 11, 11, 12, 12, 13, 13, MessageCellStateTransformerType.TIPS, MessageCellStateTransformerType.TIPS}, l = {267, 423, 423, 423, 287, 305, 362, 382, 423, 392, 402, 423, 414, 423, 423}, m = "executeProcessingTask", n = {"task", "taskType", "uniqId", "startTime", "task", "taskType", "task", "taskType", "task", "taskType", "task", "taskType", "uniqId", "metadata", "startTime", "task", "taskType", "uniqId", "metadata", "startTime", "task", "taskType", "uniqId", "metadata", "result", "duration", "algorithms", "processedFile", "task", "taskType", "task", "taskType", "task", "taskType", "metadata", "duration", "algorithms", "task", "taskType", "uniqId", "metadata", "result", "duration", "algorithms", "task", "taskType", "task", "taskType", "task", "taskType", "task", "taskType"}, s = {"L$0", "L$1", "L$2", "J$0", "L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$2", "L$3", "J$0", "L$0", "L$1", "L$2", "L$3", "J$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$0", "L$1"})
public final class MediaProcessingExecutor$executeProcessingTask$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MediaProcessingExecutor this$0;

    public MediaProcessingExecutor$executeProcessingTask$1(MediaProcessingExecutor r1, Continuation<? super MediaProcessingExecutor$executeProcessingTask$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        MediaProcessingExecutor r3 = this.this$0;
        int r0 = MediaProcessingExecutor.k;
        return r3.b(null, this);
    }
}
