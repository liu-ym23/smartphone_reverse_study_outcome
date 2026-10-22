package com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.adudio;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.adudio.MmRecordingAudioProcessor", f = "MmRecordingAudioProcessor.kt", i = {}, l = {166, 173, 183}, m = "encodeAndSaveCurrentSlice", n = {}, s = {})
public final class MmRecordingAudioProcessor$encodeAndSaveCurrentSlice$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MmRecordingAudioProcessor this$0;

    public MmRecordingAudioProcessor$encodeAndSaveCurrentSlice$1(MmRecordingAudioProcessor r1, Continuation<? super MmRecordingAudioProcessor$encodeAndSaveCurrentSlice$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        MmRecordingAudioProcessor r3 = this.this$0;
        int r0 = MmRecordingAudioProcessor.q;
        return r3.b(this);
    }
}
