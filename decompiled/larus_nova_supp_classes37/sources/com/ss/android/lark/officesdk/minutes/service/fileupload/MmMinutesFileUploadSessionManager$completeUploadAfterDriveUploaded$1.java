package com.ss.android.lark.officesdk.minutes.service.fileupload;

import com.ss.android.lark.picker.base.view.ItemViewType;
import java.util.Set;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.fileupload.MmMinutesFileUploadSessionManager", f = "MmMinutesFileUploadSessionManager.kt", i = {0, 0, 1, 2, 2, 3, 3, 3, 4, 4, 4, 7}, l = {2297, 977, 2307, 2332, 996, 1005, 1011, 1023, 1038, 1049, 1053}, m = "completeUploadAfterDriveUploaded", n = {"taskId", "$this$withLock_u24default$iv", "taskId", "taskId", "$this$withLock_u24default$iv", "taskId", "finishData", "$this$withLock_u24default$iv", "taskId", "finishData", "finishParam", "taskId"}, s = {"L$0", "L$1", "L$0", "L$0", "L$1", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$0"})
public final class MmMinutesFileUploadSessionManager$completeUploadAfterDriveUploaded$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MmMinutesFileUploadSessionManager this$0;

    public MmMinutesFileUploadSessionManager$completeUploadAfterDriveUploaded$1(MmMinutesFileUploadSessionManager r1, Continuation<? super MmMinutesFileUploadSessionManager$completeUploadAfterDriveUploaded$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        MmMinutesFileUploadSessionManager r3 = this.this$0;
        Set<String> r0 = MmMinutesFileUploadSessionManager.u;
        return r3.m(null, this);
    }
}
