package com.larus.bmhome.bot;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import java.math.BigDecimal;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.bot.CommonSettingFragment", f = "CommonSettingFragment.kt", i = {0, 0}, l = {5407, 5406}, m = "findBotInfo", n = {"scene", "forceNew"}, s = {"L$0", "Z$0"})
final class CommonSettingFragment$findBotInfo$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CommonSettingFragment this$0;

    public CommonSettingFragment$findBotInfo$1(CommonSettingFragment r1, Continuation<? super CommonSettingFragment$findBotInfo$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r3) {
        this.result = r3;
        this.label |= Integer.MIN_VALUE;
        CommonSettingFragment r4 = this.this$0;
        BigDecimal r0 = CommonSettingFragment.k1;
        return r4.Fa0(null, false, null, this);
    }
}
