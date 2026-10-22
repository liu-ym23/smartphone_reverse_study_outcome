package com.ss.android.lark.officesdk.minutes.service.recording.common.core;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.core.MmRecordingSessionManager", f = "MmRecordingSessionManager.kt", i = {0, 0, 0, 0, 1, 1, 1}, l = {1456, 1460}, m = "discardStandaloneAIInterpretationHistoryAudio", n = {"meetingId", "recordingId", "localStorage", "$this$forEach$iv", "meetingId", "recordingId", "localStorage"}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2"})
public final class MmRecordingSessionManager$discardStandaloneAIInterpretationHistoryAudio$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MmRecordingSessionManager this$0;

    public MmRecordingSessionManager$discardStandaloneAIInterpretationHistoryAudio$1(MmRecordingSessionManager r1, Continuation<? super MmRecordingSessionManager$discardStandaloneAIInterpretationHistoryAudio$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r7) {
        this.result = r7;
        this.label |= Integer.MIN_VALUE;
        MmRecordingSessionManager r0 = this.this$0;
        int r8 = MmRecordingSessionManager.I;
        return r0.k(null, null, null, null, this);
    }
}
