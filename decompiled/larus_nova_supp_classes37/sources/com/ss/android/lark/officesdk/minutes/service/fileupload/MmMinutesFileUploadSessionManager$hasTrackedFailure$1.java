package com.ss.android.lark.officesdk.minutes.service.fileupload;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.fileupload.MmMinutesFileUploadSessionManager", f = "MmMinutesFileUploadSessionManager.kt", i = {0, 0}, l = {2297}, m = "hasTrackedFailure", n = {"taskId", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1"})
final class MmMinutesFileUploadSessionManager$hasTrackedFailure$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MmMinutesFileUploadSessionManager this$0;

    public MmMinutesFileUploadSessionManager$hasTrackedFailure$1(MmMinutesFileUploadSessionManager r1, Continuation<? super MmMinutesFileUploadSessionManager$hasTrackedFailure$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return MmMinutesFileUploadSessionManager.c(this.this$0, null, this);
    }
}
