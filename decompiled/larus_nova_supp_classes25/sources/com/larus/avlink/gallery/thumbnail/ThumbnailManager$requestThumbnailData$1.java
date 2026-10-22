package com.larus.avlink.gallery.thumbnail;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.avlink.gallery.thumbnail.ThumbnailManager", f = "ThumbnailManager.kt", i = {0, 0, 0, 0, 0, 0}, l = {608}, m = "requestThumbnailData", n = {"mediaInfo", "mediaId", "createTime", "type", "timeout", "startTime"}, s = {"L$0", "L$1", "L$2", "I$0", "J$0", "J$1"})
public final class ThumbnailManager$requestThumbnailData$1 extends ContinuationImpl {
    int I$0;
    long J$0;
    long J$1;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ThumbnailManager this$0;

    public ThumbnailManager$requestThumbnailData$1(ThumbnailManager r1, Continuation<? super ThumbnailManager$requestThumbnailData$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r3) {
        this.result = r3;
        this.label |= Integer.MIN_VALUE;
        ThumbnailManager r4 = this.this$0;
        ThumbnailManager r0 = ThumbnailManager.a;
        return r4.q(null, 0, this);
    }
}
