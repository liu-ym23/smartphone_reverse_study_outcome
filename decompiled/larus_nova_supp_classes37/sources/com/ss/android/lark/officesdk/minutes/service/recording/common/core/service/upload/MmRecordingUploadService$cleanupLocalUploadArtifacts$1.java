package com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.upload;

import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.upload.MmRecordingUploadService", f = "MmRecordingUploadService.kt", i = {0, 1}, l = {369, 376, 377}, m = "cleanupLocalUploadArtifacts", n = {AppbrandHostConstants.Schema_RESERVED_FIELD.TOKEN, "meetingId"}, s = {"L$0", "L$0"})
final class MmRecordingUploadService$cleanupLocalUploadArtifacts$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MmRecordingUploadService this$0;

    public MmRecordingUploadService$cleanupLocalUploadArtifacts$1(MmRecordingUploadService r1, Continuation<? super MmRecordingUploadService$cleanupLocalUploadArtifacts$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return MmRecordingUploadService.a(this.this$0, null, this);
    }
}
