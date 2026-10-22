package com.ss.android.lark.officesdk.minutes.service.recording.common.core;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.core.MmRecordingSessionManager", f = "MmRecordingSessionManager.kt", i = {}, l = {1408, 1425, 1433}, m = "shouldResumeHistoryRecording", n = {}, s = {})
public final class MmRecordingSessionManager$shouldResumeHistoryRecording$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MmRecordingSessionManager this$0;

    public MmRecordingSessionManager$shouldResumeHistoryRecording$1(MmRecordingSessionManager r1, Continuation<? super MmRecordingSessionManager$shouldResumeHistoryRecording$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        MmRecordingSessionManager r3 = this.this$0;
        int r0 = MmRecordingSessionManager.I;
        return r3.u(null, null, null, this);
    }
}
