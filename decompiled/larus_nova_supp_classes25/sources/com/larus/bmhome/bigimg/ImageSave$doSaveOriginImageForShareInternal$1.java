package com.larus.bmhome.bigimg;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.bigimg.ImageSave", f = "ImageSave.kt", i = {0, 0, 0, 0, 1, 1, 1, 1}, l = {360, 368}, m = "doSaveOriginImageForShareInternal", n = {"url", "callback", "exifMap", "isAIGC", "url", "callback", "exifMap", "isAIGC"}, s = {"L$0", "L$1", "L$2", "Z$0", "L$0", "L$1", "L$2", "Z$0"})
final class ImageSave$doSaveOriginImageForShareInternal$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ImageSave this$0;

    public ImageSave$doSaveOriginImageForShareInternal$1(ImageSave r1, Continuation<? super ImageSave$doSaveOriginImageForShareInternal$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r7) {
        this.result = r7;
        this.label |= Integer.MIN_VALUE;
        return ImageSave.c(this.this$0, null, null, null, false, this);
    }
}
