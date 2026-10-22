package com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.adudio;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.adudio.MmRecordingAudioProcessor", f = "MmRecordingAudioProcessor.kt", i = {0, 0, 1, 1}, l = {155, 156, 161}, m = "processPcmDataChunk", n = {"pcmData", "isEnd", "pcmData", "isEnd"}, s = {"L$0", "Z$0", "L$0", "Z$0"})
public final class MmRecordingAudioProcessor$processPcmDataChunk$1 extends ContinuationImpl {
    Object L$0;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MmRecordingAudioProcessor this$0;

    public MmRecordingAudioProcessor$processPcmDataChunk$1(MmRecordingAudioProcessor r1, Continuation<? super MmRecordingAudioProcessor$processPcmDataChunk$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r3) {
        this.result = r3;
        this.label |= Integer.MIN_VALUE;
        MmRecordingAudioProcessor r4 = this.this$0;
        int r0 = MmRecordingAudioProcessor.q;
        return r4.f(null, false, this);
    }
}
