package com.ss.android.lark.officesdk.minutes.service.foundation.utils.net;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.foundation.utils.net.MmRecordingNetHelper", f = "MmRecordingNetHelper.kt", i = {}, l = {296}, m = "fetchSpeakerInfoList-yxL6bBk", n = {}, s = {})
public final class MmRecordingNetHelper$fetchSpeakerInfoList$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MmRecordingNetHelper this$0;

    public MmRecordingNetHelper$fetchSpeakerInfoList$1(MmRecordingNetHelper r1, Continuation<? super MmRecordingNetHelper$fetchSpeakerInfoList$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r7) {
        this.result = r7;
        this.label |= Integer.MIN_VALUE;
        Object r8 = this.this$0.n(null, null, null, null, this);
        if (r8 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r8;
    L6:
        return Result.box-impl(r8);
    }
}
