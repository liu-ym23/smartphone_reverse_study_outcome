package com.larus.search.impl.global.view.aggregate.kmp;

import com.larus.platform.model.SlashMentionConfig;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.search.impl.global.view.aggregate.kmp.KmpChatSearchActionHandlerServiceImpl", f = "KmpChatSearchActionHandlerServiceImpl.kt", i = {0, 0, 1, 2, 2}, l = {411, 413, 415, 423}, m = "checkAndCreateLocalConversation", n = {"bot", "botId", "bot", "bot", SlashMentionConfig.MENTION_CONTENT_CONVERSATION}, s = {"L$0", "L$1", "L$0", "L$0", "L$1"})
final class KmpChatSearchActionHandlerServiceImpl$checkAndCreateLocalConversation$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ KmpChatSearchActionHandlerServiceImpl this$0;

    public KmpChatSearchActionHandlerServiceImpl$checkAndCreateLocalConversation$1(KmpChatSearchActionHandlerServiceImpl r1, Continuation<? super KmpChatSearchActionHandlerServiceImpl$checkAndCreateLocalConversation$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return KmpChatSearchActionHandlerServiceImpl.k0(this.this$0, null, this);
    }
}
