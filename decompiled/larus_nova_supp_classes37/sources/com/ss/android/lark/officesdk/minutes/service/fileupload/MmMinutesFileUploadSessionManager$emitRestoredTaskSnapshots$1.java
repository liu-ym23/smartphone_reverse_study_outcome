package com.ss.android.lark.officesdk.minutes.service.fileupload;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.fileupload.MmMinutesFileUploadSessionManager", f = "MmMinutesFileUploadSessionManager.kt", i = {0, 0, 0, 1}, l = {1173, 1180}, m = "emitRestoredTaskSnapshots", n = {"snapshots", "snapshot", "taskId", "snapshots"}, s = {"L$0", "L$2", "L$3", "L$0"})
final class MmMinutesFileUploadSessionManager$emitRestoredTaskSnapshots$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MmMinutesFileUploadSessionManager this$0;

    public MmMinutesFileUploadSessionManager$emitRestoredTaskSnapshots$1(MmMinutesFileUploadSessionManager r1, Continuation<? super MmMinutesFileUploadSessionManager$emitRestoredTaskSnapshots$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return MmMinutesFileUploadSessionManager.a(this.this$0, null, this);
    }
}
