package com.larus.bmhome.chat.component.title;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.im.bean.bot.BotModel;
import com.larus.platform.model.EditPos;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.component.title.ChatTitleComponent$addOnBotListener$4$1", f = "ChatTitleComponent.kt", i = {}, l = {1063}, m = "invokeSuspend", n = {}, s = {})
final class ChatTitleComponent$addOnBotListener$4$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ BotModel $bot;
    final /* synthetic */ boolean $it;
    int label;
    final /* synthetic */ ChatTitleComponent this$0;

    public ChatTitleComponent$addOnBotListener$4$1(ChatTitleComponent r1, BotModel r2, boolean r3, Continuation<? super ChatTitleComponent$addOnBotListener$4$1> r4) {
        this.this$0 = r1;
        this.$bot = r2;
        this.$it = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new ChatTitleComponent$addOnBotListener$4$1(this.this$0, this.$bot, this.$it, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r5);
    L11:
        ChatTitleComponent r2 = this.this$0;
        boolean r3 = this.$it;
        int r4 = ChatTitleComponent.P1;
        boolean r6 = r2.p3(r3);
        r2.h5(r6, (EditPos) r5);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        ChatTitleComponent r7 = this.this$0;
        BotModel r8 = this.$bot;
        this.label = 1;
        int r9 = ChatTitleComponent.P1;
        r7.getClass();
        r5 = BuildersKt.withContext(Dispatchers.getIO(), new ChatTitleComponent$getEditPosFromBotModel$2(r8, null), this);
        if (r5 != r0) goto L11;
        return r0;
    }
}
