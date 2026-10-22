package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.ainote;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.repo.ainote.MmRecordingAINoteRepo", f = "MmRecordingAINoteRepo.kt", i = {0}, l = {1081, 1088}, m = "maybeShowSaveSwitchTooltip", n = {"reason"}, s = {"L$0"})
public final class MmRecordingAINoteRepo$maybeShowSaveSwitchTooltip$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MmRecordingAINoteRepo this$0;

    public MmRecordingAINoteRepo$maybeShowSaveSwitchTooltip$1(MmRecordingAINoteRepo r1, Continuation<? super MmRecordingAINoteRepo$maybeShowSaveSwitchTooltip$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        MmRecordingAINoteRepo r3 = this.this$0;
        int r0 = MmRecordingAINoteRepo.z;
        return r3.A(null, this);
    }
}
