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
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.statessync.MmRecordingStatesSyncService", f = "MmRecordingStatesSyncService.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4}, l = {598, 601, 623, 636, 643}, m = "syncRecordingStatus-BWLJW6A", n = {"statusAction", "saveArtifactType", "source", "retryOnFailure", "useRecordingApi", "statusAction", "saveArtifactType", "source", "retryOnFailure", "useRecordingApi", "statusAction", "saveArtifactType", "source", "idForStatus", "durationMs", "retryOnFailure", "useRecordingApi", "statusAction", "saveArtifactType", "source", "idForStatus", "durationMs", "updateStatusRetryConfig", "retryOnFailure", "useRecordingApi", "retryCount", "statusAction", "saveArtifactType", "source", "idForStatus", "durationMs", "updateStatusRetryConfig", "retryOnFailure", "useRecordingApi", "retryCount"}, s = {"L$0", "L$1", "L$2", "Z$0", "Z$1", "L$0", "L$1", "L$2", "Z$0", "Z$1", "L$0", "L$1", "L$2", "L$3", "L$4", "Z$0", "Z$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "Z$0", "Z$1", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "Z$0", "Z$1", "I$0"})
public final class MmRecordingStatesSyncService$syncRecordingStatus$2 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    boolean Z$0;
    boolean Z$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MmRecordingStatesSyncService this$0;

    public MmRecordingStatesSyncService$syncRecordingStatus$2(MmRecordingStatesSyncService r1, Continuation<? super MmRecordingStatesSyncService$syncRecordingStatus$2> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r3) {
        this.result = r3;
        this.label |= Integer.MIN_VALUE;
        MmRecordingStatesSyncService r4 = this.this$0;
        MmRecordingStatesSyncService.Companion r0 = MmRecordingStatesSyncService.q;
        Object r5 = r4.G(null, null, false, this);
        if (r5 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r5;
    L6:
        return Result.box-impl(r5);
    }
}
