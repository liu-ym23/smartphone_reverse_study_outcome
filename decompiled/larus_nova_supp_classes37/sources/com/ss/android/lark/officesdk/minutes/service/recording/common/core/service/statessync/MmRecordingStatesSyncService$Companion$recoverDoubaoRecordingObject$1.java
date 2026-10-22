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
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.statessync.MmRecordingStatesSyncService$Companion", f = "MmRecordingStatesSyncService.kt", i = {0, 0, 0, 0, 1}, l = {82, 88}, m = "recoverDoubaoRecordingObject-hUnOzRk$officesdk_minutes_service_release", n = {"coordinator", "meetingId", "onLookupMiss", "createRecordingObject", "lookupResult"}, s = {"L$0", "L$1", "L$2", "L$3", "L$0"})
public final class MmRecordingStatesSyncService$Companion$recoverDoubaoRecordingObject$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MmRecordingStatesSyncService.Companion this$0;

    public MmRecordingStatesSyncService$Companion$recoverDoubaoRecordingObject$1(MmRecordingStatesSyncService.Companion r1, Continuation<? super MmRecordingStatesSyncService$Companion$recoverDoubaoRecordingObject$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r8) {
        this.result = r8;
        this.label |= Integer.MIN_VALUE;
        Object r9 = this.this$0.b(null, null, null, null, null, this);
        if (r9 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r9;
    L6:
        return Result.box-impl(r9);
    }
}
