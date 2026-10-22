package com.larus.bmhome.chat.component.bottom.core.inputtext.mention;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.component.bottom.core.inputtext.mention.MentionRecommendStore", f = "MentionRecommendStore.kt", i = {0, 0, 0}, l = {127}, m = "fetchAndCache", n = {"config", "key", "userId"}, s = {"L$0", "L$1", "L$2"})
final class MentionRecommendStore$fetchAndCache$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MentionRecommendStore this$0;

    public MentionRecommendStore$fetchAndCache$1(MentionRecommendStore r1, Continuation<? super MentionRecommendStore$fetchAndCache$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return MentionRecommendStore.a(this.this$0, null, null, this);
    }
}
