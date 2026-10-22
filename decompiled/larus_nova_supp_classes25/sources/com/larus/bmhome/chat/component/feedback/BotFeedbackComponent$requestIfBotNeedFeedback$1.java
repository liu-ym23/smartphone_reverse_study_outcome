package com.larus.bmhome.chat.component.feedback;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.im.bean.bot.BotModel;
import com.larus.network.http.HttpExtKt;
import com.larus.network.http.y;
import com.larus.utils.logger.FLogger;
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
@DebugMetadata(c = "com.larus.bmhome.chat.component.feedback.BotFeedbackComponent$requestIfBotNeedFeedback$1", f = "BotFeedbackComponent.kt", i = {0}, l = {228}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
final class BotFeedbackComponent$requestIfBotNeedFeedback$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ BotFeedbackComponent this$0;

    public BotFeedbackComponent$requestIfBotNeedFeedback$1(BotFeedbackComponent r1, Continuation<? super BotFeedbackComponent$requestIfBotNeedFeedback$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        BotFeedbackComponent$requestIfBotNeedFeedback$1 r0 = new BotFeedbackComponent$requestIfBotNeedFeedback$1(this.this$0, r4);
        r0.L$0 = r3;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r17) {
        Object r13 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r0 = this.label;
        if (r0 == 0) goto L8;
        if (r0 != 1) goto L7;
        CoroutineScope r1 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r17);
        CoroutineScope r15 = r1;
        Object r2 = r17;
    L15:
        y r3 = (com.larus.network.http.a) r2;
        if ((r3 instanceof y) == false) goto L29;
        BotFeedbackComponent r4 = this.this$0;
        y r5 = r3;
        BotFavorWindowResponse r6 = (BotFavorWindowResponse) ((com.larus.network.http.a) r5).b;
        if (r6 == null) goto L22;
        Boolean r7 = r6.getEnableWindow();
        if (r7 == null) goto L22;
        boolean r8 = r7.booleanValue();
    L23:
        r4.u = r8;
        BotFeedbackComponent r9 = this.this$0;
        BotFavorWindowResponse r10 = (BotFavorWindowResponse) ((com.larus.network.http.a) r5).b;
        if (r10 == null) goto L27;
        String r11 = r10.getWindowText();
        if (r11 == null) goto L27;
    L28:
        r9.v = r11;
        this.this$0.t = true;
    L27:
        r11 = "";
    L22:
        r8 = false;
    L29:
        FLogger.a.d("BotFeedbackComponent" + r15.hashCode(), "needShowFeedbackDialog = " + this.this$0.u + ", notifyContent = " + this.this$0.v);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r17);
        r15 = (CoroutineScope) this.L$0;
        JSONObject r12 = new JSONObject();
        BotModel r14 = this.this$0.o;
        if (r14 == null) goto L11;
        String r16 = r14.getBotId();
    L12:
        r12.put("bot_id", r16);
        Unit r18 = Unit.INSTANCE;
        this.L$0 = r15;
        this.label = 1;
        r2 = HttpExtKt.k("Social", BotFavorWindowResponse.class, "/alice/bot/get_bot_favor_window", r12, null, null, true, null, null, null, this, 944);
        if (r2 != r13) goto L15;
        return r13;
    L11:
        r16 = null;
        goto L12
    }
}
