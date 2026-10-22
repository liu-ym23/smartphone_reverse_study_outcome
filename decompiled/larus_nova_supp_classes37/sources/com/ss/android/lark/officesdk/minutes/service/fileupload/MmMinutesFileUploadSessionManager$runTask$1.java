package com.ss.android.lark.officesdk.minutes.service.fileupload;

import com.ss.android.lark.picker.base.view.ItemViewType;
import java.util.Set;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.fileupload.MmMinutesFileUploadSessionManager", f = "MmMinutesFileUploadSessionManager.kt", i = {0, 0, 0, 1, 1, 3, 3, 4, 4, 4, 10, 10, 10, 10, 10, 11, 11, 11, 11, 13, 13, ItemViewType.ITEM_VIEW_TYPE_QA_CARD, ItemViewType.ITEM_VIEW_TYPE_QA_CARD, ItemViewType.ITEM_VIEW_TYPE_QA_CARD, ItemViewType.ITEM_VIEW_TYPE_CUSTOMIZATION, ItemViewType.ITEM_VIEW_TYPE_CUSTOMIZATION, ItemViewType.ITEM_VIEW_TYPE_CUSTOMIZATION, ItemViewType.ITEM_VIEW_TYPE_CARD_HEADER, ItemViewType.ITEM_VIEW_TYPE_CARD_HEADER, ItemViewType.ITEM_VIEW_TYPE_CARD_HEADER, ItemViewType.ITEM_VIEW_TYPE_CARD_HEADER, ItemViewType.ITEM_VIEW_TYPE_CARD_FOOTER, ItemViewType.ITEM_VIEW_TYPE_CARD_FOOTER, ItemViewType.ITEM_VIEW_TYPE_CARD_FOOTER, ItemViewType.ITEM_VIEW_TYPE_CARD_FOOTER, ItemViewType.ITEM_VIEW_TYPE_DIVIDER_14DP, ItemViewType.ITEM_VIEW_TYPE_DIVIDER_14DP, ItemViewType.ITEM_VIEW_TYPE_DIVIDER_14DP, ItemViewType.ITEM_VIEW_TYPE_DIVIDER_14DP, ItemViewType.ITEM_VIEW_TYPE_DIVIDER_14DP, ItemViewType.ITEM_VIEW_TYPE_DIVIDER_14DP, ItemViewType.ITEM_VIEW_TYPE_DIVIDER_14DP, ItemViewType.ITEM_VIEW_TYPE_DIVIDER_14DP, ItemViewType.ITEM_VIEW_TYPE_RECOMMEND_ACTION_HEADER, ItemViewType.ITEM_VIEW_TYPE_RECOMMEND_ACTION_HEADER, ItemViewType.ITEM_VIEW_TYPE_RECOMMEND_ACTION_HEADER, ItemViewType.ITEM_VIEW_TYPE_RECOMMEND_ACTION_HEADER, ItemViewType.ITEM_VIEW_TYPE_RECOMMEND_HISTORY_HEADER}, l = {2297, 710, 720, 723, 729, 738, 749, 759, 769, 778, 2326, 786, 791, 831, 837, 849, 852, 869, 873, 875, 879, 883, 884, 903, 2354, 2364, 923, 926, 929}, m = "runTask", n = {"taskId", "snapshot", "$this$withLock_u24default$iv", "taskId", "snapshot", "taskId", "snapshot", "taskId", "snapshot", "totalSize", "taskId", "snapshot", "uploadToken", "$this$withLock_u24default$iv", "totalSize", "taskId", "snapshot", "uploadToken", "totalSize", "taskId", "snapshot", "taskId", "snapshot", "vhId", "taskId", "snapshot", "vhId", "taskId", "snapshot", "vhId", "uploader", "taskId", "snapshot", "vhId", "uploader", "taskId", "snapshot", "vhId", "uploader", "uploadStatus", "uploadTaskIds", "uploadTaskId", "$this$withLock_u24default$iv", "taskId", "uploadTaskIds", "deferred", "$this$withLock_u24default$iv", "taskId"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "J$0", "L$0", "L$1", "L$2", "L$3", "J$0", "L$0", "L$1", "L$2", "J$0", "L$0", "L$1", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$7", "L$8", "L$0", "L$1", "L$2", "L$3", "L$0"})
public final class MmMinutesFileUploadSessionManager$runTask$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    Object L$8;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MmMinutesFileUploadSessionManager this$0;

    public MmMinutesFileUploadSessionManager$runTask$1(MmMinutesFileUploadSessionManager r1, Continuation<? super MmMinutesFileUploadSessionManager$runTask$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        MmMinutesFileUploadSessionManager r3 = this.this$0;
        Set<String> r0 = MmMinutesFileUploadSessionManager.u;
        return r3.D(null, this);
    }
}
