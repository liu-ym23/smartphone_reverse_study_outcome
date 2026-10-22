package com.ss.android.lark.officesdk.minutes.service.recording.common.core.sessionstatehandler;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.core.sessionstatehandler.MmSoftwareCurrentRecordingStateHandler$Companion", f = "MmSoftwareCurrentRecordingStateHandler.kt", i = {0}, l = {616}, m = "awaitRecordingIdForUpload", n = {"onFailure"}, s = {"L$0"})
public final class MmSoftwareCurrentRecordingStateHandler$Companion$awaitRecordingIdForUpload$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MmSoftwareCurrentRecordingStateHandler.Companion this$0;

    public MmSoftwareCurrentRecordingStateHandler$Companion$awaitRecordingIdForUpload$1(MmSoftwareCurrentRecordingStateHandler.Companion r1, Continuation<? super MmSoftwareCurrentRecordingStateHandler$Companion$awaitRecordingIdForUpload$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(null, null, this);
    }
}
