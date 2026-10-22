package com.larus.avlink.gallery.view;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.avlink.gallery.view.MineAlbumFragment", f = "MineAlbumFragment.kt", i = {0, 1, 1}, l = {636, 664}, m = "checkAndSyncUnsynchronizedMedia", n = {"destination$iv$iv", "unsyncedMedia", "metadata"}, s = {"L$0", "L$0", "L$2"})
final class MineAlbumFragment$checkAndSyncUnsynchronizedMedia$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MineAlbumFragment this$0;

    public MineAlbumFragment$checkAndSyncUnsynchronizedMedia$1(MineAlbumFragment r1, Continuation<? super MineAlbumFragment$checkAndSyncUnsynchronizedMedia$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return MineAlbumFragment.Z90(this.this$0, null, this);
    }
}
