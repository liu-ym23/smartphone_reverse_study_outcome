package com.larus.search.impl.combine;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.search.impl.combine.CombineSearchFragment", f = "CombineSearchFragment.kt", i = {0, 0, 1, 1, 1, 1}, l = {1331, 1343}, m = "notifyItemChangedWhenConversationChange", n = {"newConversation", "adapter", "newConversation", "adapter", "data", "position"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "I$0"})
final class CombineSearchFragment$notifyItemChangedWhenConversationChange$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CombineSearchFragment this$0;

    public CombineSearchFragment$notifyItemChangedWhenConversationChange$1(CombineSearchFragment r1, Continuation<? super CombineSearchFragment$notifyItemChangedWhenConversationChange$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r3) {
        this.result = r3;
        this.label |= Integer.MIN_VALUE;
        return CombineSearchFragment.W90(this.this$0, false, null, this);
    }
}
