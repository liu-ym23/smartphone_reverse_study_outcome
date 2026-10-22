package com.bytedance.lark.lark_biz_feed_android_wrapper;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.lark.lark_biz_feed_android_wrapper.FeedBadgeServiceWrapper", f = "FeedBadgeServiceWrapper.kt", i = {}, l = {31}, m = "invoke-gIAlu-s", n = {}, s = {})
public final class FeedBadgeServiceWrapper$invoke$1<T> extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FeedBadgeServiceWrapper this$0;

    public FeedBadgeServiceWrapper$invoke$1(FeedBadgeServiceWrapper r1, Continuation<? super FeedBadgeServiceWrapper$invoke$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        Object r3 = this.this$0.lc(null, this);
        if (r3 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r3;
    L6:
        return Result.box-impl(r3);
    }
}
