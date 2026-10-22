package com.ss.android.lark.officesdk.minutes.service.foundation.network.core.error;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.foundation.network.core.error.MmCustomExceptionKt", f = "MmCustomException.kt", i = {0, 0, 0, 1, 1, 1, 1}, l = {ItemViewType.ITEM_VIEW_TYPE_DIVIDER_14DP, ItemViewType.ITEM_VIEW_TYPE_CALENDAR_INFO}, m = "withRetry", n = {"operation", "maxRetries", "retryCount", "operation", "lastError", "maxRetries", "retryCount"}, s = {"L$0", "I$0", "I$1", "L$0", "L$1", "I$0", "I$1"})
public final class MmCustomExceptionKt$withRetry$1<T> extends ContinuationImpl {
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;

    public MmCustomExceptionKt$withRetry$1(Continuation<? super MmCustomExceptionKt$withRetry$1> r1) {
        super(r1);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        Object r3 = MmCustomExceptionKt.a(0, null, this);
        if (r3 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r3;
    L6:
        return Result.box-impl(r3);
    }
}
