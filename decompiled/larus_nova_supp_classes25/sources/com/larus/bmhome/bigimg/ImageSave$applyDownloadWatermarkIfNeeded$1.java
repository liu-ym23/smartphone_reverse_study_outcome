package com.larus.bmhome.bigimg;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.bigimg.ImageSave", f = "ImageSave.kt", i = {0, 1, 2}, l = {990, 998, 1001}, m = "applyDownloadWatermarkIfNeeded", n = {"input", "input", "input"}, s = {"L$0", "L$0", "L$0"})
final class ImageSave$applyDownloadWatermarkIfNeeded$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ImageSave this$0;

    public ImageSave$applyDownloadWatermarkIfNeeded$1(ImageSave r1, Continuation<? super ImageSave$applyDownloadWatermarkIfNeeded$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return ImageSave.a(this.this$0, null, this);
    }
}
