package com.larus.bmhome.chat.component.bottom.core;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.jvm.internal.PropertyReference1Impl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
final /* synthetic */ class CoreInputComponent$observeOnBotAndConversationChanged$2 extends PropertyReference1Impl {
    public static final CoreInputComponent$observeOnBotAndConversationChanged$2 INSTANCE = null;

    static {
        INSTANCE = new CoreInputComponent$observeOnBotAndConversationChanged$2();
    }

    public CoreInputComponent$observeOnBotAndConversationChanged$2() {
        super(CoreInputComponentState.class, "botModel", "getBotModel()Lcom/larus/im/bean/bot/BotModel;", 0);
    }

    public Object get(Object r1) {
        return ((CoreInputComponentState) r1).getBotModel();
    }
}
