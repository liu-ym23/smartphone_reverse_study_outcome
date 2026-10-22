package com.ss.android.lark.officesdk.minutes.service.recording.common.core.sessionstatehandler;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.core.sessionstatehandler.MmSoftwareHistoryRecordingStateHandler$Companion", f = "MmSoftwareHistoryRecordingStateHandler.kt", i = {0}, l = {57}, m = "awaitRecordingIdForHistoryUpload", n = {"onFailure"}, s = {"L$0"})
public final class MmSoftwareHistoryRecordingStateHandler$Companion$awaitRecordingIdForHistoryUpload$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MmSoftwareHistoryRecordingStateHandler.Companion this$0;

    public MmSoftwareHistoryRecordingStateHandler$Companion$awaitRecordingIdForHistoryUpload$1(MmSoftwareHistoryRecordingStateHandler.Companion r1, Continuation<? super MmSoftwareHistoryRecordingStateHandler$Companion$awaitRecordingIdForHistoryUpload$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(null, null, this);
    }
}
