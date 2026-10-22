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
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.ui.record.speaker.MmSpeakerMarkViewModel", f = "MmSpeakerMarkViewModel.kt", i = {}, l = {182}, m = "createSpeaker-gIAlu-s", n = {}, s = {})
public final class MmSpeakerMarkViewModel$createSpeaker$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MmSpeakerMarkViewModel this$0;

    public MmSpeakerMarkViewModel$createSpeaker$1(MmSpeakerMarkViewModel r1, Continuation<? super MmSpeakerMarkViewModel$createSpeaker$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        Object r3 = MmSpeakerMarkViewModel.m514access$createSpeakergIAlus(this.this$0, null, this);
        if (r3 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r3;
    L6:
        return Result.box-impl(r3);
    }
}
