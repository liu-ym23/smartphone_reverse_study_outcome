package com.ss.android.lark.compose.chatterselector.card;

import com.ss.android.lark.chameleon.pluginsystem.plugin.PluginList;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.compose.chatterselector.card.FlowCardMemberRepository", f = "FlowCardMemberRepository.kt", i = {0, 0}, l = {45}, m = "fetchSelectedChatters", n = {"selectedIds", "chatId"}, s = {"L$0", "L$1"})
public final class FlowCardMemberRepository$fetchSelectedChatters$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FlowCardMemberRepository this$0;

    public FlowCardMemberRepository$fetchSelectedChatters$1(FlowCardMemberRepository r1, Continuation<? super FlowCardMemberRepository$fetchSelectedChatters$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= PluginList.LEVEL_NOT_SET;
        return this.this$0.a(null, null, this);
    }
}
