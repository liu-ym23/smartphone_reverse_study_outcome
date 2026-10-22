package com.larus.avlink.gallery.executor;

import com.larus.avlink.model.DoraCallStateCode;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.avlink.gallery.executor.MediaAdditionReconciler", f = "MediaAdditionReconciler.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 4, 4, 4}, l = {DoraCallStateCode.ENV_OBSERVE_AUTO_TIMER_HEARTBEAT, DoraCallStateCode.ENV_OBSERVE_AUTO_LINK_CONNECTED, 190, 191, 193}, m = "reconcileAdded", n = {"albumDir", "row", "createdCount", "id", "albumDir", "row", "createdCount", "id", "albumDir", "row", "createdCount", "id", "albumDir", "row", "createdCount", "id", "albumDir", "createdCount", "id"}, s = {"L$0", "L$2", "I$0", "J$0", "L$0", "L$2", "I$0", "J$0", "L$0", "L$2", "I$0", "J$0", "L$0", "L$2", "I$0", "J$0", "L$0", "I$0", "J$0"})
final class MediaAdditionReconciler$reconcileAdded$1 extends ContinuationImpl {
    int I$0;
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MediaAdditionReconciler this$0;

    public MediaAdditionReconciler$reconcileAdded$1(MediaAdditionReconciler r1, Continuation<? super MediaAdditionReconciler$reconcileAdded$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return MediaAdditionReconciler.a(this.this$0, null, this);
    }
}
