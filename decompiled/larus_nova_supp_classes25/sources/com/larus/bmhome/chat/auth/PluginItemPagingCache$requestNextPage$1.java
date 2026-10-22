package com.larus.bmhome.chat.auth;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.auth.PluginItemPagingCache", f = "PluginItemPagingCache.kt", i = {0, 0}, l = {MessageCellStateTransformerType.SEARCH_LIST, MessageCellStateTransformerType.EDU_CONTINUE_SHOT}, m = "requestNextPage", n = {"downgradeSource", "updateFirstPage"}, s = {"L$0", "Z$0"})
public final class PluginItemPagingCache$requestNextPage$1 extends ContinuationImpl {
    Object L$0;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PluginItemPagingCache this$0;

    public PluginItemPagingCache$requestNextPage$1(PluginItemPagingCache r1, Continuation<? super PluginItemPagingCache$requestNextPage$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r3) {
        this.result = r3;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(false, null, this);
    }
}
