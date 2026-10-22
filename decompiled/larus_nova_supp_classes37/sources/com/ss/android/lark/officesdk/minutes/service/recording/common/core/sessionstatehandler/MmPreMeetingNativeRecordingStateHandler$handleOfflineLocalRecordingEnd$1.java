package com.ss.android.lark.officesdk.minutes.service.recording.common.core.sessionstatehandler;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.core.sessionstatehandler.MmPreMeetingNativeRecordingStateHandler", f = "MmPreMeetingNativeRecordingStateHandler.kt", i = {}, l = {446, 451, 453}, m = "handleOfflineLocalRecordingEnd", n = {}, s = {})
final class MmPreMeetingNativeRecordingStateHandler$handleOfflineLocalRecordingEnd$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MmPreMeetingNativeRecordingStateHandler this$0;

    public MmPreMeetingNativeRecordingStateHandler$handleOfflineLocalRecordingEnd$1(MmPreMeetingNativeRecordingStateHandler r1, Continuation<? super MmPreMeetingNativeRecordingStateHandler$handleOfflineLocalRecordingEnd$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return MmPreMeetingNativeRecordingStateHandler.f(this.this$0, null, this);
    }
}
