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
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.statessync.MmRecordingCreateService", f = "MmRecordingCreateService.kt", i = {0, 0, 0, 0}, l = {293}, m = "createMinutesTokenOnce-eH_QyT8", n = {"doubaoBizInfo", "source", "recordingId", "useRecordingApi"}, s = {"L$0", "L$1", "L$2", "Z$0"})
final class MmRecordingCreateService$createMinutesTokenOnce$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MmRecordingCreateService this$0;

    public MmRecordingCreateService$createMinutesTokenOnce$1(MmRecordingCreateService r1, Continuation<? super MmRecordingCreateService$createMinutesTokenOnce$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r10) {
        this.result = r10;
        this.label |= Integer.MIN_VALUE;
        Object r11 = MmRecordingCreateService.a(this.this$0, null, null, null, null, null, null, false, this);
        if (r11 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r11;
    L6:
        return Result.box-impl(r11);
    }
}
