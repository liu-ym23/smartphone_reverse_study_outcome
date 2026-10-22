package com.ss.android.lark.officesdk.minutes.service.recording.common.core.sessionstatehandler;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.core.sessionstatehandler.MmPreMeetingNativeRecordingStateHandler", f = "MmPreMeetingNativeRecordingStateHandler.kt", i = {0, 1, 1, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5}, l = {485, 494, 498, 506, 528, 537}, m = "submitD1204OfflineLocalUpload", n = {"audioService", "audioService", "sessionKey", "audioService", "sessionKey", "startTimeMs", "stopTimeMs", "durationMs", "sessionKey", "audioPath", "startTimeMs", "stopTimeMs", "durationMs", "sessionKey", "audioPath", "audioFile", "startTimeMs", "stopTimeMs", "durationMs", "sessionKey", "audioPath", "audioFile", "durationMs"}, s = {"L$0", "L$0", "L$1", "L$0", "L$1", "J$0", "J$1", "J$2", "L$0", "L$1", "J$0", "J$1", "J$2", "L$0", "L$1", "L$2", "J$0", "J$1", "J$2", "L$0", "L$1", "L$2", "J$0"})
public final class MmPreMeetingNativeRecordingStateHandler$submitD1204OfflineLocalUpload$1 extends ContinuationImpl {
    long J$0;
    long J$1;
    long J$2;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MmPreMeetingNativeRecordingStateHandler this$0;

    public MmPreMeetingNativeRecordingStateHandler$submitD1204OfflineLocalUpload$1(MmPreMeetingNativeRecordingStateHandler r1, Continuation<? super MmPreMeetingNativeRecordingStateHandler$submitD1204OfflineLocalUpload$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.p(null, this);
    }
}
