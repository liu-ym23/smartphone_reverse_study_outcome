package com.ss.android.lark.flow.chat.message.block.replay;

import com.ss.android.lark.blueprint.g;
import com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.block.reply.h;
import com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.ReplyBlock;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class FlowReplyBlock extends ReplyBlock {
    public final Lazy i;

    public final h i() {
        return (h) this.i.getValue();
    }

    public FlowReplyBlock(g r2) {
        Intrinsics.checkNotNullParameter(r2, "ctx");
        super(r2);
        this.i = LazyKt.lazy(new FlowReplyBlock$replyBlockRender$2(this));
    }
}
