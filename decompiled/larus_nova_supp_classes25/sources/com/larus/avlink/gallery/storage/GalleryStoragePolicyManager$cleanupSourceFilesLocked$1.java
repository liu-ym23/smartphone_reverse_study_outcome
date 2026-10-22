package com.larus.avlink.gallery.storage;

import com.larus.avlink.model.DoraCallStateCode;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.avlink.gallery.storage.GalleryStoragePolicyManager", f = "GalleryStoragePolicyManager.kt", i = {0, 0, 0}, l = {DoraCallStateCode.ENV_OBSERVE_AUTO_TIMER_HEARTBEAT}, m = "cleanupSourceFilesLocked", n = {"config", "now", "retentionMillis"}, s = {"L$0", "J$0", "J$1"})
final class GalleryStoragePolicyManager$cleanupSourceFilesLocked$1 extends ContinuationImpl {
    long J$0;
    long J$1;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ GalleryStoragePolicyManager this$0;

    public GalleryStoragePolicyManager$cleanupSourceFilesLocked$1(GalleryStoragePolicyManager r1, Continuation<? super GalleryStoragePolicyManager$cleanupSourceFilesLocked$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return GalleryStoragePolicyManager.b(this.this$0, this);
    }
}
