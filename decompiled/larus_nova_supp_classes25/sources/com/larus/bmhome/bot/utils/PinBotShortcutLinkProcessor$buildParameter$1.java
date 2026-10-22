package com.larus.bmhome.bot.utils;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.bot.utils.PinBotShortcutLinkProcessor", f = "PinBotShortcutLinkProcessor.kt", i = {0, 0, 0, 1, 1, 1, 1}, l = {89, 95}, m = "buildParameter", n = {"uri", "botIdFromUrl", "currentPage", "uri", "currentPage", "cvsId", "openChat"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "Z$0"})
final class PinBotShortcutLinkProcessor$buildParameter$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PinBotShortcutLinkProcessor this$0;

    public PinBotShortcutLinkProcessor$buildParameter$1(PinBotShortcutLinkProcessor r1, Continuation<? super PinBotShortcutLinkProcessor$buildParameter$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return PinBotShortcutLinkProcessor.a(this.this$0, null, this);
    }
}
