package com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.upload;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.upload.MmRecordingHistoryUploadResumeTracker", f = "MmRecordingHistoryUploadResumeTracker.kt", i = {0, 0, 1, 1, 1}, l = {ItemViewType.ITEM_VIEW_TYPE_JUMP_TAB_UNFOLD, 32}, m = "track", n = {"meetingId", "currentCommonParam", "meetingId", "currentCommonParam", "segmentFiles"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2"})
public final class MmRecordingHistoryUploadResumeTracker$track$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MmRecordingHistoryUploadResumeTracker this$0;

    public MmRecordingHistoryUploadResumeTracker$track$1(MmRecordingHistoryUploadResumeTracker r1, Continuation<? super MmRecordingHistoryUploadResumeTracker$track$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.b(null, this);
    }
}
