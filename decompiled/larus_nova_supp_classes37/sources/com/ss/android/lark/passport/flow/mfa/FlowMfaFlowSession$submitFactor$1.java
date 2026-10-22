package com.ss.android.lark.passport.flow.mfa;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.passport.flow.mfa.FlowMfaFlowSession", f = "FlowMfaFlowRegistry.kt", i = {0, 0, 1, 1, 2, 2}, l = {480, 490, 504}, m = "submitFactor", n = {"reportInfo", "startTime", "reportInfo", "startTime", "reportInfo", "startTime"}, s = {"L$0", "J$0", "L$0", "J$0", "L$0", "J$0"})
public final class FlowMfaFlowSession$submitFactor$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FlowMfaFlowSession this$0;

    public FlowMfaFlowSession$submitFactor$1(FlowMfaFlowSession r1, Continuation<? super FlowMfaFlowSession$submitFactor$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.B(null, null, this);
    }
}
