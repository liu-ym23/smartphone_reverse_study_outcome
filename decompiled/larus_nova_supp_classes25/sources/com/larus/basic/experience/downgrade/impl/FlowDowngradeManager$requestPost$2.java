package com.larus.basic.experience.downgrade.impl;

import com.larus.avlink.model.DoraCallStateCode;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.basic.experience.downgrade.impl.FlowDowngradeManager", f = "FlowDowngradeManager.kt", i = {1}, l = {176, DoraCallStateCode.DOUBAO_STOP_RECORD_BY_IM}, m = "requestPost", n = {"result"}, s = {"L$0"})
public final class FlowDowngradeManager$requestPost$2<T, Req> extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FlowDowngradeManager this$0;

    public FlowDowngradeManager$requestPost$2(FlowDowngradeManager r1, Continuation<? super FlowDowngradeManager$requestPost$2> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r17) {
        this.result = r17;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.h(null, null, null, null, null, null, null, null, false, null, null, null, null, this);
    }
}
