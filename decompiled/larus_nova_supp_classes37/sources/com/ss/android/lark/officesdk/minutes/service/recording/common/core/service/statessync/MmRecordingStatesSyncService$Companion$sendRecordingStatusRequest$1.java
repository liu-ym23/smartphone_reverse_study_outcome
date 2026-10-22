package com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.statessync;

import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.profile.v2.entity.BaseField;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.statessync.MmRecordingStatesSyncService$Companion", f = "MmRecordingStatesSyncService.kt", i = {}, l = {BaseField.FIELD_TYPE_S_PHONE_NUMBER}, m = "sendRecordingStatusRequest-eH_QyT8$officesdk_minutes_service_release", n = {}, s = {})
public final class MmRecordingStatesSyncService$Companion$sendRecordingStatusRequest$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MmRecordingStatesSyncService.Companion this$0;

    public MmRecordingStatesSyncService$Companion$sendRecordingStatusRequest$1(MmRecordingStatesSyncService.Companion r1, Continuation<? super MmRecordingStatesSyncService$Companion$sendRecordingStatusRequest$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r10) {
        this.result = r10;
        this.label |= Integer.MIN_VALUE;
        Object r11 = this.this$0.c(null, null, null, null, null, null, false, this);
        if (r11 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r11;
    L6:
        return Result.box-impl(r11);
    }
}
