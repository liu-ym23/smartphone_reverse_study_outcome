package com.larus.avlink.gallery.executor;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.avlink.gallery.executor.MediaAdditionReconciler", f = "MediaAdditionReconciler.kt", i = {0, 0, 1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5}, l = {120, 131, 132, 133, 134, 136}, m = "reconcileAllFromPublicAlbum", n = {"albumDir", "diskIds", "albumDir", "row", "created", "id", "albumDir", "row", "created", "id", "albumDir", "row", "created", "id", "albumDir", "row", "created", "id", "albumDir", "created", "id"}, s = {"L$0", "L$1", "L$0", "L$2", "I$0", "J$0", "L$0", "L$2", "I$0", "J$0", "L$0", "L$2", "I$0", "J$0", "L$0", "L$2", "I$0", "J$0", "L$0", "I$0", "J$0"})
final class MediaAdditionReconciler$reconcileAllFromPublicAlbum$1 extends ContinuationImpl {
    int I$0;
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MediaAdditionReconciler this$0;

    public MediaAdditionReconciler$reconcileAllFromPublicAlbum$1(MediaAdditionReconciler r1, Continuation<? super MediaAdditionReconciler$reconcileAllFromPublicAlbum$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return MediaAdditionReconciler.b(this.this$0, this);
    }
}
