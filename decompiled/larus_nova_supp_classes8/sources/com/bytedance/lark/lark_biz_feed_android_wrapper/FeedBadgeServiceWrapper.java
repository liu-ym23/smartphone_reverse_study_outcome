package com.bytedance.lark.lark_biz_feed_android_wrapper;

import com.bytedance.lark.lark_biz_feed_android.i;
import com.bytedance.lark.view_flow_wrapper.MoltenService;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class FeedBadgeServiceWrapper extends MoltenService<i> implements b {
    public FeedBadgeServiceWrapper(Function1<? super Continuation<? super i>, ? extends Object> r2) {
        Intrinsics.checkNotNullParameter(r2, "serviceProvider");
        super(r2);
    }

    @Override // com.bytedance.lark.lark_biz_feed_android_wrapper.b
    public final <T> Object lc(Function1<? super i, ? extends T> r5, Continuation<? super Result<? extends T>> r6) {
        if ((r6 instanceof FeedBadgeServiceWrapper$invoke$1) == false) goto L7;
        FeedBadgeServiceWrapper$invoke$1 r0 = (FeedBadgeServiceWrapper$invoke$1) r6;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r7 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r7);
        return ((Result) r7).unbox-impl();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r7);
        FeedBadgeServiceWrapper$invoke$2 r8 = new FeedBadgeServiceWrapper$invoke$2(r5);
        r0.label = 1;
        Object r9 = c(r8, r0);
        if (r9 != r2) goto L18;
        return r2;
    L18:
        return r9;
    L7:
        r0 = new FeedBadgeServiceWrapper$invoke$1(this, r6);
        goto L8
    }
}
