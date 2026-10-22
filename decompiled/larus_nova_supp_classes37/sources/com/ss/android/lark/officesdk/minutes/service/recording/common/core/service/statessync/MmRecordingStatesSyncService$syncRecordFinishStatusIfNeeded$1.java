package com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.statessync;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.statessync.MmRecordingStatesSyncService", f = "MmRecordingStatesSyncService.kt", i = {1, 1}, l = {677, 683}, m = "syncRecordFinishStatusIfNeeded-gIAlu-s", n = {"trigger", "deferred"}, s = {"L$0", "L$1"})
final class MmRecordingStatesSyncService$syncRecordFinishStatusIfNeeded$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MmRecordingStatesSyncService this$0;

    public MmRecordingStatesSyncService$syncRecordFinishStatusIfNeeded$1(MmRecordingStatesSyncService r1, Continuation<? super MmRecordingStatesSyncService$syncRecordFinishStatusIfNeeded$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        Object r3 = MmRecordingStatesSyncService.c(this.this$0, null, this);
        if (r3 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r3;
    L6:
        return Result.box-impl(r3);
    }
}
