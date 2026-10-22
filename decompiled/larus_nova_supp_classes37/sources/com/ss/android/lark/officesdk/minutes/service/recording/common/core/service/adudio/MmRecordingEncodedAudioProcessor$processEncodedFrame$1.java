package com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.adudio;

import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.profile.v2.entity.BaseField;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.adudio.MmRecordingEncodedAudioProcessor", f = "MmRecordingEncodedAudioProcessor.kt", i = {0}, l = {BaseField.FIELD_TYPE_S_FRIEND_LINK, BaseField.FIELD_TYPE_MEMO_DESCRIPTION}, m = "processEncodedFrame", n = {"frame"}, s = {"L$0"})
final class MmRecordingEncodedAudioProcessor$processEncodedFrame$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MmRecordingEncodedAudioProcessor this$0;

    public MmRecordingEncodedAudioProcessor$processEncodedFrame$1(MmRecordingEncodedAudioProcessor r1, Continuation<? super MmRecordingEncodedAudioProcessor$processEncodedFrame$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return MmRecordingEncodedAudioProcessor.a(this.this$0, null, this);
    }
}
