package com.bytedance.lark.lark_biz_feed_android_wrapper;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.lark.lark_biz_feed_android_wrapper.LarkFeedListViewFlowWrapper", f = "LarkFeedListViewFlowWrapper.kt", i = {}, l = {164}, m = "action-vFDjHp0", n = {}, s = {})
public final class LarkFeedListViewFlowWrapper$action$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ LarkFeedListViewFlowWrapper this$0;

    public LarkFeedListViewFlowWrapper$action$1(LarkFeedListViewFlowWrapper r1, Continuation<? super LarkFeedListViewFlowWrapper$action$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        Object r3 = this.this$0.mo1707actionvFDjHp0(null, this);
        if (r3 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r3;
    L6:
        return new com.bytedance.lark.view_flow_wrapper.d(r3);
    }
}
