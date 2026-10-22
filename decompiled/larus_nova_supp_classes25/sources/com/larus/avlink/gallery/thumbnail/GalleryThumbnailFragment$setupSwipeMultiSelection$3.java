package com.larus.avlink.gallery.thumbnail;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
final /* synthetic */ class GalleryThumbnailFragment$setupSwipeMultiSelection$3 extends FunctionReferenceImpl implements Function2<Integer, Integer, Unit> {
    public GalleryThumbnailFragment$setupSwipeMultiSelection$3(Object r8) {
        super(2, r8, GalleryThumbnailFragment.class, "applySwipeSelection", "applySwipeSelection(II)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        invoke(((Number) r1).intValue(), ((Number) r2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(int r3, int r4) {
        GalleryThumbnailFragment r0 = (GalleryThumbnailFragment) ((CallableReference) this).receiver;
        int r1 = GalleryThumbnailFragment.x;
        r0.U90(r3, r4);
    }
}
