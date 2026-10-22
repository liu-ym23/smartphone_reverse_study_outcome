package com.larus.avlink.gallery.compat;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.avlink.gallery.compat.ThumbnailMetadataHelper", f = "ThumbnailMetadataHelper.kt", i = {0, 0, 1, 1}, l = {61, 72}, m = "createThumbnailMetadata", n = {"metadata", "imageUuid", "metadata", "imageUuid"}, s = {"L$0", "J$0", "L$0", "J$0"})
final class ThumbnailMetadataHelper$createThumbnailMetadata$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ThumbnailMetadataHelper this$0;

    public ThumbnailMetadataHelper$createThumbnailMetadata$1(ThumbnailMetadataHelper r1, Continuation<? super ThumbnailMetadataHelper$createThumbnailMetadata$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r13) {
        this.result = r13;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(null, 0, null, 0, 0, 0, 0, this);
    }
}
