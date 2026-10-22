package com.larus.bot.impl.feature.discover;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bot.impl.feature.discover.BotDiscoverListFragment", f = "BotDiscoverListFragment.kt", i = {0, 1, 1, 2}, l = {574, 576, 578}, m = "checkAndCreateConversation", n = {"data", "data", "conversationId", "conversationId"}, s = {"L$0", "L$0", "L$1", "L$0"})
final class BotDiscoverListFragment$checkAndCreateConversation$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ BotDiscoverListFragment this$0;

    public BotDiscoverListFragment$checkAndCreateConversation$1(BotDiscoverListFragment r1, Continuation<? super BotDiscoverListFragment$checkAndCreateConversation$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return BotDiscoverListFragment.S90(this.this$0, null, this);
    }
}
