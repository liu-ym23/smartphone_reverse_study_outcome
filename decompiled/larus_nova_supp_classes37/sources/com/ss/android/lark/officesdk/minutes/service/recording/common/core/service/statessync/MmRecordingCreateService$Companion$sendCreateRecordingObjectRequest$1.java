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
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.statessync.MmRecordingCreateService$Companion", f = "MmRecordingCreateService.kt", i = {}, l = {54}, m = "sendCreateRecordingObjectRequest-LiYkppA$officesdk_minutes_service_release", n = {}, s = {})
public final class MmRecordingCreateService$Companion$sendCreateRecordingObjectRequest$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MmRecordingCreateService.Companion this$0;

    public MmRecordingCreateService$Companion$sendCreateRecordingObjectRequest$1(MmRecordingCreateService.Companion r1, Continuation<? super MmRecordingCreateService$Companion$sendCreateRecordingObjectRequest$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r12) {
        this.result = r12;
        this.label |= Integer.MIN_VALUE;
        Object r13 = this.this$0.a(null, null, null, 0, null, null, null, null, false, this);
        if (r13 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r13;
    L6:
        return Result.box-impl(r13);
    }
}
