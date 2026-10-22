package com.larus.bmhome.chat.helper;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.helper.ChatRouterHelper", f = "ChatRouterHelper.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 3, 3, 3}, l = {425, 435, 440, 444}, m = "createLocalBotSubConv", n = {"botId", "conv", "msgList", "projectId", "customSuffix", "conv", "msgList", "projectId", "customSuffix", "botModel", "localBotModel", "msgList", "projectId", "customSuffix", "botModel", "localBotModel", "inputLeftActionStyle", "msgList", "botModel", "localBotModel"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2"})
public final class ChatRouterHelper$createLocalBotSubConv$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ChatRouterHelper this$0;

    public ChatRouterHelper$createLocalBotSubConv$1(ChatRouterHelper r1, Continuation<? super ChatRouterHelper$createLocalBotSubConv$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r8) {
        this.result = r8;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.d(null, null, null, null, null, this);
    }
}
