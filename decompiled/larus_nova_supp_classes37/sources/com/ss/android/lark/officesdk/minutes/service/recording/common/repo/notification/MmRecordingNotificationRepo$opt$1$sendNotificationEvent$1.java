package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.notification;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.repo.notification.MmRecordingNotificationRepo$opt$1", f = "MmRecordingNotificationRepo.kt", i = {0}, l = {ItemViewType.ITEM_VIEW_TYPE_OPEN_SEARCH, ItemViewType.ITEM_VIEW_TYPE_JUMP_TAB_UNFOLD}, m = "sendNotificationEvent", n = {"event"}, s = {"L$0"})
public final class MmRecordingNotificationRepo$opt$1$sendNotificationEvent$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MmRecordingNotificationRepo$opt$1 this$0;

    public MmRecordingNotificationRepo$opt$1$sendNotificationEvent$1(MmRecordingNotificationRepo$opt$1 r1, Continuation<? super MmRecordingNotificationRepo$opt$1$sendNotificationEvent$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.T0(null, this);
    }
}
