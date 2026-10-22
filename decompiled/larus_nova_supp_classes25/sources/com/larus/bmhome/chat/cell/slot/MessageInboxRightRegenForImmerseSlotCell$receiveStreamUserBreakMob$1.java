package com.larus.bmhome.chat.cell.slot;

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
import va8.x$a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.cell.slot.MessageInboxRightRegenForImmerseSlotCell$receiveStreamUserBreakMob$1", f = "MessageInboxRightRegenForImmerseSlotCell.kt", i = {}, l = {196}, m = "invokeSuspend", n = {}, s = {})
final class MessageInboxRightRegenForImmerseSlotCell$receiveStreamUserBreakMob$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $duration;
    final /* synthetic */ Message $msg;
    int label;
    final /* synthetic */ MessageInboxRightRegenForImmerseSlotCell this$0;

    public MessageInboxRightRegenForImmerseSlotCell$receiveStreamUserBreakMob$1(MessageInboxRightRegenForImmerseSlotCell r1, Message r2, long r3, Continuation<? super MessageInboxRightRegenForImmerseSlotCell$receiveStreamUserBreakMob$1> r5) {
        this.this$0 = r1;
        this.$msg = r2;
        this.$duration = r3;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new MessageInboxRightRegenForImmerseSlotCell$receiveStreamUserBreakMob$1(this.this$0, this.$msg, this.$duration, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r12) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r12);
    L26:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r12);
        MessageInboxRightRegenForImmerseSlotCell r13 = this.this$0;
        int r2 = MessageInboxRightRegenForImmerseSlotCell.o;
        va8.x r3 = (va8.x) r13.j.getValue();
        if (r3 == null) goto L26;
        va8.a0 r14 = this.this$0.r();
        if (r14 == null) goto L13;
        wc9.e r15 = r14.h();
    L14:
        wc9.e r4 = r15;
        String r16 = this.$msg.getMessageId();
        if (r16 != null) goto L17;
        String r5 = "";
    L18:
        Message r6 = this.$msg;
        String r17 = r6.getSenderId();
        if (r17 != null) goto L21;
        String r7 = "";
    L22:
        long r8 = this.$duration;
        this.label = 1;
        if (x$a.a(r3, r4, r5, r6, r7, r8, this) != r0) goto L26;
        return r0;
    L21:
        r7 = r17;
        goto L22
    L17:
        r5 = r16;
        goto L18
    L13:
        r15 = null;
        goto L14
    }
}
