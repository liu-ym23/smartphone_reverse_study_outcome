package com.larus.bmhome.chat.component.list;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.model.repo.x1;
import com.larus.bmhome.chat.model.repo.x1$b;
import com.larus.im.bean.message.Message;
import com.larus.tts.TtsScene;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.component.list.ChatListComponentViewModel$ChatMessageTtsPlayer$ttsPlay$1$startStreamFunc$1$1", f = "ChatListComponentViewModel.kt", i = {}, l = {1684}, m = "invokeSuspend", n = {}, s = {})
public final class ChatListComponentViewModel$ChatMessageTtsPlayer$ttsPlay$1$startStreamFunc$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ TtsScene $fromScene;
    final /* synthetic */ Message $msg;
    int label;
    final /* synthetic */ ChatListComponentViewModel this$0;

    public ChatListComponentViewModel$ChatMessageTtsPlayer$ttsPlay$1$startStreamFunc$1$1(ChatListComponentViewModel r1, Message r2, TtsScene r3, Continuation<? super ChatListComponentViewModel$ChatMessageTtsPlayer$ttsPlay$1$startStreamFunc$1$1> r4) {
        this.this$0 = r1;
        this.$msg = r2;
        this.$fromScene = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new ChatListComponentViewModel$ChatMessageTtsPlayer$ttsPlay$1$startStreamFunc$1$1(this.this$0, this.$msg, this.$fromScene, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r13) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r13);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r13);
        x1 r3 = this.this$0.getReader();
        Message r4 = this.$msg;
        TtsScene r9 = this.$fromScene;
        this.label = 1;
        if (x1$b.b(r3, r4, null, true, "commerce_credit_insufficient", null, r9, this, 50) != r0) goto L12;
        return r0;
    }
}
