package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.ainote;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.repo.ainote.MmRecordingAINoteRepo", f = "MmRecordingAINoteRepo.kt", i = {0, 0}, l = {1043, 1048}, m = "updateSaveSwitchEntity", n = {"entity", "reason"}, s = {"L$0", "L$1"})
final class MmRecordingAINoteRepo$updateSaveSwitchEntity$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MmRecordingAINoteRepo this$0;

    public MmRecordingAINoteRepo$updateSaveSwitchEntity$1(MmRecordingAINoteRepo r1, Continuation<? super MmRecordingAINoteRepo$updateSaveSwitchEntity$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return MmRecordingAINoteRepo.l(this.this$0, null, null, this);
    }
}
