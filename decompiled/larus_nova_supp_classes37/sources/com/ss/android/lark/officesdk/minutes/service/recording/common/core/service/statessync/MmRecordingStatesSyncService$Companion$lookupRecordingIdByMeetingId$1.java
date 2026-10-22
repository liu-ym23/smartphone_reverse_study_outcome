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
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.statessync.MmRecordingStatesSyncService$Companion", f = "MmRecordingStatesSyncService.kt", i = {0}, l = {63}, m = "lookupRecordingIdByMeetingId-yxL6bBk$officesdk_minutes_service_release", n = {"meetingId"}, s = {"L$0"})
public final class MmRecordingStatesSyncService$Companion$lookupRecordingIdByMeetingId$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MmRecordingStatesSyncService.Companion this$0;

    public MmRecordingStatesSyncService$Companion$lookupRecordingIdByMeetingId$1(MmRecordingStatesSyncService.Companion r1, Continuation<? super MmRecordingStatesSyncService$Companion$lookupRecordingIdByMeetingId$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r7) {
        this.result = r7;
        this.label |= Integer.MIN_VALUE;
        Object r8 = this.this$0.a(null, null, null, false, this);
        if (r8 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r8;
    L6:
        return Result.box-impl(r8);
    }
}
