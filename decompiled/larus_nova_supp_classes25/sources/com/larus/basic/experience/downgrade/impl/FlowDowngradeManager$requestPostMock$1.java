package com.larus.basic.experience.downgrade.impl;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.basic.experience.downgrade.impl.FlowDowngradeManager", f = "FlowDowngradeManager.kt", i = {0, 1}, l = {220, 223}, m = "requestPostMock", n = {"downgradeContext", "result"}, s = {"L$0", "L$0"})
public final class FlowDowngradeManager$requestPostMock$1<T> extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FlowDowngradeManager this$0;

    public FlowDowngradeManager$requestPostMock$1(FlowDowngradeManager r1, Continuation<? super FlowDowngradeManager$requestPostMock$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r14) {
        this.result = r14;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.j(null, null, null, null, null, null, false, null, null, null, null, this);
    }
}
