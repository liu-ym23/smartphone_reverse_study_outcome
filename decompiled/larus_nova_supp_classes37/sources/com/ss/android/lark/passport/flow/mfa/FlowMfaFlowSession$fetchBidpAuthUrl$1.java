package com.ss.android.lark.passport.flow.mfa;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.passport.flow.mfa.FlowMfaFlowSession", f = "FlowMfaFlowRegistry.kt", i = {0, 0, 0, 1, 1}, l = {889, 896}, m = "fetchBidpAuthUrl", n = {"reportInfo", "terminalOnError", "startTime", "reportInfo", "startTime"}, s = {"L$0", "Z$0", "J$0", "L$0", "J$0"})
final class FlowMfaFlowSession$fetchBidpAuthUrl$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FlowMfaFlowSession this$0;

    public FlowMfaFlowSession$fetchBidpAuthUrl$1(FlowMfaFlowSession r1, Continuation<? super FlowMfaFlowSession$fetchBidpAuthUrl$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r3) {
        this.result = r3;
        this.label |= Integer.MIN_VALUE;
        return FlowMfaFlowSession.a(this.this$0, null, false, this);
    }
}
