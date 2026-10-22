package com.larus.bmhome.chat.model.repo;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.im.bean.message.Message;
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
@DebugMetadata(c = "com.larus.bmhome.chat.model.repo.ChatSender$failAudioTextNew$1", f = "ChatSender.kt", i = {}, l = {874, 875}, m = "invokeSuspend", n = {}, s = {})
public final class ChatSender$failAudioTextNew$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $cvsId;
    final /* synthetic */ long $duration;
    final /* synthetic */ Message $msg;
    final /* synthetic */ String $record;
    long J$0;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ ChatSender this$0;

    public ChatSender$failAudioTextNew$1(ChatSender r1, String r2, Message r3, String r4, long r5, Continuation<? super ChatSender$failAudioTextNew$1> r7) {
        this.this$0 = r1;
        this.$cvsId = r2;
        this.$msg = r3;
        this.$record = r4;
        this.$duration = r5;
        super(2, r7);
    }

    public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
        return new ChatSender$failAudioTextNew$1(this.this$0, this.$cvsId, this.$msg, this.$record, this.$duration, r10);
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
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        long r2 = this.J$0;
        String r3 = (String) this.L$1;
        Message r4 = (Message) this.L$0;
        ResultKt.throwOnFailure(r8);
    L19:
        ((com.larus.bmhome.chat.model.strategy.g0) r8).a(r4, r3, r2);
    L21:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r8);
    L13:
        wc9.e r9 = (wc9.e) r8;
        if (r9 == null) goto L21;
        ChatSender r5 = this.this$0;
        r4 = this.$msg;
        String r6 = this.$record;
        long r7 = this.$duration;
        this.L$0 = r4;
        this.L$1 = r6;
        this.J$0 = r7;
        this.label = 2;
        int r10 = ChatSender.j;
        r8 = r5.C(r9, this);
        if (r8 != r0) goto L18;
        return r0;
    L18:
        r3 = r6;
        r2 = r7;
        goto L19
    L10:
        ResultKt.throwOnFailure(r8);
        ChatSender r11 = this.this$0;
        String r12 = this.$cvsId;
        this.label = 1;
        r8 = ChatSender.y(r11, r12, this);
        if (r8 != r0) goto L13;
        return r0;
    }
}
