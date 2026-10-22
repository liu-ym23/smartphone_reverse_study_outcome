package com.larus.avlink.gallery.storage;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.avlink.gallery.storage.GalleryStoragePolicyManager", f = "GalleryStoragePolicyManager.kt", i = {0}, l = {216}, m = "getInProgressSourcePaths", n = {"$this$getInProgressSourcePaths_u24lambda_u2416"}, s = {"L$0"})
public final class GalleryStoragePolicyManager$getInProgressSourcePaths$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ GalleryStoragePolicyManager this$0;

    public GalleryStoragePolicyManager$getInProgressSourcePaths$1(GalleryStoragePolicyManager r1, Continuation<? super GalleryStoragePolicyManager$getInProgressSourcePaths$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        GalleryStoragePolicyManager r3 = this.this$0;
        GalleryStoragePolicyManager r0 = GalleryStoragePolicyManager.a;
        return r3.l(this);
    }
}
