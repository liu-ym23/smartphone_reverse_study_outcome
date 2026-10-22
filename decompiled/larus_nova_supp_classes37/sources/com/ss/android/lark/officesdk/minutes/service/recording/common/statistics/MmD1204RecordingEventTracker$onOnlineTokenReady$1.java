package com.ss.android.lark.officesdk.minutes.service.recording.common.statistics;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.MmD1204RecordingEventTracker", f = "MmD1204RecordingEventTracker.kt", i = {0, 0, 0, 0, 0}, l = {417}, m = "onOnlineTokenReady", n = {"hardwareUniqueId", "sessionId", "meetingId", "objectToken", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4"})
public final class MmD1204RecordingEventTracker$onOnlineTokenReady$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MmD1204RecordingEventTracker this$0;

    public MmD1204RecordingEventTracker$onOnlineTokenReady$1(MmD1204RecordingEventTracker r1, Continuation<? super MmD1204RecordingEventTracker$onOnlineTokenReady$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r7) {
        this.result = r7;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.d(null, null, null, null, this);
    }
}
