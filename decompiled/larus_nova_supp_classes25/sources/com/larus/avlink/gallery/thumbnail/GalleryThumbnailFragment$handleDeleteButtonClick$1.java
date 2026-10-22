package com.larus.avlink.gallery.thumbnail;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.avlink.gallery.thumbnail.GalleryThumbnailFragment", f = "GalleryThumbnailFragment.kt", i = {}, l = {729}, m = "handleDeleteButtonClick", n = {}, s = {})
final class GalleryThumbnailFragment$handleDeleteButtonClick$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ GalleryThumbnailFragment this$0;

    public GalleryThumbnailFragment$handleDeleteButtonClick$1(GalleryThumbnailFragment r1, Continuation<? super GalleryThumbnailFragment$handleDeleteButtonClick$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return GalleryThumbnailFragment.T90(this.this$0, this);
    }
}
