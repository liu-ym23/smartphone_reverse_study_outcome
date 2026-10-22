package com.larus.search.impl.combine;

import com.larus.platform.model.SlashMentionConfig;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.search.impl.combine.CombineSearchFragment", f = "CombineSearchFragment.kt", i = {0, 1, 2, 2}, l = {1164, 1167, 1169, 1180}, m = "checkAndCreateLocalConversation", n = {"data", "data", "data", SlashMentionConfig.MENTION_CONTENT_CONVERSATION}, s = {"L$0", "L$0", "L$0", "L$1"})
final class CombineSearchFragment$checkAndCreateLocalConversation$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CombineSearchFragment this$0;

    public CombineSearchFragment$checkAndCreateLocalConversation$1(CombineSearchFragment r1, Continuation<? super CombineSearchFragment$checkAndCreateLocalConversation$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return CombineSearchFragment.U90(this.this$0, null, this);
    }
}
