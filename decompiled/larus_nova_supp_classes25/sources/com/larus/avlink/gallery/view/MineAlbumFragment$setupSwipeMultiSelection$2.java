package com.larus.avlink.gallery.view;

import androidx.lifecycle.LiveData;
import com.larus.avlink.gallery.viewmodel.GalleryViewModel;
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
final /* synthetic */ class MineAlbumFragment$setupSwipeMultiSelection$2 extends FunctionReferenceImpl implements Function1<Integer, Unit> {
    public MineAlbumFragment$setupSwipeMultiSelection$2(Object r8) {
        super(1, r8, MineAlbumFragment.class, "beginSwipeSelection", "beginSwipeSelection(I)V", 0);
    }

    public final void invoke(int r5) {
        MineAlbumFragment r0 = (MineAlbumFragment) ((CallableReference) this).receiver;
        AlbumListAdapter r1 = r0.m;
        if (r1 == null) goto L28;
        List r2 = r1.getCurrentList();
        if (r2 == null) goto L29;
        com.larus.bmhome.bigimg.t1 r3 = (com.larus.bmhome.bigimg.t1) CollectionsKt.getOrNull(r2, r5);
        if (r3 == null) goto L30;
        GalleryViewModel r4 = r0.t;
        if (r4 == null) goto L18;
        LiveData<Set<String>> r6 = r4.getSelectedItems();
        if (r6 == null) goto L18;
        Set r7 = (Set) r6.getValue();
        if (r7 == null) goto L18;
        Set r8 = CollectionsKt.toSet(r7);
        if (r8 == null) goto L18;
    L20:
        if (r0.q == false) goto L23;
        MineAlbumFragment.SwipeSelectionMode r9 = MineAlbumFragment.SwipeSelectionMode.ADD;
    L26:
        r0.q = false;
        r0.p = new MineAlbumFragment.c(r5, r8, r9);
        r0.aa0(r5, r5);
        return;
    L23:
        if (r8.contains(r3.getPath()) == false) goto L25;
        r9 = MineAlbumFragment.SwipeSelectionMode.REMOVE;
        goto L26
    L25:
        r9 = MineAlbumFragment.SwipeSelectionMode.ADD;
    L18:
        r8 = SetsKt.emptySet();
        goto L20
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
