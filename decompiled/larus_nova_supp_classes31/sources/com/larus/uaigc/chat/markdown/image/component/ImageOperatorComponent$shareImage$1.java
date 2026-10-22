package com.larus.uaigc.chat.markdown.image.component;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.chat.markdown.image.component.ImageOperatorComponent", f = "ImageOperatorComponent.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 7, 7, 7, 8, 8}, l = {197, 198, 198, 257, 257, 262, 269, 276, 275, 287}, m = "shareImage", n = {"imageInfo", "eventParams", "messageId", "taskType", "isFromDownload", "imageInfo", "eventParams", "messageId", "taskType", "message", "isFromDownload", "imageInfo", "eventParams", "messageId", "taskType", "message", "isFromDownload", "imageInfo", "eventParams", "taskType", "imageUrl", "imageKey", "imageInfo", "eventParams", "taskType", "imageUrl", "imageKey", "imageInfo", "eventParams", "taskType", "imageUrl", "imageKey", "imageInfo", "eventParams", "taskType", "imageUrl", "imageKey", "imageInfo", "eventParams", "taskType", "eventParams", "taskType"}, s = {"L$0", "L$1", "L$2", "L$3", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$0", "L$1"})
public final class ImageOperatorComponent$shareImage$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$10;
    Object L$11;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    Object L$8;
    Object L$9;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ImageOperatorComponent this$0;

    public ImageOperatorComponent$shareImage$1(ImageOperatorComponent r1, Continuation<? super ImageOperatorComponent$shareImage$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r9) {
        this.result = r9;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.f(null, null, null, false, null, false, this);
    }
}
