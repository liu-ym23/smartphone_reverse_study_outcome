package com.larus.bmhome.chat.component.list;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.model.repo.x1;
import com.larus.bmhome.chat.model.repo.x1$b;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.tts.TtsScene;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.component.list.ChatListComponent$startTTS$1", f = "ChatListComponent.kt", i = {}, l = {5708}, m = "invokeSuspend", n = {}, s = {})
final class ChatListComponent$startTTS$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Message $msg;
    int label;
    final /* synthetic */ ChatListComponent this$0;

    public ChatListComponent$startTTS$1(ChatListComponent r1, Message r2, Continuation<? super ChatListComponent$startTTS$1> r3) {
        this.this$0 = r1;
        this.$msg = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new ChatListComponent$startTTS$1(this.this$0, this.$msg, r4);
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
    L22:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r13);
        ChatListComponent r14 = this.this$0;
        int r2 = ChatListComponent.W3;
        BotModel r15 = r14.j0();
        if (r15 != null) goto L11;
    L13:
        boolean r16 = false;
    L14:
        if (r16 == false) goto L22;
        f2a.c r17 = this.this$0.L1.b("[TTS][startTTS]");
        r17.c.b = CollectionsKt.listOf("TtsPlay");
        f2a.f r3 = f2a.f.i;
        String r4 = this.$msg.getMessageId();
        if (r4 != null) goto L18;
        r4 = "";
    L18:
        r17.d(MapsKt.mapOf(TuplesKt.to(r3, r4)));
        f2a.c.c(r17, null, 15);
        x1 r5 = this.this$0.U5().getReader();
        Message r6 = this.$msg;
        TtsScene r9 = TtsScene.Auto_OnBoarding;
        this.label = 1;
        if (x1$b.b(r5, r6, null, true, "auto_play", null, r9, this, 50) != r0) goto L22;
        return r0;
    L11:
        if (ve8.c.c(r15) != true) goto L13;
        r16 = true;
        goto L14
    }
}
