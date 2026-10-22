package com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.adudio;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.adudio.MmRecordingAudioService", f = "MmRecordingAudioService.kt", i = {}, l = {322}, m = "initRtcInternal", n = {}, s = {})
public final class MmRecordingAudioService$initRtcInternal$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MmRecordingAudioService this$0;

    public MmRecordingAudioService$initRtcInternal$1(MmRecordingAudioService r1, Continuation<? super MmRecordingAudioService$initRtcInternal$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        MmRecordingAudioService r3 = this.this$0;
        int r0 = MmRecordingAudioService.G;
        return r3.g(null, null, this);
    }
}
