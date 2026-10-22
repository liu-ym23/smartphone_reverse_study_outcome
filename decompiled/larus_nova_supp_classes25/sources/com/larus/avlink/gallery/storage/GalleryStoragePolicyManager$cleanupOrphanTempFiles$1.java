package com.larus.avlink.gallery.storage;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.avlink.gallery.storage.GalleryStoragePolicyManager", f = "GalleryStoragePolicyManager.kt", i = {}, l = {232}, m = "cleanupOrphanTempFiles", n = {}, s = {})
final class GalleryStoragePolicyManager$cleanupOrphanTempFiles$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ GalleryStoragePolicyManager this$0;

    public GalleryStoragePolicyManager$cleanupOrphanTempFiles$1(GalleryStoragePolicyManager r1, Continuation<? super GalleryStoragePolicyManager$cleanupOrphanTempFiles$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return GalleryStoragePolicyManager.a(this.this$0, this);
    }
}
