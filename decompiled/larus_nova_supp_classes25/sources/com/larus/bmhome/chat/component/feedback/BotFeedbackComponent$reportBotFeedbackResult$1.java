package com.larus.bmhome.chat.component.feedback;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.im.bean.bot.BotModel;
import com.larus.network.http.HttpExtKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.component.feedback.BotFeedbackComponent$reportBotFeedbackResult$1", f = "BotFeedbackComponent.kt", i = {}, l = {249}, m = "invokeSuspend", n = {}, s = {})
final class BotFeedbackComponent$reportBotFeedbackResult$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $isLike;
    int label;
    final /* synthetic */ BotFeedbackComponent this$0;

    public BotFeedbackComponent$reportBotFeedbackResult$1(BotFeedbackComponent r1, boolean r2, Continuation<? super BotFeedbackComponent$reportBotFeedbackResult$1> r3) {
        this.this$0 = r1;
        this.$isLike = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new BotFeedbackComponent$reportBotFeedbackResult$1(this.this$0, this.$isLike, r4);
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
    L20:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r14);
        JSONObject r4 = new JSONObject();
        BotFeedbackComponent r5 = this.this$0;
        boolean r6 = this.$isLike;
        BotModel r7 = r5.o;
        if (r7 == null) goto L11;
        String r8 = r7.getBotId();
    L12:
        r4.put("bot_id", r8);
        if (r6 == false) goto L15;
        int r9 = 1;
    L16:
        r4.put("bot_favor", r9);
        Unit r10 = Unit.INSTANCE;
        this.label = 1;
        if (HttpExtKt.k("Social", Object.class, "/alice/bot/set_bot_favor", r4, null, null, true, null, null, null, this, 944) != r0) goto L20;
        return r0;
    L15:
        r9 = 2;
        goto L16
    L11:
        r8 = null;
        goto L12
    }
}
