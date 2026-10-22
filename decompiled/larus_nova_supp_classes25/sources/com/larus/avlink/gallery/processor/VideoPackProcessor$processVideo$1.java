package com.larus.avlink.gallery.processor;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.avlink.gallery.processor.VideoPackProcessor", f = "VideoPackProcessor.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, l = {262}, m = "processVideo", n = {"filePath", "metadata", "mediaId", "tempOutputFile", "tempInputFile", "finalFileName", "finalOutputPath", "tempOutputPath", "stabilizerInputPath", "finalOutputPath", "optDirPath", "startTime", "isPackInput"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "J$0", "I$0"})
public final class VideoPackProcessor$processVideo$1 extends ContinuationImpl {
    int I$0;
    long J$0;
    Object L$0;
    Object L$1;
    Object L$10;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    Object L$8;
    Object L$9;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ VideoPackProcessor this$0;

    public VideoPackProcessor$processVideo$1(VideoPackProcessor r1, Continuation<? super VideoPackProcessor$processVideo$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        VideoPackProcessor r3 = this.this$0;
        s98.c r0 = VideoPackProcessor.a;
        return r3.c(null, null, this);
    }
}
