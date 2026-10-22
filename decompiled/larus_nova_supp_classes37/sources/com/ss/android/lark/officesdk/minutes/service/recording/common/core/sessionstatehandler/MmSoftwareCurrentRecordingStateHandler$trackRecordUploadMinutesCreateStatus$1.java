package com.ss.android.lark.officesdk.minutes.service.recording.common.core.sessionstatehandler;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.core.sessionstatehandler.MmSoftwareCurrentRecordingStateHandler", f = "MmSoftwareCurrentRecordingStateHandler.kt", i = {0}, l = {567}, m = "trackRecordUploadMinutesCreateStatus", n = {"fromSource"}, s = {"L$0"})
final class MmSoftwareCurrentRecordingStateHandler$trackRecordUploadMinutesCreateStatus$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MmSoftwareCurrentRecordingStateHandler this$0;

    public MmSoftwareCurrentRecordingStateHandler$trackRecordUploadMinutesCreateStatus$1(MmSoftwareCurrentRecordingStateHandler r1, Continuation<? super MmSoftwareCurrentRecordingStateHandler$trackRecordUploadMinutesCreateStatus$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return MmSoftwareCurrentRecordingStateHandler.e(this.this$0, this);
    }
}
