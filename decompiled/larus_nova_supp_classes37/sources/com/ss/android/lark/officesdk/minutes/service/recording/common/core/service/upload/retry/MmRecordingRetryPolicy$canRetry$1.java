package com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.upload.retry;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.upload.retry.MmRecordingRetryPolicy", f = "MmRecordingRetryPolicy.kt", i = {0, 1, 2, 3}, l = {20, ItemViewType.ITEM_VIEW_TYPE_RECOMMEND_HISTORY_HEADER, ItemViewType.ITEM_VIEW_TYPE_EMAIL_CONTACT, ItemViewType.ITEM_VIEW_TYPE_BOTTOM_WEAK_NET}, m = "canRetry", n = {"retryCount", "retryCount", "retryCount", "retryCount"}, s = {"J$0", "J$0", "J$0", "J$0"})
public final class MmRecordingRetryPolicy$canRetry$1 extends ContinuationImpl {
    long J$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MmRecordingRetryPolicy this$0;

    public MmRecordingRetryPolicy$canRetry$1(MmRecordingRetryPolicy r1, Continuation<? super MmRecordingRetryPolicy$canRetry$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r4) {
        this.result = r4;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(null, 0, this);
    }
}
