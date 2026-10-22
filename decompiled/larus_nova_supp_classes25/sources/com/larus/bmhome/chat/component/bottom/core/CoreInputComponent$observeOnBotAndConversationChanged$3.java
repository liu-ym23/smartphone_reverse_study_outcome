package com.larus.bmhome.chat.component.bottom.core;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.im.bean.bot.BotModel;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\n"}, d2 = {"<anonymous>", "", "type", "", "bot", "Lcom/larus/im/bean/bot/BotModel;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.component.bottom.core.CoreInputComponent$observeOnBotAndConversationChanged$3", f = "CoreInputComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class CoreInputComponent$observeOnBotAndConversationChanged$3 extends SuspendLambda implements Function3<Integer, BotModel, Continuation<? super Unit>, Object> {
    /* synthetic */ int I$0;
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ CoreInputComponent this$0;

    public CoreInputComponent$observeOnBotAndConversationChanged$3(CoreInputComponent r1, Continuation<? super CoreInputComponent$observeOnBotAndConversationChanged$3> r2) {
        this.this$0 = r1;
        super(3, r2);
    }

    public final Object invoke(int r3, BotModel r4, Continuation<? super Unit> r5) {
        CoreInputComponent$observeOnBotAndConversationChanged$3 r0 = new CoreInputComponent$observeOnBotAndConversationChanged$3(this.this$0, r5);
        r0.I$0 = r3;
        r0.L$0 = r4;
        return r0.invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2, Object r3) {
        return invoke(((Number) r1).intValue(), (BotModel) r2, (Continuation) r3);
    }

    public final Object invokeSuspend(Object r8) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L21;
        ResultKt.throwOnFailure(r8);
        int r9 = this.I$0;
        BotModel r0 = (BotModel) this.L$0;
        com.larus.bmhome.view.x2 r1 = this.this$0.y1;
        if (r1 != null) goto L7;
    L18:
        this.this$0.a4(null);
        this.this$0.k4().T0(this.this$0.F4().getBotModel());
        return Unit.INSTANCE;
    L7:
        if (r9 != 3) goto L9;
        boolean r10 = true;
    L11:
        if (r1.i == r10) goto L17;
        FLogger r3 = FLogger.a;
        String r4 = r1.c;
        StringBuilder r5 = new StringBuilder("setBreakVisible, isBreakSwitchOpen: ");
        r5.append(r1.i);
        r5.append(" -> ");
        r5.append(r10);
        r5.append(", botId=");
        if (r0 == null) goto L15;
        String r2 = r0.getBotId();
    L16:
        r5.append(r2);
        r3.d(r4, r5.toString());
        goto L17
    L15:
        r2 = null;
    L17:
        r1.i = r10;
        goto L18
    L9:
        r10 = false;
        goto L11
    L21:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
