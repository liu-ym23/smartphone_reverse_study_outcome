package com.larus.bmhome;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.FlowLarkSocialServiceImpl", f = "FlowLarkSocialServiceImpl.kt", i = {}, l = {MessageCellStateTransformerType.POI_MAP}, m = "getHumanFeedDisplayItem", n = {}, s = {})
public final class FlowLarkSocialServiceImpl$getHumanFeedDisplayItem$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FlowLarkSocialServiceImpl this$0;

    public FlowLarkSocialServiceImpl$getHumanFeedDisplayItem$1(FlowLarkSocialServiceImpl r1, Continuation<? super FlowLarkSocialServiceImpl$getHumanFeedDisplayItem$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.b(null, this);
    }
}
