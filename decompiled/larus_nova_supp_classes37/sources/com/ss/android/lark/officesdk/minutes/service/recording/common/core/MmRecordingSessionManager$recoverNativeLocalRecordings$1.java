package com.ss.android.lark.officesdk.minutes.service.recording.common.core;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.core.MmRecordingSessionManager", f = "MmRecordingSessionManager.kt", i = {0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 4, 4, 4, 4, 4}, l = {1501, 1514, 1565, 1578, 1584}, m = "recoverNativeLocalRecordings", n = {"userId", "localStorage", "userId", "localStorage", "audioPersistent", "sessionKey", "boundMeetingId", "userId", "localStorage", "audioPersistent", "sessionKey", "persistedPath", "audioFilePath", "userId", "localStorage", "audioPersistent", "sessionKey", "userId", "localStorage", "audioPersistent", "sessionKey", "audioFilePath"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$4", "L$5", "L$0", "L$1", "L$2", "L$4", "L$5", "L$6", "L$0", "L$1", "L$2", "L$4", "L$0", "L$1", "L$2", "L$4", "L$5"})
final class MmRecordingSessionManager$recoverNativeLocalRecordings$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MmRecordingSessionManager this$0;

    public MmRecordingSessionManager$recoverNativeLocalRecordings$1(MmRecordingSessionManager r1, Continuation<? super MmRecordingSessionManager$recoverNativeLocalRecordings$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return MmRecordingSessionManager.e(this.this$0, null, null, this);
    }
}
