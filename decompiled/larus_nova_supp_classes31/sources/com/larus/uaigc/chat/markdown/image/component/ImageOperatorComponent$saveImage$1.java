package com.larus.uaigc.chat.markdown.image.component;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.chat.markdown.image.component.ImageOperatorComponent", f = "ImageOperatorComponent.kt", i = {1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 3, 3, 3, 4, 4, 4}, l = {68, 83, 84, 137, 138}, m = "saveImage", n = {"imageInfo", "eventParams", "messageId", "taskType", "imageUrl", "imageInfo", "eventParams", "messageId", "taskType", "imageUrl", "imageInfo", "eventParams", "taskType", "eventParams", "taskType", "message"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2"})
public final class ImageOperatorComponent$saveImage$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ImageOperatorComponent this$0;

    public ImageOperatorComponent$saveImage$1(ImageOperatorComponent r1, Continuation<? super ImageOperatorComponent$saveImage$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r7) {
        this.result = r7;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.e(null, null, null, null, this);
    }
}
