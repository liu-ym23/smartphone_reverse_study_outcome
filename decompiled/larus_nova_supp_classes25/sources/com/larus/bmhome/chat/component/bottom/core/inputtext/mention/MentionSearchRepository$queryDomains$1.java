package com.larus.bmhome.chat.component.bottom.core.inputtext.mention;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.component.bottom.core.inputtext.mention.MentionSearchRepository", f = "MentionSearchRepository.kt", i = {0}, l = {190}, m = "queryDomains", n = {"domains"}, s = {"L$0"})
public final class MentionSearchRepository$queryDomains$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MentionSearchRepository this$0;

    public MentionSearchRepository$queryDomains$1(MentionSearchRepository r1, Continuation<? super MentionSearchRepository$queryDomains$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        MentionSearchRepository r3 = this.this$0;
        MentionSearchRepository r0 = MentionSearchRepository.a;
        return r3.e(null, null, null, this);
    }
}
