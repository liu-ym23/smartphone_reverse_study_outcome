package com.larus.avlink.gallery.thumbnail;

import androidx.lifecycle.LiveData;
import com.larus.avlink.gallery.model.ThumbnailMetadata;
import com.larus.avlink.gallery.viewmodel.ThumbnailViewModel;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
final /* synthetic */ class GalleryThumbnailFragment$setupSwipeMultiSelection$2 extends FunctionReferenceImpl implements Function1<Integer, Unit> {
    public GalleryThumbnailFragment$setupSwipeMultiSelection$2(Object r8) {
        super(1, r8, GalleryThumbnailFragment.class, "beginSwipeSelection", "beginSwipeSelection(I)V", 0);
    }

    public final void invoke(int r5) {
        GalleryThumbnailFragment r0 = (GalleryThumbnailFragment) ((CallableReference) this).receiver;
        ThumbnailListAdapter r1 = r0.f;
        if (r1 == null) goto L28;
        List r2 = r1.getCurrentList();
        if (r2 == null) goto L29;
        ThumbnailMetadata r3 = (ThumbnailMetadata) CollectionsKt.getOrNull(r2, r5);
        if (r3 == null) goto L30;
        ThumbnailViewModel r4 = r0.e;
        if (r4 == null) goto L13;
        r4.enterSelectionMode();
    L13:
        ThumbnailViewModel r6 = r0.e;
        if (r6 == null) goto L21;
        LiveData<Set<ThumbnailMetadata>> r7 = r6.getSelectedItems();
        if (r7 == null) goto L21;
        Set r8 = (Set) r7.getValue();
        if (r8 == null) goto L21;
        Set r9 = CollectionsKt.toSet(r8);
        if (r9 == null) goto L21;
    L23:
        if (r9.contains(r3) == false) goto L25;
        GalleryThumbnailFragment.SwipeSelectionMode r10 = GalleryThumbnailFragment.SwipeSelectionMode.REMOVE;
    L26:
        r0.t = new GalleryThumbnailFragment.b(r5, r9, r10);
        r0.U90(r5, r5);
        return;
    L25:
        r10 = GalleryThumbnailFragment.SwipeSelectionMode.ADD;
    L21:
        r9 = SetsKt.emptySet();
        goto L23
    L30:
        return;
    L29:
        return;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke(((Number) r1).intValue());
        return Unit.INSTANCE;
    }
}
