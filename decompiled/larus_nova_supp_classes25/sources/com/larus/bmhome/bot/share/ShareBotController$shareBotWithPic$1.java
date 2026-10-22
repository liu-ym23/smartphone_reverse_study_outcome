package com.larus.bmhome.bot.share;

import com.larus.avlink.model.DoraCallStateCode;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.bot.share.ShareBotController", f = "ShareBotController.kt", i = {1, 1, 1}, l = {120, 122, 123, DoraCallStateCode.DOUBAO_NETWORK_ERROR_INVALID}, m = "shareBotWithPic", n = {"shareItemConfig", "conversation", "botModel"}, s = {"L$0", "L$1", "L$2"})
final class ShareBotController$shareBotWithPic$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ShareBotController this$0;

    public ShareBotController$shareBotWithPic$1(ShareBotController r1, Continuation<? super ShareBotController$shareBotWithPic$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r7) {
        this.result = r7;
        this.label |= Integer.MIN_VALUE;
        return ShareBotController.a(this.this$0, null, null, null, null, this);
    }
}
