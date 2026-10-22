package com.larus.bmhome.bot;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.im.bean.bot.BotModel;
import java.math.BigDecimal;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.bot.CommonSettingFragment$setupBotEdit$1$1", f = "CommonSettingFragment.kt", i = {}, l = {4471}, m = "invokeSuspend", n = {}, s = {})
final class CommonSettingFragment$setupBotEdit$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ CommonSettingFragment this$0;

    public CommonSettingFragment$setupBotEdit$1$1(CommonSettingFragment r1, Continuation<? super CommonSettingFragment$setupBotEdit$1$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new CommonSettingFragment$setupBotEdit$1$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r74) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L8;
        if (r2 != 1) goto L7;
        ResultKt.throwOnFailure(r74);
        Object r3 = r74;
    L14:
        BotModel r4 = (BotModel) r3;
        if (r4 == null) goto L21;
        CommonSettingFragment r5 = this.this$0;
        BotModel r6 = r5.s;
        if (r6 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("botInfo");
        BotModel r7 = null;
    L20:
        r5.s = BotModel.copy$default(r7, null, null, null, 0, null, null, null, null, null, null, null, null, null, r4.getBotStatus(), null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, r4.getBotMode(), null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -8193, 2147483646, null);
        goto L21
    L19:
        r7 = r6;
    L21:
        CommonSettingFragment r8 = this.this$0;
        BigDecimal r9 = CommonSettingFragment.k1;
        r8.Ja0().updateBotEditSubTitle();
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r74);
        CommonSettingFragment r10 = this.this$0;
        String r11 = r10.n;
        if (r11 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("conversationId");
        r11 = null;
    L11:
        this.label = 1;
        r3 = CommonSettingFragment.Ga0(r10, r11, false, this, 14);
        if (r3 != r1) goto L14;
        return r1;
    }
}
