package com.larus.bmhome.chat.component.bottom.attachment;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.component.bottom.attachment.AlbumEduIntentSuggestController", f = "AlbumEduIntentSuggestController.kt", i = {0, 0, 1, 1, 2, 2, 3, 3, 4, 4}, l = {327, 330, 335, 346, 392}, m = "detect", n = {"snapshot", "config", "snapshot", "config", "snapshot", "config", "snapshot", "config", "snapshot", "bitmap"}, s = {"L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$0", "L$1"})
final class AlbumEduIntentSuggestController$detect$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AlbumEduIntentSuggestController this$0;

    public AlbumEduIntentSuggestController$detect$1(AlbumEduIntentSuggestController r1, Continuation<? super AlbumEduIntentSuggestController$detect$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return AlbumEduIntentSuggestController.b(this.this$0, null, this);
    }
}
