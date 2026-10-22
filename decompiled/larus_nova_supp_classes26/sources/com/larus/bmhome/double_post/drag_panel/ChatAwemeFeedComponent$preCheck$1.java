package com.larus.bmhome.double_post.drag_panel;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.double_post.drag_panel.ChatAwemeFeedComponent", f = "ChatAwemeFeedComponent.kt", i = {}, l = {716}, m = "preCheck", n = {}, s = {})
final class ChatAwemeFeedComponent$preCheck$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ChatAwemeFeedComponent this$0;

    public ChatAwemeFeedComponent$preCheck$1(ChatAwemeFeedComponent r1, Continuation<? super ChatAwemeFeedComponent$preCheck$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return ChatAwemeFeedComponent.Y2(this.this$0, this);
    }
}
