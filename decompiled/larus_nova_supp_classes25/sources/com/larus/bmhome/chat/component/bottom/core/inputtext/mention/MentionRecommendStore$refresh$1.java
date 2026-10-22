package com.larus.bmhome.chat.component.bottom.core.inputtext.mention;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.component.bottom.core.inputtext.mention.MentionRecommendStore", f = "MentionRecommendStore.kt", i = {0, 0, 0}, l = {84}, m = "refresh", n = {"config", "request", "includeContacts"}, s = {"L$0", "L$1", "Z$0"})
public final class MentionRecommendStore$refresh$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MentionRecommendStore this$0;

    public MentionRecommendStore$refresh$1(MentionRecommendStore r1, Continuation<? super MentionRecommendStore$refresh$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r3) {
        this.result = r3;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.d(null, false, this);
    }
}
