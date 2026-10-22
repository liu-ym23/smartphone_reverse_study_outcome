package com.ss.android.lark.officesdk.minutes.service.foundation.network.mock;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.foundation.network.mock.MmMockAwareRequestService", f = "MmMockAwareRequestService.kt", i = {0, 0}, l = {ItemViewType.ITEM_VIEW_TYPE_QA_CARD, 20}, m = "sendHttpRequest-0E7RQCE", n = {"respType", "request"}, s = {"L$0", "L$1"})
public final class MmMockAwareRequestService$sendHttpRequest$1<R> extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MmMockAwareRequestService this$0;

    public MmMockAwareRequestService$sendHttpRequest$1(MmMockAwareRequestService r1, Continuation<? super MmMockAwareRequestService$sendHttpRequest$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        Object r3 = this.this$0.c(null, null, this);
        if (r3 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r3;
    L6:
        return Result.box-impl(r3);
    }
}
