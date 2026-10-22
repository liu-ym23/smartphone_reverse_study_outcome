package com.larus.avlink.gallery.coordinator;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.avlink.gallery.coordinator.MediaSyncCoordinator", f = "MediaSyncCoordinator.kt", i = {0, 0}, l = {426}, m = "startSyncInternal", n = {"photoCnt", "videoCnt"}, s = {"L$0", "L$1"})
final class MediaSyncCoordinator$startSyncInternal$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MediaSyncCoordinator this$0;

    public MediaSyncCoordinator$startSyncInternal$1(MediaSyncCoordinator r1, Continuation<? super MediaSyncCoordinator$startSyncInternal$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r7) {
        this.result = r7;
        this.label |= Integer.MIN_VALUE;
        return MediaSyncCoordinator.b(this.this$0, null, null, null, false, this);
    }
}
