package com.larus.avlink.gallery.view;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.avlink.gallery.view.MineAlbumFragment", f = "MineAlbumFragment.kt", i = {0, 0, 0}, l = {708}, m = "syncMediaToAlbum", n = {"metadata", "contentResolver", "uniqId"}, s = {"L$0", "L$1", "L$2"})
public final class MineAlbumFragment$syncMediaToAlbum$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MineAlbumFragment this$0;

    public MineAlbumFragment$syncMediaToAlbum$1(MineAlbumFragment r1, Continuation<? super MineAlbumFragment$syncMediaToAlbum$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        MineAlbumFragment r3 = this.this$0;
        int r0 = MineAlbumFragment.D;
        return r3.ia0(null, this);
    }
}
