package com.bytedance.lark.lark_biz_feed_android_wrapper;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.lark.lark_biz_feed_android_wrapper.LarkFeedListViewModel", f = "LarkFeedListViewFlowWrapper.kt", i = {}, l = {260}, m = "action-vFDjHp0$suspendImpl", n = {}, s = {})
public final class LarkFeedListViewModel$action$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ LarkFeedListViewModel this$0;

    public LarkFeedListViewModel$action$1(LarkFeedListViewModel r1, Continuation<? super LarkFeedListViewModel$action$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        Object r3 = LarkFeedListViewModel.m1709actionvFDjHp0$suspendImpl(this.this$0, null, this);
        if (r3 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r3;
    L6:
        return new com.bytedance.lark.view_flow_wrapper.d(r3);
    }
}
