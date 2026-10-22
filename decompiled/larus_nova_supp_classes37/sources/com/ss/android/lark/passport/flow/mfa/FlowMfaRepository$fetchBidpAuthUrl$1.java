package com.ss.android.lark.passport.flow.mfa;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.passport.flow.mfa.FlowMfaRepository", f = "FlowMfaRepository.kt", i = {}, l = {140}, m = "fetchBidpAuthUrl", n = {}, s = {})
public final class FlowMfaRepository$fetchBidpAuthUrl$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FlowMfaRepository this$0;

    public FlowMfaRepository$fetchBidpAuthUrl$1(FlowMfaRepository r1, Continuation<? super FlowMfaRepository$fetchBidpAuthUrl$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.g(null, null, null, this);
    }
}
