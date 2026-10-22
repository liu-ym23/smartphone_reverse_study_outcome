package com.larus.bmhome.chat.component.bottom.core;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.im.bean.bot.BotModel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
final /* synthetic */ class CoreInputComponent$observeOnBotChanged$1 extends FunctionReferenceImpl implements Function2<BotModel, BotModel, Boolean> {
    public CoreInputComponent$observeOnBotChanged$1(Object r8) {
        super(2, r8, CoreInputViewModel.class, "diffOnBotChanged", "diffOnBotChanged(Lcom/larus/im/bean/bot/BotModel;Lcom/larus/im/bean/bot/BotModel;)Z", 0);
    }

    public final Boolean invoke(BotModel r2, BotModel r3) {
        return Boolean.valueOf(((CoreInputViewModel) ((CallableReference) this).receiver).diffOnBotChanged(r2, r3));
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((BotModel) r1, (BotModel) r2);
    }
}
