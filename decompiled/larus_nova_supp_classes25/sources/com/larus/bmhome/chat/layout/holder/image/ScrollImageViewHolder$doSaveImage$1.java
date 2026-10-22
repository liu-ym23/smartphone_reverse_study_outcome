package com.larus.bmhome.chat.layout.holder.image;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.layout.holder.image.ScrollImageViewHolder", f = "ImageScrollAdapter.kt", i = {0}, l = {588}, m = "doSaveImage", n = {"imageUrl"}, s = {"L$0"})
final class ScrollImageViewHolder$doSaveImage$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ScrollImageViewHolder this$0;

    public ScrollImageViewHolder$doSaveImage$1(ScrollImageViewHolder r1, Continuation<? super ScrollImageViewHolder$doSaveImage$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return ScrollImageViewHolder.U3(this.this$0, null, this);
    }
}
