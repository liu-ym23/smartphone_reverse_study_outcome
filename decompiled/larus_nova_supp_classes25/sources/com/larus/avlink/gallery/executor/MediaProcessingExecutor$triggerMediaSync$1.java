package com.larus.avlink.gallery.executor;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.avlink.gallery.executor.MediaProcessingExecutor", f = "MediaProcessingExecutor.kt", i = {0, 1}, l = {566, 570}, m = "triggerMediaSync", n = {"uniqId", "uniqId"}, s = {"L$0", "L$0"})
public final class MediaProcessingExecutor$triggerMediaSync$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MediaProcessingExecutor this$0;

    public MediaProcessingExecutor$triggerMediaSync$1(MediaProcessingExecutor r1, Continuation<? super MediaProcessingExecutor$triggerMediaSync$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        MediaProcessingExecutor r3 = this.this$0;
        int r0 = MediaProcessingExecutor.k;
        return r3.h(null, this);
    }
}
