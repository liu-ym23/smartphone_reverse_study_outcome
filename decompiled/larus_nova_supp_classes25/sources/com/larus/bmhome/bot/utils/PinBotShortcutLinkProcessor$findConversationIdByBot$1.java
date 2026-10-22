package com.larus.bmhome.bot.utils;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.bot.utils.PinBotShortcutLinkProcessor", f = "PinBotShortcutLinkProcessor.kt", i = {0}, l = {41, MessageCellStateTransformerType.DEVICE_OR_RUNTIME_CHANGED}, m = "findConversationIdByBot", n = {"botId"}, s = {"L$0"})
public final class PinBotShortcutLinkProcessor$findConversationIdByBot$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PinBotShortcutLinkProcessor this$0;

    public PinBotShortcutLinkProcessor$findConversationIdByBot$1(PinBotShortcutLinkProcessor r1, Continuation<? super PinBotShortcutLinkProcessor$findConversationIdByBot$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        PinBotShortcutLinkProcessor r3 = this.this$0;
        PinBotShortcutLinkProcessor r0 = PinBotShortcutLinkProcessor.a;
        return r3.c(null, this);
    }
}
