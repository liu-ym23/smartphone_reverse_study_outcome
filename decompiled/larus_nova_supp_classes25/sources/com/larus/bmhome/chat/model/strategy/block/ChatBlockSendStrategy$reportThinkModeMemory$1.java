package com.larus.bmhome.chat.model.strategy.block;

import com.larus.bmhome.actionbar.model.ReplyOption;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.thinkmode.BehaviorSource;
import com.larus.bmhome.chat.thinkmode.ConversationSource;
import com.larus.bmhome.chat.thinkmode.IThinkModeMemoryReportService;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.model.strategy.block.ChatBlockSendStrategy$reportThinkModeMemory$1", f = "ChatBlockSendStrategy.kt", i = {}, l = {211}, m = "invokeSuspend", n = {}, s = {})
public final class ChatBlockSendStrategy$reportThinkModeMemory$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $agentMode;
    final /* synthetic */ ConversationSource $conversationSource;
    final /* synthetic */ ReplyOption $replyOption;
    int label;

    public ChatBlockSendStrategy$reportThinkModeMemory$1(ReplyOption r1, ConversationSource r2, int r3, Continuation<? super ChatBlockSendStrategy$reportThinkModeMemory$1> r4) {
        this.$replyOption = r1;
        this.$conversationSource = r2;
        this.$agentMode = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new ChatBlockSendStrategy$reportThinkModeMemory$1(this.$replyOption, this.$conversationSource, this.$agentMode, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r8);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r8);
        IThinkModeMemoryReportService.Companion r2 = IThinkModeMemoryReportService.a;
        ReplyOption r9 = this.$replyOption;
        BehaviorSource r3 = BehaviorSource.CHAT;
        ConversationSource r4 = this.$conversationSource;
        Integer r5 = Boxing.boxInt(this.$agentMode);
        this.label = 1;
        if (r2.a(r9, r3, r4, r5, this) != r0) goto L12;
        return r0;
    }
}
