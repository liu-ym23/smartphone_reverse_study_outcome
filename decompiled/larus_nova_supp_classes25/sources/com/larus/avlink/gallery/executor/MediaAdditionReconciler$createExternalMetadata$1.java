package com.larus.avlink.gallery.executor;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.avlink.gallery.executor.MediaAdditionReconciler", f = "MediaAdditionReconciler.kt", i = {0, 0, 0, 1, 1, 2, 2}, l = {212, 230, 233}, m = "createExternalMetadata", n = {"row", "uniqId", "mediaStoreId", "row", "uniqId", "row", "uniqId"}, s = {"L$0", "L$1", "J$0", "L$0", "L$1", "L$0", "L$1"})
public final class MediaAdditionReconciler$createExternalMetadata$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MediaAdditionReconciler this$0;

    public MediaAdditionReconciler$createExternalMetadata$1(MediaAdditionReconciler r1, Continuation<? super MediaAdditionReconciler$createExternalMetadata$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r4) {
        this.result = r4;
        this.label |= Integer.MIN_VALUE;
        MediaAdditionReconciler r5 = this.this$0;
        MediaAdditionReconciler r0 = MediaAdditionReconciler.a;
        return r5.d(0, null, this);
    }
}
