package com.larus.bmhome.bot;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.bot.ServiceBotSettingFragment", f = "ServiceBotSettingFragment.kt", i = {}, l = {272}, m = "findConversationInfo", n = {}, s = {})
final class ServiceBotSettingFragment$findConversationInfo$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ServiceBotSettingFragment this$0;

    public ServiceBotSettingFragment$findConversationInfo$1(ServiceBotSettingFragment r1, Continuation<? super ServiceBotSettingFragment$findConversationInfo$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return ServiceBotSettingFragment.U90(this.this$0, null, this);
    }
}
