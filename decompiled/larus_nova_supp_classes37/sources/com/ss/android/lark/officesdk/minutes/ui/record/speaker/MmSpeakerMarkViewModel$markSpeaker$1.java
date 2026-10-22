package com.ss.android.lark.officesdk.minutes.ui.record.speaker;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.ui.record.speaker.MmSpeakerMarkViewModel", f = "MmSpeakerMarkViewModel.kt", i = {}, l = {207}, m = "markSpeaker-yxL6bBk", n = {}, s = {})
public final class MmSpeakerMarkViewModel$markSpeaker$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MmSpeakerMarkViewModel this$0;

    public MmSpeakerMarkViewModel$markSpeaker$1(MmSpeakerMarkViewModel r1, Continuation<? super MmSpeakerMarkViewModel$markSpeaker$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r8) {
        this.result = r8;
        this.label |= Integer.MIN_VALUE;
        Object r9 = MmSpeakerMarkViewModel.m515access$markSpeakeryxL6bBk(this.this$0, null, null, null, 0, this);
        if (r9 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r9;
    L6:
        return Result.box-impl(r9);
    }
}
