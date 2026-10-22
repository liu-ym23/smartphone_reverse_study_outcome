package com.ss.android.lark.officesdk.minutes.service.fileupload;

import com.ss.android.lark.picker.base.view.ItemViewType;
import java.util.Set;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.fileupload.MmMinutesFileUploadSessionManager", f = "MmMinutesFileUploadSessionManager.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1}, l = {2297, 1599}, m = "tryRestartPipelineFromInit", n = {"taskId", "reason", "deferred", "uploadTaskIdsToCancel", "$this$withLock_u24default$iv", "enqueueWhenNoDeferred", "taskId", "reason", "deferred", "enqueueWhenNoDeferred"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "Z$0", "L$0", "L$1", "L$2", "Z$0"})
final class MmMinutesFileUploadSessionManager$tryRestartPipelineFromInit$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MmMinutesFileUploadSessionManager this$0;

    public MmMinutesFileUploadSessionManager$tryRestartPipelineFromInit$1(MmMinutesFileUploadSessionManager r1, Continuation<? super MmMinutesFileUploadSessionManager$tryRestartPipelineFromInit$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        MmMinutesFileUploadSessionManager r3 = this.this$0;
        Set<String> r0 = MmMinutesFileUploadSessionManager.u;
        return r3.K(null, null, this);
    }
}
