package com.larus.avlink.gallery.compat;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.avlink.gallery.compat.ThumbnailMetadataHelper", f = "ThumbnailMetadataHelper.kt", i = {0, 0}, l = {207}, m = "deleteThumbnailData", n = {"deletePath", "imageUuid"}, s = {"L$0", "J$0"})
public final class ThumbnailMetadataHelper$deleteThumbnailData$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ThumbnailMetadataHelper this$0;

    public ThumbnailMetadataHelper$deleteThumbnailData$1(ThumbnailMetadataHelper r1, Continuation<? super ThumbnailMetadataHelper$deleteThumbnailData$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r7) {
        this.result = r7;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.d(0, null, null, this);
    }
}
