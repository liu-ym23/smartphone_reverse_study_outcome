package com.larus.avlink.gallery.thumbnail;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.avlink.gallery.thumbnail.ThumbnailManager", f = "ThumbnailManager.kt", i = {0, 0, 0}, l = {641}, m = "handleDisplayThumbnailData", n = {"thumbnailData", "mediaInfo", "imageUuid"}, s = {"L$0", "L$1", "J$0"})
public final class ThumbnailManager$handleDisplayThumbnailData$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ThumbnailManager this$0;

    public ThumbnailManager$handleDisplayThumbnailData$1(ThumbnailManager r1, Continuation<? super ThumbnailManager$handleDisplayThumbnailData$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        ThumbnailManager r3 = this.this$0;
        ThumbnailManager r0 = ThumbnailManager.a;
        return r3.n(null, null, this);
    }
}
