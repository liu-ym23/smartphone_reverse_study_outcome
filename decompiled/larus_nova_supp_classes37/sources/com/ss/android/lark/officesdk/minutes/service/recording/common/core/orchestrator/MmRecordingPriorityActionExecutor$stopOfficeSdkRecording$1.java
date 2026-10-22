package com.ss.android.lark.officesdk.minutes.service.recording.common.core.orchestrator;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.core.orchestrator.MmRecordingPriorityActionExecutor", f = "MmRecordingPriorityActionExecutor.kt", i = {0, 0, 0}, l = {177}, m = "stopOfficeSdkRecording-gIAlu-s", n = {"targetScene", "sessionManager", "recordingId"}, s = {"L$0", "L$1", "L$2"})
public final class MmRecordingPriorityActionExecutor$stopOfficeSdkRecording$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MmRecordingPriorityActionExecutor this$0;

    public MmRecordingPriorityActionExecutor$stopOfficeSdkRecording$1(MmRecordingPriorityActionExecutor r1, Continuation<? super MmRecordingPriorityActionExecutor$stopOfficeSdkRecording$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        Object r3 = this.this$0.h(null, this);
        if (r3 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r3;
    L6:
        return Result.box-impl(r3);
    }
}
