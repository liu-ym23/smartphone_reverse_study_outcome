package com.larus.bmhome.chat.list.cell.text.components.bottom.actionbar;

import androidx.collection.LruCache;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.platform.spi.IAIChatControlTraceService;
import java.util.Set;
import kotlin.Lazy;
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
@DebugMetadata(c = "com.larus.bmhome.chat.list.cell.text.components.bottom.actionbar.AnswerActionComponent$receiveStreamUserBreakMob$1", f = "AnswerActionComponent.kt", i = {}, l = {923}, m = "invokeSuspend", n = {}, s = {})
final class AnswerActionComponent$receiveStreamUserBreakMob$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $duration;
    final /* synthetic */ Message $msg;
    int label;
    final /* synthetic */ AnswerActionComponent this$0;

    public AnswerActionComponent$receiveStreamUserBreakMob$1(AnswerActionComponent r1, Message r2, long r3, Continuation<? super AnswerActionComponent$receiveStreamUserBreakMob$1> r5) {
        this.this$0 = r1;
        this.$msg = r2;
        this.$duration = r3;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new AnswerActionComponent$receiveStreamUserBreakMob$1(this.this$0, this.$msg, this.$duration, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r14) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r14);
    L32:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r14);
        LruCache r15 = ko8.a.a;
        AnswerActionComponent r16 = this.this$0;
        Lazy<Set<String>> r2 = AnswerActionComponent.G;
        com.larus.bmhome.chat.component.cvs.y r17 = r16.N();
        Integer r3 = null;
        if (r17 == null) goto L11;
        wc9.e r4 = r17.h();
    L12:
        String r18 = this.$msg.getMessageId();
        if (r18 != null) goto L15;
        String r5 = "";
    L16:
        Message r6 = this.$msg;
        String r19 = r6.getSenderId();
        if (r19 != null) goto L19;
        String r8 = "";
    L20:
        com.larus.bmhome.chat.component.cvs.y r110 = this.this$0.N();
        if (r110 == null) goto L25;
        BotModel r111 = r110.j0();
        if (r111 == null) goto L25;
        r3 = r111.getBotType();
    L25:
        long r10 = this.$duration;
        this.label = 1;
        Object r112 = IAIChatControlTraceService.a.Aa(r4, r5, r6, "stream_interrupt_clickstop", r8, r3, r10, this);
        if (r112 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L29;
        r112 = Unit.INSTANCE;
    L29:
        if (r112 != r0) goto L32;
        return r0;
    L19:
        r8 = r19;
        goto L20
    L15:
        r5 = r18;
        goto L16
    L11:
        r4 = null;
        goto L12
    }
}
